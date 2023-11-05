package yuyu.report.biz;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzSikinIdouListHijynbrNykBean;
import yuyu.def.biz.bean.report.BzSikinIdouListHijynbrNykDataSourceBean;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 資金移動リスト（平準払入金分）帳票テスト用クラス<br />
 */

@RunWith(OrderedRunner.class)
public class BzSikinIdouListHijynbrnykTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzSikinIdouListHijynbrNykBean bzSikinIdouListHijynbrNykBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisthijynbrnyk", C_SyoruiCdKbn.CM_SIKINIDOULIST_HIJYNNYK);

        bzSikinIdouListHijynbrNykBean.setIrSyoriymd(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean = new BzSikinIdouListHijynbrNykDataSourceBean();

        bzSikinIdouListHijynbrNykDataSourceBean.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListHijynbrNykDataSourceBean.setIrKeiritrhktuukagk(null);
        bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisiteituukasyu(null);
        bzSikinIdouListHijynbrNykDataSourceBean.setIrSeg1cd(null);
        bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisikinidougroupno(null);
        bzSikinIdouListHijynbrNykDataSourceBean.setIrKeiritrhktuukagkkei(null);
        bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisiteituukagkkei(null);
        bzSikinIdouListHijynbrNykDataSourceBean.setIrHijynnyksknidoutyuukimsg(null);

        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHijynbrNykBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisthijynbrnyk", C_SyoruiCdKbn.CM_SIKINIDOULIST_HIJYNNYK);

        bzSikinIdouListHijynbrNykBean.setIrSyoriymd("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean = new BzSikinIdouListHijynbrNykDataSourceBean();

        bzSikinIdouListHijynbrNykDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.BLNK);
        bzSikinIdouListHijynbrNykDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(0));
        bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.BLNK);
        bzSikinIdouListHijynbrNykDataSourceBean.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0));
        bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListHijynbrNykDataSourceBean.setIrKeiritrhktuukagkkei(BizCurrency.valueOf(0));
        bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisiteituukagkkei(BizCurrency.valueOf(0));
        bzSikinIdouListHijynbrNykDataSourceBean.setIrHijynnyksknidoutyuukimsg("");

        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHijynbrNykBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisthijynbrnyk", C_SyoruiCdKbn.CM_SIKINIDOULIST_HIJYNNYK);

        bzSikinIdouListHijynbrNykBean.setIrSyoriymd("2028年 7月22日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean1 = new BzSikinIdouListHijynbrNykDataSourceBean();

        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(400));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisikinidoumeisaikbnnm("入金取消分");
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukagkkei(BizCurrency.valueOf(401));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukagkkei(BizCurrency.valueOf(301));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrHijynnyksknidoutyuukimsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean1);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean2 = new BzSikinIdouListHijynbrNykDataSourceBean();

        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(4002));
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3002));
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisikinidoumeisaikbnnm("入金取消分");
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeiritrhktuukagkkei(BizCurrency.valueOf(4003));
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisiteituukagkkei(BizCurrency.valueOf(3003));
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrHijynnyksknidoutyuukimsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHijynbrNykBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisthijynbrnyk", C_SyoruiCdKbn.CM_SIKINIDOULIST_HIJYNNYK);

        bzSikinIdouListHijynbrNykBean.setIrSyoriymd("2028年 7月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean1 = new BzSikinIdouListHijynbrNykDataSourceBean();

        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.1));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.1));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisikinidoumeisaikbnnm("入金取消分");
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukagkkei(BizCurrency.valueOf(9.2));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9.2));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrHijynnyksknidoutyuukimsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean1);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean2 = new BzSikinIdouListHijynbrNykDataSourceBean();

        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisikinidoumeisaikbnnm("入金取消分");
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeiritrhktuukagkkei(BizCurrency.valueOf(9.23));
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9.23));
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrHijynnyksknidoutyuukimsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHijynbrNykBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisthijynbrnyk", C_SyoruiCdKbn.CM_SIKINIDOULIST_HIJYNNYK);

        bzSikinIdouListHijynbrNykBean.setIrSyoriymd("2028年 7月24日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean1 = new BzSikinIdouListHijynbrNykDataSourceBean();

        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.333));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.333));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisikinidoumeisaikbnnm("入金取消分");
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukagkkei(BizCurrency.valueOf(9.334));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9.334));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrHijynnyksknidoutyuukimsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean1);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean2 = new BzSikinIdouListHijynbrNykDataSourceBean();

        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(9));
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9));
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisikinidoumeisaikbnnm("入金取消分");
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeiritrhktuukagkkei(BizCurrency.valueOf(9));
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9));
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrHijynnyksknidoutyuukimsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHijynbrNykBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisthijynbrnyk", C_SyoruiCdKbn.CM_SIKINIDOULIST_HIJYNNYK);

        bzSikinIdouListHijynbrNykBean.setIrSyoriymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean;
        for (int i = 0; i < 32966; i++) {

            bzSikinIdouListHijynbrNykDataSourceBean = new BzSikinIdouListHijynbrNykDataSourceBean();

            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(999999999999999L));
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
            bzSikinIdouListHijynbrNykDataSourceBean.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999.99));
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisikinidoumeisaikbnnm("ＷＷＷＷＷ");
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);

            dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean);
        }

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean1 = new BzSikinIdouListHijynbrNykDataSourceBean();

        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(999999999999999L));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999.99));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisikinidoumeisaikbnnm("ＷＷＷＷＷ");
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukagkkei(BizCurrency.valueOf(999999999999999L));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9999999999999.99));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrHijynnyksknidoutyuukimsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHijynbrNykBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisthijynbrnyk", C_SyoruiCdKbn.CM_SIKINIDOULIST_HIJYNNYK);

        bzSikinIdouListHijynbrNykBean.setIrSyoriymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean;
        for (int i = 0; i < 31; i++) {

            bzSikinIdouListHijynbrNykDataSourceBean = new BzSikinIdouListHijynbrNykDataSourceBean();

            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
            bzSikinIdouListHijynbrNykDataSourceBean.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisikinidoumeisaikbnnm("ＷＷＷＷＷ");
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
            bzSikinIdouListHijynbrNykDataSourceBean.setIrHijynnyksknidoutyuukimsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean);
        }

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean1 = new BzSikinIdouListHijynbrNykDataSourceBean();

        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisikinidoumeisaikbnnm("ＷＷＷＷＷ");
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukagkkei(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9.22));

        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHijynbrNykBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisthijynbrnyk", C_SyoruiCdKbn.CM_SIKINIDOULIST_HIJYNNYK);

        bzSikinIdouListHijynbrNykBean.setIrSyoriymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean;
        for (int i = 0; i < 32; i++) {

            bzSikinIdouListHijynbrNykDataSourceBean = new BzSikinIdouListHijynbrNykDataSourceBean();

            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
            bzSikinIdouListHijynbrNykDataSourceBean.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisikinidoumeisaikbnnm("ＷＷＷＷＷ");
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);

            dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean);
        }

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean1 = new BzSikinIdouListHijynbrNykDataSourceBean();

        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisikinidoumeisaikbnnm("ＷＷＷＷＷ");
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukagkkei(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrHijynnyksknidoutyuukimsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHijynbrNykBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisthijynbrnyk", C_SyoruiCdKbn.CM_SIKINIDOULIST_HIJYNNYK);

        bzSikinIdouListHijynbrNykBean.setIrSyoriymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean;
        for (int i = 0; i < 33; i++) {

            bzSikinIdouListHijynbrNykDataSourceBean = new BzSikinIdouListHijynbrNykDataSourceBean();

            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
            bzSikinIdouListHijynbrNykDataSourceBean.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisikinidoumeisaikbnnm("ＷＷＷＷＷ");
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);

            dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean);
        }

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean1 = new BzSikinIdouListHijynbrNykDataSourceBean();

        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisikinidoumeisaikbnnm("ＷＷＷＷＷ");
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukagkkei(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrHijynnyksknidoutyuukimsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHijynbrNykBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisthijynbrnyk", C_SyoruiCdKbn.CM_SIKINIDOULIST_HIJYNNYK);

        bzSikinIdouListHijynbrNykBean.setIrSyoriymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean1 = new BzSikinIdouListHijynbrNykDataSourceBean();

        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(999999999999999L));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999.99));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisikinidoumeisaikbnnm("入金取消分");
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukagkkei(BizCurrency.valueOf(999999999999999L));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9999999999999.99));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrHijynnyksknidoutyuukimsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean1);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean2 = new BzSikinIdouListHijynbrNykDataSourceBean();

        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(999999999999999L));
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999.99));
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisikinidoumeisaikbnnm("入金取消分");
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeiritrhktuukagkkei(BizCurrency.valueOf(999999999999999L));
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9999999999999.99));
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrHijynnyksknidoutyuukimsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean2);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean3 = new BzSikinIdouListHijynbrNykDataSourceBean();

        bzSikinIdouListHijynbrNykDataSourceBean3.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean3.setIrKeiritrhktuukagk(BizCurrency.valueOf(999999999999999L));
        bzSikinIdouListHijynbrNykDataSourceBean3.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHijynbrNykDataSourceBean3.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHijynbrNykDataSourceBean3.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999.99));
        bzSikinIdouListHijynbrNykDataSourceBean3.setIrKeirisikinidoumeisaikbnnm("入金取消分");
        bzSikinIdouListHijynbrNykDataSourceBean3.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHijynbrNykDataSourceBean3.setIrKeiritrhktuukagkkei(BizCurrency.valueOf(999999999999999L));
        bzSikinIdouListHijynbrNykDataSourceBean3.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9999999999999.99));
        bzSikinIdouListHijynbrNykDataSourceBean3.setIrHijynnyksknidoutyuukimsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHijynbrNykBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisthijynbrnyk", C_SyoruiCdKbn.CM_SIKINIDOULIST_HIJYNNYK);

        bzSikinIdouListHijynbrNykBean.setIrSyoriymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean = new BzSikinIdouListHijynbrNykDataSourceBean();

        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHijynbrNykBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisthijynbrnyk", C_SyoruiCdKbn.CM_SIKINIDOULIST_HIJYNNYK);

        bzSikinIdouListHijynbrNykBean.setIrSyoriymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean1 = new BzSikinIdouListHijynbrNykDataSourceBean();
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListHijynbrNykDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean1);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean2 = new BzSikinIdouListHijynbrNykDataSourceBean();
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListHijynbrNykDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean2);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean3 = new BzSikinIdouListHijynbrNykDataSourceBean();
        bzSikinIdouListHijynbrNykDataSourceBean3.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean3.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean3.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHijynbrNykDataSourceBean3.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHijynbrNykDataSourceBean3.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean3.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListHijynbrNykDataSourceBean3.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHijynbrNykDataSourceBean3.setIrKeiritrhktuukagkkei(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean3.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean3.setIrHijynnyksknidoutyuukimsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean3);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean4 = new BzSikinIdouListHijynbrNykDataSourceBean();
        bzSikinIdouListHijynbrNykDataSourceBean4.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean4.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean4.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHijynbrNykDataSourceBean4.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListHijynbrNykDataSourceBean4.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean4.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListHijynbrNykDataSourceBean4.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean4);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean5 = new BzSikinIdouListHijynbrNykDataSourceBean();
        bzSikinIdouListHijynbrNykDataSourceBean5.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean5.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean5.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHijynbrNykDataSourceBean5.setIrSeg1cd(null);
        bzSikinIdouListHijynbrNykDataSourceBean5.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean5.setIrKeirisikinidoumeisaikbnnm("入金取消分");
        bzSikinIdouListHijynbrNykDataSourceBean5.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean5);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean6 = new BzSikinIdouListHijynbrNykDataSourceBean();
        bzSikinIdouListHijynbrNykDataSourceBean6.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean6.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean6.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHijynbrNykDataSourceBean6.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHijynbrNykDataSourceBean6.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean6.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListHijynbrNykDataSourceBean6.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean6);


        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean7 = new BzSikinIdouListHijynbrNykDataSourceBean();
        bzSikinIdouListHijynbrNykDataSourceBean7.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean7.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean7.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHijynbrNykDataSourceBean7.setIrSeg1cd(null);
        bzSikinIdouListHijynbrNykDataSourceBean7.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean7.setIrKeirisikinidoumeisaikbnnm("入金取消分");
        bzSikinIdouListHijynbrNykDataSourceBean7.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean7);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean8 = new BzSikinIdouListHijynbrNykDataSourceBean();
        bzSikinIdouListHijynbrNykDataSourceBean8.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean8.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean8.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHijynbrNykDataSourceBean8.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHijynbrNykDataSourceBean8.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean8.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListHijynbrNykDataSourceBean8.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean8);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean9 = new BzSikinIdouListHijynbrNykDataSourceBean();
        bzSikinIdouListHijynbrNykDataSourceBean9.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean9.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean9.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHijynbrNykDataSourceBean9.setIrSeg1cd(null);
        bzSikinIdouListHijynbrNykDataSourceBean9.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean9.setIrKeirisikinidoumeisaikbnnm("入金取消分");
        bzSikinIdouListHijynbrNykDataSourceBean9.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListHijynbrNykDataSourceBean9.setIrKeiritrhktuukagkkei(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean9.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean9.setIrHijynnyksknidoutyuukimsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean9);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean10 = new BzSikinIdouListHijynbrNykDataSourceBean();
        bzSikinIdouListHijynbrNykDataSourceBean10.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean10.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean10.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHijynbrNykDataSourceBean10.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListHijynbrNykDataSourceBean10.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean10.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListHijynbrNykDataSourceBean10.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean10);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean11 = new BzSikinIdouListHijynbrNykDataSourceBean();
        bzSikinIdouListHijynbrNykDataSourceBean11.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean11.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean11.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHijynbrNykDataSourceBean11.setIrSeg1cd(null);
        bzSikinIdouListHijynbrNykDataSourceBean11.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean11.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListHijynbrNykDataSourceBean11.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean11);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean12 = new BzSikinIdouListHijynbrNykDataSourceBean();
        bzSikinIdouListHijynbrNykDataSourceBean12.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean12.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean12.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHijynbrNykDataSourceBean12.setIrSeg1cd(null);
        bzSikinIdouListHijynbrNykDataSourceBean12.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean12.setIrKeirisikinidoumeisaikbnnm("入金取消分");
        bzSikinIdouListHijynbrNykDataSourceBean12.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean12);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean13 = new BzSikinIdouListHijynbrNykDataSourceBean();
        bzSikinIdouListHijynbrNykDataSourceBean13.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean13.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean13.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHijynbrNykDataSourceBean13.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHijynbrNykDataSourceBean13.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean13.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListHijynbrNykDataSourceBean13.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean13);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean14 = new BzSikinIdouListHijynbrNykDataSourceBean();
        bzSikinIdouListHijynbrNykDataSourceBean14.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean14.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean14.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHijynbrNykDataSourceBean14.setIrSeg1cd(null);
        bzSikinIdouListHijynbrNykDataSourceBean14.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean14.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListHijynbrNykDataSourceBean14.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean14);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean15 = new BzSikinIdouListHijynbrNykDataSourceBean();
        bzSikinIdouListHijynbrNykDataSourceBean15.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean15.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean15.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHijynbrNykDataSourceBean15.setIrSeg1cd(null);
        bzSikinIdouListHijynbrNykDataSourceBean15.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean15.setIrKeirisikinidoumeisaikbnnm("入金取消分");
        bzSikinIdouListHijynbrNykDataSourceBean15.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean15);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean16 = new BzSikinIdouListHijynbrNykDataSourceBean();
        bzSikinIdouListHijynbrNykDataSourceBean16.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean16.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean16.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHijynbrNykDataSourceBean16.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHijynbrNykDataSourceBean16.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean16.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListHijynbrNykDataSourceBean16.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean16);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean17 = new BzSikinIdouListHijynbrNykDataSourceBean();
        bzSikinIdouListHijynbrNykDataSourceBean17.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean17.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean17.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHijynbrNykDataSourceBean17.setIrSeg1cd(null);
        bzSikinIdouListHijynbrNykDataSourceBean17.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean17.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListHijynbrNykDataSourceBean17.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean17);

        BzSikinIdouListHijynbrNykDataSourceBean  bzSikinIdouListHijynbrNykDataSourceBean18 = new BzSikinIdouListHijynbrNykDataSourceBean();
        bzSikinIdouListHijynbrNykDataSourceBean18.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHijynbrNykDataSourceBean18.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean18.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHijynbrNykDataSourceBean18.setIrSeg1cd(null);
        bzSikinIdouListHijynbrNykDataSourceBean18.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean18.setIrKeirisikinidoumeisaikbnnm("入金取消分");
        bzSikinIdouListHijynbrNykDataSourceBean18.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListHijynbrNykDataSourceBean18.setIrKeiritrhktuukagkkei(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean18.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9.22));
        bzSikinIdouListHijynbrNykDataSourceBean18.setIrHijynnyksknidoutyuukimsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        dataSouceList.add(bzSikinIdouListHijynbrNykDataSourceBean18);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHijynbrNykBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}