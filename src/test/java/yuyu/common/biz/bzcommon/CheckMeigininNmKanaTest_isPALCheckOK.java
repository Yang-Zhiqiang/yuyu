package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Kojinhjn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * カナ名義人チェッククラスのメソッド {@link CheckMeigininNmKanji#isPALCheckOK(String, C_Kojinhjn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckMeigininNmKanaTest_isPALCheckOK {



    @Test
    @TestOrder(110)
    public void testIsCheckOK_A1() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK(null, C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(110)
    public void testIsCheckOK_A2() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("", C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(110)
    public void testIsCheckOK_A3() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("ア　ア", null);
        exBooleanEquals(resultFlag, true, "チェック結果");
    }


    @Test
    @TestOrder(110)
    public void testIsCheckOK_B1() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("あ　い",  C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(110)
    public void testIsCheckOK_B2() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("－　ア",  C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(110)
    public void testIsCheckOK_B3() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("ア",  C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }


    @Test
    @TestOrder(110)
    public void testIsCheckOK_B4() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("ア　ア　ア",  C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(110)
    public void testIsCheckOK_B5() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("アア",  C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(110)
    public void testIsCheckOK_B6() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("アンン　ア",  C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(110)
    public void testIsCheckOK_B7() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("アン－　ア",  C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }


    @Test
    @TestOrder(110)
    public void testIsCheckOK_B8() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("ア－－　ア",  C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }


    @Test
    @TestOrder(110)
    public void testIsCheckOK_B9() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("ア　ンア",  C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(110)
    public void testIsCheckOK_B10() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("ア　－ア",  C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }


    @Test
    @TestOrder(110)
    public void testIsCheckOK_B11() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("ンア－　ア",  C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(110)
    public void testIsCheckOK_C1() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワンガギグゲゴザジズゼゾダヂヅデドバビブベボヴパピプペ　ポ－", C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(110)
    public void testIsCheckOK_D1() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("ア．ア", C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(110)
    public void testIsCheckOK_D2() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("ア．ア．ア", C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }


    @Test
    @TestOrder(120)
    public void testIsCheckOK_E1() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("ア　アｶﾞ", C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(130)
    public void testIsCheckOK_F1() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("ア　ヲ", C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(140)
    public void testIsCheckOK_F2() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("ア　ア２", C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(150)
    public void testIsCheckOK_F3() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("ア　アＡＢＣＤ", C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(160)
    public void testIsCheckOK_F4() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("ア　（ア）", C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(160)
    public void testIsCheckOK_F5() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("ア　アァ", C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }


    @Test
    @TestOrder(160)
    public void testIsCheckOK_F6() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("ア　アーア", C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(160)
    public void testIsCheckOK_F7() {
        boolean resultFlag = CheckMeigininNmKana.isPALCheckOK("ア　ア‐ア", C_Kojinhjn.KOJIN);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

}