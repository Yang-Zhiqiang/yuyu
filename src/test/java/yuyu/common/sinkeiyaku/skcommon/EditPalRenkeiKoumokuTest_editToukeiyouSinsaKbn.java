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
 * {@link EditPalRenkeiKoumoku#editToukeiyouSinsaKbn(C_SntkhouKbn)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editToukeiyouSinsaKbn {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditToukeiyouSinsaKbn_A1() {

        String toukeiyouSinsaKbn = editPalRenkeiKoumoku.editToukeiyouSinsaKbn(C_SntkhouKbn.KKT);

        exStringEquals(toukeiyouSinsaKbn, "10", "統計用診査区分");
    }

    @Test
    @TestOrder(20)
    public void testEditToukeiyouSinsaKbn_A2() {

        String toukeiyouSinsaKbn = editPalRenkeiKoumoku.editToukeiyouSinsaKbn(C_SntkhouKbn.SYOKUGYOU);

        exStringEquals(toukeiyouSinsaKbn, "10", "統計用診査区分");
    }

    @Test
    @TestOrder(30)
    public void testEditToukeiyouSinsaKbn_A3() {

        String toukeiyouSinsaKbn = editPalRenkeiKoumoku.editToukeiyouSinsaKbn(C_SntkhouKbn.NONE);

        exStringEquals(toukeiyouSinsaKbn, "14", "統計用診査区分");
    }

    @Test
    @TestOrder(40)
    public void testEditToukeiyouSinsaKbn_A4() {

        String toukeiyouSinsaKbn = editPalRenkeiKoumoku.editToukeiyouSinsaKbn(C_SntkhouKbn.HJY);

        exStringEquals(toukeiyouSinsaKbn, "00", "統計用診査区分");
    }

    @Test
    @TestOrder(50)
    public void testEditToukeiyouSinsaKbn_A5() {

        String toukeiyouSinsaKbn = editPalRenkeiKoumoku.editToukeiyouSinsaKbn(C_SntkhouKbn.BLNK);

        exStringEquals(toukeiyouSinsaKbn, "00", "統計用診査区分");
        MockObjectManager.initialize();
    }
}