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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険料領収通貨換算計算クラスのメソッド {@link KeisanPRsTuukaKnsn#exec(BizDate, BizCurrency, C_Tuukasyu, C_Tuukasyu)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanPRsTuukaKnsnTest_exec {

    @Inject
    KeisanPRsTuukaKnsn keisanPRsTuukaKnsn;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保険料領収通貨換算計算";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanPRsTuukaKnsnTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKawaseRate());

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        C_ErrorKbn kekkaKbn = keisanPRsTuukaKnsn.exec(null, BizCurrency.valueOf(111), C_Tuukasyu.JPY, C_Tuukasyu.USD);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(keisanPRsTuukaKnsn.getErrorCd().size(), 1, "メンバ変数．エラーコードのサイズ");
        exStringEquals(keisanPRsTuukaKnsn.getErrorCd().get(0), KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR, "エラーコード");
        exStringEquals(keisanPRsTuukaKnsn.getErrorRiyuu(), KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR, "メンバ変数．エラー理由");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_ErrorKbn kekkaKbn = keisanPRsTuukaKnsn.exec(BizDate.valueOf(20200826), null, C_Tuukasyu.JPY, C_Tuukasyu.USD);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(keisanPRsTuukaKnsn.getErrorCd().size(), 1, "メンバ変数．エラーコードのサイズ");
        exStringEquals(keisanPRsTuukaKnsn.getErrorCd().get(0), KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR, "エラーコード");
        exStringEquals(keisanPRsTuukaKnsn.getErrorRiyuu(), KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR, "メンバ変数．エラー理由");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_ErrorKbn kekkaKbn = keisanPRsTuukaKnsn.exec(BizDate.valueOf(20200826), BizCurrency.valueOf(111),
            C_Tuukasyu.BLNK,
            C_Tuukasyu.USD);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(keisanPRsTuukaKnsn.getErrorCd().size(), 1, "メンバ変数．エラーコードのサイズ");
        exStringEquals(keisanPRsTuukaKnsn.getErrorCd().get(0), KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR, "エラーコード");
        exStringEquals(keisanPRsTuukaKnsn.getErrorRiyuu(), KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR, "メンバ変数．エラー理由");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        C_ErrorKbn kekkaKbn = keisanPRsTuukaKnsn.exec(BizDate.valueOf(20200826), BizCurrency.valueOf(111),
            C_Tuukasyu.USD, C_Tuukasyu.BLNK);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(keisanPRsTuukaKnsn.getErrorCd().size(), 1, "メンバ変数．エラーコードのサイズ");
        exStringEquals(keisanPRsTuukaKnsn.getErrorCd().get(0), KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR, "エラーコード");
        exStringEquals(keisanPRsTuukaKnsn.getErrorRiyuu(), KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR, "メンバ変数．エラー理由");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        C_ErrorKbn kekkaKbn = keisanPRsTuukaKnsn.exec(BizDate.valueOf(20200826), BizCurrency.valueOf(111),
            C_Tuukasyu.USD, C_Tuukasyu.USD);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(keisanPRsTuukaKnsn.getErrorCd().size(), 1, "メンバ変数．エラーコードのサイズ");
        exStringEquals(keisanPRsTuukaKnsn.getErrorCd().get(0), KeisanRsgakuConstants.ERRCD_TUUKASYUU_CHKERROR, "エラーコード");
        exStringEquals(keisanPRsTuukaKnsn.getErrorRiyuu(), KeisanRsgakuConstants.ERRRIYUU_TUUKASYUU_CHKERROR, "メンバ変数．エラー理由");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        C_ErrorKbn kekkaKbn = keisanPRsTuukaKnsn.exec(BizDate.valueOf(20200826), BizCurrency.valueOf(100,BizCurrencyTypes.DOLLAR),
            C_Tuukasyu.USD,C_Tuukasyu.JPY);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(keisanPRsTuukaKnsn.getErrorCd().size(), 0, "メンバ変数．エラーコードのサイズ");
        exStringEquals(keisanPRsTuukaKnsn.getErrorRiyuu(), null, "メンバ変数．エラー理由");
        exBizCalcbleEquals(keisanPRsTuukaKnsn.getPRsTuukaKnsn().getRstuukaknsngop(), BizCurrency.valueOf(11939,BizCurrencyTypes.YEN),
            "領収通貨換算後保険料");
        exDateEquals(keisanPRsTuukaKnsn.getPRsTuukaKnsn().getRstuukaknsnkwsratekjnymd(), BizDate.valueOf(20200826),
            "領収通貨換算時為替レート基準日");
        exBizCalcbleEquals(keisanPRsTuukaKnsn.getPRsTuukaKnsn().getRstuukaknsnkwsrate(), BizNumber.valueOf(119.39),
            "領収通貨換算時為替レート");
        exClassificationEquals(keisanPRsTuukaKnsn.getPRsTuukaKnsn().getRstuukaknsngotuukasyu(), C_Tuukasyu.JPY,
            "領収通貨換算後通貨種類");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        C_ErrorKbn kekkaKbn = keisanPRsTuukaKnsn.exec(BizDate.valueOf(20200825), BizCurrency.valueOf(100),
            C_Tuukasyu.USD, C_Tuukasyu.JPY);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(keisanPRsTuukaKnsn.getErrorCd().size(), 1, "メンバ変数．エラーコードのサイズ");
        exStringEquals(keisanPRsTuukaKnsn.getErrorCd().get(0), KeisanRsgakuConstants.ERRCD_KAWASERATESYUTOKUERR, "エラーコード");
        exStringEquals(keisanPRsTuukaKnsn.getErrorRiyuu(), KeisanRsgakuConstants.ERRRIYUU_KAWASERATESYUTOKUERR, "メンバ変数．エラー理由");

        assertNull(keisanPRsTuukaKnsn.getPRsTuukaKnsn());

    }
}
