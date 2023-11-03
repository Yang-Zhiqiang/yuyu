package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editTuukaKbn(C_Tuukasyu)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editTuukaKbn {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditTuukaKbn_A1() {

        String tuukaKbn = editPalRenkeiKoumoku.editTuukaKbn(C_Tuukasyu.USD);

        exStringEquals(tuukaKbn, "1", "通貨区分");
    }

    @Test
    @TestOrder(20)
    public void testEditTuukaKbn_A2() {

        String tuukaKbn = editPalRenkeiKoumoku.editTuukaKbn(C_Tuukasyu.EUR);

        exStringEquals(tuukaKbn, "2", "通貨区分");
    }

    @Test
    @TestOrder(30)
    public void testEditTuukaKbn_A3() {

        String tuukaKbn = editPalRenkeiKoumoku.editTuukaKbn(C_Tuukasyu.AUD);

        exStringEquals(tuukaKbn, "3", "通貨区分");
    }

    @Test
    @TestOrder(40)
    public void testEditTuukaKbn_A4() {

        String tuukaKbn = editPalRenkeiKoumoku.editTuukaKbn(C_Tuukasyu.JPY);

        exStringEquals(tuukaKbn, "0", "通貨区分");
        MockObjectManager.initialize();
    }
}