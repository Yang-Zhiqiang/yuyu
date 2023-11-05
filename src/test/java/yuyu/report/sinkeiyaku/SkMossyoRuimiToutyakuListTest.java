package yuyu.report.sinkeiyaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SkMossyoruimitoutyakulistBean;
import yuyu.def.sinkeiyaku.bean.report.SkMossyoruimitoutyakulistDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込書類未到着期間経過リスト帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkMossyoRuimiToutyakuListTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkMossyoruimitoutyakulistBean skMossyoruimitoutyakulistBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST);

        skMossyoruimitoutyakulistBean.setIrAtesaki(null);
        skMossyoruimitoutyakulistBean.setIrTyouhyousakuseiymd(null);
        skMossyoruimitoutyakulistBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean = new SkMossyoruimitoutyakulistDataSourceBean();

        skMossyoruimitoutyakulistDataSourceBean.setIrNyukintuuka(null);
        skMossyoruimitoutyakulistDataSourceBean.setIrDrtennmkj(null);
        skMossyoruimitoutyakulistDataSourceBean.setIrMosno(null);
        skMossyoruimitoutyakulistDataSourceBean.setIrHrkmirninnm(null);
        skMossyoruimitoutyakulistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(0));
        skMossyoruimitoutyakulistDataSourceBean.setIrKnjyymd(null);
        skMossyoruimitoutyakulistDataSourceBean.setIrNyknrnrkhyouymd(null);
        skMossyoruimitoutyakulistDataSourceBean.setIrKensuugoukei5(BizNumber.valueOf(0));
        skMossyoruimitoutyakulistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0));

        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skMossyoruimitoutyakulistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST);

        skMossyoruimitoutyakulistBean.setIrAtesaki("");
        skMossyoruimitoutyakulistBean.setIrTyouhyousakuseiymd("");
        skMossyoruimitoutyakulistBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean = new SkMossyoruimitoutyakulistDataSourceBean();

        skMossyoruimitoutyakulistDataSourceBean.setIrNyukintuuka("");
        skMossyoruimitoutyakulistDataSourceBean.setIrDrtennmkj("");
        skMossyoruimitoutyakulistDataSourceBean.setIrMosno("");
        skMossyoruimitoutyakulistDataSourceBean.setIrHrkmirninnm("");
        skMossyoruimitoutyakulistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(0));
        skMossyoruimitoutyakulistDataSourceBean.setIrKnjyymd("");
        skMossyoruimitoutyakulistDataSourceBean.setIrNyknrnrkhyouymd("");
        skMossyoruimitoutyakulistDataSourceBean.setIrKensuugoukei5(BizNumber.valueOf(0));
        skMossyoruimitoutyakulistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0));

        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skMossyoruimitoutyakulistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST);

        skMossyoruimitoutyakulistBean.setIrAtesaki("代理店契約室　御中");
        skMossyoruimitoutyakulistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMossyoruimitoutyakulistBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean1 = new SkMossyoruimitoutyakulistDataSourceBean();
        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean2 = new SkMossyoruimitoutyakulistDataSourceBean();
        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean3 = new SkMossyoruimitoutyakulistDataSourceBean();
        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean4 = new SkMossyoruimitoutyakulistDataSourceBean();
        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean5 = new SkMossyoruimitoutyakulistDataSourceBean();
        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean6 = new SkMossyoruimitoutyakulistDataSourceBean();
        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean7 = new SkMossyoruimitoutyakulistDataSourceBean();
        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean8 = new SkMossyoruimitoutyakulistDataSourceBean();
        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean9 = new SkMossyoruimitoutyakulistDataSourceBean();
        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean10 = new SkMossyoruimitoutyakulistDataSourceBean();
        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean11 = new SkMossyoruimitoutyakulistDataSourceBean();
        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean12 = new SkMossyoruimitoutyakulistDataSourceBean();
        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean13 = new SkMossyoruimitoutyakulistDataSourceBean();
        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean14 = new SkMossyoruimitoutyakulistDataSourceBean();
        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean15 = new SkMossyoruimitoutyakulistDataSourceBean();
        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean16 = new SkMossyoruimitoutyakulistDataSourceBean();

        skMossyoruimitoutyakulistDataSourceBean1.setIrNyukintuuka("豪ドル入金");
        skMossyoruimitoutyakulistDataSourceBean1.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean1.setIrMosno(String.valueOf(100000001));
        skMossyoruimitoutyakulistDataSourceBean1.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean1.setIrNyknkkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMossyoruimitoutyakulistDataSourceBean1.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean1.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean1.setIrKensuugoukei5(BizNumber.valueOf(0));
        skMossyoruimitoutyakulistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        skMossyoruimitoutyakulistDataSourceBean2.setIrNyukintuuka("円入金");
        skMossyoruimitoutyakulistDataSourceBean2.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean2.setIrMosno(String.valueOf(100000001));
        skMossyoruimitoutyakulistDataSourceBean2.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean2.setIrNyknkkngk(BizCurrency.valueOf(0));
        skMossyoruimitoutyakulistDataSourceBean2.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean2.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean2.setIrKensuugoukei5(BizNumber.valueOf(9999));
        skMossyoruimitoutyakulistDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(0));

        skMossyoruimitoutyakulistDataSourceBean3.setIrNyukintuuka("豪ドル入金");
        skMossyoruimitoutyakulistDataSourceBean3.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean3.setIrMosno(String.valueOf(100000001));
        skMossyoruimitoutyakulistDataSourceBean3.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean3.setIrNyknkkngk(BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR));
        skMossyoruimitoutyakulistDataSourceBean3.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean3.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean3.setIrKensuugoukei5(BizNumber.valueOf(99999));
        skMossyoruimitoutyakulistDataSourceBean3.setIrKingakugoukei(BizCurrency.valueOf(2000, BizCurrencyTypes.AU_DOLLAR));

        skMossyoruimitoutyakulistDataSourceBean4.setIrNyukintuuka("円入金");
        skMossyoruimitoutyakulistDataSourceBean4.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean4.setIrMosno(String.valueOf(100000001));
        skMossyoruimitoutyakulistDataSourceBean4.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean4.setIrNyknkkngk(BizCurrency.valueOf(1000));
        skMossyoruimitoutyakulistDataSourceBean4.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean4.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean4.setIrKensuugoukei5(BizNumber.valueOf(999));
        skMossyoruimitoutyakulistDataSourceBean4.setIrKingakugoukei(BizCurrency.valueOf(2000));

        skMossyoruimitoutyakulistDataSourceBean5.setIrNyukintuuka("豪ドル入金");
        skMossyoruimitoutyakulistDataSourceBean5.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean5.setIrMosno(String.valueOf(100000001));
        skMossyoruimitoutyakulistDataSourceBean5.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean5.setIrNyknkkngk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMossyoruimitoutyakulistDataSourceBean5.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean5.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean5.setIrKensuugoukei5(BizNumber.valueOf(1));
        skMossyoruimitoutyakulistDataSourceBean5.setIrKingakugoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));

        skMossyoruimitoutyakulistDataSourceBean6.setIrNyukintuuka("円入金");
        skMossyoruimitoutyakulistDataSourceBean6.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean6.setIrMosno(String.valueOf(100000001));
        skMossyoruimitoutyakulistDataSourceBean6.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean6.setIrNyknkkngk(BizCurrency.valueOf(9999999999L));
        skMossyoruimitoutyakulistDataSourceBean6.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean6.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean6.setIrKensuugoukei5(BizNumber.valueOf(1));
        skMossyoruimitoutyakulistDataSourceBean6.setIrKingakugoukei(BizCurrency.valueOf(9999999999999L));

        skMossyoruimitoutyakulistDataSourceBean7.setIrNyukintuuka("豪ドル入金");
        skMossyoruimitoutyakulistDataSourceBean7.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean7.setIrMosno(String.valueOf(100000001));
        skMossyoruimitoutyakulistDataSourceBean7.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean7.setIrNyknkkngk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMossyoruimitoutyakulistDataSourceBean7.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean7.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean7.setIrKensuugoukei5(BizNumber.valueOf(1));
        skMossyoruimitoutyakulistDataSourceBean7.setIrKingakugoukei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));

        skMossyoruimitoutyakulistDataSourceBean8.setIrNyukintuuka("円入金");
        skMossyoruimitoutyakulistDataSourceBean8.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean8.setIrMosno(String.valueOf(100000001));
        skMossyoruimitoutyakulistDataSourceBean8.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean8.setIrNyknkkngk(BizCurrency.valueOf(999));
        skMossyoruimitoutyakulistDataSourceBean8.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean8.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean8.setIrKensuugoukei5(BizNumber.valueOf(1));
        skMossyoruimitoutyakulistDataSourceBean8.setIrKingakugoukei(BizCurrency.valueOf(999));

        skMossyoruimitoutyakulistDataSourceBean9.setIrNyukintuuka("豪ドル入金");
        skMossyoruimitoutyakulistDataSourceBean9.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean9.setIrMosno(String.valueOf(100000001));
        skMossyoruimitoutyakulistDataSourceBean9.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean9.setIrNyknkkngk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMossyoruimitoutyakulistDataSourceBean9.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean9.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean9.setIrKensuugoukei5(BizNumber.valueOf(1));
        skMossyoruimitoutyakulistDataSourceBean9.setIrKingakugoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));

        skMossyoruimitoutyakulistDataSourceBean10.setIrNyukintuuka("円入金");
        skMossyoruimitoutyakulistDataSourceBean10.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean10.setIrMosno(String.valueOf(100000001));
        skMossyoruimitoutyakulistDataSourceBean10.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean10.setIrNyknkkngk(BizCurrency.valueOf(9999));
        skMossyoruimitoutyakulistDataSourceBean10.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean10.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean10.setIrKensuugoukei5(BizNumber.valueOf(1));
        skMossyoruimitoutyakulistDataSourceBean10.setIrKingakugoukei(BizCurrency.valueOf(9999));

        skMossyoruimitoutyakulistDataSourceBean11.setIrNyukintuuka("豪ドル入金");
        skMossyoruimitoutyakulistDataSourceBean11.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean11.setIrMosno(String.valueOf(100000001));
        skMossyoruimitoutyakulistDataSourceBean11.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean11.setIrNyknkkngk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMossyoruimitoutyakulistDataSourceBean11.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean11.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean11.setIrKensuugoukei5(BizNumber.valueOf(1));
        skMossyoruimitoutyakulistDataSourceBean11.setIrKingakugoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));

        skMossyoruimitoutyakulistDataSourceBean12.setIrNyukintuuka("円入金");
        skMossyoruimitoutyakulistDataSourceBean12.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean12.setIrMosno(String.valueOf(100000001));
        skMossyoruimitoutyakulistDataSourceBean12.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean12.setIrNyknkkngk(BizCurrency.valueOf(9.1));
        skMossyoruimitoutyakulistDataSourceBean12.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean12.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean12.setIrKensuugoukei5(BizNumber.valueOf(1));
        skMossyoruimitoutyakulistDataSourceBean12.setIrKingakugoukei(BizCurrency.valueOf(9.1));

        skMossyoruimitoutyakulistDataSourceBean13.setIrNyukintuuka("豪ドル入金");
        skMossyoruimitoutyakulistDataSourceBean13.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean13.setIrMosno(String.valueOf(100000001));
        skMossyoruimitoutyakulistDataSourceBean13.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean13.setIrNyknkkngk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMossyoruimitoutyakulistDataSourceBean13.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean13.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean13.setIrKensuugoukei5(BizNumber.valueOf(1));
        skMossyoruimitoutyakulistDataSourceBean13.setIrKingakugoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));

        skMossyoruimitoutyakulistDataSourceBean14.setIrNyukintuuka("円入金");
        skMossyoruimitoutyakulistDataSourceBean14.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean14.setIrMosno(String.valueOf(100000001));
        skMossyoruimitoutyakulistDataSourceBean14.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean14.setIrNyknkkngk(BizCurrency.valueOf(9.22));
        skMossyoruimitoutyakulistDataSourceBean14.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean14.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean14.setIrKensuugoukei5(BizNumber.valueOf(1));
        skMossyoruimitoutyakulistDataSourceBean14.setIrKingakugoukei(BizCurrency.valueOf(9.22));

        skMossyoruimitoutyakulistDataSourceBean15.setIrNyukintuuka("豪ドル入金");
        skMossyoruimitoutyakulistDataSourceBean15.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean15.setIrMosno(String.valueOf(100000001));
        skMossyoruimitoutyakulistDataSourceBean15.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean15.setIrNyknkkngk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMossyoruimitoutyakulistDataSourceBean15.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean15.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean15.setIrKensuugoukei5(BizNumber.valueOf(1));
        skMossyoruimitoutyakulistDataSourceBean15.setIrKingakugoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));

        skMossyoruimitoutyakulistDataSourceBean16.setIrNyukintuuka("円入金");
        skMossyoruimitoutyakulistDataSourceBean16.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean16.setIrMosno(String.valueOf(100000001));
        skMossyoruimitoutyakulistDataSourceBean16.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean16.setIrNyknkkngk(BizCurrency.valueOf(9.333));
        skMossyoruimitoutyakulistDataSourceBean16.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean16.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean16.setIrKensuugoukei5(BizNumber.valueOf(1));
        skMossyoruimitoutyakulistDataSourceBean16.setIrKingakugoukei(BizCurrency.valueOf(9.333));

        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean1);
        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean2);
        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean3);
        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean4);
        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean5);
        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean6);
        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean7);
        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean8);
        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean9);
        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean10);
        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean11);
        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean12);
        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean13);
        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean14);
        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean15);
        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean16);

        reportTestBean.addParamObjects(dataSouceList, skMossyoruimitoutyakulistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST);

        skMossyoruimitoutyakulistBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skMossyoruimitoutyakulistBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        skMossyoruimitoutyakulistBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 14984; i++) {
            SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean = new SkMossyoruimitoutyakulistDataSourceBean();

            skMossyoruimitoutyakulistDataSourceBean.setIrNyukintuuka("ＷＷＷＷＷ");
            skMossyoruimitoutyakulistDataSourceBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skMossyoruimitoutyakulistDataSourceBean.setIrMosno("wwwwwwwww");
            skMossyoruimitoutyakulistDataSourceBean.setIrHrkmirninnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skMossyoruimitoutyakulistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
            skMossyoruimitoutyakulistDataSourceBean.setIrKnjyymd("W.99.99.99");
            skMossyoruimitoutyakulistDataSourceBean.setIrNyknrnrkhyouymd("W.99.99.99");
            skMossyoruimitoutyakulistDataSourceBean.setIrKensuugoukei5(BizNumber.valueOf(0));
            skMossyoruimitoutyakulistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

            dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean);
        }

        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean = new SkMossyoruimitoutyakulistDataSourceBean();

        skMossyoruimitoutyakulistDataSourceBean.setIrNyukintuuka("ＷＷＷＷＷ");
        skMossyoruimitoutyakulistDataSourceBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skMossyoruimitoutyakulistDataSourceBean.setIrMosno("wwwwwwwww");
        skMossyoruimitoutyakulistDataSourceBean.setIrHrkmirninnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skMossyoruimitoutyakulistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMossyoruimitoutyakulistDataSourceBean.setIrKnjyymd("W.99.99.99");
        skMossyoruimitoutyakulistDataSourceBean.setIrNyknrnrkhyouymd("W.99.99.99");
        skMossyoruimitoutyakulistDataSourceBean.setIrKensuugoukei5(BizNumber.valueOf(0));
        skMossyoruimitoutyakulistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skMossyoruimitoutyakulistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST);

        skMossyoruimitoutyakulistBean.setIrAtesaki("代理店契約室　御中");
        skMossyoruimitoutyakulistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMossyoruimitoutyakulistBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 13; i++) {
            SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean = new SkMossyoruimitoutyakulistDataSourceBean();

            skMossyoruimitoutyakulistDataSourceBean.setIrNyukintuuka("円入金");
            skMossyoruimitoutyakulistDataSourceBean.setIrDrtennmkj("代理店名");
            skMossyoruimitoutyakulistDataSourceBean.setIrMosno(String.valueOf(100000001L + i));
            skMossyoruimitoutyakulistDataSourceBean.setIrHrkmirninnm("振込人名");
            skMossyoruimitoutyakulistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1));
            skMossyoruimitoutyakulistDataSourceBean.setIrKnjyymd("H.27.08.31");
            skMossyoruimitoutyakulistDataSourceBean.setIrNyknrnrkhyouymd("H.28.09.30");

            dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean);
        }

        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean = new SkMossyoruimitoutyakulistDataSourceBean();

        skMossyoruimitoutyakulistDataSourceBean.setIrNyukintuuka("円入金");
        skMossyoruimitoutyakulistDataSourceBean.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean.setIrMosno(String.valueOf(100000014));
        skMossyoruimitoutyakulistDataSourceBean.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1));
        skMossyoruimitoutyakulistDataSourceBean.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean.setIrKensuugoukei5(BizNumber.valueOf(14));
        skMossyoruimitoutyakulistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(14));

        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skMossyoruimitoutyakulistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST);

        skMossyoruimitoutyakulistBean.setIrAtesaki("代理店契約室　御中");
        skMossyoruimitoutyakulistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMossyoruimitoutyakulistBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 14; i++) {
            SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean = new SkMossyoruimitoutyakulistDataSourceBean();

            skMossyoruimitoutyakulistDataSourceBean.setIrNyukintuuka("円入金");
            skMossyoruimitoutyakulistDataSourceBean.setIrDrtennmkj("代理店名");
            skMossyoruimitoutyakulistDataSourceBean.setIrMosno(String.valueOf(100000001L + i));
            skMossyoruimitoutyakulistDataSourceBean.setIrHrkmirninnm("振込人名");
            skMossyoruimitoutyakulistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1));
            skMossyoruimitoutyakulistDataSourceBean.setIrKnjyymd("H.27.08.31");
            skMossyoruimitoutyakulistDataSourceBean.setIrNyknrnrkhyouymd("H.28.09.30");

            dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean);
        }

        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean = new SkMossyoruimitoutyakulistDataSourceBean();

        skMossyoruimitoutyakulistDataSourceBean.setIrNyukintuuka("円入金");
        skMossyoruimitoutyakulistDataSourceBean.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean.setIrMosno(String.valueOf(100000015));
        skMossyoruimitoutyakulistDataSourceBean.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1));
        skMossyoruimitoutyakulistDataSourceBean.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean.setIrKensuugoukei5(BizNumber.valueOf(15));
        skMossyoruimitoutyakulistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(15));

        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skMossyoruimitoutyakulistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST);

        skMossyoruimitoutyakulistBean.setIrAtesaki("代理店契約室　御中");
        skMossyoruimitoutyakulistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMossyoruimitoutyakulistBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 15; i++) {
            SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean = new SkMossyoruimitoutyakulistDataSourceBean();

            skMossyoruimitoutyakulistDataSourceBean.setIrNyukintuuka("円入金");
            skMossyoruimitoutyakulistDataSourceBean.setIrDrtennmkj("代理店名");
            skMossyoruimitoutyakulistDataSourceBean.setIrMosno(String.valueOf(100000001L + i));
            skMossyoruimitoutyakulistDataSourceBean.setIrHrkmirninnm("振込人名");
            skMossyoruimitoutyakulistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1));
            skMossyoruimitoutyakulistDataSourceBean.setIrKnjyymd("H.27.08.31");
            skMossyoruimitoutyakulistDataSourceBean.setIrNyknrnrkhyouymd("H.28.09.30");

            dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean);
        }

        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean = new SkMossyoruimitoutyakulistDataSourceBean();

        skMossyoruimitoutyakulistDataSourceBean.setIrNyukintuuka("円入金");
        skMossyoruimitoutyakulistDataSourceBean.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean.setIrMosno(String.valueOf(100000016));
        skMossyoruimitoutyakulistDataSourceBean.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1));
        skMossyoruimitoutyakulistDataSourceBean.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean.setIrKensuugoukei5(BizNumber.valueOf(16));
        skMossyoruimitoutyakulistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(16));

        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skMossyoruimitoutyakulistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST);

        skMossyoruimitoutyakulistBean.setIrAtesaki("代理店契約室　御中");
        skMossyoruimitoutyakulistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMossyoruimitoutyakulistBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean = new SkMossyoruimitoutyakulistDataSourceBean();

        skMossyoruimitoutyakulistDataSourceBean.setIrNyukintuuka("豪ドル入金");
        skMossyoruimitoutyakulistDataSourceBean.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean.setIrMosno(String.valueOf(100000001));
        skMossyoruimitoutyakulistDataSourceBean.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skMossyoruimitoutyakulistDataSourceBean.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean.setIrKensuugoukei5(BizNumber.valueOf(1));
        skMossyoruimitoutyakulistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean);


        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean2 = new SkMossyoruimitoutyakulistDataSourceBean();

        skMossyoruimitoutyakulistDataSourceBean2.setIrNyukintuuka("円入金");
        skMossyoruimitoutyakulistDataSourceBean2.setIrDrtennmkj("代理店名");
        skMossyoruimitoutyakulistDataSourceBean2.setIrMosno(String.valueOf(100000001));
        skMossyoruimitoutyakulistDataSourceBean2.setIrHrkmirninnm("振込人名");
        skMossyoruimitoutyakulistDataSourceBean2.setIrNyknkkngk(BizCurrency.valueOf(1));
        skMossyoruimitoutyakulistDataSourceBean2.setIrKnjyymd("H.27.08.31");
        skMossyoruimitoutyakulistDataSourceBean2.setIrNyknrnrkhyouymd("H.28.09.30");
        skMossyoruimitoutyakulistDataSourceBean2.setIrKensuugoukei5(BizNumber.valueOf(1));
        skMossyoruimitoutyakulistDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(1));

        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, skMossyoruimitoutyakulistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST);

        skMossyoruimitoutyakulistBean.setIrAtesaki("代理店契約室　御中");
        skMossyoruimitoutyakulistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMossyoruimitoutyakulistBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean = new SkMossyoruimitoutyakulistDataSourceBean();

        skMossyoruimitoutyakulistDataSourceBean.setIrNyukintuuka("円入金");
        skMossyoruimitoutyakulistDataSourceBean.setIrKensuugoukei5(BizNumber.valueOf(0));
        skMossyoruimitoutyakulistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0));

        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skMossyoruimitoutyakulistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST_YENDT);

        skMossyoruimitoutyakulistBean.setIrAtesaki("代理店契約室　御中");
        skMossyoruimitoutyakulistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMossyoruimitoutyakulistBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST_YENDT);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMossyoruimitoutyakulistDataSourceBean skMossyoruimitoutyakulistDataSourceBean = new SkMossyoruimitoutyakulistDataSourceBean();

        skMossyoruimitoutyakulistDataSourceBean.setIrNyukintuuka("円入金");
        skMossyoruimitoutyakulistDataSourceBean.setIrKensuugoukei5(BizNumber.valueOf(0));
        skMossyoruimitoutyakulistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0));

        dataSouceList.add(skMossyoruimitoutyakulistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skMossyoruimitoutyakulistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
