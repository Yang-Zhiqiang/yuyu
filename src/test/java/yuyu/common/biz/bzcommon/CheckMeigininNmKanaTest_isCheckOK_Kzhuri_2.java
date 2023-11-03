package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Kojinhjn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * カナ名義人チェッククラスのメソッド {@link CheckMeigininNmKana#isCheckOK_Kzhuri(String, C_Kojinhjn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckMeigininNmKanaTest_isCheckOK_Kzhuri_2 {

    @Test
    @TestOrder(10)
    public void testIsCheckOK_Kzhuri_A1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Kzhuri(null, C_Kojinhjn.HJN, 10);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(20)
    public void testIsCheckOK_Kzhuri_A2() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Kzhuri("", C_Kojinhjn.HJN, 10);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(30)
    public void testIsCheckOK_Kzhuri_B1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Kzhuri("*", C_Kojinhjn.HJN, 10);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(40)
    public void testIsCheckOK_Kzhuri_B2() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Kzhuri("を", C_Kojinhjn.HJN, 10);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(50)
    public void testIsCheckOK_Kzhuri_B3() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Kzhuri("ヲ", C_Kojinhjn.HJN, 10);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(60)
    public void testIsCheckOK_Kzhuri_B4() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Kzhuri("ｦ", C_Kojinhjn.HJN, 10);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(70)
    public void testIsCheckOK_Kzhuri_C1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Kzhuri("ァｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁツﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜﾝ012３４５6789ABCDEFGHIJKLMNOPQRSTＵＶＷXYZボポ　（）－．／「」ー", C_Kojinhjn.HJN, 247);
        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(80)
    public void testIsCheckOK_Kzhuri_C2() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Kzhuri("ァｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁツﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜｦﾝ012３４５6789ABCDEFGHIJKLMNOPQRSTＵＶＷXYZボポ　（）－．／「」ー", C_Kojinhjn.HJN, 249);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(90)
    public void testIsCheckOK_Kzhuri_D1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Kzhuri("ァｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁツﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜﾝ012３４５6789ABCDEFGHIJKLMNOPQRSTＵＶＷXYZボポ　（）－．／「」ー", C_Kojinhjn.HJN, 93);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(100)
    public void testIsCheckOK_Kzhuri_E1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Kzhuri(" ", C_Kojinhjn.KOJIN, 247);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(110)
    public void testIsCheckOK_Kzhuri_E2() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Kzhuri("  ", C_Kojinhjn.KOJIN, 247);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }
}