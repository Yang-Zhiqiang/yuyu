package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#kakukisyouryakukbumukbnSyutoku()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_kakukisyouryakukbumukbnSyutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testKakukisyouryakukbumukbnSyutoku_A1(){

        String pTaisyoukoumokuti1 = "H9";
        String pTaisyoukoumokuti2 = "C2";
        String pTaisyoukoumokuti3 = "C3";
        String pTaisyoukoumokuti4 = "C4";
        String pTaisyoukoumokuti5 = "C5";
        C_UmuKbn umuKbn = editSeihoWebRenkeiKoumoku.kakukisyouryakukbumukbnSyutoku(pTaisyoukoumokuti1,
            pTaisyoukoumokuti2, pTaisyoukoumokuti3, pTaisyoukoumokuti4, pTaisyoukoumokuti5);
        exClassificationEquals(umuKbn, C_UmuKbn.ARI, "有無区分");
    }

    @Test
    @TestOrder(20)
    public void testKakukisyouryakukbumukbnSyutoku_A2(){

        String pTaisyoukoumokuti1 = "H1";
        String pTaisyoukoumokuti2 = "C2";
        String pTaisyoukoumokuti3 = "C3";
        String pTaisyoukoumokuti4 = "C4";
        String pTaisyoukoumokuti5 = "C5";
        C_UmuKbn umuKbn = editSeihoWebRenkeiKoumoku.kakukisyouryakukbumukbnSyutoku(pTaisyoukoumokuti1,
            pTaisyoukoumokuti2, pTaisyoukoumokuti3, pTaisyoukoumokuti4, pTaisyoukoumokuti5);
        exClassificationEquals(umuKbn, C_UmuKbn.NONE, "有無区分");
    }
}
