package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#huho2GetZennoumousideumu()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_huho2GetZennoumousideumu {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testHuho2GetZennoumousideumu_A1(){

        String pZennouhyouji = "1";
        C_UmuKbn huho2Zennoumousideumu = editSeihoWebRenkeiKoumoku.huho2GetZennoumousideumu(pZennouhyouji);
        exClassificationEquals(huho2Zennoumousideumu, C_UmuKbn.ARI, "普保Ⅱ前納申出有無");
    }

    @Test
    @TestOrder(20)
    public void testHuho2GetZennoumousideumu_A2(){

        String pZennouhyouji = "0";
        C_UmuKbn huho2Zennoumousideumu = editSeihoWebRenkeiKoumoku.huho2GetZennoumousideumu(pZennouhyouji);
        exClassificationEquals(huho2Zennoumousideumu, C_UmuKbn.NONE, "普保Ⅱ前納申出有無");
    }
}
