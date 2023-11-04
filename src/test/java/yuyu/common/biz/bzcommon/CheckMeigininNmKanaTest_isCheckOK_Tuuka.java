package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * カナ名義人チェッククラスのメソッド {@link CheckMeigininNmKana#isCheckOK_Tuuka(String, C_Tuukasyu)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckMeigininNmKanaTest_isCheckOK_Tuuka {

    @Test
    @TestOrder(10)
    public void testIsCheckOK_Tuuka_A1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Tuuka(null ,C_Tuukasyu.BLNK);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(20)
    public void testIsCheckOK_Tuuka_A2() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Tuuka("" , C_Tuukasyu.BLNK);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(30)
    public void testIsCheckOK_Tuuka_A3() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Tuuka("1" ,C_Tuukasyu.BLNK);
        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(40)
    public void testIsCheckOK_Tuuka_B1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Tuuka("を", C_Tuukasyu.JPY);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(50)
    public void testIsCheckOK_Tuuka_B2() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Tuuka("ヲ", C_Tuukasyu.JPY);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(60)
    public void testIsCheckOK_Tuuka_B3() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Tuuka("ｦ", C_Tuukasyu.JPY);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(70)
    public void testIsCheckOK_Tuuka_C1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Tuuka("ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜﾝ0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZﾞﾟ()\\-.",C_Tuukasyu.JPY);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(80)
    public void testIsCheckOK_Tuuka_C2() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Tuuka("ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜﾝ0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZﾞﾟ()-.",C_Tuukasyu.JPY);
        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(90)
    public void testIsCheckOK_Tuuka_C3() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Tuuka("アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワン０１２３４５６７８９ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ゛゜（）－．",C_Tuukasyu.JPY);
        exBooleanEquals(resultFlag, true, "チェック結果");
    }
    @Test
    @TestOrder(100)
    public void testIsCheckOK_Tuuka_C4() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Tuuka("ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜｦﾝ0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZﾞﾟ()\\-.",C_Tuukasyu.JPY);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(110)
    public void testIsCheckOK_Tuuka_C5() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Tuuka("ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜｦﾝ0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZﾞﾟ()-.",C_Tuukasyu.JPY);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(120)
    public void testIsCheckOK_Tuuka_C6() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_Tuuka("アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲン０１２３４５６７８９ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ゛゜（）－．",C_Tuukasyu.JPY);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }
}