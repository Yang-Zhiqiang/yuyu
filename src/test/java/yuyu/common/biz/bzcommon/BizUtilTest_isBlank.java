package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#isBlank(String)} メソッドのテストです。
 * <br />
 */

@RunWith(SWAKTestRunner.class)
public class BizUtilTest_isBlank {
    @Test
    @TestOrder(150)
    public void testIsBlankNull1(){
        String target = null;
        boolean result = BizUtil.isBlank(target);
        boolean expect = true;
        exBooleanEquals(result, expect, "4A(1)nullの場合true");
    }

    @Test
    @TestOrder(160)
    public void testIsBlankBlank1(){
        String target = "   ";
        boolean result = BizUtil.isBlank(target);
        boolean expect = true;
        exBooleanEquals(result, expect, "4B(1)\"   \"(半角スペース×3)はtrue");
    }

    @Test
    @TestOrder(170)
    public void testIsBlankNotBlank1(){
        String target = "  abcd  ";
        boolean result = BizUtil.isBlank(target);
        boolean expect = false;
        exBooleanEquals(result, expect, "4C(1)\"  abcd  \" は false");
    }

}
