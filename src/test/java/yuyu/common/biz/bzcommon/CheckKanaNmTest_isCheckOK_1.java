package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * カナ名チェッククラスのメソッド {@link CheckKanaNm#isCheckOK(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckKanaNmTest_isCheckOK_1 {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testIsCheckOK_A1() {
        boolean resultFlag = CheckKanaNm.isCheckOK(null);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(20)
    public void testIsCheckOK_A2() {
        boolean resultFlag = CheckKanaNm.isCheckOK("");
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(30)
    public void testIsCheckOK_B1() {
        boolean resultFlag = CheckKanaNm.isCheckOK("*");
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(40)
    public void testIsCheckOK_B2() {
        boolean resultFlag = CheckKanaNm.isCheckOK("を");
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(50)
    public void testIsCheckOK_B3() {
        boolean resultFlag = CheckKanaNm.isCheckOK("ヲ");
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(60)
    public void testIsCheckOK_B4() {
        boolean resultFlag = CheckKanaNm.isCheckOK("ｦ");
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(70)
    public void testIsCheckOK_C1() {
        boolean resultFlag = CheckKanaNm.isCheckOK("ァｲｩエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワンガギグゲゴザジズゼゾダヂヅデドバビブベボヴパピプペポー１２３４５６７８９０ＡbＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱRSTＵＶＷＸＹＺ' ()+-,./:?");
        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(80)
    public void testIsCheckOK_C2() {
        boolean resultFlag = CheckKanaNm.isCheckOK("ァｲｩエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲンガギグゲゴザジズゼゾダヂヅデドバビブベボヴパピプペポー１２３４５６７８９０ＡbＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱRSTＵＶＷＸＹＺ' ()+-,./:?");
        exBooleanEquals(resultFlag, false, "チェック結果");
    }
}