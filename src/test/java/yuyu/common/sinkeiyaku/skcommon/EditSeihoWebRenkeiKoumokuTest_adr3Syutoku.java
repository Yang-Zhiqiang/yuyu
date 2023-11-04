package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#adr3Syutoku()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_adr3Syutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testAdr3Syutoku_A1(){

        String pAdr = "住所住所住所住所住所住所住所住所住所住所住所住所住所住所住所"
            + "東京東京東京東京東京東京東京東京東京東京東京東京東京東京東";
        String adr = editSeihoWebRenkeiKoumoku.adr3Syutoku(pAdr);
        exStringEquals(adr, "", "住所３");
    }


    @Test
    @TestOrder(20)
    public void testAdr3Syutoku_A2(){

        String pAdr = "住所住所住所住所住所住所住所住所住所住所住所住所住所住所住所"
            + "東京東京東京東京東京東京東京東京東京東京東京東京東京東京東京";
        String adr = editSeihoWebRenkeiKoumoku.adr3Syutoku(pAdr);
        exStringEquals(adr, "", "住所３");
    }


    @Test
    @TestOrder(30)
    public void testAdr3Syutoku_A3(){

        String pAdr = "住所住所住所住所住所住所住所住所住所住所住所住所住所住所住所"
            + "東京東京東京東京東京東京東京東京東京東京東京東京東京東京東京東";
        String adr = editSeihoWebRenkeiKoumoku.adr3Syutoku(pAdr);
        exStringEquals(adr, "東", "住所３");
    }

    @Test
    @TestOrder(40)
    public void testAdr3Syutoku_A4(){

        String pAdr = "住所住所住所住所住所住所住所住所住所住所住所住所住所住所住所"
            + "東京東京東京東京東京東京東京東京東京東京東京東京東京東京東京東京";
        String adr = editSeihoWebRenkeiKoumoku.adr3Syutoku(pAdr);
        exStringEquals(adr, "東京", "住所３");
    }

    @Test
    @TestOrder(50)
    public void testAdr3Syutoku_A5(){

        String pAdr = "住所住所住所住所住所住所住所住所住所住所住所住所住所住所住所"
            + "東京東京東京東京東京東京東京東京東京東京東京東京東京東京東京東京東";
        String adr = editSeihoWebRenkeiKoumoku.adr3Syutoku(pAdr);
        exStringEquals(adr, "東京", "住所３");
    }
}
