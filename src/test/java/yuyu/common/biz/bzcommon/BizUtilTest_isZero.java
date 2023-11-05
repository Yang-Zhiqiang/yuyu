package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * 業務汎用ユーティリティクラスのゼロチェックメソッド {@link BizUtil#isZero(BizCurrency)} テスト用クラスです。<br />
 *
 */
@RunWith(SWAKTestRunner.class)
public class BizUtilTest_isZero {

    @Test
    public void testIsZero1() {
        BizCurrency targetValue = null;
        boolean result = BizUtil.isZero(targetValue);
        exBooleanEquals(result,false,"実行結果");
    }

    @Test
    public void testIsZero2() {
        BizCurrency targetValue = BizCurrency.optional();
        boolean result = BizUtil.isZero(targetValue);
        exBooleanEquals(result,false,"実行結果");
    }

    @Test
    public void testIsZero3() {
        BizCurrency targetValue = BizCurrency.valueOf(0);
        boolean result = BizUtil.isZero(targetValue);
        exBooleanEquals(result,true,"実行結果");
    }

    @Test
    public void testIsZero4() {
        BizCurrency targetValue = BizCurrency.valueOf(1);
        boolean result = BizUtil.isZero(targetValue);
        exBooleanEquals(result,false,"実行結果");
    }

    @Test
    public void testIsZero5() {
        BizCurrency targetValue = BizCurrency.valueOf(0.1);
        boolean result = BizUtil.isZero(targetValue);
        exBooleanEquals(result,false,"実行結果");
    }
}
