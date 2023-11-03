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
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#huho2GetMosheijyunp()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_huho2GetMosheijyunp {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testHuho2GetMosheijyunp_A1(){

        String pHaraikomikaisukbn = "1";
        String pMostuukakbn = "1";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 2000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(1000, BizCurrencyTypes.YEN), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(20)
    public void testHuho2GetMosheijyunp_A2(){

        String pHaraikomikaisukbn = "1";
        String pMostuukakbn = "2";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 2000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(20.00, BizCurrencyTypes.DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(30)
    public void testHuho2GetMosheijyunp_A3(){

        String pHaraikomikaisukbn = "1";
        String pMostuukakbn = "3";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 3000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(30.00, BizCurrencyTypes.EURO), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(40)
    public void testHuho2GetMosheijyunp_A4(){

        String pHaraikomikaisukbn = "1";
        String pMostuukakbn = "4";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 4000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(40.00, BizCurrencyTypes.AU_DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(50)
    public void testHuho2GetMosheijyunp_A5(){

        String pHaraikomikaisukbn = "2";
        String pMostuukakbn = "1";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 2000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(1000, BizCurrencyTypes.YEN), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(60)
    public void testHuho2GetMosheijyunp_A6(){

        String pHaraikomikaisukbn = "2";
        String pMostuukakbn = "2";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 2000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(20.00, BizCurrencyTypes.DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(70)
    public void testHuho2GetMosheijyunp_A7(){

        String pHaraikomikaisukbn = "2";
        String pMostuukakbn = "3";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 3000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(30.00, BizCurrencyTypes.EURO), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(80)
    public void testHuho2GetMosheijyunp_A8(){

        String pHaraikomikaisukbn = "2";
        String pMostuukakbn = "4";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 4000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(40.00, BizCurrencyTypes.AU_DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(90)
    public void testHuho2GetMosheijyunp_A9(){

        String pHaraikomikaisukbn = "3";
        String pMostuukakbn = "1";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 2000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(1000, BizCurrencyTypes.YEN), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(100)
    public void testHuho2GetMosheijyunp_A10(){

        String pHaraikomikaisukbn = "3";
        String pMostuukakbn = "2";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 2000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(20.00, BizCurrencyTypes.DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(110)
    public void testHuho2GetMosheijyunp_A11(){

        String pHaraikomikaisukbn = "3";
        String pMostuukakbn = "3";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 3000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(30.00, BizCurrencyTypes.EURO), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(120)
    public void testHuho2GetMosheijyunp_A12(){

        String pHaraikomikaisukbn = "3";
        String pMostuukakbn = "4";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 4000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(40.00, BizCurrencyTypes.AU_DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(130)
    public void testHuho2GetMosheijyunp_A13(){

        String pHaraikomikaisukbn = "4";
        String pMostuukakbn = "1";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 2000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(140)
    public void testHuho2GetMosheijyunp_A14(){

        String pHaraikomikaisukbn = "4";
        String pMostuukakbn = "2";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 2000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(150)
    public void testHuho2GetMosheijyunp_A15(){

        String pHaraikomikaisukbn = "4";
        String pMostuukakbn = "3";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 3000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.EURO), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(160)
    public void testHuho2GetMosheijyunp_A16(){

        String pHaraikomikaisukbn = "4";
        String pMostuukakbn = "4";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 4000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.AU_DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(170)
    public void testHuho2GetMosheijyunp_A17(){

        String pHaraikomikaisukbn = "1";
        String pMostuukakbn = "0";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 2000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(180)
    public void testHuho2GetMosheijyunp_A18(){

        String pHaraikomikaisukbn = "1";
        String pMostuukakbn = "1";
        Long pEnkamosp = 0l;
        Long pGaikamosp = 2000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(190)
    public void testHuho2GetMosheijyunp_A19(){

        String pHaraikomikaisukbn = "1";
        String pMostuukakbn = "1";
        Long pEnkamosp = null;
        Long pGaikamosp = 2000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(200)
    public void testHuho2GetMosheijyunp_A20(){

        String pHaraikomikaisukbn = "1";
        String pMostuukakbn = "2";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 0l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(210)
    public void testHuho2GetMosheijyunp_A21(){

        String pHaraikomikaisukbn = "1";
        String pMostuukakbn = "2";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = null;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(220)
    public void testHuho2GetMosheijyunp_A22(){

        String pHaraikomikaisukbn = "1";
        String pMostuukakbn = "3";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 0l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.EURO), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(230)
    public void testHuho2GetMosheijyunp_A23(){

        String pHaraikomikaisukbn = "1";
        String pMostuukakbn = "3";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = null;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.EURO), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(240)
    public void testHuho2GetMosheijyunp_A24(){

        String pHaraikomikaisukbn = "1";
        String pMostuukakbn = "4";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 0l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.AU_DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(250)
    public void testHuho2GetMosheijyunp_A25(){

        String pHaraikomikaisukbn = "1";
        String pMostuukakbn = "4";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = null;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.AU_DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(260)
    public void testHuho2GetMosheijyunp_A26(){

        String pHaraikomikaisukbn = "2";
        String pMostuukakbn = "0";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 2000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(270)
    public void testHuho2GetMosheijyunp_A27(){

        String pHaraikomikaisukbn = "2";
        String pMostuukakbn = "1";
        Long pEnkamosp = 0l;
        Long pGaikamosp = 2000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(280)
    public void testHuho2GetMosheijyunp_A28(){

        String pHaraikomikaisukbn = "2";
        String pMostuukakbn = "1";
        Long pEnkamosp = null;
        Long pGaikamosp = 2000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(290)
    public void testHuho2GetMosheijyunp_A29(){

        String pHaraikomikaisukbn = "2";
        String pMostuukakbn = "2";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 0l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(300)
    public void testHuho2GetMosheijyunp_A30(){

        String pHaraikomikaisukbn = "2";
        String pMostuukakbn = "2";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = null;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(310)
    public void testHuho2GetMosheijyunp_A31(){

        String pHaraikomikaisukbn = "2";
        String pMostuukakbn = "3";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 0l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.EURO), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(320)
    public void testHuho2GetMosheijyunp_A32(){

        String pHaraikomikaisukbn = "2";
        String pMostuukakbn = "3";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = null;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.EURO), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(330)
    public void testHuho2GetMosheijyunp_A33(){

        String pHaraikomikaisukbn = "2";
        String pMostuukakbn = "4";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 0l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.AU_DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(340)
    public void testHuho2GetMosheijyunp_A34(){

        String pHaraikomikaisukbn = "2";
        String pMostuukakbn = "4";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = null;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.AU_DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(350)
    public void testHuho2GetMosheijyunp_A35(){

        String pHaraikomikaisukbn = "3";
        String pMostuukakbn = "0";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 2000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.YEN), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(360)
    public void testHuho2GetMosheijyunp_A36(){

        String pHaraikomikaisukbn = "3";
        String pMostuukakbn = "1";
        Long pEnkamosp = 0l;
        Long pGaikamosp = 2000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(370)
    public void testHuho2GetMosheijyunp_A37(){

        String pHaraikomikaisukbn = "3";
        String pMostuukakbn = "1";
        Long pEnkamosp = null;
        Long pGaikamosp = 2000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(380)
    public void testHuho2GetMosheijyunp_A38(){

        String pHaraikomikaisukbn = "3";
        String pMostuukakbn = "2";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 0l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(390)
    public void testHuho2GetMosheijyunp_A39(){

        String pHaraikomikaisukbn = "3";
        String pMostuukakbn = "2";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = null;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(400)
    public void testHuho2GetMosheijyunp_A40(){

        String pHaraikomikaisukbn = "3";
        String pMostuukakbn = "3";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 0l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.EURO), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(410)
    public void testHuho2GetMosheijyunp_A41(){

        String pHaraikomikaisukbn = "3";
        String pMostuukakbn = "3";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = null;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.EURO), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(420)
    public void testHuho2GetMosheijyunp_A42(){

        String pHaraikomikaisukbn = "3";
        String pMostuukakbn = "4";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 0l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.AU_DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(430)
    public void testHuho2GetMosheijyunp_A43(){

        String pHaraikomikaisukbn = "3";
        String pMostuukakbn = "4";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = null;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.AU_DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(440)
    public void testHuho2GetMosheijyunp_A44(){

        String pHaraikomikaisukbn = "4";
        String pMostuukakbn = "0";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 2000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(450)
    public void testHuho2GetMosheijyunp_A45(){

        String pHaraikomikaisukbn = "4";
        String pMostuukakbn = "1";
        Long pEnkamosp = 0l;
        Long pGaikamosp = 2000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(460)
    public void testHuho2GetMosheijyunp_A46(){

        String pHaraikomikaisukbn = "4";
        String pMostuukakbn = "1";
        Long pEnkamosp = null;
        Long pGaikamosp = 2000l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(470)
    public void testHuho2GetMosheijyunp_A47(){

        String pHaraikomikaisukbn = "4";
        String pMostuukakbn = "2";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 0l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(480)
    public void testHuho2GetMosheijyunp_A48(){

        String pHaraikomikaisukbn = "4";
        String pMostuukakbn = "2";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = null;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(490)
    public void testHuho2GetMosheijyunp_A49(){

        String pHaraikomikaisukbn = "4";
        String pMostuukakbn = "3";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 0l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.EURO), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(500)
    public void testHuho2GetMosheijyunp_A50(){

        String pHaraikomikaisukbn = "4";
        String pMostuukakbn = "3";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = null;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.EURO), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(510)
    public void testHuho2GetMosheijyunp_A51(){

        String pHaraikomikaisukbn = "4";
        String pMostuukakbn = "4";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = 0l;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.AU_DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }

    @Test
    @TestOrder(520)
    public void testHuho2GetMosheijyunp_A52(){

        String pHaraikomikaisukbn = "4";
        String pMostuukakbn = "4";
        Long pEnkamosp = 1000l;
        Long pGaikamosp = null;
        BizCurrency huho2Mosheijyunp = editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pHaraikomikaisukbn, pMostuukakbn, pEnkamosp, pGaikamosp);
        exBizCalcbleEquals(huho2Mosheijyunp, BizCurrency.valueOf(0.00, BizCurrencyTypes.AU_DOLLAR), "普保Ⅱ申込平準払Ｐ");
    }
}
