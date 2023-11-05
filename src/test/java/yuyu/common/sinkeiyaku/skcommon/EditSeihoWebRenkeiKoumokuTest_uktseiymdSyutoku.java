package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#uktseiymdSyutoku()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_uktseiymdSyutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testUktseiymdSyutoku_A1(){

        String pKtnrkkbn = "2";
        String pKttdkkbn = "0";
        String pKtseiymd = "20160627";
        String ktseiymd = editSeihoWebRenkeiKoumoku.uktseiymdSyutoku(pKtnrkkbn, pKttdkkbn, pKtseiymd);
        exStringEquals(ktseiymd, null, "受取人生年月日");
    }

    @Test
    @TestOrder(20)
    public void testUktseiymdSyutoku_A2(){

        String pKtnrkkbn = "2";
        String pKttdkkbn = "1";
        String pKtseiymd = "20160627";
        String ktseiymd = editSeihoWebRenkeiKoumoku.uktseiymdSyutoku(pKtnrkkbn, pKttdkkbn, pKtseiymd);
        exStringEquals(ktseiymd, "20160627", "受取人生年月日");
    }

    @Test
    @TestOrder(30)
    public void testUktseiymdSyutoku_A3(){

        String pKtnrkkbn = "2";
        String pKttdkkbn = "1";
        String pKtseiymd = "00000000";
        String ktseiymd = editSeihoWebRenkeiKoumoku.uktseiymdSyutoku(pKtnrkkbn, pKttdkkbn, pKtseiymd);
        exStringEquals(ktseiymd, null, "受取人生年月日");
    }

    @Test
    @TestOrder(40)
    public void testUktseiymdSyutoku_A4(){

        String pKtnrkkbn = "2";
        String pKttdkkbn = "1";
        String pKtseiymd = "0";
        String ktseiymd = editSeihoWebRenkeiKoumoku.uktseiymdSyutoku(pKtnrkkbn, pKttdkkbn, pKtseiymd);
        exStringEquals(ktseiymd, null, "受取人生年月日");
    }

    @Test
    @TestOrder(50)
    public void testUktseiymdSyutoku_A5(){

        String pKtnrkkbn = "1";
        String pKttdkkbn = "1";
        String pKtseiymd = "20160627";
        String ktseiymd = editSeihoWebRenkeiKoumoku.uktseiymdSyutoku(pKtnrkkbn, pKttdkkbn, pKtseiymd);
        exStringEquals(ktseiymd, null, "受取人生年月日");
    }

    @Test
    @TestOrder(60)
    public void testUktseiymdSyutoku_A6(){

        String pKtnrkkbn = "4";
        String pKttdkkbn = "1";
        String pKtseiymd = "20160627";
        String ktseiymd = editSeihoWebRenkeiKoumoku.uktseiymdSyutoku(pKtnrkkbn, pKttdkkbn, pKtseiymd);
        exStringEquals(ktseiymd, "20160627", "受取人生年月日");
    }
}
