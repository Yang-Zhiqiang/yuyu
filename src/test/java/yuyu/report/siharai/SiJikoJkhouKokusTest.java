package yuyu.report.siharai;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.siharai.bean.report.SiJikoJkHoukokusBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 事故状況報告書テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SiJikoJkhouKokusTest extends AbstractTest{
    @Inject
    private CreateReport createReport;

    @Inject
    private  SiJikoJkHoukokusBean ｓiJikoJkHoukokusBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiDaiHyouSenninTdkTest", C_SyoruiCdKbn.HK_KD_JIKOJKS);

        ｓiJikoJkHoukokusBean.setIrSyoriymd("");
        ｓiJikoJkHoukokusBean.setIrHozonkkn("");

        reportTestBean.addParamObjects(ｓiJikoJkHoukokusBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiDaiHyouSenninTdkTest", C_SyoruiCdKbn.HK_KD_JIKOJKS);

        ｓiJikoJkHoukokusBean.setIrSyoriymd(null);
        ｓiJikoJkHoukokusBean.setIrHozonkkn(null);

        reportTestBean.addParamObjects(ｓiJikoJkHoukokusBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiDaiHyouSenninTdkTest", C_SyoruiCdKbn.HK_KD_JIKOJKS);

        ｓiJikoJkHoukokusBean.setIrSyoriymd("平成26年12月26日");
        ｓiJikoJkHoukokusBean.setIrHozonkkn("7");

        reportTestBean.addParamObjects(ｓiJikoJkHoukokusBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiDaiHyouSenninTdkTest", C_SyoruiCdKbn.HK_KD_JIKOJKS);

        ｓiJikoJkHoukokusBean.setIrSyoriymd("ＷＷ99年99月99日");
        ｓiJikoJkHoukokusBean.setIrHozonkkn("99");

        reportTestBean.addParamObjects(ｓiJikoJkHoukokusBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
