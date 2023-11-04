package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KykKbn;


/**
 * 業務汎用ユーティリティクラスのnull置換メソッド（Integer） {@link BizUtil#replaceIfNull(Classification<?>,Classification<?>)} テスト用クラスです。<br />
 *
 */
@RunWith(SWAKTestRunner.class)
public class BizUtilTest_replaceIfNull_Kbn {

    @Test
    public void testReplaceIfNull_Kbn1() {
        C_KykKbn targetValue = null;
        C_KykKbn repValue = C_KykKbn.KEIHI_BETU;
        C_KykKbn result = (C_KykKbn)BizUtil.replaceIfNull(targetValue, repValue);
        exClassificationEquals(result, C_KykKbn.KEIHI_BETU, "結果");
    }

    @Test
    public void testReplaceIfNull_Kbn2() {
        C_KykKbn targetValue = C_KykKbn.KEIHI_DOUITU;
        C_KykKbn repValue = C_KykKbn.KEIHI_BETU;
        C_KykKbn result = (C_KykKbn)BizUtil.replaceIfNull(targetValue, repValue);
        exClassificationEquals(result, C_KykKbn.KEIHI_DOUITU, "結果");
    }
}
