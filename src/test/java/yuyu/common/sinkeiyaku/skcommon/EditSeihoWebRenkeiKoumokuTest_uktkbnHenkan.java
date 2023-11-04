package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UktKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#uktkbnHenkan()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_uktkbnHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testUktkbnHenkan_A1(){

        String pKtnrkkbn = "1";
        String pKttdkkbn = "0";
        String ktknnm = "";
        C_UktKbn uktkbn = editSeihoWebRenkeiKoumoku.uktkbnHenkan(pKtnrkkbn, pKttdkkbn, ktknnm);
        exClassificationEquals(uktkbn, C_UktKbn.KYK, "受取人区分");
    }

    @Test
    @TestOrder(20)
    public void testUktkbnHenkan_A2(){

        String pKtnrkkbn = "5";
        String pKttdkkbn = "0";
        String ktknnm = "";
        C_UktKbn uktkbn = editSeihoWebRenkeiKoumoku.uktkbnHenkan(pKtnrkkbn, pKttdkkbn, ktknnm);
        exClassificationEquals(uktkbn, C_UktKbn.HHKN, "受取人区分");
    }

    @Test
    @TestOrder(30)
    public void testUktkbnHenkan_A3(){

        String pKtnrkkbn = "2";
        String pKttdkkbn = "0";
        String ktknnm = "ウケトリニン";
        C_UktKbn uktkbn = editSeihoWebRenkeiKoumoku.uktkbnHenkan(pKtnrkkbn, pKttdkkbn, ktknnm);
        exClassificationEquals(uktkbn, C_UktKbn.KYK, "受取人区分");
    }

    @Test
    @TestOrder(40)
    public void testUktkbnHenkan_A4(){

        String pKtnrkkbn = "2";
        String pKttdkkbn = "1";
        String ktknnm = "ウケトリニン";
        C_UktKbn uktkbn = editSeihoWebRenkeiKoumoku.uktkbnHenkan(pKtnrkkbn, pKttdkkbn, ktknnm);
        exClassificationEquals(uktkbn, C_UktKbn.TOKUTEIMEIGI, "受取人区分");
    }
    @Test
    @TestOrder(50)
    public void testUktkbnHenkan_A5(){

        String pKtnrkkbn = "3";
        String pKttdkkbn = "0";
        String ktknnm = "ウケトリニン";
        C_UktKbn uktkbn = editSeihoWebRenkeiKoumoku.uktkbnHenkan(pKtnrkkbn, pKttdkkbn, ktknnm);
        exClassificationEquals(uktkbn, C_UktKbn.TOKUTEIMEIGI, "受取人区分");
    }

    @Test
    @TestOrder(60)
    public void testUktkbnHenkan_A6(){

        String pKtnrkkbn = "3";
        String pKttdkkbn = "0";
        String ktknnm = "";
        C_UktKbn uktkbn = editSeihoWebRenkeiKoumoku.uktkbnHenkan(pKtnrkkbn, pKttdkkbn, ktknnm);
        exClassificationEquals(uktkbn, C_UktKbn.BLNK, "受取人区分");
    }


}
