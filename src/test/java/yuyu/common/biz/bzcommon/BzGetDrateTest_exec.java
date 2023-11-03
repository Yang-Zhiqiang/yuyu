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

import org.slf4j.Logger;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DRateGetKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_RateGetErrorKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BzGetDrateクラスのメソッド {@link BzGetDrate#exec(String, String, BizNumber, C_Hrkkaisuu, C_Hhknsei, int, C_HknkknsmnKbn,

int, int, String, C_NaiteiKakuteiKbn, C_DRateGetKbn, int)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetDrateTest_exec {

    @Inject
    private BzGetDrate bzGetDrate;

    @Inject
    private static Logger logger;

    private final static String fileName = "UT_SP_単体テスト仕様書_Dレート取得処理";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetDrateTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap, true);
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
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BzGetDrateBean bzGetDrateBean =
            bzGetDrate.exec("2234"
                , "765"
                , BizNumber.valueOf(1.1234)
                , C_Hrkkaisuu.ITIJI
                , C_Hhknsei.MALE
                , 9
                , C_HknkknsmnKbn.NENMANKI
                , 10
                , 20
                , "2015"
                , C_NaiteiKakuteiKbn.KAKUTEI
                , C_DRateGetKbn.ONEYEAR
                , 11);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetDrateBean.getRateGetErrorKbn()
            , C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");

        logger.debug("結果区分　 = " + bzGetDrateBean.getErrorKbn() );
        logger.debug("エラー区分 = " + bzGetDrateBean.getRateGetErrorKbn() );
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BzGetDrateBean bzGetDrateBean =
            bzGetDrate.exec("2234"
                , "765"
                , BizNumber.valueOf(1.1234)
                , C_Hrkkaisuu.ITIJI
                , C_Hhknsei.MALE
                , 9
                , C_HknkknsmnKbn.NENMANKI
                , 10
                , 20
                , "2015"
                , C_NaiteiKakuteiKbn.KAKUTEI
                , C_DRateGetKbn.ONEYEAR
                , 10);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetDrateBean.getRateGetErrorKbn()
            , C_RateGetErrorKbn.TARGETERROR, "レート取得エラー区分");

        logger.debug("結果区分　 = " + bzGetDrateBean.getErrorKbn() );
        logger.debug("エラー区分 = " + bzGetDrateBean.getRateGetErrorKbn() );
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BzGetDrateBean bzGetDrateBean = bzGetDrate.exec("1234"
            , "765"
            , BizNumber.valueOf(1.1234)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.FEMALE
            , 30
            , C_HknkknsmnKbn.NENMANKI
            , 15
            , 20
            , "2015"
            , C_NaiteiKakuteiKbn.NAITEI
            , C_DRateGetKbn.ALL
            , 14);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(111.111111), bzGetDrateBean.getDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(111.111112), bzGetDrateBean.getDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(111.111113), bzGetDrateBean.getDrate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(111.111114), bzGetDrateBean.getDrate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(111.111115), bzGetDrateBean.getDrate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(111.111116), bzGetDrateBean.getDrate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(111.111117), bzGetDrateBean.getDrate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(111.111118), bzGetDrateBean.getDrate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(111.111119), bzGetDrateBean.getDrate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(111.111120), bzGetDrateBean.getDrate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(111.111121), bzGetDrateBean.getDrate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(111.111122), bzGetDrateBean.getDrate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(111.111123), bzGetDrateBean.getDrate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(111.111124), bzGetDrateBean.getDrate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(111.111125), bzGetDrateBean.getDrate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(111.111126), bzGetDrateBean.getDrate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(111.111127), bzGetDrateBean.getDrate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(111.111128), bzGetDrateBean.getDrate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(111.111129), bzGetDrateBean.getDrate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(111.111130), bzGetDrateBean.getDrate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(111.111131), bzGetDrateBean.getDrate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(111.111132), bzGetDrateBean.getDrate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(111.111133), bzGetDrateBean.getDrate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(111.111134), bzGetDrateBean.getDrate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(111.111135), bzGetDrateBean.getDrate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(111.111136), bzGetDrateBean.getDrate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(111.111137), bzGetDrateBean.getDrate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(111.111138), bzGetDrateBean.getDrate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(111.111139), bzGetDrateBean.getDrate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(111.111140), bzGetDrateBean.getDrate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(111.111141), bzGetDrateBean.getDrate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(111.111142), bzGetDrateBean.getDrate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(111.111143), bzGetDrateBean.getDrate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(111.111144), bzGetDrateBean.getDrate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(111.111145), bzGetDrateBean.getDrate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(111.111146), bzGetDrateBean.getDrate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(111.111147), bzGetDrateBean.getDrate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(111.111148), bzGetDrateBean.getDrate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(111.111149), bzGetDrateBean.getDrate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(111.111150), bzGetDrateBean.getDrate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(111.111151), bzGetDrateBean.getDrate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(111.111152), bzGetDrateBean.getDrate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(111.111153), bzGetDrateBean.getDrate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(111.111154), bzGetDrateBean.getDrate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(111.111155), bzGetDrateBean.getDrate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(111.111156), bzGetDrateBean.getDrate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(111.111157), bzGetDrateBean.getDrate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(111.111158), bzGetDrateBean.getDrate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(111.111159), bzGetDrateBean.getDrate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(111.111160), bzGetDrateBean.getDrate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(111.111161), bzGetDrateBean.getDrate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(111.111162), bzGetDrateBean.getDrate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(111.111163), bzGetDrateBean.getDrate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(111.111164), bzGetDrateBean.getDrate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(111.111165), bzGetDrateBean.getDrate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(111.111166), bzGetDrateBean.getDrate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(111.111167), bzGetDrateBean.getDrate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(111.111168), bzGetDrateBean.getDrate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(111.111169), bzGetDrateBean.getDrate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(111.111170), bzGetDrateBean.getDrate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(111.111171), bzGetDrateBean.getDrate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(111.111172), bzGetDrateBean.getDrate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(111.111173), bzGetDrateBean.getDrate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(111.111174), bzGetDrateBean.getDrate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(111.111175), bzGetDrateBean.getDrate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(111.111176), bzGetDrateBean.getDrate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(111.111177), bzGetDrateBean.getDrate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(111.111178), bzGetDrateBean.getDrate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(111.111179), bzGetDrateBean.getDrate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(111.111180), bzGetDrateBean.getDrate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(111.111181), bzGetDrateBean.getDrate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(111.111182), bzGetDrateBean.getDrate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(111.111183), bzGetDrateBean.getDrate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(111.111184), bzGetDrateBean.getDrate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(111.111185), bzGetDrateBean.getDrate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(111.111186), bzGetDrateBean.getDrate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(111.111187), bzGetDrateBean.getDrate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(111.111188), bzGetDrateBean.getDrate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(111.111189), bzGetDrateBean.getDrate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(111.111190), bzGetDrateBean.getDrate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(111.111191), bzGetDrateBean.getDrate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(111.111192), bzGetDrateBean.getDrate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(111.111193), bzGetDrateBean.getDrate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(111.111194), bzGetDrateBean.getDrate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(111.111195), bzGetDrateBean.getDrate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(111.111196), bzGetDrateBean.getDrate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(111.111197), bzGetDrateBean.getDrate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(111.111198), bzGetDrateBean.getDrate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(111.111199), bzGetDrateBean.getDrate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(111.111200), bzGetDrateBean.getDrate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(111.111201), bzGetDrateBean.getDrate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(111.111202), bzGetDrateBean.getDrate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(111.111203), bzGetDrateBean.getDrate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(111.111204), bzGetDrateBean.getDrate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(111.111205), bzGetDrateBean.getDrate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(111.111206), bzGetDrateBean.getDrate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(111.111207), bzGetDrateBean.getDrate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(111.111208), bzGetDrateBean.getDrate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(111.111209), bzGetDrateBean.getDrate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(111.111210), bzGetDrateBean.getDrate().get(99));
        assertEquals("BizNumber", BizNumber.valueOf(211.111111), bzGetDrateBean.getShisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(211.111112), bzGetDrateBean.getShisaDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(211.111113), bzGetDrateBean.getShisaDrate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(211.111114), bzGetDrateBean.getShisaDrate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(211.111115), bzGetDrateBean.getShisaDrate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(211.111116), bzGetDrateBean.getShisaDrate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(211.111117), bzGetDrateBean.getShisaDrate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(211.111118), bzGetDrateBean.getShisaDrate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(211.111119), bzGetDrateBean.getShisaDrate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(211.111120), bzGetDrateBean.getShisaDrate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(211.111121), bzGetDrateBean.getShisaDrate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(211.111122), bzGetDrateBean.getShisaDrate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(211.111123), bzGetDrateBean.getShisaDrate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(211.111124), bzGetDrateBean.getShisaDrate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(211.111125), bzGetDrateBean.getShisaDrate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(211.111126), bzGetDrateBean.getShisaDrate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(211.111127), bzGetDrateBean.getShisaDrate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(211.111128), bzGetDrateBean.getShisaDrate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(211.111129), bzGetDrateBean.getShisaDrate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(211.111130), bzGetDrateBean.getShisaDrate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(211.111131), bzGetDrateBean.getShisaDrate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(211.111132), bzGetDrateBean.getShisaDrate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(211.111133), bzGetDrateBean.getShisaDrate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(211.111134), bzGetDrateBean.getShisaDrate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(211.111135), bzGetDrateBean.getShisaDrate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(211.111136), bzGetDrateBean.getShisaDrate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(211.111137), bzGetDrateBean.getShisaDrate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(211.111138), bzGetDrateBean.getShisaDrate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(211.111139), bzGetDrateBean.getShisaDrate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(211.111140), bzGetDrateBean.getShisaDrate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(211.111141), bzGetDrateBean.getShisaDrate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(211.111142), bzGetDrateBean.getShisaDrate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(211.111143), bzGetDrateBean.getShisaDrate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(211.111144), bzGetDrateBean.getShisaDrate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(211.111145), bzGetDrateBean.getShisaDrate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(211.111146), bzGetDrateBean.getShisaDrate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(211.111147), bzGetDrateBean.getShisaDrate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(211.111148), bzGetDrateBean.getShisaDrate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(211.111149), bzGetDrateBean.getShisaDrate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(211.111150), bzGetDrateBean.getShisaDrate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(211.111151), bzGetDrateBean.getShisaDrate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(211.111152), bzGetDrateBean.getShisaDrate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(211.111153), bzGetDrateBean.getShisaDrate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(211.111154), bzGetDrateBean.getShisaDrate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(211.111155), bzGetDrateBean.getShisaDrate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(211.111156), bzGetDrateBean.getShisaDrate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(211.111157), bzGetDrateBean.getShisaDrate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(211.111158), bzGetDrateBean.getShisaDrate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(211.111159), bzGetDrateBean.getShisaDrate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(211.111160), bzGetDrateBean.getShisaDrate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(211.111161), bzGetDrateBean.getShisaDrate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(211.111162), bzGetDrateBean.getShisaDrate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(211.111163), bzGetDrateBean.getShisaDrate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(211.111164), bzGetDrateBean.getShisaDrate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(211.111165), bzGetDrateBean.getShisaDrate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(211.111166), bzGetDrateBean.getShisaDrate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(211.111167), bzGetDrateBean.getShisaDrate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(211.111168), bzGetDrateBean.getShisaDrate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(211.111169), bzGetDrateBean.getShisaDrate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(211.111170), bzGetDrateBean.getShisaDrate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(211.111171), bzGetDrateBean.getShisaDrate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(211.111172), bzGetDrateBean.getShisaDrate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(211.111173), bzGetDrateBean.getShisaDrate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(211.111174), bzGetDrateBean.getShisaDrate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(211.111175), bzGetDrateBean.getShisaDrate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(211.111176), bzGetDrateBean.getShisaDrate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(211.111177), bzGetDrateBean.getShisaDrate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(211.111178), bzGetDrateBean.getShisaDrate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(211.111179), bzGetDrateBean.getShisaDrate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(211.111180), bzGetDrateBean.getShisaDrate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(211.111181), bzGetDrateBean.getShisaDrate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(211.111182), bzGetDrateBean.getShisaDrate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(211.111183), bzGetDrateBean.getShisaDrate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(211.111184), bzGetDrateBean.getShisaDrate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(211.111185), bzGetDrateBean.getShisaDrate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(211.111186), bzGetDrateBean.getShisaDrate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(211.111187), bzGetDrateBean.getShisaDrate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(211.111188), bzGetDrateBean.getShisaDrate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(211.111189), bzGetDrateBean.getShisaDrate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(211.111190), bzGetDrateBean.getShisaDrate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(211.111191), bzGetDrateBean.getShisaDrate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(211.111192), bzGetDrateBean.getShisaDrate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(211.111193), bzGetDrateBean.getShisaDrate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(211.111194), bzGetDrateBean.getShisaDrate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(211.111195), bzGetDrateBean.getShisaDrate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(211.111196), bzGetDrateBean.getShisaDrate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(211.111197), bzGetDrateBean.getShisaDrate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(211.111198), bzGetDrateBean.getShisaDrate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(211.111199), bzGetDrateBean.getShisaDrate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(211.111200), bzGetDrateBean.getShisaDrate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(211.111201), bzGetDrateBean.getShisaDrate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(211.111202), bzGetDrateBean.getShisaDrate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(211.111203), bzGetDrateBean.getShisaDrate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(211.111204), bzGetDrateBean.getShisaDrate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(211.111205), bzGetDrateBean.getShisaDrate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(211.111206), bzGetDrateBean.getShisaDrate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(211.111207), bzGetDrateBean.getShisaDrate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(211.111208), bzGetDrateBean.getShisaDrate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(211.111209), bzGetDrateBean.getShisaDrate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(211.111210), bzGetDrateBean.getShisaDrate().get(99));
        assertEquals("BizNumber", BizNumber.valueOf(311.111111), bzGetDrateBean.getRisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(311.111112), bzGetDrateBean.getRisaDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(311.111113), bzGetDrateBean.getRisaDrate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(311.111114), bzGetDrateBean.getRisaDrate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(311.111115), bzGetDrateBean.getRisaDrate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(311.111116), bzGetDrateBean.getRisaDrate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(311.111117), bzGetDrateBean.getRisaDrate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(311.111118), bzGetDrateBean.getRisaDrate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(311.111119), bzGetDrateBean.getRisaDrate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(311.111120), bzGetDrateBean.getRisaDrate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(311.111121), bzGetDrateBean.getRisaDrate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(311.111122), bzGetDrateBean.getRisaDrate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(311.111123), bzGetDrateBean.getRisaDrate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(311.111124), bzGetDrateBean.getRisaDrate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(311.111125), bzGetDrateBean.getRisaDrate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(311.111126), bzGetDrateBean.getRisaDrate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(311.111127), bzGetDrateBean.getRisaDrate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(311.111128), bzGetDrateBean.getRisaDrate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(311.111129), bzGetDrateBean.getRisaDrate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(311.111130), bzGetDrateBean.getRisaDrate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(311.111131), bzGetDrateBean.getRisaDrate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(311.111132), bzGetDrateBean.getRisaDrate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(311.111133), bzGetDrateBean.getRisaDrate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(311.111134), bzGetDrateBean.getRisaDrate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(311.111135), bzGetDrateBean.getRisaDrate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(311.111136), bzGetDrateBean.getRisaDrate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(311.111137), bzGetDrateBean.getRisaDrate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(311.111138), bzGetDrateBean.getRisaDrate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(311.111139), bzGetDrateBean.getRisaDrate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(311.111140), bzGetDrateBean.getRisaDrate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(311.111141), bzGetDrateBean.getRisaDrate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(311.111142), bzGetDrateBean.getRisaDrate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(311.111143), bzGetDrateBean.getRisaDrate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(311.111144), bzGetDrateBean.getRisaDrate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(311.111145), bzGetDrateBean.getRisaDrate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(311.111146), bzGetDrateBean.getRisaDrate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(311.111147), bzGetDrateBean.getRisaDrate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(311.111148), bzGetDrateBean.getRisaDrate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(311.111149), bzGetDrateBean.getRisaDrate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(311.111150), bzGetDrateBean.getRisaDrate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(311.111151), bzGetDrateBean.getRisaDrate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(311.111152), bzGetDrateBean.getRisaDrate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(311.111153), bzGetDrateBean.getRisaDrate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(311.111154), bzGetDrateBean.getRisaDrate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(311.111155), bzGetDrateBean.getRisaDrate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(311.111156), bzGetDrateBean.getRisaDrate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(311.111157), bzGetDrateBean.getRisaDrate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(311.111158), bzGetDrateBean.getRisaDrate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(311.111159), bzGetDrateBean.getRisaDrate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(311.111160), bzGetDrateBean.getRisaDrate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(311.111161), bzGetDrateBean.getRisaDrate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(311.111162), bzGetDrateBean.getRisaDrate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(311.111163), bzGetDrateBean.getRisaDrate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(311.111164), bzGetDrateBean.getRisaDrate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(311.111165), bzGetDrateBean.getRisaDrate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(311.111166), bzGetDrateBean.getRisaDrate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(311.111167), bzGetDrateBean.getRisaDrate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(311.111168), bzGetDrateBean.getRisaDrate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(311.111169), bzGetDrateBean.getRisaDrate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(311.111170), bzGetDrateBean.getRisaDrate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(311.111171), bzGetDrateBean.getRisaDrate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(311.111172), bzGetDrateBean.getRisaDrate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(311.111173), bzGetDrateBean.getRisaDrate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(311.111174), bzGetDrateBean.getRisaDrate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(311.111175), bzGetDrateBean.getRisaDrate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(311.111176), bzGetDrateBean.getRisaDrate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(311.111177), bzGetDrateBean.getRisaDrate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(311.111178), bzGetDrateBean.getRisaDrate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(311.111179), bzGetDrateBean.getRisaDrate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(311.111180), bzGetDrateBean.getRisaDrate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(311.111181), bzGetDrateBean.getRisaDrate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(311.111182), bzGetDrateBean.getRisaDrate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(311.111183), bzGetDrateBean.getRisaDrate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(311.111184), bzGetDrateBean.getRisaDrate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(311.111185), bzGetDrateBean.getRisaDrate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(311.111186), bzGetDrateBean.getRisaDrate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(311.111187), bzGetDrateBean.getRisaDrate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(311.111188), bzGetDrateBean.getRisaDrate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(311.111189), bzGetDrateBean.getRisaDrate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(311.111190), bzGetDrateBean.getRisaDrate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(311.111191), bzGetDrateBean.getRisaDrate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(311.111192), bzGetDrateBean.getRisaDrate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(311.111193), bzGetDrateBean.getRisaDrate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(311.111194), bzGetDrateBean.getRisaDrate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(311.111195), bzGetDrateBean.getRisaDrate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(311.111196), bzGetDrateBean.getRisaDrate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(311.111197), bzGetDrateBean.getRisaDrate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(311.111198), bzGetDrateBean.getRisaDrate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(311.111199), bzGetDrateBean.getRisaDrate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(311.111200), bzGetDrateBean.getRisaDrate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(311.111201), bzGetDrateBean.getRisaDrate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(311.111202), bzGetDrateBean.getRisaDrate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(311.111203), bzGetDrateBean.getRisaDrate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(311.111204), bzGetDrateBean.getRisaDrate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(311.111205), bzGetDrateBean.getRisaDrate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(311.111206), bzGetDrateBean.getRisaDrate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(311.111207), bzGetDrateBean.getRisaDrate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(311.111208), bzGetDrateBean.getRisaDrate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(311.111209), bzGetDrateBean.getRisaDrate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(311.111210), bzGetDrateBean.getRisaDrate().get(99));
        assertEquals("BizNumber", BizNumber.valueOf(411.111111), bzGetDrateBean.getHisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(411.111112), bzGetDrateBean.getHisaDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(411.111113), bzGetDrateBean.getHisaDrate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(411.111114), bzGetDrateBean.getHisaDrate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(411.111115), bzGetDrateBean.getHisaDrate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(411.111116), bzGetDrateBean.getHisaDrate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(411.111117), bzGetDrateBean.getHisaDrate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(411.111118), bzGetDrateBean.getHisaDrate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(411.111119), bzGetDrateBean.getHisaDrate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(411.111120), bzGetDrateBean.getHisaDrate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(411.111121), bzGetDrateBean.getHisaDrate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(411.111122), bzGetDrateBean.getHisaDrate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(411.111123), bzGetDrateBean.getHisaDrate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(411.111124), bzGetDrateBean.getHisaDrate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(411.111125), bzGetDrateBean.getHisaDrate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(411.111126), bzGetDrateBean.getHisaDrate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(411.111127), bzGetDrateBean.getHisaDrate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(411.111128), bzGetDrateBean.getHisaDrate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(411.111129), bzGetDrateBean.getHisaDrate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(411.111130), bzGetDrateBean.getHisaDrate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(411.111131), bzGetDrateBean.getHisaDrate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(411.111132), bzGetDrateBean.getHisaDrate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(411.111133), bzGetDrateBean.getHisaDrate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(411.111134), bzGetDrateBean.getHisaDrate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(411.111135), bzGetDrateBean.getHisaDrate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(411.111136), bzGetDrateBean.getHisaDrate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(411.111137), bzGetDrateBean.getHisaDrate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(411.111138), bzGetDrateBean.getHisaDrate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(411.111139), bzGetDrateBean.getHisaDrate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(411.111140), bzGetDrateBean.getHisaDrate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(411.111141), bzGetDrateBean.getHisaDrate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(411.111142), bzGetDrateBean.getHisaDrate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(411.111143), bzGetDrateBean.getHisaDrate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(411.111144), bzGetDrateBean.getHisaDrate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(411.111145), bzGetDrateBean.getHisaDrate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(411.111146), bzGetDrateBean.getHisaDrate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(411.111147), bzGetDrateBean.getHisaDrate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(411.111148), bzGetDrateBean.getHisaDrate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(411.111149), bzGetDrateBean.getHisaDrate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(411.111150), bzGetDrateBean.getHisaDrate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(411.111151), bzGetDrateBean.getHisaDrate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(411.111152), bzGetDrateBean.getHisaDrate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(411.111153), bzGetDrateBean.getHisaDrate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(411.111154), bzGetDrateBean.getHisaDrate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(411.111155), bzGetDrateBean.getHisaDrate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(411.111156), bzGetDrateBean.getHisaDrate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(411.111157), bzGetDrateBean.getHisaDrate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(411.111158), bzGetDrateBean.getHisaDrate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(411.111159), bzGetDrateBean.getHisaDrate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(411.111160), bzGetDrateBean.getHisaDrate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(411.111161), bzGetDrateBean.getHisaDrate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(411.111162), bzGetDrateBean.getHisaDrate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(411.111163), bzGetDrateBean.getHisaDrate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(411.111164), bzGetDrateBean.getHisaDrate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(411.111165), bzGetDrateBean.getHisaDrate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(411.111166), bzGetDrateBean.getHisaDrate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(411.111167), bzGetDrateBean.getHisaDrate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(411.111168), bzGetDrateBean.getHisaDrate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(411.111169), bzGetDrateBean.getHisaDrate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(411.111170), bzGetDrateBean.getHisaDrate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(411.111171), bzGetDrateBean.getHisaDrate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(411.111172), bzGetDrateBean.getHisaDrate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(411.111173), bzGetDrateBean.getHisaDrate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(411.111174), bzGetDrateBean.getHisaDrate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(411.111175), bzGetDrateBean.getHisaDrate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(411.111176), bzGetDrateBean.getHisaDrate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(411.111177), bzGetDrateBean.getHisaDrate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(411.111178), bzGetDrateBean.getHisaDrate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(411.111179), bzGetDrateBean.getHisaDrate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(411.111180), bzGetDrateBean.getHisaDrate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(411.111181), bzGetDrateBean.getHisaDrate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(411.111182), bzGetDrateBean.getHisaDrate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(411.111183), bzGetDrateBean.getHisaDrate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(411.111184), bzGetDrateBean.getHisaDrate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(411.111185), bzGetDrateBean.getHisaDrate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(411.111186), bzGetDrateBean.getHisaDrate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(411.111187), bzGetDrateBean.getHisaDrate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(411.111188), bzGetDrateBean.getHisaDrate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(411.111189), bzGetDrateBean.getHisaDrate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(411.111190), bzGetDrateBean.getHisaDrate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(411.111191), bzGetDrateBean.getHisaDrate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(411.111192), bzGetDrateBean.getHisaDrate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(411.111193), bzGetDrateBean.getHisaDrate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(411.111194), bzGetDrateBean.getHisaDrate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(411.111195), bzGetDrateBean.getHisaDrate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(411.111196), bzGetDrateBean.getHisaDrate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(411.111197), bzGetDrateBean.getHisaDrate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(411.111198), bzGetDrateBean.getHisaDrate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(411.111199), bzGetDrateBean.getHisaDrate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(411.111200), bzGetDrateBean.getHisaDrate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(411.111201), bzGetDrateBean.getHisaDrate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(411.111202), bzGetDrateBean.getHisaDrate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(411.111203), bzGetDrateBean.getHisaDrate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(411.111204), bzGetDrateBean.getHisaDrate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(411.111205), bzGetDrateBean.getHisaDrate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(411.111206), bzGetDrateBean.getHisaDrate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(411.111207), bzGetDrateBean.getHisaDrate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(411.111208), bzGetDrateBean.getHisaDrate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(411.111209), bzGetDrateBean.getHisaDrate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(411.111210), bzGetDrateBean.getHisaDrate().get(99));
        assertEquals("BizNumber", BizNumber.valueOf(511.111111), bzGetDrateBean.getDyouVrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(511.111112), bzGetDrateBean.getDyouVrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(511.111113), bzGetDrateBean.getDyouVrate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(511.111114), bzGetDrateBean.getDyouVrate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(511.111115), bzGetDrateBean.getDyouVrate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(511.111116), bzGetDrateBean.getDyouVrate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(511.111117), bzGetDrateBean.getDyouVrate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(511.111118), bzGetDrateBean.getDyouVrate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(511.111119), bzGetDrateBean.getDyouVrate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(511.111120), bzGetDrateBean.getDyouVrate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(511.111121), bzGetDrateBean.getDyouVrate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(511.111122), bzGetDrateBean.getDyouVrate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(511.111123), bzGetDrateBean.getDyouVrate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(511.111124), bzGetDrateBean.getDyouVrate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(511.111125), bzGetDrateBean.getDyouVrate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(511.111126), bzGetDrateBean.getDyouVrate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(511.111127), bzGetDrateBean.getDyouVrate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(511.111128), bzGetDrateBean.getDyouVrate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(511.111129), bzGetDrateBean.getDyouVrate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(511.111130), bzGetDrateBean.getDyouVrate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(511.111131), bzGetDrateBean.getDyouVrate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(511.111132), bzGetDrateBean.getDyouVrate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(511.111133), bzGetDrateBean.getDyouVrate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(511.111134), bzGetDrateBean.getDyouVrate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(511.111135), bzGetDrateBean.getDyouVrate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(511.111136), bzGetDrateBean.getDyouVrate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(511.111137), bzGetDrateBean.getDyouVrate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(511.111138), bzGetDrateBean.getDyouVrate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(511.111139), bzGetDrateBean.getDyouVrate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(511.111140), bzGetDrateBean.getDyouVrate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(511.111141), bzGetDrateBean.getDyouVrate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(511.111142), bzGetDrateBean.getDyouVrate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(511.111143), bzGetDrateBean.getDyouVrate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(511.111144), bzGetDrateBean.getDyouVrate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(511.111145), bzGetDrateBean.getDyouVrate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(511.111146), bzGetDrateBean.getDyouVrate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(511.111147), bzGetDrateBean.getDyouVrate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(511.111148), bzGetDrateBean.getDyouVrate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(511.111149), bzGetDrateBean.getDyouVrate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(511.111150), bzGetDrateBean.getDyouVrate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(511.111151), bzGetDrateBean.getDyouVrate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(511.111152), bzGetDrateBean.getDyouVrate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(511.111153), bzGetDrateBean.getDyouVrate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(511.111154), bzGetDrateBean.getDyouVrate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(511.111155), bzGetDrateBean.getDyouVrate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(511.111156), bzGetDrateBean.getDyouVrate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(511.111157), bzGetDrateBean.getDyouVrate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(511.111158), bzGetDrateBean.getDyouVrate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(511.111159), bzGetDrateBean.getDyouVrate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(511.111160), bzGetDrateBean.getDyouVrate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(511.111161), bzGetDrateBean.getDyouVrate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(511.111162), bzGetDrateBean.getDyouVrate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(511.111163), bzGetDrateBean.getDyouVrate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(511.111164), bzGetDrateBean.getDyouVrate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(511.111165), bzGetDrateBean.getDyouVrate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(511.111166), bzGetDrateBean.getDyouVrate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(511.111167), bzGetDrateBean.getDyouVrate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(511.111168), bzGetDrateBean.getDyouVrate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(511.111169), bzGetDrateBean.getDyouVrate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(511.111170), bzGetDrateBean.getDyouVrate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(511.111171), bzGetDrateBean.getDyouVrate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(511.111172), bzGetDrateBean.getDyouVrate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(511.111173), bzGetDrateBean.getDyouVrate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(511.111174), bzGetDrateBean.getDyouVrate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(511.111175), bzGetDrateBean.getDyouVrate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(511.111176), bzGetDrateBean.getDyouVrate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(511.111177), bzGetDrateBean.getDyouVrate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(511.111178), bzGetDrateBean.getDyouVrate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(511.111179), bzGetDrateBean.getDyouVrate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(511.111180), bzGetDrateBean.getDyouVrate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(511.111181), bzGetDrateBean.getDyouVrate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(511.111182), bzGetDrateBean.getDyouVrate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(511.111183), bzGetDrateBean.getDyouVrate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(511.111184), bzGetDrateBean.getDyouVrate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(511.111185), bzGetDrateBean.getDyouVrate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(511.111186), bzGetDrateBean.getDyouVrate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(511.111187), bzGetDrateBean.getDyouVrate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(511.111188), bzGetDrateBean.getDyouVrate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(511.111189), bzGetDrateBean.getDyouVrate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(511.111190), bzGetDrateBean.getDyouVrate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(511.111191), bzGetDrateBean.getDyouVrate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(511.111192), bzGetDrateBean.getDyouVrate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(511.111193), bzGetDrateBean.getDyouVrate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(511.111194), bzGetDrateBean.getDyouVrate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(511.111195), bzGetDrateBean.getDyouVrate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(511.111196), bzGetDrateBean.getDyouVrate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(511.111197), bzGetDrateBean.getDyouVrate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(511.111198), bzGetDrateBean.getDyouVrate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(511.111199), bzGetDrateBean.getDyouVrate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(511.111200), bzGetDrateBean.getDyouVrate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(511.111201), bzGetDrateBean.getDyouVrate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(511.111202), bzGetDrateBean.getDyouVrate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(511.111203), bzGetDrateBean.getDyouVrate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(511.111204), bzGetDrateBean.getDyouVrate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(511.111205), bzGetDrateBean.getDyouVrate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(511.111206), bzGetDrateBean.getDyouVrate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(511.111207), bzGetDrateBean.getDyouVrate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(511.111208), bzGetDrateBean.getDyouVrate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(511.111209), bzGetDrateBean.getDyouVrate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(511.111210), bzGetDrateBean.getDyouVrate().get(99));
        assertEquals("BizNumber", BizNumber.valueOf(611.111111), bzGetDrateBean.getKikenSrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(611.111112), bzGetDrateBean.getKikenSrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(611.111113), bzGetDrateBean.getKikenSrate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(611.111114), bzGetDrateBean.getKikenSrate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(611.111115), bzGetDrateBean.getKikenSrate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(611.111116), bzGetDrateBean.getKikenSrate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(611.111117), bzGetDrateBean.getKikenSrate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(611.111118), bzGetDrateBean.getKikenSrate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(611.111119), bzGetDrateBean.getKikenSrate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(611.111120), bzGetDrateBean.getKikenSrate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(611.111121), bzGetDrateBean.getKikenSrate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(611.111122), bzGetDrateBean.getKikenSrate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(611.111123), bzGetDrateBean.getKikenSrate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(611.111124), bzGetDrateBean.getKikenSrate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(611.111125), bzGetDrateBean.getKikenSrate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(611.111126), bzGetDrateBean.getKikenSrate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(611.111127), bzGetDrateBean.getKikenSrate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(611.111128), bzGetDrateBean.getKikenSrate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(611.111129), bzGetDrateBean.getKikenSrate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(611.111130), bzGetDrateBean.getKikenSrate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(611.111131), bzGetDrateBean.getKikenSrate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(611.111132), bzGetDrateBean.getKikenSrate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(611.111133), bzGetDrateBean.getKikenSrate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(611.111134), bzGetDrateBean.getKikenSrate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(611.111135), bzGetDrateBean.getKikenSrate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(611.111136), bzGetDrateBean.getKikenSrate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(611.111137), bzGetDrateBean.getKikenSrate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(611.111138), bzGetDrateBean.getKikenSrate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(611.111139), bzGetDrateBean.getKikenSrate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(611.111140), bzGetDrateBean.getKikenSrate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(611.111141), bzGetDrateBean.getKikenSrate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(611.111142), bzGetDrateBean.getKikenSrate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(611.111143), bzGetDrateBean.getKikenSrate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(611.111144), bzGetDrateBean.getKikenSrate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(611.111145), bzGetDrateBean.getKikenSrate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(611.111146), bzGetDrateBean.getKikenSrate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(611.111147), bzGetDrateBean.getKikenSrate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(611.111148), bzGetDrateBean.getKikenSrate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(611.111149), bzGetDrateBean.getKikenSrate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(611.111150), bzGetDrateBean.getKikenSrate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(611.111151), bzGetDrateBean.getKikenSrate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(611.111152), bzGetDrateBean.getKikenSrate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(611.111153), bzGetDrateBean.getKikenSrate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(611.111154), bzGetDrateBean.getKikenSrate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(611.111155), bzGetDrateBean.getKikenSrate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(611.111156), bzGetDrateBean.getKikenSrate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(611.111157), bzGetDrateBean.getKikenSrate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(611.111158), bzGetDrateBean.getKikenSrate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(611.111159), bzGetDrateBean.getKikenSrate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(611.111160), bzGetDrateBean.getKikenSrate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(611.111161), bzGetDrateBean.getKikenSrate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(611.111162), bzGetDrateBean.getKikenSrate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(611.111163), bzGetDrateBean.getKikenSrate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(611.111164), bzGetDrateBean.getKikenSrate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(611.111165), bzGetDrateBean.getKikenSrate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(611.111166), bzGetDrateBean.getKikenSrate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(611.111167), bzGetDrateBean.getKikenSrate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(611.111168), bzGetDrateBean.getKikenSrate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(611.111169), bzGetDrateBean.getKikenSrate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(611.111170), bzGetDrateBean.getKikenSrate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(611.111171), bzGetDrateBean.getKikenSrate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(611.111172), bzGetDrateBean.getKikenSrate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(611.111173), bzGetDrateBean.getKikenSrate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(611.111174), bzGetDrateBean.getKikenSrate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(611.111175), bzGetDrateBean.getKikenSrate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(611.111176), bzGetDrateBean.getKikenSrate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(611.111177), bzGetDrateBean.getKikenSrate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(611.111178), bzGetDrateBean.getKikenSrate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(611.111179), bzGetDrateBean.getKikenSrate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(611.111180), bzGetDrateBean.getKikenSrate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(611.111181), bzGetDrateBean.getKikenSrate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(611.111182), bzGetDrateBean.getKikenSrate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(611.111183), bzGetDrateBean.getKikenSrate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(611.111184), bzGetDrateBean.getKikenSrate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(611.111185), bzGetDrateBean.getKikenSrate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(611.111186), bzGetDrateBean.getKikenSrate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(611.111187), bzGetDrateBean.getKikenSrate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(611.111188), bzGetDrateBean.getKikenSrate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(611.111189), bzGetDrateBean.getKikenSrate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(611.111190), bzGetDrateBean.getKikenSrate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(611.111191), bzGetDrateBean.getKikenSrate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(611.111192), bzGetDrateBean.getKikenSrate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(611.111193), bzGetDrateBean.getKikenSrate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(611.111194), bzGetDrateBean.getKikenSrate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(611.111195), bzGetDrateBean.getKikenSrate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(611.111196), bzGetDrateBean.getKikenSrate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(611.111197), bzGetDrateBean.getKikenSrate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(611.111198), bzGetDrateBean.getKikenSrate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(611.111199), bzGetDrateBean.getKikenSrate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(611.111200), bzGetDrateBean.getKikenSrate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(611.111201), bzGetDrateBean.getKikenSrate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(611.111202), bzGetDrateBean.getKikenSrate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(611.111203), bzGetDrateBean.getKikenSrate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(611.111204), bzGetDrateBean.getKikenSrate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(611.111205), bzGetDrateBean.getKikenSrate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(611.111206), bzGetDrateBean.getKikenSrate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(611.111207), bzGetDrateBean.getKikenSrate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(611.111208), bzGetDrateBean.getKikenSrate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(611.111209), bzGetDrateBean.getKikenSrate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(611.111210), bzGetDrateBean.getKikenSrate().get(99));

        int n=0;
        logger.debug("結果区分 　　 = " + bzGetDrateBean.getErrorKbn() );
        for (n=0; n<=99; n++){
            logger.debug("Ｄレート" + n + "　　 = " + bzGetDrateBean.getDrate().get(n) );
        }
        for (n=0; n<=99; n++){
            logger.debug("死差Ｄレート" + n + " = " + bzGetDrateBean.getShisaDrate().get(n) );
        }
        for (n=0; n<=99; n++){
            logger.debug("利差Ｄレート" + n + " = " + bzGetDrateBean.getRisaDrate().get(n) );
        }
        for (n=0; n<=99; n++){
            logger.debug("費差Ｄレート" + n + " = " + bzGetDrateBean.getHisaDrate().get(n) );
        }
        for (n=0; n<=99; n++){
            logger.debug("Ｄ用Ｖレート" + n + " = " + bzGetDrateBean.getDyouVrate().get(n) );
        }
        for (n=0; n<=99; n++){
            logger.debug("危険Ｓレート" + n + " = " + bzGetDrateBean.getKikenSrate().get(n) );
        }

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BzGetDrateBean bzGetDrateBean =
            bzGetDrate.exec("1334"
                , "765"
                , BizNumber.valueOf(1.1234)
                , C_Hrkkaisuu.ITIJI
                , C_Hhknsei.FEMALE
                , 30
                , C_HknkknsmnKbn.SAIMANKI
                , 10
                , 20
                , "2015"
                , C_NaiteiKakuteiKbn.KAKUTEI
                , C_DRateGetKbn.ONEYEAR
                , 11);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(11.111111), bzGetDrateBean.getDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(11.111112), bzGetDrateBean.getShisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(11.111113), bzGetDrateBean.getRisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(11.111114), bzGetDrateBean.getHisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(11.111115), bzGetDrateBean.getDyouVrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(11.111116), bzGetDrateBean.getKikenSrate().get(0));

        logger.debug("結果区分　　 = " + bzGetDrateBean.getErrorKbn() );
        logger.debug("Ｄレート　　 = " + bzGetDrateBean.getDrate().get(0) );
        logger.debug("死差Ｄレート = " + bzGetDrateBean.getShisaDrate().get(0) );
        logger.debug("利差Ｄレート = " + bzGetDrateBean.getRisaDrate().get(0) );
        logger.debug("費差Ｄレート = " + bzGetDrateBean.getHisaDrate().get(0) );
        logger.debug("Ｄ用Ｖレート = " + bzGetDrateBean.getDyouVrate().get(0) );
        logger.debug("危険Ｓレート = " + bzGetDrateBean.getKikenSrate().get(0) );
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BzGetDrateBean bzGetDrateBean = bzGetDrate.exec("2234"
            , "765"
            , BizNumber.valueOf(1.1234)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.FEMALE
            , 30
            , C_HknkknsmnKbn.SAIMANKI
            , 99
            , 20
            , "2015"
            , C_NaiteiKakuteiKbn.KAKUTEI
            , C_DRateGetKbn.TWOYEARS
            , 99);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetDrateBean.getRateGetErrorKbn()
            , C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");

        logger.debug("結果区分　 = " + bzGetDrateBean.getErrorKbn() );
        logger.debug("エラー区分 = " + bzGetDrateBean.getRateGetErrorKbn() );
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BzGetDrateBean bzGetDrateBean = bzGetDrate.exec("1434"
            , "765"
            , BizNumber.valueOf(0.0034)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.MALE
            , 30
            , C_HknkknsmnKbn.SAIMANKI
            , 99
            , 20
            , "2015"
            , C_NaiteiKakuteiKbn.NAITEI
            , C_DRateGetKbn.TWOYEARS
            , 98);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(196), bzGetDrateBean.getDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(197), bzGetDrateBean.getDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(296), bzGetDrateBean.getShisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(297), bzGetDrateBean.getShisaDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(396), bzGetDrateBean.getRisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(397), bzGetDrateBean.getRisaDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(496), bzGetDrateBean.getHisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(497), bzGetDrateBean.getHisaDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(596), bzGetDrateBean.getDyouVrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(597), bzGetDrateBean.getDyouVrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(696), bzGetDrateBean.getKikenSrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(697), bzGetDrateBean.getKikenSrate().get(1));

        int n=0;
        logger.debug("結果区分 　　 = " + bzGetDrateBean.getErrorKbn() );
        for (n=0; n<=1; n++){
            logger.debug("Ｄレート" + n + "　　 = " + bzGetDrateBean.getDrate().get(n) );
        }
        for (n=0; n<=1; n++){
            logger.debug("死差Ｄレート" + n + " = " + bzGetDrateBean.getShisaDrate().get(n) );
        }
        for (n=0; n<=1; n++){
            logger.debug("利差Ｄレート" + n + " = " + bzGetDrateBean.getRisaDrate().get(n) );
        }
        for (n=0; n<=1; n++){
            logger.debug("費差Ｄレート" + n + " = " + bzGetDrateBean.getHisaDrate().get(n) );
        }
        for (n=0; n<=1; n++){
            logger.debug("Ｄ用Ｖレート" + n + " = " + bzGetDrateBean.getDyouVrate().get(n) );
        }
        for (n=0; n<=1; n++){
            logger.debug("危険Ｓレート" + n + " = " + bzGetDrateBean.getKikenSrate().get(n) );
        }
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BzGetDrateBean bzGetDrateBean = bzGetDrate.exec("1534"
            , "765"
            , BizNumber.valueOf(1.1234)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.MALE
            , 30
            , C_HknkknsmnKbn.SAIMANKI
            , 99
            , 20
            , "2015"
            , C_NaiteiKakuteiKbn.NAITEI
            , C_DRateGetKbn.NONE
            , 99);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");

        logger.debug("結果区分　　　　 = " + bzGetDrateBean.getErrorKbn() );
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        BzGetDrateBean bzGetDrateBean = bzGetDrate.exec("1634"
            , "765"
            , BizNumber.valueOf(0.0004)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.FEMALE
            , 30
            , C_HknkknsmnKbn.NENMANKI
            , 15
            , 20
            , "2015"
            , C_NaiteiKakuteiKbn.NAITEI
            , C_DRateGetKbn.ALL
            , 14);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(100), bzGetDrateBean.getDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(101), bzGetDrateBean.getDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(102), bzGetDrateBean.getDrate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(99));
        assertEquals("BizNumber", BizNumber.valueOf(200), bzGetDrateBean.getShisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(201), bzGetDrateBean.getShisaDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(202), bzGetDrateBean.getShisaDrate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(99));
        assertEquals("BizNumber", BizNumber.valueOf(300), bzGetDrateBean.getRisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(301), bzGetDrateBean.getRisaDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(302), bzGetDrateBean.getRisaDrate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(99));
        assertEquals("BizNumber", BizNumber.valueOf(400), bzGetDrateBean.getHisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(401), bzGetDrateBean.getHisaDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(402), bzGetDrateBean.getHisaDrate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(99));
        assertEquals("BizNumber", BizNumber.valueOf(500), bzGetDrateBean.getDyouVrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(501), bzGetDrateBean.getDyouVrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(502), bzGetDrateBean.getDyouVrate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(99));
        assertEquals("BizNumber", BizNumber.valueOf(600), bzGetDrateBean.getKikenSrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(601), bzGetDrateBean.getKikenSrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(602), bzGetDrateBean.getKikenSrate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(99));

        int n=0;
        logger.debug("結果区分　　 = " + bzGetDrateBean.getErrorKbn() );
        for (n=0; n<=99; n++){
            logger.debug("Ｄレート" + n + "　　 = " + bzGetDrateBean.getDrate().get(n) );
        }
        for (n=0; n<=99; n++){
            logger.debug("死差Ｄレート" + n + " = " + bzGetDrateBean.getShisaDrate().get(n) );
        }
        for (n=0; n<=99; n++){
            logger.debug("利差Ｄレート" + n + " = " + bzGetDrateBean.getRisaDrate().get(n) );
        }
        for (n=0; n<=99; n++){
            logger.debug("費差Ｄレート" + n + " = " + bzGetDrateBean.getHisaDrate().get(n) );
        }
        for (n=0; n<=99; n++){
            logger.debug("Ｄ用Ｖレート" + n + " = " + bzGetDrateBean.getDyouVrate().get(n) );
        }
        for (n=0; n<=99; n++){
            logger.debug("危険Ｓレート" + n + " = " + bzGetDrateBean.getKikenSrate().get(n) );
        }

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        BzGetDrateBean bzGetDrateBean = bzGetDrate.exec("1734"
            , "765"
            , BizNumber.valueOf(1.1234)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.MALE
            , 30
            , C_HknkknsmnKbn.SAIMANKI
            , 99
            , 20
            , "2015"
            , C_NaiteiKakuteiKbn.NAITEI
            , C_DRateGetKbn.TWOYEARS
            , 98);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(198), bzGetDrateBean.getDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(298), bzGetDrateBean.getShisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(398), bzGetDrateBean.getRisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getRisaDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(498), bzGetDrateBean.getHisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(598), bzGetDrateBean.getDyouVrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getDyouVrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(698), bzGetDrateBean.getKikenSrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(1));

        int n=0;
        logger.debug("結果区分 　　 = " + bzGetDrateBean.getErrorKbn() );
        for (n=0; n<=1; n++){
            logger.debug("Ｄレート" + n + "　　 = " + bzGetDrateBean.getDrate().get(n) );
        }
        for (n=0; n<=1; n++){
            logger.debug("死差Ｄレート" + n + " = " + bzGetDrateBean.getShisaDrate().get(n) );
        }
        for (n=0; n<=1; n++){
            logger.debug("利差Ｄレート" + n + " = " + bzGetDrateBean.getRisaDrate().get(n) );
        }
        for (n=0; n<=1; n++){
            logger.debug("費差Ｄレート" + n + " = " + bzGetDrateBean.getHisaDrate().get(n) );
        }
        for (n=0; n<=1; n++){
            logger.debug("Ｄ用Ｖレート" + n + " = " + bzGetDrateBean.getDyouVrate().get(n) );
        }
        for (n=0; n<=1; n++){
            logger.debug("危険Ｓレート" + n + " = " + bzGetDrateBean.getKikenSrate().get(n) );
        }

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        BzGetDrateBean bzGetDrateBean = bzGetDrate.exec("1834"
            , "765"
            , BizNumber.valueOf(1.1234)
            , C_Hrkkaisuu.HALFY
            , C_Hhknsei.FEMALE
            , 30
            , C_HknkknsmnKbn.SAIMANKI
            , 10
            , 20
            , "2015"
            , C_NaiteiKakuteiKbn.KAKUTEI
            , C_DRateGetKbn.ONEYEAR
            , 11);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(0.111111), bzGetDrateBean.getDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0.111112), bzGetDrateBean.getShisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0.111113), bzGetDrateBean.getRisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0.111114), bzGetDrateBean.getHisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0.111115), bzGetDrateBean.getDyouVrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0.111116), bzGetDrateBean.getKikenSrate().get(0));

        logger.debug("結果区分　　 = " + bzGetDrateBean.getErrorKbn() );
        logger.debug("Ｄレート　　 = " + bzGetDrateBean.getDrate().get(0) );
        logger.debug("死差Ｄレート = " + bzGetDrateBean.getShisaDrate().get(0) );
        logger.debug("利差Ｄレート = " + bzGetDrateBean.getRisaDrate().get(0) );
        logger.debug("費差Ｄレート = " + bzGetDrateBean.getHisaDrate().get(0) );
        logger.debug("Ｄ用Ｖレート = " + bzGetDrateBean.getDyouVrate().get(0) );
        logger.debug("危険Ｓレート = " + bzGetDrateBean.getKikenSrate().get(0) );
    }

    @Test
    @TestOrder(140)
    public void testExec_A11() {

        BzGetDrateBean bzGetDrateBean =
            bzGetDrate.exec("2580"
                , "963"
                , BizNumber.valueOf(1.1234)
                , C_Hrkkaisuu.ITIJI
                , C_Hhknsei.MALE
                , 9
                , C_HknkknsmnKbn.NENMANKI
                , 9
                , 2
                , "2015"
                , C_NaiteiKakuteiKbn.KAKUTEI
                , C_DRateGetKbn.ONEYEAR
                , 9);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetDrateBean.getRateGetErrorKbn()
            , C_RateGetErrorKbn.TARGETERROR, "レート取得エラー区分");

        logger.debug("結果区分　 = " + bzGetDrateBean.getErrorKbn() );
        logger.debug("エラー区分 = " + bzGetDrateBean.getRateGetErrorKbn() );
    }

    @Test
    @TestOrder(150)
    public void testExec_A12() {

        BzGetDrateBean bzGetDrateBean = bzGetDrate.exec("2681"
            , "964"
            , BizNumber.valueOf(1.1234)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.FEMALE
            , 30
            , C_HknkknsmnKbn.NENMANKI
            , 15
            , 20
            , "2015"
            , C_NaiteiKakuteiKbn.NAITEI
            , C_DRateGetKbn.ALL
            , 14);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(111.111111), bzGetDrateBean.getDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(111.111112), bzGetDrateBean.getDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(111.111113), bzGetDrateBean.getDrate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(111.111114), bzGetDrateBean.getDrate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(111.111115), bzGetDrateBean.getDrate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(111.111116), bzGetDrateBean.getDrate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(111.111117), bzGetDrateBean.getDrate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(111.111118), bzGetDrateBean.getDrate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(111.111119), bzGetDrateBean.getDrate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(111.111120), bzGetDrateBean.getDrate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(111.111121), bzGetDrateBean.getDrate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(111.111122), bzGetDrateBean.getDrate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(111.111123), bzGetDrateBean.getDrate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(111.111124), bzGetDrateBean.getDrate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(111.111125), bzGetDrateBean.getDrate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(111.111126), bzGetDrateBean.getDrate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(111.111127), bzGetDrateBean.getDrate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(111.111128), bzGetDrateBean.getDrate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(111.111129), bzGetDrateBean.getDrate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(111.111130), bzGetDrateBean.getDrate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(111.111131), bzGetDrateBean.getDrate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(111.111132), bzGetDrateBean.getDrate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(111.111133), bzGetDrateBean.getDrate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(111.111134), bzGetDrateBean.getDrate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(111.111135), bzGetDrateBean.getDrate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(111.111136), bzGetDrateBean.getDrate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(111.111137), bzGetDrateBean.getDrate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(111.111138), bzGetDrateBean.getDrate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(111.111139), bzGetDrateBean.getDrate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(111.111140), bzGetDrateBean.getDrate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(111.111141), bzGetDrateBean.getDrate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(111.111142), bzGetDrateBean.getDrate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(111.111143), bzGetDrateBean.getDrate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(111.111144), bzGetDrateBean.getDrate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(111.111145), bzGetDrateBean.getDrate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(111.111146), bzGetDrateBean.getDrate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(111.111147), bzGetDrateBean.getDrate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(111.111148), bzGetDrateBean.getDrate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(111.111149), bzGetDrateBean.getDrate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(111.111150), bzGetDrateBean.getDrate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(111.111151), bzGetDrateBean.getDrate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(111.111152), bzGetDrateBean.getDrate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(111.111153), bzGetDrateBean.getDrate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(111.111154), bzGetDrateBean.getDrate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(111.111155), bzGetDrateBean.getDrate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(111.111156), bzGetDrateBean.getDrate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(111.111157), bzGetDrateBean.getDrate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(111.111158), bzGetDrateBean.getDrate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(111.111159), bzGetDrateBean.getDrate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(111.111160), bzGetDrateBean.getDrate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(111.111161), bzGetDrateBean.getDrate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(111.111162), bzGetDrateBean.getDrate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(111.111163), bzGetDrateBean.getDrate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(111.111164), bzGetDrateBean.getDrate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(111.111165), bzGetDrateBean.getDrate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(111.111166), bzGetDrateBean.getDrate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(111.111167), bzGetDrateBean.getDrate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(111.111168), bzGetDrateBean.getDrate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(111.111169), bzGetDrateBean.getDrate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(111.111170), bzGetDrateBean.getDrate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(111.111171), bzGetDrateBean.getDrate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(111.111172), bzGetDrateBean.getDrate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(111.111173), bzGetDrateBean.getDrate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(111.111174), bzGetDrateBean.getDrate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(111.111175), bzGetDrateBean.getDrate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(111.111176), bzGetDrateBean.getDrate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(111.111177), bzGetDrateBean.getDrate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(111.111178), bzGetDrateBean.getDrate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(111.111179), bzGetDrateBean.getDrate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(111.111180), bzGetDrateBean.getDrate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(111.111181), bzGetDrateBean.getDrate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(111.111182), bzGetDrateBean.getDrate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(111.111183), bzGetDrateBean.getDrate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(111.111184), bzGetDrateBean.getDrate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(111.111185), bzGetDrateBean.getDrate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(111.111186), bzGetDrateBean.getDrate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(111.111187), bzGetDrateBean.getDrate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(111.111188), bzGetDrateBean.getDrate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(111.111189), bzGetDrateBean.getDrate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(111.111190), bzGetDrateBean.getDrate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(111.111191), bzGetDrateBean.getDrate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(111.111192), bzGetDrateBean.getDrate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(111.111193), bzGetDrateBean.getDrate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(111.111194), bzGetDrateBean.getDrate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(111.111195), bzGetDrateBean.getDrate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(111.111196), bzGetDrateBean.getDrate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(111.111197), bzGetDrateBean.getDrate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(111.111198), bzGetDrateBean.getDrate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(111.111199), bzGetDrateBean.getDrate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(111.111200), bzGetDrateBean.getDrate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(111.111201), bzGetDrateBean.getDrate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(111.111202), bzGetDrateBean.getDrate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(111.111203), bzGetDrateBean.getDrate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(111.111204), bzGetDrateBean.getDrate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(111.111205), bzGetDrateBean.getDrate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(111.111206), bzGetDrateBean.getDrate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(111.111207), bzGetDrateBean.getDrate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(111.111208), bzGetDrateBean.getDrate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(111.111209), bzGetDrateBean.getDrate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(111.111210), bzGetDrateBean.getDrate().get(99));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(99));
        assertEquals("BizNumber", BizNumber.valueOf(111.111111), bzGetDrateBean.getRisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(111.111112), bzGetDrateBean.getRisaDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(111.111113), bzGetDrateBean.getRisaDrate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(111.111114), bzGetDrateBean.getRisaDrate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(111.111115), bzGetDrateBean.getRisaDrate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(111.111116), bzGetDrateBean.getRisaDrate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(111.111117), bzGetDrateBean.getRisaDrate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(111.111118), bzGetDrateBean.getRisaDrate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(111.111119), bzGetDrateBean.getRisaDrate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(111.111120), bzGetDrateBean.getRisaDrate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(111.111121), bzGetDrateBean.getRisaDrate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(111.111122), bzGetDrateBean.getRisaDrate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(111.111123), bzGetDrateBean.getRisaDrate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(111.111124), bzGetDrateBean.getRisaDrate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(111.111125), bzGetDrateBean.getRisaDrate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(111.111126), bzGetDrateBean.getRisaDrate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(111.111127), bzGetDrateBean.getRisaDrate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(111.111128), bzGetDrateBean.getRisaDrate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(111.111129), bzGetDrateBean.getRisaDrate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(111.111130), bzGetDrateBean.getRisaDrate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(111.111131), bzGetDrateBean.getRisaDrate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(111.111132), bzGetDrateBean.getRisaDrate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(111.111133), bzGetDrateBean.getRisaDrate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(111.111134), bzGetDrateBean.getRisaDrate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(111.111135), bzGetDrateBean.getRisaDrate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(111.111136), bzGetDrateBean.getRisaDrate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(111.111137), bzGetDrateBean.getRisaDrate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(111.111138), bzGetDrateBean.getRisaDrate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(111.111139), bzGetDrateBean.getRisaDrate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(111.111140), bzGetDrateBean.getRisaDrate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(111.111141), bzGetDrateBean.getRisaDrate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(111.111142), bzGetDrateBean.getRisaDrate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(111.111143), bzGetDrateBean.getRisaDrate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(111.111144), bzGetDrateBean.getRisaDrate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(111.111145), bzGetDrateBean.getRisaDrate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(111.111146), bzGetDrateBean.getRisaDrate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(111.111147), bzGetDrateBean.getRisaDrate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(111.111148), bzGetDrateBean.getRisaDrate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(111.111149), bzGetDrateBean.getRisaDrate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(111.111150), bzGetDrateBean.getRisaDrate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(111.111151), bzGetDrateBean.getRisaDrate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(111.111152), bzGetDrateBean.getRisaDrate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(111.111153), bzGetDrateBean.getRisaDrate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(111.111154), bzGetDrateBean.getRisaDrate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(111.111155), bzGetDrateBean.getRisaDrate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(111.111156), bzGetDrateBean.getRisaDrate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(111.111157), bzGetDrateBean.getRisaDrate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(111.111158), bzGetDrateBean.getRisaDrate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(111.111159), bzGetDrateBean.getRisaDrate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(111.111160), bzGetDrateBean.getRisaDrate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(111.111161), bzGetDrateBean.getRisaDrate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(111.111162), bzGetDrateBean.getRisaDrate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(111.111163), bzGetDrateBean.getRisaDrate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(111.111164), bzGetDrateBean.getRisaDrate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(111.111165), bzGetDrateBean.getRisaDrate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(111.111166), bzGetDrateBean.getRisaDrate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(111.111167), bzGetDrateBean.getRisaDrate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(111.111168), bzGetDrateBean.getRisaDrate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(111.111169), bzGetDrateBean.getRisaDrate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(111.111170), bzGetDrateBean.getRisaDrate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(111.111171), bzGetDrateBean.getRisaDrate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(111.111172), bzGetDrateBean.getRisaDrate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(111.111173), bzGetDrateBean.getRisaDrate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(111.111174), bzGetDrateBean.getRisaDrate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(111.111175), bzGetDrateBean.getRisaDrate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(111.111176), bzGetDrateBean.getRisaDrate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(111.111177), bzGetDrateBean.getRisaDrate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(111.111178), bzGetDrateBean.getRisaDrate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(111.111179), bzGetDrateBean.getRisaDrate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(111.111180), bzGetDrateBean.getRisaDrate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(111.111181), bzGetDrateBean.getRisaDrate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(111.111182), bzGetDrateBean.getRisaDrate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(111.111183), bzGetDrateBean.getRisaDrate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(111.111184), bzGetDrateBean.getRisaDrate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(111.111185), bzGetDrateBean.getRisaDrate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(111.111186), bzGetDrateBean.getRisaDrate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(111.111187), bzGetDrateBean.getRisaDrate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(111.111188), bzGetDrateBean.getRisaDrate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(111.111189), bzGetDrateBean.getRisaDrate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(111.111190), bzGetDrateBean.getRisaDrate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(111.111191), bzGetDrateBean.getRisaDrate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(111.111192), bzGetDrateBean.getRisaDrate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(111.111193), bzGetDrateBean.getRisaDrate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(111.111194), bzGetDrateBean.getRisaDrate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(111.111195), bzGetDrateBean.getRisaDrate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(111.111196), bzGetDrateBean.getRisaDrate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(111.111197), bzGetDrateBean.getRisaDrate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(111.111198), bzGetDrateBean.getRisaDrate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(111.111199), bzGetDrateBean.getRisaDrate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(111.111200), bzGetDrateBean.getRisaDrate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(111.111201), bzGetDrateBean.getRisaDrate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(111.111202), bzGetDrateBean.getRisaDrate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(111.111203), bzGetDrateBean.getRisaDrate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(111.111204), bzGetDrateBean.getRisaDrate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(111.111205), bzGetDrateBean.getRisaDrate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(111.111206), bzGetDrateBean.getRisaDrate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(111.111207), bzGetDrateBean.getRisaDrate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(111.111208), bzGetDrateBean.getRisaDrate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(111.111209), bzGetDrateBean.getRisaDrate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(111.111210), bzGetDrateBean.getRisaDrate().get(99));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(99));
        assertEquals("BizNumber", BizNumber.valueOf(511.111111), bzGetDrateBean.getDyouVrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(511.111112), bzGetDrateBean.getDyouVrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(511.111113), bzGetDrateBean.getDyouVrate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(511.111114), bzGetDrateBean.getDyouVrate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(511.111115), bzGetDrateBean.getDyouVrate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(511.111116), bzGetDrateBean.getDyouVrate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(511.111117), bzGetDrateBean.getDyouVrate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(511.111118), bzGetDrateBean.getDyouVrate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(511.111119), bzGetDrateBean.getDyouVrate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(511.111120), bzGetDrateBean.getDyouVrate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(511.111121), bzGetDrateBean.getDyouVrate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(511.111122), bzGetDrateBean.getDyouVrate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(511.111123), bzGetDrateBean.getDyouVrate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(511.111124), bzGetDrateBean.getDyouVrate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(511.111125), bzGetDrateBean.getDyouVrate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(511.111126), bzGetDrateBean.getDyouVrate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(511.111127), bzGetDrateBean.getDyouVrate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(511.111128), bzGetDrateBean.getDyouVrate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(511.111129), bzGetDrateBean.getDyouVrate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(511.111130), bzGetDrateBean.getDyouVrate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(511.111131), bzGetDrateBean.getDyouVrate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(511.111132), bzGetDrateBean.getDyouVrate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(511.111133), bzGetDrateBean.getDyouVrate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(511.111134), bzGetDrateBean.getDyouVrate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(511.111135), bzGetDrateBean.getDyouVrate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(511.111136), bzGetDrateBean.getDyouVrate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(511.111137), bzGetDrateBean.getDyouVrate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(511.111138), bzGetDrateBean.getDyouVrate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(511.111139), bzGetDrateBean.getDyouVrate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(511.111140), bzGetDrateBean.getDyouVrate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(511.111141), bzGetDrateBean.getDyouVrate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(511.111142), bzGetDrateBean.getDyouVrate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(511.111143), bzGetDrateBean.getDyouVrate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(511.111144), bzGetDrateBean.getDyouVrate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(511.111145), bzGetDrateBean.getDyouVrate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(511.111146), bzGetDrateBean.getDyouVrate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(511.111147), bzGetDrateBean.getDyouVrate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(511.111148), bzGetDrateBean.getDyouVrate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(511.111149), bzGetDrateBean.getDyouVrate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(511.111150), bzGetDrateBean.getDyouVrate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(511.111151), bzGetDrateBean.getDyouVrate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(511.111152), bzGetDrateBean.getDyouVrate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(511.111153), bzGetDrateBean.getDyouVrate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(511.111154), bzGetDrateBean.getDyouVrate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(511.111155), bzGetDrateBean.getDyouVrate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(511.111156), bzGetDrateBean.getDyouVrate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(511.111157), bzGetDrateBean.getDyouVrate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(511.111158), bzGetDrateBean.getDyouVrate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(511.111159), bzGetDrateBean.getDyouVrate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(511.111160), bzGetDrateBean.getDyouVrate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(511.111161), bzGetDrateBean.getDyouVrate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(511.111162), bzGetDrateBean.getDyouVrate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(511.111163), bzGetDrateBean.getDyouVrate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(511.111164), bzGetDrateBean.getDyouVrate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(511.111165), bzGetDrateBean.getDyouVrate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(511.111166), bzGetDrateBean.getDyouVrate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(511.111167), bzGetDrateBean.getDyouVrate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(511.111168), bzGetDrateBean.getDyouVrate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(511.111169), bzGetDrateBean.getDyouVrate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(511.111170), bzGetDrateBean.getDyouVrate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(511.111171), bzGetDrateBean.getDyouVrate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(511.111172), bzGetDrateBean.getDyouVrate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(511.111173), bzGetDrateBean.getDyouVrate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(511.111174), bzGetDrateBean.getDyouVrate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(511.111175), bzGetDrateBean.getDyouVrate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(511.111176), bzGetDrateBean.getDyouVrate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(511.111177), bzGetDrateBean.getDyouVrate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(511.111178), bzGetDrateBean.getDyouVrate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(511.111179), bzGetDrateBean.getDyouVrate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(511.111180), bzGetDrateBean.getDyouVrate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(511.111181), bzGetDrateBean.getDyouVrate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(511.111182), bzGetDrateBean.getDyouVrate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(511.111183), bzGetDrateBean.getDyouVrate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(511.111184), bzGetDrateBean.getDyouVrate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(511.111185), bzGetDrateBean.getDyouVrate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(511.111186), bzGetDrateBean.getDyouVrate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(511.111187), bzGetDrateBean.getDyouVrate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(511.111188), bzGetDrateBean.getDyouVrate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(511.111189), bzGetDrateBean.getDyouVrate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(511.111190), bzGetDrateBean.getDyouVrate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(511.111191), bzGetDrateBean.getDyouVrate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(511.111192), bzGetDrateBean.getDyouVrate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(511.111193), bzGetDrateBean.getDyouVrate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(511.111194), bzGetDrateBean.getDyouVrate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(511.111195), bzGetDrateBean.getDyouVrate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(511.111196), bzGetDrateBean.getDyouVrate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(511.111197), bzGetDrateBean.getDyouVrate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(511.111198), bzGetDrateBean.getDyouVrate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(511.111199), bzGetDrateBean.getDyouVrate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(511.111200), bzGetDrateBean.getDyouVrate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(511.111201), bzGetDrateBean.getDyouVrate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(511.111202), bzGetDrateBean.getDyouVrate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(511.111203), bzGetDrateBean.getDyouVrate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(511.111204), bzGetDrateBean.getDyouVrate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(511.111205), bzGetDrateBean.getDyouVrate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(511.111206), bzGetDrateBean.getDyouVrate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(511.111207), bzGetDrateBean.getDyouVrate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(511.111208), bzGetDrateBean.getDyouVrate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(511.111209), bzGetDrateBean.getDyouVrate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(511.111210), bzGetDrateBean.getDyouVrate().get(99));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(99));

        int n=0;
        logger.debug("結果区分 　　 = " + bzGetDrateBean.getErrorKbn() );
        for (n=0; n<=99; n++){
            logger.debug("Ｄレート" + n + "　　 = " + bzGetDrateBean.getDrate().get(n) );
        }
        for (n=0; n<=99; n++){
            logger.debug("死差Ｄレート" + n + " = " + bzGetDrateBean.getShisaDrate().get(n) );
        }
        for (n=0; n<=99; n++){
            logger.debug("利差Ｄレート" + n + " = " + bzGetDrateBean.getRisaDrate().get(n) );
        }
        for (n=0; n<=99; n++){
            logger.debug("費差Ｄレート" + n + " = " + bzGetDrateBean.getHisaDrate().get(n) );
        }
        for (n=0; n<=99; n++){
            logger.debug("Ｄ用Ｖレート" + n + " = " + bzGetDrateBean.getDyouVrate().get(n) );
        }
        for (n=0; n<=99; n++){
            logger.debug("危険Ｓレート" + n + " = " + bzGetDrateBean.getKikenSrate().get(n) );
        }

    }

    @Test
    @TestOrder(160)
    public void testExec_A13() {

        BzGetDrateBean bzGetDrateBean =
            bzGetDrate.exec("2782"
                , "964"
                , BizNumber.valueOf(1.1234)
                , C_Hrkkaisuu.ITIJI
                , C_Hhknsei.FEMALE
                , 30
                , C_HknkknsmnKbn.SAIMANKI
                , 10
                , 20
                , "2015"
                , C_NaiteiKakuteiKbn.KAKUTEI
                , C_DRateGetKbn.ONEYEAR
                , 11);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(0.111111), bzGetDrateBean.getDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0.111111), bzGetDrateBean.getRisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0.111112), bzGetDrateBean.getDyouVrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(0));

        logger.debug("結果区分　　 = " + bzGetDrateBean.getErrorKbn() );
        logger.debug("Ｄレート　　 = " + bzGetDrateBean.getDrate().get(0) );
        logger.debug("死差Ｄレート = " + bzGetDrateBean.getShisaDrate().get(0) );
        logger.debug("利差Ｄレート = " + bzGetDrateBean.getRisaDrate().get(0) );
        logger.debug("費差Ｄレート = " + bzGetDrateBean.getHisaDrate().get(0) );
        logger.debug("Ｄ用Ｖレート = " + bzGetDrateBean.getDyouVrate().get(0) );
        logger.debug("危険Ｓレート = " + bzGetDrateBean.getKikenSrate().get(0) );
    }

    @Test
    @TestOrder(170)
    public void testExec_A14() {

        BzGetDrateBean bzGetDrateBean = bzGetDrate.exec("2883"
            , "964"
            , BizNumber.valueOf(0.0034)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.MALE
            , 30
            , C_HknkknsmnKbn.SAIMANKI
            , 99
            , 20
            , "2015"
            , C_NaiteiKakuteiKbn.NAITEI
            , C_DRateGetKbn.TWOYEARS
            , 98);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(196), bzGetDrateBean.getDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(197), bzGetDrateBean.getDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getShisaDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(196), bzGetDrateBean.getRisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(197), bzGetDrateBean.getRisaDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getHisaDrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(296), bzGetDrateBean.getDyouVrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(297), bzGetDrateBean.getDyouVrate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetDrateBean.getKikenSrate().get(1));

        int n=0;
        logger.debug("結果区分 　　 = " + bzGetDrateBean.getErrorKbn() );
        for (n=0; n<=1; n++){
            logger.debug("Ｄレート" + n + "　　 = " + bzGetDrateBean.getDrate().get(n) );
        }
        for (n=0; n<=1; n++){
            logger.debug("死差Ｄレート" + n + " = " + bzGetDrateBean.getShisaDrate().get(n) );
        }
        for (n=0; n<=1; n++){
            logger.debug("利差Ｄレート" + n + " = " + bzGetDrateBean.getRisaDrate().get(n) );
        }
        for (n=0; n<=1; n++){
            logger.debug("費差Ｄレート" + n + " = " + bzGetDrateBean.getHisaDrate().get(n) );
        }
        for (n=0; n<=1; n++){
            logger.debug("Ｄ用Ｖレート" + n + " = " + bzGetDrateBean.getDyouVrate().get(n) );
        }
        for (n=0; n<=1; n++){
            logger.debug("危険Ｓレート" + n + " = " + bzGetDrateBean.getKikenSrate().get(n) );
        }
    }

    @Test
    @TestOrder(180)
    public void testExec_A15() {

        BzGetDrateBean bzGetDrateBean =
            bzGetDrate.exec("2782"
                , "964"
                , BizNumber.valueOf(1.1234)
                , C_Hrkkaisuu.ITIJI
                , C_Hhknsei.FEMALE
                , 30
                , C_HknkknsmnKbn.SAIMANKI
                , 10
                , 20
                , "2015"
                , C_NaiteiKakuteiKbn.KAKUTEI
                , C_DRateGetKbn.NONE
                , 11);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(210)
    public void testExec_B01() {
        BzGetDrateBean bzGetDrateBean =
            bzGetDrate.exec("2134"
                , "J"
                , BizNumber.valueOf(1.1234)
                , C_Hrkkaisuu.ITIJI
                , C_Hhknsei.FEMALE
                , 30
                , C_HknkknsmnKbn.NENMANKI
                , 15
                , 20
                , "2018"
                , C_NaiteiKakuteiKbn.NAITEI
                , C_DRateGetKbn.ALL
                , 14);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(100), bzGetDrateBean.getDrate().get(0));
    }

    @Test
    @TestOrder(220)
    public void testExec_B02() {
        BzGetDrateBean bzGetDrateBean =
            bzGetDrate.exec("2134"
                , "K"
                , BizNumber.valueOf(1.1234)
                , C_Hrkkaisuu.ITIJI
                , C_Hhknsei.FEMALE
                , 30
                , C_HknkknsmnKbn.NENMANKI
                , 15
                , 20
                , "2018"
                , C_NaiteiKakuteiKbn.NAITEI
                , C_DRateGetKbn.ALL
                , 14);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(100), bzGetDrateBean.getDrate().get(0));
    }

    @Test
    @TestOrder(230)
    public void testExec_B03() {
        BzGetDrateBean bzGetDrateBean =
            bzGetDrate.exec("2134"
                , "L"
                , BizNumber.valueOf(1.1234)
                , C_Hrkkaisuu.ITIJI
                , C_Hhknsei.FEMALE
                , 30
                , C_HknkknsmnKbn.NENMANKI
                , 15
                , 20
                , "2018"
                , C_NaiteiKakuteiKbn.NAITEI
                , C_DRateGetKbn.ALL
                , 14);

        exClassificationEquals(bzGetDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(200), bzGetDrateBean.getDrate().get(0));
    }
}
