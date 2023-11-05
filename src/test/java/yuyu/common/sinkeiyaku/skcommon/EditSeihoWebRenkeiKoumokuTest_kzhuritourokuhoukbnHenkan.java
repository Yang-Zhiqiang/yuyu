package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KzhuritourokuhouKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#kzhuritourokuhoukbnHenkan()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_kzhuritourokuhoukbnHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testKzhuritourokuhoukbnHenkan_A1() {

        String pHrkkeiro = "1";
        String pKuhrshmnttdkhyj = "0";
        String pNetkuhritaiouzumihyj = "0";

        C_KzhuritourokuhouKbn kzhuritourokuhouKbn = editSeihoWebRenkeiKoumoku.kzhuritourokuhoukbnHenkan(pHrkkeiro, pKuhrshmnttdkhyj, pNetkuhritaiouzumihyj);

        exClassificationEquals(kzhuritourokuhouKbn, C_KzhuritourokuhouKbn.PPLESS, "口座振替登録方法区分");
    }

    @Test
    @TestOrder(20)
    public void testKzhuritourokuhoukbnHenkan_A2() {

        String pHrkkeiro = "1";
        String pKuhrshmnttdkhyj = "0";
        String pNetkuhritaiouzumihyj = "1";

        C_KzhuritourokuhouKbn kzhuritourokuhouKbn = editSeihoWebRenkeiKoumoku.kzhuritourokuhoukbnHenkan(pHrkkeiro, pKuhrshmnttdkhyj, pNetkuhritaiouzumihyj);

        exClassificationEquals(kzhuritourokuhouKbn, C_KzhuritourokuhouKbn.QR, "口座振替登録方法区分");
    }

    @Test
    @TestOrder(30)
    public void testKzhuritourokuhoukbnHenkan_A3() {

        String pHrkkeiro = "1";
        String pKuhrshmnttdkhyj = "0";
        String pNetkuhritaiouzumihyj = "2";

        C_KzhuritourokuhouKbn kzhuritourokuhouKbn = editSeihoWebRenkeiKoumoku.kzhuritourokuhoukbnHenkan(pHrkkeiro, pKuhrshmnttdkhyj, pNetkuhritaiouzumihyj);

        exClassificationEquals(kzhuritourokuhouKbn, C_KzhuritourokuhouKbn.BLNK, "口座振替登録方法区分");
    }

    @Test
    @TestOrder(40)
    public void testKzhuritourokuhoukbnHenkan_A4() {

        String pHrkkeiro = "1";
        String pKuhrshmnttdkhyj = "1";
        String pNetkuhritaiouzumihyj = "0";

        C_KzhuritourokuhouKbn kzhuritourokuhouKbn = editSeihoWebRenkeiKoumoku.kzhuritourokuhoukbnHenkan(pHrkkeiro, pKuhrshmnttdkhyj, pNetkuhritaiouzumihyj);

        exClassificationEquals(kzhuritourokuhouKbn, C_KzhuritourokuhouKbn.SYOMEN, "口座振替登録方法区分");
    }

    @Test
    @TestOrder(50)
    public void testKzhuritourokuhoukbnHenkan_A5() {

        String pHrkkeiro = "1";
        String pKuhrshmnttdkhyj = "1";
        String pNetkuhritaiouzumihyj = "1";

        C_KzhuritourokuhouKbn kzhuritourokuhouKbn = editSeihoWebRenkeiKoumoku.kzhuritourokuhoukbnHenkan(pHrkkeiro, pKuhrshmnttdkhyj, pNetkuhritaiouzumihyj);

        exClassificationEquals(kzhuritourokuhouKbn, C_KzhuritourokuhouKbn.BLNK, "口座振替登録方法区分");
    }

    @Test
    @TestOrder(60)
    public void testKzhuritourokuhoukbnHenkan_A6() {

        String pHrkkeiro = "1";
        String pKuhrshmnttdkhyj = "2";
        String pNetkuhritaiouzumihyj = "0";

        C_KzhuritourokuhouKbn kzhuritourokuhouKbn = editSeihoWebRenkeiKoumoku.kzhuritourokuhoukbnHenkan(pHrkkeiro, pKuhrshmnttdkhyj, pNetkuhritaiouzumihyj);

        exClassificationEquals(kzhuritourokuhouKbn, C_KzhuritourokuhouKbn.BLNK, "口座振替登録方法区分");
    }

    @Test
    @TestOrder(70)
    public void testKzhuritourokuhoukbnHenkan_A7() {

        String pHrkkeiro = "0";
        String pKuhrshmnttdkhyj = "0";
        String pNetkuhritaiouzumihyj = "0";

        C_KzhuritourokuhouKbn kzhuritourokuhouKbn = editSeihoWebRenkeiKoumoku.kzhuritourokuhoukbnHenkan(pHrkkeiro, pKuhrshmnttdkhyj, pNetkuhritaiouzumihyj);

        exClassificationEquals(kzhuritourokuhouKbn, C_KzhuritourokuhouKbn.BLNK, "口座振替登録方法区分");
    }
}
