package yuyu.report.sinkeiyaku;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.sinkeiyaku.bean.report.SkHenkiniraisyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 返金依頼書テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SkHenkiniraisyoTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkHenkiniraisyoBean skHenkiniraisyoBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "sk_henkiniraisyoTest", C_SyoruiCdKbn.SK_HENKINIRAISYO);

        skHenkiniraisyoBean.setIrMosno(null);
        skHenkiniraisyoBean.setIrBanknmkj(null);
        skHenkiniraisyoBean.setIrSitennmkj(null);
        skHenkiniraisyoBean.setIrKzmeiginmkn(null);
        skHenkiniraisyoBean.setIrKznrkumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(skHenkiniraisyoBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "sk_henkiniraisyoTest", C_SyoruiCdKbn.SK_HENKINIRAISYO);

        skHenkiniraisyoBean.setIrMosno("");
        skHenkiniraisyoBean.setIrBanknmkj("");
        skHenkiniraisyoBean.setIrSitennmkj("");
        skHenkiniraisyoBean.setIrKzmeiginmkn("");
        skHenkiniraisyoBean.setIrKznrkumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(skHenkiniraisyoBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "sk_henkiniraisyoTest", C_SyoruiCdKbn.SK_HENKINIRAISYO);

        skHenkiniraisyoBean.setIrMosno("123456789");
        skHenkiniraisyoBean.setIrBanknmkj("東京銀行");
        skHenkiniraisyoBean.setIrSitennmkj("東京支店");
        skHenkiniraisyoBean.setIrKzmeiginmkn("タナカ");
        skHenkiniraisyoBean.setIrKznrkumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(skHenkiniraisyoBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "sk_henkiniraisyoTest", C_SyoruiCdKbn.SK_HENKINIRAISYO);

        skHenkiniraisyoBean.setIrMosno("wwwwwwwww");
        skHenkiniraisyoBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHenkiniraisyoBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHenkiniraisyoBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHenkiniraisyoBean.setIrKznrkumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(skHenkiniraisyoBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "sk_henkiniraisyoTest", C_SyoruiCdKbn.SK_HENKINIRAISYO);

        skHenkiniraisyoBean.setIrMosno("123456789");
        skHenkiniraisyoBean.setIrBanknmkj("東京銀行");
        skHenkiniraisyoBean.setIrSitennmkj("東京支店");
        skHenkiniraisyoBean.setIrKzmeiginmkn("タナカ");
        skHenkiniraisyoBean.setIrKznrkumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(skHenkiniraisyoBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}