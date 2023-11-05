package yuyu.report.sinkeiyaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.sinkeiyaku.bean.report.SkSikinIdouListHrkmKouzaHuittibunBean;
import yuyu.def.sinkeiyaku.bean.report.SkSikinIdouListHrkmKouzaHuittibunDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 資金移動リスト（振込口座不一致分）テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkSikinidoulisthrkmkzhuittiTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkSikinIdouListHrkmKouzaHuittibunBean skSikinIdouListHrkmKouzaHuittibunBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkSikinidoulisthrkmkzhuittiTest",
                C_SyoruiCdKbn.SK_SIKINIDOULIST_HRKMKZHUITTI);

        skSikinIdouListHrkmKouzaHuittibunBean.setIrTyouhyousakuseiymd(null);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean =
            new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumototuukasyu(null);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotobankcd(null);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotositencd(null);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotokouzano(null);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidougaku(null);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzatuukasyu(null);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzabanccd(null);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzasitencd(null);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzano(null);
        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean);

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, skSikinIdouListHrkmKouzaHuittibunBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SKSikinidoulisthrkmkzhuittiTest",
                C_SyoruiCdKbn.SK_SIKINIDOULIST_HRKMKZHUITTI);

        skSikinIdouListHrkmKouzaHuittibunBean.setIrTyouhyousakuseiymd("");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean =
            new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumototuukasyu(C_Tuukasyu.BLNK);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotobankcd("");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotositencd("");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotokouzano("");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidougaku(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzatuukasyu(C_Tuukasyu.BLNK);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzabanccd("");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzasitencd("");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzano("");
        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean);

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, skSikinIdouListHrkmKouzaHuittibunBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SKSikinidoulisthrkmkzhuittiTest",
                C_SyoruiCdKbn.SK_SIKINIDOULIST_HRKMKZHUITTI);

        skSikinIdouListHrkmKouzaHuittibunBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean =
                new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumototuukasyu(C_Tuukasyu.AUD);
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotobankcd("wwww");
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotositencd("www");
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotokouzano("wwwwwwwwwwww");
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidougaku(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzabanccd("wwww");
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzasitencd("www");
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzano("wwwwwwwwwwww");
            iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, skSikinIdouListHrkmKouzaHuittibunBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SKSikinidoulisthrkmkzhuittiTest",
                C_SyoruiCdKbn.SK_SIKINIDOULIST_HRKMKZHUITTI);

        skSikinIdouListHrkmKouzaHuittibunBean.setIrTyouhyousakuseiymd("平成21年 7月30日");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for (int index = 0; index < 11; index++) {
            SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean =
                new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumototuukasyu(C_Tuukasyu.AUD);
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotobankcd(String.valueOf(1000 + index));
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotositencd(String.valueOf(200 + index));
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotokouzano(String.valueOf(300000000000L + index));
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidougaku(BizCurrency.valueOf(5123546 + index, BizCurrencyTypes.AU_DOLLAR));
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzatuukasyu(C_Tuukasyu.JPY);
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzabanccd(String.valueOf(6000 + index));
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzasitencd(String.valueOf(700 + index));
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzano(String.valueOf(800000000000L + index));
            iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, skSikinIdouListHrkmKouzaHuittibunBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkSikinidoulisthrkmkzhuittiTest",
                C_SyoruiCdKbn.SK_SIKINIDOULIST_HRKMKZHUITTI);

        skSikinIdouListHrkmKouzaHuittibunBean.setIrTyouhyousakuseiymd("平成21年 7月30日");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for (int index = 0; index < 9; index++) {
            SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean =
                new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumototuukasyu(C_Tuukasyu.AUD);
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotobankcd(String.valueOf(1000 + index));
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotositencd(String.valueOf(200 + index));
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotokouzano(String.valueOf(300000000000L + index));
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidougaku(BizCurrency.valueOf(5123546 + index, BizCurrencyTypes.AU_DOLLAR));
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzabanccd(String.valueOf(6000 + index));
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzasitencd(String.valueOf(700 + index));
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzano(String.valueOf(800000000000L + index));
            iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, skSikinIdouListHrkmKouzaHuittibunBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkSikinidoulisthrkmkzhuittiTest",
                C_SyoruiCdKbn.SK_SIKINIDOULIST_HRKMKZHUITTI);

        skSikinIdouListHrkmKouzaHuittibunBean.setIrTyouhyousakuseiymd("平成21年 7月30日");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for (int index = 0; index < 9990; index++) {
            SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean =
                new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumototuukasyu(C_Tuukasyu.AUD);
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotobankcd("wwww");
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotositencd("www");
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidoumotokouzano("wwwwwwwwwwww");
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSikinidougaku(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzabanccd("wwww");
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzasitencd("www");
            skSikinIdouListHrkmKouzaHuittibunDataSourceBean.setIrSeitoukouzano("wwwwwwwwwwww");
            iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, skSikinIdouListHrkmKouzaHuittibunBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkSikinidoulisthrkmkzhuittiTest",
                C_SyoruiCdKbn.SK_SIKINIDOULIST_HRKMKZHUITTI);

        skSikinIdouListHrkmKouzaHuittibunBean.setIrTyouhyousakuseiymd("平成21年 7月30日");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean1 =
            new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean1.setIrSikinidoumototuukasyu(C_Tuukasyu.JPY);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean1.setIrSikinidoumotobankcd("1001");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean1.setIrSikinidoumotositencd("201");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean1.setIrSikinidoumotokouzano("300000000001");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean1.setIrSikinidougaku(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean1.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean1.setIrSeitoukouzabanccd("4001");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean1.setIrSeitoukouzasitencd("501");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean1.setIrSeitoukouzano("600000000001");
        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean1);

        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean2 =
            new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean2.setIrSikinidoumototuukasyu(C_Tuukasyu.JPY);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean2.setIrSikinidoumotobankcd("1002");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean2.setIrSikinidoumotositencd("202");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean2.setIrSikinidoumotokouzano("300000000002");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean2.setIrSikinidougaku(BizCurrency.valueOf(123456, BizCurrencyTypes.YEN));
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean2.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean2.setIrSeitoukouzabanccd("4002");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean2.setIrSeitoukouzasitencd("502");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean2.setIrSeitoukouzano("600000000002");
        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean2);

        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean3 =
            new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean3.setIrSikinidoumototuukasyu(C_Tuukasyu.JPY);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean3.setIrSikinidoumotobankcd("1003");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean3.setIrSikinidoumotositencd("203");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean3.setIrSikinidoumotokouzano("300000000003");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean3.setIrSikinidougaku(BizCurrency.valueOf(123, BizCurrencyTypes.YEN));
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean3.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean3.setIrSeitoukouzabanccd("4003");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean3.setIrSeitoukouzasitencd("503");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean3.setIrSeitoukouzano("600000000003");
        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean3);

        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean4 =
            new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean4.setIrSikinidoumototuukasyu(C_Tuukasyu.JPY);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean4.setIrSikinidoumotobankcd("1004");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean4.setIrSikinidoumotositencd("204");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean4.setIrSikinidoumotokouzano("300000000004");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean4.setIrSikinidougaku(BizCurrency.valueOf(1234, BizCurrencyTypes.YEN));
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean4.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean4.setIrSeitoukouzabanccd("4004");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean4.setIrSeitoukouzasitencd("504");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean4.setIrSeitoukouzano("600000000004");
        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean4);

        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean5 =
            new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean5.setIrSikinidoumototuukasyu(C_Tuukasyu.JPY);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean5.setIrSikinidoumotobankcd("1005");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean5.setIrSikinidoumotositencd("205");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean5.setIrSikinidoumotokouzano("300000000005");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean5.setIrSikinidougaku(BizCurrency.valueOf(9999999999999L, BizCurrencyTypes.YEN));
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean5.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean5.setIrSeitoukouzabanccd("4005");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean5.setIrSeitoukouzasitencd("505");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean5.setIrSeitoukouzano("600000000005");
        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean5);

        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean6 =
            new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean6.setIrSikinidoumototuukasyu(C_Tuukasyu.JPY);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean6.setIrSikinidoumotobankcd("1006");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean6.setIrSikinidoumotositencd("206");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean6.setIrSikinidoumotokouzano("300000000006");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean6.setIrSikinidougaku(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean6.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean6.setIrSeitoukouzabanccd("4006");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean6.setIrSeitoukouzasitencd("506");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean6.setIrSeitoukouzano("600000000006");
        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean6);

        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean7 =
            new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean7.setIrSikinidoumototuukasyu(C_Tuukasyu.JPY);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean7.setIrSikinidoumotobankcd("1007");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean7.setIrSikinidoumotositencd("207");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean7.setIrSikinidoumotokouzano("300000000007");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean7.setIrSikinidougaku(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean7.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean7.setIrSeitoukouzabanccd("4007");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean7.setIrSeitoukouzasitencd("507");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean7.setIrSeitoukouzano("600000000007");
        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean7);

        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean8 =
            new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean8.setIrSikinidoumototuukasyu(C_Tuukasyu.JPY);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean8.setIrSikinidoumotobankcd("1008");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean8.setIrSikinidoumotositencd("208");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean8.setIrSikinidoumotokouzano("300000000008");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean8.setIrSikinidougaku(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean8.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean8.setIrSeitoukouzabanccd("4008");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean8.setIrSeitoukouzasitencd("508");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean8.setIrSeitoukouzano("600000000008");
        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean8);


        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean9 =
            new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean9.setIrSikinidoumototuukasyu(C_Tuukasyu.JPY);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean9.setIrSikinidoumotobankcd("1009");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean9.setIrSikinidoumotositencd("209");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean9.setIrSikinidoumotokouzano("300000000009");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean9.setIrSikinidougaku(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean9.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean9.setIrSeitoukouzabanccd("4009");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean9.setIrSeitoukouzasitencd("509");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean9.setIrSeitoukouzano("600000000009");
        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean9);

        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean10 =
            new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean10.setIrSikinidoumototuukasyu(C_Tuukasyu.AUD);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean10.setIrSikinidoumotobankcd("1010");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean10.setIrSikinidoumotositencd("210");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean10.setIrSikinidoumotokouzano("300000000010");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean10.setIrSikinidougaku(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean10.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean10.setIrSeitoukouzabanccd("4010");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean10.setIrSeitoukouzasitencd("510");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean10.setIrSeitoukouzano("600000000010");
        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean10);

        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean11 =
            new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean11.setIrSikinidoumototuukasyu(C_Tuukasyu.AUD);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean11.setIrSikinidoumotobankcd("1011");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean11.setIrSikinidoumotositencd("211");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean11.setIrSikinidoumotokouzano("300000000011");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean11.setIrSikinidougaku(BizCurrency.valueOf(123456, BizCurrencyTypes.AU_DOLLAR));
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean11.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean11.setIrSeitoukouzabanccd("4011");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean11.setIrSeitoukouzasitencd("511");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean11.setIrSeitoukouzano("600000000011");
        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean11);

        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean12 =
            new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean12.setIrSikinidoumototuukasyu(C_Tuukasyu.AUD);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean12.setIrSikinidoumotobankcd("1012");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean12.setIrSikinidoumotositencd("212");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean12.setIrSikinidoumotokouzano("300000000012");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean12.setIrSikinidougaku(BizCurrency.valueOf(123, BizCurrencyTypes.AU_DOLLAR));
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean12.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean12.setIrSeitoukouzabanccd("4012");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean12.setIrSeitoukouzasitencd("512");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean12.setIrSeitoukouzano("600000000012");
        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean12);

        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean13 =
            new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean13.setIrSikinidoumototuukasyu(C_Tuukasyu.AUD);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean13.setIrSikinidoumotobankcd("1013");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean13.setIrSikinidoumotositencd("213");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean13.setIrSikinidoumotokouzano("300000000013");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean13.setIrSikinidougaku(BizCurrency.valueOf(1234, BizCurrencyTypes.AU_DOLLAR));
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean13.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean13.setIrSeitoukouzabanccd("4013");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean13.setIrSeitoukouzasitencd("513");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean13.setIrSeitoukouzano("600000000013");
        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean13);

        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean14 =
            new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean14.setIrSikinidoumototuukasyu(C_Tuukasyu.AUD);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean14.setIrSikinidoumotobankcd("1014");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean14.setIrSikinidoumotositencd("214");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean14.setIrSikinidoumotokouzano("300000000014");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean14.setIrSikinidougaku(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean14.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean14.setIrSeitoukouzabanccd("4014");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean14.setIrSeitoukouzasitencd("514");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean14.setIrSeitoukouzano("600000000014");
        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean14);

        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean15 =
            new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean15.setIrSikinidoumototuukasyu(C_Tuukasyu.AUD);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean15.setIrSikinidoumotobankcd("1015");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean15.setIrSikinidoumotositencd("215");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean15.setIrSikinidoumotokouzano("300000000015");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean15.setIrSikinidougaku(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean15.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean15.setIrSeitoukouzabanccd("4015");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean15.setIrSeitoukouzasitencd("515");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean15.setIrSeitoukouzano("600000000015");
        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean15);

        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean16 =
            new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean16.setIrSikinidoumototuukasyu(C_Tuukasyu.AUD);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean16.setIrSikinidoumotobankcd("1016");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean16.setIrSikinidoumotositencd("216");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean16.setIrSikinidoumotokouzano("300000000016");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean16.setIrSikinidougaku(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean16.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean16.setIrSeitoukouzabanccd("4016");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean16.setIrSeitoukouzasitencd("516");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean16.setIrSeitoukouzano("600000000016");
        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean16);

        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean17 =
            new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean17.setIrSikinidoumototuukasyu(C_Tuukasyu.AUD);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean17.setIrSikinidoumotobankcd("1017");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean17.setIrSikinidoumotositencd("217");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean17.setIrSikinidoumotokouzano("300000000017");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean17.setIrSikinidougaku(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean17.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean17.setIrSeitoukouzabanccd("4017");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean17.setIrSeitoukouzasitencd("517");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean17.setIrSeitoukouzano("600000000017");
        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean17);

        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean skSikinIdouListHrkmKouzaHuittibunDataSourceBean18 =
            new SkSikinIdouListHrkmKouzaHuittibunDataSourceBean();
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean18.setIrSikinidoumototuukasyu(C_Tuukasyu.AUD);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean18.setIrSikinidoumotobankcd("1018");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean18.setIrSikinidoumotositencd("218");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean18.setIrSikinidoumotokouzano("300000000018");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean18.setIrSikinidougaku(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean18.setIrSeitoukouzatuukasyu(C_Tuukasyu.EUR);
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean18.setIrSeitoukouzabanccd("4018");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean18.setIrSeitoukouzasitencd("518");
        skSikinIdouListHrkmKouzaHuittibunDataSourceBean18.setIrSeitoukouzano("600000000018");
        iReportDataSouceBeanLst.add(skSikinIdouListHrkmKouzaHuittibunDataSourceBean18);

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, skSikinIdouListHrkmKouzaHuittibunBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }
    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SKSikinidoulisthrkmkzhuittiTest",
                C_SyoruiCdKbn.SK_SIKINIDOULIST_HRKMKZHUITTI);

        skSikinIdouListHrkmKouzaHuittibunBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, skSikinIdouListHrkmKouzaHuittibunBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }
}
