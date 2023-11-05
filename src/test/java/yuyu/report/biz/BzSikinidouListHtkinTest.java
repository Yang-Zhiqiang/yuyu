package yuyu.report.biz;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzSikinIdouListHtkinBean;
import yuyu.def.biz.bean.report.BzSikinIdouListHtkinDataSourceBean;
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
 * 資金移動リスト（配当金分） 帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzSikinidouListHtkinTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzSikinIdouListHtkinBean bzSikinIdouListHtkinBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListHtkinTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_HTKIN);

        bzSikinIdouListHtkinBean.setIrSyoriymd(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean.setIrKeirisikinidougroupno(null);
        bzSikinIdouListHtkinDataSourceBean.setIrKeirisiteituukasyu(null);
        bzSikinIdouListHtkinDataSourceBean.setIrSeg1cd(null);
        bzSikinIdouListHtkinDataSourceBean.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListHtkinDataSourceBean.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListHtkinDataSourceBean.setIrKeiritrhktuukagk(null);

        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHtkinBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListHtkinTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_HTKIN);

        bzSikinIdouListHtkinBean.setIrSyoriymd("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListHtkinDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.BLNK);
        bzSikinIdouListHtkinDataSourceBean.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListHtkinDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListHtkinDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.BLNK);
        bzSikinIdouListHtkinDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(0));

        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHtkinBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListHtkinTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_HTKIN);

        bzSikinIdouListHtkinBean.setIrSyoriymd("2018年11月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean1 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHtkinDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListHtkinDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(1500));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean1);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean2 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHtkinDataSourceBean2.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(5000, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListHtkinDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(5500));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHtkinBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListHtkinTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_HTKIN);

        bzSikinIdouListHtkinBean.setIrSyoriymd("9999年12月31日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean1 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHtkinDataSourceBean1.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(999999999999999l));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean1);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean2 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHtkinDataSourceBean2.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(0));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHtkinBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListHtkinTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_HTKIN);

        bzSikinIdouListHtkinBean.setIrSyoriymd("2018年11月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean1 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHtkinDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListHtkinDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.1));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean1);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean2 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHtkinDataSourceBean2.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListHtkinDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(0));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean2);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean3 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean3.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean3.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHtkinDataSourceBean3.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean3.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.21, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean3.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean3.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean3);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean4 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean4.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean4.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHtkinDataSourceBean4.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean4.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean4.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean4.setIrKeiritrhktuukagk(BizCurrency.valueOf(0));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean4);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean5 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean5.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListHtkinDataSourceBean5.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHtkinDataSourceBean5.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean5.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.321, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean5.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean5.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.333));

        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean5);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean6 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean6.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListHtkinDataSourceBean6.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHtkinDataSourceBean6.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean6.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean6.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean6.setIrKeiritrhktuukagk(BizCurrency.valueOf(0));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean6);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHtkinBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListHtkinTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_HTKIN);

        bzSikinIdouListHtkinBean.setIrSyoriymd("2018年11月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean1 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHtkinDataSourceBean1.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(101, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(999));

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean2 = new BzSikinIdouListHtkinDataSourceBean();
        bzSikinIdouListHtkinDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHtkinDataSourceBean2.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(0));

        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean1);
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHtkinBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListHtkinTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_HTKIN);

        bzSikinIdouListHtkinBean.setIrSyoriymd("2010年10月24日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 33966; i++) {
            BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean = new BzSikinIdouListHtkinDataSourceBean();

            bzSikinIdouListHtkinDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
            bzSikinIdouListHtkinDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
            bzSikinIdouListHtkinDataSourceBean.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
            bzSikinIdouListHtkinDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
            bzSikinIdouListHtkinDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
            bzSikinIdouListHtkinDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(1));

            dataSouceList.add(bzSikinIdouListHtkinDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHtkinBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListHtkinTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_HTKIN);

        bzSikinIdouListHtkinBean.setIrSyoriymd("2018年11月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i <= 32; i++) {
            BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean = new BzSikinIdouListHtkinDataSourceBean();

            if (i%2 == 0) {

                bzSikinIdouListHtkinDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListHtkinDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListHtkinDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListHtkinDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(202));
                bzSikinIdouListHtkinDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListHtkinDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(2002));

            }
            else {
                bzSikinIdouListHtkinDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListHtkinDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListHtkinDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListHtkinDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(101));
                bzSikinIdouListHtkinDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListHtkinDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(1001));

            }

            dataSouceList.add(bzSikinIdouListHtkinDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHtkinBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListHtkinTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_HTKIN);

        bzSikinIdouListHtkinBean.setIrSyoriymd("2018年11月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i <= 34; i++) {
            BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean = new BzSikinIdouListHtkinDataSourceBean();

            if (i%2 == 0) {

                bzSikinIdouListHtkinDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListHtkinDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListHtkinDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListHtkinDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(202));
                bzSikinIdouListHtkinDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListHtkinDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(2002));

            }
            else {
                bzSikinIdouListHtkinDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListHtkinDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListHtkinDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListHtkinDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(101));
                bzSikinIdouListHtkinDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListHtkinDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(1001));

            }

            dataSouceList.add(bzSikinIdouListHtkinDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHtkinBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListHtkinTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_HTKIN);

        bzSikinIdouListHtkinBean.setIrSyoriymd("2018年11月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i <= 36; i++) {
            BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean = new BzSikinIdouListHtkinDataSourceBean();

            if (i%2 == 0) {

                bzSikinIdouListHtkinDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListHtkinDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListHtkinDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListHtkinDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(202));
                bzSikinIdouListHtkinDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListHtkinDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(2002));

            }
            else {
                bzSikinIdouListHtkinDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListHtkinDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListHtkinDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListHtkinDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(101));
                bzSikinIdouListHtkinDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListHtkinDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(1001));

            }

            dataSouceList.add(bzSikinIdouListHtkinDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHtkinBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListHtkinTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_HTKIN);

        bzSikinIdouListHtkinBean.setIrSyoriymd("2018年11月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHtkinBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListHtkinTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_HTKIN);

        bzSikinIdouListHtkinBean.setIrSyoriymd("2018年11月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean1 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHtkinDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListHtkinDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.1));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean1);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean2 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHtkinDataSourceBean2.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListHtkinDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(5));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean2);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean3 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean3.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean3.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHtkinDataSourceBean3.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListHtkinDataSourceBean3.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.3, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean3.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean3.setIrKeiritrhktuukagk(BizCurrency.valueOf(6));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean3);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean4 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean4.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean4.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHtkinDataSourceBean4.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean4.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.1, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean4.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean4.setIrKeiritrhktuukagk(BizCurrency.valueOf(6));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean4);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean5 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean5.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean5.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHtkinDataSourceBean5.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean5.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean5.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean5.setIrKeiritrhktuukagk(BizCurrency.valueOf(7));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean5);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean6 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean6.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean6.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHtkinDataSourceBean6.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean6.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.3, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean6.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean6.setIrKeiritrhktuukagk(BizCurrency.valueOf(8));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean6);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean7 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean7.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean7.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHtkinDataSourceBean7.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean7.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.4, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean7.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean7.setIrKeiritrhktuukagk(BizCurrency.valueOf(9));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean7);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean8 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean8.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean8.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHtkinDataSourceBean8.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListHtkinDataSourceBean8.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.5, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean8.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean8.setIrKeiritrhktuukagk(BizCurrency.valueOf(5));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean8);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean9 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean9.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean9.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListHtkinDataSourceBean9.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListHtkinDataSourceBean9.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.6, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean9.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean9.setIrKeiritrhktuukagk(BizCurrency.valueOf(8));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean9);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean10 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean10.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean10.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHtkinDataSourceBean10.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean10.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListHtkinDataSourceBean10.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean10.setIrKeiritrhktuukagk(BizCurrency.valueOf(5));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean10);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean11 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean11.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean11.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHtkinDataSourceBean11.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean11.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListHtkinDataSourceBean11.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean11.setIrKeiritrhktuukagk(BizCurrency.valueOf(6));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean11);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean12 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean12.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean12.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHtkinDataSourceBean12.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean12.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.3, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean12.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean12.setIrKeiritrhktuukagk(BizCurrency.valueOf(7));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean12);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean13 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean13.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean13.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHtkinDataSourceBean13.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean13.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.1, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean13.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean13.setIrKeiritrhktuukagk(BizCurrency.valueOf(5));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean13);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean14 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean14.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean14.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHtkinDataSourceBean14.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean14.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean14.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean14.setIrKeiritrhktuukagk(BizCurrency.valueOf(6));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean14);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean15 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean15.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean15.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHtkinDataSourceBean15.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListHtkinDataSourceBean15.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.3, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean15.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean15.setIrKeiritrhktuukagk(BizCurrency.valueOf(7));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean15);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean16 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean16.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean16.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHtkinDataSourceBean16.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListHtkinDataSourceBean16.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.1, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean16.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean16.setIrKeiritrhktuukagk(BizCurrency.valueOf(5));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean16);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean17 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean17.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean17.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHtkinDataSourceBean17.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListHtkinDataSourceBean17.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean17.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean17.setIrKeiritrhktuukagk(BizCurrency.valueOf(6));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean17);

        BzSikinIdouListHtkinDataSourceBean bzSikinIdouListHtkinDataSourceBean18 = new BzSikinIdouListHtkinDataSourceBean();

        bzSikinIdouListHtkinDataSourceBean18.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListHtkinDataSourceBean18.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListHtkinDataSourceBean18.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListHtkinDataSourceBean18.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.3, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListHtkinDataSourceBean18.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListHtkinDataSourceBean18.setIrKeiritrhktuukagk(BizCurrency.valueOf(7));
        dataSouceList.add(bzSikinIdouListHtkinDataSourceBean18);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListHtkinBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
