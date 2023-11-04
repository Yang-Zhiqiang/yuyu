package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tdk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#ukttdkSyutoku()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_ukttdkSyutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testUkttdkSyutoku_A1(){

        String pKtnrkkbn = "1";
        String pKttdkkbn = "0";
        C_Tdk kttdk = editSeihoWebRenkeiKoumoku.ukttdkSyutoku(pKtnrkkbn, pKttdkkbn);
        exStringEquals(kttdk.getContent(), "", "受取人続柄");
    }

    @Test
    @TestOrder(20)
    public void testUkttdkSyutoku_A2(){

        String pKtnrkkbn = "2";
        String pKttdkkbn = "0";
        C_Tdk kttdk = editSeihoWebRenkeiKoumoku.ukttdkSyutoku(pKtnrkkbn, pKttdkkbn);
        exStringEquals(kttdk.getContent(), "", "受取人続柄");
    }

    @Test
    @TestOrder(30)
    public void testUkttdkSyutoku_A3(){

        String pKtnrkkbn = "2";
        String pKttdkkbn = "1";
        C_Tdk kttdk = editSeihoWebRenkeiKoumoku.ukttdkSyutoku(pKtnrkkbn, pKttdkkbn);
        exStringEquals(kttdk.getContent(), "配偶者", "受取人続柄");
    }

    @Test
    @TestOrder(40)
    public void testUkttdkSyutoku_A4(){

        String pKtnrkkbn = "4";
        String pKttdkkbn = "1";
        C_Tdk kttdk = editSeihoWebRenkeiKoumoku.ukttdkSyutoku(pKtnrkkbn, pKttdkkbn);
        exStringEquals(kttdk.getContent(), "配偶者", "受取人続柄");
    }
}
