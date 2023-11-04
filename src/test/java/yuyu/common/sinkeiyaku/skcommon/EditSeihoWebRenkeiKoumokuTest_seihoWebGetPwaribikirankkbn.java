package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_PWaribikitekiyouKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#seihoWebGetPwaribikirankkbn()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_seihoWebGetPwaribikirankkbn {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testSeihoWebGetPwaribikirankkbn_A1(){

        C_PWaribikitekiyouKbn pPwaribikitekiyoukbn = C_PWaribikitekiyouKbn.NONE;
        String seihowebPwaribikirankkbn = editSeihoWebRenkeiKoumoku.seihoWebGetPwaribikirankkbn(pPwaribikitekiyoukbn);
        exStringEquals(seihowebPwaribikirankkbn, "0", "生保Ｗｅｂ保険料割引ランク区分");
    }

    @Test
    @TestOrder(20)
    public void testSeihoWebGetPwaribikirankkbn_A2(){

        C_PWaribikitekiyouKbn pPwaribikitekiyoukbn = C_PWaribikitekiyouKbn.PWARISEIDO_NONE;
        String seihowebPwaribikirankkbn = editSeihoWebRenkeiKoumoku.seihoWebGetPwaribikirankkbn(pPwaribikitekiyoukbn);
        exStringEquals(seihowebPwaribikirankkbn, "0", "生保Ｗｅｂ保険料割引ランク区分");
    }

    @Test
    @TestOrder(30)
    public void testSeihoWebGetPwaribikirankkbn_A3(){

        C_PWaribikitekiyouKbn pPwaribikitekiyoukbn = C_PWaribikitekiyouKbn.PWARISEIDO_RANK01;
        String seihowebPwaribikirankkbn = editSeihoWebRenkeiKoumoku.seihoWebGetPwaribikirankkbn(pPwaribikitekiyoukbn);
        exStringEquals(seihowebPwaribikirankkbn, "1", "生保Ｗｅｂ保険料割引ランク区分");
    }

    @Test
    @TestOrder(40)
    public void testSeihoWebGetPwaribikirankkbn_A4(){

        C_PWaribikitekiyouKbn pPwaribikitekiyoukbn = C_PWaribikitekiyouKbn.PWARISEIDO_RANK02;
        String seihowebPwaribikirankkbn = editSeihoWebRenkeiKoumoku.seihoWebGetPwaribikirankkbn(pPwaribikitekiyoukbn);
        exStringEquals(seihowebPwaribikirankkbn, "2", "生保Ｗｅｂ保険料割引ランク区分");
    }
}
