package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhTrhkkakkirokusyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 取引時確認記録書（名義変更） 用クラス
 */
@RunWith(OrderedRunner.class)
public class KhTorihikijikakuninMeigihnkTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhTrhkkakkirokusyoBean khTrhkkakkirokusyoBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTorihikijikakuninMeigihnk", C_SyoruiCdKbn.KK_MEIGIHNK_TORIHIKIKAK);

        khTrhkkakkirokusyoBean.setIrSyono("XXXXXXXXXXX");
        khTrhkkakkirokusyoBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");

        reportTestBean.addParamObjects(khTrhkkakkirokusyoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTorihikijikakuninMeigihnk", C_SyoruiCdKbn.KK_MEIGIHNK_TORIHIKIKAK);

        khTrhkkakkirokusyoBean.setIrSyono("10810100009");
        khTrhkkakkirokusyoBean.setIrTyouhyousakuseiymd("平成26年12月 8日");

        reportTestBean.addParamObjects(khTrhkkakkirokusyoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTorihikijikakuninMeigihnk", C_SyoruiCdKbn.KK_MEIGIHNK_TORIHIKIKAK);

        khTrhkkakkirokusyoBean.setIrSyono("");
        khTrhkkakkirokusyoBean.setIrTyouhyousakuseiymd("");

        reportTestBean.addParamObjects(khTrhkkakkirokusyoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTorihikijikakuninMeigihnk", C_SyoruiCdKbn.KK_MEIGIHNK_TORIHIKIKAK);

        khTrhkkakkirokusyoBean.setIrSyono(null);
        khTrhkkakkirokusyoBean.setIrTyouhyousakuseiymd(null);

        reportTestBean.addParamObjects(khTrhkkakkirokusyoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

}