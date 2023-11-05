package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#adr2Syutoku()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_adr2Syutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testAdr2Syutoku_A1(){

        String pAdr = "住所住所住所住所住所住所住所住所住所住所住所住所住所住所住";
        String adr = editSeihoWebRenkeiKoumoku.adr2Syutoku(pAdr);
        exStringEquals(adr, "", "住所２");
    }

    @Test
    @TestOrder(20)
    public void testAdr2Syutoku_A2(){

        String pAdr = "住所住所住所住所住所住所住所住所住所住所住所住所住所住所住所";
        String adr = editSeihoWebRenkeiKoumoku.adr2Syutoku(pAdr);
        exStringEquals(adr, "", "住所２");
    }

    @Test
    @TestOrder(30)
    public void testAdr2Syutoku_A3(){

        String pAdr = "住所住所住所住所住所住所住所住所住所住所住所住所住所住所住所"
            + "東京東京東京東京東京東京東京東京東京東京東京東京東京東京東";
        String adr = editSeihoWebRenkeiKoumoku.adr2Syutoku(pAdr);
        exStringEquals(adr, "東京東京東京東京東京東京東京東京東京東京東京東京東京東京東", "住所２");
    }

    @Test
    @TestOrder(20)
    public void testAdr2Syutoku_A4(){

        String pAdr = "住所住所住所住所住所住所住所住所住所住所住所住所住所住所住所"
            + "東京東京東京東京東京東京東京東京東京東京東京東京東京東京東京";
        String adr = editSeihoWebRenkeiKoumoku.adr2Syutoku(pAdr);
        exStringEquals(adr, "東京東京東京東京東京東京東京東京東京東京東京東京東京東京東京", "住所２");
    }

    @Test
    @TestOrder(50)
    public void testAdr2Syutoku_A5(){

        String pAdr = "住所住所住所住所住所住所住所住所住所住所住所住所住所住所住所"
            + "東京東京東京東京東京東京東京東京東京東京東京東京東京東京東京東";
        String adr = editSeihoWebRenkeiKoumoku.adr2Syutoku(pAdr);
        exStringEquals(adr, "東京東京東京東京東京東京東京東京東京東京東京東京東京東京東京", "住所２");
    }
}
