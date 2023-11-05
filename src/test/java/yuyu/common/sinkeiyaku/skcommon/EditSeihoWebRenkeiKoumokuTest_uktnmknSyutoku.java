package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#uktnmknSyutoku()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_uktnmknSyutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testUktnmknSyutoku_A1(){

        String pKtnrkkbn = "2";
        String pKttdkkbn = "0";
        String pKtknnm = "ウケトリニン";
        String ktknnm = editSeihoWebRenkeiKoumoku.uktknnmSyutoku(pKtnrkkbn, pKttdkkbn, pKtknnm);
        exStringEquals(ktknnm, null, "受取人名（カナ）");
    }

    @Test
    @TestOrder(20)
    public void testUktnmknSyutoku_A2(){

        String pKtnrkkbn = "2";
        String pKttdkkbn = "0";
        String pKtknnm = "ウケトリニン";
        String ktknnm = editSeihoWebRenkeiKoumoku.uktknnmSyutoku(pKtnrkkbn, pKttdkkbn, pKtknnm);
        exStringEquals(ktknnm, null, "受取人名（カナ）");
    }

    @Test
    @TestOrder(30)
    public void testUktnmknSyutoku_A3(){

        String pKtnrkkbn = "2";
        String pKttdkkbn = "0";
        String pKtknnm = "ウケトリニン";
        String ktknnm = editSeihoWebRenkeiKoumoku.uktknnmSyutoku(pKtnrkkbn, pKttdkkbn, pKtknnm);
        exStringEquals(ktknnm, null, "受取人名（カナ）");
    }

    @Test
    @TestOrder(40)
    public void testUktnmknSyutoku_A4(){

        String pKtnrkkbn = "4";
        String pKttdkkbn = "1";
        String pKtknnm = "ウケトリニン";
        String ktknnm = editSeihoWebRenkeiKoumoku.uktknnmSyutoku(pKtnrkkbn, pKttdkkbn, pKtknnm);
        exStringEquals(ktknnm, "ウケトリニン", "受取人名（カナ）");
    }
}
