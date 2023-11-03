package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#hrkkknsmnkbnSyutoku()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_hrkkknsmnkbnSyutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testHrkkknsmnkbnSyutoku_A1(){

        C_HknsyuruiNo pHknsyuruino = C_HknsyuruiNo.GAIKARIRITUHENDOUNK;
        Integer pPhrkkikn = 0;
        C_HrkkknsmnKbn hrkkknsmnKbn = editSeihoWebRenkeiKoumoku.hrkkknsmnkbnSyutoku(pHknsyuruino, pPhrkkikn);
        exClassificationEquals(hrkkknsmnKbn, C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");
    }

    @Test
    @TestOrder(20)
    public void testHrkkknsmnkbnSyutoku_A2(){

        C_HknsyuruiNo pHknsyuruino = C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT;
        Integer pPhrkkikn = 0;
        C_HrkkknsmnKbn hrkkknsmnKbn = editSeihoWebRenkeiKoumoku.hrkkknsmnkbnSyutoku(pHknsyuruino, pPhrkkikn);
        exClassificationEquals(hrkkknsmnKbn,  C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");
    }
    @Test
    @TestOrder(30)
    public void testHrkkknsmnkbnSyutoku_A3(){

        C_HknsyuruiNo pHknsyuruino = C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT;
        Integer pPhrkkikn = 0;
        C_HrkkknsmnKbn hrkkknsmnKbn = editSeihoWebRenkeiKoumoku.hrkkknsmnkbnSyutoku(pHknsyuruino, pPhrkkikn);
        exClassificationEquals(hrkkknsmnKbn,  C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");
    }
    @Test
    @TestOrder(40)
    public void testHrkkknsmnkbnSyutoku_A4(){

        C_HknsyuruiNo pHknsyuruino = C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI;
        Integer pPhrkkikn = 0;
        C_HrkkknsmnKbn hrkkknsmnKbn = editSeihoWebRenkeiKoumoku.hrkkknsmnkbnSyutoku(pHknsyuruino, pPhrkkikn);
        exClassificationEquals(hrkkknsmnKbn,  C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");
    }
}
