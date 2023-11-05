package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#tsbjFkmrrHantei()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_tsbjFkmrrHantei {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testTsbjFkmrrHantei_A1(){

        String pTaisyouti = "C1";
        String pTaisyoukoumokuti1 = "C1";
        boolean tsbjFkmrr = editSeihoWebRenkeiKoumoku.tsbjFkmrrHantei(pTaisyouti, pTaisyoukoumokuti1);
        exBooleanEquals(tsbjFkmrr, true, "判定結果");
    }

    @Test
    @TestOrder(20)
    public void testTsbjFkmrrHantei_A2(){

        String pTaisyouti = "C1";
        String pTaisyoukoumokuti1 = "C2";
        boolean tsbjFkmrr = editSeihoWebRenkeiKoumoku.tsbjFkmrrHantei(pTaisyouti, pTaisyoukoumokuti1);
        exBooleanEquals(tsbjFkmrr, false, "判定結果");
    }

    @Test
    @TestOrder(30)
    public void testTsbjFkmrrHantei_A3(){

        String pTaisyouti = "H5";
        String pTaisyoukoumokuti1 = "C1";
        String pTaisyoukoumokuti2 = "C2";
        String pTaisyoukoumokuti3 = "C3";
        String pTaisyoukoumokuti4 = "C4";
        String pTaisyoukoumokuti5 = "C5";
        boolean tsbjFkmrr = editSeihoWebRenkeiKoumoku.tsbjFkmrrHantei(pTaisyouti,
            pTaisyoukoumokuti1, pTaisyoukoumokuti2, pTaisyoukoumokuti3, pTaisyoukoumokuti4, pTaisyoukoumokuti5);
        exBooleanEquals(tsbjFkmrr, false, "判定結果");
    }

    @Test
    @TestOrder(40)
    public void testTsbjFkmrrHantei_A4(){

        String pTaisyouti = "H5";
        String pTaisyoukoumokuti1 = "C1";
        String pTaisyoukoumokuti2 = "C2";
        String pTaisyoukoumokuti3 = "H5";
        String pTaisyoukoumokuti4 = "C4";
        String pTaisyoukoumokuti5 = "C5";
        boolean tsbjFkmrr = editSeihoWebRenkeiKoumoku.tsbjFkmrrHantei(pTaisyouti,
            pTaisyoukoumokuti1, pTaisyoukoumokuti2, pTaisyoukoumokuti3, pTaisyoukoumokuti4, pTaisyoukoumokuti5);
        exBooleanEquals(tsbjFkmrr, true, "判定結果");
    }
}
