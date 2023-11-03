package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#tsindousiteikbnHenkan()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_tsindousiteikbnHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testTsindousiteikbnHenkan_A1(){

        String pKykdoukyohyj = "1";

        C_TsindousiteiKbn tsindousiteiKbn = editSeihoWebRenkeiKoumoku.tsindousiteikbnHenkan(pKykdoukyohyj);

        exClassificationEquals(tsindousiteiKbn, C_TsindousiteiKbn.ARI, "通信先同一指定区分");
    }

    @Test
    @TestOrder(20)
    public void testTsindousiteikbnHenkan_A2(){

        String pKykdoukyohyj = "2";

        C_TsindousiteiKbn tsindousiteiKbn = editSeihoWebRenkeiKoumoku.tsindousiteikbnHenkan(pKykdoukyohyj);

        exClassificationEquals(tsindousiteiKbn, C_TsindousiteiKbn.BLNK, "通信先同一指定区分");
    }

}
