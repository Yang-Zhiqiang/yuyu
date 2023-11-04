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
 * {@link EditPalRenkeiKoumoku#editKyknmkj(C_KykKbn, String, String, int)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editKyknmkj {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditKyknmkj_A1() {

        String kyknmkj = editPalRenkeiKoumoku.editKyknmkj(C_KykKbn.KEIHI_BETU, "内藤内藤内藤内", "小李小李", 5);

        exStringEquals(kyknmkj, "小李小李", "契約者名（漢字）");
    }

    @Test
    @TestOrder(20)
    public void testEditKyknmkj_A2() {

        String kyknmkj = editPalRenkeiKoumoku.editKyknmkj(C_KykKbn.KEIHI_BETU, "内藤内藤内藤内", "小李小李小", 5);

        exStringEquals(kyknmkj, "小李小李小", "契約者名（漢字）");
    }

    @Test
    @TestOrder(30)
    public void testEditKyknmkj_A3() {

        String kyknmkj = editPalRenkeiKoumoku.editKyknmkj(C_KykKbn.KEIHI_BETU, "内藤内藤内藤内", "小李小李小李", 5);

        exStringEquals(kyknmkj, "小李小李小", "契約者名（漢字）");
    }

    @Test
    @TestOrder(40)
    public void testEditKyknmkj_A4() {

        String kyknmkj = editPalRenkeiKoumoku.editKyknmkj(C_KykKbn.BLNK, "内藤内藤", "小李小李小李", 5);

        exStringEquals(kyknmkj, "内藤内藤", "契約者名（漢字）");
    }

    @Test
    @TestOrder(50)
    public void testEditKyknmkj_A5() {

        String kyknmkj = editPalRenkeiKoumoku.editKyknmkj(C_KykKbn.BLNK, "内藤内藤内", "小李小李小李", 5);

        exStringEquals(kyknmkj, "内藤内藤内", "契約者名（漢字）");
    }

    @Test
    @TestOrder(60)
    public void testEditKyknmkj_A6() {

        String kyknmkj = editPalRenkeiKoumoku.editKyknmkj(C_KykKbn.BLNK, "内藤内藤内藤", "小李小李小李", 5);

        exStringEquals(kyknmkj, "内藤内藤内", "契約者名（漢字）");
    }

    @Test
    @TestOrder(70)
    public void testEditKyknmkj_A7() {

        String kyknmkj = editPalRenkeiKoumoku.editKyknmkj(C_KykKbn.KEIHI_DOUITU, "内藤内藤", "小李小李小李", 5);

        exStringEquals(kyknmkj, "内藤内藤", "契約者名（漢字）");
    }

    @Test
    @TestOrder(80)
    public void testEditKyknmkj_A8() {

        String kyknmkj = editPalRenkeiKoumoku.editKyknmkj(C_KykKbn.KEIHI_DOUITU, "内藤内藤内", "小李小李小李", 5);

        exStringEquals(kyknmkj, "内藤内藤内", "契約者名（漢字）");
    }

    @Test
    @TestOrder(90)
    public void testEditKyknmkj_A9() {

        String kyknmkj = editPalRenkeiKoumoku.editKyknmkj(C_KykKbn.KEIHI_DOUITU, "内藤内藤内藤", "小李小李小李", 5);

        exStringEquals(kyknmkj, "内藤内藤内", "契約者名（漢字）");
        MockObjectManager.initialize();
    }
}