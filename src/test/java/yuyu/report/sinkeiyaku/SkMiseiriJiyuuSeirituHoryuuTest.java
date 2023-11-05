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
import yuyu.def.sinkeiyaku.bean.report.SkMiseirijiyuuSeirituhoryuuDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 未整理事由明細（成立保留受付中）帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkMiseiriJiyuuSeirituHoryuuTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkKessanMiseiriBean skKessanMiseiriBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuSeirituHoryuuTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU);

        skKessanMiseiriBean.setIrAtesaki("");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("");
        skKessanMiseiriBean.setIrNendo("");
        skKessanMiseiriBean.setIrShnknm("");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();

        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrNyukintuuka("");
        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrMosno("");
        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrKyknmkn("");
        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrRsgaku(BizCurrency.valueOf(0));
        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(0));
        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuSeirituHoryuuTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU);

        skKessanMiseiriBean.setIrAtesaki(null);
        skKessanMiseiriBean.setIrTyouhyousakuseiymd(null);
        skKessanMiseiriBean.setIrNendo(null);
        skKessanMiseiriBean.setIrShnknm(null);
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();

        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrNyukintuuka(null);
        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrMosno(null);
        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrKyknmkn(null);
        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrRsgaku(BizCurrency.valueOf(0));
        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(0));
        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrRsgakuyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean1 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();
        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean2 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();
        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean3 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();
        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean4 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();
        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean5 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();
        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean6 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();
        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean7 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();
        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean8 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();
        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean9 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();
        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean10 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();
        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean11 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();
        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean12 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();
        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean13 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();
        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean14 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();
        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean15 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();
        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean16 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();

        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrMosno("100000001");
        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(0));
        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrNyukintuuka("円");
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrMosno("100000001");
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrRsgaku(BizCurrency.valueOf(0));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrRsgakuyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        skMiseirijiyuuSeirituhoryuuDataSourceBean3.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSeirituhoryuuDataSourceBean3.setIrMosno("100000001");
        skMiseirijiyuuSeirituhoryuuDataSourceBean3.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean3.setIrRsgaku(BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSeirituhoryuuDataSourceBean3.setIrKensuugoukei(BizNumber.valueOf(999));
        skMiseirijiyuuSeirituhoryuuDataSourceBean3.setIrKingakugoukei(BizCurrency.valueOf(2000, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSeirituhoryuuDataSourceBean3.setIrRsgakuyen(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean3.setIrKingakugoukeiyen(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));

        skMiseirijiyuuSeirituhoryuuDataSourceBean4.setIrNyukintuuka("円");
        skMiseirijiyuuSeirituhoryuuDataSourceBean4.setIrMosno("100000001");
        skMiseirijiyuuSeirituhoryuuDataSourceBean4.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean4.setIrRsgaku(BizCurrency.valueOf(1000));
        skMiseirijiyuuSeirituhoryuuDataSourceBean4.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean4.setIrKingakugoukei(BizCurrency.valueOf(2000));
        skMiseirijiyuuSeirituhoryuuDataSourceBean4.setIrRsgakuyen(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean4.setIrKingakugoukeiyen(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));

        skMiseirijiyuuSeirituhoryuuDataSourceBean5.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSeirituhoryuuDataSourceBean5.setIrMosno("100000001");
        skMiseirijiyuuSeirituhoryuuDataSourceBean5.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean5.setIrRsgaku(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSeirituhoryuuDataSourceBean5.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean5.setIrKingakugoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSeirituhoryuuDataSourceBean5.setIrRsgakuyen(BizCurrency.valueOf(999999999999L, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean5.setIrKingakugoukeiyen(BizCurrency.valueOf(999999999999999L, BizCurrencyTypes.YEN));

        skMiseirijiyuuSeirituhoryuuDataSourceBean6.setIrNyukintuuka("円");
        skMiseirijiyuuSeirituhoryuuDataSourceBean6.setIrMosno("100000001");
        skMiseirijiyuuSeirituhoryuuDataSourceBean6.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean6.setIrRsgaku(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuSeirituhoryuuDataSourceBean6.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean6.setIrKingakugoukei(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuSeirituhoryuuDataSourceBean6.setIrRsgakuyen(BizCurrency.valueOf(999999999999L, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean6.setIrKingakugoukeiyen(BizCurrency.valueOf(999999999999999L, BizCurrencyTypes.YEN));

        skMiseirijiyuuSeirituhoryuuDataSourceBean7.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSeirituhoryuuDataSourceBean7.setIrMosno("100000001");
        skMiseirijiyuuSeirituhoryuuDataSourceBean7.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean7.setIrRsgaku(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSeirituhoryuuDataSourceBean7.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean7.setIrKingakugoukei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSeirituhoryuuDataSourceBean7.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean7.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

        skMiseirijiyuuSeirituhoryuuDataSourceBean8.setIrNyukintuuka("円");
        skMiseirijiyuuSeirituhoryuuDataSourceBean8.setIrMosno("100000001");
        skMiseirijiyuuSeirituhoryuuDataSourceBean8.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean8.setIrRsgaku(BizCurrency.valueOf(999));
        skMiseirijiyuuSeirituhoryuuDataSourceBean8.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean8.setIrKingakugoukei(BizCurrency.valueOf(999));
        skMiseirijiyuuSeirituhoryuuDataSourceBean8.setIrRsgakuyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean8.setIrKingakugoukeiyen(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));

        skMiseirijiyuuSeirituhoryuuDataSourceBean9.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSeirituhoryuuDataSourceBean9.setIrMosno("100000001");
        skMiseirijiyuuSeirituhoryuuDataSourceBean9.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean9.setIrRsgaku(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSeirituhoryuuDataSourceBean9.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean9.setIrKingakugoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSeirituhoryuuDataSourceBean9.setIrRsgakuyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean9.setIrKingakugoukeiyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));

        skMiseirijiyuuSeirituhoryuuDataSourceBean10.setIrNyukintuuka("円");
        skMiseirijiyuuSeirituhoryuuDataSourceBean10.setIrMosno("100000001");
        skMiseirijiyuuSeirituhoryuuDataSourceBean10.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean10.setIrRsgaku(BizCurrency.valueOf(9999));
        skMiseirijiyuuSeirituhoryuuDataSourceBean10.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean10.setIrKingakugoukei(BizCurrency.valueOf(9999));
        skMiseirijiyuuSeirituhoryuuDataSourceBean10.setIrRsgakuyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean10.setIrKingakugoukeiyen(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));

        skMiseirijiyuuSeirituhoryuuDataSourceBean11.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSeirituhoryuuDataSourceBean11.setIrMosno("100000001");
        skMiseirijiyuuSeirituhoryuuDataSourceBean11.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean11.setIrRsgaku(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSeirituhoryuuDataSourceBean11.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean11.setIrKingakugoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSeirituhoryuuDataSourceBean11.setIrRsgakuyen(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean11.setIrKingakugoukeiyen(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));

        skMiseirijiyuuSeirituhoryuuDataSourceBean12.setIrNyukintuuka("円");
        skMiseirijiyuuSeirituhoryuuDataSourceBean12.setIrMosno("100000001");
        skMiseirijiyuuSeirituhoryuuDataSourceBean12.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean12.setIrRsgaku(BizCurrency.valueOf(9.1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean12.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean12.setIrKingakugoukei(BizCurrency.valueOf(9.1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean12.setIrRsgakuyen(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean12.setIrKingakugoukeiyen(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));

        skMiseirijiyuuSeirituhoryuuDataSourceBean13.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSeirituhoryuuDataSourceBean13.setIrMosno("100000001");
        skMiseirijiyuuSeirituhoryuuDataSourceBean13.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean13.setIrRsgaku(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSeirituhoryuuDataSourceBean13.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean13.setIrKingakugoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSeirituhoryuuDataSourceBean13.setIrRsgakuyen(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean13.setIrKingakugoukeiyen(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));

        skMiseirijiyuuSeirituhoryuuDataSourceBean14.setIrNyukintuuka("円");
        skMiseirijiyuuSeirituhoryuuDataSourceBean14.setIrMosno("100000001");
        skMiseirijiyuuSeirituhoryuuDataSourceBean14.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean14.setIrRsgaku(BizCurrency.valueOf(9.22));
        skMiseirijiyuuSeirituhoryuuDataSourceBean14.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean14.setIrKingakugoukei(BizCurrency.valueOf(9.22));
        skMiseirijiyuuSeirituhoryuuDataSourceBean14.setIrRsgakuyen(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean14.setIrKingakugoukeiyen(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));

        skMiseirijiyuuSeirituhoryuuDataSourceBean15.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSeirituhoryuuDataSourceBean15.setIrMosno("100000001");
        skMiseirijiyuuSeirituhoryuuDataSourceBean15.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean15.setIrRsgaku(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSeirituhoryuuDataSourceBean15.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean15.setIrKingakugoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSeirituhoryuuDataSourceBean15.setIrRsgakuyen(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean15.setIrKingakugoukeiyen(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));

        skMiseirijiyuuSeirituhoryuuDataSourceBean16.setIrNyukintuuka("円");
        skMiseirijiyuuSeirituhoryuuDataSourceBean16.setIrMosno("100000001");
        skMiseirijiyuuSeirituhoryuuDataSourceBean16.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean16.setIrRsgaku(BizCurrency.valueOf(9.333));
        skMiseirijiyuuSeirituhoryuuDataSourceBean16.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean16.setIrKingakugoukei(BizCurrency.valueOf(9.333));
        skMiseirijiyuuSeirituhoryuuDataSourceBean16.setIrRsgakuyen(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean16.setIrKingakugoukeiyen(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));

        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean1);
        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean2);
        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean3);
        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean4);
        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean5);
        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean6);
        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean7);
        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean8);
        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean9);
        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean10);
        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean11);
        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean12);
        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean13);
        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean14);
        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean15);
        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean16);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU);

        skKessanMiseiriBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        skKessanMiseiriBean.setIrNendo("ＷＷ99ＷＷ");
        skKessanMiseiriBean.setIrShnknm("ＷＷＷＷＷ");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 2474; i++) {

            SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean1 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();

            skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrNyukintuuka("ＷＷＷ");
            skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrMosno("wwwwwwwww");
            skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrKyknmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
            skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(999999999999L, BizCurrencyTypes.YEN));

            dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean1);

        }

        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean2 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();

        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrNyukintuuka("ＷＷＷ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrMosno("wwwwwwwww");
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKyknmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrRsgaku(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(999));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrRsgakuyen(BizCurrency.valueOf(999999999999L, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKingakugoukeiyen(BizCurrency.valueOf(999999999999999L, BizCurrencyTypes.YEN));

        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 23; i++) {

            SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean1 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();

            skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrNyukintuuka("円");
            skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrMosno(String.valueOf(100000001 + i));
            skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrKyknmkn("サカタギントキ");
            skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1));
            skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

            dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean1);

        }

        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean2 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();

        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrNyukintuuka("円");
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrMosno("100000024");
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrRsgaku(BizCurrency.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(24));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(24));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKingakugoukeiyen(BizCurrency.valueOf(24, BizCurrencyTypes.YEN));

        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 24; i++) {

            SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean1 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();

            skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrNyukintuuka("円");
            skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrMosno(String.valueOf(100000001 + i));
            skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrKyknmkn("サカタギントキ");
            skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1));
            skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));


            dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean1);

        }

        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean2 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();

        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrNyukintuuka("円");
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrMosno("100000025");
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrRsgaku(BizCurrency.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(25));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(25));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKingakugoukeiyen(BizCurrency.valueOf(25, BizCurrencyTypes.YEN));

        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 25; i++) {

            SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean1 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();

            skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrNyukintuuka("円");
            skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrMosno(String.valueOf(100000001 + i));
            skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrKyknmkn("サカタギントキ");
            skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1));
            skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

            dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean1);

        }

        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean2 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();

        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrNyukintuuka("円");
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrMosno("100000026");
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrRsgaku(BizCurrency.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(26));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(26));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKingakugoukeiyen(BizCurrency.valueOf(26, BizCurrencyTypes.YEN));

        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean1 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();

        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrMosno("100000001");
        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean1);

        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean2 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();

        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrNyukintuuka("円");
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrMosno("100000001");
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKyknmkn("サカタギントキ");
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrRsgaku(BizCurrency.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(1));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrRsgakuyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        skMiseirijiyuuSeirituhoryuuDataSourceBean2.setIrKingakugoukeiyen(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean1 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();

        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrNyukintuuka("円");
        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(0));
        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU_YENDT);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("第３四半期");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUMEISAI_SEIRITUHRYUUUKTKTYUU_YENDT);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuSeirituhoryuuDataSourceBean skMiseirijiyuuSeirituhoryuuDataSourceBean1 = new SkMiseirijiyuuSeirituhoryuuDataSourceBean();

        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrNyukintuuka("円");
        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(0));
        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuSeirituhoryuuDataSourceBean1.setIrKingakugoukeiyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        dataSouceList.add(skMiseirijiyuuSeirituhoryuuDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}