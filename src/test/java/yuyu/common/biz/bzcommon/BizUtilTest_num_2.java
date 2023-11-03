package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#num(String, int, int, int, int)} メソッドのテストです。
 * ※引数の型：String,int,int,int,int<br />
 */
@RunWith(SWAKTestRunner.class)
public class BizUtilTest_num_2 {
    private String _target;
    private int    _pat1;
    private int    _len1;
    private int    _pat2;
    private int    _len2;
    @Before
    public void initNum2(){
        _target = "12.34";
        _pat1    = BizUtil.ZERO_FILL;
        _len1    = 3;
        _pat2    = BizUtil.ZERO_FILL;
        _len2    = 3;
    }

    @Test
    @TestOrder(1100)
    public void testNum2A1(){
        String result = BizUtil.num(_target, _pat1, _len1, _pat2, _len2);
        String expect = "012.340";
        exStringEquals(result, expect, "15A(1)対象文字列(０以外)について、変換形式をゼロ埋め、指定桁数を文字列長より大きくした場合");
    }

    @Test
    @TestOrder(1110)
    public void testNum2A2(){
        _pat1 = BizUtil.NON_ZERO_FILL;
        _pat2 = BizUtil.NON_ZERO_FILL;
        String result = BizUtil.num(_target, _pat1, _len1, _pat2, _len2);
        String expect = "12.34";
        exStringEquals(result, expect, "15A(2)対象文字列(０以外)について、変換形式をゼロ埋めしない、指定桁数を文字列長より大きくした場合");
    }

    @Test
    @TestOrder(1120)
    public void testNum2A3(){
        _pat1 = BizUtil.ZERO_FILL_LAST_ONLY;
        _pat2 = BizUtil.ZERO_FILL_LAST_ONLY;
        String result = BizUtil.num(_target, _pat1, _len1, _pat2, _len2);
        String expect = "12.34";
        exStringEquals(result, expect, "15A(3)対象文字列(０以外)について、変換形式を最終桁のみゼロ埋め、指定桁数を文字列長より大きくした場合");
    }

    @Test
    @TestOrder(1130)
    public void testNum2B1(){
        _target = "00.00";
        String result = BizUtil.num(_target, _pat1, _len1, _pat2, _len2);
        String expect = "000.000";
        exStringEquals(result, expect, "15B(1)０を表す文字列について、変換形式をゼロ埋め、指定桁数を文字列長より大きくした場合");
    }

    @Test
    @TestOrder(1140)
    public void testNum2B2(){
        _target = "00.00";
        _pat1 = BizUtil.NON_ZERO_FILL;
        _pat2 = BizUtil.NON_ZERO_FILL;
        String result = BizUtil.num(_target, _pat1, _len1, _pat2, _len2);
        String expect = "0";
        exStringEquals(result, expect, "15B(2)０を表す文字列について、変換形式をゼロ埋めしない、指定桁数を文字列長より大きくした場合");
    }

