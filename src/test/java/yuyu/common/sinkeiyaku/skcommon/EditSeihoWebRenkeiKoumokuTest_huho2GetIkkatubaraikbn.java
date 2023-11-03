package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#huho2GetIkkatubaraikbn()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_huho2GetIkkatubaraikbn {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testHuho2GetIkkatubaraikbn_A1(){

        String pIkkatubaraiKbn = "0";
        C_IkkatubaraiKbn huho2Ikkatubaraikbn = editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikbn(pIkkatubaraiKbn);
        exClassificationEquals(huho2Ikkatubaraikbn, C_IkkatubaraiKbn.BLNK, "普保Ⅱ一括払区分");
    }

    @Test
    @TestOrder(20)
    public void testHuho2GetIkkatubaraikbn_A2(){

        String pIkkatubaraiKbn = "1";
        C_IkkatubaraiKbn huho2Ikkatubaraikbn = editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikbn(pIkkatubaraiKbn);
        exClassificationEquals(huho2Ikkatubaraikbn, C_IkkatubaraiKbn.IKKATU, "普保Ⅱ一括払区分");
    }

    @Test
    @TestOrder(30)
    public void testHuho2GetIkkatubaraikbn_A3(){

        String pIkkatubaraiKbn = "2";
        C_IkkatubaraiKbn huho2Ikkatubaraikbn = editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikbn(pIkkatubaraiKbn);
        exClassificationEquals(huho2Ikkatubaraikbn, C_IkkatubaraiKbn.TEIKIIKKATU, "普保Ⅱ一括払区分");
    }

    @Test
    @TestOrder(40)
    public void testHuho2GetIkkatubaraikbn_A4(){

        String pIkkatubaraiKbn = "9";
        C_IkkatubaraiKbn huho2Ikkatubaraikbn = editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikbn(pIkkatubaraiKbn);
        exClassificationEquals(huho2Ikkatubaraikbn, C_IkkatubaraiKbn.BLNK, "普保Ⅱ一括払区分");
    }
}
