package yuyu.report.sinkeiyaku;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SkJimurenrakuhyouBean;
import yuyu.def.sinkeiyaku.bean.report.SkJimurenrakuhyouDetailBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 事務連絡票帳票テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SkJimuRenrakuHyouTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkJimurenrakuhyouBean skJimurenrakuhyouBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "sk_jimurenrakuhyouTest",
                    C_SyoruiCdKbn.SK_JIMURENRAKU);

            skJimurenrakuhyouBean.setIrMosno("XXXXXXXXX");

            skJimurenrakuhyouBean.setIrTyouhyousakuseiymd("2018年10月13日");
            skJimurenrakuhyouBean.setIrKinounm("返金依頼書作成処理");

            List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
            SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean = new SkJimurenrakuhyouDetailBean();
            skJimurenrakuhyouDetailBean.setIrMessage("メッセージ");

            iReportDataSouceBeanLst.add(skJimurenrakuhyouDetailBean);

            reportTestBean.addParamObjects(iReportDataSouceBeanLst, skJimurenrakuhyouBean);
            createReport.exec(new ReportServicesBean[] {reportTestBean });
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
                createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "sk_jimurenrakuhyouTest",
                    C_SyoruiCdKbn.SK_JIMURENRAKU);

            skJimurenrakuhyouBean.setIrMosno("123456789");
            skJimurenrakuhyouBean.setIrTyouhyousakuseiymd("2018年10月13日");
            skJimurenrakuhyouBean.setIrKinounm("返金依頼書作成処理");

            List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
            SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean = new SkJimurenrakuhyouDetailBean();
            skJimurenrakuhyouDetailBean.setIrMessage("メッセージ");

            iReportDataSouceBeanLst.add(skJimurenrakuhyouDetailBean);

            reportTestBean.addParamObjects(iReportDataSouceBeanLst, skJimurenrakuhyouBean);
            createReport.exec(new ReportServicesBean[] {reportTestBean });
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
                createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "sk_jimurenrakuhyouTest",
                    C_SyoruiCdKbn.SK_JIMURENRAKU);

            skJimurenrakuhyouBean.setIrMosno(null);
            skJimurenrakuhyouBean.setIrTyouhyousakuseiymd("2018年10月13日");
            skJimurenrakuhyouBean.setIrKinounm("返金依頼書作成処理");

            List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
            SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean = new SkJimurenrakuhyouDetailBean();
            skJimurenrakuhyouDetailBean.setIrMessage("メッセージ");

            iReportDataSouceBeanLst.add(skJimurenrakuhyouDetailBean);

            reportTestBean.addParamObjects(iReportDataSouceBeanLst, skJimurenrakuhyouBean);
            createReport.exec(new ReportServicesBean[] {reportTestBean });
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
                createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "sk_jimurenrakuhyouTest",
                    C_SyoruiCdKbn.SK_JIMURENRAKU);

            skJimurenrakuhyouBean.setIrMosno("");
            skJimurenrakuhyouBean.setIrTyouhyousakuseiymd("2018年10月13日");
            skJimurenrakuhyouBean.setIrKinounm("返金依頼書作成処理");

            List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
            SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean = new SkJimurenrakuhyouDetailBean();
            skJimurenrakuhyouDetailBean.setIrMessage("メッセージ");

            iReportDataSouceBeanLst.add(skJimurenrakuhyouDetailBean);

            reportTestBean.addParamObjects(iReportDataSouceBeanLst, skJimurenrakuhyouBean);
            createReport.exec(new ReportServicesBean[] {reportTestBean });
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
                createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "sk_jimurenrakuhyouTest",
                    C_SyoruiCdKbn.SK_JIMURENRAKU);

            skJimurenrakuhyouBean.setIrMosno("XXXXXXXXX");
            skJimurenrakuhyouBean.setIrTyouhyousakuseiymd("2018年10月13日");
            skJimurenrakuhyouBean.setIrKinounm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean = new SkJimurenrakuhyouDetailBean();
                skJimurenrakuhyouDetailBean.setIrMessage("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

                iReportDataSouceBeanLst.add(skJimurenrakuhyouDetailBean);
            }

            reportTestBean.addParamObjects(iReportDataSouceBeanLst, skJimurenrakuhyouBean);
            createReport.exec(new ReportServicesBean[] {reportTestBean });
        } catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

}
