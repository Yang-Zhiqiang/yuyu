package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#tuukasyuHenkan()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_tuukasyuHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testTuukasyuHenkan_A1(){

        String pTuukasyu = "1";
        C_Tuukasyu tuukasyu = editSeihoWebRenkeiKoumoku.tuukasyuHenkan(pTuukasyu);
        exClassificationEquals(tuukasyu, C_Tuukasyu.JPY, "通貨種類");
    }

    @Test
    @TestOrder(20)
    public void testTuukasyuHenkan_A2(){

        String pTuukasyu = "2";
        C_Tuukasyu tuukasyu = editSeihoWebRenkeiKoumoku.tuukasyuHenkan(pTuukasyu);
        exClassificationEquals(tuukasyu, C_Tuukasyu.USD, "通貨種類");
    }

    @Test
    @TestOrder(30)
    public void testTuukasyuHenkan_A3(){

        String pTuukasyu = "3";
        C_Tuukasyu tuukasyu = editSeihoWebRenkeiKoumoku.tuukasyuHenkan(pTuukasyu);
        exClassificationEquals(tuukasyu, C_Tuukasyu.EUR, "通貨種類");
    }

    @Test
    @TestOrder(40)
    public void testTuukasyuHenkan_A4(){

        String pTuukasyu = "4";
        C_Tuukasyu tuukasyu = editSeihoWebRenkeiKoumoku.tuukasyuHenkan(pTuukasyu);
        exClassificationEquals(tuukasyu, C_Tuukasyu.AUD, "通貨種類");
    }

    @Test
    @TestOrder(50)
    public void testTuukasyuHenkan_A5(){

        String pTuukasyu = "5";
        C_Tuukasyu tuukasyu = editSeihoWebRenkeiKoumoku.tuukasyuHenkan(pTuukasyu);
        exClassificationEquals(tuukasyu, C_Tuukasyu.BLNK, "通貨種類");
    }
}
