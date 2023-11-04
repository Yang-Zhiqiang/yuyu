package yuyu.common.biz.bzcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
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
import yuyu.def.classification.C_RateGetErrorKbn;
import yuyu.def.classification.C_VRateGetKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BzGetVrateクラスのメソッド {@link BzGetVrate#exec(String, String, BizNumber, C_Hrkkaisuu, C_Hhknsei, int, C_HknkknsmnKbn, int, int, C_VRateGetKbn, int)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetVrateTest_exec {

    @Inject
    private BzGetVrate bzGetVrate;

    private final static String fileName = "UT_SP_単体テスト仕様書_Ｖレート取得処理";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetVrateTest_exec.class, fileName, sheetName);
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
        bizDomManager.delete(bizDomManager.getAllRateV());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BzGetVrateBean bzGetVrateBean = bzGetVrate.exec("2009"
            , "123"
            , BizNumber.valueOf(0.0121)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.MALE
            , 30
            , C_HknkknsmnKbn.NENMANKI
            , 10
            , 9
            , C_VRateGetKbn.ONEYEAR
            , 11);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetVrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BzGetVrateBean bzGetVrateBean = bzGetVrate.exec("2009"
            , "123"
            , BizNumber.valueOf(0.0121)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.MALE
            , 30
            , C_HknkknsmnKbn.NENMANKI
            , 10
            , 9
            , C_VRateGetKbn.ONEYEAR
            , 10);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetVrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.TARGETERROR, "レート取得エラー区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BzGetVrateBean bzGetVrateBean = bzGetVrate.exec("1009"
            , "123"
            , BizNumber.valueOf(0.0123)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.MALE
            , 30
            , C_HknkknsmnKbn.NENMANKI
            , 10
            , 8
            , C_VRateGetKbn.ONEYEAR
            , 9);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(100), bzGetVrateBean.getVrate().get(0));
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BzGetVrateBean bzGetVrateBean = bzGetVrate.exec("1009"
            , "123"
            , BizNumber.valueOf(0.0124)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.FEMALE
            , 30
            , C_HknkknsmnKbn.SAIMANKI
            , 10
            , 9
            , C_VRateGetKbn.ALL
            , 11);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(1), bzGetVrateBean.getVrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(2), bzGetVrateBean.getVrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(3), bzGetVrateBean.getVrate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(4), bzGetVrateBean.getVrate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(5), bzGetVrateBean.getVrate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(6), bzGetVrateBean.getVrate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(7), bzGetVrateBean.getVrate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(8), bzGetVrateBean.getVrate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(9), bzGetVrateBean.getVrate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(10), bzGetVrateBean.getVrate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(11), bzGetVrateBean.getVrate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(12), bzGetVrateBean.getVrate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(13), bzGetVrateBean.getVrate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(14), bzGetVrateBean.getVrate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(15), bzGetVrateBean.getVrate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(16), bzGetVrateBean.getVrate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(17), bzGetVrateBean.getVrate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(18), bzGetVrateBean.getVrate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(19), bzGetVrateBean.getVrate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(20), bzGetVrateBean.getVrate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(21), bzGetVrateBean.getVrate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(22), bzGetVrateBean.getVrate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(23), bzGetVrateBean.getVrate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(24), bzGetVrateBean.getVrate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(25), bzGetVrateBean.getVrate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(26), bzGetVrateBean.getVrate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(27), bzGetVrateBean.getVrate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(28), bzGetVrateBean.getVrate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(29), bzGetVrateBean.getVrate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(30), bzGetVrateBean.getVrate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(31), bzGetVrateBean.getVrate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(32), bzGetVrateBean.getVrate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(33), bzGetVrateBean.getVrate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(34), bzGetVrateBean.getVrate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(35), bzGetVrateBean.getVrate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(36), bzGetVrateBean.getVrate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(37), bzGetVrateBean.getVrate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(38), bzGetVrateBean.getVrate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(39), bzGetVrateBean.getVrate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(40), bzGetVrateBean.getVrate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(41), bzGetVrateBean.getVrate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(42), bzGetVrateBean.getVrate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(43), bzGetVrateBean.getVrate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(44), bzGetVrateBean.getVrate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(45), bzGetVrateBean.getVrate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(46), bzGetVrateBean.getVrate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(47), bzGetVrateBean.getVrate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(48), bzGetVrateBean.getVrate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(49), bzGetVrateBean.getVrate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(50), bzGetVrateBean.getVrate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(51), bzGetVrateBean.getVrate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(52), bzGetVrateBean.getVrate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(53), bzGetVrateBean.getVrate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(54), bzGetVrateBean.getVrate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(55), bzGetVrateBean.getVrate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(56), bzGetVrateBean.getVrate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(57), bzGetVrateBean.getVrate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(58), bzGetVrateBean.getVrate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(59), bzGetVrateBean.getVrate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(60), bzGetVrateBean.getVrate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(61), bzGetVrateBean.getVrate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(62), bzGetVrateBean.getVrate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(63), bzGetVrateBean.getVrate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(64), bzGetVrateBean.getVrate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(65), bzGetVrateBean.getVrate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(66), bzGetVrateBean.getVrate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(67), bzGetVrateBean.getVrate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(68), bzGetVrateBean.getVrate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(69), bzGetVrateBean.getVrate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(70), bzGetVrateBean.getVrate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(71), bzGetVrateBean.getVrate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(72), bzGetVrateBean.getVrate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(73), bzGetVrateBean.getVrate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(74), bzGetVrateBean.getVrate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(75), bzGetVrateBean.getVrate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(76), bzGetVrateBean.getVrate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(77), bzGetVrateBean.getVrate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(78), bzGetVrateBean.getVrate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(79), bzGetVrateBean.getVrate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(80), bzGetVrateBean.getVrate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(81), bzGetVrateBean.getVrate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(82), bzGetVrateBean.getVrate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(83), bzGetVrateBean.getVrate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(84), bzGetVrateBean.getVrate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(85), bzGetVrateBean.getVrate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(86), bzGetVrateBean.getVrate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(87), bzGetVrateBean.getVrate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(88), bzGetVrateBean.getVrate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(89), bzGetVrateBean.getVrate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(90), bzGetVrateBean.getVrate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(91), bzGetVrateBean.getVrate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(92), bzGetVrateBean.getVrate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(93), bzGetVrateBean.getVrate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(94), bzGetVrateBean.getVrate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(95), bzGetVrateBean.getVrate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(96), bzGetVrateBean.getVrate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(97), bzGetVrateBean.getVrate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(98), bzGetVrateBean.getVrate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(99), bzGetVrateBean.getVrate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(100), bzGetVrateBean.getVrate().get(99));
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BzGetVrateBean bzGetVrateBean = bzGetVrate.exec("2009"
            , "123"
            , BizNumber.valueOf(0.0122)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.MALE
            , 30
            , C_HknkknsmnKbn.SAIMANKI
            , 100
            , 9
            , C_VRateGetKbn.TWOYEARS
            , 99);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetVrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BzGetVrateBean bzGetVrateBean = bzGetVrate.exec("1009"
            , "123"
            , BizNumber.valueOf(0.0125)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.MALE
            , 30
            , C_HknkknsmnKbn.SAIMANKI
            , 99
            , 9
            , C_VRateGetKbn.TWOYEARS
            , 98);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(200), bzGetVrateBean.getVrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(300), bzGetVrateBean.getVrate().get(1));
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BzGetVrateBean bzGetVrateBean = bzGetVrate.exec("1009"
            , "123"
            , BizNumber.valueOf(0.0126)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.MALE
            , 30
            , C_HknkknsmnKbn.SAIMANKI
            , 99
            , 9
            , C_VRateGetKbn.NONE
            , 99);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        BzGetVrateBean bzGetVrateBean = bzGetVrate.exec("1009"
            , "123"
            , BizNumber.valueOf(0.0127)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.FEMALE
            , 30
            , C_HknkknsmnKbn.SAIMANKI
            , 10
            , 9
            , C_VRateGetKbn.ALL
            , 11);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(1), bzGetVrateBean.getVrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(2), bzGetVrateBean.getVrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(3), bzGetVrateBean.getVrate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetVrateBean.getVrate().get(99));
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        BzGetVrateBean bzGetVrateBean = bzGetVrate.exec("1009"
            , "127"
            , BizNumber.valueOf(0.0127)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.FEMALE
            , 30
            , C_HknkknsmnKbn.SAIMANKI
            , 10
            , 9
            , C_VRateGetKbn.TWOYEARS
            , 1);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(2), bzGetVrateBean.getVrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(3), bzGetVrateBean.getVrate().get(1));
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        BzGetVrateBean bzGetVrateBean = bzGetVrate.exec("1009"
            , "123"
            , BizNumber.valueOf(0.0123)
            , C_Hrkkaisuu.NEN
            , C_Hhknsei.MALE
            , 30
            , C_HknkknsmnKbn.NENMANKI
            , 10
            , 8
            , C_VRateGetKbn.ONEYEAR
            , 9);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(100), bzGetVrateBean.getVrate().get(0));
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        BzGetVrateBean bzGetVrateBean = bzGetVrate.exec("2009"
            , "123"
            , BizNumber.valueOf(0.0121)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.MALE
            , 30
            , C_HknkknsmnKbn.NENMANKI
            , 10
            , 9
            , C_VRateGetKbn.ONEYEAR
            , -1);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetVrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        BzGetVrateBean bzGetVrateBean = bzGetVrate.exec("2009"
            , "123"
            , BizNumber.valueOf(0.0121)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.MALE
            , 30
            , C_HknkknsmnKbn.NENMANKI
            , 10
            , 9
            , C_VRateGetKbn.ONEYEAR
            , 100);

        exClassificationEquals(bzGetVrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetVrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");
    }
}
