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
import yuyu.def.classification.C_WRateGetKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BzGetWrateクラスのメソッド {@link BzGetWrate#exec(String, String, BizNumber, C_Hrkkaisuu, C_Hhknsei, int, C_HknkknsmnKbn, int, int, C_Kykjyoutai, C_Tuukasyu, int, C_WRateGetKbn, int)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetWrateTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_Ｗレート取得";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetWrateTest_exec.class, fileName, sheetName);
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
        bizDomManager.delete(bizDomManager.getAllRateW());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BzGetWrate bzGetWrate = SWAKInjector.getInstance(BzGetWrate.class);

        BzGetWrateBean bzGetWrateBean = bzGetWrate.exec(
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
            C_WRateGetKbn.ONEYEAR,
            -1);

        exClassificationEquals(bzGetWrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetWrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");
        assertNull("Ｗレート", bzGetWrateBean.getWrate());
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BzGetWrate bzGetWrate = SWAKInjector.getInstance(BzGetWrate.class);

        BzGetWrateBean bzGetWrateBean = bzGetWrate.exec(
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
            C_WRateGetKbn.ONEYEAR,
            100);

        exClassificationEquals(bzGetWrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetWrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");
        assertNull("Ｗレート", bzGetWrateBean.getWrate());
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BzGetWrate bzGetWrate = SWAKInjector.getInstance(BzGetWrate.class);

        BzGetWrateBean bzGetWrateBean = bzGetWrate.exec(
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
            C_WRateGetKbn.ONEYEAR,
            1);

        exClassificationEquals(bzGetWrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetWrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");
        assertNull("Ｗレート", bzGetWrateBean.getWrate());
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BzGetWrate bzGetWrate = SWAKInjector.getInstance(BzGetWrate.class);

        BzGetWrateBean bzGetWrateBean = bzGetWrate.exec(
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
            C_WRateGetKbn.TWOYEARS,
            99);

        exClassificationEquals(bzGetWrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetWrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");
        assertNull("Ｗレート", bzGetWrateBean.getWrate());
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BzGetWrate bzGetWrate = SWAKInjector.getInstance(BzGetWrate.class);

        BzGetWrateBean bzGetWrateBean = bzGetWrate.exec(
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
            C_WRateGetKbn.TWOYEARS,
            0);

        exClassificationEquals(bzGetWrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetWrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(0), BizNumber.valueOf(1), "Ｗレート[0]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(1), BizNumber.valueOf(2), "Ｗレート[1]");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BzGetWrate bzGetWrate = SWAKInjector.getInstance(BzGetWrate.class);

        BzGetWrateBean bzGetWrateBean = bzGetWrate.exec(
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
            C_WRateGetKbn.TWOYEARS,
            98);

        exClassificationEquals(bzGetWrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetWrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(0), BizNumber.valueOf(0), "Ｗレート[0]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(1), BizNumber.valueOf(100), "Ｗレート[1]");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BzGetWrate bzGetWrate = SWAKInjector.getInstance(BzGetWrate.class);

        BzGetWrateBean bzGetWrateBean = bzGetWrate.exec(
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
            C_WRateGetKbn.ONEYEAR,
            99);

        exClassificationEquals(bzGetWrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetWrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(0), BizNumber.valueOf(100), "Ｗレート[0]");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        BzGetWrate bzGetWrate = SWAKInjector.getInstance(BzGetWrate.class);

        BzGetWrateBean bzGetWrateBean = bzGetWrate.exec(
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
            C_WRateGetKbn.ALL,
            3);

        exClassificationEquals(bzGetWrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetWrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(0), BizNumber.valueOf(1), "Ｗレート[0]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(1), BizNumber.valueOf(2), "Ｗレート[1]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(2), BizNumber.valueOf(3), "Ｗレート[2]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(3), BizNumber.valueOf(4), "Ｗレート[3]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(4), BizNumber.valueOf(5), "Ｗレート[4]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(5), BizNumber.valueOf(6), "Ｗレート[5]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(6), BizNumber.valueOf(7), "Ｗレート[6]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(7), BizNumber.valueOf(8), "Ｗレート[7]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(8), BizNumber.valueOf(9), "Ｗレート[8]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(9), BizNumber.valueOf(10), "Ｗレート[9]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(10), BizNumber.valueOf(11), "Ｗレート[10]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(11), BizNumber.valueOf(12), "Ｗレート[11]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(12), BizNumber.valueOf(13), "Ｗレート[12]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(13), BizNumber.valueOf(14), "Ｗレート[13]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(14), BizNumber.valueOf(15), "Ｗレート[14]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(15), BizNumber.valueOf(16), "Ｗレート[15]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(16), BizNumber.valueOf(17), "Ｗレート[16]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(17), BizNumber.valueOf(18), "Ｗレート[17]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(18), BizNumber.valueOf(19), "Ｗレート[18]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(19), BizNumber.valueOf(20), "Ｗレート[19]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(20), BizNumber.valueOf(21), "Ｗレート[20]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(21), BizNumber.valueOf(22), "Ｗレート[21]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(22), BizNumber.valueOf(23), "Ｗレート[22]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(23), BizNumber.valueOf(24), "Ｗレート[23]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(24), BizNumber.valueOf(25), "Ｗレート[24]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(25), BizNumber.valueOf(26), "Ｗレート[25]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(26), BizNumber.valueOf(27), "Ｗレート[26]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(27), BizNumber.valueOf(28), "Ｗレート[27]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(28), BizNumber.valueOf(29), "Ｗレート[28]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(29), BizNumber.valueOf(30), "Ｗレート[29]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(30), BizNumber.valueOf(31), "Ｗレート[30]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(31), BizNumber.valueOf(32), "Ｗレート[31]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(32), BizNumber.valueOf(33), "Ｗレート[32]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(33), BizNumber.valueOf(34), "Ｗレート[33]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(34), BizNumber.valueOf(35), "Ｗレート[34]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(35), BizNumber.valueOf(36), "Ｗレート[35]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(36), BizNumber.valueOf(37), "Ｗレート[36]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(37), BizNumber.valueOf(38), "Ｗレート[37]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(38), BizNumber.valueOf(39), "Ｗレート[38]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(39), BizNumber.valueOf(40), "Ｗレート[39]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(40), BizNumber.valueOf(41), "Ｗレート[40]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(41), BizNumber.valueOf(42), "Ｗレート[41]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(42), BizNumber.valueOf(43), "Ｗレート[42]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(43), BizNumber.valueOf(44), "Ｗレート[43]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(44), BizNumber.valueOf(45), "Ｗレート[44]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(45), BizNumber.valueOf(46), "Ｗレート[45]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(46), BizNumber.valueOf(47), "Ｗレート[46]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(47), BizNumber.valueOf(48), "Ｗレート[47]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(48), BizNumber.valueOf(49), "Ｗレート[48]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(49), BizNumber.valueOf(50), "Ｗレート[49]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(50), BizNumber.valueOf(51), "Ｗレート[50]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(51), BizNumber.valueOf(52), "Ｗレート[51]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(52), BizNumber.valueOf(53), "Ｗレート[52]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(53), BizNumber.valueOf(54), "Ｗレート[53]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(54), BizNumber.valueOf(55), "Ｗレート[54]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(55), BizNumber.valueOf(56), "Ｗレート[55]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(56), BizNumber.valueOf(57), "Ｗレート[56]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(57), BizNumber.valueOf(58), "Ｗレート[57]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(58), BizNumber.valueOf(59), "Ｗレート[58]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(59), BizNumber.valueOf(60), "Ｗレート[59]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(60), BizNumber.valueOf(61), "Ｗレート[60]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(61), BizNumber.valueOf(62), "Ｗレート[61]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(62), BizNumber.valueOf(63), "Ｗレート[62]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(63), BizNumber.valueOf(64), "Ｗレート[63]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(64), BizNumber.valueOf(65), "Ｗレート[64]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(65), BizNumber.valueOf(66), "Ｗレート[65]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(66), BizNumber.valueOf(67), "Ｗレート[66]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(67), BizNumber.valueOf(68), "Ｗレート[67]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(68), BizNumber.valueOf(69), "Ｗレート[68]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(69), BizNumber.valueOf(70), "Ｗレート[69]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(70), BizNumber.valueOf(71), "Ｗレート[70]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(71), BizNumber.valueOf(72), "Ｗレート[71]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(72), BizNumber.valueOf(73), "Ｗレート[72]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(73), BizNumber.valueOf(74), "Ｗレート[73]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(74), BizNumber.valueOf(75), "Ｗレート[74]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(75), BizNumber.valueOf(76), "Ｗレート[75]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(76), BizNumber.valueOf(77), "Ｗレート[76]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(77), BizNumber.valueOf(78), "Ｗレート[77]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(78), BizNumber.valueOf(79), "Ｗレート[78]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(79), BizNumber.valueOf(80), "Ｗレート[79]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(80), BizNumber.valueOf(81), "Ｗレート[80]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(81), BizNumber.valueOf(82), "Ｗレート[81]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(82), BizNumber.valueOf(83), "Ｗレート[82]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(83), BizNumber.valueOf(84), "Ｗレート[83]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(84), BizNumber.valueOf(85), "Ｗレート[84]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(85), BizNumber.valueOf(86), "Ｗレート[85]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(86), BizNumber.valueOf(87), "Ｗレート[86]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(87), BizNumber.valueOf(88), "Ｗレート[87]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(88), BizNumber.valueOf(89), "Ｗレート[88]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(89), BizNumber.valueOf(90), "Ｗレート[89]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(90), BizNumber.valueOf(91), "Ｗレート[90]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(91), BizNumber.valueOf(92), "Ｗレート[91]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(92), BizNumber.valueOf(93), "Ｗレート[92]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(93), BizNumber.valueOf(94), "Ｗレート[93]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(94), BizNumber.valueOf(95), "Ｗレート[94]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(95), BizNumber.valueOf(96), "Ｗレート[95]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(96), BizNumber.valueOf(97), "Ｗレート[96]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(97), BizNumber.valueOf(98), "Ｗレート[97]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(98), BizNumber.valueOf(99), "Ｗレート[98]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(99), BizNumber.valueOf(100), "Ｗレート[99]");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        BzGetWrate bzGetWrate = SWAKInjector.getInstance(BzGetWrate.class);

        BzGetWrateBean bzGetWrateBean = bzGetWrate.exec(
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
            C_WRateGetKbn.ALL,
            3);

        exClassificationEquals(bzGetWrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetWrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.TARGETERROR, "レート取得エラー区分");
        assertNull("Ｗレート", bzGetWrateBean.getWrate());
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        BzGetWrate bzGetWrate = SWAKInjector.getInstance(BzGetWrate.class);

        BzGetWrateBean bzGetWrateBean = bzGetWrate.exec(
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
            C_WRateGetKbn.NONE,
            3);

        exClassificationEquals(bzGetWrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetWrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exNumericEquals(bzGetWrateBean.getWrate().size(), 0, "Ｗレートの件数");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        BzGetWrate bzGetWrate = SWAKInjector.getInstance(BzGetWrate.class);

        BzGetWrateBean bzGetWrateBean = bzGetWrate.exec(
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
            C_WRateGetKbn.ALL,
            3);

        exClassificationEquals(bzGetWrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(bzGetWrateBean.getRateGetErrorKbn(), null, "レート取得エラー区分");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(0), BizNumber.valueOf(1), "Ｗレート[0]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(1), BizNumber.valueOf(2), "Ｗレート[1]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(2), BizNumber.valueOf(3), "Ｗレート[2]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(3), BizNumber.valueOf(0), "Ｗレート[3]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(4), BizNumber.valueOf(0), "Ｗレート[4]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(5), BizNumber.valueOf(0), "Ｗレート[5]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(6), BizNumber.valueOf(0), "Ｗレート[6]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(7), BizNumber.valueOf(0), "Ｗレート[7]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(8), BizNumber.valueOf(0), "Ｗレート[8]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(9), BizNumber.valueOf(0), "Ｗレート[9]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(10), BizNumber.valueOf(0), "Ｗレート[10]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(11), BizNumber.valueOf(0), "Ｗレート[11]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(12), BizNumber.valueOf(0), "Ｗレート[12]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(13), BizNumber.valueOf(0), "Ｗレート[13]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(14), BizNumber.valueOf(0), "Ｗレート[14]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(15), BizNumber.valueOf(0), "Ｗレート[15]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(16), BizNumber.valueOf(0), "Ｗレート[16]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(17), BizNumber.valueOf(0), "Ｗレート[17]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(18), BizNumber.valueOf(0), "Ｗレート[18]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(19), BizNumber.valueOf(0), "Ｗレート[19]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(20), BizNumber.valueOf(0), "Ｗレート[20]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(21), BizNumber.valueOf(0), "Ｗレート[21]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(22), BizNumber.valueOf(0), "Ｗレート[22]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(23), BizNumber.valueOf(0), "Ｗレート[23]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(24), BizNumber.valueOf(0), "Ｗレート[24]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(25), BizNumber.valueOf(0), "Ｗレート[25]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(26), BizNumber.valueOf(0), "Ｗレート[26]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(27), BizNumber.valueOf(0), "Ｗレート[27]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(28), BizNumber.valueOf(0), "Ｗレート[28]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(29), BizNumber.valueOf(0), "Ｗレート[29]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(30), BizNumber.valueOf(0), "Ｗレート[30]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(31), BizNumber.valueOf(0), "Ｗレート[31]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(32), BizNumber.valueOf(0), "Ｗレート[32]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(33), BizNumber.valueOf(0), "Ｗレート[33]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(34), BizNumber.valueOf(0), "Ｗレート[34]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(35), BizNumber.valueOf(0), "Ｗレート[35]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(36), BizNumber.valueOf(0), "Ｗレート[36]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(37), BizNumber.valueOf(0), "Ｗレート[37]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(38), BizNumber.valueOf(0), "Ｗレート[38]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(39), BizNumber.valueOf(0), "Ｗレート[39]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(40), BizNumber.valueOf(0), "Ｗレート[40]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(41), BizNumber.valueOf(0), "Ｗレート[41]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(42), BizNumber.valueOf(0), "Ｗレート[42]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(43), BizNumber.valueOf(0), "Ｗレート[43]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(44), BizNumber.valueOf(0), "Ｗレート[44]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(45), BizNumber.valueOf(0), "Ｗレート[45]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(46), BizNumber.valueOf(0), "Ｗレート[46]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(47), BizNumber.valueOf(0), "Ｗレート[47]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(48), BizNumber.valueOf(0), "Ｗレート[48]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(49), BizNumber.valueOf(0), "Ｗレート[49]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(50), BizNumber.valueOf(0), "Ｗレート[50]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(51), BizNumber.valueOf(0), "Ｗレート[51]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(52), BizNumber.valueOf(0), "Ｗレート[52]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(53), BizNumber.valueOf(0), "Ｗレート[53]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(54), BizNumber.valueOf(0), "Ｗレート[54]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(55), BizNumber.valueOf(0), "Ｗレート[55]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(56), BizNumber.valueOf(0), "Ｗレート[56]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(57), BizNumber.valueOf(0), "Ｗレート[57]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(58), BizNumber.valueOf(0), "Ｗレート[58]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(59), BizNumber.valueOf(0), "Ｗレート[59]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(60), BizNumber.valueOf(0), "Ｗレート[60]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(61), BizNumber.valueOf(0), "Ｗレート[61]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(62), BizNumber.valueOf(0), "Ｗレート[62]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(63), BizNumber.valueOf(0), "Ｗレート[63]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(64), BizNumber.valueOf(0), "Ｗレート[64]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(65), BizNumber.valueOf(0), "Ｗレート[65]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(66), BizNumber.valueOf(0), "Ｗレート[66]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(67), BizNumber.valueOf(0), "Ｗレート[67]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(68), BizNumber.valueOf(0), "Ｗレート[68]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(69), BizNumber.valueOf(0), "Ｗレート[69]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(70), BizNumber.valueOf(0), "Ｗレート[70]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(71), BizNumber.valueOf(0), "Ｗレート[71]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(72), BizNumber.valueOf(0), "Ｗレート[72]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(73), BizNumber.valueOf(0), "Ｗレート[73]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(74), BizNumber.valueOf(0), "Ｗレート[74]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(75), BizNumber.valueOf(0), "Ｗレート[75]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(76), BizNumber.valueOf(0), "Ｗレート[76]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(77), BizNumber.valueOf(0), "Ｗレート[77]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(78), BizNumber.valueOf(0), "Ｗレート[78]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(79), BizNumber.valueOf(0), "Ｗレート[79]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(80), BizNumber.valueOf(0), "Ｗレート[80]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(81), BizNumber.valueOf(0), "Ｗレート[81]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(82), BizNumber.valueOf(0), "Ｗレート[82]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(83), BizNumber.valueOf(0), "Ｗレート[83]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(84), BizNumber.valueOf(0), "Ｗレート[84]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(85), BizNumber.valueOf(0), "Ｗレート[85]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(86), BizNumber.valueOf(0), "Ｗレート[86]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(87), BizNumber.valueOf(0), "Ｗレート[87]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(88), BizNumber.valueOf(0), "Ｗレート[88]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(89), BizNumber.valueOf(0), "Ｗレート[89]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(90), BizNumber.valueOf(0), "Ｗレート[90]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(91), BizNumber.valueOf(0), "Ｗレート[91]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(92), BizNumber.valueOf(0), "Ｗレート[92]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(93), BizNumber.valueOf(0), "Ｗレート[93]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(94), BizNumber.valueOf(0), "Ｗレート[94]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(95), BizNumber.valueOf(0), "Ｗレート[95]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(96), BizNumber.valueOf(0), "Ｗレート[96]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(97), BizNumber.valueOf(0), "Ｗレート[97]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(98), BizNumber.valueOf(0), "Ｗレート[98]");
        exBizCalcbleEquals(bzGetWrateBean.getWrate().get(99), BizNumber.valueOf(0), "Ｗレート[99]");
    }
}
