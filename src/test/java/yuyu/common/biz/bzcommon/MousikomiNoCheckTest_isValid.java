package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 申込番号チェッククラスのメソッド {@link MousikomiNoCheck#isValid(String)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class MousikomiNoCheckTest_isValid {

    @Test
    @TestOrder(10)
    public void testIsValid_A1() {

        String mosno = null;

        boolean result = MousikomiNoCheck.isValid(mosno);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(20)
    public void testIsValid_A2() {

        String mosno = "98000001";

        boolean result = MousikomiNoCheck.isValid(mosno);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(30)
    public void testIsValid_A3() {

        String mosno = "98abcdef1";

        boolean result = MousikomiNoCheck.isValid(mosno);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(50)
    public void testIsValid_A5() {

        String mosno = "980000037";

        boolean result = MousikomiNoCheck.isValid(mosno);

        exBooleanEquals(result, false, "チェック結果");
    }

    @Test
    @TestOrder(60)
    public void testIsValid_A6() {

        String mosno = "980000038";

        boolean result = MousikomiNoCheck.isValid(mosno);

        exBooleanEquals(result, true, "チェック結果");
    }

    @Test
    @TestOrder(70)
    public void testIsValid_A7() {

        String mosno1 = "779999998";
        String mosno2 = "800000038";
        String mosno3 = "850000039";
        String mosno4 = "980000040";
        String mosno5 = "900000041";
        String mosno6 = "960000042";

        boolean result1 = MousikomiNoCheck.isValid(mosno1);
        boolean result2 = MousikomiNoCheck.isValid(mosno2);
        boolean result3 = MousikomiNoCheck.isValid(mosno3);
        boolean result4 = MousikomiNoCheck.isValid(mosno4);
        boolean result5 = MousikomiNoCheck.isValid(mosno5);
        boolean result6 = MousikomiNoCheck.isValid(mosno6);

        exBooleanEquals(result1, false, "チェック結果");
        exBooleanEquals(result2, false, "チェック結果");
        exBooleanEquals(result3, false, "チェック結果");
        exBooleanEquals(result4, false, "チェック結果");
        exBooleanEquals(result5, false, "チェック結果");
        exBooleanEquals(result6, false, "チェック結果");
    }

    @Test
    @TestOrder(80)
    public void testIsValid_A8() {

        String mosno1 = "789999992";
        String mosno2 = "799999990";
        String mosno3 = "869999995";
        String mosno4 = "879999993";
        String mosno5 = "880000013";
        String mosno7 = "970000014";
        String mosno8 = "980000046";
        String mosno9 = "990000044";
        String mosno10 = "870000007";
        String mosno11 = "880000005";
        String mosno12 = "790000004";

        boolean result1 = MousikomiNoCheck.isValid(mosno1);
        boolean result2 = MousikomiNoCheck.isValid(mosno2);
        boolean result3 = MousikomiNoCheck.isValid(mosno3);
        boolean result4 = MousikomiNoCheck.isValid(mosno4);
        boolean result5 = MousikomiNoCheck.isValid(mosno5);
        boolean result7 = MousikomiNoCheck.isValid(mosno7);
        boolean result8 = MousikomiNoCheck.isValid(mosno8);
        boolean result9 = MousikomiNoCheck.isValid(mosno9);
        boolean result10 = MousikomiNoCheck.isValid(mosno10);
        boolean result11 = MousikomiNoCheck.isValid(mosno11);
        boolean result12 = MousikomiNoCheck.isValid(mosno12);

        exBooleanEquals(result1, true, "チェック結果");
        exBooleanEquals(result2, true, "チェック結果");
        exBooleanEquals(result3, true, "チェック結果");
        exBooleanEquals(result4, true, "チェック結果");
        exBooleanEquals(result5, true, "チェック結果");
        exBooleanEquals(result7, true, "チェック結果");
        exBooleanEquals(result8, true, "チェック結果");
        exBooleanEquals(result9, true, "チェック結果");
        exBooleanEquals(result10, true, "チェック結果");
        exBooleanEquals(result11, true, "チェック結果");
        exBooleanEquals(result12, true, "チェック結果");

        MockObjectManager.initialize();
    }

}
