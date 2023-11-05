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

import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SkFstpuriagemeisaiBean;
import yuyu.def.sinkeiyaku.bean.report.SkFstpuriagemeisaiDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 初回保険料クレジットカード扱売上請求明細票<br />
 */
@RunWith(OrderedRunner.class)
public class SkFstpuriageseikyuumeisaiTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkFstpuriagemeisaiBean skFstpuriagemeisaiBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuumeisaiTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUMEISAI_JCB);

        skFstpuriagemeisaiBean.setIrAtesaki(null);
        skFstpuriagemeisaiBean.setIrTyouhyousakuseiymd(null);
        skFstpuriagemeisaiBean.setIrCardkaisya(null);
        skFstpuriagemeisaiBean.setIrSyuukeicomment(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkFstpuriagemeisaiDataSourceBean skFstpuriagemeisaiDataSourceBean = new SkFstpuriagemeisaiDataSourceBean();

        skFstpuriagemeisaiDataSourceBean.setIrRenno(null);
        skFstpuriagemeisaiDataSourceBean.setIrCardbrand(null);
        skFstpuriagemeisaiDataSourceBean.setIrDatasousinymd(null);
        skFstpuriagemeisaiDataSourceBean.setIrMosno(null);
        skFstpuriagemeisaiDataSourceBean.setIrRsgaku(null);
        skFstpuriagemeisaiDataSourceBean.setIrRyosyuymd(null);
        skFstpuriagemeisaiDataSourceBean.setIrHknsyurui(null);
        skFstpuriagemeisaiDataSourceBean.setIrKykymd(null);
        skFstpuriagemeisaiDataSourceBean.setIrSeirituymd(null);
        skFstpuriagemeisaiDataSourceBean.setIrCreditkessaiyouno(null);
        skFstpuriagemeisaiDataSourceBean.setIrKensuugoukei(null);
        skFstpuriagemeisaiDataSourceBean.setIrGoukeikingk(null);

        dataSouceList.add(skFstpuriagemeisaiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skFstpuriagemeisaiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuumeisaiTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUMEISAI_JCB);

        skFstpuriagemeisaiBean.setIrAtesaki("");
        skFstpuriagemeisaiBean.setIrTyouhyousakuseiymd("");
        skFstpuriagemeisaiBean.setIrCardkaisya("");
        skFstpuriagemeisaiBean.setIrSyuukeicomment("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkFstpuriagemeisaiDataSourceBean skFstpuriagemeisaiDataSourceBean = new SkFstpuriagemeisaiDataSourceBean();

        skFstpuriagemeisaiDataSourceBean.setIrRenno(0);
        skFstpuriagemeisaiDataSourceBean.setIrCardbrand("");
        skFstpuriagemeisaiDataSourceBean.setIrDatasousinymd("");
        skFstpuriagemeisaiDataSourceBean.setIrMosno("");
        skFstpuriagemeisaiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skFstpuriagemeisaiDataSourceBean.setIrRyosyuymd("");
        skFstpuriagemeisaiDataSourceBean.setIrHknsyurui("");
        skFstpuriagemeisaiDataSourceBean.setIrKykymd("");
        skFstpuriagemeisaiDataSourceBean.setIrSeirituymd("");
        skFstpuriagemeisaiDataSourceBean.setIrCreditkessaiyouno("");
        skFstpuriagemeisaiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(0));
        skFstpuriagemeisaiDataSourceBean.setIrGoukeikingk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        dataSouceList.add(skFstpuriagemeisaiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skFstpuriagemeisaiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuumeisaiTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUMEISAI_JCB);

        skFstpuriagemeisaiBean.setIrAtesaki("代理店契約室　御中");
        skFstpuriagemeisaiBean.setIrTyouhyousakuseiymd("2020年 7月30日");
        skFstpuriagemeisaiBean.setIrCardkaisya(C_CardBrandKbn.JCB.getContent());
        skFstpuriagemeisaiBean.setIrSyuukeicomment("※当リスト集計対象はデータ送信日（集計日）：前月１９日～当月１８日　集計基準日は投入日（データ送信日＋２日）：前月２１日～当月２０日）");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 14; i++) {

            SkFstpuriagemeisaiDataSourceBean skFstpuriagemeisaiDataSourceBean = new SkFstpuriagemeisaiDataSourceBean();

            skFstpuriagemeisaiDataSourceBean.setIrRenno(11111);
            skFstpuriagemeisaiDataSourceBean.setIrCardbrand("Ａｍｅｘ");
            skFstpuriagemeisaiDataSourceBean.setIrDatasousinymd("20200730");
            skFstpuriagemeisaiDataSourceBean.setIrMosno("100000001");
            skFstpuriagemeisaiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
            skFstpuriagemeisaiDataSourceBean.setIrRyosyuymd("20190730");
            skFstpuriagemeisaiDataSourceBean.setIrHknsyurui("たのしみ未来グローバル");
            skFstpuriagemeisaiDataSourceBean.setIrKykymd("20210730");
            skFstpuriagemeisaiDataSourceBean.setIrSeirituymd("20200630");
            skFstpuriagemeisaiDataSourceBean.setIrCreditkessaiyouno("10000000100000111111010102");
            skFstpuriagemeisaiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(14));
            skFstpuriagemeisaiDataSourceBean.setIrGoukeikingk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));

            dataSouceList.add(skFstpuriagemeisaiDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skFstpuriagemeisaiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuumeisaiTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUMEISAI_VISA);

        skFstpuriagemeisaiBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        skFstpuriagemeisaiBean.setIrCardkaisya("ＷＷＷＷＷ");
        skFstpuriagemeisaiBean.setIrSyuukeicomment("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 15; i++) {

            SkFstpuriagemeisaiDataSourceBean skFstpuriagemeisaiDataSourceBean = new SkFstpuriagemeisaiDataSourceBean();

            skFstpuriagemeisaiDataSourceBean.setIrRenno(99999);
            skFstpuriagemeisaiDataSourceBean.setIrCardbrand("ＷＷＷＷＷＷ");
            skFstpuriagemeisaiDataSourceBean.setIrDatasousinymd("99999999");
            skFstpuriagemeisaiDataSourceBean.setIrMosno("wwwwwwwww");
            skFstpuriagemeisaiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
            skFstpuriagemeisaiDataSourceBean.setIrRyosyuymd("99999999");
            skFstpuriagemeisaiDataSourceBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skFstpuriagemeisaiDataSourceBean.setIrKykymd("99999999");
            skFstpuriagemeisaiDataSourceBean.setIrSeirituymd("99999999");
            skFstpuriagemeisaiDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
            skFstpuriagemeisaiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(15));
            skFstpuriagemeisaiDataSourceBean.setIrGoukeikingk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));

            dataSouceList.add(skFstpuriagemeisaiDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skFstpuriagemeisaiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuumeisaiTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUMEISAI_VISA);

        skFstpuriagemeisaiBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        skFstpuriagemeisaiBean.setIrCardkaisya(C_CardBrandKbn.VISA.getContent());
        skFstpuriagemeisaiBean.setIrSyuukeicomment("※当リスト集計対象はデータ送信日（送付日）：前月１６日～当月１５日　集計基準日はデータ送信日：前月１６日～当月１５日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 16; i++) {

            SkFstpuriagemeisaiDataSourceBean skFstpuriagemeisaiDataSourceBean = new SkFstpuriagemeisaiDataSourceBean();

            skFstpuriagemeisaiDataSourceBean.setIrRenno(99999);
            skFstpuriagemeisaiDataSourceBean.setIrCardbrand("Ａｍｅｘ");
            skFstpuriagemeisaiDataSourceBean.setIrDatasousinymd("99999999");
            skFstpuriagemeisaiDataSourceBean.setIrMosno("wwwwwwwww");
            skFstpuriagemeisaiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
            skFstpuriagemeisaiDataSourceBean.setIrRyosyuymd("99999999");
            skFstpuriagemeisaiDataSourceBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skFstpuriagemeisaiDataSourceBean.setIrKykymd("99999999");
            skFstpuriagemeisaiDataSourceBean.setIrSeirituymd("99999999");
            skFstpuriagemeisaiDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
            skFstpuriagemeisaiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(16));
            skFstpuriagemeisaiDataSourceBean.setIrGoukeikingk(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

            dataSouceList.add(skFstpuriagemeisaiDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skFstpuriagemeisaiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuumeisaiTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUMEISAI_VISA);

        skFstpuriagemeisaiBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        skFstpuriagemeisaiBean.setIrCardkaisya(C_CardBrandKbn.VISA.getContent());
        skFstpuriagemeisaiBean.setIrSyuukeicomment("※当リスト集計対象はデータ送信日（送付日）：前月１６日～当月１５日　集計基準日はデータ送信日：前月１６日～当月１５日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 999; i++) {

            SkFstpuriagemeisaiDataSourceBean skFstpuriagemeisaiDataSourceBean = new SkFstpuriagemeisaiDataSourceBean();

            skFstpuriagemeisaiDataSourceBean.setIrRenno(99999);
            skFstpuriagemeisaiDataSourceBean.setIrCardbrand("Ａｍｅｘ");
            skFstpuriagemeisaiDataSourceBean.setIrDatasousinymd("99999999");
            skFstpuriagemeisaiDataSourceBean.setIrMosno("wwwwwwwww");
            skFstpuriagemeisaiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
            skFstpuriagemeisaiDataSourceBean.setIrRyosyuymd("99999999");
            skFstpuriagemeisaiDataSourceBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skFstpuriagemeisaiDataSourceBean.setIrKykymd("99999999");
            skFstpuriagemeisaiDataSourceBean.setIrSeirituymd("99999999");
            skFstpuriagemeisaiDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
            skFstpuriagemeisaiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(999));
            skFstpuriagemeisaiDataSourceBean.setIrGoukeikingk(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));

            dataSouceList.add(skFstpuriagemeisaiDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skFstpuriagemeisaiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuumeisaiTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUMEISAI_VISA);

        skFstpuriagemeisaiBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        skFstpuriagemeisaiBean.setIrCardkaisya(C_CardBrandKbn.VISA.getContent());
        skFstpuriagemeisaiBean.setIrSyuukeicomment("※当リスト集計対象はデータ送信日（送付日）：前月１６日～当月１５日　集計基準日はデータ送信日：前月１６日～当月１５日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, skFstpuriagemeisaiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuumeisaiTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUMEISAI_VISA);

        skFstpuriagemeisaiBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        skFstpuriagemeisaiBean.setIrCardkaisya(C_CardBrandKbn.VISA.getContent());
        skFstpuriagemeisaiBean.setIrSyuukeicomment("※当リスト集計対象はデータ送信日（送付日）：前月１６日～当月１５日　集計基準日はデータ送信日：前月１６日～当月１５日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 14984; i++) {

            SkFstpuriagemeisaiDataSourceBean skFstpuriagemeisaiDataSourceBean = new SkFstpuriagemeisaiDataSourceBean();

            skFstpuriagemeisaiDataSourceBean.setIrRenno(99999);
            skFstpuriagemeisaiDataSourceBean.setIrCardbrand("Ａｍｅｘ");
            skFstpuriagemeisaiDataSourceBean.setIrDatasousinymd("99999999");
            skFstpuriagemeisaiDataSourceBean.setIrMosno("wwwwwwwww");
            skFstpuriagemeisaiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
            skFstpuriagemeisaiDataSourceBean.setIrRyosyuymd("99999999");
            skFstpuriagemeisaiDataSourceBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skFstpuriagemeisaiDataSourceBean.setIrKykymd("99999999");
            skFstpuriagemeisaiDataSourceBean.setIrSeirituymd("99999999");
            skFstpuriagemeisaiDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
            skFstpuriagemeisaiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(14984));
            skFstpuriagemeisaiDataSourceBean.setIrGoukeikingk(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));

            dataSouceList.add(skFstpuriagemeisaiDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skFstpuriagemeisaiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuumeisaiTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUMEISAI_VISA);

        skFstpuriagemeisaiBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        skFstpuriagemeisaiBean.setIrCardkaisya(C_CardBrandKbn.VISA.getContent());
        skFstpuriagemeisaiBean.setIrSyuukeicomment("※当リスト集計対象はデータ送信日（送付日）：前月１６日～当月１５日　集計基準日はデータ送信日：前月１６日～当月１５日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkFstpuriagemeisaiDataSourceBean skFstpuriagemeisaiDataSourceBean = new SkFstpuriagemeisaiDataSourceBean();

        skFstpuriagemeisaiDataSourceBean.setIrRenno(99999);
        skFstpuriagemeisaiDataSourceBean.setIrCardbrand("Ａｍｅｘ");
        skFstpuriagemeisaiDataSourceBean.setIrDatasousinymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrMosno("wwwwwwwww");
        skFstpuriagemeisaiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skFstpuriagemeisaiDataSourceBean.setIrRyosyuymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiDataSourceBean.setIrKykymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrSeirituymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFstpuriagemeisaiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skFstpuriagemeisaiDataSourceBean.setIrGoukeikingk(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));

        dataSouceList.add(skFstpuriagemeisaiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skFstpuriagemeisaiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuumeisaiTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUMEISAI_VISA);

        skFstpuriagemeisaiBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        skFstpuriagemeisaiBean.setIrCardkaisya(C_CardBrandKbn.VISA.getContent());
        skFstpuriagemeisaiBean.setIrSyuukeicomment("※当リスト集計対象はデータ送信日（送付日）：前月１６日～当月１５日　集計基準日はデータ送信日：前月１６日～当月１５日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkFstpuriagemeisaiDataSourceBean skFstpuriagemeisaiDataSourceBean = new SkFstpuriagemeisaiDataSourceBean();

        skFstpuriagemeisaiDataSourceBean.setIrRenno(99999);
        skFstpuriagemeisaiDataSourceBean.setIrCardbrand("Ａｍｅｘ");
        skFstpuriagemeisaiDataSourceBean.setIrDatasousinymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrMosno("wwwwwwwww");
        skFstpuriagemeisaiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skFstpuriagemeisaiDataSourceBean.setIrRyosyuymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiDataSourceBean.setIrKykymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrSeirituymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFstpuriagemeisaiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skFstpuriagemeisaiDataSourceBean.setIrGoukeikingk(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));

        dataSouceList.add(skFstpuriagemeisaiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skFstpuriagemeisaiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuumeisaiTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUMEISAI_VISA);

        skFstpuriagemeisaiBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        skFstpuriagemeisaiBean.setIrCardkaisya(C_CardBrandKbn.VISA.getContent());
        skFstpuriagemeisaiBean.setIrSyuukeicomment("※当リスト集計対象はデータ送信日（送付日）：前月１６日～当月１５日　集計基準日はデータ送信日：前月１６日～当月１５日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkFstpuriagemeisaiDataSourceBean skFstpuriagemeisaiDataSourceBean = new SkFstpuriagemeisaiDataSourceBean();

        skFstpuriagemeisaiDataSourceBean.setIrRenno(99999);
        skFstpuriagemeisaiDataSourceBean.setIrCardbrand("Ａｍｅｘ");
        skFstpuriagemeisaiDataSourceBean.setIrDatasousinymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrMosno("wwwwwwwww");
        skFstpuriagemeisaiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skFstpuriagemeisaiDataSourceBean.setIrRyosyuymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiDataSourceBean.setIrKykymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrSeirituymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFstpuriagemeisaiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skFstpuriagemeisaiDataSourceBean.setIrGoukeikingk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(skFstpuriagemeisaiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skFstpuriagemeisaiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuumeisaiTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUMEISAI_VISA);

        skFstpuriagemeisaiBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        skFstpuriagemeisaiBean.setIrCardkaisya(C_CardBrandKbn.VISA.getContent());
        skFstpuriagemeisaiBean.setIrSyuukeicomment("※当リスト集計対象はデータ送信日（送付日）：前月１６日～当月１５日　集計基準日はデータ送信日：前月１６日～当月１５日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkFstpuriagemeisaiDataSourceBean skFstpuriagemeisaiDataSourceBean = new SkFstpuriagemeisaiDataSourceBean();

        skFstpuriagemeisaiDataSourceBean.setIrRenno(99999);
        skFstpuriagemeisaiDataSourceBean.setIrCardbrand("Ａｍｅｘ");
        skFstpuriagemeisaiDataSourceBean.setIrDatasousinymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrMosno("wwwwwwwww");
        skFstpuriagemeisaiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR));
        skFstpuriagemeisaiDataSourceBean.setIrRyosyuymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiDataSourceBean.setIrKykymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrSeirituymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFstpuriagemeisaiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skFstpuriagemeisaiDataSourceBean.setIrGoukeikingk(BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(skFstpuriagemeisaiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skFstpuriagemeisaiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuumeisaiTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUMEISAI_VISA);

        skFstpuriagemeisaiBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        skFstpuriagemeisaiBean.setIrCardkaisya(C_CardBrandKbn.VISA.getContent());
        skFstpuriagemeisaiBean.setIrSyuukeicomment("※当リスト集計対象はデータ送信日（送付日）：前月１６日～当月１５日　集計基準日はデータ送信日：前月１６日～当月１５日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkFstpuriagemeisaiDataSourceBean skFstpuriagemeisaiDataSourceBean = new SkFstpuriagemeisaiDataSourceBean();

        skFstpuriagemeisaiDataSourceBean.setIrRenno(99999);
        skFstpuriagemeisaiDataSourceBean.setIrCardbrand("Ａｍｅｘ");
        skFstpuriagemeisaiDataSourceBean.setIrDatasousinymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrMosno("wwwwwwwww");
        skFstpuriagemeisaiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9999999999l, BizCurrencyTypes.YEN));
        skFstpuriagemeisaiDataSourceBean.setIrRyosyuymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiDataSourceBean.setIrKykymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrSeirituymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFstpuriagemeisaiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skFstpuriagemeisaiDataSourceBean.setIrGoukeikingk(BizCurrency.valueOf(9999999999999l, BizCurrencyTypes.YEN));

        dataSouceList.add(skFstpuriagemeisaiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skFstpuriagemeisaiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuumeisaiTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUMEISAI_VISA);

        skFstpuriagemeisaiBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        skFstpuriagemeisaiBean.setIrCardkaisya(C_CardBrandKbn.VISA.getContent());
        skFstpuriagemeisaiBean.setIrSyuukeicomment("※当リスト集計対象はデータ送信日（送付日）：前月１６日～当月１５日　集計基準日はデータ送信日：前月１６日～当月１５日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkFstpuriagemeisaiDataSourceBean skFstpuriagemeisaiDataSourceBean = new SkFstpuriagemeisaiDataSourceBean();

        skFstpuriagemeisaiDataSourceBean.setIrRenno(99999);
        skFstpuriagemeisaiDataSourceBean.setIrCardbrand("Ａｍｅｘ");
        skFstpuriagemeisaiDataSourceBean.setIrDatasousinymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrMosno("wwwwwwwww");
        skFstpuriagemeisaiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skFstpuriagemeisaiDataSourceBean.setIrRyosyuymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiDataSourceBean.setIrKykymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrSeirituymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFstpuriagemeisaiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skFstpuriagemeisaiDataSourceBean.setIrGoukeikingk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(skFstpuriagemeisaiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skFstpuriagemeisaiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuumeisaiTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUMEISAI_VISA);

        skFstpuriagemeisaiBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        skFstpuriagemeisaiBean.setIrCardkaisya(C_CardBrandKbn.VISA.getContent());
        skFstpuriagemeisaiBean.setIrSyuukeicomment("※当リスト集計対象はデータ送信日（送付日）：前月１６日～当月１５日　集計基準日はデータ送信日：前月１６日～当月１５日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkFstpuriagemeisaiDataSourceBean skFstpuriagemeisaiDataSourceBean = new SkFstpuriagemeisaiDataSourceBean();

        skFstpuriagemeisaiDataSourceBean.setIrRenno(99999);
        skFstpuriagemeisaiDataSourceBean.setIrCardbrand("Ａｍｅｘ");
        skFstpuriagemeisaiDataSourceBean.setIrDatasousinymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrMosno("wwwwwwwww");
        skFstpuriagemeisaiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skFstpuriagemeisaiDataSourceBean.setIrRyosyuymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiDataSourceBean.setIrKykymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrSeirituymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFstpuriagemeisaiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skFstpuriagemeisaiDataSourceBean.setIrGoukeikingk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(skFstpuriagemeisaiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skFstpuriagemeisaiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuumeisaiTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUMEISAI_VISA);

        skFstpuriagemeisaiBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        skFstpuriagemeisaiBean.setIrCardkaisya(C_CardBrandKbn.VISA.getContent());
        skFstpuriagemeisaiBean.setIrSyuukeicomment("※当リスト集計対象はデータ送信日（送付日）：前月１６日～当月１５日　集計基準日はデータ送信日：前月１６日～当月１５日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkFstpuriagemeisaiDataSourceBean skFstpuriagemeisaiDataSourceBean = new SkFstpuriagemeisaiDataSourceBean();

        skFstpuriagemeisaiDataSourceBean.setIrRenno(99999);
        skFstpuriagemeisaiDataSourceBean.setIrCardbrand("Ａｍｅｘ");
        skFstpuriagemeisaiDataSourceBean.setIrDatasousinymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrMosno("wwwwwwwww");
        skFstpuriagemeisaiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skFstpuriagemeisaiDataSourceBean.setIrRyosyuymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiDataSourceBean.setIrKykymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrSeirituymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFstpuriagemeisaiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skFstpuriagemeisaiDataSourceBean.setIrGoukeikingk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(skFstpuriagemeisaiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skFstpuriagemeisaiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuumeisaiTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUMEISAI_VISA);

        skFstpuriagemeisaiBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        skFstpuriagemeisaiBean.setIrCardkaisya(C_CardBrandKbn.VISA.getContent());
        skFstpuriagemeisaiBean.setIrSyuukeicomment("※当リスト集計対象はデータ送信日（送付日）：前月１６日～当月１５日　集計基準日はデータ送信日：前月１６日～当月１５日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkFstpuriagemeisaiDataSourceBean skFstpuriagemeisaiDataSourceBean = new SkFstpuriagemeisaiDataSourceBean();

        skFstpuriagemeisaiDataSourceBean.setIrRenno(99999);
        skFstpuriagemeisaiDataSourceBean.setIrCardbrand("Ａｍｅｘ");
        skFstpuriagemeisaiDataSourceBean.setIrDatasousinymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrMosno("wwwwwwwww");
        skFstpuriagemeisaiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skFstpuriagemeisaiDataSourceBean.setIrRyosyuymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiDataSourceBean.setIrKykymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrSeirituymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFstpuriagemeisaiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skFstpuriagemeisaiDataSourceBean.setIrGoukeikingk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(skFstpuriagemeisaiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skFstpuriagemeisaiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuumeisaiTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUMEISAI_VISA);

        skFstpuriagemeisaiBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        skFstpuriagemeisaiBean.setIrCardkaisya(C_CardBrandKbn.VISA.getContent());
        skFstpuriagemeisaiBean.setIrSyuukeicomment("※当リスト集計対象はデータ送信日（送付日）：前月１６日～当月１５日　集計基準日はデータ送信日：前月１６日～当月１５日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkFstpuriagemeisaiDataSourceBean skFstpuriagemeisaiDataSourceBean = new SkFstpuriagemeisaiDataSourceBean();

        skFstpuriagemeisaiDataSourceBean.setIrRenno(99999);
        skFstpuriagemeisaiDataSourceBean.setIrCardbrand("Ａｍｅｘ");
        skFstpuriagemeisaiDataSourceBean.setIrDatasousinymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrMosno("wwwwwwwww");
        skFstpuriagemeisaiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skFstpuriagemeisaiDataSourceBean.setIrRyosyuymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skFstpuriagemeisaiDataSourceBean.setIrKykymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrSeirituymd("99999999");
        skFstpuriagemeisaiDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFstpuriagemeisaiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skFstpuriagemeisaiDataSourceBean.setIrGoukeikingk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(skFstpuriagemeisaiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skFstpuriagemeisaiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}