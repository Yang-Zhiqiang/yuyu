package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SntkhouKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#sntkhoukbnHenkan()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_sntkhoukbnHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testSntkhoukbnHenkan_A1(){

        String pSntkhouKbn = "1";
        C_SntkhouKbn sntkhouKbn = editSeihoWebRenkeiKoumoku.sntkhoukbnHenkan(pSntkhouKbn);
        exClassificationEquals(sntkhouKbn, C_SntkhouKbn.HJY, "選択方法区分");
    }

    @Test
    @TestOrder(20)
    public void testSntkhoukbnHenkan_A2(){

        String pSntkhouKbn = "2";
        C_SntkhouKbn sntkhouKbn = editSeihoWebRenkeiKoumoku.sntkhoukbnHenkan(pSntkhouKbn);
        exClassificationEquals(sntkhouKbn, C_SntkhouKbn.KKT, "選択方法区分");
    }

    @Test
    @TestOrder(30)
    public void testSntkhoukbnHenkan_A3(){

        String pSntkhouKbn = "3";
        C_SntkhouKbn sntkhouKbn = editSeihoWebRenkeiKoumoku.sntkhoukbnHenkan(pSntkhouKbn);
        exClassificationEquals(sntkhouKbn, C_SntkhouKbn.NONE, "選択方法区分");
    }

    @Test
    @TestOrder(40)
    public void testSntkhoukbnHenkan_A4(){

        String pSntkhouKbn = "4";
        C_SntkhouKbn sntkhouKbn = editSeihoWebRenkeiKoumoku.sntkhoukbnHenkan(pSntkhouKbn);
        exClassificationEquals(sntkhouKbn, C_SntkhouKbn.BLNK, "選択方法区分");
    }
}
