package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SntkhouKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editHjykktKbn(C_SntkhouKbn)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editHjykktKbn {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditHjykktKbn_A1() {

        String hjykktKbn = editPalRenkeiKoumoku.editHjykktKbn(C_SntkhouKbn.HJY);

        exStringEquals(hjykktKbn, "1", "報状告知区分");
    }

    @Test
    @TestOrder(20)
    public void testEditHjykktKbn_A2() {

        String hjykktKbn = editPalRenkeiKoumoku.editHjykktKbn(C_SntkhouKbn.KKT);

        exStringEquals(hjykktKbn, "2", "報状告知区分");

        MockObjectManager.initialize();
    }
}