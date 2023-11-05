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
import yuyu.def.sinkeiyaku.bean.report.SkKessanMiseiriBean;
import yuyu.def.sinkeiyaku.bean.report.SkMiseirikariukekinmeisaiDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 未整理仮受金明細  帳票テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SkMiseirikariukekinmeisaiTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkKessanMiseiriBean skKessanMiseiriBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki("");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("");
        skKessanMiseiriBean.setIrNendo("");
        skKessanMiseiriBean.setIrShnknm("");
        skKessanMiseiriBean.setIrTyouhyoutitle("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();


        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("");
        skDai1kaihokenryouittilistDataSourceBean.setIrMosno("");
        skDai1kaihokenryouittilistDataSourceBean.setIrKyknmkn("");
        skDai1kaihokenryouittilistDataSourceBean.setIrSknnkaisiymd("");
        skDai1kaihokenryouittilistDataSourceBean.setIrKykymd("");
        skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("");
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgaku(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki(null);
        skKessanMiseiriBean.setIrTyouhyousakuseiymd(null);
        skKessanMiseiriBean.setIrNendo(null);
        skKessanMiseiriBean.setIrShnknm(null);
        skKessanMiseiriBean.setIrTyouhyoutitle(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("");
        skDai1kaihokenryouittilistDataSourceBean.setIrMosno("");
        skDai1kaihokenryouittilistDataSourceBean.setIrKyknmkn(null);
        skDai1kaihokenryouittilistDataSourceBean.setIrSknnkaisiymd(null);
        skDai1kaihokenryouittilistDataSourceBean.setIrKykymd(null);
        skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd(null);
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgaku(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("仮受金（第１回）明細（普保Ⅱ）");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        skKessanMiseiriBean.setIrNendo("ＷＷ99ＷＷ");
        skKessanMiseiriBean.setIrShnknm("ＷＷＷＷＷ");
        skKessanMiseiriBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("ＷＷＷ");
        skDai1kaihokenryouittilistDataSourceBean.setIrMosno("wwwwwwwww");
        skDai1kaihokenryouittilistDataSourceBean.setIrKyknmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skDai1kaihokenryouittilistDataSourceBean.setIrSknnkaisiymd("99999999");
        skDai1kaihokenryouittilistDataSourceBean.setIrKykymd("99999999");
        skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("99999999");
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(9999999999999L, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(999999999999999L, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("仮受金（第１回）明細（普保Ⅱ）");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean2 = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean2.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean2.setIrMosno("wwwwwwwww");
        skDai1kaihokenryouittilistDataSourceBean2.setIrKyknmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skDai1kaihokenryouittilistDataSourceBean2.setIrSknnkaisiymd("99999999");
        skDai1kaihokenryouittilistDataSourceBean2.setIrKykymd("99999999");
        skDai1kaihokenryouittilistDataSourceBean2.setIrRyosyuymd("99999999");
        skDai1kaihokenryouittilistDataSourceBean2.setIrRsgaku(BizCurrency.valueOf(9999999999L, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(9999999999L, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean2.setIrRsgakuyen(BizCurrency.valueOf(9999999999999L, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukeiyen(BizCurrency.valueOf(999999999999999L, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("仮受金（第１回）明細（普保Ⅱ）");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean2 = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean2.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean2.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean2.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean2.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean2.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean2.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean2.setIrRsgaku(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean2.setIrRsgakuyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukeiyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("仮受金（第１回）明細（普保Ⅱ）");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgaku(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));


        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean2 = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean2.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean2.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean2.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean2.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean2.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean2.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean2.setIrRsgaku(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean2.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("仮受金（第１回）明細（普保Ⅱ）");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("仮受金（第１回）明細（普保Ⅱ）");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("仮受金（第１回）明細（普保Ⅱ）");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("仮受金（第１回）明細（普保Ⅱ）");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 1; i < 999; i++){

            SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirikariukekinmeisaiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
            skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(String.valueOf(100000000+i));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160301");
            skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160401");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160501");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);
        }

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(String.valueOf(100000999));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(999));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(9989999999990.01, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("仮受金（第１回）明細（普保Ⅱ）");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 1; i < 1001; i++){

            SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirikariukekinmeisaiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
            skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(String.valueOf(100000000+i));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160301");
            skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160401");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160501");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);
        }

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100001001");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9.99, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1001));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("仮受金（第１回）明細（普保Ⅱ）");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 1; i < 1001; i++){

            SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirikariukekinmeisaiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円");
            skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(String.valueOf(100000000+i));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160301");
            skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160401");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160501");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9999999999L, BizCurrencyTypes.YEN));
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);
        }

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100001001");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1001));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(9999999999999L, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("仮受金（第１回）明細（普保Ⅱ）");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 1; i < 99; i++){

            SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirikariukekinmeisaiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
            skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(String.valueOf(100000000+i));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160301");
            skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160401");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160501");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);
        }

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(String.valueOf(100000000+100));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(99));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(99, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("仮受金（第１回）明細（普保Ⅱ）");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 1; i < 2475; i++){

            SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirikariukekinmeisaiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
            skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(String.valueOf(100000000+i));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160301");
            skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160401");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160501");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(null);
            skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(null);
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);
        }

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean2 = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean2.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean2.setIrMosno(String.valueOf(100002475));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean2.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean2.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean2.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean2.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(2475));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(2475, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean2.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("仮受金（第１回）明細（普保Ⅱ）");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 1; i < 24; i++){

            SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirikariukekinmeisaiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
            skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(String.valueOf(100000000+i));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160301");
            skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160401");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160501");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(null);
            skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(null);
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);
        }

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean2 = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean2.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean2.setIrMosno(String.valueOf(100000024));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean2.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean2.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean2.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean2.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(24));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(24, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean2.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("仮受金（第１回）明細（普保Ⅱ）");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 1; i < 25; i++){

            SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirikariukekinmeisaiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
            skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(String.valueOf(100000000+i));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160301");
            skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160401");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160501");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(null);
            skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(null);
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);
        }

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean2 = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean2.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean2.setIrMosno(String.valueOf(100000025));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean2.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean2.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean2.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean2.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(25));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(25, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean2.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("仮受金（第１回）明細（普保Ⅱ）");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 1; i < 26; i++){

            SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirikariukekinmeisaiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
            skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(String.valueOf(100000000+i));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160301");
            skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160401");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160501");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(null);
            skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(null);
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);
        }

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean2 = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean2.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean2.setIrMosno(String.valueOf(100000026));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean2.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean2.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean2.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean2.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(26));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(26, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean2.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("仮受金（第１回）明細（普保Ⅱ）");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 1; i < 10; i++){

            SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirikariukekinmeisaiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
            skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(String.valueOf(100000000+i));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160301");
            skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160401");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160501");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(null);
            skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(null);
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);
        }

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean2 = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean2.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean2.setIrMosno(String.valueOf(100000010));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean2.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean2.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean2.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean2.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(10));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(10, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean2.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean2);

        for(int j = 1; j < 10; j++){

            SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirikariukekinmeisaiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円");
            skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(String.valueOf(200000000+j));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160301");
            skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160401");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160501");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(null);
            skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(null);
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);
        }

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean3 = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean3.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean3.setIrMosno(String.valueOf(200000010));
        skDai1kaihokenryouittilistDataSourceBean3.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean3.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean3.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean3.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean3.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean3.setIrKensuugoukei(BizNumber.valueOf(10));
        skDai1kaihokenryouittilistDataSourceBean3.setIrKingakugoukei(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean3.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean3.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean3);


        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("仮受金（第１回）明細（普保Ⅱ）");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean2 = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean2.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(210)
    @Transactional
    public void testCreateReport21(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRKARIUKEKINMEISAI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("仮受金（第１回）明細（普保Ⅱ）（円建）");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirikariukekinmeisaiDataSourceBean skDai1kaihokenryouittilistDataSourceBean2 = new SkMiseirikariukekinmeisaiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean2.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


}
