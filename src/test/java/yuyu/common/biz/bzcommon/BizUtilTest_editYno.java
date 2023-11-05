package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#editYno(String)} メソッドのテストです。
 * <br />
 */

@RunWith(SWAKTestRunner.class)
public class BizUtilTest_editYno {
    @Test
    @TestOrder(510)
    public void testEditYnoA1(){
        String target = "1234567";
        String result = BizUtil.editYno(target);
        String expect = "123-4567";
        exStringEquals(result, expect, "10A(1)対象文字列が数字７桁");
    }

    @Test
    @TestOrder(520)
    public void testEditYnoA2(){
        String target = "a2c4#f7";
        String result = BizUtil.editYno(target);
        String expect = "a2c-4#f7";
        exStringEquals(result, expect, "10A(2)対象文字列が任意の文字７桁");
    }

    @Test
    @TestOrder(530)
    public void testEditYnoB1(){
        String target = null;
        String result = BizUtil.editYno(target);
        String expect = null;
        exStringEquals(result, expect, "10B(1)対象文字列がnull");
    }

    @Test
    @TestOrder(540)
    public void testEditYnoB2(){
        String target = "";
        String result = BizUtil.editYno(target);
        String expect = "";
        exStringEquals(result, expect, "10B(2)対象文字列がブランク");
    }

    @Test
    @TestOrder(550)
    public void testEditYnoC1(){
        String target = "1";
        String result = BizUtil.editYno(target);
        String expect = "1";
        exStringEquals(result, expect, "10C(1)対象文字列が１桁の非ブランク文字列");
    }

    @Test
    @TestOrder(560)
    public void testEditYnoC2(){
        String target = "123";
        String result = BizUtil.editYno(target);
        String expect = "123";
        exStringEquals(result, expect, "10C(2)対象文字列が３桁の非ブランク文字列");
    }

    @Test
    @TestOrder(570)
    public void testEditYnoD1(){
        String target = "1234";
        String result = BizUtil.editYno(target);
        String expect = "123-4";
        exStringEquals(result, expect, "10D(1)対象文字列が４桁の文字列");
    }

    @Test
    @TestOrder(580)
    public void testEditYnoD2(){
        String target = "1234567890";
        String result = BizUtil.editYno(target);
        String expect = "123-4567890";
        exStringEquals(result, expect, "10D(2)対象文字列が７桁より大きい文字列");
    }

}
