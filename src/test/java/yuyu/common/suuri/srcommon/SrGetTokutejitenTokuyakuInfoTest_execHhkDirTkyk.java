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
 * メイン処理（被保険者代理特約）のメソッド {@link SrGetTokutejitenTokuyakuInfo#execHhkDirTkyk(C_SonotaTkTokuteiJitenKbn,
        BizDate, String, String, BizDate, C_UmuKbn,  BizDate)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SrGetTokutejitenTokuyakuInfoTest_execHhkDirTkyk {

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

            testDataAndTblMap = testDataMaker.getInData(SrGetTokutejitenTokuyakuInfoTest_execHhkDirTkyk.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
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
    public void testExecHhkDirTkyk_A1() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20180614);
        String pSyono = "17806000013";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20201022);
        C_UmuKbn pStdrsktkyhkumu = C_UmuKbn.NONE;
        BizDate pStdrsktkyhkymd = BizDate.valueOf(20180614);

        String hhkdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execHhkDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pStdrsktkyhkumu, pStdrsktkyhkymd);

        exStringEquals(hhkdrtkykariHyj, "0", "被保険者代理特約有表示");

    }

    @Test
    @TestOrder(20)
    public void testExecHhkDirTkyk_A2() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20180614);
        String pSyono = "17806000013";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20201022);
        C_UmuKbn pStdrsktkyhkumu = C_UmuKbn.ARI;
        BizDate pStdrsktkyhkymd = BizDate.valueOf(20180613);

        String hhkdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execHhkDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pStdrsktkyhkumu, pStdrsktkyhkymd);

        exStringEquals(hhkdrtkykariHyj, "1", "被保険者代理特約有表示");

    }

    @Test
    @TestOrder(30)
    public void testExecHhkDirTkyk_A3() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20180614);
        String pSyono = "17806000013";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20201022);
        C_UmuKbn pStdrsktkyhkumu = C_UmuKbn.ARI;
        BizDate pStdrsktkyhkymd = BizDate.valueOf(20180614);

        String hhkdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execHhkDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pStdrsktkyhkumu, pStdrsktkyhkymd);

        exStringEquals(hhkdrtkykariHyj, "1", "被保険者代理特約有表示");

    }

    @Test
    @TestOrder(40)
    public void testExecHhkDirTkyk_A4() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20180614);
        String pSyono = "17806000013";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20201022);
        C_UmuKbn pStdrsktkyhkumu = C_UmuKbn.ARI;
        BizDate pStdrsktkyhkymd = BizDate.valueOf(20180615);

        String hhkdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execHhkDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pStdrsktkyhkumu, pStdrsktkyhkymd);

        exStringEquals(hhkdrtkykariHyj, "0", "被保険者代理特約有表示");

    }

    @Test
    @TestOrder(50)
    public void testExecHhkDirTkyk_A5() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20180614);
        String pSyono = "17806000013";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20201022);
        C_UmuKbn pStdrsktkyhkumu = C_UmuKbn.NONE;
        BizDate pStdrsktkyhkymd = BizDate.valueOf(20180614);

        String hhkdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execHhkDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pStdrsktkyhkumu, pStdrsktkyhkymd);

        exStringEquals(hhkdrtkykariHyj, "0", "被保険者代理特約有表示");

    }

    @Test
    @TestOrder(60)
    public void testExecHhkDirTkyk_A6() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20201022);
        String pSyono = "17806000013";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        C_UmuKbn pStdrsktkyhkumu = C_UmuKbn.ARI;
        BizDate pStdrsktkyhkymd = BizDate.valueOf(20180613);

        String hhkdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execHhkDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pStdrsktkyhkumu, pStdrsktkyhkymd);

        exStringEquals(hhkdrtkykariHyj, "1", "被保険者代理特約有表示");

    }

    @Test
    @TestOrder(70)
    public void testExecHhkDirTkyk_A7() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20201022);
        String pSyono = "17806000013";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        C_UmuKbn pStdrsktkyhkumu = C_UmuKbn.ARI;
        BizDate pStdrsktkyhkymd = BizDate.valueOf(20180614);

        String hhkdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execHhkDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pStdrsktkyhkumu, pStdrsktkyhkymd);

        exStringEquals(hhkdrtkykariHyj, null, "被保険者代理特約有表示");

    }

    @Test
    @TestOrder(80)
    public void testExecHhkDirTkyk_A8() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20201022);
        String pSyono = "17806000275";
        String pHenkousikibetukey = "50";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        C_UmuKbn pStdrsktkyhkumu = C_UmuKbn.ARI;
        BizDate pStdrsktkyhkymd = BizDate.valueOf(20180614);

        String hhkdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execHhkDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pStdrsktkyhkumu, pStdrsktkyhkymd);

        exStringEquals(hhkdrtkykariHyj, "1", "被保険者代理特約有表示");

    }

    @Test
    @TestOrder(90)
    public void testExecHhkDirTkyk_A9() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20201022);
        String pSyono = "17806000301";
        String pHenkousikibetukey = "40";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        C_UmuKbn pStdrsktkyhkumu = C_UmuKbn.ARI;
        BizDate pStdrsktkyhkymd = BizDate.valueOf(20180614);

        String hhkdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execHhkDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pStdrsktkyhkumu, pStdrsktkyhkymd);

        exStringEquals(hhkdrtkykariHyj, "0", "被保険者代理特約有表示");

    }


    @Test
    @TestOrder(100)
    public void testExecHhkDirTkyk_A10() {

        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = BizDate.valueOf(20201022);
        String pSyono = "17806000013";
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        C_UmuKbn pStdrsktkyhkumu = C_UmuKbn.ARI;
        BizDate pStdrsktkyhkymd = BizDate.valueOf(20180615);

        String hhkdrtkykariHyj =
            srGetTokutejitenTokuyakuInfo.execHhkDirTkyk(
                pSonotaTkTokuteiJitenKbn, pKijyunYmd, pSyono, pHenkousikibetukey, pKouryokuhasseiymd, pStdrsktkyhkumu, pStdrsktkyhkymd);

        exStringEquals(hhkdrtkykariHyj, "0", "被保険者代理特約有表示");

    }
}
