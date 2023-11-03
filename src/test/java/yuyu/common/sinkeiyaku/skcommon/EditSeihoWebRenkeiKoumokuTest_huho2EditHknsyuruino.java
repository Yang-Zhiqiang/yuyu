package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#huho2EditHknsyuruino()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_huho2EditHknsyuruino {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testHuho2EditHknsyuruino_A1(){

        String hknsyuruino = "444";

        C_HknsyuruiNo huho2Hknsyuruino = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(hknsyuruino);

        exClassificationEquals(huho2Hknsyuruino, C_HknsyuruiNo.BLNK, "普保Ⅱ保険種類番号");
    }

    @Test
    @TestOrder(20)
    public void testHuho2EditHknsyuruino_A2(){

        String hknsyuruino = "321";

        C_HknsyuruiNo huho2Hknsyuruino = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(hknsyuruino);

        exClassificationEquals(huho2Hknsyuruino, C_HknsyuruiNo.GAIKAINDEXNK, "普保Ⅱ保険種類番号");
    }

    @Test
    @TestOrder(30)
    public void testHuho2EditHknsyuruino_A3(){

        String hknsyuruino = "322";

        C_HknsyuruiNo huho2Hknsyuruino = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(hknsyuruino);

        exClassificationEquals(huho2Hknsyuruino, C_HknsyuruiNo.GAIKAINDEXNK_SISUU, "普保Ⅱ保険種類番号");
    }

    @Test
    @TestOrder(40)
    public void testHuho2EditHknsyuruino_A4(){

        String hknsyuruino = "323";

        C_HknsyuruiNo huho2Hknsyuruino = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(hknsyuruino);

        exClassificationEquals(huho2Hknsyuruino, C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU, "普保Ⅱ保険種類番号");
    }

    @Test
    @TestOrder(50)
    public void testHuho2EditHknsyuruino_A5(){

        String hknsyuruino = "331";

        C_HknsyuruiNo huho2Hknsyuruino = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(hknsyuruino);

        exClassificationEquals(huho2Hknsyuruino, C_HknsyuruiNo.GAIKARIRITUHENDOUNK, "普保Ⅱ保険種類番号");
    }

    @Test
    @TestOrder(60)
    public void testHuho2EditHknsyuruino_A6(){

        String hknsyuruino = "332";

        C_HknsyuruiNo huho2Hknsyuruino = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(hknsyuruino);

        exClassificationEquals(huho2Hknsyuruino, C_HknsyuruiNo.GAIKARIRITUHENDOUNK, "普保Ⅱ保険種類番号");
    }

    @Test
    @TestOrder(70)
    public void testHuho2EditHknsyuruino_A7(){

        String hknsyuruino = "123";

        C_HknsyuruiNo huho2Hknsyuruino = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(hknsyuruino);

        exClassificationEquals(huho2Hknsyuruino, C_HknsyuruiNo.BLNK, "普保Ⅱ保険種類番号");
    }

    @Test
    @TestOrder(80)
    public void testHuho2EditHknsyuruino_A8(){

        String hknsyuruino = "12";

        C_HknsyuruiNo huho2Hknsyuruino = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(hknsyuruino);

        exClassificationEquals(huho2Hknsyuruino, C_HknsyuruiNo.BLNK, "普保Ⅱ保険種類番号");
    }

    @Test
    @TestOrder(90)
    public void testHuho2EditHknsyuruino_A9(){

        String hknsyuruino = "1234";

        C_HknsyuruiNo huho2Hknsyuruino = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(hknsyuruino);

        exClassificationEquals(huho2Hknsyuruino, C_HknsyuruiNo.BLNK, "普保Ⅱ保険種類番号");
    }

    @Test
    @TestOrder(100)
    public void testHuho2EditHknsyuruino_A10(){

        String hknsyuruino = "445";

        C_HknsyuruiNo huho2Hknsyuruino = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(hknsyuruino);

        exClassificationEquals(huho2Hknsyuruino, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI, "普保Ⅱ保険種類番号");
    }

    @Test
    @TestOrder(110)
    public void testHuho2EditHknsyuruino_A11(){

        String hknsyuruino = "446";

        C_HknsyuruiNo huho2Hknsyuruino = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(hknsyuruino);

        exClassificationEquals(huho2Hknsyuruino, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGNASI, "普保Ⅱ保険種類番号");
    }

    @Test
    @TestOrder(120)
    public void testHuho2EditHknsyuruino_A12(){

        String hknsyuruino = "324";

        C_HknsyuruiNo huho2Hknsyuruino = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(hknsyuruino);

        exClassificationEquals(huho2Hknsyuruino, C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU, "普保Ⅱ保険種類番号");
    }

    @Test
    @TestOrder(130)
    public void testHuho2EditHknsyuruino_A13(){

        String hknsyuruino = "325";

        C_HknsyuruiNo huho2Hknsyuruino = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(hknsyuruino);

        exClassificationEquals(huho2Hknsyuruino, C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI, "普保Ⅱ保険種類番号");
    }

    @Test
    @TestOrder(140)
    public void testHuho2EditHknsyuruino_A14(){

        String hknsyuruino = "326";

        C_HknsyuruiNo huho2Hknsyuruino = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(hknsyuruino);

        exClassificationEquals(huho2Hknsyuruino, C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI, "普保Ⅱ保険種類番号");
    }
    @Test
    @TestOrder(150)
    public void testHuho2EditHknsyuruino_A15(){

        String hknsyuruino = "357";

        C_HknsyuruiNo huho2Hknsyuruino = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(hknsyuruino);

        exClassificationEquals(huho2Hknsyuruino, C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT, "普保Ⅱ保険種類番号");
    }

    @Test
    @TestOrder(160)
    public void testHuho2EditHknsyuruino_A16(){

        String hknsyuruino = "358";

        C_HknsyuruiNo huho2Hknsyuruino = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(hknsyuruino);

        exClassificationEquals(huho2Hknsyuruino, C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT , "普保Ⅱ保険種類番号");
    }
}
