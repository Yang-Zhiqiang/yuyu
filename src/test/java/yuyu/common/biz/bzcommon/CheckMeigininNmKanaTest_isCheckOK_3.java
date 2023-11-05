package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * カナ名義人チェッククラスのメソッド {@link CheckMeigininNmKana#isCheckOK(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckMeigininNmKanaTest_isCheckOK_3 {

    @Test
    @TestOrder(10)
    public void testIsCheckOK_A1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK(null);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(20)
    public void testIsCheckOK_A2() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK("");
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(30)
    public void testIsCheckOK_B1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK("*");
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(40)
    public void testIsCheckOK_B2() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK("を");
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(50)
    public void testIsCheckOK_B3() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK("ヲ");
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(60)
    public void testIsCheckOK_B4() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK("ｦ");
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(70)
    public void testIsCheckOK_C1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK("ァｲｩエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワンガギグゲゴザジズゼゾダヂヅデドバビブベボヴパピプペポ１２３４５６７８９０ＡbＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱRSTＵＶＷＸＹＺ' ()+-,./:?");
        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(80)
    public void testIsCheckOK_C2() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK("ァｲｩエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲンガギグゲゴザジズゼゾダヂヅデドバビブベボヴパピプペポ１２３４５６７８９０ＡbＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱRSTＵＶＷＸＹＺ' ()+-,./:?");
        exBooleanEquals(resultFlag, false, "チェック結果");
    }
}