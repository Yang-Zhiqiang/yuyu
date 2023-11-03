package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#getSJISLen_From_Unicode(char)} メソッドのテストです。
 * ※引数の型：char<br />
 */

@RunWith(SWAKTestRunner.class)
public class BizUtilTest_getSJISLen_From_Unicode_2 {
    private long execGetSJISLenFromUnicodeString(char target){
        try {
            return BizUtil.getSJISLen_From_Unicode(target);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @TestOrder(220)
    public void testGetSJISLenFromUnicodeChar1(){
        char target = 'a';
        long result = execGetSJISLenFromUnicodeString(target);
        long expect = 1;
        exNumericEquals(result, expect, "6A(1)半角文字の場合");
    }

    @Test
    @TestOrder(230)
    public void testGetSJISLenFromUnicodeChar2(){
        char target = 'あ';
        long result = execGetSJISLenFromUnicodeString(target);
        long expect = 2;
        exNumericEquals(result, expect, "6A(2)全角文字の場合");
    }

}
