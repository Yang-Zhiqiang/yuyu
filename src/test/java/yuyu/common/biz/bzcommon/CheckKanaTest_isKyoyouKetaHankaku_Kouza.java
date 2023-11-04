package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * カナ入力チェッククラスのメソッド {@link CheckKana#isKyoyouKetaHankaku_Kouza(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckKanaTest_isKyoyouKetaHankaku_Kouza {

    @Test
    @TestOrder(10)
    public void testisKyoyouKetaHankaku_Kouza_A1() {
        boolean resultFlag = CheckKana.isKyoyouKetaHankaku_Kouza(null);

        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(20)
    public void testisKyoyouKetaHankaku_Kouza_A2() {
        boolean resultFlag = CheckKana.isKyoyouKetaHankaku_Kouza("");

        exBooleanEquals(resultFlag, true, "チェック結果");
    }
    @Test
    @TestOrder(30)
    public void testisKyoyouKetaHankaku_Kouza_A3() {
        boolean resultFlag = CheckKana.isKyoyouKetaHankaku_Kouza("1");

        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(40)
    public void testisKyoyouKetaHankaku_Kouza_B1() {
        boolean resultFlag = CheckKana.isKyoyouKetaHankaku_Kouza("アイウエオアイウエオアイウエオアイウエオアイウエオアイウエオ");

        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(50)
    public void testisKyoyouKetaHankaku_Kouza_B2() {
        boolean resultFlag = CheckKana.isKyoyouKetaHankaku_Kouza("アイウエオアイウエオアイウエオアイウエオアイウエオアイウエオ１");

        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(60)
    public void testisKyoyouKetaHankaku_Kouza_B3() {
        boolean resultFlag = CheckKana.isKyoyouKetaHankaku_Kouza("アイウエオアイウエオアイウエオアイウエオアイウエオアイウエ");

        exBooleanEquals(resultFlag, true, "チェック結果");
    }
    @Test
    @TestOrder(70)
    public void testisKyoyouKetaHankaku_Kouza_C1() {
        boolean resultFlag = CheckKana.isKyoyouKetaHankaku_Kouza("アイウエオアイウエオアイウエオアイウエオアイウエオガギグゲゴ");

        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(80)
    public void testisKyoyouKetaHankaku_Kouza_C2() {
        boolean resultFlag = CheckKana.isKyoyouKetaHankaku_Kouza("アイウエオアイウエオアイウエオアイウエオアイウエオパピプペポ");

        exBooleanEquals(resultFlag, false, "チェック結果");
    }

    @Test
    @TestOrder(90)
    public void testisKyoyouKetaHankaku_Kouza_C3() {
        boolean resultFlag = CheckKana.isKyoyouKetaHankaku_Kouza("アイウエオアイウエオアイウエオアイウエオアイウエオＡＢＣＤＥ");

        exBooleanEquals(resultFlag, true, "チェック結果");
    }
}