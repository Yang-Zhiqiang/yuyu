package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editHhknnen(int)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editHhknnen {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditHhknnen_A1() {

        String hhknnen = editPalRenkeiKoumoku.editHhknnen(9);

        exStringEquals(hhknnen, "09", "被保険者年令");
    }

    @Test
    @TestOrder(20)
    public void testEditHhknnen_A2() {

        String hhknnen = editPalRenkeiKoumoku.editHhknnen(100);

        exStringEquals(hhknnen, "99", "被保険者年令");
    }

    @Test
    @TestOrder(30)
    public void testEditHhknnen_A3() {

        String hhknnen = editPalRenkeiKoumoku.editHhknnen(101);

        exStringEquals(hhknnen, "99", "被保険者年令");

        MockObjectManager.initialize();

    }
}