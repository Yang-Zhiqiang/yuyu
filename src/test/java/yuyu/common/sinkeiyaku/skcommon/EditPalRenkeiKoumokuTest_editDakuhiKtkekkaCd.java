package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Ketkekkacd;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editDakuhiKtkekkaCd(C_Ketkekkacd)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editDakuhiKtkekkaCd {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditDakuhiKtkekkaCd_A1() {

        String dakuhiKtkekkaCd = editPalRenkeiKoumoku.editDakuhiKtkekkaCd(C_Ketkekkacd.MUJYOUKEN);

        exStringEquals(dakuhiKtkekkaCd, "10", "諾否決定結果コード");
    }

    @Test
    @TestOrder(20)
    public void testEditDakuhiKtkekkaCd_A2() {

        String dakuhiKtkekkaCd = editPalRenkeiKoumoku.editDakuhiKtkekkaCd(C_Ketkekkacd.GENKAITAI_SYOUDAKU);

        exStringEquals(dakuhiKtkekkaCd, "13", "諾否決定結果コード");
    }

    @Test
    @TestOrder(30)
    public void testEditDakuhiKtkekkaCd_A3() {

        String dakuhiKtkekkaCd = editPalRenkeiKoumoku.editDakuhiKtkekkaCd(C_Ketkekkacd.ENKI_SIJINASI);

        exStringEquals(dakuhiKtkekkaCd, "70", "諾否決定結果コード");
    }

    @Test
    @TestOrder(40)
    public void testEditDakuhiKtkekkaCd_A4() {

        String dakuhiKtkekkaCd = editPalRenkeiKoumoku.editDakuhiKtkekkaCd(C_Ketkekkacd.ENKI_SUUNENGOSAISIN);

        exStringEquals(dakuhiKtkekkaCd, "75", "諾否決定結果コード");
    }

    @Test
    @TestOrder(50)
    public void testEditDakuhiKtkekkaCd_A5() {

        String dakuhiKtkekkaCd = editPalRenkeiKoumoku.editDakuhiKtkekkaCd(C_Ketkekkacd.MIAWASE);

        exStringEquals(dakuhiKtkekkaCd, "80", "諾否決定結果コード");
    }

    @Test
    @TestOrder(60)
    public void testEditDakuhiKtkekkaCd_A6() {

        String dakuhiKtkekkaCd = editPalRenkeiKoumoku.editDakuhiKtkekkaCd(C_Ketkekkacd.BLNK);

        exStringEquals(dakuhiKtkekkaCd, "", "諾否決定結果コード");
    }

    @Test
    @TestOrder(70)
    public void testEditDakuhiKtkekkaCd_A7() {

        String dakuhiKtkekkaCd = editPalRenkeiKoumoku.editDakuhiKtkekkaCd(C_Ketkekkacd.JYOUKENTUKI);

        exStringEquals(dakuhiKtkekkaCd, "", "諾否決定結果コード");
    }

    @Test
    @TestOrder(80)
    public void testEditDakuhiKtkekkaCd_A8() {

        String dakuhiKtkekkaCd = editPalRenkeiKoumoku.editDakuhiKtkekkaCd(C_Ketkekkacd.TOKUBETUJYOUKEN);

        exStringEquals(dakuhiKtkekkaCd, "", "諾否決定結果コード");
    }

    @Test
    @TestOrder(90)
    public void testEditDakuhiKtkekkaCd_A9() {

        String dakuhiKtkekkaCd = editPalRenkeiKoumoku.editDakuhiKtkekkaCd(C_Ketkekkacd.TKJY_JYOUKENTUKI_HEI);

        exStringEquals(dakuhiKtkekkaCd, "", "諾否決定結果コード");
    }

    @Test
    @TestOrder(100)
    public void testEditDakuhiKtkekkaCd_A10() {

        String dakuhiKtkekkaCd = editPalRenkeiKoumoku.editDakuhiKtkekkaCd(C_Ketkekkacd.COOLINGOFF);

        exStringEquals(dakuhiKtkekkaCd, "", "諾否決定結果コード");
    }

    @Test
    @TestOrder(110)
    public void testEditDakuhiKtkekkaCd_A11() {

        String dakuhiKtkekkaCd = editPalRenkeiKoumoku.editDakuhiKtkekkaCd(C_Ketkekkacd.MOS_TORIKESI);

        exStringEquals(dakuhiKtkekkaCd, "", "諾否決定結果コード");
    }

    @Test
    @TestOrder(120)
    public void testEditDakuhiKtkekkaCd_A12() {

        String dakuhiKtkekkaCd = editPalRenkeiKoumoku.editDakuhiKtkekkaCd(C_Ketkekkacd.YUUKOUKKNKKA);

        exStringEquals(dakuhiKtkekkaCd, "", "諾否決定結果コード");
    }

    @Test
    @TestOrder(130)
    public void testEditDakuhiKtkekkaCd_A13() {

        String dakuhiKtkekkaCd = editPalRenkeiKoumoku.editDakuhiKtkekkaCd(C_Ketkekkacd.SYOKAIPKOUHUNOU);

        exStringEquals(dakuhiKtkekkaCd, "", "諾否決定結果コード");
    }

    @Test
    @TestOrder(140)
    public void testEditDakuhiKtkekkaCd_A14() {

        String dakuhiKtkekkaCd = editPalRenkeiKoumoku.editDakuhiKtkekkaCd(C_Ketkekkacd.HUBI_MATI);

        exStringEquals(dakuhiKtkekkaCd, "", "諾否決定結果コード");
    }

    @Test
    @TestOrder(150)
    public void testEditDakuhiKtkekkaCd_A15() {

        String dakuhiKtkekkaCd = editPalRenkeiKoumoku.editDakuhiKtkekkaCd(C_Ketkekkacd.HAND_KETTEI);

        exStringEquals(dakuhiKtkekkaCd, "", "諾否決定結果コード");
    }

    @Test
    @TestOrder(160)
    public void testEditDakuhiKtkekkaCd_A16() {

        String dakuhiKtkekkaCd = editPalRenkeiKoumoku.editDakuhiKtkekkaCd(C_Ketkekkacd.KYOUSEIHAND_KETTEI);

        exStringEquals(dakuhiKtkekkaCd, "", "諾否決定結果コード");

        MockObjectManager.initialize();

    }
}