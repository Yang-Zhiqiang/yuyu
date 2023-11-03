package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * 業務汎用ユーティリティクラスのnull置換メソッド（Integer） {@link BizUtil#replaceIfNull(Integer,Integer)} テスト用クラスです。<br />
 *
 */
@RunWith(SWAKTestRunner.class)
public class BizUtilTest_replaceIfNull_Integer {

    @Test
    public void testReplaceIfNull_Integer1() {
        Integer targetValue = null;
        Integer repValue = 1234;
        Integer result = BizUtil.replaceIfNull(targetValue, repValue);
        exNumericEquals(result,1234,"結果");
    }

    @Test
    public void testReplaceIfNull_Integer2() {
        Integer targetValue = 1;
        Integer repValue = 1234;
        Integer result = BizUtil.replaceIfNull(targetValue, repValue);
        exNumericEquals(result,1,"結果");
    }

    @Test
    public void testReplaceIfNull_Integer3() {
        Integer targetValue = 0;
        Integer repValue = 1234;
        Integer result = BizUtil.replaceIfNull(targetValue, repValue);
        exNumericEquals(result,0,"結果");
    }
}
