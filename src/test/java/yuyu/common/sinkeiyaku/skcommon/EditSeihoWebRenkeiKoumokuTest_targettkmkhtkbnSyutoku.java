package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#targettkmkhtkbnSyutoku()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_targettkmkhtkbnSyutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testTargettkmkhtkbnSyutoku_A1(){

        Integer pTargettkmokuhyouti = 110;
        C_TargetTkMokuhyoutiKbn targetTkMokuhyoutiKbn =
            editSeihoWebRenkeiKoumoku.targettkmkhtkbnSyutoku(pTargettkmokuhyouti);
        exClassificationEquals(targetTkMokuhyoutiKbn, C_TargetTkMokuhyoutiKbn.TARGET110, "ターゲット特約目標値区分");
    }

    @Test
    @TestOrder(20)
    public void testTargettkmkhtkbnSyutoku_A2(){

        Integer pTargettkmokuhyouti = 120;
        C_TargetTkMokuhyoutiKbn targetTkMokuhyoutiKbn =
            editSeihoWebRenkeiKoumoku.targettkmkhtkbnSyutoku(pTargettkmokuhyouti);
        exClassificationEquals(targetTkMokuhyoutiKbn, C_TargetTkMokuhyoutiKbn.TARGET120, "ターゲット特約目標値区分");
    }

    @Test
    @TestOrder(30)
    public void testTargettkmkhtkbnSyutoku_A3(){

        Integer pTargettkmokuhyouti = 130;
        C_TargetTkMokuhyoutiKbn targetTkMokuhyoutiKbn =
            editSeihoWebRenkeiKoumoku.targettkmkhtkbnSyutoku(pTargettkmokuhyouti);
        exClassificationEquals(targetTkMokuhyoutiKbn, C_TargetTkMokuhyoutiKbn.TARGET130, "ターゲット特約目標値区分");
    }

    @Test
    @TestOrder(40)
    public void testTargettkmkhtkbnSyutoku_A4(){

        Integer pTargettkmokuhyouti = 140;
        C_TargetTkMokuhyoutiKbn targetTkMokuhyoutiKbn =
            editSeihoWebRenkeiKoumoku.targettkmkhtkbnSyutoku(pTargettkmokuhyouti);
        exClassificationEquals(targetTkMokuhyoutiKbn, C_TargetTkMokuhyoutiKbn.TARGET140, "ターゲット特約目標値区分");
    }

    @Test
    @TestOrder(50)
    public void testTargettkmkhtkbnSyutoku_A5(){

        Integer pTargettkmokuhyouti = 150;
        C_TargetTkMokuhyoutiKbn targetTkMokuhyoutiKbn =
            editSeihoWebRenkeiKoumoku.targettkmkhtkbnSyutoku(pTargettkmokuhyouti);
        exClassificationEquals(targetTkMokuhyoutiKbn, C_TargetTkMokuhyoutiKbn.TARGET150, "ターゲット特約目標値区分");
    }

    @Test
    @TestOrder(60)
    public void testTargettkmkhtkbnSyutoku_A6(){

        Integer pTargettkmokuhyouti = 160;
        C_TargetTkMokuhyoutiKbn targetTkMokuhyoutiKbn =
            editSeihoWebRenkeiKoumoku.targettkmkhtkbnSyutoku(pTargettkmokuhyouti);
        exClassificationEquals(targetTkMokuhyoutiKbn, C_TargetTkMokuhyoutiKbn.TARGET160, "ターゲット特約目標値区分");
    }

    @Test
    @TestOrder(70)
    public void testTargettkmkhtkbnSyutoku_A7(){

        Integer pTargettkmokuhyouti = 170;
        C_TargetTkMokuhyoutiKbn targetTkMokuhyoutiKbn =
            editSeihoWebRenkeiKoumoku.targettkmkhtkbnSyutoku(pTargettkmokuhyouti);
        exClassificationEquals(targetTkMokuhyoutiKbn, C_TargetTkMokuhyoutiKbn.TARGET170, "ターゲット特約目標値区分");
    }

    @Test
    @TestOrder(80)
    public void testTargettkmkhtkbnSyutoku_A8(){

        Integer pTargettkmokuhyouti = 180;
        C_TargetTkMokuhyoutiKbn targetTkMokuhyoutiKbn =
            editSeihoWebRenkeiKoumoku.targettkmkhtkbnSyutoku(pTargettkmokuhyouti);
        exClassificationEquals(targetTkMokuhyoutiKbn, C_TargetTkMokuhyoutiKbn.TARGET180, "ターゲット特約目標値区分");
    }

    @Test
    @TestOrder(90)
    public void testTargettkmkhtkbnSyutoku_A9(){

        Integer pTargettkmokuhyouti = 190;
        C_TargetTkMokuhyoutiKbn targetTkMokuhyoutiKbn =
            editSeihoWebRenkeiKoumoku.targettkmkhtkbnSyutoku(pTargettkmokuhyouti);
        exClassificationEquals(targetTkMokuhyoutiKbn, C_TargetTkMokuhyoutiKbn.TARGET190, "ターゲット特約目標値区分");
    }

    @Test
    @TestOrder(100)
    public void testTargettkmkhtkbnSyutoku_A10(){

        Integer pTargettkmokuhyouti = 200;
        C_TargetTkMokuhyoutiKbn targetTkMokuhyoutiKbn =
            editSeihoWebRenkeiKoumoku.targettkmkhtkbnSyutoku(pTargettkmokuhyouti);
        exClassificationEquals(targetTkMokuhyoutiKbn, C_TargetTkMokuhyoutiKbn.TARGET200, "ターゲット特約目標値区分");
    }

    @Test
    @TestOrder(110)
    public void testTargettkmkhtkbnSyutoku_A11(){

        Integer pTargettkmokuhyouti = 999;
        C_TargetTkMokuhyoutiKbn targetTkMokuhyoutiKbn =
            editSeihoWebRenkeiKoumoku.targettkmkhtkbnSyutoku(pTargettkmokuhyouti);
        exClassificationEquals(targetTkMokuhyoutiKbn, C_TargetTkMokuhyoutiKbn.BLNK, "ターゲット特約目標値区分");
    }

    @Test
    @TestOrder(120)
    public void testTargettkmkhtkbnSyutoku_A12(){

        Integer pTargettkmokuhyouti = 105;
        C_TargetTkMokuhyoutiKbn targetTkMokuhyoutiKbn =
            editSeihoWebRenkeiKoumoku.targettkmkhtkbnSyutoku(pTargettkmokuhyouti);
        exClassificationEquals(targetTkMokuhyoutiKbn, C_TargetTkMokuhyoutiKbn.TARGET105, "ターゲット特約目標値区分");
    }
}
