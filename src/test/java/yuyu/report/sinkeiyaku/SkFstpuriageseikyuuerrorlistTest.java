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

import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SkFsturiagekekkaerrorlistDataSourceBean;
import yuyu.def.sinkeiyaku.bean.report.SkSyanailistheaderBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 初回保険料売上請求エラーリスト<br />
 */
@RunWith(OrderedRunner.class)
public class SkFstpuriageseikyuuerrorlistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkSyanailistheaderBean skSyanailistheaderBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuuerrorlistTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki(null);
        skSyanailistheaderBean.setIrTyouhyousakuseiymd(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean = new SkFsturiagekekkaerrorlistDataSourceBean();

        skFsturiagekekkaerrorlistDataSourceBean.setIrCreditkessaiyouno(null);
        skFsturiagekekkaerrorlistDataSourceBean.setIrCredituriagegk(null);
        skFsturiagekekkaerrorlistDataSourceBean.setIrCredituriagengjiyuu(null);
        skFsturiagekekkaerrorlistDataSourceBean.setIrSeikyuuerrorriyuu(null);
        skFsturiagekekkaerrorlistDataSourceBean.setIrUriageseikyuuerrcd(null);
        skFsturiagekekkaerrorlistDataSourceBean.setIrKensuugoukei(null);

        dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuuerrorlistTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean = new SkFsturiagekekkaerrorlistDataSourceBean();

        skFsturiagekekkaerrorlistDataSourceBean.setIrCreditkessaiyouno("");
        skFsturiagekekkaerrorlistDataSourceBean.setIrCredituriagegk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skFsturiagekekkaerrorlistDataSourceBean.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.BLNK);
        skFsturiagekekkaerrorlistDataSourceBean.setIrSeikyuuerrorriyuu("");
        skFsturiagekekkaerrorlistDataSourceBean.setIrUriageseikyuuerrcd("");
        skFsturiagekekkaerrorlistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(0));

        dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuuerrorlistTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("代理店契約室　御中");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("2019年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 14; i++) {

            SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean = new SkFsturiagekekkaerrorlistDataSourceBean();

            skFsturiagekekkaerrorlistDataSourceBean.setIrCreditkessaiyouno("10000000100000111111010102");
            skFsturiagekekkaerrorlistDataSourceBean.setIrCredituriagegk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
            skFsturiagekekkaerrorlistDataSourceBean.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.KINKYUUTEISI);
            skFsturiagekekkaerrorlistDataSourceBean.setIrSeikyuuerrorriyuu("クレジットカードの有効期限エラー");
            skFsturiagekekkaerrorlistDataSourceBean.setIrUriageseikyuuerrcd("k04");
            skFsturiagekekkaerrorlistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(14));

            dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuuerrorlistTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 15; i++) {

            SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean = new SkFsturiagekekkaerrorlistDataSourceBean();

            skFsturiagekekkaerrorlistDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
            skFsturiagekekkaerrorlistDataSourceBean.setIrCredituriagegk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
            skFsturiagekekkaerrorlistDataSourceBean.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.CARDGAISYAERROR);
            skFsturiagekekkaerrorlistDataSourceBean.setIrSeikyuuerrorriyuu("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skFsturiagekekkaerrorlistDataSourceBean.setIrUriageseikyuuerrcd("ＷＷＷ");
            skFsturiagekekkaerrorlistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(15));

            dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuuerrorlistTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 16; i++) {

            SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean = new SkFsturiagekekkaerrorlistDataSourceBean();

            skFsturiagekekkaerrorlistDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
            skFsturiagekekkaerrorlistDataSourceBean.setIrCredituriagegk(BizCurrency.valueOf(1111.2222, BizCurrencyTypes.AU_DOLLAR));
            skFsturiagekekkaerrorlistDataSourceBean.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.CARDGAISYAERROR);
            skFsturiagekekkaerrorlistDataSourceBean.setIrSeikyuuerrorriyuu("収納代行センターにて送信先カード判定エラー");
            skFsturiagekekkaerrorlistDataSourceBean.setIrUriageseikyuuerrcd("ＷＷＷ");
            skFsturiagekekkaerrorlistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(16));

            dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuuerrorlistTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 999; i++) {

            SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean = new SkFsturiagekekkaerrorlistDataSourceBean();

            skFsturiagekekkaerrorlistDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
            skFsturiagekekkaerrorlistDataSourceBean.setIrCredituriagegk(BizCurrency.valueOf(1111, BizCurrencyTypes.AU_DOLLAR));
            skFsturiagekekkaerrorlistDataSourceBean.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.CARDGAISYAERROR);
            skFsturiagekekkaerrorlistDataSourceBean.setIrSeikyuuerrorriyuu("収納代行センターにて送信先カード判定エラー");
            skFsturiagekekkaerrorlistDataSourceBean.setIrUriageseikyuuerrcd("ＷＷＷ");
            skFsturiagekekkaerrorlistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(999));

            dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuuerrorlistTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuuerrorlistTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 14984; i++) {

            SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean = new SkFsturiagekekkaerrorlistDataSourceBean();

            skFsturiagekekkaerrorlistDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
            skFsturiagekekkaerrorlistDataSourceBean.setIrCredituriagegk(BizCurrency.valueOf(1234, BizCurrencyTypes.YEN));
            skFsturiagekekkaerrorlistDataSourceBean.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.CARDGAISYAERROR);
            skFsturiagekekkaerrorlistDataSourceBean.setIrSeikyuuerrorriyuu("収納代行センターにて送信先カード判定エラー");
            skFsturiagekekkaerrorlistDataSourceBean.setIrUriageseikyuuerrcd("ＷＷＷ");
            skFsturiagekekkaerrorlistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(14984));

            dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkFstpuriageseikyuuerrorlistTest", C_SyoruiCdKbn.SK_FSTPURIAGESEIKYUUERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean1 = new SkFsturiagekekkaerrorlistDataSourceBean();
        SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean2 = new SkFsturiagekekkaerrorlistDataSourceBean();
        SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean3 = new SkFsturiagekekkaerrorlistDataSourceBean();
        SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean4 = new SkFsturiagekekkaerrorlistDataSourceBean();
        SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean5 = new SkFsturiagekekkaerrorlistDataSourceBean();
        SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean6 = new SkFsturiagekekkaerrorlistDataSourceBean();
        SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean7 = new SkFsturiagekekkaerrorlistDataSourceBean();
        SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean8 = new SkFsturiagekekkaerrorlistDataSourceBean();
        SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean9 = new SkFsturiagekekkaerrorlistDataSourceBean();
        SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean10 = new SkFsturiagekekkaerrorlistDataSourceBean();
        SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean11 = new SkFsturiagekekkaerrorlistDataSourceBean();
        SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean12 = new SkFsturiagekekkaerrorlistDataSourceBean();
        SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean13 = new SkFsturiagekekkaerrorlistDataSourceBean();
        SkFsturiagekekkaerrorlistDataSourceBean skFsturiagekekkaerrorlistDataSourceBean14 = new SkFsturiagekekkaerrorlistDataSourceBean();

        skFsturiagekekkaerrorlistDataSourceBean1.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFsturiagekekkaerrorlistDataSourceBean1.setIrCredituriagegk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skFsturiagekekkaerrorlistDataSourceBean1.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.CARDGAISYAERROR);
        skFsturiagekekkaerrorlistDataSourceBean1.setIrSeikyuuerrorriyuu("収納代行センターにて送信先カード判定エラー");
        skFsturiagekekkaerrorlistDataSourceBean1.setIrUriageseikyuuerrcd("ＷＷＷ");
        skFsturiagekekkaerrorlistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(14));

        skFsturiagekekkaerrorlistDataSourceBean2.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFsturiagekekkaerrorlistDataSourceBean2.setIrCredituriagegk(BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR));
        skFsturiagekekkaerrorlistDataSourceBean2.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.CARDGAISYAERROR);
        skFsturiagekekkaerrorlistDataSourceBean2.setIrSeikyuuerrorriyuu("収納代行センターにて送信先カード判定エラー");
        skFsturiagekekkaerrorlistDataSourceBean2.setIrUriageseikyuuerrcd("ＷＷＷ");
        skFsturiagekekkaerrorlistDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(14));

        skFsturiagekekkaerrorlistDataSourceBean3.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFsturiagekekkaerrorlistDataSourceBean3.setIrCredituriagegk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skFsturiagekekkaerrorlistDataSourceBean3.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.CARDGAISYAERROR);
        skFsturiagekekkaerrorlistDataSourceBean3.setIrSeikyuuerrorriyuu("収納代行センターにて送信先カード判定エラー");
        skFsturiagekekkaerrorlistDataSourceBean3.setIrUriageseikyuuerrcd("ＷＷＷ");
        skFsturiagekekkaerrorlistDataSourceBean3.setIrKensuugoukei(BizNumber.valueOf(14));

        skFsturiagekekkaerrorlistDataSourceBean4.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFsturiagekekkaerrorlistDataSourceBean4.setIrCredituriagegk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skFsturiagekekkaerrorlistDataSourceBean4.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.CARDGAISYAERROR);
        skFsturiagekekkaerrorlistDataSourceBean4.setIrSeikyuuerrorriyuu("収納代行センターにて送信先カード判定エラー");
        skFsturiagekekkaerrorlistDataSourceBean4.setIrUriageseikyuuerrcd("ＷＷＷ");
        skFsturiagekekkaerrorlistDataSourceBean4.setIrKensuugoukei(BizNumber.valueOf(14));

        skFsturiagekekkaerrorlistDataSourceBean5.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFsturiagekekkaerrorlistDataSourceBean5.setIrCredituriagegk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skFsturiagekekkaerrorlistDataSourceBean5.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.CARDGAISYAERROR);
        skFsturiagekekkaerrorlistDataSourceBean5.setIrSeikyuuerrorriyuu("収納代行センターにて送信先カード判定エラー");
        skFsturiagekekkaerrorlistDataSourceBean5.setIrUriageseikyuuerrcd("ＷＷＷ");
        skFsturiagekekkaerrorlistDataSourceBean5.setIrKensuugoukei(BizNumber.valueOf(14));

        skFsturiagekekkaerrorlistDataSourceBean6.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFsturiagekekkaerrorlistDataSourceBean6.setIrCredituriagegk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skFsturiagekekkaerrorlistDataSourceBean6.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.CARDGAISYAERROR);
        skFsturiagekekkaerrorlistDataSourceBean6.setIrSeikyuuerrorriyuu("収納代行センターにて送信先カード判定エラー");
        skFsturiagekekkaerrorlistDataSourceBean6.setIrUriageseikyuuerrcd("ＷＷＷ");
        skFsturiagekekkaerrorlistDataSourceBean6.setIrKensuugoukei(BizNumber.valueOf(14));

        skFsturiagekekkaerrorlistDataSourceBean7.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFsturiagekekkaerrorlistDataSourceBean7.setIrCredituriagegk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skFsturiagekekkaerrorlistDataSourceBean7.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.CARDGAISYAERROR);
        skFsturiagekekkaerrorlistDataSourceBean7.setIrSeikyuuerrorriyuu("収納代行センターにて送信先カード判定エラー");
        skFsturiagekekkaerrorlistDataSourceBean7.setIrUriageseikyuuerrcd("ＷＷＷ");
        skFsturiagekekkaerrorlistDataSourceBean7.setIrKensuugoukei(BizNumber.valueOf(14));

        skFsturiagekekkaerrorlistDataSourceBean8.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFsturiagekekkaerrorlistDataSourceBean8.setIrCredituriagegk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        skFsturiagekekkaerrorlistDataSourceBean8.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.CARDGAISYAERROR);
        skFsturiagekekkaerrorlistDataSourceBean8.setIrSeikyuuerrorriyuu("収納代行センターにて送信先カード判定エラー");
        skFsturiagekekkaerrorlistDataSourceBean8.setIrUriageseikyuuerrcd("ＷＷＷ");
        skFsturiagekekkaerrorlistDataSourceBean8.setIrKensuugoukei(BizNumber.valueOf(14));

        skFsturiagekekkaerrorlistDataSourceBean9.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFsturiagekekkaerrorlistDataSourceBean9.setIrCredituriagegk(BizCurrency.valueOf(9999999999l, BizCurrencyTypes.YEN));
        skFsturiagekekkaerrorlistDataSourceBean9.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.CARDGAISYAERROR);
        skFsturiagekekkaerrorlistDataSourceBean9.setIrSeikyuuerrorriyuu("収納代行センターにて送信先カード判定エラー");
        skFsturiagekekkaerrorlistDataSourceBean9.setIrUriageseikyuuerrcd("ＷＷＷ");
        skFsturiagekekkaerrorlistDataSourceBean9.setIrKensuugoukei(BizNumber.valueOf(14));

        skFsturiagekekkaerrorlistDataSourceBean10.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFsturiagekekkaerrorlistDataSourceBean10.setIrCredituriagegk(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skFsturiagekekkaerrorlistDataSourceBean10.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.CARDGAISYAERROR);
        skFsturiagekekkaerrorlistDataSourceBean10.setIrSeikyuuerrorriyuu("収納代行センターにて送信先カード判定エラー");
        skFsturiagekekkaerrorlistDataSourceBean10.setIrUriageseikyuuerrcd("ＷＷＷ");
        skFsturiagekekkaerrorlistDataSourceBean10.setIrKensuugoukei(BizNumber.valueOf(14));

        skFsturiagekekkaerrorlistDataSourceBean11.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFsturiagekekkaerrorlistDataSourceBean11.setIrCredituriagegk(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skFsturiagekekkaerrorlistDataSourceBean11.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.CARDGAISYAERROR);
        skFsturiagekekkaerrorlistDataSourceBean11.setIrSeikyuuerrorriyuu("収納代行センターにて送信先カード判定エラー");
        skFsturiagekekkaerrorlistDataSourceBean11.setIrUriageseikyuuerrcd("ＷＷＷ");
        skFsturiagekekkaerrorlistDataSourceBean11.setIrKensuugoukei(BizNumber.valueOf(14));

        skFsturiagekekkaerrorlistDataSourceBean12.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFsturiagekekkaerrorlistDataSourceBean12.setIrCredituriagegk(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skFsturiagekekkaerrorlistDataSourceBean12.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.CARDGAISYAERROR);
        skFsturiagekekkaerrorlistDataSourceBean12.setIrSeikyuuerrorriyuu("収納代行センターにて送信先カード判定エラー");
        skFsturiagekekkaerrorlistDataSourceBean12.setIrUriageseikyuuerrcd("ＷＷＷ");
        skFsturiagekekkaerrorlistDataSourceBean12.setIrKensuugoukei(BizNumber.valueOf(14));

        skFsturiagekekkaerrorlistDataSourceBean13.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFsturiagekekkaerrorlistDataSourceBean13.setIrCredituriagegk(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skFsturiagekekkaerrorlistDataSourceBean13.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.CARDGAISYAERROR);
        skFsturiagekekkaerrorlistDataSourceBean13.setIrSeikyuuerrorriyuu("収納代行センターにて送信先カード判定エラー");
        skFsturiagekekkaerrorlistDataSourceBean13.setIrUriageseikyuuerrcd("ＷＷＷ");
        skFsturiagekekkaerrorlistDataSourceBean13.setIrKensuugoukei(BizNumber.valueOf(14));

        skFsturiagekekkaerrorlistDataSourceBean14.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        skFsturiagekekkaerrorlistDataSourceBean14.setIrCredituriagegk(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skFsturiagekekkaerrorlistDataSourceBean14.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.CARDGAISYAERROR);
        skFsturiagekekkaerrorlistDataSourceBean14.setIrSeikyuuerrorriyuu("収納代行センターにて送信先カード判定エラー");
        skFsturiagekekkaerrorlistDataSourceBean14.setIrUriageseikyuuerrcd("ＷＷＷ");
        skFsturiagekekkaerrorlistDataSourceBean14.setIrKensuugoukei(BizNumber.valueOf(14));

        dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean1);
        dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean2);
        dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean3);
        dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean4);
        dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean5);
        dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean6);
        dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean7);
        dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean8);
        dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean9);
        dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean10);
        dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean11);
        dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean12);
        dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean13);
        dataSouceList.add(skFsturiagekekkaerrorlistDataSourceBean14);

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}