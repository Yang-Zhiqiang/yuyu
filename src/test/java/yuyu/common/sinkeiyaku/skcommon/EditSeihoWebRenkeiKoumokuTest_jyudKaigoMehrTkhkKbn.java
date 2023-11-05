package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tkhukaumu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#jyudKaigoMehrTkhkKbn()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_jyudKaigoMehrTkhkKbn {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testJyudkaigomehrtkhkkbn_A1(){

        String pKaigomehrtkarihyj = "1";
        C_Tkhukaumu tkhukaumu =
            editSeihoWebRenkeiKoumoku.jyudKaigoMehrTkhkKbn(pKaigomehrtkarihyj);
        exClassificationEquals(tkhukaumu, C_Tkhukaumu.HUKA, "特約付加有無");
    }

    @Test
    @TestOrder(20)
    public void testJyudkaigomehrtkhkkbn_A2(){

        String pKaigomehrtkarihyj = "2";
        C_Tkhukaumu tkhukaumu =
            editSeihoWebRenkeiKoumoku.jyudKaigoMehrTkhkKbn(pKaigomehrtkarihyj);
        exClassificationEquals(tkhukaumu, C_Tkhukaumu.BLNK, "特約付加有無");
    }
}
