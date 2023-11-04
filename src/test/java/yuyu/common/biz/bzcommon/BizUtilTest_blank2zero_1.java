package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#blank2zero(String)} メソッドのテストです。
 * ※ブランク(String)＞ゼロ(String)変換<br />
 */

@RunWith(SWAKTestRunner.class)
public class BizUtilTest_blank2zero_1 {
    @Test
    @TestOrder(80)
    public void testBlank2ZeroStringBlank1(){
        String target = "";
        String result = BizUtil.blank2zero(target);
        String expect = "0";
        exStringEquals(result, expect, "2A(1)\"\"を変換");
    }

    @Test
    @TestOrder(90)
    public void testBlank2ZeroStringNotBlank1(){
        String target = "1234";
        String result = BizUtil.blank2zero(target);
        String expect = "1234";
        exStringEquals(result, expect, "2B(1)\"1234\"は変換しない");
    }

    @Test
    @TestOrder(100)
    public void testBlank2ZeroStringNotBlank2(){
        String target = "abcd";
        String result = BizUtil.blank2zero(target);
        String expect = "abcd";
        exStringEquals(result, expect, "2B(2)\"abcd\"は変換しない");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(110)
    public void testBlank2ZeroStringNull1(){
        String target = null;
        String errmsg = null;
        String expect = "nullチェックエラーです。不明";
        try{
            BizUtil.blank2zero(target);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "2C(1)null は例外発生");
            throw bae;
        }
    }

}
