package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#getSJISEdit(String, long)} メソッドのテストです。
 * <br />
 */

@RunWith(SWAKTestRunner.class)
public class BizUtilTest_getSJISEdit {
    @Test
    @TestOrder(240)
    public void testGetSJISEditA1(){
        String target = "abcdefg";
        long   tarlen = 5;
        String result = BizUtil.getSJISEdit(target,tarlen);
        String expect = "abcde";
        exStringEquals(result, expect, "7A(1)対象文字列が半角のみ");
    }

    @Test
    @TestOrder(250)
    public void testGetSJISEditA2(){
        String target = "あいうえお";
        long   tarlen = 5;
        String result = BizUtil.getSJISEdit(target,tarlen);
        String expect = "あい";
        exStringEquals(result, expect, "7A(2)対象文字列が全角のみ");
    }

    @Test
    @TestOrder(260)
    public void testGetSJISEditA3(){
        String target = "abあいcdうえ";
        long   tarlen = 5;
        String result = BizUtil.getSJISEdit(target,tarlen);
        String expect = "abあ";
        exStringEquals(result, expect, "7A(3)対象文字列が全角半角混合");
    }

    @Test
    @TestOrder(270)
    public void testGetSJISEditB1(){
        String target = "abcdefg";
        long   tarlen = 20;
        String result = BizUtil.getSJISEdit(target,tarlen);
        String expect = "abcdefg";
        exStringEquals(result, expect, "7B(1)指定バイト数が大きい");
    }

    @Test
    @TestOrder(280)
    public void testGetSJISEditC1(){
        String target = "abcdefg";
        long   tarlen = 0;
        String result = BizUtil.getSJISEdit(target,tarlen);
        String expect = "";
        exStringEquals(result, expect, "7C(1)指定バイト数が0");
    }

    @Test
    @TestOrder(290)
    public void testGetSJISEditC2(){
        String target = "abcdefg";
        long   tarlen = -5;
        String result = BizUtil.getSJISEdit(target,tarlen);
        String expect = "";
        exStringEquals(result, expect, "7C(2)指定バイト数が-5");
    }

    @Test
    @TestOrder(300)
    public void testGetSJISEditD1(){
        String target = null;
        long   tarlen = 5;
        String result = BizUtil.getSJISEdit(target,tarlen);
        String expect = "";
        exStringEquals(result, expect, "7D(1)対象文字列がnull");
    }

}
