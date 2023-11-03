package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#num(String, int, int)} メソッドのテストです。
 * ※引数の型：String, int, int<br />
 */

@RunWith(SWAKTestRunner.class)
public class BizUtilTest_num_1 {
    private String _target;
    private int    _pat;
    private int    _len;
    @Before
    public void initNum1(){
        _target = "99";
        _pat    = BizUtil.ZERO_FILL;
        _len    = 3;
    }

    @Test
    @TestOrder(870)
    public void testNum1A1(){
        String result = BizUtil.num(_target, _pat, _len);
        String expect = "099";
        exStringEquals(result, expect, "14A(1)対象文字列が０以外の整数値文字列(２桁)について、変換形式をゼロ埋め、指定桁数を文字列長より大きくした場合");
    }

    @Test
    @TestOrder(880)
    public void testNum1A2(){
        _pat = BizUtil.NON_ZERO_FILL;
        String result = BizUtil.num(_target, _pat, _len);
        String expect = "99";
        exStringEquals(result, expect, "14A(2)対象文字列が０以外の整数値文字列(２桁)について、変換形式をゼロ埋めしない、指定桁数を文字列長より大きくした場合");
    }

    @Test
    @TestOrder(890)
    public void testNum1A3(){
        _pat = BizUtil.ZERO_FILL_LAST_ONLY;
        String result = BizUtil.num(_target, _pat, _len);
        String expect = "99";
        exStringEquals(result, expect, "14A(3)対象文字列が０以外の整数値文字列(２桁)について、変換形式を最終桁のみゼロ埋め、指定桁数を文字列長より大きくした場合");
    }

    @Test
    @TestOrder(900)
    public void testNum1A4(){
        _len = 1;
        String result = BizUtil.num(_target, _pat, _len);
        String expect = "99";
        exStringEquals(result, expect, "14A(4)対象文字列が０以外の整数値文字列(２桁)について、変換形式をゼロ埋め、指定桁数を文字列長以下にした場合");
    }

    @Test
    @TestOrder(910)
    public void testNum1A5(){
        _pat = BizUtil.NON_ZERO_FILL;
        _len = 1;
        String result = BizUtil.num(_target, _pat, _len);
        String expect = "99";
        exStringEquals(result, expect, "14A(5)対象文字列が０以外の整数値文字列(２桁)について、変換形式をゼロ埋めしない、指定桁数を文字列長以下にした場合");
    }

    @Test
    @TestOrder(920)
    public void testNum1A6(){
        _pat = BizUtil.ZERO_FILL_LAST_ONLY;
        _len = 1;
        String result = BizUtil.num(_target, _pat, _len);
        String expect = "99";
        exStringEquals(result, expect, "14A(6)対象文字列が０以外の整数値文字列(２桁)について、変換形式を最終桁のみゼロ埋め、指定桁数を文字列長以下にした場合");
    }

    @Test
    @TestOrder(930)
    public void testNum1B1(){
        _target = "00";
        String result = BizUtil.num(_target, _pat, _len);
        String expect = "000";
        exStringEquals(result, expect, "14B(1)０を表す文字列について、変換形式をゼロ埋め、指定桁数を文字列長より大きくした場合");
    }

    @Test
    @TestOrder(940)
    public void testNum1B2(){
        _target = "00";
        _pat    = BizUtil.NON_ZERO_FILL;
        String result = BizUtil.num(_target, _pat, _len);
        String expect = "0";
        exStringEquals(result, expect, "14B(2)０を表す文字列について、変換形式をゼロ埋めしない、指定桁数を文字列長より大きくした場合");
    }

    @Test
    @TestOrder(950)
    public void testNum1B3(){
        _target = "00";
        _pat    = BizUtil.ZERO_FILL_LAST_ONLY;
        String result = BizUtil.num(_target, _pat, _len);
        String expect = "0";
        exStringEquals(result, expect, "14B(3)０を表す文字列について、変換形式を最終桁のみゼロ埋め、指定桁数を文字列長より大きくした場合");
    }

    @Test
    @TestOrder(960)
    public void testNum1B4(){
        _target = "00";
        _len    = 1;
        String result = BizUtil.num(_target, _pat, _len);
        String expect = "0";
        exStringEquals(result, expect, "14B(4)０を表す文字列について、変換形式をゼロ埋め、指定桁数を文字列長以下にした場合");
    }

