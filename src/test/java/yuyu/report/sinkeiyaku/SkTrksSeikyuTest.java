package yuyu.report.sinkeiyaku;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.sinkeiyaku.bean.report.SkTrksseikyuBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 取消請求書帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkTrksSeikyuTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private  SkTrksseikyuBean skTrksseikyuBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTrksSeikyuTest", C_SyoruiCdKbn.SK_TRKSSEIKYU);

        skTrksseikyuBean.setIrMosno(null);
        skTrksseikyuBean.setIrKznrkumu(C_UmuKbn.ARI);
        skTrksseikyuBean.setIrBanknmkj(null);
        skTrksseikyuBean.setIrSitennmkj(null);
        skTrksseikyuBean.setIrKzmeiginmkn(null);

        reportTestBean.addParamObjects(skTrksseikyuBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTrksSeikyuTest", C_SyoruiCdKbn.SK_TRKSSEIKYU);

        skTrksseikyuBean.setIrMosno("");
        skTrksseikyuBean.setIrKznrkumu(C_UmuKbn.ARI);
        skTrksseikyuBean.setIrBanknmkj("");
        skTrksseikyuBean.setIrSitennmkj("");
        skTrksseikyuBean.setIrKzmeiginmkn("");

        reportTestBean.addParamObjects(skTrksseikyuBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTrksSeikyuTest", C_SyoruiCdKbn.SK_TRKSSEIKYU);

        skTrksseikyuBean.setIrMosno("123456789");
        skTrksseikyuBean.setIrKznrkumu(C_UmuKbn.ARI);
        skTrksseikyuBean.setIrBanknmkj("銀行名");
        skTrksseikyuBean.setIrSitennmkj("支店名");
        skTrksseikyuBean.setIrKzmeiginmkn("口座名義人氏名");

        reportTestBean.addParamObjects(skTrksseikyuBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTrksSeikyuTest", C_SyoruiCdKbn.SK_TRKSSEIKYU);

        skTrksseikyuBean.setIrMosno("wwwwwwwww");
        skTrksseikyuBean.setIrKznrkumu(C_UmuKbn.ARI);
        skTrksseikyuBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skTrksseikyuBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skTrksseikyuBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(skTrksseikyuBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTrksSeikyuTest", C_SyoruiCdKbn.SK_TRKSSEIKYU);

        skTrksseikyuBean.setIrMosno("123456789");
        skTrksseikyuBean.setIrKznrkumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(skTrksseikyuBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
