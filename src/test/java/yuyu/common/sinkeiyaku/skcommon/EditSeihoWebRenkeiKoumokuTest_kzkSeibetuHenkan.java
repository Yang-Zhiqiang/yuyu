package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Seibetu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#kzkSeibetuHenkan()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_kzkSeibetuHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testKzkSeibetuHenkan_A1(){

        String pSeibetukbn = "1";

        C_Seibetu seibetu = editSeihoWebRenkeiKoumoku.kzkSeibetuHenkan(pSeibetukbn);

        exClassificationEquals(seibetu, C_Seibetu.MALE, "性別");
    }

    @Test
    @TestOrder(20)
    public void testKzkSeibetuHenkan_A2(){

        String pSeibetukbn = "2";

        C_Seibetu seibetu = editSeihoWebRenkeiKoumoku.kzkSeibetuHenkan(pSeibetukbn);

        exClassificationEquals(seibetu, C_Seibetu.FEMALE, "性別");
    }

    @Test
    @TestOrder(30)
    public void testKzkSeibetuHenkan_A3(){

        String pSeibetukbn = "3";

        C_Seibetu seibetu = editSeihoWebRenkeiKoumoku.kzkSeibetuHenkan(pSeibetukbn);

        exClassificationEquals(seibetu, C_Seibetu.BLNK, "性別");
    }
}