    @Test
    @TestOrder(970)
    public void testNum1B5(){
        _target = "00";
        _pat    = BizUtil.NON_ZERO_FILL;
        _len    = 1;
        String result = BizUtil.num(_target, _pat, _len);
        String expect = "0";
        exStringEquals(result, expect, "14B(5)０を表す文字列について、変換形式をゼロ埋めしない、指定桁数を文字列長以下にした場合");
    }

    @Test
    @TestOrder(980)
    public void testNum1B6(){
        _target = "00";
        _pat    = BizUtil.ZERO_FILL_LAST_ONLY;
        _len    = 1;
        String result = BizUtil.num(_target, _pat, _len);
        String expect = "0";
        exStringEquals(result, expect, "14B(6)０を表す文字列について、変換形式を最終桁のみゼロ埋め、指定桁数を文字列長以下にした場合");
    }

    @Test
    @TestOrder(990)
    public void testNum1C1(){
        _len = -1;
        String result = BizUtil.num(_target, _pat, _len);
        String expect = "99";
        exStringEquals(result, expect, "14C(1)変換形式をゼロ埋め、指定桁数を負値とした場合");
    }

    @Test
    @TestOrder(1000)
    public void testNum1C2(){
        _pat    = BizUtil.NON_ZERO_FILL;
        _len = -1;
        String result = BizUtil.num(_target, _pat, _len);
        String expect = "99";
        exStringEquals(result, expect, "14C(2)変換形式をゼロ埋めしない、指定桁数を負値とした場合");
    }

    @Test
    @TestOrder(1010)
    public void testNum1C3(){
        _pat    = BizUtil.ZERO_FILL_LAST_ONLY;
        _len = -1;
        String result = BizUtil.num(_target, _pat, _len);
        String expect = "99";
        exStringEquals(result, expect, "14C(3)変換形式を最終桁のみゼロ埋め、指定桁数を負値とした場合");
    }

    @Test(expected=NullPointerException.class)
    @TestOrder(1020)
    public void testNum1D1(){
        _target = null;
        try{
            BizUtil.comma(_target, _pat, _len);
        }catch(NullPointerException npe){
            throw npe;
        }
    }

    @Test(expected=NumberFormatException.class)
    @TestOrder(1030)
    public void testNum1D2(){
        _target = "";
        try{
            BizUtil.comma(_target, _pat, _len);
        }catch(NumberFormatException nfe){
            throw nfe;
        }
    }

    @Test(expected=NumberFormatException.class)
    @TestOrder(1040)
    public void testNum1D3(){
        _target = "abc";
        try{
            BizUtil.comma(_target, _pat, _len);
        }catch(NumberFormatException nfe){
            throw nfe;
        }
    }

    @Test
    @TestOrder(1050)
    public void testNum1E1(){
        _target = "12.4";
        String result = BizUtil.num(_target, _pat, _len);
        String expect = "012";
        exStringEquals(result, expect, "14E(1)小数点を含む数値文字列について、変換形式をゼロ埋め指定した場合");
    }

    @Test
    @TestOrder(1060)
    public void testNum1E2(){
        _target = "12.5";
        _pat    = BizUtil.NON_ZERO_FILL;
        String result = BizUtil.num(_target, _pat, _len);
        String expect = "13";
        exStringEquals(result, expect, "14E(2)小数点を含む数値文字列について、変換形式をゼロ埋めしない指定した場合");
    }

    @Test
    @TestOrder(1070)
    public void testNum1E3(){
        _target    = "12.4";
        _pat    = BizUtil.ZERO_FILL_LAST_ONLY;
        String result = BizUtil.num(_target, _pat, _len);
        String expect = "12";
        exStringEquals(result, expect, "14E(3)小数点を含む数値文字列について、変換形式を最終桁のみゼロ埋め指定した場合、ゼロ埋めしない");
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1080)
    public void testNum1F1(){
        String errmsg = null;
        String expect = "引数が不正です。";
        _pat = 3;
        try{
            BizUtil.comma(_target, _pat, _len);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "14F(1)小数部の変換形式が不正");
            throw bae;
        }
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1090)
    public void testNum1F2(){
        String errmsg = null;
        String expect = "引数が不正です。";
        _pat = -1;
        try{
            BizUtil.comma(_target, _pat, _len);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "14F(2)小数部の変換形式が不正");
            throw bae;
        }
    }

}
