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
import yuyu.def.sinkeiyaku.bean.report.SkSakujokeiyakumeisailistBean;
import yuyu.def.sinkeiyaku.bean.report.SkSakujokeiyakumeisailistDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 削除契約明細リスト帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkSakujoKeiyakuMeisaiListTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkSakujokeiyakumeisailistBean skSakujokeiyakumeisailistBean;


    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_SAKUJOKYKMEISAILIST);

        skSakujokeiyakumeisailistBean.setIrAtesaki(null);
        skSakujokeiyakumeisailistBean.setIrTyouhyousakuseiymd(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean = new SkSakujokeiyakumeisailistDataSourceBean();

        skSakujokeiyakumeisailistDataSourceBean.setIrNyukintuuka(null);
        skSakujokeiyakumeisailistDataSourceBean.setIrOyadrtencd(null);
        skSakujokeiyakumeisailistDataSourceBean.setIrMosno(null);
        skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirninnm(null);
        skSakujokeiyakumeisailistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(0));
        skSakujokeiyakumeisailistDataSourceBean.setIrKnjyymd(null);
        skSakujokeiyakumeisailistDataSourceBean.setIrNyknsyoriymd(null);
        skSakujokeiyakumeisailistDataSourceBean.setIrKouzano(null);
        skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirnincd(null);
        skSakujokeiyakumeisailistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(0));
        skSakujokeiyakumeisailistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0));

        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSakujokeiyakumeisailistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_SAKUJOKYKMEISAILIST);

        skSakujokeiyakumeisailistBean.setIrAtesaki("");
        skSakujokeiyakumeisailistBean.setIrTyouhyousakuseiymd("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean = new SkSakujokeiyakumeisailistDataSourceBean();

        skSakujokeiyakumeisailistDataSourceBean.setIrNyukintuuka("");
        skSakujokeiyakumeisailistDataSourceBean.setIrOyadrtencd("");
        skSakujokeiyakumeisailistDataSourceBean.setIrMosno("");
        skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirninnm("");
        skSakujokeiyakumeisailistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(0));
        skSakujokeiyakumeisailistDataSourceBean.setIrKnjyymd("");
        skSakujokeiyakumeisailistDataSourceBean.setIrNyknsyoriymd("");
        skSakujokeiyakumeisailistDataSourceBean.setIrKouzano("");
        skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirnincd("");
        skSakujokeiyakumeisailistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(0));
        skSakujokeiyakumeisailistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0));

        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSakujokeiyakumeisailistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_SAKUJOKYKMEISAILIST);

        skSakujokeiyakumeisailistBean.setIrAtesaki("代理店契約室　御中");
        skSakujokeiyakumeisailistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skSakujokeiyakumeisailistBean.setIrSyoruicd(C_SyoruiCdKbn.SK_SAKUJOKYKMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean1 = new SkSakujokeiyakumeisailistDataSourceBean();
        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean2 = new SkSakujokeiyakumeisailistDataSourceBean();
        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean3 = new SkSakujokeiyakumeisailistDataSourceBean();
        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean4 = new SkSakujokeiyakumeisailistDataSourceBean();
        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean5 = new SkSakujokeiyakumeisailistDataSourceBean();
        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean6 = new SkSakujokeiyakumeisailistDataSourceBean();
        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean7 = new SkSakujokeiyakumeisailistDataSourceBean();
        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean8 = new SkSakujokeiyakumeisailistDataSourceBean();
        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean9 = new SkSakujokeiyakumeisailistDataSourceBean();
        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean10 = new SkSakujokeiyakumeisailistDataSourceBean();
        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean11 = new SkSakujokeiyakumeisailistDataSourceBean();
        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean12 = new SkSakujokeiyakumeisailistDataSourceBean();
        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean13 = new SkSakujokeiyakumeisailistDataSourceBean();
        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean14 = new SkSakujokeiyakumeisailistDataSourceBean();
        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean15 = new SkSakujokeiyakumeisailistDataSourceBean();
        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean16 = new SkSakujokeiyakumeisailistDataSourceBean();

        skSakujokeiyakumeisailistDataSourceBean1.setIrNyukintuuka("豪ドル入金");
        skSakujokeiyakumeisailistDataSourceBean1.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean1.setIrMosno(String.valueOf(100000001));
        skSakujokeiyakumeisailistDataSourceBean1.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean1.setIrNyknkkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skSakujokeiyakumeisailistDataSourceBean1.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean1.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean1.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean1.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean1.setIrKingakugoukei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        skSakujokeiyakumeisailistDataSourceBean2.setIrNyukintuuka("円入金");
        skSakujokeiyakumeisailistDataSourceBean2.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean2.setIrMosno(String.valueOf(100000001));
        skSakujokeiyakumeisailistDataSourceBean2.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean2.setIrNyknkkngk(BizCurrency.valueOf(0));
        skSakujokeiyakumeisailistDataSourceBean2.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean2.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean2.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean2.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(0));

        skSakujokeiyakumeisailistDataSourceBean3.setIrNyukintuuka("豪ドル入金");
        skSakujokeiyakumeisailistDataSourceBean3.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean3.setIrMosno(String.valueOf(100000001));
        skSakujokeiyakumeisailistDataSourceBean3.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean3.setIrNyknkkngk(BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR));
        skSakujokeiyakumeisailistDataSourceBean3.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean3.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean3.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean3.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean3.setIrKensuugoukei(BizNumber.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean3.setIrKingakugoukei(BizCurrency.valueOf(2000, BizCurrencyTypes.AU_DOLLAR));

        skSakujokeiyakumeisailistDataSourceBean4.setIrNyukintuuka("円入金");
        skSakujokeiyakumeisailistDataSourceBean4.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean4.setIrMosno(String.valueOf(100000001));
        skSakujokeiyakumeisailistDataSourceBean4.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean4.setIrNyknkkngk(BizCurrency.valueOf(1000));
        skSakujokeiyakumeisailistDataSourceBean4.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean4.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean4.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean4.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean4.setIrKensuugoukei(BizNumber.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean4.setIrKingakugoukei(BizCurrency.valueOf(2000));

        skSakujokeiyakumeisailistDataSourceBean5.setIrNyukintuuka("豪ドル入金");
        skSakujokeiyakumeisailistDataSourceBean5.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean5.setIrMosno(String.valueOf(100000001));
        skSakujokeiyakumeisailistDataSourceBean5.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean5.setIrNyknkkngk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skSakujokeiyakumeisailistDataSourceBean5.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean5.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean5.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean5.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean5.setIrKensuugoukei(BizNumber.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean5.setIrKingakugoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));

        skSakujokeiyakumeisailistDataSourceBean6.setIrNyukintuuka("円入金");
        skSakujokeiyakumeisailistDataSourceBean6.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean6.setIrMosno(String.valueOf(100000001));
        skSakujokeiyakumeisailistDataSourceBean6.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean6.setIrNyknkkngk(BizCurrency.valueOf(9999999999999L));
        skSakujokeiyakumeisailistDataSourceBean6.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean6.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean6.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean6.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean6.setIrKensuugoukei(BizNumber.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean6.setIrKingakugoukei(BizCurrency.valueOf(9999999999999L));

        skSakujokeiyakumeisailistDataSourceBean7.setIrNyukintuuka("豪ドル入金");
        skSakujokeiyakumeisailistDataSourceBean7.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean7.setIrMosno(String.valueOf(100000001));
        skSakujokeiyakumeisailistDataSourceBean7.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean7.setIrNyknkkngk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skSakujokeiyakumeisailistDataSourceBean7.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean7.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean7.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean7.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean7.setIrKensuugoukei(BizNumber.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean7.setIrKingakugoukei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));

        skSakujokeiyakumeisailistDataSourceBean8.setIrNyukintuuka("円入金");
        skSakujokeiyakumeisailistDataSourceBean8.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean8.setIrMosno(String.valueOf(100000001));
        skSakujokeiyakumeisailistDataSourceBean8.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean8.setIrNyknkkngk(BizCurrency.valueOf(999));
        skSakujokeiyakumeisailistDataSourceBean8.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean8.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean8.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean8.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean8.setIrKensuugoukei(BizNumber.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean8.setIrKingakugoukei(BizCurrency.valueOf(999));

        skSakujokeiyakumeisailistDataSourceBean9.setIrNyukintuuka("豪ドル入金");
        skSakujokeiyakumeisailistDataSourceBean9.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean9.setIrMosno(String.valueOf(100000001));
        skSakujokeiyakumeisailistDataSourceBean9.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean9.setIrNyknkkngk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skSakujokeiyakumeisailistDataSourceBean9.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean9.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean9.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean9.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean9.setIrKensuugoukei(BizNumber.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean9.setIrKingakugoukei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));

        skSakujokeiyakumeisailistDataSourceBean10.setIrNyukintuuka("円入金");
        skSakujokeiyakumeisailistDataSourceBean10.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean10.setIrMosno(String.valueOf(100000001));
        skSakujokeiyakumeisailistDataSourceBean10.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean10.setIrNyknkkngk(BizCurrency.valueOf(9999));
        skSakujokeiyakumeisailistDataSourceBean10.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean10.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean10.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean10.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean10.setIrKensuugoukei(BizNumber.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean10.setIrKingakugoukei(BizCurrency.valueOf(9999));

        skSakujokeiyakumeisailistDataSourceBean11.setIrNyukintuuka("豪ドル入金");
        skSakujokeiyakumeisailistDataSourceBean11.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean11.setIrMosno(String.valueOf(100000001));
        skSakujokeiyakumeisailistDataSourceBean11.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean11.setIrNyknkkngk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skSakujokeiyakumeisailistDataSourceBean11.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean11.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean11.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean11.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean11.setIrKensuugoukei(BizNumber.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean11.setIrKingakugoukei(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));

        skSakujokeiyakumeisailistDataSourceBean12.setIrNyukintuuka("円入金");
        skSakujokeiyakumeisailistDataSourceBean12.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean12.setIrMosno(String.valueOf(100000001));
        skSakujokeiyakumeisailistDataSourceBean12.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean12.setIrNyknkkngk(BizCurrency.valueOf(9.1));
        skSakujokeiyakumeisailistDataSourceBean12.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean12.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean12.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean12.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean12.setIrKensuugoukei(BizNumber.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean12.setIrKingakugoukei(BizCurrency.valueOf(9.1));

        skSakujokeiyakumeisailistDataSourceBean13.setIrNyukintuuka("豪ドル入金");
        skSakujokeiyakumeisailistDataSourceBean13.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean13.setIrMosno(String.valueOf(100000001));
        skSakujokeiyakumeisailistDataSourceBean13.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean13.setIrNyknkkngk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skSakujokeiyakumeisailistDataSourceBean13.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean13.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean13.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean13.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean13.setIrKensuugoukei(BizNumber.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean13.setIrKingakugoukei(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));

        skSakujokeiyakumeisailistDataSourceBean14.setIrNyukintuuka("円入金");
        skSakujokeiyakumeisailistDataSourceBean14.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean14.setIrMosno(String.valueOf(100000001));
        skSakujokeiyakumeisailistDataSourceBean14.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean14.setIrNyknkkngk(BizCurrency.valueOf(9.22));
        skSakujokeiyakumeisailistDataSourceBean14.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean14.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean14.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean14.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean14.setIrKensuugoukei(BizNumber.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean14.setIrKingakugoukei(BizCurrency.valueOf(9.22));

        skSakujokeiyakumeisailistDataSourceBean15.setIrNyukintuuka("豪ドル入金");
        skSakujokeiyakumeisailistDataSourceBean15.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean15.setIrMosno(String.valueOf(100000001));
        skSakujokeiyakumeisailistDataSourceBean15.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean15.setIrNyknkkngk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skSakujokeiyakumeisailistDataSourceBean15.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean15.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean15.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean15.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean15.setIrKensuugoukei(BizNumber.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean15.setIrKingakugoukei(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));

        skSakujokeiyakumeisailistDataSourceBean16.setIrNyukintuuka("円入金");
        skSakujokeiyakumeisailistDataSourceBean16.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean16.setIrMosno(String.valueOf(100000001));
        skSakujokeiyakumeisailistDataSourceBean16.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean16.setIrNyknkkngk(BizCurrency.valueOf(9.333));
        skSakujokeiyakumeisailistDataSourceBean16.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean16.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean16.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean16.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean16.setIrKensuugoukei(BizNumber.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean16.setIrKingakugoukei(BizCurrency.valueOf(9.333));

        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean1);
        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean2);
        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean3);
        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean4);
        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean5);
        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean6);
        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean7);
        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean8);
        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean9);
        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean10);
        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean11);
        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean12);
        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean13);
        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean14);
        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean15);
        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean16);

        reportTestBean.addParamObjects(dataSouceList, skSakujokeiyakumeisailistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_SAKUJOKYKMEISAILIST);

        skSakujokeiyakumeisailistBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSakujokeiyakumeisailistBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 14984; i++) {
            SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean = new SkSakujokeiyakumeisailistDataSourceBean();

            skSakujokeiyakumeisailistDataSourceBean.setIrNyukintuuka("ＷＷＷＷＷ");
            skSakujokeiyakumeisailistDataSourceBean.setIrOyadrtencd("wwwwwww");
            skSakujokeiyakumeisailistDataSourceBean.setIrMosno("wwwwwwwww");
            skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirninnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skSakujokeiyakumeisailistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
            skSakujokeiyakumeisailistDataSourceBean.setIrKnjyymd("w.99.99.99");
            skSakujokeiyakumeisailistDataSourceBean.setIrNyknsyoriymd("w.99.99.99");
            skSakujokeiyakumeisailistDataSourceBean.setIrKouzano("wwwwwwwwwwww");
            skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirnincd("wwwwwwwwww");


            dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean);
        }

        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean = new SkSakujokeiyakumeisailistDataSourceBean();

        skSakujokeiyakumeisailistDataSourceBean.setIrNyukintuuka("ＷＷＷＷＷ");
        skSakujokeiyakumeisailistDataSourceBean.setIrOyadrtencd("wwwwwww");
        skSakujokeiyakumeisailistDataSourceBean.setIrMosno("wwwwwwwww");
        skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirninnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSakujokeiyakumeisailistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skSakujokeiyakumeisailistDataSourceBean.setIrKnjyymd("w.99.99.99");
        skSakujokeiyakumeisailistDataSourceBean.setIrNyknsyoriymd("w.99.99.99");
        skSakujokeiyakumeisailistDataSourceBean.setIrKouzano("wwwwwwwwwwww");
        skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirnincd("wwwwwwwwww");
        skSakujokeiyakumeisailistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(999));
        skSakujokeiyakumeisailistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSakujokeiyakumeisailistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_SAKUJOKYKMEISAILIST);

        skSakujokeiyakumeisailistBean.setIrAtesaki("代理店契約室　御中");
        skSakujokeiyakumeisailistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 13; i++) {
            SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean = new SkSakujokeiyakumeisailistDataSourceBean();

            skSakujokeiyakumeisailistDataSourceBean.setIrNyukintuuka("円入金");
            skSakujokeiyakumeisailistDataSourceBean.setIrOyadrtencd("1234567");
            skSakujokeiyakumeisailistDataSourceBean.setIrMosno(String.valueOf(100000001L + i));
            skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirninnm("振込人名");
            skSakujokeiyakumeisailistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1));
            skSakujokeiyakumeisailistDataSourceBean.setIrKnjyymd("H.27.08.31");
            skSakujokeiyakumeisailistDataSourceBean.setIrNyknsyoriymd("H.29.09.12");
            skSakujokeiyakumeisailistDataSourceBean.setIrKouzano("123456789012");
            skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirnincd("9876543210");

            dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean);
        }

        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean = new SkSakujokeiyakumeisailistDataSourceBean();

        skSakujokeiyakumeisailistDataSourceBean.setIrNyukintuuka("円入金");
        skSakujokeiyakumeisailistDataSourceBean.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean.setIrMosno(String.valueOf(100000014));
        skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(14));
        skSakujokeiyakumeisailistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(14));

        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSakujokeiyakumeisailistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_SAKUJOKYKMEISAILIST);

        skSakujokeiyakumeisailistBean.setIrAtesaki("代理店契約室　御中");
        skSakujokeiyakumeisailistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 14; i++) {
            SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean = new SkSakujokeiyakumeisailistDataSourceBean();

            skSakujokeiyakumeisailistDataSourceBean.setIrNyukintuuka("円入金");
            skSakujokeiyakumeisailistDataSourceBean.setIrOyadrtencd("1234567");
            skSakujokeiyakumeisailistDataSourceBean.setIrMosno(String.valueOf(100000001L + i));
            skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirninnm("振込人名");
            skSakujokeiyakumeisailistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1));
            skSakujokeiyakumeisailistDataSourceBean.setIrKnjyymd("H.27.08.31");
            skSakujokeiyakumeisailistDataSourceBean.setIrNyknsyoriymd("H.29.09.12");
            skSakujokeiyakumeisailistDataSourceBean.setIrKouzano("123456789012");
            skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirnincd("9876543210");

            dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean);
        }

        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean = new SkSakujokeiyakumeisailistDataSourceBean();

        skSakujokeiyakumeisailistDataSourceBean.setIrNyukintuuka("円入金");
        skSakujokeiyakumeisailistDataSourceBean.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean.setIrMosno(String.valueOf(100000015));
        skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(15));
        skSakujokeiyakumeisailistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(15));

        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSakujokeiyakumeisailistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_SAKUJOKYKMEISAILIST);

        skSakujokeiyakumeisailistBean.setIrAtesaki("代理店契約室　御中");
        skSakujokeiyakumeisailistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 15; i++) {
            SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean = new SkSakujokeiyakumeisailistDataSourceBean();

            skSakujokeiyakumeisailistDataSourceBean.setIrNyukintuuka("円入金");
            skSakujokeiyakumeisailistDataSourceBean.setIrOyadrtencd("1234567");
            skSakujokeiyakumeisailistDataSourceBean.setIrMosno(String.valueOf(100000001L + i));
            skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirninnm("振込人名");
            skSakujokeiyakumeisailistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1));
            skSakujokeiyakumeisailistDataSourceBean.setIrKnjyymd("H.27.08.31");
            skSakujokeiyakumeisailistDataSourceBean.setIrNyknsyoriymd("H.29.09.12");
            skSakujokeiyakumeisailistDataSourceBean.setIrKouzano("123456789012");
            skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirnincd("9876543210");

            dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean);
        }

        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean = new SkSakujokeiyakumeisailistDataSourceBean();

        skSakujokeiyakumeisailistDataSourceBean.setIrNyukintuuka("円入金");
        skSakujokeiyakumeisailistDataSourceBean.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean.setIrMosno(String.valueOf(100000016));
        skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(16));
        skSakujokeiyakumeisailistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(16));

        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSakujokeiyakumeisailistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_SAKUJOKYKMEISAILIST);

        skSakujokeiyakumeisailistBean.setIrAtesaki("代理店契約室　御中");
        skSakujokeiyakumeisailistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean = new SkSakujokeiyakumeisailistDataSourceBean();
        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean2 = new SkSakujokeiyakumeisailistDataSourceBean();

        skSakujokeiyakumeisailistDataSourceBean.setIrNyukintuuka("豪ドル入金");
        skSakujokeiyakumeisailistDataSourceBean.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean.setIrMosno(String.valueOf(100000001));
        skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        skSakujokeiyakumeisailistDataSourceBean.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));

        skSakujokeiyakumeisailistDataSourceBean2.setIrNyukintuuka("円入金");
        skSakujokeiyakumeisailistDataSourceBean2.setIrOyadrtencd("1234567");
        skSakujokeiyakumeisailistDataSourceBean2.setIrMosno(String.valueOf(100000001));
        skSakujokeiyakumeisailistDataSourceBean2.setIrHrkmirninnm("振込人名");
        skSakujokeiyakumeisailistDataSourceBean2.setIrNyknkkngk(BizCurrency.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean2.setIrKnjyymd("H.27.08.31");
        skSakujokeiyakumeisailistDataSourceBean2.setIrNyknsyoriymd("H.29.09.12");
        skSakujokeiyakumeisailistDataSourceBean2.setIrKouzano("123456789012");
        skSakujokeiyakumeisailistDataSourceBean2.setIrHrkmirnincd("9876543210");
        skSakujokeiyakumeisailistDataSourceBean2.setIrKensuugoukei(BizNumber.valueOf(1));
        skSakujokeiyakumeisailistDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(1));

        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean);
        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, skSakujokeiyakumeisailistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_SAKUJOKYKMEISAILIST);

        skSakujokeiyakumeisailistBean.setIrAtesaki("代理店契約室　御中");
        skSakujokeiyakumeisailistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean = new SkSakujokeiyakumeisailistDataSourceBean();

        skSakujokeiyakumeisailistDataSourceBean.setIrNyukintuuka("円入金");
        skSakujokeiyakumeisailistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(0));
        skSakujokeiyakumeisailistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0));

        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSakujokeiyakumeisailistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkSakujoKeiyakuMeisaiListTest", C_SyoruiCdKbn.SK_SAKUJOKYKMEISAILIST_YENDT );

        skSakujokeiyakumeisailistBean.setIrAtesaki("代理店契約室　御中");
        skSakujokeiyakumeisailistBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skSakujokeiyakumeisailistBean.setIrSyoruicd(C_SyoruiCdKbn.SK_SAKUJOKYKMEISAILIST_YENDT );

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkSakujokeiyakumeisailistDataSourceBean skSakujokeiyakumeisailistDataSourceBean = new SkSakujokeiyakumeisailistDataSourceBean();

        skSakujokeiyakumeisailistDataSourceBean.setIrNyukintuuka("円入金");
        skSakujokeiyakumeisailistDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(0));
        skSakujokeiyakumeisailistDataSourceBean.setIrKingakugoukei(BizCurrency.valueOf(0));

        dataSouceList.add(skSakujokeiyakumeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSakujokeiyakumeisailistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
