package yuyu.report.sinkeiyaku;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SkTtdkkanryouTuutiBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 手続完了通知（顧客宛）クラス
 */
@RunWith(OrderedRunner.class)
public class SkTtdkkrTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkTtdkkanryouTuutiBean skTtdkkanryouTuutiBean;

    @Inject
    private BzKokyakuAtesakiBean bzKokyakuAtesakiBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTtdkkr", C_SyoruiCdKbn.SK_TTDKKR);

        skTtdkkanryouTuutiBean.setIrHknsyurui("");
        skTtdkkanryouTuutiBean.setIrAisyoumei("");
        skTtdkkanryouTuutiBean.setIrKetkekkacd(C_Ketkekkacd.BLNK);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("");
        bzKokyakuAtesakiBean.setIrShsyno("");
        bzKokyakuAtesakiBean.setIrShadr1kj("");
        bzKokyakuAtesakiBean.setIrShadr2kj("");
        bzKokyakuAtesakiBean.setIrShadr3kj("");
        bzKokyakuAtesakiBean.setIrShsnmkj("");
        bzKokyakuAtesakiBean.setIrToiawaseyno("");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("");
        bzKokyakuAtesakiBean.setIrHknkisynm("");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("");
        bzKokyakuAtesakiBean.setIrToiawasetelno("");

        reportTestBean.addParamObjects(skTtdkkanryouTuutiBean, bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTtdkkr", C_SyoruiCdKbn.SK_TTDKKR);

        skTtdkkanryouTuutiBean.setIrHknsyurui(null);
        skTtdkkanryouTuutiBean.setIrAisyoumei(null);
        skTtdkkanryouTuutiBean.setIrKetkekkacd(C_Ketkekkacd.BLNK);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(null);
        bzKokyakuAtesakiBean.setIrShsyno(null);
        bzKokyakuAtesakiBean.setIrShadr1kj(null);
        bzKokyakuAtesakiBean.setIrShadr2kj(null);
        bzKokyakuAtesakiBean.setIrShadr3kj(null);
        bzKokyakuAtesakiBean.setIrShsnmkj(null);
        bzKokyakuAtesakiBean.setIrToiawaseyno(null);
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj(null);
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj(null);
        bzKokyakuAtesakiBean.setIrHknkisynm(null);
        bzKokyakuAtesakiBean.setIrToiawasesosiki(null);
        bzKokyakuAtesakiBean.setIrToiawasetantounm(null);
        bzKokyakuAtesakiBean.setIrToiawasetelno(null);

        reportTestBean.addParamObjects(skTtdkkanryouTuutiBean, bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTtdkkr", C_SyoruiCdKbn.SK_TTDKKR);

        skTtdkkanryouTuutiBean.setIrHknsyurui("低解約返戻金型無配当特別終身保険");
        skTtdkkanryouTuutiBean.setIrAisyoumei("「ふるはーと外貨」");
        skTtdkkanryouTuutiBean.setIrKetkekkacd(C_Ketkekkacd.MOS_TORIKESI);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2018年 7月10日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("送付先住所１");
        bzKokyakuAtesakiBean.setIrShadr2kj("送付先住所２");
        bzKokyakuAtesakiBean.setIrShadr3kj("送付先住所３");
        bzKokyakuAtesakiBean.setIrShsnmkj("送付先氏名");
        bzKokyakuAtesakiBean.setIrToiawaseyno("295-0000");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２");
        bzKokyakuAtesakiBean.setIrHknkisynm("保険会社名");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("新契約チーム");
        bzKokyakuAtesakiBean.setIrToiawasetelno("06-6937-1136");

        reportTestBean.addParamObjects(skTtdkkanryouTuutiBean, bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTtdkkr", C_SyoruiCdKbn.SK_TTDKKR);

        skTtdkkanryouTuutiBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skTtdkkanryouTuutiBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skTtdkkanryouTuutiBean.setIrKetkekkacd(C_Ketkekkacd.COOLINGOFF);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");

        reportTestBean.addParamObjects(skTtdkkanryouTuutiBean, bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkTtdkkr", C_SyoruiCdKbn.SK_TTDKKR);

        skTtdkkanryouTuutiBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skTtdkkanryouTuutiBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skTtdkkanryouTuutiBean.setIrKetkekkacd(C_Ketkekkacd.MIAWASE);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");

        reportTestBean.addParamObjects(skTtdkkanryouTuutiBean, bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}