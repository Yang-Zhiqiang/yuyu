package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#huho2GetZenkizennouumu()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_huho2GetZenkizennouumu {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testHuho2GetZenkizennouumu_A1(){

        C_UmuKbn pZenkizennoutekiumu = C_UmuKbn.ARI;
        String pZennouhyouji = "1";
        C_BlnktkumuKbn huho2Zenkizennouumu = editSeihoWebRenkeiKoumoku.huho2GetZenkizennouumu(
            pZenkizennoutekiumu, pZennouhyouji);
        exClassificationEquals(huho2Zenkizennouumu, C_BlnktkumuKbn.ARI, "普保Ⅱ全期前納有無");
    }

    @Test
    @TestOrder(20)
    public void testHuho2GetZenkizennouumu_A2(){

        C_UmuKbn pZenkizennoutekiumu = C_UmuKbn.ARI;
        String pZennouhyouji = "0";
        C_BlnktkumuKbn huho2Zenkizennouumu = editSeihoWebRenkeiKoumoku.huho2GetZenkizennouumu(
            pZenkizennoutekiumu, pZennouhyouji);
        exClassificationEquals(huho2Zenkizennouumu, C_BlnktkumuKbn.NONE, "普保Ⅱ全期前納有無");
    }

    @Test
    @TestOrder(30)
    public void testHuho2GetZenkizennouumu_A3(){

        C_UmuKbn pZenkizennoutekiumu = C_UmuKbn.NONE;
        String pZennouhyouji = "1";
        C_BlnktkumuKbn huho2Zenkizennouumu = editSeihoWebRenkeiKoumoku.huho2GetZenkizennouumu(
            pZenkizennoutekiumu, pZennouhyouji);
        exClassificationEquals(huho2Zenkizennouumu, C_BlnktkumuKbn.ARI, "普保Ⅱ全期前納有無");
    }

    @Test
    @TestOrder(40)
    public void testHuho2GetZenkizennouumu_A4(){

        C_UmuKbn pZenkizennoutekiumu = C_UmuKbn.NONE;
        String pZennouhyouji = "0";
        C_BlnktkumuKbn huho2Zenkizennouumu = editSeihoWebRenkeiKoumoku.huho2GetZenkizennouumu(
            pZenkizennoutekiumu, pZennouhyouji);
        exClassificationEquals(huho2Zenkizennouumu, C_BlnktkumuKbn.BLNK, "普保Ⅱ全期前納有無");
    }
}
