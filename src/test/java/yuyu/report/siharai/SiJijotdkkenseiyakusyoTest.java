package yuyu.report.siharai;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.siharai.bean.report.SiJijotdkkenseiyakusyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 事情届兼誓約書 用クラス
 */
@RunWith(OrderedRunner.class)
public class SiJijotdkkenseiyakusyoTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SiJijotdkkenseiyakusyoBean siJijotdkkenseiyakusyoBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiJijotdkkenseiyakusyoTest", C_SyoruiCdKbn.HK_JIJYOUTODOKEKENSEIYAKUSYO);

        siJijotdkkenseiyakusyoBean.setIrSyono("");
        siJijotdkkenseiyakusyoBean.setIrHknknuktnm("");
        siJijotdkkenseiyakusyoBean.setIrDrsknm("");

        reportTestBean.addParamObjects(siJijotdkkenseiyakusyoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiJijotdkkenseiyakusyoTest", C_SyoruiCdKbn.HK_JIJYOUTODOKEKENSEIYAKUSYO);

        siJijotdkkenseiyakusyoBean.setIrSyono(null);
        siJijotdkkenseiyakusyoBean.setIrHknknuktnm(null);
        siJijotdkkenseiyakusyoBean.setIrDrsknm(null);

        reportTestBean.addParamObjects(siJijotdkkenseiyakusyoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiJijotdkkenseiyakusyoTest", C_SyoruiCdKbn.HK_JIJYOUTODOKEKENSEIYAKUSYO);

        siJijotdkkenseiyakusyoBean.setIrSyono("１２３４５６７８９０１");
        siJijotdkkenseiyakusyoBean.setIrHknknuktnm("田中　太郎");
        siJijotdkkenseiyakusyoBean.setIrDrsknm("田中　次郎");

        reportTestBean.addParamObjects(siJijotdkkenseiyakusyoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiJijotdkkenseiyakusyoTest", C_SyoruiCdKbn.HK_JIJYOUTODOKEKENSEIYAKUSYO);

        siJijotdkkenseiyakusyoBean.setIrSyono("ＷＷＷＷＷＷＷＷＷＷＷ");
        siJijotdkkenseiyakusyoBean.setIrHknknuktnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siJijotdkkenseiyakusyoBean.setIrDrsknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(siJijotdkkenseiyakusyoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
