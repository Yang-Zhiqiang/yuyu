package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tdk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#hhkdrtdkkbnHenkan()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_hhkdrtdkkbnHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testHhkdrtdkkbnHenkan_A1(){

        String pTdkkbn = "1";

        C_Tdk tdk = editSeihoWebRenkeiKoumoku.hhkdrtdkkbnHenkan(pTdkkbn);

        exClassificationEquals(tdk, C_Tdk.HGU, "続柄");
    }

    @Test
    @TestOrder(20)
    public void testHhkdrtdkkbnHenkan_A2(){

        String pTdkkbn = "2";

        C_Tdk tdk = editSeihoWebRenkeiKoumoku.hhkdrtdkkbnHenkan(pTdkkbn);

        exClassificationEquals(tdk, C_Tdk.KO, "続柄");
    }

    @Test
    @TestOrder(30)
    public void testHhkdrtdkkbnHenkan_A3(){

        String pTdkkbn = "3";

        C_Tdk tdk = editSeihoWebRenkeiKoumoku.hhkdrtdkkbnHenkan(pTdkkbn);

        exClassificationEquals(tdk, C_Tdk.OYA, "続柄");
    }

    @Test
    @TestOrder(40)
    public void testHhkdrtdkkbnHenkan_A4(){

        String pTdkkbn = "4";

        C_Tdk tdk = editSeihoWebRenkeiKoumoku.hhkdrtdkkbnHenkan(pTdkkbn);

        exClassificationEquals(tdk, C_Tdk.MAGO, "続柄");
    }

    @Test
    @TestOrder(50)
    public void testHhkdrtdkkbnHenkan_A5(){

        String pTdkkbn = "5";

        C_Tdk tdk = editSeihoWebRenkeiKoumoku.hhkdrtdkkbnHenkan(pTdkkbn);

        exClassificationEquals(tdk, C_Tdk.SHB, "続柄");
    }

    @Test
    @TestOrder(60)
    public void testHhkdrtdkkbnHenkan_A6(){

        String pTdkkbn = "6";

        C_Tdk tdk = editSeihoWebRenkeiKoumoku.hhkdrtdkkbnHenkan(pTdkkbn);

        exClassificationEquals(tdk, C_Tdk.KYDSM, "続柄");
    }

    @Test
    @TestOrder(70)
    public void testHhkdrtdkkbnHenkan_A7(){

        String pTdkkbn = "8";

        C_Tdk tdk = editSeihoWebRenkeiKoumoku.hhkdrtdkkbnHenkan(pTdkkbn);

        exClassificationEquals(tdk, C_Tdk.SINTOU3, "続柄");
    }

    @Test
    @TestOrder(80)
    public void testHhkdrtdkkbnHenkan_A8(){

        String pTdkkbn = "9";

        C_Tdk tdk = editSeihoWebRenkeiKoumoku.hhkdrtdkkbnHenkan(pTdkkbn);

        exClassificationEquals(tdk, C_Tdk.SONOTA, "続柄");
    }

    @Test
    @TestOrder(90)
    public void testHhkdrtdkkbnHenkan_A9(){

        String pTdkkbn = "10";

        C_Tdk tdk = editSeihoWebRenkeiKoumoku.hhkdrtdkkbnHenkan(pTdkkbn);

        exClassificationEquals(tdk, C_Tdk.BLNK, "続柄");
    }
}
