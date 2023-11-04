package yuyu.common.biz.bzcommon;

import static org.junit.Assert.*;
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
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_RateGetErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_DRateGetKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BzGetDrate2クラスのメソッド {@link BzGetDrate2#exec(String, String, BizNumber, C_Hrkkaisuu, C_Hhknsei, int, C_HknkknsmnKbn, int, int, C_Kykjyoutai, C_Tuukasyu, int, String, C_NaiteiKakuteiKbn, C_DRateGetKbn, int)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetDrate2Test_exec {

    private final static String fileName = "UT_SP_単体テスト仕様書（共通）_Ｄレート取得２";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetDrate2Test_exec.class, fileName, sheetName);
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
        bizDomManager.delete(bizDomManager.getAllRateD());
        bizDomManager.delete(bizDomManager.getAllRisaHitSyouhnyouRateD2());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BzGetDrate2 bzGetDrate2 = SWAKInjector.getInstance(BzGetDrate2.class);

        BzGetDrateBean bzGetDrateBean = bzGetDrate2.exec(
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
            "2020",
            C_NaiteiKakuteiKbn.NAITEI,
            C_DRateGetKbn.ONEYEAR,
            1);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetDrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetDrateBean.getDrate().get(0), BizNumber.valueOf(1.11), "Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getShisaDrate().get(0), BizNumber.valueOf(0), "死差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getRisaDrate().get(0), BizNumber.valueOf(1.11), "利差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getHisaDrate().get(0), BizNumber.valueOf(0), "費差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getDyouVrate().get(0), BizNumber.valueOf(2.11), "Ｄ用Ｖレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getKikenSrate().get(0), BizNumber.valueOf(0), "危険Ｓレート[0]");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BzGetDrate2 bzGetDrate2 = SWAKInjector.getInstance(BzGetDrate2.class);

        BzGetDrateBean bzGetDrateBean = bzGetDrate2.exec(
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
            "2021",
            C_NaiteiKakuteiKbn.NAITEI,
            C_DRateGetKbn.ONEYEAR,
            1);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetDrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetDrateBean.getDrate().get(0), BizNumber.valueOf(1.22), "Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getShisaDrate().get(0), BizNumber.valueOf(0), "死差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getRisaDrate().get(0), BizNumber.valueOf(1.22), "利差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getHisaDrate().get(0), BizNumber.valueOf(0), "費差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getDyouVrate().get(0), BizNumber.valueOf(2.22), "Ｄ用Ｖレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getKikenSrate().get(0), BizNumber.valueOf(0), "危険Ｓレート[0]");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BzGetDrate2 bzGetDrate2 = SWAKInjector.getInstance(BzGetDrate2.class);

        BzGetDrateBean bzGetDrateBean = bzGetDrate2.exec(
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
            "2021",
            C_NaiteiKakuteiKbn.NAITEI,
            C_DRateGetKbn.ONEYEAR,
            1);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetDrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetDrateBean.getDrate().get(0), BizNumber.valueOf(1.33), "Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getShisaDrate().get(0), BizNumber.valueOf(0), "死差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getRisaDrate().get(0), BizNumber.valueOf(1.33), "利差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getHisaDrate().get(0), BizNumber.valueOf(0), "費差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getDyouVrate().get(0), BizNumber.valueOf(2.33), "Ｄ用Ｖレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getKikenSrate().get(0), BizNumber.valueOf(0), "危険Ｓレート[0]");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BzGetDrate2 bzGetDrate2 = SWAKInjector.getInstance(BzGetDrate2.class);

        BzGetDrateBean bzGetDrateBean = bzGetDrate2.exec(
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
            "2021",
            C_NaiteiKakuteiKbn.NAITEI,
            C_DRateGetKbn.ONEYEAR,
            -1);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetDrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");
        assertNull("Ｄレート", bzGetDrateBean.getDrate());
        assertNull("死差Ｄレート", bzGetDrateBean.getShisaDrate());
        assertNull("利差Ｄレート", bzGetDrateBean.getRisaDrate());
        assertNull("費差Ｄレート", bzGetDrateBean.getHisaDrate());
        assertNull("Ｄ用Ｖレート", bzGetDrateBean.getDyouVrate());
        assertNull("危険Ｓレート", bzGetDrateBean.getKikenSrate());
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BzGetDrate2 bzGetDrate2 = SWAKInjector.getInstance(BzGetDrate2.class);

        BzGetDrateBean bzGetDrateBean = bzGetDrate2.exec(
            "ﾕｲ",
            "0",
            BizNumber.valueOf(0.005),
            C_Hrkkaisuu.ITIJI,
            C_Hhknsei.MALE,
            10,
            C_HknkknsmnKbn.NENMANKI,
            0,
            20,
            C_Kykjyoutai.HRKMTYUU,
            C_Tuukasyu.JPY,
            2,
            "2021",
            C_NaiteiKakuteiKbn.NAITEI,
            C_DRateGetKbn.ONEYEAR,
            1);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetDrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");
        assertNull("Ｄレート", bzGetDrateBean.getDrate());
        assertNull("死差Ｄレート", bzGetDrateBean.getShisaDrate());
        assertNull("利差Ｄレート", bzGetDrateBean.getRisaDrate());
        assertNull("費差Ｄレート", bzGetDrateBean.getHisaDrate());
        assertNull("Ｄ用Ｖレート", bzGetDrateBean.getDyouVrate());
        assertNull("危険Ｓレート", bzGetDrateBean.getKikenSrate());
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BzGetDrate2 bzGetDrate2 = SWAKInjector.getInstance(BzGetDrate2.class);

        BzGetDrateBean bzGetDrateBean = bzGetDrate2.exec(
            "ﾕｲ",
            "0",
            BizNumber.valueOf(0.005),
            C_Hrkkaisuu.ITIJI,
            C_Hhknsei.MALE,
            10,
            C_HknkknsmnKbn.SAIMANKI,
            98,
            20,
            C_Kykjyoutai.HRKMTYUU,
            C_Tuukasyu.JPY,
            2,
            "2021",
            C_NaiteiKakuteiKbn.NAITEI,
            C_DRateGetKbn.TWOYEARS,
            99);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetDrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");
        assertNull("Ｄレート", bzGetDrateBean.getDrate());
        assertNull("死差Ｄレート", bzGetDrateBean.getShisaDrate());
        assertNull("利差Ｄレート", bzGetDrateBean.getRisaDrate());
        assertNull("費差Ｄレート", bzGetDrateBean.getHisaDrate());
        assertNull("Ｄ用Ｖレート", bzGetDrateBean.getDyouVrate());
        assertNull("危険Ｓレート", bzGetDrateBean.getKikenSrate());
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BzGetDrate2 bzGetDrate2 = SWAKInjector.getInstance(BzGetDrate2.class);

        BzGetDrateBean bzGetDrateBean = bzGetDrate2.exec(
            "ﾕﾉ",
            "0",
            BizNumber.valueOf(0.005),
            C_Hrkkaisuu.ITIJI,
            C_Hhknsei.MALE,
            10,
            C_HknkknsmnKbn.NENMANKI,
            0,
            20,
            C_Kykjyoutai.HRKMTYUU,
            C_Tuukasyu.JPY,
            2,
            "2021",
            C_NaiteiKakuteiKbn.NAITEI,
            C_DRateGetKbn.TWOYEARS,
            0);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetDrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetDrateBean.getDrate().get(0), BizNumber.valueOf(1.1), "Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getDrate().get(1), BizNumber.valueOf(1.2), "Ｄレート[1]");
        exBizCalcbleEquals(bzGetDrateBean.getShisaDrate().get(0), BizNumber.valueOf(0), "死差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getShisaDrate().get(1), BizNumber.valueOf(0), "死差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getRisaDrate().get(0), BizNumber.valueOf(1.1), "利差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getRisaDrate().get(1), BizNumber.valueOf(1.2), "利差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getHisaDrate().get(0), BizNumber.valueOf(0), "費差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getHisaDrate().get(1), BizNumber.valueOf(0), "費差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getDyouVrate().get(0), BizNumber.valueOf(1), "Ｄ用Ｖレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getDyouVrate().get(1), BizNumber.valueOf(2), "Ｄ用Ｖレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getKikenSrate().get(0), BizNumber.valueOf(0), "危険Ｓレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getKikenSrate().get(1), BizNumber.valueOf(0), "危険Ｓレート[0]");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        BzGetDrate2 bzGetDrate2 = SWAKInjector.getInstance(BzGetDrate2.class);

        BzGetDrateBean bzGetDrateBean = bzGetDrate2.exec(
            "ﾕﾉ",
            "0",
            BizNumber.valueOf(0.005),
            C_Hrkkaisuu.ITIJI,
            C_Hhknsei.MALE,
            10,
            C_HknkknsmnKbn.NENMANKI,
            99,
            20,
            C_Kykjyoutai.HRKMTYUU,
            C_Tuukasyu.JPY,
            2,
            "2021",
            C_NaiteiKakuteiKbn.NAITEI,
            C_DRateGetKbn.TWOYEARS,
            98);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetDrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetDrateBean.getDrate().get(0), BizNumber.valueOf(0), "Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getDrate().get(1), BizNumber.valueOf(2), "Ｄレート[1]");
        exBizCalcbleEquals(bzGetDrateBean.getShisaDrate().get(0), BizNumber.valueOf(0), "死差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getShisaDrate().get(1), BizNumber.valueOf(0), "死差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getRisaDrate().get(0), BizNumber.valueOf(0), "利差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getRisaDrate().get(1), BizNumber.valueOf(2), "利差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getHisaDrate().get(0), BizNumber.valueOf(0), "費差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getHisaDrate().get(1), BizNumber.valueOf(0), "費差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getDyouVrate().get(0), BizNumber.valueOf(0), "Ｄ用Ｖレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getDyouVrate().get(1), BizNumber.valueOf(100), "Ｄ用Ｖレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getKikenSrate().get(0), BizNumber.valueOf(0), "危険Ｓレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getKikenSrate().get(1), BizNumber.valueOf(0), "危険Ｓレート[0]");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        BzGetDrate2 bzGetDrate2 = SWAKInjector.getInstance(BzGetDrate2.class);

        BzGetDrateBean bzGetDrateBean = bzGetDrate2.exec(
            "ﾕﾉ",
            "0",
            BizNumber.valueOf(0.005),
            C_Hrkkaisuu.ITIJI,
            C_Hhknsei.MALE,
            10,
            C_HknkknsmnKbn.SAIMANKI,
            98,
            20,
            C_Kykjyoutai.HRKMTYUU,
            C_Tuukasyu.JPY,
            2,
            "2021",
            C_NaiteiKakuteiKbn.NAITEI,
            C_DRateGetKbn.ONEYEAR,
            99);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetDrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetDrateBean.getDrate().get(0), BizNumber.valueOf(2), "Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getShisaDrate().get(0), BizNumber.valueOf(0), "死差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getRisaDrate().get(0), BizNumber.valueOf(2), "利差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getHisaDrate().get(0), BizNumber.valueOf(0), "費差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getDyouVrate().get(0), BizNumber.valueOf(100), "Ｄ用Ｖレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getKikenSrate().get(0), BizNumber.valueOf(0), "危険Ｓレート[0]");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        BzGetDrate2 bzGetDrate2 = SWAKInjector.getInstance(BzGetDrate2.class);

        BzGetDrateBean bzGetDrateBean = bzGetDrate2.exec(
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
            "2021",
            C_NaiteiKakuteiKbn.NAITEI,
            C_DRateGetKbn.ALL,
            3);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetDrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        assertEquals("Ｄレート", BizNumber.valueOf(111.111111), bzGetDrateBean.getDrate().get(0));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111112), bzGetDrateBean.getDrate().get(1));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111113), bzGetDrateBean.getDrate().get(2));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111114), bzGetDrateBean.getDrate().get(3));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111115), bzGetDrateBean.getDrate().get(4));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111116), bzGetDrateBean.getDrate().get(5));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111117), bzGetDrateBean.getDrate().get(6));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111118), bzGetDrateBean.getDrate().get(7));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111119), bzGetDrateBean.getDrate().get(8));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111120), bzGetDrateBean.getDrate().get(9));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111121), bzGetDrateBean.getDrate().get(10));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111122), bzGetDrateBean.getDrate().get(11));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111123), bzGetDrateBean.getDrate().get(12));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111124), bzGetDrateBean.getDrate().get(13));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111125), bzGetDrateBean.getDrate().get(14));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111126), bzGetDrateBean.getDrate().get(15));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111127), bzGetDrateBean.getDrate().get(16));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111128), bzGetDrateBean.getDrate().get(17));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111129), bzGetDrateBean.getDrate().get(18));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111130), bzGetDrateBean.getDrate().get(19));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111131), bzGetDrateBean.getDrate().get(20));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111132), bzGetDrateBean.getDrate().get(21));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111133), bzGetDrateBean.getDrate().get(22));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111134), bzGetDrateBean.getDrate().get(23));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111135), bzGetDrateBean.getDrate().get(24));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111136), bzGetDrateBean.getDrate().get(25));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111137), bzGetDrateBean.getDrate().get(26));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111138), bzGetDrateBean.getDrate().get(27));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111139), bzGetDrateBean.getDrate().get(28));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111140), bzGetDrateBean.getDrate().get(29));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111141), bzGetDrateBean.getDrate().get(30));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111142), bzGetDrateBean.getDrate().get(31));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111143), bzGetDrateBean.getDrate().get(32));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111144), bzGetDrateBean.getDrate().get(33));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111145), bzGetDrateBean.getDrate().get(34));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111146), bzGetDrateBean.getDrate().get(35));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111147), bzGetDrateBean.getDrate().get(36));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111148), bzGetDrateBean.getDrate().get(37));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111149), bzGetDrateBean.getDrate().get(38));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111150), bzGetDrateBean.getDrate().get(39));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111151), bzGetDrateBean.getDrate().get(40));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111152), bzGetDrateBean.getDrate().get(41));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111153), bzGetDrateBean.getDrate().get(42));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111154), bzGetDrateBean.getDrate().get(43));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111155), bzGetDrateBean.getDrate().get(44));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111156), bzGetDrateBean.getDrate().get(45));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111157), bzGetDrateBean.getDrate().get(46));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111158), bzGetDrateBean.getDrate().get(47));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111159), bzGetDrateBean.getDrate().get(48));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111160), bzGetDrateBean.getDrate().get(49));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111161), bzGetDrateBean.getDrate().get(50));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111162), bzGetDrateBean.getDrate().get(51));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111163), bzGetDrateBean.getDrate().get(52));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111164), bzGetDrateBean.getDrate().get(53));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111165), bzGetDrateBean.getDrate().get(54));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111166), bzGetDrateBean.getDrate().get(55));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111167), bzGetDrateBean.getDrate().get(56));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111168), bzGetDrateBean.getDrate().get(57));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111169), bzGetDrateBean.getDrate().get(58));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111170), bzGetDrateBean.getDrate().get(59));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111171), bzGetDrateBean.getDrate().get(60));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111172), bzGetDrateBean.getDrate().get(61));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111173), bzGetDrateBean.getDrate().get(62));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111174), bzGetDrateBean.getDrate().get(63));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111175), bzGetDrateBean.getDrate().get(64));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111176), bzGetDrateBean.getDrate().get(65));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111177), bzGetDrateBean.getDrate().get(66));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111178), bzGetDrateBean.getDrate().get(67));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111179), bzGetDrateBean.getDrate().get(68));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111180), bzGetDrateBean.getDrate().get(69));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111181), bzGetDrateBean.getDrate().get(70));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111182), bzGetDrateBean.getDrate().get(71));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111183), bzGetDrateBean.getDrate().get(72));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111184), bzGetDrateBean.getDrate().get(73));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111185), bzGetDrateBean.getDrate().get(74));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111186), bzGetDrateBean.getDrate().get(75));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111187), bzGetDrateBean.getDrate().get(76));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111188), bzGetDrateBean.getDrate().get(77));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111189), bzGetDrateBean.getDrate().get(78));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111190), bzGetDrateBean.getDrate().get(79));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111191), bzGetDrateBean.getDrate().get(80));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111192), bzGetDrateBean.getDrate().get(81));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111193), bzGetDrateBean.getDrate().get(82));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111194), bzGetDrateBean.getDrate().get(83));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111195), bzGetDrateBean.getDrate().get(84));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111196), bzGetDrateBean.getDrate().get(85));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111197), bzGetDrateBean.getDrate().get(86));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111198), bzGetDrateBean.getDrate().get(87));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111199), bzGetDrateBean.getDrate().get(88));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111200), bzGetDrateBean.getDrate().get(89));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111201), bzGetDrateBean.getDrate().get(90));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111202), bzGetDrateBean.getDrate().get(91));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111203), bzGetDrateBean.getDrate().get(92));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111204), bzGetDrateBean.getDrate().get(93));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111205), bzGetDrateBean.getDrate().get(94));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111206), bzGetDrateBean.getDrate().get(95));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111207), bzGetDrateBean.getDrate().get(96));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111208), bzGetDrateBean.getDrate().get(97));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111209), bzGetDrateBean.getDrate().get(98));
        assertEquals("Ｄレート", BizNumber.valueOf(111.111210), bzGetDrateBean.getDrate().get(99));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(0));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(1));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(2));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(3));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(4));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(5));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(6));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(7));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(8));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(9));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(10));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(11));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(12));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(13));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(14));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(15));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(16));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(17));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(18));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(19));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(20));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(21));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(22));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(23));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(24));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(25));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(26));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(27));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(28));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(29));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(30));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(31));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(32));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(33));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(34));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(35));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(36));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(37));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(38));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(39));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(40));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(41));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(42));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(43));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(44));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(45));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(46));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(47));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(48));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(49));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(50));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(51));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(52));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(53));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(54));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(55));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(56));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(57));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(58));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(59));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(60));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(61));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(62));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(63));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(64));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(65));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(66));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(67));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(68));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(69));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(70));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(71));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(72));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(73));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(74));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(75));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(76));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(77));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(78));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(79));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(80));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(81));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(82));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(83));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(84));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(85));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(86));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(87));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(88));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(89));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(90));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(91));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(92));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(93));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(94));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(95));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(96));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(97));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(98));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(99));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111111), bzGetDrateBean.getRisaDrate().get(0));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111112), bzGetDrateBean.getRisaDrate().get(1));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111113), bzGetDrateBean.getRisaDrate().get(2));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111114), bzGetDrateBean.getRisaDrate().get(3));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111115), bzGetDrateBean.getRisaDrate().get(4));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111116), bzGetDrateBean.getRisaDrate().get(5));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111117), bzGetDrateBean.getRisaDrate().get(6));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111118), bzGetDrateBean.getRisaDrate().get(7));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111119), bzGetDrateBean.getRisaDrate().get(8));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111120), bzGetDrateBean.getRisaDrate().get(9));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111121), bzGetDrateBean.getRisaDrate().get(10));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111122), bzGetDrateBean.getRisaDrate().get(11));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111123), bzGetDrateBean.getRisaDrate().get(12));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111124), bzGetDrateBean.getRisaDrate().get(13));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111125), bzGetDrateBean.getRisaDrate().get(14));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111126), bzGetDrateBean.getRisaDrate().get(15));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111127), bzGetDrateBean.getRisaDrate().get(16));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111128), bzGetDrateBean.getRisaDrate().get(17));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111129), bzGetDrateBean.getRisaDrate().get(18));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111130), bzGetDrateBean.getRisaDrate().get(19));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111131), bzGetDrateBean.getRisaDrate().get(20));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111132), bzGetDrateBean.getRisaDrate().get(21));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111133), bzGetDrateBean.getRisaDrate().get(22));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111134), bzGetDrateBean.getRisaDrate().get(23));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111135), bzGetDrateBean.getRisaDrate().get(24));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111136), bzGetDrateBean.getRisaDrate().get(25));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111137), bzGetDrateBean.getRisaDrate().get(26));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111138), bzGetDrateBean.getRisaDrate().get(27));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111139), bzGetDrateBean.getRisaDrate().get(28));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111140), bzGetDrateBean.getRisaDrate().get(29));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111141), bzGetDrateBean.getRisaDrate().get(30));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111142), bzGetDrateBean.getRisaDrate().get(31));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111143), bzGetDrateBean.getRisaDrate().get(32));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111144), bzGetDrateBean.getRisaDrate().get(33));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111145), bzGetDrateBean.getRisaDrate().get(34));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111146), bzGetDrateBean.getRisaDrate().get(35));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111147), bzGetDrateBean.getRisaDrate().get(36));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111148), bzGetDrateBean.getRisaDrate().get(37));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111149), bzGetDrateBean.getRisaDrate().get(38));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111150), bzGetDrateBean.getRisaDrate().get(39));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111151), bzGetDrateBean.getRisaDrate().get(40));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111152), bzGetDrateBean.getRisaDrate().get(41));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111153), bzGetDrateBean.getRisaDrate().get(42));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111154), bzGetDrateBean.getRisaDrate().get(43));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111155), bzGetDrateBean.getRisaDrate().get(44));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111156), bzGetDrateBean.getRisaDrate().get(45));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111157), bzGetDrateBean.getRisaDrate().get(46));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111158), bzGetDrateBean.getRisaDrate().get(47));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111159), bzGetDrateBean.getRisaDrate().get(48));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111160), bzGetDrateBean.getRisaDrate().get(49));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111161), bzGetDrateBean.getRisaDrate().get(50));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111162), bzGetDrateBean.getRisaDrate().get(51));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111163), bzGetDrateBean.getRisaDrate().get(52));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111164), bzGetDrateBean.getRisaDrate().get(53));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111165), bzGetDrateBean.getRisaDrate().get(54));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111166), bzGetDrateBean.getRisaDrate().get(55));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111167), bzGetDrateBean.getRisaDrate().get(56));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111168), bzGetDrateBean.getRisaDrate().get(57));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111169), bzGetDrateBean.getRisaDrate().get(58));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111170), bzGetDrateBean.getRisaDrate().get(59));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111171), bzGetDrateBean.getRisaDrate().get(60));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111172), bzGetDrateBean.getRisaDrate().get(61));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111173), bzGetDrateBean.getRisaDrate().get(62));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111174), bzGetDrateBean.getRisaDrate().get(63));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111175), bzGetDrateBean.getRisaDrate().get(64));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111176), bzGetDrateBean.getRisaDrate().get(65));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111177), bzGetDrateBean.getRisaDrate().get(66));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111178), bzGetDrateBean.getRisaDrate().get(67));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111179), bzGetDrateBean.getRisaDrate().get(68));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111180), bzGetDrateBean.getRisaDrate().get(69));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111181), bzGetDrateBean.getRisaDrate().get(70));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111182), bzGetDrateBean.getRisaDrate().get(71));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111183), bzGetDrateBean.getRisaDrate().get(72));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111184), bzGetDrateBean.getRisaDrate().get(73));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111185), bzGetDrateBean.getRisaDrate().get(74));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111186), bzGetDrateBean.getRisaDrate().get(75));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111187), bzGetDrateBean.getRisaDrate().get(76));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111188), bzGetDrateBean.getRisaDrate().get(77));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111189), bzGetDrateBean.getRisaDrate().get(78));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111190), bzGetDrateBean.getRisaDrate().get(79));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111191), bzGetDrateBean.getRisaDrate().get(80));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111192), bzGetDrateBean.getRisaDrate().get(81));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111193), bzGetDrateBean.getRisaDrate().get(82));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111194), bzGetDrateBean.getRisaDrate().get(83));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111195), bzGetDrateBean.getRisaDrate().get(84));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111196), bzGetDrateBean.getRisaDrate().get(85));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111197), bzGetDrateBean.getRisaDrate().get(86));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111198), bzGetDrateBean.getRisaDrate().get(87));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111199), bzGetDrateBean.getRisaDrate().get(88));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111200), bzGetDrateBean.getRisaDrate().get(89));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111201), bzGetDrateBean.getRisaDrate().get(90));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111202), bzGetDrateBean.getRisaDrate().get(91));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111203), bzGetDrateBean.getRisaDrate().get(92));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111204), bzGetDrateBean.getRisaDrate().get(93));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111205), bzGetDrateBean.getRisaDrate().get(94));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111206), bzGetDrateBean.getRisaDrate().get(95));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111207), bzGetDrateBean.getRisaDrate().get(96));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111208), bzGetDrateBean.getRisaDrate().get(97));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111209), bzGetDrateBean.getRisaDrate().get(98));
        assertEquals("利差Ｄレート", BizNumber.valueOf(111.111210), bzGetDrateBean.getRisaDrate().get(99));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(0));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(1));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(2));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(3));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(4));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(5));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(6));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(7));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(8));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(9));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(10));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(11));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(12));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(13));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(14));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(15));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(16));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(17));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(18));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(19));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(20));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(21));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(22));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(23));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(24));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(25));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(26));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(27));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(28));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(29));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(30));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(31));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(32));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(33));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(34));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(35));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(36));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(37));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(38));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(39));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(40));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(41));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(42));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(43));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(44));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(45));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(46));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(47));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(48));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(49));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(50));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(51));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(52));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(53));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(54));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(55));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(56));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(57));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(58));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(59));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(60));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(61));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(62));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(63));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(64));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(65));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(66));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(67));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(68));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(69));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(70));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(71));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(72));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(73));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(74));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(75));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(76));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(77));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(78));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(79));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(80));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(81));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(82));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(83));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(84));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(85));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(86));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(87));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(88));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(89));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(90));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(91));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(92));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(93));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(94));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(95));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(96));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(97));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(98));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(99));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111111), bzGetDrateBean.getDyouVrate().get(0));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111112), bzGetDrateBean.getDyouVrate().get(1));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111113), bzGetDrateBean.getDyouVrate().get(2));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111114), bzGetDrateBean.getDyouVrate().get(3));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111115), bzGetDrateBean.getDyouVrate().get(4));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111116), bzGetDrateBean.getDyouVrate().get(5));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111117), bzGetDrateBean.getDyouVrate().get(6));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111118), bzGetDrateBean.getDyouVrate().get(7));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111119), bzGetDrateBean.getDyouVrate().get(8));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111120), bzGetDrateBean.getDyouVrate().get(9));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111121), bzGetDrateBean.getDyouVrate().get(10));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111122), bzGetDrateBean.getDyouVrate().get(11));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111123), bzGetDrateBean.getDyouVrate().get(12));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111124), bzGetDrateBean.getDyouVrate().get(13));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111125), bzGetDrateBean.getDyouVrate().get(14));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111126), bzGetDrateBean.getDyouVrate().get(15));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111127), bzGetDrateBean.getDyouVrate().get(16));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111128), bzGetDrateBean.getDyouVrate().get(17));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111129), bzGetDrateBean.getDyouVrate().get(18));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111130), bzGetDrateBean.getDyouVrate().get(19));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111131), bzGetDrateBean.getDyouVrate().get(20));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111132), bzGetDrateBean.getDyouVrate().get(21));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111133), bzGetDrateBean.getDyouVrate().get(22));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111134), bzGetDrateBean.getDyouVrate().get(23));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111135), bzGetDrateBean.getDyouVrate().get(24));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111136), bzGetDrateBean.getDyouVrate().get(25));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111137), bzGetDrateBean.getDyouVrate().get(26));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111138), bzGetDrateBean.getDyouVrate().get(27));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111139), bzGetDrateBean.getDyouVrate().get(28));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111140), bzGetDrateBean.getDyouVrate().get(29));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111141), bzGetDrateBean.getDyouVrate().get(30));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111142), bzGetDrateBean.getDyouVrate().get(31));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111143), bzGetDrateBean.getDyouVrate().get(32));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111144), bzGetDrateBean.getDyouVrate().get(33));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111145), bzGetDrateBean.getDyouVrate().get(34));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111146), bzGetDrateBean.getDyouVrate().get(35));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111147), bzGetDrateBean.getDyouVrate().get(36));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111148), bzGetDrateBean.getDyouVrate().get(37));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111149), bzGetDrateBean.getDyouVrate().get(38));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111150), bzGetDrateBean.getDyouVrate().get(39));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111151), bzGetDrateBean.getDyouVrate().get(40));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111152), bzGetDrateBean.getDyouVrate().get(41));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111153), bzGetDrateBean.getDyouVrate().get(42));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111154), bzGetDrateBean.getDyouVrate().get(43));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111155), bzGetDrateBean.getDyouVrate().get(44));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111156), bzGetDrateBean.getDyouVrate().get(45));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111157), bzGetDrateBean.getDyouVrate().get(46));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111158), bzGetDrateBean.getDyouVrate().get(47));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111159), bzGetDrateBean.getDyouVrate().get(48));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111160), bzGetDrateBean.getDyouVrate().get(49));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111161), bzGetDrateBean.getDyouVrate().get(50));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111162), bzGetDrateBean.getDyouVrate().get(51));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111163), bzGetDrateBean.getDyouVrate().get(52));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111164), bzGetDrateBean.getDyouVrate().get(53));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111165), bzGetDrateBean.getDyouVrate().get(54));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111166), bzGetDrateBean.getDyouVrate().get(55));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111167), bzGetDrateBean.getDyouVrate().get(56));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111168), bzGetDrateBean.getDyouVrate().get(57));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111169), bzGetDrateBean.getDyouVrate().get(58));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111170), bzGetDrateBean.getDyouVrate().get(59));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111171), bzGetDrateBean.getDyouVrate().get(60));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111172), bzGetDrateBean.getDyouVrate().get(61));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111173), bzGetDrateBean.getDyouVrate().get(62));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111174), bzGetDrateBean.getDyouVrate().get(63));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111175), bzGetDrateBean.getDyouVrate().get(64));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111176), bzGetDrateBean.getDyouVrate().get(65));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111177), bzGetDrateBean.getDyouVrate().get(66));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111178), bzGetDrateBean.getDyouVrate().get(67));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111179), bzGetDrateBean.getDyouVrate().get(68));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111180), bzGetDrateBean.getDyouVrate().get(69));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111181), bzGetDrateBean.getDyouVrate().get(70));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111182), bzGetDrateBean.getDyouVrate().get(71));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111183), bzGetDrateBean.getDyouVrate().get(72));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111184), bzGetDrateBean.getDyouVrate().get(73));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111185), bzGetDrateBean.getDyouVrate().get(74));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111186), bzGetDrateBean.getDyouVrate().get(75));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111187), bzGetDrateBean.getDyouVrate().get(76));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111188), bzGetDrateBean.getDyouVrate().get(77));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111189), bzGetDrateBean.getDyouVrate().get(78));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111190), bzGetDrateBean.getDyouVrate().get(79));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111191), bzGetDrateBean.getDyouVrate().get(80));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111192), bzGetDrateBean.getDyouVrate().get(81));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111193), bzGetDrateBean.getDyouVrate().get(82));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111194), bzGetDrateBean.getDyouVrate().get(83));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111195), bzGetDrateBean.getDyouVrate().get(84));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111196), bzGetDrateBean.getDyouVrate().get(85));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111197), bzGetDrateBean.getDyouVrate().get(86));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111198), bzGetDrateBean.getDyouVrate().get(87));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111199), bzGetDrateBean.getDyouVrate().get(88));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111200), bzGetDrateBean.getDyouVrate().get(89));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111201), bzGetDrateBean.getDyouVrate().get(90));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111202), bzGetDrateBean.getDyouVrate().get(91));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111203), bzGetDrateBean.getDyouVrate().get(92));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111204), bzGetDrateBean.getDyouVrate().get(93));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111205), bzGetDrateBean.getDyouVrate().get(94));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111206), bzGetDrateBean.getDyouVrate().get(95));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111207), bzGetDrateBean.getDyouVrate().get(96));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111208), bzGetDrateBean.getDyouVrate().get(97));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111209), bzGetDrateBean.getDyouVrate().get(98));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(511.111210), bzGetDrateBean.getDyouVrate().get(99));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(0));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(1));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(2));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(3));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(4));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(5));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(6));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(7));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(8));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(9));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(10));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(11));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(12));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(13));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(14));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(15));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(16));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(17));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(18));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(19));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(20));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(21));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(22));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(23));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(24));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(25));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(26));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(27));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(28));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(29));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(30));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(31));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(32));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(33));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(34));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(35));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(36));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(37));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(38));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(39));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(40));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(41));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(42));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(43));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(44));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(45));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(46));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(47));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(48));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(49));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(50));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(51));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(52));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(53));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(54));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(55));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(56));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(57));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(58));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(59));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(60));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(61));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(62));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(63));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(64));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(65));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(66));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(67));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(68));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(69));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(70));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(71));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(72));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(73));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(74));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(75));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(76));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(77));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(78));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(79));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(80));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(81));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(82));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(83));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(84));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(85));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(86));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(87));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(88));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(89));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(90));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(91));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(92));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(93));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(94));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(95));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(96));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(97));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(98));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(99));
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        BzGetDrate2 bzGetDrate2 = SWAKInjector.getInstance(BzGetDrate2.class);

        BzGetDrateBean bzGetDrateBean = bzGetDrate2.exec(
            "ﾕｲ",
            "0",
            BizNumber.valueOf(0.005),
            C_Hrkkaisuu.ITIJI,
            C_Hhknsei.MALE,
            10,
            C_HknkknsmnKbn.NENMANKI,
            14,
            20,
            C_Kykjyoutai.HRKMTYUU,
            C_Tuukasyu.JPY,
            2,
            "2021",
            C_NaiteiKakuteiKbn.NAITEI,
            C_DRateGetKbn.ALL,
            3);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetDrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.TARGETERROR, "レート取得エラー区分");
        assertNull("Ｄレート", bzGetDrateBean.getDrate());
        assertNull("死差Ｄレート", bzGetDrateBean.getShisaDrate());
        assertNull("利差Ｄレート", bzGetDrateBean.getRisaDrate());
        assertNull("費差Ｄレート", bzGetDrateBean.getHisaDrate());
        assertNull("Ｄ用Ｖレート", bzGetDrateBean.getDyouVrate());
        assertNull("危険Ｓレート", bzGetDrateBean.getKikenSrate());
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        BzGetDrate2 bzGetDrate2 = SWAKInjector.getInstance(BzGetDrate2.class);

        BzGetDrateBean bzGetDrateBean = bzGetDrate2.exec(
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
            "2021",
            C_NaiteiKakuteiKbn.NAITEI,
            C_DRateGetKbn.NONE,
            3);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetDrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exNumericEquals(bzGetDrateBean.getDrate().size(), 0, "Ｄレートの件数");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        BzGetDrate2 bzGetDrate2 = SWAKInjector.getInstance(BzGetDrate2.class);

        BzGetDrateBean bzGetDrateBean = bzGetDrate2.exec(
            "ﾕｲ",
            "0",
            BizNumber.valueOf(0.005),
            C_Hrkkaisuu.ITIJI,
            C_Hhknsei.MALE,
            10,
            C_HknkknsmnKbn.NENMANKI,
            20,
            20,
            C_Kykjyoutai.HRKMTYUU,
            C_Tuukasyu.JPY,
            2,
            "2021",
            C_NaiteiKakuteiKbn.NAITEI,
            C_DRateGetKbn.ALL,
            3);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetDrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        assertEquals("Ｄレート", BizNumber.valueOf(100), bzGetDrateBean.getDrate().get(0));
        assertEquals("Ｄレート", BizNumber.valueOf(101), bzGetDrateBean.getDrate().get(1));
        assertEquals("Ｄレート", BizNumber.valueOf(102), bzGetDrateBean.getDrate().get(2));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(3));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(4));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(5));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(6));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(7));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(8));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(9));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(10));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(11));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(12));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(13));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(14));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(15));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(16));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(17));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(18));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(19));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(20));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(21));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(22));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(23));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(24));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(25));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(26));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(27));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(28));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(29));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(30));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(31));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(32));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(33));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(34));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(35));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(36));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(37));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(38));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(39));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(40));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(41));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(42));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(43));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(44));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(45));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(46));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(47));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(48));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(49));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(50));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(51));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(52));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(53));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(54));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(55));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(56));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(57));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(58));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(59));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(60));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(61));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(62));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(63));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(64));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(65));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(66));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(67));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(68));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(69));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(70));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(71));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(72));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(73));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(74));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(75));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(76));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(77));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(78));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(79));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(80));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(81));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(82));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(83));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(84));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(85));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(86));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(87));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(88));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(89));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(90));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(91));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(92));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(93));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(94));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(95));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(96));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(97));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(98));
        assertEquals("Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(99));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(0));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(1));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(2));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(3));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(4));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(5));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(6));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(7));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(8));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(9));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(10));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(11));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(12));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(13));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(14));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(15));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(16));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(17));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(18));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(19));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(20));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(21));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(22));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(23));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(24));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(25));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(26));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(27));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(28));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(29));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(30));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(31));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(32));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(33));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(34));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(35));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(36));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(37));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(38));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(39));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(40));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(41));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(42));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(43));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(44));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(45));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(46));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(47));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(48));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(49));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(50));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(51));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(52));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(53));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(54));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(55));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(56));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(57));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(58));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(59));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(60));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(61));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(62));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(63));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(64));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(65));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(66));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(67));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(68));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(69));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(70));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(71));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(72));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(73));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(74));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(75));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(76));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(77));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(78));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(79));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(80));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(81));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(82));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(83));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(84));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(85));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(86));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(87));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(88));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(89));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(90));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(91));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(92));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(93));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(94));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(95));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(96));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(97));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(98));
        assertEquals("死差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(99));
        assertEquals("利差Ｄレート", BizNumber.valueOf(100), bzGetDrateBean.getRisaDrate().get(0));
        assertEquals("利差Ｄレート", BizNumber.valueOf(101), bzGetDrateBean.getRisaDrate().get(1));
        assertEquals("利差Ｄレート", BizNumber.valueOf(102), bzGetDrateBean.getRisaDrate().get(2));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(3));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(4));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(5));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(6));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(7));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(8));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(9));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(10));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(11));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(12));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(13));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(14));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(15));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(16));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(17));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(18));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(19));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(20));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(21));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(22));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(23));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(24));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(25));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(26));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(27));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(28));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(29));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(30));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(31));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(32));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(33));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(34));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(35));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(36));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(37));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(38));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(39));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(40));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(41));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(42));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(43));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(44));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(45));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(46));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(47));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(48));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(49));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(50));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(51));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(52));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(53));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(54));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(55));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(56));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(57));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(58));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(59));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(60));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(61));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(62));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(63));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(64));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(65));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(66));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(67));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(68));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(69));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(70));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(71));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(72));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(73));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(74));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(75));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(76));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(77));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(78));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(79));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(80));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(81));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(82));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(83));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(84));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(85));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(86));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(87));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(88));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(89));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(90));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(91));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(92));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(93));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(94));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(95));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(96));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(97));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(98));
        assertEquals("利差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(99));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(0));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(1));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(2));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(3));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(4));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(5));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(6));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(7));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(8));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(9));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(10));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(11));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(12));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(13));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(14));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(15));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(16));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(17));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(18));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(19));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(20));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(21));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(22));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(23));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(24));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(25));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(26));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(27));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(28));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(29));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(30));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(31));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(32));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(33));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(34));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(35));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(36));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(37));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(38));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(39));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(40));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(41));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(42));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(43));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(44));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(45));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(46));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(47));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(48));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(49));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(50));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(51));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(52));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(53));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(54));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(55));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(56));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(57));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(58));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(59));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(60));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(61));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(62));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(63));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(64));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(65));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(66));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(67));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(68));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(69));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(70));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(71));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(72));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(73));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(74));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(75));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(76));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(77));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(78));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(79));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(80));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(81));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(82));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(83));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(84));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(85));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(86));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(87));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(88));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(89));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(90));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(91));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(92));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(93));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(94));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(95));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(96));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(97));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(98));
        assertEquals("費差Ｄレート", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(99));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(201), bzGetDrateBean.getDyouVrate().get(0));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(202), bzGetDrateBean.getDyouVrate().get(1));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(203), bzGetDrateBean.getDyouVrate().get(2));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(3));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(4));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(5));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(6));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(7));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(8));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(9));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(10));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(11));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(12));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(13));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(14));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(15));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(16));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(17));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(18));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(19));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(20));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(21));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(22));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(23));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(24));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(25));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(26));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(27));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(28));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(29));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(30));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(31));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(32));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(33));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(34));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(35));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(36));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(37));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(38));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(39));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(40));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(41));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(42));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(43));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(44));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(45));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(46));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(47));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(48));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(49));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(50));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(51));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(52));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(53));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(54));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(55));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(56));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(57));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(58));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(59));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(60));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(61));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(62));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(63));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(64));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(65));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(66));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(67));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(68));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(69));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(70));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(71));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(72));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(73));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(74));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(75));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(76));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(77));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(78));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(79));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(80));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(81));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(82));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(83));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(84));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(85));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(86));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(87));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(88));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(89));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(90));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(91));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(92));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(93));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(94));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(95));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(96));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(97));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(98));
        assertEquals("Ｄ用Ｖレート", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(99));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(0));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(1));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(2));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(3));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(4));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(5));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(6));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(7));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(8));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(9));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(10));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(11));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(12));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(13));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(14));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(15));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(16));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(17));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(18));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(19));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(20));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(21));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(22));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(23));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(24));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(25));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(26));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(27));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(28));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(29));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(30));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(31));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(32));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(33));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(34));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(35));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(36));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(37));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(38));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(39));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(40));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(41));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(42));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(43));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(44));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(45));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(46));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(47));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(48));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(49));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(50));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(51));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(52));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(53));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(54));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(55));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(56));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(57));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(58));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(59));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(60));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(61));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(62));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(63));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(64));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(65));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(66));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(67));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(68));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(69));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(70));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(71));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(72));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(73));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(74));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(75));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(76));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(77));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(78));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(79));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(80));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(81));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(82));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(83));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(84));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(85));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(86));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(87));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(88));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(89));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(90));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(91));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(92));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(93));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(94));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(95));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(96));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(97));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(98));
        assertEquals("危険Ｓレート", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(99));
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        BzGetDrate2 bzGetDrate2 = SWAKInjector.getInstance(BzGetDrate2.class);

        BzGetDrateBean bzGetDrateBean = bzGetDrate2.exec(
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
            "2021",
            C_NaiteiKakuteiKbn.NAITEI,
            C_DRateGetKbn.ONEYEAR,
            100);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetDrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");
        assertNull("Ｄレート", bzGetDrateBean.getDrate());
        assertNull("死差Ｄレート", bzGetDrateBean.getShisaDrate());
        assertNull("利差Ｄレート", bzGetDrateBean.getRisaDrate());
        assertNull("費差Ｄレート", bzGetDrateBean.getHisaDrate());
        assertNull("Ｄ用Ｖレート", bzGetDrateBean.getDyouVrate());
        assertNull("危険Ｓレート", bzGetDrateBean.getKikenSrate());
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        BzGetDrate2 bzGetDrate2 = SWAKInjector.getInstance(BzGetDrate2.class);

        BzGetDrateBean bzGetDrateBean = bzGetDrate2.exec(
            "ﾕﾉ",
            "L",
            BizNumber.valueOf(0.005),
            C_Hrkkaisuu.ITIJI,
            C_Hhknsei.MALE,
            10,
            C_HknkknsmnKbn.SAIMANKI,
            98,
            20,
            C_Kykjyoutai.HRKMTYUU,
            C_Tuukasyu.JPY,
            2,
            "2022",
            C_NaiteiKakuteiKbn.NAITEI,
            C_DRateGetKbn.ONEYEAR,
            99);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetDrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetDrateBean.getDrate().get(0), BizNumber.valueOf(2), "Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getShisaDrate().get(0), BizNumber.valueOf(0), "死差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getRisaDrate().get(0), BizNumber.valueOf(2), "利差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getHisaDrate().get(0), BizNumber.valueOf(0), "費差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getDyouVrate().get(0), BizNumber.valueOf(100), "Ｄ用Ｖレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getKikenSrate().get(0), BizNumber.valueOf(0), "危険Ｓレート[0]");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        BzGetDrate2 bzGetDrate2 = SWAKInjector.getInstance(BzGetDrate2.class);

        BzGetDrateBean bzGetDrateBean = bzGetDrate2.exec(
            "ﾕﾉ",
            "L",
            BizNumber.valueOf(0.005),
            C_Hrkkaisuu.ITIJI,
            C_Hhknsei.MALE,
            10,
            C_HknkknsmnKbn.SAIMANKI,
            98,
            20,
            C_Kykjyoutai.HRKMTYUU,
            C_Tuukasyu.JPY,
            2,
            "2021",
            C_NaiteiKakuteiKbn.KAKUTEI,
            C_DRateGetKbn.ONEYEAR,
            99);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetDrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetDrateBean.getDrate().get(0), BizNumber.valueOf(2), "Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getShisaDrate().get(0), BizNumber.valueOf(0), "死差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getRisaDrate().get(0), BizNumber.valueOf(2), "利差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getHisaDrate().get(0), BizNumber.valueOf(0), "費差Ｄレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getDyouVrate().get(0), BizNumber.valueOf(100), "Ｄ用Ｖレート[0]");
        exBizCalcbleEquals(bzGetDrateBean.getKikenSrate().get(0), BizNumber.valueOf(0), "危険Ｓレート[0]");
    }
}
