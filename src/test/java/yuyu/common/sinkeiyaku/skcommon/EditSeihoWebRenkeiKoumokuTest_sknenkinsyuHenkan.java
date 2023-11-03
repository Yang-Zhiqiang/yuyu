package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド {@link EditSeihoWebRenkeiKoumoku#sknenkinsyuHenkan(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_sknenkinsyuHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testSknenkinsyuHenkan_A1() {

        C_Sknenkinsyu sknenkinsyu = editSeihoWebRenkeiKoumoku.sknenkinsyuHenkan("6");

        exClassificationEquals(sknenkinsyu, C_Sknenkinsyu.KKTI5, "新契約年金種類");

    }

    @Test
    @TestOrder(20)
    public void testSknenkinsyuHenkan_A2() {

        C_Sknenkinsyu sknenkinsyu = editSeihoWebRenkeiKoumoku.sknenkinsyuHenkan("1");

        exClassificationEquals(sknenkinsyu, C_Sknenkinsyu.KKTI10, "新契約年金種類");

    }

    @Test
    @TestOrder(30)
    public void testSknenkinsyuHenkan_A3() {

        C_Sknenkinsyu sknenkinsyu = editSeihoWebRenkeiKoumoku.sknenkinsyuHenkan("2");

        exClassificationEquals(sknenkinsyu, C_Sknenkinsyu.KKTI15, "新契約年金種類");

    }

    @Test
    @TestOrder(40)
    public void testSknenkinsyuHenkan_A4() {

        C_Sknenkinsyu sknenkinsyu = editSeihoWebRenkeiKoumoku.sknenkinsyuHenkan("C");

        exClassificationEquals(sknenkinsyu, C_Sknenkinsyu.SGKHSYSYSN, "新契約年金種類");

    }

    @Test
    @TestOrder(50)
    public void testSknenkinsyuHenkan_A5() {

        C_Sknenkinsyu sknenkinsyu = editSeihoWebRenkeiKoumoku.sknenkinsyuHenkan("D");

        exClassificationEquals(sknenkinsyu, C_Sknenkinsyu.KKTI5DAI1BAIGAKU, "新契約年金種類");

    }

    @Test
    @TestOrder(60)
    public void testSknenkinsyuHenkan_A6() {

        C_Sknenkinsyu sknenkinsyu = editSeihoWebRenkeiKoumoku.sknenkinsyuHenkan("5");

        exClassificationEquals(sknenkinsyu, C_Sknenkinsyu.BLNK, "新契約年金種類");

    }
}
