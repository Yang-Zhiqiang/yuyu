package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tdk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#zrnUktTdkKbn()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_zrnUktTdkKbn {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testZrnUktTdkKbn_A1(){

        String pZrnukttdkkbn = "0";
        C_Tdk tdk = editSeihoWebRenkeiKoumoku.zrnUktTdkKbn(pZrnukttdkkbn);
        exClassificationEquals(tdk, C_Tdk.BLNK, "受取人続柄");
    }

    @Test
    @TestOrder(20)
    public void testZrnUktTdkKbn_A2(){

        String pZrnukttdkkbn = "1";
        C_Tdk tdk = editSeihoWebRenkeiKoumoku.zrnUktTdkKbn(pZrnukttdkkbn);
        exClassificationEquals(tdk, C_Tdk.HGU, "受取人続柄");
    }

    @Test
    @TestOrder(30)
    public void testZrnUktTdkKbn_A3(){

        String pZrnukttdkkbn = "2";
        C_Tdk tdk = editSeihoWebRenkeiKoumoku.zrnUktTdkKbn(pZrnukttdkkbn);
        exClassificationEquals(tdk, C_Tdk.KO, "受取人続柄");
    }

    @Test
    @TestOrder(40)
    public void testZrnUktTdkKbn_A4(){

        String pZrnukttdkkbn = "3";
        C_Tdk tdk = editSeihoWebRenkeiKoumoku.zrnUktTdkKbn(pZrnukttdkkbn);
        exClassificationEquals(tdk, C_Tdk.OYA, "受取人続柄");
    }

    @Test
    @TestOrder(50)
    public void testZrnUktTdkKbn_A5(){

        String pZrnukttdkkbn = "4";
        C_Tdk tdk = editSeihoWebRenkeiKoumoku.zrnUktTdkKbn(pZrnukttdkkbn);
        exClassificationEquals(tdk, C_Tdk.MAGO, "受取人続柄");
    }

    @Test
    @TestOrder(60)
    public void testZrnUktTdkKbn_A6(){

        String pZrnukttdkkbn = "5";
        C_Tdk tdk = editSeihoWebRenkeiKoumoku.zrnUktTdkKbn(pZrnukttdkkbn);
        exClassificationEquals(tdk, C_Tdk.SHB, "受取人続柄");
    }

    @Test
    @TestOrder(70)
    public void testZrnUktTdkKbn_A7(){

        String pZrnukttdkkbn = "6";
        C_Tdk tdk = editSeihoWebRenkeiKoumoku.zrnUktTdkKbn(pZrnukttdkkbn);
        exClassificationEquals(tdk, C_Tdk.KYDSM, "受取人続柄");
    }

    @Test
    @TestOrder(80)
    public void testZrnUktTdkKbn_A8(){

        String pZrnukttdkkbn = "7";
        C_Tdk tdk = editSeihoWebRenkeiKoumoku.zrnUktTdkKbn(pZrnukttdkkbn);
        exClassificationEquals(tdk, C_Tdk.KYN, "受取人続柄");
    }

    @Test
    @TestOrder(90)
    public void testZrnUktTdkKbn_A9(){

        String pZrnukttdkkbn = "8";
        C_Tdk tdk = editSeihoWebRenkeiKoumoku.zrnUktTdkKbn(pZrnukttdkkbn);
        exClassificationEquals(tdk, C_Tdk.HTSZN, "受取人続柄");
    }

    @Test
    @TestOrder(100)
    public void testZrnUktTdkKbn_A10(){

        String pZrnukttdkkbn = "9";
        C_Tdk tdk = editSeihoWebRenkeiKoumoku.zrnUktTdkKbn(pZrnukttdkkbn);
        exClassificationEquals(tdk, C_Tdk.SONOTA, "受取人続柄");
    }

    @Test
    @TestOrder(110)
    public void testZrnUktTdkKbn_A11(){

        String pZrnukttdkkbn = "10";
        C_Tdk tdk = editSeihoWebRenkeiKoumoku.zrnUktTdkKbn(pZrnukttdkkbn);
        exClassificationEquals(tdk, C_Tdk.BLNK, "受取人続柄");
    }
}
