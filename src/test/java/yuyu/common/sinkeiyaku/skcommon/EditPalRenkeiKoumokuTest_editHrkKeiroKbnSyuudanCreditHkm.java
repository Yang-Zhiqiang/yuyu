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
 * {@link EditPalRenkeiKoumoku#editHrkKeiroKbnSyuudanCreditHkm(C_Hrkkeiro, C_Hrkkaisuu)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editHrkKeiroKbnSyuudanCreditHkm {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditHrkKeiroKbnSyuudanCreditHkm_A1() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbnSyuudanCreditHkm(C_Hrkkeiro.KOUHURI, null);

        exStringEquals(hrkKeiroKbn, "1", "払込経路区分");
    }

    @Test
    @TestOrder(20)
    public void testEditHrkKeiroKbnSyuudanCreditHkm_A2() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbnSyuudanCreditHkm(C_Hrkkeiro.DANTAI, null);

        exStringEquals(hrkKeiroKbn, "2", "払込経路区分");
    }

    @Test
    @TestOrder(30)
    public void testEditHrkKeiroKbnSyuudanCreditHkm_A3() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbnSyuudanCreditHkm(C_Hrkkeiro.SYUUDAN, null);

        exStringEquals(hrkKeiroKbn, "6", "払込経路区分");
    }

    @Test
    @TestOrder(40)
    public void testEditHrkKeiroKbnSyuudanCreditHkm_A4() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbnSyuudanCreditHkm(C_Hrkkeiro.BLNK, C_Hrkkaisuu.ITIJI);

        exStringEquals(hrkKeiroKbn, " ", "払込経路区分");
    }

    @Test
    @TestOrder(50)
    public void testEditHrkKeiroKbnSyuudanCreditHkm_A5() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbnSyuudanCreditHkm(C_Hrkkeiro.BLNK, null);

        exStringEquals(hrkKeiroKbn, " ", "払込経路区分");
    }

    @Test
    @TestOrder(60)
    public void testEditHrkKeiroKbnSyuudanCreditHkm_A6() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbnSyuudanCreditHkm(C_Hrkkeiro.BLNK, C_Hrkkaisuu.BLNK);

        exStringEquals(hrkKeiroKbn, " ", "払込経路区分");
    }

    @Test
    @TestOrder(70)
    public void testEditHrkKeiroKbnSyuudanCreditHkm_A7() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbnSyuudanCreditHkm(C_Hrkkeiro.BLNK, C_Hrkkaisuu.TUKI);

        exStringEquals(hrkKeiroKbn, " ", "払込経路区分");
    }

    @Test
    @TestOrder(80)
    public void testEditHrkKeiroKbnSyuudanCreditHkm_A8() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbnSyuudanCreditHkm(C_Hrkkeiro.BLNK, C_Hrkkaisuu.HALFY);

        exStringEquals(hrkKeiroKbn, " ", "払込経路区分");
    }

    @Test
    @TestOrder(90)
    public void testEditHrkKeiroKbnSyuudanCreditHkm_A9() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbnSyuudanCreditHkm(C_Hrkkeiro.BLNK, C_Hrkkaisuu.NEN);

        exStringEquals(hrkKeiroKbn, " ", "払込経路区分");
    }

    @Test
    @TestOrder(100)
    public void testEditHrkKeiroKbnSyuudanCreditHkm_A10() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbnSyuudanCreditHkm(C_Hrkkeiro.CREDIT, null);

        exStringEquals(hrkKeiroKbn, "6", "払込経路区分");
    }

    @Test
    @TestOrder(110)
    public void testEditHrkKeiroKbnSyuudanCreditHkm_A11() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbnSyuudanCreditHkm(C_Hrkkeiro.HURIKAE, null);

        exStringEquals(hrkKeiroKbn, "4", "払込経路区分");
    }

    @Test
    @TestOrder(120)
    public void testEditHrkKeiroKbnSyuudanCreditHkm_A12() {
        String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbnSyuudanCreditHkm(null, null);

        exStringEquals(hrkKeiroKbn, " ", "払込経路区分");
    }

}
