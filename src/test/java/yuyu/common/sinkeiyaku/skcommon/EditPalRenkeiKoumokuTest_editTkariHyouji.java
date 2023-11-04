package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tkhukaumu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editTkariHyouji(C_Tkhukaumu)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editTkariHyouji {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditTkariHyouji_A1() {

        String tkariHyouji = editPalRenkeiKoumoku.editTkariHyouji(C_Tkhukaumu.HUKA);

        exStringEquals(tkariHyouji, "1", "特約有表示");
    }

    @Test
    @TestOrder(20)
    public void testEditTkariHyouji_A2() {

        String tkariHyouji = editPalRenkeiKoumoku.editTkariHyouji(C_Tkhukaumu.NONE);

        exStringEquals(tkariHyouji, "0", "特約有表示");
        MockObjectManager.initialize();
    }
}