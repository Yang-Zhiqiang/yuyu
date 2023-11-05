package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#huho2GetMosikkatup()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_huho2GetMosikkatup {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testHuho2GetIkkatubaraikaisuup_A1(){

        String pNyuukintuukakbn = "1";
        Long pEnkamosikkatup = 1000l;
        Long pGaikamosikkatup = 2000l;
        BizCurrency huho2Mosikkatup = editSeihoWebRenkeiKoumoku.huho2GetMosikkatup(
            pNyuukintuukakbn, pEnkamosikkatup, pGaikamosikkatup);
        exBizCalcbleEquals(huho2Mosikkatup, BizCurrency.valueOf(1000, BizCurrencyTypes.YEN), "普保Ⅱ申込一括払Ｐ");
    }

    @Test
    @TestOrder(20)
    public void testHuho2GetIkkatubaraikaisuup_A2(){

        String pNyuukintuukakbn = "2";
        Long pEnkamosikkatup = 1000l;
        Long pGaikamosikkatup = 2000l;
        BizCurrency huho2Mosikkatup = editSeihoWebRenkeiKoumoku.huho2GetMosikkatup(
            pNyuukintuukakbn, pEnkamosikkatup, pGaikamosikkatup);
        exBizCalcbleEquals(huho2Mosikkatup, BizCurrency.valueOf(20.00, BizCurrencyTypes.DOLLAR), "普保Ⅱ申込一括払Ｐ");
    }

    @Test
    @TestOrder(30)
    public void testHuho2GetIkkatubaraikaisuup_A3(){

        String pNyuukintuukakbn = "3";
        Long pEnkamosikkatup = 1000l;
        Long pGaikamosikkatup = 3000l;
        BizCurrency huho2Mosikkatup = editSeihoWebRenkeiKoumoku.huho2GetMosikkatup(
            pNyuukintuukakbn, pEnkamosikkatup, pGaikamosikkatup);
        exBizCalcbleEquals(huho2Mosikkatup, BizCurrency.valueOf(30.00, BizCurrencyTypes.EURO), "普保Ⅱ申込一括払Ｐ");
    }

    @Test
    @TestOrder(40)
    public void testHuho2GetIkkatubaraikaisuup_A4(){

        String pNyuukintuukakbn = "4";
        Long pEnkamosikkatup = 1000l;
        Long pGaikamosikkatup = 4000l;
        BizCurrency huho2Mosikkatup = editSeihoWebRenkeiKoumoku.huho2GetMosikkatup(
            pNyuukintuukakbn, pEnkamosikkatup, pGaikamosikkatup);
        exBizCalcbleEquals(huho2Mosikkatup, BizCurrency.valueOf(40.00, BizCurrencyTypes.AU_DOLLAR), "普保Ⅱ申込一括払Ｐ");
    }

    @Test
    @TestOrder(50)
    public void testHuho2GetIkkatubaraikaisuup_A5(){

        String pNyuukintuukakbn = "0";
        Long pEnkamosikkatup = 1000l;
        Long pGaikamosikkatup = 2000l;
        BizCurrency huho2Mosikkatup = editSeihoWebRenkeiKoumoku.huho2GetMosikkatup(
            pNyuukintuukakbn, pEnkamosikkatup, pGaikamosikkatup);
        exBizCalcbleEquals(huho2Mosikkatup, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "普保Ⅱ申込一括払Ｐ");
    }

    @Test
    @TestOrder(60)
    public void testHuho2GetIkkatubaraikaisuup_A6(){

        String pNyuukintuukakbn = "1";
        Long pEnkamosikkatup = 0l;
        Long pGaikamosikkatup = 2000l;
        BizCurrency huho2Mosikkatup = editSeihoWebRenkeiKoumoku.huho2GetMosikkatup(
            pNyuukintuukakbn, pEnkamosikkatup, pGaikamosikkatup);
        exBizCalcbleEquals(huho2Mosikkatup, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "普保Ⅱ申込一括払Ｐ");
    }

    @Test
    @TestOrder(70)
    public void testHuho2GetIkkatubaraikaisuup_A7(){

        String pNyuukintuukakbn = "1";
        Long pEnkamosikkatup = null;
        Long pGaikamosikkatup = 2000l;
        BizCurrency huho2Mosikkatup = editSeihoWebRenkeiKoumoku.huho2GetMosikkatup(
            pNyuukintuukakbn, pEnkamosikkatup, pGaikamosikkatup);
        exBizCalcbleEquals(huho2Mosikkatup, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "普保Ⅱ申込一括払Ｐ");
    }

    @Test
    @TestOrder(80)
    public void testHuho2GetIkkatubaraikaisuup_A8(){

        String pNyuukintuukakbn = "2";
        Long pEnkamosikkatup = 1000l;
        Long pGaikamosikkatup = 0l;
        BizCurrency huho2Mosikkatup = editSeihoWebRenkeiKoumoku.huho2GetMosikkatup(
            pNyuukintuukakbn, pEnkamosikkatup, pGaikamosikkatup);
        exBizCalcbleEquals(huho2Mosikkatup, BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "普保Ⅱ申込一括払Ｐ");
    }

    @Test
    @TestOrder(90)
    public void testHuho2GetIkkatubaraikaisuup_A9(){

        String pNyuukintuukakbn = "2";
        Long pEnkamosikkatup = 1000l;
        Long pGaikamosikkatup = null;
        BizCurrency huho2Mosikkatup = editSeihoWebRenkeiKoumoku.huho2GetMosikkatup(
            pNyuukintuukakbn, pEnkamosikkatup, pGaikamosikkatup);
        exBizCalcbleEquals(huho2Mosikkatup, BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "普保Ⅱ申込一括払Ｐ");
    }

    @Test
    @TestOrder(100)
    public void testHuho2GetIkkatubaraikaisuup_A10(){

        String pNyuukintuukakbn = "3";
        Long pEnkamosikkatup = 1000l;
        Long pGaikamosikkatup = 0l;
        BizCurrency huho2Mosikkatup = editSeihoWebRenkeiKoumoku.huho2GetMosikkatup(
            pNyuukintuukakbn, pEnkamosikkatup, pGaikamosikkatup);
        exBizCalcbleEquals(huho2Mosikkatup, BizCurrency.valueOf(0.00, BizCurrencyTypes.EURO), "普保Ⅱ申込一括払Ｐ");
    }

    @Test
    @TestOrder(110)
    public void testHuho2GetIkkatubaraikaisuup_A11(){

        String pNyuukintuukakbn = "3";
        Long pEnkamosikkatup = 1000l;
        Long pGaikamosikkatup = null;
        BizCurrency huho2Mosikkatup = editSeihoWebRenkeiKoumoku.huho2GetMosikkatup(
            pNyuukintuukakbn, pEnkamosikkatup, pGaikamosikkatup);
        exBizCalcbleEquals(huho2Mosikkatup, BizCurrency.valueOf(0.00, BizCurrencyTypes.EURO), "普保Ⅱ申込一括払Ｐ");
    }

    @Test
    @TestOrder(120)
    public void testHuho2GetIkkatubaraikaisuup_A12(){

        String pNyuukintuukakbn = "4";
        Long pEnkamosikkatup = 1000l;
        Long pGaikamosikkatup = 0l;
        BizCurrency huho2Mosikkatup = editSeihoWebRenkeiKoumoku.huho2GetMosikkatup(
            pNyuukintuukakbn, pEnkamosikkatup, pGaikamosikkatup);
        exBizCalcbleEquals(huho2Mosikkatup, BizCurrency.valueOf(0.00, BizCurrencyTypes.AU_DOLLAR), "普保Ⅱ申込一括払Ｐ");
    }

    @Test
    @TestOrder(130)
    public void testHuho2GetIkkatubaraikaisuup_A13(){

        String pNyuukintuukakbn = "4";
        Long pEnkamosikkatup = 1000l;
        Long pGaikamosikkatup = null;
        BizCurrency huho2Mosikkatup = editSeihoWebRenkeiKoumoku.huho2GetMosikkatup(
            pNyuukintuukakbn, pEnkamosikkatup, pGaikamosikkatup);
        exBizCalcbleEquals(huho2Mosikkatup, BizCurrency.valueOf(0.00, BizCurrencyTypes.AU_DOLLAR), "普保Ⅱ申込一括払Ｐ");
    }
}
