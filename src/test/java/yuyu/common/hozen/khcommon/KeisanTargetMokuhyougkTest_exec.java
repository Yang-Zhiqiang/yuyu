package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ターゲット特約目標額計算クラスのメソッド {@link KeisanTargetMokuhyougk#exec(BizCurrency, int)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanTargetMokuhyougkTest_exec {

    @Inject
    private KeisanTargetMokuhyougk keisanTargetMokuhyougk;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizCurrency pTargetkijyungk = BizCurrency.valueOf(123456, BizCurrencyTypes.DOLLAR);
        int pTargettkmokuhyougkwari = 100;
        BizCurrency mokuhyougk = keisanTargetMokuhyougk.exec(pTargetkijyungk, pTargettkmokuhyougkwari);

        exBizCalcbleEquals(mokuhyougk, BizCurrency.valueOf(123456, BizCurrencyTypes.DOLLAR), "目標額");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizCurrency pTargetkijyungk = BizCurrency.valueOf(12345.1, BizCurrencyTypes.DOLLAR);
        int pTargettkmokuhyougkwari = 1;
        BizCurrency mokuhyougk = keisanTargetMokuhyougk.exec(pTargetkijyungk, pTargettkmokuhyougkwari);

        exBizCalcbleEquals(mokuhyougk, BizCurrency.valueOf(123.46, BizCurrencyTypes.DOLLAR), "目標額");

    }
    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizCurrency pTargetkijyungk = BizCurrency.valueOf(12345.5, BizCurrencyTypes.DOLLAR);
        int pTargettkmokuhyougkwari = 1;
        BizCurrency mokuhyougk = keisanTargetMokuhyougk.exec(pTargetkijyungk, pTargettkmokuhyougkwari);

        exBizCalcbleEquals(mokuhyougk, BizCurrency.valueOf(123.46, BizCurrencyTypes.DOLLAR), "目標額");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BizCurrency pTargetkijyungk = BizCurrency.valueOf(1234, BizCurrencyTypes.YEN);
        int pTargettkmokuhyougkwari = 100;
        BizCurrency mokuhyougk = keisanTargetMokuhyougk.exec(pTargetkijyungk, pTargettkmokuhyougkwari);

        exBizCalcbleEquals(mokuhyougk, BizCurrency.valueOf(1234, BizCurrencyTypes.YEN), "目標額");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BizCurrency pTargetkijyungk = BizCurrency.valueOf(1231, BizCurrencyTypes.YEN);
        int pTargettkmokuhyougkwari = 10;
        BizCurrency mokuhyougk = keisanTargetMokuhyougk.exec(pTargetkijyungk, pTargettkmokuhyougkwari);

        exBizCalcbleEquals(mokuhyougk, BizCurrency.valueOf(124, BizCurrencyTypes.YEN), "目標額");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BizCurrency pTargetkijyungk = BizCurrency.valueOf(1235, BizCurrencyTypes.YEN);
        int pTargettkmokuhyougkwari = 10;
        BizCurrency mokuhyougk = keisanTargetMokuhyougk.exec(pTargetkijyungk, pTargettkmokuhyougkwari);

        exBizCalcbleEquals(mokuhyougk, BizCurrency.valueOf(124, BizCurrencyTypes.YEN), "目標額");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BizCurrency pTargetkijyungk = BizCurrency.valueOf(1235, BizCurrencyTypes.YEN);
        int pTargettkmokuhyougkwari = 0;
        BizCurrency mokuhyougk = keisanTargetMokuhyougk.exec(pTargetkijyungk, pTargettkmokuhyougkwari);

        exBizCalcbleEquals(mokuhyougk, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "目標額");

    }
}
