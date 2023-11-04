package yuyu.common.biz.report;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * {@link ViewReport}クラスに含まれる、{@link ViewReport#editCommaKen (String)} メソッドのテストです。 * <br />
 */
@RunWith(OrderedRunner.class)
public class ViewReportTest_editCommaKen {

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
    public void testEditCommaKen_A1(){
        value = null;
        result = ViewReport.editCommaKen(value);
        expect = null;
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test(expected=NumberFormatException.class)
    @TestOrder(20)
    public void testEditCommaKen_A2(){
        value = "";
        result = ViewReport.editCommaKen(value);
    }

    @Test
    @TestOrder(30)
    public void testEditCommaKen_A3(){
        value = "1000";
        result = ViewReport.editCommaKen(value);
        expect = "1,000 件";
        exStringEquals(result, expect, "編集後文字列");
    }
}
