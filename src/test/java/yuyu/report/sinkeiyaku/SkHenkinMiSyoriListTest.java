package yuyu.report.sinkeiyaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SkHenkinmisyorilistDetailBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * 返金未処理リスト帳票テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SkHenkinMiSyoriListTest extends AbstractTest {

    @Inject
    private CreateReport createReport;


    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "report", "SkHenkinMiSyoriTest",
                C_SyoruiCdKbn.SK_HENKINMISYORILIST);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for (int i = 1; i < 10; i++) {

            SkHenkinmisyorilistDetailBean skHenkinmisyorilistDetailBean = new SkHenkinmisyorilistDetailBean();

            skHenkinmisyorilistDetailBean.setIrMosno("10000000" + i);

            skHenkinmisyorilistDetailBean.setIrKyknmkj("藤真健司" + i);

            skHenkinmisyorilistDetailBean.setIrDrtencd("TEST" + i);

            skHenkinmisyorilistDetailBean.setIrDrtennmkj("大阪" + i);

            skHenkinmisyorilistDetailBean.setIrTratkiagcd("OTHER" + i);

            skHenkinmisyorilistDetailBean.setIrSeiritujk("成立");
            skHenkinmisyorilistDetailBean.setIrTyouhyousakuseiymd("平成 1年 1月 1日");
            skHenkinmisyorilistDetailBean.setIrKensuu(10);
            skHenkinmisyorilistDetailBean.setIrSrsyoriymd("2015.04.25");
            skHenkinmisyorilistDetailBean.setIrLastrsymd("2015.03.12");
            skHenkinmisyorilistDetailBean.setIrPageno(i);
            skHenkinmisyorilistDetailBean.setIrSoupagesuu(9);
            skHenkinmisyorilistDetailBean.setIrSyoruicd(C_SyoruiCdKbn.SK_HENKINMISYORILIST);

            iReportDataSouceBeanLst.add(skHenkinmisyorilistDetailBean);
        }


        reportTestBean.addParamObjects(iReportDataSouceBeanLst);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }


    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "report", "SkHenkinMiSyoriTest",
                C_SyoruiCdKbn.SK_HENKINMISYORILIST);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for (int i = 1; i < 1000; i++) {

            SkHenkinmisyorilistDetailBean skHenkinmisyorilistDetailBean = new SkHenkinmisyorilistDetailBean();
            skHenkinmisyorilistDetailBean.setIrMosno("XXXXXXXXX");

            skHenkinmisyorilistDetailBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skHenkinmisyorilistDetailBean.setIrSrsyoriymd("9999.99.99");
            skHenkinmisyorilistDetailBean.setIrLastrsymd("9999.99.99");

            skHenkinmisyorilistDetailBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            skHenkinmisyorilistDetailBean.setIrDrtencd("XXXXXXX");

            skHenkinmisyorilistDetailBean.setIrTratkiagcd("XXXXXXX");

            skHenkinmisyorilistDetailBean.setIrSeiritujk("成立");
            skHenkinmisyorilistDetailBean.setIrTyouhyousakuseiymd("平成99年99月99日");
            skHenkinmisyorilistDetailBean.setIrKensuu(999);
            skHenkinmisyorilistDetailBean.setIrPageno(999);
            skHenkinmisyorilistDetailBean.setIrSoupagesuu(999);
            skHenkinmisyorilistDetailBean.setIrSyoruicd(C_SyoruiCdKbn.SK_HENKINMISYORILIST);

            iReportDataSouceBeanLst.add(skHenkinmisyorilistDetailBean);
        }


        reportTestBean.addParamObjects(iReportDataSouceBeanLst);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }
    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "report", "SkHenkinMiSyoriTest",
                C_SyoruiCdKbn.SK_HENKINMISYORILIST);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        SkHenkinmisyorilistDetailBean skHenkinmisyorilistDetailBean = new SkHenkinmisyorilistDetailBean();

        skHenkinmisyorilistDetailBean.setIrMosno(null);

        skHenkinmisyorilistDetailBean.setIrKyknmkj(null);

        skHenkinmisyorilistDetailBean.setIrSeiritujk(null);
        skHenkinmisyorilistDetailBean.setIrSrsyoriymd(null);
        skHenkinmisyorilistDetailBean.setIrLastrsymd(null);

        skHenkinmisyorilistDetailBean.setIrTratkiagcd(null);
        skHenkinmisyorilistDetailBean.setIrTyouhyousakuseiymd(null);
        skHenkinmisyorilistDetailBean.setIrKensuu(null);

        skHenkinmisyorilistDetailBean.setIrDrtencd(null);

        skHenkinmisyorilistDetailBean.setIrDrtennmkj(null);
        skHenkinmisyorilistDetailBean.setIrPageno(null);
        skHenkinmisyorilistDetailBean.setIrSoupagesuu(null);
        skHenkinmisyorilistDetailBean.setIrSyoruicd(C_SyoruiCdKbn.SK_HENKINMISYORILIST);

        iReportDataSouceBeanLst.add(skHenkinmisyorilistDetailBean);


        reportTestBean.addParamObjects(iReportDataSouceBeanLst);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "report", "SkHenkinMiSyoriTest",
                C_SyoruiCdKbn.SK_HENKINMISYORILIST);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        SkHenkinmisyorilistDetailBean skHenkinmisyorilistDetailBean = new SkHenkinmisyorilistDetailBean();
        skHenkinmisyorilistDetailBean.setIrMosno("");

        skHenkinmisyorilistDetailBean.setIrKyknmkj("");

        skHenkinmisyorilistDetailBean.setIrSeiritujk("");
        skHenkinmisyorilistDetailBean.setIrSrsyoriymd("");
        skHenkinmisyorilistDetailBean.setIrLastrsymd("");

        skHenkinmisyorilistDetailBean.setIrTratkiagcd("");
        skHenkinmisyorilistDetailBean.setIrTyouhyousakuseiymd("");
        skHenkinmisyorilistDetailBean.setIrKensuu(null);

        skHenkinmisyorilistDetailBean.setIrDrtencd("");

        skHenkinmisyorilistDetailBean.setIrDrtennmkj("");
        skHenkinmisyorilistDetailBean.setIrPageno(null);
        skHenkinmisyorilistDetailBean.setIrSoupagesuu(null);
        skHenkinmisyorilistDetailBean.setIrSyoruicd(C_SyoruiCdKbn.SK_HENKINMISYORILIST);

        iReportDataSouceBeanLst.add(skHenkinmisyorilistDetailBean);


        reportTestBean.addParamObjects(iReportDataSouceBeanLst);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }


    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "report", "SkHenkinMiSyoriTest",
                C_SyoruiCdKbn.SK_HENKINMISYORILIST);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for (int i = 1; i < 25; i++) {

            SkHenkinmisyorilistDetailBean skHenkinmisyorilistDetailBean = new SkHenkinmisyorilistDetailBean();

            skHenkinmisyorilistDetailBean.setIrMosno("20000000" + i);

            skHenkinmisyorilistDetailBean.setIrKyknmkj("山田" + i);

            skHenkinmisyorilistDetailBean.setIrDrtencd("TCODE11");

            skHenkinmisyorilistDetailBean.setIrDrtennmkj("京都" + i);

            skHenkinmisyorilistDetailBean.setIrTratkiagcd("CODE" + i);
            skHenkinmisyorilistDetailBean.setIrTyouhyousakuseiymd("平成26年12月11日");

            skHenkinmisyorilistDetailBean.setIrSeiritujk("成立");
            skHenkinmisyorilistDetailBean.setIrKensuu(24);
            skHenkinmisyorilistDetailBean.setIrSrsyoriymd("2015.04.25");
            skHenkinmisyorilistDetailBean.setIrLastrsymd("2015.03.12");
            skHenkinmisyorilistDetailBean.setIrPageno(1);
            skHenkinmisyorilistDetailBean.setIrSoupagesuu(1);
            skHenkinmisyorilistDetailBean.setIrSyoruicd(C_SyoruiCdKbn.SK_HENKINMISYORILIST);

            iReportDataSouceBeanLst.add(skHenkinmisyorilistDetailBean);
        }


        reportTestBean.addParamObjects(iReportDataSouceBeanLst);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "report", "SkHenkinMiSyoriTest",
                C_SyoruiCdKbn.SK_HENKINMISYORILIST);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for (int i = 21; i < 46; i++) {

            SkHenkinmisyorilistDetailBean skHenkinmisyorilistDetailBean = new SkHenkinmisyorilistDetailBean();

            skHenkinmisyorilistDetailBean.setIrMosno("1000000" + i);

            skHenkinmisyorilistDetailBean.setIrKyknmkj("藤真健司" + i);

            skHenkinmisyorilistDetailBean.setIrDrtencd("TESTCOD");

            skHenkinmisyorilistDetailBean.setIrDrtennmkj("大阪" + i);

            skHenkinmisyorilistDetailBean.setIrTratkiagcd("OTHER" + i);
            skHenkinmisyorilistDetailBean.setIrTyouhyousakuseiymd("平成 1年 1月 1日");

            skHenkinmisyorilistDetailBean.setIrSeiritujk("成立");
            skHenkinmisyorilistDetailBean.setIrKensuu(25);
            skHenkinmisyorilistDetailBean.setIrSrsyoriymd("2015.04.25");
            skHenkinmisyorilistDetailBean.setIrLastrsymd("2015.03.12");
            skHenkinmisyorilistDetailBean.setIrPageno(1);
            skHenkinmisyorilistDetailBean.setIrSoupagesuu(1);
            skHenkinmisyorilistDetailBean.setIrSyoruicd(C_SyoruiCdKbn.SK_HENKINMISYORILIST);

            iReportDataSouceBeanLst.add(skHenkinmisyorilistDetailBean);
        }


        reportTestBean.addParamObjects(iReportDataSouceBeanLst);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "report", "SkHenkinMiSyoriTest",
                C_SyoruiCdKbn.SK_HENKINMISYORILIST);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for (int i = 41; i < 67; i++) {

            SkHenkinmisyorilistDetailBean skHenkinmisyorilistDetailBean = new SkHenkinmisyorilistDetailBean();

            skHenkinmisyorilistDetailBean.setIrMosno("1000000" + i);

            skHenkinmisyorilistDetailBean.setIrKyknmkj("山田" + i);

            skHenkinmisyorilistDetailBean.setIrDrtencd("TCODE1");

            skHenkinmisyorilistDetailBean.setIrDrtennmkj("京都" + i);

            skHenkinmisyorilistDetailBean.setIrTratkiagcd("CODE" + i);
            skHenkinmisyorilistDetailBean.setIrTyouhyousakuseiymd("平成 1年12月 1日");

            skHenkinmisyorilistDetailBean.setIrSeiritujk("成立");
            skHenkinmisyorilistDetailBean.setIrKensuu(26);
            skHenkinmisyorilistDetailBean.setIrSrsyoriymd("2015.04.25");
            skHenkinmisyorilistDetailBean.setIrLastrsymd("2015.03.12");
            skHenkinmisyorilistDetailBean.setIrPageno(1);
            skHenkinmisyorilistDetailBean.setIrSoupagesuu(2);
            skHenkinmisyorilistDetailBean.setIrSyoruicd(C_SyoruiCdKbn.SK_HENKINMISYORILIST);

            iReportDataSouceBeanLst.add(skHenkinmisyorilistDetailBean);
        }


        reportTestBean.addParamObjects(iReportDataSouceBeanLst);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }


    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "report", "SkHenkinMiSyoriTest",
                C_SyoruiCdKbn.SK_HENKINMISYORILIST_YENDT);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for (int i = 1; i < 10; i++) {

            SkHenkinmisyorilistDetailBean skHenkinmisyorilistDetailBean = new SkHenkinmisyorilistDetailBean();

            skHenkinmisyorilistDetailBean.setIrMosno("10000000" + i);

            skHenkinmisyorilistDetailBean.setIrKyknmkj("藤真健司" + i);

            skHenkinmisyorilistDetailBean.setIrDrtencd("TEST" + i);

            skHenkinmisyorilistDetailBean.setIrDrtennmkj("大阪" + i);

            skHenkinmisyorilistDetailBean.setIrTratkiagcd("OTHER" + i);

            skHenkinmisyorilistDetailBean.setIrSeiritujk("成立");
            skHenkinmisyorilistDetailBean.setIrTyouhyousakuseiymd("平成 1年 1月 1日");
            skHenkinmisyorilistDetailBean.setIrKensuu(10);
            skHenkinmisyorilistDetailBean.setIrSrsyoriymd("2015.04.25");
            skHenkinmisyorilistDetailBean.setIrLastrsymd("2015.03.12");
            skHenkinmisyorilistDetailBean.setIrPageno(i);
            skHenkinmisyorilistDetailBean.setIrSoupagesuu(9);
            skHenkinmisyorilistDetailBean.setIrSyoruicd(C_SyoruiCdKbn.SK_HENKINMISYORILIST_YENDT);

            iReportDataSouceBeanLst.add(skHenkinmisyorilistDetailBean);
        }


        reportTestBean.addParamObjects(iReportDataSouceBeanLst);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }
}