    @Test
    @TestOrder(1150)
    public void testNum2B3(){
        _target = "00.00";
        _pat1 = BizUtil.ZERO_FILL_LAST_ONLY;
        _pat2 = BizUtil.ZERO_FILL_LAST_ONLY;
        String result = BizUtil.num(_target, _pat1, _len1, _pat2, _len2);
        String expect = "0";
        exStringEquals(result, expect, "15B(3)０を表す文字列について、変換形式を最終桁のみゼロ埋め、指定桁数を文字列長より大きくした場合");
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1160)
    public void testNum2C1(){
        String errmsg = null;
        String expect = "入力桁数が不正です。";
        _len1 = 1;
        try{
            BizUtil.num(_target, _pat1, _len1, _pat2, _len2);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "15C(1)整数部指定桁数を実桁数より小さくした場合");
            throw bae;
        }
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1170)
    public void testNum2C2(){
        String errmsg = null;
        String expect = "入力桁数が不正です。";
        _len2 = 1;
        try{
            BizUtil.num(_target, _pat1, _len1, _pat2, _len2);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "15C(2)小数部指定桁数を実桁数より小さくした場合");
            throw bae;
        }
    }

    @Test
    @TestOrder(1180)
    public void testNum2C3(){
        _pat1 = BizUtil.ZERO_FILL_LAST_ONLY;
        _len1 = 2;
        _pat2 = BizUtil.ZERO_FILL_LAST_ONLY;
        _len2 = 2;
        String result = BizUtil.num(_target, _pat1, _len1, _pat2, _len2);
        String expect = "12.34";
        exStringEquals(result, expect, "15C(3)指定桁数と実桁数が等しい場合");
    }

    @Test(expected=NullPointerException.class)
    @TestOrder(1190)
    public void testNum2D1(){
        _target = null;
        try{
            BizUtil.num(_target, _pat1, _len1, _pat2, _len2);
        }catch(NullPointerException npe){
            throw npe;
        }
    }

    @Test(expected=NumberFormatException.class)
    @TestOrder(1200)
    public void testNum2D2(){
        _target = "";
        _pat1 = BizUtil.NON_ZERO_FILL;
        _pat2 = BizUtil.NON_ZERO_FILL;
        try{
            BizUtil.num(_target, _pat1, _len1, _pat2, _len2);
        }catch(NumberFormatException nfe){
            throw nfe;
        }
    }

    @Test(expected=NumberFormatException.class)
    @TestOrder(1210)
    public void testNum2D3(){
        _target = "ab.cd";
        _pat1 = BizUtil.ZERO_FILL_LAST_ONLY;
        _pat2 = BizUtil.ZERO_FILL_LAST_ONLY;
        try{
            BizUtil.num(_target, _pat1, _len1, _pat2, _len2);
        }catch(NumberFormatException nfe){
            throw nfe;
        }
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1220)
    public void testNum2E1(){
        String errmsg = null;
        String expect = "入力桁数が不正です。";
        _len2 = 40;
        try{
            BizUtil.num(_target, _pat1, _len1, _pat2, _len2);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "15E(1)小数部指定桁数が不正な値(４０)");
            throw bae;
        }
    }

    @Test
    @TestOrder(1230)
    public void testNum2E2(){
        _pat1 = BizUtil.NON_ZERO_FILL;
        _pat2 = BizUtil.NON_ZERO_FILL;
        _len2 = 39;
        String result = BizUtil.num(_target, _pat1, _len1, _pat2, _len2);
        String expect = "12.34";
        exStringEquals(result, expect, "15E(2)小数部指定桁数が正しい値(３９）：比較ケース");
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1240)
    public void testNum2F1(){
        String errmsg = null;
        String expect = "引数が不正です。";
        _pat1 = 3;
        try{
            BizUtil.num(_target, _pat1, _len1, _pat2, _len2);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "15F(1)整数部の変換形式が不正");
            throw bae;
        }
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1250)
    public void testNum2F2(){
        String errmsg = null;
        String expect = "引数が不正です。";
        _pat1 = -1;
        _pat2 = BizUtil.NON_ZERO_FILL;
        try{
            BizUtil.num(_target, _pat1, _len1, _pat2, _len2);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "15F(2)整数部の変換形式が不正");
            throw bae;
        }
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1260)
    public void testNum2F3(){
        String errmsg = null;
        String expect = "引数が不正です。";
        _pat2 = 3;
        try{
            BizUtil.num(_target, _pat1, _len1, _pat2, _len2);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "15F(3)小数部の変換形式が不正");
            throw bae;
        }
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1270)
    public void testNum2F4(){
        String errmsg = null;
        String expect = "引数が不正です。";
        _pat1 = BizUtil.NON_ZERO_FILL;
        _pat2 = -1;
        try{
            BizUtil.num(_target, _pat1, _len1, _pat2, _len2);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "15F(4)小数部の変換形式が不正");
            throw bae;
        }
    }

}
