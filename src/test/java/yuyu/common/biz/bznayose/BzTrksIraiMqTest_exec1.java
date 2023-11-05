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
import yuyu.common.base.BaseUserInfo;
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
public class BzTrksIraiMqTest_exec1{

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_PALあて取消依頼（MQ）";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzTrksIraiMqTest_exec1.class, fileName, sheetName);
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

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(MqApiCaller.class).to(MqApiCallerStubForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void testInit() {

        MqApiCallerStubForSinkeiyaku.caller = BzTrksIraiMqTest_exec1.class;

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllMqBatchSosiki());
    }

    @AfterClass
    public static void testClear() {

        MqApiCallerStubForSinkeiyaku.caller = null;
        MqApiCallerStubForSinkeiyaku.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testExec1_A1 () {

        BzTrksIraiYokenBean bzTrksIraiYokenBean = null;

        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);

        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        assertNull("ACS基盤エラーコード", bzTrksIraiKekkaBean.getAcserrcd());
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(),
            C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(),
            C_JdTrksPalTrksZanKbn.BLNK, "自動取消用PAL取消残区分");
    }

    @Test
    @TestOrder(20)
    public void testExec1_A2 () {

        BzTrksIraiYokenBean bzTrksIraiYokenBean =  new BzTrksIraiYokenBean();

        baseUserInfo.getUser().setUserId("JUnit");

        bzTrksIraiYokenBean.setYoukyuuno("180000000000000001");
        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.BLNK);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);
        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);

        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        assertNull("ACS基盤エラーコード", bzTrksIraiKekkaBean.getAcserrcd());
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(),
            C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(),
            C_JdTrksPalTrksZanKbn.ARI, "自動取消用PAL取消残区分");

        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri(bzTrksIraiYokenBean.getYoukyuuno());
        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "180000000000000001", "要求通番");
        assertNull("普保Ⅱ契約番号区分", youkyuuNoKanri.getHuho2kyknokbn());
        assertNull("普保Ⅱ契約番号", youkyuuNoKanri.getHuho2kykno());
        assertNull("（ＭＱ更新用）ＭＱ処理結果区分", youkyuuNoKanri.getMqkousinmqsyorikekkakbn());
        assertNull("（ＭＱ更新用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqkousinacserrcd());
        exClassificationEquals(youkyuuNoKanri.getMqtrksiraimqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "（ＭＱ取消依頼用）ＭＱ処理結果区分");
        assertNull("（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqtrksiraiacserrcd());
        assertNull("契約内容反映エラー区分", youkyuuNoKanri.getKyknaiyouhaneierrkbn());
        exClassificationEquals(youkyuuNoKanri.getTrkskekkakbn(), C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.ARI, "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec1", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(30)
    public void testExec1_A3 () {

        BzTrksIraiYokenBean bzTrksIraiYokenBean = new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU);

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);
        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);

        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        assertNull("ACS基盤エラーコード", bzTrksIraiKekkaBean.getAcserrcd());
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(),
            C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(),
            C_JdTrksPalTrksZanKbn.KANOUSEIARI, "自動取消用PAL取消残区分");

        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri(bzTrksIraiYokenBean.getYoukyuuno());
        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "3113", "要求通番");

        assertNull("普保Ⅱ契約番号区分", youkyuuNoKanri.getHuho2kyknokbn());
        assertNull("普保Ⅱ契約番号", youkyuuNoKanri.getHuho2kykno());
        assertNull("（ＭＱ更新用）ＭＱ処理結果区分", youkyuuNoKanri.getMqkousinmqsyorikekkakbn());
        assertNull("（ＭＱ更新用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqkousinacserrcd());
        exClassificationEquals(youkyuuNoKanri.getMqtrksiraimqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "（ＭＱ取消依頼用）ＭＱ処理結果区分");
        assertNull("（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqtrksiraiacserrcd());
        assertNull("契約内容反映エラー区分", youkyuuNoKanri.getKyknaiyouhaneierrkbn());
        exClassificationEquals(youkyuuNoKanri.getTrkskekkakbn(), C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.KANOUSEIARI, "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec1", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(40)
    public void testExec1_A4 () {

        BzTrksIraiYokenBean bzTrksIraiYokenBean = new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIERROR);

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);
        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);

        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        assertNull("ACS基盤エラーコード", bzTrksIraiKekkaBean.getAcserrcd());
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(),
            C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(),
            C_JdTrksPalTrksZanKbn.BLNK, "自動取消用PAL取消残区分");

        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri(bzTrksIraiYokenBean.getYoukyuuno());
        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "3113", "要求通番");

        assertNull("普保Ⅱ契約番号区分", youkyuuNoKanri.getHuho2kyknokbn());
        assertNull("普保Ⅱ契約番号", youkyuuNoKanri.getHuho2kykno());
        assertNull("（ＭＱ更新用）ＭＱ処理結果区分", youkyuuNoKanri.getMqkousinmqsyorikekkakbn());
        assertNull("（ＭＱ更新用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqkousinacserrcd());
        exClassificationEquals(youkyuuNoKanri.getMqtrksiraimqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "（ＭＱ取消依頼用）ＭＱ処理結果区分");
        assertNull("（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqtrksiraiacserrcd());
        assertNull("契約内容反映エラー区分", youkyuuNoKanri.getKyknaiyouhaneierrkbn());
        exClassificationEquals(youkyuuNoKanri.getTrkskekkakbn(), C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.BLNK, "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec1", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(50)
    public void testExec1_A5 () {

        MockObjectManager.initialize();

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN1;

        BzTrksIraiYokenBean bzTrksIraiYokenBean =
            new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);

        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exStringEquals(bzTrksIraiKekkaBean.getAcserrcd(), "4545", "ACS基盤エラーコード");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(),
            C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(),
            C_JdTrksPalTrksZanKbn.KANOUSEIARI, "自動取消用ＰＡＬ取消残区分");

        exStringEquals((String)MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 0), "PY11", "処理コード");
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
        exClassificationEquals(youkyuuNoKanri.getMqtrksiraimqsyorikekkakbn(),
            C_MQSyorikekkaKbn.ERROR, "（ＭＱ取消依頼用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqtrksiraiacserrcd(), "4545", "（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード");
        assertNull("契約内容反映エラー区分", youkyuuNoKanri.getKyknaiyouhaneierrkbn());
        exClassificationEquals(youkyuuNoKanri.getTrkskekkakbn(), C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(),
            C_JdTrksPalTrksZanKbn.KANOUSEIARI, "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec1", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(60)
    public void testExec1_A6 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN2;

        BzTrksIraiYokenBean bzTrksIraiYokenBean =
            new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIERROR);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);

        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exStringEquals(bzTrksIraiKekkaBean.getAcserrcd(), "4545", "ACS基盤エラーコード");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(),
            C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(),
            C_JdTrksPalTrksZanKbn.BLNK, "自動取消用ＰＡＬ取消残区分");

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
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.BLNK, "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec1", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(70)
    public void testExec1_A7 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN3;

        BzTrksIraiYokenBean bzTrksIraiYokenBean =
            new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);

        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exStringEquals(bzTrksIraiKekkaBean.getAcserrcd(), "0000", "ACS基盤エラーコード");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(),
            C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
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
        exClassificationEquals(youkyuuNoKanri.getTrkskekkakbn(), C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.ARI, "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec1", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(80)
    public void testExec1_A8 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN4;

        BzTrksIraiYokenBean bzTrksIraiYokenBean =
            new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIERROR);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);

        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exStringEquals(bzTrksIraiKekkaBean.getAcserrcd(), "0000", "ACS基盤エラーコード");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(),
            C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(),
            C_JdTrksPalTrksZanKbn.BLNK, "自動取消用ＰＡＬ取消残区分");

        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri(bzTrksIraiYokenBean.getYoukyuuno());
        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "3113", "要求通番");

        assertNull("普保Ⅱ契約番号区分", youkyuuNoKanri.getHuho2kyknokbn());
        assertNull("普保Ⅱ契約番号", youkyuuNoKanri.getHuho2kykno());
        assertNull("（ＭＱ更新用）ＭＱ処理結果区分", youkyuuNoKanri.getMqkousinmqsyorikekkakbn());
        assertNull("（ＭＱ更新用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqkousinacserrcd());
        exClassificationEquals(youkyuuNoKanri.getMqtrksiraimqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "（ＭＱ取消依頼用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqtrksiraiacserrcd(), "0000", "（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード");
        assertNull("契約内容反映エラー区分", youkyuuNoKanri.getKyknaiyouhaneierrkbn());
        exClassificationEquals(youkyuuNoKanri.getTrkskekkakbn(), C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.BLNK, "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec1", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(90)
    public void testExec1_A9 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN5;

        BzTrksIraiYokenBean bzTrksIraiYokenBean =
            new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);

        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exStringEquals(bzTrksIraiKekkaBean.getAcserrcd(), "0000", "ACS基盤エラーコード");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(),
            C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(),
            C_JdTrksPalTrksZanKbn.KANOUSEIARI, "自動取消用ＰＡＬ取消残区分");

        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri(bzTrksIraiYokenBean.getYoukyuuno());
        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "3113", "要求通番");

        assertNull("普保Ⅱ契約番号区分", youkyuuNoKanri.getHuho2kyknokbn());
        assertNull("普保Ⅱ契約番号", youkyuuNoKanri.getHuho2kykno());
        assertNull("（ＭＱ更新用）ＭＱ処理結果区分", youkyuuNoKanri.getMqkousinmqsyorikekkakbn());
        assertNull("（ＭＱ更新用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqkousinacserrcd());
        exClassificationEquals(youkyuuNoKanri.getMqtrksiraimqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "（ＭＱ取消依頼用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqtrksiraiacserrcd(), "0000", "（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード");
        assertNull("契約内容反映エラー区分", youkyuuNoKanri.getKyknaiyouhaneierrkbn());
        exClassificationEquals(youkyuuNoKanri.getTrkskekkakbn(), C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.KANOUSEIARI, "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec1", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(100)
    public void testExec1_A10 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN6;

        BzTrksIraiYokenBean bzTrksIraiYokenBean =
            new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.BLNK);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
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
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec1", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(110)
    public void testExec1_A11 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN7;

        BzTrksIraiYokenBean bzTrksIraiYokenBean = new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU);
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);

        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exStringEquals(bzTrksIraiKekkaBean.getAcserrcd(), "0000", "ACS基盤エラーコード");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(),
            C_TorikesiKekkaKbn.TORIKESIOK, "取消結果区分");
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
        exClassificationEquals(youkyuuNoKanri.getTrkskekkakbn(), C_TorikesiKekkaKbn.TORIKESIOK, "取消結果区分");
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.NONE, "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec1", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(120)
    public void testExec_B1 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = "error1";

        BzTrksIraiYokenBean bzTrksIraiYokenBean =
            new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean;

        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);
        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(), C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        assertNull("ACS基盤エラーコード", bzTrksIraiKekkaBean.getAcserrcd());
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.ARI, "自動取消用PAL取消残区分");

        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri(bzTrksIraiYokenBean.getYoukyuuno());
        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "3113", "要求通番");
        assertNull("普保Ⅱ契約番号区分", youkyuuNoKanri.getHuho2kyknokbn());
        assertNull("普保Ⅱ契約番号", youkyuuNoKanri.getHuho2kykno());
        assertNull("（ＭＱ更新用）ＭＱ処理結果区分", youkyuuNoKanri.getMqkousinmqsyorikekkakbn());
        assertNull("（ＭＱ更新用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqkousinacserrcd());
        exClassificationEquals(youkyuuNoKanri.getMqtrksiraimqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "（ＭＱ取消依頼用）ＭＱ処理結果区分");
        assertNull("（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqtrksiraiacserrcd());
        assertNull("契約内容反映エラー区分", youkyuuNoKanri.getKyknaiyouhaneierrkbn());
        exClassificationEquals(youkyuuNoKanri.getTrkskekkakbn(), C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.ARI, "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec1", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(130)
    public void testExec_B2 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = "error1";

        BzTrksIraiYokenBean bzTrksIraiYokenBean =
            new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean;

        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);
        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(), C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        assertNull("ACS基盤エラーコード", bzTrksIraiKekkaBean.getAcserrcd());
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.KANOUSEIARI, "自動取消用PAL取消残区分");
    }

    @Test
    @TestOrder(140)
    public void testExec_B3 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = "error1";

        BzTrksIraiYokenBean bzTrksIraiYokenBean =
            new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIERROR);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean;

        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);
        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(), C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        assertNull("ACS基盤エラーコード", bzTrksIraiKekkaBean.getAcserrcd());
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.BLNK, "自動取消用PAL取消残区分");
    }

    @Test
    @TestOrder(150)
    public void testExec_B4 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = "error2";

        BzTrksIraiYokenBean bzTrksIraiYokenBean =
            new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean;

        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);
        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(), C_TorikesiKekkaKbn.HUMEI, "取消結果区分");
        assertNull("ACS基盤エラーコード", bzTrksIraiKekkaBean.getAcserrcd());
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.KANOUSEIARI, "自動取消用PAL取消残区分");

        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri(bzTrksIraiYokenBean.getYoukyuuno());
        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "3113", "要求通番");
        assertNull("普保Ⅱ契約番号区分", youkyuuNoKanri.getHuho2kyknokbn());
        assertNull("普保Ⅱ契約番号", youkyuuNoKanri.getHuho2kykno());
        assertNull("（ＭＱ更新用）ＭＱ処理結果区分", youkyuuNoKanri.getMqkousinmqsyorikekkakbn());
        assertNull("（ＭＱ更新用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqkousinacserrcd());
        exClassificationEquals(youkyuuNoKanri.getMqtrksiraimqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "（ＭＱ取消依頼用）ＭＱ処理結果区分");
        assertNull("（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqtrksiraiacserrcd());
        assertNull("契約内容反映エラー区分", youkyuuNoKanri.getKyknaiyouhaneierrkbn());
        exClassificationEquals(youkyuuNoKanri.getTrkskekkakbn(), C_TorikesiKekkaKbn.HUMEI, "取消結果区分");
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.KANOUSEIARI, "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec1", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(160)
    public void testExec_B5 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = "error2";

        BzTrksIraiYokenBean bzTrksIraiYokenBean =
            new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean;

        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);
        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(), C_TorikesiKekkaKbn.HUMEI, "取消結果区分");
        assertNull("ACS基盤エラーコード", bzTrksIraiKekkaBean.getAcserrcd());
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.KANOUSEIARI, "自動取消用PAL取消残区分");
    }

    @Test
    @TestOrder(170)
    public void testExec_B6 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = "error3";

        BzTrksIraiYokenBean bzTrksIraiYokenBean =
            new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean;

        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);
        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(), C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        assertNull("ACS基盤エラーコード", bzTrksIraiKekkaBean.getAcserrcd());
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.ARI, "自動取消用PAL取消残区分");

        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri(bzTrksIraiYokenBean.getYoukyuuno());
        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "3113", "要求通番");
        assertNull("普保Ⅱ契約番号区分", youkyuuNoKanri.getHuho2kyknokbn());
        assertNull("普保Ⅱ契約番号", youkyuuNoKanri.getHuho2kykno());
        assertNull("（ＭＱ更新用）ＭＱ処理結果区分", youkyuuNoKanri.getMqkousinmqsyorikekkakbn());
        assertNull("（ＭＱ更新用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqkousinacserrcd());
        exClassificationEquals(youkyuuNoKanri.getMqtrksiraimqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "（ＭＱ取消依頼用）ＭＱ処理結果区分");
        assertNull("（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqtrksiraiacserrcd());
        assertNull("契約内容反映エラー区分", youkyuuNoKanri.getKyknaiyouhaneierrkbn());
        exClassificationEquals(youkyuuNoKanri.getTrkskekkakbn(), C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.ARI, "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec1", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(180)
    public void testExec_B7 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = "error3";

        BzTrksIraiYokenBean bzTrksIraiYokenBean =
            new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIERROR);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean;

        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);
        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(), C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        assertNull("ACS基盤エラーコード", bzTrksIraiKekkaBean.getAcserrcd());
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.BLNK, "自動取消用PAL取消残区分");
    }

    @Test
    @TestOrder(190)
    public void testExec_B8 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = "error3";

        BzTrksIraiYokenBean bzTrksIraiYokenBean =
            new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean;

        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);
        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(), C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        assertNull("ACS基盤エラーコード", bzTrksIraiKekkaBean.getAcserrcd());
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.KANOUSEIARI, "自動取消用PAL取消残区分");
    }

    @Test
    @TestOrder(200)
    public void testExec1_A12 () {

        BzTrksIraiYokenBean bzTrksIraiYokenBean =  new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setYoukyuuno("180000000000000000");
        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.BLNK);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);

        exClassificationEquals(bzTrksIraiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        assertNull("ACS基盤エラーコード", bzTrksIraiKekkaBean.getAcserrcd());
        exClassificationEquals(bzTrksIraiKekkaBean.getTrkskekkakbn(),
            C_TorikesiKekkaKbn.ERR_SONOTA, "取消結果区分");
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(),
            C_JdTrksPalTrksZanKbn.BLNK, "自動取消用PAL取消残区分");
    }

    @Test
    @TestOrder(210)
    public void testExec_B9 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = "error4";

        BzTrksIraiYokenBean bzTrksIraiYokenBean =
            new BzTrksIraiYokenBean();

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
        bzTrksIraiYokenBean.setYoukyuuno("3113");
        bzTrksIraiYokenBean.setHuho2kykno("10000000003");

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean;

        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
        bzTrksIraiKekkaBean =bzTrksIraiMq.exec(bzTrksIraiYokenBean);

        assertNull("ＭＱ処理結果区分", bzTrksIraiKekkaBean.getMqsyorikekkakbn());
        assertNull("取消結果区分", bzTrksIraiKekkaBean.getTrkskekkakbn());
        assertNull("ACS基盤エラーコード", bzTrksIraiKekkaBean.getAcserrcd());
        exClassificationEquals(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.BLNK, "自動取消用PAL取消残区分");

        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri(bzTrksIraiYokenBean.getYoukyuuno());
        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "3113", "要求通番");
        assertNull("普保Ⅱ契約番号区分", youkyuuNoKanri.getHuho2kyknokbn());
        assertNull("普保Ⅱ契約番号", youkyuuNoKanri.getHuho2kykno());
        assertNull("（ＭＱ更新用）ＭＱ処理結果区分", youkyuuNoKanri.getMqkousinmqsyorikekkakbn());
        assertNull("（ＭＱ更新用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqkousinacserrcd());
        assertNull("（ＭＱ取消依頼用）ＭＱ処理結果区分", youkyuuNoKanri.getMqtrksiraimqsyorikekkakbn());
        assertNull("（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード", youkyuuNoKanri.getMqtrksiraiacserrcd());
        assertNull("契約内容反映エラー区分", youkyuuNoKanri.getKyknaiyouhaneierrkbn());
        assertNull("取消結果区分", youkyuuNoKanri.getTrkskekkakbn());
        exClassificationEquals(youkyuuNoKanri.getJdtrkspaltrkszankbn(), C_JdTrksPalTrksZanKbn.BLNK, "自動取消用ＰＡＬ取消残区分");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinKinou(), "BzTrksIraiMqTest_exec1", "業務用更新機能ＩＤ");
        exStringEquals(youkyuuNoKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }
}