package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド {@link EditSeihoWebRenkeiKoumoku#hknkknSyutoku(Integer, Integer, C_HknsyuruiNo)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_hknkknSyutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testHknkknSyutoku_A1() {

        int hknkkn = editSeihoWebRenkeiKoumoku.hknkknSyutoku(10, 15, C_HknsyuruiNo.GAIKAINDEXNK);

        exNumericEquals(hknkkn, 15, "保険期間");

    }

    @Test
    @TestOrder(20)
    public void testHknkknSyutoku_A2() {

        int hknkkn = editSeihoWebRenkeiKoumoku.hknkknSyutoku(10, 15, C_HknsyuruiNo.GAIKAINDEXNK_SISUU);

        exNumericEquals(hknkkn, 15, "保険期間");

    }

    @Test
    @TestOrder(30)
    public void testHknkknSyutoku_A3() {

        int hknkkn = editSeihoWebRenkeiKoumoku.hknkknSyutoku(10, 15, C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU);

        exNumericEquals(hknkkn, 15, "保険期間");

    }

    @Test
    @TestOrder(40)
    public void testHknkknSyutoku_A4() {

        int hknkkn = editSeihoWebRenkeiKoumoku.hknkknSyutoku(10, 15, C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU);

        exNumericEquals(hknkkn, 15, "保険期間");

    }

    @Test
    @TestOrder(50)
    public void testHknkknSyutoku_A5() {

        int hknkkn = editSeihoWebRenkeiKoumoku.hknkknSyutoku(10, 15, C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI);

        exNumericEquals(hknkkn, 15, "保険期間");

    }

    @Test
    @TestOrder(60)
    public void testHknkknSyutoku_A6() {

        int hknkkn = editSeihoWebRenkeiKoumoku.hknkknSyutoku(10, 15, C_HknsyuruiNo.GAIKARIRITUHENDOUNK);

        exNumericEquals(hknkkn, 10, "保険期間");

    }
}
