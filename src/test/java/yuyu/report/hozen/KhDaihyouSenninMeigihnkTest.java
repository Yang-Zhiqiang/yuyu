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
 * 代表選任届（名義変更）帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhDaihyouSenninMeigihnkTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private  KhDaihyousennintodokeBean khDaihyousennintodokeBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhDaihyouSenninMeigihnkTest", C_SyoruiCdKbn.KK_MEIGIHNK_DAIHYOUSN);

        khDaihyousennintodokeBean.setIrSyono("wwwwwwwwwww");
        khDaihyousennintodokeBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khDaihyousennintodokeBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");

        reportTestBean.addParamObjects(khDaihyousennintodokeBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhDaihyouSenninMeigihnkTest", C_SyoruiCdKbn.KK_MEIGIHNK_DAIHYOUSN);

        khDaihyousennintodokeBean.setIrSyono("10000000001");
        khDaihyousennintodokeBean.setIrKyknmkj("契約者名");
        khDaihyousennintodokeBean.setIrTyouhyousakuseiymd("平成21年7月10日");

        reportTestBean.addParamObjects(khDaihyousennintodokeBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhDaihyouSenninMeigihnkTest", C_SyoruiCdKbn.KK_MEIGIHNK_DAIHYOUSN);

        khDaihyousennintodokeBean.setIrSyono(null);
        khDaihyousennintodokeBean.setIrKyknmkj(null);
        khDaihyousennintodokeBean.setIrTyouhyousakuseiymd(null);

        reportTestBean.addParamObjects(khDaihyousennintodokeBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhDaihyouSenninMeigihnkTest", C_SyoruiCdKbn.KK_MEIGIHNK_DAIHYOUSN);

        khDaihyousennintodokeBean.setIrSyono("");
        khDaihyousennintodokeBean.setIrKyknmkj("");
        khDaihyousennintodokeBean.setIrTyouhyousakuseiymd("");

        reportTestBean.addParamObjects(khDaihyousennintodokeBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
