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
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#huho2GetMoszennoup()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_huho2GetMoszennoup {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testHuho2GetMoszennoup_A1(){

        String pMostuukakbn = "1";
        Long pEnkaMoszennoup = 1000l;
        Long pGaikaMoszennoup = 2000l;
        BizCurrency huho2Moszennoup = editSeihoWebRenkeiKoumoku.huho2GetMoszennoup(
            pMostuukakbn, pEnkaMoszennoup, pGaikaMoszennoup);
        exBizCalcbleEquals(huho2Moszennoup, BizCurrency.valueOf(1000, BizCurrencyTypes.YEN), "普保Ⅱ申込前納Ｐ");
    }

    @Test
    @TestOrder(20)
    public void testHuho2GetMoszennoup_A2(){

        String pMostuukakbn = "2";
        Long pEnkaMoszennoup = 1000l;
        Long pGaikaMoszennoup = 2000l;
        BizCurrency huho2Moszennoup = editSeihoWebRenkeiKoumoku.huho2GetMoszennoup(
            pMostuukakbn, pEnkaMoszennoup, pGaikaMoszennoup);
        exBizCalcbleEquals(huho2Moszennoup, BizCurrency.valueOf(20.00, BizCurrencyTypes.DOLLAR), "普保Ⅱ申込前納Ｐ");
    }

    @Test
    @TestOrder(30)
    public void testHuho2GetMoszennoup_A3(){

        String pMostuukakbn = "3";
        Long pEnkaMoszennoup = 1000l;
        Long pGaikaMoszennoup = 3000l;
        BizCurrency huho2Moszennoup = editSeihoWebRenkeiKoumoku.huho2GetMoszennoup(
            pMostuukakbn, pEnkaMoszennoup, pGaikaMoszennoup);
        exBizCalcbleEquals(huho2Moszennoup, BizCurrency.valueOf(30.00, BizCurrencyTypes.EURO), "普保Ⅱ申込前納Ｐ");
    }

    @Test
    @TestOrder(40)
    public void testHuho2GetMoszennoup_A4(){

        String pMostuukakbn = "4";
        Long pEnkaMoszennoup = 1000l;
        Long pGaikaMoszennoup = 4000l;
        BizCurrency huho2Moszennoup = editSeihoWebRenkeiKoumoku.huho2GetMoszennoup(
            pMostuukakbn, pEnkaMoszennoup, pGaikaMoszennoup);
        exBizCalcbleEquals(huho2Moszennoup, BizCurrency.valueOf(40.00, BizCurrencyTypes.AU_DOLLAR), "普保Ⅱ申込前納Ｐ");
    }

    @Test
    @TestOrder(50)
    public void testHuho2GetMoszennoup_A5(){

        String pMostuukakbn = "0";
        Long pEnkaMoszennoup = 1000l;
        Long pGaikaMoszennoup = 2000l;
        BizCurrency huho2Moszennoup = editSeihoWebRenkeiKoumoku.huho2GetMoszennoup(
            pMostuukakbn, pEnkaMoszennoup, pGaikaMoszennoup);
        exBizCalcbleEquals(huho2Moszennoup, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "普保Ⅱ申込前納Ｐ");
    }

    @Test
    @TestOrder(60)
    public void testHuho2GetMoszennoup_A6(){

        String pMostuukakbn = "1";
        Long pEnkaMoszennoup = 0l;
        Long pGaikaMoszennoup = 2000l;
        BizCurrency huho2Moszennoup = editSeihoWebRenkeiKoumoku.huho2GetMoszennoup(
            pMostuukakbn, pEnkaMoszennoup, pGaikaMoszennoup);
        exBizCalcbleEquals(huho2Moszennoup, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "普保Ⅱ申込前納Ｐ");
    }

    @Test
    @TestOrder(70)
    public void testHuho2GetMoszennoup_A7(){

        String pMostuukakbn = "1";
        Long pEnkaMoszennoup = null;
        Long pGaikaMoszennoup = 2000l;
        BizCurrency huho2Moszennoup = editSeihoWebRenkeiKoumoku.huho2GetMoszennoup(
            pMostuukakbn, pEnkaMoszennoup, pGaikaMoszennoup);
        exBizCalcbleEquals(huho2Moszennoup, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "普保Ⅱ申込前納Ｐ");
    }

    @Test
    @TestOrder(80)
    public void testHuho2GetMoszennoup_A8(){

        String pMostuukakbn = "2";
        Long pEnkaMoszennoup = 1000l;
        Long pGaikaMoszennoup = 0l;
        BizCurrency huho2Moszennoup = editSeihoWebRenkeiKoumoku.huho2GetMoszennoup(
            pMostuukakbn, pEnkaMoszennoup, pGaikaMoszennoup);
        exBizCalcbleEquals(huho2Moszennoup, BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "普保Ⅱ申込前納Ｐ");
    }

    @Test
    @TestOrder(90)
    public void testHuho2GetMoszennoup_A9(){

        String pMostuukakbn = "2";
        Long pEnkaMoszennoup = 1000l;
        Long pGaikaMoszennoup = null;
        BizCurrency huho2Moszennoup = editSeihoWebRenkeiKoumoku.huho2GetMoszennoup(
            pMostuukakbn, pEnkaMoszennoup, pGaikaMoszennoup);
        exBizCalcbleEquals(huho2Moszennoup, BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "普保Ⅱ申込前納Ｐ");
    }

    @Test
    @TestOrder(100)
    public void testHuho2GetMoszennoup_A10(){

        String pMostuukakbn = "3";
        Long pEnkaMoszennoup = 1000l;
        Long pGaikaMoszennoup = 0l;
        BizCurrency huho2Moszennoup = editSeihoWebRenkeiKoumoku.huho2GetMoszennoup(
            pMostuukakbn, pEnkaMoszennoup, pGaikaMoszennoup);
        exBizCalcbleEquals(huho2Moszennoup, BizCurrency.valueOf(0.00, BizCurrencyTypes.EURO), "普保Ⅱ申込前納Ｐ");
    }

    @Test
    @TestOrder(110)
    public void testHuho2GetMoszennoup_A11(){

        String pMostuukakbn = "3";
        Long pEnkaMoszennoup = 1000l;
        Long pGaikaMoszennoup = null;
        BizCurrency huho2Moszennoup = editSeihoWebRenkeiKoumoku.huho2GetMoszennoup(
            pMostuukakbn, pEnkaMoszennoup, pGaikaMoszennoup);
        exBizCalcbleEquals(huho2Moszennoup, BizCurrency.valueOf(0.00, BizCurrencyTypes.EURO), "普保Ⅱ申込前納Ｐ");
    }

    @Test
    @TestOrder(120)
    public void testHuho2GetMoszennoup_A12(){

        String pMostuukakbn = "4";
        Long pEnkaMoszennoup = 1000l;
        Long pGaikaMoszennoup = 0l;
        BizCurrency huho2Moszennoup = editSeihoWebRenkeiKoumoku.huho2GetMoszennoup(
            pMostuukakbn, pEnkaMoszennoup, pGaikaMoszennoup);
        exBizCalcbleEquals(huho2Moszennoup, BizCurrency.valueOf(0.00, BizCurrencyTypes.AU_DOLLAR), "普保Ⅱ申込前納Ｐ");
    }

    @Test
    @TestOrder(130)
    public void testHuho2GetMoszennoup_A13(){

        String pMostuukakbn = "4";
        Long pEnkaMoszennoup = 1000l;
        Long pGaikaMoszennoup = null;
        BizCurrency huho2Moszennoup = editSeihoWebRenkeiKoumoku.huho2GetMoszennoup(
            pMostuukakbn, pEnkaMoszennoup, pGaikaMoszennoup);
        exBizCalcbleEquals(huho2Moszennoup, BizCurrency.valueOf(0.00, BizCurrencyTypes.AU_DOLLAR), "普保Ⅱ申込前納Ｐ");
    }

}
