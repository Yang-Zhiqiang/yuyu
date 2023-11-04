package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editKetasuuShiteiZeroUme(String, int)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editKetasuuShiteiZeroUme {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditKetasuuShiteiZeroUme_A1() {

        String HenkangoMoziretu = editPalRenkeiKoumoku.editKetasuuShiteiZeroUme(-1 ,2);

        exStringEquals(HenkangoMoziretu, "00", "変換後文字列");
    }

    @Test
    @TestOrder(20)
    public void testEditKetasuuShiteiZeroUme_A2() {

        String HenkangoMoziretu = editPalRenkeiKoumoku.editKetasuuShiteiZeroUme(0 ,2);

        exStringEquals(HenkangoMoziretu, "00", "変換後文字列");
    }

    @Test
    @TestOrder(30)
    public void testEditKetasuuShiteiZeroUme_A3() {

        String HenkangoMoziretu = editPalRenkeiKoumoku.editKetasuuShiteiZeroUme(15 ,2);

        exStringEquals(HenkangoMoziretu, "15", "変換後文字列");
    }

    @Test
    @TestOrder(40)
    public void testEditKetasuuShiteiZeroUme_A4() {

        String HenkangoMoziretu = editPalRenkeiKoumoku.editKetasuuShiteiZeroUme(100 ,2);

        exStringEquals(HenkangoMoziretu, "99", "変換後文字列");
    }

    @Test
    @TestOrder(50)
    public void testEditKetasuuShiteiZeroUme_A5() {

        String HenkangoMoziretu = editPalRenkeiKoumoku.editKetasuuShiteiZeroUme(5 ,2);

        exStringEquals(HenkangoMoziretu, "05", "変換後文字列");
    }
}