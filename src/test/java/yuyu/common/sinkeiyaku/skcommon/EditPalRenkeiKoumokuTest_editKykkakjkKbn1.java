package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editKykKakjkKbn1(C_KykkakjkKbn, C_SeirituKbn, C_UmuKbn)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editKykkakjkKbn1 {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditKykkakjkKbn1_A1() {

        String kykKakjkKbn1 = editPalRenkeiKoumoku.editKykKakjkKbn1(C_KykkakjkKbn.KAKUNIN_SUMI, null, null);

        exStringEquals(kykKakjkKbn1, "4", "契約確認状況区分（1文字）");
    }

    @Test
    @TestOrder(20)
    public void testEditKykkakjkKbn1_A2() {

        String kykKakjkKbn1 = editPalRenkeiKoumoku.editKykKakjkKbn1(C_KykkakjkKbn.SEIRITUGO_KAK_IRAISU, null, null);

        exStringEquals(kykKakjkKbn1, "2", "契約確認状況区分（1文字）");
    }

    @Test
    @TestOrder(30)
    public void testEditKykkakjkKbn1_A3() {

        String kykKakjkKbn1 = editPalRenkeiKoumoku.editKykKakjkKbn1(
            C_KykkakjkKbn.KETMAE_KAKUNIN, C_SeirituKbn.HUSEIRITU, null);

        exStringEquals(kykKakjkKbn1, "4", "契約確認状況区分（1文字）");
    }

    @Test
    @TestOrder(40)
    public void testEditKykkakjkKbn1_A4() {

        String kykKakjkKbn1 = editPalRenkeiKoumoku.editKykKakjkKbn1(
            C_KykkakjkKbn.KETMAE_KAKUNIN, C_SeirituKbn.SEIRITU, null);

        exStringEquals(kykKakjkKbn1, "2", "契約確認状況区分（1文字）");
    }

    @Test
    @TestOrder(50)
    public void testEditKykkakjkKbn1_A5() {

        String kykKakjkKbn1 = editPalRenkeiKoumoku.editKykKakjkKbn1(
            C_KykkakjkKbn.KETHORYU_KAKUNIN, C_SeirituKbn.HUSEIRITU, null);

        exStringEquals(kykKakjkKbn1, "4", "契約確認状況区分（1文字）");
    }

    @Test
    @TestOrder(60)
    public void testEditKykkakjkKbn1_A6() {

        String kykKakjkKbn1 = editPalRenkeiKoumoku.editKykKakjkKbn1(
            C_KykkakjkKbn.KETHORYU_KAKUNIN, C_SeirituKbn.SEIRITU, null);

        exStringEquals(kykKakjkKbn1, "2", "契約確認状況区分（1文字）");
    }

    @Test
    @TestOrder(70)
    public void testEditKykkakjkKbn1_A7() {

        String kykKakjkKbn1 = editPalRenkeiKoumoku.editKykKakjkKbn1(
            C_KykkakjkKbn.NONE, C_SeirituKbn.HUSEIRITU, null);

        exStringEquals(kykKakjkKbn1, "0", "契約確認状況区分（1文字）");
    }

    @Test
    @TestOrder(80)
    public void testEditKykkakjkKbn1_A8() {

        String kykKakjkKbn1 = editPalRenkeiKoumoku.editKykKakjkKbn1(
            C_KykkakjkKbn.KETMAE_KAKUNIN, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI);

        exStringEquals(kykKakjkKbn1, "3", "契約確認状況区分（1文字）");
    }

    @Test
    @TestOrder(90)
    public void testEditKykkakjkKbn1_A9() {

        String kykKakjkKbn1 = editPalRenkeiKoumoku.editKykKakjkKbn1(
            C_KykkakjkKbn.KETMAE_KAKUNIN, C_SeirituKbn.NONE, C_UmuKbn.ARI);

        exStringEquals(kykKakjkKbn1, "3", "契約確認状況区分（1文字）");
    }

    @Test
    @TestOrder(100)
    public void testEditKykkakjkKbn1_A10() {

        String kykKakjkKbn1 = editPalRenkeiKoumoku.editKykKakjkKbn1(
            C_KykkakjkKbn.KETMAE_KAKUNIN, C_SeirituKbn.SEIRITU, C_UmuKbn.NONE);

        exStringEquals(kykKakjkKbn1, "2", "契約確認状況区分（1文字）");
    }

    @Test
    @TestOrder(110)
    public void testEditKykkakjkKbn1_A11() {

        String kykKakjkKbn1 = editPalRenkeiKoumoku.editKykKakjkKbn1(
            C_KykkakjkKbn.KETHORYU_KAKUNIN, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI);

        exStringEquals(kykKakjkKbn1, "3", "契約確認状況区分（1文字）");
    }

    @Test
    @TestOrder(120)
    public void testEditKykkakjkKbn1_A12() {

        String kykKakjkKbn1 = editPalRenkeiKoumoku.editKykKakjkKbn1(
            C_KykkakjkKbn.KETHORYU_KAKUNIN, C_SeirituKbn.NONE, C_UmuKbn.ARI);

        exStringEquals(kykKakjkKbn1, "3", "契約確認状況区分（1文字）");
    }

    @Test
    @TestOrder(130)
    public void testEditKykkakjkKbn1_A13() {

        String kykKakjkKbn1 = editPalRenkeiKoumoku.editKykKakjkKbn1(
            C_KykkakjkKbn.KETHORYU_KAKUNIN, C_SeirituKbn.SEIRITU, C_UmuKbn.NONE);

        exStringEquals(kykKakjkKbn1, "2", "契約確認状況区分（1文字）");
    }

    @Test
    @TestOrder(140)
    public void testEditKykkakjkKbn1_A14() {

        String kykKakjkKbn1 = editPalRenkeiKoumoku.editKykKakjkKbn1(
            C_KykkakjkKbn.NONE, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI);

        exStringEquals(kykKakjkKbn1, "0", "契約確認状況区分（1文字）");
    }

    @Test
    @TestOrder(150)
    public void testEditKykkakjkKbn1_A15() {

        String kykKakjkKbn1 = editPalRenkeiKoumoku.editKykKakjkKbn1(
            C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY, C_SeirituKbn.ITIPMATI, C_UmuKbn.ARI);

        exStringEquals(kykKakjkKbn1, "0", "契約確認状況区分（1文字）");
        MockObjectManager.initialize();
    }

}