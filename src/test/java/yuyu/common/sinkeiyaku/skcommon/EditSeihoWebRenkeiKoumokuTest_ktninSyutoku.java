package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#ktninSyutoku()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_ktninSyutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testKtninSyutoku_A1(){

        Integer pKthksuninzuuc = 3;
        String pKtnrkkbn = "1";
        Integer ktnin = editSeihoWebRenkeiKoumoku.ktninSyutoku(pKthksuninzuuc, pKtnrkkbn);
        exNumericEquals(ktnin, Integer.valueOf(3), "受取人人数");
    }

    @Test
    @TestOrder(20)
    public void testKtninSyutoku_A2(){

        Integer pKthksuninzuuc = 2;
        String pKtnrkkbn = "4";
        Integer ktnin = editSeihoWebRenkeiKoumoku.ktninSyutoku(pKthksuninzuuc, pKtnrkkbn);
        exNumericEquals(ktnin, Integer.valueOf(2), "受取人人数");
    }

    @Test
    @TestOrder(30)
    public void testKtninSyutoku_A3(){

        Integer pKthksuninzuuc = 1;
        String pKtnrkkbn = "1";
        Integer ktnin = editSeihoWebRenkeiKoumoku.ktninSyutoku(pKthksuninzuuc, pKtnrkkbn);
        exNumericEquals(ktnin, Integer.valueOf(1), "受取人人数");
    }

    @Test
    @TestOrder(40)
    public void testKtninSyutoku_A4(){

        Integer pKthksuninzuuc = 1;
        String pKtnrkkbn = "4";
        Integer ktnin = editSeihoWebRenkeiKoumoku.ktninSyutoku(pKthksuninzuuc, pKtnrkkbn);
        exNumericEquals(ktnin, Integer.valueOf(1), "受取人人数");
    }

    @Test
    @TestOrder(50)
    public void testKtninSyutoku_A5(){

        Integer pKthksuninzuuc = 1;
        String pKtnrkkbn = "2";
        Integer ktnin = editSeihoWebRenkeiKoumoku.ktninSyutoku(pKthksuninzuuc, pKtnrkkbn);
        exNumericEquals(ktnin, Integer.valueOf(0), "受取人人数");
    }
}
