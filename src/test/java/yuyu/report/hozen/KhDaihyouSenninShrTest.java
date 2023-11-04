package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhDaihyousennintodokeBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 代表選任届（支払）帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhDaihyouSenninShrTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private  KhDaihyousennintodokeBean khDaihyousennintodokeBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhDaihyouSenninShrTest", C_SyoruiCdKbn.KK_KAIYAKU_DAIHYOUSN);

        khDaihyousennintodokeBean.setIrSyono(null);
        khDaihyousennintodokeBean.setIrKyknmkj(null);
        khDaihyousennintodokeBean.setIrTyouhyousakuseiymd(null);
        khDaihyousennintodokeBean.setIrKinouid(null);

        reportTestBean.addParamObjects(khDaihyousennintodokeBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhDaihyouSenninShrTest", C_SyoruiCdKbn.KK_KAIYAKU_DAIHYOUSN);

        khDaihyousennintodokeBean.setIrSyono("");
        khDaihyousennintodokeBean.setIrKyknmkj("");
        khDaihyousennintodokeBean.setIrTyouhyousakuseiymd("");
        khDaihyousennintodokeBean.setIrKinouid("");

        reportTestBean.addParamObjects(khDaihyousennintodokeBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhDaihyouSenninShrTest", C_SyoruiCdKbn.KK_KAIYAKU_DAIHYOUSN);

        khDaihyousennintodokeBean.setIrSyono("17806000035");
        khDaihyousennintodokeBean.setIrKyknmkj("田中　太郎");
        khDaihyousennintodokeBean.setIrTyouhyousakuseiymd("平成 2年 7月 5日");
        khDaihyousennintodokeBean.setIrKinouid("khkaiyaku");

        reportTestBean.addParamObjects(khDaihyousennintodokeBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhDaihyouSenninShrTest", C_SyoruiCdKbn.KK_KAIYAKU_DAIHYOUSN);

        khDaihyousennintodokeBean.setIrSyono("wwwwwwwwwww");
        khDaihyousennintodokeBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khDaihyousennintodokeBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        khDaihyousennintodokeBean.setIrKinouid("khkaiyaku");

        reportTestBean.addParamObjects(khDaihyousennintodokeBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhDaihyouSenninShrTest", C_SyoruiCdKbn.KK_YENDTHNKHNRKN_DAIHYOUSN);

        khDaihyousennintodokeBean.setIrSyono("17806000035");
        khDaihyousennintodokeBean.setIrKyknmkj("田中　太郎");
        khDaihyousennintodokeBean.setIrTyouhyousakuseiymd("平成 2年 7月 5日");
        khDaihyousennintodokeBean.setIrKinouid("khyendthnkhrshr");

        reportTestBean.addParamObjects(khDaihyousennintodokeBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
