package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#ptuutihyjHenkan(String, C_HknsyuruiNo,
 * C_BlnktkumuKbn, C_Tuukasyu)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_ptuutihyjHenkan {
    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testPtuutihyjHenkan_A1() {

        String pPtuutihyj = "1";
        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT;
        C_BlnktkumuKbn pZenkizennouumu = C_BlnktkumuKbn.ARI;
        C_Tuukasyu pNykntuukasyu = C_Tuukasyu.USD;

        C_YnkHrkmgkAnniTuutiKbn ynkHrkmgkAnniTuutiKbn = editSeihoWebRenkeiKoumoku.ptuutihyjHenkan(pPtuutihyj, pHknsyuruiNo,
            pZenkizennouumu, pNykntuukasyu);

        exClassificationEquals(ynkHrkmgkAnniTuutiKbn, C_YnkHrkmgkAnniTuutiKbn.YUUSOUKIBOU ,"円貨払込額案内通知区分");
    }

    @Test
    @TestOrder(20)
    public void testPtuutihyjHenkan_A2() {

        String pPtuutihyj = "2";
        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT ;
        C_BlnktkumuKbn pZenkizennouumu = C_BlnktkumuKbn.NONE;
        C_Tuukasyu pNykntuukasyu = C_Tuukasyu.JPY;

        C_YnkHrkmgkAnniTuutiKbn ynkHrkmgkAnniTuutiKbn = editSeihoWebRenkeiKoumoku.ptuutihyjHenkan(pPtuutihyj, pHknsyuruiNo,
            pZenkizennouumu, pNykntuukasyu);

        exClassificationEquals(ynkHrkmgkAnniTuutiKbn, C_YnkHrkmgkAnniTuutiKbn.YUUSOUKIBOUSHINAI ,"円貨払込額案内通知区分");
    }

    @Test
    @TestOrder(30)
    public void testPtuutihyjHenkan_A3() {

        String pPtuutihyj = "2";
        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT;
        C_BlnktkumuKbn pZenkizennouumu = C_BlnktkumuKbn.ARI;
        C_Tuukasyu pNykntuukasyu = C_Tuukasyu.JPY;

        C_YnkHrkmgkAnniTuutiKbn ynkHrkmgkAnniTuutiKbn = editSeihoWebRenkeiKoumoku.ptuutihyjHenkan(pPtuutihyj, pHknsyuruiNo,
            pZenkizennouumu, pNykntuukasyu);

        exClassificationEquals(ynkHrkmgkAnniTuutiKbn, C_YnkHrkmgkAnniTuutiKbn.BLNK ,"円貨払込額案内通知区分");
    }

    @Test
    @TestOrder(40)
    public void testPtuutihyjHenkan_A4() {

        String pPtuutihyj = "2";
        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT;
        C_BlnktkumuKbn pZenkizennouumu = C_BlnktkumuKbn.NONE;
        C_Tuukasyu pNykntuukasyu = C_Tuukasyu.USD;

        C_YnkHrkmgkAnniTuutiKbn ynkHrkmgkAnniTuutiKbn = editSeihoWebRenkeiKoumoku.ptuutihyjHenkan(pPtuutihyj, pHknsyuruiNo,
            pZenkizennouumu, pNykntuukasyu);

        exClassificationEquals(ynkHrkmgkAnniTuutiKbn, C_YnkHrkmgkAnniTuutiKbn.BLNK ,"円貨払込額案内通知区分");
    }

    @Test
    @TestOrder(50)
    public void testPtuutihyjHenkan_A5() {

        String pPtuutihyj = "2";
        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT;
        C_BlnktkumuKbn pZenkizennouumu = C_BlnktkumuKbn.NONE;
        C_Tuukasyu pNykntuukasyu = C_Tuukasyu.JPY;

        C_YnkHrkmgkAnniTuutiKbn ynkHrkmgkAnniTuutiKbn = editSeihoWebRenkeiKoumoku.ptuutihyjHenkan(pPtuutihyj, pHknsyuruiNo,
            pZenkizennouumu, pNykntuukasyu);

        exClassificationEquals(ynkHrkmgkAnniTuutiKbn, C_YnkHrkmgkAnniTuutiKbn.BLNK ,"円貨払込額案内通知区分");
    }


}
