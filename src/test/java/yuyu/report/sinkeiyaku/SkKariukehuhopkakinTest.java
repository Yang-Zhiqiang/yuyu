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
import yuyu.def.sinkeiyaku.bean.report.SkKariukeHuhopkakinBean;
import yuyu.def.sinkeiyaku.bean.report.SkKariukehuhopkakinDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 仮受（普保Ｐ過金）１ヵ月超経過リスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkKariukehuhopkakinTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkKariukeHuhopkakinBean skkariukehuhopkakinBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkKariukefuhopkakinTest",
                C_SyoruiCdKbn.SK_KARIUKEHUHOPKAKIN1MKEIKA);

        skkariukehuhopkakinBean.setIrAtesaki("");
        skkariukehuhopkakinBean.setIrTyouhyousakuseiymd("");
        skkariukehuhopkakinBean.setIrSyuukeiym("");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();


        SkKariukehuhopkakinDataSourceBean SkKariukehuhopkakinDataSourceBean = new SkKariukehuhopkakinDataSourceBean();

        SkKariukehuhopkakinDataSourceBean.setIrMosno("");
        SkKariukehuhopkakinDataSourceBean.setIrSuitouymdseireki("");
        SkKariukehuhopkakinDataSourceBean.setIrHnknriyuukbn("");
        SkKariukehuhopkakinDataSourceBean.setIrHnkngkkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        SkKariukehuhopkakinDataSourceBean.setIrDrtennmkj("");
        SkKariukehuhopkakinDataSourceBean.setIrAatukaikojincd("");

        iReportDataSouceBeanLst.add(SkKariukehuhopkakinDataSourceBean);


        reportTestBean.addParamObjects(iReportDataSouceBeanLst, skkariukehuhopkakinBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkKariukefuhopkakinTest",
                C_SyoruiCdKbn.SK_KARIUKEHUHOPKAKIN1MKEIKA);

        skkariukehuhopkakinBean.setIrAtesaki(null);
        skkariukehuhopkakinBean.setIrTyouhyousakuseiymd(null);
        skkariukehuhopkakinBean.setIrSyuukeiym(null);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();


        SkKariukehuhopkakinDataSourceBean SkKariukehuhopkakinDataSourceBean = new SkKariukehuhopkakinDataSourceBean();

        SkKariukehuhopkakinDataSourceBean.setIrMosno(null);
        SkKariukehuhopkakinDataSourceBean.setIrSuitouymdseireki(null);
        SkKariukehuhopkakinDataSourceBean.setIrHnknriyuukbn(null);
        SkKariukehuhopkakinDataSourceBean.setIrHnkngkkngk(null);
        SkKariukehuhopkakinDataSourceBean.setIrDrtennmkj(null);
        SkKariukehuhopkakinDataSourceBean.setIrAatukaikojincd(null);

        iReportDataSouceBeanLst.add(SkKariukehuhopkakinDataSourceBean);


        reportTestBean.addParamObjects(iReportDataSouceBeanLst, skkariukehuhopkakinBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkKariukefuhopkakinTest",
                C_SyoruiCdKbn.SK_KARIUKEHUHOPKAKIN1MKEIKA);

        skkariukehuhopkakinBean.setIrAtesaki("代理店契約室　御中");
        skkariukehuhopkakinBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skkariukehuhopkakinBean.setIrSyuukeiym("平成21年 7月末");
        skkariukehuhopkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEHUHOPKAKIN1MKEIKA);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        SkKariukehuhopkakinDataSourceBean SkKariukehuhopkakinDataSourceBean = new SkKariukehuhopkakinDataSourceBean();

        SkKariukehuhopkakinDataSourceBean.setIrMosno(String.valueOf(100000001));
        SkKariukehuhopkakinDataSourceBean.setIrSuitouymdseireki("平成21年 7月31日");
        SkKariukehuhopkakinDataSourceBean.setIrHnknriyuukbn("有効期間経過");
        SkKariukehuhopkakinDataSourceBean.setIrHnkngkkngk(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        SkKariukehuhopkakinDataSourceBean.setIrDrtennmkj("代理店名");
        SkKariukehuhopkakinDataSourceBean.setIrAatukaikojincd("9900000001");

        iReportDataSouceBeanLst.add(SkKariukehuhopkakinDataSourceBean);
        for (int i = 1; i < 19; i++) {

            SkKariukehuhopkakinDataSourceBean SkKariukehuhopkakinDataSourceBean1 = new SkKariukehuhopkakinDataSourceBean();

            SkKariukehuhopkakinDataSourceBean1.setIrMosno(String.valueOf(100000001+i));
            SkKariukehuhopkakinDataSourceBean1.setIrSuitouymdseireki("平成21年 8月"+i+"日");
            SkKariukehuhopkakinDataSourceBean1.setIrHnknriyuukbn("有効期間経過"+i);
            SkKariukehuhopkakinDataSourceBean1.setIrHnkngkkngk(BizCurrency.valueOf(9999+i, BizCurrencyTypes.YEN));
            SkKariukehuhopkakinDataSourceBean1.setIrDrtennmkj("代理店名"+i);
            SkKariukehuhopkakinDataSourceBean1.setIrAatukaikojincd(String.valueOf(9900000001L+i));

            iReportDataSouceBeanLst.add(SkKariukehuhopkakinDataSourceBean1);
        }

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, skkariukehuhopkakinBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkKariukefuhopkakinTest",
                C_SyoruiCdKbn.SK_KARIUKEHUHOPKAKIN1MKEIKA);

        skkariukehuhopkakinBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skkariukehuhopkakinBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        skkariukehuhopkakinBean.setIrSyuukeiym("ＷＷ99年99月末");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();


        SkKariukehuhopkakinDataSourceBean SkKariukehuhopkakinDataSourceBean = new SkKariukehuhopkakinDataSourceBean();

        SkKariukehuhopkakinDataSourceBean.setIrMosno("wwwwwwwww");
        SkKariukehuhopkakinDataSourceBean.setIrSuitouymdseireki("ＷＷ99年99月99日");
        SkKariukehuhopkakinDataSourceBean.setIrHnknriyuukbn("ＷＷＷＷＷＷＷＷＷＷ");
        SkKariukehuhopkakinDataSourceBean.setIrHnkngkkngk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        SkKariukehuhopkakinDataSourceBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        SkKariukehuhopkakinDataSourceBean.setIrAatukaikojincd("wwwwwwwwww");

        iReportDataSouceBeanLst.add(SkKariukehuhopkakinDataSourceBean);


        reportTestBean.addParamObjects(iReportDataSouceBeanLst, skkariukehuhopkakinBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkKariukefuhopkakinTest",
                C_SyoruiCdKbn.SK_KARIUKEHUHOPKAKIN1MKEIKA);

        skkariukehuhopkakinBean.setIrAtesaki("代理店契約室　御中");
        skkariukehuhopkakinBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skkariukehuhopkakinBean.setIrSyuukeiym("平成21年 7月末");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for (int i = 0; i < 20; i++) {

            SkKariukehuhopkakinDataSourceBean SkKariukehuhopkakinDataSourceBean = new SkKariukehuhopkakinDataSourceBean();

            SkKariukehuhopkakinDataSourceBean.setIrMosno(String.valueOf(100000001+i));
            SkKariukehuhopkakinDataSourceBean.setIrSuitouymdseireki("平成21年 7月31日");
            SkKariukehuhopkakinDataSourceBean.setIrHnknriyuukbn("有効期間経過");
            SkKariukehuhopkakinDataSourceBean.setIrHnkngkkngk(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
            SkKariukehuhopkakinDataSourceBean.setIrDrtennmkj("代理店名");
            SkKariukehuhopkakinDataSourceBean.setIrAatukaikojincd("9900000001");

            iReportDataSouceBeanLst.add(SkKariukehuhopkakinDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, skkariukehuhopkakinBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkKariukefuhopkakinTest",
                C_SyoruiCdKbn.SK_KARIUKEHUHOPKAKIN1MKEIKA);

        skkariukehuhopkakinBean.setIrAtesaki("代理店契約室　御中");
        skkariukehuhopkakinBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skkariukehuhopkakinBean.setIrSyuukeiym("平成21年 7月末");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for (int i = 0; i < 21; i++) {

            SkKariukehuhopkakinDataSourceBean SkKariukehuhopkakinDataSourceBean = new SkKariukehuhopkakinDataSourceBean();

            SkKariukehuhopkakinDataSourceBean.setIrMosno(String.valueOf(100000001+i));
            SkKariukehuhopkakinDataSourceBean.setIrSuitouymdseireki("平成21年 7月31日");
            SkKariukehuhopkakinDataSourceBean.setIrHnknriyuukbn("有効期間経過");
            SkKariukehuhopkakinDataSourceBean.setIrHnkngkkngk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
            SkKariukehuhopkakinDataSourceBean.setIrDrtennmkj("代理店名");
            SkKariukehuhopkakinDataSourceBean.setIrAatukaikojincd("9900000001");

            iReportDataSouceBeanLst.add(SkKariukehuhopkakinDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, skkariukehuhopkakinBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkKariukefuhopkakinTest",
                C_SyoruiCdKbn.SK_KARIUKEHUHOPKAKIN1MKEIKA);

        skkariukehuhopkakinBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skkariukehuhopkakinBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        skkariukehuhopkakinBean.setIrSyuukeiym("ＷＷ99年99月末");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        SkKariukehuhopkakinDataSourceBean SkKariukehuhopkakinDataSourceBean = new SkKariukehuhopkakinDataSourceBean();

        SkKariukehuhopkakinDataSourceBean.setIrMosno("wwwwwwwww");
        SkKariukehuhopkakinDataSourceBean.setIrSuitouymdseireki("ＷＷ99年99月99日");
        SkKariukehuhopkakinDataSourceBean.setIrHnknriyuukbn("ＷＷＷＷＷＷＷＷＷＷ");
        SkKariukehuhopkakinDataSourceBean.setIrHnkngkkngk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        SkKariukehuhopkakinDataSourceBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        SkKariukehuhopkakinDataSourceBean.setIrAatukaikojincd("wwwwwwwwww");

        iReportDataSouceBeanLst.add(SkKariukehuhopkakinDataSourceBean);


        reportTestBean.addParamObjects(iReportDataSouceBeanLst, skkariukehuhopkakinBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkKariukefuhopkakinTest",
                C_SyoruiCdKbn.SK_KARIUKEHUHOPKAKIN1MKEIKA);

        skkariukehuhopkakinBean.setIrAtesaki("代理店契約室　御中");
        skkariukehuhopkakinBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skkariukehuhopkakinBean.setIrSyuukeiym("平成21年 7月末");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for (int i = 0; i < 19980; i++) {

            SkKariukehuhopkakinDataSourceBean SkKariukehuhopkakinDataSourceBean = new SkKariukehuhopkakinDataSourceBean();

            SkKariukehuhopkakinDataSourceBean.setIrMosno(String.valueOf(100000001+i));
            SkKariukehuhopkakinDataSourceBean.setIrSuitouymdseireki("平成21年 7月31日");
            SkKariukehuhopkakinDataSourceBean.setIrHnknriyuukbn("有効期間経過");
            SkKariukehuhopkakinDataSourceBean.setIrHnkngkkngk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
            SkKariukehuhopkakinDataSourceBean.setIrDrtennmkj("代理店名");
            SkKariukehuhopkakinDataSourceBean.setIrAatukaikojincd("9900000001");

            iReportDataSouceBeanLst.add(SkKariukehuhopkakinDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, skkariukehuhopkakinBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkKariukefuhopkakinTest",
                C_SyoruiCdKbn.SK_KARIUKEHUHOPKAKIN1MKEIKA);

        skkariukehuhopkakinBean.setIrAtesaki("代理店契約室　御中");
        skkariukehuhopkakinBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skkariukehuhopkakinBean.setIrSyuukeiym("平成21年 7月末");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for (int i = 0; i < 99999; i++) {

            SkKariukehuhopkakinDataSourceBean SkKariukehuhopkakinDataSourceBean = new SkKariukehuhopkakinDataSourceBean();

            SkKariukehuhopkakinDataSourceBean.setIrMosno(String.valueOf(100000001+i));
            SkKariukehuhopkakinDataSourceBean.setIrSuitouymdseireki("平成21年 7月31日");
            SkKariukehuhopkakinDataSourceBean.setIrHnknriyuukbn("有効期間経過");
            SkKariukehuhopkakinDataSourceBean.setIrHnkngkkngk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
            SkKariukehuhopkakinDataSourceBean.setIrDrtennmkj("代理店名");
            SkKariukehuhopkakinDataSourceBean.setIrAatukaikojincd("9900000001");

            iReportDataSouceBeanLst.add(SkKariukehuhopkakinDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, skkariukehuhopkakinBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkKariukefuhopkakinTest",
                C_SyoruiCdKbn.SK_KARIUKEHUHOPKAKIN1MKEIKA);

        skkariukehuhopkakinBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skkariukehuhopkakinBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        skkariukehuhopkakinBean.setIrSyuukeiym("ＷＷ99年99月末");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, skkariukehuhopkakinBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkKariukefuhopkakinTest",
                C_SyoruiCdKbn.SK_KARIUKEHUHOPKAKIN1MKEIKA_YENDT);

        skkariukehuhopkakinBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skkariukehuhopkakinBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        skkariukehuhopkakinBean.setIrSyuukeiym("ＷＷ99年99月末");
        skkariukehuhopkakinBean.setIrSyoruicd(C_SyoruiCdKbn.SK_KARIUKEHUHOPKAKIN1MKEIKA_YENDT);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, skkariukehuhopkakinBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

}