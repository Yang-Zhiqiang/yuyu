package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzSksKaisyasiyouranBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.hozen.bean.report.KhSeikyuusyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 目標額変更請求書 用クラス
 */
@RunWith(OrderedRunner.class)
public class KhMkhgkhnkSksTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhSeikyuusyoBean khSeikyuusyoBean;

    @Inject
    private BzSksKaisyasiyouranBean bzSksKaisyasiyouranBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMkhgkhnkSks", C_SyoruiCdKbn.KK_MKHGKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("wwwwwwwwwww");
        khSeikyuusyoBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinyno("wwwwwww");
        khSeikyuusyoBean.setIrTsintelno("wwwwwwwwwwwwww");
        khSeikyuusyoBean.setIrTsinadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrAftertargettkmokuhyouti(999);
        khSeikyuusyoBean.setIrBeforetargettkmokuhyouti(999);
        khSeikyuusyoBean.setIrTargettkkbn(C_TargetTkKbn.SYUUSIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("wwwwwwww");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 99年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMkhgkhnkSks", C_SyoruiCdKbn.KK_MKHGKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrKyknmkj("田中太郎");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");
        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");
        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");
        khSeikyuusyoBean.setIrTsinadr3kj("新宿市１ー２ー２２");
        khSeikyuusyoBean.setIrAftertargettkmokuhyouti(149);
        khSeikyuusyoBean.setIrBeforetargettkmokuhyouti(151);
        khSeikyuusyoBean.setIrTargettkkbn(C_TargetTkKbn.SYUUSIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMkhgkhnkSks", C_SyoruiCdKbn.KK_MKHGKHNK_SKS);

        khSeikyuusyoBean.setIrSyono(null);
        khSeikyuusyoBean.setIrKyknmkj(null);
        khSeikyuusyoBean.setIrTsinyno(null);
        khSeikyuusyoBean.setIrTsintelno(null);
        khSeikyuusyoBean.setIrTsinadr1kj(null);
        khSeikyuusyoBean.setIrTsinadr2kj(null);
        khSeikyuusyoBean.setIrTsinadr3kj(null);
        khSeikyuusyoBean.setIrAftertargettkmokuhyouti(null);
        khSeikyuusyoBean.setIrBeforetargettkmokuhyouti(null);
        khSeikyuusyoBean.setIrTargettkkbn(C_TargetTkKbn.SYUUSIN);

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
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMkhgkhnkSks", C_SyoruiCdKbn.KK_MKHGKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("");
        khSeikyuusyoBean.setIrKyknmkj("");
        khSeikyuusyoBean.setIrTsinyno("");
        khSeikyuusyoBean.setIrTsintelno("");
        khSeikyuusyoBean.setIrTsinadr1kj("");
        khSeikyuusyoBean.setIrTsinadr2kj("");
        khSeikyuusyoBean.setIrTsinadr3kj("");
        khSeikyuusyoBean.setIrAftertargettkmokuhyouti(0);
        khSeikyuusyoBean.setIrBeforetargettkmokuhyouti(0);
        khSeikyuusyoBean.setIrTargettkkbn(C_TargetTkKbn.SYUUSIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("");
        bzSksKaisyasiyouranBean.setIrHozonkkn("");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMkhgkhnkSks", C_SyoruiCdKbn.KK_MKHGKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("wwwwwwwwwww");
        khSeikyuusyoBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinyno("wwwwwww");
        khSeikyuusyoBean.setIrTsintelno("wwwwwwwwwwwwww");
        khSeikyuusyoBean.setIrTsinadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrAftertargettkmokuhyouti(0);
        khSeikyuusyoBean.setIrBeforetargettkmokuhyouti(0);
        khSeikyuusyoBean.setIrTargettkkbn(C_TargetTkKbn.SYUUSIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("wwwwwwww");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMkhgkhnkSks", C_SyoruiCdKbn.KK_MKHGKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrKyknmkj("田中太郎");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");
        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");
        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");
        khSeikyuusyoBean.setIrTsinadr3kj("新宿市１ー２ー２２");
        khSeikyuusyoBean.setIrAftertargettkmokuhyouti(999);
        khSeikyuusyoBean.setIrBeforetargettkmokuhyouti(0);
        khSeikyuusyoBean.setIrTargettkkbn(C_TargetTkKbn.SYUUSIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMkhgkhnkSks", C_SyoruiCdKbn.KK_MKHGKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrKyknmkj("田中太郎");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");
        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");
        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");
        khSeikyuusyoBean.setIrTsinadr3kj("新宿市１ー２ー２２");
        khSeikyuusyoBean.setIrAftertargettkmokuhyouti(0);
        khSeikyuusyoBean.setIrBeforetargettkmokuhyouti(999);
        khSeikyuusyoBean.setIrTargettkkbn(C_TargetTkKbn.SYUUSIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMkhgkhnkSks", C_SyoruiCdKbn.KK_MKHGKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("wwwwwwwwwww");
        khSeikyuusyoBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinyno("wwwwwww");
        khSeikyuusyoBean.setIrTsintelno("wwwwwwwwwwwwww");
        khSeikyuusyoBean.setIrTsinadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrAftertargettkmokuhyouti(999);
        khSeikyuusyoBean.setIrBeforetargettkmokuhyouti(999);
        khSeikyuusyoBean.setIrTargettkkbn(C_TargetTkKbn.NENKIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("wwwwwwww");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 99年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMkhgkhnkSks", C_SyoruiCdKbn.KK_MKHGKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrKyknmkj("田中太郎");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");
        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");
        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");
        khSeikyuusyoBean.setIrTsinadr3kj("新宿市１ー２ー２２");
        khSeikyuusyoBean.setIrAftertargettkmokuhyouti(139);
        khSeikyuusyoBean.setIrBeforetargettkmokuhyouti(141);
        khSeikyuusyoBean.setIrTargettkkbn(C_TargetTkKbn.NENKIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMkhgkhnkSks", C_SyoruiCdKbn.KK_MKHGKHNK_SKS);

        khSeikyuusyoBean.setIrSyono(null);
        khSeikyuusyoBean.setIrKyknmkj(null);
        khSeikyuusyoBean.setIrTsinyno(null);
        khSeikyuusyoBean.setIrTsintelno(null);
        khSeikyuusyoBean.setIrTsinadr1kj(null);
        khSeikyuusyoBean.setIrTsinadr2kj(null);
        khSeikyuusyoBean.setIrTsinadr3kj(null);
        khSeikyuusyoBean.setIrAftertargettkmokuhyouti(null);
        khSeikyuusyoBean.setIrBeforetargettkmokuhyouti(null);
        khSeikyuusyoBean.setIrTargettkkbn(C_TargetTkKbn.NENKIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyanm(null);
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd(null);
        bzSksKaisyasiyouranBean.setIrHozonkkn(null);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMkhgkhnkSks", C_SyoruiCdKbn.KK_MKHGKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("");
        khSeikyuusyoBean.setIrKyknmkj("");
        khSeikyuusyoBean.setIrTsinyno("");
        khSeikyuusyoBean.setIrTsintelno("");
        khSeikyuusyoBean.setIrTsinadr1kj("");
        khSeikyuusyoBean.setIrTsinadr2kj("");
        khSeikyuusyoBean.setIrTsinadr3kj("");
        khSeikyuusyoBean.setIrAftertargettkmokuhyouti(0);
        khSeikyuusyoBean.setIrBeforetargettkmokuhyouti(0);
        khSeikyuusyoBean.setIrTargettkkbn(C_TargetTkKbn.NENKIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("");
        bzSksKaisyasiyouranBean.setIrHozonkkn("");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMkhgkhnkSks", C_SyoruiCdKbn.KK_MKHGKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("wwwwwwwwwww");
        khSeikyuusyoBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinyno("wwwwwww");
        khSeikyuusyoBean.setIrTsintelno("wwwwwwwwwwwwww");
        khSeikyuusyoBean.setIrTsinadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrAftertargettkmokuhyouti(0);
        khSeikyuusyoBean.setIrBeforetargettkmokuhyouti(0);
        khSeikyuusyoBean.setIrTargettkkbn(C_TargetTkKbn.NENKIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("wwwwwwww");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMkhgkhnkSks", C_SyoruiCdKbn.KK_MKHGKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrKyknmkj("田中太郎");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");
        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");
        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");
        khSeikyuusyoBean.setIrTsinadr3kj("新宿市１ー２ー２２");
        khSeikyuusyoBean.setIrAftertargettkmokuhyouti(999);
        khSeikyuusyoBean.setIrBeforetargettkmokuhyouti(0);
        khSeikyuusyoBean.setIrTargettkkbn(C_TargetTkKbn.NENKIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMkhgkhnkSks", C_SyoruiCdKbn.KK_MKHGKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrKyknmkj("田中太郎");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");
        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");
        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");
        khSeikyuusyoBean.setIrTsinadr3kj("新宿市１ー２ー２２");
        khSeikyuusyoBean.setIrAftertargettkmokuhyouti(0);
        khSeikyuusyoBean.setIrBeforetargettkmokuhyouti(999);
        khSeikyuusyoBean.setIrTargettkkbn(C_TargetTkKbn.NENKIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
