package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * カナ入力チェッククラスのメソッド {@link CheckKana#isKyoyouKetaHankaku(String, int)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class CheckKanaTest_isKyoyouKetaHankaku {

    @Test
    @TestOrder(10)
    public void testIsKyoyouKetaHankaku_A1() {
        boolean resultFlag = CheckKana.isKyoyouKetaHankaku(null, 0);

        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(20)
    public void testIsKyoyouKetaHankaku_A2() {
        boolean resultFlag = CheckKana.isKyoyouKetaHankaku("", 0);

        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(30)
    public void testIsKyoyouKetaHankaku_B1() {
        boolean resultFlag = CheckKana.isKyoyouKetaHankaku("アアア", 2);

        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(40)
    public void testIsKyoyouKetaHankaku_B2() {
        boolean resultFlag = CheckKana.isKyoyouKetaHankaku("アアア", 3);

        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(50)
    public void testIsKyoyouKetaHankaku_B3() {
        boolean resultFlag = CheckKana.isKyoyouKetaHankaku("アア", 3);

        exBooleanEquals(resultFlag, true, "チェック結果");
    }
}