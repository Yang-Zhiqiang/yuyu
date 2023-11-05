package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhCreditTourokuKensuuListBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * クレカ登録件数リスト 帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhCredittourokukensuulistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhCreditTourokuKensuuListBean khCreditTourokuKensuuListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhCredittourokukensuulistTest",
                C_SyoruiCdKbn.AS_CREDITTOUROKUKENSUULIST);

        khCreditTourokuKensuuListBean.setIrAtesakisosiki("");
        khCreditTourokuKensuuListBean.setIrSakuseiymd("");
        khCreditTourokuKensuuListBean.setIrCredittourokukensuubpo(0);

        reportTestBean.addParamObjects(khCreditTourokuKensuuListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhCredittourokukensuulistTest",
                C_SyoruiCdKbn.AS_CREDITTOUROKUKENSUULIST);

        khCreditTourokuKensuuListBean.setIrAtesakisosiki(null);
        khCreditTourokuKensuuListBean.setIrSakuseiymd(null);
        khCreditTourokuKensuuListBean.setIrCredittourokukensuubpo(null);

        reportTestBean.addParamObjects(khCreditTourokuKensuuListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhCredittourokukensuulistTest",
                C_SyoruiCdKbn.AS_CREDITTOUROKUKENSUULIST);

        khCreditTourokuKensuuListBean.setIrAtesakisosiki("収納サービス室");
        khCreditTourokuKensuuListBean.setIrSakuseiymd("20190802");
        khCreditTourokuKensuuListBean.setIrCredittourokukensuubpo(100);

        reportTestBean.addParamObjects(khCreditTourokuKensuuListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhCredittourokukensuulistTest",
                C_SyoruiCdKbn.AS_CREDITTOUROKUKENSUULIST);

        khCreditTourokuKensuuListBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khCreditTourokuKensuuListBean.setIrSakuseiymd("99999999");
        khCreditTourokuKensuuListBean.setIrCredittourokukensuubpo(99999);

        reportTestBean.addParamObjects(khCreditTourokuKensuuListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhCredittourokukensuulistTest",
                C_SyoruiCdKbn.AS_CREDITTOUROKUKENSUULIST);

        khCreditTourokuKensuuListBean.setIrAtesakisosiki("収納サービス室");
        khCreditTourokuKensuuListBean.setIrSakuseiymd("20190802");
        khCreditTourokuKensuuListBean.setIrCredittourokukensuubpo(1000);

        reportTestBean.addParamObjects(khCreditTourokuKensuuListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
