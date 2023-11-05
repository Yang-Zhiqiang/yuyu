package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzdairiten.BzGetTuukeiBunwari;
import yuyu.common.biz.bzdairiten.BzGetTuukeiBunwariMockForSinkeiyaku;
import yuyu.common.biz.bznayose.BzKykNaiyouHaneiMq;
import yuyu.common.biz.bznayose.BzKykNaiyouHaneiMqMockForSinkeiyaku;
import yuyu.common.biz.bznayose.BzKykNaiyouHaneiYokenBean;
import yuyu.common.biz.bznayose.BzTrksIraiMq;
import yuyu.common.biz.bznayose.BzTrksIraiMqMockForSinkeiyaku;
import yuyu.common.biz.bznayose.BzTrksIraiYokenBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_KyknaiyouhaneiErrKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Mfrenflg;
import yuyu.def.classification.C_MossyoumetuKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 新契約当日異動内容編集クラスのメソッド {@link SkToujituIdounaiyouEdit#skIdounaiyouMQEdit(HT_SyoriCTL)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit {

    @Inject
    private SkToujituIdounaiyouEdit skToujituIdounaiyouEdit;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzBatchParam bzBatchParam;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_新契約当日異動内容編集";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {

                bind(BzKykNaiyouHaneiMq.class).to(BzKykNaiyouHaneiMqMockForSinkeiyaku.class);
                bind(BzTrksIraiMq.class).to(BzTrksIraiMqMockForSinkeiyaku.class);
                bind(BzGetTuukeiBunwari.class).to(BzGetTuukeiBunwariMockForSinkeiyaku.class);

            }
        });

    }

    @BeforeClass
    public static void testInit(){
        BzKykNaiyouHaneiMqMockForSinkeiyaku.caller = SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class;
        BzTrksIraiMqMockForSinkeiyaku.caller = SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class;
        BzGetTuukeiBunwariMockForSinkeiyaku.caller = SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class;
    }

    @AfterClass
    public static void testClear() {
        BzKykNaiyouHaneiMqMockForSinkeiyaku.caller = null;
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = null;
        BzTrksIraiMqMockForSinkeiyaku.caller = null;
        BzTrksIraiMqMockForSinkeiyaku.SYORIPTN = null;
        BzGetTuukeiBunwariMockForSinkeiyaku.caller = null;
        BzGetTuukeiBunwariMockForSinkeiyaku.SYORIPTN = null;

        MockObjectManager.initialize();
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.flush();
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllYoukyuuNoKanri());
        bizDomManager.delete(bizDomManager.getAllTjtIdouNySk());
        bizDomManager.flush();
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSequences());
        baseDomManager.flush();

    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testSkIdounaiyouMQEdit_A1() {

        SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(null);

        exClassificationEquals(skIdounaiyouKekkaBean.getErrorKbn(), C_ErrorKbn.ERROR, "新契約当日異動内容実行結果エラー区分");
        exNumericEquals(skIdounaiyouKekkaBean.getErrorMsgLst().size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testSkIdounaiyouMQEdit_A2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");

        SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        exClassificationEquals(skIdounaiyouKekkaBean.getErrorKbn(), C_ErrorKbn.ERROR, "新契約当日異動内容実行結果エラー区分");
        exNumericEquals(skIdounaiyouKekkaBean.getErrorMsgLst().size(), 0, "件数");

    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(30)
    public void testSkIdounaiyouMQEdit_A3() {

        try {
            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
            skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。主契約申込商品件数異常 申込番号：791112246", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testSkIdounaiyouMQEdit_A4() {

        MockObjectManager.initialize();
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");

        SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        exClassificationEquals(skIdounaiyouKekkaBean.getErrorKbn(), C_ErrorKbn.OK, "新契約当日異動内容実行結果エラー区分");

        exNumericEquals(skIdounaiyouKekkaBean.getErrorMsgLst().size(), 0, "件数");

        exStringEquals(skIdounaiyouKekkaBean.getYoukyuuno(), "ykno10000187654321", "要求通番");

        List<BT_TjtIdouNySk> tjtIdouNySkLst = bizDomManager.getTjtIdouNySksByMosno("791112253");
        exNumericEquals(tjtIdouNySkLst.size(), 1, "件数");
        exStringEquals(tjtIdouNySkLst.get(0).getMosno(), "791112253", "申込番号");
        exNumericEquals(tjtIdouNySkLst.get(0).getRenno3keta(), 1, "連番（３桁）");

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = (BzKykNaiyouHaneiYokenBean)MockObjectManager.getArgument(BzKykNaiyouHaneiMqMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.MOSNO, "普保Ⅱ契約番号区分");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getHuho2kykno(), "791112253", "普保Ⅱ契約番号");
        exNumericEquals(bzKykNaiyouHaneiYokenBean.getRecordsakujyohyouji(), 0, "レコード削除表示");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkseiritukbn(), C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(bzKykNaiyouHaneiYokenBean.getSksrsyoriymd(), BizDate.valueOf("20160401"), "（新契約）成立処理日");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkmfrenflg(), C_Mfrenflg.SUMI, "MF連動済フラグ");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSksyono(), "11807111141", "（新契約）証券番号");
        exDateEquals(bzKykNaiyouHaneiYokenBean.getSkmosymd(), BizDate.valueOf("20160402"), "（新契約）申込日");
        exDateEquals(bzKykNaiyouHaneiYokenBean.getSkkykymd(), BizDate.valueOf("20160403"), "（新契約）契約日");
        exDateEquals(bzKykNaiyouHaneiYokenBean.getSksknnkaisiymd(), BizDate.valueOf("20160404"), "（新契約）責任開始日");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkkyktuukasyu(), C_Tuukasyu.JPY, "（新契約）契約通貨種類");
        exBizCalcbleEquals(bzKykNaiyouHaneiYokenBean.getSktsnnkgns(), BizCurrency.valueOf(400), "（新契約）通算用年金原資");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSksntkhoukbn(), C_SntkhouKbn.HJY, "（新契約）選択方法区分");
        exDateYMEquals(bzKykNaiyouHaneiYokenBean.getSkbosyuuym(), BizDateYM.valueOf("201604"), "（新契約）募集年月");
        exNumericEquals(bzKykNaiyouHaneiYokenBean.getSkkykhhkndouhyouji(), 1, "契約者被保険者同一表示");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getHhknnmkn(), "カナ", "被保険者名（カナ）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getHhknnmkj(), "漢字", "被保険者名（漢字）");
        exDateEquals(bzKykNaiyouHaneiYokenBean.getHhknseiymd(), BizDate.valueOf("20160405"), "被保険者生年月日");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getHhknyno(), "1234567", "被保険者郵便番号");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getHhknadr1kj(), "被保険者住所１", "被保険者住所１（漢字）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getHhknadr2kj(), "被保険者住所２", "被保険者住所２（漢字）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getHhknadr3kj(), "被保険者住所３", "被保険者住所３（漢字）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getHhkntelno(), "023-4560-7890", "被保険者電話番号");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getHhknsykgycd(), "060", "被保険者職業コード");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKyknmkn(), "カナカナ", "契約者名（カナ）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKyknmkj(), "漢字漢字", "契約者名（漢字）");
        exDateEquals(bzKykNaiyouHaneiYokenBean.getKykseiymd(), BizDate.valueOf("20160406"), "契約者生年月日");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getTsinyno(), "7654321", "通信先郵便番号");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getTsintelno(), "087-6540-3210", "通信先電話番号");
        exBizCalcbleEquals(bzKykNaiyouHaneiYokenBean.getSktsnsibous(), BizCurrency.valueOf(400), "（新契約）通算用死亡Ｓ");
        exBizCalcbleEquals(bzKykNaiyouHaneiYokenBean.getSktsnitijip(), BizCurrency.valueOf(500), "（新契約）通算用一時払Ｐ");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSksyouhncd(), "ﾕｾ", "（新契約）商品コード");
        exNumericEquals(bzKykNaiyouHaneiYokenBean.getSkhrkkkn(), 1, "（新契約）払込期間");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSbuktnmkn1(), "カナナ", "死亡受取人名（カナ）１");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSbuktnmkj1(), "漢字字", "死亡受取人名（漢字）１");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSbuktnmkn2(), "カナナナ", "死亡受取人名（カナ）２");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSbuktnmkj2(), "漢字字字", "死亡受取人名（漢字）２");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSbuktnmkn3(), "カナナナナ", "死亡受取人名（カナ）３");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSbuktnmkj3(), "漢字字字字", "死亡受取人名（漢字）３");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSbuktnmkn4(), "カナナナナナ", "死亡受取人名（カナ）４");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSbuktnmkj4(), "漢字字字字字", "死亡受取人名（漢字）４");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getStdrsknmkn(), "カナナナナナナ", "指定代理請求人名（カナ）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getStdrsknmkj(), "漢字字字字字字", "指定代理請求人名（漢字）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKykdairinmkn(), null, "契約者代理人名（カナ）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKykdairinmkj(), null, "契約者代理人名（漢字）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getDairitencd1(), "D001", "代理店コード１");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKzktourokunmkn1(), "カナ１", "家族登録名（カナ）１");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKzktourokunmkj1(), "漢字１", "家族登録名（漢字）１");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKzktourokunmkn2(), "カナ２", "家族登録名（カナ）２");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKzktourokunmkj2(), "漢字２", "家族登録名（漢字）２");
        exBizCalcbleEquals(bzKykNaiyouHaneiYokenBean.getBunwari1(), BizNumber.valueOf(1), "分担割合１");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKanrisosikicd1(), "DK01", "管理組織コード１");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getDairitencd2(), "D002", "代理店コード２");
        exBizCalcbleEquals(bzKykNaiyouHaneiYokenBean.getBunwari2(), BizNumber.valueOf(2), "分担割合２");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKanrisosikicd2(), "DK02", "管理組織コード２");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkmossyoumetukbn(), C_MossyoumetuKbn.SEIRITU, "（新契約）申込消滅区分");

        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkkaigomaehrtkykumukbn(), C_UmuKbn.ARI, "（新契約）介護前払特約有無区分");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkpyennykntkykumukbn(), C_UmuKbn.ARI, "（新契約）保険料円入金特約有無区分");
        exBizCalcbleEquals(bzKykNaiyouHaneiYokenBean.getSktsnyennyknkgk(), BizCurrency.valueOf(0), "（新契約）通算用円入金額");
        exNumericEquals(bzKykNaiyouHaneiYokenBean.getSksyouhnsdno(), 1, "（新契約）商品世代番号");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testSkIdounaiyouMQEdit_A5() {

        MockObjectManager.initialize();
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112261");

        SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        exClassificationEquals(skIdounaiyouKekkaBean.getErrorKbn(), C_ErrorKbn.ERROR, "新契約当日異動内容実行結果エラー区分");

        exNumericEquals(skIdounaiyouKekkaBean.getErrorMsgLst().size(), 1, "件数");
        exStringEquals(skIdounaiyouKekkaBean.getErrorMsgLst().get(0), "EBA1020", "出力エラーメッセージID");
        exStringEquals(skIdounaiyouKekkaBean.getYoukyuuno(), null, "要求通番");

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = (BzKykNaiyouHaneiYokenBean)MockObjectManager.getArgument(BzKykNaiyouHaneiMqMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.MOSNO, "普保Ⅱ契約番号区分");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getHuho2kykno(), "791112261", "普保Ⅱ契約番号");
        exNumericEquals(bzKykNaiyouHaneiYokenBean.getRecordsakujyohyouji(), 0, "レコード削除表示");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkseiritukbn(), C_SeirituKbn.HUSEIRITU, "（新契約）成立区分");
        exDateEquals(bzKykNaiyouHaneiYokenBean.getSksrsyoriymd(), BizDate.valueOf("20160401"), "（新契約）成立処理日");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkmfrenflg(), C_Mfrenflg.SUMI, "MF連動済フラグ");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSksyono(), "11807111152", "（新契約）証券番号");
        exDateEquals(bzKykNaiyouHaneiYokenBean.getSkmosymd(), BizDate.valueOf("20160402"), "（新契約）申込日");
        exDateEquals(bzKykNaiyouHaneiYokenBean.getSkkykymd(), BizDate.valueOf("20160403"), "（新契約）契約日");
        exDateEquals(bzKykNaiyouHaneiYokenBean.getSksknnkaisiymd(), BizDate.valueOf("20160404"), "（新契約）責任開始日");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkkyktuukasyu(), C_Tuukasyu.JPY, "（新契約）契約通貨種類");
        exBizCalcbleEquals(bzKykNaiyouHaneiYokenBean.getSktsnnkgns(), BizCurrency.valueOf(400), "（新契約）通算用年金原資");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSksntkhoukbn(), C_SntkhouKbn.HJY, "（新契約）選択方法区分");
        exDateYMEquals(bzKykNaiyouHaneiYokenBean.getSkbosyuuym(), BizDateYM.valueOf("201604"), "（新契約）募集年月");
        exNumericEquals(bzKykNaiyouHaneiYokenBean.getSkkykhhkndouhyouji(), 0, "（新契約）契約者被保険者同一表示");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getHhknnmkn(), "カナ", "被保険者名（カナ）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getHhknnmkj(), "漢字", "被保険者名（漢字）");
        exDateEquals(bzKykNaiyouHaneiYokenBean.getHhknseiymd(), BizDate.valueOf("20160405"), "被保険者生年月日");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getHhknyno(), "1234567", "被保険者郵便番号");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getHhknadr1kj(), "被保険者住所１", "被保険者住所１（漢字）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getHhknadr2kj(), "被保険者住所２", "被保険者住所２（漢字）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getHhknadr3kj(), "被保険者住所３", "被保険者住所３（漢字）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getHhkntelno(), "023-4560-7890", "被保険者電話番号");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getHhknsykgycd(), "060", "被保険者職業コード");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKyknmkn(), "カナカナ", "契約者名（カナ）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKyknmkj(), "漢字漢字", "契約者名（漢字）");
        exDateEquals(bzKykNaiyouHaneiYokenBean.getKykseiymd(), BizDate.valueOf("20160406"), "契約者生年月日");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getTsinyno(), "7654321", "通信先郵便番号");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getTsintelno(), "087-6540-3210", "通信先電話番号");
        exBizCalcbleEquals(bzKykNaiyouHaneiYokenBean.getSktsnsibous(), BizCurrency.valueOf(400), "（新契約）通算用死亡Ｓ");
        exBizCalcbleEquals(bzKykNaiyouHaneiYokenBean.getSktsnitijip(), BizCurrency.valueOf(500), "（新契約）通算用一時払Ｐ");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSksyouhncd(), "ﾕｾ", "（新契約）商品コード");
        exNumericEquals(bzKykNaiyouHaneiYokenBean.getSkhrkkkn(), 1, "（新契約）払込期間");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSbuktnmkn1(), null, "死亡受取人名（カナ）１");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSbuktnmkj1(), null, "死亡受取人名（漢字）１");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSbuktnmkn2(), null, "死亡受取人名（カナ）２");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSbuktnmkj2(), null, "死亡受取人名（漢字）２");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSbuktnmkn3(), null, "死亡受取人名（カナ）３");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSbuktnmkj3(), null, "死亡受取人名（漢字）３");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSbuktnmkn4(), null, "死亡受取人名（カナ）４");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSbuktnmkj4(), null, "死亡受取人名（漢字）４");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getStdrsknmkn(), null, "指定代理請求人名（カナ）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getStdrsknmkj(), null, "指定代理請求人名（漢字）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKykdairinmkn(), null, "契約者代理人名（カナ）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKykdairinmkj(), null, "契約者代理人名（漢字）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getDairitencd1(), null, "代理店コード１");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKzktourokunmkn1(), null, "家族登録名（カナ）１");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKzktourokunmkj1(), null, "家族登録名（漢字）１");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKzktourokunmkn2(), null, "家族登録名（カナ）２");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKzktourokunmkj2(), null, "家族登録名（漢字）２");
        exBizCalcbleEquals(bzKykNaiyouHaneiYokenBean.getBunwari1(), null, "分担割合１");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKanrisosikicd1(), null, "管理組織コード１");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getDairitencd2(), null, "代理店コード２");
        exBizCalcbleEquals(bzKykNaiyouHaneiYokenBean.getBunwari2(), null, "分担割合２");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKanrisosikicd2(), null, "管理組織コード２");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkmossyoumetukbn(), C_MossyoumetuKbn.MIKAKUTEI, "（新契約）申込消滅区分");

        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkkaigomaehrtkykumukbn(), C_UmuKbn.NONE, "（新契約）介護前払特約有無区分");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkpyennykntkykumukbn(), C_UmuKbn.NONE, "（新契約）保険料円入金特約有無区分");
        exBizCalcbleEquals(bzKykNaiyouHaneiYokenBean.getSktsnyennyknkgk(), BizCurrency.valueOf(0), "（新契約）通算用円入金額");
        exNumericEquals(bzKykNaiyouHaneiYokenBean.getSksyouhnsdno(), 1, "（新契約）商品世代番号");

    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testSkIdounaiyouMQEdit_A6() {

        MockObjectManager.initialize();
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN3;
        BzTrksIraiMqMockForSinkeiyaku.SYORIPTN = BzTrksIraiMqMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112279");

        SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        exClassificationEquals(skIdounaiyouKekkaBean.getErrorKbn(), C_ErrorKbn.ERROR, "新契約当日異動内容実行結果エラー区分");

        exNumericEquals(skIdounaiyouKekkaBean.getErrorMsgLst().size(), 1, "件数");
        exStringEquals(skIdounaiyouKekkaBean.getErrorMsgLst().get(0), "EBA1021", "出力エラーメッセージID");

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = (BzKykNaiyouHaneiYokenBean)MockObjectManager.getArgument(BzKykNaiyouHaneiMqMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkmossyoumetukbn(), C_MossyoumetuKbn.MIAWASE, "（新契約）申込消滅区分");

        BzTrksIraiYokenBean bzTrksIraiYokenBean = (BzTrksIraiYokenBean)MockObjectManager.getArgument(BzTrksIraiMq.class, "exec", 0, 0);
        exClassificationEquals(bzTrksIraiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.MOSNO, "普保Ⅱ契約番号区分");
        exStringEquals(bzTrksIraiYokenBean.getHuho2kykno(), "791112279", "普保Ⅱ契約番号");
        exStringEquals(bzTrksIraiYokenBean.getYoukyuuno(), "ykno10000187654321", "要求通番");
        exClassificationEquals(bzTrksIraiYokenBean.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU, "契約内容反映エラー区分");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testSkIdounaiyouMQEdit_A7() {

        MockObjectManager.initialize();
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN3;
        BzTrksIraiMqMockForSinkeiyaku.SYORIPTN = BzTrksIraiMqMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");

        SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        exClassificationEquals(skIdounaiyouKekkaBean.getErrorKbn(), C_ErrorKbn.ERROR, "新契約当日異動内容実行結果エラー区分");

        exNumericEquals(skIdounaiyouKekkaBean.getErrorMsgLst().size(), 1, "件数");
        exStringEquals(skIdounaiyouKekkaBean.getErrorMsgLst().get(0), "EBA1022", "出力エラーメッセージID");

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = (BzKykNaiyouHaneiYokenBean)MockObjectManager.getArgument(BzKykNaiyouHaneiMqMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkmossyoumetukbn(), C_MossyoumetuKbn.ENKI, "（新契約）申込消滅区分");

        BzTrksIraiYokenBean bzTrksIraiYokenBean = (BzTrksIraiYokenBean)MockObjectManager.getArgument(BzTrksIraiMq.class, "exec", 0, 0);
        exClassificationEquals(bzTrksIraiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.MOSNO, "普保Ⅱ契約番号区分");
        exStringEquals(bzTrksIraiYokenBean.getHuho2kykno(), "791112287", "普保Ⅱ契約番号");
        exStringEquals(bzTrksIraiYokenBean.getYoukyuuno(), "ykno10000187654321", "要求通番");
        exClassificationEquals(bzTrksIraiYokenBean.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU, "契約内容反映エラー区分");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testSkIdounaiyouMQEdit_A8() {

        MockObjectManager.initialize();
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN3;
        BzTrksIraiMqMockForSinkeiyaku.SYORIPTN = BzTrksIraiMqMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112295");

        SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        exClassificationEquals(skIdounaiyouKekkaBean.getErrorKbn(), C_ErrorKbn.ERROR, "新契約当日異動内容実行結果エラー区分");

        exNumericEquals(skIdounaiyouKekkaBean.getErrorMsgLst().size(), 1, "件数");
        exStringEquals(skIdounaiyouKekkaBean.getErrorMsgLst().get(0), "EBA1020", "出力エラーメッセージID");

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = (BzKykNaiyouHaneiYokenBean)MockObjectManager.getArgument(BzKykNaiyouHaneiMqMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkmossyoumetukbn(), C_MossyoumetuKbn.ENKI, "（新契約）申込消滅区分");

        BzTrksIraiYokenBean bzTrksIraiYokenBean = (BzTrksIraiYokenBean)MockObjectManager.getArgument(BzTrksIraiMq.class, "exec", 0, 0);
        exClassificationEquals(bzTrksIraiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.MOSNO, "普保Ⅱ契約番号区分");
        exStringEquals(bzTrksIraiYokenBean.getHuho2kykno(), "791112295", "普保Ⅱ契約番号");
        exStringEquals(bzTrksIraiYokenBean.getYoukyuuno(), "ykno10000187654321", "要求通番");
        exClassificationEquals(bzTrksIraiYokenBean.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU, "契約内容反映エラー区分");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testSkIdounaiyouMQEdit_A9() {

        MockObjectManager.initialize();
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN4;
        BzTrksIraiMqMockForSinkeiyaku.SYORIPTN = BzTrksIraiMqMockForSinkeiyaku.TESTPATTERN4;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112303");

        SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        exClassificationEquals(skIdounaiyouKekkaBean.getErrorKbn(), C_ErrorKbn.ERROR, "新契約当日異動内容実行結果エラー区分");

        exNumericEquals(skIdounaiyouKekkaBean.getErrorMsgLst().size(), 1, "件数");
        exStringEquals(skIdounaiyouKekkaBean.getErrorMsgLst().get(0), "EBA1020", "出力エラーメッセージID");

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = (BzKykNaiyouHaneiYokenBean)MockObjectManager.getArgument(BzKykNaiyouHaneiMqMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkmossyoumetukbn(), C_MossyoumetuKbn.MOSTRKS, "（新契約）申込消滅区分");

    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testSkIdounaiyouMQEdit_A10() {

        MockObjectManager.initialize();
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN3;
        BzTrksIraiMqMockForSinkeiyaku.SYORIPTN = BzTrksIraiMqMockForSinkeiyaku.TESTPATTERN4;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112311");

        SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        exClassificationEquals(skIdounaiyouKekkaBean.getErrorKbn(), C_ErrorKbn.ERROR, "新契約当日異動内容実行結果エラー区分");

        exNumericEquals(skIdounaiyouKekkaBean.getErrorMsgLst().size(), 1, "件数");
        exStringEquals(skIdounaiyouKekkaBean.getErrorMsgLst().get(0), "EBA1020", "出力エラーメッセージID");

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = (BzKykNaiyouHaneiYokenBean)MockObjectManager.getArgument(BzKykNaiyouHaneiMqMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkmossyoumetukbn(), C_MossyoumetuKbn.YUUKOUKIKANKEIKA, "（新契約）申込消滅区分");

        BzTrksIraiYokenBean bzTrksIraiYokenBean = (BzTrksIraiYokenBean)MockObjectManager.getArgument(BzTrksIraiMq.class, "exec", 0, 0);
        exClassificationEquals(bzTrksIraiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.MOSNO, "普保Ⅱ契約番号区分");
        exStringEquals(bzTrksIraiYokenBean.getHuho2kykno(), "791112311", "普保Ⅱ契約番号");
        exStringEquals(bzTrksIraiYokenBean.getYoukyuuno(), "ykno10000187654321", "要求通番");
        exClassificationEquals(bzTrksIraiYokenBean.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU, "契約内容反映エラー区分");
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testSkIdounaiyouMQEdit_A11() {

        MockObjectManager.initialize();
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN3;
        BzTrksIraiMqMockForSinkeiyaku.SYORIPTN = BzTrksIraiMqMockForSinkeiyaku.TESTPATTERN4;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112329");

        SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        exClassificationEquals(skIdounaiyouKekkaBean.getErrorKbn(), C_ErrorKbn.ERROR, "新契約当日異動内容実行結果エラー区分");

        exNumericEquals(skIdounaiyouKekkaBean.getErrorMsgLst().size(), 1, "件数");
        exStringEquals(skIdounaiyouKekkaBean.getErrorMsgLst().get(0), "EBA1020", "出力エラーメッセージID");

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = (BzKykNaiyouHaneiYokenBean)MockObjectManager.getArgument(BzKykNaiyouHaneiMqMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkmossyoumetukbn(), C_MossyoumetuKbn.MIKAKUTEI, "（新契約）申込消滅区分");

        BzTrksIraiYokenBean bzTrksIraiYokenBean = (BzTrksIraiYokenBean)MockObjectManager.getArgument(BzTrksIraiMq.class, "exec", 0, 0);
        exClassificationEquals(bzTrksIraiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.MOSNO, "普保Ⅱ契約番号区分");
        exStringEquals(bzTrksIraiYokenBean.getHuho2kykno(), "791112329", "普保Ⅱ契約番号");
        exStringEquals(bzTrksIraiYokenBean.getYoukyuuno(), "ykno10000187654321", "要求通番");
        exClassificationEquals(bzTrksIraiYokenBean.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU, "契約内容反映エラー区分");
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testSkIdounaiyouMQEdit_A12() {

        MockObjectManager.initialize();
        BzGetTuukeiBunwariMockForSinkeiyaku.SYORIPTN = BzGetTuukeiBunwariMockForSinkeiyaku.TESTPATTERN1;
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN5;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112337");

        SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        exClassificationEquals(skIdounaiyouKekkaBean.getErrorKbn(), C_ErrorKbn.OK, "新契約当日異動内容実行結果エラー区分");

        exNumericEquals(skIdounaiyouKekkaBean.getErrorMsgLst().size(), 0, "件数");

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = (BzKykNaiyouHaneiYokenBean)MockObjectManager.getArgument(BzKykNaiyouHaneiMqMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzKykNaiyouHaneiYokenBean.getHhknnmkj(), "", "被保険者名（漢字）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKyknmkj(), "", "契約者名（漢字）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSbuktnmkj1(), "", "死亡受取人名（漢字）１");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSbuktnmkj2(), "", "死亡受取人名（漢字）２");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSbuktnmkj3(), "", "死亡受取人名（漢字）３");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSbuktnmkj4(), "", "死亡受取人名（漢字）４");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getStdrsknmkj(), "", "指定代理請求人名（漢字）");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKanrisosikicd2(), "", "管理組織コード２");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKzktourokunmkj1(), "", "家族登録名（漢字）１");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKzktourokunmkj2(), "", "家族登録名（漢字）２");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(130)
    public void testSkIdounaiyouMQEdit_A13() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112345");

        try {
            skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);
        }
        catch(CommonBizAppException e){
            exStringEquals(e.getMessage(), "システム整合性エラーです。主契約申込商品件数異常 申込番号：791112345", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testSkIdounaiyouMQEdit_A14() {

        MockObjectManager.initialize();

        C_KinouKbn kinouKbn = kinou.getKinouKbn();
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        bzBatchParam.setSyoriYmd(BizDate.valueOf(20171001));

        BzGetTuukeiBunwariMockForSinkeiyaku.SYORIPTN = BzGetTuukeiBunwariMockForSinkeiyaku.TESTPATTERN1;
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN6;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112352");

        SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        exClassificationEquals(skIdounaiyouKekkaBean.getErrorKbn(), C_ErrorKbn.OK, "新契約当日異動内容実行結果エラー区分");

        exNumericEquals(skIdounaiyouKekkaBean.getErrorMsgLst().size(), 0, "件数");

        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForSinkeiyaku.class, "exec", 0, 6), BizDateYM.valueOf(201710), "基準年月");

        kinou.setKinouKbn(kinouKbn);
        bzBatchParam.setSyoriYmd(syoriYmd);
    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testSkIdounaiyouMQEdit_A15() {

        MockObjectManager.initialize();

        C_KinouKbn kinouKbn = kinou.getKinouKbn();
        kinou.setKinouKbn(C_KinouKbn.ONLINEBATCH);

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        bzBatchParam.setSyoriYmd(BizDate.valueOf(20171101));

        BzGetTuukeiBunwariMockForSinkeiyaku.SYORIPTN = BzGetTuukeiBunwariMockForSinkeiyaku.TESTPATTERN1;
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN7;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112360");

        SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        exClassificationEquals(skIdounaiyouKekkaBean.getErrorKbn(), C_ErrorKbn.OK, "新契約当日異動内容実行結果エラー区分");

        exNumericEquals(skIdounaiyouKekkaBean.getErrorMsgLst().size(), 0, "件数");

        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForSinkeiyaku.class, "exec", 0, 6), BizDateYM.valueOf(201711), "基準年月");

        exNumericEquals(syoriCTL.getNayoseKekkas().size(), 1, "件数");
        exStringEquals(syoriCTL.getNayoseKekkas().get(0).getSakuinnmno(), "10", "索引名番号");

        kinou.setKinouKbn(kinouKbn);
        bzBatchParam.setSyoriYmd(syoriYmd);
    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testSkIdounaiyouMQEdit_A16() {

        BzGetTuukeiBunwariMockForSinkeiyaku.SYORIPTN = BzGetTuukeiBunwariMockForSinkeiyaku.TESTPATTERN1;
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN8;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112378");

        SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        exClassificationEquals(skIdounaiyouKekkaBean.getErrorKbn(), C_ErrorKbn.OK, "新契約当日異動内容実行結果エラー区分");

        exNumericEquals(skIdounaiyouKekkaBean.getErrorMsgLst().size(), 0, "件数");

        exNumericEquals(syoriCTL.getNayoseKekkas().size(), 1, "件数");
        exStringEquals(syoriCTL.getNayoseKekkas().get(0).getSakuinnmno(), "20", "索引名番号");
    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testSkIdounaiyouMQEdit_A17() {

        BzGetTuukeiBunwariMockForSinkeiyaku.SYORIPTN = BzGetTuukeiBunwariMockForSinkeiyaku.TESTPATTERN1;
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN9;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112386");

        SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        exClassificationEquals(skIdounaiyouKekkaBean.getErrorKbn(), C_ErrorKbn.OK, "新契約当日異動内容実行結果エラー区分");

        exNumericEquals(skIdounaiyouKekkaBean.getErrorMsgLst().size(), 0, "件数");

        exNumericEquals(syoriCTL.getNayoseKekkas().size(), 3, "件数");
        exStringEquals(syoriCTL.getNayoseKekkas().get(0).getSakuinnmno(), "0", "索引名番号");
        exStringEquals(syoriCTL.getNayoseKekkas().get(1).getSakuinnmno(), "0", "索引名番号");
        exStringEquals(syoriCTL.getNayoseKekkas().get(2).getSakuinnmno(), "0", "索引名番号");
    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testSkIdounaiyouMQEdit_A18() {

        BzGetTuukeiBunwariMockForSinkeiyaku.SYORIPTN = BzGetTuukeiBunwariMockForSinkeiyaku.TESTPATTERN1;
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN10;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112394");

        SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        exClassificationEquals(skIdounaiyouKekkaBean.getErrorKbn(), C_ErrorKbn.OK, "新契約当日異動内容実行結果エラー区分");

        exNumericEquals(skIdounaiyouKekkaBean.getErrorMsgLst().size(), 0, "件数");

        exNumericEquals(syoriCTL.getNayoseKekkas().size(), 1, "件数");
        exStringEquals(syoriCTL.getNayoseKekkas().get(0).getSakuinnmno(), "20", "索引名番号");
    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testSkIdounaiyouMQEdit_A19() {

        BzGetTuukeiBunwariMockForSinkeiyaku.SYORIPTN = BzGetTuukeiBunwariMockForSinkeiyaku.TESTPATTERN1;
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN11;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112402");

        SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        exClassificationEquals(skIdounaiyouKekkaBean.getErrorKbn(), C_ErrorKbn.OK, "新契約当日異動内容実行結果エラー区分");

        exNumericEquals(skIdounaiyouKekkaBean.getErrorMsgLst().size(), 0, "件数");

        exNumericEquals(syoriCTL.getNayoseKekkas().size(), 1, "件数");
        exStringEquals(syoriCTL.getNayoseKekkas().get(0).getSakuinnmno(), "0", "索引名番号");
    }

    @Test
    @Transactional
    @TestOrder(200)
    public void testSkIdounaiyouMQEdit_A20() {

        MockObjectManager.initialize();
        BzGetTuukeiBunwariMockForSinkeiyaku.SYORIPTN = BzGetTuukeiBunwariMockForSinkeiyaku.TESTPATTERN1;
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112410");

        skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = (BzKykNaiyouHaneiYokenBean)MockObjectManager.getArgument(BzKykNaiyouHaneiMqMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkhrkkeiro(), C_Hrkkeiro.KOUHURI, "（新契約）払込経路");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSktsntuukasyu(), C_Tuukasyu.JPY, "（新契約）通算用通貨種類");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getBankcd(), null, "銀行コード");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSitencd(), null, "支店コード");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getYokinkbn(), null, "預金種目区分");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKouzano(), null, "口座番号");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKzmeiginmkn(), null, "口座名義人氏名（カナ）");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getKzkykdoukbn(), null, "口座名義契約者同一区分");
    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testSkIdounaiyouMQEdit_A21() {

        MockObjectManager.initialize();
        BzGetTuukeiBunwariMockForSinkeiyaku.SYORIPTN = BzGetTuukeiBunwariMockForSinkeiyaku.TESTPATTERN1;
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112428");

        skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = (BzKykNaiyouHaneiYokenBean)MockObjectManager.getArgument(BzKykNaiyouHaneiMqMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkhrkkeiro(), C_Hrkkeiro.DANTAI, "（新契約）払込経路");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSktsntuukasyu(), C_Tuukasyu.JPY, "（新契約）通算用通貨種類");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getBankcd(), null, "銀行コード");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSitencd(), null, "支店コード");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getYokinkbn(), null, "預金種目区分");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKouzano(), null, "口座番号");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKzmeiginmkn(), null, "口座名義人氏名（カナ）");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getKzkykdoukbn(), null, "口座名義契約者同一区分");
    }

    @Test
    @Transactional
    @TestOrder(220)
    public void testSkIdounaiyouMQEdit_A22() {

        MockObjectManager.initialize();
        BzGetTuukeiBunwariMockForSinkeiyaku.SYORIPTN = BzGetTuukeiBunwariMockForSinkeiyaku.TESTPATTERN1;
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112436");

        skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = (BzKykNaiyouHaneiYokenBean)MockObjectManager.getArgument(BzKykNaiyouHaneiMqMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkhrkkeiro(), C_Hrkkeiro.KOUHURI, "（新契約）払込経路");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSktsntuukasyu(), C_Tuukasyu.USD, "（新契約）通算用通貨種類");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getBankcd(), null, "銀行コード");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSitencd(), null, "支店コード");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getYokinkbn(), null, "預金種目区分");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKouzano(), null, "口座番号");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKzmeiginmkn(), null, "口座名義人氏名（カナ）");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getKzkykdoukbn(), null, "口座名義契約者同一区分");
    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testSkIdounaiyouMQEdit_A23() {

        MockObjectManager.initialize();
        BzGetTuukeiBunwariMockForSinkeiyaku.SYORIPTN = BzGetTuukeiBunwariMockForSinkeiyaku.TESTPATTERN1;
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112444");

        skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = (BzKykNaiyouHaneiYokenBean)MockObjectManager.getArgument(BzKykNaiyouHaneiMqMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkhrkkeiro(), C_Hrkkeiro.KOUHURI, "（新契約）払込経路");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSktsntuukasyu(), C_Tuukasyu.AUD, "（新契約）通算用通貨種類");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getBankcd(), "1001", "銀行コード");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSitencd(), "101", "支店コード");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKouzano(), "123451000010", "口座番号");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKzmeiginmkn(), "ヒホケンメイカナ１", "口座名義人氏名（カナ）");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getKzkykdoukbn(), C_KzkykdouKbn.DOUITU, "口座名義契約者同一区分");
    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testSkIdounaiyouMQEdit_A24() {

        MockObjectManager.initialize();
        BzGetTuukeiBunwariMockForSinkeiyaku.SYORIPTN = BzGetTuukeiBunwariMockForSinkeiyaku.TESTPATTERN1;
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112451");

        skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = (BzKykNaiyouHaneiYokenBean)MockObjectManager.getArgument(BzKykNaiyouHaneiMqMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkhrkkeiro(), C_Hrkkeiro.KOUHURI, "（新契約）払込経路");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSktsntuukasyu(), C_Tuukasyu.EUR, "（新契約）通算用通貨種類");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getBankcd(), "1002", "銀行コード");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSitencd(), "102", "支店コード");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getYokinkbn(), C_YokinKbn.TOUZA, "預金種目区分");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKouzano(), "123451000011", "口座番号");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKzmeiginmkn(), "ケイヤクメイカナ１", "口座名義人氏名（カナ）");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getKzkykdoukbn(), C_KzkykdouKbn.DOUITU, "口座名義契約者同一区分");
    }

    @Test
    @Transactional
    @TestOrder(250)
    public void testSkIdounaiyouMQEdit_A25() {

        MockObjectManager.initialize();
        BzGetTuukeiBunwariMockForSinkeiyaku.SYORIPTN = BzGetTuukeiBunwariMockForSinkeiyaku.TESTPATTERN1;
        BzKykNaiyouHaneiMqMockForSinkeiyaku.SYORIPTN = BzKykNaiyouHaneiMqMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112469");

        skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = (BzKykNaiyouHaneiYokenBean)MockObjectManager.getArgument(BzKykNaiyouHaneiMqMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSkhrkkeiro(), C_Hrkkeiro.KOUHURI, "（新契約）払込経路");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getSktsntuukasyu(), C_Tuukasyu.AUD, "（新契約）通算用通貨種類");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getBankcd(), "1003", "銀行コード");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getSitencd(), "103", "支店コード");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getYokinkbn(), C_YokinKbn.TTYOKIN, "預金種目区分");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKouzano(), "123451000012", "口座番号");
        exStringEquals(bzKykNaiyouHaneiYokenBean.getKzmeiginmkn(), "コウザメイギニンシメイカナ３", "口座名義人氏名（カナ）");
        exClassificationEquals(bzKykNaiyouHaneiYokenBean.getKzkykdoukbn(), C_KzkykdouKbn.SITEI, "口座名義契約者同一区分");
    }
}
