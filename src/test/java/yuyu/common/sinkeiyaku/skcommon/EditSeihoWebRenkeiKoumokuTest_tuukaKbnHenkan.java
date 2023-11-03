package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#tuukaKbnHenkan()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_tuukaKbnHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testTuukaKbnHenkan_A1(){

        C_Tuukasyu pTuukakbn = C_Tuukasyu.JPY;
        String tuukasyu = editSeihoWebRenkeiKoumoku.tuukaKbnHenkan(pTuukakbn);
        exStringEquals(tuukasyu, "1", "通貨区分");
    }

    @Test
    @TestOrder(20)
    public void testTuukaKbnHenkan_A2(){

        C_Tuukasyu pTuukakbn = C_Tuukasyu.USD;
        String tuukasyu = editSeihoWebRenkeiKoumoku.tuukaKbnHenkan(pTuukakbn);
        exStringEquals(tuukasyu, "2", "通貨区分");
    }

    @Test
    @TestOrder(30)
    public void testTuukaKbnHenkan_A3(){

        C_Tuukasyu pTuukakbn = C_Tuukasyu.EUR;
        String tuukasyu = editSeihoWebRenkeiKoumoku.tuukaKbnHenkan(pTuukakbn);
        exStringEquals(tuukasyu, "3", "通貨区分");
    }

    @Test
    @TestOrder(40)
    public void testTuukaKbnHenkan_A4(){

        C_Tuukasyu pTuukakbn = C_Tuukasyu.AUD;
        String tuukasyu = editSeihoWebRenkeiKoumoku.tuukaKbnHenkan(pTuukakbn);
        exStringEquals(tuukasyu, "4", "通貨区分");
    }

    @Test
    @TestOrder(50)
    public void testTuukaKbnHenkan_A5(){

        C_Tuukasyu pTuukakbn = C_Tuukasyu.BLNK;
        String tuukasyu = editSeihoWebRenkeiKoumoku.tuukaKbnHenkan(pTuukakbn);
        exStringEquals(tuukasyu, "0", "通貨区分");
    }
}
