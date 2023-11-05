package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 電話番号チェッククラスのメソッド {@link CheckTelNo#isCheckOK(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckTelNoTest_isCheckOK {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testIsCheckOK_A1() {
        boolean result = CheckTelNo.isCheckOK(null);
        exBooleanEquals(result, false, "結果");
    }

    @Test
    @TestOrder(20)
    public void testIsCheckOK_A2() {
        boolean result = CheckTelNo.isCheckOK("");
        exBooleanEquals(result, false, "結果");
    }

    @Test
    @TestOrder(30)
    public void testIsCheckOK_B1() {
        boolean result = CheckTelNo.isCheckOK("1394127856#");
        exBooleanEquals(result, false, "結果");
    }

    @Test
    @TestOrder(40)
    public void testIsCheckOK_B2() {
        boolean result = CheckTelNo.isCheckOK("1394-278456");
        exBooleanEquals(result, false, "結果");
    }

    @Test
    @TestOrder(50)
    public void testIsCheckOK_B3() {
        boolean result = CheckTelNo.isCheckOK("--941278569");
        exBooleanEquals(result, false, "結果");
    }

    @Test
    @TestOrder(60)
    public void testIsCheckOK_B4() {
        boolean result = CheckTelNo.isCheckOK("139412-785-");
        exBooleanEquals(result, false, "結果");
    }

    @Test
    @TestOrder(70)
    public void testIsCheckOK_B5() {
        boolean result = CheckTelNo.isCheckOK("139--126789");
        exBooleanEquals(result, false, "結果");
    }

    @Test
    @TestOrder(80)
    public void testIsCheckOK_B6() {
        boolean result = CheckTelNo.isCheckOK("0-1234-56789");
        exBooleanEquals(result, false, "結果");
    }

    @Test
    @TestOrder(90)
    public void testIsCheckOK_B7() {
        boolean result = CheckTelNo.isCheckOK("0123456-78-9");
        exBooleanEquals(result, false, "結果");
    }

    @Test
    @TestOrder(100)
    public void testIsCheckOK_B8() {
        boolean result = CheckTelNo.isCheckOK("139-123-78569");
        exBooleanEquals(result, false, "結果");
    }

    @Test
    @TestOrder(110)
    public void testIsCheckOK_C1() {
        boolean result = CheckTelNo.isCheckOK("03-1234-5678");
        exBooleanEquals(result, true, "結果");
    }

    @Test
    @TestOrder(120)
    public void testIsCheckOK_C2() {
        boolean result = CheckTelNo.isCheckOK("011-123-4567");
        exBooleanEquals(result, true, "結果");
    }

    @Test
    @TestOrder(130)
    public void testIsCheckOK_C3() {
        boolean result = CheckTelNo.isCheckOK("0123-12-3456");
        exBooleanEquals(result, true, "結果");
    }

    @Test
    @TestOrder(140)
    public void testIsCheckOK_C4() {
        boolean result = CheckTelNo.isCheckOK("01267-1-2345");
        exBooleanEquals(result, true, "結果");
    }

    @Test
    @TestOrder(150)
    public void testIsCheckOK_C5() {
        boolean result = CheckTelNo.isCheckOK("090-123-45678");
        exBooleanEquals(result, true, "結果");
    }

    @Test
    @TestOrder(160)
    public void testIsCheckOK_C6() {
        boolean result = CheckTelNo.isCheckOK("080-1234-5678");
        exBooleanEquals(result, true, "結果");
    }

    @Test
    @TestOrder(170)
    public void testIsCheckOK_C7() {
        boolean result = CheckTelNo.isCheckOK("0120-123-456");
        exBooleanEquals(result, true, "結果");
    }

    @Test
    @TestOrder(180)
    public void testIsCheckOK_C8() {
        boolean result = CheckTelNo.isCheckOK("0120-123-4567");
        exBooleanEquals(result, true, "結果");
    }
}
