package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editNenkinsyu(C_Sknenkinsyu)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editNenkinsyu {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditNenkinsyu_A1() {
        String nenkinsyu = editPalRenkeiKoumoku.editNenkinsyu(C_Sknenkinsyu.KKTI5);

        exStringEquals(nenkinsyu, "1", "年金種類区分");
    }

    @Test
    @TestOrder(20)
    public void testEditNenkinsyu_A2() {
        String nenkinsyu = editPalRenkeiKoumoku.editNenkinsyu(C_Sknenkinsyu.KKTI10);

        exStringEquals(nenkinsyu, "2", "年金種類区分");
    }

    @Test
    @TestOrder(30)
    public void testEditNenkinsyu_A3() {
        String nenkinsyu = editPalRenkeiKoumoku.editNenkinsyu(C_Sknenkinsyu.KKTI15);

        exStringEquals(nenkinsyu, "3", "年金種類区分");
    }

    @Test
    @TestOrder(40)
    public void testEditNenkinsyu_A4() {
        String nenkinsyu = editPalRenkeiKoumoku.editNenkinsyu(C_Sknenkinsyu.SGKHSYSYSN);

        exStringEquals(nenkinsyu, "8", "年金種類区分");
    }

    @Test
    @TestOrder(50)
    public void testEditNenkinsyu_A5() {
        String nenkinsyu = editPalRenkeiKoumoku.editNenkinsyu(C_Sknenkinsyu.KKTI5DAI1BAIGAKU);

        exStringEquals(nenkinsyu, "A", "年金種類区分");
    }

    @Test
    @TestOrder(60)
    public void testEditNenkinsyu_A6() {
        String nenkinsyu = editPalRenkeiKoumoku.editNenkinsyu(C_Sknenkinsyu.BLNK);

        exStringEquals(nenkinsyu, "0", "年金種類区分");
    }

    @Test
    @TestOrder(70)
    public void testEditNenkinsyu_A7() {
        String nenkinsyu = editPalRenkeiKoumoku.editNenkinsyu(null);

        exStringEquals(nenkinsyu, "0", "年金種類区分");
    }

}
