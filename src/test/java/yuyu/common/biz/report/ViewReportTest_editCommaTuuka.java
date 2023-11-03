package yuyu.common.biz.report;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * {@link ViewReport}クラスに含まれる、{@link ViewReport#editCommaTuuka(BizCurrency,int,int)} メソッドのテストです。
 * <br />
 */
@RunWith(OrderedRunner.class)
public class ViewReportTest_editCommaTuuka {

    private BizCurrency value;

    private int pat;

    private int len;
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

        len = 3;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = null;
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(20)
    public void testEditCommaTuuka_A2() {
        value = BizCurrency.valueOf(1000, BizCurrencyTypes.YEN);

        pat = BizUtil.ZERO_FILL;

        len = 0;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000 円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(30)
    public void testEditCommaTuuka_A3() {
        value = BizCurrency.valueOf(1000, BizCurrencyTypes.YEN);

        pat = BizUtil.NON_ZERO_FILL;

        len = 0;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000 円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(40)
    public void testEditCommaTuuka_A4() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.YEN);

        pat = BizUtil.ZERO_FILL;

        len = 0;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000 円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(50)
    public void testEditCommaTuuka_A5() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.YEN);

        pat = BizUtil.NON_ZERO_FILL;

        len = 0;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000 円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(60)
    public void testEditCommaTuuka_A6() {
        value = BizCurrency.valueOf(1000, BizCurrencyTypes.YEN);

        pat = BizUtil.ZERO_FILL;

        len = 3;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000.000 円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(70)
    public void testEditCommaTuuka_A7() {
        value = BizCurrency.valueOf(1000, BizCurrencyTypes.YEN);

        pat = BizUtil.NON_ZERO_FILL;

        len = 3;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000 円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(80)
    public void testEditCommaTuuka_A8() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.YEN);

        pat = BizUtil.ZERO_FILL;

        len = 3;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000.100 円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(90)
    public void testEditCommaTuuka_A9() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.YEN);

        pat = BizUtil.NON_ZERO_FILL;

        len = 3;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000.1 円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(100)
    public void testEditCommaTuuka_A10() {
        value = BizCurrency.valueOf(1000, BizCurrencyTypes.MANYEN);

        pat = BizUtil.ZERO_FILL;

        len = 0;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000 万円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(110)
    public void testEditCommaTuuka_A11() {
        value = BizCurrency.valueOf(1000, BizCurrencyTypes.MANYEN);

        pat = BizUtil.NON_ZERO_FILL;

        len = 0;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000 万円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(120)
    public void testEditCommaTuuka_A12() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.MANYEN);

        pat = BizUtil.ZERO_FILL;

        len = 0;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000 万円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(130)
    public void testEditCommaTuuka_A13() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.MANYEN);

        pat = BizUtil.NON_ZERO_FILL;

        len = 0;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000 万円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(140)
    public void testEditCommaTuuka_A14() {
        value = BizCurrency.valueOf(1000, BizCurrencyTypes.MANYEN);

        pat = BizUtil.ZERO_FILL;

        len = 3;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000.000 万円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(150)
    public void testEditCommaTuuka_A15() {
        value = BizCurrency.valueOf(1000, BizCurrencyTypes.MANYEN);

        pat = BizUtil.NON_ZERO_FILL;

        len = 3;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000 万円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(160)
    public void testEditCommaTuuka_A16() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.MANYEN);

        pat = BizUtil.ZERO_FILL;

        len = 3;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000.100 万円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(170)
    public void testEditCommaTuuka_A17() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.MANYEN);

        pat = BizUtil.NON_ZERO_FILL;

        len = 3;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000.1 万円";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(180)
    public void testEditCommaTuuka_A18() {
        value = BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);

        pat = BizUtil.ZERO_FILL;

        len = 0;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000 米ドル";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(190)
    public void testEditCommaTuuka_A19() {
        value = BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);

        pat = BizUtil.NON_ZERO_FILL;

        len = 0;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000 米ドル";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(200)
    public void testEditCommaTuuka_A20() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.DOLLAR);

        pat = BizUtil.ZERO_FILL;

        len = 0;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000 米ドル";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(210)
    public void testEditCommaTuuka_A21() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.DOLLAR);

        pat = BizUtil.NON_ZERO_FILL;

        len = 0;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000 米ドル";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(220)
    public void testEditCommaTuuka_A22() {
        value = BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);

        pat = BizUtil.ZERO_FILL;

        len = 3;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000.000 米ドル";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(230)
    public void testEditCommaTuuka_A23() {
        value = BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);

        pat = BizUtil.NON_ZERO_FILL;

        len = 3;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000 米ドル";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(240)
    public void testEditCommaTuuka_A24() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.DOLLAR);

        pat = BizUtil.ZERO_FILL;

        len = 3;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000.100 米ドル";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test
    @TestOrder(250)
    public void testEditCommaTuuka_A25() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.DOLLAR);

        pat = BizUtil.NON_ZERO_FILL;

        len = 3;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000.1 米ドル";
        exStringEquals(result, expect, "編集後文字列");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(260)
    public void testEditCommaTuuka_A26() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.YEN);

        pat = BizUtil.ZERO_FILL;

        len = 40;
        expect = "入力桁数が不正です。";
        try{
            result = ViewReport.editCommaTuuka(value, pat, len);
        }catch(BizAppException bae){
            result = bae.getMessage();
            exStringEquals(result, expect, "編集後文字列");
            throw bae;
        }
    }

    @Test
    @TestOrder(270)
    public void testEditCommaTuuka_A27() {
        value = BizCurrency.valueOf(1000.1, BizCurrencyTypes.YEN);

        pat = BizUtil.NON_ZERO_FILL;

        len = 39;
        result = ViewReport.editCommaTuuka(value, pat, len);
        expect = "1,000.1 円";
        exStringEquals(result, expect, "編集後文字列");
    }

}
