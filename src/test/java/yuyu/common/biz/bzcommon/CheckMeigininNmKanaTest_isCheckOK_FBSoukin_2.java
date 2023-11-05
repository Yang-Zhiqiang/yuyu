package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * カナ名義人チェッククラスのメソッド {@link CheckMeigininNmKana#isCheckOK_FBSoukin(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckMeigininNmKanaTest_isCheckOK_FBSoukin_2 {

    @Test
    @TestOrder(10)
    public void testIsCheckOK_FBSoukin_A1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_FBSoukin(null, 10);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(20)
    public void testIsCheckOK_FBSoukin_A2() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_FBSoukin("", 10);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(30)
    public void testIsCheckOK_FBSoukin_B1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_FBSoukin("*", 10);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(40)
    public void testIsCheckOK_FBSoukin_B2() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_FBSoukin("を", 10);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(50)
    public void testIsCheckOK_FBSoukin_B3() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_FBSoukin("ヲ", 10);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(60)
    public void testIsCheckOK_FBSoukin_B4() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_FBSoukin("ｦ", 10);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(70)
    public void testIsCheckOK_FBSoukin_C1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_FBSoukin("ァｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁツﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜﾝ０１２3456789ABCDEFGHＩＪＫLMNOPQRSTUVWXYZボポﾞﾟ ()-,./｢\\｣ｰ", 247);
        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(80)
    public void testIsCheckOK_FBSoukin_C2() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_FBSoukin("ァｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁツﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜｦﾝ０１２3456789ABCDEFGHＩＪＫLMNOPQRSTUVWXYZボポﾞﾟ ()-,./｢\\｣ｰ", 249);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(90)
    public void testIsCheckOK_FBSoukin_D1() {
        boolean resultFlag = CheckMeigininNmKana.isCheckOK_FBSoukin("ァｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁツﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜﾝ０１２3456789ABCDEFGHＩＪＫLMNOPQRSTUVWXYZボポﾞﾟ ()-,./｢\\｣ｰ", 97);
        exBooleanEquals(resultFlag, false, "チェック結果");
    }
}