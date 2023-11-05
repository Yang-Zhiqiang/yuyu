package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DsSyomenTtdkHyouji;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド {@link EditSeihoWebRenkeiKoumoku#dsSyomenTtdkHyoujiHenkan(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_dsSyomenTtdkHyoujiHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testDsSyomenTtdkHyoujiHenkan_A1() {

        C_DsSyomenTtdkHyouji dsSyomenTtdkHyouji = editSeihoWebRenkeiKoumoku.dsSyomenTtdkHyoujiHenkan("1");

        exClassificationEquals(dsSyomenTtdkHyouji, C_DsSyomenTtdkHyouji.SYOMENTTDK, "ＤＳ書面手続表示");

    }

    @Test
    @TestOrder(20)
    public void testDsSyomenTtdkHyoujiHenkan_A2() {

        C_DsSyomenTtdkHyouji dsSyomenTtdkHyouji = editSeihoWebRenkeiKoumoku.dsSyomenTtdkHyoujiHenkan("2");

        exClassificationEquals(dsSyomenTtdkHyouji, C_DsSyomenTtdkHyouji.MISETTEI, "ＤＳ書面手続表示");

    }

}
