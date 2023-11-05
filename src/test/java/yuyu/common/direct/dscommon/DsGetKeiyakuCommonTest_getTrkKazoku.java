package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ契約共通情報取得クラスのメソッド {@link DsGetKeiyakuCommon#getTrkKazoku()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsGetKeiyakuCommonTest_getTrkKazoku {

    private final static String SYONO1 = "11807111118";

    private final static String SYONO2 = "11807111129";

    private final static String SYONO3 = "11807111130";

    private final static String SYONO4 = "11807111141";

    private final static String SYONO5 = "11807111152";

    @Inject
    private DsGetKeiyakuCommon dsGetKeiyakuCommon;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ契約共通情報取得";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DsGetKeiyakuCommonTest_getTrkKazoku.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ005", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testGetTrkKazoku_A1() {
        TrkKazokuBean trkKazokuBean = dsGetKeiyakuCommon.getTrkKazoku(SYONO1);

        exClassificationEquals(trkKazokuBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testGetTrkKazoku_A2() {
        TrkKazokuBean trkKazokuBean = dsGetKeiyakuCommon.getTrkKazoku(SYONO2);

        exClassificationEquals(trkKazokuBean.getErrorKbn(),  C_ErrorKbn.OK,  "結果区分");
        exClassificationEquals(trkKazokuBean.getTrkkzkumuKbn1(),  C_UmuKbn.NONE,  "登録家族情報有無区分１");
        exClassificationEquals(trkKazokuBean.getTrkkzkKbn1(),  C_TrkKzkKbn.TRKKZK1,  "登録家族区分１");
        exDateEquals(trkKazokuBean.getTrkkzksetteiYmd1(),  null,  "登録家族設定年月日１");
        exStringEquals(trkKazokuBean.getTrkkzknmKn1(),  "",  "登録家族名（カナ）１");
        exStringEquals(trkKazokuBean.getTrkkzknmKj1(),  "",  "登録家族名（漢字）１");
        exClassificationEquals(trkKazokuBean.getTrkkzknmkjkhukaKbn1(),  C_KjkhukaKbn.BLNK,  "登録家族名漢字化不可区分１");
        exDateEquals(trkKazokuBean.getTrkkzkseiYmd1(),  null, "登録家族生年月日１");
        exClassificationEquals(trkKazokuBean.getTrkkzkSei1(),  C_Seibetu.BLNK,  "登録家族性別１");
        exClassificationEquals(trkKazokuBean.getTrkkzkTdk1(),  C_Tdk.BLNK,  "登録家族続柄１");
        exStringEquals(trkKazokuBean.getTrkkzkYno1(),  "",  "登録家族郵便番号１");
        exStringEquals(trkKazokuBean.getTrkkzkadr1Kj1(),  "",  "登録家族住所１（漢字）１");
        exStringEquals(trkKazokuBean.getTrkkzkadr2Kj1(),  "",  "登録家族住所２（漢字）１");
        exStringEquals(trkKazokuBean.getTrkkzkadr3Kj1(),  "",  "登録家族住所３（漢字）１");
        exStringEquals(trkKazokuBean.getTrkkzkTelno1(),  "",   "登録家族電話番号１");
        exStringEquals(trkKazokuBean.getGyoumuKousinTime1(),  "",  "業務用更新時間１");
        exClassificationEquals(trkKazokuBean.getTrkkzkumuKbn2(),  C_UmuKbn.NONE,  "登録家族情報有無区分２");
        exClassificationEquals(trkKazokuBean.getTrkkzkKbn2(),  C_TrkKzkKbn.TRKKZK2,  "登録家族区分２");
        exDateEquals(trkKazokuBean.getTrkkzksetteiYmd2(),  null,  "登録家族設定年月日２");
        exStringEquals(trkKazokuBean.getTrkkzknmKn2(),  "",  "登録家族名（カナ）２");
        exStringEquals(trkKazokuBean.getTrkkzknmKj2(),  "",  "登録家族名（漢字）２");
        exClassificationEquals(trkKazokuBean.getTrkkzknmkjkhukaKbn2(),  C_KjkhukaKbn.BLNK,  "登録家族名漢字化不可区分２");
        exDateEquals(trkKazokuBean.getTrkkzkseiYmd2(),  null, "登録家族生年月日２");
        exClassificationEquals(trkKazokuBean.getTrkkzkSei2(),  C_Seibetu.BLNK,  "登録家族性別２");
        exClassificationEquals(trkKazokuBean.getTrkkzkTdk2(),  C_Tdk.BLNK,  "登録家族続柄２");
        exStringEquals(trkKazokuBean.getTrkkzkYno2(),  "",  "登録家族郵便番号２");
        exStringEquals(trkKazokuBean.getTrkkzkadr1Kj2(),  "",  "登録家族住所１（漢字）２");
        exStringEquals(trkKazokuBean.getTrkkzkadr2Kj2(),  "",  "登録家族住所２（漢字）２");
        exStringEquals(trkKazokuBean.getTrkkzkadr3Kj2(),  "",  "登録家族住所３（漢字）２");
        exStringEquals(trkKazokuBean.getTrkkzkTelno2(),  "",   "登録家族電話番号２");
        exStringEquals(trkKazokuBean.getGyoumuKousinTime2(),  "",  "業務用更新時間２");
    }

    @Test
    @TestOrder(30)
    public void testGetTrkKazoku_A3() {
        TrkKazokuBean trkKazokuBean = dsGetKeiyakuCommon.getTrkKazoku(SYONO3);

        exClassificationEquals(trkKazokuBean.getErrorKbn(),  C_ErrorKbn.OK,  "結果区分");
        exClassificationEquals(trkKazokuBean.getTrkkzkumuKbn1(),  C_UmuKbn.ARI,  "登録家族情報有無区分１");
        exClassificationEquals(trkKazokuBean.getTrkkzkKbn1(),  C_TrkKzkKbn.TRKKZK1,  "登録家族区分１");
        exDateEquals(trkKazokuBean.getTrkkzksetteiYmd1(),  BizDate.valueOf("20200324"),  "登録家族設定年月日１");
        exStringEquals(trkKazokuBean.getTrkkzknmKn1(),  "カナイチ",  "登録家族名（カナ）１");
        exStringEquals(trkKazokuBean.getTrkkzknmKj1(),  "仮名イチ",  "登録家族名（漢字）１");
        exClassificationEquals(trkKazokuBean.getTrkkzknmkjkhukaKbn1(),  C_KjkhukaKbn.BLNK,  "登録家族名漢字化不可区分１");
        exDateEquals(trkKazokuBean.getTrkkzkseiYmd1(),  BizDate.valueOf("20000324"), "登録家族生年月日１");
        exClassificationEquals(trkKazokuBean.getTrkkzkSei1(),  C_Seibetu.MALE,  "登録家族性別１");
        exClassificationEquals(trkKazokuBean.getTrkkzkTdk1(),  C_Tdk.HONNIN,  "登録家族続柄１");
        exStringEquals(trkKazokuBean.getTrkkzkYno1(),  "1234567",  "登録家族郵便番号１");
        exStringEquals(trkKazokuBean.getTrkkzkadr1Kj1(),  "いち",  "登録家族住所１（漢字）１");
        exStringEquals(trkKazokuBean.getTrkkzkadr2Kj1(),  "に",  "登録家族住所２（漢字）１");
        exStringEquals(trkKazokuBean.getTrkkzkadr3Kj1(),  "さん",  "登録家族住所３（漢字）１");
        exStringEquals(trkKazokuBean.getTrkkzkTelno1(),  "080-1234-5678",   "登録家族電話番号１");
        exStringEquals(trkKazokuBean.getGyoumuKousinTime1(),  "20200324",  "業務用更新時間１");
        exClassificationEquals(trkKazokuBean.getTrkkzkumuKbn2(),  C_UmuKbn.NONE,  "登録家族情報有無区分２");
        exClassificationEquals(trkKazokuBean.getTrkkzkKbn2(),  C_TrkKzkKbn.TRKKZK2,  "登録家族区分２");
        exDateEquals(trkKazokuBean.getTrkkzksetteiYmd2(),  null,  "登録家族設定年月日２");
        exStringEquals(trkKazokuBean.getTrkkzknmKn2(),  "",  "登録家族名（カナ）２");
        exStringEquals(trkKazokuBean.getTrkkzknmKj2(),  "",  "登録家族名（漢字）２");
        exClassificationEquals(trkKazokuBean.getTrkkzknmkjkhukaKbn2(),  C_KjkhukaKbn.BLNK,  "登録家族名漢字化不可区分２");
        exDateEquals(trkKazokuBean.getTrkkzkseiYmd2(),  null, "登録家族生年月日２");
        exClassificationEquals(trkKazokuBean.getTrkkzkSei2(),  C_Seibetu.BLNK,  "登録家族性別２");
        exClassificationEquals(trkKazokuBean.getTrkkzkTdk2(),  C_Tdk.BLNK,  "登録家族続柄２");
        exStringEquals(trkKazokuBean.getTrkkzkYno2(),  "",  "登録家族郵便番号２");
        exStringEquals(trkKazokuBean.getTrkkzkadr1Kj2(),  "",  "登録家族住所１（漢字）２");
        exStringEquals(trkKazokuBean.getTrkkzkadr2Kj2(),  "",  "登録家族住所２（漢字）２");
        exStringEquals(trkKazokuBean.getTrkkzkadr3Kj2(),  "",  "登録家族住所３（漢字）２");
        exStringEquals(trkKazokuBean.getTrkkzkTelno2(),  "",   "登録家族電話番号２");
        exStringEquals(trkKazokuBean.getGyoumuKousinTime2(),  "",  "業務用更新時間２");
    }

    @Test
    @TestOrder(40)
    public void testGetTrkKazoku_A4() {
        TrkKazokuBean trkKazokuBean = dsGetKeiyakuCommon.getTrkKazoku(SYONO4);

        exClassificationEquals(trkKazokuBean.getErrorKbn(),  C_ErrorKbn.OK,  "結果区分");
        exClassificationEquals(trkKazokuBean.getTrkkzkumuKbn1(),  C_UmuKbn.NONE,  "登録家族情報有無区分１");
        exClassificationEquals(trkKazokuBean.getTrkkzkKbn1(),  C_TrkKzkKbn.TRKKZK1,  "登録家族区分１");
        exDateEquals(trkKazokuBean.getTrkkzksetteiYmd1(),  null,  "登録家族設定年月日１");
        exStringEquals(trkKazokuBean.getTrkkzknmKn1(),  "",  "登録家族名（カナ）１");
        exStringEquals(trkKazokuBean.getTrkkzknmKj1(),  "",  "登録家族名（漢字）１");
        exClassificationEquals(trkKazokuBean.getTrkkzknmkjkhukaKbn1(),  C_KjkhukaKbn.BLNK,  "登録家族名漢字化不可区分１");
        exDateEquals(trkKazokuBean.getTrkkzkseiYmd1(),  null, "登録家族生年月日１");
        exClassificationEquals(trkKazokuBean.getTrkkzkSei1(),  C_Seibetu.BLNK,  "登録家族性別１");
        exClassificationEquals(trkKazokuBean.getTrkkzkTdk1(),  C_Tdk.BLNK,  "登録家族続柄１");
        exStringEquals(trkKazokuBean.getTrkkzkYno1(),  "",  "登録家族郵便番号１");
        exStringEquals(trkKazokuBean.getTrkkzkadr1Kj1(),  "",  "登録家族住所１（漢字）１");
        exStringEquals(trkKazokuBean.getTrkkzkadr2Kj1(),  "",  "登録家族住所２（漢字）１");
        exStringEquals(trkKazokuBean.getTrkkzkadr3Kj1(),  "",  "登録家族住所３（漢字）１");
        exStringEquals(trkKazokuBean.getTrkkzkTelno1(),  "",   "登録家族電話番号１");
        exStringEquals(trkKazokuBean.getGyoumuKousinTime1(),  "",  "業務用更新時間１");
        exClassificationEquals(trkKazokuBean.getTrkkzkumuKbn2(),  C_UmuKbn.ARI,  "登録家族情報有無区分２");
        exClassificationEquals(trkKazokuBean.getTrkkzkKbn2(),  C_TrkKzkKbn.TRKKZK2,  "登録家族区分２");
        exDateEquals(trkKazokuBean.getTrkkzksetteiYmd2(),  BizDate.valueOf("20200301"),  "登録家族設定年月日２");
        exStringEquals(trkKazokuBean.getTrkkzknmKn2(),  "カナニ",  "登録家族名（カナ）２");
        exStringEquals(trkKazokuBean.getTrkkzknmKj2(),  "仮名ニ",  "登録家族名（漢字）２");
        exClassificationEquals(trkKazokuBean.getTrkkzknmkjkhukaKbn2(),  C_KjkhukaKbn.BLNK,  "登録家族名漢字化不可区分２");
        exDateEquals(trkKazokuBean.getTrkkzkseiYmd2(),  BizDate.valueOf("20000301"), "登録家族生年月日２");
        exClassificationEquals(trkKazokuBean.getTrkkzkSei2(),  C_Seibetu.FEMALE,  "登録家族性別２");
        exClassificationEquals(trkKazokuBean.getTrkkzkTdk2(),  C_Tdk.HGU,  "登録家族続柄２");
        exStringEquals(trkKazokuBean.getTrkkzkYno2(),  "1111111",  "登録家族郵便番号２");
        exStringEquals(trkKazokuBean.getTrkkzkadr1Kj2(),  "よん",  "登録家族住所１（漢字）２");
        exStringEquals(trkKazokuBean.getTrkkzkadr2Kj2(),  "ご",  "登録家族住所２（漢字）２");
        exStringEquals(trkKazokuBean.getTrkkzkadr3Kj2(),  "ろく",  "登録家族住所３（漢字）２");
        exStringEquals(trkKazokuBean.getTrkkzkTelno2(),  "080-1111-1111",   "登録家族電話番号２");
        exStringEquals(trkKazokuBean.getGyoumuKousinTime2(),  "20200301",  "業務用更新時間２");
    }

    @Test
    @TestOrder(50)
    public void testGetTrkKazoku_A5() {
        TrkKazokuBean trkKazokuBean = dsGetKeiyakuCommon.getTrkKazoku(SYONO5);

        exClassificationEquals(trkKazokuBean.getErrorKbn(),  C_ErrorKbn.OK,  "結果区分");
        exClassificationEquals(trkKazokuBean.getTrkkzkumuKbn1(),  C_UmuKbn.ARI,  "登録家族情報有無区分１");
        exClassificationEquals(trkKazokuBean.getTrkkzkKbn1(),  C_TrkKzkKbn.TRKKZK1,  "登録家族区分１");
        exDateEquals(trkKazokuBean.getTrkkzksetteiYmd1(),  BizDate.valueOf("20200324"),  "登録家族設定年月日１");
        exStringEquals(trkKazokuBean.getTrkkzknmKn1(),  "カナイチ",  "登録家族名（カナ）１");
        exStringEquals(trkKazokuBean.getTrkkzknmKj1(),  "仮名イチ",  "登録家族名（漢字）１");
        exClassificationEquals(trkKazokuBean.getTrkkzknmkjkhukaKbn1(),  C_KjkhukaKbn.BLNK,  "登録家族名漢字化不可区分１");
        exDateEquals(trkKazokuBean.getTrkkzkseiYmd1(),  BizDate.valueOf("20000324"), "登録家族生年月日１");
        exClassificationEquals(trkKazokuBean.getTrkkzkSei1(),  C_Seibetu.MALE,  "登録家族性別１");
        exClassificationEquals(trkKazokuBean.getTrkkzkTdk1(),  C_Tdk.HONNIN,  "登録家族続柄１");
        exStringEquals(trkKazokuBean.getTrkkzkYno1(),  "1234567",  "登録家族郵便番号１");
        exStringEquals(trkKazokuBean.getTrkkzkadr1Kj1(),  "いち",  "登録家族住所１（漢字）１");
        exStringEquals(trkKazokuBean.getTrkkzkadr2Kj1(),  "に",  "登録家族住所２（漢字）１");
        exStringEquals(trkKazokuBean.getTrkkzkadr3Kj1(),  "さん",  "登録家族住所３（漢字）１");
        exStringEquals(trkKazokuBean.getTrkkzkTelno1(),  "080-1234-5678",   "登録家族電話番号１");
        exStringEquals(trkKazokuBean.getGyoumuKousinTime1(),  "20200324",  "業務用更新時間１");
        exClassificationEquals(trkKazokuBean.getTrkkzkumuKbn2(),  C_UmuKbn.ARI,  "登録家族情報有無区分２");
        exClassificationEquals(trkKazokuBean.getTrkkzkKbn2(),  C_TrkKzkKbn.TRKKZK2,  "登録家族区分２");
        exDateEquals(trkKazokuBean.getTrkkzksetteiYmd2(),  BizDate.valueOf("20200301"),  "登録家族設定年月日２");
        exStringEquals(trkKazokuBean.getTrkkzknmKn2(),  "カナニ",  "登録家族名（カナ）２");
        exStringEquals(trkKazokuBean.getTrkkzknmKj2(),  "仮名ニ",  "登録家族名（漢字）２");
        exClassificationEquals(trkKazokuBean.getTrkkzknmkjkhukaKbn2(),  C_KjkhukaKbn.BLNK,  "登録家族名漢字化不可区分２");
        exDateEquals(trkKazokuBean.getTrkkzkseiYmd2(),  BizDate.valueOf("20000301"), "登録家族生年月日２");
        exClassificationEquals(trkKazokuBean.getTrkkzkSei2(),  C_Seibetu.FEMALE,  "登録家族性別２");
        exClassificationEquals(trkKazokuBean.getTrkkzkTdk2(),  C_Tdk.HGU,  "登録家族続柄２");
        exStringEquals(trkKazokuBean.getTrkkzkYno2(),  "1111111",  "登録家族郵便番号２");
        exStringEquals(trkKazokuBean.getTrkkzkadr1Kj2(),  "よん",  "登録家族住所１（漢字）２");
        exStringEquals(trkKazokuBean.getTrkkzkadr2Kj2(),  "ご",  "登録家族住所２（漢字）２");
        exStringEquals(trkKazokuBean.getTrkkzkadr3Kj2(),  "ろく",  "登録家族住所３（漢字）２");
        exStringEquals(trkKazokuBean.getTrkkzkTelno2(),  "080-1111-1111",   "登録家族電話番号２");
        exStringEquals(trkKazokuBean.getGyoumuKousinTime2(),  "20200301",  "業務用更新時間２");
    }
}
