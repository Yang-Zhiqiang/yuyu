package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.def.classification.C_ErrorKbn;

/**
 * 端数月未収Ｐ編集クラスのメソッド {@link HasuuMsyPHensyu#exec(HasuuMsyPHensyuBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HasuuMsyPHensyuTest_exec {

    @Inject
    private HasuuMsyPHensyu hasuuMsyPHensyu;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        HasuuMsyPHensyuBean hasuuMsyPHensyuBean = SWAKInjector.getInstance(HasuuMsyPHensyuBean.class);
        hasuuMsyPHensyuBean.setMisyuup(null);
        hasuuMsyPHensyuBean.setMikeikap(BizCurrency.valueOf(1100, BizCurrencyTypes.YEN));
        hasuuMsyPHensyuBean.setKyktuukasyu(C_Tuukasyu.JPY);

        C_ErrorKbn errorKbn = hasuuMsyPHensyu.exec(hasuuMsyPHensyuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull("未収保険料充当回数（年）", hasuuMsyPHensyu.getMisyuupjyuutoukaisuuy());
        assertNull("未収保険料充当回数（月）", hasuuMsyPHensyu.getMisyuupjyuutoukaisuum());
        assertNull("未収保険料充当年月", hasuuMsyPHensyu.getMisyuupjyuutouym());
        assertNull("未収保険料", hasuuMsyPHensyu.getMisyuup());
        assertNull("円貨未収保険料", hasuuMsyPHensyu.getYenkamisyuup());
        assertNull("未経過保険料充当回数（年）", hasuuMsyPHensyu.getMikeikapjyuutoukaisuuy());
        assertNull("未経過保険料充当回数（月）", hasuuMsyPHensyu.getMikeikapjyuutoukaisuum());
        assertNull("未経過保険料充当年月", hasuuMsyPHensyu.getMikeikapjyuutouym());
        assertNull("未経過保険料", hasuuMsyPHensyu.getMikeikap());
        assertNull("円貨未経過保険料", hasuuMsyPHensyu.getYenkamikeikap());
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        HasuuMsyPHensyuBean hasuuMsyPHensyuBean = SWAKInjector.getInstance(HasuuMsyPHensyuBean.class);
        hasuuMsyPHensyuBean.setMisyuup(BizCurrency.valueOf(1200, BizCurrencyTypes.YEN));
        hasuuMsyPHensyuBean.setMikeikap(null);
        hasuuMsyPHensyuBean.setKyktuukasyu(C_Tuukasyu.JPY);

        C_ErrorKbn errorKbn = hasuuMsyPHensyu.exec(hasuuMsyPHensyuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull("未収保険料充当回数（年）", hasuuMsyPHensyu.getMisyuupjyuutoukaisuuy());
        assertNull("未収保険料充当回数（月）", hasuuMsyPHensyu.getMisyuupjyuutoukaisuum());
        assertNull("未収保険料充当年月", hasuuMsyPHensyu.getMisyuupjyuutouym());
        assertNull("未収保険料", hasuuMsyPHensyu.getMisyuup());
        assertNull("円貨未収保険料", hasuuMsyPHensyu.getYenkamisyuup());
        assertNull("未経過保険料充当回数（年）", hasuuMsyPHensyu.getMikeikapjyuutoukaisuuy());
        assertNull("未経過保険料充当回数（月）", hasuuMsyPHensyu.getMikeikapjyuutoukaisuum());
        assertNull("未経過保険料充当年月", hasuuMsyPHensyu.getMikeikapjyuutouym());
        assertNull("未経過保険料", hasuuMsyPHensyu.getMikeikap());
        assertNull("円貨未経過保険料", hasuuMsyPHensyu.getYenkamikeikap());
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        HasuuMsyPHensyuBean hasuuMsyPHensyuBean = SWAKInjector.getInstance(HasuuMsyPHensyuBean.class);
        hasuuMsyPHensyuBean.setMisyuup(BizCurrency.valueOf(200, BizCurrencyTypes.YEN));
        hasuuMsyPHensyuBean.setMikeikap(BizCurrency.valueOf(300, BizCurrencyTypes.YEN));
        hasuuMsyPHensyuBean.setKyktuukasyu(null);

        C_ErrorKbn errorKbn = hasuuMsyPHensyu.exec(hasuuMsyPHensyuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull("未収保険料充当回数（年）", hasuuMsyPHensyu.getMisyuupjyuutoukaisuuy());
        assertNull("未収保険料充当回数（月）", hasuuMsyPHensyu.getMisyuupjyuutoukaisuum());
        assertNull("未収保険料充当年月", hasuuMsyPHensyu.getMisyuupjyuutouym());
        assertNull("未収保険料", hasuuMsyPHensyu.getMisyuup());
        assertNull("円貨未収保険料", hasuuMsyPHensyu.getYenkamisyuup());
        assertNull("未経過保険料充当回数（年）", hasuuMsyPHensyu.getMikeikapjyuutoukaisuuy());
        assertNull("未経過保険料充当回数（月）", hasuuMsyPHensyu.getMikeikapjyuutoukaisuum());
        assertNull("未経過保険料充当年月", hasuuMsyPHensyu.getMikeikapjyuutouym());
        assertNull("未経過保険料", hasuuMsyPHensyu.getMikeikap());
        assertNull("円貨未経過保険料", hasuuMsyPHensyu.getYenkamikeikap());
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        HasuuMsyPHensyuBean hasuuMsyPHensyuBean = SWAKInjector.getInstance(HasuuMsyPHensyuBean.class);

        hasuuMsyPHensyuBean.setMisyuupjyuutoukaisuuy(2);
        hasuuMsyPHensyuBean.setMisyuupjyuutoukaisuum(11);
        hasuuMsyPHensyuBean.setMisyuupjyuutouym(BizDateYM.valueOf("202001"));
        hasuuMsyPHensyuBean.setMisyuup(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        hasuuMsyPHensyuBean.setYenkamisyuup(BizCurrency.valueOf(500, BizCurrencyTypes.YEN));
        hasuuMsyPHensyuBean.setMikeikapjyuutoukaisuuy(1);
        hasuuMsyPHensyuBean.setMikeikapjyuutoukaisuum(10);
        hasuuMsyPHensyuBean.setMikeikapjyuutouym(BizDateYM.valueOf("202002"));
        hasuuMsyPHensyuBean.setMikeikap(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        hasuuMsyPHensyuBean.setYenkamikeikap(BizCurrency.valueOf(600, BizCurrencyTypes.YEN));
        hasuuMsyPHensyuBean.setKyktuukasyu(C_Tuukasyu.JPY);

        C_ErrorKbn errorKbn = hasuuMsyPHensyu.exec(hasuuMsyPHensyuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(hasuuMsyPHensyu.getMisyuupjyuutoukaisuuy(), 2, "未収保険料充当回数（年）");
        exNumericEquals(hasuuMsyPHensyu.getMisyuupjyuutoukaisuum(), 11,  "未収保険料充当回数（月）");
        exDateYMEquals(hasuuMsyPHensyu.getMisyuupjyuutouym(), BizDateYM.valueOf("202001"), "未収保険料充当年月");
        exBizCalcbleEquals(hasuuMsyPHensyu.getMisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "未収保険料");
        exBizCalcbleEquals(hasuuMsyPHensyu.getYenkamisyuup(), BizCurrency.valueOf(500, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(hasuuMsyPHensyu.getMikeikapjyuutoukaisuuy(), 1, "未経過保険料充当回数（年）");
        exNumericEquals(hasuuMsyPHensyu.getMikeikapjyuutoukaisuum(), 10,  "未経過保険料充当回数（月）");
        exDateYMEquals(hasuuMsyPHensyu.getMikeikapjyuutouym(), BizDateYM.valueOf("202002"), "未経過保険料充当年月");
        exBizCalcbleEquals(hasuuMsyPHensyu.getMikeikap(), BizCurrency.valueOf(1000, BizCurrencyTypes.YEN), "未経過保険料");
        exBizCalcbleEquals(hasuuMsyPHensyu.getYenkamikeikap(), BizCurrency.valueOf(600, BizCurrencyTypes.YEN), "円貨未経過保険料");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        HasuuMsyPHensyuBean hasuuMsyPHensyuBean = SWAKInjector.getInstance(HasuuMsyPHensyuBean.class);

        hasuuMsyPHensyuBean.setMisyuupjyuutoukaisuuy(2);
        hasuuMsyPHensyuBean.setMisyuupjyuutoukaisuum(11);
        hasuuMsyPHensyuBean.setMisyuupjyuutouym(BizDateYM.valueOf("202001"));
        hasuuMsyPHensyuBean.setMisyuup(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
        hasuuMsyPHensyuBean.setYenkamisyuup(BizCurrency.valueOf(500, BizCurrencyTypes.YEN));
        hasuuMsyPHensyuBean.setMikeikapjyuutoukaisuuy(1);
        hasuuMsyPHensyuBean.setMikeikapjyuutoukaisuum(10);
        hasuuMsyPHensyuBean.setMikeikapjyuutouym(BizDateYM.valueOf("202002"));
        hasuuMsyPHensyuBean.setMikeikap(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        hasuuMsyPHensyuBean.setYenkamikeikap(BizCurrency.valueOf(600, BizCurrencyTypes.YEN));
        hasuuMsyPHensyuBean.setKyktuukasyu(C_Tuukasyu.JPY);

        C_ErrorKbn errorKbn = hasuuMsyPHensyu.exec(hasuuMsyPHensyuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(hasuuMsyPHensyu.getMisyuupjyuutoukaisuuy(), 2, "未収保険料充当回数（年）");
        exNumericEquals(hasuuMsyPHensyu.getMisyuupjyuutoukaisuum(), 11,  "未収保険料充当回数（月）");
        exDateYMEquals(hasuuMsyPHensyu.getMisyuupjyuutouym(), BizDateYM.valueOf("202001"), "未収保険料充当年月");
        exBizCalcbleEquals(hasuuMsyPHensyu.getMisyuup(), BizCurrency.valueOf(2000, BizCurrencyTypes.YEN), "未収保険料");
        exBizCalcbleEquals(hasuuMsyPHensyu.getYenkamisyuup(), BizCurrency.valueOf(500, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(hasuuMsyPHensyu.getMikeikapjyuutoukaisuuy(), 1, "未経過保険料充当回数（年）");
        exNumericEquals(hasuuMsyPHensyu.getMikeikapjyuutoukaisuum(), 10,  "未経過保険料充当回数（月）");
        exDateYMEquals(hasuuMsyPHensyu.getMikeikapjyuutouym(), BizDateYM.valueOf("202002"), "未経過保険料充当年月");
        exBizCalcbleEquals(hasuuMsyPHensyu.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "未経過保険料");
        exBizCalcbleEquals(hasuuMsyPHensyu.getYenkamikeikap(), BizCurrency.valueOf(600, BizCurrencyTypes.YEN), "円貨未経過保険料");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        HasuuMsyPHensyuBean hasuuMsyPHensyuBean = SWAKInjector.getInstance(HasuuMsyPHensyuBean.class);

        hasuuMsyPHensyuBean.setMisyuupjyuutoukaisuuy(1);
        hasuuMsyPHensyuBean.setMisyuupjyuutoukaisuum(11);
        hasuuMsyPHensyuBean.setMisyuupjyuutouym(null);
        hasuuMsyPHensyuBean.setMisyuup(BizCurrency.valueOf(4000, BizCurrencyTypes.DOLLAR));
        hasuuMsyPHensyuBean.setYenkamisyuup(BizCurrency.valueOf(1200, BizCurrencyTypes.YEN));
        hasuuMsyPHensyuBean.setMikeikapjyuutoukaisuuy(2);
        hasuuMsyPHensyuBean.setMikeikapjyuutoukaisuum(10);
        hasuuMsyPHensyuBean.setMikeikapjyuutouym(BizDateYM.valueOf("202001"));
        hasuuMsyPHensyuBean.setMikeikap(BizCurrency.valueOf(3000, BizCurrencyTypes.DOLLAR));
        hasuuMsyPHensyuBean.setYenkamikeikap(BizCurrency.valueOf(1300, BizCurrencyTypes.YEN));
        hasuuMsyPHensyuBean.setKyktuukasyu(C_Tuukasyu.JPY);

        C_ErrorKbn errorKbn = hasuuMsyPHensyu.exec(hasuuMsyPHensyuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(hasuuMsyPHensyu.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(hasuuMsyPHensyu.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(hasuuMsyPHensyu.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(hasuuMsyPHensyu.getMisyuup(), BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(hasuuMsyPHensyu.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(hasuuMsyPHensyu.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(hasuuMsyPHensyu.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(hasuuMsyPHensyu.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(hasuuMsyPHensyu.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "未経過保険料");
        exBizCalcbleEquals(hasuuMsyPHensyu.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        HasuuMsyPHensyuBean hasuuMsyPHensyuBean = SWAKInjector.getInstance(HasuuMsyPHensyuBean.class);

        hasuuMsyPHensyuBean.setMisyuupjyuutoukaisuuy(1);
        hasuuMsyPHensyuBean.setMisyuupjyuutoukaisuum(7);
        hasuuMsyPHensyuBean.setMisyuupjyuutouym(BizDateYM.valueOf("202011"));
        hasuuMsyPHensyuBean.setMisyuup(BizCurrency.valueOf(12000, BizCurrencyTypes.DOLLAR));
        hasuuMsyPHensyuBean.setYenkamisyuup(BizCurrency.valueOf(1200, BizCurrencyTypes.YEN));
        hasuuMsyPHensyuBean.setMikeikapjyuutoukaisuuy(2);
        hasuuMsyPHensyuBean.setMikeikapjyuutoukaisuum(6);
        hasuuMsyPHensyuBean.setMikeikapjyuutouym(BizDateYM.valueOf("202008"));
        hasuuMsyPHensyuBean.setMikeikap(BizCurrency.valueOf(6000, BizCurrencyTypes.DOLLAR));
        hasuuMsyPHensyuBean.setKyktuukasyu(C_Tuukasyu.USD);
        hasuuMsyPHensyuBean.setKwsrate(BizNumber.valueOf(101.34));

        C_ErrorKbn errorKbn = hasuuMsyPHensyu.exec(hasuuMsyPHensyuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(hasuuMsyPHensyu.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(hasuuMsyPHensyu.getMisyuupjyuutoukaisuum(), 13, "未収保険料充当回数（月）");
        exDateYMEquals(hasuuMsyPHensyu.getMisyuupjyuutouym(), BizDateYM.valueOf("202011"), "未収保険料充当年月");
        exBizCalcbleEquals(hasuuMsyPHensyu.getMisyuup(), BizCurrency.valueOf(6000, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(hasuuMsyPHensyu.getYenkamisyuup(), BizCurrency.valueOf(608040, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(hasuuMsyPHensyu.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(hasuuMsyPHensyu.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(hasuuMsyPHensyu.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(hasuuMsyPHensyu.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hasuuMsyPHensyu.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");
    }
}
