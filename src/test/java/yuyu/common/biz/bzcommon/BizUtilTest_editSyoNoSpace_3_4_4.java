package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#editSyoNoSpace_3_4_4(String)} メソッドのテストです。
 * <br />
 */

@RunWith(SWAKTestRunner.class)
public class BizUtilTest_editSyoNoSpace_3_4_4 {
    @Test
    @TestOrder(590)
    public void testEditSyoNoSpace_3_4_4A1(){
        String target = "ABC4567HIJK";
        String result = BizUtil.editSyoNoSpace_3_4_4(target);
        String expect = "ABC 4567 HIJK";
        exStringEquals(result, expect, "11A(1)対象文字列が任意の文字１１桁");
    }

    @Test
    @TestOrder(600)
    public void testEditSyoNoSpace_3_4_4B1(){
        String target = null;
        String result = BizUtil.editSyoNoSpace_3_4_4(target);
        String expect = null;
        exStringEquals(result, expect, "11B(1)対象文字列がnull");
    }

    @Test
    @TestOrder(610)
    public void testEditSyoNoSpace_3_4_4B2(){
        String target = "";
        String result = BizUtil.editSyoNoSpace_3_4_4(target);
        String expect = "";
        exStringEquals(result, expect, "11B(2)対象文字列がブランク");
    }

    @Test
    @TestOrder(620)
    public void testEditSyoNoSpace_3_4_4C1(){
        String target = "1234567890";
        String result = BizUtil.editSyoNoSpace_3_4_4(target);
        String expect = "1234567890";
        exStringEquals(result, expect, "11C(1)対象文字列が１１桁未満(１０桁）");
    }

    @Test
    @TestOrder(630)
    public void testEditSyoNoSpace_3_4_4C2(){
        String target = "123456789012";
        String result = BizUtil.editSyoNoSpace_3_4_4(target);
        String expect = "123456789012";
        exStringEquals(result, expect, "11C(2)対象文字列が１２桁以上(１２桁）");
    }

}
