package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * カナ名チェッククラスのメソッド {@link CheckKanaNm#isCheckOK(String, int)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckKanaNmTest_isCheckOK_2 {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testIsCheckOK_A1() {
        boolean resultFlag = CheckKanaNm.isCheckOK(null, 10);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(20)
    public void testIsCheckOK_A2() {
        boolean resultFlag = CheckKanaNm.isCheckOK("", 10);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(30)
    public void testIsCheckOK_B1() {
        boolean resultFlag = CheckKanaNm.isCheckOK("*", 10);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(40)
    public void testIsCheckOK_B2() {
        boolean resultFlag = CheckKanaNm.isCheckOK("を", 10);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(50)
    public void testIsCheckOK_B3() {
        boolean resultFlag = CheckKanaNm.isCheckOK("ヲ", 10);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(60)
    public void testIsCheckOK_B4() {
        boolean resultFlag = CheckKanaNm.isCheckOK("ｦ", 10);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(70)
    public void testIsCheckOK_C1() {
        boolean resultFlag = CheckKanaNm.isCheckOK("ァｲｩエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワンガギグゲゴザジズゼゾダヂヅデドバビブベボヴパピプペポー１２３４５６７８９０ＡbＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱRSTＵＶＷＸＹＺ' ()+-,./:?", 247);
        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(80)
    public void testIsCheckOK_C2() {
        boolean resultFlag = CheckKanaNm.isCheckOK("ァｲｩエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲンガギグゲゴザジズゼゾダヂヅデドバビブベボヴパピプペポー１２３４５６７８９０ＡbＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱRSTＵＶＷＸＹＺ' ()+-,./:?", 249);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }
}