package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Kojinhjn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * カナ名義人チェッククラスのメソッド {@link CheckMeigininNmKana#isCheckOK(String, C_Kojinhjn, int)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckMeigininNmKanaTest_isCheckOK_2 {

    @Test
    @TestOrder(10)
    public void testIsCheckOK_A1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK("アアア　アアア", C_Kojinhjn.KOJIN, 10);
        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(20)
    public void testIsCheckOK_A2() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK("アアア　アアアアアアア", C_Kojinhjn.KOJIN, 10);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(30)
    public void testIsCheckOK_A3() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK("アアアアアアアアア", C_Kojinhjn.KOJIN, 10);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

}