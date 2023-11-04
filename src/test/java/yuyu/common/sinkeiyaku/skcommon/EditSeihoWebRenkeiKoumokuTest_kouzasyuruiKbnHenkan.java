package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド {@link EditSeihoWebRenkeiKoumoku#kouzasyuruiKbnHenkan(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_kouzasyuruiKbnHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testKouzasyuruiKbnHenkan_A1() {

        C_KouzasyuruiKbn kouzasyuruiKbn = editSeihoWebRenkeiKoumoku.kouzasyuruiKbnHenkan("1");

        exClassificationEquals(kouzasyuruiKbn, C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");

    }

    @Test
    @TestOrder(20)
    public void testKouzasyuruiKbnHenkan_A2() {

        C_KouzasyuruiKbn kouzasyuruiKbn = editSeihoWebRenkeiKoumoku.kouzasyuruiKbnHenkan("2");

        exClassificationEquals(kouzasyuruiKbn, C_KouzasyuruiKbn.GAIKAKOUZA, "口座種類区分");

    }

    @Test
    @TestOrder(30)
    public void testKouzasyuruiKbnHenkan_A3() {

        C_KouzasyuruiKbn kouzasyuruiKbn = editSeihoWebRenkeiKoumoku.kouzasyuruiKbnHenkan("3");

        exClassificationEquals(kouzasyuruiKbn, C_KouzasyuruiKbn.BLNK, "口座種類区分");

    }

}
