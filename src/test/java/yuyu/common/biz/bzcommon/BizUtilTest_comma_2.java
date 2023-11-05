package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#comma(String, int, int)} メソッドのテストです。
 * ※引数の型：String,int,int<br />
 */

@RunWith(SWAKTestRunner.class)
public class BizUtilTest_comma_2 {
    private String _target;
    private int    _pat;
    private int    _len;
    @Before
    public void initComma2(){
        _target = "123.4";
        _pat    = BizUtil.ZERO_FILL;
        _len    = 3;
    }

    @Test
    @TestOrder(720)
    public void testComma2A1(){
        String result = BizUtil.comma(_target, _pat, _len);
        String expect = "123.400";
        exStringEquals(result, expect, "13A(1)対象文字列の整数部が４桁未満(３桁)の数値文字列");
    }

    @Test
    @TestOrder(730)
    public void testComma2A2(){
        _pat = BizUtil.NON_ZERO_FILL;
        String result = BizUtil.comma(_target, _pat, _len);
        String expect = "123.4";
        exStringEquals(result, expect, "13A(2)対象文字列の整数部が４桁未満(３桁)の数値文字列");
    }

    @Test
    @TestOrder(740)
    public void testComma2A3(){
        _target = "123.456";
        _pat    = BizUtil.NON_ZERO_FILL;
        _len    = 2;
        String result = BizUtil.comma(_target, _pat, _len);
        String expect = "123.46";
        exStringEquals(result, expect, "13A(3)対象文字列の整数部が４桁未満(３桁)の数値文字列");
    }

    @Test
    @TestOrder(750)
    public void testComma2A4(){
        _target = "1234.5";
        String result = BizUtil.comma(_target, _pat, _len);
        String expect = "1,234.500";
        exStringEquals(result, expect, "13A(4)対象文字列の整数部が４桁以上(４桁)の数値文字列");
    }

    @Test(expected=NullPointerException.class)
    @TestOrder(760)
    public void testComma2B1(){
        _target = null;
        try{
            BizUtil.comma(_target, _pat, _len);
        }catch(NullPointerException npe){
            throw npe;
        }
    }

    @Test(expected=NumberFormatException.class)
    @TestOrder(770)
    public void testComma2B2(){
        _target = "";
        try{
            BizUtil.comma(_target, _pat, _len);
        }catch(NumberFormatException nfe){
            throw nfe;
        }
    }

    @Test(expected=NumberFormatException.class)
    @TestOrder(780)
    public void testComma2B3(){
        _target = "abcd.ef";
        try{
            BizUtil.comma(_target, _pat, _len);
        }catch(NumberFormatException nfe){
            throw nfe;
        }
    }

    @Test
    @TestOrder(790)
    public void testComma2C1(){
        _target = "123";
        String result = BizUtil.comma(_target, _pat, _len);
        String expect = "123.000";
        exStringEquals(result, expect, "13C(1)対象文字列の整数部が４桁未満(３桁)の数値文字列");
    }

    @Test
    @TestOrder(800)
    public void testComma2C2(){
        _target = "1234";
        _pat    = BizUtil.NON_ZERO_FILL;
        String result = BizUtil.comma(_target, _pat, _len);
        String expect = "1,234";
        exStringEquals(result, expect, "13C(2)対象文字列の整数部が４桁以上(４桁)の数値文字列");
    }

    @Test(expected=BizAppException.class)
    @TestOrder(810)
    public void testComma2D1(){
        String errmsg = null;
        String expect = "引数が不正です。";
        _pat = 3;
        try{
            BizUtil.comma(_target, _pat, _len);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "13D(1)小数部の変換形式が不正");
            throw bae;
        }
    }

    @Test(expected=BizAppException.class)
    @TestOrder(820)
    public void testComma2D2(){
        String errmsg = null;
        String expect = "引数が不正です。";
        _pat = -1;
        try{
            BizUtil.comma(_target, _pat, _len);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "13D(2)小数部の変換形式が不正");
            throw bae;
        }
    }

    @Test(expected=BizAppException.class)
    @TestOrder(830)
    public void testComma2E1(){
        String errmsg = null;
        String expect = "入力桁数が不正です。";
        _len = 40;
        try{
            BizUtil.comma(_target, _pat, _len);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "13E(1)指定フォーマット長が不正な値(４０）");
            throw bae;
        }
    }

    @Test
    @TestOrder(840)
    public void testComma2E2(){
        _pat    = BizUtil.NON_ZERO_FILL;
        _len   = 39;
        String result = BizUtil.comma(_target, _pat, _len);
        String expect = "123.4";
        exStringEquals(result, expect, "13E(2)指定フォーマット長が正しい値(３９）：比較ケース");
    }

    @Test
    @TestOrder(850)
    public void testComma2F1(){
        _len   = 0;
        String result = BizUtil.comma(_target, _pat, _len);
        String expect = "123";
        exStringEquals(result, expect, "13F(1)指定フォーマット長が不正な値(０）、ゼロ埋め");
    }

    @Test
    @TestOrder(860)
    public void testComma2F2(){
        _target = "1234.56";
        _pat    = BizUtil.NON_ZERO_FILL;
        _len    = -1;
        String result = BizUtil.comma(_target, _pat, _len);
        String expect = "1,235";
        exStringEquals(result, expect, "13F(2)指定フォーマット長が不正な値(－１）、ゼロ埋めなし");
    }

}
