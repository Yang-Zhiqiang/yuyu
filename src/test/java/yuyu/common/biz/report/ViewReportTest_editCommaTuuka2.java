package yuyu.common.biz.report;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * {@link ViewReport}クラスに含まれる、{@link ViewReport#editCommaTuuka(BizCurrency,int)} メソッドのテストです。
 * <br />
 */
@RunWith(OrderedRunner.class)
public class ViewReportTest_editCommaTuuka2 {

    private BizCurrency value;
    private int pat;
    private String result;
    private String expect;

    @Before
    public void resetDefaultVal() {
        this.result = null;
        this.expect = null;
    }

    @Test
    @TestOrder(10)
    public void testEditCommaTuuka_A1() {
        value = null;
        pat = BizUtil.NON_ZERO_FILL;
        result = ViewReport.editCommaTuuka(value, pat);
        expect = null;
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(20)
    public void testEditCommaTuuka_A2() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.YEN);
        pat = BizUtil.ZERO_FILL;
        result = ViewReport.editCommaTuuka(value, pat);
        expect = "1,000 円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(30)
    public void testEditCommaTuuka_A3() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.YEN);
        pat = BizUtil.NON_ZERO_FILL;
        result = ViewReport.editCommaTuuka(value, pat);
        expect = "1,000 円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(40)
    public void testEditCommaTuuka_A4() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.DOLLAR);
        pat = BizUtil.ZERO_FILL;
        result = ViewReport.editCommaTuuka(value, pat);
        expect = "1,000.10 米ドル";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(50)
    public void testEditCommaTuuka_A5() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.DOLLAR);
        pat = BizUtil.NON_ZERO_FILL;
        result = ViewReport.editCommaTuuka(value, pat);
        expect = "1,000.1 米ドル";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(60)
    public void testEditCommaTuuka_A6() {
        value = BizCurrency.valueOf(999, BizCurrencyTypes.YEN);
        pat = BizUtil.NON_ZERO_FILL;
        result = ViewReport.editCommaTuuka(value, pat);
        expect = "999 円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(70)
    public void testEditCommaTuuka_A7() {
        value = BizCurrency.valueOf(999, BizCurrencyTypes.DOLLAR);
        pat = BizUtil.ZERO_FILL;
        result = ViewReport.editCommaTuuka(value, pat);
        expect = "999.00 米ドル";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(80)
    public void testEditCommaTuuka_A8() {
        value = BizCurrency.valueOf(1000.11, BizCurrencyTypes.DOLLAR);
        pat = BizUtil.NON_ZERO_FILL;
        result = ViewReport.editCommaTuuka(value, pat);
        expect = "1,000.11 米ドル";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(90)
    public void testEditCommaTuuka_A9() {
        value = BizCurrency.valueOf(1000.11, BizCurrencyTypes.DOLLAR);
        pat = BizUtil.ZERO_FILL;
        result = ViewReport.editCommaTuuka(value, pat);
        expect = "1,000.11 米ドル";
        exStringEquals(result, expect, "編集後文字列");
    }
}
