package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#sntkhouKbnsyokugyouHenkanHenkan()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_sntkhouKbnsyokugyouHenkan {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testsntkhouKbnsyokugyouHenkan_A1(){

        String pHjykktkbn = "1";
        BM_SyouhnZokusei pSyouhnZokusei = new BM_SyouhnZokusei();
        C_SntkhouKbn sntkhouKbn = editSeihoWebRenkeiKoumoku.sntkhouKbnsyokugyouHenkan(pHjykktkbn, pSyouhnZokusei);
        exClassificationEquals(sntkhouKbn, C_SntkhouKbn.HJY, "選択方法区分");
    }

    @Test
    @TestOrder(20)
    public void testsntkhouKbnsyokugyouHenkan_A2(){

        String pHjykktkbn = "2";
        BM_SyouhnZokusei pSyouhnZokusei = new BM_SyouhnZokusei();
        pSyouhnZokusei.setSyokugyoukktumu(C_UmuKbn.ARI);
        C_SntkhouKbn sntkhouKbn = editSeihoWebRenkeiKoumoku.sntkhouKbnsyokugyouHenkan(pHjykktkbn, pSyouhnZokusei);
        exClassificationEquals(sntkhouKbn, C_SntkhouKbn.SYOKUGYOU, "選択方法区分");
    }

    @Test
    @TestOrder(30)
    public void testsntkhouKbnsyokugyouHenkan_A3(){

        String pHjykktkbn = "2";
        BM_SyouhnZokusei pSyouhnZokusei = new BM_SyouhnZokusei();
        pSyouhnZokusei.setSyokugyoukktumu(C_UmuKbn.NONE);
        C_SntkhouKbn sntkhouKbn = editSeihoWebRenkeiKoumoku.sntkhouKbnsyokugyouHenkan(pHjykktkbn, pSyouhnZokusei);
        exClassificationEquals(sntkhouKbn, C_SntkhouKbn.KKT, "選択方法区分");
    }

    @Test
    @TestOrder(40)
    public void testsntkhouKbnsyokugyouHenkan_A4(){

        String pHjykktkbn = "3";
        BM_SyouhnZokusei pSyouhnZokusei = new BM_SyouhnZokusei();
        C_SntkhouKbn sntkhouKbn = editSeihoWebRenkeiKoumoku.sntkhouKbnsyokugyouHenkan(pHjykktkbn, pSyouhnZokusei);
        exClassificationEquals(sntkhouKbn, C_SntkhouKbn.NONE, "選択方法区分");
    }

    @Test
    @TestOrder(50)
    public void testsntkhouKbnsyokugyouHenkan_A5(){

        String pHjykktkbn = "4";
        BM_SyouhnZokusei pSyouhnZokusei = new BM_SyouhnZokusei();
        C_SntkhouKbn sntkhouKbn = editSeihoWebRenkeiKoumoku.sntkhouKbnsyokugyouHenkan(pHjykktkbn, pSyouhnZokusei);
        exClassificationEquals(sntkhouKbn, C_SntkhouKbn.BLNK, "選択方法区分");
    }
}
