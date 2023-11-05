package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzSksKaisyasiyouranBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhSeikyuusyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 証券再発行請求書帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhSyoSaiHkSksTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private  KhSeikyuusyoBean khSeikyuusyoBean;

    @Inject
    private BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyoSaihkSksTest", C_SyoruiCdKbn.KK_SYOSAIHK_SKS);

        khSeikyuusyoBean.setIrSyono("XXXXXXXXXXX");
        khSeikyuusyoBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinyno("XXXXXXX");
        khSeikyuusyoBean.setIrTsintelno("XXXXXXXXXXXXXX");
        khSeikyuusyoBean.setIrTsinadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("XXXXXXXX");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("99年");


        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyoSaihkSksTest", C_SyoruiCdKbn.KK_SYOSAIHK_SKS);

        khSeikyuusyoBean.setIrSyono("10000000001");
        khSeikyuusyoBean.setIrKyknmkj("契約者名（漢字）");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("12345678901234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyoSaihkSksTest", C_SyoruiCdKbn.KK_SYOSAIHK_SKS);

        khSeikyuusyoBean.setIrSyono(null);
        khSeikyuusyoBean.setIrKyknmkj(null);
        khSeikyuusyoBean.setIrTsinyno(null);
        khSeikyuusyoBean.setIrTsintelno(null);
        khSeikyuusyoBean.setIrTsinadr1kj(null);
        khSeikyuusyoBean.setIrTsinadr2kj(null);
        khSeikyuusyoBean.setIrTsinadr3kj(null);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyanm(null);
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd(null);
        bzSksKaisyasiyouranBean.setIrHozonkkn(null);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyoSaihkSksTest", C_SyoruiCdKbn.KK_SYOSAIHK_SKS);

        khSeikyuusyoBean.setIrSyono("");
        khSeikyuusyoBean.setIrKyknmkj("");
        khSeikyuusyoBean.setIrTsinyno("");
        khSeikyuusyoBean.setIrTsintelno("");
        khSeikyuusyoBean.setIrTsinadr1kj("");
        khSeikyuusyoBean.setIrTsinadr2kj("");
        khSeikyuusyoBean.setIrTsinadr3kj("");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("");
        bzSksKaisyasiyouranBean.setIrHozonkkn("");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
