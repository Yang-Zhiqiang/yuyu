package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#num(String, int, int, int, int, int)} メソッドのテストです。
 * ※引数の型：String,int,int,int,int,int<br />
 */

@RunWith(SWAKTestRunner.class)
public class BizUtilTest_num_3 {
    private String _target;
    private int    _pat1;
    private int    _len1;
    private int    _pat2;
    private int    _len2;
    private int    _flg;
    @Before
    public void initNum3(){
        _target = "12.34";
        _pat1    = BizUtil.ZERO_FILL;
        _len1    = 3;
        _pat2    = BizUtil.ZERO_FILL;
        _len2    = 3;
        _flg     = BizUtil.KETASUU_CHECK_ERROR;
    }

    @Test
    @TestOrder(1280)
    public void testNum3A1(){
        String result = BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        String expect = "012.340";
        exStringEquals(result, expect, "16A(1)対象文字列(０以外)について、変換形式をゼロ埋め、指定桁数を文字列長より大きくした場合");
    }

    @Test
    @TestOrder(1290)
    public void testNum3A2(){
        _pat1 = BizUtil.NON_ZERO_FILL;
        _pat2 = BizUtil.NON_ZERO_FILL;
        String result = BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        String expect = "12.34";
        exStringEquals(result, expect, "16A(2)対象文字列(０以外)について、変換形式をゼロ埋めしない、指定桁数を文字列長より大きくした場合");
    }

    @Test
    @TestOrder(1300)
    public void testNum3A3(){
        _pat1 = BizUtil.ZERO_FILL_LAST_ONLY;
        _pat2 = BizUtil.ZERO_FILL_LAST_ONLY;
        String result = BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        String expect = "12.34";
        exStringEquals(result, expect, "16A(3)対象文字列(０以外)について、変換形式を最終桁のみゼロ埋め、指定桁数を文字列長より大きくした場合");
    }

    @Test
    @TestOrder(1310)
    public void testNum3B1(){
        _target = "00.00";
        String result = BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        String expect = "000.000";
        exStringEquals(result, expect, "16A(1)対象文字列(０以外)について、変換形式をゼロ埋め、指定桁数を文字列長より大きくした場合");
    }

    @Test
    @TestOrder(1320)
    public void testNum3B2(){
        _target = "00.00";
        _pat1   = BizUtil.NON_ZERO_FILL;
        _pat2   = BizUtil.NON_ZERO_FILL;
        String result = BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        String expect = "0";
        exStringEquals(result, expect, "16A(2)０を表す文字列について、変換形式をゼロ埋めしない、指定桁数を文字列長より大きくした場合");
    }

