package yuyu.report.sinkeiyaku;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.sinkeiyaku.bean.report.SkNyuukinjyouhouhuittikakuninBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 入金情報不一致確認書帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkNyuukinjyouhouhuittikakuninTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkNyuukinjyouhouhuittikakuninBean skNyuukinjyouhouhuittikakuninBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki(null);
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(null);
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.NYKNMEISAI);
        skNyuukinjyouhouhuittikakuninBean.setIrKouzano(null);
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm(null);
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(null);
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm(null);
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm(null);
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrMosno(null);
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn(null);
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(null);
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou(null);
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou(null);
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm(null);
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj(null);
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu(null);
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm(null);
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno(null);
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn(null);
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei(null);

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));

        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.ONLINE);
        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("123456789012");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("2134567809");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(8800, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015.10.10");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("341256789");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(9900, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("4561235");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("5612347");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015.10.20");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("641237895");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナカナ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("7891234");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015.10.30");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.AUD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ふるはーとＪロードグローバル");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("9999年99月99日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(9999));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.ONLINE);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("wwwwwwwwwwww");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("wwwwwwwwww");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("9999.99.99");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("wwwwwwwww");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("ＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("ＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("wwwwwww");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("wwwwwww");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("9999.99.99");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("wwwwwwwww");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("wwwwwww");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("9999.99.99");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　9999.99.99）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");


        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("100000000000");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("1000000000");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015. 8.31");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("100000000");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ契約者名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("1000000");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("1000000");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015. 8.31");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("100000000");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナ契約者名");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("1000000");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015. 8.31");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ふるはーとＪロードグローバル");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("100000000000");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("1000000000");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015. 8.31");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("100000000");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ契約者名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("1000000");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("1000000");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015. 8.31");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("100000000");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナ契約者名");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("1000000");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015. 8.31");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ふるはーとＪロードグローバル");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("100000000000");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("1000000000");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015. 8.31");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("100000000");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ契約者名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("1000000");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("1000000");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015. 8.31");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("100000000");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナ契約者名");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("1000000");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015. 8.31");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ふるはーとＪロードグローバル");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("100000000000");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("1000000000");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015. 8.31");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("100000000");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ契約者名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("1000000");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("1000000");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015. 8.31");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("100000000");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナ契約者名");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("1000000");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015. 8.31");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ふるはーとＪロードグローバル");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("123456789012");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("2134567809");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015.10.10");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("341256789");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("4561235");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("5612347");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015.10.20");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("641237895");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナカナ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("7891234");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015.10.30");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ふるはーとＪロードグローバル");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("123456789012");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("2134567809");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015.10.10");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("341256789");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("4561235");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("5612347");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015.10.20");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("641237895");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナカナ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("7891234");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015.10.30");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ふるはーとＪロードグローバル");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("123456789012");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("2134567809");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015.10.10");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("341256789");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("4561235");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("5612347");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015.10.20");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("641237895");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナカナ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("7891234");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015.10.30");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ふるはーとＪロードグローバル");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("123456789012");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("2134567809");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(9999999999L, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015.10.10");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("341256789");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("4561235");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("5612347");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015.10.20");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("641237895");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナカナ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("7891234");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015.10.30");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ふるはーとＪロードグローバル");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("123456789012");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("2134567809");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015.10.10");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("341256789");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("4561235");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("5612347");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015.10.20");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("641237895");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナカナ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("7891234");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015.10.30");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ふるはーとＪロードグローバル");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("123456789012");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("2134567809");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015.10.10");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("341256789");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("4561235");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("5612347");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015.10.20");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("641237895");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナカナ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("7891234");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015.10.30");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ふるはーとＪロードグローバル");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("123456789012");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("2134567809");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015.10.10");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("341256789");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("4561235");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("5612347");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015.10.20");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("641237895");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナカナ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("7891234");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015.10.30");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ふるはーとＪロードグローバル");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("123456789012");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("2134567809");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015.10.10");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("341256789");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("4561235");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("5612347");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015.10.20");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("641237895");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナカナ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("7891234");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015.10.30");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ふるはーとＪロードグローバル");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("123456789012");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("2134567809");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015.10.10");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("341256789");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("4561235");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("5612347");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015.10.20");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("641237895");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナカナ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("7891234");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015.10.30");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ふるはーとＪロードグローバル");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("123456789012");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("2134567809");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015.10.10");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("341256789");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("4561235");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("5612347");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015.10.20");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("641237895");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナカナ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("7891234");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015.10.30");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ふるはーとＪロードグローバル");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("123456789012");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("2134567809");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015.10.10");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("341256789");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(9999999999L, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("4561235");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("5612347");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015.10.20");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("641237895");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナカナ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("7891234");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015.10.30");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ふるはーとＪロードグローバル");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("123456789012");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("2134567809");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015.10.10");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("341256789");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("4561235");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("5612347");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015.10.20");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("641237895");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナカナ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("7891234");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015.10.30");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ふるはーとＪロードグローバル");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testCreateReport21() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("123456789012");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("2134567809");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015.10.10");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("341256789");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("4561235");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("5612347");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015.10.20");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("641237895");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナカナ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("7891234");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015.10.30");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ふるはーとＪロードグローバル");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testCreateReport22() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("123456789012");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("2134567809");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015.10.10");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("341256789");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("4561235");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("5612347");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015.10.20");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("641237895");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナカナ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("7891234");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015.10.30");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ふるはーとＪロードグローバル");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testCreateReport23() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("123456789012");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("2134567809");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015.10.10");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("341256789");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("4561235");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("5612347");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015.10.20");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("641237895");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナカナ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("7891234");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015.10.30");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ふるはーとＪロードグローバル");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }


    @Test
    @TestOrder(240)
    @Transactional
    public void testCreateReport24() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki(null);
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(null);
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(null);
        skNyuukinjyouhouhuittikakuninBean.setIrKouzano(null);
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm(null);
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(null);
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm(null);
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm(null);
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrMosno(null);
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn(null);
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(null);
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou(null);
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou(null);
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm(null);
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj(null);
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu(null);
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm(null);
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno(null);
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn(null);
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(null);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei(null);


        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testCreateReport25() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki(null);
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(null);
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.NYKNMEISAI);
        skNyuukinjyouhouhuittikakuninBean.setIrKouzano(null);
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm(null);
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(null);
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm(null);
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm(null);
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrMosno(null);
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn(null);
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(null);
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou(null);
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou(null);
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm(null);
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj(null);
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu(null);
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm(null);
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno(null);
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn(null);
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd(null);
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei(null);

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testCreateReport26() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));

        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.ONLINE);
        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.EUR);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("");

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testCreateReport27() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("123456789012");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("2134567809");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(8800, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015.10.10");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("341256789");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(9900, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("4561235");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("5612347");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015.10.20");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("641237895");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナカナ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("7891234");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015.10.30");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.AUD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("たのしみ未来グローバル");
        skNyuukinjyouhouhuittikakuninBean.setIrSyoruicd(C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testCreateReport28() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("9999年99月99日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(9999));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.ONLINE);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("wwwwwwwwwwww");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("wwwwwwwwww");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("9999.99.99");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("wwwwwwwww");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("ＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("ＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("wwwwwww");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("wwwwwww");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("9999.99.99");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("wwwwwwwww");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("wwwwwww");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("9999.99.99");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.USD);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　9999.99.99）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skNyuukinjyouhouhuittikakuninBean.setIrSyoruicd(C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);
        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(290)
    @Transactional
    public void testCreateReport29() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.NYKNMEISAI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("123456789012");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("2134567809");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(8800, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015.10.10");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("341256789");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(9900, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("4561235");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("5612347");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015.10.20");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("641237895");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナカナ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("7891234");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015.10.30");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.JPY);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("たのしみ未来グローバル");
        skNyuukinjyouhouhuittikakuninBean.setIrSyoruicd(C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(300)
    @Transactional
    public void testCreateReport30() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkNyuukinjyouhouhuittikakuninTest",
                C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO_YENDT);

        skNyuukinjyouhouhuittikakuninBean.setIrAtesaki("代理店契約室　御中");
        skNyuukinjyouhouhuittikakuninBean.setIrTyouhyousakuseiymd("2009年 7月30日");
        skNyuukinjyouhouhuittikakuninBean.setIrPageno(Integer.valueOf(1));
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.NYKNMEISAI);

        skNyuukinjyouhouhuittikakuninBean.setIrKouzano("123456789012");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirninnm("送金人");
        skNyuukinjyouhouhuittikakuninBean.setIrHrkmirnincd("2134567809");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknkkngk(BizCurrency.valueOf(8800, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSimukebanknm("仕向銀行名");
        skNyuukinjyouhouhuittikakuninBean.setIrSimuketennm("仕向店名");
        skNyuukinjyouhouhuittikakuninBean.setIrMosymd("2015.10.10");
        skNyuukinjyouhouhuittikakuninBean.setIrMosno("341256789");
        skNyuukinjyouhouhuittikakuninBean.setIrKyknmkn("カナ");
        skNyuukinjyouhouhuittikakuninBean.setIrMosfstpkei(BizCurrency.valueOf(9900, BizCurrencyTypes.YEN));
        skNyuukinjyouhouhuittikakuninBean.setIrSeikeijizenkizennou("あり");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinjyoukyou("未入金");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtencd("4561235");
        skNyuukinjyouhouhuittikakuninBean.setIrOyadrtennm("代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrDrtennmkj("Ａ扱者代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrNyuukinhuittiriyuu("申込番号不一致");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytencd("5612347");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneioyadytennm("保険料反映代理店名");
        skNyuukinjyouhouhuittikakuninBean.setIrKnjyymd("2015.10.20");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneimosno("641237895");
        skNyuukinjyouhouhuittikakuninBean.setIrPhaneikyknmkn("カナカナ");
        skNyuukinjyouhouhuittikakuninBean.setIrJigyouhicd("7891234");
        skNyuukinjyouhouhuittikakuninBean.setIrNyknrnrkhyouymd("2015.10.30");
        skNyuukinjyouhouhuittikakuninBean.setIrSiteituuka(C_Tuukasyu.JPY);
        skNyuukinjyouhouhuittikakuninBean.setIrMeisaitrkmymd("（明細取込日　2015. 8.31）");
        skNyuukinjyouhouhuittikakuninBean.setIrAisyoumei("たのしみ未来グローバル");
        skNyuukinjyouhouhuittikakuninBean.setIrSyoruicd(C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO_YENDT);

        reportTestBean.addParamObjects(skNyuukinjyouhouhuittikakuninBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }
}
