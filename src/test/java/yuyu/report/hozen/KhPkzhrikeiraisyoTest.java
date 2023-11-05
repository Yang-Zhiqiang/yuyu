package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.hozen.bean.report.KhPkzhrikeIraisyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生命保険料口座振替依頼書 用クラス
 */
@RunWith(OrderedRunner.class)
public class KhPkzhrikeiraisyoTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhPkzhrikeIraisyoBean khPkzhrikeIraisyoBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPkzhrikeiraisyoTest", C_SyoruiCdKbn.AS_PKZHRIKEIRAI);

        khPkzhrikeIraisyoBean.setIrSyono("");
        khPkzhrikeIraisyoBean.setIrHrkkaisuu(null);
        khPkzhrikeIraisyoBean.setIrTikiktbrisyuruikbn(null);

        khPkzhrikeIraisyoBean.setIrToritsugisyasyozokunm("");
        khPkzhrikeIraisyoBean.setIrToritsugisyakjncd("");
        khPkzhrikeIraisyoBean.setIrToritsugisyanm("");
        khPkzhrikeIraisyoBean.setIrTyouhyousakuseiymd("");
        khPkzhrikeIraisyoBean.setIrHozonkkn("");

        reportTestBean.addParamObjects(khPkzhrikeIraisyoBean, khPkzhrikeIraisyoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPkzhrikeiraisyoTest", C_SyoruiCdKbn.AS_PKZHRIKEIRAI);

        khPkzhrikeIraisyoBean.setIrSyono(null);
        khPkzhrikeIraisyoBean.setIrHrkkaisuu(null);
        khPkzhrikeIraisyoBean.setIrTikiktbrisyuruikbn(null);

        khPkzhrikeIraisyoBean.setIrToritsugisyasyozokunm(null);
        khPkzhrikeIraisyoBean.setIrToritsugisyakjncd(null);
        khPkzhrikeIraisyoBean.setIrToritsugisyanm(null);
        khPkzhrikeIraisyoBean.setIrTyouhyousakuseiymd(null);
        khPkzhrikeIraisyoBean.setIrHozonkkn(null);

        reportTestBean.addParamObjects(khPkzhrikeIraisyoBean, khPkzhrikeIraisyoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPkzhrikeiraisyoTest", C_SyoruiCdKbn.AS_PKZHRIKEIRAI);

        khPkzhrikeIraisyoBean.setIrSyono("12345678901");
        khPkzhrikeIraisyoBean.setIrHrkkaisuu(C_Hrkkaisuu.BLNK);
        khPkzhrikeIraisyoBean.setIrTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        khPkzhrikeIraisyoBean.setIrToritsugisyasyozokunm("取次者所属名");
        khPkzhrikeIraisyoBean.setIrToritsugisyakjncd("12345678");
        khPkzhrikeIraisyoBean.setIrToritsugisyanm("取次者氏名");
        khPkzhrikeIraisyoBean.setIrTyouhyousakuseiymd("2018年 2月 6日");
        khPkzhrikeIraisyoBean.setIrHozonkkn("3年");

        reportTestBean.addParamObjects(khPkzhrikeIraisyoBean, khPkzhrikeIraisyoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPkzhrikeiraisyoTest", C_SyoruiCdKbn.AS_PKZHRIKEIRAI);


        khPkzhrikeIraisyoBean.setIrSyono("wwwwwwwwwww");
        khPkzhrikeIraisyoBean.setIrHrkkaisuu(C_Hrkkaisuu.TUKI);
        khPkzhrikeIraisyoBean.setIrTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
        khPkzhrikeIraisyoBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khPkzhrikeIraisyoBean.setIrToritsugisyakjncd("wwwwwwww");
        khPkzhrikeIraisyoBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khPkzhrikeIraisyoBean.setIrTyouhyousakuseiymd("9999年99月99日");
        khPkzhrikeIraisyoBean.setIrHozonkkn("99年");

        reportTestBean.addParamObjects(khPkzhrikeIraisyoBean, khPkzhrikeIraisyoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPkzhrikeiraisyoTest", C_SyoruiCdKbn.AS_PKZHRIKEIRAI);

        khPkzhrikeIraisyoBean.setIrSyono("12345678901");
        khPkzhrikeIraisyoBean.setIrHrkkaisuu(C_Hrkkaisuu.HALFY);
        khPkzhrikeIraisyoBean.setIrTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);

        khPkzhrikeIraisyoBean.setIrToritsugisyasyozokunm("取次者所属名");
        khPkzhrikeIraisyoBean.setIrToritsugisyakjncd("12345678");
        khPkzhrikeIraisyoBean.setIrToritsugisyanm("取次者氏名");
        khPkzhrikeIraisyoBean.setIrTyouhyousakuseiymd("2018年 2月 6日");
        khPkzhrikeIraisyoBean.setIrHozonkkn("15年");

        reportTestBean.addParamObjects(khPkzhrikeIraisyoBean, khPkzhrikeIraisyoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPkzhrikeiraisyoTest", C_SyoruiCdKbn.AS_PKZHRIKEIRAI);

        khPkzhrikeIraisyoBean.setIrSyono("12345678901");
        khPkzhrikeIraisyoBean.setIrHrkkaisuu(C_Hrkkaisuu.NEN);
        khPkzhrikeIraisyoBean.setIrTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);

        khPkzhrikeIraisyoBean.setIrToritsugisyasyozokunm("取次者所属名");
        khPkzhrikeIraisyoBean.setIrToritsugisyakjncd("12345678");
        khPkzhrikeIraisyoBean.setIrToritsugisyanm("取次者氏名");
        khPkzhrikeIraisyoBean.setIrTyouhyousakuseiymd("2018年 2月 6日");
        khPkzhrikeIraisyoBean.setIrHozonkkn("15年");

        reportTestBean.addParamObjects(khPkzhrikeIraisyoBean, khPkzhrikeIraisyoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPkzhrikeiraisyoTest", C_SyoruiCdKbn.AS_PKZHRIKEIRAI);

        khPkzhrikeIraisyoBean.setIrSyono("12345678901");
        khPkzhrikeIraisyoBean.setIrHrkkaisuu(C_Hrkkaisuu.ITIJI);
        khPkzhrikeIraisyoBean.setIrTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);

        khPkzhrikeIraisyoBean.setIrToritsugisyasyozokunm("取次者所属名");
        khPkzhrikeIraisyoBean.setIrToritsugisyakjncd("12345678");
        khPkzhrikeIraisyoBean.setIrToritsugisyanm("取次者氏名");
        khPkzhrikeIraisyoBean.setIrTyouhyousakuseiymd("2018年 2月 6日");
        khPkzhrikeIraisyoBean.setIrHozonkkn("15年");

        reportTestBean.addParamObjects(khPkzhrikeIraisyoBean, khPkzhrikeIraisyoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPkzhrikeiraisyoTest", C_SyoruiCdKbn.AS_PKZHRIKEIRAI);

        khPkzhrikeIraisyoBean.setIrSyono("12345678901");
        khPkzhrikeIraisyoBean.setIrHrkkaisuu(C_Hrkkaisuu.BLNK);
        khPkzhrikeIraisyoBean.setIrTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        khPkzhrikeIraisyoBean.setIrToritsugisyasyozokunm("取次者所属名");
        khPkzhrikeIraisyoBean.setIrToritsugisyakjncd("12345678");
        khPkzhrikeIraisyoBean.setIrToritsugisyanm("取次者氏名");
        khPkzhrikeIraisyoBean.setIrTyouhyousakuseiymd("2018年 2月 6日");
        khPkzhrikeIraisyoBean.setIrHozonkkn("15年");

        reportTestBean.addParamObjects(khPkzhrikeIraisyoBean, khPkzhrikeIraisyoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPkzhrikeiraisyoTest", C_SyoruiCdKbn.AS_PKZHRIKEIRAI);

        khPkzhrikeIraisyoBean.setIrSyono("12345678901");
        khPkzhrikeIraisyoBean.setIrHrkkaisuu(C_Hrkkaisuu.BLNK);
        khPkzhrikeIraisyoBean.setIrTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.NONE);

        khPkzhrikeIraisyoBean.setIrToritsugisyasyozokunm("取次者所属名");
        khPkzhrikeIraisyoBean.setIrToritsugisyakjncd("12345678");
        khPkzhrikeIraisyoBean.setIrToritsugisyanm("取次者氏名");
        khPkzhrikeIraisyoBean.setIrTyouhyousakuseiymd("2018年 2月 6日");
        khPkzhrikeIraisyoBean.setIrHozonkkn("15年");

        reportTestBean.addParamObjects(khPkzhrikeIraisyoBean, khPkzhrikeIraisyoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
