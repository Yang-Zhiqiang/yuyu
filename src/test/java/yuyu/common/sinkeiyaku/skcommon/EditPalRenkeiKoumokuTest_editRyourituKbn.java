package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DntryourituKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editRyourituKbn(C_Hrkkeiro, C_DntryourituKbn)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editRyourituKbn {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditRyourituKbn_A1() {
        String ryourituKbn = editPalRenkeiKoumoku.editRyourituKbn(C_Hrkkeiro.KOUHURI, C_DntryourituKbn.BLNK);

        exStringEquals(ryourituKbn, "3", "料率区分");
    }

    @Test
    @TestOrder(20)
    public void testEditRyourituKbn_A2() {
        String ryourituKbn = editPalRenkeiKoumoku.editRyourituKbn(C_Hrkkeiro.DANTAI, C_DntryourituKbn.A);

        exStringEquals(ryourituKbn, "1", "料率区分");
    }

    @Test
    @TestOrder(30)
    public void testEditRyourituKbn_A3() {
        String ryourituKbn = editPalRenkeiKoumoku.editRyourituKbn(C_Hrkkeiro.DANTAI, C_DntryourituKbn.B);

        exStringEquals(ryourituKbn, "2", "料率区分");
    }

    @Test
    @TestOrder(40)
    public void testEditRyourituKbn_A4() {
        String ryourituKbn = editPalRenkeiKoumoku.editRyourituKbn(C_Hrkkeiro.DANTAI, C_DntryourituKbn.BLNK);

        exStringEquals(ryourituKbn, "0", "料率区分");
    }

    @Test
    @TestOrder(50)
    public void testEditRyourituKbn_A5() {
        String ryourituKbn = editPalRenkeiKoumoku.editRyourituKbn(C_Hrkkeiro.DANTAI, null);

        exStringEquals(ryourituKbn, "0", "料率区分");
    }

    @Test
    @TestOrder(60)
    public void testEditRyourituKbn_A6() {
        String ryourituKbn = editPalRenkeiKoumoku.editRyourituKbn(C_Hrkkeiro.SYUUDAN, C_DntryourituKbn.BLNK);

        exStringEquals(ryourituKbn, "4", "料率区分");
    }

    @Test
    @TestOrder(70)
    public void testEditRyourituKbn_A7() {
        String ryourituKbn = editPalRenkeiKoumoku.editRyourituKbn(C_Hrkkeiro.CREDIT, C_DntryourituKbn.BLNK);

        exStringEquals(ryourituKbn, "5", "料率区分");
    }

    @Test
    @TestOrder(80)
    public void testEditRyourituKbn_A8() {
        String ryourituKbn = editPalRenkeiKoumoku.editRyourituKbn(C_Hrkkeiro.HURIKAE, C_DntryourituKbn.BLNK);

        exStringEquals(ryourituKbn, "0", "料率区分");
    }

    @Test
    @TestOrder(90)
    public void testEditRyourituKbn_A9() {
        String ryourituKbn = editPalRenkeiKoumoku.editRyourituKbn(C_Hrkkeiro.BLNK, C_DntryourituKbn.BLNK);

        exStringEquals(ryourituKbn, "0", "料率区分");
    }

    @Test
    @TestOrder(100)
    public void testEditRyourituKbn_A10() {
        String ryourituKbn = editPalRenkeiKoumoku.editRyourituKbn(null, C_DntryourituKbn.BLNK);

        exStringEquals(ryourituKbn, "0", "料率区分");
    }

}
