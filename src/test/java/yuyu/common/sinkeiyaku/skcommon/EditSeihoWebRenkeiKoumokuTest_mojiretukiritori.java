package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#mojiretuKiritori()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_mojiretukiritori {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testMojiretukiritori_A1(){

        String pTaisyouMojiretu = null;
        int pBegin = 4;
        int pEnd = 4;
        String taisyouMojiretu = editSeihoWebRenkeiKoumoku.mojiretuKiritori(pTaisyouMojiretu, pBegin, pEnd);
        exStringEquals(taisyouMojiretu, "", "対象文字列");
    }

    @Test
    @TestOrder(20)
    public void testMojiretukiritori_A2(){

        String pTaisyouMojiretu = "対象文字列";
        int pBegin = 4;
        int pEnd = 10;
        String taisyouMojiretu = editSeihoWebRenkeiKoumoku.mojiretuKiritori(pTaisyouMojiretu, pBegin, pEnd);
        exStringEquals(taisyouMojiretu, "", "対象文字列");
    }

    @Test
    @TestOrder(30)
    public void testMojiretukiritori_A3(){

        String pTaisyouMojiretu = "対象文字列";
        int pBegin = 4;
        int pEnd = 5;
        String taisyouMojiretu = editSeihoWebRenkeiKoumoku.mojiretuKiritori(pTaisyouMojiretu, pBegin, pEnd);
        exStringEquals(taisyouMojiretu, "列", "対象文字列");
    }

    @Test
    @TestOrder(40)
    public void testMojiretukiritori_A4(){

        String pTaisyouMojiretu = "対象文字列";
        int pBegin = 0;
        int pEnd = 5;
        String taisyouMojiretu = editSeihoWebRenkeiKoumoku.mojiretuKiritori(pTaisyouMojiretu, pBegin, pEnd);
        exStringEquals(taisyouMojiretu, "対象文字列", "対象文字列");
    }
}
