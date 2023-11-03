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
 * {@link EditPalRenkeiKoumoku#editKyknmkn(C_KykKbn, String, String, int)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editKyknmkn {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditKyknmkn_A1() {

        String kyknmkn = editPalRenkeiKoumoku.editKyknmkn(C_KykKbn.KEIHI_BETU, "カクカクカク", "モリモリ", 5);

        exStringEquals(kyknmkn, "モリモリ", "契約者名（カナ）");
    }

    @Test
    @TestOrder(20)
    public void testEditKyknmkn_A2() {

        String kyknmkn = editPalRenkeiKoumoku.editKyknmkn(C_KykKbn.KEIHI_BETU, "カクカクカク", "モリモリモ", 5);

        exStringEquals(kyknmkn, "モリモリモ", "契約者名（カナ）");
    }

    @Test
    @TestOrder(30)
    public void testEditKyknmkn_A3() {

        String kyknmkn = editPalRenkeiKoumoku.editKyknmkn(C_KykKbn.KEIHI_BETU, "カクカクカク", "モリモリモリ", 5);

        exStringEquals(kyknmkn, "モリモリモ", "契約者名（カナ）");
    }

    @Test
    @TestOrder(40)
    public void testEditKyknmkn_A4() {

        String kyknmkn = editPalRenkeiKoumoku.editKyknmkn(C_KykKbn.BLNK, "カクカク", "モリモリモリ", 5);

        exStringEquals(kyknmkn, "カクカク", "契約者名（カナ）");
    }

    @Test
    @TestOrder(50)
    public void testEditKyknmkn_A5() {

        String kyknmkn = editPalRenkeiKoumoku.editKyknmkn(C_KykKbn.BLNK, "カクカクカ", "モリモリモリ", 5);

        exStringEquals(kyknmkn, "カクカクカ", "契約者名（カナ）");
    }

    @Test
    @TestOrder(60)
    public void testEditKyknmkn_A6() {

        String kyknmkn = editPalRenkeiKoumoku.editKyknmkn(C_KykKbn.BLNK, "カクカクカク", "モリモリモリ", 5);

        exStringEquals(kyknmkn, "カクカクカ", "契約者名（カナ）");
    }

    @Test
    @TestOrder(70)
    public void testEditKyknmkn_A7() {

        String kyknmkn = editPalRenkeiKoumoku.editKyknmkn(C_KykKbn.KEIHI_DOUITU, "カクカク", "モリモリモリ", 5);

        exStringEquals(kyknmkn, "カクカク", "契約者名（カナ）");
    }

    @Test
    @TestOrder(80)
    public void testEditKyknmkn_A8() {

        String kyknmkn = editPalRenkeiKoumoku.editKyknmkn(C_KykKbn.KEIHI_DOUITU, "カクカクカ", "モリモリモリ", 5);

        exStringEquals(kyknmkn, "カクカクカ", "契約者名（カナ）");
    }

    @Test
    @TestOrder(90)
    public void testEditKyknmkn_A9() {

        String kyknmkn = editPalRenkeiKoumoku.editKyknmkn(C_KykKbn.KEIHI_DOUITU, "カクカクカク", "モリモリモリ", 5);

        exStringEquals(kyknmkn, "カクカクカ", "契約者名（カナ）");
        MockObjectManager.initialize();
    }
}