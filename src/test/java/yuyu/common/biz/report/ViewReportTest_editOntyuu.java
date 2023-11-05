package yuyu.common.biz.report;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * {@link ViewReport}クラスに含まれる、{@link ViewReport#editOntyuu(String)} メソッドのテストです。
 * <br />
 */
@RunWith(OrderedRunner.class)
public class ViewReportTest_editOntyuu {

    private String value;
    private String result;
    private String expect;

    @Before
    public void resetDefaultVal(){
        this.result = null;
        this.expect = null;
    }

    @Test
    @TestOrder(10)
    public void testEditOntyuu_A1(){
        value = null;
        result = ViewReport.editOntyuu(value);
        expect = null;
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(20)
    public void testEditOntyuu_A2(){
        value = "";
        result = ViewReport.editOntyuu(value);
        expect = "　御中";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(30)
    public void testEditOntyuu_A3(){
        value = "ゆうゆう株式会社";
        result = ViewReport.editOntyuu(value);
        expect = "ゆうゆう株式会社　御中";
        exStringEquals(result, expect, "編集後文字列");
    }
}
