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
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#mossyukykpSyutoku()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_mossyukykpSyutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testMossyukykpSyutoku_A1(){

        String pMostuukakbn = "1";
        Long pMoshokenryou = 1000l;
        Long pGaikamoshokenryou = 2000l;
        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.mossyukykpSyutoku(pMostuukakbn, pMoshokenryou,
            pGaikamoshokenryou);
        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(1000, BizCurrencyTypes.YEN), "申込主契約・特約Ｐ");
    }

    @Test
    @TestOrder(20)
    public void testMossyukykpSyutoku_A2(){

        String pMostuukakbn = "2";
        Long pMoshokenryou = 1000l;
        Long pGaikamoshokenryou = 2000l;
        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.mossyukykpSyutoku(pMostuukakbn, pMoshokenryou,
            pGaikamoshokenryou);
        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(20.00, BizCurrencyTypes.DOLLAR), "申込主契約・特約Ｐ");
    }

    @Test
    @TestOrder(30)
    public void testMossyukykpSyutoku_A3(){

        String pMostuukakbn = "3";
        Long pMoshokenryou = 1000l;
        Long pGaikamoshokenryou = 3000l;
        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.mossyukykpSyutoku(pMostuukakbn, pMoshokenryou,
            pGaikamoshokenryou);
        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(30.00, BizCurrencyTypes.EURO), "申込主契約・特約Ｐ");
    }

    @Test
    @TestOrder(40)
    public void testMossyukykpSyutoku_A4(){

        String pMostuukakbn = "4";
        Long pMoshokenryou = 1000l;
        Long pGaikamoshokenryou = 4000l;
        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.mossyukykpSyutoku(pMostuukakbn, pMoshokenryou,
            pGaikamoshokenryou);
        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(40.00, BizCurrencyTypes.AU_DOLLAR), "申込主契約・特約Ｐ");
    }

    @Test
    @TestOrder(50)
    public void testMossyukykpSyutoku_A5(){

        String pMostuukakbn = "0";
        Long pMoshokenryou = 1000l;
        Long pGaikamoshokenryou = 2000l;
        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.mossyukykpSyutoku(pMostuukakbn, pMoshokenryou,
            pGaikamoshokenryou);
        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "申込主契約・特約Ｐ");
    }

    @Test
    @TestOrder(60)
    public void testMossyukykpSyutoku_A6(){

        String pMostuukakbn = "1";
        Long pMoshokenryou = 0l;
        Long pGaikamoshokenryou = 2000l;
        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.mossyukykpSyutoku(pMostuukakbn, pMoshokenryou,
            pGaikamoshokenryou);
        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "申込主契約・特約Ｐ");
    }

    @Test
    @TestOrder(70)
    public void testMossyukykpSyutoku_A7(){

        String pMostuukakbn = "1";
        Long pMoshokenryou = null;
        Long pGaikamoshokenryou = 2000l;
        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.mossyukykpSyutoku(pMostuukakbn, pMoshokenryou,
            pGaikamoshokenryou);
        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "申込主契約・特約Ｐ");
    }

    @Test
    @TestOrder(80)
    public void testMossyukykpSyutoku_A8(){

        String pMostuukakbn = "2";
        Long pMoshokenryou = 1000l;
        Long pGaikamoshokenryou = 0l;
        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.mossyukykpSyutoku(pMostuukakbn, pMoshokenryou,
            pGaikamoshokenryou);
        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "申込主契約・特約Ｐ");
    }

    @Test
    @TestOrder(90)
    public void testMossyukykpSyutoku_A9(){

        String pMostuukakbn = "2";
        Long pMoshokenryou = 1000l;
        Long pGaikamoshokenryou = null;
        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.mossyukykpSyutoku(pMostuukakbn, pMoshokenryou,
            pGaikamoshokenryou);
        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "申込主契約・特約Ｐ");
    }

    @Test
    @TestOrder(100)
    public void testMossyukykpSyutoku_A10(){

        String pMostuukakbn = "3";
        Long pMoshokenryou = 1000l;
        Long pGaikamoshokenryou = 0l;
        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.mossyukykpSyutoku(pMostuukakbn, pMoshokenryou,
            pGaikamoshokenryou);
        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(0.00, BizCurrencyTypes.EURO), "申込主契約・特約Ｐ");
    }

    @Test
    @TestOrder(110)
    public void testMossyukykpSyutoku_A11(){

        String pMostuukakbn = "3";
        Long pMoshokenryou = 1000l;
        Long pGaikamoshokenryou = null;
        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.mossyukykpSyutoku(pMostuukakbn, pMoshokenryou,
            pGaikamoshokenryou);
        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(0.00, BizCurrencyTypes.EURO), "申込主契約・特約Ｐ");
    }

    @Test
    @TestOrder(120)
    public void testMossyukykpSyutoku_A12(){

        String pMostuukakbn = "4";
        Long pMoshokenryou = 1000l;
        Long pGaikamoshokenryou = 0l;
        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.mossyukykpSyutoku(pMostuukakbn, pMoshokenryou,
            pGaikamoshokenryou);
        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(0.00, BizCurrencyTypes.AU_DOLLAR), "申込主契約・特約Ｐ");
    }

    @Test
    @TestOrder(130)
    public void testMossyukykpSyutoku_A13(){

        String pMostuukakbn = "4";
        Long pMoshokenryou = 1000l;
        Long pGaikamoshokenryou = null;
        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.mossyukykpSyutoku(pMostuukakbn, pMoshokenryou,
            pGaikamoshokenryou);
        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(0.00, BizCurrencyTypes.AU_DOLLAR), "申込主契約・特約Ｐ");
    }
}
