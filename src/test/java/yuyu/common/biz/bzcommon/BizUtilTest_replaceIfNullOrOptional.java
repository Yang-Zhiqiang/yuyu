package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * 業務汎用ユーティリティクラスのnull置換メソッド（Integer） {@link BizUtil#replaceIfNullOrOptional(BizCurrency,BizCurrency)} テスト用クラスです。<br />
 *
 */
@RunWith(SWAKTestRunner.class)
public class BizUtilTest_replaceIfNullOrOptional {

    @Test
    public void testReplaceIfNullOrOptional1() {
        BizCurrency targetValue = null;
        BizCurrency repValue = BizCurrency.valueOf(1234);
        BizCurrency result = BizUtil.replaceIfNullOrOptional(targetValue, repValue);
        exBizCalcbleEquals(result, BizCurrency.valueOf(1234), "結果");
    }

    @Test
    public void testReplaceIfNullOrOptional2() {
        BizCurrency targetValue = BizCurrency.optional();
        BizCurrency repValue = BizCurrency.valueOf(1234);
        BizCurrency result = BizUtil.replaceIfNullOrOptional(targetValue, repValue);
        exBizCalcbleEquals(result,BizCurrency.valueOf(1234),"結果");
    }

    @Test
    public void testReplaceIfNullOrOptional3() {
        BizCurrency targetValue = BizCurrency.valueOf(1);
        BizCurrency repValue = BizCurrency.valueOf(1234);
        BizCurrency result = BizUtil.replaceIfNullOrOptional(targetValue, repValue);
        exBizCalcbleEquals(result,BizCurrency.valueOf(1),"結果");
    }

    @Test
    public void testReplaceIfNullOrOptional4() {
        BizCurrency targetValue = BizCurrency.valueOf(0);
        BizCurrency repValue = BizCurrency.valueOf(1234);
        BizCurrency result = BizUtil.replaceIfNullOrOptional(targetValue, repValue);
        exBizCalcbleEquals(result,BizCurrency.valueOf(0),"結果");
    }
}
