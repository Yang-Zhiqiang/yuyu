package yuyu.common.hozen.ascommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
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
 * 年１回払年２回払領収金額計算クラスのメソッド {@link KeisanNenHalfyRsgaku#exec(IT_KykKihon,C_Nykkeiro,C_NyknaiyouKbn,BizDate,BizDateYM,Integer,Integer)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanNenHalfyRsgakuTest_exec2 {

    @Inject
    private KeisanNenHalfyRsgaku keisanNenHalfyRsgaku;

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_年１回払年２回払領収金額計算";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanNenHalfyRsgakuTest_exec2.class, fileName, sheetName);
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
    public void testExec_A1() {

        IT_KykKihon kykKihon = null;

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20201215), BizDateYM.valueOf(202011), 1, 1);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("16810111308");

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(kykKihon, null, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20201215), BizDateYM.valueOf(202011), 1, 1);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("16810111308");

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(kykKihon, C_Nykkeiro.BLNK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20201215), BizDateYM.valueOf(202011), 1, 1);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("16810111308");

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, null,
            BizDate.valueOf(20201215), BizDateYM.valueOf(202011), 1, 1);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("16810111308");

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.BLNK,
            BizDate.valueOf(20201215), BizDateYM.valueOf(202011), 1, 1);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("16810111308");

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            null, BizDateYM.valueOf(202011), 1, 1);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("16810111308");

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20201215), null, 1, 1);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("16810111308");

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20201215), BizDateYM.valueOf(202011), null, 1);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("16810111308");

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20201215), BizDateYM.valueOf(202011), 1, null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("16810111308");

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20201215), BizDateYM.valueOf(202011), 1, 1);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "保険料領収通貨取得エラー", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E006", "エラーコード[0]");

    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("16810111319");

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20151015), BizDateYM.valueOf(201510), 1, 1);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "保険料通貨換算計算エラー為替レート取得ミス", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 2, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E004", "エラーコード[0]");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(1), "E011", "エラーコード[1]");

    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("16810111320");

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20201215), BizDateYM.valueOf(202011), 1, 1);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), null, "エラー理由");
        exBizCalcbleEquals(keisanNenHalfyRsgaku.getKeisanRsgkOutBean().getRsgakuGoukei(), BizCurrency.valueOf(3000000), "領収金額合計");
        exBizCalcbleEquals(keisanNenHalfyRsgaku.getKeisanRsgkOutBean().getIktwaribikikgkGoukei(), BizCurrency.valueOf(0), "一括割引料合計");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 0, "エラーコードの件数");

        List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanLst = keisanNenHalfyRsgaku.getKeisanRsgkOutBean().getKeisanRsgkUtiwakeBeanLst();
        exNumericEquals(keisanRsgkUtiwakeBeanLst.size(), 1, "件数");
        exDateYMEquals(keisanRsgkUtiwakeBeanLst.get(0).getJyutoustartym(), BizDateYM.valueOf(202011), "充当開始年月");
        exNumericEquals(keisanRsgkUtiwakeBeanLst.get(0).getJyuutounensuu(), 1, "充当年数");
        exNumericEquals(keisanRsgkUtiwakeBeanLst.get(0).getJyuutoutukisuu(), 0, "充当月数");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanLst.get(0).getRsgaku(), BizCurrency.valueOf(3000000), "領収金額");
        exDateEquals(keisanRsgkUtiwakeBeanLst.get(0).getRyosyukwsratekjymd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanLst.get(0).getRyosyukwsrate(), BizNumber.valueOf(0), "領収為替レート");
        exClassificationEquals(keisanRsgkUtiwakeBeanLst.get(0).getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanLst.get(0).getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
    }
}
