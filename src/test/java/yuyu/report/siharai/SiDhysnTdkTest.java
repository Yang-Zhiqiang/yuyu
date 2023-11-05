package yuyu.report.siharai;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.siharai.bean.report.SiDhysntdkBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 代表選任届テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SiDhysnTdkTest extends AbstractTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private  SiDhysntdkBean siDhysntdkBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiDaiHyouSenninTdkTest", C_SyoruiCdKbn.HK_SB_DAIHYOU);

        siDhysntdkBean.setIrSyono("wwwwwwwwwww");
        siDhysntdkBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siDhysntdkBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siDhysntdkBean.setIrMsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siDhysntdkBean.setIrMsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(siDhysntdkBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiDaiHyouSenninTdkTest", C_SyoruiCdKbn.HK_SB_DAIHYOU);

        siDhysntdkBean.setIrSyono("10000000001");
        siDhysntdkBean.setIrMsg1("　下記契約の請求に当たり全員の協議により、私が代表者となりましたので、下記の個人情報取り扱いに他");
        siDhysntdkBean.setIrMsg2("の全員とともに同意のうえお届けします。つきましては、全額を私にお支払いください。万一、本件に関し");
        siDhysntdkBean.setIrMsg3("異議を申し立てる者がありましても、当方で解決し、貴社に対しては一切ご迷惑をおかけいたしません。");
        siDhysntdkBean.setIrMsg4("異議を申し立てる者がありましても、貴社に対しては一切ご迷惑をおかけいたしません。");

        reportTestBean.addParamObjects(siDhysntdkBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiDaiHyouSenninTdkTest", C_SyoruiCdKbn.HK_SB_DAIHYOU);

        siDhysntdkBean.setIrSyono(null);
        siDhysntdkBean.setIrMsg1(null);
        siDhysntdkBean.setIrMsg2(null);
        siDhysntdkBean.setIrMsg3(null);
        siDhysntdkBean.setIrMsg4(null);

        reportTestBean.addParamObjects(siDhysntdkBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiDaiHyouSenninTdkTest", C_SyoruiCdKbn.HK_SB_DAIHYOU);

        siDhysntdkBean.setIrSyono("");
        siDhysntdkBean.setIrMsg1("");
        siDhysntdkBean.setIrMsg2("");
        siDhysntdkBean.setIrMsg3("");
        siDhysntdkBean.setIrMsg4("");

        reportTestBean.addParamObjects(siDhysntdkBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
