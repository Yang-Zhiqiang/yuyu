package yuyu.common.biz.bzcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#splitLineSeparator(String, int, boolean)} メソッドのテストです。
 * <br />
 */

@RunWith(SWAKTestRunner.class)
public class BizUtilTest_splitLineSeparator {
    @Test
    @TestOrder(1500)
    public void testSplitLineSeparatorA1(){
        String  target = "1234\r\n567890";
        int     len    = 5;
        boolean flg    = true;
        String[] result = BizUtil.splitLineSeparator(target, len, flg);
        String[] expect = {"1234","56789","0"};
        assertArrayEquals("17A(1)対象文字列(\\r\\nを含み、１０文字以上)について、指定桁数(5)と改行コード(\\r\\n)毎に、文字列配列へ切り分ける",
                expect, result);
    }

    @Test
    @TestOrder(1510)
    public void testSplitLineSeparatorA2(){
        String  target = "1234\r567890";
        int     len    = 4;
        boolean flg    = true;
        String[] result = BizUtil.splitLineSeparator(target, len, flg);
        String[] expect = {"1234","5678","90"};
        assertArrayEquals("17A(2)対象文字列(\\rを含み、１０文字以上)について、指定桁数(4)と改行コード(\\r)毎に、文字列配列へ切り分ける",
                expect, result);
    }

    @Test
    @TestOrder(1520)
    public void testSplitLineSeparatorA3(){
        String  target = "1234\n567890";
        int     len    = 3;
        boolean flg    = true;
        String[] result = BizUtil.splitLineSeparator(target, len, flg);
        String[] expect = {"123","4","567","890"};
        assertArrayEquals("17A(3)対象文字列(\\nを含み、１０文字以上)について、指定桁数(3)と改行コード(\\n)毎に、文字列配列へ切り分ける",
                expect, result);
    }

    @Test
    @TestOrder(1530)
    public void testSplitLineSeparatorA4(){
        String  target = "1234567890";
        int     len    = 4;
        boolean flg    = true;
        String[] result = BizUtil.splitLineSeparator(target, len, flg);
        String[] expect = {"1234","5678", "90"};
        assertArrayEquals("17A(4)改行コードを含まない場合",
                expect, result);
    }

    @Test
    @TestOrder(1540)
    public void testSplitLineSeparatorA5(){
        String  target = "1234567890";
        int     len    = 10;
        boolean flg    = true;
        String[] result = BizUtil.splitLineSeparator(target, len, flg);
        String[] expect = {"1234567890"};
        assertArrayEquals("17A(5)改行コードを含まず、指定桁数が文字列長以上の場合",
                expect, result);
    }

    @Test
    @TestOrder(1550)
    public void testSplitLineSeparatorA6(){
        String  target = "1\n2\r3\r\n4\n5\r6";
        int     len    = 20;
        boolean flg    = true;
        String[] result = BizUtil.splitLineSeparator(target, len, flg);
        String[] expect = {"1\n2\r3","4\n5\r6"};
        assertArrayEquals("17A(6)改行コードが混在(\\r\\n, \\r, \\n) した場合",
                expect, result);
    }

    @Test
    @TestOrder(1560)
    public void testSplitLineSeparatorA7(){
        String  target = "1\n2\r3\n4\n5\r6";
        int     len    = 20;
        boolean flg    = true;
        String[] result = BizUtil.splitLineSeparator(target, len, flg);
        String[] expect = {"1\n2", "3\n4\n5", "6"};
        assertArrayEquals("17A(7)改行コードが混在(\\r, \\n) した場合",
                expect, result);
    }

    @Test
    @TestOrder(1570)
    public void testSplitLineSeparatorA8(){
        String  target = "123\n4567\n890";
        int     len    = 4;
        boolean flg    = false;
        String[] result = BizUtil.splitLineSeparator(target, len, flg);
        String[] expect = {"123\n", "4567\n", "890"};
        assertArrayEquals("17A(8)改行コードを残す",
                expect, result);
    }

    @Test
    @TestOrder(1580)
    public void testSplitLineSeparatorA9(){
        String  target = "123\n\n4567890";
        int     len    = 20;
        boolean flg    = true;
        String[] result = BizUtil.splitLineSeparator(target, len, flg);
        String[] expect = {"123", "", "4567890"};
        assertArrayEquals("17A(9)改行コードが連続で並んでいる場合",
                expect, result);
    }

    @Test(expected=NullPointerException.class)
    @TestOrder(1590)
    public void testSplitLineSeparatorB1(){
        String  target = null;
        int     len    = 5;
        boolean flg    = true;
        try{
            BizUtil.splitLineSeparator(target, len, flg);
        }catch(NullPointerException npe){
            throw npe;
        }
    }

    @Test
    @TestOrder(1600)
    public void testSplitLineSeparatorC1(){
        String  target = "";
        int     len    = 5;
        boolean flg    = true;
        String[] result = BizUtil.splitLineSeparator(target, len, flg);
        String[] expect = {};
        assertArrayEquals("17C(1)対象文字列がブランクである場合",
                expect, result);
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1610)
    public void testSplitLineSeparatorD1(){
        String errmsg = null;
        String expect = "最大文字数の指定が不正です。";
        String  target = "1234567890";
        int     len    = 0;
        boolean flg    = true;
        try{
            BizUtil.splitLineSeparator(target, len, flg);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "17D(1)指定桁数が0以下の場合");
            throw bae;
        }
    }

}
