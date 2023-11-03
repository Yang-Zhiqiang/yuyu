package yuyu.report.sinkeiyaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SkCreditqrtrkmihaneilistDataSourceBean;
import yuyu.def.sinkeiyaku.bean.report.SkSyanailistheaderBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * クレカＱＲ登録未反映リスト（申込入力未了分）（普保Ⅱ）帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkCreditqrtourokumihaneiListTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkSyanailistheaderBean skSyanailistheaderBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCreditqrtourokumihaneiListTest", C_SyoruiCdKbn.SK_CREDITQRTOUROKUMIHANEILIST);

        skSyanailistheaderBean.setIrAtesakisosiki(null);
        skSyanailistheaderBean.setIrTyouhyousakuseiymd(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkCreditqrtrkmihaneilistDataSourceBean skCreditqrtrkmihaneilistDataSourceBean = new SkCreditqrtrkmihaneilistDataSourceBean();

        skCreditqrtrkmihaneilistDataSourceBean.setIrCreditqrtrkymd(null);
        skCreditqrtrkmihaneilistDataSourceBean.setIrDatajyusinymd(null);
        skCreditqrtrkmihaneilistDataSourceBean.setIrMosno(null);
        skCreditqrtrkmihaneilistDataSourceBean.setIrCreditkessaiyouno(null);

        dataSouceList.add(skCreditqrtrkmihaneilistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCreditqrtourokumihaneiListTest", C_SyoruiCdKbn.SK_CREDITQRTOUROKUMIHANEILIST);

        skSyanailistheaderBean.setIrAtesakisosiki("");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkCreditqrtrkmihaneilistDataSourceBean skCreditqrtrkmihaneilistDataSourceBean = new SkCreditqrtrkmihaneilistDataSourceBean();

        skCreditqrtrkmihaneilistDataSourceBean.setIrCreditqrtrkymd("");
        skCreditqrtrkmihaneilistDataSourceBean.setIrDatajyusinymd("");
        skCreditqrtrkmihaneilistDataSourceBean.setIrMosno("");
        skCreditqrtrkmihaneilistDataSourceBean.setIrCreditkessaiyouno("");

        dataSouceList.add(skCreditqrtrkmihaneilistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCreditqrtourokumihaneiListTest", C_SyoruiCdKbn.SK_CREDITQRTOUROKUMIHANEILIST);

        skSyanailistheaderBean.setIrAtesakisosiki("代理店契約室　御中");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("2019年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 14; i++) {

            SkCreditqrtrkmihaneilistDataSourceBean skCreditqrtrkmihaneilistDataSourceBean = new SkCreditqrtrkmihaneilistDataSourceBean();

            skCreditqrtrkmihaneilistDataSourceBean.setIrCreditqrtrkymd("20191111");
            skCreditqrtrkmihaneilistDataSourceBean.setIrDatajyusinymd("20191110");
            skCreditqrtrkmihaneilistDataSourceBean.setIrMosno("100000001");
            skCreditqrtrkmihaneilistDataSourceBean.setIrCreditkessaiyouno("10000000100000111111010102");

            dataSouceList.add(skCreditqrtrkmihaneilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCreditqrtourokumihaneiListTest", C_SyoruiCdKbn.SK_CREDITQRTOUROKUMIHANEILIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 15; i++) {

            SkCreditqrtrkmihaneilistDataSourceBean skCreditqrtrkmihaneilistDataSourceBean = new SkCreditqrtrkmihaneilistDataSourceBean();

            skCreditqrtrkmihaneilistDataSourceBean.setIrCreditqrtrkymd("99999999");
            skCreditqrtrkmihaneilistDataSourceBean.setIrDatajyusinymd("99999999");
            skCreditqrtrkmihaneilistDataSourceBean.setIrMosno("wwwwwwwww");
            skCreditqrtrkmihaneilistDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");

            dataSouceList.add(skCreditqrtrkmihaneilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCreditqrtourokumihaneiListTest", C_SyoruiCdKbn.SK_CREDITQRTOUROKUMIHANEILIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 16; i++) {

            SkCreditqrtrkmihaneilistDataSourceBean skCreditqrtrkmihaneilistDataSourceBean = new SkCreditqrtrkmihaneilistDataSourceBean();

            skCreditqrtrkmihaneilistDataSourceBean.setIrCreditqrtrkymd("99999999");
            skCreditqrtrkmihaneilistDataSourceBean.setIrDatajyusinymd("99999999");
            skCreditqrtrkmihaneilistDataSourceBean.setIrMosno("wwwwwwwww");
            skCreditqrtrkmihaneilistDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");

            dataSouceList.add(skCreditqrtrkmihaneilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCreditqrtourokumihaneiListTest", C_SyoruiCdKbn.SK_CREDITQRTOUROKUMIHANEILIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 999; i++) {

            SkCreditqrtrkmihaneilistDataSourceBean skCreditqrtrkmihaneilistDataSourceBean = new SkCreditqrtrkmihaneilistDataSourceBean();

            skCreditqrtrkmihaneilistDataSourceBean.setIrCreditqrtrkymd("99999999");
            skCreditqrtrkmihaneilistDataSourceBean.setIrDatajyusinymd("99999999");
            skCreditqrtrkmihaneilistDataSourceBean.setIrMosno("wwwwwwwww");
            skCreditqrtrkmihaneilistDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");

            dataSouceList.add(skCreditqrtrkmihaneilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCreditqrtourokumihaneiListTest", C_SyoruiCdKbn.SK_CREDITQRTOUROKUMIHANEILIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCreditqrtourokumihaneiListTest", C_SyoruiCdKbn.SK_CREDITQRTOUROKUMIHANEILIST);

        skSyanailistheaderBean.setIrAtesakisosiki("代理店契約室　御中");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("2019年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkCreditqrtrkmihaneilistDataSourceBean skCreditqrtrkmihaneilistDataSourceBean1 = new SkCreditqrtrkmihaneilistDataSourceBean();
        SkCreditqrtrkmihaneilistDataSourceBean skCreditqrtrkmihaneilistDataSourceBean2 = new SkCreditqrtrkmihaneilistDataSourceBean();
        SkCreditqrtrkmihaneilistDataSourceBean skCreditqrtrkmihaneilistDataSourceBean3 = new SkCreditqrtrkmihaneilistDataSourceBean();

        skCreditqrtrkmihaneilistDataSourceBean1.setIrCreditqrtrkymd("20191111");
        skCreditqrtrkmihaneilistDataSourceBean1.setIrDatajyusinymd("20191110");
        skCreditqrtrkmihaneilistDataSourceBean1.setIrMosno(String.valueOf(100000001));
        skCreditqrtrkmihaneilistDataSourceBean1.setIrCreditkessaiyouno("10000000100000111111010102");

        skCreditqrtrkmihaneilistDataSourceBean2.setIrCreditqrtrkymd("20191110");
        skCreditqrtrkmihaneilistDataSourceBean2.setIrDatajyusinymd("20191109");
        skCreditqrtrkmihaneilistDataSourceBean2.setIrMosno(String.valueOf(100000002));
        skCreditqrtrkmihaneilistDataSourceBean2.setIrCreditkessaiyouno("10000000100000111111010103");

        skCreditqrtrkmihaneilistDataSourceBean3.setIrCreditqrtrkymd("20191110");
        skCreditqrtrkmihaneilistDataSourceBean3.setIrDatajyusinymd("20191108");
        skCreditqrtrkmihaneilistDataSourceBean3.setIrMosno(String.valueOf(100000003));
        skCreditqrtrkmihaneilistDataSourceBean3.setIrCreditkessaiyouno("10000000100000111111010104");

        dataSouceList.add(skCreditqrtrkmihaneilistDataSourceBean1);
        dataSouceList.add(skCreditqrtrkmihaneilistDataSourceBean2);
        dataSouceList.add(skCreditqrtrkmihaneilistDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCreditqrtourokumihaneiListTest", C_SyoruiCdKbn.SK_CREDITQRTOUROKUMIHANEILIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 14984; i++) {

            SkCreditqrtrkmihaneilistDataSourceBean skCreditqrtrkmihaneilistDataSourceBean = new SkCreditqrtrkmihaneilistDataSourceBean();

            skCreditqrtrkmihaneilistDataSourceBean.setIrCreditqrtrkymd("99999999");
            skCreditqrtrkmihaneilistDataSourceBean.setIrDatajyusinymd("99999999");
            skCreditqrtrkmihaneilistDataSourceBean.setIrMosno("wwwwwwwww");
            skCreditqrtrkmihaneilistDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");

            dataSouceList.add(skCreditqrtrkmihaneilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}