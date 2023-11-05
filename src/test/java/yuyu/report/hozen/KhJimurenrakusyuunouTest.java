package yuyu.report.hozen;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhJimuRenrakuhyouSyuunouBean;
import yuyu.def.hozen.bean.report.KhJimuRenrakuhyouSyuunouDetailBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 事務連絡票（収納）テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhJimurenrakusyuunouTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhJimuRenrakuhyouSyuunouBean khJimuRenrakuhyouSyuunouBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU);

        khJimuRenrakuhyouSyuunouBean.setIrSyoriymd(null);
        khJimuRenrakuhyouSyuunouBean.setIrSyono(null);
        khJimuRenrakuhyouSyuunouBean.setIrKinounm(null);
        khJimuRenrakuhyouSyuunouBean.setIrTantcd(null);
        khJimuRenrakuhyouSyuunouBean.setIrTantnm(null);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();


        for (int i = 0; i < 1; i++) {

            KhJimuRenrakuhyouSyuunouDetailBean khJimuRenrakuhyouSyuunouDetailBean = new KhJimuRenrakuhyouSyuunouDetailBean();

            khJimuRenrakuhyouSyuunouDetailBean.setIrJmrnrkhyousyuunoumsg(null);

            iReportDataSouceBean.add(khJimuRenrakuhyouSyuunouDetailBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khJimuRenrakuhyouSyuunouBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU);

        khJimuRenrakuhyouSyuunouBean.setIrSyoriymd("");
        khJimuRenrakuhyouSyuunouBean.setIrSyono("");
        khJimuRenrakuhyouSyuunouBean.setIrKinounm("");
        khJimuRenrakuhyouSyuunouBean.setIrTantcd("");
        khJimuRenrakuhyouSyuunouBean.setIrTantnm("");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhJimuRenrakuhyouSyuunouDetailBean khJimuRenrakuhyouSyuunouDetailBean = null;

        for (int i = 0; i < 1; i++) {

            khJimuRenrakuhyouSyuunouDetailBean = new KhJimuRenrakuhyouSyuunouDetailBean();

            khJimuRenrakuhyouSyuunouDetailBean.setIrJmrnrkhyousyuunoumsg("");

            iReportDataSouceBean.add(khJimuRenrakuhyouSyuunouDetailBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khJimuRenrakuhyouSyuunouBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU);

        khJimuRenrakuhyouSyuunouBean.setIrSyoriymd("2026年 8月 8日");
        khJimuRenrakuhyouSyuunouBean.setIrSyono("11807111118");
        khJimuRenrakuhyouSyuunouBean.setIrKinounm("事務連絡票（収納）");
        khJimuRenrakuhyouSyuunouBean.setIrTantcd("1234567");
        khJimuRenrakuhyouSyuunouBean.setIrTantnm("担当者名");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhJimuRenrakuhyouSyuunouDetailBean khJimuRenrakuhyouSyuunouDetailBean1 = new KhJimuRenrakuhyouSyuunouDetailBean();
        khJimuRenrakuhyouSyuunouDetailBean1.setIrJmrnrkhyousyuunoumsg("仮受金に計上しました");
        KhJimuRenrakuhyouSyuunouDetailBean khJimuRenrakuhyouSyuunouDetailBean2 = new KhJimuRenrakuhyouSyuunouDetailBean();
        khJimuRenrakuhyouSyuunouDetailBean2.setIrJmrnrkhyousyuunoumsg("");
        KhJimuRenrakuhyouSyuunouDetailBean khJimuRenrakuhyouSyuunouDetailBean3 = new KhJimuRenrakuhyouSyuunouDetailBean();
        khJimuRenrakuhyouSyuunouDetailBean3.setIrJmrnrkhyousyuunoumsg("仮受理由区分／消滅後入金");
        KhJimuRenrakuhyouSyuunouDetailBean khJimuRenrakuhyouSyuunouDetailBean4 = new KhJimuRenrakuhyouSyuunouDetailBean();
        khJimuRenrakuhyouSyuunouDetailBean4.setIrJmrnrkhyousyuunoumsg("入金経路／銀行");
        KhJimuRenrakuhyouSyuunouDetailBean khJimuRenrakuhyouSyuunouDetailBean5 = new KhJimuRenrakuhyouSyuunouDetailBean();
        khJimuRenrakuhyouSyuunouDetailBean5.setIrJmrnrkhyousyuunoumsg("入金内容区分／継続Ｐ");
        KhJimuRenrakuhyouSyuunouDetailBean khJimuRenrakuhyouSyuunouDetailBean6 = new KhJimuRenrakuhyouSyuunouDetailBean();
        khJimuRenrakuhyouSyuunouDetailBean6.setIrJmrnrkhyousyuunoumsg("充当年月／2030年10月");
        KhJimuRenrakuhyouSyuunouDetailBean khJimuRenrakuhyouSyuunouDetailBean7 = new KhJimuRenrakuhyouSyuunouDetailBean();
        khJimuRenrakuhyouSyuunouDetailBean7.setIrJmrnrkhyousyuunoumsg("充当回数／3ヵ月");
        KhJimuRenrakuhyouSyuunouDetailBean khJimuRenrakuhyouSyuunouDetailBean8 = new KhJimuRenrakuhyouSyuunouDetailBean();
        khJimuRenrakuhyouSyuunouDetailBean8.setIrJmrnrkhyousyuunoumsg("仮受番号／123");
        KhJimuRenrakuhyouSyuunouDetailBean khJimuRenrakuhyouSyuunouDetailBean9 = new KhJimuRenrakuhyouSyuunouDetailBean();
        khJimuRenrakuhyouSyuunouDetailBean9.setIrJmrnrkhyousyuunoumsg("仮受金額／1,234,567,890円");
        KhJimuRenrakuhyouSyuunouDetailBean khJimuRenrakuhyouSyuunouDetailBean10 = new KhJimuRenrakuhyouSyuunouDetailBean();
        khJimuRenrakuhyouSyuunouDetailBean10.setIrJmrnrkhyousyuunoumsg("領収日／2030年12月11日");

        iReportDataSouceBean.add(khJimuRenrakuhyouSyuunouDetailBean1);
        iReportDataSouceBean.add(khJimuRenrakuhyouSyuunouDetailBean2);
        iReportDataSouceBean.add(khJimuRenrakuhyouSyuunouDetailBean3);
        iReportDataSouceBean.add(khJimuRenrakuhyouSyuunouDetailBean4);
        iReportDataSouceBean.add(khJimuRenrakuhyouSyuunouDetailBean5);
        iReportDataSouceBean.add(khJimuRenrakuhyouSyuunouDetailBean6);
        iReportDataSouceBean.add(khJimuRenrakuhyouSyuunouDetailBean7);
        iReportDataSouceBean.add(khJimuRenrakuhyouSyuunouDetailBean8);
        iReportDataSouceBean.add(khJimuRenrakuhyouSyuunouDetailBean9);
        iReportDataSouceBean.add(khJimuRenrakuhyouSyuunouDetailBean10);

        reportTestBean.addParamObjects(iReportDataSouceBean, khJimuRenrakuhyouSyuunouBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU);

        khJimuRenrakuhyouSyuunouBean.setIrSyoriymd("9999年99月99日");
        khJimuRenrakuhyouSyuunouBean.setIrSyono("NNNNNNNNNNN");
        khJimuRenrakuhyouSyuunouBean.setIrKinounm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khJimuRenrakuhyouSyuunouBean.setIrTantcd("NNNNNNNN");
        khJimuRenrakuhyouSyuunouBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhJimuRenrakuhyouSyuunouDetailBean khJimuRenrakuhyouSyuunouDetailBean = null;

        for (int i = 0; i < 43; i++) {

            khJimuRenrakuhyouSyuunouDetailBean = new KhJimuRenrakuhyouSyuunouDetailBean();

            khJimuRenrakuhyouSyuunouDetailBean.setIrJmrnrkhyousyuunoumsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            iReportDataSouceBean.add(khJimuRenrakuhyouSyuunouDetailBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khJimuRenrakuhyouSyuunouBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU);

        khJimuRenrakuhyouSyuunouBean.setIrSyoriymd("9999年99月99日");
        khJimuRenrakuhyouSyuunouBean.setIrSyono("NNNNNNNNNNN");
        khJimuRenrakuhyouSyuunouBean.setIrKinounm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khJimuRenrakuhyouSyuunouBean.setIrTantcd("23456789");
        khJimuRenrakuhyouSyuunouBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhJimuRenrakuhyouSyuunouDetailBean khJimuRenrakuhyouSyuunouDetailBean = null;

        for (int i = 0; i < 42; i++) {

            khJimuRenrakuhyouSyuunouDetailBean = new KhJimuRenrakuhyouSyuunouDetailBean();

            khJimuRenrakuhyouSyuunouDetailBean.setIrJmrnrkhyousyuunoumsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            iReportDataSouceBean.add(khJimuRenrakuhyouSyuunouDetailBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khJimuRenrakuhyouSyuunouBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU);

        khJimuRenrakuhyouSyuunouBean.setIrSyoriymd("9999年99月99日");
        khJimuRenrakuhyouSyuunouBean.setIrSyono("NNNNNNNNNNN");
        khJimuRenrakuhyouSyuunouBean.setIrKinounm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khJimuRenrakuhyouSyuunouBean.setIrTantcd("345678901");
        khJimuRenrakuhyouSyuunouBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhJimuRenrakuhyouSyuunouDetailBean khJimuRenrakuhyouSyuunouDetailBean = null;

        for (int i = 0; i < 44; i++) {

            khJimuRenrakuhyouSyuunouDetailBean = new KhJimuRenrakuhyouSyuunouDetailBean();

            khJimuRenrakuhyouSyuunouDetailBean.setIrJmrnrkhyousyuunoumsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            iReportDataSouceBean.add(khJimuRenrakuhyouSyuunouDetailBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khJimuRenrakuhyouSyuunouBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU);

        khJimuRenrakuhyouSyuunouBean.setIrSyoriymd("9999年99月99日");
        khJimuRenrakuhyouSyuunouBean.setIrSyono("NNNNNNNNNNN");
        khJimuRenrakuhyouSyuunouBean.setIrKinounm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khJimuRenrakuhyouSyuunouBean.setIrTantcd("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");
        khJimuRenrakuhyouSyuunouBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhJimuRenrakuhyouSyuunouDetailBean khJimuRenrakuhyouSyuunouDetailBean = null;

        for (int i = 0; i < 42957; i++) {

            khJimuRenrakuhyouSyuunouDetailBean = new KhJimuRenrakuhyouSyuunouDetailBean();

            khJimuRenrakuhyouSyuunouDetailBean.setIrJmrnrkhyousyuunoumsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            iReportDataSouceBean.add(khJimuRenrakuhyouSyuunouDetailBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khJimuRenrakuhyouSyuunouBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU);

        khJimuRenrakuhyouSyuunouBean.setIrSyoriymd("9999年99月99日");
        khJimuRenrakuhyouSyuunouBean.setIrSyono("NNNNNNNNNNN");
        khJimuRenrakuhyouSyuunouBean.setIrKinounm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khJimuRenrakuhyouSyuunouBean.setIrTantcd("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");
        khJimuRenrakuhyouSyuunouBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(iReportDataSouceBean, khJimuRenrakuhyouSyuunouBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }
}
