package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 経理伝票データ作成共通処理クラスのメソッド {@link BzKeiriDenDataSksKyoutuu#changeGaika(BT_DenpyoData)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzKeiriDenDataSksKyoutuuTest_changeGaika extends AbstractTest {

    @Inject
    private BzKeiriDenDataSksKyoutuu bzKeiriDenDataSksKyoutuu;

    @Test
    @TestOrder(10)
    public void testChangeGaika_A1() {
        BizCurrency pDengaikagk = BizCurrency.valueOf(1000, BizCurrencyTypes.YEN);
        BizNumber pKawaserate = BizNumber.valueOf(1);

        BizCurrency denyenKagk = bzKeiriDenDataSksKyoutuu.changeGaika(pDengaikagk, pKawaserate);

        exBizCalcbleEquals(denyenKagk, BizCurrency.valueOf(1000), "伝票金額（円）");

    }

    @Test
    @TestOrder(20)
    public void testChangeGaika_A2() {
        BizCurrency pDengaikagk = BizCurrency.valueOf(1000, BizCurrencyTypes.YEN);
        BizNumber pKawaserate = BizNumber.valueOf(1.5);

        BizCurrency denyenKagk = bzKeiriDenDataSksKyoutuu.changeGaika(pDengaikagk, pKawaserate);

        exBizCalcbleEquals(denyenKagk, BizCurrency.valueOf(1000), "伝票金額（円）");

    }

    @Test
    @TestOrder(30)
    public void testChangeGaika_A3() {
        BizCurrency pDengaikagk = BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);
        BizNumber pKawaserate = BizNumber.valueOf(6);

        BizCurrency denyenKagk = bzKeiriDenDataSksKyoutuu.changeGaika(pDengaikagk, pKawaserate);

        exBizCalcbleEquals(denyenKagk, BizCurrency.valueOf(6000), "伝票金額（円）");

    }

    @Test
    @TestOrder(40)
    public void testChangeGaika_A4() {
        BizCurrency pDengaikagk = BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);
        BizNumber pKawaserate = BizNumber.valueOf(6.5);

        BizCurrency denyenKagk = bzKeiriDenDataSksKyoutuu.changeGaika(pDengaikagk, pKawaserate);

        exBizCalcbleEquals(denyenKagk, BizCurrency.valueOf(6500), "伝票金額（円）");

    }

    @Test
    @TestOrder(50)
    public void testChangeGaika_A5() {
        BizCurrency pDengaikagk = BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR);
        BizNumber pKawaserate = BizNumber.valueOf(4);

        BizCurrency denyenKagk = bzKeiriDenDataSksKyoutuu.changeGaika(pDengaikagk, pKawaserate);

        exBizCalcbleEquals(denyenKagk, BizCurrency.valueOf(4000), "伝票金額（円）");

    }

    @Test
    @TestOrder(60)
    public void testChangeGaika_A6() {
        BizCurrency pDengaikagk = BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR);
        BizNumber pKawaserate = BizNumber.valueOf(4.5);

        BizCurrency denyenKagk = bzKeiriDenDataSksKyoutuu.changeGaika(pDengaikagk, pKawaserate);

        exBizCalcbleEquals(denyenKagk, BizCurrency.valueOf(4500), "伝票金額（円）");

    }

    @Test
    @TestOrder(70)
    public void testChangeGaika_A7() {
        BizCurrency pDengaikagk = BizCurrency.valueOf(1000, BizCurrencyTypes.EURO);
        BizNumber pKawaserate = BizNumber.valueOf(8);

        BizCurrency denyenKagk = bzKeiriDenDataSksKyoutuu.changeGaika(pDengaikagk, pKawaserate);

        exBizCalcbleEquals(denyenKagk, BizCurrency.valueOf(8000), "伝票金額（円）");

    }

    @Test
    @TestOrder(80)
    public void testChangeGaika_A8() {
        BizCurrency pDengaikagk = BizCurrency.valueOf(1000, BizCurrencyTypes.EURO);
        BizNumber pKawaserate = BizNumber.valueOf(8.5);

        BizCurrency denyenKagk = bzKeiriDenDataSksKyoutuu.changeGaika(pDengaikagk, pKawaserate);

        exBizCalcbleEquals(denyenKagk, BizCurrency.valueOf(8500), "伝票金額（円）");

    }
}
