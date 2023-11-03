package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * KeisanKihrkPクラスのメソッド {@link KeisanKihrkP#exec(String,C_Tuukasyu)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanKihrkPTest_exec {

    private final static String syoNo1 = "12806345672";

    private final static String syoNo2 = "12806345683";

    private final static String syoNo3 = "12806345694";

    private final static String syoNo4 = "12806345708";

    private final static String syoNo5 = "12806345719";

    private final static String syoNo6 = "12806345720";

    private final static String syoNo7 = "12806345731";

    private final static String syoNo8 = "11807111185";

    private final static String syoNo9 = "11807111196";

    private final static String syoNo10 = "11807111200";

    private final static String syoNo11 = "18807000213";

    private final static String syoNo12 = "18806000014";

    private final static String syoNo13 = "99806001010";

    private final static String syoNo14 = "99806001021";

    private final static String syoNo15 = "99806001032";

    @Inject
    private KeisanKihrkP keisanKihrkP;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_既払込Ｐ計算";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanKihrkPTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU));
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        C_ErrorKbn errorKbn = keisanKihrkP.exec(syoNo1, C_Tuukasyu.JPY);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanKihrkP.getKihrkP(), BizCurrency.valueOf(0), "既払込Ｐ（契約通貨）");
        exBooleanEquals(keisanKihrkP.getKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getYenKihrkP(), BizCurrency.valueOf(0), "既払込Ｐ（円貨）");
        exBooleanEquals(keisanKihrkP.getYenKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getSkjHrktuukaKihrkP(), BizCurrency.valueOf(0), "既払込Ｐ（新契約時払込通貨）");
        exBooleanEquals(keisanKihrkP.getSkjHrktuukaKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_ErrorKbn errorKbn = keisanKihrkP.exec(syoNo2, C_Tuukasyu.JPY);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanKihrkP.getKihrkP(), BizCurrency.valueOf(100), "既払込Ｐ（契約通貨）");
        exBooleanEquals(keisanKihrkP.getKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getYenKihrkP(), BizCurrency.valueOf(100), "既払込Ｐ（円貨）");
        exBooleanEquals(keisanKihrkP.getYenKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getSkjHrktuukaKihrkP(), BizCurrency.valueOf(100), "既払込Ｐ（新契約時払込通貨）");
        exBooleanEquals(keisanKihrkP.getSkjHrktuukaKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_ErrorKbn errorKbn = keisanKihrkP.exec(syoNo3, C_Tuukasyu.JPY);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanKihrkP.getKihrkP(), BizCurrency.valueOf(0), "既払込Ｐ（契約通貨）");
        exBooleanEquals(keisanKihrkP.getKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getYenKihrkP(), BizCurrency.valueOf(0), "既払込Ｐ（円貨）");
        exBooleanEquals(keisanKihrkP.getYenKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getSkjHrktuukaKihrkP(), BizCurrency.valueOf(0), "既払込Ｐ（新契約時払込通貨）");
        exBooleanEquals(keisanKihrkP.getSkjHrktuukaKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        C_ErrorKbn errorKbn = keisanKihrkP.exec(syoNo4, C_Tuukasyu.JPY);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanKihrkP.getKihrkP(), BizCurrency.valueOf(0), "既払込Ｐ（契約通貨）");
        exBooleanEquals(keisanKihrkP.getKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getYenKihrkP(), BizCurrency.valueOf(0), "既払込Ｐ（円貨）");
        exBooleanEquals(keisanKihrkP.getYenKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getSkjHrktuukaKihrkP(), BizCurrency.valueOf(0), "既払込Ｐ（新契約時払込通貨）");
        exBooleanEquals(keisanKihrkP.getSkjHrktuukaKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        C_ErrorKbn errorKbn = keisanKihrkP.exec(syoNo5, C_Tuukasyu.JPY);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanKihrkP.getKihrkP(), BizCurrency.valueOf(256), "既払込Ｐ（契約通貨）");
        exBooleanEquals(keisanKihrkP.getKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getYenKihrkP(), BizCurrency.valueOf(256), "既払込Ｐ（円貨）");
        exBooleanEquals(keisanKihrkP.getYenKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getSkjHrktuukaKihrkP(), BizCurrency.valueOf(256), "既払込Ｐ（新契約時払込通貨）");
        exBooleanEquals(keisanKihrkP.getSkjHrktuukaKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        C_ErrorKbn errorKbn = keisanKihrkP.exec(syoNo6, C_Tuukasyu.JPY);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanKihrkP.getKihrkP(), BizCurrency.valueOf(0), "既払込Ｐ（契約通貨）");
        exBooleanEquals(keisanKihrkP.getKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getYenKihrkP(), BizCurrency.valueOf(456), "既払込Ｐ（円貨）");
        exBooleanEquals(keisanKihrkP.getYenKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getSkjHrktuukaKihrkP(), BizCurrency.valueOf(456), "既払込Ｐ（新契約時払込通貨）");
        exBooleanEquals(keisanKihrkP.getSkjHrktuukaKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        C_ErrorKbn errorKbn = keisanKihrkP.exec(syoNo7, C_Tuukasyu.EUR);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanKihrkP.getKihrkP(), BizCurrency.valueOf(0, BizCurrencyTypes.EURO), "既払込Ｐ（契約通貨）");
        exBooleanEquals(keisanKihrkP.getKihrkP().getType() == BizCurrencyTypes.EURO, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getYenKihrkP(), BizCurrency.valueOf(456), "既払込Ｐ（円貨）");
        exBooleanEquals(keisanKihrkP.getYenKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getSkjHrktuukaKihrkP(), BizCurrency.valueOf(456), "既払込Ｐ（新契約時払込通貨）");
        exBooleanEquals(keisanKihrkP.getSkjHrktuukaKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        C_ErrorKbn errorKbn = keisanKihrkP.exec(syoNo11, C_Tuukasyu.JPY);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanKihrkP.getKihrkP(), BizCurrency.valueOf(0), "既払込Ｐ（契約通貨）");
        exBooleanEquals(keisanKihrkP.getKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getYenKihrkP(), BizCurrency.valueOf(100), "既払込Ｐ（円貨）");
        exBooleanEquals(keisanKihrkP.getYenKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getSkjHrktuukaKihrkP(), BizCurrency.valueOf(100), "既払込Ｐ（新契約時払込通貨）");
        exBooleanEquals(keisanKihrkP.getSkjHrktuukaKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        C_ErrorKbn errorKbn = keisanKihrkP.exec(syoNo12, C_Tuukasyu.JPY);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanKihrkP.getKihrkP(), BizCurrency.valueOf(0), "既払込Ｐ（契約通貨）");
        exBooleanEquals(keisanKihrkP.getKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getYenKihrkP(), BizCurrency.valueOf(100), "既払込Ｐ（円貨）");
        exBooleanEquals(keisanKihrkP.getYenKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getSkjHrktuukaKihrkP(), BizCurrency.valueOf(100), "既払込Ｐ（新契約時払込通貨）");
        exBooleanEquals(keisanKihrkP.getSkjHrktuukaKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        C_ErrorKbn errorKbn = keisanKihrkP.exec(syoNo13, C_Tuukasyu.USD);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanKihrkP.getKihrkP(), BizCurrency.valueOf(33.23, BizCurrencyTypes.DOLLAR), "既払込Ｐ（契約通貨）");
        exBooleanEquals(keisanKihrkP.getKihrkP().getType() == BizCurrencyTypes.DOLLAR, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getYenKihrkP(), BizCurrency.valueOf(600), "既払込Ｐ（円貨）");
        exBooleanEquals(keisanKihrkP.getYenKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getSkjHrktuukaKihrkP(), BizCurrency.valueOf(33.23, BizCurrencyTypes.DOLLAR), "既払込Ｐ（新契約時払込通貨）");
        exBooleanEquals(keisanKihrkP.getSkjHrktuukaKihrkP().getType() == BizCurrencyTypes.DOLLAR, true, "通貨タイプ");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        C_ErrorKbn errorKbn = keisanKihrkP.exec(syoNo14, C_Tuukasyu.USD);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanKihrkP.getKihrkP(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "既払込Ｐ（契約通貨）");
        exBooleanEquals(keisanKihrkP.getKihrkP().getType() == BizCurrencyTypes.DOLLAR, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getYenKihrkP(), BizCurrency.valueOf(0), "既払込Ｐ（円貨）");
        exBooleanEquals(keisanKihrkP.getYenKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getSkjHrktuukaKihrkP(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "既払込Ｐ（新契約時払込通貨）");
        exBooleanEquals(keisanKihrkP.getSkjHrktuukaKihrkP().getType() == BizCurrencyTypes.DOLLAR, true, "通貨タイプ");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        C_ErrorKbn errorKbn = keisanKihrkP.exec(syoNo15, C_Tuukasyu.USD);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanKihrkP.getKihrkP(), BizCurrency.valueOf(1.23, BizCurrencyTypes.DOLLAR), "既払込Ｐ（契約通貨）");
        exBooleanEquals(keisanKihrkP.getKihrkP().getType() == BizCurrencyTypes.DOLLAR, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getYenKihrkP(), BizCurrency.valueOf(100), "既払込Ｐ（円貨）");
        exBooleanEquals(keisanKihrkP.getYenKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getSkjHrktuukaKihrkP(), BizCurrency.valueOf(1.23, BizCurrencyTypes.DOLLAR), "既払込Ｐ（新契約時払込通貨）");
        exBooleanEquals(keisanKihrkP.getSkjHrktuukaKihrkP().getType() == BizCurrencyTypes.DOLLAR, true, "通貨タイプ");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(210)
    public void testExec_B1() {

        try {
            keisanKihrkP.exec(syoNo8, C_Tuukasyu.EUR);
        } catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。入金実績履歴情報取得に失敗しました。証券番号：11807111185", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(220)
    public void testExec_B2() {

        C_ErrorKbn errorKbn = keisanKihrkP.exec(syoNo9, C_Tuukasyu.JPY);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanKihrkP.getKihrkP(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "既払込Ｐ（契約通貨）");
        exBooleanEquals(keisanKihrkP.getKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getYenKihrkP(), BizCurrency.valueOf(456), "既払込Ｐ（円貨）");
        exBooleanEquals(keisanKihrkP.getYenKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getSkjHrktuukaKihrkP(), BizCurrency.valueOf(456), "既払込Ｐ（新契約時払込通貨）");
        exBooleanEquals(keisanKihrkP.getSkjHrktuukaKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
    }

    @Test
    @TestOrder(230)
    public void testExec_B3() {

        C_ErrorKbn errorKbn = keisanKihrkP.exec(syoNo10, C_Tuukasyu.JPY);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanKihrkP.getKihrkP(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "既払込Ｐ（契約通貨）");
        exBooleanEquals(keisanKihrkP.getKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getYenKihrkP(), BizCurrency.valueOf(789), "既払込Ｐ（円貨）");
        exBooleanEquals(keisanKihrkP.getYenKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
        exBizCalcbleEquals(keisanKihrkP.getSkjHrktuukaKihrkP(), BizCurrency.valueOf(0), "既払込Ｐ（新契約時払込通貨）");
        exBooleanEquals(keisanKihrkP.getSkjHrktuukaKihrkP().getType() == BizCurrencyTypes.YEN, true, "通貨タイプ");
    }
}