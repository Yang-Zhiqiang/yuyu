package yuyu.common.biz.report;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * {@link ViewReport}クラスに含まれる、{@link ViewReport#editSamaKana(String)} メソッドのテストです。
 * <br />
 */
@RunWith(OrderedRunner.class)
public class ViewReportTest_editSamaKana {

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
    public void testEditSamaKana_A1(){
        value = null;
        result = ViewReport.editSamaKana(value);
        expect = null;
        exStringEquals(result, expect, "編集後文字列");
    }
    @Test
    @TestOrder(20)
    public void testEditSamaKana_A2(){
        value = "";
        result = ViewReport.editSamaKana(value);
        expect = "　サマ";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(30)
    public void testEditSamaKana_A3(){
        value = "ユウユウ　タロウ";
        result = ViewReport.editSamaKana(value);
        expect = "ユウユウ　タロウ　サマ";
        exStringEquals(result, expect, "編集後文字列");
    }
}

