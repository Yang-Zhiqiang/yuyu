package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_RateGetErrorKbn;
import yuyu.def.classification.C_RyourituKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BzGetPrate2クラスのメソッド {@link BzGetPrate#exec(String, String, BizNumber, C_Hrkkaisuu, C_Hhknsei, int, C_HknkknsmnKbn, int, int, C_Kykjyoutai, C_Tuukasyu, int, C_RyourituKbn)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetPrate2Test_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_Ｐレート取得２";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetPrate2Test_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllRateP2());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BzGetPrate2 bzGetPrate2 = SWAKInjector.getInstance(BzGetPrate2.class);

        BzGetPrateBean bzGetPrateBean = bzGetPrate2.exec(
            "ﾕｲ",
            "J",
            BizNumber.valueOf(0.005),
            C_Hrkkaisuu.ITIJI,
            C_Hhknsei.MALE,
            10,
            C_HknkknsmnKbn.NENMANKI,
            15,
            20,
            C_Kykjyoutai.HRKMTYUU,
            C_Tuukasyu.JPY,
            2,
            C_RyourituKbn.DANTAI_B);

        exClassificationEquals(bzGetPrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetPrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetPrateBean.getPrate(), BizNumber.valueOf(123.456789), "Ｐレート");
        exBizCalcbleEquals(bzGetPrateBean.getPsRate(), BizNumber.valueOf(223.456789), "Ｐ建Ｓレート");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BzGetPrate2 bzGetPrate2 = SWAKInjector.getInstance(BzGetPrate2.class);

        BzGetPrateBean bzGetPrateBean = bzGetPrate2.exec(
            "ﾕﾉ",
            "K",
            BizNumber.valueOf(0.005),
            C_Hrkkaisuu.ITIJI,
            C_Hhknsei.MALE,
            10,
            C_HknkknsmnKbn.NENMANKI,
            15,
            20,
            C_Kykjyoutai.HRKMTYUU,
            C_Tuukasyu.JPY,
            2,
            C_RyourituKbn.DANTAI_B);

        exClassificationEquals(bzGetPrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetPrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetPrateBean.getPrate(), BizNumber.valueOf(123.456789), "Ｐレート");
        exBizCalcbleEquals(bzGetPrateBean.getPsRate(), BizNumber.valueOf(223.456789), "Ｐ建Ｓレート");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BzGetPrate2 bzGetPrate2 = SWAKInjector.getInstance(BzGetPrate2.class);

        BzGetPrateBean bzGetPrateBean = bzGetPrate2.exec(
            "ﾕﾉ",
            "L",
            BizNumber.valueOf(0.005),
            C_Hrkkaisuu.ITIJI,
            C_Hhknsei.MALE,
            10,
            C_HknkknsmnKbn.NENMANKI,
            15,
            20,
            C_Kykjyoutai.HRKMTYUU,
            C_Tuukasyu.JPY,
            2,
            C_RyourituKbn.DANTAI_B);

        exClassificationEquals(bzGetPrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetPrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetPrateBean.getPrate(), BizNumber.valueOf(123.456789), "Ｐレート");
        exBizCalcbleEquals(bzGetPrateBean.getPsRate(), BizNumber.valueOf(223.456789), "Ｐ建Ｓレート");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BzGetPrate2 bzGetPrate2 = SWAKInjector.getInstance(BzGetPrate2.class);

        BzGetPrateBean bzGetPrateBean = bzGetPrate2.exec(
            "ﾕｲ",
            "0",
            BizNumber.valueOf(0.005),
            C_Hrkkaisuu.ITIJI,
            C_Hhknsei.MALE,
            10,
            C_HknkknsmnKbn.NENMANKI,
            15,
            20,
            C_Kykjyoutai.HRKMTYUU,
            C_Tuukasyu.JPY,
            2,
            C_RyourituKbn.DANTAI_B);

        exClassificationEquals(bzGetPrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetPrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.TARGETERROR, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetPrateBean.getPrate(), null, "Ｐレート");
        exBizCalcbleEquals(bzGetPrateBean.getPsRate(), null, "Ｐ建Ｓレート");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BzGetPrate2 bzGetPrate2 = SWAKInjector.getInstance(BzGetPrate2.class);

        BzGetPrateBean bzGetPrateBean = bzGetPrate2.exec(
            "ﾕﾉ",
            "0",
            BizNumber.valueOf(0.005),
            C_Hrkkaisuu.ITIJI,
            C_Hhknsei.MALE,
            10,
            C_HknkknsmnKbn.NENMANKI,
            15,
            20,
            C_Kykjyoutai.HRKMTYUU,
            C_Tuukasyu.JPY,
            2,
            C_RyourituKbn.DANTAI_B);

        exClassificationEquals(bzGetPrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetPrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetPrateBean.getPrate(), BizNumber.valueOf(323.456789), "Ｐレート");
        exBizCalcbleEquals(bzGetPrateBean.getPsRate(), BizNumber.valueOf(423.456789), "Ｐ建Ｓレート");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BzGetPrate2 bzGetPrate2 = SWAKInjector.getInstance(BzGetPrate2.class);

        BzGetPrateBean bzGetPrateBean = bzGetPrate2.exec(
            "ﾕｹ",
            "L",
            BizNumber.valueOf(0.005),
            C_Hrkkaisuu.ITIJI,
            C_Hhknsei.MALE,
            10,
            C_HknkknsmnKbn.NENMANKI,
            15,
            20,
            C_Kykjyoutai.HRKMTYUU,
            C_Tuukasyu.JPY,
            2,
            C_RyourituKbn.DANTAI_B);

        exClassificationEquals(bzGetPrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetPrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetPrateBean.getPrate(), BizNumber.valueOf(123.456789), "Ｐレート");
        exBizCalcbleEquals(bzGetPrateBean.getPsRate(), BizNumber.valueOf(223.456789), "Ｐ建Ｓレート");
    }

}
