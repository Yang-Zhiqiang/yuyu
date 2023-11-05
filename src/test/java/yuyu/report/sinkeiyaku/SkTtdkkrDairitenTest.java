package yuyu.report.sinkeiyaku;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzDairitenAtesakiBean;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.sinkeiyaku.bean.report.SkTtdkkanryouTuutiBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 手続完了通知（代理店宛）クラス
 */
@RunWith(OrderedRunner.class)
public class SkTtdkkrDairitenTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkTtdkkanryouTuutiBean skTtdkkanryouTuutiBean;

    @Inject
    private BzDairitenAtesakiBean bzDairitenAtesakiBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTtdkkrDairiten", C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);

        skTtdkkanryouTuutiBean.setIrTyouhyoutitle("");
        skTtdkkanryouTuutiBean.setIrKyknmkj("");
        skTtdkkanryouTuutiBean.setIrMosno("");
        skTtdkkanryouTuutiBean.setIrFstphrkgk("");
        skTtdkkanryouTuutiBean.setIrHnknyoteiymd("");
        skTtdkkanryouTuutiBean.setIrHknsyurui("");
        skTtdkkanryouTuutiBean.setIrAisyoumei("");
        skTtdkkanryouTuutiBean.setIrTratkisitennm("");
        skTtdkkanryouTuutiBean.setIrTratkitantounmkj("");
        skTtdkkanryouTuutiBean.setIrUktkid("");
        skTtdkkanryouTuutiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skTtdkkanryouTuutiBean.setIrKetkekkacd(C_Ketkekkacd.ENKI_SUUNENGOSAISIN);
        skTtdkkanryouTuutiBean.setIrHenkinumu(C_UmuKbn.ARI);
        skTtdkkanryouTuutiBean.setIrSeiritukbn(C_SeirituKbn.ITIPMATI);

        bzDairitenAtesakiBean.setIrTyouhyousakuseiymd("");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("");
        bzDairitenAtesakiBean.setIrHknkisynm("");
        bzDairitenAtesakiBean.setIrToiawasesosiki("");
        bzDairitenAtesakiBean.setIrToiawasetantounm("");
        bzDairitenAtesakiBean.setIrToiawasetelno("");
        bzDairitenAtesakiBean.setIrToiawasefaxno("");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("");

        reportTestBean.addParamObjects(skTtdkkanryouTuutiBean, bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTtdkkrDairiten", C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);

        skTtdkkanryouTuutiBean.setIrTyouhyoutitle(null);
        skTtdkkanryouTuutiBean.setIrKyknmkj(null);
        skTtdkkanryouTuutiBean.setIrMosno(null);
        skTtdkkanryouTuutiBean.setIrFstphrkgk(null);
        skTtdkkanryouTuutiBean.setIrHnknyoteiymd(null);
        skTtdkkanryouTuutiBean.setIrHknsyurui(null);
        skTtdkkanryouTuutiBean.setIrAisyoumei(null);
        skTtdkkanryouTuutiBean.setIrTratkisitennm(null);
        skTtdkkanryouTuutiBean.setIrTratkitantounmkj(null);
        skTtdkkanryouTuutiBean.setIrUktkid(null);
        skTtdkkanryouTuutiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skTtdkkanryouTuutiBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skTtdkkanryouTuutiBean.setIrHenkinumu(C_UmuKbn.ARI);
        skTtdkkanryouTuutiBean.setIrSeiritukbn(C_SeirituKbn.ITIPMATI);

        bzDairitenAtesakiBean.setIrTyouhyousakuseiymd(null);
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1(null);
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2(null);
        bzDairitenAtesakiBean.setIrTratkitantounmkj(null);
        bzDairitenAtesakiBean.setIrHknkisynm(null);
        bzDairitenAtesakiBean.setIrToiawasesosiki(null);
        bzDairitenAtesakiBean.setIrToiawasetantounm(null);
        bzDairitenAtesakiBean.setIrToiawasetelno(null);
        bzDairitenAtesakiBean.setIrToiawasefaxno(null);
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi(null);

        reportTestBean.addParamObjects(skTtdkkanryouTuutiBean, bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTtdkkrDairiten", C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);

        skTtdkkanryouTuutiBean.setIrTyouhyoutitle("クーリングオフ手続き完了のお知らせ");
        skTtdkkanryouTuutiBean.setIrKyknmkj("契約者名");
        skTtdkkanryouTuutiBean.setIrMosno("100000001");
        skTtdkkanryouTuutiBean.setIrFstphrkgk("2,999.99 豪ドル");
        skTtdkkanryouTuutiBean.setIrHnknyoteiymd("2018年 7月11日");
        skTtdkkanryouTuutiBean.setIrHknsyurui("低解約返戻金型無配当特別終身保険");
        skTtdkkanryouTuutiBean.setIrAisyoumei("「ふるはーとＦ」");
        skTtdkkanryouTuutiBean.setIrTratkisitennm("取扱支店名");
        skTtdkkanryouTuutiBean.setIrTratkitantounmkj("取扱担当者名");
        skTtdkkanryouTuutiBean.setIrUktkid("12345678900987654321");
        skTtdkkanryouTuutiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skTtdkkanryouTuutiBean.setIrKetkekkacd(C_Ketkekkacd.COOLINGOFF);
        skTtdkkanryouTuutiBean.setIrHenkinumu(C_UmuKbn.ARI);
        skTtdkkanryouTuutiBean.setIrSeiritukbn(C_SeirituKbn.HUSEIRITU);

        bzDairitenAtesakiBean.setIrTyouhyousakuseiymd("2018年 7月10日");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("打出機関名２");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名");
        bzDairitenAtesakiBean.setIrHknkisynm("保険会社名");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetantounm("新契約チーム");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-303");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX");

        reportTestBean.addParamObjects(skTtdkkanryouTuutiBean, bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTtdkkrDairiten", C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);

        skTtdkkanryouTuutiBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skTtdkkanryouTuutiBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skTtdkkanryouTuutiBean.setIrMosno("wwwwwwwww");
        skTtdkkanryouTuutiBean.setIrFstphrkgk("9,999,999,999.99 ＷＷＷ");
        skTtdkkanryouTuutiBean.setIrHnknyoteiymd("9999年99月99日");
        skTtdkkanryouTuutiBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skTtdkkanryouTuutiBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skTtdkkanryouTuutiBean.setIrTratkisitennm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skTtdkkanryouTuutiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skTtdkkanryouTuutiBean.setIrUktkid("wwwwwwwwwwwwwwwwwwww");
        skTtdkkanryouTuutiBean.setIrSkeijimukbn(C_SkeijimuKbn.SMBC);
        skTtdkkanryouTuutiBean.setIrKetkekkacd(C_Ketkekkacd.COOLINGOFF);
        skTtdkkanryouTuutiBean.setIrHenkinumu(C_UmuKbn.ARI);
        skTtdkkanryouTuutiBean.setIrSeiritukbn(C_SeirituKbn.ITIPMATI);

        bzDairitenAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("www");

        reportTestBean.addParamObjects(skTtdkkanryouTuutiBean, bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTtdkkrDairiten", C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);

        skTtdkkanryouTuutiBean.setIrTyouhyoutitle("クーリングオフ手続き完了のお知らせ");
        skTtdkkanryouTuutiBean.setIrKyknmkj("契約者名");
        skTtdkkanryouTuutiBean.setIrMosno("100000001");
        skTtdkkanryouTuutiBean.setIrFstphrkgk("2,999.99 豪ドル");
        skTtdkkanryouTuutiBean.setIrHnknyoteiymd("2018年 7月11日");
        skTtdkkanryouTuutiBean.setIrHknsyurui("低解約返戻金型無配当特別終身保険");
        skTtdkkanryouTuutiBean.setIrAisyoumei("「ふるはーとＦ」");
        skTtdkkanryouTuutiBean.setIrTratkisitennm("取扱支店名");
        skTtdkkanryouTuutiBean.setIrTratkitantounmkj("取扱担当者名");
        skTtdkkanryouTuutiBean.setIrUktkid("12345678900987654321");
        skTtdkkanryouTuutiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skTtdkkanryouTuutiBean.setIrKetkekkacd(C_Ketkekkacd.COOLINGOFF);
        skTtdkkanryouTuutiBean.setIrHenkinumu(C_UmuKbn.NONE);
        skTtdkkanryouTuutiBean.setIrSeiritukbn(C_SeirituKbn.HUSEIRITU);

        bzDairitenAtesakiBean.setIrTyouhyousakuseiymd("2018年 7月10日");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("打出機関名２");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名");
        bzDairitenAtesakiBean.setIrHknkisynm("保険会社名");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetantounm("新契約チーム");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-303");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("123");

        reportTestBean.addParamObjects(skTtdkkanryouTuutiBean, bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTtdkkrDairiten", C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);

        skTtdkkanryouTuutiBean.setIrTyouhyoutitle("クーリングオフ手続き完了のお知らせ");
        skTtdkkanryouTuutiBean.setIrKyknmkj("契約者名");
        skTtdkkanryouTuutiBean.setIrMosno("100000001");
        skTtdkkanryouTuutiBean.setIrFstphrkgk("2,999.99 豪ドル");
        skTtdkkanryouTuutiBean.setIrHnknyoteiymd("2018年 7月11日");
        skTtdkkanryouTuutiBean.setIrHknsyurui("低解約返戻金型無配当特別終身保険");
        skTtdkkanryouTuutiBean.setIrAisyoumei("「ふるはーとＦ」");
        skTtdkkanryouTuutiBean.setIrTratkisitennm("取扱支店名");
        skTtdkkanryouTuutiBean.setIrTratkitantounmkj("取扱担当者名");
        skTtdkkanryouTuutiBean.setIrUktkid("12345678900987654321");
        skTtdkkanryouTuutiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skTtdkkanryouTuutiBean.setIrKetkekkacd(C_Ketkekkacd.MOS_TORIKESI);
        skTtdkkanryouTuutiBean.setIrHenkinumu(C_UmuKbn.NONE);
        skTtdkkanryouTuutiBean.setIrSeiritukbn(C_SeirituKbn.HUSEIRITU);

        bzDairitenAtesakiBean.setIrTyouhyousakuseiymd("2018年 7月10日");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("打出機関名２");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名");
        bzDairitenAtesakiBean.setIrHknkisynm("保険会社名");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetantounm("新契約チーム");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-303");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("123");

        reportTestBean.addParamObjects(skTtdkkanryouTuutiBean, bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTtdkkrDairiten", C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);

        skTtdkkanryouTuutiBean.setIrTyouhyoutitle("クーリングオフ手続き完了のお知らせ");
        skTtdkkanryouTuutiBean.setIrKyknmkj("契約者名");
        skTtdkkanryouTuutiBean.setIrMosno("100000001");
        skTtdkkanryouTuutiBean.setIrFstphrkgk("2,999.99 豪ドル");
        skTtdkkanryouTuutiBean.setIrHnknyoteiymd("2018年 7月11日");
        skTtdkkanryouTuutiBean.setIrHknsyurui("低解約返戻金型無配当特別終身保険");
        skTtdkkanryouTuutiBean.setIrAisyoumei("「ふるはーとＦ」");
        skTtdkkanryouTuutiBean.setIrTratkisitennm("取扱支店名");
        skTtdkkanryouTuutiBean.setIrTratkitantounmkj("取扱担当者名");
        skTtdkkanryouTuutiBean.setIrUktkid("12345678900987654321");
        skTtdkkanryouTuutiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skTtdkkanryouTuutiBean.setIrKetkekkacd(C_Ketkekkacd.MOS_TORIKESI);
        skTtdkkanryouTuutiBean.setIrHenkinumu(C_UmuKbn.ARI);
        skTtdkkanryouTuutiBean.setIrSeiritukbn(C_SeirituKbn.ITIPMATI);

        bzDairitenAtesakiBean.setIrTyouhyousakuseiymd("2018年 7月10日");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("打出機関名２");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名");
        bzDairitenAtesakiBean.setIrHknkisynm("保険会社名");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetantounm("新契約チーム");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-303");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("123");

        reportTestBean.addParamObjects(skTtdkkanryouTuutiBean, bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTtdkkrDairiten", C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);

        skTtdkkanryouTuutiBean.setIrTyouhyoutitle("");
        skTtdkkanryouTuutiBean.setIrKyknmkj("");
        skTtdkkanryouTuutiBean.setIrMosno("");
        skTtdkkanryouTuutiBean.setIrFstphrkgk("");
        skTtdkkanryouTuutiBean.setIrHnknyoteiymd("");
        skTtdkkanryouTuutiBean.setIrHknsyurui("");
        skTtdkkanryouTuutiBean.setIrAisyoumei("");
        skTtdkkanryouTuutiBean.setIrTratkisitennm("");
        skTtdkkanryouTuutiBean.setIrTratkitantounmkj("");
        skTtdkkanryouTuutiBean.setIrUktkid("");
        skTtdkkanryouTuutiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skTtdkkanryouTuutiBean.setIrKetkekkacd(C_Ketkekkacd.ENKI_SIJINASI);
        skTtdkkanryouTuutiBean.setIrHenkinumu(C_UmuKbn.ARI);
        skTtdkkanryouTuutiBean.setIrSeiritukbn(C_SeirituKbn.HUSEIRITU);

        bzDairitenAtesakiBean.setIrTyouhyousakuseiymd("");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("");
        bzDairitenAtesakiBean.setIrHknkisynm("");
        bzDairitenAtesakiBean.setIrToiawasesosiki("");
        bzDairitenAtesakiBean.setIrToiawasetantounm("");
        bzDairitenAtesakiBean.setIrToiawasetelno("");
        bzDairitenAtesakiBean.setIrToiawasefaxno("");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("");

        reportTestBean.addParamObjects(skTtdkkanryouTuutiBean, bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTtdkkrDairiten", C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);

        skTtdkkanryouTuutiBean.setIrTyouhyoutitle(null);
        skTtdkkanryouTuutiBean.setIrKyknmkj(null);
        skTtdkkanryouTuutiBean.setIrMosno(null);
        skTtdkkanryouTuutiBean.setIrFstphrkgk(null);
        skTtdkkanryouTuutiBean.setIrHnknyoteiymd(null);
        skTtdkkanryouTuutiBean.setIrHknsyurui(null);
        skTtdkkanryouTuutiBean.setIrAisyoumei(null);
        skTtdkkanryouTuutiBean.setIrTratkisitennm(null);
        skTtdkkanryouTuutiBean.setIrTratkitantounmkj(null);
        skTtdkkanryouTuutiBean.setIrUktkid(null);
        skTtdkkanryouTuutiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skTtdkkanryouTuutiBean.setIrKetkekkacd(C_Ketkekkacd.ENKI_SUUNENGOSAISIN);
        skTtdkkanryouTuutiBean.setIrHenkinumu(C_UmuKbn.ARI);
        skTtdkkanryouTuutiBean.setIrSeiritukbn(C_SeirituKbn.HUSEIRITU);

        bzDairitenAtesakiBean.setIrTyouhyousakuseiymd(null);
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1(null);
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2(null);
        bzDairitenAtesakiBean.setIrTratkitantounmkj(null);
        bzDairitenAtesakiBean.setIrHknkisynm(null);
        bzDairitenAtesakiBean.setIrToiawasesosiki(null);
        bzDairitenAtesakiBean.setIrToiawasetantounm(null);
        bzDairitenAtesakiBean.setIrToiawasetelno(null);
        bzDairitenAtesakiBean.setIrToiawasefaxno(null);
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi(null);

        reportTestBean.addParamObjects(skTtdkkanryouTuutiBean, bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTtdkkrDairiten", C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);

        skTtdkkanryouTuutiBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skTtdkkanryouTuutiBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skTtdkkanryouTuutiBean.setIrMosno("wwwwwwwww");
        skTtdkkanryouTuutiBean.setIrFstphrkgk("9,999,999,999.99 ＷＷＷ");
        skTtdkkanryouTuutiBean.setIrHnknyoteiymd("9999年99月99日");
        skTtdkkanryouTuutiBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skTtdkkanryouTuutiBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skTtdkkanryouTuutiBean.setIrTratkisitennm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skTtdkkanryouTuutiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skTtdkkanryouTuutiBean.setIrUktkid("wwwwwwwwwwwwwwwwwwww");
        skTtdkkanryouTuutiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skTtdkkanryouTuutiBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);
        skTtdkkanryouTuutiBean.setIrHenkinumu(C_UmuKbn.ARI);
        skTtdkkanryouTuutiBean.setIrSeiritukbn(C_SeirituKbn.HUSEIRITU);

        bzDairitenAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("www");

        reportTestBean.addParamObjects(skTtdkkanryouTuutiBean, bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTtdkkrDairiten", C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN);

        skTtdkkanryouTuutiBean.setIrTyouhyoutitle("クーリングオフ手続き完了のお知らせ");
        skTtdkkanryouTuutiBean.setIrKyknmkj("契約者名");
        skTtdkkanryouTuutiBean.setIrMosno("100000001");
        skTtdkkanryouTuutiBean.setIrFstphrkgk("2,999.99 豪ドル");
        skTtdkkanryouTuutiBean.setIrHnknyoteiymd("2018年 7月11日");
        skTtdkkanryouTuutiBean.setIrHknsyurui("低解約返戻金型無配当特別終身保険");
        skTtdkkanryouTuutiBean.setIrAisyoumei("「ふるはーとＦ」");
        skTtdkkanryouTuutiBean.setIrTratkisitennm("取扱支店名");
        skTtdkkanryouTuutiBean.setIrTratkitantounmkj("取扱担当者名");
        skTtdkkanryouTuutiBean.setIrUktkid("12345678900987654321");
        skTtdkkanryouTuutiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);
        skTtdkkanryouTuutiBean.setIrKetkekkacd(C_Ketkekkacd.ENKI_SIJINASI);
        skTtdkkanryouTuutiBean.setIrHenkinumu(C_UmuKbn.ARI);
        skTtdkkanryouTuutiBean.setIrSeiritukbn(C_SeirituKbn.ITIPMATI);

        bzDairitenAtesakiBean.setIrTyouhyousakuseiymd("2018年 7月10日");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("打出機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("打出機関名２");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱担当者名");
        bzDairitenAtesakiBean.setIrHknkisynm("保険会社名");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetantounm("新契約チーム");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-303");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("123");

        reportTestBean.addParamObjects(skTtdkkanryouTuutiBean, bzDairitenAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
