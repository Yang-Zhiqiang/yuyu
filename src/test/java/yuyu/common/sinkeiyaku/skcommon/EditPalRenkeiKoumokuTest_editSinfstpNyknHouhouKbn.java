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
 * {@link EditPalRenkeiKoumoku#editSinfstpNyknHouhouKbn(C_UmuKbn)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editSinfstpNyknHouhouKbn {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditSinfstpNyknHouhouKbn_A1() {

        String sinfstpNyknHouhouKbn = editPalRenkeiKoumoku.editSinfstpNyknHouhouKbn(C_UmuKbn.ARI);

        exStringEquals(sinfstpNyknHouhouKbn, "08", "新初回Ｐ入金方法区分");
    }

    @Test
    @TestOrder(20)
    public void testEditSinfstpNyknHouhouKbn_A2() {

        String sinfstpNyknHouhouKbn = editPalRenkeiKoumoku.editSinfstpNyknHouhouKbn(C_UmuKbn.NONE);

        exStringEquals(sinfstpNyknHouhouKbn, "00", "新初回Ｐ入金方法区分");
        MockObjectManager.initialize();
    }
}