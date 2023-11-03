package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#uktnmkjSyutoku()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_uktnmkjSyutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testUktnmkjSyutoku_A1(){

        String pKtnrkkbn = "2";
        String pKttdkkbn = "0";
        String pKtkjnm = "受取人名（漢字）";
        String ktnmkj = editSeihoWebRenkeiKoumoku.uktnmkjSyutoku(pKtnrkkbn, pKttdkkbn, pKtkjnm);
        exStringEquals(ktnmkj, null, "受取人名（漢字）");
    }

    @Test
    @TestOrder(20)
    public void testUktnmkjSyutoku_A2(){

        String pKtnrkkbn = "2";
        String pKttdkkbn = "1";
        String pKtkjnm = "受取人名（漢字）";
        String ktnmkj = editSeihoWebRenkeiKoumoku.uktnmkjSyutoku(pKtnrkkbn, pKttdkkbn, pKtkjnm);
        exStringEquals(ktnmkj, "受取人名（漢字）", "受取人名（漢字）");
    }

    @Test
    @TestOrder(30)
    public void testUktnmkjSyutoku_A3(){

        String pKtnrkkbn = "4";
        String pKttdkkbn = "0";
        String pKtkjnm = "受取人名（漢字）4";
        String ktnmkj = editSeihoWebRenkeiKoumoku.uktnmkjSyutoku(pKtnrkkbn, pKttdkkbn, pKtkjnm);
        exStringEquals(ktnmkj, null, "受取人名（漢字）");
    }

    @Test
    @TestOrder(40)
    public void testUktnmkjSyutoku_A4(){

        String pKtnrkkbn = "4";
        String pKttdkkbn = "1";
        String pKtkjnm = "受取人名（漢字）4";
        String ktnmkj = editSeihoWebRenkeiKoumoku.uktnmkjSyutoku(pKtnrkkbn, pKttdkkbn, pKtkjnm);
        exStringEquals(ktnmkj, "受取人名（漢字）4", "受取人名（漢字）");
    }

    @Test
    @TestOrder(50)
    public void testUktnmkjSyutoku_A5(){

        String pKtnrkkbn = "1";
        String pKttdkkbn = "1";
        String pKtkjnm = "受取人名（漢字）";
        String ktnmkj = editSeihoWebRenkeiKoumoku.uktnmkjSyutoku(pKtnrkkbn, pKttdkkbn, pKtkjnm);
        exStringEquals(ktnmkj, null, "受取人名（漢字）");
    }
}
