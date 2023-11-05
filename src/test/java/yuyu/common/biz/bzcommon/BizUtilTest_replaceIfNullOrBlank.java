package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * 業務汎用ユーティリティクラスのnull・ブランク置換メソッド {@link BizUtil#replaceIfNullOrBlank(String,String)} テスト用クラスです。<br />
 *
 */
@RunWith(SWAKTestRunner.class)
public class BizUtilTest_replaceIfNullOrBlank {

    @Test
    public void testReplaceIfNullOrBlank1() {
        String targetValue = null;
        String repValue = "置換値";
        String result = BizUtil.replaceIfNullOrBlank(targetValue, repValue);
        exStringEquals(result,"置換値","結果");
    }

    @Test
    public void testReplaceIfNullOrBlank2() {
        String targetValue = "";
        String repValue = "置換値";
        String result = BizUtil.replaceIfNullOrBlank(targetValue, repValue);
        exStringEquals(result,"置換値","結果");
    }

    @Test
    public void testReplaceIfNullOrBlank3() {
        String targetValue = "対象文字列";
        String repValue = "置換値";
        String result = BizUtil.replaceIfNullOrBlank(targetValue, repValue);
        exStringEquals(result,"対象文字列","結果");
    }

    @Test
    public void testReplaceIfNullOrBlank4() {
        String targetValue = " ";
        String repValue = "置換値";
        String result = BizUtil.replaceIfNullOrBlank(targetValue, repValue);
        exStringEquals(result," ","結果");
    }
}
