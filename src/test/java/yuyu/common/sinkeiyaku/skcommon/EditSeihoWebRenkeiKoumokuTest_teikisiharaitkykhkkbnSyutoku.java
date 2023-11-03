package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド {@link EditSeihoWebRenkeiKoumoku#teikisiharaitkykhkkbnSyutoku(String, C_HknsyuruiNo)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_teikisiharaitkykhkkbnSyutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void teikisiharaitkykhkkbnSyutoku_A1() {

        C_Tkhukaumu tkhukaUmu = editSeihoWebRenkeiKoumoku.teikisiharaitkykhkkbnSyutoku("1", C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI);

        exClassificationEquals(tkhukaUmu, C_Tkhukaumu.HUKA, "特約付加有無");

    }

    @Test
    @TestOrder(20)
    public void teikisiharaitkykhkkbnSyutoku_A2() {

        C_Tkhukaumu tkhukaUmu = editSeihoWebRenkeiKoumoku.teikisiharaitkykhkkbnSyutoku("0", C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI);

        exClassificationEquals(tkhukaUmu, C_Tkhukaumu.NONE, "特約付加有無");

    }

    @Test
    @TestOrder(30)
    public void teikisiharaitkykhkkbnSyutoku_A3() {

        C_Tkhukaumu tkhukaUmu = editSeihoWebRenkeiKoumoku.teikisiharaitkykhkkbnSyutoku("0", C_HknsyuruiNo.GAIKARIRITUHENDOUNK);

        exClassificationEquals(tkhukaUmu, C_Tkhukaumu.BLNK, "特約付加有無");

    }
}
