package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhCreditcardMosBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * クレジットカード扱い申込書 用クラス
 */
@RunWith(OrderedRunner.class)
public class KhCreditcardmosTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhCreditcardMosBean khCreditcardMosBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhCreditcardmosTest", C_SyoruiCdKbn.AS_CREDITCARDMOS);

        khCreditcardMosBean.setIrSyono("");
        khCreditcardMosBean.setIrCreditkessaiyouno("");
        khCreditcardMosBean.setIrKyksyanmkn("");
        khCreditcardMosBean.setIrKyksyatel("");
        khCreditcardMosBean.setIrToritsugisyasyozokunm("");
        khCreditcardMosBean.setIrToritsugisyakjncd("");
        khCreditcardMosBean.setIrToritsugisyanm("");
        khCreditcardMosBean.setIrTyouhyousakuseiymd("");
        khCreditcardMosBean.setIrHozonkkn("");
        reportTestBean.addParamObjects(khCreditcardMosBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhCreditcardmosTest", C_SyoruiCdKbn.AS_CREDITCARDMOS);

        khCreditcardMosBean.setIrSyono(null);
        khCreditcardMosBean.setIrCreditkessaiyouno(null);
        khCreditcardMosBean.setIrKyksyanmkn(null);
        khCreditcardMosBean.setIrKyksyatel(null);
        khCreditcardMosBean.setIrToritsugisyasyozokunm(null);
        khCreditcardMosBean.setIrToritsugisyakjncd(null);
        khCreditcardMosBean.setIrToritsugisyanm(null);
        khCreditcardMosBean.setIrTyouhyousakuseiymd(null);
        khCreditcardMosBean.setIrHozonkkn(null);
        reportTestBean.addParamObjects(khCreditcardMosBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhCreditcardmosTest", C_SyoruiCdKbn.AS_CREDITCARDMOS);

        khCreditcardMosBean.setIrSyono("86004500243");
        khCreditcardMosBean.setIrCreditkessaiyouno("74102589633210654987753246");
        khCreditcardMosBean.setIrKyksyanmkn("契約者氏名");
        khCreditcardMosBean.setIrKyksyatel("01205060801234");
        khCreditcardMosBean.setIrToritsugisyasyozokunm("取次者所属名");
        khCreditcardMosBean.setIrToritsugisyakjncd("30313234");
        khCreditcardMosBean.setIrToritsugisyanm("取次者氏名");
        khCreditcardMosBean.setIrTyouhyousakuseiymd("2012年12月23日");
        khCreditcardMosBean.setIrHozonkkn("1年");
        reportTestBean.addParamObjects(khCreditcardMosBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhCreditcardmosTest", C_SyoruiCdKbn.AS_CREDITCARDMOS);

        khCreditcardMosBean.setIrSyono("wwwwwwwwwww");
        khCreditcardMosBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
        khCreditcardMosBean.setIrKyksyanmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khCreditcardMosBean.setIrKyksyatel("wwwwwwwwwwwwww");
        khCreditcardMosBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khCreditcardMosBean.setIrToritsugisyakjncd("wwwwwwww");
        khCreditcardMosBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khCreditcardMosBean.setIrTyouhyousakuseiymd("9999年12月31日");
        khCreditcardMosBean.setIrHozonkkn("99年");
        reportTestBean.addParamObjects(khCreditcardMosBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
