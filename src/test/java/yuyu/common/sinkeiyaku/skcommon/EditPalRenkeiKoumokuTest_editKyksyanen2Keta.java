package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KykKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editKyksyanen2Keta(C_KykKbn, int, int)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editKyksyanen2Keta {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditKyksyanen2Keta_A1() {

        String kyksyanen2Keta = editPalRenkeiKoumoku.editKyksyanen2Keta(C_KykKbn.KEIHI_BETU, 0, 9);

        exStringEquals(kyksyanen2Keta, "09", "契約者年令（２桁）");
    }

    @Test
    @TestOrder(20)
    public void testEditKyksyanen2Keta_A2() {

        String kyksyanen2Keta = editPalRenkeiKoumoku.editKyksyanen2Keta(C_KykKbn.KEIHI_BETU, 0, 100);

        exStringEquals(kyksyanen2Keta, "99", "契約者年令（２桁）");
    }

    @Test
    @TestOrder(30)
    public void testEditKyksyanen2Keta_A3() {

        String kyksyanen2Keta = editPalRenkeiKoumoku.editKyksyanen2Keta(C_KykKbn.KEIHI_BETU, 0, 101);

        exStringEquals(kyksyanen2Keta, "99", "契約者年令（２桁）");
    }

    @Test
    @TestOrder(40)
    public void testEditKyksyanen2Keta_A4() {

        String kyksyanen2Keta = editPalRenkeiKoumoku.editKyksyanen2Keta(C_KykKbn.BLNK, 9, 0);

        exStringEquals(kyksyanen2Keta, "09", "契約者年令（２桁）");
    }

    @Test
    @TestOrder(50)
    public void testEditKyksyanen2Keta_A5() {

        String kyksyanen2Keta = editPalRenkeiKoumoku.editKyksyanen2Keta(C_KykKbn.BLNK, 100, 0);

        exStringEquals(kyksyanen2Keta, "99", "契約者年令（２桁）");
    }

    @Test
    @TestOrder(60)
    public void testEditKyksyanen2Keta_A6() {

        String kyksyanen2Keta = editPalRenkeiKoumoku.editKyksyanen2Keta(C_KykKbn.BLNK, 101, 0);

        exStringEquals(kyksyanen2Keta, "99", "契約者年令（２桁）");
    }

    @Test
    @TestOrder(70)
    public void testEditKyksyanen2Keta_A7() {

        String kyksyanen2Keta = editPalRenkeiKoumoku.editKyksyanen2Keta(C_KykKbn.KEIHI_DOUITU, 99, 0);

        exStringEquals(kyksyanen2Keta, "99", "契約者年令（２桁）");
        MockObjectManager.initialize();
    }
}