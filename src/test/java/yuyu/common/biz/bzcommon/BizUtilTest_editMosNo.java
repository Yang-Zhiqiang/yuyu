package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#editMosNo(String)} メソッドのテストです。
 * <br />
 */

@RunWith(SWAKTestRunner.class)
public class BizUtilTest_editMosNo {
    @Test
    @TestOrder(590)
    public void testEditMosNoA1(){
        String target = "ABC4567HI";
        String result = BizUtil.editMosNo(target);
        String expect = "ABC 456 7HI";
        exStringEquals(result, expect, "11A(1)対象文字列が任意の文字１１桁");
    }

    @Test
    @TestOrder(600)
    public void testEditMosNoB1(){
        String target = null;
        String result = BizUtil.editMosNo(target);
        String expect = null;
        exStringEquals(result, expect, "11B(1)対象文字列がnull");
    }

    @Test
    @TestOrder(610)
    public void testEditMosNoB2(){
        String target = "";
        String result = BizUtil.editMosNo(target);
        String expect = "";
        exStringEquals(result, expect, "11B(2)対象文字列がブランク");
    }

    @Test
    @TestOrder(620)
    public void testEditMosNoC1(){
        String target = "12345678";
        String result = BizUtil.editMosNo(target);
        String expect = "12345678";
        exStringEquals(result, expect, "9C(1)対象文字列が９桁未満(８桁）");
    }

    @Test
    @TestOrder(630)
    public void testEditMosNoC2(){
        String target = "1234567890";
        String result = BizUtil.editMosNo(target);
        String expect = "1234567890";
        exStringEquals(result, expect, "9C(2)対象文字列が１０桁以上(１０桁）");
    }

}
