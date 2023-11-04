package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 単月保険料充当額計算クラスのメソッド {@link KeisanPJyuutougk#exec(BizCurrency, BizCurrency, int, int, C_HrkkknsmnKbn, BizDate, BizDateYM)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanPJyuutougkTest_exec {

    @Inject
    private KeisanPJyuutougk keisanPJyuutougk;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        C_ErrorKbn errorKbn = keisanPJyuutougk.exec(null, BizCurrency.valueOf(15), 16, 17, C_HrkkknsmnKbn.SAIMANKI,
            BizDate.valueOf(20181106), BizDateYM.valueOf(201908));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanPJyuutougk.getPJyuutougk());
        assertNull(keisanPJyuutougk.getYoteiSinkeiyakuhiRitu());
        assertNull(keisanPJyuutougk.getYoteiIjihiRitu());
        assertNull(keisanPJyuutougk.getYoteiSyuukinhiRitu());
        assertNull(keisanPJyuutougk.getKougakuWaribikiRitu());

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_ErrorKbn errorKbn = keisanPJyuutougk.exec(BizCurrency.valueOf(14), null, 16, 17, C_HrkkknsmnKbn.SAIMANKI,
            BizDate.valueOf(20181106), BizDateYM.valueOf(201908));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanPJyuutougk.getPJyuutougk());
        assertNull(keisanPJyuutougk.getYoteiSinkeiyakuhiRitu());
        assertNull(keisanPJyuutougk.getYoteiIjihiRitu());
        assertNull(keisanPJyuutougk.getYoteiSyuukinhiRitu());
        assertNull(keisanPJyuutougk.getKougakuWaribikiRitu());

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_ErrorKbn errorKbn = keisanPJyuutougk.exec(BizCurrency.valueOf(14), BizCurrency.valueOf(15), 16, 17, null,
            BizDate.valueOf(20181106), BizDateYM.valueOf(201908));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanPJyuutougk.getPJyuutougk());
        assertNull(keisanPJyuutougk.getYoteiSinkeiyakuhiRitu());
        assertNull(keisanPJyuutougk.getYoteiIjihiRitu());
        assertNull(keisanPJyuutougk.getYoteiSyuukinhiRitu());
        assertNull(keisanPJyuutougk.getKougakuWaribikiRitu());

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        C_ErrorKbn errorKbn = keisanPJyuutougk.exec(BizCurrency.valueOf(14), BizCurrency.valueOf(15), 16, 17,
            C_HrkkknsmnKbn.SAIMANKI,
            null, BizDateYM.valueOf(201908));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanPJyuutougk.getPJyuutougk());
        assertNull(keisanPJyuutougk.getYoteiSinkeiyakuhiRitu());
        assertNull(keisanPJyuutougk.getYoteiIjihiRitu());
        assertNull(keisanPJyuutougk.getYoteiSyuukinhiRitu());
        assertNull(keisanPJyuutougk.getKougakuWaribikiRitu());

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        C_ErrorKbn errorKbn = keisanPJyuutougk.exec(BizCurrency.valueOf(14), BizCurrency.valueOf(15), 16, 17,
            C_HrkkknsmnKbn.SAIMANKI, BizDate.valueOf(20181106), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanPJyuutougk.getPJyuutougk());
        assertNull(keisanPJyuutougk.getYoteiSinkeiyakuhiRitu());
        assertNull(keisanPJyuutougk.getYoteiIjihiRitu());
        assertNull(keisanPJyuutougk.getYoteiSyuukinhiRitu());
        assertNull(keisanPJyuutougk.getKougakuWaribikiRitu());

    }

    @Test
    @TestOrder(60)
    public void testExec_B1() {

        C_ErrorKbn errorKbn = keisanPJyuutougk.exec(BizCurrency.valueOf(14, BizCurrencyTypes.DOLLAR),
            BizCurrency.valueOf(15, BizCurrencyTypes.YEN), 16, 26, C_HrkkknsmnKbn.SAIMANKI, BizDate.valueOf(20181106),
            BizDateYM.valueOf(201811));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanPJyuutougk.getPJyuutougk(), BizCurrency.valueOf(13.069, BizCurrencyTypes.DOLLAR),
            "保険料充当額（契約通貨）");
        exBizCalcbleEquals(keisanPJyuutougk.getYoteiSinkeiyakuhiRitu(), BizNumber.valueOf(0.0315), "予定新契約費率");
        exBizCalcbleEquals(keisanPJyuutougk.getYoteiIjihiRitu(), BizNumber.valueOf(0.02), "予定維持費率");
        exBizCalcbleEquals(keisanPJyuutougk.getYoteiSyuukinhiRitu(), BizNumber.valueOf(0.015), "予定集金費率");
        exBizCalcbleEquals(keisanPJyuutougk.getKougakuWaribikiRitu(), BizNumber.valueOf(0), "高額割引率");

    }

    @Test
    @TestOrder(70)
    public void testExec_B2() {

        C_ErrorKbn errorKbn = keisanPJyuutougk.exec(BizCurrency.valueOf(14, BizCurrencyTypes.DOLLAR),
            BizCurrency.valueOf(15, BizCurrencyTypes.YEN), 16, 17, C_HrkkknsmnKbn.SAIMANKI, BizDate.valueOf(20181106),
            BizDateYM.valueOf(201810));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanPJyuutougk.getPJyuutougk());
        assertNull(keisanPJyuutougk.getYoteiSinkeiyakuhiRitu());
        assertNull(keisanPJyuutougk.getYoteiIjihiRitu());
        assertNull(keisanPJyuutougk.getYoteiSyuukinhiRitu());
        assertNull(keisanPJyuutougk.getKougakuWaribikiRitu());

    }

    @Test
    @TestOrder(80)
    public void testExec_B3() {

        C_ErrorKbn errorKbn = keisanPJyuutougk.exec(BizCurrency.valueOf(14, BizCurrencyTypes.DOLLAR),
            BizCurrency.valueOf(14999, BizCurrencyTypes.YEN), 16, 30, C_HrkkknsmnKbn.SAIMANKI,
            BizDate.valueOf(20181106),
            BizDateYM.valueOf(201812));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanPJyuutougk.getPJyuutougk(), BizCurrency.valueOf(12.761, BizCurrencyTypes.DOLLAR),
            "保険料充当額（契約通貨）");
        exBizCalcbleEquals(keisanPJyuutougk.getYoteiSinkeiyakuhiRitu(), BizNumber.valueOf(0.0495), "予定新契約費率");
        exBizCalcbleEquals(keisanPJyuutougk.getYoteiIjihiRitu(), BizNumber.valueOf(0.024), "予定維持費率");
        exBizCalcbleEquals(keisanPJyuutougk.getYoteiSyuukinhiRitu(), BizNumber.valueOf(0.015), "予定集金費率");
        exBizCalcbleEquals(keisanPJyuutougk.getKougakuWaribikiRitu(), BizNumber.valueOf(0), "高額割引率");

    }

    @Test
    @TestOrder(90)
    public void testExec_B4() {

        C_ErrorKbn errorKbn = keisanPJyuutougk.exec(BizCurrency.valueOf(14, BizCurrencyTypes.DOLLAR),
            BizCurrency.valueOf(15000, BizCurrencyTypes.YEN), 16, 15, C_HrkkknsmnKbn.NENMANKI,
            BizDate.valueOf(20181106),
            BizDateYM.valueOf(202712));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanPJyuutougk.getPJyuutougk(), BizCurrency.valueOf(12.754, BizCurrencyTypes.DOLLAR),
            "保険料充当額（契約通貨）");
        exBizCalcbleEquals(keisanPJyuutougk.getYoteiSinkeiyakuhiRitu(), BizNumber.valueOf(0.054), "予定新契約費率");
        exBizCalcbleEquals(keisanPJyuutougk.getYoteiIjihiRitu(), BizNumber.valueOf(0.025), "予定維持費率");
        exBizCalcbleEquals(keisanPJyuutougk.getYoteiSyuukinhiRitu(), BizNumber.valueOf(0.015), "予定集金費率");
        exBizCalcbleEquals(keisanPJyuutougk.getKougakuWaribikiRitu(), BizNumber.valueOf(0.005), "高額割引率");

    }

    @Test
    @TestOrder(100)
    public void testExec_B5() {

        C_ErrorKbn errorKbn = keisanPJyuutougk.exec(BizCurrency.valueOf(14, BizCurrencyTypes.AU_DOLLAR),
            BizCurrency.valueOf(29999, BizCurrencyTypes.YEN), 16, 40, C_HrkkknsmnKbn.NENMANKI,
            BizDate.valueOf(20181106),
            BizDateYM.valueOf(202712));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanPJyuutougk.getPJyuutougk(), BizCurrency.valueOf(11.27, BizCurrencyTypes.AU_DOLLAR),
            "保険料充当額（契約通貨）");
        exBizCalcbleEquals(keisanPJyuutougk.getYoteiSinkeiyakuhiRitu(), BizNumber.valueOf(0.15), "予定新契約費率");
        exBizCalcbleEquals(keisanPJyuutougk.getYoteiIjihiRitu(), BizNumber.valueOf(0.035), "予定維持費率");
        exBizCalcbleEquals(keisanPJyuutougk.getYoteiSyuukinhiRitu(), BizNumber.valueOf(0.015), "予定集金費率");
        exBizCalcbleEquals(keisanPJyuutougk.getKougakuWaribikiRitu(), BizNumber.valueOf(0.005), "高額割引率");

    }

    @Test
    @TestOrder(110)
    public void testExec_B6() {

        C_ErrorKbn errorKbn = keisanPJyuutougk.exec(BizCurrency.valueOf(14, BizCurrencyTypes.AU_DOLLAR),
            BizCurrency.valueOf(30000, BizCurrencyTypes.YEN), 16, 25, C_HrkkknsmnKbn.NENMANKI,
            BizDate.valueOf(20181106),
            BizDateYM.valueOf(202812));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanPJyuutougk.getPJyuutougk(), BizCurrency.valueOf(13.44, BizCurrencyTypes.AU_DOLLAR),
            "保険料充当額（契約通貨）");
        exBizCalcbleEquals(keisanPJyuutougk.getYoteiSinkeiyakuhiRitu(), BizNumber.valueOf(0), "予定新契約費率");
        exBizCalcbleEquals(keisanPJyuutougk.getYoteiIjihiRitu(), BizNumber.valueOf(0.035), "予定維持費率");
        exBizCalcbleEquals(keisanPJyuutougk.getYoteiSyuukinhiRitu(), BizNumber.valueOf(0.015), "予定集金費率");
        exBizCalcbleEquals(keisanPJyuutougk.getKougakuWaribikiRitu(), BizNumber.valueOf(0.01), "高額割引率");

    }

    @Test
    @TestOrder(120)
    public void testExec_B7() {

        C_ErrorKbn errorKbn = keisanPJyuutougk.exec(BizCurrency.valueOf(14, BizCurrencyTypes.AU_DOLLAR),
            BizCurrency.valueOf(30001, BizCurrencyTypes.YEN), 16, 22, C_HrkkknsmnKbn.NENMANKI,
            BizDate.valueOf(20181106),
            BizDateYM.valueOf(202912));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanPJyuutougk.getPJyuutougk(), BizCurrency.valueOf(13.482, BizCurrencyTypes.AU_DOLLAR),
            "保険料充当額（契約通貨）");
        exBizCalcbleEquals(keisanPJyuutougk.getYoteiSinkeiyakuhiRitu(), BizNumber.valueOf(0), "予定新契約費率");
        exBizCalcbleEquals(keisanPJyuutougk.getYoteiIjihiRitu(), BizNumber.valueOf(0.032), "予定維持費率");
        exBizCalcbleEquals(keisanPJyuutougk.getYoteiSyuukinhiRitu(), BizNumber.valueOf(0.015), "予定集金費率");
        exBizCalcbleEquals(keisanPJyuutougk.getKougakuWaribikiRitu(), BizNumber.valueOf(0.01), "高額割引率");

    }

}