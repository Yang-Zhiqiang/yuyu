package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.hozen.bean.report.KhPHrkkaisuuHenkouMosBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生命保険料払込回数変更申込書 用クラス
 */
@RunWith(OrderedRunner.class)
public class KhPhrkkaisuuhenkoumosTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhPHrkkaisuuHenkouMosBean khPHrkkaisuuHenkouMosBean;


    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPhrkkaisuuhenkoumosTest", C_SyoruiCdKbn.KK_HRIKAIHEN_SKS);

        khPHrkkaisuuHenkouMosBean.setIrSyono("");
        khPHrkkaisuuHenkouMosBean.setIrHrkkaisuu(null);
        khPHrkkaisuuHenkouMosBean.setIrTikiktbrisyuruikbn(null);

        khPHrkkaisuuHenkouMosBean.setIrToritsugisyasyozokunm("");
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyakjncd("");
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyanm("");
        khPHrkkaisuuHenkouMosBean.setIrTyouhyousakuseiymd("");
        khPHrkkaisuuHenkouMosBean.setIrHozonkkn("");
        reportTestBean.addParamObjects(khPHrkkaisuuHenkouMosBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPhrkkaisuuhenkoumosTest", C_SyoruiCdKbn.KK_HRIKAIHEN_SKS);

        khPHrkkaisuuHenkouMosBean.setIrSyono(null);
        khPHrkkaisuuHenkouMosBean.setIrHrkkaisuu(null);
        khPHrkkaisuuHenkouMosBean.setIrTikiktbrisyuruikbn(null);

        khPHrkkaisuuHenkouMosBean.setIrToritsugisyasyozokunm(null);
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyakjncd(null);
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyanm(null);
        khPHrkkaisuuHenkouMosBean.setIrTyouhyousakuseiymd(null);
        khPHrkkaisuuHenkouMosBean.setIrHozonkkn(null);

        reportTestBean.addParamObjects(khPHrkkaisuuHenkouMosBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPhrkkaisuuhenkoumosTest", C_SyoruiCdKbn.KK_HRIKAIHEN_SKS);

        khPHrkkaisuuHenkouMosBean.setIrSyono("12345678901");
        khPHrkkaisuuHenkouMosBean.setIrHrkkaisuu(C_Hrkkaisuu.TUKI);
        khPHrkkaisuuHenkouMosBean.setIrTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyasyozokunm("取次者所属名");
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyakjncd("12345678");
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyanm("取次者氏名");
        khPHrkkaisuuHenkouMosBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        khPHrkkaisuuHenkouMosBean.setIrHozonkkn("3年");
        reportTestBean.addParamObjects(khPHrkkaisuuHenkouMosBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPhrkkaisuuhenkoumosTest", C_SyoruiCdKbn.KK_HRIKAIHEN_SKS);

        khPHrkkaisuuHenkouMosBean.setIrSyono("wwwwwwwwwww");
        khPHrkkaisuuHenkouMosBean.setIrHrkkaisuu(C_Hrkkaisuu.HALFY);
        khPHrkkaisuuHenkouMosBean.setIrTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyakjncd("wwwwwwww");
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khPHrkkaisuuHenkouMosBean.setIrTyouhyousakuseiymd("9999年99月99日");
        khPHrkkaisuuHenkouMosBean.setIrHozonkkn("99年");

        reportTestBean.addParamObjects(khPHrkkaisuuHenkouMosBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPhrkkaisuuhenkoumosTest", C_SyoruiCdKbn.KK_HRIKAIHEN_SKS);

        khPHrkkaisuuHenkouMosBean.setIrSyono("12345678901");
        khPHrkkaisuuHenkouMosBean.setIrHrkkaisuu(C_Hrkkaisuu.NEN);
        khPHrkkaisuuHenkouMosBean.setIrTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyasyozokunm("取次者所属名");
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyakjncd("12345678");
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyanm("取次者氏名");
        khPHrkkaisuuHenkouMosBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        khPHrkkaisuuHenkouMosBean.setIrHozonkkn("15年");

        reportTestBean.addParamObjects(khPHrkkaisuuHenkouMosBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPhrkkaisuuhenkoumosTest", C_SyoruiCdKbn.KK_HRIKAIHEN_SKS);

        khPHrkkaisuuHenkouMosBean.setIrSyono("12345678901");
        khPHrkkaisuuHenkouMosBean.setIrHrkkaisuu(C_Hrkkaisuu.BLNK);
        khPHrkkaisuuHenkouMosBean.setIrTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);

        khPHrkkaisuuHenkouMosBean.setIrToritsugisyasyozokunm("取次者所属名");
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyakjncd("12345678");
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyanm("取次者氏名");
        khPHrkkaisuuHenkouMosBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        khPHrkkaisuuHenkouMosBean.setIrHozonkkn("15年");

        reportTestBean.addParamObjects(khPHrkkaisuuHenkouMosBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPhrkkaisuuhenkoumosTest", C_SyoruiCdKbn.KK_HRIKAIHEN_SKS);

        khPHrkkaisuuHenkouMosBean.setIrSyono("12345678901");
        khPHrkkaisuuHenkouMosBean.setIrHrkkaisuu(C_Hrkkaisuu.BLNK);
        khPHrkkaisuuHenkouMosBean.setIrTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.NONE);

        khPHrkkaisuuHenkouMosBean.setIrToritsugisyasyozokunm("取次者所属名");
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyakjncd("12345678");
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyanm("取次者氏名");
        khPHrkkaisuuHenkouMosBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        khPHrkkaisuuHenkouMosBean.setIrHozonkkn("3年");
        reportTestBean.addParamObjects(khPHrkkaisuuHenkouMosBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPhrkkaisuuhenkoumosTest", C_SyoruiCdKbn.KK_HRIKAIHEN_SKS);

        khPHrkkaisuuHenkouMosBean.setIrSyono("wwwwwwwwwww");
        khPHrkkaisuuHenkouMosBean.setIrHrkkaisuu(C_Hrkkaisuu.BLNK);
        khPHrkkaisuuHenkouMosBean.setIrTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        khPHrkkaisuuHenkouMosBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyakjncd("wwwwwwww");
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khPHrkkaisuuHenkouMosBean.setIrTyouhyousakuseiymd("9999年99月99日");
        khPHrkkaisuuHenkouMosBean.setIrHozonkkn("99年");

        reportTestBean.addParamObjects(khPHrkkaisuuHenkouMosBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPhrkkaisuuhenkoumosTest", C_SyoruiCdKbn.KK_HRIKAIHEN_SKS);

        khPHrkkaisuuHenkouMosBean.setIrSyono("12345678901");
        khPHrkkaisuuHenkouMosBean.setIrHrkkaisuu(C_Hrkkaisuu.BLNK);
        khPHrkkaisuuHenkouMosBean.setIrTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        khPHrkkaisuuHenkouMosBean.setIrToritsugisyasyozokunm("取次者所属名");
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyakjncd("12345678");
        khPHrkkaisuuHenkouMosBean.setIrToritsugisyanm("取次者氏名");
        khPHrkkaisuuHenkouMosBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        khPHrkkaisuuHenkouMosBean.setIrHozonkkn("15年");
        reportTestBean.addParamObjects(khPHrkkaisuuHenkouMosBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }



}
