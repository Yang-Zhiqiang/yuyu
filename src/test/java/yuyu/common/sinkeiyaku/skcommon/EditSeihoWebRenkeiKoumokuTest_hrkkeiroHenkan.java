package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hrkkeiro;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#hrkkeiroHenkan()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_hrkkeiroHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testhrkkeiroHenkan_A1(){

        String pHrkkeirokbn = "1";
        C_Hrkkeiro hrkkeiro = editSeihoWebRenkeiKoumoku.hrkkeiroHenkan(pHrkkeirokbn);
        exClassificationEquals(hrkkeiro, C_Hrkkeiro.KOUHURI, "払込経路");
    }

    @Test
    @TestOrder(20)
    public void testhrkkeiroHenkan_A2(){

        String pHaraikomikaisukbn = "2";
        C_Hrkkeiro hrkkeiro = editSeihoWebRenkeiKoumoku.hrkkeiroHenkan(pHaraikomikaisukbn);
        exClassificationEquals(hrkkeiro, C_Hrkkeiro.DANTAI, "払込経路");
    }

    @Test
    @TestOrder(30)
    public void testhrkkeiroHenkan_A3(){

        String pHaraikomikaisukbn = "3";
        C_Hrkkeiro hrkkeiro = editSeihoWebRenkeiKoumoku.hrkkeiroHenkan(pHaraikomikaisukbn);
        exClassificationEquals(hrkkeiro, C_Hrkkeiro.SYUUDAN, "払込経路");
    }

    @Test
    @TestOrder(40)
    public void testhrkkeiroHenkan_A4(){

        String pHaraikomikaisukbn = "6";
        C_Hrkkeiro hrkkeiro = editSeihoWebRenkeiKoumoku.hrkkeiroHenkan(pHaraikomikaisukbn);
        exClassificationEquals(hrkkeiro, C_Hrkkeiro.HURIKAE, "払込経路");
    }

    @Test
    @TestOrder(50)
    public void testhrkkeiroHenkan_A5(){

        String pHaraikomikaisukbn = "7";
        C_Hrkkeiro hrkkeiro = editSeihoWebRenkeiKoumoku.hrkkeiroHenkan(pHaraikomikaisukbn);
        exClassificationEquals(hrkkeiro, C_Hrkkeiro.CREDIT, "払込経路");
    }

    @Test
    @TestOrder(60)
    public void testhrkkeiroHenkan_A6(){

        String pHaraikomikaisukbn = "5";
        C_Hrkkeiro hrkkeiro = editSeihoWebRenkeiKoumoku.hrkkeiroHenkan(pHaraikomikaisukbn);
        exClassificationEquals(hrkkeiro, C_Hrkkeiro.BLNK, "払込経路");
    }
}
