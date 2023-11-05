package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Kojinhjn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * カナ名義人チェッククラスのメソッド {@link CheckMeigininNmKana#isCheckOK_Koza(String, C_Kojinhjn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckMeigininNmKanaTest_isCheckOK_Koza_1 {

    @Test
    @TestOrder(10)
    public void testIsCheckOK_Koza_A1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Koza(null, C_Kojinhjn.HJN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(20)
    public void testIsCheckOK_Koza_A2() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Koza("", C_Kojinhjn.HJN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(30)
    public void testIsCheckOK_Koza_B1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Koza("*", C_Kojinhjn.HJN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(40)
    public void testIsCheckOK_Koza_B2() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Koza("を", C_Kojinhjn.HJN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(50)
    public void testIsCheckOK_Koza_B3() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Koza("ヲ", C_Kojinhjn.HJN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(60)
    public void testIsCheckOK_Koza_B4() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Koza("ｦ", C_Kojinhjn.HJN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(70)
    public void testIsCheckOK_Koza_C1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Koza("ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄナニﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜﾝ0123４５6789ABＣＤＥFGHIJKLMNOPQRSTUVWXYZボポﾞﾟ()-. ", C_Kojinhjn.HJN);
        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(80)
    public void testIsCheckOK_Koza_C2() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Koza("ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄナニﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜｦﾝ0123４５6789ABＣＤＥFGHIJKLMNOPQRSTUVWXYZボポﾞﾟ()-. ", C_Kojinhjn.HJN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(90)
    public void testIsCheckOK_Koza_D1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Koza("ｱ", C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(100)
    public void testIsCheckOK_Koza_D2() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Koza("  ", C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }
}