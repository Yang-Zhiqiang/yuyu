package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#editMojiretu(String, int)} メソッドのテストです。
 * <br />
 */

@RunWith(SWAKTestRunner.class)
public class BizUtilTest_editMojiretu {
    @Test
    @TestOrder(1900)
    public void testeditMojiretuA1(){
        String target = "1234\r\n567890";
        int    len    = 5;
        String result = BizUtil.editMojiretu(target, len);
        String expect = "1234\r\n56789\r\n0";
        exStringEquals(result, expect,
                "26A(1)対象文字列(\r\nを含み、１０文字以上)について、指定桁数(5)と改行文字(\r\n)毎に、改行文字を付加し、返します");
    }


    @Test
    @TestOrder(1910)
    public void testeditMojiretuA2(){
        String  target = "1234567890";
        int     len    = 10;
        String  result = BizUtil.editMojiretu(target, len);
        String  expect = "1234567890";
        exStringEquals(result, expect,
                "26A(2)改行コードを含まず、指定桁数が文字列長以上の場合");
    }


    @Test
    @TestOrder(1920)
    public void testeditMojiretuB1(){
        String  target = null;
        int     len    = 5;
        String  result =BizUtil.editMojiretu(target, len);
        String  expect = "";
        exStringEquals(result, expect,
                "26B(1)対象文字列がnull の場合");
    }


    @Test
    @TestOrder(1930)
    public void testeditMojiretuC1(){
        String  target = "";
        int     len    = 5;
        String  result = BizUtil.editMojiretu(target, len);
        String  expect = "";
        exStringEquals(result, expect,
                "26C(1)対象文字列がブランクである場合");
    }

    @Test
    @TestOrder(1940)
    public void testeditMojiretuD1(){
        String target = "1234\r\n56789";
        int    len    = 0;
        String result=BizUtil.editMojiretu(target, len);
        exStringEquals(result, target, "26D(1)指定桁数が0の場合");
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1950)
    public void testeditMojiretuE1(){
        String errmsg = null;
        String expect = "最大文字数の指定が不正です。";
        String target = "1234\r\n56789";
        int    len    = -5;
        try{
            BizUtil.editMojiretu(target, len);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "26E(1)指定桁数が0未満の場合");
            throw bae;
        }
    }
}
