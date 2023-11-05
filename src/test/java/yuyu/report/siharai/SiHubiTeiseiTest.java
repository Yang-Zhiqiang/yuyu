package yuyu.report.siharai;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzSksKaisyasiyouranBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.siharai.bean.report.SiHubiteiseiBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 不備訂正書テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SiHubiTeiseiTest extends AbstractTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SiHubiteiseiBean siHubiteiseiBean;

    @Inject
    private BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono(null);
        siHubiteiseiBean.setIrSeikyuusyanmkj(null);
        siHubiteiseiBean.setIrHubimsg1(null);
        siHubiteiseiBean.setIrHubimsg2(null);
        siHubiteiseiBean.setIrHubimsg3(null);
        siHubiteiseiBean.setIrHubimsg4(null);
        siHubiteiseiBean.setIrHubimsg5(null);
        siHubiteiseiBean.setIrHubimsg6(null);
        siHubiteiseiBean.setIrHubimsg7(null);
        siHubiteiseiBean.setIrHubimsg8(null);
        siHubiteiseiBean.setIrHubimsg9(null);
        siHubiteiseiBean.setIrHubimsg10(null);
        siHubiteiseiBean.setIrRenno1(null);
        siHubiteiseiBean.setIrRenno2(null);
        siHubiteiseiBean.setIrRenno3(null);
        siHubiteiseiBean.setIrRenno4(null);
        siHubiteiseiBean.setIrRenno5(null);
        siHubiteiseiBean.setIrRenno6(null);
        siHubiteiseiBean.setIrRenno7(null);
        siHubiteiseiBean.setIrRenno8(null);
        siHubiteiseiBean.setIrRenno9(null);
        siHubiteiseiBean.setIrRenno10(null);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyanm(null);
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd(null);
        bzSksKaisyasiyouranBean.setIrHozonkkn(null);

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("");
        siHubiteiseiBean.setIrSeikyuusyanmkj("");
        siHubiteiseiBean.setIrHubimsg1("");
        siHubiteiseiBean.setIrHubimsg2("");
        siHubiteiseiBean.setIrHubimsg3("");
        siHubiteiseiBean.setIrHubimsg4("");
        siHubiteiseiBean.setIrHubimsg5("");
        siHubiteiseiBean.setIrHubimsg6("");
        siHubiteiseiBean.setIrHubimsg7("");
        siHubiteiseiBean.setIrHubimsg8("");
        siHubiteiseiBean.setIrHubimsg9("");
        siHubiteiseiBean.setIrHubimsg10("");
        siHubiteiseiBean.setIrRenno1(null);
        siHubiteiseiBean.setIrRenno2(null);
        siHubiteiseiBean.setIrRenno3(null);
        siHubiteiseiBean.setIrRenno4(null);
        siHubiteiseiBean.setIrRenno5(null);
        siHubiteiseiBean.setIrRenno6(null);
        siHubiteiseiBean.setIrRenno7(null);
        siHubiteiseiBean.setIrRenno8(null);
        siHubiteiseiBean.setIrRenno9(null);
        siHubiteiseiBean.setIrRenno10(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("");
        bzSksKaisyasiyouranBean.setIrHozonkkn("");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("不備メッセージ１");
        siHubiteiseiBean.setIrHubimsg2("不備メッセージ２");
        siHubiteiseiBean.setIrHubimsg3("不備メッセージ３");
        siHubiteiseiBean.setIrHubimsg4("不備メッセージ４");
        siHubiteiseiBean.setIrHubimsg5("不備メッセージ５");
        siHubiteiseiBean.setIrHubimsg6("不備メッセージ６");
        siHubiteiseiBean.setIrHubimsg7("不備メッセージ７");
        siHubiteiseiBean.setIrHubimsg8("不備メッセージ８");
        siHubiteiseiBean.setIrHubimsg9("不備メッセージ９");
        siHubiteiseiBean.setIrHubimsg10("不備メッセージ１０");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(9);
        siHubiteiseiBean.setIrRenno10(10);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("wwwwwwwwwww");
        siHubiteiseiBean.setIrSeikyuusyanmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ" );
        siHubiteiseiBean.setIrHubimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ" );
        siHubiteiseiBean.setIrHubimsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ" );
        siHubiteiseiBean.setIrHubimsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ" );
        siHubiteiseiBean.setIrHubimsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ" );
        siHubiteiseiBean.setIrHubimsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ" );
        siHubiteiseiBean.setIrHubimsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ" );
        siHubiteiseiBean.setIrHubimsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ" );
        siHubiteiseiBean.setIrHubimsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ" );
        siHubiteiseiBean.setIrHubimsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ" );
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(9);
        siHubiteiseiBean.setIrRenno10(10);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("wwwwwwww");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("99年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("");
        siHubiteiseiBean.setIrHubimsg2("");
        siHubiteiseiBean.setIrHubimsg3("");
        siHubiteiseiBean.setIrHubimsg4("");
        siHubiteiseiBean.setIrHubimsg5("");
        siHubiteiseiBean.setIrHubimsg6("");
        siHubiteiseiBean.setIrHubimsg7("");
        siHubiteiseiBean.setIrHubimsg8("");
        siHubiteiseiBean.setIrHubimsg9("");
        siHubiteiseiBean.setIrHubimsg10("");
        siHubiteiseiBean.setIrRenno1(null);
        siHubiteiseiBean.setIrRenno2(null);
        siHubiteiseiBean.setIrRenno3(null);
        siHubiteiseiBean.setIrRenno4(null);
        siHubiteiseiBean.setIrRenno5(null);
        siHubiteiseiBean.setIrRenno6(null);
        siHubiteiseiBean.setIrRenno7(null);
        siHubiteiseiBean.setIrRenno8(null);
        siHubiteiseiBean.setIrRenno9(null);
        siHubiteiseiBean.setIrRenno10(null);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.NONE);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("不備メッセージ１");
        siHubiteiseiBean.setIrHubimsg2("不備メッセージ２");
        siHubiteiseiBean.setIrHubimsg3("不備メッセージ３");
        siHubiteiseiBean.setIrHubimsg4("不備メッセージ４");
        siHubiteiseiBean.setIrHubimsg5("");
        siHubiteiseiBean.setIrHubimsg6("");
        siHubiteiseiBean.setIrHubimsg7("");
        siHubiteiseiBean.setIrHubimsg8("");
        siHubiteiseiBean.setIrHubimsg9("");
        siHubiteiseiBean.setIrHubimsg10("");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(null);
        siHubiteiseiBean.setIrRenno6(null);
        siHubiteiseiBean.setIrRenno7(null);
        siHubiteiseiBean.setIrRenno8(null);
        siHubiteiseiBean.setIrRenno9(null);
        siHubiteiseiBean.setIrRenno10(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.NONE);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("不備メッセージ１");
        siHubiteiseiBean.setIrHubimsg2("不備メッセージ２");
        siHubiteiseiBean.setIrHubimsg3("不備メッセージ３");
        siHubiteiseiBean.setIrHubimsg4("不備メッセージ４");
        siHubiteiseiBean.setIrHubimsg5("不備メッセージ５");
        siHubiteiseiBean.setIrHubimsg6("");
        siHubiteiseiBean.setIrHubimsg7("");
        siHubiteiseiBean.setIrHubimsg8("");
        siHubiteiseiBean.setIrHubimsg9("");
        siHubiteiseiBean.setIrHubimsg10("");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(null);
        siHubiteiseiBean.setIrRenno7(null);
        siHubiteiseiBean.setIrRenno8(null);
        siHubiteiseiBean.setIrRenno9(null);
        siHubiteiseiBean.setIrRenno10(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.NONE);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.NONE);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("不備メッセージ１");
        siHubiteiseiBean.setIrHubimsg2("不備メッセージ２");
        siHubiteiseiBean.setIrHubimsg3("不備メッセージ３");
        siHubiteiseiBean.setIrHubimsg4("不備メッセージ４");
        siHubiteiseiBean.setIrHubimsg5("不備メッセージ５");
        siHubiteiseiBean.setIrHubimsg6("不備メッセージ６");
        siHubiteiseiBean.setIrHubimsg7("");
        siHubiteiseiBean.setIrHubimsg8("");
        siHubiteiseiBean.setIrHubimsg9("");
        siHubiteiseiBean.setIrHubimsg10("");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(null);
        siHubiteiseiBean.setIrRenno8(null);
        siHubiteiseiBean.setIrRenno9(null);
        siHubiteiseiBean.setIrRenno10(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("不備メッセージ１");
        siHubiteiseiBean.setIrHubimsg2("不備メッセージ２");
        siHubiteiseiBean.setIrHubimsg3("不備メッセージ３");
        siHubiteiseiBean.setIrHubimsg4("不備メッセージ４");
        siHubiteiseiBean.setIrHubimsg5("不備メッセージ５");
        siHubiteiseiBean.setIrHubimsg6("不備メッセージ６");
        siHubiteiseiBean.setIrHubimsg7("不備メッセージ７");
        siHubiteiseiBean.setIrHubimsg8("");
        siHubiteiseiBean.setIrHubimsg9("");
        siHubiteiseiBean.setIrHubimsg10("");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(null);
        siHubiteiseiBean.setIrRenno9(null);
        siHubiteiseiBean.setIrRenno10(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("不備メッセージ１");
        siHubiteiseiBean.setIrHubimsg2("不備メッセージ２");
        siHubiteiseiBean.setIrHubimsg3("不備メッセージ３");
        siHubiteiseiBean.setIrHubimsg4("不備メッセージ４");
        siHubiteiseiBean.setIrHubimsg5("不備メッセージ５");
        siHubiteiseiBean.setIrHubimsg6("不備メッセージ６");
        siHubiteiseiBean.setIrHubimsg7("不備メッセージ７");
        siHubiteiseiBean.setIrHubimsg8("不備メッセージ８");
        siHubiteiseiBean.setIrHubimsg9("");
        siHubiteiseiBean.setIrHubimsg10("");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(null);
        siHubiteiseiBean.setIrRenno10(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("不備メッセージ１");
        siHubiteiseiBean.setIrHubimsg2("不備メッセージ２");
        siHubiteiseiBean.setIrHubimsg3("不備メッセージ３");
        siHubiteiseiBean.setIrHubimsg4("不備メッセージ４");
        siHubiteiseiBean.setIrHubimsg5("不備メッセージ５");
        siHubiteiseiBean.setIrHubimsg6("不備メッセージ６");
        siHubiteiseiBean.setIrHubimsg7("不備メッセージ７");
        siHubiteiseiBean.setIrHubimsg8("不備メッセージ８");
        siHubiteiseiBean.setIrHubimsg9("不備メッセージ９");
        siHubiteiseiBean.setIrHubimsg10("");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(9);
        siHubiteiseiBean.setIrRenno10(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("不備メッセージ１");
        siHubiteiseiBean.setIrHubimsg2("不備メッセージ２");
        siHubiteiseiBean.setIrHubimsg3("不備メッセージ３");
        siHubiteiseiBean.setIrHubimsg4("不備メッセージ４");
        siHubiteiseiBean.setIrHubimsg5("不備メッセージ５");
        siHubiteiseiBean.setIrHubimsg6("不備メッセージ６");
        siHubiteiseiBean.setIrHubimsg7("不備メッセージ７");
        siHubiteiseiBean.setIrHubimsg8("不備メッセージ８");
        siHubiteiseiBean.setIrHubimsg9("不備メッセージ９");
        siHubiteiseiBean.setIrHubimsg10("不備メッセージ１０");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(9);
        siHubiteiseiBean.setIrRenno10(10);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(9);
        siHubiteiseiBean.setIrRenno10(10);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(9);
        siHubiteiseiBean.setIrRenno10(10);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(9);
        siHubiteiseiBean.setIrRenno10(10);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(9);
        siHubiteiseiBean.setIrRenno10(10);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(9);
        siHubiteiseiBean.setIrRenno10(10);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(9);
        siHubiteiseiBean.setIrRenno10(10);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(9);
        siHubiteiseiBean.setIrRenno10(10);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(9);
        siHubiteiseiBean.setIrRenno10(10);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testCreateReport21() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(9);
        siHubiteiseiBean.setIrRenno10(10);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testCreateReport22() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(9);
        siHubiteiseiBean.setIrRenno10(10);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testCreateReport23() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(9);
        siHubiteiseiBean.setIrRenno10(10);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testCreateReport24() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(9);
        siHubiteiseiBean.setIrRenno10(10);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testCreateReport25() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(9);
        siHubiteiseiBean.setIrRenno10(10);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testCreateReport26() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(9);
        siHubiteiseiBean.setIrRenno10(10);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testCreateReport27() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrHubimsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(9);
        siHubiteiseiBean.setIrRenno10(10);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testCreateReport28() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("不\n備\nメ\nッ\nセ\nージ１");
        siHubiteiseiBean.setIrHubimsg2("不\n備\nメ\nッ\nセ\nージ２");
        siHubiteiseiBean.setIrHubimsg3("不\n備\nメ\nッ\nセ\nージ３");
        siHubiteiseiBean.setIrHubimsg4("不\n備\nメ\nッ\nセ\nージ４");
        siHubiteiseiBean.setIrHubimsg5("不\n備\nメ\nッ\nセ\nージ５");
        siHubiteiseiBean.setIrHubimsg6("不\n備\nメ\nッ\nセ\nージ６");
        siHubiteiseiBean.setIrHubimsg7("不\n備\nメ\nッ\nセ\nージ７");
        siHubiteiseiBean.setIrHubimsg8("不\n備\nメ\nッ\nセ\nージ８");
        siHubiteiseiBean.setIrHubimsg9("不\n備\nメ\nッ\nセ\nージ９");
        siHubiteiseiBean.setIrHubimsg10("不\n備\nメ\nッ\nセ\nージ０");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(7);
        siHubiteiseiBean.setIrRenno8(8);
        siHubiteiseiBean.setIrRenno9(9);
        siHubiteiseiBean.setIrRenno10(10);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(290)
    @Transactional
    public void testCreateReport29() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiHubiTeiseiTest", C_SyoruiCdKbn.HK_SB_HUBITEISEI);

        siHubiteiseiBean.setIrSyono("10000000001");
        siHubiteiseiBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siHubiteiseiBean.setIrHubimsg1("不備メッセージ１");
        siHubiteiseiBean.setIrHubimsg2("不備メッセージ２");
        siHubiteiseiBean.setIrHubimsg3("不備メッセージ３");
        siHubiteiseiBean.setIrHubimsg4("不備メッセージ４");
        siHubiteiseiBean.setIrHubimsg5("不備メッセージ５");
        siHubiteiseiBean.setIrHubimsg6("不備メッセージ６");
        siHubiteiseiBean.setIrHubimsg7("");
        siHubiteiseiBean.setIrHubimsg8("");
        siHubiteiseiBean.setIrHubimsg9("");
        siHubiteiseiBean.setIrHubimsg10("");
        siHubiteiseiBean.setIrRenno1(1);
        siHubiteiseiBean.setIrRenno2(2);
        siHubiteiseiBean.setIrRenno3(3);
        siHubiteiseiBean.setIrRenno4(4);
        siHubiteiseiBean.setIrRenno5(5);
        siHubiteiseiBean.setIrRenno6(6);
        siHubiteiseiBean.setIrRenno7(null);
        siHubiteiseiBean.setIrRenno8(null);
        siHubiteiseiBean.setIrRenno9(null);
        siHubiteiseiBean.setIrRenno10(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成28年12月 2日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15 年");

        siHubiteiseiBean.setIrPageinfohyoujiumu(C_UmuKbn.NONE);
        siHubiteiseiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);
        siHubiteiseiBean.setIrGenponhnkykumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siHubiteiseiBean,bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
