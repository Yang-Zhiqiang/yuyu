package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#getSJISLen_From_Unicode(String)} メソッドのテストです。
 * ※引数の型：String<br />
 */

@RunWith(SWAKTestRunner.class)
public class BizUtilTest_getSJISLen_From_Unicode_1 {
    private int execGetSJISLenFromUnicodeString(String target){
        try {
            return BizUtil.getSJISLen_From_Unicode(target);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @TestOrder(180)
    public void testGetSJISLenFromUnicodeStringNull(){
        String target = null;
        int result = execGetSJISLenFromUnicodeString(target);
        int expect = 0;
        exNumericEquals(result, expect, "5A(1)nullの場合 0 を返す");
    }

    @Test
    @TestOrder(190)
    public void testGetSJISLenFromUnicodeStringNotNull1(){
        String target = "abcd";
        int result = execGetSJISLenFromUnicodeString(target);
        int expect = 4;
        exNumericEquals(result, expect, "5B(1)半角のみの場合");
    }

    @Test
    @TestOrder(200)
    public void testGetSJISLenFromUnicodeStringNotNull2(){
        String target = "あいうえ";
        int result = execGetSJISLenFromUnicodeString(target);
        int expect = 8;
        exNumericEquals(result, expect, "5B(2)全角のみの場合");
    }

    @Test
    @TestOrder(210)
    public void testGetSJISLenFromUnicodeStringNotNull3(){
        String target = "おeかf";
        int result = execGetSJISLenFromUnicodeString(target);
        int expect = 6;
        exNumericEquals(result, expect, "5B(3)半角全角を混ぜた場合");
    }

}
