package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForHozen;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 単月外貨入金額計算クラスのメソッド {@link KeisanGaikaP#execKawaseSitei(BizCurrency, C_Tuukasyu, BizNumber)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanGaikaPTest_execKawaseSitei {

    @Inject
    private KeisanGaikaP keisanGaikaP;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanGaikakanzan.class).to(KeisanGaikakanzanMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanGaikakanzanMockForHozen.caller = KeisanGaikaPTest_execKawaseSitei.class;
    }

    @AfterClass
    public static void testClear() {
        KeisanGaikakanzanMockForHozen.caller = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExecKawaseSitei_A1() {

        C_ErrorKbn errorKbn = keisanGaikaP.execKawaseSitei(null, C_Tuukasyu.USD, BizNumber.valueOf(12.02));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanGaikaP.getP());
        assertNull(keisanGaikaP.getKawaseRate());

    }

    @Test
    @TestOrder(20)
    public void testExecKawaseSitei_A2() {

        C_ErrorKbn errorKbn = keisanGaikaP.execKawaseSitei(BizCurrency.valueOf(14), null, BizNumber.valueOf(12.02));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanGaikaP.getP());
        assertNull(keisanGaikaP.getKawaseRate());

    }

    @Test
    @TestOrder(30)
    public void testExecKawaseSitei_A3() {

        C_ErrorKbn errorKbn = keisanGaikaP.execKawaseSitei(BizCurrency.valueOf(14), C_Tuukasyu.USD, null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanGaikaP.getP());
        assertNull(keisanGaikaP.getKawaseRate());

    }

    @Test
    @TestOrder(40)
    public void testExecKawaseSitei_A4() {

        MockObjectManager.initialize();
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanGaikaP.execKawaseSitei(BizCurrency.valueOf(14), C_Tuukasyu.USD,
            BizNumber.valueOf(12.02));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanGaikaP.getP(), BizCurrency.valueOf(16, BizCurrencyTypes.DOLLAR), "保険料（契約通貨）");
        exBizCalcbleEquals(keisanGaikaP.getKawaseRate(), BizNumber.valueOf(12.02), "為替レート");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "execDivide", 0, 0),
            C_Tuukasyu.USD, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "execDivide", 0, 1),
            BizCurrency.valueOf(14), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "execDivide", 0, 2),
            BizNumber.valueOf(12.02), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "execDivide", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

    }

}