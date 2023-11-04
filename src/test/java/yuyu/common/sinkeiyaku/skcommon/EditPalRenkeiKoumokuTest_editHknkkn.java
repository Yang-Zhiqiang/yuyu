package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editHknkkn(HT_MosKihon, HT_MosSyouhn, BM_SyouhnZokusei)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editHknkkn {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditHknkkn_A1_1() {

        HT_MosKihon pMosKihon = new HT_MosKihon();
        pMosKihon.setMosno("860000033");
        pMosKihon.setHhknnen(10);

        HT_MosSyouhn pMosSyouhn = new HT_MosSyouhn();
        pMosSyouhn.setMosno("860000033");
        pMosSyouhn.setHknkkn(null);
        pMosSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        pMosSyouhn.setHrkkknsmnkbn(C_HrkkknsmnKbn.NENMANKI);
        pMosSyouhn.setHrkkkn(1);

        BM_SyouhnZokusei pSyouhnZokusei= new BM_SyouhnZokusei();
        pSyouhnZokusei.setNkhknumu(C_UmuKbn.ARI);

        editPalRenkeiKoumoku.editHknkkn(pMosKihon,pMosSyouhn,pSyouhnZokusei);

        exStringEquals(editPalRenkeiKoumoku.getHknKkn(), "00", "保険期間");
        exStringEquals(editPalRenkeiKoumoku.getSaiMnkKykHyj(), "0", "才満期契約表示");
        exStringEquals(editPalRenkeiKoumoku.getHrkkkn(), "01", "払込期間");

    }

    @Test
    @TestOrder(20)
    public void testEditHknkkn_A1_2() {

        HT_MosKihon pMosKihon = new HT_MosKihon();
        pMosKihon.setMosno("860000033");
        pMosKihon.setHhknnen(10);

        HT_MosSyouhn pMosSyouhn = new HT_MosSyouhn();
        pMosSyouhn.setMosno("860000033");
        pMosSyouhn.setHknkkn(5);
        pMosSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        pMosSyouhn.setHrkkknsmnkbn(C_HrkkknsmnKbn.NENMANKI);
        pMosSyouhn.setHrkkkn(1);

        BM_SyouhnZokusei pSyouhnZokusei= new BM_SyouhnZokusei();
        pSyouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        editPalRenkeiKoumoku.editHknkkn(pMosKihon,pMosSyouhn,pSyouhnZokusei);

        exStringEquals(editPalRenkeiKoumoku.getHknKkn(), "05", "保険期間");
        exStringEquals(editPalRenkeiKoumoku.getSaiMnkKykHyj(), "1", "才満期契約表示");
        exStringEquals(editPalRenkeiKoumoku.getHrkkkn(), "11", "払込期間");
    }

    @Test
    @TestOrder(30)
    public void testEditHknkkn_A1_3() {

        HT_MosKihon pMosKihon = new HT_MosKihon();
        pMosKihon.setMosno("860000033");
        pMosKihon.setHhknnen(10);

        HT_MosSyouhn pMosSyouhn = new HT_MosSyouhn();
        pMosSyouhn.setMosno("860000033");
        pMosSyouhn.setHknkkn(15);
        pMosSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        pMosSyouhn.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        pMosSyouhn.setHrkkkn(1);

        BM_SyouhnZokusei pSyouhnZokusei= new BM_SyouhnZokusei();
        pSyouhnZokusei.setNkhknumu(C_UmuKbn.NONE);
        editPalRenkeiKoumoku.editHknkkn(pMosKihon,pMosSyouhn,pSyouhnZokusei);

        exStringEquals(editPalRenkeiKoumoku.getHknKkn(), "15", "保険期間");
        exStringEquals(editPalRenkeiKoumoku.getSaiMnkKykHyj(), "1", "才満期契約表示");
        exStringEquals(editPalRenkeiKoumoku.getHrkkkn(), "01", "払込期間");
    }

    @Test
    @TestOrder(40)
    public void testEditHknkkn_A1_4() {

        HT_MosKihon pMosKihon = new HT_MosKihon();
        pMosKihon.setMosno("860000033");
        pMosKihon.setHhknnen(10);

        HT_MosSyouhn pMosSyouhn = new HT_MosSyouhn();
        pMosSyouhn.setMosno("860000033");
        pMosSyouhn.setHknkkn(99);
        pMosSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        pMosSyouhn.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        pMosSyouhn.setHrkkkn(15);

        BM_SyouhnZokusei pSyouhnZokusei= new BM_SyouhnZokusei();
        pSyouhnZokusei.setNkhknumu(C_UmuKbn.NONE);
        editPalRenkeiKoumoku.editHknkkn(pMosKihon,pMosSyouhn,pSyouhnZokusei);

        exStringEquals(editPalRenkeiKoumoku.getHknKkn(), "99", "保険期間");
        exStringEquals(editPalRenkeiKoumoku.getSaiMnkKykHyj(), "0", "才満期契約表示");
        exStringEquals(editPalRenkeiKoumoku.getHrkkkn(), "05", "払込期間");
    }


    @Test
    @TestOrder(50)
    public void testEditHknkkn_A1_5() {

        HT_MosKihon pMosKihon = null;

        HT_MosSyouhn pMosSyouhn = new HT_MosSyouhn();
        pMosSyouhn.setMosno("860000033");
        pMosSyouhn.setHknkkn(15);
        pMosSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        pMosSyouhn.setHrkkkn(0);

        BM_SyouhnZokusei pSyouhnZokusei= new BM_SyouhnZokusei();
        pSyouhnZokusei.setNkhknumu(C_UmuKbn.NONE);
        editPalRenkeiKoumoku.editHknkkn(pMosKihon,pMosSyouhn,pSyouhnZokusei);

        exStringEquals(editPalRenkeiKoumoku.getHknKkn(), "00", "保険期間");
        exStringEquals(editPalRenkeiKoumoku.getSaiMnkKykHyj(), "0", "才満期契約表示");
        exStringEquals(editPalRenkeiKoumoku.getHrkkkn(), "00", "払込期間");
    }

    @Test
    @TestOrder(60)
    public void testEditHknkkn_A1_6() {

        HT_MosKihon pMosKihon = new HT_MosKihon();
        pMosKihon.setMosno("860000033");
        pMosKihon.setHhknnen(10);

        HT_MosSyouhn pMosSyouhn = null;

        BM_SyouhnZokusei pSyouhnZokusei= new BM_SyouhnZokusei();
        pSyouhnZokusei.setNkhknumu(C_UmuKbn.NONE);
        editPalRenkeiKoumoku.editHknkkn(pMosKihon,pMosSyouhn,pSyouhnZokusei);

        exStringEquals(editPalRenkeiKoumoku.getHknKkn(), "00", "保険期間");
        exStringEquals(editPalRenkeiKoumoku.getSaiMnkKykHyj(), "0", "才満期契約表示");
        exStringEquals(editPalRenkeiKoumoku.getHrkkkn(), "00", "払込期間");
    }

    @Test
    @TestOrder(70)
    public void testEditHknkkn_A1_7() {

        HT_MosKihon pMosKihon = new HT_MosKihon();
        pMosKihon.setMosno("860000033");
        pMosKihon.setHhknnen(10);

        HT_MosSyouhn pMosSyouhn = new HT_MosSyouhn();
        pMosSyouhn.setMosno("860000033");
        pMosSyouhn.setHknkkn(15);
        pMosSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        pMosSyouhn.setHrkkkn(1);

        BM_SyouhnZokusei pSyouhnZokusei= null;

        editPalRenkeiKoumoku.editHknkkn(pMosKihon,pMosSyouhn,pSyouhnZokusei);

        exStringEquals(editPalRenkeiKoumoku.getHknKkn(), "00", "保険期間");
        exStringEquals(editPalRenkeiKoumoku.getSaiMnkKykHyj(), "0", "才満期契約表示");
        exStringEquals(editPalRenkeiKoumoku.getHrkkkn(), "00", "払込期間");
    }

    @Test
    @TestOrder(80)
    public void testEditHknkkn_A1_8() {

        HT_MosKihon pMosKihon = new HT_MosKihon();
        pMosKihon.setMosno("860000033");
        pMosKihon.setHhknnen(10);

        HT_MosSyouhn pMosSyouhn = new HT_MosSyouhn();
        pMosSyouhn.setMosno("860000033");
        pMosSyouhn.setHknkkn(15);
        pMosSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        pMosSyouhn.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        pMosSyouhn.setHrkkkn(1);

        BM_SyouhnZokusei pSyouhnZokusei= new BM_SyouhnZokusei();
        pSyouhnZokusei.setNkhknumu(C_UmuKbn.NONE);
        editPalRenkeiKoumoku.editHknkkn(pMosKihon,pMosSyouhn,pSyouhnZokusei);

        exStringEquals(editPalRenkeiKoumoku.getHknKkn(), "15", "保険期間");
        exStringEquals(editPalRenkeiKoumoku.getSaiMnkKykHyj(), "0", "才満期契約表示");
        exStringEquals(editPalRenkeiKoumoku.getHrkkkn(), "01", "払込期間");
    }
}