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
 * {@link ViewReport}クラスに含まれる、{@link ViewReport#editCommaTuukaNoSpace(BizCurrency,int)} メソッドのテストです。
 * <br />
 */
@RunWith(OrderedRunner.class)
public class ViewReportTest_editCommaTuukaNoSpace2 {

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
    public void testEditCommaTuukaNoSpace_A1() {
        value = null;
        pat = BizUtil.NON_ZERO_FILL;
        result = ViewReport.editCommaTuukaNoSpace(value, pat);
        expect = null;
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(20)
    public void testEditCommaTuukaNoSpace_A2() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.YEN);
        pat = BizUtil.ZERO_FILL;
        result = ViewReport.editCommaTuukaNoSpace(value, pat);
        expect = "1,000円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(30)
    public void testEditCommaTuukaNoSpace_A3() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.YEN);
        pat = BizUtil.NON_ZERO_FILL;
        result = ViewReport.editCommaTuukaNoSpace(value, pat);
        expect = "1,000円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(40)
    public void testEditCommaTuukaNoSpace_A4() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.DOLLAR);
        pat = BizUtil.ZERO_FILL;
        result = ViewReport.editCommaTuukaNoSpace(value, pat);
        expect = "1,000.10米ドル";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(50)
    public void testEditCommaTuukaNoSpace_A5() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.DOLLAR);
        pat = BizUtil.NON_ZERO_FILL;
        result = ViewReport.editCommaTuukaNoSpace(value, pat);
        expect = "1,000.1米ドル";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(60)
    public void testEditCommaTuukaNoSpace_A6() {
        value = BizCurrency.valueOf(999, BizCurrencyTypes.YEN);
        pat = BizUtil.NON_ZERO_FILL;
        result = ViewReport.editCommaTuukaNoSpace(value, pat);
        expect = "999円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(70)
    public void testEditCommaTuukaNoSpace_A7() {
        value = BizCurrency.valueOf(999, BizCurrencyTypes.DOLLAR);
        pat = BizUtil.ZERO_FILL;
        result = ViewReport.editCommaTuukaNoSpace(value, pat);
        expect = "999.00米ドル";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(80)
    public void testEditCommaTuukaNoSpace_A8() {
        value = BizCurrency.valueOf(1000.11, BizCurrencyTypes.DOLLAR);
        pat = BizUtil.NON_ZERO_FILL;
        result = ViewReport.editCommaTuukaNoSpace(value, pat);
        expect = "1,000.11米ドル";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(90)
    public void testEditCommaTuukaNoSpace_A9() {
        value = BizCurrency.valueOf(1000.11, BizCurrencyTypes.DOLLAR);
        pat = BizUtil.ZERO_FILL;
        result = ViewReport.editCommaTuukaNoSpace(value, pat);
        expect = "1,000.11米ドル";
        exStringEquals(result, expect, "編集後文字列");
    }
}
