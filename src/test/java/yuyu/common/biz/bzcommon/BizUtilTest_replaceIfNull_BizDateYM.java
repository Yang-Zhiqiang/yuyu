package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * 業務汎用ユーティリティクラスのnull置換メソッド（BizDateYM） {@link BizUtil#replaceIfNull(BizDateYM,BizDateYM)} テスト用クラスです。<br />
 *
 */
@RunWith(SWAKTestRunner.class)
public class BizUtilTest_replaceIfNull_BizDateYM {

    @Test
    public void testReplaceIfNull_BizDateYM1() {
        BizDateYM targetValue = null;
        BizDateYM repValue = BizDateYM.valueOf("201505");
        BizDateYM result = BizUtil.replaceIfNull(targetValue, repValue);
        exStringEquals(result.toString(),"201505","結果");
    }

    @Test
    public void testReplaceIfNull_BizDateYM2() {
        BizDateYM targetValue = BizDateYM.valueOf("201504");
        BizDateYM repValue = BizDateYM.valueOf("201505");
        BizDateYM result = BizUtil.replaceIfNull(targetValue, repValue);
        exStringEquals(result.toString(),"201504","結果");
    }
}
