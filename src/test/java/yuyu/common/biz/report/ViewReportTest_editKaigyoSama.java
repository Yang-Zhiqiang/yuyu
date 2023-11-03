package yuyu.common.biz.report;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * {@link ViewReport}クラスに含まれる、{@link ViewReport#editKaigyoSama(String)} メソッドのテストです。 * <br />
 */
@RunWith(OrderedRunner.class)
public class ViewReportTest_editKaigyoSama {

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
    public void testEditKaigyoSama_A1(){
        value = null;
        result = ViewReport.editKaigyoSama(value);
        expect = null;
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(20)
    public void testEditKaigyoSama_A2(){
        value = "";
        result = ViewReport.editKaigyoSama(value);
        expect = "　様";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(30)
    public void testEditKaigyoSama_A3(){
        value = "12345678901234567";
        result = ViewReport.editKaigyoSama(value);
        expect = "1234567890123456\r\n7　様";
        exStringEquals(result, expect, "編集後文字列");
    }
}
