package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tkhukaumu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#yennykntkhkkbnSyutoku()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_yennykntkhkkbnSyutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testYennykntkhkkbnSyutoku_A1(){

        String pSiteituukakbn = "2";
        String pNykntuukakbn = "1";
        C_Tkhukaumu tkhukaumu = editSeihoWebRenkeiKoumoku.yennykntkhkkbnSyutoku(pSiteituukakbn, pNykntuukakbn);
        exClassificationEquals(tkhukaumu, C_Tkhukaumu.HUKA, "特約付加有無");
    }

    @Test
    @TestOrder(20)
    public void testYennykntkhkkbnSyutoku_A2(){

        String pSiteituukakbn = "1";
        String pNykntuukakbn = "2";
        C_Tkhukaumu tkhukaumu = editSeihoWebRenkeiKoumoku.yennykntkhkkbnSyutoku(pSiteituukakbn, pNykntuukakbn);
        exClassificationEquals(tkhukaumu, C_Tkhukaumu.NONE, "特約付加有無");
    }

    @Test
    @TestOrder(30)
    public void testYennykntkhkkbnSyutoku_A3(){

        String pSiteituukakbn = "1";
        String pNykntuukakbn = "1";
        C_Tkhukaumu tkhukaumu = editSeihoWebRenkeiKoumoku.yennykntkhkkbnSyutoku(pSiteituukakbn, pNykntuukakbn);
        exClassificationEquals(tkhukaumu, C_Tkhukaumu.BLNK, "特約付加有無");
    }
}
