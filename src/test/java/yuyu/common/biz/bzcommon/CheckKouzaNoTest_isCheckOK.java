package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 口座番号チェッククラスのメソッド {@link CheckKouzaNo#isCheckOK(String, C_Tuukasyu)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckKouzaNoTest_isCheckOK {

    @Inject
    private CheckKouzaNo checkKouzaNo;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testIsCheckOK_A1() {

        boolean result = checkKouzaNo.isCheckOK(null, C_Tuukasyu.JPY);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(20)
    public void testIsCheckOK_A2() {

        boolean result = checkKouzaNo.isCheckOK("", C_Tuukasyu.JPY);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(30)
    public void testIsCheckOK_A3() {

        boolean result = checkKouzaNo.isCheckOK("1234567890", C_Tuukasyu.JPY);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(40)
    public void testIsCheckOK_A4() {

        boolean result = checkKouzaNo.isCheckOK("123456789A", C_Tuukasyu.JPY);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(50)
    public void testIsCheckOK_A5() {

        boolean result = checkKouzaNo.isCheckOK("123456789-",C_Tuukasyu.JPY);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(60)
    public void testIsCheckOK_A6() {

        boolean result = checkKouzaNo.isCheckOK("１２３4567890'+",C_Tuukasyu.JPY);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(70)
    public void testIsCheckOK_A7() {

        boolean result = checkKouzaNo.isCheckOK("1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ/-?:().,'+",C_Tuukasyu.USD);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(80)
    public void testIsCheckOK_A8() {

        boolean result = checkKouzaNo.isCheckOK("123456789ABC-a",C_Tuukasyu.USD);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(90)
    public void testIsCheckOK_A9() {

        boolean result = checkKouzaNo.isCheckOK("123456789ABC-@",C_Tuukasyu.USD);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(100)
    public void testIsCheckOK_A10() {

        boolean result = checkKouzaNo.isCheckOK("１２３456789ABC-",C_Tuukasyu.USD);

        exBooleanEquals(result, false, "チェック結果");
    }


    @Test
    @TestOrder(110)
    public void testIsCheckOK_A11() {

        boolean result = checkKouzaNo.isCheckOK("1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ/-?:().,'+",C_Tuukasyu.EUR);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(120)
    public void testIsCheckOK_A12() {

        boolean result = checkKouzaNo.isCheckOK("123456789ABC-a",C_Tuukasyu.EUR);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(130)
    public void testIsCheckOK_A13() {

        boolean result = checkKouzaNo.isCheckOK("123456789ABC-@",C_Tuukasyu.EUR);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(140)
    public void testIsCheckOK_A14() {

        boolean result = checkKouzaNo.isCheckOK("１２３456789ABC-",C_Tuukasyu.EUR);

        exBooleanEquals(result, false, "チェック結果");
    }


    @Test
    @TestOrder(150)
    public void testIsCheckOK_A15() {

        boolean result = checkKouzaNo.isCheckOK("1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ/-?:().,'+",C_Tuukasyu.AUD);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(160)
    public void testIsCheckOK_A16() {

        boolean result = checkKouzaNo.isCheckOK("123456789ABC-a",C_Tuukasyu.AUD);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(170)
    public void testIsCheckOK_A17() {

        boolean result = checkKouzaNo.isCheckOK("123456789ABC-@",C_Tuukasyu.AUD);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(180)
    public void testIsCheckOK_A18() {

        boolean result = checkKouzaNo.isCheckOK("１２３456789ABC-",C_Tuukasyu.AUD);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(190)
    public void testIsCheckOK_A19() {

        boolean result = checkKouzaNo.isCheckOK("1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ/-?:().,'+",C_Tuukasyu.BLNK);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(200)
    public void testIsCheckOK_A20() {

        boolean result = checkKouzaNo.isCheckOK("123456789ABC-a",C_Tuukasyu.BLNK);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(210)
    public void testIsCheckOK_A21() {

        boolean result = checkKouzaNo.isCheckOK("123456789ABC-@",C_Tuukasyu.BLNK);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(220)
    public void testIsCheckOK_A22() {

        boolean result = checkKouzaNo.isCheckOK("１２３456789ABC-",C_Tuukasyu.BLNK);

        exBooleanEquals(result, false, "チェック結果");
    }

}
