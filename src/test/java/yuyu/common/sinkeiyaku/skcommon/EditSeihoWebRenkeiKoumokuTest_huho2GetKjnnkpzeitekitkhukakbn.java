package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#huho2GetKjnnkpzeitekitkhukakbn()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_huho2GetKjnnkpzeitekitkhukakbn {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testHuho2GetKjnnkpzeitekitkhukakbn_A1(){

        C_UmuKbn pZeiseitekikakuumu = C_UmuKbn.ARI;
        String pTksykmcd1 = "C6";
        String pTksykmcd2 = "C9";
        String pTksykmcd3 = "C9";
        String pTksykmcd4 = "C9";
        String pTksykmcd5 = "C9";
        C_Tkhukaumu huho2Kjnnkpzeitekitkhukakbn = editSeihoWebRenkeiKoumoku.huho2GetKjnnkpzeitekitkhukakbn(
            pZeiseitekikakuumu, pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);
        exClassificationEquals(huho2Kjnnkpzeitekitkhukakbn, C_Tkhukaumu.HUKA, "普保Ⅱ個人年金保険料税制適格特約付加区分");
    }

    @Test
    @TestOrder(20)
    public void testHuho2GetKjnnkpzeitekitkhukakbn_A2(){

        C_UmuKbn pZeiseitekikakuumu = C_UmuKbn.ARI;
        String pTksykmcd1 = "C9";
        String pTksykmcd2 = "C6";
        String pTksykmcd3 = "C9";
        String pTksykmcd4 = "C9";
        String pTksykmcd5 = "C9";
        C_Tkhukaumu huho2Kjnnkpzeitekitkhukakbn = editSeihoWebRenkeiKoumoku.huho2GetKjnnkpzeitekitkhukakbn(
            pZeiseitekikakuumu, pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);
        exClassificationEquals(huho2Kjnnkpzeitekitkhukakbn, C_Tkhukaumu.HUKA, "普保Ⅱ個人年金保険料税制適格特約付加区分");
    }

    @Test
    @TestOrder(30)
    public void testHuho2GetKjnnkpzeitekitkhukakbn_A3(){

        C_UmuKbn pZeiseitekikakuumu = C_UmuKbn.ARI;
        String pTksykmcd1 = "C9";
        String pTksykmcd2 = "C9";
        String pTksykmcd3 = "C6";
        String pTksykmcd4 = "C9";
        String pTksykmcd5 = "C9";
        C_Tkhukaumu huho2Kjnnkpzeitekitkhukakbn = editSeihoWebRenkeiKoumoku.huho2GetKjnnkpzeitekitkhukakbn(
            pZeiseitekikakuumu, pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);
        exClassificationEquals(huho2Kjnnkpzeitekitkhukakbn, C_Tkhukaumu.HUKA, "普保Ⅱ個人年金保険料税制適格特約付加区分");
    }

    @Test
    @TestOrder(40)
    public void testHuho2GetKjnnkpzeitekitkhukakbn_A4(){

        C_UmuKbn pZeiseitekikakuumu = C_UmuKbn.ARI;
        String pTksykmcd1 = "C9";
        String pTksykmcd2 = "C9";
        String pTksykmcd3 = "C9";
        String pTksykmcd4 = "C6";
        String pTksykmcd5 = "C9";
        C_Tkhukaumu huho2Kjnnkpzeitekitkhukakbn = editSeihoWebRenkeiKoumoku.huho2GetKjnnkpzeitekitkhukakbn(
            pZeiseitekikakuumu, pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);
        exClassificationEquals(huho2Kjnnkpzeitekitkhukakbn, C_Tkhukaumu.HUKA, "普保Ⅱ個人年金保険料税制適格特約付加区分");
    }

    @Test
    @TestOrder(50)
    public void testHuho2GetKjnnkpzeitekitkhukakbn_A5(){

        C_UmuKbn pZeiseitekikakuumu = C_UmuKbn.ARI;
        String pTksykmcd1 = "C9";
        String pTksykmcd2 = "C9";
        String pTksykmcd3 = "C9";
        String pTksykmcd4 = "C9";
        String pTksykmcd5 = "C6";
        C_Tkhukaumu huho2Kjnnkpzeitekitkhukakbn = editSeihoWebRenkeiKoumoku.huho2GetKjnnkpzeitekitkhukakbn(
            pZeiseitekikakuumu, pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);
        exClassificationEquals(huho2Kjnnkpzeitekitkhukakbn, C_Tkhukaumu.HUKA, "普保Ⅱ個人年金保険料税制適格特約付加区分");
    }

    @Test
    @TestOrder(60)
    public void testHuho2GetKjnnkpzeitekitkhukakbn_A6(){

        C_UmuKbn pZeiseitekikakuumu = C_UmuKbn.ARI;
        String pTksykmcd1 = "C9";
        String pTksykmcd2 = "C9";
        String pTksykmcd3 = "C9";
        String pTksykmcd4 = "C9";
        String pTksykmcd5 = "C9";
        C_Tkhukaumu huho2Kjnnkpzeitekitkhukakbn = editSeihoWebRenkeiKoumoku.huho2GetKjnnkpzeitekitkhukakbn(
            pZeiseitekikakuumu, pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);
        exClassificationEquals(huho2Kjnnkpzeitekitkhukakbn, C_Tkhukaumu.NONE, "普保Ⅱ個人年金保険料税制適格特約付加区分");
    }

    @Test
    @TestOrder(70)
    public void testHuho2GetKjnnkpzeitekitkhukakbn_A7(){

        C_UmuKbn pZeiseitekikakuumu = C_UmuKbn.NONE;
        String pTksykmcd1 = "C6";
        String pTksykmcd2 = "C9";
        String pTksykmcd3 = "C9";
        String pTksykmcd4 = "C9";
        String pTksykmcd5 = "C9";
        C_Tkhukaumu huho2Kjnnkpzeitekitkhukakbn = editSeihoWebRenkeiKoumoku.huho2GetKjnnkpzeitekitkhukakbn(
            pZeiseitekikakuumu, pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);
        exClassificationEquals(huho2Kjnnkpzeitekitkhukakbn, C_Tkhukaumu.HUKA, "普保Ⅱ個人年金保険料税制適格特約付加区分");
    }

    @Test
    @TestOrder(80)
    public void testHuho2GetKjnnkpzeitekitkhukakbn_A8(){

        C_UmuKbn pZeiseitekikakuumu = C_UmuKbn.NONE;
        String pTksykmcd1 = "C9";
        String pTksykmcd2 = "C6";
        String pTksykmcd3 = "C9";
        String pTksykmcd4 = "C9";
        String pTksykmcd5 = "C9";
        C_Tkhukaumu huho2Kjnnkpzeitekitkhukakbn = editSeihoWebRenkeiKoumoku.huho2GetKjnnkpzeitekitkhukakbn(
            pZeiseitekikakuumu, pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);
        exClassificationEquals(huho2Kjnnkpzeitekitkhukakbn, C_Tkhukaumu.HUKA, "普保Ⅱ個人年金保険料税制適格特約付加区分");
    }

    @Test
    @TestOrder(90)
    public void testHuho2GetKjnnkpzeitekitkhukakbn_A9(){

        C_UmuKbn pZeiseitekikakuumu = C_UmuKbn.NONE;
        String pTksykmcd1 = "C9";
        String pTksykmcd2 = "C9";
        String pTksykmcd3 = "C6";
        String pTksykmcd4 = "C9";
        String pTksykmcd5 = "C9";
        C_Tkhukaumu huho2Kjnnkpzeitekitkhukakbn = editSeihoWebRenkeiKoumoku.huho2GetKjnnkpzeitekitkhukakbn(
            pZeiseitekikakuumu, pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);
        exClassificationEquals(huho2Kjnnkpzeitekitkhukakbn, C_Tkhukaumu.HUKA, "普保Ⅱ個人年金保険料税制適格特約付加区分");
    }

    @Test
    @TestOrder(100)
    public void testHuho2GetKjnnkpzeitekitkhukakbn_A10(){

        C_UmuKbn pZeiseitekikakuumu = C_UmuKbn.NONE;
        String pTksykmcd1 = "C9";
        String pTksykmcd2 = "C9";
        String pTksykmcd3 = "C9";
        String pTksykmcd4 = "C6";
        String pTksykmcd5 = "C9";
        C_Tkhukaumu huho2Kjnnkpzeitekitkhukakbn = editSeihoWebRenkeiKoumoku.huho2GetKjnnkpzeitekitkhukakbn(
            pZeiseitekikakuumu, pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);
        exClassificationEquals(huho2Kjnnkpzeitekitkhukakbn, C_Tkhukaumu.HUKA, "普保Ⅱ個人年金保険料税制適格特約付加区分");
    }

    @Test
    @TestOrder(110)
    public void testHuho2GetKjnnkpzeitekitkhukakbn_A11(){

        C_UmuKbn pZeiseitekikakuumu = C_UmuKbn.NONE;
        String pTksykmcd1 = "C9";
        String pTksykmcd2 = "C9";
        String pTksykmcd3 = "C9";
        String pTksykmcd4 = "C9";
        String pTksykmcd5 = "C6";
        C_Tkhukaumu huho2Kjnnkpzeitekitkhukakbn = editSeihoWebRenkeiKoumoku.huho2GetKjnnkpzeitekitkhukakbn(
            pZeiseitekikakuumu, pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);
        exClassificationEquals(huho2Kjnnkpzeitekitkhukakbn, C_Tkhukaumu.HUKA, "普保Ⅱ個人年金保険料税制適格特約付加区分");
    }

    @Test
    @TestOrder(120)
    public void testHuho2GetKjnnkpzeitekitkhukakbn_A12(){

        C_UmuKbn pZeiseitekikakuumu = C_UmuKbn.NONE;
        String pTksykmcd1 = "C9";
        String pTksykmcd2 = "C9";
        String pTksykmcd3 = "C9";
        String pTksykmcd4 = "C9";
        String pTksykmcd5 = "C9";
        C_Tkhukaumu huho2Kjnnkpzeitekitkhukakbn = editSeihoWebRenkeiKoumoku.huho2GetKjnnkpzeitekitkhukakbn(
            pZeiseitekikakuumu, pTksykmcd1, pTksykmcd2, pTksykmcd3, pTksykmcd4, pTksykmcd5);
        exClassificationEquals(huho2Kjnnkpzeitekitkhukakbn, C_Tkhukaumu.BLNK, "普保Ⅱ個人年金保険料税制適格特約付加区分");
    }
}
