package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Kojinhjn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * カナ名義人チェッククラスのメソッド {@link CheckMeigininNmKana#isCheckOK(String, C_Kojinhjn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckMeigininNmKanaTest_isCheckOK_1 {

    @Test
    @TestOrder(10)
    public void testIsCheckOK_A1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK(null, C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(20)
    public void testIsCheckOK_A2() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK("テスト", C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }


}