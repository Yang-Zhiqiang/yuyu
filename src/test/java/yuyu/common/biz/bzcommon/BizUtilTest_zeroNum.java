package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#zeroNum(String, int, int)} メソッドのテストです。
 * <br />
 */

@RunWith(SWAKTestRunner.class)
public class BizUtilTest_zeroNum {
    private String _target;
    private int    _len1;
    private int    _len2;
    @Before
    public void initZeroNum(){
        _target = "12.34";
        _len1    = 3;
        _len2    = 3;
    }

    @Test
    @TestOrder(1620)
    public void testZeroNumA1(){
        String result = BizUtil.zeroNum(_target, _len1, _len2);
        String expect = "012.340";
        exStringEquals(result, expect, "18A(1)対象文字列(０以外)について、変換形式をゼロ埋め、指定桁数を文字列長より大きくした場合");
    }

    @Test
    @TestOrder(1630)
    public void testZeroNumB1(){
        _target = "00.00";
        String result = BizUtil.zeroNum(_target, _len1, _len2);
        String expect = "000.000";
        exStringEquals(result, expect, "18B(1)０を表す文字列について、変換形式をゼロ埋め、指定桁数を文字列長より大きくした場合");
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1640)
    public void testZeroNumC1(){
        String errmsg = null;
        String expect = "入力桁数が不正です。";
        _len1 = 1;
        try{
            BizUtil.zeroNum(_target, _len1, _len2);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "18C(1)整数部指定桁数を実桁数より小さくした場合");
            throw bae;
        }
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1650)
    public void testZeroNumC2(){
        String errmsg = null;
        String expect = "入力桁数が不正です。";
        _len2 = 1;
        try{
            BizUtil.zeroNum(_target, _len1, _len2);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "18C(2)小数部指定桁数を実桁数より小さくした場合");
            throw bae;
        }
    }

    @Test
    @TestOrder(1660)
    public void testZeroNumC3(){
        _len1 = 2;
        _len2 = 2;
        String result = BizUtil.zeroNum(_target, _len1, _len2);
        String expect = "12.34";
        exStringEquals(result, expect, "18C(3)指定桁数と実桁数が等しい場合");
    }

    @Test(expected=NullPointerException.class)
    @TestOrder(1670)
    public void testZeroNumD1(){
        _target = null;
        try{
            BizUtil.zeroNum(_target, _len1, _len2);
        }catch(NullPointerException npe){
            throw npe;
        }
    }

    @Test(expected=NumberFormatException.class)
    @TestOrder(1680)
    public void testZeroNumD2(){
        _target = "";
        try{
            BizUtil.zeroNum(_target, _len1, _len2);
        }catch(NumberFormatException nfe){
            throw nfe;
        }
    }

    @Test(expected=NumberFormatException.class)
    @TestOrder(1690)
    public void testZeroNumD3(){
        _target = "ab.cd";
        try{
            BizUtil.zeroNum(_target, _len1, _len2);
        }catch(NumberFormatException nfe){
            throw nfe;
        }
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1700)
    public void testZeroNumE1(){
        String errmsg = null;
        String expect = "入力桁数が不正です。";
        _len2 = 40;
        try{
            BizUtil.zeroNum(_target, _len1, _len2);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "18E(1)小数部指定桁数が不正な値(４０）");
            throw bae;
        }
    }

    @Test
    @TestOrder(1710)
    public void testZeroNumE2(){
        _len2 = 39;
        String result = BizUtil.zeroNum(_target, _len1, _len2);
        String expect = "012.340000000000000000000000000000000000000";
        exStringEquals(result, expect, "18C(3)指定桁数と実桁数が等しい場合");
    }

}