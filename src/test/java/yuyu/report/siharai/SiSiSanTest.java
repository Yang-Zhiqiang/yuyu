package yuyu.report.siharai;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.siharai.bean.report.SiEditEnkaryuuiBean;
import yuyu.def.siharai.bean.report.SiEditEnkaryuuiDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金支払金額試算書テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SiSiSanTest extends AbstractTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private  SiEditEnkaryuuiBean siEditEnkaryuuiBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiSanTest", C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);

        siEditEnkaryuuiBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrSyono("wwwwwwwwwww");
        siEditEnkaryuuiBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrUktnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrUkthou("ＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrCalckijyunymd("9999年99月99日");
        siEditEnkaryuuiBean.setIrUktbnwari("999.99 ％");
        siEditEnkaryuuiBean.setIrMsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrLayoutgkhyjumu(C_UmuKbn.ARI);
        siEditEnkaryuuiBean.setIrLayoutyenhyjumu(C_UmuKbn.NONE);
        siEditEnkaryuuiBean.setIrHkgkgaika(BizCurrency.valueOf(99999999999.99, BizCurrencyTypes.DOLLAR));
        siEditEnkaryuuiBean.setIrHkgkyen(BizCurrency.valueOf(99999999999L));

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean1 = null;

        for (int i = 0; i < 13; i++) {

            ｓiEditEnkaryuuiDSBean1 = new SiEditEnkaryuuiDataSourceBean();

            ｓiEditEnkaryuuiDSBean1.setIrTuukasyu(C_Tuukasyu.USD);
            ｓiEditEnkaryuuiDSBean1.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            ｓiEditEnkaryuuiDSBean1.setIrKyhkg(BizCurrency.valueOf(99999999999.99, BizCurrencyTypes.DOLLAR));
            ｓiEditEnkaryuuiDSBean1.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean1);
        }

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean2 = null;

        for (int i = 0; i < 13; i++) {

            ｓiEditEnkaryuuiDSBean2 = new SiEditEnkaryuuiDataSourceBean();

            ｓiEditEnkaryuuiDSBean2.setIrTuukasyu(C_Tuukasyu.JPY);
            ｓiEditEnkaryuuiDSBean2.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            ｓiEditEnkaryuuiDSBean2.setIrKyhkg(BizCurrency.valueOf(99999999999L));
            ｓiEditEnkaryuuiDSBean2.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean2);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean,siEditEnkaryuuiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiSanTest", C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);

        siEditEnkaryuuiBean.setIrTyouhyoutitle("死亡保険金（給付金）支払金額　試算書");
        siEditEnkaryuuiBean.setIrMsg1("メッセージ１");
        siEditEnkaryuuiBean.setIrMsg2("メッセージ２");
        siEditEnkaryuuiBean.setIrSyono("10000000001");
        siEditEnkaryuuiBean.setIrKyknmkj("契約者名（漢字）");
        siEditEnkaryuuiBean.setIrHhknnmkj("被保険者名（漢字）");
        siEditEnkaryuuiBean.setIrUktnmkj("受取人名（漢字）");
        siEditEnkaryuuiBean.setIrUkthou("受取方法");
        siEditEnkaryuuiBean.setIrCalckijyunymd("2026年12月26日");
        siEditEnkaryuuiBean.setIrUktbnwari("80.00 ％");
        siEditEnkaryuuiBean.setIrMsg6("メッセージ６");
        siEditEnkaryuuiBean.setIrMsg7("メッセージ７");
        siEditEnkaryuuiBean.setIrMsg8("メッセージ８");
        siEditEnkaryuuiBean.setIrMsg9("メッセージ９");
        siEditEnkaryuuiBean.setIrMsg10("メッセージ１０");
        siEditEnkaryuuiBean.setIrMsg11("メッセージ１１");
        siEditEnkaryuuiBean.setIrLayoutgkhyjumu(C_UmuKbn.ARI);
        siEditEnkaryuuiBean.setIrLayoutyenhyjumu(C_UmuKbn.NONE);
        siEditEnkaryuuiBean.setIrHkgkgaika(BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR));
        siEditEnkaryuuiBean.setIrHkgkyen(BizCurrency.valueOf(201));


        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean1 = new SiEditEnkaryuuiDataSourceBean();

        ｓiEditEnkaryuuiDSBean1.setIrTuukasyu(C_Tuukasyu.USD);
        ｓiEditEnkaryuuiDSBean1.setIrKyuuhuname("預り金");
        ｓiEditEnkaryuuiDSBean1.setIrKyhkg(BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR));
        ｓiEditEnkaryuuiDSBean1.setIrShrdetailbikou("");
        iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean1);

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean2 = new SiEditEnkaryuuiDataSourceBean();

        ｓiEditEnkaryuuiDSBean2.setIrTuukasyu(C_Tuukasyu.USD);
        ｓiEditEnkaryuuiDSBean2.setIrKyuuhuname("保険料");
        ｓiEditEnkaryuuiDSBean2.setIrKyhkg(BizCurrency.valueOf(-200, BizCurrencyTypes.DOLLAR));
        ｓiEditEnkaryuuiDSBean2.setIrShrdetailbikou("２０１７年９月から　２か月分");
        iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean2);

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean3 = new SiEditEnkaryuuiDataSourceBean();

        ｓiEditEnkaryuuiDSBean3.setIrTuukasyu(C_Tuukasyu.USD);
        ｓiEditEnkaryuuiDSBean3.setIrKyuuhuname("その他支払金");
        ｓiEditEnkaryuuiDSBean3.setIrKyhkg(BizCurrency.valueOf(160, BizCurrencyTypes.DOLLAR));
        ｓiEditEnkaryuuiDSBean3.setIrShrdetailbikou("（Ａ）配当金：2,000 円");
        iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean3);

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean4 = new SiEditEnkaryuuiDataSourceBean();

        ｓiEditEnkaryuuiDSBean4.setIrTuukasyu(C_Tuukasyu.USD);
        ｓiEditEnkaryuuiDSBean4.setIrKyuuhuname("");
        ｓiEditEnkaryuuiDSBean4.setIrKyhkg(null);
        ｓiEditEnkaryuuiDSBean4.setIrShrdetailbikou("（Ｂ）保険料：10,000 円");
        iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean4);

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean5 = new SiEditEnkaryuuiDataSourceBean();

        ｓiEditEnkaryuuiDSBean5.setIrTuukasyu(C_Tuukasyu.USD);
        ｓiEditEnkaryuuiDSBean5.setIrKyuuhuname("");
        ｓiEditEnkaryuuiDSBean5.setIrKyhkg(null);
        ｓiEditEnkaryuuiDSBean5.setIrShrdetailbikou("（Ｃ）預り金：2,000 円");
        iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean5);

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean6 = new SiEditEnkaryuuiDataSourceBean();

        ｓiEditEnkaryuuiDSBean6.setIrTuukasyu(C_Tuukasyu.USD);
        ｓiEditEnkaryuuiDSBean6.setIrKyuuhuname("");
        ｓiEditEnkaryuuiDSBean6.setIrKyhkg(null);
        ｓiEditEnkaryuuiDSBean6.setIrShrdetailbikou("（Ｄ）その他精算金：2,000 円");
        iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean6);

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean7 = new SiEditEnkaryuuiDataSourceBean();

        ｓiEditEnkaryuuiDSBean7.setIrTuukasyu(C_Tuukasyu.USD);
        ｓiEditEnkaryuuiDSBean7.setIrKyuuhuname("");
        ｓiEditEnkaryuuiDSBean7.setIrKyhkg(null);
        ｓiEditEnkaryuuiDSBean7.setIrShrdetailbikou("（２０１７年９月から　２か月分）");
        iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean7);

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean8 = new SiEditEnkaryuuiDataSourceBean();

        ｓiEditEnkaryuuiDSBean8.setIrTuukasyu(C_Tuukasyu.USD);
        ｓiEditEnkaryuuiDSBean8.setIrKyuuhuname("");
        ｓiEditEnkaryuuiDSBean8.setIrKyhkg(null);
        ｓiEditEnkaryuuiDSBean8.setIrShrdetailbikou(" 【差引金額（Ａ）＋（Ｂ）＋（Ｃ）＋（Ｄ）】");
        iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean8);

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean9 = new SiEditEnkaryuuiDataSourceBean();

        ｓiEditEnkaryuuiDSBean9.setIrTuukasyu(C_Tuukasyu.USD);
        ｓiEditEnkaryuuiDSBean9.setIrKyuuhuname("");
        ｓiEditEnkaryuuiDSBean9.setIrKyhkg(null);
        ｓiEditEnkaryuuiDSBean9.setIrShrdetailbikou("    16,000 円");
        iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean9);

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean10 = new SiEditEnkaryuuiDataSourceBean();

        ｓiEditEnkaryuuiDSBean10.setIrTuukasyu(C_Tuukasyu.USD);
        ｓiEditEnkaryuuiDSBean10.setIrKyuuhuname("");
        ｓiEditEnkaryuuiDSBean10.setIrKyhkg(null);
        ｓiEditEnkaryuuiDSBean10.setIrShrdetailbikou("為替レート：1米ドル　＝　100.00円");
        iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean10);

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean11 = new SiEditEnkaryuuiDataSourceBean();

        ｓiEditEnkaryuuiDSBean11.setIrTuukasyu(C_Tuukasyu.USD);
        ｓiEditEnkaryuuiDSBean11.setIrKyuuhuname("");
        ｓiEditEnkaryuuiDSBean11.setIrKyhkg(null);
        ｓiEditEnkaryuuiDSBean11.setIrShrdetailbikou("");
        iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean11);

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean12 = new SiEditEnkaryuuiDataSourceBean();

        ｓiEditEnkaryuuiDSBean12.setIrTuukasyu(C_Tuukasyu.USD);
        ｓiEditEnkaryuuiDSBean12.setIrKyuuhuname("");
        ｓiEditEnkaryuuiDSBean12.setIrKyhkg(null);
        ｓiEditEnkaryuuiDSBean12.setIrShrdetailbikou("");
        iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean12);

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean13 = new SiEditEnkaryuuiDataSourceBean();

        ｓiEditEnkaryuuiDSBean13.setIrTuukasyu(C_Tuukasyu.USD);
        ｓiEditEnkaryuuiDSBean13.setIrKyuuhuname("");
        ｓiEditEnkaryuuiDSBean13.setIrKyhkg(null);
        ｓiEditEnkaryuuiDSBean13.setIrShrdetailbikou("");
        iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean13);

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean14 = new SiEditEnkaryuuiDataSourceBean();

        ｓiEditEnkaryuuiDSBean14.setIrTuukasyu(C_Tuukasyu.JPY);
        ｓiEditEnkaryuuiDSBean14.setIrKyuuhuname("死亡保険金");
        ｓiEditEnkaryuuiDSBean14.setIrKyhkg(BizCurrency.valueOf(100000000L ));
        ｓiEditEnkaryuuiDSBean14.setIrShrdetailbikou("外貨金額：100,000.00 米ドル");
        iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean14);

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean15 = new SiEditEnkaryuuiDataSourceBean();

        ｓiEditEnkaryuuiDSBean15.setIrTuukasyu(C_Tuukasyu.JPY);
        ｓiEditEnkaryuuiDSBean15.setIrKyuuhuname("死亡保険金");
        ｓiEditEnkaryuuiDSBean15.setIrKyhkg(BizCurrency.valueOf(100000000L ));
        ｓiEditEnkaryuuiDSBean15.setIrShrdetailbikou("為替レート：1米ドル　＝　100.00 円");
        iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean15);

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean16 = new SiEditEnkaryuuiDataSourceBean();

        ｓiEditEnkaryuuiDSBean16.setIrTuukasyu(C_Tuukasyu.JPY);
        ｓiEditEnkaryuuiDSBean16.setIrKyuuhuname("災害死亡保険金");
        ｓiEditEnkaryuuiDSBean16.setIrKyhkg(BizCurrency.valueOf(100000000L));
        ｓiEditEnkaryuuiDSBean16.setIrShrdetailbikou("外貨金額：100,000.00 米ドル");
        iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean16);

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean17 = new SiEditEnkaryuuiDataSourceBean();

        ｓiEditEnkaryuuiDSBean17.setIrTuukasyu(C_Tuukasyu.JPY);
        ｓiEditEnkaryuuiDSBean17.setIrKyuuhuname("");
        ｓiEditEnkaryuuiDSBean17.setIrKyhkg(null);
        ｓiEditEnkaryuuiDSBean1.setIrShrdetailbikou("為替レート：1米ドル　＝　100.00 円");
        iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean17);

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean18 = new SiEditEnkaryuuiDataSourceBean();

        ｓiEditEnkaryuuiDSBean18.setIrTuukasyu(C_Tuukasyu.JPY);
        ｓiEditEnkaryuuiDSBean18.setIrKyuuhuname("その他精算金");
        ｓiEditEnkaryuuiDSBean18.setIrKyhkg(BizCurrency.valueOf(200));
        ｓiEditEnkaryuuiDSBean1.setIrShrdetailbikou("");
        iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean18);

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean19 = null;

        for (int i = 0; i < 8; i++) {

            ｓiEditEnkaryuuiDSBean19 = new SiEditEnkaryuuiDataSourceBean();

            ｓiEditEnkaryuuiDSBean19.setIrTuukasyu(C_Tuukasyu.JPY);
            ｓiEditEnkaryuuiDSBean19.setIrKyuuhuname("");
            ｓiEditEnkaryuuiDSBean19.setIrKyhkg(null);
            ｓiEditEnkaryuuiDSBean19.setIrShrdetailbikou("");

            iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean19);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean,siEditEnkaryuuiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiSanTest", C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);

        siEditEnkaryuuiBean.setIrTyouhyoutitle(null);
        siEditEnkaryuuiBean.setIrMsg1(null);
        siEditEnkaryuuiBean.setIrMsg2(null);
        siEditEnkaryuuiBean.setIrSyono(null);
        siEditEnkaryuuiBean.setIrKyknmkj(null);
        siEditEnkaryuuiBean.setIrHhknnmkj(null);
        siEditEnkaryuuiBean.setIrUktnmkj(null);
        siEditEnkaryuuiBean.setIrUkthou(null);
        siEditEnkaryuuiBean.setIrCalckijyunymd(null);
        siEditEnkaryuuiBean.setIrUktbnwari(null);
        siEditEnkaryuuiBean.setIrMsg6(null);
        siEditEnkaryuuiBean.setIrMsg7(null);
        siEditEnkaryuuiBean.setIrMsg8(null);
        siEditEnkaryuuiBean.setIrMsg9(null);
        siEditEnkaryuuiBean.setIrMsg10(null);
        siEditEnkaryuuiBean.setIrMsg11(null);
        siEditEnkaryuuiBean.setIrLayoutgkhyjumu(C_UmuKbn.ARI);
        siEditEnkaryuuiBean.setIrLayoutyenhyjumu(C_UmuKbn.NONE);
        siEditEnkaryuuiBean.setIrHkgkgaika(null);
        siEditEnkaryuuiBean.setIrHkgkyen(null);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean = null;

        for (int i = 0; i < 13; i++) {

            ｓiEditEnkaryuuiDSBean = new SiEditEnkaryuuiDataSourceBean();

            ｓiEditEnkaryuuiDSBean.setIrTuukasyu(C_Tuukasyu.USD);
            ｓiEditEnkaryuuiDSBean.setIrKyuuhuname(null);
            ｓiEditEnkaryuuiDSBean.setIrKyhkg(null);
            ｓiEditEnkaryuuiDSBean.setIrShrdetailbikou(null);

            iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean);
        }

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean1 = null;

        for (int i = 0; i < 13; i++) {

            ｓiEditEnkaryuuiDSBean1 = new SiEditEnkaryuuiDataSourceBean();

            ｓiEditEnkaryuuiDSBean1.setIrTuukasyu(C_Tuukasyu.JPY);
            ｓiEditEnkaryuuiDSBean1.setIrKyuuhuname(null);
            ｓiEditEnkaryuuiDSBean1.setIrKyhkg(null);
            ｓiEditEnkaryuuiDSBean1.setIrShrdetailbikou(null);

            iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean1);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean,siEditEnkaryuuiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiSanTest", C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);

        siEditEnkaryuuiBean.setIrTyouhyoutitle("");
        siEditEnkaryuuiBean.setIrMsg1("");
        siEditEnkaryuuiBean.setIrMsg2("");
        siEditEnkaryuuiBean.setIrSyono("");
        siEditEnkaryuuiBean.setIrKyknmkj("");
        siEditEnkaryuuiBean.setIrHhknnmkj("");
        siEditEnkaryuuiBean.setIrUktnmkj("");
        siEditEnkaryuuiBean.setIrUkthou("");
        siEditEnkaryuuiBean.setIrCalckijyunymd("");
        siEditEnkaryuuiBean.setIrUktbnwari("");
        siEditEnkaryuuiBean.setIrMsg6("");
        siEditEnkaryuuiBean.setIrMsg7("");
        siEditEnkaryuuiBean.setIrMsg8("");
        siEditEnkaryuuiBean.setIrMsg9("");
        siEditEnkaryuuiBean.setIrMsg10("");
        siEditEnkaryuuiBean.setIrMsg11("");
        siEditEnkaryuuiBean.setIrLayoutgkhyjumu(C_UmuKbn.ARI);
        siEditEnkaryuuiBean.setIrLayoutyenhyjumu(C_UmuKbn.NONE);
        siEditEnkaryuuiBean.setIrHkgkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        siEditEnkaryuuiBean.setIrHkgkyen(BizCurrency.valueOf(0));


        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean = null;

        for (int i = 0; i < 13; i++) {

            ｓiEditEnkaryuuiDSBean = new SiEditEnkaryuuiDataSourceBean();

            ｓiEditEnkaryuuiDSBean.setIrTuukasyu(C_Tuukasyu.USD);
            ｓiEditEnkaryuuiDSBean.setIrKyuuhuname("");
            ｓiEditEnkaryuuiDSBean.setIrKyhkg(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
            ｓiEditEnkaryuuiDSBean.setIrShrdetailbikou("");

            iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean);
        }

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean1 = null;

        for (int i = 0; i < 13; i++) {

            ｓiEditEnkaryuuiDSBean1 = new SiEditEnkaryuuiDataSourceBean();

            ｓiEditEnkaryuuiDSBean1.setIrTuukasyu(C_Tuukasyu.JPY);
            ｓiEditEnkaryuuiDSBean1.setIrKyuuhuname("");
            ｓiEditEnkaryuuiDSBean1.setIrKyhkg(BizCurrency.valueOf(0));
            ｓiEditEnkaryuuiDSBean1.setIrShrdetailbikou("");

            iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean1);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean,siEditEnkaryuuiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiSanTest", C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);

        siEditEnkaryuuiBean.setIrTyouhyoutitle("");
        siEditEnkaryuuiBean.setIrMsg1("");
        siEditEnkaryuuiBean.setIrMsg2("");
        siEditEnkaryuuiBean.setIrSyono("");
        siEditEnkaryuuiBean.setIrKyknmkj("");
        siEditEnkaryuuiBean.setIrHhknnmkj("");
        siEditEnkaryuuiBean.setIrUktnmkj("");
        siEditEnkaryuuiBean.setIrUkthou("");
        siEditEnkaryuuiBean.setIrCalckijyunymd("");
        siEditEnkaryuuiBean.setIrUktbnwari("");
        siEditEnkaryuuiBean.setIrMsg6("");
        siEditEnkaryuuiBean.setIrMsg7("");
        siEditEnkaryuuiBean.setIrMsg8("");
        siEditEnkaryuuiBean.setIrMsg9("");
        siEditEnkaryuuiBean.setIrMsg10("");
        siEditEnkaryuuiBean.setIrMsg11("");
        siEditEnkaryuuiBean.setIrLayoutgkhyjumu(C_UmuKbn.ARI);
        siEditEnkaryuuiBean.setIrLayoutyenhyjumu(C_UmuKbn.NONE);
        siEditEnkaryuuiBean.setIrHkgkgaika(BizCurrency.valueOf(999, BizCurrencyTypes.DOLLAR));
        siEditEnkaryuuiBean.setIrHkgkyen(BizCurrency.valueOf(999));

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean = null;

        for (int i = 0; i < 13; i++) {

            ｓiEditEnkaryuuiDSBean = new SiEditEnkaryuuiDataSourceBean();

            ｓiEditEnkaryuuiDSBean.setIrTuukasyu(C_Tuukasyu.USD);
            ｓiEditEnkaryuuiDSBean.setIrKyuuhuname("");
            ｓiEditEnkaryuuiDSBean.setIrKyhkg(BizCurrency.valueOf(999, BizCurrencyTypes.DOLLAR));
            ｓiEditEnkaryuuiDSBean.setIrShrdetailbikou("");

            iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean);
        }

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean1 = null;

        for (int i = 0; i < 13; i++) {

            ｓiEditEnkaryuuiDSBean1 = new SiEditEnkaryuuiDataSourceBean();

            ｓiEditEnkaryuuiDSBean1.setIrTuukasyu(C_Tuukasyu.JPY);
            ｓiEditEnkaryuuiDSBean1.setIrKyuuhuname("");
            ｓiEditEnkaryuuiDSBean1.setIrKyhkg(BizCurrency.valueOf(999));
            ｓiEditEnkaryuuiDSBean1.setIrShrdetailbikou("");

            iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean1);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean,siEditEnkaryuuiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiSanTest", C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);

        siEditEnkaryuuiBean.setIrTyouhyoutitle("");
        siEditEnkaryuuiBean.setIrMsg1("");
        siEditEnkaryuuiBean.setIrMsg2("");
        siEditEnkaryuuiBean.setIrSyono("");
        siEditEnkaryuuiBean.setIrKyknmkj("");
        siEditEnkaryuuiBean.setIrHhknnmkj("");
        siEditEnkaryuuiBean.setIrUktnmkj("");
        siEditEnkaryuuiBean.setIrUkthou("");
        siEditEnkaryuuiBean.setIrCalckijyunymd("");
        siEditEnkaryuuiBean.setIrUktbnwari("");
        siEditEnkaryuuiBean.setIrMsg6("");
        siEditEnkaryuuiBean.setIrMsg7("");
        siEditEnkaryuuiBean.setIrMsg8("");
        siEditEnkaryuuiBean.setIrMsg9("");
        siEditEnkaryuuiBean.setIrMsg10("");
        siEditEnkaryuuiBean.setIrMsg11("");
        siEditEnkaryuuiBean.setIrLayoutgkhyjumu(C_UmuKbn.ARI);
        siEditEnkaryuuiBean.setIrLayoutyenhyjumu(C_UmuKbn.NONE);
        siEditEnkaryuuiBean.setIrHkgkgaika(BizCurrency.valueOf(9999, BizCurrencyTypes.DOLLAR));
        siEditEnkaryuuiBean.setIrHkgkyen(BizCurrency.valueOf(9999));

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean = null;

        for (int i = 0; i < 13; i++) {

            ｓiEditEnkaryuuiDSBean = new SiEditEnkaryuuiDataSourceBean();

            ｓiEditEnkaryuuiDSBean.setIrTuukasyu(C_Tuukasyu.USD);
            ｓiEditEnkaryuuiDSBean.setIrKyuuhuname("");
            ｓiEditEnkaryuuiDSBean.setIrKyhkg(BizCurrency.valueOf(9999, BizCurrencyTypes.DOLLAR));
            ｓiEditEnkaryuuiDSBean.setIrShrdetailbikou("");

            iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean);
        }

        for (int i = 0; i < 13; i++) {

            ｓiEditEnkaryuuiDSBean = new SiEditEnkaryuuiDataSourceBean();

            ｓiEditEnkaryuuiDSBean.setIrTuukasyu(C_Tuukasyu.JPY);
            ｓiEditEnkaryuuiDSBean.setIrKyuuhuname("");
            ｓiEditEnkaryuuiDSBean.setIrKyhkg(BizCurrency.valueOf(9999));
            ｓiEditEnkaryuuiDSBean.setIrShrdetailbikou("");

            iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean,siEditEnkaryuuiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiSanTest", C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);

        siEditEnkaryuuiBean.setIrTyouhyoutitle("");
        siEditEnkaryuuiBean.setIrMsg1("");
        siEditEnkaryuuiBean.setIrMsg2("");
        siEditEnkaryuuiBean.setIrSyono("");
        siEditEnkaryuuiBean.setIrKyknmkj("");
        siEditEnkaryuuiBean.setIrHhknnmkj("");
        siEditEnkaryuuiBean.setIrUktnmkj("");
        siEditEnkaryuuiBean.setIrUkthou("");
        siEditEnkaryuuiBean.setIrCalckijyunymd("");
        siEditEnkaryuuiBean.setIrUktbnwari("");
        siEditEnkaryuuiBean.setIrMsg6("");
        siEditEnkaryuuiBean.setIrMsg7("");
        siEditEnkaryuuiBean.setIrMsg8("");
        siEditEnkaryuuiBean.setIrMsg9("");
        siEditEnkaryuuiBean.setIrMsg10("");
        siEditEnkaryuuiBean.setIrMsg11("");
        siEditEnkaryuuiBean.setIrLayoutgkhyjumu(C_UmuKbn.ARI);
        siEditEnkaryuuiBean.setIrLayoutyenhyjumu(C_UmuKbn.NONE);
        siEditEnkaryuuiBean.setIrHkgkgaika(BizCurrency.valueOf(9.1, BizCurrencyTypes.DOLLAR));
        siEditEnkaryuuiBean.setIrHkgkyen(BizCurrency.valueOf(9.1));

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean = null;

        for (int i = 0; i < 13; i++) {

            ｓiEditEnkaryuuiDSBean = new SiEditEnkaryuuiDataSourceBean();

            ｓiEditEnkaryuuiDSBean.setIrTuukasyu(C_Tuukasyu.USD);
            ｓiEditEnkaryuuiDSBean.setIrKyuuhuname("");
            ｓiEditEnkaryuuiDSBean.setIrKyhkg(BizCurrency.valueOf(9.1, BizCurrencyTypes.DOLLAR));
            ｓiEditEnkaryuuiDSBean.setIrShrdetailbikou("");

            iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean);
        }

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean1 = null;

        for (int i = 0; i < 13; i++) {

            ｓiEditEnkaryuuiDSBean1 = new SiEditEnkaryuuiDataSourceBean();

            ｓiEditEnkaryuuiDSBean1.setIrTuukasyu(C_Tuukasyu.JPY);
            ｓiEditEnkaryuuiDSBean1.setIrKyuuhuname("");
            ｓiEditEnkaryuuiDSBean1.setIrKyhkg(BizCurrency.valueOf(9.1));
            ｓiEditEnkaryuuiDSBean1.setIrShrdetailbikou("");

            iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean1);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean,siEditEnkaryuuiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiSanTest", C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);

        siEditEnkaryuuiBean.setIrTyouhyoutitle("");
        siEditEnkaryuuiBean.setIrMsg1("");
        siEditEnkaryuuiBean.setIrMsg2("");
        siEditEnkaryuuiBean.setIrSyono("");
        siEditEnkaryuuiBean.setIrKyknmkj("");
        siEditEnkaryuuiBean.setIrHhknnmkj("");
        siEditEnkaryuuiBean.setIrUktnmkj("");
        siEditEnkaryuuiBean.setIrUkthou("");
        siEditEnkaryuuiBean.setIrCalckijyunymd("");
        siEditEnkaryuuiBean.setIrUktbnwari("");
        siEditEnkaryuuiBean.setIrMsg6("");
        siEditEnkaryuuiBean.setIrMsg7("");
        siEditEnkaryuuiBean.setIrMsg8("");
        siEditEnkaryuuiBean.setIrMsg9("");
        siEditEnkaryuuiBean.setIrMsg10("");
        siEditEnkaryuuiBean.setIrMsg11("");
        siEditEnkaryuuiBean.setIrLayoutgkhyjumu(C_UmuKbn.ARI);
        siEditEnkaryuuiBean.setIrLayoutyenhyjumu(C_UmuKbn.NONE);
        siEditEnkaryuuiBean.setIrHkgkgaika(BizCurrency.valueOf(9.22, BizCurrencyTypes.DOLLAR));
        siEditEnkaryuuiBean.setIrHkgkyen(BizCurrency.valueOf(9.22));

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean = null;

        for (int i = 0; i < 13; i++) {

            ｓiEditEnkaryuuiDSBean = new SiEditEnkaryuuiDataSourceBean();

            ｓiEditEnkaryuuiDSBean.setIrTuukasyu(C_Tuukasyu.USD);
            ｓiEditEnkaryuuiDSBean.setIrKyuuhuname("");
            ｓiEditEnkaryuuiDSBean.setIrKyhkg(BizCurrency.valueOf(9.22, BizCurrencyTypes.DOLLAR));
            ｓiEditEnkaryuuiDSBean.setIrShrdetailbikou("");

            iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean);
        }

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean1 = null;

        for (int i = 0; i < 13; i++) {

            ｓiEditEnkaryuuiDSBean1 = new SiEditEnkaryuuiDataSourceBean();

            ｓiEditEnkaryuuiDSBean1.setIrTuukasyu(C_Tuukasyu.JPY);
            ｓiEditEnkaryuuiDSBean1.setIrKyuuhuname("");
            ｓiEditEnkaryuuiDSBean1.setIrKyhkg(BizCurrency.valueOf(9.22));
            ｓiEditEnkaryuuiDSBean1.setIrShrdetailbikou("");

            iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean1);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean,siEditEnkaryuuiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiSanTest", C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);

        siEditEnkaryuuiBean.setIrTyouhyoutitle("");
        siEditEnkaryuuiBean.setIrMsg1("");
        siEditEnkaryuuiBean.setIrMsg2("");
        siEditEnkaryuuiBean.setIrSyono("");
        siEditEnkaryuuiBean.setIrKyknmkj("");
        siEditEnkaryuuiBean.setIrHhknnmkj("");
        siEditEnkaryuuiBean.setIrUktnmkj("");
        siEditEnkaryuuiBean.setIrUkthou("");
        siEditEnkaryuuiBean.setIrCalckijyunymd("");
        siEditEnkaryuuiBean.setIrUktbnwari("");
        siEditEnkaryuuiBean.setIrMsg6("");
        siEditEnkaryuuiBean.setIrMsg7("");
        siEditEnkaryuuiBean.setIrMsg8("");
        siEditEnkaryuuiBean.setIrMsg9("");
        siEditEnkaryuuiBean.setIrMsg10("");
        siEditEnkaryuuiBean.setIrMsg11("");
        siEditEnkaryuuiBean.setIrLayoutgkhyjumu(C_UmuKbn.ARI);
        siEditEnkaryuuiBean.setIrLayoutyenhyjumu(C_UmuKbn.NONE);
        siEditEnkaryuuiBean.setIrHkgkgaika(BizCurrency.valueOf(9.333, BizCurrencyTypes.DOLLAR));
        siEditEnkaryuuiBean.setIrHkgkyen(BizCurrency.valueOf(9.333));

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean = null;

        for (int i = 0; i < 13; i++) {

            ｓiEditEnkaryuuiDSBean = new SiEditEnkaryuuiDataSourceBean();

            ｓiEditEnkaryuuiDSBean.setIrTuukasyu(C_Tuukasyu.USD);
            ｓiEditEnkaryuuiDSBean.setIrKyuuhuname("");
            ｓiEditEnkaryuuiDSBean.setIrKyhkg(BizCurrency.valueOf(9.333, BizCurrencyTypes.DOLLAR));
            ｓiEditEnkaryuuiDSBean.setIrShrdetailbikou("");

            iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean);
        }

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean1 = null;

        for (int i = 0; i < 13; i++) {

            ｓiEditEnkaryuuiDSBean1 = new SiEditEnkaryuuiDataSourceBean();

            ｓiEditEnkaryuuiDSBean1.setIrTuukasyu(C_Tuukasyu.JPY);
            ｓiEditEnkaryuuiDSBean1.setIrKyuuhuname("");
            ｓiEditEnkaryuuiDSBean1.setIrKyhkg(BizCurrency.valueOf(9.333));
            ｓiEditEnkaryuuiDSBean1.setIrShrdetailbikou("");

            iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean1);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean,siEditEnkaryuuiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiSanTest", C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);

        siEditEnkaryuuiBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrSyono("wwwwwwwwwww");
        siEditEnkaryuuiBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrUktnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrUkthou("ＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrCalckijyunymd("9999年99月99日");
        siEditEnkaryuuiBean.setIrUktbnwari("999.99 ％");
        siEditEnkaryuuiBean.setIrMsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrLayoutgkhyjumu(C_UmuKbn.NONE);
        siEditEnkaryuuiBean.setIrLayoutyenhyjumu(C_UmuKbn.ARI);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean = null;

        for (int i = 0; i < 13; i++) {

            ｓiEditEnkaryuuiDSBean = new SiEditEnkaryuuiDataSourceBean();

            ｓiEditEnkaryuuiDSBean.setIrTuukasyu(C_Tuukasyu.USD);
            ｓiEditEnkaryuuiDSBean.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            ｓiEditEnkaryuuiDSBean.setIrKyhkg(BizCurrency.valueOf(99999999999.99, BizCurrencyTypes.DOLLAR));
            ｓiEditEnkaryuuiDSBean.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean,siEditEnkaryuuiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiSanTest", C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);

        siEditEnkaryuuiBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrSyono("wwwwwwwwwww");
        siEditEnkaryuuiBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrUktnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrUkthou("ＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrCalckijyunymd("9999年99月99日");
        siEditEnkaryuuiBean.setIrUktbnwari("999.99 ％");
        siEditEnkaryuuiBean.setIrMsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrLayoutgkhyjumu(C_UmuKbn.ARI);
        siEditEnkaryuuiBean.setIrLayoutyenhyjumu(C_UmuKbn.NONE);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean1 = null;

        for (int i = 0; i < 13; i++) {

            ｓiEditEnkaryuuiDSBean1 = new SiEditEnkaryuuiDataSourceBean();

            ｓiEditEnkaryuuiDSBean1.setIrTuukasyu(C_Tuukasyu.USD);
            ｓiEditEnkaryuuiDSBean1.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            ｓiEditEnkaryuuiDSBean1.setIrKyhkg(BizCurrency.valueOf(99999999999.99, BizCurrencyTypes.DOLLAR));
            ｓiEditEnkaryuuiDSBean1.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean1);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean,siEditEnkaryuuiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiSanTest", C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);

        siEditEnkaryuuiBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrSyono("wwwwwwwwwww");
        siEditEnkaryuuiBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrUktnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrUkthou("ＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrCalckijyunymd("9999年99月99日");
        siEditEnkaryuuiBean.setIrUktbnwari("999.99 ％");
        siEditEnkaryuuiBean.setIrMsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrMsg11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditEnkaryuuiBean.setIrLayoutgkhyjumu(C_UmuKbn.NONE);
        siEditEnkaryuuiBean.setIrLayoutyenhyjumu(C_UmuKbn.ARI);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        SiEditEnkaryuuiDataSourceBean  ｓiEditEnkaryuuiDSBean1 = null;

        for (int i = 0; i < 13; i++) {

            ｓiEditEnkaryuuiDSBean1 = new SiEditEnkaryuuiDataSourceBean();

            ｓiEditEnkaryuuiDSBean1.setIrTuukasyu(C_Tuukasyu.JPY);
            ｓiEditEnkaryuuiDSBean1.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            ｓiEditEnkaryuuiDSBean1.setIrKyhkg(BizCurrency.valueOf(99999999999L));
            ｓiEditEnkaryuuiDSBean1.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            iReportDataSouceBean.add(ｓiEditEnkaryuuiDSBean1);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean,siEditEnkaryuuiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
