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
import yuyu.def.sinkeiyaku.bean.report.SkDai1kaihokenryouittilistBean;
import yuyu.def.sinkeiyaku.bean.report.SkDai1kaihokenryouittilistDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 第１回保険料一致リスト帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkDai1KaihokenRyouittiListTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkDai1kaihokenryouittilistBean skDai1kaihokenryouittilistBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_1PNYKNITTILIST);

        skDai1kaihokenryouittilistBean.setIrAtesaki(null);
        skDai1kaihokenryouittilistBean.setIrTyouhyousakuseiymd(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkDai1kaihokenryouittilistDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka(null);
        skDai1kaihokenryouittilistDataSourceBean.setIrJigyouhiutiwakecd(null);
        skDai1kaihokenryouittilistDataSourceBean.setIrDrtennmkj(null);
        skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd(null);
        skDai1kaihokenryouittilistDataSourceBean.setIrMosno(null);
        skDai1kaihokenryouittilistDataSourceBean.setIrHrkmirninnm(null);
        skDai1kaihokenryouittilistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean.setIrDai1kaip(BizCurrency.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean.setIrHrkmtsry(BizCurrency.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean.setIrNyknrnrkhyouymd(null);
        skDai1kaihokenryouittilistDataSourceBean.setIrSeiritujk(null);
        skDai1kaihokenryouittilistDataSourceBean.setIrKensuugoukei5(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean.setIrDai1kaipgoukei(BizCurrency.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean.setIrHrkmtsrygoukei(BizCurrency.valueOf(0));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skDai1kaihokenryouittilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_1PNYKNITTILIST);

        skDai1kaihokenryouittilistBean.setIrAtesaki("");
        skDai1kaihokenryouittilistBean.setIrTyouhyousakuseiymd("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkDai1kaihokenryouittilistDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("");
        skDai1kaihokenryouittilistDataSourceBean.setIrJigyouhiutiwakecd("");
        skDai1kaihokenryouittilistDataSourceBean.setIrDrtennmkj("");
        skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("");
        skDai1kaihokenryouittilistDataSourceBean.setIrMosno("");
        skDai1kaihokenryouittilistDataSourceBean.setIrHrkmirninnm("");
        skDai1kaihokenryouittilistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean.setIrDai1kaip(BizCurrency.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean.setIrHrkmtsry(BizCurrency.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean.setIrNyknrnrkhyouymd("");
        skDai1kaihokenryouittilistDataSourceBean.setIrSeiritujk("");
        skDai1kaihokenryouittilistDataSourceBean.setIrKensuugoukei5(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean.setIrDai1kaipgoukei(BizCurrency.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean.setIrHrkmtsrygoukei(BizCurrency.valueOf(0));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skDai1kaihokenryouittilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_1PNYKNITTILIST);

        skDai1kaihokenryouittilistBean.setIrAtesaki("代理店契約室　御中");
        skDai1kaihokenryouittilistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skDai1kaihokenryouittilistBean.setIrSyoruicd(C_SyoruiCdKbn.SK_1PNYKNITTILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkDai1kaihokenryouittilistDataSourceBean();
        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean2 = new SkDai1kaihokenryouittilistDataSourceBean();
        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean3 = new SkDai1kaihokenryouittilistDataSourceBean();
        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean4 = new SkDai1kaihokenryouittilistDataSourceBean();
        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean5 = new SkDai1kaihokenryouittilistDataSourceBean();
        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean6 = new SkDai1kaihokenryouittilistDataSourceBean();
        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean7 = new SkDai1kaihokenryouittilistDataSourceBean();
        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean8 = new SkDai1kaihokenryouittilistDataSourceBean();
        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean9 = new SkDai1kaihokenryouittilistDataSourceBean();
        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean10 = new SkDai1kaihokenryouittilistDataSourceBean();
        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean11 = new SkDai1kaihokenryouittilistDataSourceBean();
        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean12 = new SkDai1kaihokenryouittilistDataSourceBean();
        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean13 = new SkDai1kaihokenryouittilistDataSourceBean();
        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean14 = new SkDai1kaihokenryouittilistDataSourceBean();
        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean15 = new SkDai1kaihokenryouittilistDataSourceBean();
        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean16 = new SkDai1kaihokenryouittilistDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル入金");
        skDai1kaihokenryouittilistDataSourceBean1.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean1.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(String.valueOf(100000001));
        skDai1kaihokenryouittilistDataSourceBean1.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyknkkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrDai1kaip(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrHrkmtsry(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei5(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrDai1kaipgoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrHrkmtsrygoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        skDai1kaihokenryouittilistDataSourceBean2.setIrNyukintuuka("円入金");
        skDai1kaihokenryouittilistDataSourceBean2.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean2.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean2.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean2.setIrMosno(String.valueOf(100000001));
        skDai1kaihokenryouittilistDataSourceBean2.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean2.setIrNyknkkngk(BizCurrency.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean2.setIrDai1kaip(BizCurrency.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean2.setIrHrkmtsry(BizCurrency.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean2.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean2.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean2.setIrKensuugoukei5(BizNumber.valueOf(9999));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean2.setIrDai1kaipgoukei(BizCurrency.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean2.setIrHrkmtsrygoukei(BizCurrency.valueOf(0));

        skDai1kaihokenryouittilistDataSourceBean3.setIrNyukintuuka("豪ドル入金");
        skDai1kaihokenryouittilistDataSourceBean3.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean3.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean3.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean3.setIrMosno(String.valueOf(100000001));
        skDai1kaihokenryouittilistDataSourceBean3.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean3.setIrNyknkkngk(BizCurrency.valueOf(1001, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean3.setIrDai1kaip(BizCurrency.valueOf(1002, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean3.setIrHrkmtsry(BizCurrency.valueOf(1003, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean3.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean3.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean3.setIrKensuugoukei5(BizNumber.valueOf(99999));
        skDai1kaihokenryouittilistDataSourceBean3.setIrKingakugoukei(BizCurrency.valueOf(2001, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean3.setIrDai1kaipgoukei(BizCurrency.valueOf(2002, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean3.setIrHrkmtsrygoukei(BizCurrency.valueOf(2003, BizCurrencyTypes.AU_DOLLAR));

        skDai1kaihokenryouittilistDataSourceBean4.setIrNyukintuuka("円入金");
        skDai1kaihokenryouittilistDataSourceBean4.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean4.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean4.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean4.setIrMosno(String.valueOf(100000001));
        skDai1kaihokenryouittilistDataSourceBean4.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean4.setIrNyknkkngk(BizCurrency.valueOf(1001));
        skDai1kaihokenryouittilistDataSourceBean4.setIrDai1kaip(BizCurrency.valueOf(1002));
        skDai1kaihokenryouittilistDataSourceBean4.setIrHrkmtsry(BizCurrency.valueOf(1003));
        skDai1kaihokenryouittilistDataSourceBean4.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean4.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean4.setIrKensuugoukei5(BizNumber.valueOf(999));
        skDai1kaihokenryouittilistDataSourceBean4.setIrKingakugoukei(BizCurrency.valueOf(2001));
        skDai1kaihokenryouittilistDataSourceBean4.setIrDai1kaipgoukei(BizCurrency.valueOf(2002));
        skDai1kaihokenryouittilistDataSourceBean4.setIrHrkmtsrygoukei(BizCurrency.valueOf(2003));

        skDai1kaihokenryouittilistDataSourceBean5.setIrNyukintuuka("豪ドル入金");
        skDai1kaihokenryouittilistDataSourceBean5.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean5.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean5.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean5.setIrMosno(String.valueOf(100000001));
        skDai1kaihokenryouittilistDataSourceBean5.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean5.setIrNyknkkngk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean5.setIrDai1kaip(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean5.setIrHrkmtsry(BizCurrency.valueOf(9999.99, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean5.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean5.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean5.setIrKensuugoukei5(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean5.setIrKingakugoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean5.setIrDai1kaipgoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean5.setIrHrkmtsrygoukei(BizCurrency.valueOf(999999999.99, BizCurrencyTypes.AU_DOLLAR));

        skDai1kaihokenryouittilistDataSourceBean6.setIrNyukintuuka("円入金");
        skDai1kaihokenryouittilistDataSourceBean6.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean6.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean6.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean6.setIrMosno(String.valueOf(100000001));
        skDai1kaihokenryouittilistDataSourceBean6.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean6.setIrNyknkkngk(BizCurrency.valueOf(9999999999L));
        skDai1kaihokenryouittilistDataSourceBean6.setIrDai1kaip(BizCurrency.valueOf(9999999999L));
        skDai1kaihokenryouittilistDataSourceBean6.setIrHrkmtsry(BizCurrency.valueOf(9999));
        skDai1kaihokenryouittilistDataSourceBean6.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean6.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean6.setIrKensuugoukei5(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean6.setIrKingakugoukei(BizCurrency.valueOf(9999999999999L));
        skDai1kaihokenryouittilistDataSourceBean6.setIrDai1kaipgoukei(BizCurrency.valueOf(9999999999999L));
        skDai1kaihokenryouittilistDataSourceBean6.setIrHrkmtsrygoukei(BizCurrency.valueOf(999999999));

        skDai1kaihokenryouittilistDataSourceBean7.setIrNyukintuuka("豪ドル入金");
        skDai1kaihokenryouittilistDataSourceBean7.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean7.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean7.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean7.setIrMosno(String.valueOf(100000001));
        skDai1kaihokenryouittilistDataSourceBean7.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean7.setIrNyknkkngk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean7.setIrDai1kaip(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean7.setIrHrkmtsry(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean7.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean7.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean7.setIrKensuugoukei5(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean7.setIrKingakugoukei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean7.setIrDai1kaipgoukei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean7.setIrHrkmtsrygoukei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));

        skDai1kaihokenryouittilistDataSourceBean8.setIrNyukintuuka("円入金");
        skDai1kaihokenryouittilistDataSourceBean8.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean8.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean8.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean8.setIrMosno(String.valueOf(100000001));
        skDai1kaihokenryouittilistDataSourceBean8.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean8.setIrNyknkkngk(BizCurrency.valueOf(999));
        skDai1kaihokenryouittilistDataSourceBean8.setIrDai1kaip(BizCurrency.valueOf(999));
        skDai1kaihokenryouittilistDataSourceBean8.setIrHrkmtsry(BizCurrency.valueOf(999));
        skDai1kaihokenryouittilistDataSourceBean8.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean8.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean8.setIrKensuugoukei5(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean8.setIrKingakugoukei(BizCurrency.valueOf(999));
        skDai1kaihokenryouittilistDataSourceBean8.setIrDai1kaipgoukei(BizCurrency.valueOf(999));
        skDai1kaihokenryouittilistDataSourceBean8.setIrHrkmtsrygoukei(BizCurrency.valueOf(999));

        skDai1kaihokenryouittilistDataSourceBean9.setIrNyukintuuka("豪ドル入金");
        skDai1kaihokenryouittilistDataSourceBean9.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean9.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean9.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean9.setIrMosno(String.valueOf(100000001));
        skDai1kaihokenryouittilistDataSourceBean9.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean9.setIrNyknkkngk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean9.setIrDai1kaip(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean9.setIrHrkmtsry(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean9.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean9.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean9.setIrKensuugoukei5(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean9.setIrKingakugoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean9.setIrDai1kaipgoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean9.setIrHrkmtsrygoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));

        skDai1kaihokenryouittilistDataSourceBean10.setIrNyukintuuka("円入金");
        skDai1kaihokenryouittilistDataSourceBean10.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean10.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean10.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean10.setIrMosno(String.valueOf(100000001));
        skDai1kaihokenryouittilistDataSourceBean10.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean10.setIrNyknkkngk(BizCurrency.valueOf(9999));
        skDai1kaihokenryouittilistDataSourceBean10.setIrDai1kaip(BizCurrency.valueOf(9999));
        skDai1kaihokenryouittilistDataSourceBean10.setIrHrkmtsry(BizCurrency.valueOf(9999));
        skDai1kaihokenryouittilistDataSourceBean10.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean10.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean10.setIrKensuugoukei5(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean10.setIrKingakugoukei(BizCurrency.valueOf(9999));
        skDai1kaihokenryouittilistDataSourceBean10.setIrDai1kaipgoukei(BizCurrency.valueOf(9999));
        skDai1kaihokenryouittilistDataSourceBean10.setIrHrkmtsrygoukei(BizCurrency.valueOf(9999));

        skDai1kaihokenryouittilistDataSourceBean11.setIrNyukintuuka("豪ドル入金");
        skDai1kaihokenryouittilistDataSourceBean11.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean11.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean11.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean11.setIrMosno(String.valueOf(100000001));
        skDai1kaihokenryouittilistDataSourceBean11.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean11.setIrNyknkkngk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean11.setIrDai1kaip(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean11.setIrHrkmtsry(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean11.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean11.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean11.setIrKensuugoukei5(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean11.setIrKingakugoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean11.setIrDai1kaipgoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean11.setIrHrkmtsrygoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));

        skDai1kaihokenryouittilistDataSourceBean12.setIrNyukintuuka("円入金");
        skDai1kaihokenryouittilistDataSourceBean12.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean12.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean12.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean12.setIrMosno(String.valueOf(100000001));
        skDai1kaihokenryouittilistDataSourceBean12.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean12.setIrNyknkkngk(BizCurrency.valueOf(9.1));
        skDai1kaihokenryouittilistDataSourceBean12.setIrDai1kaip(BizCurrency.valueOf(9.1));
        skDai1kaihokenryouittilistDataSourceBean12.setIrHrkmtsry(BizCurrency.valueOf(9.1));
        skDai1kaihokenryouittilistDataSourceBean12.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean12.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean12.setIrKensuugoukei5(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean12.setIrKingakugoukei(BizCurrency.valueOf(9.1));
        skDai1kaihokenryouittilistDataSourceBean12.setIrDai1kaipgoukei(BizCurrency.valueOf(9.1));
        skDai1kaihokenryouittilistDataSourceBean12.setIrHrkmtsrygoukei(BizCurrency.valueOf(9.1));

        skDai1kaihokenryouittilistDataSourceBean13.setIrNyukintuuka("豪ドル入金");
        skDai1kaihokenryouittilistDataSourceBean13.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean13.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean13.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean13.setIrMosno(String.valueOf(100000001));
        skDai1kaihokenryouittilistDataSourceBean13.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean13.setIrNyknkkngk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean13.setIrDai1kaip(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean13.setIrHrkmtsry(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean13.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean13.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean13.setIrKensuugoukei5(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean13.setIrKingakugoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean13.setIrDai1kaipgoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean13.setIrHrkmtsrygoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));

        skDai1kaihokenryouittilistDataSourceBean14.setIrNyukintuuka("円入金");
        skDai1kaihokenryouittilistDataSourceBean14.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean14.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean14.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean14.setIrMosno(String.valueOf(100000001));
        skDai1kaihokenryouittilistDataSourceBean14.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean14.setIrNyknkkngk(BizCurrency.valueOf(9.22));
        skDai1kaihokenryouittilistDataSourceBean14.setIrDai1kaip(BizCurrency.valueOf(9.22));
        skDai1kaihokenryouittilistDataSourceBean14.setIrHrkmtsry(BizCurrency.valueOf(9.22));
        skDai1kaihokenryouittilistDataSourceBean14.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean14.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean14.setIrKensuugoukei5(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean14.setIrKingakugoukei(BizCurrency.valueOf(9.22));
        skDai1kaihokenryouittilistDataSourceBean14.setIrDai1kaipgoukei(BizCurrency.valueOf(9.22));
        skDai1kaihokenryouittilistDataSourceBean14.setIrHrkmtsrygoukei(BizCurrency.valueOf(9.22));

        skDai1kaihokenryouittilistDataSourceBean15.setIrNyukintuuka("豪ドル入金");
        skDai1kaihokenryouittilistDataSourceBean15.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean15.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean15.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean15.setIrMosno(String.valueOf(100000001));
        skDai1kaihokenryouittilistDataSourceBean15.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean15.setIrNyknkkngk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean15.setIrDai1kaip(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean15.setIrHrkmtsry(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean15.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean15.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean15.setIrKensuugoukei5(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean15.setIrKingakugoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean15.setIrDai1kaipgoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean15.setIrHrkmtsrygoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));

        skDai1kaihokenryouittilistDataSourceBean16.setIrNyukintuuka("円入金");
        skDai1kaihokenryouittilistDataSourceBean16.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean16.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean16.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean16.setIrMosno(String.valueOf(100000001));
        skDai1kaihokenryouittilistDataSourceBean16.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean16.setIrNyknkkngk(BizCurrency.valueOf(9.333));
        skDai1kaihokenryouittilistDataSourceBean16.setIrDai1kaip(BizCurrency.valueOf(9.333));
        skDai1kaihokenryouittilistDataSourceBean16.setIrHrkmtsry(BizCurrency.valueOf(9.333));
        skDai1kaihokenryouittilistDataSourceBean16.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean16.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean16.setIrKensuugoukei5(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean16.setIrKingakugoukei(BizCurrency.valueOf(9.333));
        skDai1kaihokenryouittilistDataSourceBean16.setIrDai1kaipgoukei(BizCurrency.valueOf(9.333));
        skDai1kaihokenryouittilistDataSourceBean16.setIrHrkmtsrygoukei(BizCurrency.valueOf(9.333));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);
        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean2);
        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean3);
        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean4);
        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean5);
        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean6);
        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean7);
        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean8);
        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean9);
        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean10);
        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean11);
        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean12);
        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean13);
        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean14);
        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean15);
        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean16);

        reportTestBean.addParamObjects(dataSouceList, skDai1kaihokenryouittilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_1PNYKNITTILIST);

        skDai1kaihokenryouittilistBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skDai1kaihokenryouittilistBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 14984; i++) {
            SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkDai1kaihokenryouittilistDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("ＷＷＷＷＷ");
            skDai1kaihokenryouittilistDataSourceBean.setIrJigyouhiutiwakecd("wwwwwww");
            skDai1kaihokenryouittilistDataSourceBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("W.99.99.99");
            skDai1kaihokenryouittilistDataSourceBean.setIrMosno("wwwwwwwww");
            skDai1kaihokenryouittilistDataSourceBean.setIrHrkmirninnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skDai1kaihokenryouittilistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
            skDai1kaihokenryouittilistDataSourceBean.setIrDai1kaip(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
            skDai1kaihokenryouittilistDataSourceBean.setIrHrkmtsry(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
            skDai1kaihokenryouittilistDataSourceBean.setIrNyknrnrkhyouymd("W.99.99.99");
            skDai1kaihokenryouittilistDataSourceBean.setIrSeiritujk("ＷＷＷ");

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);
        }

        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkDai1kaihokenryouittilistDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("ＷＷＷＷＷ");
        skDai1kaihokenryouittilistDataSourceBean.setIrJigyouhiutiwakecd("wwwwwww");
        skDai1kaihokenryouittilistDataSourceBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("W.99.99.99");
        skDai1kaihokenryouittilistDataSourceBean.setIrMosno("wwwwwwwww");
        skDai1kaihokenryouittilistDataSourceBean.setIrHrkmirninnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skDai1kaihokenryouittilistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean.setIrDai1kaip(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean.setIrHrkmtsry(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean.setIrNyknrnrkhyouymd("W.99.99.99");
        skDai1kaihokenryouittilistDataSourceBean.setIrSeiritujk("ＷＷＷ");
        skDai1kaihokenryouittilistDataSourceBean.setIrKensuugoukei5(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean.setIrDai1kaipgoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean.setIrHrkmtsrygoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skDai1kaihokenryouittilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_1PNYKNITTILIST);

        skDai1kaihokenryouittilistBean.setIrAtesaki("代理店契約室　御中");
        skDai1kaihokenryouittilistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 13; i++) {
            SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkDai1kaihokenryouittilistDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("円入金");
            skDai1kaihokenryouittilistDataSourceBean.setIrJigyouhiutiwakecd("1000000");
            skDai1kaihokenryouittilistDataSourceBean.setIrDrtennmkj("代理店名");
            skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("H.27.08.31");
            skDai1kaihokenryouittilistDataSourceBean.setIrMosno(String.valueOf(100000001L + i));
            skDai1kaihokenryouittilistDataSourceBean.setIrHrkmirninnm("カナ契約者名");
            skDai1kaihokenryouittilistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1));
            skDai1kaihokenryouittilistDataSourceBean.setIrDai1kaip(BizCurrency.valueOf(1));
            skDai1kaihokenryouittilistDataSourceBean.setIrHrkmtsry(BizCurrency.valueOf(1));
            skDai1kaihokenryouittilistDataSourceBean.setIrNyknrnrkhyouymd("H.28.09.30");
            skDai1kaihokenryouittilistDataSourceBean.setIrSeiritujk("成立");

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);
        }

        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkDai1kaihokenryouittilistDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("円入金");
        skDai1kaihokenryouittilistDataSourceBean.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean.setIrMosno("100000014");
        skDai1kaihokenryouittilistDataSourceBean.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrDai1kaip(BizCurrency.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrHrkmtsry(BizCurrency.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean.setIrKensuugoukei5(BizNumber.valueOf(14));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(14));
        skDai1kaihokenryouittilistDataSourceBean.setIrDai1kaipgoukei(BizCurrency.valueOf(14));
        skDai1kaihokenryouittilistDataSourceBean.setIrHrkmtsrygoukei(BizCurrency.valueOf(14));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skDai1kaihokenryouittilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_1PNYKNITTILIST);

        skDai1kaihokenryouittilistBean.setIrAtesaki("代理店契約室　御中");
        skDai1kaihokenryouittilistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 14; i++) {
            SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkDai1kaihokenryouittilistDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("円入金");
            skDai1kaihokenryouittilistDataSourceBean.setIrJigyouhiutiwakecd("1000000");
            skDai1kaihokenryouittilistDataSourceBean.setIrDrtennmkj("代理店名");
            skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("H.27.08.31");
            skDai1kaihokenryouittilistDataSourceBean.setIrMosno(String.valueOf(100000001L + i));
            skDai1kaihokenryouittilistDataSourceBean.setIrHrkmirninnm("カナ契約者名");
            skDai1kaihokenryouittilistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1));
            skDai1kaihokenryouittilistDataSourceBean.setIrDai1kaip(BizCurrency.valueOf(1));
            skDai1kaihokenryouittilistDataSourceBean.setIrHrkmtsry(BizCurrency.valueOf(1));
            skDai1kaihokenryouittilistDataSourceBean.setIrNyknrnrkhyouymd("H.28.09.30");
            skDai1kaihokenryouittilistDataSourceBean.setIrSeiritujk("成立");

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);
        }

        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkDai1kaihokenryouittilistDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("円入金");
        skDai1kaihokenryouittilistDataSourceBean.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean.setIrMosno("100000015");
        skDai1kaihokenryouittilistDataSourceBean.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrDai1kaip(BizCurrency.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrHrkmtsry(BizCurrency.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean.setIrKensuugoukei5(BizNumber.valueOf(15));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(15));
        skDai1kaihokenryouittilistDataSourceBean.setIrDai1kaipgoukei(BizCurrency.valueOf(15));
        skDai1kaihokenryouittilistDataSourceBean.setIrHrkmtsrygoukei(BizCurrency.valueOf(15));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skDai1kaihokenryouittilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_1PNYKNITTILIST);

        skDai1kaihokenryouittilistBean.setIrAtesaki("代理店契約室　御中");
        skDai1kaihokenryouittilistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 15; i++) {
            SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkDai1kaihokenryouittilistDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("円入金");
            skDai1kaihokenryouittilistDataSourceBean.setIrJigyouhiutiwakecd("1000000");
            skDai1kaihokenryouittilistDataSourceBean.setIrDrtennmkj("代理店名");
            skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("H.27.08.31");
            skDai1kaihokenryouittilistDataSourceBean.setIrMosno(String.valueOf(100000001L + i));
            skDai1kaihokenryouittilistDataSourceBean.setIrHrkmirninnm("カナ契約者名");
            skDai1kaihokenryouittilistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1));
            skDai1kaihokenryouittilistDataSourceBean.setIrDai1kaip(BizCurrency.valueOf(1));
            skDai1kaihokenryouittilistDataSourceBean.setIrHrkmtsry(BizCurrency.valueOf(1));
            skDai1kaihokenryouittilistDataSourceBean.setIrNyknrnrkhyouymd("H.28.09.30");
            skDai1kaihokenryouittilistDataSourceBean.setIrSeiritujk("成立");

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);
        }

        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkDai1kaihokenryouittilistDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("円入金");
        skDai1kaihokenryouittilistDataSourceBean.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean.setIrMosno("100000016");
        skDai1kaihokenryouittilistDataSourceBean.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrDai1kaip(BizCurrency.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrHrkmtsry(BizCurrency.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean.setIrKensuugoukei5(BizNumber.valueOf(16));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(16));
        skDai1kaihokenryouittilistDataSourceBean.setIrDai1kaipgoukei(BizCurrency.valueOf(16));
        skDai1kaihokenryouittilistDataSourceBean.setIrHrkmtsrygoukei(BizCurrency.valueOf(16));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skDai1kaihokenryouittilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_1PNYKNITTILIST);

        skDai1kaihokenryouittilistBean.setIrAtesaki("代理店契約室　御中");
        skDai1kaihokenryouittilistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkDai1kaihokenryouittilistDataSourceBean();
        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean2 = new SkDai1kaihokenryouittilistDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル入金");
        skDai1kaihokenryouittilistDataSourceBean1.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean1.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(String.valueOf(100000001));
        skDai1kaihokenryouittilistDataSourceBean1.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyknkkngk(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrDai1kaip(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrHrkmtsry(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei5(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrDai1kaipgoukei(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrHrkmtsrygoukei(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));

        skDai1kaihokenryouittilistDataSourceBean2.setIrNyukintuuka("円入金");
        skDai1kaihokenryouittilistDataSourceBean2.setIrJigyouhiutiwakecd("1000000");
        skDai1kaihokenryouittilistDataSourceBean2.setIrDrtennmkj("代理店名");
        skDai1kaihokenryouittilistDataSourceBean2.setIrRyosyuymd("H.27.08.31");
        skDai1kaihokenryouittilistDataSourceBean2.setIrMosno(String.valueOf(100000001));
        skDai1kaihokenryouittilistDataSourceBean2.setIrHrkmirninnm("カナ契約者名");
        skDai1kaihokenryouittilistDataSourceBean2.setIrNyknkkngk(BizCurrency.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean2.setIrDai1kaip(BizCurrency.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean2.setIrHrkmtsry(BizCurrency.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean2.setIrNyknrnrkhyouymd("H.28.09.30");
        skDai1kaihokenryouittilistDataSourceBean2.setIrSeiritujk("成立");
        skDai1kaihokenryouittilistDataSourceBean2.setIrKensuugoukei5(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean2.setIrDai1kaipgoukei(BizCurrency.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean2.setIrHrkmtsrygoukei(BizCurrency.valueOf(1));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);
        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, skDai1kaihokenryouittilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_1PNYKNITTILIST);

        skDai1kaihokenryouittilistBean.setIrAtesaki("代理店契約室　御中");
        skDai1kaihokenryouittilistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkDai1kaihokenryouittilistDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円入金");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei5(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean1.setIrDai1kaipgoukei(BizCurrency.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean1.setIrHrkmtsrygoukei(BizCurrency.valueOf(0));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skDai1kaihokenryouittilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_1PNYKNITTILIST_YENDT);

        skDai1kaihokenryouittilistBean.setIrAtesaki("代理店契約室　御中");
        skDai1kaihokenryouittilistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skDai1kaihokenryouittilistBean.setIrSyoruicd(C_SyoruiCdKbn.SK_1PNYKNITTILIST_YENDT);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkDai1kaihokenryouittilistDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkDai1kaihokenryouittilistDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円入金");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei5(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean1.setIrDai1kaipgoukei(BizCurrency.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean1.setIrHrkmtsrygoukei(BizCurrency.valueOf(0));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skDai1kaihokenryouittilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}