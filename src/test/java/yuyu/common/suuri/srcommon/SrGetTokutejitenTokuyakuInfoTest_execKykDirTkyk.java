package yuyu.common.suuri.srcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_SonotaTkTokuteiJitenKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * メイン処理（契約者代理特約）のメソッド {@link SrGetTokutejitenTokuyakuInfo#execKykDirTkyk(C_SonotaTkTokuteiJitenKbn,
        BizDate, String, String, BizDate, C_UmuKbn, BizDate, BizDate)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SrGetTokutejitenTokuyakuInfoTest_execKykDirTkyk {

    @Inject
    SrGetTokutejitenTokuyakuInfo srGetTokutejitenTokuyakuInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書_特定時点その他特約情報取得";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(SrGetTokutejitenTokuyakuInfoTest_execKykDirTkyk.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ004", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testExecKykDirTkyk_A1() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20180614);
        String pSyono = "17806000013";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        C_UmuKbn pKykdrtkykhukaumu = C_UmuKbn.NONE;
        BizDate pKykdrtkykhukaymd = BizDate.valueOf(20180614);
        BizDate pKykdrtkykkaiyakuymd = null;

        String kykdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pKykdrtkykhukaumu, pKykdrtkykhukaymd, pKykdrtkykkaiyakuymd);

        exStringEquals(kykdrtkykariHyj, "0", "契約者代理特約有表示");

    }

    @Test
    @TestOrder(20)
    public void testExecKykDirTkyk_A2() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20180614);
        String pSyono = "17806000013";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20201023);
        C_UmuKbn pKykdrtkykhukaumu = C_UmuKbn.NONE;
        BizDate pKykdrtkykhukaymd = BizDate.valueOf(20200912);
        BizDate pKykdrtkykkaiyakuymd = BizDate.valueOf(20180613);

        String kykdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pKykdrtkykhukaumu, pKykdrtkykhukaymd, pKykdrtkykkaiyakuymd);

        exStringEquals(kykdrtkykariHyj, "0", "契約者代理特約有表示");

    }

    @Test
    @TestOrder(30)
    public void testExecKykDirTkyk_A3() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20180614);
        String pSyono = "17806000013";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20201023);
        C_UmuKbn pKykdrtkykhukaumu = C_UmuKbn.NONE;
        BizDate pKykdrtkykhukaymd = BizDate.valueOf(20200912);
        BizDate pKykdrtkykkaiyakuymd = BizDate.valueOf(20180614);

        String kykdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pKykdrtkykhukaumu, pKykdrtkykhukaymd, pKykdrtkykkaiyakuymd);

        exStringEquals(kykdrtkykariHyj, "0", "契約者代理特約有表示");

    }

    @Test
    @TestOrder(40)
    public void testExecKykDirTkyk_A4() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20180614);
        String pSyono = "17806000013";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20201023);
        C_UmuKbn pKykdrtkykhukaumu = C_UmuKbn.NONE;
        BizDate pKykdrtkykhukaymd = BizDate.valueOf(20200912);
        BizDate pKykdrtkykkaiyakuymd = BizDate.valueOf(20180615);

        String kykdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pKykdrtkykhukaumu, pKykdrtkykhukaymd, pKykdrtkykkaiyakuymd);

        exStringEquals(kykdrtkykariHyj, "" , "契約者代理特約有表示");

    }

    @Test
    @TestOrder(50)
    public void testExecKykDirTkyk_A5() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20180614);
        String pSyono = "17806000275";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20201023);
        C_UmuKbn pKykdrtkykhukaumu = C_UmuKbn.NONE;
        BizDate pKykdrtkykhukaymd = BizDate.valueOf(20200912);
        BizDate pKykdrtkykkaiyakuymd = BizDate.valueOf(20180615);

        String kykdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pKykdrtkykhukaumu, pKykdrtkykhukaymd, pKykdrtkykkaiyakuymd);

        exStringEquals(kykdrtkykariHyj, "20190729", "契約者代理特約有表示");

    }

    @Test
    @TestOrder(60)
    public void testExecKykDirTkyk_A6() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20180614);
        String pSyono = "17806000301";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20201023);
        C_UmuKbn pKykdrtkykhukaumu = C_UmuKbn.NONE;
        BizDate pKykdrtkykhukaymd = BizDate.valueOf(20200912);
        BizDate pKykdrtkykkaiyakuymd = BizDate.valueOf(20180615);

        String kykdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pKykdrtkykhukaumu, pKykdrtkykhukaymd, pKykdrtkykkaiyakuymd);

        exStringEquals(kykdrtkykariHyj, "", "契約者代理特約有表示");

    }

    @Test
    @TestOrder(70)
    public void testExecKykDirTkyk_A7() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20180614);
        String pSyono = "17806000013";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20201023);
        C_UmuKbn pKykdrtkykhukaumu = C_UmuKbn.ARI;
        BizDate pKykdrtkykhukaymd = BizDate.valueOf(20180613);
        BizDate pKykdrtkykkaiyakuymd = BizDate.valueOf(20200912);

        String kykdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pKykdrtkykhukaumu, pKykdrtkykhukaymd, pKykdrtkykkaiyakuymd);

        exStringEquals(kykdrtkykariHyj, "1", "契約者代理特約有表示");

    }

    @Test
    @TestOrder(80)
    public void testExecKykDirTkyk_A8() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20180614);
        String pSyono = "17806000013";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20201023);
        C_UmuKbn pKykdrtkykhukaumu = C_UmuKbn.ARI;
        BizDate pKykdrtkykhukaymd = BizDate.valueOf(20180614);
        BizDate pKykdrtkykkaiyakuymd = BizDate.valueOf(20200912);

        String kykdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pKykdrtkykhukaumu, pKykdrtkykhukaymd, pKykdrtkykkaiyakuymd);

        exStringEquals(kykdrtkykariHyj, "1", "契約者代理特約有表示");

    }

    @Test
    @TestOrder(90)
    public void testExecKykDirTkyk_A9() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20180614);
        String pSyono = "17806000013";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20201023);
        C_UmuKbn pKykdrtkykhukaumu = C_UmuKbn.ARI;
        BizDate pKykdrtkykhukaymd = BizDate.valueOf(20180615);
        BizDate pKykdrtkykkaiyakuymd = BizDate.valueOf(20200912);

        String kykdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pKykdrtkykhukaumu, pKykdrtkykhukaymd, pKykdrtkykkaiyakuymd);

        exStringEquals(kykdrtkykariHyj, "", "契約者代理特約有表示");

    }

    @Test
    @TestOrder(100)
    public void testExecKykDirTkyk_A10() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20180614);
        String pSyono = "17806000013";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        C_UmuKbn pKykdrtkykhukaumu = C_UmuKbn.NONE;
        BizDate pKykdrtkykhukaymd = BizDate.valueOf(20180614);
        BizDate pKykdrtkykkaiyakuymd = null;

        String kykdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pKykdrtkykhukaumu, pKykdrtkykhukaymd, pKykdrtkykkaiyakuymd);

        exStringEquals(kykdrtkykariHyj, "0", "契約者代理特約有表示");

    }

    @Test
    @TestOrder(110)
    public void testExecKykDirTkyk_A11() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20201023);
        String pSyono = "17806000013";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        C_UmuKbn pKykdrtkykhukaumu = C_UmuKbn.NONE;
        BizDate pKykdrtkykhukaymd = BizDate.valueOf(20200912);
        BizDate pKykdrtkykkaiyakuymd = BizDate.valueOf(20180613);

        String kykdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pKykdrtkykhukaumu, pKykdrtkykhukaymd, pKykdrtkykkaiyakuymd);

        exStringEquals(kykdrtkykariHyj, "0", "契約者代理特約有表示");

    }

    @Test
    @TestOrder(120)
    public void testExecKykDirTkyk_A12() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20201023);
        String pSyono = "17806000013";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        C_UmuKbn pKykdrtkykhukaumu = C_UmuKbn.NONE;
        BizDate pKykdrtkykhukaymd = BizDate.valueOf(20200912);
        BizDate pKykdrtkykkaiyakuymd = BizDate.valueOf(20180614);

        String kykdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pKykdrtkykhukaumu, pKykdrtkykhukaymd, pKykdrtkykkaiyakuymd);

        exStringEquals(kykdrtkykariHyj, "", "契約者代理特約有表示");

    }

    @Test
    @TestOrder(130)
    public void testExecKykDirTkyk_A13() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20201023);
        String pSyono = "10806000016";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        C_UmuKbn pKykdrtkykhukaumu = C_UmuKbn.NONE;
        BizDate pKykdrtkykhukaymd = BizDate.valueOf(20200912);
        BizDate pKykdrtkykkaiyakuymd = BizDate.valueOf(20180614);

        String kykdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pKykdrtkykhukaumu, pKykdrtkykhukaymd, pKykdrtkykkaiyakuymd);

        exStringEquals(kykdrtkykariHyj, "20201024", "契約者代理特約有表示");

    }

    @Test
    @TestOrder(140)
    public void testExecKykDirTkyk_A14() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20201023);
        String pSyono = "10806000027";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        C_UmuKbn pKykdrtkykhukaumu = C_UmuKbn.NONE;
        BizDate pKykdrtkykhukaymd = BizDate.valueOf(20200912);
        BizDate pKykdrtkykkaiyakuymd = BizDate.valueOf(20180614);

        String kykdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pKykdrtkykhukaumu, pKykdrtkykhukaymd, pKykdrtkykkaiyakuymd);

        exStringEquals(kykdrtkykariHyj, "20180612", "契約者代理特約有表示");

    }

    @Test
    @TestOrder(150)
    public void testExecKykDirTkyk_A15() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20201023);
        String pSyono = "12806000063";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        C_UmuKbn pKykdrtkykhukaumu = C_UmuKbn.NONE;
        BizDate pKykdrtkykhukaymd = BizDate.valueOf(20200912);
        BizDate pKykdrtkykkaiyakuymd = BizDate.valueOf(20180614);

        String kykdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pKykdrtkykhukaumu, pKykdrtkykhukaymd, pKykdrtkykkaiyakuymd);

        exStringEquals(kykdrtkykariHyj, "", "契約者代理特約有表示");

    }

    @Test
    @TestOrder(160)
    public void testExecKykDirTkyk_A16() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20201023);
        String pSyono = "12806000063";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        C_UmuKbn pKykdrtkykhukaumu = C_UmuKbn.NONE;
        BizDate pKykdrtkykhukaymd = BizDate.valueOf(20200912);
        BizDate pKykdrtkykkaiyakuymd = BizDate.valueOf(20180615);

        String kykdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pKykdrtkykhukaumu, pKykdrtkykhukaymd, pKykdrtkykkaiyakuymd);

        exStringEquals(kykdrtkykariHyj, "", "契約者代理特約有表示");

    }

    @Test
    @TestOrder(170)
    public void testExecKykDirTkyk_A17() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20201023);
        String pSyono = "17806000013";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        C_UmuKbn pKykdrtkykhukaumu = C_UmuKbn.ARI;
        BizDate pKykdrtkykhukaymd = BizDate.valueOf(20180613);
        BizDate pKykdrtkykkaiyakuymd = BizDate.valueOf(20200912);

        String kykdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pKykdrtkykhukaumu, pKykdrtkykhukaymd, pKykdrtkykkaiyakuymd);

        exStringEquals(kykdrtkykariHyj, "1", "契約者代理特約有表示");

    }

    @Test
    @TestOrder(180)
    public void testExecKykDirTkyk_A18() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20201023);
        String pSyono = "12806000063";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        C_UmuKbn pKykdrtkykhukaumu = C_UmuKbn.ARI;
        BizDate pKykdrtkykhukaymd = BizDate.valueOf(20180614);
        BizDate pKykdrtkykkaiyakuymd = BizDate.valueOf(20200912);

        String kykdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pKykdrtkykhukaumu, pKykdrtkykhukaymd, pKykdrtkykkaiyakuymd);

        exStringEquals(kykdrtkykariHyj, "", "契約者代理特約有表示");

    }

    @Test
    @TestOrder(190)
    public void testExecKykDirTkyk_A19() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20201023);
        String pSyono = "12806000063";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        C_UmuKbn pKykdrtkykhukaumu = C_UmuKbn.ARI;
        BizDate pKykdrtkykhukaymd = BizDate.valueOf(20180615);
        BizDate pKykdrtkykkaiyakuymd = BizDate.valueOf(20200912);

        String kykdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pKykdrtkykhukaumu, pKykdrtkykhukaymd, pKykdrtkykkaiyakuymd);

        exStringEquals(kykdrtkykariHyj, "", "契約者代理特約有表示");

    }
}
