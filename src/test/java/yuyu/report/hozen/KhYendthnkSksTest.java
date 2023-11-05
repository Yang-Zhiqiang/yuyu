package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzSksKaisyasiyouranBean;
import yuyu.def.classification.C_MousideIkouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhSeikyuusyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 円建変更請求書帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhYendthnkSksTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private  KhSeikyuusyoBean khSeikyuusyoBean;

    @Inject
    private BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhYendthnkSksTest", C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        khSeikyuusyoBean.setIrSyono("");
        khSeikyuusyoBean.setIrKyknmkj("");
        khSeikyuusyoBean.setIrTsinyno("");
        khSeikyuusyoBean.setIrTsintelno("");
        khSeikyuusyoBean.setIrTsinadr1kj("");
        khSeikyuusyoBean.setIrTsinadr2kj("");
        khSeikyuusyoBean.setIrTsinadr3kj("");
        khSeikyuusyoBean.setIrMousideikoukbn(C_MousideIkouKbn.YENNENKIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("");
        bzSksKaisyasiyouranBean.setIrHozonkkn("");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhYendthnkSksTest", C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        khSeikyuusyoBean.setIrSyono(null);
        khSeikyuusyoBean.setIrKyknmkj(null);
        khSeikyuusyoBean.setIrTsinyno(null);
        khSeikyuusyoBean.setIrTsintelno(null);
        khSeikyuusyoBean.setIrTsinadr1kj(null);
        khSeikyuusyoBean.setIrTsinadr2kj(null);
        khSeikyuusyoBean.setIrTsinadr3kj(null);
        khSeikyuusyoBean.setIrMousideikoukbn(null);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyanm(null);
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd(null);
        bzSksKaisyasiyouranBean.setIrHozonkkn(null);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhYendthnkSksTest", C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100002");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");
        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");
        khSeikyuusyoBean.setIrMousideikoukbn(C_MousideIkouKbn.YENNENKIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 2年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhYendthnkSksTest", C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        khSeikyuusyoBean.setIrSyono("wwwwwwwwwww");
        khSeikyuusyoBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinyno("wwwwwww");
        khSeikyuusyoBean.setIrTsintelno("wwwwwwwwwwwwww");
        khSeikyuusyoBean.setIrTsinadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrMousideikoukbn(C_MousideIkouKbn.YENNENKIN);


        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("wwwwwwww");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後99年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhYendthnkSksTest", C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100002");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");
        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");
        khSeikyuusyoBean.setIrMousideikoukbn(C_MousideIkouKbn.YENSYUUSIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 2年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

}
