package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#huho2GetYakkanJyuryouKbn()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_huho2GetYakkanJyuryouKbn {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testHuho2GetYakkanJyuryouKbn_A1(){

        String pYakkankbn = "0";
        C_YakkanJyuryouKbn huho2YakkanJyuryouKbn =
            editSeihoWebRenkeiKoumoku.huho2GetYakkanJyuryouKbn(pYakkankbn);
        exClassificationEquals(huho2YakkanJyuryouKbn, C_YakkanJyuryouKbn.BLNK, "普保Ⅱ約款受領方法区分");
    }

    @Test
    @TestOrder(20)
    public void testHuho2GetYakkanJyuryouKbn_A2(){

        String pYakkankbn = "1";
        C_YakkanJyuryouKbn huho2YakkanJyuryouKbn =
            editSeihoWebRenkeiKoumoku.huho2GetYakkanJyuryouKbn(pYakkankbn);
        exClassificationEquals(huho2YakkanJyuryouKbn, C_YakkanJyuryouKbn.WEB, "普保Ⅱ約款受領方法区分");
    }

    @Test
    @TestOrder(30)
    public void testHuho2GetYakkanJyuryouKbn_A3(){

        String pYakkankbn = "2";
        C_YakkanJyuryouKbn huho2YakkanJyuryouKbn =
            editSeihoWebRenkeiKoumoku.huho2GetYakkanJyuryouKbn(pYakkankbn);
        exClassificationEquals(huho2YakkanJyuryouKbn, C_YakkanJyuryouKbn.SASSI, "普保Ⅱ約款受領方法区分");
    }

    @Test
    @TestOrder(40)
    public void testHuho2GetYakkanJyuryouKbn_A4(){

        String pYakkankbn = "3";
        C_YakkanJyuryouKbn huho2YakkanJyuryouKbn =
            editSeihoWebRenkeiKoumoku.huho2GetYakkanJyuryouKbn(pYakkankbn);
        exClassificationEquals(huho2YakkanJyuryouKbn, C_YakkanJyuryouKbn.WEB_SASSI, "普保Ⅱ約款受領方法区分");
    }

    @Test
    @TestOrder(50)
    public void testHuho2GetYakkanJyuryouKbn_A5(){

        String pYakkankbn = "9";
        C_YakkanJyuryouKbn huho2YakkanJyuryouKbn =
            editSeihoWebRenkeiKoumoku.huho2GetYakkanJyuryouKbn(pYakkankbn);
        exClassificationEquals(huho2YakkanJyuryouKbn, C_YakkanJyuryouKbn.BLNK, "普保Ⅱ約款受領方法区分");
    }
}
