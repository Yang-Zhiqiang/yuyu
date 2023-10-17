package yuyu.report.hozen;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Dattaikeiro;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhDattaiMikaisyouListBean;
import yuyu.def.hozen.bean.report.KhDattaiMikaisyouListDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 脱退未解消リストテスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhdattaimikaisyoulistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhDattaiMikaisyouListBean khDattaiMikaisyouListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhhrkeyousiskskykminyknlistTest",
                C_SyoruiCdKbn.AS_DATTAI_MIKAISYOULIST);

        khDattaiMikaisyouListBean.setIrSyoribi(null);
        khDattaiMikaisyouListBean.setIrKensuu(null);
        khDattaiMikaisyouListBean.setIrSakuseisosiki(null);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhDattaiMikaisyouListDataSourceBean khDattaiMikaisyouListDataSourceBean = null;

        for (int i = 0; i < 1; i++) {

            khDattaiMikaisyouListDataSourceBean = new KhDattaiMikaisyouListDataSourceBean();

            khDattaiMikaisyouListDataSourceBean.setIrAtesakisosiki(null);
            khDattaiMikaisyouListDataSourceBean.setIrTyoukimisyorihyouji(null);
            khDattaiMikaisyouListDataSourceBean.setIrSyono(null);
            khDattaiMikaisyouListDataSourceBean.setIrSyoriymdbizdate(null);
            khDattaiMikaisyouListDataSourceBean.setIrDattaikeiro(null);
            khDattaiMikaisyouListDataSourceBean.setIrDattaiinputsosiki(null);
            khDattaiMikaisyouListDataSourceBean.setIrTantnm(null);
            khDattaiMikaisyouListDataSourceBean.setIrDattairiyuukbn(null);
            khDattaiMikaisyouListDataSourceBean.setIrComment124keta(null);

            iReportDataSouceBean.add(khDattaiMikaisyouListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khDattaiMikaisyouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhhrkeyousiskskykminyknlistTest",
                C_SyoruiCdKbn.AS_DATTAI_MIKAISYOULIST);

        khDattaiMikaisyouListBean.setIrSyoribi(null);
        khDattaiMikaisyouListBean.setIrKensuu(null);
        khDattaiMikaisyouListBean.setIrSakuseisosiki("");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhDattaiMikaisyouListDataSourceBean khDattaiMikaisyouListDataSourceBean = null;

        for (int i = 0; i < 1; i++) {

            khDattaiMikaisyouListDataSourceBean = new KhDattaiMikaisyouListDataSourceBean();

            khDattaiMikaisyouListDataSourceBean.setIrAtesakisosiki("");
            khDattaiMikaisyouListDataSourceBean.setIrTyoukimisyorihyouji("");
            khDattaiMikaisyouListDataSourceBean.setIrSyono("");
            khDattaiMikaisyouListDataSourceBean.setIrSyoriymdbizdate(null);
            khDattaiMikaisyouListDataSourceBean.setIrDattaikeiro(null);
            khDattaiMikaisyouListDataSourceBean.setIrDattaiinputsosiki("");
            khDattaiMikaisyouListDataSourceBean.setIrTantnm("");
            khDattaiMikaisyouListDataSourceBean.setIrDattairiyuukbn(null);
            khDattaiMikaisyouListDataSourceBean.setIrComment124keta("");

            iReportDataSouceBean.add(khDattaiMikaisyouListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khDattaiMikaisyouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhhrkeyousiskskykminyknlistTest",
                C_SyoruiCdKbn.AS_DATTAI_MIKAISYOULIST);

        khDattaiMikaisyouListBean.setIrSyoribi(BizDate.valueOf("20170506"));
        khDattaiMikaisyouListBean.setIrKensuu(1);
        khDattaiMikaisyouListBean.setIrSakuseisosiki("組織５５１００００");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhDattaiMikaisyouListDataSourceBean khDattaiMikaisyouListDataSourceBean = null;

        for (int i = 0; i < 1; i++) {

            khDattaiMikaisyouListDataSourceBean = new KhDattaiMikaisyouListDataSourceBean();

            khDattaiMikaisyouListDataSourceBean.setIrAtesakisosiki("宛先組織名");
            khDattaiMikaisyouListDataSourceBean.setIrTyoukimisyorihyouji("*");
            khDattaiMikaisyouListDataSourceBean.setIrSyono("11807111118");
            khDattaiMikaisyouListDataSourceBean.setIrSyoriymdbizdate(BizDate.valueOf("20170607"));
            khDattaiMikaisyouListDataSourceBean.setIrDattaikeiro(C_Dattaikeiro.KOUHURI);
            khDattaiMikaisyouListDataSourceBean.setIrDattaiinputsosiki("脱退入力組織");
            khDattaiMikaisyouListDataSourceBean.setIrTantnm("担当者名");
            khDattaiMikaisyouListDataSourceBean.setIrDattairiyuukbn(C_DattairiyuuKbn.HRHENKIBOU);
            khDattaiMikaisyouListDataSourceBean.setIrComment124keta("コメント１２４桁あいうえお");

            iReportDataSouceBean.add(khDattaiMikaisyouListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khDattaiMikaisyouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhhrkeyousiskskykminyknlistTest",
                C_SyoruiCdKbn.AS_DATTAI_MIKAISYOULIST);

        khDattaiMikaisyouListBean.setIrSyoribi(BizDate.valueOf("99991231"));
        khDattaiMikaisyouListBean.setIrKensuu(12);
        khDattaiMikaisyouListBean.setIrSakuseisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhDattaiMikaisyouListDataSourceBean khDattaiMikaisyouListDataSourceBean = null;

        for (int i = 0; i < 12; i++) {

            khDattaiMikaisyouListDataSourceBean = new KhDattaiMikaisyouListDataSourceBean();

            khDattaiMikaisyouListDataSourceBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khDattaiMikaisyouListDataSourceBean.setIrTyoukimisyorihyouji("w");
            khDattaiMikaisyouListDataSourceBean.setIrSyono("wwwwwwwwwww");
            khDattaiMikaisyouListDataSourceBean.setIrSyoriymdbizdate(BizDate.valueOf("99991231"));
            khDattaiMikaisyouListDataSourceBean.setIrDattaikeiro(C_Dattaikeiro.CREDIT);
            khDattaiMikaisyouListDataSourceBean.setIrDattaiinputsosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khDattaiMikaisyouListDataSourceBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khDattaiMikaisyouListDataSourceBean.setIrDattairiyuukbn(C_DattairiyuuKbn.CSSKOUHURIIRHUBI);
            khDattaiMikaisyouListDataSourceBean.setIrComment124keta("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            iReportDataSouceBean.add(khDattaiMikaisyouListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khDattaiMikaisyouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhhrkeyousiskskykminyknlistTest",
                C_SyoruiCdKbn.AS_DATTAI_MIKAISYOULIST);

        khDattaiMikaisyouListBean.setIrSyoribi(BizDate.valueOf("20871231"));
        khDattaiMikaisyouListBean.setIrKensuu(11);
        khDattaiMikaisyouListBean.setIrSakuseisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhDattaiMikaisyouListDataSourceBean khDattaiMikaisyouListDataSourceBean1 = new KhDattaiMikaisyouListDataSourceBean();
        khDattaiMikaisyouListDataSourceBean1.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khDattaiMikaisyouListDataSourceBean1.setIrTyoukimisyorihyouji("*");
        khDattaiMikaisyouListDataSourceBean1.setIrSyono("11807111118");
        khDattaiMikaisyouListDataSourceBean1.setIrSyoriymdbizdate(BizDate.valueOf("20171203"));
        khDattaiMikaisyouListDataSourceBean1.setIrDattaikeiro(C_Dattaikeiro.CREDIT);
        khDattaiMikaisyouListDataSourceBean1.setIrDattaiinputsosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khDattaiMikaisyouListDataSourceBean1.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khDattaiMikaisyouListDataSourceBean1.setIrDattairiyuukbn(C_DattairiyuuKbn.CSSKOUHURIIRHUBI);
        khDattaiMikaisyouListDataSourceBean1.setIrComment124keta("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        KhDattaiMikaisyouListDataSourceBean khDattaiMikaisyouListDataSourceBean2 = new KhDattaiMikaisyouListDataSourceBean();
        khDattaiMikaisyouListDataSourceBean2.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khDattaiMikaisyouListDataSourceBean2.setIrTyoukimisyorihyouji("*");
        khDattaiMikaisyouListDataSourceBean2.setIrSyono("11807111129");
        khDattaiMikaisyouListDataSourceBean2.setIrSyoriymdbizdate(BizDate.valueOf("20171204"));
        khDattaiMikaisyouListDataSourceBean2.setIrDattaikeiro(C_Dattaikeiro.CREDIT);
        khDattaiMikaisyouListDataSourceBean2.setIrDattaiinputsosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khDattaiMikaisyouListDataSourceBean2.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khDattaiMikaisyouListDataSourceBean2.setIrDattairiyuukbn(C_DattairiyuuKbn.CSSKOUHURIIRHUBI);
        khDattaiMikaisyouListDataSourceBean2.setIrComment124keta("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        KhDattaiMikaisyouListDataSourceBean khDattaiMikaisyouListDataSourceBean3 = new KhDattaiMikaisyouListDataSourceBean();
        khDattaiMikaisyouListDataSourceBean3.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khDattaiMikaisyouListDataSourceBean3.setIrTyoukimisyorihyouji("*");
        khDattaiMikaisyouListDataSourceBean3.setIrSyono("11807111118");
        khDattaiMikaisyouListDataSourceBean3.setIrSyoriymdbizdate(BizDate.valueOf("20171205"));
        khDattaiMikaisyouListDataSourceBean3.setIrDattaikeiro(C_Dattaikeiro.CREDIT);
        khDattaiMikaisyouListDataSourceBean3.setIrDattaiinputsosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khDattaiMikaisyouListDataSourceBean3.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khDattaiMikaisyouListDataSourceBean3.setIrDattairiyuukbn(C_DattairiyuuKbn.CSSKOUHURIIRHUBI);
        khDattaiMikaisyouListDataSourceBean3.setIrComment124keta("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        KhDattaiMikaisyouListDataSourceBean khDattaiMikaisyouListDataSourceBean4 = new KhDattaiMikaisyouListDataSourceBean();
        khDattaiMikaisyouListDataSourceBean4.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khDattaiMikaisyouListDataSourceBean4.setIrTyoukimisyorihyouji("*");
        khDattaiMikaisyouListDataSourceBean4.setIrSyono("11807111129");
        khDattaiMikaisyouListDataSourceBean4.setIrSyoriymdbizdate(BizDate.valueOf("20171205"));
        khDattaiMikaisyouListDataSourceBean4.setIrDattaikeiro(C_Dattaikeiro.CREDIT);
        khDattaiMikaisyouListDataSourceBean4.setIrDattaiinputsosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khDattaiMikaisyouListDataSourceBean4.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khDattaiMikaisyouListDataSourceBean4.setIrDattairiyuukbn(C_DattairiyuuKbn.CSSKOUHURIIRHUBI);
        khDattaiMikaisyouListDataSourceBean4.setIrComment124keta("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        KhDattaiMikaisyouListDataSourceBean khDattaiMikaisyouListDataSourceBean5 =  new KhDattaiMikaisyouListDataSourceBean();
        khDattaiMikaisyouListDataSourceBean5.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khDattaiMikaisyouListDataSourceBean5.setIrTyoukimisyorihyouji("*");
        khDattaiMikaisyouListDataSourceBean5.setIrSyono("11807111130");
        khDattaiMikaisyouListDataSourceBean5.setIrSyoriymdbizdate(BizDate.valueOf("20171205"));
        khDattaiMikaisyouListDataSourceBean5.setIrDattaikeiro(C_Dattaikeiro.CREDIT);
        khDattaiMikaisyouListDataSourceBean5.setIrDattaiinputsosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khDattaiMikaisyouListDataSourceBean5.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khDattaiMikaisyouListDataSourceBean5.setIrDattairiyuukbn(C_DattairiyuuKbn.CSSKOUHURIIRHUBI);
        khDattaiMikaisyouListDataSourceBean5.setIrComment124keta("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        iReportDataSouceBean.add(khDattaiMikaisyouListDataSourceBean1);
        iReportDataSouceBean.add(khDattaiMikaisyouListDataSourceBean2);
        iReportDataSouceBean.add(khDattaiMikaisyouListDataSourceBean3);
        iReportDataSouceBean.add(khDattaiMikaisyouListDataSourceBean4);
        iReportDataSouceBean.add(khDattaiMikaisyouListDataSourceBean5);

        KhDattaiMikaisyouListDataSourceBean khDattaiMikaisyouListDataSourceBean = null;

        for (int i = 5; i < 11; i++) {

            khDattaiMikaisyouListDataSourceBean = new KhDattaiMikaisyouListDataSourceBean();

            khDattaiMikaisyouListDataSourceBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khDattaiMikaisyouListDataSourceBean.setIrTyoukimisyorihyouji("*");
            khDattaiMikaisyouListDataSourceBean.setIrSyono("wwwwwwwwwww");
            khDattaiMikaisyouListDataSourceBean.setIrSyoriymdbizdate(BizDate.valueOf("20871231"));
            khDattaiMikaisyouListDataSourceBean.setIrDattaikeiro(C_Dattaikeiro.CREDIT);
            khDattaiMikaisyouListDataSourceBean.setIrDattaiinputsosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khDattaiMikaisyouListDataSourceBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khDattaiMikaisyouListDataSourceBean.setIrDattairiyuukbn(C_DattairiyuuKbn.CSSKOUHURIIRHUBI);
            khDattaiMikaisyouListDataSourceBean.setIrComment124keta("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            iReportDataSouceBean.add(khDattaiMikaisyouListDataSourceBean);
        }



        reportTestBean.addParamObjects(iReportDataSouceBean, khDattaiMikaisyouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhhrkeyousiskskykminyknlistTest",
                C_SyoruiCdKbn.AS_DATTAI_MIKAISYOULIST);

        khDattaiMikaisyouListBean.setIrSyoribi(BizDate.valueOf("20871231"));
        khDattaiMikaisyouListBean.setIrKensuu(13);
        khDattaiMikaisyouListBean.setIrSakuseisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhDattaiMikaisyouListDataSourceBean khDattaiMikaisyouListDataSourceBean = null;

        for (int i = 0; i < 13; i++) {

            khDattaiMikaisyouListDataSourceBean = new KhDattaiMikaisyouListDataSourceBean();

            khDattaiMikaisyouListDataSourceBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khDattaiMikaisyouListDataSourceBean.setIrTyoukimisyorihyouji("*");
            khDattaiMikaisyouListDataSourceBean.setIrSyono("wwwwwwwwwww");
            khDattaiMikaisyouListDataSourceBean.setIrSyoriymdbizdate(BizDate.valueOf("20871231"));
            khDattaiMikaisyouListDataSourceBean.setIrDattaikeiro(C_Dattaikeiro.CREDIT);
            khDattaiMikaisyouListDataSourceBean.setIrDattaiinputsosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khDattaiMikaisyouListDataSourceBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khDattaiMikaisyouListDataSourceBean.setIrDattairiyuukbn(C_DattairiyuuKbn.CSSKOUHURIIRHUBI);
            khDattaiMikaisyouListDataSourceBean.setIrComment124keta("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            iReportDataSouceBean.add(khDattaiMikaisyouListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khDattaiMikaisyouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhhrkeyousiskskykminyknlistTest",
                C_SyoruiCdKbn.AS_DATTAI_MIKAISYOULIST);

        khDattaiMikaisyouListBean.setIrSyoribi(BizDate.valueOf("20871231"));
        khDattaiMikaisyouListBean.setIrKensuu(11988);
        khDattaiMikaisyouListBean.setIrSakuseisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhDattaiMikaisyouListDataSourceBean khDattaiMikaisyouListDataSourceBean = null;

        for (int i = 0; i < 11988; i++) {

            khDattaiMikaisyouListDataSourceBean = new KhDattaiMikaisyouListDataSourceBean();

            khDattaiMikaisyouListDataSourceBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khDattaiMikaisyouListDataSourceBean.setIrTyoukimisyorihyouji("*");
            khDattaiMikaisyouListDataSourceBean.setIrSyono("wwwwwwwwwww");
            khDattaiMikaisyouListDataSourceBean.setIrSyoriymdbizdate(BizDate.valueOf("20871231"));
            khDattaiMikaisyouListDataSourceBean.setIrDattaikeiro(C_Dattaikeiro.CREDIT);
            khDattaiMikaisyouListDataSourceBean.setIrDattaiinputsosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khDattaiMikaisyouListDataSourceBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khDattaiMikaisyouListDataSourceBean.setIrDattairiyuukbn(C_DattairiyuuKbn.CSSKOUHURIIRHUBI);
            khDattaiMikaisyouListDataSourceBean.setIrComment124keta("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            iReportDataSouceBean.add(khDattaiMikaisyouListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khDattaiMikaisyouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhhrkeyousiskskykminyknlistTest",
                C_SyoruiCdKbn.AS_DATTAI_MIKAISYOULIST);

        khDattaiMikaisyouListBean.setIrSyoribi(BizDate.valueOf("20871231"));
        khDattaiMikaisyouListBean.setIrKensuu(9999);
        khDattaiMikaisyouListBean.setIrSakuseisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhDattaiMikaisyouListDataSourceBean khDattaiMikaisyouListDataSourceBean = null;

        for (int i = 0; i < 9999; i++) {

            khDattaiMikaisyouListDataSourceBean = new KhDattaiMikaisyouListDataSourceBean();

            khDattaiMikaisyouListDataSourceBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khDattaiMikaisyouListDataSourceBean.setIrTyoukimisyorihyouji("*");
            khDattaiMikaisyouListDataSourceBean.setIrSyono("wwwwwwwwwww");
            khDattaiMikaisyouListDataSourceBean.setIrSyoriymdbizdate(BizDate.valueOf("20871231"));
            khDattaiMikaisyouListDataSourceBean.setIrDattaikeiro(C_Dattaikeiro.CREDIT);
            khDattaiMikaisyouListDataSourceBean.setIrDattaiinputsosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khDattaiMikaisyouListDataSourceBean.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khDattaiMikaisyouListDataSourceBean.setIrDattairiyuukbn(C_DattairiyuuKbn.CSSKOUHURIIRHUBI);
            khDattaiMikaisyouListDataSourceBean.setIrComment124keta("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            iReportDataSouceBean.add(khDattaiMikaisyouListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khDattaiMikaisyouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhhrkeyousiskskykminyknlistTest",
                C_SyoruiCdKbn.AS_DATTAI_MIKAISYOULIST);

        khDattaiMikaisyouListBean.setIrSyoribi(BizDate.valueOf("20871231"));
        khDattaiMikaisyouListBean.setIrKensuu(0);
        khDattaiMikaisyouListBean.setIrSakuseisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhDattaiMikaisyouListDataSourceBean khDattaiMikaisyouListDataSourceBean1 = new KhDattaiMikaisyouListDataSourceBean();
        khDattaiMikaisyouListDataSourceBean1.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        iReportDataSouceBean.add(khDattaiMikaisyouListDataSourceBean1);

        reportTestBean.addParamObjects(iReportDataSouceBean, khDattaiMikaisyouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhhrkeyousiskskykminyknlistTest",
                C_SyoruiCdKbn.AS_DATTAI_MIKAISYOULIST);

        khDattaiMikaisyouListBean.setIrSyoribi(BizDate.valueOf("20871231"));
        khDattaiMikaisyouListBean.setIrKensuu(2);
        khDattaiMikaisyouListBean.setIrSakuseisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhDattaiMikaisyouListDataSourceBean khDattaiMikaisyouListDataSourceBean1 = new KhDattaiMikaisyouListDataSourceBean();
        khDattaiMikaisyouListDataSourceBean1.setIrAtesakisosiki("宛先");
        khDattaiMikaisyouListDataSourceBean1.setIrTyoukimisyorihyouji("*");
        khDattaiMikaisyouListDataSourceBean1.setIrSyono("11807111118");
        khDattaiMikaisyouListDataSourceBean1.setIrSyoriymdbizdate(BizDate.valueOf("20171203"));
        khDattaiMikaisyouListDataSourceBean1.setIrDattaikeiro(C_Dattaikeiro.CREDIT);
        khDattaiMikaisyouListDataSourceBean1.setIrDattaiinputsosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khDattaiMikaisyouListDataSourceBean1.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khDattaiMikaisyouListDataSourceBean1.setIrDattairiyuukbn(C_DattairiyuuKbn.CSSKOUHURIIRHUBI);
        khDattaiMikaisyouListDataSourceBean1.setIrComment124keta("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        KhDattaiMikaisyouListDataSourceBean khDattaiMikaisyouListDataSourceBean2 =  new KhDattaiMikaisyouListDataSourceBean();

        khDattaiMikaisyouListDataSourceBean2.setIrAtesakisosiki("宛先組織名");
        khDattaiMikaisyouListDataSourceBean2.setIrTyoukimisyorihyouji("*");
        khDattaiMikaisyouListDataSourceBean2.setIrSyono("11807111118");
        khDattaiMikaisyouListDataSourceBean2.setIrSyoriymdbizdate(BizDate.valueOf("20171203"));
        khDattaiMikaisyouListDataSourceBean2.setIrDattaikeiro(C_Dattaikeiro.CREDIT);
        khDattaiMikaisyouListDataSourceBean2.setIrDattaiinputsosiki("脱退入力組織");
        khDattaiMikaisyouListDataSourceBean2.setIrTantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khDattaiMikaisyouListDataSourceBean2.setIrDattairiyuukbn(C_DattairiyuuKbn.CSSKOUHURIIRHUBI);
        khDattaiMikaisyouListDataSourceBean2.setIrComment124keta("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        iReportDataSouceBean.add(khDattaiMikaisyouListDataSourceBean1);
        iReportDataSouceBean.add(khDattaiMikaisyouListDataSourceBean2);

        reportTestBean.addParamObjects(iReportDataSouceBean, khDattaiMikaisyouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }}
