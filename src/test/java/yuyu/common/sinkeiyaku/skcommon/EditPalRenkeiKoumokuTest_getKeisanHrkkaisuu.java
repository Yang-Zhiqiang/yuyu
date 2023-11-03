package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#getKeisanHrkkaisuu(C_Hrkkaisuu)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_getKeisanHrkkaisuu {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testGetKeisanHrkkaisuu_A1() {
        int keisanHrkkaisuu = editPalRenkeiKoumoku.getKeisanHrkkaisuu(C_Hrkkaisuu.TUKI);

        exNumericEquals(keisanHrkkaisuu, 1, "計算用払込回数");
    }

    @Test
    @TestOrder(20)
    public void testGetKeisanHrkkaisuu_A2() {
        int keisanHrkkaisuu = editPalRenkeiKoumoku.getKeisanHrkkaisuu(C_Hrkkaisuu.HALFY);

        exNumericEquals(keisanHrkkaisuu, 6, "計算用払込回数");
    }

    @Test
    @TestOrder(30)
    public void testGetKeisanHrkkaisuu_A3() {
        int keisanHrkkaisuu = editPalRenkeiKoumoku.getKeisanHrkkaisuu(C_Hrkkaisuu.NEN);

        exNumericEquals(keisanHrkkaisuu, 12, "計算用払込回数");
    }

    @Test
    @TestOrder(40)
    public void testGetKeisanHrkkaisuu_A4() {
        int keisanHrkkaisuu = editPalRenkeiKoumoku.getKeisanHrkkaisuu(C_Hrkkaisuu.BLNK);

        exNumericEquals(keisanHrkkaisuu, 1, "計算用払込回数");
    }

    @Test
    @TestOrder(50)
    public void testGetKeisanHrkkaisuu_A5() {
        int keisanHrkkaisuu = editPalRenkeiKoumoku.getKeisanHrkkaisuu(C_Hrkkaisuu.ITIJI);

        exNumericEquals(keisanHrkkaisuu, 1, "計算用払込回数");
    }

}
