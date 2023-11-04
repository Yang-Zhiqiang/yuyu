package yuyu.report.sinkeiyaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SkKessanMiseiriBean;
import yuyu.def.sinkeiyaku.bean.report.SkMiseirijiyuuKrkmeisaiDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 未整理事由別仮受金明細リスト帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkMiseiriJiyuuKrkMeisaiTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkKessanMiseiriBean skKessanMiseiriBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuSyoruiHubiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINMEISAILIST);

        skKessanMiseiriBean.setIrAtesaki(null);
        skKessanMiseiriBean.setIrTyouhyousakuseiymd(null);
        skKessanMiseiriBean.setIrNendo(null);
        skKessanMiseiriBean.setIrShnknm(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean = new SkMiseirijiyuuKrkmeisaiDataSourceBean();

        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMiseirijiyuukbn(null);
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrNyukintuuka(null);
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMosno(null);
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKyknmkn(null);
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukai(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetu(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(0));

        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINMEISAILIST);

        skKessanMiseiriBean.setIrAtesaki("");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("");
        skKessanMiseiriBean.setIrNendo("");
        skKessanMiseiriBean.setIrShnknm("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean = new SkMiseirijiyuuKrkmeisaiDataSourceBean();

        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMiseirijiyuukbn("");
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrNyukintuuka("");
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMosno("");
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKyknmkn("");
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukai(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetu(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(0));

        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINMEISAILIST);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean1 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();
        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean2 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();
        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean3 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();
        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean4 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();
        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean5 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();
        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean6 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();
        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean7 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();
        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean8 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();
        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean9 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();
        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean10 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();
        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean11 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();
        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean12 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();
        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean13 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();
        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean14 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();
        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean15 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();
        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean16 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();

        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrMosno("100000001");
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2syoukai(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2kobetu(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        skMiseirijiyuuKrkmeisaiDataSourceBean2.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean2.setIrNyukintuuka("円");
        skMiseirijiyuuKrkmeisaiDataSourceBean2.setIrMosno("100000001");
        skMiseirijiyuuKrkmeisaiDataSourceBean2.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean2.setIrKrkhuho2syoukai(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean2.setIrKrkhuho2kobetu(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean2.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean2.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean2.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean2.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(0));

        skMiseirijiyuuKrkmeisaiDataSourceBean3.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean3.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuKrkmeisaiDataSourceBean3.setIrMosno("100000001");
        skMiseirijiyuuKrkmeisaiDataSourceBean3.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean3.setIrKrkhuho2syoukai(BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean3.setIrKrkhuho2kobetu(BizCurrency.valueOf(2000, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean3.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(3000, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean3.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(4000, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean3.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(5000, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean3.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(6000, BizCurrencyTypes.AU_DOLLAR));

        skMiseirijiyuuKrkmeisaiDataSourceBean4.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean4.setIrNyukintuuka("円");
        skMiseirijiyuuKrkmeisaiDataSourceBean4.setIrMosno("100000001");
        skMiseirijiyuuKrkmeisaiDataSourceBean4.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean4.setIrKrkhuho2syoukai(BizCurrency.valueOf(1000));
        skMiseirijiyuuKrkmeisaiDataSourceBean4.setIrKrkhuho2kobetu(BizCurrency.valueOf(2000));
        skMiseirijiyuuKrkmeisaiDataSourceBean4.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(3000));
        skMiseirijiyuuKrkmeisaiDataSourceBean4.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(4000));
        skMiseirijiyuuKrkmeisaiDataSourceBean4.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(5000));
        skMiseirijiyuuKrkmeisaiDataSourceBean4.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(6000));

        skMiseirijiyuuKrkmeisaiDataSourceBean5.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean5.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuKrkmeisaiDataSourceBean5.setIrMosno("100000001");
        skMiseirijiyuuKrkmeisaiDataSourceBean5.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean5.setIrKrkhuho2syoukai(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean5.setIrKrkhuho2kobetu(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean5.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean5.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean5.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean5.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));

        skMiseirijiyuuKrkmeisaiDataSourceBean6.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean6.setIrNyukintuuka("円");
        skMiseirijiyuuKrkmeisaiDataSourceBean6.setIrMosno("100000001");
        skMiseirijiyuuKrkmeisaiDataSourceBean6.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean6.setIrKrkhuho2syoukai(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrkmeisaiDataSourceBean6.setIrKrkhuho2kobetu(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrkmeisaiDataSourceBean6.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrkmeisaiDataSourceBean6.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrkmeisaiDataSourceBean6.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrkmeisaiDataSourceBean6.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(9999999999999L));

        skMiseirijiyuuKrkmeisaiDataSourceBean7.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean7.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuKrkmeisaiDataSourceBean7.setIrMosno("100000001");
        skMiseirijiyuuKrkmeisaiDataSourceBean7.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean7.setIrKrkhuho2syoukai(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean7.setIrKrkhuho2kobetu(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean7.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean7.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean7.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean7.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));

        skMiseirijiyuuKrkmeisaiDataSourceBean8.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean8.setIrNyukintuuka("円");
        skMiseirijiyuuKrkmeisaiDataSourceBean8.setIrMosno("100000001");
        skMiseirijiyuuKrkmeisaiDataSourceBean8.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean8.setIrKrkhuho2syoukai(BizCurrency.valueOf(999));
        skMiseirijiyuuKrkmeisaiDataSourceBean8.setIrKrkhuho2kobetu(BizCurrency.valueOf(999));
        skMiseirijiyuuKrkmeisaiDataSourceBean8.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(999));
        skMiseirijiyuuKrkmeisaiDataSourceBean8.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(999));
        skMiseirijiyuuKrkmeisaiDataSourceBean8.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(999));
        skMiseirijiyuuKrkmeisaiDataSourceBean8.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(999));

        skMiseirijiyuuKrkmeisaiDataSourceBean9.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean9.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuKrkmeisaiDataSourceBean9.setIrMosno("100000001");
        skMiseirijiyuuKrkmeisaiDataSourceBean9.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean9.setIrKrkhuho2syoukai(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean9.setIrKrkhuho2kobetu(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean9.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean9.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean9.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean9.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));

        skMiseirijiyuuKrkmeisaiDataSourceBean10.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean10.setIrNyukintuuka("円");
        skMiseirijiyuuKrkmeisaiDataSourceBean10.setIrMosno("100000001");
        skMiseirijiyuuKrkmeisaiDataSourceBean10.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean10.setIrKrkhuho2syoukai(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrkmeisaiDataSourceBean10.setIrKrkhuho2kobetu(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrkmeisaiDataSourceBean10.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrkmeisaiDataSourceBean10.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrkmeisaiDataSourceBean10.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrkmeisaiDataSourceBean10.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(9999));

        skMiseirijiyuuKrkmeisaiDataSourceBean11.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean11.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuKrkmeisaiDataSourceBean11.setIrMosno("100000001");
        skMiseirijiyuuKrkmeisaiDataSourceBean11.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean11.setIrKrkhuho2syoukai(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean11.setIrKrkhuho2kobetu(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean11.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean11.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean11.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean11.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));

        skMiseirijiyuuKrkmeisaiDataSourceBean12.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean12.setIrNyukintuuka("円");
        skMiseirijiyuuKrkmeisaiDataSourceBean12.setIrMosno("100000001");
        skMiseirijiyuuKrkmeisaiDataSourceBean12.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean12.setIrKrkhuho2syoukai(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrkmeisaiDataSourceBean12.setIrKrkhuho2kobetu(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrkmeisaiDataSourceBean12.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrkmeisaiDataSourceBean12.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrkmeisaiDataSourceBean12.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrkmeisaiDataSourceBean12.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(9.1));

        skMiseirijiyuuKrkmeisaiDataSourceBean13.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean13.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuKrkmeisaiDataSourceBean13.setIrMosno("100000001");
        skMiseirijiyuuKrkmeisaiDataSourceBean13.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean13.setIrKrkhuho2syoukai(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean13.setIrKrkhuho2kobetu(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean13.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(9.220, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean13.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean13.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean13.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));

        skMiseirijiyuuKrkmeisaiDataSourceBean14.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean14.setIrNyukintuuka("円");
        skMiseirijiyuuKrkmeisaiDataSourceBean14.setIrMosno("100000001");
        skMiseirijiyuuKrkmeisaiDataSourceBean14.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean14.setIrKrkhuho2syoukai(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrkmeisaiDataSourceBean14.setIrKrkhuho2kobetu(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrkmeisaiDataSourceBean14.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrkmeisaiDataSourceBean14.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrkmeisaiDataSourceBean14.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrkmeisaiDataSourceBean14.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(9.22));

        skMiseirijiyuuKrkmeisaiDataSourceBean15.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean15.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuKrkmeisaiDataSourceBean15.setIrMosno("100000001");
        skMiseirijiyuuKrkmeisaiDataSourceBean15.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean15.setIrKrkhuho2syoukai(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean15.setIrKrkhuho2kobetu(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean15.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean15.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean15.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean15.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));

        skMiseirijiyuuKrkmeisaiDataSourceBean16.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean16.setIrNyukintuuka("円");
        skMiseirijiyuuKrkmeisaiDataSourceBean16.setIrMosno("100000001");
        skMiseirijiyuuKrkmeisaiDataSourceBean16.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean16.setIrKrkhuho2syoukai(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrkmeisaiDataSourceBean16.setIrKrkhuho2kobetu(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrkmeisaiDataSourceBean16.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrkmeisaiDataSourceBean16.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrkmeisaiDataSourceBean16.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrkmeisaiDataSourceBean16.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(9.333));

        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean1);
        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean2);
        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean3);
        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean4);
        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean5);
        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean6);
        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean7);
        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean8);
        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean9);
        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean10);
        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean11);
        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean12);
        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean13);
        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean14);
        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean15);
        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean16);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINMEISAILIST);

        skKessanMiseiriBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        skKessanMiseiriBean.setIrNendo("ＷＷ99ＷＷ");
        skKessanMiseiriBean.setIrShnknm("ＷＷＷＷＷ");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 2474; i++) {
            SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean = new SkMiseirijiyuuKrkmeisaiDataSourceBean();

            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMiseirijiyuukbn("9999");
            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrNyukintuuka("豪ドル");
            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMosno("wwwwwwwww");
            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKyknmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukai(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetu(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

            dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean);
        }

        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean = new SkMiseirijiyuuKrkmeisaiDataSourceBean();

        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMiseirijiyuukbn("9999");
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMosno("wwwwwwwww");
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKyknmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukai(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetu(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINMEISAILIST);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 23; i++) {
            SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean = new SkMiseirijiyuuKrkmeisaiDataSourceBean();

            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMiseirijiyuukbn("1234");
            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrNyukintuuka("円");
            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMosno(String.valueOf(100000001L + i));
            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKyknmkn("契約者名");
            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukai(BizCurrency.valueOf(1));
            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetu(BizCurrency.valueOf(1));

            dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean);
        }

        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean = new SkMiseirijiyuuKrkmeisaiDataSourceBean();

        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrNyukintuuka("円");
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMosno(String.valueOf(100000024));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukai(BizCurrency.valueOf(1));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetu(BizCurrency.valueOf(1));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(24));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(24));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(24));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(24));

        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINMEISAILIST);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 24; i++) {
            SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean = new SkMiseirijiyuuKrkmeisaiDataSourceBean();

            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMiseirijiyuukbn("1234");
            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrNyukintuuka("円");
            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMosno(String.valueOf(100000001L + i));
            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKyknmkn("契約者名");
            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukai(BizCurrency.valueOf(1));
            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetu(BizCurrency.valueOf(1));

            dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean);
        }

        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean = new SkMiseirijiyuuKrkmeisaiDataSourceBean();

        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrNyukintuuka("円");
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMosno(String.valueOf(100000025));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukai(BizCurrency.valueOf(1));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetu(BizCurrency.valueOf(1));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(25));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(25));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(25));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(25));

        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINMEISAILIST);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 25; i++) {
            SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean = new SkMiseirijiyuuKrkmeisaiDataSourceBean();

            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMiseirijiyuukbn("1234");
            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrNyukintuuka("円");
            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMosno(String.valueOf(100000001L + i));
            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKyknmkn("契約者名");
            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukai(BizCurrency.valueOf(1));
            skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetu(BizCurrency.valueOf(1));

            dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean);
        }

        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean = new SkMiseirijiyuuKrkmeisaiDataSourceBean();

        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrNyukintuuka("円");
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrMosno(String.valueOf(100000026));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukai(BizCurrency.valueOf(1));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetu(BizCurrency.valueOf(1));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(26));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(26));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(26));
        skMiseirijiyuuKrkmeisaiDataSourceBean.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(26));

        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuSyoruiHubiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINMEISAILIST);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean1 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();
        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean2 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();
        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean3 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();

        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrNyukintuuka("円");
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrMosno("100000001");
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2syoukai(BizCurrency.valueOf(1));
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2kobetu(BizCurrency.valueOf(1));
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(1));
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(1));

        skMiseirijiyuuKrkmeisaiDataSourceBean2.setIrMiseirijiyuukbn("1235");
        skMiseirijiyuuKrkmeisaiDataSourceBean2.setIrNyukintuuka("円");
        skMiseirijiyuuKrkmeisaiDataSourceBean2.setIrMosno("100000001");
        skMiseirijiyuuKrkmeisaiDataSourceBean2.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean2.setIrKrkhuho2syoukai(BizCurrency.valueOf(1));
        skMiseirijiyuuKrkmeisaiDataSourceBean2.setIrKrkhuho2kobetu(BizCurrency.valueOf(1));
        skMiseirijiyuuKrkmeisaiDataSourceBean2.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(1));
        skMiseirijiyuuKrkmeisaiDataSourceBean2.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(1));
        skMiseirijiyuuKrkmeisaiDataSourceBean2.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(2));
        skMiseirijiyuuKrkmeisaiDataSourceBean2.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(2));

        skMiseirijiyuuKrkmeisaiDataSourceBean3.setIrMiseirijiyuukbn("1235");
        skMiseirijiyuuKrkmeisaiDataSourceBean3.setIrNyukintuuka("豪ドル");
        skMiseirijiyuuKrkmeisaiDataSourceBean3.setIrMosno("100000001");
        skMiseirijiyuuKrkmeisaiDataSourceBean3.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean3.setIrKrkhuho2syoukai(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean3.setIrKrkhuho2kobetu(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean3.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean3.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean3.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean3.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean1);
        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean2);
        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINMEISAILIST);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean1 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();

        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrMiseirijiyuukbn("1234");
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrNyukintuuka("ＷＷＷ");
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrMosno("100000001");
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKyknmkn("契約者名");
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2syoukai(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2kobetu(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINMEISAILIST);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("決算");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean1 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();

        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrNyukintuuka("円");
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(0));

        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINMEISAILIST_YENDT);

        skKessanMiseiriBean.setIrAtesaki("代理店契約室　御中");
        skKessanMiseiriBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skKessanMiseiriBean.setIrNendo("平成26年度");
        skKessanMiseiriBean.setIrShnknm("第３四半期");
        skKessanMiseiriBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINMEISAILIST_YENDT);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkMiseirijiyuuKrkmeisaiDataSourceBean skMiseirijiyuuKrkmeisaiDataSourceBean1 = new SkMiseirijiyuuKrkmeisaiDataSourceBean();

        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrNyukintuuka("円");
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2syoukaisyoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2kobetusyoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2syoukaigoukei(BizCurrency.valueOf(0));
        skMiseirijiyuuKrkmeisaiDataSourceBean1.setIrKrkhuho2kobetugoukei(BizCurrency.valueOf(0));

        dataSouceList.add(skMiseirijiyuuKrkmeisaiDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, skKessanMiseiriBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
