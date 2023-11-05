package yuyu.report.sinkeiyaku;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SkMisslistBean;
import yuyu.def.sinkeiyaku.bean.report.SkMisslistDetailBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約ミスリスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SkMislistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkMisslistBean skMisslistBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        try {


            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "sk_mislistTest",
                    C_SyoruiCdKbn.SK_HURIKOMINYKNSAKUJOMISSLIST);

            skMisslistBean.setIrTyouhyousakuseiymd("平成 2年 1月 1日");

            skMisslistBean.setIrKensuu(9);

            skMisslistBean.setIrKinounm("機能名");

            List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
            for (int i = 1; i < 10; i++) {

                SkMisslistDetailBean skMisslistDetailBean = new SkMisslistDetailBean();

                skMisslistDetailBean.setIrMosno("10000000" + i);
                skMisslistDetailBean.setIrMisslistmsg("メッセージ" + i);

                iReportDataSouceBeanLst.add(skMisslistDetailBean);
            }

            reportTestBean.addParamObjects(iReportDataSouceBeanLst, skMisslistBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
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
                createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "sk_mislistTest",
                    C_SyoruiCdKbn.SK_HURIKOMINYKNSAKUJOMISSLIST);

            skMisslistBean.setIrTyouhyousakuseiymd("平成 2年 1月 1日");

            skMisslistBean.setIrKensuu(10);

            skMisslistBean.setIrKinounm("機能名");

            List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
            for (int i = 1; i < 11; i++) {

                SkMisslistDetailBean skMisslistDetailBean = new SkMisslistDetailBean();

                skMisslistDetailBean.setIrMosno("10000000" + i);
                skMisslistDetailBean.setIrMisslistmsg("メッセージ" + i);

                iReportDataSouceBeanLst.add(skMisslistDetailBean);
            }

            reportTestBean.addParamObjects(iReportDataSouceBeanLst, skMisslistBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
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
                createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "sk_mislistTest",
                    C_SyoruiCdKbn.SK_HURIKOMINYKNSAKUJOMISSLIST);

            skMisslistBean.setIrTyouhyousakuseiymd("平成 2年 1月 1日");

            skMisslistBean.setIrKensuu(11);

            skMisslistBean.setIrKinounm("機能名");

            List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
            for (int i = 1; i < 12; i++) {

                SkMisslistDetailBean skMisslistDetailBean = new SkMisslistDetailBean();

                skMisslistDetailBean.setIrMosno("10000000" + i);
                skMisslistDetailBean.setIrMisslistmsg("メッセージ" + i);

                iReportDataSouceBeanLst.add(skMisslistDetailBean);
            }

            reportTestBean.addParamObjects(iReportDataSouceBeanLst, skMisslistBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
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
                createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "sk_mislistTest",
                    C_SyoruiCdKbn.SK_HURIKOMINYKNSAKUJOMISSLIST);

            skMisslistBean.setIrTyouhyousakuseiymd("平成99年99月99日");

            skMisslistBean.setIrKensuu(999);

            skMisslistBean.setIrKinounm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ" +
                "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
            for (int i = 0; i < 999; i++) {

                SkMisslistDetailBean skMisslistDetailBean = new SkMisslistDetailBean();

                skMisslistDetailBean.setIrMosno("XXXXXXXXX");
                skMisslistDetailBean.setIrMisslistmsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ" +
                    "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ" +
                    "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ" +
                    "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

                iReportDataSouceBeanLst.add(skMisslistDetailBean);
            }

            reportTestBean.addParamObjects(iReportDataSouceBeanLst, skMisslistBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
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
                createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "sk_mislistTest",
                    C_SyoruiCdKbn.SK_HURIKOMINYKNSAKUJOMISSLIST);

            skMisslistBean.setIrTyouhyousakuseiymd("平成99年12月31日");

            skMisslistBean.setIrKensuu(1002);

            skMisslistBean.setIrKinounm("機能名");

            List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
            for (int i = 0; i < 1002; i++) {

                SkMisslistDetailBean skMisslistDetailBean = new SkMisslistDetailBean();

                skMisslistDetailBean.setIrMosno("XXXXXXXXX");
                skMisslistDetailBean.setIrMisslistmsg("メッセージ");

                iReportDataSouceBeanLst.add(skMisslistDetailBean);
            }

            reportTestBean.addParamObjects(iReportDataSouceBeanLst, skMisslistBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
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
                createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "sk_mislistTest",
                    C_SyoruiCdKbn.SK_HURIKOMINYKNSAKUJOMISSLIST);

            skMisslistBean.setIrTyouhyousakuseiymd(null);

            skMisslistBean.setIrKensuu(null);

            skMisslistBean.setIrKinounm(null);

            List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

            SkMisslistDetailBean skMisslistDetailBean = new SkMisslistDetailBean();

            skMisslistDetailBean.setIrMosno(null);
            skMisslistDetailBean.setIrMisslistmsg(null);

            iReportDataSouceBeanLst.add(skMisslistDetailBean);

            reportTestBean.addParamObjects(iReportDataSouceBeanLst, skMisslistBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
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
                createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "sk_mislistTest",
                    C_SyoruiCdKbn.SK_HURIKOMINYKNSAKUJOMISSLIST);

            skMisslistBean.setIrTyouhyousakuseiymd("");

            skMisslistBean.setIrKensuu(0);

            skMisslistBean.setIrKinounm("");

            List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

            SkMisslistDetailBean skMisslistDetailBean = new SkMisslistDetailBean();

            skMisslistDetailBean.setIrMosno("");
            skMisslistDetailBean.setIrMisslistmsg("");

            iReportDataSouceBeanLst.add(skMisslistDetailBean);

            reportTestBean.addParamObjects(iReportDataSouceBeanLst, skMisslistBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

}