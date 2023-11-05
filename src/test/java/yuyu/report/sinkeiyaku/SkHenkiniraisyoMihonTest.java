package yuyu.report.sinkeiyaku;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SkHenkiniraisyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 返金依頼書（ご記入見本）テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SkHenkiniraisyoMihonTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkHenkiniraisyoBean skHenkiniraisyoBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHenkiniraisyoMihonTest", C_SyoruiCdKbn.SK_HENKINIRAISYO_MIHON);

        skHenkiniraisyoBean.setIrKouzasyuruikbn(C_KouzasyuruiKbn.YENKOUZA);

        reportTestBean.addParamObjects(skHenkiniraisyoBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHenkiniraisyoMihonTest", C_SyoruiCdKbn.SK_HENKINIRAISYO_MIHON);

        skHenkiniraisyoBean.setIrKouzasyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);

        reportTestBean.addParamObjects(skHenkiniraisyoBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}