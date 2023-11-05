package yuyu.report.siharai;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.siharai.bean.report.SiEditKakuniniraisyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 確認依頼書テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SiKakuniniRaiSyoTest extends AbstractTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private  SiEditKakuniniraisyoBean siEditKakuniniraisyoBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiKakuniniRaiSyoTest", C_SyoruiCdKbn.HK_SB_KAKUNINIRAIS);

        siEditKakuniniraisyoBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditKakuniniraisyoBean.setIrIraisyohyojitelno("wwwwwwwwwwwwww");
        siEditKakuniniraisyoBean.setIrSyono("wwwwwwwwwww");
        siEditKakuniniraisyoBean.setIrKykymd("ＷＷ99年99月99日");
        siEditKakuniniraisyoBean.setIrSbymdkoteiymd("ＷＷ99年99月99日");
        siEditKakuniniraisyoBean.setIrSyoruiukeymd("ＷＷ99年99月99日");
        siEditKakuniniraisyoBean.setIrSikkouymd("ＷＷ99年99月99日");
        siEditKakuniniraisyoBean.setIrHksknnkaisiymd("ＷＷ99年99月99日");
        siEditKakuniniraisyoBean.setIrLastmeihenymd("ＷＷ99年99月99日");
        siEditKakuniniraisyoBean.setIrHhknnmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditKakuniniraisyoBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditKakuniniraisyoBean.setIrSeikyuusyanmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditKakuniniraisyoBean.setIrSeikyuusyanmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditKakuniniraisyoBean.setIrKyknmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditKakuniniraisyoBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditKakuniniraisyoBean.setIrHkgk("99,999,999,999");
        siEditKakuniniraisyoBean.setIrTsinyno("9999999");
        siEditKakuniniraisyoBean.setIrTsintelno("wwwwwwwwwwwwww");
        siEditKakuniniraisyoBean.setIrTsinadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditKakuniniraisyoBean.setIrTsinadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditKakuniniraisyoBean.setIrTsinadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siEditKakuniniraisyoBean.setIrSyustani("ＷＷＷ");
        siEditKakuniniraisyoBean.setIrSaigais("99,999,999,999");
        siEditKakuniniraisyoBean.setIrSaigaistani("ＷＷＷ");
        siEditKakuniniraisyoBean.setIrHozonkkn("99ＷＷ");

        reportTestBean.addParamObjects(siEditKakuniniraisyoBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiKakuniniRaiSyoTest", C_SyoruiCdKbn.HK_SB_KAKUNINIRAIS);

        siEditKakuniniraisyoBean.setIrTyouhyoutitle("死亡　保険金確認依頼書");
        siEditKakuniniraisyoBean.setIrIraisyohyojitelno("12345678901234");
        siEditKakuniniraisyoBean.setIrSyono("10000000001");
        siEditKakuniniraisyoBean.setIrKykymd("平成28年1月2日");
        siEditKakuniniraisyoBean.setIrSbymdkoteiymd("平成31年12月18日");
        siEditKakuniniraisyoBean.setIrSyoruiukeymd("平成21年9月23日");
        siEditKakuniniraisyoBean.setIrSikkouymd("平成22年9月23日");
        siEditKakuniniraisyoBean.setIrHksknnkaisiymd("平成23年9月23日");
        siEditKakuniniraisyoBean.setIrLastmeihenymd("平成24年9月23日");
        siEditKakuniniraisyoBean.setIrHhknnmkn("カナ");
        siEditKakuniniraisyoBean.setIrHhknnmkj("被保険者名（漢字）");
        siEditKakuniniraisyoBean.setIrSeikyuusyanmkn("カナカナ");
        siEditKakuniniraisyoBean.setIrSeikyuusyanmkj("請求者（漢字）");
        siEditKakuniniraisyoBean.setIrKyknmkn("カナカナカナ");
        siEditKakuniniraisyoBean.setIrKyknmkj("契約者名（漢字）");
        siEditKakuniniraisyoBean.setIrHkgk("12,345,678");
        siEditKakuniniraisyoBean.setIrTsinyno("1234567");
        siEditKakuniniraisyoBean.setIrTsintelno("43210987654321");
        siEditKakuniniraisyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        siEditKakuniniraisyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        siEditKakuniniraisyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        siEditKakuniniraisyoBean.setIrSyustani("円");
        siEditKakuniniraisyoBean.setIrSaigais("12,345,123");
        siEditKakuniniraisyoBean.setIrSaigaistani("円");
        siEditKakuniniraisyoBean.setIrHozonkkn("3か月");

        reportTestBean.addParamObjects(siEditKakuniniraisyoBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiKakuniniRaiSyoTest", C_SyoruiCdKbn.HK_SB_KAKUNINIRAIS);

        siEditKakuniniraisyoBean.setIrTyouhyoutitle(null);
        siEditKakuniniraisyoBean.setIrIraisyohyojitelno(null);
        siEditKakuniniraisyoBean.setIrSyono(null);
        siEditKakuniniraisyoBean.setIrKykymd(null);
        siEditKakuniniraisyoBean.setIrSbymdkoteiymd(null);
        siEditKakuniniraisyoBean.setIrSyoruiukeymd(null);
        siEditKakuniniraisyoBean.setIrSikkouymd(null);
        siEditKakuniniraisyoBean.setIrHksknnkaisiymd(null);
        siEditKakuniniraisyoBean.setIrLastmeihenymd(null);
        siEditKakuniniraisyoBean.setIrHhknnmkn(null);
        siEditKakuniniraisyoBean.setIrHhknnmkj(null);
        siEditKakuniniraisyoBean.setIrSeikyuusyanmkn(null);
        siEditKakuniniraisyoBean.setIrSeikyuusyanmkj(null);
        siEditKakuniniraisyoBean.setIrKyknmkn(null);
        siEditKakuniniraisyoBean.setIrKyknmkj(null);
        siEditKakuniniraisyoBean.setIrHkgk(null);
        siEditKakuniniraisyoBean.setIrTsinyno(null);
        siEditKakuniniraisyoBean.setIrTsintelno(null);
        siEditKakuniniraisyoBean.setIrTsinadr1kj(null);
        siEditKakuniniraisyoBean.setIrTsinadr2kj(null);
        siEditKakuniniraisyoBean.setIrTsinadr3kj(null);
        siEditKakuniniraisyoBean.setIrSyustani(null);
        siEditKakuniniraisyoBean.setIrSaigais(null);
        siEditKakuniniraisyoBean.setIrSaigaistani(null);
        siEditKakuniniraisyoBean.setIrHozonkkn(null);

        reportTestBean.addParamObjects(siEditKakuniniraisyoBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiKakuniniRaiSyoTest", C_SyoruiCdKbn.HK_SB_KAKUNINIRAIS);

        siEditKakuniniraisyoBean.setIrTyouhyoutitle("");
        siEditKakuniniraisyoBean.setIrIraisyohyojitelno("");
        siEditKakuniniraisyoBean.setIrSyono("");
        siEditKakuniniraisyoBean.setIrKykymd("");
        siEditKakuniniraisyoBean.setIrSbymdkoteiymd("");
        siEditKakuniniraisyoBean.setIrSyoruiukeymd("");
        siEditKakuniniraisyoBean.setIrSikkouymd("");
        siEditKakuniniraisyoBean.setIrHksknnkaisiymd("");
        siEditKakuniniraisyoBean.setIrLastmeihenymd("");
        siEditKakuniniraisyoBean.setIrHhknnmkn("");
        siEditKakuniniraisyoBean.setIrHhknnmkj("");
        siEditKakuniniraisyoBean.setIrSeikyuusyanmkn("");
        siEditKakuniniraisyoBean.setIrSeikyuusyanmkj("");
        siEditKakuniniraisyoBean.setIrKyknmkn("");
        siEditKakuniniraisyoBean.setIrKyknmkj("");
        siEditKakuniniraisyoBean.setIrHkgk("");
        siEditKakuniniraisyoBean.setIrTsinyno("");
        siEditKakuniniraisyoBean.setIrTsintelno("");
        siEditKakuniniraisyoBean.setIrTsinadr1kj("");
        siEditKakuniniraisyoBean.setIrTsinadr2kj("");
        siEditKakuniniraisyoBean.setIrTsinadr3kj("");
        siEditKakuniniraisyoBean.setIrSyustani("");
        siEditKakuniniraisyoBean.setIrSaigais("");
        siEditKakuniniraisyoBean.setIrSaigaistani("");
        siEditKakuniniraisyoBean.setIrHozonkkn("");

        reportTestBean.addParamObjects(siEditKakuniniraisyoBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
