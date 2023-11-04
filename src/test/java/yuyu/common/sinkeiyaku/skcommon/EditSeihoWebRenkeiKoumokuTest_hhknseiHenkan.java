package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hhknsei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#hhknseiHenkan()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_hhknseiHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testHhknseiHenkan_A1(){

        String pHhknsei = "1";
        C_Hhknsei hhknsei = editSeihoWebRenkeiKoumoku.hhknseiHenkan(pHhknsei);
        exClassificationEquals(hhknsei, C_Hhknsei.MALE, "被保険者性別");
    }
    @Test
    @TestOrder(20)
    public void testHhknseiHenkan_A2(){

        String pHhknsei = "2";
        C_Hhknsei hhknsei = editSeihoWebRenkeiKoumoku.hhknseiHenkan(pHhknsei);
        exClassificationEquals(hhknsei, C_Hhknsei.FEMALE, "被保険者性別");
    }

    @Test
    @TestOrder(30)
    public void testHhknseiHenkan_A3(){

        String pHhknsei = "3";
        C_Hhknsei hhknsei = editSeihoWebRenkeiKoumoku.hhknseiHenkan(pHhknsei);
        exClassificationEquals(hhknsei, C_Hhknsei.BLNK, "被保険者性別");
    }
}
