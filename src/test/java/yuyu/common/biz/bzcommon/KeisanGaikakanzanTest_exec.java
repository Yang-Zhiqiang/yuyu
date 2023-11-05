package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 通貨換算計算クラスのメソッド {@link KeisanGaikakanzan#exec(C_Tuukasyu,BizCurrency,BizNumber,C_HasuusyoriKbn)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanGaikakanzanTest_exec {

    @Inject
    private KeisanGaikakanzan keisanGaikakanzan;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.USD, BizCurrency.valueOf(6543, BizCurrencyTypes.YEN), BizNumber.valueOf(0.001), C_HasuusyoriKbn.AGE);

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(6.55, BizCurrencyTypes.DOLLAR), "換算額");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.USD, BizCurrency.valueOf(6548, BizCurrencyTypes.YEN), BizNumber.valueOf(0.001), C_HasuusyoriKbn.AGE);

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(6.55, BizCurrencyTypes.DOLLAR), "換算額");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.USD, BizCurrency.valueOf(6543, BizCurrencyTypes.YEN), BizNumber.valueOf(0.001), C_HasuusyoriKbn.SUTE);

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(6.54, BizCurrencyTypes.DOLLAR), "換算額");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.USD, BizCurrency.valueOf(6548, BizCurrencyTypes.YEN), BizNumber.valueOf(0.001), C_HasuusyoriKbn.SUTE);

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(6.54, BizCurrencyTypes.DOLLAR), "換算額");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.USD, BizCurrency.valueOf(6544, BizCurrencyTypes.YEN), BizNumber.valueOf(0.001), C_HasuusyoriKbn.SSYGNY);

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(6.54, BizCurrencyTypes.DOLLAR), "換算額");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.USD, BizCurrency.valueOf(6545, BizCurrencyTypes.YEN), BizNumber.valueOf(0.001), C_HasuusyoriKbn.SSYGNY);

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(6.55, BizCurrencyTypes.DOLLAR), "換算額");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.USD, BizCurrency.valueOf(6546, BizCurrencyTypes.YEN), BizNumber.valueOf(0.001), C_HasuusyoriKbn.SSYGNY);

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(6.55, BizCurrencyTypes.DOLLAR), "換算額");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.USD, BizCurrency.valueOf(123456, BizCurrencyTypes.YEN), BizNumber.valueOf(0.01), C_HasuusyoriKbn.BLNK);

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "換算額");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY, BizCurrency.valueOf(685, BizCurrencyTypes.DOLLAR), BizNumber.valueOf(1000), C_HasuusyoriKbn.AGE);

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(685000, BizCurrencyTypes.YEN), "換算額");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        keisanGaikakanzan.exec(C_Tuukasyu.JPY, BizCurrency.valueOf(654391, BizCurrencyTypes.YEN), BizNumber.valueOf(1), C_HasuusyoriKbn.AGE);

        BizCurrency kanzanGaku = keisanGaikakanzan.getKanzanGaku();

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(654391, BizCurrencyTypes.YEN), "換算額");
    }
    @Test
    @TestOrder(110)
    public void testExec_B1() {

        keisanGaikakanzan.execDivide(C_Tuukasyu.USD, BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN), BizNumber.valueOf(120.89), C_HasuusyoriKbn.AGE);

        BizCurrency kanzanGaku = keisanGaikakanzan.getKanzanGaku();

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(8271.99, BizCurrencyTypes.DOLLAR), "換算額");
    }

    @Test
    @TestOrder(120)
    public void testExec_B2() {

        keisanGaikakanzan.execDivide(C_Tuukasyu.USD, BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN), BizNumber.valueOf(120.89), C_HasuusyoriKbn.SUTE);

        BizCurrency kanzanGaku = keisanGaikakanzan.getKanzanGaku();

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(8271.98, BizCurrencyTypes.DOLLAR), "換算額");
    }
    @Test
    @TestOrder(130)
    public void testExec_B3() {

        keisanGaikakanzan.execDivide(C_Tuukasyu.USD, BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN), BizNumber.valueOf(120.89), C_HasuusyoriKbn.SSYGNY);

        BizCurrency kanzanGaku = keisanGaikakanzan.getKanzanGaku();

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(8271.98, BizCurrencyTypes.DOLLAR), "換算額");
    }
    @Test
    @TestOrder(140)
    public void testExec_B4() {

        Exception e = null;
        try {
            keisanGaikakanzan.execDivide(C_Tuukasyu.USD, BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN), BizNumber.valueOf(120.89), C_HasuusyoriKbn.BLNK);
        } catch (ArithmeticException ae){
            e =ae;
        }

        exStringEquals(e.getMessage(), "Rounding necessary", "Excepyion Message");
    }
    @Test
    @TestOrder(150)
    public void testExec_B5() {


        keisanGaikakanzan.execDivide(C_Tuukasyu.USD, BizCurrency.valueOf(1000000, BizCurrencyTypes.AU_DOLLAR), BizNumber.valueOf(1.3722), C_HasuusyoriKbn.AGE);

        BizCurrency kanzanGaku = keisanGaikakanzan.getKanzanGaku();

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(728756.75, BizCurrencyTypes.DOLLAR), "換算額");

    }
    @Test
    @TestOrder(160)
    public void testExec_B6() {

        keisanGaikakanzan.execDivide(C_Tuukasyu.USD, BizCurrency.valueOf(1000000, BizCurrencyTypes.DOLLAR), BizNumber.valueOf(1.3722), C_HasuusyoriKbn.AGE);

        BizCurrency kanzanGaku = keisanGaikakanzan.getKanzanGaku();

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(728756.75, BizCurrencyTypes.DOLLAR), "換算額");
    }
    @Test
    @TestOrder(160)
    public void testExec_B7() {

        keisanGaikakanzan.execDivide(C_Tuukasyu.AUD, BizCurrency.valueOf(1000000, BizCurrencyTypes.AU_DOLLAR), BizNumber.valueOf(1.3722), C_HasuusyoriKbn.AGE);

        BizCurrency kanzanGaku = keisanGaikakanzan.getKanzanGaku();

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(728756.75, BizCurrencyTypes.AU_DOLLAR), "換算額");
    }
    @Test
    @TestOrder(160)
    public void testExec_B8() {

        keisanGaikakanzan.execDivide(C_Tuukasyu.AUD, BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN), BizNumber.valueOf(120.89), C_HasuusyoriKbn.AGE);

        BizCurrency kanzanGaku = keisanGaikakanzan.getKanzanGaku();

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(8271.99, BizCurrencyTypes.AU_DOLLAR), "換算額");
    }

    @Test
    @TestOrder(160)
    public void testExec_B9() {

        keisanGaikakanzan.execDivide(C_Tuukasyu.AUD, BizCurrency.valueOf(1000000, BizCurrencyTypes.DOLLAR), BizNumber.valueOf(1.3722), C_HasuusyoriKbn.AGE);

        BizCurrency kanzanGaku = keisanGaikakanzan.getKanzanGaku();

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(728756.75, BizCurrencyTypes.AU_DOLLAR), "換算額");
    }

    @Test
    @TestOrder(160)
    public void testExec_B10() {

        keisanGaikakanzan.execDivide(C_Tuukasyu.JPY, BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN), BizNumber.valueOf(0.0083), C_HasuusyoriKbn.AGE);

        BizCurrency kanzanGaku = keisanGaikakanzan.getKanzanGaku();

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(120481928, BizCurrencyTypes.YEN), "換算額");
    }

    @Test
    @TestOrder(160)
    public void testExec_B11() {

        keisanGaikakanzan.execDivide(C_Tuukasyu.JPY, BizCurrency.valueOf(1000000, BizCurrencyTypes.DOLLAR), BizNumber.valueOf(3.0), C_HasuusyoriKbn.AGE);

        BizCurrency kanzanGaku = keisanGaikakanzan.getKanzanGaku();

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(333334, BizCurrencyTypes.YEN), "換算額");
    }

    @Test
    @TestOrder(160)
    public void testExec_B12() {

        keisanGaikakanzan.execDivide(C_Tuukasyu.JPY, BizCurrency.valueOf(1000000, BizCurrencyTypes.AU_DOLLAR), BizNumber.valueOf(3.0), C_HasuusyoriKbn.AGE);

        BizCurrency kanzanGaku = keisanGaikakanzan.getKanzanGaku();

        exBizCalcbleEquals(kanzanGaku, BizCurrency.valueOf(333334, BizCurrencyTypes.YEN), "換算額");
    }

}
