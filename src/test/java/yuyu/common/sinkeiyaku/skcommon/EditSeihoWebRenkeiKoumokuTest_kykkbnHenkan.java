package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KykKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#kykkbnHenkan()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_kykkbnHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testKykkbnHenkan_A1(){

        String pKeihidouituhyj = "1";
        C_KykKbn kykKbn = editSeihoWebRenkeiKoumoku.kykkbnHenkan(pKeihidouituhyj);
        exClassificationEquals(kykKbn, C_KykKbn.KEIHI_DOUITU, "契約者区分");
    }

    @Test
    @TestOrder(20)
    public void testKykkbnHenkan_A2(){

        String pKeihidouituhyj = "2";
        C_KykKbn kykKbn = editSeihoWebRenkeiKoumoku.kykkbnHenkan(pKeihidouituhyj);
        exClassificationEquals(kykKbn, C_KykKbn.KEIHI_BETU, "契約者区分");
    }
}
