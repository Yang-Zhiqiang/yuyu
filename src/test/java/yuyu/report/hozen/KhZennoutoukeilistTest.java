package yuyu.report.hozen;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhZennouToukeiListBean;
import yuyu.def.hozen.bean.report.KhZennouToukeiListDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 前納統計リスト 帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhZennoutoukeilistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhZennouToukeiListBean khZennouToukeiListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoutoukeilistTest",
                C_SyoruiCdKbn.AS_ZENNOUTOUKEILIST);
        khZennouToukeiListBean.setIrSakuseiymd("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean.setIrZennoutoukeilistkbn("1");
        khZennouToukeiListDataSourceBean.setIrZennoutoukeilisttitle("");
        khZennouToukeiListDataSourceBean.setIrListkbnbtsyuukei("");
        khZennouToukeiListDataSourceBean.setIrZennoukbnbtsyuukei("");
        khZennouToukeiListDataSourceBean.setIrSegbetusyuukei("");
        khZennouToukeiListDataSourceBean.setIrZennoukbn("");
        khZennouToukeiListDataSourceBean.setIrKbnkeirisegcd("");
        khZennouToukeiListDataSourceBean.setIrZennoukaisiym(null);
        khZennouToukeiListDataSourceBean.setIrZennoutoukeilist(0);
        khZennouToukeiListDataSourceBean.setIrZennoukaisizndk(BizCurrency.valueOf(0));
        khZennouToukeiListDataSourceBean.setIrMkkp(BizCurrency.valueOf(0));
        khZennouToukeiListDataSourceBean.setIrZennoukaisizndkgaika(BizCurrency.valueOf(0,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean.setIrMkkpgaika(BizCurrency.valueOf(0,BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(khZennouToukeiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khZennouToukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoutoukeilistTest",
                C_SyoruiCdKbn.AS_ZENNOUTOUKEILIST);
        khZennouToukeiListBean.setIrSakuseiymd(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean.setIrZennoutoukeilistkbn("1");
        khZennouToukeiListDataSourceBean.setIrZennoutoukeilisttitle(null);
        khZennouToukeiListDataSourceBean.setIrListkbnbtsyuukei(null);
        khZennouToukeiListDataSourceBean.setIrZennoukbnbtsyuukei(null);
        khZennouToukeiListDataSourceBean.setIrSegbetusyuukei(null);
        khZennouToukeiListDataSourceBean.setIrZennoukbn(null);
        khZennouToukeiListDataSourceBean.setIrKbnkeirisegcd(null);
        khZennouToukeiListDataSourceBean.setIrZennoukaisiym(null);
        khZennouToukeiListDataSourceBean.setIrZennoutoukeilist(null);
        khZennouToukeiListDataSourceBean.setIrZennoukaisizndk(null);
        khZennouToukeiListDataSourceBean.setIrMkkp(null);
        khZennouToukeiListDataSourceBean.setIrZennoukaisizndkgaika(null);
        khZennouToukeiListDataSourceBean.setIrMkkpgaika(null);

        dataSouceList.add(khZennouToukeiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khZennouToukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoutoukeilistTest",
                C_SyoruiCdKbn.AS_ZENNOUTOUKEILIST);
        khZennouToukeiListBean.setIrSakuseiymd("2018年 2月 2日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 19; i++) {
            KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean = new KhZennouToukeiListDataSourceBean();

            khZennouToukeiListDataSourceBean.setIrZennoutoukeilistkbn("1");
            khZennouToukeiListDataSourceBean.setIrZennoutoukeilisttitle("＊＊＊前納未経過Ｐリスト＊＊＊");
            khZennouToukeiListDataSourceBean.setIrListkbnbtsyuukei("1合計");
            khZennouToukeiListDataSourceBean.setIrZennoukbnbtsyuukei("2合計");
            khZennouToukeiListDataSourceBean.setIrSegbetusyuukei("1111合計");
            khZennouToukeiListDataSourceBean.setIrZennoukbn("1");
            khZennouToukeiListDataSourceBean.setIrKbnkeirisegcd("2801");
            khZennouToukeiListDataSourceBean.setIrZennoukaisiym(BizDateYM.valueOf(201904));
            khZennouToukeiListDataSourceBean.setIrZennoutoukeilist(100);
            khZennouToukeiListDataSourceBean.setIrZennoukaisizndk(BizCurrency.valueOf(101));
            khZennouToukeiListDataSourceBean.setIrMkkp(BizCurrency.valueOf(102));
            khZennouToukeiListDataSourceBean.setIrZennoukaisizndkgaika(BizCurrency.valueOf(103,BizCurrencyTypes.AU_DOLLAR));
            khZennouToukeiListDataSourceBean.setIrMkkpgaika(BizCurrency.valueOf(104,BizCurrencyTypes.AU_DOLLAR));

            dataSouceList.add(khZennouToukeiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khZennouToukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoutoukeilistTest",
                C_SyoruiCdKbn.AS_ZENNOUTOUKEILIST);
        khZennouToukeiListBean.setIrSakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 20; i++) {
            KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean = new KhZennouToukeiListDataSourceBean();

            khZennouToukeiListDataSourceBean.setIrZennoutoukeilistkbn("1");
            khZennouToukeiListDataSourceBean.setIrZennoutoukeilisttitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khZennouToukeiListDataSourceBean.setIrListkbnbtsyuukei("ＷＷＷ");
            khZennouToukeiListDataSourceBean.setIrZennoukbnbtsyuukei("ＷＷＷ");
            khZennouToukeiListDataSourceBean.setIrSegbetusyuukei("ＷＷＷＷＷＷ");
            khZennouToukeiListDataSourceBean.setIrZennoukbn("w");
            khZennouToukeiListDataSourceBean.setIrKbnkeirisegcd("wwww");
            khZennouToukeiListDataSourceBean.setIrZennoukaisiym(BizDateYM.valueOf(999912));
            khZennouToukeiListDataSourceBean.setIrZennoutoukeilist(9999999);
            khZennouToukeiListDataSourceBean.setIrZennoukaisizndk(BizCurrency.valueOf(9999999999999L));
            khZennouToukeiListDataSourceBean.setIrMkkp(BizCurrency.valueOf(9999999999999L));
            khZennouToukeiListDataSourceBean.setIrZennoukaisizndkgaika(BizCurrency.valueOf(99999999999.99,BizCurrencyTypes.AU_DOLLAR));
            khZennouToukeiListDataSourceBean.setIrMkkpgaika(BizCurrency.valueOf(99999999999.99,BizCurrencyTypes.AU_DOLLAR));

            dataSouceList.add(khZennouToukeiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khZennouToukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoutoukeilistTest",
                C_SyoruiCdKbn.AS_ZENNOUTOUKEILIST);
        khZennouToukeiListBean.setIrSakuseiymd("2018年 2月 2日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 21; i++) {
            KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean = new KhZennouToukeiListDataSourceBean();

            khZennouToukeiListDataSourceBean.setIrZennoutoukeilistkbn("1");
            khZennouToukeiListDataSourceBean.setIrZennoutoukeilisttitle("＊＊＊前納未経過Ｐリスト＊＊＊");
            khZennouToukeiListDataSourceBean.setIrListkbnbtsyuukei("1合計");
            khZennouToukeiListDataSourceBean.setIrZennoukbnbtsyuukei("2合計");
            khZennouToukeiListDataSourceBean.setIrSegbetusyuukei("1111合計");
            khZennouToukeiListDataSourceBean.setIrZennoukbn("1");
            khZennouToukeiListDataSourceBean.setIrKbnkeirisegcd("2801");
            khZennouToukeiListDataSourceBean.setIrZennoukaisiym(BizDateYM.valueOf(201904));
            khZennouToukeiListDataSourceBean.setIrZennoutoukeilist(1000);
            khZennouToukeiListDataSourceBean.setIrZennoukaisizndk(BizCurrency.valueOf(1001));
            khZennouToukeiListDataSourceBean.setIrMkkp(BizCurrency.valueOf(1002));
            khZennouToukeiListDataSourceBean.setIrZennoukaisizndkgaika(BizCurrency.valueOf(1003,BizCurrencyTypes.AU_DOLLAR));
            khZennouToukeiListDataSourceBean.setIrMkkpgaika(BizCurrency.valueOf(1004,BizCurrencyTypes.AU_DOLLAR));

            dataSouceList.add(khZennouToukeiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khZennouToukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoutoukeilistTest",
                C_SyoruiCdKbn.AS_ZENNOUTOUKEILIST);
        khZennouToukeiListBean.setIrSakuseiymd("2018年 2月 2日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean1 = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean1.setIrZennoutoukeilistkbn("1");
        khZennouToukeiListDataSourceBean1.setIrZennoutoukeilisttitle("＊＊＊前納未経過Ｐリスト＊＊＊");
        khZennouToukeiListDataSourceBean1.setIrListkbnbtsyuukei("");
        khZennouToukeiListDataSourceBean1.setIrZennoukbnbtsyuukei("");
        khZennouToukeiListDataSourceBean1.setIrSegbetusyuukei("");
        khZennouToukeiListDataSourceBean1.setIrZennoukbn("1");
        khZennouToukeiListDataSourceBean1.setIrKbnkeirisegcd("1111");
        khZennouToukeiListDataSourceBean1.setIrZennoukaisiym(BizDateYM.valueOf(202005));
        khZennouToukeiListDataSourceBean1.setIrZennoutoukeilist(100);
        khZennouToukeiListDataSourceBean1.setIrZennoukaisizndk(BizCurrency.valueOf(1000));
        khZennouToukeiListDataSourceBean1.setIrMkkp(BizCurrency.valueOf(10000));
        khZennouToukeiListDataSourceBean1.setIrZennoukaisizndkgaika(BizCurrency.valueOf(1000,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean1.setIrMkkpgaika(BizCurrency.valueOf(10000,BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(khZennouToukeiListDataSourceBean1);

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean2 = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean2.setIrZennoutoukeilistkbn("1");
        khZennouToukeiListDataSourceBean2.setIrZennoutoukeilisttitle("＊＊＊前納未経過Ｐリスト＊＊＊");
        khZennouToukeiListDataSourceBean2.setIrListkbnbtsyuukei("");
        khZennouToukeiListDataSourceBean2.setIrZennoukbnbtsyuukei("");
        khZennouToukeiListDataSourceBean2.setIrSegbetusyuukei("1111合計");
        khZennouToukeiListDataSourceBean2.setIrZennoukbn("");
        khZennouToukeiListDataSourceBean2.setIrKbnkeirisegcd("");
        khZennouToukeiListDataSourceBean2.setIrZennoukaisiym(null);
        khZennouToukeiListDataSourceBean2.setIrZennoutoukeilist(100);
        khZennouToukeiListDataSourceBean2.setIrZennoukaisizndk(BizCurrency.valueOf(1000));
        khZennouToukeiListDataSourceBean2.setIrMkkp(BizCurrency.valueOf(10000));
        khZennouToukeiListDataSourceBean2.setIrZennoukaisizndkgaika(BizCurrency.valueOf(1000,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean2.setIrMkkpgaika(BizCurrency.valueOf(10000,BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(khZennouToukeiListDataSourceBean2);

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean3 = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean3.setIrZennoutoukeilistkbn("1");
        khZennouToukeiListDataSourceBean3.setIrZennoutoukeilisttitle("＊＊＊前納未経過Ｐリスト＊＊＊");
        khZennouToukeiListDataSourceBean3.setIrListkbnbtsyuukei("");
        khZennouToukeiListDataSourceBean3.setIrZennoukbnbtsyuukei("");
        khZennouToukeiListDataSourceBean3.setIrSegbetusyuukei("");
        khZennouToukeiListDataSourceBean3.setIrZennoukbn("1");
        khZennouToukeiListDataSourceBean3.setIrKbnkeirisegcd("2222");
        khZennouToukeiListDataSourceBean3.setIrZennoukaisiym(BizDateYM.valueOf(202005));
        khZennouToukeiListDataSourceBean3.setIrZennoutoukeilist(200);
        khZennouToukeiListDataSourceBean3.setIrZennoukaisizndk(BizCurrency.valueOf(2000));
        khZennouToukeiListDataSourceBean3.setIrMkkp(BizCurrency.valueOf(20000));
        khZennouToukeiListDataSourceBean3.setIrZennoukaisizndkgaika(BizCurrency.valueOf(2000,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean3.setIrMkkpgaika(BizCurrency.valueOf(20000,BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(khZennouToukeiListDataSourceBean3);

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean4 = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean4.setIrZennoutoukeilistkbn("1");
        khZennouToukeiListDataSourceBean4.setIrZennoutoukeilisttitle("＊＊＊前納未経過Ｐリスト＊＊＊");
        khZennouToukeiListDataSourceBean4.setIrListkbnbtsyuukei("");
        khZennouToukeiListDataSourceBean4.setIrZennoukbnbtsyuukei("");
        khZennouToukeiListDataSourceBean4.setIrSegbetusyuukei("2222合計");
        khZennouToukeiListDataSourceBean4.setIrZennoukbn("");
        khZennouToukeiListDataSourceBean4.setIrKbnkeirisegcd("");
        khZennouToukeiListDataSourceBean4.setIrZennoukaisiym(null);
        khZennouToukeiListDataSourceBean4.setIrZennoutoukeilist(200);
        khZennouToukeiListDataSourceBean4.setIrZennoukaisizndk(BizCurrency.valueOf(2000));
        khZennouToukeiListDataSourceBean4.setIrMkkp(BizCurrency.valueOf(20000));
        khZennouToukeiListDataSourceBean4.setIrZennoukaisizndkgaika(BizCurrency.valueOf(2000,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean4.setIrMkkpgaika(BizCurrency.valueOf(20000,BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(khZennouToukeiListDataSourceBean4);

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean5 = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean5.setIrZennoutoukeilistkbn("1");
        khZennouToukeiListDataSourceBean5.setIrZennoutoukeilisttitle("＊＊＊前納未経過Ｐリスト＊＊＊");
        khZennouToukeiListDataSourceBean5.setIrListkbnbtsyuukei("");
        khZennouToukeiListDataSourceBean5.setIrZennoukbnbtsyuukei("1合計");
        khZennouToukeiListDataSourceBean5.setIrSegbetusyuukei("");
        khZennouToukeiListDataSourceBean5.setIrZennoukbn("");
        khZennouToukeiListDataSourceBean5.setIrKbnkeirisegcd("");
        khZennouToukeiListDataSourceBean5.setIrZennoukaisiym(null);
        khZennouToukeiListDataSourceBean5.setIrZennoutoukeilist(300);
        khZennouToukeiListDataSourceBean5.setIrZennoukaisizndk(BizCurrency.valueOf(3000));
        khZennouToukeiListDataSourceBean5.setIrMkkp(BizCurrency.valueOf(30000));
        khZennouToukeiListDataSourceBean5.setIrZennoukaisizndkgaika(BizCurrency.valueOf(3000,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean5.setIrMkkpgaika(BizCurrency.valueOf(30000,BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(khZennouToukeiListDataSourceBean5);

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean6 = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean6.setIrZennoutoukeilistkbn("1");
        khZennouToukeiListDataSourceBean6.setIrZennoutoukeilisttitle("＊＊＊前納未経過Ｐリスト＊＊＊");
        khZennouToukeiListDataSourceBean6.setIrListkbnbtsyuukei("");
        khZennouToukeiListDataSourceBean6.setIrZennoukbnbtsyuukei("");
        khZennouToukeiListDataSourceBean6.setIrSegbetusyuukei("");
        khZennouToukeiListDataSourceBean6.setIrZennoukbn("1");
        khZennouToukeiListDataSourceBean6.setIrKbnkeirisegcd("2222");
        khZennouToukeiListDataSourceBean6.setIrZennoukaisiym(BizDateYM.valueOf(202005));
        khZennouToukeiListDataSourceBean6.setIrZennoutoukeilist(301);
        khZennouToukeiListDataSourceBean6.setIrZennoukaisizndk(BizCurrency.valueOf(3001));
        khZennouToukeiListDataSourceBean6.setIrMkkp(BizCurrency.valueOf(30001));
        khZennouToukeiListDataSourceBean6.setIrZennoukaisizndkgaika(BizCurrency.valueOf(3001,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean6.setIrMkkpgaika(BizCurrency.valueOf(30001,BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(khZennouToukeiListDataSourceBean6);

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean7 = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean7.setIrZennoutoukeilistkbn("1");
        khZennouToukeiListDataSourceBean7.setIrZennoutoukeilisttitle("＊＊＊前納未経過Ｐリスト＊＊＊");
        khZennouToukeiListDataSourceBean7.setIrListkbnbtsyuukei("");
        khZennouToukeiListDataSourceBean7.setIrZennoukbnbtsyuukei("");
        khZennouToukeiListDataSourceBean7.setIrSegbetusyuukei("2222合計");
        khZennouToukeiListDataSourceBean7.setIrZennoukbn("");
        khZennouToukeiListDataSourceBean7.setIrKbnkeirisegcd("");
        khZennouToukeiListDataSourceBean7.setIrZennoukaisiym(null);
        khZennouToukeiListDataSourceBean7.setIrZennoutoukeilist(301);
        khZennouToukeiListDataSourceBean7.setIrZennoukaisizndk(BizCurrency.valueOf(3001));
        khZennouToukeiListDataSourceBean7.setIrMkkp(BizCurrency.valueOf(30001));
        khZennouToukeiListDataSourceBean7.setIrZennoukaisizndkgaika(BizCurrency.valueOf(3001,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean7.setIrMkkpgaika(BizCurrency.valueOf(30001,BizCurrencyTypes.AU_DOLLAR));


        dataSouceList.add(khZennouToukeiListDataSourceBean7);

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean8 = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean8.setIrZennoutoukeilistkbn("1");
        khZennouToukeiListDataSourceBean8.setIrZennoutoukeilisttitle("＊＊＊前納未経過Ｐリスト＊＊＊");
        khZennouToukeiListDataSourceBean8.setIrListkbnbtsyuukei("");
        khZennouToukeiListDataSourceBean8.setIrZennoukbnbtsyuukei("2合計");
        khZennouToukeiListDataSourceBean8.setIrSegbetusyuukei("");
        khZennouToukeiListDataSourceBean8.setIrZennoukbn("");
        khZennouToukeiListDataSourceBean8.setIrKbnkeirisegcd("");
        khZennouToukeiListDataSourceBean8.setIrZennoukaisiym(null);
        khZennouToukeiListDataSourceBean8.setIrZennoutoukeilist(301);
        khZennouToukeiListDataSourceBean8.setIrZennoukaisizndk(BizCurrency.valueOf(3001));
        khZennouToukeiListDataSourceBean8.setIrMkkp(BizCurrency.valueOf(30001));
        khZennouToukeiListDataSourceBean8.setIrZennoukaisizndkgaika(BizCurrency.valueOf(3001,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean8.setIrMkkpgaika(BizCurrency.valueOf(30001,BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(khZennouToukeiListDataSourceBean8);

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean9 = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean9.setIrZennoutoukeilistkbn("3");
        khZennouToukeiListDataSourceBean9.setIrZennoutoukeilisttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
        khZennouToukeiListDataSourceBean9.setIrListkbnbtsyuukei("");
        khZennouToukeiListDataSourceBean9.setIrZennoukbnbtsyuukei("");
        khZennouToukeiListDataSourceBean9.setIrSegbetusyuukei("");
        khZennouToukeiListDataSourceBean9.setIrZennoukbn("1");
        khZennouToukeiListDataSourceBean9.setIrKbnkeirisegcd("1111");
        khZennouToukeiListDataSourceBean9.setIrZennoukaisiym(BizDateYM.valueOf(202005));
        khZennouToukeiListDataSourceBean9.setIrZennoutoukeilist(100);
        khZennouToukeiListDataSourceBean9.setIrZennoukaisizndk(BizCurrency.valueOf(1000));
        khZennouToukeiListDataSourceBean9.setIrMkkp(BizCurrency.valueOf(10000));
        khZennouToukeiListDataSourceBean9.setIrZennoukaisizndkgaika(BizCurrency.valueOf(1000,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean9.setIrMkkpgaika(BizCurrency.valueOf(10000,BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(khZennouToukeiListDataSourceBean9);

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean10 = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean10.setIrZennoutoukeilistkbn("3");
        khZennouToukeiListDataSourceBean10.setIrZennoutoukeilisttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
        khZennouToukeiListDataSourceBean10.setIrListkbnbtsyuukei("");
        khZennouToukeiListDataSourceBean10.setIrZennoukbnbtsyuukei("");
        khZennouToukeiListDataSourceBean10.setIrSegbetusyuukei("1111合計");
        khZennouToukeiListDataSourceBean10.setIrZennoukbn("");
        khZennouToukeiListDataSourceBean10.setIrKbnkeirisegcd("");
        khZennouToukeiListDataSourceBean10.setIrZennoukaisiym(null);
        khZennouToukeiListDataSourceBean10.setIrZennoutoukeilist(100);
        khZennouToukeiListDataSourceBean10.setIrZennoukaisizndk(BizCurrency.valueOf(1000));
        khZennouToukeiListDataSourceBean10.setIrMkkp(BizCurrency.valueOf(10000));
        khZennouToukeiListDataSourceBean10.setIrZennoukaisizndkgaika(BizCurrency.valueOf(1000,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean10.setIrMkkpgaika(BizCurrency.valueOf(10000,BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(khZennouToukeiListDataSourceBean10);

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean11 = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean11.setIrZennoutoukeilistkbn("3");
        khZennouToukeiListDataSourceBean11.setIrZennoutoukeilisttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
        khZennouToukeiListDataSourceBean11.setIrListkbnbtsyuukei("");
        khZennouToukeiListDataSourceBean11.setIrZennoukbnbtsyuukei("");
        khZennouToukeiListDataSourceBean11.setIrSegbetusyuukei("");
        khZennouToukeiListDataSourceBean11.setIrZennoukbn("1");
        khZennouToukeiListDataSourceBean11.setIrKbnkeirisegcd("2222");
        khZennouToukeiListDataSourceBean11.setIrZennoukaisiym(BizDateYM.valueOf(202005));
        khZennouToukeiListDataSourceBean11.setIrZennoutoukeilist(200);
        khZennouToukeiListDataSourceBean11.setIrZennoukaisizndk(BizCurrency.valueOf(2000));
        khZennouToukeiListDataSourceBean11.setIrMkkp(BizCurrency.valueOf(20000));
        khZennouToukeiListDataSourceBean11.setIrZennoukaisizndkgaika(BizCurrency.valueOf(2000,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean11.setIrMkkpgaika(BizCurrency.valueOf(20000,BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(khZennouToukeiListDataSourceBean11);

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean12 = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean12.setIrZennoutoukeilistkbn("3");
        khZennouToukeiListDataSourceBean12.setIrZennoutoukeilisttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
        khZennouToukeiListDataSourceBean12.setIrListkbnbtsyuukei("");
        khZennouToukeiListDataSourceBean12.setIrZennoukbnbtsyuukei("");
        khZennouToukeiListDataSourceBean12.setIrSegbetusyuukei("2222合計");
        khZennouToukeiListDataSourceBean12.setIrZennoukbn("");
        khZennouToukeiListDataSourceBean12.setIrKbnkeirisegcd("");
        khZennouToukeiListDataSourceBean12.setIrZennoukaisiym(null);
        khZennouToukeiListDataSourceBean12.setIrZennoutoukeilist(200);
        khZennouToukeiListDataSourceBean12.setIrZennoukaisizndk(BizCurrency.valueOf(2000));
        khZennouToukeiListDataSourceBean12.setIrMkkp(BizCurrency.valueOf(20000));
        khZennouToukeiListDataSourceBean12.setIrZennoukaisizndkgaika(BizCurrency.valueOf(2000,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean12.setIrMkkpgaika(BizCurrency.valueOf(20000,BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(khZennouToukeiListDataSourceBean12);

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean13 = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean13.setIrZennoutoukeilistkbn("3");
        khZennouToukeiListDataSourceBean13.setIrZennoutoukeilisttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
        khZennouToukeiListDataSourceBean13.setIrListkbnbtsyuukei("");
        khZennouToukeiListDataSourceBean13.setIrZennoukbnbtsyuukei("1合計");
        khZennouToukeiListDataSourceBean13.setIrSegbetusyuukei("");
        khZennouToukeiListDataSourceBean13.setIrZennoukbn("");
        khZennouToukeiListDataSourceBean13.setIrKbnkeirisegcd("");
        khZennouToukeiListDataSourceBean13.setIrZennoukaisiym(null);
        khZennouToukeiListDataSourceBean13.setIrZennoutoukeilist(300);
        khZennouToukeiListDataSourceBean13.setIrZennoukaisizndk(BizCurrency.valueOf(3000));
        khZennouToukeiListDataSourceBean13.setIrMkkp(BizCurrency.valueOf(30000));
        khZennouToukeiListDataSourceBean13.setIrZennoukaisizndkgaika(BizCurrency.valueOf(3000,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean13.setIrMkkpgaika(BizCurrency.valueOf(30000,BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(khZennouToukeiListDataSourceBean13);

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean14 = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean14.setIrZennoutoukeilistkbn("3");
        khZennouToukeiListDataSourceBean14.setIrZennoutoukeilisttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
        khZennouToukeiListDataSourceBean14.setIrListkbnbtsyuukei("");
        khZennouToukeiListDataSourceBean14.setIrZennoukbnbtsyuukei("");
        khZennouToukeiListDataSourceBean14.setIrSegbetusyuukei("");
        khZennouToukeiListDataSourceBean14.setIrZennoukbn("1");
        khZennouToukeiListDataSourceBean14.setIrKbnkeirisegcd("2222");
        khZennouToukeiListDataSourceBean14.setIrZennoukaisiym(BizDateYM.valueOf(202005));
        khZennouToukeiListDataSourceBean14.setIrZennoutoukeilist(301);
        khZennouToukeiListDataSourceBean14.setIrZennoukaisizndk(BizCurrency.valueOf(3001));
        khZennouToukeiListDataSourceBean14.setIrMkkp(BizCurrency.valueOf(30001));
        khZennouToukeiListDataSourceBean14.setIrZennoukaisizndkgaika(BizCurrency.valueOf(3001,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean14.setIrMkkpgaika(BizCurrency.valueOf(30001,BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(khZennouToukeiListDataSourceBean14);

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean15 = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean15.setIrZennoutoukeilistkbn("3");
        khZennouToukeiListDataSourceBean15.setIrZennoutoukeilisttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
        khZennouToukeiListDataSourceBean15.setIrListkbnbtsyuukei("");
        khZennouToukeiListDataSourceBean15.setIrZennoukbnbtsyuukei("");
        khZennouToukeiListDataSourceBean15.setIrSegbetusyuukei("2222合計");
        khZennouToukeiListDataSourceBean15.setIrZennoukbn("");
        khZennouToukeiListDataSourceBean15.setIrKbnkeirisegcd("");
        khZennouToukeiListDataSourceBean15.setIrZennoukaisiym(null);
        khZennouToukeiListDataSourceBean15.setIrZennoutoukeilist(301);
        khZennouToukeiListDataSourceBean15.setIrZennoukaisizndk(BizCurrency.valueOf(3001));
        khZennouToukeiListDataSourceBean15.setIrMkkp(BizCurrency.valueOf(30001));
        khZennouToukeiListDataSourceBean15.setIrZennoukaisizndkgaika(BizCurrency.valueOf(3001,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean15.setIrMkkpgaika(BizCurrency.valueOf(30001,BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(khZennouToukeiListDataSourceBean15);

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean16 = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean16.setIrZennoutoukeilistkbn("3");
        khZennouToukeiListDataSourceBean16.setIrZennoutoukeilisttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
        khZennouToukeiListDataSourceBean16.setIrListkbnbtsyuukei("");
        khZennouToukeiListDataSourceBean16.setIrZennoukbnbtsyuukei("2合計");
        khZennouToukeiListDataSourceBean16.setIrSegbetusyuukei("");
        khZennouToukeiListDataSourceBean16.setIrZennoukbn("");
        khZennouToukeiListDataSourceBean16.setIrKbnkeirisegcd("");
        khZennouToukeiListDataSourceBean16.setIrZennoukaisiym(null);
        khZennouToukeiListDataSourceBean16.setIrZennoutoukeilist(301);
        khZennouToukeiListDataSourceBean16.setIrZennoukaisizndk(BizCurrency.valueOf(3001));
        khZennouToukeiListDataSourceBean16.setIrMkkp(BizCurrency.valueOf(30001));
        khZennouToukeiListDataSourceBean16.setIrZennoukaisizndkgaika(BizCurrency.valueOf(3001,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean16.setIrMkkpgaika(BizCurrency.valueOf(30001,BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(khZennouToukeiListDataSourceBean16);

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean17 = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean17.setIrZennoutoukeilistkbn("0");
        khZennouToukeiListDataSourceBean17.setIrZennoutoukeilisttitle("＊＊＊リスト区分別集計結果＊＊＊");
        khZennouToukeiListDataSourceBean17.setIrListkbnbtsyuukei("1合計");
        khZennouToukeiListDataSourceBean17.setIrZennoukbnbtsyuukei("");
        khZennouToukeiListDataSourceBean17.setIrSegbetusyuukei("");
        khZennouToukeiListDataSourceBean17.setIrZennoukbn("");
        khZennouToukeiListDataSourceBean17.setIrKbnkeirisegcd("");
        khZennouToukeiListDataSourceBean17.setIrZennoukaisiym(null);
        khZennouToukeiListDataSourceBean17.setIrZennoutoukeilist(600);
        khZennouToukeiListDataSourceBean17.setIrZennoukaisizndk(BizCurrency.valueOf(6000));
        khZennouToukeiListDataSourceBean17.setIrMkkp(BizCurrency.valueOf(60000));
        khZennouToukeiListDataSourceBean17.setIrZennoukaisizndkgaika(BizCurrency.valueOf(6000,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean17.setIrMkkpgaika(BizCurrency.valueOf(60000,BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(khZennouToukeiListDataSourceBean17);

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean18 = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean18.setIrZennoutoukeilistkbn("0");
        khZennouToukeiListDataSourceBean18.setIrZennoutoukeilisttitle("＊＊＊リスト区分別集計結果＊＊＊");
        khZennouToukeiListDataSourceBean18.setIrListkbnbtsyuukei("2合計");
        khZennouToukeiListDataSourceBean18.setIrZennoukbnbtsyuukei("");
        khZennouToukeiListDataSourceBean18.setIrSegbetusyuukei("");
        khZennouToukeiListDataSourceBean18.setIrZennoukbn("");
        khZennouToukeiListDataSourceBean18.setIrKbnkeirisegcd("");
        khZennouToukeiListDataSourceBean18.setIrZennoukaisiym(null);
        khZennouToukeiListDataSourceBean18.setIrZennoutoukeilist(0);
        khZennouToukeiListDataSourceBean18.setIrZennoukaisizndk(BizCurrency.valueOf(0));
        khZennouToukeiListDataSourceBean18.setIrMkkp(BizCurrency.valueOf(0));
        khZennouToukeiListDataSourceBean18.setIrZennoukaisizndkgaika(BizCurrency.valueOf(0,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean18.setIrMkkpgaika(BizCurrency.valueOf(0,BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(khZennouToukeiListDataSourceBean18);

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean19 = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean19.setIrZennoutoukeilistkbn("0");
        khZennouToukeiListDataSourceBean19.setIrZennoutoukeilisttitle("＊＊＊リスト区分別集計結果＊＊＊");
        khZennouToukeiListDataSourceBean19.setIrListkbnbtsyuukei("3合計");
        khZennouToukeiListDataSourceBean19.setIrZennoukbnbtsyuukei("");
        khZennouToukeiListDataSourceBean19.setIrSegbetusyuukei("");
        khZennouToukeiListDataSourceBean19.setIrZennoukbn("");
        khZennouToukeiListDataSourceBean19.setIrKbnkeirisegcd("");
        khZennouToukeiListDataSourceBean19.setIrZennoukaisiym(null);
        khZennouToukeiListDataSourceBean19.setIrZennoutoukeilist(602);
        khZennouToukeiListDataSourceBean19.setIrZennoukaisizndk(BizCurrency.valueOf(6002));
        khZennouToukeiListDataSourceBean19.setIrMkkp(BizCurrency.valueOf(60002));
        khZennouToukeiListDataSourceBean19.setIrZennoukaisizndkgaika(BizCurrency.valueOf(6002,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean19.setIrMkkpgaika(BizCurrency.valueOf(60002,BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(khZennouToukeiListDataSourceBean19);

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean20 = new KhZennouToukeiListDataSourceBean();

        khZennouToukeiListDataSourceBean20.setIrZennoutoukeilistkbn("0");
        khZennouToukeiListDataSourceBean20.setIrZennoutoukeilisttitle("＊＊＊リスト区分別集計結果＊＊＊");
        khZennouToukeiListDataSourceBean20.setIrListkbnbtsyuukei("総合計");
        khZennouToukeiListDataSourceBean20.setIrZennoukbnbtsyuukei("");
        khZennouToukeiListDataSourceBean20.setIrSegbetusyuukei("");
        khZennouToukeiListDataSourceBean20.setIrZennoukbn("");
        khZennouToukeiListDataSourceBean20.setIrKbnkeirisegcd("");
        khZennouToukeiListDataSourceBean20.setIrZennoukaisiym(null);
        khZennouToukeiListDataSourceBean20.setIrZennoutoukeilist(1202);
        khZennouToukeiListDataSourceBean20.setIrZennoukaisizndk(BizCurrency.valueOf(12002));
        khZennouToukeiListDataSourceBean20.setIrMkkp(BizCurrency.valueOf(120002));
        khZennouToukeiListDataSourceBean20.setIrZennoukaisizndkgaika(BizCurrency.valueOf(12002,BizCurrencyTypes.AU_DOLLAR));
        khZennouToukeiListDataSourceBean20.setIrMkkpgaika(BizCurrency.valueOf(120002,BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(khZennouToukeiListDataSourceBean20);
        reportTestBean.addParamObjects(dataSouceList, khZennouToukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoutoukeilistTest",
                C_SyoruiCdKbn.AS_ZENNOUTOUKEILIST);
        khZennouToukeiListBean.setIrSakuseiymd("2018年 2月 2日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 2000; i++) {
            KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean = new KhZennouToukeiListDataSourceBean();

            khZennouToukeiListDataSourceBean.setIrZennoutoukeilistkbn("1");
            khZennouToukeiListDataSourceBean.setIrZennoutoukeilisttitle("＊＊＊前納未経過Ｐリスト＊＊＊");
            khZennouToukeiListDataSourceBean.setIrListkbnbtsyuukei("1合計");
            khZennouToukeiListDataSourceBean.setIrZennoukbnbtsyuukei("2合計");
            khZennouToukeiListDataSourceBean.setIrSegbetusyuukei("1111合計");
            khZennouToukeiListDataSourceBean.setIrZennoukbn("1");
            khZennouToukeiListDataSourceBean.setIrKbnkeirisegcd("2801");
            khZennouToukeiListDataSourceBean.setIrZennoukaisiym(BizDateYM.valueOf(201904));
            khZennouToukeiListDataSourceBean.setIrZennoutoukeilist(100);
            khZennouToukeiListDataSourceBean.setIrZennoukaisizndk(BizCurrency.valueOf(101));
            khZennouToukeiListDataSourceBean.setIrMkkp(BizCurrency.valueOf(102));
            khZennouToukeiListDataSourceBean.setIrZennoukaisizndkgaika(BizCurrency.valueOf(9.1,BizCurrencyTypes.AU_DOLLAR));
            khZennouToukeiListDataSourceBean.setIrMkkpgaika(BizCurrency.valueOf(9.2,BizCurrencyTypes.AU_DOLLAR));

            dataSouceList.add(khZennouToukeiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khZennouToukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }



    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoutoukeilistTest",
                C_SyoruiCdKbn.AS_ZENNOUTOUKEILIST);
        khZennouToukeiListBean.setIrSakuseiymd("2018年 2月 2日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 20000; i++) {
            KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean = new KhZennouToukeiListDataSourceBean();

            khZennouToukeiListDataSourceBean.setIrZennoutoukeilistkbn("1");
            khZennouToukeiListDataSourceBean.setIrZennoutoukeilisttitle("＊＊＊前納未経過Ｐリスト＊＊＊");
            khZennouToukeiListDataSourceBean.setIrListkbnbtsyuukei("1合計");
            khZennouToukeiListDataSourceBean.setIrZennoukbnbtsyuukei("2合計");
            khZennouToukeiListDataSourceBean.setIrSegbetusyuukei("1111合計");
            khZennouToukeiListDataSourceBean.setIrZennoukbn("1");
            khZennouToukeiListDataSourceBean.setIrKbnkeirisegcd("2801");
            khZennouToukeiListDataSourceBean.setIrZennoukaisiym(BizDateYM.valueOf(201904));
            khZennouToukeiListDataSourceBean.setIrZennoutoukeilist(100);
            khZennouToukeiListDataSourceBean.setIrZennoukaisizndk(BizCurrency.valueOf(101));
            khZennouToukeiListDataSourceBean.setIrMkkp(BizCurrency.valueOf(102));
            khZennouToukeiListDataSourceBean.setIrZennoukaisizndkgaika(BizCurrency.valueOf(9.11,BizCurrencyTypes.AU_DOLLAR));
            khZennouToukeiListDataSourceBean.setIrMkkpgaika(BizCurrency.valueOf(9.22,BizCurrencyTypes.AU_DOLLAR));

            dataSouceList.add(khZennouToukeiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khZennouToukeiListBean);

        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoutoukeilistTest",
                C_SyoruiCdKbn.AS_ZENNOUTOUKEILIST);
        khZennouToukeiListBean.setIrSakuseiymd("2018年 2月 2日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 200000; i++) {
            KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean = new KhZennouToukeiListDataSourceBean();

            khZennouToukeiListDataSourceBean.setIrZennoutoukeilistkbn("1");
            khZennouToukeiListDataSourceBean.setIrZennoutoukeilisttitle("＊＊＊前納未経過Ｐリスト＊＊＊");
            khZennouToukeiListDataSourceBean.setIrListkbnbtsyuukei("1合計");
            khZennouToukeiListDataSourceBean.setIrZennoukbnbtsyuukei("2合計");
            khZennouToukeiListDataSourceBean.setIrSegbetusyuukei("1111合計");
            khZennouToukeiListDataSourceBean.setIrZennoukbn("1");
            khZennouToukeiListDataSourceBean.setIrKbnkeirisegcd("2801");
            khZennouToukeiListDataSourceBean.setIrZennoukaisiym(BizDateYM.valueOf(201904));
            khZennouToukeiListDataSourceBean.setIrZennoutoukeilist(100);
            khZennouToukeiListDataSourceBean.setIrZennoukaisizndk(BizCurrency.valueOf(101));
            khZennouToukeiListDataSourceBean.setIrMkkp(BizCurrency.valueOf(102));
            khZennouToukeiListDataSourceBean.setIrZennoukaisizndkgaika(BizCurrency.valueOf(9.111,BizCurrencyTypes.AU_DOLLAR));
            khZennouToukeiListDataSourceBean.setIrMkkpgaika(BizCurrency.valueOf(9.222,BizCurrencyTypes.AU_DOLLAR));

            dataSouceList.add(khZennouToukeiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khZennouToukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoutoukeilistTest",
                C_SyoruiCdKbn.AS_ZENNOUTOUKEILIST);
        khZennouToukeiListBean.setIrSakuseiymd("2018年 2月 2日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, khZennouToukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
