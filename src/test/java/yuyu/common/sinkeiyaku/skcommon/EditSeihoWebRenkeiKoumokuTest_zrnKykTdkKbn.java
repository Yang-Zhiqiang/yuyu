package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tdk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#zrnKykTdkKbn()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_zrnKykTdkKbn {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testZrnKykTdkKbn_A1(){

        String pZrnkyktdkkbn = "0";
        C_Tdk tdk = editSeihoWebRenkeiKoumoku.zrnKykTdkKbn(pZrnkyktdkkbn);
        exClassificationEquals(tdk, C_Tdk.BLNK, "契約者続柄");
    }

    @Test
    @TestOrder(20)
    public void testZrnKykTdkKbn_A2(){

        String pZrnkyktdkkbn = "1";
        C_Tdk tdk = editSeihoWebRenkeiKoumoku.zrnKykTdkKbn(pZrnkyktdkkbn);
        exClassificationEquals(tdk, C_Tdk.HGU, "契約者続柄");
    }

    @Test
    @TestOrder(30)
    public void testZrnKykTdkKbn_A3(){

        String pZrnkyktdkkbn = "2";
        C_Tdk tdk = editSeihoWebRenkeiKoumoku.zrnKykTdkKbn(pZrnkyktdkkbn);
        exClassificationEquals(tdk, C_Tdk.KO, "契約者続柄");
    }

    @Test
    @TestOrder(40)
    public void testZrnKykTdkKbn_A4(){

        String pZrnkyktdkkbn = "3";
        C_Tdk tdk = editSeihoWebRenkeiKoumoku.zrnKykTdkKbn(pZrnkyktdkkbn);
        exClassificationEquals(tdk, C_Tdk.OYA, "契約者続柄");
    }

    @Test
    @TestOrder(50)
    public void testZrnKykTdkKbn_A5(){

        String pZrnkyktdkkbn = "4";
        C_Tdk tdk = editSeihoWebRenkeiKoumoku.zrnKykTdkKbn(pZrnkyktdkkbn);
        exClassificationEquals(tdk, C_Tdk.MAGO, "契約者続柄");
    }

    @Test
    @TestOrder(60)
    public void testZrnKykTdkKbn_A6(){

        String pZrnkyktdkkbn = "5";
        C_Tdk tdk = editSeihoWebRenkeiKoumoku.zrnKykTdkKbn(pZrnkyktdkkbn);
        exClassificationEquals(tdk, C_Tdk.SHB, "契約者続柄");
    }

    @Test
    @TestOrder(70)
    public void testZrnKykTdkKbn_A7(){

        String pZrnkyktdkkbn = "6";
        C_Tdk tdk = editSeihoWebRenkeiKoumoku.zrnKykTdkKbn(pZrnkyktdkkbn);
        exClassificationEquals(tdk, C_Tdk.KYDSM, "契約者続柄");
    }

    @Test
    @TestOrder(80)
    public void testZrnKykTdkKbn_A8(){

        String pZrnkyktdkkbn = "9";
        C_Tdk tdk = editSeihoWebRenkeiKoumoku.zrnKykTdkKbn(pZrnkyktdkkbn);
        exClassificationEquals(tdk, C_Tdk.SONOTA, "契約者続柄");
    }

    @Test
    @TestOrder(90)
    public void testZrnKykTdkKbn_A9(){

        String pZrnkyktdkkbn = "10";
        C_Tdk tdk = editSeihoWebRenkeiKoumoku.zrnKykTdkKbn(pZrnkyktdkkbn);
        exClassificationEquals(tdk, C_Tdk.BLNK, "契約者続柄");
    }
}
