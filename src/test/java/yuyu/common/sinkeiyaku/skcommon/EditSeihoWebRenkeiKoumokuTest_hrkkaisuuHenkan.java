package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#hrkkaisuuHenkan()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_hrkkaisuuHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testHrkkaisuuHenkan_A1(){

        String pHaraikomikaisukbn = "1";
        C_Hrkkaisuu hrkkaisuu = editSeihoWebRenkeiKoumoku.hrkkaisuuHenkan(pHaraikomikaisukbn);
        exClassificationEquals(hrkkaisuu, C_Hrkkaisuu.NEN, "払込回数");
    }

    @Test
    @TestOrder(20)
    public void testHrkkaisuuHenkan_A2(){

        String pHaraikomikaisukbn = "2";
        C_Hrkkaisuu hrkkaisuu = editSeihoWebRenkeiKoumoku.hrkkaisuuHenkan(pHaraikomikaisukbn);
        exClassificationEquals(hrkkaisuu, C_Hrkkaisuu.HALFY, "払込回数");
    }

    @Test
    @TestOrder(30)
    public void testHrkkaisuuHenkan_A3(){

        String pHaraikomikaisukbn = "3";
        C_Hrkkaisuu hrkkaisuu = editSeihoWebRenkeiKoumoku.hrkkaisuuHenkan(pHaraikomikaisukbn);
        exClassificationEquals(hrkkaisuu, C_Hrkkaisuu.TUKI, "払込回数");
    }

    @Test
    @TestOrder(40)
    public void testHrkkaisuuHenkan_A4(){

        String pHaraikomikaisukbn = "4";
        C_Hrkkaisuu hrkkaisuu = editSeihoWebRenkeiKoumoku.hrkkaisuuHenkan(pHaraikomikaisukbn);
        exClassificationEquals(hrkkaisuu, C_Hrkkaisuu.ITIJI, "払込回数");
    }

    @Test
    @TestOrder(50)
    public void testHrkkaisuuHenkan_A5(){

        String pHaraikomikaisukbn = "5";
        C_Hrkkaisuu hrkkaisuu = editSeihoWebRenkeiKoumoku.hrkkaisuuHenkan(pHaraikomikaisukbn);
        exClassificationEquals(hrkkaisuu, C_Hrkkaisuu.BLNK, "払込回数");
    }
}
