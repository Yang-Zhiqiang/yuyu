package yuyu.report.sinkeiyaku;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SKYuukoukknkyklistDetailBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 有効期間経過契約リスト帳票テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SkYuukouKknKykListTest {

    @Inject
    private CreateReport createReport;


    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "Sk_yuukoukknkyklistTest",
                    C_SyoruiCdKbn.SK_YUUKOUKKNYOKOKULIST);

            List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
            for (int i = 1; i < 6; i++) {
                SKYuukoukknkyklistDetailBean sKYuukoukknkyklistDetailBean = new SKYuukoukknkyklistDetailBean();

                sKYuukoukknkyklistDetailBean.setIrYuukoukknkeikahanteiymd("平成22年3月31日");

                sKYuukoukknkyklistDetailBean.setIrYuukoukknkeikahanteiym("平成99年12月");
                sKYuukoukknkyklistDetailBean.setIrKensuu(5);
                sKYuukoukknkyklistDetailBean.setIrMosymd("2009.01.21");
                sKYuukoukknkyklistDetailBean.setIrKktkktymd("2009.03.11");
                sKYuukoukknkyklistDetailBean.setIrHjkktymd("2009.04.11");
                sKYuukoukknkyklistDetailBean.setIrFstnyknrsymd("2009.06.1");
                if (i < 4 ) {


                    sKYuukoukknkyklistDetailBean.setIrDrtencd("100001" + i);

                    sKYuukoukknkyklistDetailBean.setIrKthhbkbnval("あり");

                    sKYuukoukknkyklistDetailBean.setIrSrhhbkbnval("なし");

                    sKYuukoukknkyklistDetailBean.setIrKhnhbkbnval("あり");

                    sKYuukoukknkyklistDetailBean.setIrJimusrhkbnval("成立保留中 ");

                    sKYuukoukknkyklistDetailBean.setIrKetteikbnval("決定待ち");

                } else {


                    sKYuukoukknkyklistDetailBean.setIrDrtencd("1000014");

                    sKYuukoukknkyklistDetailBean.setIrKthhbkbnval("なし");

                    sKYuukoukknkyklistDetailBean.setIrSrhhbkbnval("あり");

                    sKYuukoukknkyklistDetailBean.setIrKhnhbkbnval("なし");

                    sKYuukoukknkyklistDetailBean.setIrJimusrhkbnval("なし ");

                    sKYuukoukknkyklistDetailBean.setIrKetteikbnval("決定済");
                }


                sKYuukoukknkyklistDetailBean.setIrKeikakbnval("予告期間");

                sKYuukoukknkyklistDetailBean.setIrDrtennmkj("代理店名" + i);
                sKYuukoukknkyklistDetailBean.setIrMosno("10000000"  + i);

                sKYuukoukknkyklistDetailBean.setIrTratkiagcd("200000"  + i);

                sKYuukoukknkyklistDetailBean.setIrHhknnmkj("田中" + i);

                sKYuukoukknkyklistDetailBean.setIrKyknmkj("契約者名" + i);
                sKYuukoukknkyklistDetailBean.setIrFstphrkkeiroval("振込み");

                iReportDataSouceBeanLst.add(sKYuukoukknkyklistDetailBean);
            }

            reportTestBean.addParamObjects(iReportDataSouceBeanLst);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

        } catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);

    }


    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "Sk_yuukoukknkyklistTest",
                    C_SyoruiCdKbn.SK_YUUKOUKKNTYOUKALIST);

            List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
            for (int i = 1; i < 999; i++) {
                SKYuukoukknkyklistDetailBean sKYuukoukknkyklistDetailBean = new SKYuukoukknkyklistDetailBean();

                sKYuukoukknkyklistDetailBean.setIrYuukoukknkeikahanteiymd("平成22年1月21日");

                sKYuukoukknkyklistDetailBean.setIrYuukoukknkeikahanteiym("平成99年12月");
                sKYuukoukknkyklistDetailBean.setIrKensuu(999);
                sKYuukoukknkyklistDetailBean.setIrMosymd("2009.01.15");
                sKYuukoukknkyklistDetailBean.setIrKktkktymd("2009.03.14");
                sKYuukoukknkyklistDetailBean.setIrHjkktymd("2009.04.11");
                sKYuukoukknkyklistDetailBean.setIrFstnyknrsymd("2009.06.12");


                sKYuukoukknkyklistDetailBean.setIrKeikakbnval("ＷＷＷＷＷＷ");

                sKYuukoukknkyklistDetailBean.setIrDrtencd("XXXXXXX");

                sKYuukoukknkyklistDetailBean.setIrKthhbkbnval("ＷＷ");

                sKYuukoukknkyklistDetailBean.setIrSrhhbkbnval("ＷＷ");

                sKYuukoukknkyklistDetailBean.setIrKhnhbkbnval("ＷＷ");

                sKYuukoukknkyklistDetailBean.setIrJimusrhkbnval("ＷＷＷＷＷ");

                sKYuukoukknkyklistDetailBean.setIrKetteikbnval("ＷＷＷＷ");


                sKYuukoukknkyklistDetailBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
                sKYuukoukknkyklistDetailBean.setIrMosno("XXXXXXXXX");

                sKYuukoukknkyklistDetailBean.setIrTratkiagcd("XXXXXXX");

                sKYuukoukknkyklistDetailBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

                sKYuukoukknkyklistDetailBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
                sKYuukoukknkyklistDetailBean.setIrFstphrkkeiroval("ＷＷＷ");

                iReportDataSouceBeanLst.add(sKYuukoukknkyklistDetailBean);
            }

            reportTestBean.addParamObjects(iReportDataSouceBeanLst);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

        } catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "Sk_yuukoukknkyklistTest",
                    C_SyoruiCdKbn.SK_YUUKOUKKNTYOUKALIST);

            List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
            SKYuukoukknkyklistDetailBean sKYuukoukknkyklistDetailBean = new SKYuukoukknkyklistDetailBean();

            sKYuukoukknkyklistDetailBean.setIrYuukoukknkeikahanteiym(null);

            sKYuukoukknkyklistDetailBean.setIrKeikakbnval(null);
            sKYuukoukknkyklistDetailBean.setIrYuukoukknkeikahanteiymd(null);
            sKYuukoukknkyklistDetailBean.setIrKensuu(null);

            sKYuukoukknkyklistDetailBean.setIrDrtencd(null);

            sKYuukoukknkyklistDetailBean.setIrDrtennmkj(null);
            sKYuukoukknkyklistDetailBean.setIrMosno(null);

            sKYuukoukknkyklistDetailBean.setIrTratkiagcd(null);

            sKYuukoukknkyklistDetailBean.setIrHhknnmkj(null);

            sKYuukoukknkyklistDetailBean.setIrKyknmkj(null);

            sKYuukoukknkyklistDetailBean.setIrKthhbkbnval(null);

            sKYuukoukknkyklistDetailBean.setIrSrhhbkbnval(null);

            sKYuukoukknkyklistDetailBean.setIrKhnhbkbnval(null);

            sKYuukoukknkyklistDetailBean.setIrJimusrhkbnval(null);

            sKYuukoukknkyklistDetailBean.setIrKetteikbnval(null);
            sKYuukoukknkyklistDetailBean.setIrMosymd(null);
            sKYuukoukknkyklistDetailBean.setIrKktkktymd(null);
            sKYuukoukknkyklistDetailBean.setIrHjkktymd(null);
            sKYuukoukknkyklistDetailBean.setIrFstphrkkeiroval(null);
            sKYuukoukknkyklistDetailBean.setIrFstnyknrsymd(null);

            iReportDataSouceBeanLst.add(sKYuukoukknkyklistDetailBean);
            reportTestBean.addParamObjects(iReportDataSouceBeanLst);

            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

        } catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "Sk_yuukoukknkyklistTest",
                    C_SyoruiCdKbn.SK_YUUKOUKKNTYOUKALIST);

            List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

            SKYuukoukknkyklistDetailBean sKYuukoukknkyklistDetailBean = new SKYuukoukknkyklistDetailBean();

            sKYuukoukknkyklistDetailBean.setIrYuukoukknkeikahanteiym("");

            sKYuukoukknkyklistDetailBean.setIrKeikakbnval("");
            sKYuukoukknkyklistDetailBean.setIrYuukoukknkeikahanteiymd("");
            sKYuukoukknkyklistDetailBean.setIrKensuu(null);

            sKYuukoukknkyklistDetailBean.setIrDrtencd("");

            sKYuukoukknkyklistDetailBean.setIrDrtennmkj("");
            sKYuukoukknkyklistDetailBean.setIrMosno("");

            sKYuukoukknkyklistDetailBean.setIrTratkiagcd("");

            sKYuukoukknkyklistDetailBean.setIrHhknnmkj("");

            sKYuukoukknkyklistDetailBean.setIrKyknmkj("");

            sKYuukoukknkyklistDetailBean.setIrKthhbkbnval("");

            sKYuukoukknkyklistDetailBean.setIrSrhhbkbnval("");

            sKYuukoukknkyklistDetailBean.setIrKhnhbkbnval("");

            sKYuukoukknkyklistDetailBean.setIrJimusrhkbnval("");

            sKYuukoukknkyklistDetailBean.setIrKetteikbnval("");
            sKYuukoukknkyklistDetailBean.setIrMosymd("");
            sKYuukoukknkyklistDetailBean.setIrKktkktymd("");
            sKYuukoukknkyklistDetailBean.setIrHjkktymd("");
            sKYuukoukknkyklistDetailBean.setIrFstphrkkeiroval("");
            sKYuukoukknkyklistDetailBean.setIrFstnyknrsymd("");

            iReportDataSouceBeanLst.add(sKYuukoukknkyklistDetailBean);

            reportTestBean.addParamObjects(iReportDataSouceBeanLst);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

        } catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);

    }


    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {

        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "Sk_yuukoukknkyklistTest",
                    C_SyoruiCdKbn.SK_YUUKOUKKNTYOUKALIST);

            List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
            for (int i = 20; i < 25; i++) {
                SKYuukoukknkyklistDetailBean sKYuukoukknkyklistDetailBean = new SKYuukoukknkyklistDetailBean();

                sKYuukoukknkyklistDetailBean.setIrYuukoukknkeikahanteiymd("平成22年3月11日");

                sKYuukoukknkyklistDetailBean.setIrYuukoukknkeikahanteiym("平成99年12月");
                sKYuukoukknkyklistDetailBean.setIrKensuu(5);
                sKYuukoukknkyklistDetailBean.setIrMosymd("2009.01.21");
                sKYuukoukknkyklistDetailBean.setIrKktkktymd("2009.03.12");
                sKYuukoukknkyklistDetailBean.setIrHjkktymd("2009.04.13");
                sKYuukoukknkyklistDetailBean.setIrFstnyknrsymd("2009.06.14");


                sKYuukoukknkyklistDetailBean.setIrSrhhbkbnval("なし");

                sKYuukoukknkyklistDetailBean.setIrKthhbkbnval("あり");

                sKYuukoukknkyklistDetailBean.setIrKhnhbkbnval("あり");

                sKYuukoukknkyklistDetailBean.setIrJimusrhkbnval("成立保留中 ");

                sKYuukoukknkyklistDetailBean.setIrKetteikbnval("決定待ち");


                sKYuukoukknkyklistDetailBean.setIrKeikakbnval("有効期間超過");

                sKYuukoukknkyklistDetailBean.setIrDrtencd("2000011");

                sKYuukoukknkyklistDetailBean.setIrDrtennmkj("代理店名６");
                sKYuukoukknkyklistDetailBean.setIrMosno("1000000006");

                sKYuukoukknkyklistDetailBean.setIrTratkiagcd("2000006");

                sKYuukoukknkyklistDetailBean.setIrHhknnmkj("田中６");

                sKYuukoukknkyklistDetailBean.setIrKyknmkj("契約者名６");
                sKYuukoukknkyklistDetailBean.setIrFstphrkkeiroval("振込み");

                iReportDataSouceBeanLst.add(sKYuukoukknkyklistDetailBean);
            }

            reportTestBean.addParamObjects(iReportDataSouceBeanLst);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

        } catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);

    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {

        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "Sk_yuukoukknkyklistTest",
                    C_SyoruiCdKbn.SK_YUUKOUKKNTYOUKALIST);

            List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
            for (int i = 6; i < 12; i++) {
                SKYuukoukknkyklistDetailBean sKYuukoukknkyklistDetailBean = new SKYuukoukknkyklistDetailBean();

                sKYuukoukknkyklistDetailBean.setIrYuukoukknkeikahanteiymd("平成22年3月11日");

                sKYuukoukknkyklistDetailBean.setIrYuukoukknkeikahanteiym("平成99年12月");
                sKYuukoukknkyklistDetailBean.setIrKensuu(6);
                sKYuukoukknkyklistDetailBean.setIrMosymd("2009.01.21");
                sKYuukoukknkyklistDetailBean.setIrKktkktymd("2009.03.12");
                sKYuukoukknkyklistDetailBean.setIrHjkktymd("2009.04.13");
                sKYuukoukknkyklistDetailBean.setIrFstnyknrsymd("2009.06.14");


                sKYuukoukknkyklistDetailBean.setIrSrhhbkbnval("あり");

                sKYuukoukknkyklistDetailBean.setIrKthhbkbnval("なし");

                sKYuukoukknkyklistDetailBean.setIrKhnhbkbnval("なし");

                sKYuukoukknkyklistDetailBean.setIrJimusrhkbnval("なし ");

                sKYuukoukknkyklistDetailBean.setIrKetteikbnval("未決定");


                sKYuukoukknkyklistDetailBean.setIrKeikakbnval("有効期間超過");

                sKYuukoukknkyklistDetailBean.setIrDrtencd("3000011");

                sKYuukoukknkyklistDetailBean.setIrDrtennmkj("代理店名１３");
                sKYuukoukknkyklistDetailBean.setIrMosno("100000013");

                sKYuukoukknkyklistDetailBean.setIrTratkiagcd("2000013");

                sKYuukoukknkyklistDetailBean.setIrHhknnmkj("田中１３");

                sKYuukoukknkyklistDetailBean.setIrKyknmkj("契約者名１３");
                sKYuukoukknkyklistDetailBean.setIrFstphrkkeiroval("振込み");

                iReportDataSouceBeanLst.add(sKYuukoukknkyklistDetailBean);
            }

            reportTestBean.addParamObjects(iReportDataSouceBeanLst);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

        } catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);

    }


    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {

        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "Sk_yuukoukknkyklistTest",
                    C_SyoruiCdKbn.SK_YUUKOUKKNYOKOKULIST);

            List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
            for (int i = 13; i < 20; i++) {
                SKYuukoukknkyklistDetailBean sKYuukoukknkyklistDetailBean = new SKYuukoukknkyklistDetailBean();

                sKYuukoukknkyklistDetailBean.setIrYuukoukknkeikahanteiymd("平成22年3月11日");

                sKYuukoukknkyklistDetailBean.setIrYuukoukknkeikahanteiym("平成99年12月");
                sKYuukoukknkyklistDetailBean.setIrKensuu(7);
                sKYuukoukknkyklistDetailBean.setIrMosymd("2009.01.21");
                sKYuukoukknkyklistDetailBean.setIrKktkktymd("2009.03.12");
                sKYuukoukknkyklistDetailBean.setIrHjkktymd("2009.04.13");
                sKYuukoukknkyklistDetailBean.setIrFstnyknrsymd("2009.06.14");

                sKYuukoukknkyklistDetailBean.setIrKthhbkbnval("なし");

                sKYuukoukknkyklistDetailBean.setIrKhnhbkbnval("なし");

                sKYuukoukknkyklistDetailBean.setIrJimusrhkbnval("なし ");

                sKYuukoukknkyklistDetailBean.setIrKetteikbnval("決定待ち");

                sKYuukoukknkyklistDetailBean.setIrSrhhbkbnval("あり");

                sKYuukoukknkyklistDetailBean.setIrKeikakbnval("予告期間");

                sKYuukoukknkyklistDetailBean.setIrDrtencd("4000011");

                sKYuukoukknkyklistDetailBean.setIrDrtennmkj("代理店名２０");
                sKYuukoukknkyklistDetailBean.setIrMosno("100000020");

                sKYuukoukknkyklistDetailBean.setIrTratkiagcd("2000020");

                sKYuukoukknkyklistDetailBean.setIrHhknnmkj("田中２０");

                sKYuukoukknkyklistDetailBean.setIrKyknmkj("契約者名２０");
                sKYuukoukknkyklistDetailBean.setIrFstphrkkeiroval("振込み");

                iReportDataSouceBeanLst.add(sKYuukoukknkyklistDetailBean);
            }

            reportTestBean.addParamObjects(iReportDataSouceBeanLst);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

        } catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);

    }

}
