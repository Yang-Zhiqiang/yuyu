package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * カナ入力チェッククラスのメソッド {@link CheckKana#isKyokaMoji(String)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class CheckKanaTest_isKyokaMoji {

    @Test
    @TestOrder(10)
    public void testIsKyokaMoji_A1() {
        boolean resultFlag = CheckKana.isKyokaMoji(null);
        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(20)
    public void testIsKyokaMoji_A2() {
        boolean resultFlag = CheckKana.isKyokaMoji("テスト");
        exBooleanEquals(resultFlag, false, "チェック結果");
    }
}