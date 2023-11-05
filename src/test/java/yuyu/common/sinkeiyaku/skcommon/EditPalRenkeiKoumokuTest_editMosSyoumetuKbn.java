package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editMosSyoumetuKbn(C_SeirituKbn, C_Ketkekkacd)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editMosSyoumetuKbn {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditMosSyoumetuKbn_A1() {

        String mosSyoumetuKbn = editPalRenkeiKoumoku.editMosSyoumetuKbn(C_SeirituKbn.SEIRITU, null);

        exStringEquals(mosSyoumetuKbn, "1", "申込消滅区分");
    }

    @Test
    @TestOrder(20)
    public void testEditMosSyoumetuKbn_A2() {

        String mosSyoumetuKbn = editPalRenkeiKoumoku.editMosSyoumetuKbn(C_SeirituKbn.HUSEIRITU, C_Ketkekkacd.MIAWASE);

        exStringEquals(mosSyoumetuKbn, "2", "申込消滅区分");
    }

    @Test
    @TestOrder(30)
    public void testEditMosSyoumetuKbn_A3() {

        String mosSyoumetuKbn = editPalRenkeiKoumoku.editMosSyoumetuKbn(C_SeirituKbn.NONE, C_Ketkekkacd.MIAWASE);

        exStringEquals(mosSyoumetuKbn, "0", "申込消滅区分");
    }

    @Test
    @TestOrder(40)
    public void testEditMosSyoumetuKbn_A4() {

        String mosSyoumetuKbn = editPalRenkeiKoumoku.editMosSyoumetuKbn(C_SeirituKbn.HUSEIRITU, C_Ketkekkacd.ENKI_SUUNENGOSAISIN);

        exStringEquals(mosSyoumetuKbn, "3", "申込消滅区分");
    }

    @Test
    @TestOrder(50)
    public void testEditMosSyoumetuKbn_A5() {

        String mosSyoumetuKbn = editPalRenkeiKoumoku.editMosSyoumetuKbn(C_SeirituKbn.NONE , C_Ketkekkacd.ENKI_SUUNENGOSAISIN);

        exStringEquals(mosSyoumetuKbn, "0", "申込消滅区分");
    }

    @Test
    @TestOrder(60)
    public void testEditMosSyoumetuKbn_A6() {

        String mosSyoumetuKbn = editPalRenkeiKoumoku.editMosSyoumetuKbn(C_SeirituKbn.HUSEIRITU, C_Ketkekkacd.ENKI_SIJINASI);

        exStringEquals(mosSyoumetuKbn, "3", "申込消滅区分");
    }

    @Test
    @TestOrder(70)
    public void testEditMosSyoumetuKbn_A7() {

        String mosSyoumetuKbn = editPalRenkeiKoumoku.editMosSyoumetuKbn(C_SeirituKbn.NONE, C_Ketkekkacd.ENKI_SIJINASI);

        exStringEquals(mosSyoumetuKbn, "0", "申込消滅区分");
    }

    @Test
    @TestOrder(80)
    public void testEditMosSyoumetuKbn_A8() {

        String mosSyoumetuKbn = editPalRenkeiKoumoku.editMosSyoumetuKbn(C_SeirituKbn.HUSEIRITU, C_Ketkekkacd.COOLINGOFF);

        exStringEquals(mosSyoumetuKbn, "4", "申込消滅区分");
    }

    @Test
    @TestOrder(90)
    public void testEditMosSyoumetuKbn_A9() {

        String mosSyoumetuKbn = editPalRenkeiKoumoku.editMosSyoumetuKbn(C_SeirituKbn.NONE, C_Ketkekkacd.COOLINGOFF);

        exStringEquals(mosSyoumetuKbn, "0", "申込消滅区分");
    }

    @Test
    @TestOrder(100)
    public void testEditMosSyoumetuKbn_A10() {

        String mosSyoumetuKbn = editPalRenkeiKoumoku.editMosSyoumetuKbn(C_SeirituKbn.HUSEIRITU, C_Ketkekkacd.MOS_TORIKESI);

        exStringEquals(mosSyoumetuKbn, "4", "申込消滅区分");
    }

    @Test
    @TestOrder(110)
    public void testEditMosSyoumetuKbn_A11() {

        String mosSyoumetuKbn = editPalRenkeiKoumoku.editMosSyoumetuKbn(C_SeirituKbn.NONE, C_Ketkekkacd.MOS_TORIKESI);

        exStringEquals(mosSyoumetuKbn, "0", "申込消滅区分");
    }

    @Test
    @TestOrder(120)
    public void testEditMosSyoumetuKbn_A12() {

        String mosSyoumetuKbn = editPalRenkeiKoumoku.editMosSyoumetuKbn(C_SeirituKbn.HUSEIRITU, C_Ketkekkacd.YUUKOUKKNKKA);

        exStringEquals(mosSyoumetuKbn, "5", "申込消滅区分");
    }

    @Test
    @TestOrder(130)
    public void testEditMosSyoumetuKbn_A13() {

        String mosSyoumetuKbn = editPalRenkeiKoumoku.editMosSyoumetuKbn(C_SeirituKbn.NONE, C_Ketkekkacd.YUUKOUKKNKKA);

        exStringEquals(mosSyoumetuKbn, "0", "申込消滅区分");
    }

    @Test
    @TestOrder(140)
    public void testEditMosSyoumetuKbn_A14() {

        String mosSyoumetuKbn = editPalRenkeiKoumoku.editMosSyoumetuKbn(C_SeirituKbn.ITIPMATI, C_Ketkekkacd.BLNK);

        exStringEquals(mosSyoumetuKbn, "0", "申込消滅区分");
        MockObjectManager.initialize();
    }
}