package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Kyksei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#kykseiHenkan()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_kykseiHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testKykseiHenkan_A1(){

        String pKyksei = "1";
        C_Kyksei kyksei = editSeihoWebRenkeiKoumoku.kykseiHenkan(pKyksei);
        exClassificationEquals(kyksei, C_Kyksei.MALE, "契約者性別");
    }
    @Test
    @TestOrder(20)
    public void testKykseiHenkan_A2(){

        String pKyksei = "2";
        C_Kyksei kyksei = editSeihoWebRenkeiKoumoku.kykseiHenkan(pKyksei);
        exClassificationEquals(kyksei, C_Kyksei.FEMALE, "契約者性別");
    }

    @Test
    @TestOrder(30)
    public void testKykseiHenkan_A3(){

        String pKyksei = "3";
        C_Kyksei kyksei = editSeihoWebRenkeiKoumoku.kykseiHenkan(pKyksei);
        exClassificationEquals(kyksei, C_Kyksei.BLNK, "契約者性別");
    }
}
