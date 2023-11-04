package yuyu.report.sinkeiyaku;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzDairitenAtesakiBean;
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HusyoudakuTuutiSouhusakiKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.sinkeiyaku.bean.report.SkKykhuseirituBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約不成立通知書  帳票テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SkKykhuseirituTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkKykhuseirituBean skKykhuseirituBean;

    @Inject
    private BzKokyakuAtesakiBean bzKokyakuAtesakiBean;

    @Inject
    private BzDairitenAtesakiBean bzDairitenAtesakiBean;


    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("wwwwwＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.COOLINGOFF);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("wwwwwＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MOS_TORIKESI);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("wwwwwＷＷＷ");
        skKykhuseirituBean.setIrMosno("987654321");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.YUUKOUKKNKKA);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("wwwwwＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.ENKI_SIJINASI);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("wwwwwＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.ENKI_SUUNENGOSAISIN);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("wwww");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("99/99ＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("wwwwwwwwwww");

        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.KOKYAKUATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("wwwwwＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("wwwwwＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.YUUKOUKKNKKA);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.NONE);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("7月10日");
        bzDairitenAtesakiBean.setIrDrtennmkj("東京市高田馬場第一代理店");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("田中維持");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("代理店打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（代理店打出機関名２（漢字））");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("２");
        skKykhuseirituBean.setIrSitencd("0001");
        skKykhuseirituBean.setIrKyknmkj("上野次郎");
        skKykhuseirituBean.setIrHhknnmkj("上野八子");
        skKykhuseirituBean.setIrMosymd("2016年11月18日");
        skKykhuseirituBean.setIrAisyoumei("「ふるはーと外貨」");
        skKykhuseirituBean.setIrSyokaihrkp("9,999.99 米ドル");
        skKykhuseirituBean.setIrRyosyuymd("7/10着金済");
        skKykhuseirituBean.setIrMosno("123456789");
        skKykhuseirituBean.setIrUktkid("1Z3J567890");

        skKykhuseirituBean.setIrTyouhyoutitle("お申込み契約についてのお知らせ");
        skKykhuseirituBean.setIrHknsyurui("終身保険（即時保障型）");
        skKykhuseirituBean.setIr1puktymd("2009年7月10日");
        skKykhuseirituBean.setIrTantnm("田中子丸");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2009年7月10日");
        bzKokyakuAtesakiBean.setIrShsyno("0101234");
        bzKokyakuAtesakiBean.setIrShadr1kj("送付先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrShadr2kj("送付先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrShadr3kj("送付先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrShsnmkj("上野一郎");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("新契約チーム");
        bzKokyakuAtesakiBean.setIrToiawasetelno("06-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("受付時間　　午前９時～午後５時");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("（土・日・祝日・年末年始除く）");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("7月10日");
        bzDairitenAtesakiBean.setIrDrtennmkj("東京市高田馬場第一代理店");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("田中維持");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("代理店打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("代理店打出機関名２（漢字）");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("３");
        skKykhuseirituBean.setIrSitencd("０００１");
        skKykhuseirituBean.setIrKyknmkj("上野次郎");
        skKykhuseirituBean.setIrHhknnmkj("上野八子");
        skKykhuseirituBean.setIrMosymd("2016年01月18日");
        skKykhuseirituBean.setIrAisyoumei("「ふるはーと外貨」");
        skKykhuseirituBean.setIrSyokaihrkp("9,999.99 円");
        skKykhuseirituBean.setIrRyosyuymd("7/10着金済");
        skKykhuseirituBean.setIrMosno("987654321");
        skKykhuseirituBean.setIrUktkid("1Z3J567890");
        skKykhuseirituBean.setIrTyouhyoutitle("お申込み契約についてのお知らせ");
        skKykhuseirituBean.setIrHknsyurui("終身保険（即時保障型）「ふるはーと外貨」");
        skKykhuseirituBean.setIr1puktymd("2009年7月10日");
        skKykhuseirituBean.setIrTantnm("田中子丸");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2009年7月10日");
        bzKokyakuAtesakiBean.setIrShsyno("0101234");
        bzKokyakuAtesakiBean.setIrShadr1kj("送付先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrShadr2kj("送付先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrShadr3kj("送付先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrShsnmkj("上野一郎");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("新契約チーム");
        bzKokyakuAtesakiBean.setIrToiawasetelno("06-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("受付時間　　午前９時～午後５時");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("（土・日・祝日・年末年始除く）");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("2009年7月10日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("wwwwwＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("2009年8月10日");
        skKykhuseirituBean.setIrTantnm("田中子丸");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.YUUKOUKKNKKA);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.NONE);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("");
        bzDairitenAtesakiBean.setIrDrtennmkj("");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("");
        bzDairitenAtesakiBean.setIrHknkisynm("");
        bzDairitenAtesakiBean.setIrToiawasesosiki("");
        bzDairitenAtesakiBean.setIrToiawasetelno("");
        bzDairitenAtesakiBean.setIrToiawasefaxno("");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("");
        skKykhuseirituBean.setIrSitencd("");
        skKykhuseirituBean.setIrKyknmkj("");
        skKykhuseirituBean.setIrHhknnmkj("");
        skKykhuseirituBean.setIrMosymd("");
        skKykhuseirituBean.setIrAisyoumei("");
        skKykhuseirituBean.setIrSyokaihrkp("");
        skKykhuseirituBean.setIrRyosyuymd("");
        skKykhuseirituBean.setIrMosno("");
        skKykhuseirituBean.setIrUktkid("");

        skKykhuseirituBean.setIrTyouhyoutitle("");
        skKykhuseirituBean.setIrHknsyurui("");
        skKykhuseirituBean.setIr1puktymd("");
        skKykhuseirituBean.setIrTantnm("");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("");
        bzKokyakuAtesakiBean.setIrShsyno("");
        bzKokyakuAtesakiBean.setIrShadr1kj("");
        bzKokyakuAtesakiBean.setIrShadr2kj("");
        bzKokyakuAtesakiBean.setIrShadr3kj("");
        bzKokyakuAtesakiBean.setIrShsnmkj("");
        bzKokyakuAtesakiBean.setIrToiawaseyno("");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("");
        bzKokyakuAtesakiBean.setIrHknkisynm("");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("");
        bzKokyakuAtesakiBean.setIrToiawasetelno("");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("");
        bzDairitenAtesakiBean.setIrDrtennmkj("");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("");
        bzDairitenAtesakiBean.setIrHknkisynm("");
        bzDairitenAtesakiBean.setIrToiawasesosiki("");
        bzDairitenAtesakiBean.setIrToiawasetelno("");
        bzDairitenAtesakiBean.setIrToiawasefaxno("");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("");
        skKykhuseirituBean.setIrSitencd("");
        skKykhuseirituBean.setIrKyknmkj("");
        skKykhuseirituBean.setIrHhknnmkj("");
        skKykhuseirituBean.setIrMosymd("");
        skKykhuseirituBean.setIrAisyoumei("");
        skKykhuseirituBean.setIrSyokaihrkp("");
        skKykhuseirituBean.setIrRyosyuymd("");
        skKykhuseirituBean.setIrMosno("");
        skKykhuseirituBean.setIrUktkid("");
        skKykhuseirituBean.setIrTyouhyoutitle("");
        skKykhuseirituBean.setIrHknsyurui("");
        skKykhuseirituBean.setIr1puktymd("");
        skKykhuseirituBean.setIrTantnm("");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("");
        bzKokyakuAtesakiBean.setIrShsyno("");
        bzKokyakuAtesakiBean.setIrShadr1kj("");
        bzKokyakuAtesakiBean.setIrShadr2kj("");
        bzKokyakuAtesakiBean.setIrShadr3kj("");
        bzKokyakuAtesakiBean.setIrShsnmkj("");
        bzKokyakuAtesakiBean.setIrToiawaseyno("");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("");
        bzKokyakuAtesakiBean.setIrHknkisynm("");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("");
        bzKokyakuAtesakiBean.setIrToiawasetelno("");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("");
        bzDairitenAtesakiBean.setIrDrtennmkj("");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("");
        bzDairitenAtesakiBean.setIrHknkisynm("");
        bzDairitenAtesakiBean.setIrToiawasesosiki("");
        bzDairitenAtesakiBean.setIrToiawasetelno("");
        bzDairitenAtesakiBean.setIrToiawasefaxno("");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("");
        skKykhuseirituBean.setIrSitencd("");
        skKykhuseirituBean.setIrKyknmkj("");
        skKykhuseirituBean.setIrHhknnmkj("");
        skKykhuseirituBean.setIrMosymd("");
        skKykhuseirituBean.setIrAisyoumei("");
        skKykhuseirituBean.setIrSyokaihrkp("");
        skKykhuseirituBean.setIrRyosyuymd("");
        skKykhuseirituBean.setIrMosno("");
        skKykhuseirituBean.setIrUktkid("");
        skKykhuseirituBean.setIrTyouhyoutitle("");
        skKykhuseirituBean.setIrHknsyurui("");
        skKykhuseirituBean.setIr1puktymd("");
        skKykhuseirituBean.setIrTantnm("");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.YUUKOUKKNKKA);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.NONE);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("");
        bzKokyakuAtesakiBean.setIrShsyno("");
        bzKokyakuAtesakiBean.setIrShadr1kj("");
        bzKokyakuAtesakiBean.setIrShadr2kj("");
        bzKokyakuAtesakiBean.setIrShadr3kj("");
        bzKokyakuAtesakiBean.setIrShsnmkj("");
        bzKokyakuAtesakiBean.setIrToiawaseyno("");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("");
        bzKokyakuAtesakiBean.setIrHknkisynm("");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("");
        bzKokyakuAtesakiBean.setIrToiawasetelno("");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd(null);
        bzDairitenAtesakiBean.setIrDrtennmkj(null);
        bzDairitenAtesakiBean.setIrTratkitantounmkj(null);
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1(null);
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2(null);
        bzDairitenAtesakiBean.setIrHknkisynm(null);
        bzDairitenAtesakiBean.setIrToiawasesosiki(null);
        bzDairitenAtesakiBean.setIrToiawasetelno(null);
        bzDairitenAtesakiBean.setIrToiawasefaxno(null);
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi(null);

        skKykhuseirituBean.setIrKyktuutisetteinissuu(null);
        skKykhuseirituBean.setIrSitencd(null);
        skKykhuseirituBean.setIrKyknmkj(null);
        skKykhuseirituBean.setIrHhknnmkj(null);
        skKykhuseirituBean.setIrMosymd(null);
        skKykhuseirituBean.setIrAisyoumei(null);
        skKykhuseirituBean.setIrSyokaihrkp(null);
        skKykhuseirituBean.setIrRyosyuymd(null);
        skKykhuseirituBean.setIrMosno(null);
        skKykhuseirituBean.setIrUktkid(null);

        skKykhuseirituBean.setIrTyouhyoutitle(null);
        skKykhuseirituBean.setIrHknsyurui(null);
        skKykhuseirituBean.setIr1puktymd(null);
        skKykhuseirituBean.setIrTantnm(null);

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(null);
        bzKokyakuAtesakiBean.setIrShsyno(null);
        bzKokyakuAtesakiBean.setIrShadr1kj(null);
        bzKokyakuAtesakiBean.setIrShadr2kj(null);
        bzKokyakuAtesakiBean.setIrShadr3kj(null);
        bzKokyakuAtesakiBean.setIrShsnmkj(null);
        bzKokyakuAtesakiBean.setIrToiawaseyno(null);
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj(null);
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj(null);
        bzKokyakuAtesakiBean.setIrHknkisynm(null);
        bzKokyakuAtesakiBean.setIrToiawasesosiki(null);
        bzKokyakuAtesakiBean.setIrToiawasetantounm(null);
        bzKokyakuAtesakiBean.setIrToiawasetelno(null);
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1(null);
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2(null);

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd(null);
        bzDairitenAtesakiBean.setIrDrtennmkj(null);
        bzDairitenAtesakiBean.setIrTratkitantounmkj(null);
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1(null);
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2(null);
        bzDairitenAtesakiBean.setIrHknkisynm(null);
        bzDairitenAtesakiBean.setIrToiawasesosiki(null);
        bzDairitenAtesakiBean.setIrToiawasetelno(null);
        bzDairitenAtesakiBean.setIrToiawasefaxno(null);
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi(null);

        skKykhuseirituBean.setIrKyktuutisetteinissuu(null);
        skKykhuseirituBean.setIrSitencd(null);
        skKykhuseirituBean.setIrKyknmkj(null);
        skKykhuseirituBean.setIrHhknnmkj(null);
        skKykhuseirituBean.setIrMosymd(null);
        skKykhuseirituBean.setIrAisyoumei(null);
        skKykhuseirituBean.setIrSyokaihrkp(null);
        skKykhuseirituBean.setIrRyosyuymd(null);
        skKykhuseirituBean.setIrMosno(null);
        skKykhuseirituBean.setIrUktkid(null);

        skKykhuseirituBean.setIrTyouhyoutitle(null);
        skKykhuseirituBean.setIrHknsyurui(null);
        skKykhuseirituBean.setIr1puktymd(null);
        skKykhuseirituBean.setIrTantnm(null);

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(null);
        bzKokyakuAtesakiBean.setIrShsyno(null);
        bzKokyakuAtesakiBean.setIrShadr1kj(null);
        bzKokyakuAtesakiBean.setIrShadr2kj(null);
        bzKokyakuAtesakiBean.setIrShadr3kj(null);
        bzKokyakuAtesakiBean.setIrShsnmkj(null);
        bzKokyakuAtesakiBean.setIrToiawaseyno(null);
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj(null);
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj(null);
        bzKokyakuAtesakiBean.setIrHknkisynm(null);
        bzKokyakuAtesakiBean.setIrToiawasesosiki(null);
        bzKokyakuAtesakiBean.setIrToiawasetantounm(null);
        bzKokyakuAtesakiBean.setIrToiawasetelno(null);
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1(null);
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2(null);

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd(null);
        bzDairitenAtesakiBean.setIrDrtennmkj(null);
        bzDairitenAtesakiBean.setIrTratkitantounmkj(null);
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1(null);
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2(null);
        bzDairitenAtesakiBean.setIrHknkisynm(null);
        bzDairitenAtesakiBean.setIrToiawasesosiki(null);
        bzDairitenAtesakiBean.setIrToiawasetelno(null);
        bzDairitenAtesakiBean.setIrToiawasefaxno(null);
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi(null);

        skKykhuseirituBean.setIrKyktuutisetteinissuu(null);
        skKykhuseirituBean.setIrSitencd(null);
        skKykhuseirituBean.setIrKyknmkj(null);
        skKykhuseirituBean.setIrHhknnmkj(null);
        skKykhuseirituBean.setIrMosymd(null);
        skKykhuseirituBean.setIrAisyoumei(null);
        skKykhuseirituBean.setIrSyokaihrkp(null);
        skKykhuseirituBean.setIrRyosyuymd(null);
        skKykhuseirituBean.setIrMosno(null);
        skKykhuseirituBean.setIrUktkid(null);
        skKykhuseirituBean.setIrTyouhyoutitle(null);
        skKykhuseirituBean.setIrHknsyurui(null);
        skKykhuseirituBean.setIr1puktymd(null);
        skKykhuseirituBean.setIrTantnm(null);

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.YUUKOUKKNKKA);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.NONE);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(null);
        bzKokyakuAtesakiBean.setIrShsyno(null);
        bzKokyakuAtesakiBean.setIrShadr1kj(null);
        bzKokyakuAtesakiBean.setIrShadr2kj(null);
        bzKokyakuAtesakiBean.setIrShadr3kj(null);
        bzKokyakuAtesakiBean.setIrShsnmkj(null);
        bzKokyakuAtesakiBean.setIrToiawaseyno(null);
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj(null);
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj(null);
        bzKokyakuAtesakiBean.setIrHknkisynm(null);
        bzKokyakuAtesakiBean.setIrToiawasesosiki(null);
        bzKokyakuAtesakiBean.setIrToiawasetantounm(null);
        bzKokyakuAtesakiBean.setIrToiawasetelno(null);
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1(null);
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2(null);

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("99/99ＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("ww-wwww-wwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("99/99ＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("ww-wwww-wwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("99/99ＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("ww-wwww-wwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testCreateReport21(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("99/99ＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("ww-wwww-wwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testCreateReport22(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("99/99ＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("ww-wwww-wwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testCreateReport23(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("99/99ＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("ww-wwww-wwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testCreateReport24(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("wwwwwＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testCreateReport25(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("wwwwwＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testCreateReport26(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("wwwwwＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testCreateReport27(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("wwwwwＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testCreateReport28(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("wwwwwＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(290)
    @Transactional
    public void testCreateReport29(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("wwwwwＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(300)
    @Transactional
    public void testCreateReport30(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷ\nＷＷＷＷＷ\nＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("99/99ＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("ww-wwww-wwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(310)
    @Transactional
    public void testCreateReport31(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKykhuseiritu", C_SyoruiCdKbn.SK_KYKHUSEIRITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷ\nＷＷＷＷＷ\nＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        skKykhuseirituBean.setIrKyktuutisetteinissuu("Ｗ");
        skKykhuseirituBean.setIrSitencd("ＷＷ");
        skKykhuseirituBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrMosymd("9999年99月99日");
        skKykhuseirituBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrSyokaihrkp("9,999,999,999.99 ＷＷＷ");
        skKykhuseirituBean.setIrRyosyuymd("wwwwwＷＷＷ");
        skKykhuseirituBean.setIrMosno("wwwwwwwww");
        skKykhuseirituBean.setIrUktkid("ＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKykhuseirituBean.setIr1puktymd("9999年99月99日");
        skKykhuseirituBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skKykhuseirituBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skKykhuseirituBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skKykhuseirituBean.setIrNyknnrkumu(C_UmuKbn.ARI);
        skKykhuseirituBean.setIrHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        skKykhuseirituBean.setIrHusyoudakutuutishskbn(C_HusyoudakuTuutiSouhusakiKbn.DAIRITENATE);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skKykhuseirituBean,bzKokyakuAtesakiBean,bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
