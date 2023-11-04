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
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_NenkinDRateGetKbn;
import yuyu.def.classification.C_NenkinJimuTesuuryouKbn;
import yuyu.def.classification.C_NenkinKbn;
import yuyu.def.classification.C_NenkinKigouSedaiKbn;
import yuyu.def.classification.C_RateGetErrorKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年金開始後Ｄレート取得クラスのメソッド {@link BzGetNenkinDrate#exec(C_NenkinKbn, String, C_NenkinKigouSedaiKbn, String, String, C_NenkinJimuTesuuryouKbn, String, C_NaiteiKakuteiKbn, C_NenkinDRateGetKbn, int)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetNenkinDrateTest_exec {

    @Inject
    private BzGetNenkinDrate bzGetNenkinDrate;

    private final static String fileName = "UT_SP_単体テスト仕様書_年金開始後Dレート取得処理";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetNenkinDrateTest_exec.class, fileName, sheetName);
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
        bizDomManager.delete(bizDomManager.getAllRateNenkinD());
    }


    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BzGetNenkinDrateBean bzGetNenkinDrateBean = bzGetNenkinDrate.exec(C_NenkinKbn.YUYU
            , "2009"
            , C_NenkinKigouSedaiKbn.KAI10S
            , "9"
            , "90"
            , C_NenkinJimuTesuuryouKbn.PER1_00
            , "1001"
            , C_NaiteiKakuteiKbn.KAKUTEI
            , C_NenkinDRateGetKbn.ONEYEAR
            , 10);

        exClassificationEquals(bzGetNenkinDrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetNenkinDrateBean.getRateGetErrorKbn()
            , C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BzGetNenkinDrateBean bzGetNenkinDrateBean = bzGetNenkinDrate.exec(C_NenkinKbn.YUYU, "2009", C_NenkinKigouSedaiKbn.KAI10S, "10", "90", C_NenkinJimuTesuuryouKbn.PER1_00, "1001", C_NaiteiKakuteiKbn.KAKUTEI, C_NenkinDRateGetKbn.ONEYEAR, 10);

        exClassificationEquals(bzGetNenkinDrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BzGetNenkinDrateBean bzGetNenkinDrateBean = bzGetNenkinDrate.exec(C_NenkinKbn.YUYU
            , "1009"
            , C_NenkinKigouSedaiKbn.KAI10S
            , "11"
            , "90"
            , C_NenkinJimuTesuuryouKbn.PER1_00
            , "1001"
            , C_NaiteiKakuteiKbn.KAKUTEI
            , C_NenkinDRateGetKbn.ALL
            , 10);

        exClassificationEquals(bzGetNenkinDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(100), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(200), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(300), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(400), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(500), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(600), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(700), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(800), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(900), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(1000), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(1100), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(1200), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(1300), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(1400), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(1500), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(1600), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(1700), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(1800), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(1900), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(2000), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(2100), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(2200), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(2300), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(2400), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(2500), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(2600), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(2700), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(2800), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(2900), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(3000), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(3100), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(3200), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(3300), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(3400), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(3500), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(3600), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(3700), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(3800), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(3900), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(4000), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(4100), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(4200), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(4300), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(4400), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(4500), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(4600), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(4700), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(4800), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(4900), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(5000), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(5100), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(5200), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(5300), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(5400), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(5500), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(5600), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(5700), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(5800), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(5900), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(6000), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(6100), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(6200), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(6300), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(6400), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(6500), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(6600), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(6700), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(6800), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(6900), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(7000), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(7100), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(7200), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(7300), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(7400), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(7500), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(7600), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(7700), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(7800), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(7900), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(8000), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(8100), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(8200), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(8300), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(8400), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(8500), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(8600), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(8700), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(8800), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(8900), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(9000), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(9100), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(9200), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(9300), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(9400), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(9500), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(9600), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(9700), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(9800), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(9900), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(10000), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(99));
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BzGetNenkinDrateBean bzGetNenkinDrateBean = bzGetNenkinDrate.exec(C_NenkinKbn.YUYU
            , "2009"
            , C_NenkinKigouSedaiKbn.KAI10S
            , "99"
            , "90"
            , C_NenkinJimuTesuuryouKbn.PER1_00
            , "1001"
            , C_NaiteiKakuteiKbn.KAKUTEI
            , C_NenkinDRateGetKbn.TWOYEARS
            , 99);

        exClassificationEquals(bzGetNenkinDrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetNenkinDrateBean.getRateGetErrorKbn()
            , C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BzGetNenkinDrateBean bzGetNenkinDrateBean = bzGetNenkinDrate.exec(C_NenkinKbn.YUYU
            , "1009"
            , C_NenkinKigouSedaiKbn.KAI10S
            , "10"
            , "90"
            , C_NenkinJimuTesuuryouKbn.PER1_00
            , "1002"
            , C_NaiteiKakuteiKbn.NAITEI
            , C_NenkinDRateGetKbn.TWOYEARS
            , 10);

        exClassificationEquals(bzGetNenkinDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(2000), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(3000), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(1));
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BzGetNenkinDrateBean bzGetNenkinDrateBean = bzGetNenkinDrate.exec(C_NenkinKbn.YUYU
            , "1009"
            , C_NenkinKigouSedaiKbn.KAI10S
            , "99"
            , "90"
            , C_NenkinJimuTesuuryouKbn.PER1_25
            , "1003"
            , C_NaiteiKakuteiKbn.KAKUTEI
            , C_NenkinDRateGetKbn.ONEYEAR
            , 99);

        exClassificationEquals(bzGetNenkinDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(990), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(0));
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BzGetNenkinDrateBean bzGetNenkinDrateBean = bzGetNenkinDrate.exec(C_NenkinKbn.YUYU
            , "1009"
            , C_NenkinKigouSedaiKbn.KAI10S
            , "10"
            , "90"
            , C_NenkinJimuTesuuryouKbn.PER1_00
            , "1004"
            , C_NaiteiKakuteiKbn.KAKUTEI
            , C_NenkinDRateGetKbn.NONE
            , 10);

        exClassificationEquals(bzGetNenkinDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        BzGetNenkinDrateBean bzGetNenkinDrateBean = bzGetNenkinDrate.exec(C_NenkinKbn.YUYU
            , "1009"
            , C_NenkinKigouSedaiKbn.KAI10S
            , "11"
            , "90"
            , C_NenkinJimuTesuuryouKbn.PER1_00
            , "1005"
            , C_NaiteiKakuteiKbn.KAKUTEI
            , C_NenkinDRateGetKbn.ALL
            , 10);

        exClassificationEquals(bzGetNenkinDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(1000), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(2000), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(3000), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(99));
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        BzGetNenkinDrateBean bzGetNenkinDrateBean = bzGetNenkinDrate.exec(C_NenkinKbn.YUYU
            , "1009"
            , C_NenkinKigouSedaiKbn.KAI10S
            , "10"
            , "90"
            , C_NenkinJimuTesuuryouKbn.PER1_00
            , "1006"
            , C_NaiteiKakuteiKbn.NAITEI
            , C_NenkinDRateGetKbn.TWOYEARS
            , 10);

        exClassificationEquals(bzGetNenkinDrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(2000), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinDrateBean.getNenkinKaisigodRate().get(1));
    }
}