    @Test
    @TestOrder(1330)
    public void testNum3B3(){
        _target = "00.00";
        _pat1   = BizUtil.ZERO_FILL_LAST_ONLY;
        _pat2   = BizUtil.ZERO_FILL_LAST_ONLY;
        String result = BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        String expect = "0";
        exStringEquals(result, expect, "16A(3)０を表す文字列について、変換形式を最終桁のみゼロ埋め、指定桁数を文字列長より大きくした場合");
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1340)
    public void testNum3C1(){
        String errmsg = null;
        String expect = "入力桁数が不正です。";
        _len1 = 1;
        try{
            BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "16C(1)整数部指定桁数を実桁数より小さくした場合で、桁数チェック後の動作が例外(BizAppException)発生");
            throw bae;
        }
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1350)
    public void testNum3C2(){
        String errmsg = null;
        String expect = "入力桁数が不正です。";
        _pat1   = BizUtil.NON_ZERO_FILL;
        _pat2   = BizUtil.NON_ZERO_FILL;
        _len2 = 1;
        try{
            BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "16C(2)小数部指定桁数を実桁数より小さくした場合で、桁数チェック後の動作が例外(BizAppException)発生");
            throw bae;
        }
    }

    @Test
    @TestOrder(1360)
    public void testNum3C3(){
        _pat1 = BizUtil.ZERO_FILL_LAST_ONLY;
        _len1 = 2;
        _pat2 = BizUtil.ZERO_FILL_LAST_ONLY;
        _len2 = 2;
        String result = BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        String expect = "12.34";
        exStringEquals(result, expect, "16C(3)指定桁数と実桁数が等しい場合");
    }

    @Test
    @TestOrder(1370)
    public void testNum3C4(){
        _len1 = 1;
        _flg  = BizUtil.DECIMAL_KETASUU_ROUND;
        String result = BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        String expect = "12.340";
        exStringEquals(result, expect, "16C(4)整数部指定桁数を実桁数より小さくした場合で、桁数チェック後の動作が例外発生させない");
    }

    @Test
    @TestOrder(1380)
    public void testNum3C5(){
        _len2 = 1;
        _flg  = BizUtil.DECIMAL_KETASUU_ROUND;
        String result = BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        String expect = "012.3";
        exStringEquals(result, expect, "16C(5)小数部指定桁数を実桁数より小さくした場合で、桁数チェック後の動作が例外発生させない");
    }

    @Test
    @TestOrder(1390)
    public void testNum3C6(){
        _target = "12.35";
        _len2   = 1;
        _flg    = BizUtil.DECIMAL_KETASUU_ROUND;
        String result = BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        String expect = "012.4";
        exStringEquals(result, expect, "16C(6)小数部指定桁数を実桁数より小さくした場合で、桁数チェック後の動作が例外発生させない");
    }

    @Test(expected=NullPointerException.class)
    @TestOrder(1400)
    public void testNum3D1(){
        _target = null;
        try{
            BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        }catch(NullPointerException npe){
            throw npe;
        }
    }

    @Test(expected=NumberFormatException.class)
    @TestOrder(1410)
    public void testNum3D2(){
        _target = "";
        _pat1 = BizUtil.NON_ZERO_FILL;
        _pat2 = BizUtil.NON_ZERO_FILL;
        try{
            BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        }catch(NumberFormatException nfe){
            throw nfe;
        }
    }

    @Test(expected=NumberFormatException.class)
    @TestOrder(1420)
    public void testNum3D3(){
        _target = "ab.cd";
        _pat1 = BizUtil.ZERO_FILL_LAST_ONLY;
        _pat2 = BizUtil.ZERO_FILL_LAST_ONLY;
        try{
            BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        }catch(NumberFormatException nfe){
            throw nfe;
        }
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1430)
    public void testNum3E1(){
        String errmsg = null;
        String expect = "入力桁数が不正です。";
        _len2 = 40;
        try{
            BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "16E(1)小数部指定桁数が不正な値(４０)");
            throw bae;
        }
    }

    @Test
    @TestOrder(1440)
    public void testNum3E2(){
        _pat1 = BizUtil.NON_ZERO_FILL;
        _pat2 = BizUtil.NON_ZERO_FILL;
        _len2 = 39;
        String result = BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        String expect = "12.34";
        exStringEquals(result, expect, "16E(2)小数部指定桁数が正しい値(３９）：比較ケース");
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1450)
    public void testNum3F1(){
        String errmsg = null;
        String expect = "引数が不正です。";
        _pat1 = 3;
        try{
            BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "16F(1)整数部の変換形式が不正");
            throw bae;
        }
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1460)
    public void testNum3F2(){
        String errmsg = null;
        String expect = "引数が不正です。";
        _pat1 = -1;
        _pat2 = BizUtil.NON_ZERO_FILL;
        try{
            BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "16F(2)整数部の変換形式が不正");
            throw bae;
        }
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1470)
    public void testNum3F3(){
        String errmsg = null;
        String expect = "引数が不正です。";
        _pat2 = 3;
        try{
            BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "16F(3)小数部の変換形式が不正");
            throw bae;
        }
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1480)
    public void testNum3F4(){
        String errmsg = null;
        String expect = "引数が不正です。";
        _pat1 = BizUtil.NON_ZERO_FILL;
        _pat2 = -1;
        try{
            BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "16F(4)小数部の変換形式が不正");
            throw bae;
        }
    }

    @Test
    @TestOrder(1490)
    public void testNum3G1(){
        _len1 = 1;
        _len2 = 1;
        _flg  = 3;
        String result = BizUtil.num(_target, _pat1, _len1, _pat2, _len2, _flg);
        String expect = "12.3";
        exStringEquals(result, expect, "16G(1)整数部の変換形式が不正");
    }

}
