package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_NensyuuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#hhknnensyuukbnSyutoku(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_hhknnensyuukbnSyutoku {
    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testHhknnensyuukbnSyutoku_A1() {

        String pHhknnensyuukbn = "1";
        C_NensyuuKbn nensyuuKbn = editSeihoWebRenkeiKoumoku.hhknnensyuukbnSyutoku(pHhknnensyuukbn);

        exClassificationEquals(nensyuuKbn, C_NensyuuKbn.UNDER300, "年収区分");
    }


    @Test
    @TestOrder(20)
    public void testHhknnensyuukbnSyutoku_A2() {

        String pHhknnensyuukbn = "2";
        C_NensyuuKbn nensyuuKbn = editSeihoWebRenkeiKoumoku.hhknnensyuukbnSyutoku(pHhknnensyuukbn);

        exClassificationEquals(nensyuuKbn, C_NensyuuKbn.UNDER500, "年収区分");
    }

    @Test
    @TestOrder(30)
    public void testHhknnensyuukbnSyutoku_A3() {

        String pHhknnensyuukbn = "3";
        C_NensyuuKbn nensyuuKbn = editSeihoWebRenkeiKoumoku.hhknnensyuukbnSyutoku(pHhknnensyuukbn);

        exClassificationEquals(nensyuuKbn, C_NensyuuKbn.UNDER700, "年収区分");
    }

    @Test
    @TestOrder(40)
    public void testHhknnensyuukbnSyutoku_A4() {

        String pHhknnensyuukbn = "4";
        C_NensyuuKbn nensyuuKbn = editSeihoWebRenkeiKoumoku.hhknnensyuukbnSyutoku(pHhknnensyuukbn);

        exClassificationEquals(nensyuuKbn, C_NensyuuKbn.UNDER1000, "年収区分");
    }
    @Test
    @TestOrder(50)
    public void testHhknnensyuukbnSyutoku_A5() {

        String pHhknnensyuukbn = "5";
        C_NensyuuKbn nensyuuKbn = editSeihoWebRenkeiKoumoku.hhknnensyuukbnSyutoku(pHhknnensyuukbn);

        exClassificationEquals(nensyuuKbn, C_NensyuuKbn.MORETHAN1000, "年収区分");
    }

    @Test
    @TestOrder(60)
    public void testHhknnensyuukbnSyutoku_A6() {

        String pHhknnensyuukbn = "0";
        C_NensyuuKbn nensyuuKbn = editSeihoWebRenkeiKoumoku.hhknnensyuukbnSyutoku(pHhknnensyuukbn);

        exClassificationEquals(nensyuuKbn, C_NensyuuKbn.BLNK, "年収区分");
    }


}
