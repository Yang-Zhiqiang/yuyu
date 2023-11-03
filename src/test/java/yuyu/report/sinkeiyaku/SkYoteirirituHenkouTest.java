package yuyu.report.sinkeiyaku;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzDairitenAtesakiBean;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.sinkeiyaku.bean.report.SkYoteirirituhenkouBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 予定利率変更連絡票帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkYoteirirituHenkouTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkYoteirirituhenkouBean skYoteirirituhenkouBean;

    @Inject
    private BzDairitenAtesakiBean bzDairitenAtesakiBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno(null);
        skYoteirirituhenkouBean.setIrDrtenjimcd(null);
        skYoteirirituhenkouBean.setIrKyknmkj(null);
        skYoteirirituhenkouBean.setIrAisyoumei(null);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd(null);

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("");
        skYoteirirituhenkouBean.setIrDrtenjimcd("");
        skYoteirirituhenkouBean.setIrKyknmkj("");
        skYoteirirituhenkouBean.setIrAisyoumei("");
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("しんきんらいふ年金Ｓ　たのしみ未来グローバル");
        skYoteirirituhenkouBean.setIrHhknnmkj("被保険者名（漢字）");
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("www-www-www");
        skYoteirirituhenkouBean.setIrDrtenjimcd("wwww");
        skYoteirirituhenkouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMTB);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrHhknnmkj("被保険者名（漢字）");
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno(null);
        skYoteirirituhenkouBean.setIrDrtenjimcd(null);
        skYoteirirituhenkouBean.setIrKyknmkj(null);
        skYoteirirituhenkouBean.setIrAisyoumei(null);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("");
        skYoteirirituhenkouBean.setIrDrtenjimcd("");
        skYoteirirituhenkouBean.setIrKyknmkj("");
        skYoteirirituhenkouBean.setIrAisyoumei("");
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrHhknnmkj("被保険者名（漢字）");
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_DOUITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 9月15日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）ショップ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）ショップ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("保険会社名（漢字）ショップ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）ショップ");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-860-492");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrHhknnmkj("被保険者名（漢字）");
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_DOUITU);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }


    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno(null);
        skYoteirirituhenkouBean.setIrDrtenjimcd(null);
        skYoteirirituhenkouBean.setIrKyknmkj(null);
        skYoteirirituhenkouBean.setIrAisyoumei(null);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("");
        skYoteirirituhenkouBean.setIrDrtenjimcd("");
        skYoteirirituhenkouBean.setIrKyknmkj("");
        skYoteirirituhenkouBean.setIrAisyoumei("");
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("しんきんらいふ年金Ｓ　たのしみ未来グローバル");
        skYoteirirituhenkouBean.setIrHhknnmkj("被保険者名（漢字）");
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-303");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("www-www-www");
        skYoteirirituhenkouBean.setIrDrtenjimcd("wwww");
        skYoteirirituhenkouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMTB);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrHhknnmkj("被保険者名（漢字）");
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrHhknnmkj("被保険者名（漢字）");
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_DOUITU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 9月15日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）ショップ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）ショップ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("保険会社名（漢字）ショップ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）ショップ");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-860-492");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrHhknnmkj("被保険者名（漢字）");
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_DOUITU);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno(null);
        skYoteirirituhenkouBean.setIrDrtenjimcd(null);
        skYoteirirituhenkouBean.setIrKyknmkj(null);
        skYoteirirituhenkouBean.setIrAisyoumei(null);
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu(null);
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu(null);
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn(null);
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn(null);
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu(null);
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu(null);
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.NONE);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn(null);
        skYoteirirituhenkouBean.setIrMsg1(null);
        skYoteirirituhenkouBean.setIrMsg2(null);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("");
        skYoteirirituhenkouBean.setIrDrtenjimcd("");
        skYoteirirituhenkouBean.setIrKyknmkj("");
        skYoteirirituhenkouBean.setIrAisyoumei("");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.NONE);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("");
        skYoteirirituhenkouBean.setIrMsg1("");
        skYoteirirituhenkouBean.setIrMsg2("");

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }


    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno(null);
        skYoteirirituhenkouBean.setIrDrtenjimcd(null);
        skYoteirirituhenkouBean.setIrKyknmkj(null);
        skYoteirirituhenkouBean.setIrAisyoumei(null);
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu(null);
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu(null);
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn(null);
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn(null);
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu(null);
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu(null);
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("7");
        skYoteirirituhenkouBean.setIrMsg1(null);
        skYoteirirituhenkouBean.setIrMsg2(null);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("");
        skYoteirirituhenkouBean.setIrDrtenjimcd("");
        skYoteirirituhenkouBean.setIrKyknmkj("");
        skYoteirirituhenkouBean.setIrAisyoumei("");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("7");
        skYoteirirituhenkouBean.setIrMsg1("");
        skYoteirirituhenkouBean.setIrMsg2("");

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testCreateReport21() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.NONE);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("1");
        skYoteirirituhenkouBean.setIrMsg1("予定利率が変動し、基本保険金額が申込日時点より変更となっていることを契約者様にご説明願います。");
        skYoteirirituhenkouBean.setIrMsg2("確定した基本保険金額につきましては、当社より送付いたします保険証券に記載しております。");

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testCreateReport22() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("1");

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testCreateReport23() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("2");

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testCreateReport24() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("3");

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testCreateReport25() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("4");

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testCreateReport26() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("5");

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testCreateReport27() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("6");

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testCreateReport28() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("7");
        skYoteirirituhenkouBean.setIrMsg1("予定利率が変動し、基本保険金額が申込日時点より変更となっていることを契約者様にご説明願います。");
        skYoteirirituhenkouBean.setIrMsg2("確定した基本保険金額につきましては、当社より送付いたします保険証券に記載しております。");

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(290)
    @Transactional
    public void testCreateReport29() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("www-www-www");
        skYoteirirituhenkouBean.setIrDrtenjimcd("wwww");
        skYoteirirituhenkouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("wwww");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("wwwwww");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("wwwwww");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("wwww");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("wwww");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.NONE);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("7");
        skYoteirirituhenkouBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(300)
    @Transactional
    public void testCreateReport30() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("www-www-www");
        skYoteirirituhenkouBean.setIrDrtenjimcd("wwww");
        skYoteirirituhenkouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("wwww");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("wwwwww");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("wwwwww");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("wwww");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("wwww");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("7");
        skYoteirirituhenkouBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(310)
    @Transactional
    public void testCreateReport31() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno(null);
        skYoteirirituhenkouBean.setIrDrtenjimcd(null);
        skYoteirirituhenkouBean.setIrKyknmkj(null);
        skYoteirirituhenkouBean.setIrAisyoumei(null);
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu(null);
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu(null);
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn(null);
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn(null);
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu(null);
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu(null);
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.NONE);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn(null);
        skYoteirirituhenkouBean.setIrMsg1(null);
        skYoteirirituhenkouBean.setIrMsg2(null);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(320)
    @Transactional
    public void testCreateReport32() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("");
        skYoteirirituhenkouBean.setIrDrtenjimcd("");
        skYoteirirituhenkouBean.setIrKyknmkj("");
        skYoteirirituhenkouBean.setIrAisyoumei("");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.NONE);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("");
        skYoteirirituhenkouBean.setIrMsg1("");
        skYoteirirituhenkouBean.setIrMsg2("");

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }


    @Test
    @TestOrder(330)
    @Transactional
    public void testCreateReport33() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno(null);
        skYoteirirituhenkouBean.setIrDrtenjimcd(null);
        skYoteirirituhenkouBean.setIrKyknmkj(null);
        skYoteirirituhenkouBean.setIrAisyoumei(null);
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu(null);
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu(null);
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn(null);
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn(null);
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu(null);
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu(null);
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("7");
        skYoteirirituhenkouBean.setIrMsg1(null);
        skYoteirirituhenkouBean.setIrMsg2(null);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(340)
    @Transactional
    public void testCreateReport34() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("");
        skYoteirirituhenkouBean.setIrDrtenjimcd("");
        skYoteirirituhenkouBean.setIrKyknmkj("");
        skYoteirirituhenkouBean.setIrAisyoumei("");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("7");
        skYoteirirituhenkouBean.setIrMsg1("");
        skYoteirirituhenkouBean.setIrMsg2("");

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(350)
    @Transactional
    public void testCreateReport35() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.NONE);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("1");
        skYoteirirituhenkouBean.setIrMsg1("予定利率が変動し、基本保険金額が申込日時点より変更となっていることを契約者様にご説明願います。");
        skYoteirirituhenkouBean.setIrMsg2("確定した基本保険金額につきましては、当社より送付いたします保険証券に記載しております。");

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(360)
    @Transactional
    public void testCreateReport36() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("1");

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(370)
    @Transactional
    public void testCreateReport37() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("2");

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(380)
    @Transactional
    public void testCreateReport38() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("3");

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(390)
    @Transactional
    public void testCreateReport39() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("4");

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(400)
    @Transactional
    public void testCreateReport40() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("5");

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(410)
    @Transactional
    public void testCreateReport41() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("6");

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(420)
    @Transactional
    public void testCreateReport42() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("7");
        skYoteirirituhenkouBean.setIrMsg1("予定利率が変動し、基本保険金額が申込日時点より変更となっていることを契約者様にご説明願います。");
        skYoteirirituhenkouBean.setIrMsg2("確定した基本保険金額につきましては、当社より送付いたします保険証券に記載しております。");


        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(430)
    @Transactional
    public void testCreateReport43() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("www-www-www");
        skYoteirirituhenkouBean.setIrDrtenjimcd("wwww");
        skYoteirirituhenkouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("wwww");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("wwwwww");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("wwwwww");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("wwww");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("wwww");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.NONE);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("7");
        skYoteirirituhenkouBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(440)
    @Transactional
    public void testCreateReport44() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("www-www-www");
        skYoteirirituhenkouBean.setIrDrtenjimcd("wwww");
        skYoteirirituhenkouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("wwww");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("wwwwww");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("wwwwww");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("wwww");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("wwww");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("7");
        skYoteirirituhenkouBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(450)
    @Transactional
    public void testCreateReport45() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno(null);
        skYoteirirituhenkouBean.setIrDrtenjimcd(null);
        skYoteirirituhenkouBean.setIrKyknmkj(null);
        skYoteirirituhenkouBean.setIrAisyoumei(null);
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu(null);
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu(null);
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn(null);
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn(null);
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu(null);
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu(null);
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt(null);
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt(null);
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("8");
        skYoteirirituhenkouBean.setIrMsg1(null);
        skYoteirirituhenkouBean.setIrMsg2(null);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(460)
    @Transactional
    public void testCreateReport46() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("");
        skYoteirirituhenkouBean.setIrDrtenjimcd("");
        skYoteirirituhenkouBean.setIrKyknmkj("");
        skYoteirirituhenkouBean.setIrAisyoumei("");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("");
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt("");
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt("");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("8");
        skYoteirirituhenkouBean.setIrMsg1("");
        skYoteirirituhenkouBean.setIrMsg2("");

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(470)
    @Transactional
    public void testCreateReport47() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt("9.95");
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt("9.96");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("8");
        skYoteirirituhenkouBean.setIrMsg1("予定利率が変動し、基本保険金額が申込日時点より変更となっていることを契約者様にご説明願います。");
        skYoteirirituhenkouBean.setIrMsg2("確定した基本保険金額につきましては、当社より送付いたします保険証券に記載しております。");

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(480)
    @Transactional
    public void testCreateReport48() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("www-www-www");
        skYoteirirituhenkouBean.setIrDrtenjimcd("wwww");
        skYoteirirituhenkouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("wwww");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("wwwwww");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("wwwwww");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("wwww");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("wwww");
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt("wwww");
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt("wwww");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("8");
        skYoteirirituhenkouBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(490)
    @Transactional
    public void testCreateReport49() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno(null);
        skYoteirirituhenkouBean.setIrDrtenjimcd(null);
        skYoteirirituhenkouBean.setIrKyknmkj(null);
        skYoteirirituhenkouBean.setIrAisyoumei(null);
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu(null);
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu(null);
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn(null);
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn(null);
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu(null);
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu(null);
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt(null);
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt(null);
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("8");
        skYoteirirituhenkouBean.setIrMsg1(null);
        skYoteirirituhenkouBean.setIrMsg2(null);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(500)
    @Transactional
    public void testCreateReport50() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("");
        skYoteirirituhenkouBean.setIrDrtenjimcd("");
        skYoteirirituhenkouBean.setIrKyknmkj("");
        skYoteirirituhenkouBean.setIrAisyoumei("");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("");
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt("");
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt("");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("8");
        skYoteirirituhenkouBean.setIrMsg1("");
        skYoteirirituhenkouBean.setIrMsg2("");

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(510)
    @Transactional
    public void testCreateReport51() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt("9.95");
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt("9.96");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("8");
        skYoteirirituhenkouBean.setIrMsg1("予定利率が変動し、基本保険金額が申込日時点より変更となっていることを契約者様にご説明願います。");
        skYoteirirituhenkouBean.setIrMsg2("確定した基本保険金額につきましては、当社より送付いたします保険証券に記載しております。");


        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(520)
    @Transactional
    public void testCreateReport52() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("www-www-www");
        skYoteirirituhenkouBean.setIrDrtenjimcd("wwww");
        skYoteirirituhenkouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("wwww");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("wwwwww");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("wwwwww");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("wwww");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("wwww");
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt("wwww");
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt("wwww");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("8");
        skYoteirirituhenkouBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(530)
    @Transactional
    public void testCreateReport53() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno(null);
        skYoteirirituhenkouBean.setIrDrtenjimcd(null);
        skYoteirirituhenkouBean.setIrKyknmkj(null);
        skYoteirirituhenkouBean.setIrAisyoumei(null);
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu(null);
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu(null);
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn(null);
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn(null);
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu(null);
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu(null);
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt(null);
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt(null);
        skYoteirirituhenkouBean.setIrMosymdrendouritu(null);
        skYoteirirituhenkouBean.setIrKykymdrendouritu(null);
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("9");
        skYoteirirituhenkouBean.setIrMsg1(null);
        skYoteirirituhenkouBean.setIrMsg2(null);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(540)
    @Transactional
    public void testCreateReport54() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("");
        skYoteirirituhenkouBean.setIrDrtenjimcd("");
        skYoteirirituhenkouBean.setIrKyknmkj("");
        skYoteirirituhenkouBean.setIrAisyoumei("");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("");
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt("");
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt("");
        skYoteirirituhenkouBean.setIrMosymdrendouritu("");
        skYoteirirituhenkouBean.setIrKykymdrendouritu("");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("9");
        skYoteirirituhenkouBean.setIrMsg1("");
        skYoteirirituhenkouBean.setIrMsg2("");

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(550)
    @Transactional
    public void testCreateReport55() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt("9.95");
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt("9.96");
        skYoteirirituhenkouBean.setIrMosymdrendouritu("999.98");
        skYoteirirituhenkouBean.setIrKykymdrendouritu("999.95");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("9");
        skYoteirirituhenkouBean.setIrMsg1("予定利率が変動し、基本保険金額が申込日時点より変更となっていることを契約者様にご説明願います。");
        skYoteirirituhenkouBean.setIrMsg2("確定した基本保険金額につきましては、当社より送付いたします保険証券に記載しております。");

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(560)
    @Transactional
    public void testCreateReport56() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("www-www-www");
        skYoteirirituhenkouBean.setIrDrtenjimcd("wwww");
        skYoteirirituhenkouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("wwww");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("wwwwww");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("wwwwww");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("wwww");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("wwww");
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt("wwww");
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt("wwww");
        skYoteirirituhenkouBean.setIrMosymdrendouritu("wwwwww");
        skYoteirirituhenkouBean.setIrKykymdrendouritu("wwwwww");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("9");
        skYoteirirituhenkouBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(570)
    @Transactional
    public void testCreateReport57() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno(null);
        skYoteirirituhenkouBean.setIrDrtenjimcd(null);
        skYoteirirituhenkouBean.setIrKyknmkj(null);
        skYoteirirituhenkouBean.setIrAisyoumei(null);
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu(null);
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu(null);
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn(null);
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn(null);
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu(null);
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu(null);
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt(null);
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt(null);
        skYoteirirituhenkouBean.setIrMosymdrendouritu(null);
        skYoteirirituhenkouBean.setIrKykymdrendouritu(null);
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("9");
        skYoteirirituhenkouBean.setIrMsg1(null);
        skYoteirirituhenkouBean.setIrMsg2(null);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(580)
    @Transactional
    public void testCreateReport58() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("");
        skYoteirirituhenkouBean.setIrDrtenjimcd("");
        skYoteirirituhenkouBean.setIrKyknmkj("");
        skYoteirirituhenkouBean.setIrAisyoumei("");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("");
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt("");
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt("");
        skYoteirirituhenkouBean.setIrMosymdrendouritu("");
        skYoteirirituhenkouBean.setIrKykymdrendouritu("");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("9");
        skYoteirirituhenkouBean.setIrMsg1("");
        skYoteirirituhenkouBean.setIrMsg2("");

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(590)
    @Transactional
    public void testCreateReport59() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt("9.95");
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt("9.96");
        skYoteirirituhenkouBean.setIrMosymdrendouritu("999.98");
        skYoteirirituhenkouBean.setIrKykymdrendouritu("999.95");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("9");
        skYoteirirituhenkouBean.setIrMsg1("予定利率が変動し、基本保険金額が申込日時点より変更となっていることを契約者様にご説明願います。");
        skYoteirirituhenkouBean.setIrMsg2("確定した基本保険金額につきましては、当社より送付いたします保険証券に記載しております。");


        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(600)
    @Transactional
    public void testCreateReport60() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("www-www-www");
        skYoteirirituhenkouBean.setIrDrtenjimcd("wwww");
        skYoteirirituhenkouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("wwww");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("wwwwww");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("wwwwww");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("wwww");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("wwww");
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt("wwww");
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt("wwww");
        skYoteirirituhenkouBean.setIrMosymdrendouritu("wwwwww");
        skYoteirirituhenkouBean.setIrKykymdrendouritu("wwwwww");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("9");
        skYoteirirituhenkouBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(610)
    @Transactional
    public void testCreateReport61() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno(null);
        skYoteirirituhenkouBean.setIrDrtenjimcd(null);
        skYoteirirituhenkouBean.setIrKyknmkj(null);
        skYoteirirituhenkouBean.setIrAisyoumei(null);
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu(null);
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu(null);
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn(null);
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn(null);
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu(null);
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu(null);
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt(null);
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt(null);
        skYoteirirituhenkouBean.setIrMosymdrendouritu(null);
        skYoteirirituhenkouBean.setIrKykymdrendouritu(null);
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("10");
        skYoteirirituhenkouBean.setIrMsg1(null);
        skYoteirirituhenkouBean.setIrMsg2(null);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(620)
    @Transactional
    public void testCreateReport62() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("");
        skYoteirirituhenkouBean.setIrDrtenjimcd("");
        skYoteirirituhenkouBean.setIrKyknmkj("");
        skYoteirirituhenkouBean.setIrAisyoumei("");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("");
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt("");
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt("");
        skYoteirirituhenkouBean.setIrMosymdrendouritu("");
        skYoteirirituhenkouBean.setIrKykymdrendouritu("");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("10");
        skYoteirirituhenkouBean.setIrMsg1("");
        skYoteirirituhenkouBean.setIrMsg2("");

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(630)
    @Transactional
    public void testCreateReport63() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt("9.95");
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt("9.96");
        skYoteirirituhenkouBean.setIrMosymdrendouritu("999.98");
        skYoteirirituhenkouBean.setIrKykymdrendouritu("999.95");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("10");
        skYoteirirituhenkouBean.setIrMsg1("予定利率が変動し、基本保険金額が申込日時点より変更となっていることを契約者様にご説明願います。");
        skYoteirirituhenkouBean.setIrMsg2("確定した基本保険金額につきましては、当社より送付いたします保険証券に記載しております。");

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(640)
    @Transactional
    public void testCreateReport64() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("www-www-www");
        skYoteirirituhenkouBean.setIrDrtenjimcd("wwww");
        skYoteirirituhenkouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("wwww");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("wwwwww");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("wwwwww");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("wwww");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("wwww");
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt("wwww");
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt("wwww");
        skYoteirirituhenkouBean.setIrMosymdrendouritu("wwwwww");
        skYoteirirituhenkouBean.setIrKykymdrendouritu("wwwwww");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("10");
        skYoteirirituhenkouBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("5100001");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(650)
    @Transactional
    public void testCreateReport65() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno(null);
        skYoteirirituhenkouBean.setIrDrtenjimcd(null);
        skYoteirirituhenkouBean.setIrKyknmkj(null);
        skYoteirirituhenkouBean.setIrAisyoumei(null);
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu(null);
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu(null);
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu(null);
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn(null);
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn(null);
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu(null);
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu(null);
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt(null);
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt(null);
        skYoteirirituhenkouBean.setIrMosymdrendouritu(null);
        skYoteirirituhenkouBean.setIrKykymdrendouritu(null);
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("10");
        skYoteirirituhenkouBean.setIrMsg1(null);
        skYoteirirituhenkouBean.setIrMsg2(null);

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(660)
    @Transactional
    public void testCreateReport66() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("");
        skYoteirirituhenkouBean.setIrDrtenjimcd("");
        skYoteirirituhenkouBean.setIrKyknmkj("");
        skYoteirirituhenkouBean.setIrAisyoumei("");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("");
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt("");
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt("");
        skYoteirirituhenkouBean.setIrMosymdrendouritu("");
        skYoteirirituhenkouBean.setIrKykymdrendouritu("");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("10");
        skYoteirirituhenkouBean.setIrMsg1("");
        skYoteirirituhenkouBean.setIrMsg2("");

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.BLNK);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(670)
    @Transactional
    public void testCreateReport67() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("999-999-999");
        skYoteirirituhenkouBean.setIrDrtenjimcd("9999");
        skYoteirirituhenkouBean.setIrKyknmkj("契約者名（漢字）");
        skYoteirirituhenkouBean.setIrAisyoumei("愛称名");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("9.99");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("9.98");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("9.91");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("9.92");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("999.99");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("999.98");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("9.93");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("9.94");
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt("9.95");
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt("9.96");
        skYoteirirituhenkouBean.setIrMosymdrendouritu("999.98");
        skYoteirirituhenkouBean.setIrKykymdrendouritu("999.95");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("10");
        skYoteirirituhenkouBean.setIrMsg1("予定利率が変動し、基本保険金額が申込日時点より変更となっていることを契約者様にご説明願います。");
        skYoteirirituhenkouBean.setIrMsg2("確定した基本保険金額につきましては、当社より送付いたします保険証券に記載しております。");


        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(680)
    @Transactional
    public void testCreateReport68() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYoteirirituHenkouTest",
                C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU);

        skYoteirirituhenkouBean.setIrMosno("www-www-www");
        skYoteirirituhenkouBean.setIrDrtenjimcd("wwww");
        skYoteirirituhenkouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);
        skYoteirirituhenkouBean.setIrMosymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdyoteiriritu("wwww");
        skYoteirirituhenkouBean.setIrMosymdtumitateriritu("wwww");
        skYoteirirituhenkouBean.setIrKykymdtumitateriritu("wwww");
        skYoteirirituhenkouBean.setIrMosymdtmttknzoukaritujygn("wwwwww");
        skYoteirirituhenkouBean.setIrKykymdtmttknzoukaritujygn("wwwwww");
        skYoteirirituhenkouBean.setIrMosymdsetteibairitu("wwww");
        skYoteirirituhenkouBean.setIrKykymdsetteibairitu("wwww");
        skYoteirirituhenkouBean.setIrMosymdloadinghnkgtmttrrt("wwww");
        skYoteirirituhenkouBean.setIrKykymdloadinghnkgtmttrrt("wwww");
        skYoteirirituhenkouBean.setIrMosymdrendouritu("wwwwww");
        skYoteirirituhenkouBean.setIrKykymdrendouritu("wwwwww");
        skYoteirirituhenkouBean.setIrTmttrrttouhendouumu(C_UmuKbn.ARI);
        skYoteirirituhenkouBean.setIrTmttrrttourayoutptn("10");
        skYoteirirituhenkouBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skYoteirirituhenkouBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

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
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        skYoteirirituhenkouBean.setIrOyadrtencd("2101079");

        reportTestBean.addParamObjects(skYoteirirituhenkouBean, bzDairitenAtesakiBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }
}
