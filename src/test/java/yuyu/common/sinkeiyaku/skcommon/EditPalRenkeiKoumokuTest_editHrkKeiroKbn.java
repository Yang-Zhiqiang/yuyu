package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editHrkKeiroKbn(C_Hrkkeiro, C_Hrkkaisuu)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editHrkKeiroKbn {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditHrkKeiroKbn_A1() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbn(C_Hrkkeiro.KOUHURI, null);

        exStringEquals(hrkKeiroKbn, "1", "払込経路区分");
    }

    @Test
    @TestOrder(20)
    public void testEditHrkKeiroKbn_A2() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbn(C_Hrkkeiro.DANTAI, null);

        exStringEquals(hrkKeiroKbn, "2", "払込経路区分");
    }

    @Test
    @TestOrder(30)
    public void testEditHrkKeiroKbn_A3() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbn(C_Hrkkeiro.SYUUDAN, null);

        exStringEquals(hrkKeiroKbn, "6", "払込経路区分");
    }

    @Test
    @TestOrder(40)
    public void testEditHrkKeiroKbn_A4() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbn(C_Hrkkeiro.BLNK, C_Hrkkaisuu.ITIJI);

        exStringEquals(hrkKeiroKbn, " ", "払込経路区分");
    }

    @Test
    @TestOrder(50)
    public void testEditHrkKeiroKbn_A5() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbn(C_Hrkkeiro.BLNK, null);

        exStringEquals(hrkKeiroKbn, " ", "払込経路区分");
    }

    @Test
    @TestOrder(60)
    public void testEditHrkKeiroKbn_A6() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbn(C_Hrkkeiro.BLNK, C_Hrkkaisuu.BLNK);

        exStringEquals(hrkKeiroKbn, " ", "払込経路区分");
    }

    @Test
    @TestOrder(70)
    public void testEditHrkKeiroKbn_A7() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbn(C_Hrkkeiro.BLNK, C_Hrkkaisuu.TUKI);

        exStringEquals(hrkKeiroKbn, " ", "払込経路区分");
    }

    @Test
    @TestOrder(80)
    public void testEditHrkKeiroKbn_A8() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbn(C_Hrkkeiro.BLNK, C_Hrkkaisuu.HALFY);

        exStringEquals(hrkKeiroKbn, " ", "払込経路区分");
    }

    @Test
    @TestOrder(90)
    public void testEditHrkKeiroKbn_A9() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbn(C_Hrkkeiro.BLNK, C_Hrkkaisuu.NEN);

        exStringEquals(hrkKeiroKbn, " ", "払込経路区分");
    }

    @Test
    @TestOrder(100)
    public void testEditHrkKeiroKbn_A10() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbn(C_Hrkkeiro.CREDIT, null);

        exStringEquals(hrkKeiroKbn, "8", "払込経路区分");
    }

    @Test
    @TestOrder(110)
    public void testEditHrkKeiroKbn_A11() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbn(C_Hrkkeiro.HURIKAE, null);

        exStringEquals(hrkKeiroKbn, "4", "払込経路区分");
    }

    @Test
    @TestOrder(120)
    public void testEditHrkKeiroKbn_A12() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbn(null, null);

        exStringEquals(hrkKeiroKbn, " ", "払込経路区分");
    }

}
