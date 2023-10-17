package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzSksKaisyasiyouranBean;
import yuyu.def.classification.C_Khhrshrjiyuu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.hozen.bean.report.KhSeikyuusyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 *配当金支払請求書テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class KhDshrSksTest extends AbstractTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhSeikyuusyoBean khSeikyuusyoBean;


    @Inject
    private BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhDshrSksTest", C_SyoruiCdKbn.KK_DSHR_SKS);
        khSeikyuusyoBean.setIrSyono("");
        khSeikyuusyoBean.setIrKyknmkj("");
        khSeikyuusyoBean.setIrTsinyno("");
        khSeikyuusyoBean.setIrTsintelno("");
        khSeikyuusyoBean.setIrTsinadr1kj("");
        khSeikyuusyoBean.setIrTsinadr2kj("");
        khSeikyuusyoBean.setIrTsinadr3kj("");
        khSeikyuusyoBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("");
        bzSksKaisyasiyouranBean.setIrHozonkkn("");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhDshrSksTest", C_SyoruiCdKbn.KK_DSHR_SKS);
        khSeikyuusyoBean.setIrSyono(null);
        khSeikyuusyoBean.setIrKyknmkj(null);
        khSeikyuusyoBean.setIrTsinyno(null);
        khSeikyuusyoBean.setIrTsintelno(null);
        khSeikyuusyoBean.setIrTsinadr1kj(null);
        khSeikyuusyoBean.setIrTsinadr2kj(null);
        khSeikyuusyoBean.setIrTsinadr3kj(null);
        khSeikyuusyoBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyanm(null);
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd(null);
        bzSksKaisyasiyouranBean.setIrHozonkkn(null);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhDshrSksTest", C_SyoruiCdKbn.KK_DSHR_SKS);
        khSeikyuusyoBean.setIrSyono("10810100002");
        khSeikyuusyoBean.setIrKyknmkj("田中　太郎");
        khSeikyuusyoBean.setIrTsinyno("0101122");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");
        khSeikyuusyoBean.setIrTsinadr1kj("新栄町１－４－３４");
        khSeikyuusyoBean.setIrTsinadr2kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr3kj("ABCマンション");
        khSeikyuusyoBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("1年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhDshrSksTest", C_SyoruiCdKbn.KK_DSHR_SKS);
        khSeikyuusyoBean.setIrSyono("wwwwwwwwwww");
        khSeikyuusyoBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinyno("wwwwwww");
        khSeikyuusyoBean.setIrTsintelno("wwwwwwwwwwwwww");
        khSeikyuusyoBean.setIrTsinadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("wwwwwwww");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("99年");


        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


}
