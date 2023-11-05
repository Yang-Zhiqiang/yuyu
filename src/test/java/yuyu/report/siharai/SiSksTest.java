package yuyu.report.siharai;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.siharai.bean.report.SiSksBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 請求書 テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SiSksTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SiSksBean siSksBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SiSksTest",
                C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        siSksBean.setIrTyouhyoutitle("");
        siSksBean.setIrSyono("");
        siSksBean.setIrTsinyno("");
        siSksBean.setIrTsintelno("");
        siSksBean.setIrTsinadr1kj("");
        siSksBean.setIrTsinadr2kj("");
        siSksBean.setIrTsinadr3kj("");
        siSksBean.setIrMsg1("");
        siSksBean.setIrMsg2("");
        siSksBean.setIrMsg3("");
        siSksBean.setIrMsg4("");
        siSksBean.setIrToritsugisyasyozokunm("");
        siSksBean.setIrToritsugisyakjncd("");
        siSksBean.setIrToritsugisyanm("");
        siSksBean.setIrTyouhyousakuseiymd("");
        siSksBean.setIrHozonkkn("");
        siSksBean.setIrShsrtdkdadrhyjumu(C_UmuKbn.ARI);
        siSksBean.setIrShsrkinyuuhyjumu(C_UmuKbn.NONE);
        siSksBean.setIrUkthougkdthyjumu(C_UmuKbn.ARI);
        siSksBean.setIrUkthouendthyjumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(siSksBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SiSksTest",
                C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        siSksBean.setIrTyouhyoutitle(null);
        siSksBean.setIrSyono(null);
        siSksBean.setIrTsinyno(null);
        siSksBean.setIrTsintelno(null);
        siSksBean.setIrTsinadr1kj(null);
        siSksBean.setIrTsinadr2kj(null);
        siSksBean.setIrTsinadr3kj(null);
        siSksBean.setIrMsg1(null);
        siSksBean.setIrMsg2(null);
        siSksBean.setIrMsg3(null);
        siSksBean.setIrMsg4(null);
        siSksBean.setIrToritsugisyasyozokunm(null);
        siSksBean.setIrToritsugisyakjncd(null);
        siSksBean.setIrToritsugisyanm(null);
        siSksBean.setIrTyouhyousakuseiymd(null);
        siSksBean.setIrHozonkkn(null);
        siSksBean.setIrShsrtdkdadrhyjumu(C_UmuKbn.ARI);
        siSksBean.setIrShsrkinyuuhyjumu(C_UmuKbn.NONE);
        siSksBean.setIrUkthougkdthyjumu(C_UmuKbn.ARI);
        siSksBean.setIrUkthouendthyjumu(C_UmuKbn.NONE);
        reportTestBean.addParamObjects(siSksBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SiSksTest",
                C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        siSksBean.setIrTyouhyoutitle("死亡保険金（給付金）請求書【住友生命提出用】");
        siSksBean.setIrSyono("11807111118");
        siSksBean.setIrTsinyno("1950000");
        siSksBean.setIrTsintelno("1206-6937-1136");
        siSksBean.setIrTsinadr1kj("大阪市中央区");
        siSksBean.setIrTsinadr2kj("新栄町１－４－３４");
        siSksBean.setIrTsinadr3kj("ＡＢＣマンション");
        siSksBean.setIrMsg1("死亡保険金（給付金）を請求します。");
        siSksBean.setIrMsg2("高度障害保険金を請求します。");
        siSksBean.setIrMsg3("全額一時金でのお支払となります。");
        siSksBean.setIrMsg4("その他保険に関連・付随する業務");
        siSksBean.setIrToritsugisyasyozokunm("取次者所属名");
        siSksBean.setIrToritsugisyakjncd("12345678");
        siSksBean.setIrToritsugisyanm("取次者氏名");
        siSksBean.setIrTyouhyousakuseiymd("2018年 3月 3日");
        siSksBean.setIrHozonkkn("5 年");
        siSksBean.setIrShsrtdkdadrhyjumu(C_UmuKbn.ARI);
        siSksBean.setIrShsrkinyuuhyjumu(C_UmuKbn.NONE);
        siSksBean.setIrUkthougkdthyjumu(C_UmuKbn.ARI);
        siSksBean.setIrUkthouendthyjumu(C_UmuKbn.NONE);
        reportTestBean.addParamObjects(siSksBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }


    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SiSksTest",
                C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        siSksBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrSyono("wwwwwwwwwww");
        siSksBean.setIrTsinyno("wwwwwww");
        siSksBean.setIrTsintelno("wwwwwwwwwwwwww");
        siSksBean.setIrTsinadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrTsinadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrTsinadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrMsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrMsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrToritsugisyakjncd("wwwwwwww");
        siSksBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrTyouhyousakuseiymd("9999年99月99日");
        siSksBean.setIrHozonkkn("99 年");

        siSksBean.setIrShsrtdkdadrhyjumu(C_UmuKbn.ARI);
        siSksBean.setIrShsrkinyuuhyjumu(C_UmuKbn.NONE);
        siSksBean.setIrUkthougkdthyjumu(C_UmuKbn.ARI);
        siSksBean.setIrUkthouendthyjumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(siSksBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }
    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SiSksTest",
                C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        siSksBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrSyono("wwwwwwwwwww");
        siSksBean.setIrTsinyno("wwwwwww");
        siSksBean.setIrTsintelno("wwwwwwwwwwwwww");
        siSksBean.setIrTsinadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrTsinadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrTsinadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrMsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrMsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrToritsugisyakjncd("wwwwwwww");
        siSksBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrTyouhyousakuseiymd("9999年99月99日");
        siSksBean.setIrHozonkkn("99 年");
        siSksBean.setIrShsrtdkdadrhyjumu(C_UmuKbn.NONE);
        siSksBean.setIrShsrkinyuuhyjumu(C_UmuKbn.ARI);
        siSksBean.setIrUkthougkdthyjumu(C_UmuKbn.NONE);
        siSksBean.setIrUkthouendthyjumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siSksBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }
    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SiSksTest",
                C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        siSksBean.setIrTyouhyoutitle("死亡保険金（給付金）請求書【住友生命提出用】");
        siSksBean.setIrSyono("wwwwwwwwwww");
        siSksBean.setIrTsinyno("wwwwwww");
        siSksBean.setIrTsintelno("wwwwwwwwwwwwww");
        siSksBean.setIrTsinadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrTsinadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrTsinadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrMsg1("死亡保険金を請求します。");
        siSksBean.setIrMsg2("");
        siSksBean.setIrMsg3("");
        siSksBean.setIrMsg4("");
        siSksBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrToritsugisyakjncd("wwwwwwww");
        siSksBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSksBean.setIrTyouhyousakuseiymd("9999年99月99日");
        siSksBean.setIrHozonkkn("99 年");

        siSksBean.setIrShsrtdkdadrhyjumu(C_UmuKbn.NONE);
        siSksBean.setIrShsrkinyuuhyjumu(C_UmuKbn.NONE);
        siSksBean.setIrUkthougkdthyjumu(C_UmuKbn.NONE);
        siSksBean.setIrUkthouendthyjumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(siSksBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SiSksTest",
                C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        siSksBean.setIrTyouhyoutitle("");
        siSksBean.setIrSyono("");
        siSksBean.setIrTsinyno("");
        siSksBean.setIrTsintelno("");
        siSksBean.setIrTsinadr1kj("");
        siSksBean.setIrTsinadr2kj("");
        siSksBean.setIrTsinadr3kj("");
        siSksBean.setIrMsg1("");
        siSksBean.setIrMsg2("");
        siSksBean.setIrMsg3("");
        siSksBean.setIrMsg4("");
        siSksBean.setIrToritsugisyasyozokunm("");
        siSksBean.setIrToritsugisyakjncd("");
        siSksBean.setIrToritsugisyanm("");
        siSksBean.setIrTyouhyousakuseiymd("");
        siSksBean.setIrHozonkkn("");
        siSksBean.setIrShsrtdkdadrhyjumu(C_UmuKbn.NONE);
        siSksBean.setIrShsrkinyuuhyjumu(C_UmuKbn.ARI);
        siSksBean.setIrUkthougkdthyjumu(C_UmuKbn.NONE);
        siSksBean.setIrUkthouendthyjumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siSksBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SiSksTest",
                C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        siSksBean.setIrTyouhyoutitle(null);
        siSksBean.setIrSyono(null);
        siSksBean.setIrTsinyno(null);
        siSksBean.setIrTsintelno(null);
        siSksBean.setIrTsinadr1kj(null);
        siSksBean.setIrTsinadr2kj(null);
        siSksBean.setIrTsinadr3kj(null);
        siSksBean.setIrMsg1(null);
        siSksBean.setIrMsg2(null);
        siSksBean.setIrMsg3(null);
        siSksBean.setIrMsg4(null);
        siSksBean.setIrToritsugisyasyozokunm(null);
        siSksBean.setIrToritsugisyakjncd(null);
        siSksBean.setIrToritsugisyanm(null);
        siSksBean.setIrTyouhyousakuseiymd(null);
        siSksBean.setIrHozonkkn(null);
        siSksBean.setIrShsrtdkdadrhyjumu(C_UmuKbn.NONE);
        siSksBean.setIrShsrkinyuuhyjumu(C_UmuKbn.ARI);
        siSksBean.setIrUkthougkdthyjumu(C_UmuKbn.NONE);
        siSksBean.setIrUkthouendthyjumu(C_UmuKbn.ARI);
        reportTestBean.addParamObjects(siSksBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SiSksTest",
                C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        siSksBean.setIrTyouhyoutitle("死亡保険金（給付金）請求書【住友生命提出用】");
        siSksBean.setIrSyono("11807111118");
        siSksBean.setIrTsinyno("1950000");
        siSksBean.setIrTsintelno("1206-6937-1136");
        siSksBean.setIrTsinadr1kj("大阪市中央区");
        siSksBean.setIrTsinadr2kj("新栄町１－４－３４");
        siSksBean.setIrTsinadr3kj("ＡＢＣマンション");
        siSksBean.setIrMsg1("死亡保険金（給付金）を請求します。");
        siSksBean.setIrMsg2("高度障害保険金を請求します。");
        siSksBean.setIrMsg3("全額一時金でのお支払となります。");
        siSksBean.setIrMsg4("その他保険に関連・付随する業務");
        siSksBean.setIrToritsugisyasyozokunm("取次者所属名");
        siSksBean.setIrToritsugisyakjncd("12345678");
        siSksBean.setIrToritsugisyanm("取次者氏名");
        siSksBean.setIrTyouhyousakuseiymd("2018年 3月 3日");
        siSksBean.setIrHozonkkn("5 年");
        siSksBean.setIrShsrtdkdadrhyjumu(C_UmuKbn.NONE);
        siSksBean.setIrShsrkinyuuhyjumu(C_UmuKbn.ARI);
        siSksBean.setIrUkthougkdthyjumu(C_UmuKbn.NONE);
        siSksBean.setIrUkthouendthyjumu(C_UmuKbn.ARI);
        reportTestBean.addParamObjects(siSksBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void createSample1() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SiSksTest",
                C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        siSksBean.setIrTyouhyoutitle("死亡保険金（給付金）請求書【住友生命提出用】");
        siSksBean.setIrSyono("");
        siSksBean.setIrTsinyno("");
        siSksBean.setIrTsintelno("");
        siSksBean.setIrTsinadr1kj("");
        siSksBean.setIrTsinadr2kj("");
        siSksBean.setIrTsinadr3kj("");
        siSksBean.setIrMsg1("死亡保険金（給付金）を請求します。");
        siSksBean.setIrMsg2("");
        siSksBean.setIrMsg3("");
        siSksBean.setIrMsg4("");
        siSksBean.setIrToritsugisyasyozokunm("");
        siSksBean.setIrToritsugisyakjncd("");
        siSksBean.setIrToritsugisyanm("");
        siSksBean.setIrTyouhyousakuseiymd("");
        siSksBean.setIrHozonkkn("");
        siSksBean.setIrShsrtdkdadrhyjumu(C_UmuKbn.NONE);
        siSksBean.setIrShsrkinyuuhyjumu(C_UmuKbn.ARI);
        siSksBean.setIrUkthougkdthyjumu(C_UmuKbn.ARI);
        siSksBean.setIrUkthouendthyjumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(siSksBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }


    @Test
    @TestOrder(110)
    @Transactional

    public void createSample2() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SiSksTest",
                C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        siSksBean.setIrTyouhyoutitle("死亡保険金（給付金）請求書【住友生命提出用】");
        siSksBean.setIrSyono("");
        siSksBean.setIrTsinyno("");
        siSksBean.setIrTsintelno("");
        siSksBean.setIrTsinadr1kj("");
        siSksBean.setIrTsinadr2kj("");
        siSksBean.setIrTsinadr3kj("");
        siSksBean.setIrMsg1("死亡保険金（給付金）を請求します。");
        siSksBean.setIrMsg2("");
        siSksBean.setIrMsg3("");
        siSksBean.setIrMsg4("");
        siSksBean.setIrToritsugisyasyozokunm("");
        siSksBean.setIrToritsugisyakjncd("");
        siSksBean.setIrToritsugisyanm("");
        siSksBean.setIrTyouhyousakuseiymd("");
        siSksBean.setIrHozonkkn("");
        siSksBean.setIrShsrtdkdadrhyjumu(C_UmuKbn.NONE);
        siSksBean.setIrShsrkinyuuhyjumu(C_UmuKbn.ARI);
        siSksBean.setIrUkthougkdthyjumu(C_UmuKbn.NONE);
        siSksBean.setIrUkthouendthyjumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siSksBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

}
