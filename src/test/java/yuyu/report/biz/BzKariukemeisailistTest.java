package yuyu.report.biz;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzKariukeMeisaiListBean;
import yuyu.def.biz.bean.report.BzKariukeMeisaiListDataSourceBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 仮受計上明細リスト 帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzKariukemeisailistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzKariukeMeisaiListBean bzKariukeMeisaiListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_KARIUKEMEISAI_3);

        bzKariukeMeisaiListBean.setIrSyoriymd("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("");
        bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
        bzKariukeMeisaiListDataSourceBean.setIrSyorinm("");
        bzKariukeMeisaiListDataSourceBean.setIrSyono("");
        bzKariukeMeisaiListDataSourceBean.setIrDenrenno("");
        bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(0));
        bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(null);
        bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(0));
        bzKariukeMeisaiListDataSourceBean.setIrSikinidoumeisaigk(BizCurrency.valueOf(0));
        bzKariukeMeisaiListDataSourceBean.setIrKyktuukasyu(null);
        bzKariukeMeisaiListDataSourceBean.setIrKanjyoukmkcd("");
        bzKariukeMeisaiListDataSourceBean.setIrKanjyoukmknm("");

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzKariukeMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_KARIUKEMEISAI_3);

        bzKariukeMeisaiListBean.setIrSyoriymd(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean.setIrTantousitunm(null);
        bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
        bzKariukeMeisaiListDataSourceBean.setIrSyorinm(null);
        bzKariukeMeisaiListDataSourceBean.setIrSyono(null);
        bzKariukeMeisaiListDataSourceBean.setIrDenrenno(null);
        bzKariukeMeisaiListDataSourceBean.setIrEdano(null);
        bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(null);
        bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(null);
        bzKariukeMeisaiListDataSourceBean.setIrSikinidoumeisaigk(null);
        bzKariukeMeisaiListDataSourceBean.setIrKyktuukasyu(null);
        bzKariukeMeisaiListDataSourceBean.setIrKanjyoukmkcd(null);
        bzKariukeMeisaiListDataSourceBean.setIrKanjyoukmknm(null);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzKariukeMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_KARIUKEMEISAI_3);

        bzKariukeMeisaiListBean.setIrSyoriymd("2021年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("保全支払サービス室");
        bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
        bzKariukeMeisaiListDataSourceBean.setIrSyorinm("解約処理");
        bzKariukeMeisaiListDataSourceBean.setIrSyono("11807111118");
        bzKariukeMeisaiListDataSourceBean.setIrDenrenno("10000000000000000001");
        bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(2));
        bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(9999));
        bzKariukeMeisaiListDataSourceBean.setIrSikinidoumeisaigk(BizCurrency.valueOf(9999));
        bzKariukeMeisaiListDataSourceBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        bzKariukeMeisaiListDataSourceBean.setIrKanjyoukmkcd("41529");
        bzKariukeMeisaiListDataSourceBean.setIrKanjyoukmknm("支払利息／保険契約支払利息（外保：豪ドル");

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean);
        reportTestBean.addParamObjects(dataSouceList, bzKariukeMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_KARIUKEMEISAI_3);

        bzKariukeMeisaiListBean.setIrSyoriymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
        bzKariukeMeisaiListDataSourceBean.setIrSyorinm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKariukeMeisaiListDataSourceBean.setIrSyono("wwwwwwwwwww");
        bzKariukeMeisaiListDataSourceBean.setIrDenrenno("wwwwwwwwwwwwwwwwwwww");
        bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(99));
        bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(9999999999999L, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(99999999999.99));
        bzKariukeMeisaiListDataSourceBean.setIrSikinidoumeisaigk(BizCurrency.valueOf(99999999999.99));
        bzKariukeMeisaiListDataSourceBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        bzKariukeMeisaiListDataSourceBean.setIrKanjyoukmkcd("wwwww");
        bzKariukeMeisaiListDataSourceBean.setIrKanjyoukmknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzKariukeMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_KARIUKEMEISAI_3);

        bzKariukeMeisaiListBean.setIrSyoriymd("2021年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("保全支払サービス室");
        bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
        bzKariukeMeisaiListDataSourceBean.setIrSyorinm("解約処理");
        bzKariukeMeisaiListDataSourceBean.setIrSyono("11807111118");
        bzKariukeMeisaiListDataSourceBean.setIrDenrenno("1000000000000000000"+String.valueOf(1));
        bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(1));
        bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(999));
        bzKariukeMeisaiListDataSourceBean.setIrSikinidoumeisaigk(BizCurrency.valueOf(999));
        bzKariukeMeisaiListDataSourceBean.setIrKyktuukasyu(C_Tuukasyu.EUR);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean1 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean1.setIrTantousitunm("保全支払サービス室");
        bzKariukeMeisaiListDataSourceBean1.setIrTantousitucd(C_Tantositucd.DAIRITENKEIYAKU);
        bzKariukeMeisaiListDataSourceBean1.setIrSyorinm("解約処理");
        bzKariukeMeisaiListDataSourceBean1.setIrSyono("11807111118");
        bzKariukeMeisaiListDataSourceBean1.setIrDenrenno("1000000000000000000"+String.valueOf(2));
        bzKariukeMeisaiListDataSourceBean1.setIrEdano(Integer.valueOf(2));
        bzKariukeMeisaiListDataSourceBean1.setIrDengk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean1.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzKariukeMeisaiListDataSourceBean1.setIrSiharaigk(BizCurrency.valueOf(9.1));
        bzKariukeMeisaiListDataSourceBean1.setIrSikinidoumeisaigk(BizCurrency.valueOf(9.4));
        bzKariukeMeisaiListDataSourceBean1.setIrKyktuukasyu(C_Tuukasyu.EUR);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean1);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean2 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean2.setIrTantousitunm("保全支払サービス室");
        bzKariukeMeisaiListDataSourceBean2.setIrTantousitucd(C_Tantositucd.DAIRITENJIMUSV);
        bzKariukeMeisaiListDataSourceBean2.setIrSyorinm("解約処理");
        bzKariukeMeisaiListDataSourceBean2.setIrSyono("11807111118");
        bzKariukeMeisaiListDataSourceBean2.setIrDenrenno("1000000000000000000"+String.valueOf(3));
        bzKariukeMeisaiListDataSourceBean2.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean2.setIrDengk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean2.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzKariukeMeisaiListDataSourceBean2.setIrSiharaigk(BizCurrency.valueOf(9.22));
        bzKariukeMeisaiListDataSourceBean2.setIrSikinidoumeisaigk(BizCurrency.valueOf(9.55));
        bzKariukeMeisaiListDataSourceBean2.setIrKyktuukasyu(C_Tuukasyu.EUR);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean2);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean3 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean3.setIrTantousitunm("保全支払サービス室");
        bzKariukeMeisaiListDataSourceBean3.setIrTantousitucd(C_Tantositucd.DAIRITENKEIYAKU);
        bzKariukeMeisaiListDataSourceBean3.setIrSyorinm("解約処理");
        bzKariukeMeisaiListDataSourceBean3.setIrSyono("11807111118");
        bzKariukeMeisaiListDataSourceBean3.setIrDenrenno("1000000000000000000"+String.valueOf(3));
        bzKariukeMeisaiListDataSourceBean3.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean3.setIrDengk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean3.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzKariukeMeisaiListDataSourceBean3.setIrSiharaigk(BizCurrency.valueOf(9.333));
        bzKariukeMeisaiListDataSourceBean3.setIrSikinidoumeisaigk(BizCurrency.valueOf(9.666));
        bzKariukeMeisaiListDataSourceBean3.setIrKyktuukasyu(C_Tuukasyu.EUR);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, bzKariukeMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_KARIUKEMEISAI_3);

        bzKariukeMeisaiListBean.setIrSyoriymd("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, bzKariukeMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_KARIUKEMEISAI_3);

        bzKariukeMeisaiListBean.setIrSyoriymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i < 1000; i++) {

            BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

            bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("保全支払サービス室");
            bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
            bzKariukeMeisaiListDataSourceBean.setIrSyorinm("解約処理");
            bzKariukeMeisaiListDataSourceBean.setIrSyono("11111111111");
            bzKariukeMeisaiListDataSourceBean.setIrDenrenno("10000000000000000001");
            bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(2));
            bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(i, BizCurrencyTypes.YEN));
            bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
            bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(i));

            dataSouceList.add(bzKariukeMeisaiListDataSourceBean);
        }

        for (int i = 1; i < 10000; i++) {

            BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

            bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("保全支払サービス室");
            bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.DAIRITENKEIYAKU);
            bzKariukeMeisaiListDataSourceBean.setIrSyorinm("解約処理2");
            bzKariukeMeisaiListDataSourceBean.setIrSyono("11111111111");
            bzKariukeMeisaiListDataSourceBean.setIrDenrenno("10000000000000000002");
            bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(2));
            bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(i, BizCurrencyTypes.YEN));
            bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
            bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(i));

            dataSouceList.add(bzKariukeMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzKariukeMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_KARIUKEMEISAI_3);

        bzKariukeMeisaiListBean.setIrSyoriymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i < 100000; i++) {

            BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

            bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("保全支払サービス室");
            bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
            bzKariukeMeisaiListDataSourceBean.setIrSyorinm("解約処理");
            bzKariukeMeisaiListDataSourceBean.setIrSyono("11111111111");
            bzKariukeMeisaiListDataSourceBean.setIrDenrenno("10000000000000000001");
            bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(2));
            bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(i, BizCurrencyTypes.YEN));
            bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
            bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(i));

            dataSouceList.add(bzKariukeMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzKariukeMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_KARIUKEMEISAI_3);

        bzKariukeMeisaiListBean.setIrSyoriymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i < 5000; i++) {

            BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

            bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("保全支払サービス室");
            bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
            bzKariukeMeisaiListDataSourceBean.setIrSyorinm("解約処理");
            bzKariukeMeisaiListDataSourceBean.setIrSyono("11111111111");
            bzKariukeMeisaiListDataSourceBean.setIrDenrenno("10000000000000000001");
            bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(2));
            bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(i, BizCurrencyTypes.YEN));
            bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
            bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(i));

            dataSouceList.add(bzKariukeMeisaiListDataSourceBean);

            BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean1 = new BzKariukeMeisaiListDataSourceBean();

            bzKariukeMeisaiListDataSourceBean1.setIrTantousitunm("保全支払サービス室");
            bzKariukeMeisaiListDataSourceBean1.setIrTantousitucd(C_Tantositucd.DAIRITENJIMUSV);
            bzKariukeMeisaiListDataSourceBean1.setIrSyorinm("解約処理2");
            bzKariukeMeisaiListDataSourceBean1.setIrSyono("11111111111");
            bzKariukeMeisaiListDataSourceBean1.setIrDenrenno("10000000000000000002");
            bzKariukeMeisaiListDataSourceBean1.setIrEdano(Integer.valueOf(2));
            bzKariukeMeisaiListDataSourceBean1.setIrDengk(BizCurrency.valueOf(i, BizCurrencyTypes.YEN));
            bzKariukeMeisaiListDataSourceBean1.setIrShrtuukasyu(C_Tuukasyu.USD);
            bzKariukeMeisaiListDataSourceBean1.setIrSiharaigk(BizCurrency.valueOf(i));

            dataSouceList.add(bzKariukeMeisaiListDataSourceBean1);
        }

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("保全支払サービス室");
        bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
        bzKariukeMeisaiListDataSourceBean.setIrSyorinm("解約処理");
        bzKariukeMeisaiListDataSourceBean.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean.setIrDenrenno("10000000000000000001");
        bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(2));
        bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(5000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(5000));

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzKariukeMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_KARIUKEMEISAI_3);

        bzKariukeMeisaiListBean.setIrSyoriymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i < 31; i++) {

            BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

            bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("保全支払サービス室");
            bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
            bzKariukeMeisaiListDataSourceBean.setIrSyorinm("解約処理");
            bzKariukeMeisaiListDataSourceBean.setIrSyono("11111111111");
            bzKariukeMeisaiListDataSourceBean.setIrDenrenno("10000000000000000001");
            bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(2));
            bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(i, BizCurrencyTypes.YEN));
            bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
            bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(i));

            dataSouceList.add(bzKariukeMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzKariukeMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_KARIUKEMEISAI_3);

        bzKariukeMeisaiListBean.setIrSyoriymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i < 32; i++) {

            BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

            bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("保全支払サービス室");
            bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
            bzKariukeMeisaiListDataSourceBean.setIrSyorinm("解約処理");
            bzKariukeMeisaiListDataSourceBean.setIrSyono("11111111111");
            bzKariukeMeisaiListDataSourceBean.setIrDenrenno("10000000000000000001");
            bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(2));
            bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(i, BizCurrencyTypes.YEN));
            bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
            bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(i));

            dataSouceList.add(bzKariukeMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzKariukeMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_KARIUKEMEISAI_3);

        bzKariukeMeisaiListBean.setIrSyoriymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i < 33; i++) {

            BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

            bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("保全支払サービス室");
            bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
            bzKariukeMeisaiListDataSourceBean.setIrSyorinm("解約処理");
            bzKariukeMeisaiListDataSourceBean.setIrSyono("11111111111");
            bzKariukeMeisaiListDataSourceBean.setIrDenrenno("10000000000000000001");
            bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(2));
            bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(i, BizCurrencyTypes.YEN));
            bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
            bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(i));

            dataSouceList.add(bzKariukeMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzKariukeMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_KARIUKEMEISAI_3);

        bzKariukeMeisaiListBean.setIrSyoriymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i < 34; i++) {

            BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

            bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("保全支払サービス室");
            bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
            bzKariukeMeisaiListDataSourceBean.setIrSyorinm("解約処理");
            bzKariukeMeisaiListDataSourceBean.setIrSyono("11111111111");
            bzKariukeMeisaiListDataSourceBean.setIrDenrenno("10000000000000000001");
            bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(2));
            bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(i, BizCurrencyTypes.YEN));
            bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
            bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(i));

            dataSouceList.add(bzKariukeMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzKariukeMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_KARIUKEMEISAI_3);

        bzKariukeMeisaiListBean.setIrSyoriymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i < 35; i++) {

            BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

            bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("保全支払サービス室");
            bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
            bzKariukeMeisaiListDataSourceBean.setIrSyorinm("解約処理");
            bzKariukeMeisaiListDataSourceBean.setIrSyono("11111111111");
            bzKariukeMeisaiListDataSourceBean.setIrDenrenno("10000000000000000001");
            bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(2));
            bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(i, BizCurrencyTypes.YEN));
            bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
            bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(i));

            dataSouceList.add(bzKariukeMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzKariukeMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_KARIUKEMEISAI_3);

        bzKariukeMeisaiListBean.setIrSyoriymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i < 36; i++) {

            BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

            bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("保全支払サービス室");
            bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
            bzKariukeMeisaiListDataSourceBean.setIrSyorinm("解約処理");
            bzKariukeMeisaiListDataSourceBean.setIrSyono("11111111111");
            bzKariukeMeisaiListDataSourceBean.setIrDenrenno("10000000000000000001");
            bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(2));
            bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(i, BizCurrencyTypes.YEN));
            bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
            bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(i));

            dataSouceList.add(bzKariukeMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzKariukeMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_KARIUKEMEISAI_3);

        bzKariukeMeisaiListBean.setIrSyoriymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i < 11; i++) {

            BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

            bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("保全支払サービス室");
            bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
            bzKariukeMeisaiListDataSourceBean.setIrSyorinm("解約処理");
            bzKariukeMeisaiListDataSourceBean.setIrSyono("11111111111");
            bzKariukeMeisaiListDataSourceBean.setIrDenrenno("10000000000000000001");
            bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(2));
            bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(i, BizCurrencyTypes.YEN));
            bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
            bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(i));

            dataSouceList.add(bzKariukeMeisaiListDataSourceBean);
        }

        for (int i = 1; i < 11; i++) {

            BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

            bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("保全支払サービス室");
            bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.DAIRITENKEIYAKU);
            bzKariukeMeisaiListDataSourceBean.setIrSyorinm("解約処理2");
            bzKariukeMeisaiListDataSourceBean.setIrSyono("11111111111");
            bzKariukeMeisaiListDataSourceBean.setIrDenrenno("10000000000000000002");
            bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(2));
            bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(i, BizCurrencyTypes.YEN));
            bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
            bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(i));

            dataSouceList.add(bzKariukeMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzKariukeMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_KARIUKEMEISAI_3);

        bzKariukeMeisaiListBean.setIrSyoriymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i < 37; i++) {

            BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

            bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("保全支払サービス室");
            bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
            bzKariukeMeisaiListDataSourceBean.setIrSyorinm("解約処理");
            bzKariukeMeisaiListDataSourceBean.setIrSyono("11111111111");
            bzKariukeMeisaiListDataSourceBean.setIrDenrenno("10000000000000000001");
            bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(2));
            bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(i, BizCurrencyTypes.YEN));
            bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
            bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(i));

            dataSouceList.add(bzKariukeMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzKariukeMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_KARIUKEMEISAI_3);

        bzKariukeMeisaiListBean.setIrSyoriymd("ＮＮZ9年Z9月Z9日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean1 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean1.setIrTantousitunm("保全支払サービス室");
        bzKariukeMeisaiListDataSourceBean1.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
        bzKariukeMeisaiListDataSourceBean1.setIrSyorinm("解約処理");
        bzKariukeMeisaiListDataSourceBean1.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean1.setIrDenrenno("10000000000000000001");
        bzKariukeMeisaiListDataSourceBean1.setIrEdano(Integer.valueOf(1));
        bzKariukeMeisaiListDataSourceBean1.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean1.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzKariukeMeisaiListDataSourceBean1.setIrSiharaigk(BizCurrency.valueOf(100));
        bzKariukeMeisaiListDataSourceBean1.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean1.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean1);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean2 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean2.setIrTantousitunm("保全支払サービス室");
        bzKariukeMeisaiListDataSourceBean2.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
        bzKariukeMeisaiListDataSourceBean2.setIrSyorinm("解約処理");
        bzKariukeMeisaiListDataSourceBean2.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean2.setIrDenrenno("10000000000000000001");
        bzKariukeMeisaiListDataSourceBean2.setIrEdano(Integer.valueOf(1));
        bzKariukeMeisaiListDataSourceBean2.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean2.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzKariukeMeisaiListDataSourceBean2.setIrSiharaigk(BizCurrency.valueOf(0));
        bzKariukeMeisaiListDataSourceBean2.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean2.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean2);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean3 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean3.setIrTantousitunm("保全支払サービス室2");
        bzKariukeMeisaiListDataSourceBean3.setIrTantousitucd(C_Tantositucd.DAIRITENKEIYAKU);
        bzKariukeMeisaiListDataSourceBean3.setIrSyorinm("解約処理2");
        bzKariukeMeisaiListDataSourceBean3.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean3.setIrDenrenno("10000000000000000002");
        bzKariukeMeisaiListDataSourceBean3.setIrEdano(Integer.valueOf(2));
        bzKariukeMeisaiListDataSourceBean3.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean3.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzKariukeMeisaiListDataSourceBean3.setIrSiharaigk(BizCurrency.valueOf(200));
        bzKariukeMeisaiListDataSourceBean3.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean3.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean3);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean4 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean4.setIrTantousitunm("保全支払サービス室2");
        bzKariukeMeisaiListDataSourceBean4.setIrTantousitucd(C_Tantositucd.DAIRITENKEIYAKU);
        bzKariukeMeisaiListDataSourceBean4.setIrSyorinm("解約処理2");
        bzKariukeMeisaiListDataSourceBean4.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean4.setIrDenrenno("10000000000000000002");
        bzKariukeMeisaiListDataSourceBean4.setIrEdano(Integer.valueOf(2));
        bzKariukeMeisaiListDataSourceBean4.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean4.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzKariukeMeisaiListDataSourceBean4.setIrSiharaigk(BizCurrency.valueOf(0));
        bzKariukeMeisaiListDataSourceBean4.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean4.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean4);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean5 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean5.setIrTantousitunm("保全支払サービス室3");
        bzKariukeMeisaiListDataSourceBean5.setIrTantousitucd(C_Tantositucd.DAIRITENJIMUSV);
        bzKariukeMeisaiListDataSourceBean5.setIrSyorinm("解約処理3");
        bzKariukeMeisaiListDataSourceBean5.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean5.setIrDenrenno("10000000000000000003");
        bzKariukeMeisaiListDataSourceBean5.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean5.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean5.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzKariukeMeisaiListDataSourceBean5.setIrSiharaigk(BizCurrency.valueOf(300));
        bzKariukeMeisaiListDataSourceBean5.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean5.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean5);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean6 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean6.setIrTantousitunm("保全支払サービス室3");
        bzKariukeMeisaiListDataSourceBean6.setIrTantousitucd(C_Tantositucd.DAIRITENJIMUSV);
        bzKariukeMeisaiListDataSourceBean6.setIrSyorinm("解約処理3");
        bzKariukeMeisaiListDataSourceBean6.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean6.setIrDenrenno("10000000000000000003");
        bzKariukeMeisaiListDataSourceBean6.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean6.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean6.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzKariukeMeisaiListDataSourceBean6.setIrSiharaigk(BizCurrency.valueOf(0));
        bzKariukeMeisaiListDataSourceBean6.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean6.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean6);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean7 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean7.setIrTantousitunm("保全支払サービス室4");
        bzKariukeMeisaiListDataSourceBean7.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
        bzKariukeMeisaiListDataSourceBean7.setIrSyorinm("解約処理4");
        bzKariukeMeisaiListDataSourceBean7.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean7.setIrDenrenno("10000000000000000004");
        bzKariukeMeisaiListDataSourceBean7.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean7.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean7.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzKariukeMeisaiListDataSourceBean7.setIrSiharaigk(BizCurrency.valueOf(410));
        bzKariukeMeisaiListDataSourceBean7.setIrSikinidoumeisaigk(BizCurrency.valueOf(0));
        bzKariukeMeisaiListDataSourceBean7.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean7);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean8 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean8.setIrTantousitunm("保全支払サービス室4");
        bzKariukeMeisaiListDataSourceBean8.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
        bzKariukeMeisaiListDataSourceBean8.setIrSyorinm("解約処理4");
        bzKariukeMeisaiListDataSourceBean8.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean8.setIrDenrenno("10000000000000000004");
        bzKariukeMeisaiListDataSourceBean8.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean8.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean8.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzKariukeMeisaiListDataSourceBean8.setIrSiharaigk(BizCurrency.valueOf(420));
        bzKariukeMeisaiListDataSourceBean8.setIrSikinidoumeisaigk(BizCurrency.valueOf(0));
        bzKariukeMeisaiListDataSourceBean8.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean8);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean9 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean9.setIrTantousitunm("保全支払サービス室4");
        bzKariukeMeisaiListDataSourceBean9.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
        bzKariukeMeisaiListDataSourceBean9.setIrSyorinm("解約処理4");
        bzKariukeMeisaiListDataSourceBean9.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean9.setIrDenrenno("10000000000000000004");
        bzKariukeMeisaiListDataSourceBean9.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean9.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean9.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzKariukeMeisaiListDataSourceBean9.setIrSiharaigk(BizCurrency.valueOf(0));
        bzKariukeMeisaiListDataSourceBean9.setIrSikinidoumeisaigk(BizCurrency.valueOf(0));
        bzKariukeMeisaiListDataSourceBean9.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean9);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean10 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean10.setIrTantousitunm("保全支払サービス室4");
        bzKariukeMeisaiListDataSourceBean10.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
        bzKariukeMeisaiListDataSourceBean10.setIrSyorinm("解約処理4");
        bzKariukeMeisaiListDataSourceBean10.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean10.setIrDenrenno("10000000000000000004");
        bzKariukeMeisaiListDataSourceBean10.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean10.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean10.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzKariukeMeisaiListDataSourceBean10.setIrSiharaigk(BizCurrency.valueOf(0));
        bzKariukeMeisaiListDataSourceBean10.setIrSikinidoumeisaigk(BizCurrency.valueOf(0));
        bzKariukeMeisaiListDataSourceBean10.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean10);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean11 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean11.setIrTantousitunm("保全支払サービス室5");
        bzKariukeMeisaiListDataSourceBean11.setIrTantousitucd(C_Tantositucd.DAIRITENKEIYAKU);
        bzKariukeMeisaiListDataSourceBean11.setIrSyorinm("解約処理5");
        bzKariukeMeisaiListDataSourceBean11.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean11.setIrDenrenno("10000000000000000005");
        bzKariukeMeisaiListDataSourceBean11.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean11.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean11.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzKariukeMeisaiListDataSourceBean11.setIrSiharaigk(BizCurrency.valueOf(510));
        bzKariukeMeisaiListDataSourceBean11.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean11.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean11);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean12 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean12.setIrTantousitunm("保全支払サービス室5");
        bzKariukeMeisaiListDataSourceBean12.setIrTantousitucd(C_Tantositucd.DAIRITENKEIYAKU);
        bzKariukeMeisaiListDataSourceBean12.setIrSyorinm("解約処理5");
        bzKariukeMeisaiListDataSourceBean12.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean12.setIrDenrenno("10000000000000000005");
        bzKariukeMeisaiListDataSourceBean12.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean12.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean12.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzKariukeMeisaiListDataSourceBean12.setIrSiharaigk(BizCurrency.valueOf(520));
        bzKariukeMeisaiListDataSourceBean12.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean12.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean12);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean13 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean13.setIrTantousitunm("保全支払サービス室5");
        bzKariukeMeisaiListDataSourceBean13.setIrTantousitucd(C_Tantositucd.DAIRITENKEIYAKU);
        bzKariukeMeisaiListDataSourceBean13.setIrSyorinm("解約処理5");
        bzKariukeMeisaiListDataSourceBean13.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean13.setIrDenrenno("10000000000000000005");
        bzKariukeMeisaiListDataSourceBean13.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean13.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean13.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzKariukeMeisaiListDataSourceBean13.setIrSiharaigk(BizCurrency.valueOf(0));
        bzKariukeMeisaiListDataSourceBean13.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean13.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean13);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean14 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean14.setIrTantousitunm("保全支払サービス室5");
        bzKariukeMeisaiListDataSourceBean14.setIrTantousitucd(C_Tantositucd.DAIRITENKEIYAKU);
        bzKariukeMeisaiListDataSourceBean14.setIrSyorinm("解約処理5");
        bzKariukeMeisaiListDataSourceBean14.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean14.setIrDenrenno("10000000000000000005");
        bzKariukeMeisaiListDataSourceBean14.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean14.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean14.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzKariukeMeisaiListDataSourceBean14.setIrSiharaigk(BizCurrency.valueOf(0));
        bzKariukeMeisaiListDataSourceBean14.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean14.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean14);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean15 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean15.setIrTantousitunm("保全支払サービス室6");
        bzKariukeMeisaiListDataSourceBean15.setIrTantousitucd(C_Tantositucd.DAIRITENJIMUSV);
        bzKariukeMeisaiListDataSourceBean15.setIrSyorinm("解約処理6");
        bzKariukeMeisaiListDataSourceBean15.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean15.setIrDenrenno("10000000000000000006");
        bzKariukeMeisaiListDataSourceBean15.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean15.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean15.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzKariukeMeisaiListDataSourceBean15.setIrSiharaigk(BizCurrency.valueOf(610));
        bzKariukeMeisaiListDataSourceBean15.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean15.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean15);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean16 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean16.setIrTantousitunm("保全支払サービス室6");
        bzKariukeMeisaiListDataSourceBean16.setIrTantousitucd(C_Tantositucd.DAIRITENJIMUSV);
        bzKariukeMeisaiListDataSourceBean16.setIrSyorinm("解約処理6");
        bzKariukeMeisaiListDataSourceBean16.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean16.setIrDenrenno("10000000000000000006");
        bzKariukeMeisaiListDataSourceBean16.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean16.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean16.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzKariukeMeisaiListDataSourceBean16.setIrSiharaigk(BizCurrency.valueOf(620));
        bzKariukeMeisaiListDataSourceBean16.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean16.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean16);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean17 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean17.setIrTantousitunm("保全支払サービス室6");
        bzKariukeMeisaiListDataSourceBean17.setIrTantousitucd(C_Tantositucd.DAIRITENJIMUSV);
        bzKariukeMeisaiListDataSourceBean17.setIrSyorinm("解約処理6");
        bzKariukeMeisaiListDataSourceBean17.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean17.setIrDenrenno("10000000000000000006");
        bzKariukeMeisaiListDataSourceBean17.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean17.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean17.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzKariukeMeisaiListDataSourceBean17.setIrSiharaigk(BizCurrency.valueOf(0));
        bzKariukeMeisaiListDataSourceBean17.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean17.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean17);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean18 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean18.setIrTantousitunm("保全支払サービス室6");
        bzKariukeMeisaiListDataSourceBean18.setIrTantousitucd(C_Tantositucd.DAIRITENJIMUSV);
        bzKariukeMeisaiListDataSourceBean18.setIrSyorinm("解約処理6");
        bzKariukeMeisaiListDataSourceBean18.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean18.setIrDenrenno("10000000000000000006");
        bzKariukeMeisaiListDataSourceBean18.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean18.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean18.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzKariukeMeisaiListDataSourceBean18.setIrSiharaigk(BizCurrency.valueOf(0));
        bzKariukeMeisaiListDataSourceBean18.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean18.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean18);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean19 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean19.setIrTantousitunm("保全支払サービス室7");
        bzKariukeMeisaiListDataSourceBean19.setIrTantousitucd(C_Tantositucd.DAIRITENKEIYAKU);
        bzKariukeMeisaiListDataSourceBean19.setIrSyorinm("解約処理7");
        bzKariukeMeisaiListDataSourceBean19.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean19.setIrDenrenno("10000000000000000007");
        bzKariukeMeisaiListDataSourceBean19.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean19.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean19.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzKariukeMeisaiListDataSourceBean19.setIrSiharaigk(BizCurrency.valueOf(710));
        bzKariukeMeisaiListDataSourceBean19.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean19.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean19);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean20 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean20.setIrTantousitunm("保全支払サービス室7");
        bzKariukeMeisaiListDataSourceBean20.setIrTantousitucd(C_Tantositucd.DAIRITENKEIYAKU);
        bzKariukeMeisaiListDataSourceBean20.setIrSyorinm("解約処理7");
        bzKariukeMeisaiListDataSourceBean20.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean20.setIrDenrenno("10000000000000000007");
        bzKariukeMeisaiListDataSourceBean20.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean20.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean20.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzKariukeMeisaiListDataSourceBean20.setIrSiharaigk(BizCurrency.valueOf(0));
        bzKariukeMeisaiListDataSourceBean20.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean20.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean20);


        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean21 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean21.setIrTantousitunm("保全支払サービス室7");
        bzKariukeMeisaiListDataSourceBean21.setIrTantousitucd(C_Tantositucd.DAIRITENKEIYAKU);
        bzKariukeMeisaiListDataSourceBean21.setIrSyorinm("解約処理7");
        bzKariukeMeisaiListDataSourceBean21.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean21.setIrDenrenno("10000000000000000007");
        bzKariukeMeisaiListDataSourceBean21.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean21.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean21.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzKariukeMeisaiListDataSourceBean21.setIrSiharaigk(BizCurrency.valueOf(720));
        bzKariukeMeisaiListDataSourceBean21.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean21.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean21);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean22 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean22.setIrTantousitunm("保全支払サービス室7");
        bzKariukeMeisaiListDataSourceBean22.setIrTantousitucd(C_Tantositucd.DAIRITENKEIYAKU);
        bzKariukeMeisaiListDataSourceBean22.setIrSyorinm("解約処理7");
        bzKariukeMeisaiListDataSourceBean22.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean22.setIrDenrenno("10000000000000000007");
        bzKariukeMeisaiListDataSourceBean22.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean22.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean22.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzKariukeMeisaiListDataSourceBean22.setIrSiharaigk(BizCurrency.valueOf(0));
        bzKariukeMeisaiListDataSourceBean22.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean22.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean22);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean23 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean23.setIrTantousitunm("保全支払サービス室7");
        bzKariukeMeisaiListDataSourceBean23.setIrTantousitucd(C_Tantositucd.DAIRITENKEIYAKU);
        bzKariukeMeisaiListDataSourceBean23.setIrSyorinm("解約処理7");
        bzKariukeMeisaiListDataSourceBean23.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean23.setIrDenrenno("10000000000000000007");
        bzKariukeMeisaiListDataSourceBean23.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean23.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean23.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzKariukeMeisaiListDataSourceBean23.setIrSiharaigk(BizCurrency.valueOf(730));
        bzKariukeMeisaiListDataSourceBean23.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean23.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean23);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean24 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean24.setIrTantousitunm("保全支払サービス室7");
        bzKariukeMeisaiListDataSourceBean24.setIrTantousitucd(C_Tantositucd.DAIRITENKEIYAKU);
        bzKariukeMeisaiListDataSourceBean24.setIrSyorinm("解約処理7");
        bzKariukeMeisaiListDataSourceBean24.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean24.setIrDenrenno("10000000000000000007");
        bzKariukeMeisaiListDataSourceBean24.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean24.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean24.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzKariukeMeisaiListDataSourceBean24.setIrSiharaigk(BizCurrency.valueOf(0));
        bzKariukeMeisaiListDataSourceBean24.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean24.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean24);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean25 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean25.setIrTantousitunm("保全支払サービス室7");
        bzKariukeMeisaiListDataSourceBean25.setIrTantousitucd(C_Tantositucd.DAIRITENKEIYAKU);
        bzKariukeMeisaiListDataSourceBean25.setIrSyorinm("解約処理7");
        bzKariukeMeisaiListDataSourceBean25.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean25.setIrDenrenno("10000000000000000007");
        bzKariukeMeisaiListDataSourceBean25.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean25.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean25.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzKariukeMeisaiListDataSourceBean25.setIrSiharaigk(BizCurrency.valueOf(100));
        bzKariukeMeisaiListDataSourceBean25.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean25.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean25);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean26 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean26.setIrTantousitunm("保全支払サービス室7");
        bzKariukeMeisaiListDataSourceBean26.setIrTantousitucd(C_Tantositucd.DAIRITENKEIYAKU);
        bzKariukeMeisaiListDataSourceBean26.setIrSyorinm("解約処理7");
        bzKariukeMeisaiListDataSourceBean26.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean26.setIrDenrenno("10000000000000000007");
        bzKariukeMeisaiListDataSourceBean26.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean26.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean26.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzKariukeMeisaiListDataSourceBean26.setIrSiharaigk(BizCurrency.valueOf(200));
        bzKariukeMeisaiListDataSourceBean26.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean26.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean26);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean27 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean27.setIrTantousitunm("保全支払サービス室7");
        bzKariukeMeisaiListDataSourceBean27.setIrTantousitucd(C_Tantositucd.DAIRITENKEIYAKU);
        bzKariukeMeisaiListDataSourceBean27.setIrSyorinm("解約処理7");
        bzKariukeMeisaiListDataSourceBean27.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean27.setIrDenrenno("10000000000000000007");
        bzKariukeMeisaiListDataSourceBean27.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean27.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean27.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzKariukeMeisaiListDataSourceBean27.setIrSiharaigk(BizCurrency.valueOf(300));
        bzKariukeMeisaiListDataSourceBean27.setIrSikinidoumeisaigk(BizCurrency.valueOf(101));
        bzKariukeMeisaiListDataSourceBean27.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean27);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean28 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean28.setIrTantousitunm("保全支払サービス室8");
        bzKariukeMeisaiListDataSourceBean28.setIrTantousitucd(C_Tantositucd.DIRECTSVKIKAKU);
        bzKariukeMeisaiListDataSourceBean28.setIrSyorinm("解約処理8");
        bzKariukeMeisaiListDataSourceBean28.setIrSyono("11111111111");
        bzKariukeMeisaiListDataSourceBean28.setIrDenrenno("10000000000000000008");
        bzKariukeMeisaiListDataSourceBean28.setIrEdano(Integer.valueOf(3));
        bzKariukeMeisaiListDataSourceBean28.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean28.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzKariukeMeisaiListDataSourceBean28.setIrSiharaigk(null);
        bzKariukeMeisaiListDataSourceBean28.setIrSikinidoumeisaigk(null);
        bzKariukeMeisaiListDataSourceBean28.setIrKyktuukasyu(C_Tuukasyu.AUD);

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean28);

        reportTestBean.addParamObjects(dataSouceList, bzKariukeMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_KARIUKEMEISAI_3);

        bzKariukeMeisaiListBean.setIrSyoriymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("保全支払サービス室");
        bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
        bzKariukeMeisaiListDataSourceBean.setIrSyorinm("解約処理");
        bzKariukeMeisaiListDataSourceBean.setIrSyono("11807111118");
        bzKariukeMeisaiListDataSourceBean.setIrDenrenno("10000000000000000001");
        bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(2));
        bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(2000));

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean2 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean2.setIrTantousitunm("保全支払サービス室");
        bzKariukeMeisaiListDataSourceBean2.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
        bzKariukeMeisaiListDataSourceBean2.setIrSyorinm("解約処理");
        bzKariukeMeisaiListDataSourceBean2.setIrSyono("11807111118");
        bzKariukeMeisaiListDataSourceBean2.setIrDenrenno("10000000000000000001");
        bzKariukeMeisaiListDataSourceBean2.setIrEdano(Integer.valueOf(2));
        bzKariukeMeisaiListDataSourceBean2.setIrDengk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean2.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzKariukeMeisaiListDataSourceBean2.setIrSiharaigk(BizCurrency.valueOf(2000));

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean2);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean1 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean1.setIrTantousitunm("保全支払サービス室");
        bzKariukeMeisaiListDataSourceBean1.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
        bzKariukeMeisaiListDataSourceBean1.setIrSyorinm("解約処理2");
        bzKariukeMeisaiListDataSourceBean1.setIrSyono("11807111118");
        bzKariukeMeisaiListDataSourceBean1.setIrDenrenno("10000000000000000002");
        bzKariukeMeisaiListDataSourceBean1.setIrEdano(Integer.valueOf(2));
        bzKariukeMeisaiListDataSourceBean1.setIrDengk(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean1.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzKariukeMeisaiListDataSourceBean1.setIrSiharaigk(BizCurrency.valueOf(3000));

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean1);

        BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean3 = new BzKariukeMeisaiListDataSourceBean();

        bzKariukeMeisaiListDataSourceBean3.setIrTantousitunm("保全支払サービス室");
        bzKariukeMeisaiListDataSourceBean3.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
        bzKariukeMeisaiListDataSourceBean3.setIrSyorinm("解約処理2");
        bzKariukeMeisaiListDataSourceBean3.setIrSyono("11807111118");
        bzKariukeMeisaiListDataSourceBean3.setIrDenrenno("10000000000000000002");
        bzKariukeMeisaiListDataSourceBean3.setIrEdano(Integer.valueOf(2));
        bzKariukeMeisaiListDataSourceBean3.setIrDengk(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
        bzKariukeMeisaiListDataSourceBean3.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzKariukeMeisaiListDataSourceBean3.setIrSiharaigk(BizCurrency.valueOf(3000));

        dataSouceList.add(bzKariukeMeisaiListDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, bzKariukeMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_KARIUKEMEISAI_3);

        bzKariukeMeisaiListBean.setIrSyoriymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i < 9; i++) {

            BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

            bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("保全支払サービス室");
            bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
            bzKariukeMeisaiListDataSourceBean.setIrSyorinm("解約処理");
            bzKariukeMeisaiListDataSourceBean.setIrSyono("11111111111");
            bzKariukeMeisaiListDataSourceBean.setIrDenrenno("10000000000000000001");
            bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(2));
            bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(i, BizCurrencyTypes.YEN));
            bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
            bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(i));
            bzKariukeMeisaiListDataSourceBean.setIrKanjyoukmkcd("27242");
            bzKariukeMeisaiListDataSourceBean.setIrKanjyoukmknm("仮受金／その他仮受金（外保）");

            dataSouceList.add(bzKariukeMeisaiListDataSourceBean);
        }

        for (int i = 1; i < 11; i++) {

            BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

            bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("保全支払サービス室");
            bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.CARDHAKKOUCENTER);
            bzKariukeMeisaiListDataSourceBean.setIrSyorinm("解約処理2");
            bzKariukeMeisaiListDataSourceBean.setIrSyono("11111111111");
            bzKariukeMeisaiListDataSourceBean.setIrDenrenno("10000000000000000001");
            bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(2));
            bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(i, BizCurrencyTypes.YEN));
            bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
            bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(i));
            bzKariukeMeisaiListDataSourceBean.setIrKanjyoukmkcd("27249");
            bzKariukeMeisaiListDataSourceBean.setIrKanjyoukmknm("仮受金／その他仮受金（預り金）（外保：豪");

            dataSouceList.add(bzKariukeMeisaiListDataSourceBean);
        }

        for (int i = 1; i < 13; i++) {

            BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListDataSourceBean = new BzKariukeMeisaiListDataSourceBean();

            bzKariukeMeisaiListDataSourceBean.setIrTantousitunm("保全支払サービス室");
            bzKariukeMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.DAIRITENKEIYAKU);
            bzKariukeMeisaiListDataSourceBean.setIrSyorinm("解約処理3");
            bzKariukeMeisaiListDataSourceBean.setIrSyono("11111111111");
            bzKariukeMeisaiListDataSourceBean.setIrDenrenno("10000000000000000001");
            bzKariukeMeisaiListDataSourceBean.setIrEdano(Integer.valueOf(2));
            bzKariukeMeisaiListDataSourceBean.setIrDengk(BizCurrency.valueOf(i, BizCurrencyTypes.YEN));
            bzKariukeMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
            bzKariukeMeisaiListDataSourceBean.setIrSiharaigk(BizCurrency.valueOf(i));
            bzKariukeMeisaiListDataSourceBean.setIrKanjyoukmkcd("27249");
            bzKariukeMeisaiListDataSourceBean.setIrKanjyoukmknm("仮受金／その他仮受金（預り金）（外保：豪");

            dataSouceList.add(bzKariukeMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzKariukeMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
