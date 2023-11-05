package yuyu.report.sinkeiyaku;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzDairitenAtesakiBean;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 取消請求書(送付案内)テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkTrksseikyuSouhuTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private  BzDairitenAtesakiBean bzDairitenAtesakiBean;


    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkDairitenatesakiFaxSubTest", C_SyoruiCdKbn.SK_TRKSSEIKYU_SOUHU);

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

        reportTestBean.addParamObjects(bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkDairitenatesakiFaxSubTest", C_SyoruiCdKbn.SK_TRKSSEIKYU_SOUHU);

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

        reportTestBean.addParamObjects(bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkDairitenatesakiFaxSubTest", C_SyoruiCdKbn.SK_TRKSSEIKYU_SOUHU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 8月26日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)");
        bzDairitenAtesakiBean.setIrHknkisynm("保険会社名（漢字）");
        bzDairitenAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);

        reportTestBean.addParamObjects(bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkDairitenatesakiFaxSubTest", C_SyoruiCdKbn.SK_TRKSSEIKYU_SOUHU);

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

        reportTestBean.addParamObjects(bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkDairitenatesakiFaxSubTest", C_SyoruiCdKbn.SK_TRKSSEIKYU_SOUHU);

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

        reportTestBean.addParamObjects(bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkDairitenatesakiFaxSubTest", C_SyoruiCdKbn.SK_TRKSSEIKYU_SOUHU);

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

        reportTestBean.addParamObjects(bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkDairitenatesakiFaxSubTest", C_SyoruiCdKbn.SK_TRKSSEIKYU_SOUHU);

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

        reportTestBean.addParamObjects(bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkDairitenatesakiFaxSubTest", C_SyoruiCdKbn.SK_TRKSSEIKYU_SOUHU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 9月15日");
        bzDairitenAtesakiBean.setIrDrtennmkj("代理店名（漢字）ショップ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名（漢字）ショップ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１（漢字）ショップ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("(打出機関名２（漢字）)ショップ");
        bzDairitenAtesakiBean.setIrHknkisynm("保険会社名（漢字）ショップ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）ショップ");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-860-492");
        bzDairitenAtesakiBean.setIrToiawasefaxno("");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);

        reportTestBean.addParamObjects(bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkDairitenatesakiFaxSubTest", C_SyoruiCdKbn.SK_TRKSSEIKYU_SOUHU);

        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);

        reportTestBean.addParamObjects(bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}