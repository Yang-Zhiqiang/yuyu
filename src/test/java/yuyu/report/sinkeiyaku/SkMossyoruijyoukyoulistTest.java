package yuyu.report.sinkeiyaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzDairitenAtesakiBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SkMossyoruijyoukyoulistDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込書類送付状況リスト帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkMossyoruijyoukyoulistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzDairitenAtesakiBean bzDairitenAtesakiBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkMossyoruijyoukyoulistTest",
                C_SyoruiCdKbn.SK_MOSSOUHUJYOUKYOULIST);

        bzDairitenAtesakiBean.setIrHknkisynm("");
        bzDairitenAtesakiBean.setIrToiawasesosiki("");
        bzDairitenAtesakiBean.setIrToiawasefaxno("");
        bzDairitenAtesakiBean.setIrDrtennmkj("");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        SkMossyoruijyoukyoulistDataSourceBean skMossyoruijyoukyoulistDataSourceBean = new SkMossyoruijyoukyoulistDataSourceBean();

        skMossyoruijyoukyoulistDataSourceBean.setIrMostokusokuumu("");
        skMossyoruijyoukyoulistDataSourceBean.setIrDrtennmkj("");
        skMossyoruijyoukyoulistDataSourceBean.setIrKnjyymd("");
        skMossyoruijyoukyoulistDataSourceBean.setIrMosno("");
        skMossyoruijyoukyoulistDataSourceBean.setIrHrkmirninnm("");
        skMossyoruijyoukyoulistDataSourceBean.setIrBanknmkj("");
        skMossyoruijyoukyoulistDataSourceBean.setIrSitennmkj("");
        skMossyoruijyoukyoulistDataSourceBean.setIrHrkmgk(null);

        iReportDataSouceBeanLst.add(skMossyoruijyoukyoulistDataSourceBean);

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, bzDairitenAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }
    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkMossyoruijyoukyoulistTest",
                C_SyoruiCdKbn.SK_MOSSOUHUJYOUKYOULIST);

        bzDairitenAtesakiBean.setIrHknkisynm(null);
        bzDairitenAtesakiBean.setIrToiawasesosiki(null);
        bzDairitenAtesakiBean.setIrToiawasefaxno(null);
        bzDairitenAtesakiBean.setIrDrtennmkj(null);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        SkMossyoruijyoukyoulistDataSourceBean skMossyoruijyoukyoulistDataSourceBean = new SkMossyoruijyoukyoulistDataSourceBean();

        skMossyoruijyoukyoulistDataSourceBean.setIrMostokusokuumu(null);
        skMossyoruijyoukyoulistDataSourceBean.setIrDrtennmkj(null);
        skMossyoruijyoukyoulistDataSourceBean.setIrKnjyymd(null);
        skMossyoruijyoukyoulistDataSourceBean.setIrMosno(null);
        skMossyoruijyoukyoulistDataSourceBean.setIrHrkmirninnm(null);
        skMossyoruijyoukyoulistDataSourceBean.setIrBanknmkj(null);
        skMossyoruijyoukyoulistDataSourceBean.setIrSitennmkj(null);
        skMossyoruijyoukyoulistDataSourceBean.setIrHrkmgk(null);

        iReportDataSouceBeanLst.add(skMossyoruijyoukyoulistDataSourceBean);

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, bzDairitenAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkMossyoruijyoukyoulistTest",
                C_SyoruiCdKbn.SK_MOSSOUHUJYOUKYOULIST);

        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室　行");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrDrtennmkj("親募集代理店");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for (int i = 1; i < 10; i++) {

            SkMossyoruijyoukyoulistDataSourceBean skMossyoruijyoukyoulistDataSourceBean = new SkMossyoruijyoukyoulistDataSourceBean();

            skMossyoruijyoukyoulistDataSourceBean.setIrMostokusokuumu("*");
            skMossyoruijyoukyoulistDataSourceBean.setIrDrtennmkj("取扱代理店名");
            skMossyoruijyoukyoulistDataSourceBean.setIrKnjyymd("H.27.12.31");
            skMossyoruijyoukyoulistDataSourceBean.setIrMosno("10000000" + i);
            skMossyoruijyoukyoulistDataSourceBean.setIrHrkmirninnm("振込人名");
            skMossyoruijyoukyoulistDataSourceBean.setIrBanknmkj("振込銀行名");
            skMossyoruijyoukyoulistDataSourceBean.setIrSitennmkj("支店名");
            skMossyoruijyoukyoulistDataSourceBean.setIrHrkmgk(BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR));

            iReportDataSouceBeanLst.add(skMossyoruijyoukyoulistDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, bzDairitenAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkMossyoruijyoukyoulistTest",
                C_SyoruiCdKbn.SK_MOSSOUHUJYOUKYOULIST);

        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        SkMossyoruijyoukyoulistDataSourceBean skMossyoruijyoukyoulistDataSourceBean = new SkMossyoruijyoukyoulistDataSourceBean();

        skMossyoruijyoukyoulistDataSourceBean.setIrMostokusokuumu("w");
        skMossyoruijyoukyoulistDataSourceBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skMossyoruijyoukyoulistDataSourceBean.setIrKnjyymd("w.99.99.99");
        skMossyoruijyoukyoulistDataSourceBean.setIrMosno("wwwwwwwww");
        skMossyoruijyoukyoulistDataSourceBean.setIrHrkmirninnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skMossyoruijyoukyoulistDataSourceBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skMossyoruijyoukyoulistDataSourceBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skMossyoruijyoukyoulistDataSourceBean.setIrHrkmgk(BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR));

        iReportDataSouceBeanLst.add(skMossyoruijyoukyoulistDataSourceBean);

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, bzDairitenAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkMossyoruijyoukyoulistTest",
                C_SyoruiCdKbn.SK_MOSSOUHUJYOUKYOULIST);

        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室　行");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrDrtennmkj("親募集代理店");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for (int i = 1; i < 10; i++) {

            SkMossyoruijyoukyoulistDataSourceBean skMossyoruijyoukyoulistDataSourceBean = new SkMossyoruijyoukyoulistDataSourceBean();

            skMossyoruijyoukyoulistDataSourceBean.setIrMostokusokuumu("*");
            skMossyoruijyoukyoulistDataSourceBean.setIrDrtennmkj("取扱代理店名");
            skMossyoruijyoukyoulistDataSourceBean.setIrKnjyymd("H.27.12.31");
            skMossyoruijyoukyoulistDataSourceBean.setIrMosno("10000000" + i);
            skMossyoruijyoukyoulistDataSourceBean.setIrHrkmirninnm("振込人名");
            skMossyoruijyoukyoulistDataSourceBean.setIrBanknmkj("振込銀行名");
            skMossyoruijyoukyoulistDataSourceBean.setIrSitennmkj("支店名");
            skMossyoruijyoukyoulistDataSourceBean.setIrHrkmgk(BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR));

            iReportDataSouceBeanLst.add(skMossyoruijyoukyoulistDataSourceBean);
        }
        for (int i = 0; i < 1; i++) {

            SkMossyoruijyoukyoulistDataSourceBean skMossyoruijyoukyoulistDataSourceBean = new SkMossyoruijyoukyoulistDataSourceBean();

            skMossyoruijyoukyoulistDataSourceBean.setIrMostokusokuumu("*");
            skMossyoruijyoukyoulistDataSourceBean.setIrDrtennmkj("取扱代理店名");
            skMossyoruijyoukyoulistDataSourceBean.setIrKnjyymd("H.27.12.31");
            skMossyoruijyoukyoulistDataSourceBean.setIrMosno("100000010");
            skMossyoruijyoukyoulistDataSourceBean.setIrHrkmirninnm("振込人名");
            skMossyoruijyoukyoulistDataSourceBean.setIrBanknmkj("振込銀行名");
            skMossyoruijyoukyoulistDataSourceBean.setIrSitennmkj("支店名");
            skMossyoruijyoukyoulistDataSourceBean.setIrHrkmgk(BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR));

            iReportDataSouceBeanLst.add(skMossyoruijyoukyoulistDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, bzDairitenAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkMossyoruijyoukyoulistTest",
                C_SyoruiCdKbn.SK_MOSSOUHUJYOUKYOULIST);

        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室　行");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrDrtennmkj("親募集代理店");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for (int i = 1; i < 10; i++) {

            SkMossyoruijyoukyoulistDataSourceBean skMossyoruijyoukyoulistDataSourceBean = new SkMossyoruijyoukyoulistDataSourceBean();

            skMossyoruijyoukyoulistDataSourceBean.setIrMostokusokuumu("*");
            skMossyoruijyoukyoulistDataSourceBean.setIrDrtennmkj("取扱代理店名");
            skMossyoruijyoukyoulistDataSourceBean.setIrKnjyymd("H.27.12.31");
            skMossyoruijyoukyoulistDataSourceBean.setIrMosno("10000000" + i);
            skMossyoruijyoukyoulistDataSourceBean.setIrHrkmirninnm("振込人名");
            skMossyoruijyoukyoulistDataSourceBean.setIrBanknmkj("振込銀行名");
            skMossyoruijyoukyoulistDataSourceBean.setIrSitennmkj("支店名");
            skMossyoruijyoukyoulistDataSourceBean.setIrHrkmgk(BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR));

            iReportDataSouceBeanLst.add(skMossyoruijyoukyoulistDataSourceBean);
        }

        for (int i = 0; i < 2; i++) {

            SkMossyoruijyoukyoulistDataSourceBean skMossyoruijyoukyoulistDataSourceBean = new SkMossyoruijyoukyoulistDataSourceBean();

            skMossyoruijyoukyoulistDataSourceBean.setIrMostokusokuumu("*");
            skMossyoruijyoukyoulistDataSourceBean.setIrDrtennmkj("取扱代理店名");
            skMossyoruijyoukyoulistDataSourceBean.setIrKnjyymd("H.27.12.31");
            skMossyoruijyoukyoulistDataSourceBean.setIrMosno("10000001" + i);
            skMossyoruijyoukyoulistDataSourceBean.setIrHrkmirninnm("振込人名");
            skMossyoruijyoukyoulistDataSourceBean.setIrBanknmkj("振込銀行名");
            skMossyoruijyoukyoulistDataSourceBean.setIrSitennmkj("支店名");
            skMossyoruijyoukyoulistDataSourceBean.setIrHrkmgk(BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR));

            iReportDataSouceBeanLst.add(skMossyoruijyoukyoulistDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, bzDairitenAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkMossyoruijyoukyoulistTest",
                C_SyoruiCdKbn.SK_MOSSOUHUJYOUKYOULIST);

        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室　行");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrDrtennmkj("親募集代理店");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for (int i = 0; i < 9990; i++) {

            SkMossyoruijyoukyoulistDataSourceBean skMossyoruijyoukyoulistDataSourceBean = new SkMossyoruijyoukyoulistDataSourceBean();

            skMossyoruijyoukyoulistDataSourceBean.setIrMostokusokuumu("*");
            skMossyoruijyoukyoulistDataSourceBean.setIrDrtennmkj("取扱代理店名");
            skMossyoruijyoukyoulistDataSourceBean.setIrKnjyymd("H.27.12.31");
            skMossyoruijyoukyoulistDataSourceBean.setIrMosno("100000001");
            skMossyoruijyoukyoulistDataSourceBean.setIrHrkmirninnm("振込人名");
            skMossyoruijyoukyoulistDataSourceBean.setIrBanknmkj("振込銀行名");
            skMossyoruijyoukyoulistDataSourceBean.setIrSitennmkj("支店名");
            skMossyoruijyoukyoulistDataSourceBean.setIrHrkmgk(BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR));

            iReportDataSouceBeanLst.add(skMossyoruijyoukyoulistDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, bzDairitenAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkMossyoruijyoukyoulistTest",
                C_SyoruiCdKbn.SK_MOSSOUHUJYOUKYOULIST);

        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室　行");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrDrtennmkj("親募集代理店");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            SkMossyoruijyoukyoulistDataSourceBean skMossyoruijyoukyoulistDataSourceBean1 = new SkMossyoruijyoukyoulistDataSourceBean();

            skMossyoruijyoukyoulistDataSourceBean1.setIrMostokusokuumu("*");
            skMossyoruijyoukyoulistDataSourceBean1.setIrDrtennmkj("取扱代理店名");
            skMossyoruijyoukyoulistDataSourceBean1.setIrKnjyymd("H.27.12.31");
            skMossyoruijyoukyoulistDataSourceBean1.setIrMosno("100000001");
            skMossyoruijyoukyoulistDataSourceBean1.setIrHrkmirninnm("振込人名");
            skMossyoruijyoukyoulistDataSourceBean1.setIrBanknmkj("振込銀行名");
            skMossyoruijyoukyoulistDataSourceBean1.setIrSitennmkj("支店名");
            if( i == 0){
                skMossyoruijyoukyoulistDataSourceBean1.setIrHrkmgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            }else if( i == 1){
                skMossyoruijyoukyoulistDataSourceBean1.setIrHrkmgk(BizCurrency.valueOf(0, BizCurrencyTypes.MANYEN));
            }else if( i == 2){
                skMossyoruijyoukyoulistDataSourceBean1.setIrHrkmgk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
            }else if( i == 3){
                skMossyoruijyoukyoulistDataSourceBean1.setIrHrkmgk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
            }else if( i == 4){
                skMossyoruijyoukyoulistDataSourceBean1.setIrHrkmgk(BizCurrency.valueOf(0, BizCurrencyTypes.EURO));
            }

            iReportDataSouceBeanLst.add(skMossyoruijyoukyoulistDataSourceBean1);

            SkMossyoruijyoukyoulistDataSourceBean skMossyoruijyoukyoulistDataSourceBean2 = new SkMossyoruijyoukyoulistDataSourceBean();

            skMossyoruijyoukyoulistDataSourceBean2.setIrMostokusokuumu("*");
            skMossyoruijyoukyoulistDataSourceBean2.setIrDrtennmkj("取扱代理店名");
            skMossyoruijyoukyoulistDataSourceBean2.setIrKnjyymd("H.27.12.31");
            skMossyoruijyoukyoulistDataSourceBean2.setIrMosno("100000001");
            skMossyoruijyoukyoulistDataSourceBean2.setIrHrkmirninnm("振込人名");
            skMossyoruijyoukyoulistDataSourceBean2.setIrBanknmkj("振込銀行名");
            skMossyoruijyoukyoulistDataSourceBean2.setIrSitennmkj("支店名");
            if( i == 0){
                skMossyoruijyoukyoulistDataSourceBean2.setIrHrkmgk(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
            }else if( i == 1){
                skMossyoruijyoukyoulistDataSourceBean2.setIrHrkmgk(BizCurrency.valueOf(10000, BizCurrencyTypes.MANYEN));
            }else if( i == 2){
                skMossyoruijyoukyoulistDataSourceBean2.setIrHrkmgk(BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR));
            }else if( i == 3){
                skMossyoruijyoukyoulistDataSourceBean2.setIrHrkmgk(BizCurrency.valueOf(10000, BizCurrencyTypes.AU_DOLLAR));
            }else if( i == 4){
                skMossyoruijyoukyoulistDataSourceBean2.setIrHrkmgk(BizCurrency.valueOf(10000, BizCurrencyTypes.EURO));
            }

            iReportDataSouceBeanLst.add(skMossyoruijyoukyoulistDataSourceBean2);

            SkMossyoruijyoukyoulistDataSourceBean skMossyoruijyoukyoulistDataSourceBean3 = new SkMossyoruijyoukyoulistDataSourceBean();

            skMossyoruijyoukyoulistDataSourceBean3.setIrMostokusokuumu("*");
            skMossyoruijyoukyoulistDataSourceBean3.setIrDrtennmkj("取扱代理店名");
            skMossyoruijyoukyoulistDataSourceBean3.setIrKnjyymd("H.27.12.31");
            skMossyoruijyoukyoulistDataSourceBean3.setIrMosno("100000001");
            skMossyoruijyoukyoulistDataSourceBean3.setIrHrkmirninnm("振込人名");
            skMossyoruijyoukyoulistDataSourceBean3.setIrBanknmkj("振込銀行名");
            skMossyoruijyoukyoulistDataSourceBean3.setIrSitennmkj("支店名");
            if( i == 0){
                skMossyoruijyoukyoulistDataSourceBean3.setIrHrkmgk(BizCurrency.valueOf(9999999999L, BizCurrencyTypes.YEN));
            }else if( i == 1){
                skMossyoruijyoukyoulistDataSourceBean3.setIrHrkmgk(BizCurrency.valueOf(9999999999L, BizCurrencyTypes.MANYEN));
            }else if( i == 2){
                skMossyoruijyoukyoulistDataSourceBean3.setIrHrkmgk(BizCurrency.valueOf(9999999999L, BizCurrencyTypes.DOLLAR));
            }else if( i == 3){
                skMossyoruijyoukyoulistDataSourceBean3.setIrHrkmgk(BizCurrency.valueOf(9999999999L, BizCurrencyTypes.AU_DOLLAR));
            }else if( i == 4){
                skMossyoruijyoukyoulistDataSourceBean3.setIrHrkmgk(BizCurrency.valueOf(9999999999L, BizCurrencyTypes.EURO));
            }

            iReportDataSouceBeanLst.add(skMossyoruijyoukyoulistDataSourceBean3);
        }
        reportTestBean.addParamObjects(iReportDataSouceBeanLst, bzDairitenAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkMossyoruijyoukyoulistTest",
                C_SyoruiCdKbn.SK_MOSSOUHUJYOUKYOULIST);

        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室　行");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrDrtennmkj("親募集代理店");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            SkMossyoruijyoukyoulistDataSourceBean skMossyoruijyoukyoulistDataSourceBean1 = new SkMossyoruijyoukyoulistDataSourceBean();

            skMossyoruijyoukyoulistDataSourceBean1.setIrMostokusokuumu("*");
            skMossyoruijyoukyoulistDataSourceBean1.setIrDrtennmkj("取扱代理店名");
            skMossyoruijyoukyoulistDataSourceBean1.setIrKnjyymd("H.27.12.31");
            skMossyoruijyoukyoulistDataSourceBean1.setIrMosno("100000001");
            skMossyoruijyoukyoulistDataSourceBean1.setIrHrkmirninnm("振込人名");
            skMossyoruijyoukyoulistDataSourceBean1.setIrBanknmkj("振込銀行名");
            skMossyoruijyoukyoulistDataSourceBean1.setIrSitennmkj("支店名");
            if( i == 0){
                skMossyoruijyoukyoulistDataSourceBean1.setIrHrkmgk(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
            }else if( i == 1){
                skMossyoruijyoukyoulistDataSourceBean1.setIrHrkmgk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
            }

            iReportDataSouceBeanLst.add(skMossyoruijyoukyoulistDataSourceBean1);

            SkMossyoruijyoukyoulistDataSourceBean skMossyoruijyoukyoulistDataSourceBean2 = new SkMossyoruijyoukyoulistDataSourceBean();

            skMossyoruijyoukyoulistDataSourceBean2.setIrMostokusokuumu("*");
            skMossyoruijyoukyoulistDataSourceBean2.setIrDrtennmkj("取扱代理店名");
            skMossyoruijyoukyoulistDataSourceBean2.setIrKnjyymd("H.27.12.31");
            skMossyoruijyoukyoulistDataSourceBean2.setIrMosno("100000001");
            skMossyoruijyoukyoulistDataSourceBean2.setIrHrkmirninnm("振込人名");
            skMossyoruijyoukyoulistDataSourceBean2.setIrBanknmkj("振込銀行名");
            skMossyoruijyoukyoulistDataSourceBean2.setIrSitennmkj("支店名");
            if( i == 0){
                skMossyoruijyoukyoulistDataSourceBean2.setIrHrkmgk(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
            }else if( i == 1){
                skMossyoruijyoukyoulistDataSourceBean2.setIrHrkmgk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
            }

            iReportDataSouceBeanLst.add(skMossyoruijyoukyoulistDataSourceBean2);

            SkMossyoruijyoukyoulistDataSourceBean skMossyoruijyoukyoulistDataSourceBean3 = new SkMossyoruijyoukyoulistDataSourceBean();

            skMossyoruijyoukyoulistDataSourceBean3.setIrMostokusokuumu("*");
            skMossyoruijyoukyoulistDataSourceBean3.setIrDrtennmkj("取扱代理店名");
            skMossyoruijyoukyoulistDataSourceBean3.setIrKnjyymd("H.27.12.31");
            skMossyoruijyoukyoulistDataSourceBean3.setIrMosno("100000001");
            skMossyoruijyoukyoulistDataSourceBean3.setIrHrkmirninnm("振込人名");
            skMossyoruijyoukyoulistDataSourceBean3.setIrBanknmkj("振込銀行名");
            skMossyoruijyoukyoulistDataSourceBean3.setIrSitennmkj("支店名");
            if( i == 0){
                skMossyoruijyoukyoulistDataSourceBean3.setIrHrkmgk(BizCurrency.valueOf(9999999999L, BizCurrencyTypes.YEN));
            }else if( i == 1){
                skMossyoruijyoukyoulistDataSourceBean3.setIrHrkmgk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
            }

            iReportDataSouceBeanLst.add(skMossyoruijyoukyoulistDataSourceBean3);

            SkMossyoruijyoukyoulistDataSourceBean skMossyoruijyoukyoulistDataSourceBean4 = new SkMossyoruijyoukyoulistDataSourceBean();

            skMossyoruijyoukyoulistDataSourceBean4.setIrMostokusokuumu("*");
            skMossyoruijyoukyoulistDataSourceBean4.setIrDrtennmkj("取扱代理店名");
            skMossyoruijyoukyoulistDataSourceBean4.setIrKnjyymd("H.27.12.31");
            skMossyoruijyoukyoulistDataSourceBean4.setIrMosno("100000001");
            skMossyoruijyoukyoulistDataSourceBean4.setIrHrkmirninnm("振込人名");
            skMossyoruijyoukyoulistDataSourceBean4.setIrBanknmkj("振込銀行名");
            skMossyoruijyoukyoulistDataSourceBean4.setIrSitennmkj("支店名");
            if( i == 0){
                skMossyoruijyoukyoulistDataSourceBean4.setIrHrkmgk(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
            }else if( i == 1){
                skMossyoruijyoukyoulistDataSourceBean4.setIrHrkmgk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
            }

            iReportDataSouceBeanLst.add(skMossyoruijyoukyoulistDataSourceBean4);

            SkMossyoruijyoukyoulistDataSourceBean skMossyoruijyoukyoulistDataSourceBean5 = new SkMossyoruijyoukyoulistDataSourceBean();

            skMossyoruijyoukyoulistDataSourceBean5.setIrMostokusokuumu("*");
            skMossyoruijyoukyoulistDataSourceBean5.setIrDrtennmkj("取扱代理店名");
            skMossyoruijyoukyoulistDataSourceBean5.setIrKnjyymd("H.27.12.31");
            skMossyoruijyoukyoulistDataSourceBean5.setIrMosno("100000001");
            skMossyoruijyoukyoulistDataSourceBean5.setIrHrkmirninnm("振込人名");
            skMossyoruijyoukyoulistDataSourceBean5.setIrBanknmkj("振込銀行名");
            skMossyoruijyoukyoulistDataSourceBean5.setIrSitennmkj("支店名");
            if( i == 0){
                skMossyoruijyoukyoulistDataSourceBean5.setIrHrkmgk(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
            }else if( i == 1){
                skMossyoruijyoukyoulistDataSourceBean5.setIrHrkmgk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
            }

            iReportDataSouceBeanLst.add(skMossyoruijyoukyoulistDataSourceBean5);

            SkMossyoruijyoukyoulistDataSourceBean skMossyoruijyoukyoulistDataSourceBean6 = new SkMossyoruijyoukyoulistDataSourceBean();

            skMossyoruijyoukyoulistDataSourceBean6.setIrMostokusokuumu("*");
            skMossyoruijyoukyoulistDataSourceBean6.setIrDrtennmkj("取扱代理店名");
            skMossyoruijyoukyoulistDataSourceBean6.setIrKnjyymd("H.27.12.31");
            skMossyoruijyoukyoulistDataSourceBean6.setIrMosno("100000001");
            skMossyoruijyoukyoulistDataSourceBean6.setIrHrkmirninnm("振込人名");
            skMossyoruijyoukyoulistDataSourceBean6.setIrBanknmkj("振込銀行名");
            skMossyoruijyoukyoulistDataSourceBean6.setIrSitennmkj("支店名");
            if( i == 0){
                skMossyoruijyoukyoulistDataSourceBean6.setIrHrkmgk(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
            }else if( i == 1){
                skMossyoruijyoukyoulistDataSourceBean6.setIrHrkmgk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
            }

            iReportDataSouceBeanLst.add(skMossyoruijyoukyoulistDataSourceBean6);

        }
        reportTestBean.addParamObjects(iReportDataSouceBeanLst, bzDairitenAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

}