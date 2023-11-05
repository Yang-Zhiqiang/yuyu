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
import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.sinkeiyaku.bean.report.SkKessanMiseiriBean;
import yuyu.def.sinkeiyaku.bean.report.SkMiseirijiyuuSyoruihubiDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 未整理事由明細（書類不備）帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkMiseiriJiyuuSyoruiHubiTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkKessanMiseiriBean skKessanMiseiriBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuSyoruiHubiTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN);

        skKessanMiseiriBean.setIrAtesaki(null);
        skKessanMiseiriBean.setIrTyouhyousakuseiymd(null);
        skKessanMiseiriBean.setIrNendo(null);
        skKessanMiseiriBean.setIrShnknm(null);
        skKessanMiseiriBean.setIrTyouhyoutitle(null);
        skKessanMiseiriBean.setIrSyoruihubitandokuflg(C_TaisyouKbn.TAISYOU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean = new SkMiseirijiyuuSyoruihubiDataSourceBean();

        skMiseirijiyuuSyoruihubiDataSourceBean.setIrNyukintuuka(null);
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMosno(null);
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKyknmkn(null);
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn1(null);
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn2(null);
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn3(null);
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn4(null);
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn5(null);
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn6(null);
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn7(null);
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn8(null);
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn9(null);
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn10(null);
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0));

        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN);

        skKessanMiseiriBean.setIrAtesaki("");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("");
        skKessanMiseiriBean.setIrNendo("");
        skKessanMiseiriBean.setIrShnknm("");
        skKessanMiseiriBean.setIrTyouhyoutitle("");
        skKessanMiseiriBean.setIrSyoruihubitandokuflg(C_TaisyouKbn.TAISYOU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 18; i++) {
            SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean = new SkMiseirijiyuuSyoruihubiDataSourceBean();

            skMiseirijiyuuSyoruihubiDataSourceBean.setIrNyukintuuka("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrMosno("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrKyknmkn("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(0));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(0));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn1("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn2("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn3("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn4("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn5("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn6("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn7("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn8("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn9("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn10("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(0));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(0));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(0));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(0));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(0));

            dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skKessanMiseiriBean.setIrNendo("2014年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("（ＮＯ．２）普保Ⅱ");
        skKessanMiseiriBean.setIrSyoruihubitandokuflg(C_TaisyouKbn.HITAISYOU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean1 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean2 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean3 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean4 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean5 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean6 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean7 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean8 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean9 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean10 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean11 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean12 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean13 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean14 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean15 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean16 = new SkMiseirijiyuuSyoruihubiDataSourceBean();

        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(0));

        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrRsgakuyen(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrRsgaku(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(10));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(10));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrKingakugoukeiyen(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(0));

        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrRsgakuyen(BizCurrency.valueOf(1000));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrRsgaku(BizCurrency.valueOf(1001, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(1000));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrKensuugoukei(BizNumber.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrKingakugoukeiyen(BizCurrency.valueOf(1000));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrKingakugoukei(BizCurrency.valueOf(1007, BizCurrencyTypes.AU_DOLLAR));

        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrRsgakuyen(BizCurrency.valueOf(1000));
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrRsgaku(BizCurrency.valueOf(1002));
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(1000));
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(1000));
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrKingakugoukeiyen(BizCurrency.valueOf(1006));
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrKingakugoukei(BizCurrency.valueOf(1000));

        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrRsgakuyen(BizCurrency.valueOf(999999999999L));
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrRsgaku(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrKingakugoukeiyen(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrKingakugoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));

        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrRsgakuyen(BizCurrency.valueOf(999999999999L));
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrRsgaku(BizCurrency.valueOf(999999999999L));
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrKingakugoukeiyen(BizCurrency.valueOf(999999999999999L));
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrKingakugoukei(BizCurrency.valueOf(999999999999999L));

        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrRsgakuyen(BizCurrency.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrRsgaku(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrKingakugoukeiyen(BizCurrency.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrKingakugoukei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));

        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrRsgakuyen(BizCurrency.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrRsgaku(BizCurrency.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrKingakugoukeiyen(BizCurrency.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrKingakugoukei(BizCurrency.valueOf(999));

        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrRsgakuyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrRsgaku(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrKingakugoukeiyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrKingakugoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));

        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrRsgakuyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrRsgaku(BizCurrency.valueOf(9999));
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9999));
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrKingakugoukeiyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrKingakugoukei(BizCurrency.valueOf(9999));

        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrRsgakuyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrRsgaku(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrKingakugoukeiyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrKingakugoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));

        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrRsgakuyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrRsgaku(BizCurrency.valueOf(9.1));
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9.1));
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrKingakugoukeiyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrKingakugoukei(BizCurrency.valueOf(9.1));

        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrRsgakuyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrRsgaku(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrKingakugoukeiyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrKingakugoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));

        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrRsgakuyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrRsgaku(BizCurrency.valueOf(9.22));
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9.22));
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrKingakugoukeiyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrKingakugoukei(BizCurrency.valueOf(9.22));

        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrRsgakuyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrRsgaku(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrKingakugoukeiyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrKingakugoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));

        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrRsgakuyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrRsgaku(BizCurrency.valueOf(9.333));
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9.333));
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrKingakugoukeiyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrKingakugoukei(BizCurrency.valueOf(9.333));

        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean1);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean2);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean3);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean4);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean5);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean6);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean7);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean8);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean9);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean10);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean11);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean12);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean13);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean14);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean15);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean16);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN);

        skKessanMiseiriBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("9999年99月99日");
        skKessanMiseiriBean.setIrNendo("9999ＷＷ");
        skKessanMiseiriBean.setIrShnknm("ＷＷＷＷＷ");
        skKessanMiseiriBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKessanMiseiriBean.setIrSyoruihubitandokuflg(C_TaisyouKbn.TAISYOU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1979; i++) {
            SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean = new SkMiseirijiyuuSyoruihubiDataSourceBean();

            skMiseirijiyuuSyoruihubiDataSourceBean.setIrNyukintuuka("豪ドル");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrMosno("wwwwwwwww");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrKyknmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(999999999999L));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn1("ww");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn2("ww");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn3("ww");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn4("ww");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn5("ww");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn6("ww");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn7("ww");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn8("ww");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn9("ww");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn10("ww");

            dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean);
        }

        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean1 = new SkMiseirijiyuuSyoruihubiDataSourceBean();

        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrMosno("wwwwwwwww");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrKyknmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(999999999999L));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn1("ww");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn2("ww");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn3("ww");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn4("ww");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn5("ww");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn6("ww");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn7("ww");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn8("ww");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn9("ww");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn10("ww");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(999999999999999L));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(999999999999999L));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skKessanMiseiriBean.setIrNendo("2014年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("（ＮＯ．２）普保Ⅱ");
        skKessanMiseiriBean.setIrSyoruihubitandokuflg(C_TaisyouKbn.HITAISYOU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 18; i++) {
            SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean = new SkMiseirijiyuuSyoruihubiDataSourceBean();

            skMiseirijiyuuSyoruihubiDataSourceBean.setIrNyukintuuka("円");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrMosno(String.valueOf(100000001L + i));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrKyknmkn("坂田銀時");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(1));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(1));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn1("01");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn2("02");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn3("03");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn4("04");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn5("05");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn6("06");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn7("07");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn8("08");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn9("09");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn10("10");

            dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean);
        }

        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean = new SkMiseirijiyuuSyoruihubiDataSourceBean();

        skMiseirijiyuuSyoruihubiDataSourceBean.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMosno(String.valueOf(100000019));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(19));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(19));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(19));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(19));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(19));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(19));

        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skKessanMiseiriBean.setIrNendo("2014年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("（ＮＯ．２）普保Ⅱ");
        skKessanMiseiriBean.setIrSyoruihubitandokuflg(C_TaisyouKbn.HITAISYOU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 19; i++) {
            SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean = new SkMiseirijiyuuSyoruihubiDataSourceBean();

            skMiseirijiyuuSyoruihubiDataSourceBean.setIrNyukintuuka("円");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrMosno(String.valueOf(100000001L + i));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrKyknmkn("坂田銀時");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(1));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(1));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn1("01");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn2("02");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn3("03");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn4("04");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn5("05");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn6("06");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn7("07");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn8("08");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn9("09");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn10("10");

            dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean);
        }

        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean = new SkMiseirijiyuuSyoruihubiDataSourceBean();

        skMiseirijiyuuSyoruihubiDataSourceBean.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMosno(String.valueOf(100000020));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(20));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(20));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(20));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(20));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(20));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(20));

        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skKessanMiseiriBean.setIrNendo("2014年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("（ＮＯ．２）普保Ⅱ");
        skKessanMiseiriBean.setIrSyoruihubitandokuflg(C_TaisyouKbn.HITAISYOU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 20; i++) {
            SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean = new SkMiseirijiyuuSyoruihubiDataSourceBean();

            skMiseirijiyuuSyoruihubiDataSourceBean.setIrNyukintuuka("円");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrMosno(String.valueOf(100000001L + i));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrKyknmkn("坂田銀時");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(1));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(1));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn1("01");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn2("02");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn3("03");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn4("04");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn5("05");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn6("06");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn7("07");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn8("08");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn9("09");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn10("10");

            dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean);
        }

        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean = new SkMiseirijiyuuSyoruihubiDataSourceBean();

        skMiseirijiyuuSyoruihubiDataSourceBean.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMosno(String.valueOf(100000021));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(21));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(21));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(21));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(21));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(21));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(21));

        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuSyoruiHubiTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skKessanMiseiriBean.setIrNendo("2014年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("（ＮＯ．２）普保Ⅱ");
        skKessanMiseiriBean.setIrSyoruihubitandokuflg(C_TaisyouKbn.HITAISYOU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean2 = new SkMiseirijiyuuSyoruihubiDataSourceBean();

        skMiseirijiyuuSyoruihubiDataSourceBean.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMosno("100000001");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(1));

        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrMosno("100000001");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrRsgakuyen(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrRsgaku(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrKingakugoukeiyen(BizCurrency.valueOf(1));

        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuSyoruiHubiTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skKessanMiseiriBean.setIrNendo("2014年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("（ＮＯ．１）普保Ⅱ");
        skKessanMiseiriBean.setIrSyoruihubitandokuflg(C_TaisyouKbn.TAISYOU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 19; i++) {

            SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean = new SkMiseirijiyuuSyoruihubiDataSourceBean();

            skMiseirijiyuuSyoruihubiDataSourceBean.setIrNyukintuuka("円");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrMosno(String.valueOf(100000001L + i));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrKyknmkn("坂田銀時");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(1));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(1));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn1("01");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn2("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn3("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn4("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn5("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn6("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn7("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn8("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn9("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn10("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(19));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(19));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(19));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(19));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(19));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(19));

            dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuSyoruiHubiTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skKessanMiseiriBean.setIrNendo("2014年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("（ＮＯ．１）普保Ⅱ");
        skKessanMiseiriBean.setIrSyoruihubitandokuflg(C_TaisyouKbn.TAISYOU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 20; i++) {

            SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean = new SkMiseirijiyuuSyoruihubiDataSourceBean();

            skMiseirijiyuuSyoruihubiDataSourceBean.setIrNyukintuuka("円");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrMosno(String.valueOf(100000001L + i));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrKyknmkn("坂田銀時");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(1));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(1));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn1("01");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn2("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn3("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn4("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn5("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn6("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn7("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn8("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn9("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn10("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(20));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(20));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(20));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(20));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(20));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(20));

            dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuSyoruiHubiTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skKessanMiseiriBean.setIrNendo("2014年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("（ＮＯ．１）普保Ⅱ");
        skKessanMiseiriBean.setIrSyoruihubitandokuflg(C_TaisyouKbn.TAISYOU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 20; i++) {

            SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean = new SkMiseirijiyuuSyoruihubiDataSourceBean();

            skMiseirijiyuuSyoruihubiDataSourceBean.setIrNyukintuuka("円");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrMosno(String.valueOf(100000001L + i));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrKyknmkn("坂田銀時");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(1));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(1));
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn1("01");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn2("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn3("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn4("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn5("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn6("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn7("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn8("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn9("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn10("");
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukensuusyoukei(null);
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngksyoukei(null);
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrKensuugoukei(null);
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukei(null);
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngkskeiyen(null);
            skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukeiyen(null);

            dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean);
        }

        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean1 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrMosno(String.valueOf(100000021));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(21));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(21));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(21));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(21));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(21));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(21));

        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuSyoruiHubiTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skKessanMiseiriBean.setIrNendo("2014年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("（ＮＯ．１）普保Ⅱ");
        skKessanMiseiriBean.setIrSyoruihubitandokuflg(C_TaisyouKbn.TAISYOU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean2 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean3 = new SkMiseirijiyuuSyoruihubiDataSourceBean();

        skMiseirijiyuuSyoruihubiDataSourceBean.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMosno("100000001");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(1));

        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrMosno("100000002");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrRsgakuyen(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrRsgaku(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrKensuugoukei(null);
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrKingakugoukei(null);
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrKingakugoukeiyen(null);

        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrMosno("100000003");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrRsgakuyen(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrRsgaku(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn1("02");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrKensuugoukei(BizNumber.valueOf(2));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrKingakugoukei(BizCurrency.valueOf(2));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrKingakugoukeiyen(BizCurrency.valueOf(2));

        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean2);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuSyoruiHubiTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skKessanMiseiriBean.setIrNendo("2014年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("（ＮＯ．２）普保Ⅱ");
        skKessanMiseiriBean.setIrSyoruihubitandokuflg(C_TaisyouKbn.HITAISYOU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean = new SkMiseirijiyuuSyoruihubiDataSourceBean();

        skMiseirijiyuuSyoruihubiDataSourceBean.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMosno("100000001");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn2("02");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn3("03");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn4("04");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn5("05");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn6("06");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn7("07");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn8("08");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn9("09");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn10("10");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(1));

        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuSyoruiHubiTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skKessanMiseiriBean.setIrNendo("2014年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("（ＮＯ．１）普保Ⅱ");
        skKessanMiseiriBean.setIrSyoruihubitandokuflg(C_TaisyouKbn.TAISYOU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean = new SkMiseirijiyuuSyoruihubiDataSourceBean();

        skMiseirijiyuuSyoruihubiDataSourceBean.setIrNyukintuuka("ＷＷＷ");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMosno("100000001");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukensuusyoukei(null);
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngksyoukei(null);
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngkskeiyen(null);
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(1));

        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skKessanMiseiriBean.setIrNendo("2014年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("（ＮＯ．１）普保Ⅱ");
        skKessanMiseiriBean.setIrSyoruihubitandokuflg(C_TaisyouKbn.TAISYOU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean1 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean2 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean3 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean4 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean5 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean6 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean7 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean8 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean9 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean10 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean11 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean12 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean13 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean14 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean15 = new SkMiseirijiyuuSyoruihubiDataSourceBean();
        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean16 = new SkMiseirijiyuuSyoruihubiDataSourceBean();

        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(0));

        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrRsgakuyen(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrRsgaku(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(10));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(10));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean2.setIrKingakugoukeiyen(BizCurrency.valueOf(0));

        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrRsgakuyen(BizCurrency.valueOf(1000));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrRsgaku(BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(10004, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrKensuugoukei(BizNumber.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrKingakugoukei(BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(1000));
        skMiseirijiyuuSyoruihubiDataSourceBean3.setIrKingakugoukeiyen(BizCurrency.valueOf(1000));

        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrRsgakuyen(BizCurrency.valueOf(1000));
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrRsgaku(BizCurrency.valueOf(1000));
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(1005));
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrKingakugoukei(BizCurrency.valueOf(1000));
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(1003));
        skMiseirijiyuuSyoruihubiDataSourceBean4.setIrKingakugoukeiyen(BizCurrency.valueOf(1000));

        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrRsgakuyen(BizCurrency.valueOf(999999999999L));
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrRsgaku(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrKingakugoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(999999999999999L));
        skMiseirijiyuuSyoruihubiDataSourceBean5.setIrKingakugoukeiyen(BizCurrency.valueOf(999999999999999L));

        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrRsgakuyen(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrRsgaku(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(999999999999999L));
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrKingakugoukei(BizCurrency.valueOf(999999999999999L));
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(999999999999999L));
        skMiseirijiyuuSyoruihubiDataSourceBean6.setIrKingakugoukeiyen(BizCurrency.valueOf(999999999999999L));

        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrRsgakuyen(BizCurrency.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrRsgaku(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrKingakugoukei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean7.setIrKingakugoukeiyen(BizCurrency.valueOf(999));

        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrRsgakuyen(BizCurrency.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrRsgaku(BizCurrency.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrKingakugoukei(BizCurrency.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(999));
        skMiseirijiyuuSyoruihubiDataSourceBean8.setIrKingakugoukeiyen(BizCurrency.valueOf(999));

        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrRsgakuyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrRsgaku(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrKingakugoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuSyoruihubiDataSourceBean9.setIrKingakugoukeiyen(BizCurrency.valueOf(9999));

        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrRsgakuyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrRsgaku(BizCurrency.valueOf(9999));
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9999));
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrKingakugoukei(BizCurrency.valueOf(9999));
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuSyoruihubiDataSourceBean10.setIrKingakugoukeiyen(BizCurrency.valueOf(9999));

        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrRsgakuyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrRsgaku(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrKingakugoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuSyoruihubiDataSourceBean11.setIrKingakugoukeiyen(BizCurrency.valueOf(9.1));

        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrRsgakuyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrRsgaku(BizCurrency.valueOf(9.1));
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9.1));
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrKingakugoukei(BizCurrency.valueOf(9.1));
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuSyoruihubiDataSourceBean12.setIrKingakugoukeiyen(BizCurrency.valueOf(9.1));

        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrRsgakuyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrRsgaku(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrKingakugoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuSyoruihubiDataSourceBean13.setIrKingakugoukeiyen(BizCurrency.valueOf(9.22));

        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrRsgakuyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrRsgaku(BizCurrency.valueOf(9.22));
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9.22));
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrKingakugoukei(BizCurrency.valueOf(9.22));
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuSyoruihubiDataSourceBean14.setIrKingakugoukeiyen(BizCurrency.valueOf(9.22));

        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrRsgakuyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrRsgaku(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrKingakugoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuSyoruihubiDataSourceBean15.setIrKingakugoukeiyen(BizCurrency.valueOf(9.333));

        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrMosno(String.valueOf(100000001));
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrKyknmkn("坂田銀時");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrRsgakuyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrRsgaku(BizCurrency.valueOf(9.333));
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrSyoruisyuruikbn1("01");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrSyoruisyuruikbn2("");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrSyoruisyuruikbn3("");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrSyoruisyuruikbn4("");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrSyoruisyuruikbn5("");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrSyoruisyuruikbn6("");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrSyoruisyuruikbn7("");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrSyoruisyuruikbn8("");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrSyoruisyuruikbn9("");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrSyoruisyuruikbn10("");
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(9.333));
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrKingakugoukei(BizCurrency.valueOf(9.333));
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuSyoruihubiDataSourceBean16.setIrKingakugoukeiyen(BizCurrency.valueOf(9.333));

        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean1);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean2);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean3);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean4);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean5);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean6);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean7);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean8);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean9);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean10);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean11);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean12);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean13);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean14);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean15);
        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean16);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuSyoruiHubiTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skKessanMiseiriBean.setIrNendo("2014年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("（ＮＯ．１）普保Ⅱ");
        skKessanMiseiriBean.setIrSyoruihubitandokuflg(C_TaisyouKbn.TAISYOU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean = new SkMiseirijiyuuSyoruihubiDataSourceBean();

        skMiseirijiyuuSyoruihubiDataSourceBean.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(0));

        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuSyoruiHubiTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SYORUIHUBI_TAN);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skKessanMiseiriBean.setIrNendo("2014年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrTyouhyoutitle("（ＮＯ．１）普保Ⅱ（円建）");
        skKessanMiseiriBean.setIrSyoruihubitandokuflg(C_TaisyouKbn.TAISYOU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuSyoruihubiDataSourceBean skMiseirijiyuuSyoruihubiDataSourceBean = new SkMiseirijiyuuSyoruihubiDataSourceBean();

        skMiseirijiyuuSyoruihubiDataSourceBean.setIrNyukintuuka("円");
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukensuusyoukei(BizNumber.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngksyoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrMiseirijiyuukngkskeiyen(BizCurrency.valueOf(0));
        skMiseirijiyuuSyoruihubiDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(0));

        dataSouceList.add(skMiseirijiyuuSyoruihubiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
