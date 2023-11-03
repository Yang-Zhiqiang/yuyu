package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#syksbYensitiHsyuTkhkKbn()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_syksbYensitiHsyuTkhkKbn {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testSyksbyensitihsyutkhkkbn_A1(){

        String pYensitihsyutkykarihyj = "1";
        C_HknsyuruiNo pHknsyuruino = C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI;
        C_Tkhukaumu tkhukaumu =
            editSeihoWebRenkeiKoumoku.syksbYensitiHsyuTkhkKbn(pYensitihsyutkykarihyj, pHknsyuruino);
        exClassificationEquals(tkhukaumu, C_Tkhukaumu.HUKA, "特約付加有無");
    }

    @Test
    @TestOrder(20)
    public void testSyksbyensitihsyutkhkkbn_A2(){

        String pYensitihsyutkykarihyj = "2";
        C_HknsyuruiNo pHknsyuruino = C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI;
        C_Tkhukaumu tkhukaumu =
            editSeihoWebRenkeiKoumoku.syksbYensitiHsyuTkhkKbn(pYensitihsyutkykarihyj, pHknsyuruino);
        exClassificationEquals(tkhukaumu, C_Tkhukaumu.NONE, "特約付加有無");
    }

    @Test
    @TestOrder(30)
    public void testSyksbyensitihsyutkhkkbn_A3(){

        String pYensitihsyutkykarihyj = "2";
        C_HknsyuruiNo pHknsyuruino = C_HknsyuruiNo.GAIKARIRITUHENDOUNK;
        C_Tkhukaumu tkhukaumu =
            editSeihoWebRenkeiKoumoku.syksbYensitiHsyuTkhkKbn(pYensitihsyutkykarihyj, pHknsyuruino);
        exClassificationEquals(tkhukaumu, C_Tkhukaumu.BLNK, "特約付加有無");
    }

    @Test
    @TestOrder(40)
    public void testSyksbyensitihsyutkhkkbn_A4(){

        String pYensitihsyutkykarihyj = "2";
        C_HknsyuruiNo pHknsyuruino = C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI;
        C_Tkhukaumu tkhukaumu =
            editSeihoWebRenkeiKoumoku.syksbYensitiHsyuTkhkKbn(pYensitihsyutkykarihyj, pHknsyuruino);
        exClassificationEquals(tkhukaumu, C_Tkhukaumu.NONE, "特約付加有無");
    }
}
