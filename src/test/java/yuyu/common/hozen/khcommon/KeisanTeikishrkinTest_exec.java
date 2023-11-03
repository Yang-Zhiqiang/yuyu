package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 定期支払金計算クラスのメソッド {@link KeisanTeikishrkin#exec(BizCurrency, BizNumber)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanTeikishrkinTest_exec {

    @Inject
    private KeisanTeikishrkin KeisanTeikishrkin;


    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizCurrency kijyunkngk = null;

        BizNumber teikishrritu = null;

        C_ErrorKbn resultKbn = KeisanTeikishrkin.exec(kijyunkngk, teikishrritu);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");

        exBizCalcbleEquals(KeisanTeikishrkin.getTeikishrkin(), null, "定期支払金");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizCurrency kijyunkngk = null;

        BizNumber teikishrritu = BizNumber.valueOf(1.1234);

        C_ErrorKbn resultKbn = KeisanTeikishrkin.exec(kijyunkngk, teikishrritu);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");

        exBizCalcbleEquals(KeisanTeikishrkin.getTeikishrkin(), null, "定期支払金");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizCurrency kijyunkngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.DOLLAR);

        BizNumber teikishrritu = null;

        C_ErrorKbn resultKbn = KeisanTeikishrkin.exec(kijyunkngk, teikishrritu);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");

        exBizCalcbleEquals(KeisanTeikishrkin.getTeikishrkin(), null, "定期支払金");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BizCurrency kijyunkngk = BizCurrency.valueOf(1234567891, BizCurrencyTypes.DOLLAR);

        BizNumber teikishrritu = BizNumber.valueOf(1.2345);

        C_ErrorKbn resultKbn = KeisanTeikishrkin.exec(kijyunkngk, teikishrritu);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanTeikishrkin.getTeikishrkin(), BizCurrency.valueOf(1524074061.44, BizCurrencyTypes.DOLLAR), "定期支払金");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BizCurrency kijyunkngk = BizCurrency.valueOf(1234567891, BizCurrencyTypes.AU_DOLLAR);

        BizNumber teikishrritu = BizNumber.valueOf(1.2345);

        C_ErrorKbn resultKbn = KeisanTeikishrkin.exec(kijyunkngk, teikishrritu);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanTeikishrkin.getTeikishrkin(), BizCurrency.valueOf(1524074061.44, BizCurrencyTypes.AU_DOLLAR), "定期支払金");

    }
    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BizCurrency kijyunkngk = BizCurrency.valueOf(1234567891, BizCurrencyTypes.YEN);

        BizNumber teikishrritu = BizNumber.valueOf(1.2345);

        C_ErrorKbn resultKbn = KeisanTeikishrkin.exec(kijyunkngk, teikishrritu);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanTeikishrkin.getTeikishrkin(), BizCurrency.valueOf(1524074062, BizCurrencyTypes.YEN), "定期支払金");

    }
}
