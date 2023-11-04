package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editNyknJkKbn(C_UmuKbn, BizDate, BizDateYM)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editNyknJkKbn {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditNyknJkKbn_A1() {

        String nyknJkKbn = editPalRenkeiKoumoku.editNyknJkKbn(C_UmuKbn.NONE, null, null);

        exStringEquals(nyknJkKbn, "0", "入金状況区分");
    }

    @Test
    @TestOrder(20)
    public void testEditNyknJkKbn_A2() {

        String nyknJkKbn = editPalRenkeiKoumoku.editNyknJkKbn(
            C_UmuKbn.ARI, BizDate.valueOf(20160105), BizDateYM.valueOf(201601));

        exStringEquals(nyknJkKbn, "1", "入金状況区分");
    }

    @Test
    @TestOrder(30)
    public void testEditNyknJkKbn_A3() {

        String nyknJkKbn = editPalRenkeiKoumoku.editNyknJkKbn(
            C_UmuKbn.ARI, BizDate.valueOf(20160131), BizDateYM.valueOf(201601));

        exStringEquals(nyknJkKbn, "1", "入金状況区分");
    }

    @Test
    @TestOrder(40)
    public void testEditNyknJkKbn_A4() {

        String nyknJkKbn = editPalRenkeiKoumoku.editNyknJkKbn(
            C_UmuKbn.ARI, BizDate.valueOf(20160505), BizDateYM.valueOf(201601));

        exStringEquals(nyknJkKbn, "2", "入金状況区分");
        MockObjectManager.initialize();
    }
}