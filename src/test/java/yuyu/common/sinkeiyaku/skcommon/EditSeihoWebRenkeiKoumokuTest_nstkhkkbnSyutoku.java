package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tkhukaumu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#nstkhkkbnSyutoku()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_nstkhkkbnSyutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testnstkhkkbnSyutoku_A1(){

        String pNkshrarihyj = "1";
        C_Tkhukaumu tkhukaumu = editSeihoWebRenkeiKoumoku.nstkhkkbnSyutoku(pNkshrarihyj);
        exClassificationEquals(tkhukaumu, C_Tkhukaumu.HUKA, "特約付加有無");
    }
    @Test
    @TestOrder(20)
    public void testnstkhkkbnSyutoku_A2(){

        String pNkshrarihyj = "2";
        C_Tkhukaumu tkhukaumu = editSeihoWebRenkeiKoumoku.nstkhkkbnSyutoku(pNkshrarihyj);
        exClassificationEquals(tkhukaumu, C_Tkhukaumu.BLNK, "特約付加有無");
    }
}
