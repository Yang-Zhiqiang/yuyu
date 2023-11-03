package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#comma(String)} メソッドのテストです。
 * ※引数の型：String<br />
 */

@RunWith(SWAKTestRunner.class)
public class BizUtilTest_comma_1 {
    @Test
    @TestOrder(640)
    public void testComma1A1(){
        String target = "123";
        String result = BizUtil.comma(target);
        String expect = "123";
        exStringEquals(result, expect, "12A(1)対象文字列が４桁未満(３桁)の数値文字列");
    }

    @Test
    @TestOrder(650)
    public void testComma1A2(){
        String target = "1234";
        String result = BizUtil.comma(target);
        String expect = "1,234";
        exStringEquals(result, expect, "12A(2)対象文字列が４桁以上(４桁)の数値文字列");
    }

    @Test
    @TestOrder(660)
    public void testComma1A3(){
        String target = "1234567";
        String result = BizUtil.comma(target);
        String expect = "1,234,567";
        exStringEquals(result, expect, "12A(3)対象文字列が４桁以上(７桁)の数値文字列");
    }

    @Test(expected=NullPointerException.class)
    @TestOrder(670)
    public void testComma1B1(){
        String target = null;
        try{
            BizUtil.comma(target);
        }catch(NullPointerException npe){
            throw npe;
        }
    }

    @Test(expected=NumberFormatException.class)
    @TestOrder(680)
    public void testComma1B2(){
        String target = "";
        try{
            BizUtil.comma(target);
        }catch(NumberFormatException nfe){
            throw nfe;
        }
    }

    @Test(expected=NumberFormatException.class)
    @TestOrder(690)
    public void testComma1B3(){
        String target = "abcdefg";
        try{
            BizUtil.comma(target);
        }catch(NumberFormatException nfe){
            throw nfe;
        }
    }

    @Test
    @TestOrder(700)
    public void testComma1C1(){
        String target = "1234.321";
        String result = BizUtil.comma(target);
        String expect = "1,234";
        exStringEquals(result, expect, "12C(1)小数点を含む(小数第一位が５未満)");
    }

    @Test
    @TestOrder(710)
    public void testComma1C2(){
        String target = "1234.567";
        String result = BizUtil.comma(target);
        String expect = "1,235";
        exStringEquals(result, expect, "12C(2)小数点を含む(小数第一位が５以上)");
    }

}
