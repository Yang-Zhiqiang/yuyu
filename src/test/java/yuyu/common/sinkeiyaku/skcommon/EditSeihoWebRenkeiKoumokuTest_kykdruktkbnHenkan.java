package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UktKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#kykdruktkbnHenkan()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_kykdruktkbnHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testKykdruktkbnHenkan_A1(){

        String pUktinputkbn = "1";

        C_UktKbn uktKbn = editSeihoWebRenkeiKoumoku.kykdruktkbnHenkan(pUktinputkbn);

        exClassificationEquals(uktKbn, C_UktKbn.TOUROKUKAZOKU1, "受取人区分");
    }

    @Test
    @TestOrder(20)
    public void testKykdruktkbnHenkan_A2(){

        String pUktinputkbn = "2";

        C_UktKbn uktKbn = editSeihoWebRenkeiKoumoku.kykdruktkbnHenkan(pUktinputkbn);

        exClassificationEquals(uktKbn, C_UktKbn.TOUROKUKAZOKU2, "受取人区分");
    }

    @Test
    @TestOrder(30)
    public void testKykdruktkbnHenkan_A3(){

        String pUktinputkbn = "4";

        C_UktKbn uktKbn = editSeihoWebRenkeiKoumoku.kykdruktkbnHenkan(pUktinputkbn);

        exClassificationEquals(uktKbn, C_UktKbn.BLNK, "受取人区分");
    }
}
