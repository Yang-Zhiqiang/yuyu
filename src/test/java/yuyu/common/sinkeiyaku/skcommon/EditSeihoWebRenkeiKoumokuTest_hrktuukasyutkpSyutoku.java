package yuyu.common.sinkeiyaku.skcommon;

import javax.inject.Inject;

import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#hrktuukasyutkpSyutoku()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_hrktuukasyutkpSyutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    //    @Test
    //    @TestOrder(10)
    //    public void testHrktuukasyutkpSyutoku_A1(){
    //
    //        String pNykntuukakbn = "1";
    //        Long pNykntuukanykngk = 1000l;
    //        Long pGaikanykntuukanykngk = 2000l;
    //        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.hrktuukasyutkpSyutoku(pNykntuukakbn, pNykntuukanykngk,
    //            pGaikanykntuukanykngk);
    //        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(1000, BizCurrencyTypes.YEN), "払込通貨主契約・特約Ｐ");
    //    }
    //
    //    @Test
    //    @TestOrder(20)
    //    public void testHrktuukasyutkpSyutoku_A2(){
    //
    //        String pNykntuukakbn = "2";
    //        Long pNykntuukanykngk = 1000l;
    //        Long pGaikanykntuukanykngk = 2000l;
    //        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.hrktuukasyutkpSyutoku(pNykntuukakbn, pNykntuukanykngk,
    //            pGaikanykntuukanykngk);
    //        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(20.00, BizCurrencyTypes.DOLLAR), "払込通貨主契約・特約Ｐ");
    //    }
    //
    //    @Test
    //    @TestOrder(30)
    //    public void testHrktuukasyutkpSyutoku_A3(){
    //
    //        String pNykntuukakbn = "3";
    //        Long pNykntuukanykngk = 1000l;
    //        Long pGaikanykntuukanykngk = 3000l;
    //        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.hrktuukasyutkpSyutoku(pNykntuukakbn, pNykntuukanykngk,
    //            pGaikanykntuukanykngk);
    //        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(30.00, BizCurrencyTypes.EURO), "払込通貨主契約・特約Ｐ");
    //    }
    //
    //    @Test
    //    @TestOrder(40)
    //    public void testHrktuukasyutkpSyutoku_A4(){
    //
    //        String pNykntuukakbn = "4";
    //        Long pNykntuukanykngk = 1000l;
    //        Long pGaikanykntuukanykngk = 4000l;
    //        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.hrktuukasyutkpSyutoku(pNykntuukakbn, pNykntuukanykngk,
    //            pGaikanykntuukanykngk);
    //        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(40.00, BizCurrencyTypes.AU_DOLLAR), "払込通貨主契約・特約Ｐ");
    //    }
    //
    //    @Test
    //    @TestOrder(50)
    //    public void testHrktuukasyutkpSyutoku_A5(){
    //
    //        String pNykntuukakbn = "0";
    //        Long pNykntuukanykngk = 1000l;
    //        Long pGaikanykntuukanykngk = 2000l;
    //        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.hrktuukasyutkpSyutoku(pNykntuukakbn, pNykntuukanykngk,
    //            pGaikanykntuukanykngk);
    //        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "払込通貨主契約・特約Ｐ");
    //    }
    //
    //    @Test
    //    @TestOrder(60)
    //    public void testHrktuukasyutkpSyutoku_A6(){
    //
    //        String pNykntuukakbn = "1";
    //        Long pNykntuukanykngk = 0l;
    //        Long pGaikanykntuukanykngk = 2000l;
    //        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.hrktuukasyutkpSyutoku(pNykntuukakbn, pNykntuukanykngk,
    //            pGaikanykntuukanykngk);
    //        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "払込通貨主契約・特約Ｐ");
    //    }
    //
    //    @Test
    //    @TestOrder(70)
    //    public void testHrktuukasyutkpSyutoku_A7(){
    //
    //        String pNykntuukakbn = "1";
    //        Long pNykntuukanykngk = null;
    //        Long pGaikanykntuukanykngk = 2000l;
    //        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.hrktuukasyutkpSyutoku(pNykntuukakbn, pNykntuukanykngk,
    //            pGaikanykntuukanykngk);
    //        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "払込通貨主契約・特約Ｐ");
    //    }
    //
    //    @Test
    //    @TestOrder(80)
    //    public void testHrktuukasyutkpSyutoku_A8(){
    //
    //        String pNykntuukakbn = "2";
    //        Long pNykntuukanykngk = 1000l;
    //        Long pGaikanykntuukanykngk = 0l;
    //        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.hrktuukasyutkpSyutoku(pNykntuukakbn, pNykntuukanykngk,
    //            pGaikanykntuukanykngk);
    //        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "払込通貨主契約・特約Ｐ");
    //    }
    //
    //    @Test
    //    @TestOrder(90)
    //    public void testHrktuukasyutkpSyutoku_A9(){
    //
    //        String pNykntuukakbn = "2";
    //        Long pNykntuukanykngk = 1000l;
    //        Long pGaikanykntuukanykngk = null;
    //        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.hrktuukasyutkpSyutoku(pNykntuukakbn, pNykntuukanykngk,
    //            pGaikanykntuukanykngk);
    //        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "払込通貨主契約・特約Ｐ");
    //    }
    //
    //    @Test
    //    @TestOrder(100)
    //    public void testHrktuukasyutkpSyutoku_A10(){
    //
    //        String pNykntuukakbn = "3";
    //        Long pNykntuukanykngk = 1000l;
    //        Long pGaikanykntuukanykngk = 0l;
    //        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.hrktuukasyutkpSyutoku(pNykntuukakbn, pNykntuukanykngk,
    //            pGaikanykntuukanykngk);
    //        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(0.00, BizCurrencyTypes.EURO), "払込通貨主契約・特約Ｐ");
    //    }
    //
    //    @Test
    //    @TestOrder(110)
    //    public void testHrktuukasyutkpSyutoku_A11(){
    //
    //        String pNykntuukakbn = "3";
    //        Long pNykntuukanykngk = 1000l;
    //        Long pGaikanykntuukanykngk = null;
    //        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.hrktuukasyutkpSyutoku(pNykntuukakbn, pNykntuukanykngk,
    //            pGaikanykntuukanykngk);
    //        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(0.00, BizCurrencyTypes.EURO), "払込通貨主契約・特約Ｐ");
    //    }
    //
    //    @Test
    //    @TestOrder(120)
    //    public void testHrktuukasyutkpSyutoku_A12(){
    //
    //        String pNykntuukakbn = "4";
    //        Long pNykntuukanykngk = 1000l;
    //        Long pGaikanykntuukanykngk = 0l;
    //        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.hrktuukasyutkpSyutoku(pNykntuukakbn, pNykntuukanykngk,
    //            pGaikanykntuukanykngk);
    //        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(0.00, BizCurrencyTypes.AU_DOLLAR), "払込通貨主契約・特約Ｐ");
    //    }
    //
    //    @Test
    //    @TestOrder(130)
    //    public void testHrktuukasyutkpSyutoku_A13(){
    //
    //        String pNykntuukakbn = "4";
    //        Long pNykntuukanykngk = 1000l;
    //        Long pGaikanykntuukanykngk = null;
    //        BizCurrency hrktuukasyutkp = editSeihoWebRenkeiKoumoku.hrktuukasyutkpSyutoku(pNykntuukakbn, pNykntuukanykngk,
    //            pGaikanykntuukanykngk);
    //        exBizCalcbleEquals(hrktuukasyutkp, BizCurrency.valueOf(null, BizCurrencyTypes.AU_DOLLAR), "払込通貨主契約・特約Ｐ");
    //    }
}
