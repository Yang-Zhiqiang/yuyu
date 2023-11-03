package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#adr1Syutoku()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_adr1Syutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testAdr1Syutoku_A1(){

        String pAdr = "住所住所住所住所住所住所住所住所住所住所住所住所住所住所住";
        String adr = editSeihoWebRenkeiKoumoku.adr1Syutoku(pAdr);
        exStringEquals(adr, "住所住所住所住所住所住所住所住所住所住所住所住所住所住所住", "住所１");
    }

    @Test
    @TestOrder(20)
    public void testAdr1Syutoku_A2(){

        String pAdr = "住所住所住所住所住所住所住所住所住所住所住所住所住所住所住所";
        String adr = editSeihoWebRenkeiKoumoku.adr1Syutoku(pAdr);
        exStringEquals(adr, "住所住所住所住所住所住所住所住所住所住所住所住所住所住所住所", "住所１");
    }

    @Test
    @TestOrder(30)
    public void testAdr1Syutoku_A3(){

        String pAdr = "住所住所住所住所住所住所住所住所住所住所住所住所住所住所住所住";
        String adr = editSeihoWebRenkeiKoumoku.adr1Syutoku(pAdr);
        exStringEquals(adr, "住所住所住所住所住所住所住所住所住所住所住所住所住所住所住所", "住所１");
    }
}
