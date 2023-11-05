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
import yuyu.def.sinkeiyaku.bean.report.SkMiseirijiyuuNyuukinhubiDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 未整理事由明細（入金内容不備）帳票テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SkMiseirijiyuuNyuukinhubiTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkKessanMiseiriBean skKessanMiseiriBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki(null);
        skKessanMiseiriBean.setIrTyouhyousakuseiymd(null);
        skKessanMiseiriBean.setIrNendo(null);
        skKessanMiseiriBean.setIrShnknm(null);
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();


        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka(null);
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(null);
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn(null);
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd(null);
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd(null);
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd(null);
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn(null);

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);


        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki("");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("");
        skKessanMiseiriBean.setIrNendo("");
        skKessanMiseiriBean.setIrShnknm("");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();


        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("");
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("");

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160503");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160504");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160505");
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        skKessanMiseiriBean.setIrNendo("ＷＷ99ＷＷ");
        skKessanMiseiriBean.setIrShnknm("ＷＷＷＷＷ");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("ＷＷＷ");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("wwwwwwwww");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("99999999");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("99999999");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("99999999");
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("w");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(999999999999L, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        skKessanMiseiriBean.setIrNendo("ＷＷ99ＷＷ");
        skKessanMiseiriBean.setIrShnknm("ＷＷＷＷＷ");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("wwwwwwwww");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("99999999");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("99999999");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("99999999");
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("w");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9999999999L, BizCurrencyTypes.YEN));

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9999999999L, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(9999999999L, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(999999999999L, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(99999999999999L, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(99999999999999L, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160503");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160504");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160505");
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));


        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean.setIrSknnkaisiymd("20160503");
        skDai1kaihokenryouittilistDataSourceBean.setIrKykymd("20160504");
        skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("20160505");
        skDai1kaihokenryouittilistDataSourceBean.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgaku(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

        skDai1kaihokenryouittilistDataSourceBean.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));



        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160503");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160504");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160505");
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean.setIrSknnkaisiymd("20160503");
        skDai1kaihokenryouittilistDataSourceBean.setIrKykymd("20160504");
        skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("20160505");
        skDai1kaihokenryouittilistDataSourceBean.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));

        skDai1kaihokenryouittilistDataSourceBean.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160503");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160504");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160505");
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean.setIrSknnkaisiymd("20160503");
        skDai1kaihokenryouittilistDataSourceBean.setIrKykymd("20160504");
        skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("20160505");
        skDai1kaihokenryouittilistDataSourceBean.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));

        skDai1kaihokenryouittilistDataSourceBean.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160503");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160504");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160505");
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
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
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean.setIrSknnkaisiymd("20160503");
        skDai1kaihokenryouittilistDataSourceBean.setIrKykymd("20160504");
        skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("20160505");
        skDai1kaihokenryouittilistDataSourceBean.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));

        skDai1kaihokenryouittilistDataSourceBean.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160503");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160504");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160505");
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
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
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 1; i < 999; i++){
            SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("円");
            skDai1kaihokenryouittilistDataSourceBean.setIrMosno(String.valueOf(100000000+i));
            skDai1kaihokenryouittilistDataSourceBean.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean.setIrSknnkaisiymd("20160503");
            skDai1kaihokenryouittilistDataSourceBean.setIrKykymd("20160504");
            skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("20160505");
            skDai1kaihokenryouittilistDataSourceBean.setIrNyuukinjoutaikbn("1");
            skDai1kaihokenryouittilistDataSourceBean.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
            skDai1kaihokenryouittilistDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);
        }
        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160503");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160504");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160505");
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(999));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(999));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
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
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 1; i < 1001; i++){
            SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("豪ドル");
            skDai1kaihokenryouittilistDataSourceBean.setIrMosno(String.valueOf(100000000+i));
            skDai1kaihokenryouittilistDataSourceBean.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean.setIrSknnkaisiymd("20160503");
            skDai1kaihokenryouittilistDataSourceBean.setIrKykymd("20160504");
            skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("20160505");
            skDai1kaihokenryouittilistDataSourceBean.setIrNyuukinjoutaikbn("1");
            skDai1kaihokenryouittilistDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
            skDai1kaihokenryouittilistDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);
        }
        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100001001");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160503");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160504");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160505");
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9.99, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1001));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1001));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(999999999999999L, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(999999999999999L, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 1; i < 1001; i++){
            SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("円");
            skDai1kaihokenryouittilistDataSourceBean.setIrMosno(String.valueOf(100000000+i));
            skDai1kaihokenryouittilistDataSourceBean.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean.setIrSknnkaisiymd("20160503");
            skDai1kaihokenryouittilistDataSourceBean.setIrKykymd("20160504");
            skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("20160505");
            skDai1kaihokenryouittilistDataSourceBean.setIrNyuukinjoutaikbn("1");
            skDai1kaihokenryouittilistDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9999999999L, BizCurrencyTypes.YEN));
            skDai1kaihokenryouittilistDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(999999999999L, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);
        }
        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100001001");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160503");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160504");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160505");
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1001));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9999999999999L, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1001));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(9999999999999L, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(999999999999999L, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(999999999999999L, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 1; i < 99; i++){
            SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean.setIrNyukintuuka("円");
            skDai1kaihokenryouittilistDataSourceBean.setIrMosno(String.valueOf(100000000+i));
            skDai1kaihokenryouittilistDataSourceBean.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean.setIrSknnkaisiymd("20160503");
            skDai1kaihokenryouittilistDataSourceBean.setIrKykymd("20160504");
            skDai1kaihokenryouittilistDataSourceBean.setIrRyosyuymd("20160505");
            skDai1kaihokenryouittilistDataSourceBean.setIrNyuukinjoutaikbn("1");
            skDai1kaihokenryouittilistDataSourceBean.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
            skDai1kaihokenryouittilistDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean);
        }
        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100000999");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160503");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160504");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160505");
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(99));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(99, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(99));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(99, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(99, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(99, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for(int i = 1; i < 50; i++){
            SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円");
            skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100000001");
            skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160503");
            skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160504");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160505");
            skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));

            skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
            skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
            skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

            SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean2 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean2.setIrNyukintuuka("豪ドル");
            skDai1kaihokenryouittilistDataSourceBean2.setIrMosno("100000001");
            skDai1kaihokenryouittilistDataSourceBean2.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean2.setIrSknnkaisiymd("20160503");
            skDai1kaihokenryouittilistDataSourceBean2.setIrKykymd("20160504");
            skDai1kaihokenryouittilistDataSourceBean2.setIrRyosyuymd("20160505");
            skDai1kaihokenryouittilistDataSourceBean2.setIrNyuukinjoutaikbn("1");
            skDai1kaihokenryouittilistDataSourceBean2.setIrRsgaku(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
            skDai1kaihokenryouittilistDataSourceBean2.setIrRsgakuyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));

            skDai1kaihokenryouittilistDataSourceBean2.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
            skDai1kaihokenryouittilistDataSourceBean2.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
            skDai1kaihokenryouittilistDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(1));
            skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
            skDai1kaihokenryouittilistDataSourceBean2.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
            skDai1kaihokenryouittilistDataSourceBean2.setIrKingakugoukeiyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean2);
        }

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160503");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160504");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160505");
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for(int i = 1; i < 24; i++){
            SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円");
            skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(String.valueOf(100000000 + i));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160503");
            skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160504");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160505");
            skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);
        }

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100000024");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160503");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160504");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160505");
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(24));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(24, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(24));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(24, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(24, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(24, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for(int i = 1; i < 25; i++){
            SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円");
            skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(String.valueOf(100000000 + i));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160503");
            skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160504");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160505");
            skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);
        }

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100000025");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160503");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160504");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160505");
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(25));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(25, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(25));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(25, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(25, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(25, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for(int i = 1; i < 26; i++){
            SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円");
            skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(String.valueOf(100000000 + i));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160503");
            skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160504");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160505");
            skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);
        }

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100000026");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160503");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160504");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160505");
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(26));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(26, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(26));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(26, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(26, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(26, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 1; i < 5; i++){

            SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");
            skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(String.valueOf(100000000+i));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160301");
            skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160401");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160501");
            skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);
        }

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean12 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean12.setIrNyukintuuka("豪ドル");
        skDai1kaihokenryouittilistDataSourceBean12.setIrMosno(String.valueOf(100000005));
        skDai1kaihokenryouittilistDataSourceBean12.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean12.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean12.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean12.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean12.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean12.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean12.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean12.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(5));
        skDai1kaihokenryouittilistDataSourceBean12.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(5, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean12.setIrKensuugoukei(BizNumber.valueOf(5));
        skDai1kaihokenryouittilistDataSourceBean12.setIrKingakugoukei(BizCurrency.valueOf(5, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean12.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(5, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean12.setIrKingakugoukeiyen(BizCurrency.valueOf(5, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean12);

        for(int j = 1; j < 5; j++){

            SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円");
            skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(String.valueOf(200000000+j));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160301");
            skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160401");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160501");
            skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);
        }


        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean22 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();
        skDai1kaihokenryouittilistDataSourceBean22.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean22.setIrMosno(String.valueOf(200000005));
        skDai1kaihokenryouittilistDataSourceBean22.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean22.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean22.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean22.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean22.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean22.setIrRsgaku(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean22.setIrRsgakuyen(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean22.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(5));
        skDai1kaihokenryouittilistDataSourceBean22.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean22.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean22);

        for(int j = 1; j < 5; j++){

            SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

            skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円");
            skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(String.valueOf(200000005+j));
            skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
            skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160301");
            skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160401");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160501");
            skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("2");
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(3, BizCurrencyTypes.YEN));
            skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(3, BizCurrencyTypes.YEN));

            dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);
        }

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean23 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();
        skDai1kaihokenryouittilistDataSourceBean23.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean23.setIrMosno(String.valueOf(200000010));
        skDai1kaihokenryouittilistDataSourceBean23.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean23.setIrSknnkaisiymd("20160301");
        skDai1kaihokenryouittilistDataSourceBean23.setIrKykymd("20160401");
        skDai1kaihokenryouittilistDataSourceBean23.setIrRyosyuymd("20160501");
        skDai1kaihokenryouittilistDataSourceBean23.setIrNyuukinjoutaikbn("2");
        skDai1kaihokenryouittilistDataSourceBean23.setIrRsgaku(BizCurrency.valueOf(3, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean23.setIrRsgakuyen(BizCurrency.valueOf(3, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean23.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(5));
        skDai1kaihokenryouittilistDataSourceBean23.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(15, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean23.setIrKensuugoukei(BizNumber.valueOf(10));
        skDai1kaihokenryouittilistDataSourceBean23.setIrKingakugoukei(BizCurrency.valueOf(25, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean23.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(15, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean23.setIrKingakugoukeiyen(BizCurrency.valueOf(25, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean23);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno(null);
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn(null);
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd(null);
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd(null);
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd(null);
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn(null);
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testCreateReport21(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("豪ドル");

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(0));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testCreateReport22(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseirikariukekinmeisai", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI_YENDT);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("第３四半期");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_NYKNHUBI_YENDT);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuNyuukinhubiDataSourceBean skDai1kaihokenryouittilistDataSourceBean1 = new SkMiseirijiyuuNyuukinhubiDataSourceBean();

        skDai1kaihokenryouittilistDataSourceBean1.setIrNyukintuuka("円");
        skDai1kaihokenryouittilistDataSourceBean1.setIrMosno("100000001");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKyknmkn("契約者名");
        skDai1kaihokenryouittilistDataSourceBean1.setIrSknnkaisiymd("20160503");
        skDai1kaihokenryouittilistDataSourceBean1.setIrKykymd("20160504");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRyosyuymd("20160505");
        skDai1kaihokenryouittilistDataSourceBean1.setIrNyuukinjoutaikbn("1");
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));

        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skDai1kaihokenryouittilistDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));


        dataSouceList.add(skDai1kaihokenryouittilistDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}