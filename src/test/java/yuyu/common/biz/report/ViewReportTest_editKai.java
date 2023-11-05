package yuyu.common.biz.report;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * {@link ViewReport}クラスに含まれる、{@link ViewReport#editKai(String)} メソッドのテストです。 * <br />
 */
@RunWith(OrderedRunner.class)
public class ViewReportTest_editKai {
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
    public void testEditKai_A1(){
        value = null;
        result = ViewReport.editKai(value);
        expect = null;
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(20)
    public void testEditKai_A2(){
        value = "";
        result = ViewReport.editKai(value);
        expect = " 回";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(30)
    public void testEditKai_A3(){
        value = "10";
        result = ViewReport.editKai(value);
        expect = "10 回";
        exStringEquals(result, expect, "編集後文字列");
    }
}
