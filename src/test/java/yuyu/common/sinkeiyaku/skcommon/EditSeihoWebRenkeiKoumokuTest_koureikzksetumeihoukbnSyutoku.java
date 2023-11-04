package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KoureiKzkSetumeiHouKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド {@link EditSeihoWebRenkeiKoumoku#koureikzksetumeihoukbnSyutoku(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_koureikzksetumeihoukbnSyutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void koureikzksetumeihoukbnSyutoku_A1() {

        C_KoureiKzkSetumeiHouKbn koureiKzkSetumeiHouKbn = editSeihoWebRenkeiKoumoku.koureikzksetumeihoukbnSyutoku("1");

        exClassificationEquals(koureiKzkSetumeiHouKbn, C_KoureiKzkSetumeiHouKbn.KAZOKUDOUSEKI, "高齢者ご家族等説明方法区分");

    }

    @Test
    @TestOrder(20)
    public void koureikzksetumeihoukbnSyutoku_A2() {

        C_KoureiKzkSetumeiHouKbn koureiKzkSetumeiHouKbn = editSeihoWebRenkeiKoumoku.koureikzksetumeihoukbnSyutoku("2");

        exClassificationEquals(koureiKzkSetumeiHouKbn, C_KoureiKzkSetumeiHouKbn.KAZOKUJIZENTAIMEN, "高齢者ご家族等説明方法区分");

    }

    @Test
    @TestOrder(30)
    public void koureikzksetumeihoukbnSyutoku_A3() {

        C_KoureiKzkSetumeiHouKbn koureiKzkSetumeiHouKbn = editSeihoWebRenkeiKoumoku.koureikzksetumeihoukbnSyutoku("3");

        exClassificationEquals(koureiKzkSetumeiHouKbn, C_KoureiKzkSetumeiHouKbn.KAZOKUJIZENYUUSOU, "高齢者ご家族等説明方法区分");

    }

    @Test
    @TestOrder(40)
    public void koureikzksetumeihoukbnSyutoku_A4() {

        C_KoureiKzkSetumeiHouKbn koureiKzkSetumeiHouKbn = editSeihoWebRenkeiKoumoku.koureikzksetumeihoukbnSyutoku("9");

        exClassificationEquals(koureiKzkSetumeiHouKbn, C_KoureiKzkSetumeiHouKbn.JOUKIHUKA, "高齢者ご家族等説明方法区分");

    }

    @Test
    @TestOrder(50)
    public void koureikzksetumeihoukbnSyutoku_A5() {

        C_KoureiKzkSetumeiHouKbn koureiKzkSetumeiHouKbn = editSeihoWebRenkeiKoumoku.koureikzksetumeihoukbnSyutoku("10");

        exClassificationEquals(koureiKzkSetumeiHouKbn, C_KoureiKzkSetumeiHouKbn.BLNK, "高齢者ご家族等説明方法区分");

    }
}
