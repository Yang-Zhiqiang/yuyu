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
import yuyu.def.classification.C_NenkinJimuTesuuryouKbn;
import yuyu.def.classification.C_NenkinKbn;
import yuyu.def.classification.C_NenkinKigouSedaiKbn;
import yuyu.def.classification.C_NenkinVRateGetKbn;
import yuyu.def.classification.C_RateGetErrorKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年金開始後Ｐ基礎Ｖレート取得クラスのメソッド {@link BzGetNenkinPkisoVrate#exec(C_NenkinKbn, String, C_NenkinKigouSedaiKbn, String, String, C_NenkinJimuTesuuryouKbn, C_NenkinVRateGetKbn, int)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetNenkinPkisoVrateTest_exec {

    @Inject
    private BzGetNenkinPkisoVrate bzGetNenkinPkisoVrate;

    private final static String fileName = "UT_SP_単体テスト仕様書_年金開始後Ｐ基礎Ｖレート取得";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetNenkinPkisoVrateTest_exec.class, fileName, sheetName);
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
        bizDomManager.delete(bizDomManager.getAllRateNenkinPkisoV());
    }


    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BzGetNenkinPkisoVrateBean bzGetNenkinPkisoVrateBean = bzGetNenkinPkisoVrate.exec(C_NenkinKbn.YUYU
            , "2100"
            , C_NenkinKigouSedaiKbn.KAI10S
            , "10"
            , "90"
            , C_NenkinJimuTesuuryouKbn.PER1_00
            , C_NenkinVRateGetKbn.ONEYEAR
            , 11);

        exClassificationEquals(bzGetNenkinPkisoVrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetNenkinPkisoVrateBean.getRateGetErrorKbn()
            , C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BzGetNenkinPkisoVrateBean bzGetNenkinPkisoVrateBean = bzGetNenkinPkisoVrate.exec(C_NenkinKbn.YUYU
            , "2100"
            , C_NenkinKigouSedaiKbn.KAI10S
            , "10"
            , "90"
            , C_NenkinJimuTesuuryouKbn.PER1_00
            , C_NenkinVRateGetKbn.ONEYEAR
            , 10);

        exClassificationEquals(bzGetNenkinPkisoVrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BzGetNenkinPkisoVrateBean bzGetNenkinPkisoVrateBean = bzGetNenkinPkisoVrate.exec(C_NenkinKbn.YUYU
            , "1100"
            , C_NenkinKigouSedaiKbn.KAI10S
            , "12"
            , "90"
            , C_NenkinJimuTesuuryouKbn.PER1_00
            , C_NenkinVRateGetKbn.ALL
            , 10);

        exClassificationEquals(bzGetNenkinPkisoVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(10), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(20), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(30), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(40), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(50), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(60), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(70), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(80), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(90), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(100), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(110), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(120), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(130), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(140), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(150), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(160), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(170), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(180), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(190), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(200), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(210), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(220), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(230), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(240), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(250), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(260), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(270), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(280), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(290), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(300), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(310), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(320), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(330), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(340), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(350), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(360), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(370), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(380), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(390), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(400), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(410), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(420), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(430), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(440), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(450), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(460), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(470), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(480), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(490), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(500), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(510), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(520), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(530), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(540), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(550), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(560), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(570), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(580), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(590), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(600), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(610), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(620), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(630), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(640), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(650), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(660), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(670), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(680), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(690), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(700), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(710), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(720), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(730), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(740), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(750), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(760), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(770), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(780), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(790), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(800), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(810), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(820), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(830), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(840), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(850), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(860), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(870), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(880), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(890), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(900), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(910), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(920), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(930), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(940), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(950), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(960), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(970), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(980), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(990), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(1000), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(99));
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BzGetNenkinPkisoVrateBean bzGetNenkinPkisoVrateBean = bzGetNenkinPkisoVrate.exec(C_NenkinKbn.YUYU
            , "2100"
            , C_NenkinKigouSedaiKbn.KAI10S
            , "99"
            , "90"
            , C_NenkinJimuTesuuryouKbn.PER1_00
            , C_NenkinVRateGetKbn.TWOYEARS
            , 99);

        exClassificationEquals(bzGetNenkinPkisoVrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetNenkinPkisoVrateBean.getRateGetErrorKbn()
            , C_RateGetErrorKbn.INPUTERROR, "レート取得エラー区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BzGetNenkinPkisoVrateBean bzGetNenkinPkisoVrateBean = bzGetNenkinPkisoVrate.exec(C_NenkinKbn.YUYU
            , "1200"
            , C_NenkinKigouSedaiKbn.KAI10S
            , "10"
            , "90"
            , C_NenkinJimuTesuuryouKbn.PER1_00
            , C_NenkinVRateGetKbn.TWOYEARS
            , 10);

        exClassificationEquals(bzGetNenkinPkisoVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(2000), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(3000), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(1));
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BzGetNenkinPkisoVrateBean bzGetNenkinPkisoVrateBean = bzGetNenkinPkisoVrate.exec(C_NenkinKbn.YUYU
            , "1300"
            , C_NenkinKigouSedaiKbn.KAI10S
            , "99"
            , "90"
            , C_NenkinJimuTesuuryouKbn.PER1_25
            , C_NenkinVRateGetKbn.ONEYEAR
            , 99);

        exClassificationEquals(bzGetNenkinPkisoVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(9900), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(0));
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BzGetNenkinPkisoVrateBean bzGetNenkinPkisoVrateBean = bzGetNenkinPkisoVrate.exec(C_NenkinKbn.YUYU
            , "1400"
            , C_NenkinKigouSedaiKbn.KAI10S
            , "10"
            , "90"
            , C_NenkinJimuTesuuryouKbn.PER1_00
            , C_NenkinVRateGetKbn.NONE
            , 10);

        exClassificationEquals(bzGetNenkinPkisoVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        BzGetNenkinPkisoVrateBean bzGetNenkinPkisoVrateBean = bzGetNenkinPkisoVrate.exec(C_NenkinKbn.YUYU
            , "1500"
            , C_NenkinKigouSedaiKbn.KAI10S
            , "12"
            , "90"
            , C_NenkinJimuTesuuryouKbn.PER1_00
            , C_NenkinVRateGetKbn.ALL
            , 10);

        exClassificationEquals(bzGetNenkinPkisoVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(1000), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(2000), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(1));
        assertEquals("BizNumber", BizNumber.valueOf(3000), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(2));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(3));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(4));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(5));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(6));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(7));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(8));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(9));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(10));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(11));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(12));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(13));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(14));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(15));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(16));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(17));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(18));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(19));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(20));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(21));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(22));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(23));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(24));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(25));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(26));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(27));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(28));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(29));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(30));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(31));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(32));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(33));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(34));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(35));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(36));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(37));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(38));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(39));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(40));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(41));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(42));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(43));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(44));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(45));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(46));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(47));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(48));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(49));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(50));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(51));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(52));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(53));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(54));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(55));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(56));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(57));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(58));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(59));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(60));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(61));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(62));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(63));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(64));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(65));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(66));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(67));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(68));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(69));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(70));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(71));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(72));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(73));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(74));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(75));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(76));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(77));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(78));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(79));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(80));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(81));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(82));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(83));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(84));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(85));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(86));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(87));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(88));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(89));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(90));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(91));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(92));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(93));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(94));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(95));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(96));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(97));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(98));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(99));
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        BzGetNenkinPkisoVrateBean bzGetNenkinPkisoVrateBean = bzGetNenkinPkisoVrate.exec(C_NenkinKbn.YUYU
            , "1600"
            , C_NenkinKigouSedaiKbn.KAI10S
            , "10"
            , "90"
            , C_NenkinJimuTesuuryouKbn.PER1_00
            , C_NenkinVRateGetKbn.TWOYEARS
            , 10);

        exClassificationEquals(bzGetNenkinPkisoVrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("BizNumber", BizNumber.valueOf(20000), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(0));
        assertEquals("BizNumber", BizNumber.valueOf(0), bzGetNenkinPkisoVrateBean.getNenkinKaisigovRate().get(1));
    }
}
