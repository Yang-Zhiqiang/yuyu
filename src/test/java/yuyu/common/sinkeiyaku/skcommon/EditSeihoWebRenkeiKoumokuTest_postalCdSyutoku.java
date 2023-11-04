package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#postalCdSyutokun()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_postalCdSyutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testPostalCdSyutoku_A1(){

        String pKihontikucd = "123456";
        String kihontikucd = editSeihoWebRenkeiKoumoku.postalCdSyutoku(pKihontikucd);
        exStringEquals(kihontikucd, "123456", "郵便番号");
    }

    @Test
    @TestOrder(20)
    public void testPostalCdSyutoku_A2(){

        String pKihontikucd = "1234567";
        String kihontikucd = editSeihoWebRenkeiKoumoku.postalCdSyutoku(pKihontikucd);
        exStringEquals(kihontikucd, "1234567", "郵便番号");
    }

    @Test
    @TestOrder(30)
    public void testPostalCdSyutoku_A3(){

        String pKihontikucd = "12345678";
        String kihontikucd = editSeihoWebRenkeiKoumoku.postalCdSyutoku(pKihontikucd);
        exStringEquals(kihontikucd, "1234567", "郵便番号");
    }
}
