package yuyu.common.biz.bznayose;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.configuration.ProductMode;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.bean.mq.BzMqTrksIraiYokenBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_JdTrksPalTrksZanKbn;
import yuyu.def.classification.C_KyknaiyouhaneiErrKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_TorikesiKekkaKbn;
import yuyu.def.db.entity.BT_YoukyuuNoKanri;
import yuyu.infrext.mq.MqApiCaller;
import yuyu.infrext.mq.MqApiCallerStubForSinkeiyaku;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * PALあて取消依頼（MQ）のメソッド {@link BzTrksIraiMq#exec(BzTrksIraiYokenBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzTrksIraiMqTest_exec2{

    @Inject
    private BizDomManager bizDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_PALあて取消依頼（MQ）";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzTrksIraiMqTest_exec2.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllYoukyuuNoKanri());
    }

    @BeforeClass
    @Transactional
    public static void testInit() {

        MqApiCallerStubForSinkeiyaku.caller = BzTrksIraiMqTest_exec2.class;

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllMqBatchSosiki());
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzTrksIraiMqTest_exec2.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(MqApiCaller.class).to(MqApiCallerStubForSinkeiyaku.class);
            }
        });
    }

    @AfterClass
    public static void testClear() {

        MqApiCallerStubForSinkeiyaku.caller = null;
        MqApiCallerStubForSinkeiyaku.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @AfterClass
    @Transactional
    public static void deleteData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllMqBatchSosiki());
    }

    @Test
    @TestOrder(10)
    public void testExec2_A1 () {

        MockObjectManager.initialize();

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN1;

        BzTrksIraiYokenBean bzTrksIraiYokenBean = new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);
        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);

        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exStringEquals(bzTrksIraiKekkaBean.getAcserrcd(), "4545", "ACS基盤エラーコード");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(),
            C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(),
            C_JdTrksPalTrksZanKbn.ARI, "自動取消用ＰＡＬ取消残区分");

        exStringEquals((String)MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 0), "PY11", "処理コード");
        exStringEquals((String)MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 2), "sscd001", "組織コード");
        exStringEquals((String)MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 3), "                    ", "オペレータID");
        String iwsTrksIraiYoken = (String)MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 1);

        BzMqTrksIraiYokenBean bzMqTrksIraiYokenBean =
            FixedlengthConvertUtil.stringToBeanForFixedlength(iwsTrksIraiYoken, BzMqTrksIraiYokenBean.class);

        exStringEquals(bzMqTrksIraiYokenBean.getIwsSyoricd(), "PY11", "（ＩＷＳ）処理コード");
        exStringEquals(bzMqTrksIraiYokenBean.getIwsKugirihugou(), ".", "（ＩＷＳ）区切符号");
        exStringEquals(bzMqTrksIraiYokenBean.getIwsYoukyuuno(), "3113", "（ＩＷＳ）要求通番");
        exStringEquals(bzMqTrksIraiYokenBean.getIwsHuho2kyknokbn(), "2", "（ＩＷＳ）普保Ⅱ契約番号区分");
        exStringEquals(bzMqTrksIraiYokenBean.getIwsHuho2kykno(), "10000000003", "（ＩＷＳ）普保Ⅱ契約番号");

        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri(bzTrksIraiYokenBean.getYoukyuuno());
        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "3113", "要求通番");
        assertNull("普保Ⅱ契約番号区分", youkyuuNoKanri.getHuho2kyknokbn());
        assertNull("普保Ⅱ契約番号", youkyuuNoKanri.getHuho2kykno());
        assertNull("（ＭＱ更新用）ＭＱ処理結果区分", youkyuuNoKanri.getMqkousinmqsyorikekkakbn());
        assertNull("（ＭＱ更新用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqkousinacserrcd());
        exClassificationEquals(youkyuuNoKanri.getMqtrksiraimqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "（ＭＱ取消依頼用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqtrksiraiacserrcd(), "4545", "（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード");
        assertNull("契約内容反映エラー区分", youkyuuNoKanri.getKyknaiyouhaneierrkbn());
        exClassificationEquals(youkyuuNoKanri.getTrkskekkakbn(), C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.ARI, "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec2", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(20)
    public void testExec2_A2 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN2;

        BzTrksIraiYokenBean bzTrksIraiYokenBean = new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);
        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);

        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exStringEquals(bzTrksIraiKekkaBean.getAcserrcd(), "0000", "ACS基盤エラーコード");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(),
            C_TorikesiKekkaKbn.ERR_ATOSYORIARI, "取消結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(),
            C_JdTrksPalTrksZanKbn.ARI, "自動取消用ＰＡＬ取消残区分");

        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri(bzTrksIraiYokenBean.getYoukyuuno());
        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "3113", "要求通番");

        assertNull("普保Ⅱ契約番号区分", youkyuuNoKanri.getHuho2kyknokbn());
        assertNull("普保Ⅱ契約番号", youkyuuNoKanri.getHuho2kykno());
        assertNull("（ＭＱ更新用）ＭＱ処理結果区分", youkyuuNoKanri.getMqkousinmqsyorikekkakbn());
        assertNull("（ＭＱ更新用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqkousinacserrcd());
        exClassificationEquals(youkyuuNoKanri.getMqtrksiraimqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "（ＭＱ取消依頼用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqtrksiraiacserrcd(), "0000", "（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード");
        assertNull("契約内容反映エラー区分", youkyuuNoKanri.getKyknaiyouhaneierrkbn());
        exClassificationEquals(youkyuuNoKanri.getTrkskekkakbn(), C_TorikesiKekkaKbn.ERR_ATOSYORIARI, "取消結果区分");
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.ARI, "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec2", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(30)
    public void testExec2_A3 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN3;

        BzTrksIraiYokenBean bzTrksIraiYokenBean = new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);
        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);

        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exStringEquals(bzTrksIraiKekkaBean.getAcserrcd(), "0000", "ACS基盤エラーコード");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(),
            C_TorikesiKekkaKbn.BLNK, "取消結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(),
            C_JdTrksPalTrksZanKbn.NONE, "自動取消用ＰＡＬ取消残区分");

        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri(bzTrksIraiYokenBean.getYoukyuuno());
        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "3113", "要求通番");

        assertNull("普保Ⅱ契約番号区分", youkyuuNoKanri.getHuho2kyknokbn());
        assertNull("普保Ⅱ契約番号", youkyuuNoKanri.getHuho2kykno());
        assertNull("（ＭＱ更新用）ＭＱ処理結果区分", youkyuuNoKanri.getMqkousinmqsyorikekkakbn());
        assertNull("（ＭＱ更新用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqkousinacserrcd());
        exClassificationEquals(youkyuuNoKanri.getMqtrksiraimqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "（ＭＱ取消依頼用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqtrksiraiacserrcd(), "0000", "（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード");
        assertNull("契約内容反映エラー区分", youkyuuNoKanri.getKyknaiyouhaneierrkbn());
        exClassificationEquals(youkyuuNoKanri.getTrkskekkakbn(), C_TorikesiKekkaKbn.BLNK, "取消結果区分");
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.NONE, "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec2", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(40)
    public void testExec2_A4 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN4;

        BzTrksIraiYokenBean bzTrksIraiYokenBean = new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);
        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);

        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exStringEquals(bzTrksIraiKekkaBean.getAcserrcd(), "0000", "ACS基盤エラーコード");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(),
            C_TorikesiKekkaKbn.ERR_YOUKYUUNONONE, "取消結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(),
            C_JdTrksPalTrksZanKbn.NONE, "自動取消用ＰＡＬ取消残区分");

        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri(bzTrksIraiYokenBean.getYoukyuuno());
        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "3113", "要求通番");

        assertNull("普保Ⅱ契約番号区分", youkyuuNoKanri.getHuho2kyknokbn());
        assertNull("普保Ⅱ契約番号", youkyuuNoKanri.getHuho2kykno());
        assertNull("（ＭＱ更新用）ＭＱ処理結果区分", youkyuuNoKanri.getMqkousinmqsyorikekkakbn());
        assertNull("（ＭＱ更新用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqkousinacserrcd());
        exClassificationEquals(youkyuuNoKanri.getMqtrksiraimqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "（ＭＱ取消依頼用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqtrksiraiacserrcd(), "0000", "（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード");
        assertNull("契約内容反映エラー区分", youkyuuNoKanri.getKyknaiyouhaneierrkbn());
        exClassificationEquals(youkyuuNoKanri.getTrkskekkakbn(), C_TorikesiKekkaKbn.ERR_YOUKYUUNONONE, "取消結果区分");
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.NONE, "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec2", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(50)
    public void testExec2_A5 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN5;

        BzTrksIraiYokenBean bzTrksIraiYokenBean = new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);
        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);

        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exStringEquals(bzTrksIraiKekkaBean.getAcserrcd(), "0000", "ACS基盤エラーコード");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(),
            C_TorikesiKekkaKbn.ERR_TORIKESIZUMI, "取消結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(),
            C_JdTrksPalTrksZanKbn.NONE, "自動取消用ＰＡＬ取消残区分");

        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri(bzTrksIraiYokenBean.getYoukyuuno());
        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "3113", "要求通番");

        assertNull("普保Ⅱ契約番号区分", youkyuuNoKanri.getHuho2kyknokbn());
        assertNull("普保Ⅱ契約番号", youkyuuNoKanri.getHuho2kykno());
        assertNull("（ＭＱ更新用）ＭＱ処理結果区分", youkyuuNoKanri.getMqkousinmqsyorikekkakbn());
        assertNull("（ＭＱ更新用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqkousinacserrcd());
        exClassificationEquals(youkyuuNoKanri.getMqtrksiraimqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "（ＭＱ取消依頼用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqtrksiraiacserrcd(), "0000", "（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード");
        assertNull("契約内容反映エラー区分", youkyuuNoKanri.getKyknaiyouhaneierrkbn());
        exClassificationEquals(youkyuuNoKanri.getTrkskekkakbn(), C_TorikesiKekkaKbn.ERR_TORIKESIZUMI, "取消結果区分");
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.NONE, "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec2", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(60)
    public void testExec2_A6 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN6;

        BzTrksIraiYokenBean bzTrksIraiYokenBean = new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIERROR);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);
        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);

        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exStringEquals(bzTrksIraiKekkaBean.getAcserrcd(), "0000", "ACS基盤エラーコード");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(),
            C_TorikesiKekkaKbn.HUMEI, "取消結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(),
            C_JdTrksPalTrksZanKbn.NONE, "自動取消用ＰＡＬ取消残区分");

        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri(bzTrksIraiYokenBean.getYoukyuuno());
        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "3113", "要求通番");

        assertNull("普保Ⅱ契約番号区分", youkyuuNoKanri.getHuho2kyknokbn());
        assertNull("普保Ⅱ契約番号", youkyuuNoKanri.getHuho2kykno());
        assertNull("（ＭＱ更新用）ＭＱ処理結果区分", youkyuuNoKanri.getMqkousinmqsyorikekkakbn());
        assertNull("（ＭＱ更新用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqkousinacserrcd());
        exClassificationEquals(youkyuuNoKanri.getMqtrksiraimqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "（ＭＱ取消依頼用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqtrksiraiacserrcd(), "0000", "（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード");
        assertNull("契約内容反映エラー区分", youkyuuNoKanri.getKyknaiyouhaneierrkbn());
        exClassificationEquals(youkyuuNoKanri.getTrkskekkakbn(), C_TorikesiKekkaKbn.HUMEI, "取消結果区分");
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.NONE, "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec2", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(70)
    public void testExec2_A7 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN7;

        BzTrksIraiYokenBean bzTrksIraiYokenBean = new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIERROR);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);
        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);

        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exStringEquals(bzTrksIraiKekkaBean.getAcserrcd(), "0000", "ACS基盤エラーコード");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(),
            C_TorikesiKekkaKbn.BLNK, "取消結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(),
            C_JdTrksPalTrksZanKbn.NONE, "自動取消用ＰＡＬ取消残区分");

        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri(bzTrksIraiYokenBean.getYoukyuuno());
        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "3113", "要求通番");

        assertNull("普保Ⅱ契約番号区分", youkyuuNoKanri.getHuho2kyknokbn());
        assertNull("普保Ⅱ契約番号", youkyuuNoKanri.getHuho2kykno());
        assertNull("（ＭＱ更新用）ＭＱ処理結果区分", youkyuuNoKanri.getMqkousinmqsyorikekkakbn());
        assertNull("（ＭＱ更新用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqkousinacserrcd());
        exClassificationEquals(youkyuuNoKanri.getMqtrksiraimqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "（ＭＱ取消依頼用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqtrksiraiacserrcd(), "0000", "（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード");
        assertNull("契約内容反映エラー区分", youkyuuNoKanri.getKyknaiyouhaneierrkbn());
        exClassificationEquals(youkyuuNoKanri.getTrkskekkakbn(), C_TorikesiKekkaKbn.BLNK, "取消結果区分");
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.NONE, "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec2", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }
}