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
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#kihonsSyutoku()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_kihonsSyutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testKihonsSyutoku_A1(){

        String pSiteituukakbn = "4";
        long pKihons = 1000l;
        long pGaikakihons=2000l;
        BizCurrency Kihons = editSeihoWebRenkeiKoumoku.kihonsSyutoku(pSiteituukakbn, pKihons,pGaikakihons);
        exBizCalcbleEquals(Kihons, BizCurrency.valueOf(20.00, BizCurrencyTypes.AU_DOLLAR), "基本Ｓ");
    }

    @Test
    @TestOrder(20)
    public void testKihonsSyutoku_A2(){

        String pSiteituukakbn = "1";
        long pKihons = 1000l;
        long pGaikakihons=2000l;
        BizCurrency Kihons = editSeihoWebRenkeiKoumoku.kihonsSyutoku(pSiteituukakbn, pKihons,pGaikakihons);
        exBizCalcbleEquals(Kihons, BizCurrency.valueOf(1000, BizCurrencyTypes.YEN), "基本Ｓ");
    }

    @Test
    @TestOrder(30)
    public void testKihonsSyutoku_A3() {

        String pSiteituukakbn = "2";
        long pKihons = 1000l;
        long pGaikakihons = 2000l;
        BizCurrency Kihons = editSeihoWebRenkeiKoumoku
            .kihonsSyutoku(pSiteituukakbn, pKihons, pGaikakihons);
        exBizCalcbleEquals(Kihons, BizCurrency.valueOf(20.00, BizCurrencyTypes.DOLLAR), "基本Ｓ");
    }

    @Test
    @TestOrder(40)
    public void testKihonsSyutoku_A4() {

        String pSiteituukakbn = "3";
        long pKihons = 1000l;
        long pGaikakihons = 2000l;
        BizCurrency Kihons = editSeihoWebRenkeiKoumoku
            .kihonsSyutoku(pSiteituukakbn, pKihons, pGaikakihons);
        exBizCalcbleEquals(Kihons, BizCurrency.valueOf(20.00, BizCurrencyTypes.EURO), "基本Ｓ");
    }
    @Test
    @TestOrder(50)
    public void testKihonsSyutoku_A5() {

        String pSiteituukakbn = "0";
        long pKihons = 1000l;
        long pGaikakihons = 2000l;
        BizCurrency Kihons = editSeihoWebRenkeiKoumoku
            .kihonsSyutoku(pSiteituukakbn, pKihons, pGaikakihons);
        exBizCalcbleEquals(Kihons, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "基本Ｓ");
    }
}
