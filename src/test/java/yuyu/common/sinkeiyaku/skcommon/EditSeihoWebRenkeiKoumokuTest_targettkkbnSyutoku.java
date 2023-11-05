package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_TargetTkKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#targettkkbnSyutoku()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_targettkkbnSyutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testtargettkkbnSyutoku_A1(){

        String pTargettkkbn = "1";
        C_TargetTkKbn targetTkKbn = editSeihoWebRenkeiKoumoku.targettkkbnSyutoku(pTargettkkbn);
        exClassificationEquals(targetTkKbn, C_TargetTkKbn.SYUUSIN, "ターゲット特約区分");
    }

    @Test
    @TestOrder(20)
    public void testtargettkkbnSyutoku_A2(){

        String pTargettkkbn = "2";
        C_TargetTkKbn targetTkKbn = editSeihoWebRenkeiKoumoku.targettkkbnSyutoku(pTargettkkbn);
        exClassificationEquals(targetTkKbn, C_TargetTkKbn.NENKIN, "ターゲット特約区分");
    }

    @Test
    @TestOrder(30)
    public void testtargettkkbnSyutoku_A3(){

        String pTargettkkbn = "3";
        C_TargetTkKbn targetTkKbn = editSeihoWebRenkeiKoumoku.targettkkbnSyutoku(pTargettkkbn);
        exClassificationEquals(targetTkKbn, C_TargetTkKbn.BLNK, "ターゲット特約区分");
    }
}
