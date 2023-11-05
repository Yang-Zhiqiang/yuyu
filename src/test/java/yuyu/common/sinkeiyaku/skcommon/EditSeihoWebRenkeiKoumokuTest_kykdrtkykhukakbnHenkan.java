package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tkhukaumu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#kykdrtkykhukakbnHenkan()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_kykdrtkykhukakbnHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testKykdrtkykhukakbnHenkan_A1(){

        String pDrtkkbn = "1";

        C_Tkhukaumu tkhukaumu = editSeihoWebRenkeiKoumoku.kykdrtkykhukakbnHenkan(pDrtkkbn);

        exClassificationEquals(tkhukaumu, C_Tkhukaumu.HUKA, "特約付加有無");
    }

    @Test
    @TestOrder(20)
    public void testKykdrtkykhukakbnHenkan_A2(){

        String pDrtkkbn = "2";

        C_Tkhukaumu tkhukaumu = editSeihoWebRenkeiKoumoku.kykdrtkykhukakbnHenkan(pDrtkkbn);

        exClassificationEquals(tkhukaumu, C_Tkhukaumu.HUKA, "特約付加有無");
    }

    @Test
    @TestOrder(30)
    public void testKykdrtkykhukakbnHenkan_A3(){

        String pDrtkkbn = "3";

        C_Tkhukaumu tkhukaumu = editSeihoWebRenkeiKoumoku.kykdrtkykhukakbnHenkan(pDrtkkbn);

        exClassificationEquals(tkhukaumu, C_Tkhukaumu.BLNK, "特約付加有無");
    }
}
