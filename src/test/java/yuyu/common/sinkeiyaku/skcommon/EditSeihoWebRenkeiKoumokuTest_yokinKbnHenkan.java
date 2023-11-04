package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_YokinKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド {@link EditSeihoWebRenkeiKoumoku#yokinKbnHenkan(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_yokinKbnHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testYokinKbnHenkan_A1() {

        C_YokinKbn yokinKbn = editSeihoWebRenkeiKoumoku.yokinKbnHenkan("1");

        exClassificationEquals(yokinKbn, C_YokinKbn.HUTUU, "預金種目区分");

    }

    @Test
    @TestOrder(20)
    public void testYokinKbnHenkan_A2() {

        C_YokinKbn yokinKbn = editSeihoWebRenkeiKoumoku.yokinKbnHenkan("2");

        exClassificationEquals(yokinKbn, C_YokinKbn.TOUZA, "預金種目区分");

    }

    @Test
    @TestOrder(30)
    public void testYokinKbnHenkan_A3() {

        C_YokinKbn yokinKbn = editSeihoWebRenkeiKoumoku.yokinKbnHenkan("3");

        exClassificationEquals(yokinKbn, C_YokinKbn.BLNK, "預金種目区分");

    }

}
