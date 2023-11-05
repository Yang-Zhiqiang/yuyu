package yuyu.common.hozen.ascommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 月払領収金額計算のメソッド {@link KeisanTukiRsgaku#exec(IT_KykKihon,C_Nykkeiro,C_NyknaiyouKbn,BizDate,BizDateYM,Integer)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanTukiRsgakuTest_exec2 {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_月払領収金額計算";

    private final static String sheetName = "INデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;


    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(KeisanTukiRsgakuTest_exec2.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

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
    @Transactional
    public void testExec_B1() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(null, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20200825), BizDateYM.valueOf(202007), 2);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_B2() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(kykKihon, null, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20200825), BizDateYM.valueOf(202007), 2);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_B3() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(kykKihon, C_Nykkeiro.BLNK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20200825), BizDateYM.valueOf(202007), 2);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_B4() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, null,
            BizDate.valueOf(20200825), BizDateYM.valueOf(202007), 2);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_B5() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.BLNK,
            BizDate.valueOf(20200825), BizDateYM.valueOf(202007), 2);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_B6() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            null, BizDateYM.valueOf(202007), 2);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_B7() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20200825), null, 2);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_B8() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20200825), BizDateYM.valueOf(202007), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_B9() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20200825), BizDateYM.valueOf(202007), 2);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "保険料領収通貨取得エラー", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E006", "エラーコード[0]");
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_B10() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001021");
        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20200825), BizDateYM.valueOf(202007), 3);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "割引適用あり", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E002", "エラーコード[0]");
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_B11() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001032");
        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20200825), BizDateYM.valueOf(202007), 2);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), null, "エラー理由");
        exBizCalcbleEquals(keisanTukiRsgaku.getKeisanRsgkOutBean().getRsgakuGoukei(), BizCurrency.valueOf(2000000), "領収金額合計");
        exBizCalcbleEquals(keisanTukiRsgaku.getKeisanRsgkOutBean().getIktwaribikikgkGoukei(), BizCurrency.valueOf(0), "一括割引料合計");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 0, "エラーコードの件数");
        List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList = keisanTukiRsgaku.getKeisanRsgkOutBean().getKeisanRsgkUtiwakeBeanLst();
        exNumericEquals(keisanRsgkUtiwakeBeanList.size(), 2, "件数");
        exDateYMEquals(keisanRsgkUtiwakeBeanList.get(0).getJyutoustartym(), BizDateYM.valueOf(202007), "充当開始年月");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(0).getJyuutounensuu(), 0, "充当年数");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(0).getJyuutoutukisuu(), 1, "充当月数");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getRsgaku(), BizCurrency.valueOf(1000000), "領収金額");
        exDateEquals(keisanRsgkUtiwakeBeanList.get(0).getRyosyukwsratekjymd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getRyosyukwsrate(), BizNumber.valueOf(0), "領収為替レート");
        exClassificationEquals(keisanRsgkUtiwakeBeanList.get(0).getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");

        exDateYMEquals(keisanRsgkUtiwakeBeanList.get(1).getJyutoustartym(), BizDateYM.valueOf(202008), "充当開始年月");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(1).getJyuutounensuu(), 0, "充当年数");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(1).getJyuutoutukisuu(), 1, "充当月数");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(1).getRsgaku(), BizCurrency.valueOf(1000000), "領収金額");
        exDateEquals(keisanRsgkUtiwakeBeanList.get(1).getRyosyukwsratekjymd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(1).getRyosyukwsrate(), BizNumber.valueOf(0), "領収為替レート");
        exClassificationEquals(keisanRsgkUtiwakeBeanList.get(1).getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(1).getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");

    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_B12() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001043");
        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20200825), BizDateYM.valueOf(202007), 2);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), null, "エラー理由");
        exBizCalcbleEquals(keisanTukiRsgaku.getKeisanRsgkOutBean().getRsgakuGoukei(), BizCurrency.valueOf(4000000), "領収金額合計");
        exBizCalcbleEquals(keisanTukiRsgaku.getKeisanRsgkOutBean().getIktwaribikikgkGoukei(), BizCurrency.valueOf(0), "一括割引料合計");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 0, "エラーコードの件数");
        List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList = keisanTukiRsgaku.getKeisanRsgkOutBean().getKeisanRsgkUtiwakeBeanLst();
        exNumericEquals(keisanRsgkUtiwakeBeanList.size(), 2, "件数");
        exDateYMEquals(keisanRsgkUtiwakeBeanList.get(0).getJyutoustartym(), BizDateYM.valueOf(202007), "充当開始年月");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(0).getJyuutounensuu(), 0, "充当年数");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(0).getJyuutoutukisuu(), 1, "充当月数");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getRsgaku(), BizCurrency.valueOf(2000000), "領収金額");
        exDateEquals(keisanRsgkUtiwakeBeanList.get(0).getRyosyukwsratekjymd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getRyosyukwsrate(), BizNumber.valueOf(0), "領収為替レート");
        exClassificationEquals(keisanRsgkUtiwakeBeanList.get(0).getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");

        exDateYMEquals(keisanRsgkUtiwakeBeanList.get(1).getJyutoustartym(), BizDateYM.valueOf(202008), "充当開始年月");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(1).getJyuutounensuu(), 0, "充当年数");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(1).getJyuutoutukisuu(), 1, "充当月数");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(1).getRsgaku(), BizCurrency.valueOf(2000000), "領収金額");
        exDateEquals(keisanRsgkUtiwakeBeanList.get(1).getRyosyukwsratekjymd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(1).getRyosyukwsrate(), BizNumber.valueOf(0), "領収為替レート");
        exClassificationEquals(keisanRsgkUtiwakeBeanList.get(1).getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(1).getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");

    }
}
