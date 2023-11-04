package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#zero2blank(String)} メソッドのテストです。
 * <br />
 */

@RunWith(SWAKTestRunner.class)
public class BizUtilTest_zero2blank {
    @Test
    @TestOrder(10)
    public void testZero2BlankZero1(){
        String target = "0";
        String result = BizUtil.zero2blank(target);
        String expect = "";
        exStringEquals(result, expect, "1A(1)\"0\"を変換");
    }

    @Test
    @TestOrder(20)
    public void testZero2BlankZero2(){
        String target = "-0";
        String result = BizUtil.zero2blank(target);
        String expect = "";
        exStringEquals(result, expect, "1A(2)\"-0\"を変換");
    }

    @Test
    @TestOrder(30)
    public void testZero2BlankZero3(){
        String target = "00";
        String result = BizUtil.zero2blank(target);
        String expect = "";
        exStringEquals(result, expect, "1A(3)\"00\"を変換");
    }

    @Test
    @TestOrder(40)
    public void testZero2BlankNotZero1(){
        String target = "1234";
        String result = BizUtil.zero2blank(target);
        String expect = "1234";
        exStringEquals(result, expect, "1B(1)\"1234\"は変換しない");
    }

    @Test
    @TestOrder(50)
    public void testZero2BlankNotZero2(){
        String target = "0.0";
        String result = BizUtil.zero2blank(target);
        String expect = "0.0";
        exStringEquals(result, expect, "1B(2)\"0.0\"は変換しない");
    }

    @Test
    @TestOrder(60)
    public void testZero2BlankNotZero3(){
        String target = "abcd";
        String result = BizUtil.zero2blank(target);
        String expect = "abcd";
        exStringEquals(result, expect, "1B(3)\"abcd\"は変換しない");
    }

    @Test
    @TestOrder(70)
    public void testZero2BlankNull1(){
        String target = null;
        String result = BizUtil.zero2blank(target);
        String expect = "";
        exStringEquals(result, expect, "1C(1)nullを変換");
    }


}
