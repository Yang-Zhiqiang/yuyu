package yuyu.common.hozen.ascommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 領収金額計算のメソッド {@link KeisanRsgaku#exec(IT_KykKihon,C_Nykkeiro,C_NyknaiyouKbn,BizDate,BizDateYM,Integer,Integer)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanRsgakuTest_exec2 {

    @Inject
    KeisanRsgaku keisanRsgaku;

    @Inject
    KeisanRsgakuBean keisanRsgakuBean;

    @Inject
    HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_領収金額計算";

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

        C_ErrorKbn errorKbn = keisanRsgaku.exec(null, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20200801), BizDateYM.valueOf(202009), 2, 6);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_B2() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        C_ErrorKbn errorKbn = keisanRsgaku.exec(kykKihon, null, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20200801), BizDateYM.valueOf(202009), 2, 6);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_B3() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        C_ErrorKbn errorKbn = keisanRsgaku.exec(kykKihon, C_Nykkeiro.BLNK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20200801), BizDateYM.valueOf(202009), 2, 6);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_B4() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        C_ErrorKbn errorKbn = keisanRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, null,
            BizDate.valueOf(20200801), BizDateYM.valueOf(202009), 2, 6);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_B5() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        C_ErrorKbn errorKbn = keisanRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.BLNK,
            BizDate.valueOf(20200801), BizDateYM.valueOf(202009), 2, 6);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_B6() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        C_ErrorKbn errorKbn = keisanRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            null, BizDateYM.valueOf(202009), 2, 6);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_B7() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        C_ErrorKbn errorKbn = keisanRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20200801), null, 2, 6);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_B8() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        C_ErrorKbn errorKbn = keisanRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20200801), BizDateYM.valueOf(202009), null, 6);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_B9() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        C_ErrorKbn errorKbn = keisanRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20200801), BizDateYM.valueOf(202009), 2, null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_B10() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        C_ErrorKbn errorKbn = keisanRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20200801), BizDateYM.valueOf(202009), 2, 6);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "保険料領収通貨取得エラー", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E006", "エラーコード[0]");
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_B11() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001021");
        C_ErrorKbn errorKbn = keisanRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20200801), BizDateYM.valueOf(202007), 0, 6);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "月払割引適用あり", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E002", "エラーコード[0]");
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_B12() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001032");
        C_ErrorKbn errorKbn = keisanRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20200801), BizDateYM.valueOf(202009), 2, 6);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), null, "エラー理由");
        assertNull(keisanRsgaku.getKeisanRsgkOutBean());
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 0, "エラーコードの件数");

    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_B13() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001043");
        C_ErrorKbn errorKbn = keisanRsgaku.exec(kykKihon, C_Nykkeiro.KZHRK, C_NyknaiyouKbn.KEIZOKUP,
            BizDate.valueOf(20200801), BizDateYM.valueOf(202009), 2, 6);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), null, "エラー理由");
        assertNull(keisanRsgaku.getKeisanRsgkOutBean());
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 0, "エラーコードの件数");

    }
}
