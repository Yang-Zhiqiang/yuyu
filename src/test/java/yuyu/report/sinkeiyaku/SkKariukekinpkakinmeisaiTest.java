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
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.sinkeiyaku.bean.report.SkKariukekinpkakinBean;
import yuyu.def.sinkeiyaku.bean.report.SkKariukekinpkakinDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 仮受金（Ｐ過金）明細 帳票テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SkKariukekinpkakinmeisaiTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkKariukekinpkakinBean skKariukekinpkakinBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        skKariukekinpkakinBean.setIrAtesaki("");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("");
        skKariukekinpkakinBean.setIrTyouhyoutitle("");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean.setIrTuukasyu(null);
        skKariukekinpkakinDsBean.setIrSyuukeitani("");
        skKariukekinpkakinDsBean.setIrMosno("");
        skKariukekinpkakinDsBean.setIrKyknmkn("");
        skKariukekinpkakinDsBean.setIrRyosyuymd("");
        skKariukekinpkakinDsBean.setIrSuitouymd("");
        skKariukekinpkakinDsBean.setIrPkakingkyen(null);
        skKariukekinpkakinDsBean.setIrPkakingk(null);
        skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(0));
        skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(0));
        skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(null);
        skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(null);
        skKariukekinpkakinDsBean.setIrKawasesasoneki(null);

        dataSouceList.add(skKariukekinpkakinDsBean);

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        skKariukekinpkakinBean.setIrAtesaki(null);
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd(null);
        skKariukekinpkakinBean.setIrTyouhyoutitle(null);
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean.setIrTuukasyu(null);
        skKariukekinpkakinDsBean.setIrSyuukeitani(null);
        skKariukekinpkakinDsBean.setIrMosno(null);
        skKariukekinpkakinDsBean.setIrKyknmkn(null);
        skKariukekinpkakinDsBean.setIrRyosyuymd(null);
        skKariukekinpkakinDsBean.setIrSuitouymd(null);
        skKariukekinpkakinDsBean.setIrPkakingkyen(null);
        skKariukekinpkakinDsBean.setIrPkakingk(null);
        skKariukekinpkakinDsBean.setIrKensuugoukei(null);
        skKariukekinpkakinDsBean.setIrKingakugoukeiyen(null);
        skKariukekinpkakinDsBean.setIrKingakugoukei(null);
        skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(null);
        skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(null);
        skKariukekinpkakinDsBean.setIrKawasesasoneki(null);

        dataSouceList.add(skKariukekinpkakinDsBean);

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年 9月末　仮受金（Ｐ過金）明細");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.JPY);
        skKariukekinpkakinDsBean.setIrSyuukeitani("円入金");
        skKariukekinpkakinDsBean.setIrMosno("123456789");
        skKariukekinpkakinDsBean.setIrKyknmkn("タナカ　タロウ");
        skKariukekinpkakinDsBean.setIrRyosyuymd("20180108");
        skKariukekinpkakinDsBean.setIrSuitouymd("20180109");
        skKariukekinpkakinDsBean.setIrPkakingkyen(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrPkakingk(BizCurrency.valueOf(3000, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(4000, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(6000, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(0));
        skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(null);
        skKariukekinpkakinDsBean.setIrKawasesasoneki(null);

        dataSouceList.add(skKariukekinpkakinDsBean);

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        skKariukekinpkakinBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.AUD);
        skKariukekinpkakinDsBean.setIrSyuukeitani("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKariukekinpkakinDsBean.setIrMosno("wwwwwwwww");
        skKariukekinpkakinDsBean.setIrKyknmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKariukekinpkakinDsBean.setIrRyosyuymd("99999999");
        skKariukekinpkakinDsBean.setIrSuitouymd("99999999");
        skKariukekinpkakinDsBean.setIrPkakingkyen(BizCurrency.valueOf(9999999999999l, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrPkakingk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(999));
        skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(999999999999999l, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(999.99));
        skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(BizCurrency.valueOf(999999999999999l, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKawasesasoneki(BizCurrency.valueOf(-999999999999999l, BizCurrencyTypes.YEN));

        dataSouceList.add(skKariukekinpkakinDsBean);

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年 9月末　仮受金（Ｐ過金）明細");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.JPY);
        skKariukekinpkakinDsBean.setIrSyuukeitani("円入金");
        skKariukekinpkakinDsBean.setIrMosno("123456789");
        skKariukekinpkakinDsBean.setIrKyknmkn("タナカ　タロウ");
        skKariukekinpkakinDsBean.setIrRyosyuymd("20180108");
        skKariukekinpkakinDsBean.setIrSuitouymd("20180109");
        skKariukekinpkakinDsBean.setIrPkakingkyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrPkakingk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(0));
        skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(0));
        skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(null);
        skKariukekinpkakinDsBean.setIrKawasesasoneki(null);

        dataSouceList.add(skKariukekinpkakinDsBean);

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年 9月末　仮受金（Ｐ過金）明細");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.AUD);
        skKariukekinpkakinDsBean.setIrSyuukeitani("豪ドル入金");
        skKariukekinpkakinDsBean.setIrMosno("123456789");
        skKariukekinpkakinDsBean.setIrKyknmkn("タナカ　タロウ");
        skKariukekinpkakinDsBean.setIrRyosyuymd("20180108");
        skKariukekinpkakinDsBean.setIrSuitouymd("20180109");
        skKariukekinpkakinDsBean.setIrPkakingkyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrPkakingk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(0));
        skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(0));
        skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKawasesasoneki(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        dataSouceList.add(skKariukekinpkakinDsBean);

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年 9月末　仮受金（Ｐ過金）明細");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.JPY);
        skKariukekinpkakinDsBean.setIrSyuukeitani("円入金");
        skKariukekinpkakinDsBean.setIrMosno("123456789");
        skKariukekinpkakinDsBean.setIrKyknmkn("タナカ　タロウ");
        skKariukekinpkakinDsBean.setIrRyosyuymd("20180108");
        skKariukekinpkakinDsBean.setIrSuitouymd("20180109");
        skKariukekinpkakinDsBean.setIrPkakingkyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrPkakingk(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(99));
        skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(0));
        skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(null);
        skKariukekinpkakinDsBean.setIrKawasesasoneki(null);

        dataSouceList.add(skKariukekinpkakinDsBean);

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年 9月末　仮受金（Ｐ過金）明細");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.JPY);
        skKariukekinpkakinDsBean.setIrSyuukeitani("円入金");
        skKariukekinpkakinDsBean.setIrMosno("123456789");
        skKariukekinpkakinDsBean.setIrKyknmkn("タナカ　タロウ");
        skKariukekinpkakinDsBean.setIrRyosyuymd("20180108");
        skKariukekinpkakinDsBean.setIrSuitouymd("20180109");
        skKariukekinpkakinDsBean.setIrPkakingkyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrPkakingk(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(0));
        skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(null);
        skKariukekinpkakinDsBean.setIrKawasesasoneki(null);

        dataSouceList.add(skKariukekinpkakinDsBean);

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年 9月末　仮受金（Ｐ過金）明細");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.JPY);
        skKariukekinpkakinDsBean.setIrSyuukeitani("円入金");
        skKariukekinpkakinDsBean.setIrMosno("123456789");
        skKariukekinpkakinDsBean.setIrKyknmkn("タナカ　タロウ");
        skKariukekinpkakinDsBean.setIrRyosyuymd("20180108");
        skKariukekinpkakinDsBean.setIrSuitouymd("20180109");
        skKariukekinpkakinDsBean.setIrPkakingkyen(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrPkakingk(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(0));
        skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(null);
        skKariukekinpkakinDsBean.setIrKawasesasoneki(null);

        dataSouceList.add(skKariukekinpkakinDsBean);

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年 9月末　仮受金（Ｐ過金）明細");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.JPY);
        skKariukekinpkakinDsBean.setIrSyuukeitani("円入金");
        skKariukekinpkakinDsBean.setIrMosno("123456789");
        skKariukekinpkakinDsBean.setIrKyknmkn("タナカ　タロウ");
        skKariukekinpkakinDsBean.setIrRyosyuymd("20180108");
        skKariukekinpkakinDsBean.setIrSuitouymd("20180109");
        skKariukekinpkakinDsBean.setIrPkakingkyen(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrPkakingk(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(0));
        skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(null);
        skKariukekinpkakinDsBean.setIrKawasesasoneki(null);

        dataSouceList.add(skKariukekinpkakinDsBean);

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年 9月末　仮受金（Ｐ過金）明細");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.JPY);
        skKariukekinpkakinDsBean.setIrSyuukeitani("円入金");
        skKariukekinpkakinDsBean.setIrMosno("123456789");
        skKariukekinpkakinDsBean.setIrKyknmkn("タナカ　タロウ");
        skKariukekinpkakinDsBean.setIrRyosyuymd("20180108");
        skKariukekinpkakinDsBean.setIrSuitouymd("20180109");
        skKariukekinpkakinDsBean.setIrPkakingkyen(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrPkakingk(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(0));
        skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(null);
        skKariukekinpkakinDsBean.setIrKawasesasoneki(null);

        dataSouceList.add(skKariukekinpkakinDsBean);

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年 9月末　仮受金（Ｐ過金）明細");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.AUD);
        skKariukekinpkakinDsBean.setIrSyuukeitani("豪ドル入金");
        skKariukekinpkakinDsBean.setIrMosno("123456789");
        skKariukekinpkakinDsBean.setIrKyknmkn("タナカ　タロウ");
        skKariukekinpkakinDsBean.setIrRyosyuymd("20180108");
        skKariukekinpkakinDsBean.setIrSuitouymd("20180109");
        skKariukekinpkakinDsBean.setIrPkakingkyen(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrPkakingk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(0.58));
        skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKawasesasoneki(BizCurrency.valueOf(-9.1, BizCurrencyTypes.YEN));

        dataSouceList.add(skKariukekinpkakinDsBean);

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年 9月末　仮受金（Ｐ過金）明細");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.AUD);
        skKariukekinpkakinDsBean.setIrSyuukeitani("豪ドル入金");
        skKariukekinpkakinDsBean.setIrMosno("123456789");
        skKariukekinpkakinDsBean.setIrKyknmkn("タナカ　タロウ");
        skKariukekinpkakinDsBean.setIrRyosyuymd("20180108");
        skKariukekinpkakinDsBean.setIrSuitouymd("20180109");
        skKariukekinpkakinDsBean.setIrPkakingkyen(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrPkakingk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(0.58));
        skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKawasesasoneki(BizCurrency.valueOf(-9.22, BizCurrencyTypes.YEN));

        dataSouceList.add(skKariukekinpkakinDsBean);

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年 9月末　仮受金（Ｐ過金）明細");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.AUD);
        skKariukekinpkakinDsBean.setIrSyuukeitani("豪ドル入金");
        skKariukekinpkakinDsBean.setIrMosno("123456789");
        skKariukekinpkakinDsBean.setIrKyknmkn("タナカ　タロウ");
        skKariukekinpkakinDsBean.setIrRyosyuymd("20180108");
        skKariukekinpkakinDsBean.setIrSuitouymd("20180109");
        skKariukekinpkakinDsBean.setIrPkakingkyen(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrPkakingk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(0.58));
        skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKawasesasoneki(BizCurrency.valueOf(-9.333, BizCurrencyTypes.YEN));

        dataSouceList.add(skKariukekinpkakinDsBean);

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年 9月末　仮受金（Ｐ過金）明細");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.AUD);
        skKariukekinpkakinDsBean.setIrSyuukeitani("豪ドル入金");
        skKariukekinpkakinDsBean.setIrMosno("123456789");
        skKariukekinpkakinDsBean.setIrKyknmkn("タナカ　タロウ");
        skKariukekinpkakinDsBean.setIrRyosyuymd("20180108");
        skKariukekinpkakinDsBean.setIrSuitouymd("20180109");
        skKariukekinpkakinDsBean.setIrPkakingkyen(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrPkakingk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(0.58));
        skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKawasesasoneki(BizCurrency.valueOf(-999, BizCurrencyTypes.YEN));

        dataSouceList.add(skKariukekinpkakinDsBean);

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年 9月末　仮受金（Ｐ過金）明細");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.AUD);
        skKariukekinpkakinDsBean.setIrSyuukeitani("豪ドル入金");
        skKariukekinpkakinDsBean.setIrMosno("123456789");
        skKariukekinpkakinDsBean.setIrKyknmkn("タナカ　タロウ");
        skKariukekinpkakinDsBean.setIrRyosyuymd("20180108");
        skKariukekinpkakinDsBean.setIrSuitouymd("20180109");
        skKariukekinpkakinDsBean.setIrPkakingkyen(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrPkakingk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(0.58));
        skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKawasesasoneki(BizCurrency.valueOf(-9999, BizCurrencyTypes.YEN));

        dataSouceList.add(skKariukekinpkakinDsBean);


        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年 9月末　仮受金（Ｐ過金）明細");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 24; i++) {
            SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
            skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.JPY);
            skKariukekinpkakinDsBean.setIrSyuukeitani("円入金");
            skKariukekinpkakinDsBean.setIrMosno("123456789");
            skKariukekinpkakinDsBean.setIrKyknmkn("タナカ　タロウ");
            skKariukekinpkakinDsBean.setIrRyosyuymd("20180108");
            skKariukekinpkakinDsBean.setIrSuitouymd("20180109");
            skKariukekinpkakinDsBean.setIrPkakingkyen(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
            skKariukekinpkakinDsBean.setIrPkakingk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));

            if (i == 23) {
                skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(24));
                skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(24000, BizCurrencyTypes.YEN));
                skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(2400, BizCurrencyTypes.YEN));
                skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(0));
                skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(null);
                skKariukekinpkakinDsBean.setIrKawasesasoneki(null);
            }

            dataSouceList.add(skKariukekinpkakinDsBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年 9月末　仮受金（Ｐ過金）明細");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 25; i++) {

            SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
            skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.JPY);
            skKariukekinpkakinDsBean.setIrSyuukeitani("円入金");
            skKariukekinpkakinDsBean.setIrMosno("123456789");
            skKariukekinpkakinDsBean.setIrKyknmkn("タナカ　タロウ");
            skKariukekinpkakinDsBean.setIrRyosyuymd("20180108");
            skKariukekinpkakinDsBean.setIrSuitouymd("20180109");
            skKariukekinpkakinDsBean.setIrPkakingkyen(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
            skKariukekinpkakinDsBean.setIrPkakingk(BizCurrency.valueOf(9999999999l, BizCurrencyTypes.YEN));

            if (i == 24) {
                skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(25));
                skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(24000, BizCurrencyTypes.YEN));
                skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(9999999999999l, BizCurrencyTypes.YEN));
                skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(0));
                skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(null);
                skKariukekinpkakinDsBean.setIrKawasesasoneki(null);
            }

            dataSouceList.add(skKariukekinpkakinDsBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年 9月末　仮受金（Ｐ過金）明細");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 26; i++) {
            SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
            skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.AUD);
            skKariukekinpkakinDsBean.setIrSyuukeitani("豪ドル入金");
            skKariukekinpkakinDsBean.setIrMosno("123456789");
            skKariukekinpkakinDsBean.setIrKyknmkn("タナカ　タロウ");
            skKariukekinpkakinDsBean.setIrRyosyuymd("20180108");
            skKariukekinpkakinDsBean.setIrSuitouymd("20180109");
            skKariukekinpkakinDsBean.setIrPkakingkyen(BizCurrency.valueOf(80, BizCurrencyTypes.YEN));
            skKariukekinpkakinDsBean.setIrPkakingk(BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR));

            if (i == 25) {
                skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(26));
                skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(2080, BizCurrencyTypes.YEN));
                skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(2600, BizCurrencyTypes.AU_DOLLAR));
                skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(0.99));
                skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(BizCurrency.valueOf(7000, BizCurrencyTypes.YEN));
                skKariukekinpkakinDsBean.setIrKawasesasoneki(BizCurrency.valueOf(-8000, BizCurrencyTypes.YEN));
            }

            dataSouceList.add(skKariukekinpkakinDsBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINZANDAKAMEISAILIST);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年度第１四半期　仮受金（Ｐ過金）残高明細リスト");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINZANDAKAMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 26; i++) {
            SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
            skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.JPY);
            skKariukekinpkakinDsBean.setIrSyuukeitani("円入金");
            skKariukekinpkakinDsBean.setIrMosno("123456789");
            skKariukekinpkakinDsBean.setIrKyknmkn("タナカ　タロウ");
            skKariukekinpkakinDsBean.setIrRyosyuymd("20180108");
            skKariukekinpkakinDsBean.setIrSuitouymd("20180109");
            skKariukekinpkakinDsBean.setIrPkakingkyen(BizCurrency.valueOf(80, BizCurrencyTypes.YEN));
            skKariukekinpkakinDsBean.setIrPkakingk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));

            if (i == 25) {
                skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(26));
                skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(2080, BizCurrencyTypes.YEN));
                skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(2600, BizCurrencyTypes.YEN));
                skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(0.99));
                skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(BizCurrency.valueOf(7000, BizCurrencyTypes.YEN));
                skKariukekinpkakinDsBean.setIrKawasesasoneki(BizCurrency.valueOf(-8000, BizCurrencyTypes.YEN));
            }

            dataSouceList.add(skKariukekinpkakinDsBean);
        }

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean27 = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean27.setIrTuukasyu(C_Tuukasyu.USD);
        skKariukekinpkakinDsBean27.setIrSyuukeitani("米ドル入金");
        skKariukekinpkakinDsBean27.setIrMosno("100000001");
        skKariukekinpkakinDsBean27.setIrKyknmkn("タナカ　タロウ１");
        skKariukekinpkakinDsBean27.setIrRyosyuymd("20170101");
        skKariukekinpkakinDsBean27.setIrSuitouymd("20180110");
        skKariukekinpkakinDsBean27.setIrPkakingkyen(BizCurrency.valueOf(80, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean27.setIrPkakingk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        dataSouceList.add(skKariukekinpkakinDsBean27);

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean28 = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean28.setIrTuukasyu(C_Tuukasyu.USD);
        skKariukekinpkakinDsBean28.setIrSyuukeitani("米ドル入金");
        skKariukekinpkakinDsBean28.setIrMosno("100000001");
        skKariukekinpkakinDsBean28.setIrKyknmkn("タナカ　タロウ２");
        skKariukekinpkakinDsBean28.setIrRyosyuymd("20170102");
        skKariukekinpkakinDsBean28.setIrSuitouymd("20180111");
        skKariukekinpkakinDsBean28.setIrPkakingkyen(BizCurrency.valueOf(80, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean28.setIrPkakingk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        dataSouceList.add(skKariukekinpkakinDsBean28);

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean29 = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean29.setIrTuukasyu(C_Tuukasyu.USD);
        skKariukekinpkakinDsBean29.setIrSyuukeitani("米ドル入金");
        skKariukekinpkakinDsBean29.setIrMosno("100000002");
        skKariukekinpkakinDsBean29.setIrKyknmkn("タナカ　タロウ３");
        skKariukekinpkakinDsBean29.setIrRyosyuymd("20170103");
        skKariukekinpkakinDsBean29.setIrSuitouymd("20180111");
        skKariukekinpkakinDsBean29.setIrPkakingkyen(BizCurrency.valueOf(80, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean29.setIrPkakingk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        skKariukekinpkakinDsBean29.setIrKensuugoukei(BizNumber.valueOf(3));
        skKariukekinpkakinDsBean29.setIrKingakugoukeiyen(BizCurrency.valueOf(240, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean29.setIrKingakugoukei(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));
        skKariukekinpkakinDsBean29.setIrYenkansantkykwsrate(BizNumber.valueOf(0.99));
        skKariukekinpkakinDsBean29.setIrYenkansanpkakingkgoukei(BizCurrency.valueOf(7000, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean29.setIrKawasesasoneki(BizCurrency.valueOf(-8000, BizCurrencyTypes.YEN));
        dataSouceList.add(skKariukekinpkakinDsBean29);

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean30 = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean30.setIrTuukasyu(C_Tuukasyu.AUD);
        skKariukekinpkakinDsBean30.setIrSyuukeitani("豪ドル");
        skKariukekinpkakinDsBean30.setIrMosno("");
        skKariukekinpkakinDsBean30.setIrKyknmkn("");
        skKariukekinpkakinDsBean30.setIrRyosyuymd("");
        skKariukekinpkakinDsBean30.setIrSuitouymd("");
        skKariukekinpkakinDsBean30.setIrPkakingkyen(null);
        skKariukekinpkakinDsBean30.setIrPkakingk(null);
        skKariukekinpkakinDsBean30.setIrKensuugoukei(BizNumber.valueOf(0));
        skKariukekinpkakinDsBean30.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean30.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean30.setIrYenkansantkykwsrate(BizNumber.valueOf(0));
        skKariukekinpkakinDsBean30.setIrYenkansanpkakingkgoukei(null);
        skKariukekinpkakinDsBean30.setIrKawasesasoneki(null);
        dataSouceList.add(skKariukekinpkakinDsBean30);

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testCreateReport21(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINZANDAKAMEISAILIST);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年度第１四半期　仮受金（Ｐ過金）残高明細リスト");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINZANDAKAMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.JPY);
        skKariukekinpkakinDsBean.setIrSyuukeitani("円入金");
        skKariukekinpkakinDsBean.setIrMosno("");
        skKariukekinpkakinDsBean.setIrKyknmkn("");
        skKariukekinpkakinDsBean.setIrRyosyuymd("");
        skKariukekinpkakinDsBean.setIrSuitouymd("");
        skKariukekinpkakinDsBean.setIrPkakingkyen(null);
        skKariukekinpkakinDsBean.setIrPkakingk(null);
        skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(0));
        skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(0));
        skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(null);
        skKariukekinpkakinDsBean.setIrKawasesasoneki(null);

        dataSouceList.add(skKariukekinpkakinDsBean);

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testCreateReport22(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINZANDAKAMEISAILIST);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年度第１四半期　仮受金（Ｐ過金）残高明細リスト");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINZANDAKAMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.AUD);
        skKariukekinpkakinDsBean.setIrSyuukeitani("豪ドル入金");
        skKariukekinpkakinDsBean.setIrMosno("");
        skKariukekinpkakinDsBean.setIrKyknmkn("");
        skKariukekinpkakinDsBean.setIrRyosyuymd("");
        skKariukekinpkakinDsBean.setIrSuitouymd("");
        skKariukekinpkakinDsBean.setIrPkakingkyen(null);
        skKariukekinpkakinDsBean.setIrPkakingk(null);
        skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(0));
        skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(0));
        skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(null);
        skKariukekinpkakinDsBean.setIrKawasesasoneki(null);

        dataSouceList.add(skKariukekinpkakinDsBean);

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testCreateReport23(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINZANDAKAMEISAILIST);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年 9月末　仮受金（Ｐ過金）明細");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
        skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.AUD);
        skKariukekinpkakinDsBean.setIrSyuukeitani("豪ドル入金");
        skKariukekinpkakinDsBean.setIrMosno("123456789");
        skKariukekinpkakinDsBean.setIrKyknmkn("タナカ　タロウ");
        skKariukekinpkakinDsBean.setIrRyosyuymd("20180108");
        skKariukekinpkakinDsBean.setIrSuitouymd("20180109");
        skKariukekinpkakinDsBean.setIrPkakingkyen(BizCurrency.valueOf(80, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrPkakingk(BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(80, BizCurrencyTypes.YEN));
        skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR));
        skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(null);
        skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(null);
        skKariukekinpkakinDsBean.setIrKawasesasoneki(null);

        dataSouceList.add(skKariukekinpkakinDsBean);

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testCreateReport24(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKariukekinpkakinmeisaiTest", C_SyoruiCdKbn.SK_KARIUKEKINPKAKINZANDAKAMEISAILIST);

        skKariukekinpkakinBean.setIrAtesaki("代理店契約室　御中");
        skKariukekinpkakinBean.setIrTyouhyousakuseiymd("平成30年 1月 8日");
        skKariukekinpkakinBean.setIrTyouhyoutitle("平成29年 9月末　仮受金（Ｐ過金）明細");
        skKariukekinpkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEKINPKAKINMEISAI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 2475; i++) {
            SkKariukekinpkakinDataSourceBean skKariukekinpkakinDsBean = new SkKariukekinpkakinDataSourceBean();
            skKariukekinpkakinDsBean.setIrTuukasyu(C_Tuukasyu.AUD);
            skKariukekinpkakinDsBean.setIrSyuukeitani("豪ドル入金");
            skKariukekinpkakinDsBean.setIrMosno("123456789");
            skKariukekinpkakinDsBean.setIrKyknmkn("タナカ　タロウ");
            skKariukekinpkakinDsBean.setIrRyosyuymd("20180108");
            skKariukekinpkakinDsBean.setIrSuitouymd("20180109");
            skKariukekinpkakinDsBean.setIrPkakingkyen(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
            skKariukekinpkakinDsBean.setIrPkakingk(BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR));

            if (i==2474) {
                skKariukekinpkakinDsBean.setIrKensuugoukei(BizNumber.valueOf(2475));
                skKariukekinpkakinDsBean.setIrKingakugoukeiyen(BizCurrency.valueOf(24750, BizCurrencyTypes.YEN));
                skKariukekinpkakinDsBean.setIrKingakugoukei(BizCurrency.valueOf(24750, BizCurrencyTypes.AU_DOLLAR));
                skKariukekinpkakinDsBean.setIrYenkansantkykwsrate(BizNumber.valueOf(0.99));
                skKariukekinpkakinDsBean.setIrYenkansanpkakingkgoukei(BizCurrency.valueOf(15400000, BizCurrencyTypes.YEN));
                skKariukekinpkakinDsBean.setIrKawasesasoneki(BizCurrency.valueOf(-1400000, BizCurrencyTypes.YEN));
            }

            dataSouceList.add(skKariukekinpkakinDsBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skKariukekinpkakinBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
