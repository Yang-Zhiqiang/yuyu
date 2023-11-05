package yuyu.report.hozen;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhZennouMkkPKsSampleListBean;
import yuyu.def.hozen.bean.report.KhZennouMkkPKsSampleListDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 前納未経過Ｐ検証サンプルリストテスト用クラス
 */
@RunWith(OrderedRunner.class)
public class KhZennoumikeikaSamplelistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhZennouMkkPKsSampleListBean khZennouMkkPKsSampleListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoumikeikaSamplelistTest", C_SyoruiCdKbn.AS_ZENNOUMKKPKSSAMPLELIST);

        khZennouMkkPKsSampleListBean.setIrSakuseiymd("");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhZennouMkkPKsSampleListDataSourceBean khZennouMkkPKsSampleListDsBean = null;

        for (int i = 0; i < 1; i++) {

            khZennouMkkPKsSampleListDsBean = new KhZennouMkkPKsSampleListDataSourceBean();

            khZennouMkkPKsSampleListDsBean.setIrZnnmkkpkssamplekslsttitle("");
            khZennouMkkPKsSampleListDsBean.setIrSyono("");
            khZennouMkkPKsSampleListDsBean.setIrZennoutoukeilistkbn("");
            khZennouMkkPKsSampleListDsBean.setIrZennoukbn("");
            khZennouMkkPKsSampleListDsBean.setIrKbnkeirisegcd("");
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisiym(null);
            khZennouMkkPKsSampleListDsBean.setIrKeiyakuymd8keta(null);
            khZennouMkkPKsSampleListDsBean.setIrZennounyuukinymd(null);
            khZennouMkkPKsSampleListDsBean.setIrZennouwrbkrt(null);
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisizndk(null);
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyrt(null);
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyzndk(null);

            iReportDataSouceBean.add(khZennouMkkPKsSampleListDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khZennouMkkPKsSampleListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoumikeikaSamplelistTest", C_SyoruiCdKbn.AS_ZENNOUMKKPKSSAMPLELIST);

        khZennouMkkPKsSampleListBean.setIrSakuseiymd(null);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhZennouMkkPKsSampleListDataSourceBean khZennouMkkPKsSampleListDsBean = null;

        for (int i = 0; i < 1; i++) {

            khZennouMkkPKsSampleListDsBean = new KhZennouMkkPKsSampleListDataSourceBean();

            khZennouMkkPKsSampleListDsBean.setIrZnnmkkpkssamplekslsttitle(null);
            khZennouMkkPKsSampleListDsBean.setIrSyono(null);
            khZennouMkkPKsSampleListDsBean.setIrZennoutoukeilistkbn(null);
            khZennouMkkPKsSampleListDsBean.setIrZennoukbn(null);
            khZennouMkkPKsSampleListDsBean.setIrKbnkeirisegcd(null);
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisiym(null);
            khZennouMkkPKsSampleListDsBean.setIrKeiyakuymd8keta(null);
            khZennouMkkPKsSampleListDsBean.setIrZennounyuukinymd(null);
            khZennouMkkPKsSampleListDsBean.setIrZennouwrbkrt(null);
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisizndk(null);
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyrt(null);
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyzndk(null);
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisizndkgaika(null);
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyzndkgaika(null);

            iReportDataSouceBean.add(khZennouMkkPKsSampleListDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khZennouMkkPKsSampleListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoumikeikaSamplelistTest", C_SyoruiCdKbn.AS_ZENNOUMKKPKSSAMPLELIST);

        khZennouMkkPKsSampleListBean.setIrSakuseiymd("19900202");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhZennouMkkPKsSampleListDataSourceBean khZennouMkkPKsSampleListDsBean = null;

        for (int i = 0; i < 1; i++) {

            khZennouMkkPKsSampleListDsBean = new KhZennouMkkPKsSampleListDataSourceBean();

            khZennouMkkPKsSampleListDsBean.setIrZnnmkkpkssamplekslsttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
            khZennouMkkPKsSampleListDsBean.setIrSyono("12345678901");
            khZennouMkkPKsSampleListDsBean.setIrZennoutoukeilistkbn("1");
            khZennouMkkPKsSampleListDsBean.setIrZennoukbn("2");
            khZennouMkkPKsSampleListDsBean.setIrKbnkeirisegcd("3");
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisiym(BizDateYM.valueOf("201703"));
            khZennouMkkPKsSampleListDsBean.setIrKeiyakuymd8keta(BizDate.valueOf("20170404"));
            khZennouMkkPKsSampleListDsBean.setIrZennounyuukinymd(BizDate.valueOf("20170505"));
            khZennouMkkPKsSampleListDsBean.setIrZennouwrbkrt(BizNumber.valueOf(1.1));
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisizndk(BizCurrency.valueOf(1000));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyrt(BizNumber.valueOf(2.1));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyzndk(BizCurrency.valueOf(1001));
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisizndkgaika(BizCurrency.valueOf(1003,BizCurrencyTypes.AU_DOLLAR));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyzndkgaika(BizCurrency.valueOf(1004,BizCurrencyTypes.AU_DOLLAR));

            iReportDataSouceBean.add(khZennouMkkPKsSampleListDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khZennouMkkPKsSampleListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoumikeikaSamplelistTest", C_SyoruiCdKbn.AS_ZENNOUMKKPKSSAMPLELIST);

        khZennouMkkPKsSampleListBean.setIrSakuseiymd("20871222");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhZennouMkkPKsSampleListDataSourceBean khZennouMkkPKsSampleListDsBean = null;

        for (int i = 0; i < 20; i++) {

            khZennouMkkPKsSampleListDsBean = new KhZennouMkkPKsSampleListDataSourceBean();

            khZennouMkkPKsSampleListDsBean.setIrZnnmkkpkssamplekslsttitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khZennouMkkPKsSampleListDsBean.setIrSyono("wwwwwwwwwww");
            khZennouMkkPKsSampleListDsBean.setIrZennoutoukeilistkbn("w");
            khZennouMkkPKsSampleListDsBean.setIrZennoukbn("w");
            khZennouMkkPKsSampleListDsBean.setIrKbnkeirisegcd("wwww");
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisiym(BizDateYM.valueOf("208712"));
            khZennouMkkPKsSampleListDsBean.setIrKeiyakuymd8keta(BizDate.valueOf("20871222"));
            khZennouMkkPKsSampleListDsBean.setIrZennounyuukinymd(BizDate.valueOf("20871223"));
            khZennouMkkPKsSampleListDsBean.setIrZennouwrbkrt(BizNumber.valueOf(9.999999));
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisizndk(BizCurrency.valueOf(99999999999l));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyrt(BizNumber.valueOf(9.999999));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyzndk(BizCurrency.valueOf(99999999999l));
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisizndkgaika(BizCurrency.valueOf(99999999999l,BizCurrencyTypes.AU_DOLLAR));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyzndkgaika(BizCurrency.valueOf(99999999999l,BizCurrencyTypes.AU_DOLLAR));

            iReportDataSouceBean.add(khZennouMkkPKsSampleListDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khZennouMkkPKsSampleListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoumikeikaSamplelistTest", C_SyoruiCdKbn.AS_ZENNOUMKKPKSSAMPLELIST);

        khZennouMkkPKsSampleListBean.setIrSakuseiymd("19900202");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhZennouMkkPKsSampleListDataSourceBean khZennouMkkPKsSampleListDsBean = null;

        for (int i = 0; i < 21; i++) {

            khZennouMkkPKsSampleListDsBean = new KhZennouMkkPKsSampleListDataSourceBean();

            khZennouMkkPKsSampleListDsBean.setIrZnnmkkpkssamplekslsttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
            khZennouMkkPKsSampleListDsBean.setIrSyono("12345678901");
            khZennouMkkPKsSampleListDsBean.setIrZennoutoukeilistkbn("1");
            khZennouMkkPKsSampleListDsBean.setIrZennoukbn("2");
            khZennouMkkPKsSampleListDsBean.setIrKbnkeirisegcd("3");
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisiym(BizDateYM.valueOf("201703"));
            khZennouMkkPKsSampleListDsBean.setIrKeiyakuymd8keta(BizDate.valueOf("20170404"));
            khZennouMkkPKsSampleListDsBean.setIrZennounyuukinymd(BizDate.valueOf("20170505"));
            khZennouMkkPKsSampleListDsBean.setIrZennouwrbkrt(BizNumber.valueOf(1));
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisizndk(BizCurrency.valueOf(999));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyrt(BizNumber.valueOf(2));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyzndk(BizCurrency.valueOf(999));
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisizndkgaika(BizCurrency.valueOf(999,BizCurrencyTypes.AU_DOLLAR));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyzndkgaika(BizCurrency.valueOf(999,BizCurrencyTypes.AU_DOLLAR));

            iReportDataSouceBean.add(khZennouMkkPKsSampleListDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khZennouMkkPKsSampleListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoumikeikaSamplelistTest", C_SyoruiCdKbn.AS_ZENNOUMKKPKSSAMPLELIST);

        khZennouMkkPKsSampleListBean.setIrSakuseiymd("19900202");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhZennouMkkPKsSampleListDataSourceBean khZennouMkkPKsSampleListDsBean1= new KhZennouMkkPKsSampleListDataSourceBean();
        khZennouMkkPKsSampleListDsBean1.setIrZnnmkkpkssamplekslsttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
        khZennouMkkPKsSampleListDsBean1.setIrSyono("12345678908");
        khZennouMkkPKsSampleListDsBean1.setIrZennoutoukeilistkbn("1");
        khZennouMkkPKsSampleListDsBean1.setIrZennoukbn("3");
        khZennouMkkPKsSampleListDsBean1.setIrKbnkeirisegcd("0001");
        khZennouMkkPKsSampleListDsBean1.setIrZennoukaisiym(BizDateYM.valueOf("201703"));
        khZennouMkkPKsSampleListDsBean1.setIrKeiyakuymd8keta(BizDate.valueOf("20170404"));
        khZennouMkkPKsSampleListDsBean1.setIrZennounyuukinymd(BizDate.valueOf("20170505"));
        khZennouMkkPKsSampleListDsBean1.setIrZennouwrbkrt(BizNumber.valueOf(1.1));
        khZennouMkkPKsSampleListDsBean1.setIrZennoukaisizndk(BizCurrency.valueOf(1000));
        khZennouMkkPKsSampleListDsBean1.setIrTndmatutkyrt(BizNumber.valueOf(1.2));
        khZennouMkkPKsSampleListDsBean1.setIrTndmatutkyzndk(BizCurrency.valueOf(1001));
        khZennouMkkPKsSampleListDsBean1.setIrZennoukaisizndkgaika(BizCurrency.valueOf(1002,BizCurrencyTypes.AU_DOLLAR));
        khZennouMkkPKsSampleListDsBean1.setIrTndmatutkyzndkgaika(BizCurrency.valueOf(1003,BizCurrencyTypes.AU_DOLLAR));
        iReportDataSouceBean.add(khZennouMkkPKsSampleListDsBean1);

        KhZennouMkkPKsSampleListDataSourceBean khZennouMkkPKsSampleListDsBean2= new KhZennouMkkPKsSampleListDataSourceBean();
        khZennouMkkPKsSampleListDsBean2.setIrZnnmkkpkssamplekslsttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
        khZennouMkkPKsSampleListDsBean2.setIrSyono("12345678909");
        khZennouMkkPKsSampleListDsBean2.setIrZennoutoukeilistkbn("1");
        khZennouMkkPKsSampleListDsBean2.setIrZennoukbn("3");
        khZennouMkkPKsSampleListDsBean2.setIrKbnkeirisegcd("0002");
        khZennouMkkPKsSampleListDsBean2.setIrZennoukaisiym(BizDateYM.valueOf("201703"));
        khZennouMkkPKsSampleListDsBean2.setIrKeiyakuymd8keta(BizDate.valueOf("20170404"));
        khZennouMkkPKsSampleListDsBean2.setIrZennounyuukinymd(BizDate.valueOf("20170505"));
        khZennouMkkPKsSampleListDsBean2.setIrZennouwrbkrt(BizNumber.valueOf(1.1));
        khZennouMkkPKsSampleListDsBean2.setIrZennoukaisizndk(BizCurrency.valueOf(1000));
        khZennouMkkPKsSampleListDsBean2.setIrTndmatutkyrt(BizNumber.valueOf(1.2));
        khZennouMkkPKsSampleListDsBean2.setIrTndmatutkyzndk(BizCurrency.valueOf(1001));
        khZennouMkkPKsSampleListDsBean2.setIrZennoukaisizndkgaika(BizCurrency.valueOf(1002,BizCurrencyTypes.AU_DOLLAR));
        khZennouMkkPKsSampleListDsBean2.setIrTndmatutkyzndkgaika(BizCurrency.valueOf(1003,BizCurrencyTypes.AU_DOLLAR));
        iReportDataSouceBean.add(khZennouMkkPKsSampleListDsBean2);

        KhZennouMkkPKsSampleListDataSourceBean khZennouMkkPKsSampleListDsBean3= new KhZennouMkkPKsSampleListDataSourceBean();
        khZennouMkkPKsSampleListDsBean3.setIrZnnmkkpkssamplekslsttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
        khZennouMkkPKsSampleListDsBean3.setIrSyono("12345678910");
        khZennouMkkPKsSampleListDsBean3.setIrZennoutoukeilistkbn("1");
        khZennouMkkPKsSampleListDsBean3.setIrZennoukbn("4");
        khZennouMkkPKsSampleListDsBean3.setIrKbnkeirisegcd("0002");
        khZennouMkkPKsSampleListDsBean3.setIrZennoukaisiym(BizDateYM.valueOf("201703"));
        khZennouMkkPKsSampleListDsBean3.setIrKeiyakuymd8keta(BizDate.valueOf("20170404"));
        khZennouMkkPKsSampleListDsBean3.setIrZennounyuukinymd(BizDate.valueOf("20170505"));
        khZennouMkkPKsSampleListDsBean3.setIrZennouwrbkrt(BizNumber.valueOf(1.1));
        khZennouMkkPKsSampleListDsBean3.setIrZennoukaisizndk(BizCurrency.valueOf(1000));
        khZennouMkkPKsSampleListDsBean3.setIrTndmatutkyrt(BizNumber.valueOf(1.2));
        khZennouMkkPKsSampleListDsBean3.setIrTndmatutkyzndk(BizCurrency.valueOf(1001));
        khZennouMkkPKsSampleListDsBean3.setIrZennoukaisizndkgaika(BizCurrency.valueOf(1002,BizCurrencyTypes.AU_DOLLAR));
        khZennouMkkPKsSampleListDsBean3.setIrTndmatutkyzndkgaika(BizCurrency.valueOf(1003,BizCurrencyTypes.AU_DOLLAR));
        iReportDataSouceBean.add(khZennouMkkPKsSampleListDsBean3);

        KhZennouMkkPKsSampleListDataSourceBean khZennouMkkPKsSampleListDsBean4= new KhZennouMkkPKsSampleListDataSourceBean();
        khZennouMkkPKsSampleListDsBean4.setIrZnnmkkpkssamplekslsttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
        khZennouMkkPKsSampleListDsBean4.setIrSyono("12345678911");
        khZennouMkkPKsSampleListDsBean4.setIrZennoutoukeilistkbn("2");
        khZennouMkkPKsSampleListDsBean4.setIrZennoukbn("4");
        khZennouMkkPKsSampleListDsBean4.setIrKbnkeirisegcd("0002");
        khZennouMkkPKsSampleListDsBean4.setIrZennoukaisiym(BizDateYM.valueOf("201703"));
        khZennouMkkPKsSampleListDsBean4.setIrKeiyakuymd8keta(BizDate.valueOf("20170404"));
        khZennouMkkPKsSampleListDsBean4.setIrZennounyuukinymd(BizDate.valueOf("20170505"));
        khZennouMkkPKsSampleListDsBean4.setIrZennouwrbkrt(BizNumber.valueOf(1.1));
        khZennouMkkPKsSampleListDsBean4.setIrZennoukaisizndk(BizCurrency.valueOf(1000));
        khZennouMkkPKsSampleListDsBean4.setIrTndmatutkyrt(BizNumber.valueOf(1.2));
        khZennouMkkPKsSampleListDsBean4.setIrTndmatutkyzndk(BizCurrency.valueOf(1001));
        khZennouMkkPKsSampleListDsBean4.setIrZennoukaisizndkgaika(BizCurrency.valueOf(1002,BizCurrencyTypes.AU_DOLLAR));
        khZennouMkkPKsSampleListDsBean4.setIrTndmatutkyzndkgaika(BizCurrency.valueOf(1003,BizCurrencyTypes.AU_DOLLAR));
        iReportDataSouceBean.add(khZennouMkkPKsSampleListDsBean4);

        KhZennouMkkPKsSampleListDataSourceBean khZennouMkkPKsSampleListDsBean5 = new KhZennouMkkPKsSampleListDataSourceBean();
        khZennouMkkPKsSampleListDsBean5.setIrZnnmkkpkssamplekslsttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
        khZennouMkkPKsSampleListDsBean5.setIrSyono("12345678912");
        khZennouMkkPKsSampleListDsBean5.setIrZennoutoukeilistkbn("2");
        khZennouMkkPKsSampleListDsBean5.setIrZennoukbn("4");
        khZennouMkkPKsSampleListDsBean5.setIrKbnkeirisegcd("0002");
        khZennouMkkPKsSampleListDsBean5.setIrZennoukaisiym(BizDateYM.valueOf("201703"));
        khZennouMkkPKsSampleListDsBean5.setIrKeiyakuymd8keta(BizDate.valueOf("20170404"));
        khZennouMkkPKsSampleListDsBean5.setIrZennounyuukinymd(BizDate.valueOf("20170505"));
        khZennouMkkPKsSampleListDsBean5.setIrZennouwrbkrt(BizNumber.valueOf(1.1));
        khZennouMkkPKsSampleListDsBean5.setIrZennoukaisizndk(BizCurrency.valueOf(1000));
        khZennouMkkPKsSampleListDsBean5.setIrTndmatutkyrt(BizNumber.valueOf(1.2));
        khZennouMkkPKsSampleListDsBean5.setIrTndmatutkyzndk(BizCurrency.valueOf(1001));
        khZennouMkkPKsSampleListDsBean5.setIrZennoukaisizndkgaika(BizCurrency.valueOf(1002,BizCurrencyTypes.AU_DOLLAR));
        khZennouMkkPKsSampleListDsBean5.setIrTndmatutkyzndkgaika(BizCurrency.valueOf(1003,BizCurrencyTypes.AU_DOLLAR));
        iReportDataSouceBean.add(khZennouMkkPKsSampleListDsBean5);

        reportTestBean.addParamObjects(iReportDataSouceBean, khZennouMkkPKsSampleListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoumikeikaSamplelistTest", C_SyoruiCdKbn.AS_ZENNOUMKKPKSSAMPLELIST);

        khZennouMkkPKsSampleListBean.setIrSakuseiymd("19900202");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhZennouMkkPKsSampleListDataSourceBean khZennouMkkPKsSampleListDsBean  = new KhZennouMkkPKsSampleListDataSourceBean();
        iReportDataSouceBean.add(khZennouMkkPKsSampleListDsBean);

        reportTestBean.addParamObjects(iReportDataSouceBean, khZennouMkkPKsSampleListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoumikeikaSamplelistTest", C_SyoruiCdKbn.AS_ZENNOUMKKPKSSAMPLELIST);

        khZennouMkkPKsSampleListBean.setIrSakuseiymd("19900202");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhZennouMkkPKsSampleListDataSourceBean khZennouMkkPKsSampleListDsBean = null;

        for (int i = 0; i < 19980; i++) {

            khZennouMkkPKsSampleListDsBean = new KhZennouMkkPKsSampleListDataSourceBean();

            khZennouMkkPKsSampleListDsBean.setIrZnnmkkpkssamplekslsttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
            khZennouMkkPKsSampleListDsBean.setIrSyono("12345678901");
            khZennouMkkPKsSampleListDsBean.setIrZennoutoukeilistkbn("1");
            khZennouMkkPKsSampleListDsBean.setIrZennoukbn("2");
            khZennouMkkPKsSampleListDsBean.setIrKbnkeirisegcd("3");
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisiym(BizDateYM.valueOf("201703"));
            khZennouMkkPKsSampleListDsBean.setIrKeiyakuymd8keta(BizDate.valueOf("20170404"));
            khZennouMkkPKsSampleListDsBean.setIrZennounyuukinymd(BizDate.valueOf("20170505"));
            khZennouMkkPKsSampleListDsBean.setIrZennouwrbkrt(BizNumber.valueOf(1.1));
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisizndk(BizCurrency.valueOf(1000));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyrt(BizNumber.valueOf(1.2));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyzndk(BizCurrency.valueOf(1001));
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisizndkgaika(BizCurrency.valueOf(0,BizCurrencyTypes.AU_DOLLAR));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyzndkgaika(BizCurrency.valueOf(0,BizCurrencyTypes.AU_DOLLAR));

            iReportDataSouceBean.add(khZennouMkkPKsSampleListDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khZennouMkkPKsSampleListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoumikeikaSamplelistTest", C_SyoruiCdKbn.AS_ZENNOUMKKPKSSAMPLELIST);

        khZennouMkkPKsSampleListBean.setIrSakuseiymd("19900202");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhZennouMkkPKsSampleListDataSourceBean khZennouMkkPKsSampleListDsBean = null;

        for (int i = 0; i < 20000; i++) {

            khZennouMkkPKsSampleListDsBean = new KhZennouMkkPKsSampleListDataSourceBean();

            khZennouMkkPKsSampleListDsBean.setIrZnnmkkpkssamplekslsttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
            khZennouMkkPKsSampleListDsBean.setIrSyono("12345678901");
            khZennouMkkPKsSampleListDsBean.setIrZennoutoukeilistkbn("1");
            khZennouMkkPKsSampleListDsBean.setIrZennoukbn("2");
            khZennouMkkPKsSampleListDsBean.setIrKbnkeirisegcd("3");
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisiym(BizDateYM.valueOf("201703"));
            khZennouMkkPKsSampleListDsBean.setIrKeiyakuymd8keta(BizDate.valueOf("20170404"));
            khZennouMkkPKsSampleListDsBean.setIrZennounyuukinymd(BizDate.valueOf("20170505"));
            khZennouMkkPKsSampleListDsBean.setIrZennouwrbkrt(BizNumber.valueOf(1.1));
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisizndk(BizCurrency.valueOf(1000));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyrt(BizNumber.valueOf(1.2));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyzndk(BizCurrency.valueOf(1001));
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisizndkgaika(BizCurrency.valueOf(9.1,BizCurrencyTypes.AU_DOLLAR));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyzndkgaika(BizCurrency.valueOf(9.2,BizCurrencyTypes.AU_DOLLAR));

            iReportDataSouceBean.add(khZennouMkkPKsSampleListDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khZennouMkkPKsSampleListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }


    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoumikeikaSamplelistTest", C_SyoruiCdKbn.AS_ZENNOUMKKPKSSAMPLELIST);

        khZennouMkkPKsSampleListBean.setIrSakuseiymd("19900202");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhZennouMkkPKsSampleListDataSourceBean khZennouMkkPKsSampleListDsBean = null;

        for (int i = 0; i < 19980; i++) {

            khZennouMkkPKsSampleListDsBean = new KhZennouMkkPKsSampleListDataSourceBean();

            khZennouMkkPKsSampleListDsBean.setIrZnnmkkpkssamplekslsttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
            khZennouMkkPKsSampleListDsBean.setIrSyono("12345678901");
            khZennouMkkPKsSampleListDsBean.setIrZennoutoukeilistkbn("1");
            khZennouMkkPKsSampleListDsBean.setIrZennoukbn("2");
            khZennouMkkPKsSampleListDsBean.setIrKbnkeirisegcd("3");
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisiym(BizDateYM.valueOf("201703"));
            khZennouMkkPKsSampleListDsBean.setIrKeiyakuymd8keta(BizDate.valueOf("20170404"));
            khZennouMkkPKsSampleListDsBean.setIrZennounyuukinymd(BizDate.valueOf("20170505"));
            khZennouMkkPKsSampleListDsBean.setIrZennouwrbkrt(BizNumber.valueOf(1.1));
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisizndk(BizCurrency.valueOf(1000));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyrt(BizNumber.valueOf(1.2));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyzndk(BizCurrency.valueOf(1001));
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisizndkgaika(BizCurrency.valueOf(9.11,BizCurrencyTypes.AU_DOLLAR));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyzndkgaika(BizCurrency.valueOf(9.22,BizCurrencyTypes.AU_DOLLAR));

            iReportDataSouceBean.add(khZennouMkkPKsSampleListDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khZennouMkkPKsSampleListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }
    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennoumikeikaSamplelistTest", C_SyoruiCdKbn.AS_ZENNOUMKKPKSSAMPLELIST);

        khZennouMkkPKsSampleListBean.setIrSakuseiymd("19900202");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhZennouMkkPKsSampleListDataSourceBean khZennouMkkPKsSampleListDsBean = null;

        for (int i = 0; i < 20000; i++) {

            khZennouMkkPKsSampleListDsBean = new KhZennouMkkPKsSampleListDataSourceBean();

            khZennouMkkPKsSampleListDsBean.setIrZnnmkkpkssamplekslsttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
            khZennouMkkPKsSampleListDsBean.setIrSyono("12345678901");
            khZennouMkkPKsSampleListDsBean.setIrZennoutoukeilistkbn("1");
            khZennouMkkPKsSampleListDsBean.setIrZennoukbn("2");
            khZennouMkkPKsSampleListDsBean.setIrKbnkeirisegcd("3");
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisiym(BizDateYM.valueOf("201703"));
            khZennouMkkPKsSampleListDsBean.setIrKeiyakuymd8keta(BizDate.valueOf("20170404"));
            khZennouMkkPKsSampleListDsBean.setIrZennounyuukinymd(BizDate.valueOf("20170505"));
            khZennouMkkPKsSampleListDsBean.setIrZennouwrbkrt(BizNumber.valueOf(1.1));
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisizndk(BizCurrency.valueOf(1000));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyrt(BizNumber.valueOf(1.2));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyzndk(BizCurrency.valueOf(1001));
            khZennouMkkPKsSampleListDsBean.setIrZennoukaisizndkgaika(BizCurrency.valueOf(9.111,BizCurrencyTypes.AU_DOLLAR));
            khZennouMkkPKsSampleListDsBean.setIrTndmatutkyzndkgaika(BizCurrency.valueOf(9.222,BizCurrencyTypes.AU_DOLLAR));

            iReportDataSouceBean.add(khZennouMkkPKsSampleListDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khZennouMkkPKsSampleListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

}
