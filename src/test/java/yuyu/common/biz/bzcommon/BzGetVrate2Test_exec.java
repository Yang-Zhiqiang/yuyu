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
import yuyu.def.classification.C_RateGetErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_VRateGetKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BzGetVrate2クラスのメソッド {@link BzGetVrate2#exec(String, String, BizNumber, C_Hrkkaisuu, C_Hhknsei, int, C_HknkknsmnKbn, int, int, C_Kykjyoutai, C_Tuukasyu, int, C_VRateGetKbn, int)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetVrate2Test_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_Ｖレート取得２";

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
        bizDomManager.delete(bizDomManager.getAllRateV2());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BzGetVrate2 bzGetVrate2 = SWAKInjector.getInstance(BzGetVrate2.class);

        BzGetVrateBean bzGetVrateBean = bzGetVrate2.exec(
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
            C_VRateGetKbn.ONEYEAR,
            3);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetVrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(0), BizNumber.valueOf(4), "Ｖレート[0]");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BzGetVrate2 bzGetVrate2 = SWAKInjector.getInstance(BzGetVrate2.class);

        BzGetVrateBean bzGetVrateBean = bzGetVrate2.exec(
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
            C_VRateGetKbn.ONEYEAR,
            3);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetVrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(0), BizNumber.valueOf(5), "Ｖレート[0]");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BzGetVrate2 bzGetVrate2 = SWAKInjector.getInstance(BzGetVrate2.class);

        BzGetVrateBean bzGetVrateBean = bzGetVrate2.exec(
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
            C_VRateGetKbn.ONEYEAR,
            3);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetVrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(0), BizNumber.valueOf(6), "Ｖレート[0]");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BzGetVrate2 bzGetVrate2 = SWAKInjector.getInstance(BzGetVrate2.class);

        BzGetVrateBean bzGetVrateBean = bzGetVrate2.exec(
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
            C_VRateGetKbn.ONEYEAR,
            -1);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetVrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");
        assertNull("Ｖレート", bzGetVrateBean.getVrate());
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BzGetVrate2 bzGetVrate2 = SWAKInjector.getInstance(BzGetVrate2.class);

        BzGetVrateBean bzGetVrateBean = bzGetVrate2.exec(
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
            C_VRateGetKbn.ONEYEAR,
            1);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetVrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");
        assertNull("Ｖレート", bzGetVrateBean.getVrate());
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BzGetVrate2 bzGetVrate2 = SWAKInjector.getInstance(BzGetVrate2.class);

        BzGetVrateBean bzGetVrateBean = bzGetVrate2.exec(
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
            C_VRateGetKbn.TWOYEARS,
            99);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetVrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");
        assertNull("Ｖレート", bzGetVrateBean.getVrate());
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BzGetVrate2 bzGetVrate2 = SWAKInjector.getInstance(BzGetVrate2.class);

        BzGetVrateBean bzGetVrateBean = bzGetVrate2.exec(
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
            C_VRateGetKbn.TWOYEARS,
            0);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetVrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(0), BizNumber.valueOf(1), "Ｖレート[0]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(1), BizNumber.valueOf(2), "Ｖレート[1]");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        BzGetVrate2 bzGetVrate2 = SWAKInjector.getInstance(BzGetVrate2.class);

        BzGetVrateBean bzGetVrateBean = bzGetVrate2.exec(
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
            C_VRateGetKbn.TWOYEARS,
            98);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetVrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(0), BizNumber.valueOf(0), "Ｖレート[0]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(1), BizNumber.valueOf(100), "Ｖレート[1]");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        BzGetVrate2 bzGetVrate2 = SWAKInjector.getInstance(BzGetVrate2.class);

        BzGetVrateBean bzGetVrateBean = bzGetVrate2.exec(
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
            C_VRateGetKbn.ONEYEAR,
            99);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetVrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(0), BizNumber.valueOf(100), "Ｖレート[0]");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        BzGetVrate2 bzGetVrate2 = SWAKInjector.getInstance(BzGetVrate2.class);

        BzGetVrateBean bzGetVrateBean = bzGetVrate2.exec(
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
            C_VRateGetKbn.ALL,
            3);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetVrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(0), BizNumber.valueOf(1), "Ｖレート[0]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(1), BizNumber.valueOf(2), "Ｖレート[1]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(2), BizNumber.valueOf(3), "Ｖレート[2]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(3), BizNumber.valueOf(4), "Ｖレート[3]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(4), BizNumber.valueOf(5), "Ｖレート[4]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(5), BizNumber.valueOf(6), "Ｖレート[5]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(6), BizNumber.valueOf(7), "Ｖレート[6]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(7), BizNumber.valueOf(8), "Ｖレート[7]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(8), BizNumber.valueOf(9), "Ｖレート[8]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(9), BizNumber.valueOf(10), "Ｖレート[9]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(10), BizNumber.valueOf(11), "Ｖレート[10]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(11), BizNumber.valueOf(12), "Ｖレート[11]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(12), BizNumber.valueOf(13), "Ｖレート[12]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(13), BizNumber.valueOf(14), "Ｖレート[13]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(14), BizNumber.valueOf(15), "Ｖレート[14]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(15), BizNumber.valueOf(16), "Ｖレート[15]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(16), BizNumber.valueOf(17), "Ｖレート[16]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(17), BizNumber.valueOf(18), "Ｖレート[17]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(18), BizNumber.valueOf(19), "Ｖレート[18]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(19), BizNumber.valueOf(20), "Ｖレート[19]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(20), BizNumber.valueOf(21), "Ｖレート[20]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(21), BizNumber.valueOf(22), "Ｖレート[21]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(22), BizNumber.valueOf(23), "Ｖレート[22]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(23), BizNumber.valueOf(24), "Ｖレート[23]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(24), BizNumber.valueOf(25), "Ｖレート[24]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(25), BizNumber.valueOf(26), "Ｖレート[25]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(26), BizNumber.valueOf(27), "Ｖレート[26]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(27), BizNumber.valueOf(28), "Ｖレート[27]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(28), BizNumber.valueOf(29), "Ｖレート[28]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(29), BizNumber.valueOf(30), "Ｖレート[29]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(30), BizNumber.valueOf(31), "Ｖレート[30]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(31), BizNumber.valueOf(32), "Ｖレート[31]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(32), BizNumber.valueOf(33), "Ｖレート[32]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(33), BizNumber.valueOf(34), "Ｖレート[33]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(34), BizNumber.valueOf(35), "Ｖレート[34]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(35), BizNumber.valueOf(36), "Ｖレート[35]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(36), BizNumber.valueOf(37), "Ｖレート[36]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(37), BizNumber.valueOf(38), "Ｖレート[37]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(38), BizNumber.valueOf(39), "Ｖレート[38]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(39), BizNumber.valueOf(40), "Ｖレート[39]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(40), BizNumber.valueOf(41), "Ｖレート[40]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(41), BizNumber.valueOf(42), "Ｖレート[41]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(42), BizNumber.valueOf(43), "Ｖレート[42]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(43), BizNumber.valueOf(44), "Ｖレート[43]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(44), BizNumber.valueOf(45), "Ｖレート[44]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(45), BizNumber.valueOf(46), "Ｖレート[45]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(46), BizNumber.valueOf(47), "Ｖレート[46]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(47), BizNumber.valueOf(48), "Ｖレート[47]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(48), BizNumber.valueOf(49), "Ｖレート[48]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(49), BizNumber.valueOf(50), "Ｖレート[49]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(50), BizNumber.valueOf(51), "Ｖレート[50]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(51), BizNumber.valueOf(52), "Ｖレート[51]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(52), BizNumber.valueOf(53), "Ｖレート[52]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(53), BizNumber.valueOf(54), "Ｖレート[53]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(54), BizNumber.valueOf(55), "Ｖレート[54]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(55), BizNumber.valueOf(56), "Ｖレート[55]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(56), BizNumber.valueOf(57), "Ｖレート[56]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(57), BizNumber.valueOf(58), "Ｖレート[57]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(58), BizNumber.valueOf(59), "Ｖレート[58]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(59), BizNumber.valueOf(60), "Ｖレート[59]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(60), BizNumber.valueOf(61), "Ｖレート[60]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(61), BizNumber.valueOf(62), "Ｖレート[61]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(62), BizNumber.valueOf(63), "Ｖレート[62]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(63), BizNumber.valueOf(64), "Ｖレート[63]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(64), BizNumber.valueOf(65), "Ｖレート[64]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(65), BizNumber.valueOf(66), "Ｖレート[65]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(66), BizNumber.valueOf(67), "Ｖレート[66]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(67), BizNumber.valueOf(68), "Ｖレート[67]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(68), BizNumber.valueOf(69), "Ｖレート[68]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(69), BizNumber.valueOf(70), "Ｖレート[69]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(70), BizNumber.valueOf(71), "Ｖレート[70]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(71), BizNumber.valueOf(72), "Ｖレート[71]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(72), BizNumber.valueOf(73), "Ｖレート[72]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(73), BizNumber.valueOf(74), "Ｖレート[73]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(74), BizNumber.valueOf(75), "Ｖレート[74]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(75), BizNumber.valueOf(76), "Ｖレート[75]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(76), BizNumber.valueOf(77), "Ｖレート[76]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(77), BizNumber.valueOf(78), "Ｖレート[77]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(78), BizNumber.valueOf(79), "Ｖレート[78]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(79), BizNumber.valueOf(80), "Ｖレート[79]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(80), BizNumber.valueOf(81), "Ｖレート[80]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(81), BizNumber.valueOf(82), "Ｖレート[81]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(82), BizNumber.valueOf(83), "Ｖレート[82]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(83), BizNumber.valueOf(84), "Ｖレート[83]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(84), BizNumber.valueOf(85), "Ｖレート[84]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(85), BizNumber.valueOf(86), "Ｖレート[85]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(86), BizNumber.valueOf(87), "Ｖレート[86]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(87), BizNumber.valueOf(88), "Ｖレート[87]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(88), BizNumber.valueOf(89), "Ｖレート[88]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(89), BizNumber.valueOf(90), "Ｖレート[89]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(90), BizNumber.valueOf(91), "Ｖレート[90]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(91), BizNumber.valueOf(92), "Ｖレート[91]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(92), BizNumber.valueOf(93), "Ｖレート[92]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(93), BizNumber.valueOf(94), "Ｖレート[93]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(94), BizNumber.valueOf(95), "Ｖレート[94]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(95), BizNumber.valueOf(96), "Ｖレート[95]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(96), BizNumber.valueOf(97), "Ｖレート[96]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(97), BizNumber.valueOf(98), "Ｖレート[97]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(98), BizNumber.valueOf(99), "Ｖレート[98]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(99), BizNumber.valueOf(100), "Ｖレート[99]");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        BzGetVrate2 bzGetVrate2 = SWAKInjector.getInstance(BzGetVrate2.class);

        BzGetVrateBean bzGetVrateBean = bzGetVrate2.exec(
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
            C_VRateGetKbn.ALL,
            3);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetVrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.TARGETERROR, "レート取得エラー区分");
        assertNull("Ｖレート", bzGetVrateBean.getVrate());
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        BzGetVrate2 bzGetVrate2 = SWAKInjector.getInstance(BzGetVrate2.class);

        BzGetVrateBean bzGetVrateBean = bzGetVrate2.exec(
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
            C_VRateGetKbn.NONE,
            3);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetVrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exNumericEquals(bzGetVrateBean.getVrate().size(), 0, "Ｖレートの件数");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        BzGetVrate2 bzGetVrate2 = SWAKInjector.getInstance(BzGetVrate2.class);

        BzGetVrateBean bzGetVrateBean = bzGetVrate2.exec(
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
            C_VRateGetKbn.ALL,
            3);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetVrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(0), BizNumber.valueOf(1), "Ｖレート[0]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(1), BizNumber.valueOf(2), "Ｖレート[1]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(2), BizNumber.valueOf(3), "Ｖレート[2]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(3), BizNumber.valueOf(0), "Ｖレート[3]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(4), BizNumber.valueOf(0), "Ｖレート[4]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(5), BizNumber.valueOf(0), "Ｖレート[5]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(6), BizNumber.valueOf(0), "Ｖレート[6]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(7), BizNumber.valueOf(0), "Ｖレート[7]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(8), BizNumber.valueOf(0), "Ｖレート[8]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(9), BizNumber.valueOf(0), "Ｖレート[9]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(10), BizNumber.valueOf(0), "Ｖレート[10]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(11), BizNumber.valueOf(0), "Ｖレート[11]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(12), BizNumber.valueOf(0), "Ｖレート[12]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(13), BizNumber.valueOf(0), "Ｖレート[13]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(14), BizNumber.valueOf(0), "Ｖレート[14]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(15), BizNumber.valueOf(0), "Ｖレート[15]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(16), BizNumber.valueOf(0), "Ｖレート[16]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(17), BizNumber.valueOf(0), "Ｖレート[17]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(18), BizNumber.valueOf(0), "Ｖレート[18]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(19), BizNumber.valueOf(0), "Ｖレート[19]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(20), BizNumber.valueOf(0), "Ｖレート[20]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(21), BizNumber.valueOf(0), "Ｖレート[21]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(22), BizNumber.valueOf(0), "Ｖレート[22]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(23), BizNumber.valueOf(0), "Ｖレート[23]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(24), BizNumber.valueOf(0), "Ｖレート[24]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(25), BizNumber.valueOf(0), "Ｖレート[25]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(26), BizNumber.valueOf(0), "Ｖレート[26]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(27), BizNumber.valueOf(0), "Ｖレート[27]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(28), BizNumber.valueOf(0), "Ｖレート[28]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(29), BizNumber.valueOf(0), "Ｖレート[29]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(30), BizNumber.valueOf(0), "Ｖレート[30]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(31), BizNumber.valueOf(0), "Ｖレート[31]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(32), BizNumber.valueOf(0), "Ｖレート[32]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(33), BizNumber.valueOf(0), "Ｖレート[33]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(34), BizNumber.valueOf(0), "Ｖレート[34]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(35), BizNumber.valueOf(0), "Ｖレート[35]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(36), BizNumber.valueOf(0), "Ｖレート[36]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(37), BizNumber.valueOf(0), "Ｖレート[37]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(38), BizNumber.valueOf(0), "Ｖレート[38]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(39), BizNumber.valueOf(0), "Ｖレート[39]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(40), BizNumber.valueOf(0), "Ｖレート[40]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(41), BizNumber.valueOf(0), "Ｖレート[41]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(42), BizNumber.valueOf(0), "Ｖレート[42]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(43), BizNumber.valueOf(0), "Ｖレート[43]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(44), BizNumber.valueOf(0), "Ｖレート[44]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(45), BizNumber.valueOf(0), "Ｖレート[45]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(46), BizNumber.valueOf(0), "Ｖレート[46]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(47), BizNumber.valueOf(0), "Ｖレート[47]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(48), BizNumber.valueOf(0), "Ｖレート[48]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(49), BizNumber.valueOf(0), "Ｖレート[49]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(50), BizNumber.valueOf(0), "Ｖレート[50]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(51), BizNumber.valueOf(0), "Ｖレート[51]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(52), BizNumber.valueOf(0), "Ｖレート[52]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(53), BizNumber.valueOf(0), "Ｖレート[53]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(54), BizNumber.valueOf(0), "Ｖレート[54]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(55), BizNumber.valueOf(0), "Ｖレート[55]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(56), BizNumber.valueOf(0), "Ｖレート[56]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(57), BizNumber.valueOf(0), "Ｖレート[57]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(58), BizNumber.valueOf(0), "Ｖレート[58]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(59), BizNumber.valueOf(0), "Ｖレート[59]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(60), BizNumber.valueOf(0), "Ｖレート[60]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(61), BizNumber.valueOf(0), "Ｖレート[61]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(62), BizNumber.valueOf(0), "Ｖレート[62]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(63), BizNumber.valueOf(0), "Ｖレート[63]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(64), BizNumber.valueOf(0), "Ｖレート[64]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(65), BizNumber.valueOf(0), "Ｖレート[65]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(66), BizNumber.valueOf(0), "Ｖレート[66]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(67), BizNumber.valueOf(0), "Ｖレート[67]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(68), BizNumber.valueOf(0), "Ｖレート[68]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(69), BizNumber.valueOf(0), "Ｖレート[69]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(70), BizNumber.valueOf(0), "Ｖレート[70]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(71), BizNumber.valueOf(0), "Ｖレート[71]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(72), BizNumber.valueOf(0), "Ｖレート[72]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(73), BizNumber.valueOf(0), "Ｖレート[73]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(74), BizNumber.valueOf(0), "Ｖレート[74]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(75), BizNumber.valueOf(0), "Ｖレート[75]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(76), BizNumber.valueOf(0), "Ｖレート[76]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(77), BizNumber.valueOf(0), "Ｖレート[77]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(78), BizNumber.valueOf(0), "Ｖレート[78]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(79), BizNumber.valueOf(0), "Ｖレート[79]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(80), BizNumber.valueOf(0), "Ｖレート[80]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(81), BizNumber.valueOf(0), "Ｖレート[81]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(82), BizNumber.valueOf(0), "Ｖレート[82]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(83), BizNumber.valueOf(0), "Ｖレート[83]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(84), BizNumber.valueOf(0), "Ｖレート[84]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(85), BizNumber.valueOf(0), "Ｖレート[85]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(86), BizNumber.valueOf(0), "Ｖレート[86]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(87), BizNumber.valueOf(0), "Ｖレート[87]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(88), BizNumber.valueOf(0), "Ｖレート[88]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(89), BizNumber.valueOf(0), "Ｖレート[89]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(90), BizNumber.valueOf(0), "Ｖレート[90]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(91), BizNumber.valueOf(0), "Ｖレート[91]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(92), BizNumber.valueOf(0), "Ｖレート[92]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(93), BizNumber.valueOf(0), "Ｖレート[93]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(94), BizNumber.valueOf(0), "Ｖレート[94]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(95), BizNumber.valueOf(0), "Ｖレート[95]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(96), BizNumber.valueOf(0), "Ｖレート[96]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(97), BizNumber.valueOf(0), "Ｖレート[97]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(98), BizNumber.valueOf(0), "Ｖレート[98]");
        exBizCalcbleEquals(bzGetVrateBean.getVrate().get(99), BizNumber.valueOf(0), "Ｖレート[99]");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        BzGetVrate2 bzGetVrate2 = SWAKInjector.getInstance(BzGetVrate2.class);

        BzGetVrateBean bzGetVrateBean = bzGetVrate2.exec(
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
            C_VRateGetKbn.ONEYEAR,
            100);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetVrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");
        assertNull("Ｖレート", bzGetVrateBean.getVrate());
    }
}
