package yuyu.report.sinkeiyaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_CreditTrkhouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SkCreditcardtourokuhaneierrlistDataSourceBean;
import yuyu.def.sinkeiyaku.bean.report.SkSyanailistheaderBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * クレジットカ－ド登録反映エラーリスト帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkCredittourokuhaneierrorListTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkSyanailistheaderBean skSyanailistheaderBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCredittourokuhaneierrorListTest", C_SyoruiCdKbn.SK_CREDITCARDTOUROKUHANEIERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki(null);
        skSyanailistheaderBean.setIrTyouhyousakuseiymd(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkCreditcardtourokuhaneierrlistDataSourceBean skCreditcardtourokuhaneierrlistDataSourceBean = new SkCreditcardtourokuhaneierrlistDataSourceBean();

        skCreditcardtourokuhaneierrlistDataSourceBean.setIrCredittrkhoukbn(null);
        skCreditcardtourokuhaneierrlistDataSourceBean.setIrSosikicd(null);
        skCreditcardtourokuhaneierrlistDataSourceBean.setIrMosno(null);
        skCreditcardtourokuhaneierrlistDataSourceBean.setIrCreditkessaiyouno(null);
        skCreditcardtourokuhaneierrlistDataSourceBean.setIrCredittrkhaneierrriyuu(null);
        dataSouceList.add(skCreditcardtourokuhaneierrlistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCredittourokuhaneierrorListTest", C_SyoruiCdKbn.SK_CREDITCARDTOUROKUHANEIERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkCreditcardtourokuhaneierrlistDataSourceBean skCreditcardtourokuhaneierrlistDataSourceBean = new SkCreditcardtourokuhaneierrlistDataSourceBean();

        skCreditcardtourokuhaneierrlistDataSourceBean.setIrCredittrkhoukbn(C_CreditTrkhouKbn.BLNK);
        skCreditcardtourokuhaneierrlistDataSourceBean.setIrSosikicd("");
        skCreditcardtourokuhaneierrlistDataSourceBean.setIrMosno("");
        skCreditcardtourokuhaneierrlistDataSourceBean.setIrCreditkessaiyouno("");
        skCreditcardtourokuhaneierrlistDataSourceBean.setIrCredittrkhaneierrriyuu("");
        dataSouceList.add(skCreditcardtourokuhaneierrlistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCredittourokuhaneierrorListTest", C_SyoruiCdKbn.SK_CREDITCARDTOUROKUHANEIERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("代理店契約室　御中");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("2019年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 14; i++) {

            SkCreditcardtourokuhaneierrlistDataSourceBean skCreditcardtourokuhaneierrlistDataSourceBean = new SkCreditcardtourokuhaneierrlistDataSourceBean();

            skCreditcardtourokuhaneierrlistDataSourceBean.setIrCredittrkhoukbn(C_CreditTrkhouKbn.QR);
            skCreditcardtourokuhaneierrlistDataSourceBean.setIrSosikicd("1234567");
            skCreditcardtourokuhaneierrlistDataSourceBean.setIrMosno("100000001");
            skCreditcardtourokuhaneierrlistDataSourceBean.setIrCreditkessaiyouno("10000000100000111111010102");
            skCreditcardtourokuhaneierrlistDataSourceBean.setIrCredittrkhaneierrriyuu("申込レコードなし");

            dataSouceList.add(skCreditcardtourokuhaneierrlistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCredittourokuhaneierrorListTest", C_SyoruiCdKbn.SK_CREDITCARDTOUROKUHANEIERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 15; i++) {

            SkCreditcardtourokuhaneierrlistDataSourceBean skCreditcardtourokuhaneierrlistDataSourceBean = new SkCreditcardtourokuhaneierrlistDataSourceBean();

            skCreditcardtourokuhaneierrlistDataSourceBean.setIrCredittrkhoukbn(C_CreditTrkhouKbn.SYOMEN);
            skCreditcardtourokuhaneierrlistDataSourceBean.setIrSosikicd("wwwwwww");
            skCreditcardtourokuhaneierrlistDataSourceBean.setIrMosno("wwwwwwwww");
            skCreditcardtourokuhaneierrlistDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
            skCreditcardtourokuhaneierrlistDataSourceBean.setIrCredittrkhaneierrriyuu("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            dataSouceList.add(skCreditcardtourokuhaneierrlistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCredittourokuhaneierrorListTest", C_SyoruiCdKbn.SK_CREDITCARDTOUROKUHANEIERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("代理店契約室　御中");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("2019年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 16; i++) {

            SkCreditcardtourokuhaneierrlistDataSourceBean skCreditcardtourokuhaneierrlistDataSourceBean = new SkCreditcardtourokuhaneierrlistDataSourceBean();

            skCreditcardtourokuhaneierrlistDataSourceBean.setIrCredittrkhoukbn(C_CreditTrkhouKbn.QR);
            skCreditcardtourokuhaneierrlistDataSourceBean.setIrSosikicd("1234567");
            skCreditcardtourokuhaneierrlistDataSourceBean.setIrMosno("100000001");
            skCreditcardtourokuhaneierrlistDataSourceBean.setIrCreditkessaiyouno("10000000100000111111010102");
            skCreditcardtourokuhaneierrlistDataSourceBean.setIrCredittrkhaneierrriyuu("申込レコードなし");

            dataSouceList.add(skCreditcardtourokuhaneierrlistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCredittourokuhaneierrorListTest", C_SyoruiCdKbn.SK_CREDITCARDTOUROKUHANEIERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("代理店契約室　御中");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("2019年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCredittourokuhaneierrorListTest", C_SyoruiCdKbn.SK_CREDITCARDTOUROKUHANEIERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 14984; i++) {

            SkCreditcardtourokuhaneierrlistDataSourceBean skCreditcardtourokuhaneierrlistDataSourceBean = new SkCreditcardtourokuhaneierrlistDataSourceBean();

            skCreditcardtourokuhaneierrlistDataSourceBean.setIrCredittrkhoukbn(C_CreditTrkhouKbn.SYOMEN);
            skCreditcardtourokuhaneierrlistDataSourceBean.setIrSosikicd("wwwwwww");
            skCreditcardtourokuhaneierrlistDataSourceBean.setIrMosno("wwwwwwwww");
            skCreditcardtourokuhaneierrlistDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
            skCreditcardtourokuhaneierrlistDataSourceBean.setIrCredittrkhaneierrriyuu("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            dataSouceList.add(skCreditcardtourokuhaneierrlistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCredittourokuhaneierrorListTest", C_SyoruiCdKbn.SK_CREDITCARDTOUROKUHANEIERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 999; i++) {

            SkCreditcardtourokuhaneierrlistDataSourceBean skCreditcardtourokuhaneierrlistDataSourceBean = new SkCreditcardtourokuhaneierrlistDataSourceBean();

            skCreditcardtourokuhaneierrlistDataSourceBean.setIrCredittrkhoukbn(C_CreditTrkhouKbn.SYOMEN);
            skCreditcardtourokuhaneierrlistDataSourceBean.setIrSosikicd("wwwwwww");
            skCreditcardtourokuhaneierrlistDataSourceBean.setIrMosno("wwwwwwwww");
            skCreditcardtourokuhaneierrlistDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
            skCreditcardtourokuhaneierrlistDataSourceBean.setIrCredittrkhaneierrriyuu("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            dataSouceList.add(skCreditcardtourokuhaneierrlistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}