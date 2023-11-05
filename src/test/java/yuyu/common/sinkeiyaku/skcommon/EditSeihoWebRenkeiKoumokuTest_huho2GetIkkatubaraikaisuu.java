package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#huho2GetIkkatubaraikaisuu()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_huho2GetIkkatubaraikaisuu {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testHuho2GetIkkatubaraikaisuu_A1(){

        String pIkkatubaraikaisuu = "00";
        C_IkkatubaraiKaisuuKbn huho2Ikkatubaraikaisuu = editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikaisuu(pIkkatubaraikaisuu);
        exClassificationEquals(huho2Ikkatubaraikaisuu, C_IkkatubaraiKaisuuKbn.BLNK, "普保Ⅱ一括払回数");
    }

    @Test
    @TestOrder(20)
    public void testHuho2GetIkkatubaraikaisuu_A2(){

        String pIkkatubaraikaisuu = "02";
        C_IkkatubaraiKaisuuKbn huho2Ikkatubaraikaisuu = editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikaisuu(pIkkatubaraikaisuu);
        exClassificationEquals(huho2Ikkatubaraikaisuu, C_IkkatubaraiKaisuuKbn.IKKATU2, "普保Ⅱ一括払回数");
    }

    @Test
    @TestOrder(30)
    public void testHuho2GetIkkatubaraikaisuu_A3(){

        String pIkkatubaraikaisuu = "03";
        C_IkkatubaraiKaisuuKbn huho2Ikkatubaraikaisuu = editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikaisuu(pIkkatubaraikaisuu);
        exClassificationEquals(huho2Ikkatubaraikaisuu, C_IkkatubaraiKaisuuKbn.IKKATU3, "普保Ⅱ一括払回数");
    }

    @Test
    @TestOrder(40)
    public void testHuho2GetIkkatubaraikaisuu_A4(){

        String pIkkatubaraikaisuu = "04";
        C_IkkatubaraiKaisuuKbn huho2Ikkatubaraikaisuu = editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikaisuu(pIkkatubaraikaisuu);
        exClassificationEquals(huho2Ikkatubaraikaisuu, C_IkkatubaraiKaisuuKbn.IKKATU4, "普保Ⅱ一括払回数");
    }

    @Test
    @TestOrder(50)
    public void testHuho2GetIkkatubaraikaisuu_A5(){

        String pIkkatubaraikaisuu = "05";
        C_IkkatubaraiKaisuuKbn huho2Ikkatubaraikaisuu = editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikaisuu(pIkkatubaraikaisuu);
        exClassificationEquals(huho2Ikkatubaraikaisuu, C_IkkatubaraiKaisuuKbn.IKKATU5, "普保Ⅱ一括払回数");
    }

    @Test
    @TestOrder(60)
    public void testHuho2GetIkkatubaraikaisuu_A6(){

        String pIkkatubaraikaisuu = "06";
        C_IkkatubaraiKaisuuKbn huho2Ikkatubaraikaisuu = editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikaisuu(pIkkatubaraikaisuu);
        exClassificationEquals(huho2Ikkatubaraikaisuu, C_IkkatubaraiKaisuuKbn.IKKATU6, "普保Ⅱ一括払回数");
    }

    @Test
    @TestOrder(70)
    public void testHuho2GetIkkatubaraikaisuu_A7(){

        String pIkkatubaraikaisuu = "07";
        C_IkkatubaraiKaisuuKbn huho2Ikkatubaraikaisuu = editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikaisuu(pIkkatubaraikaisuu);
        exClassificationEquals(huho2Ikkatubaraikaisuu, C_IkkatubaraiKaisuuKbn.IKKATU7, "普保Ⅱ一括払回数");
    }

    @Test
    @TestOrder(80)
    public void testHuho2GetIkkatubaraikaisuu_A8(){

        String pIkkatubaraikaisuu = "08";
        C_IkkatubaraiKaisuuKbn huho2Ikkatubaraikaisuu = editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikaisuu(pIkkatubaraikaisuu);
        exClassificationEquals(huho2Ikkatubaraikaisuu, C_IkkatubaraiKaisuuKbn.IKKATU8, "普保Ⅱ一括払回数");
    }

    @Test
    @TestOrder(90)
    public void testHuho2GetIkkatubaraikaisuu_A9(){

        String pIkkatubaraikaisuu = "09";
        C_IkkatubaraiKaisuuKbn huho2Ikkatubaraikaisuu = editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikaisuu(pIkkatubaraikaisuu);
        exClassificationEquals(huho2Ikkatubaraikaisuu, C_IkkatubaraiKaisuuKbn.IKKATU9, "普保Ⅱ一括払回数");
    }

    @Test
    @TestOrder(100)
    public void testHuho2GetIkkatubaraikaisuu_A10(){

        String pIkkatubaraikaisuu = "10";
        C_IkkatubaraiKaisuuKbn huho2Ikkatubaraikaisuu = editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikaisuu(pIkkatubaraikaisuu);
        exClassificationEquals(huho2Ikkatubaraikaisuu, C_IkkatubaraiKaisuuKbn.IKKATU10, "普保Ⅱ一括払回数");
    }

    @Test
    @TestOrder(110)
    public void testHuho2GetIkkatubaraikaisuu_A11(){

        String pIkkatubaraikaisuu = "11";
        C_IkkatubaraiKaisuuKbn huho2Ikkatubaraikaisuu = editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikaisuu(pIkkatubaraikaisuu);
        exClassificationEquals(huho2Ikkatubaraikaisuu, C_IkkatubaraiKaisuuKbn.IKKATU11, "普保Ⅱ一括払回数");
    }

    @Test
    @TestOrder(120)
    public void testHuho2GetIkkatubaraikaisuu_A12(){

        String pIkkatubaraikaisuu = "12";
        C_IkkatubaraiKaisuuKbn huho2Ikkatubaraikaisuu = editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikaisuu(pIkkatubaraikaisuu);
        exClassificationEquals(huho2Ikkatubaraikaisuu, C_IkkatubaraiKaisuuKbn.IKKATU12, "普保Ⅱ一括払回数");
    }

    @Test
    @TestOrder(130)
    public void testHuho2GetIkkatubaraikaisuu_A13(){

        String pIkkatubaraikaisuu = "01";
        C_IkkatubaraiKaisuuKbn huho2Ikkatubaraikaisuu = editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikaisuu(pIkkatubaraikaisuu);
        exClassificationEquals(huho2Ikkatubaraikaisuu, C_IkkatubaraiKaisuuKbn.BLNK, "普保Ⅱ一括払回数");
    }

}
