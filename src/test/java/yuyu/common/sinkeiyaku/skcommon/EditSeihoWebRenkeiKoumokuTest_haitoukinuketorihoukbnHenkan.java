package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#haitoukinuketorihoukbnHenkan()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_haitoukinuketorihoukbnHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testHaitoukinuketorihoukbnHenkan_A1(){

        String pHaitoukinuketorihoukbn = "1";
        C_HaitoukinuketorihouKbn haitoukinuketorihouKbn =
            editSeihoWebRenkeiKoumoku.haitoukinuketorihoukbnHenkan(pHaitoukinuketorihoukbn);
        exClassificationEquals(haitoukinuketorihouKbn, C_HaitoukinuketorihouKbn.TUMIHAI, "配当金受取方法区分");
    }

    @Test
    @TestOrder(20)
    public void testHaitoukinuketorihoukbnHenkan_A2(){

        String pHaitoukinuketorihoukbn = "2";
        C_HaitoukinuketorihouKbn haitoukinuketorihouKbn =
            editSeihoWebRenkeiKoumoku.haitoukinuketorihoukbnHenkan(pHaitoukinuketorihoukbn);
        exClassificationEquals(haitoukinuketorihouKbn, C_HaitoukinuketorihouKbn.BLNK, "配当金受取方法区分");
    }
}
