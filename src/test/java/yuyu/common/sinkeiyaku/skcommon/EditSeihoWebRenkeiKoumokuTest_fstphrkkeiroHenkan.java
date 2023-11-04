package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#fstphrkkeiroHenkan()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_fstphrkkeiroHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testFstphrkkeiroHenkan_A1(){

        String pHaraikomikaisukbn = "3";
        String pHrkkeirokbn = "7";
        String pTkiyougyoutaikbn = "D";

        C_FstphrkkeiroKbn fstphrkkeiroKbn = editSeihoWebRenkeiKoumoku.fstphrkkeiroHenkan(pHaraikomikaisukbn, pHrkkeirokbn, pTkiyougyoutaikbn);

        exClassificationEquals(fstphrkkeiroKbn, C_FstphrkkeiroKbn.CREDIT, "初回保険料払込経路区分");
    }

    @Test
    @TestOrder(20)
    public void testFstphrkkeiroHenkan_A2(){

        String pHaraikomikaisukbn = "3";
        String pHrkkeirokbn = "7";
        String pTkiyougyoutaikbn = "E";

        C_FstphrkkeiroKbn fstphrkkeiroKbn = editSeihoWebRenkeiKoumoku.fstphrkkeiroHenkan(pHaraikomikaisukbn, pHrkkeirokbn, pTkiyougyoutaikbn);

        exClassificationEquals(fstphrkkeiroKbn, C_FstphrkkeiroKbn.HURIKOMI, "初回保険料払込経路区分");
    }

    @Test
    @TestOrder(30)
    public void testFstphrkkeiroHenkan_A3(){

        String pHaraikomikaisukbn = "3";
        String pHrkkeirokbn = "8";
        String pTkiyougyoutaikbn = "D";

        C_FstphrkkeiroKbn fstphrkkeiroKbn = editSeihoWebRenkeiKoumoku.fstphrkkeiroHenkan(pHaraikomikaisukbn, pHrkkeirokbn, pTkiyougyoutaikbn);

        exClassificationEquals(fstphrkkeiroKbn, C_FstphrkkeiroKbn.HURIKOMI, "初回保険料払込経路区分");
    }

    @Test
    @TestOrder(30)
    public void testFstphrkkeiroHenkan_A4(){

        String pHaraikomikaisukbn = "4";
        String pHrkkeirokbn = "7";
        String pTkiyougyoutaikbn = "D";

        C_FstphrkkeiroKbn fstphrkkeiroKbn = editSeihoWebRenkeiKoumoku.fstphrkkeiroHenkan(pHaraikomikaisukbn, pHrkkeirokbn, pTkiyougyoutaikbn);

        exClassificationEquals(fstphrkkeiroKbn, C_FstphrkkeiroKbn.HURIKOMI, "初回保険料払込経路区分");
    }

}
