package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editNyknzumiHyouji(C_UmuKbn, C_UmuKbn)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editNyknzumiHyouji {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditNyknzumiHyouji_A1() {

        String nyknzumiHyouji = editPalRenkeiKoumoku.editNyknzumiHyouji(C_UmuKbn.ARI, C_UmuKbn.ARI);

        exStringEquals(nyknzumiHyouji, "1", "入金済表示");
    }

    @Test
    @TestOrder(20)
    public void testEditNyknzumiHyouji_A2() {

        String nyknzumiHyouji = editPalRenkeiKoumoku.editNyknzumiHyouji(C_UmuKbn.NONE, C_UmuKbn.ARI);

        exStringEquals(nyknzumiHyouji, "0", "入金済表示");
    }

    @Test
    @TestOrder(30)
    public void testEditNyknzumiHyouji_A3() {

        String nyknzumiHyouji = editPalRenkeiKoumoku.editNyknzumiHyouji(C_UmuKbn.ARI, C_UmuKbn.NONE);

        exStringEquals(nyknzumiHyouji, "0", "入金済表示");
    }

    @Test
    @TestOrder(40)
    public void testEditNyknzumiHyouji_A4() {

        String nyknzumiHyouji = editPalRenkeiKoumoku.editNyknzumiHyouji(C_UmuKbn.NONE, C_UmuKbn.NONE);

        exStringEquals(nyknzumiHyouji, "0", "入金済表示");
        MockObjectManager.initialize();
    }
}