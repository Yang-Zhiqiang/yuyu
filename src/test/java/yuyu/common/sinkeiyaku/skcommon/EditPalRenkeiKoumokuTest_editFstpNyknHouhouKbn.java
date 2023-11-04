package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editFstpNyknHouhouKbn(C_UmuKbn, C_FstphrkkeiroKbn)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editFstpNyknHouhouKbn {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditFstpNyknHouhouKbn_A1() {

        String fstpNyknHouhouKbn = editPalRenkeiKoumoku.editFstpNyknHouhouKbn(C_UmuKbn.ARI, C_FstphrkkeiroKbn.CREDIT);

        exStringEquals(fstpNyknHouhouKbn, "8", "初回Ｐ入金方法区分");
    }

    @Test
    @TestOrder(20)
    public void testEditFstpNyknHouhouKbn_A2() {

        String fstpNyknHouhouKbn = editPalRenkeiKoumoku.editFstpNyknHouhouKbn(C_UmuKbn.NONE, C_FstphrkkeiroKbn.CREDIT);

        exStringEquals(fstpNyknHouhouKbn, "0", "初回Ｐ入金方法区分");
    }

    @Test
    @TestOrder(30)
    public void testEditFstpNyknHouhouKbn_A3() {

        String fstpNyknHouhouKbn = editPalRenkeiKoumoku.editFstpNyknHouhouKbn(C_UmuKbn.ARI, C_FstphrkkeiroKbn.BLNK);

        exStringEquals(fstpNyknHouhouKbn, "0", "初回Ｐ入金方法区分");
    }

    @Test
    @TestOrder(40)
    public void testEditFstpNyknHouhouKbn_A4() {

        String fstpNyknHouhouKbn = editPalRenkeiKoumoku.editFstpNyknHouhouKbn(C_UmuKbn.ARI, C_FstphrkkeiroKbn.HURIKOMI);

        exStringEquals(fstpNyknHouhouKbn, "0", "初回Ｐ入金方法区分");
    }

    @Test
    @TestOrder(50)
    public void testEditFstpNyknHouhouKbn_A5() {

        String fstpNyknHouhouKbn = editPalRenkeiKoumoku.editFstpNyknHouhouKbn(C_UmuKbn.ARI, C_FstphrkkeiroKbn.KOUHURI);

        exStringEquals(fstpNyknHouhouKbn, "0", "初回Ｐ入金方法区分");
    }

    @Test
    @TestOrder(60)
    public void testEditFstpNyknHouhouKbn_A6() {

        String fstpNyknHouhouKbn = editPalRenkeiKoumoku.editFstpNyknHouhouKbn(C_UmuKbn.ARI, C_FstphrkkeiroKbn.CONVENIENCE);

        exStringEquals(fstpNyknHouhouKbn, "0", "初回Ｐ入金方法区分");
        MockObjectManager.initialize();
    }
}