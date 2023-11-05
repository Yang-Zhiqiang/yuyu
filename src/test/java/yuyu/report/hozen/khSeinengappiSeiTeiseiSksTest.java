package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzSksKaisyasiyouranBean;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.bean.report.KhSeikyuusyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生年月日・性訂正請求書帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class khSeinengappiSeiTeiseiSksTest {

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
            createReport.createNewReportServiceBean("hozen", "", "kh_seinengappiseiteisei_sks", C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS);

        khSeikyuusyoBean.setIrSyono(null);
        khSeikyuusyoBean.setIrKyknmkj(null);
        khSeikyuusyoBean.setIrTsinyno(null);
        khSeikyuusyoBean.setIrTsintelno(null);
        khSeikyuusyoBean.setIrTsinadr1kj(null);
        khSeikyuusyoBean.setIrTsinadr2kj(null);
        khSeikyuusyoBean.setIrTsinadr3kj(null);
        khSeikyuusyoBean.setIrHhknseiymd(null);
        khSeikyuusyoBean.setIrHhknsei(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyanm(null);
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd(null);
        bzSksKaisyasiyouranBean.setIrHozonkkn(null);
        khSeikyuusyoBean.setIrBanknmkj(null);
        khSeikyuusyoBean.setIrKzmeiginmkn(null);

        khSeikyuusyoBean.setIrHhknseiymdhenkouumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrHhknseihenkouumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrHenkankinumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.EUR);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);
        khSeikyuusyoBean.setIrSaikensetumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_seinengappiseiteisei_sks", C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS);

        khSeikyuusyoBean.setIrSyono("");
        khSeikyuusyoBean.setIrKyknmkj("");
        khSeikyuusyoBean.setIrTsinyno("");
        khSeikyuusyoBean.setIrTsintelno("");
        khSeikyuusyoBean.setIrTsinadr1kj("");
        khSeikyuusyoBean.setIrTsinadr2kj("");
        khSeikyuusyoBean.setIrTsinadr3kj("");
        khSeikyuusyoBean.setIrHhknseiymd("");
        khSeikyuusyoBean.setIrHhknsei(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("");
        bzSksKaisyasiyouranBean.setIrHozonkkn("");
        khSeikyuusyoBean.setIrBanknmkj("");
        khSeikyuusyoBean.setIrKzmeiginmkn("");

        khSeikyuusyoBean.setIrHhknseiymdhenkouumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrHhknseihenkouumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrHenkankinumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.EUR);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);
        khSeikyuusyoBean.setIrSaikensetumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_seinengappiseiteisei_sks", C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS);

        khSeikyuusyoBean.setIrSyono("10000000001");
        khSeikyuusyoBean.setIrKyknmkj("佐藤美雪");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");
        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");
        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");
        khSeikyuusyoBean.setIrTsinadr3kj("２－４－３５");
        khSeikyuusyoBean.setIrHhknseiymd("平成10年11月20日");
        khSeikyuusyoBean.setIrHhknsei(C_Hhknsei.FEMALE);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月26日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後15年");
        khSeikyuusyoBean.setIrBanknmkj("青森県三沢市細谷銀行");
        khSeikyuusyoBean.setIrKzmeiginmkn("ケイメイ ゼロイチニサンゼロイチニサ");

        khSeikyuusyoBean.setIrHhknseiymdhenkouumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrHhknseihenkouumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrHenkankinumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.EUR);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);
        khSeikyuusyoBean.setIrSaikensetumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_seinengappiseiteisei_sks", C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS);

        khSeikyuusyoBean.setIrSyono("wwwwwwwwwww");
        khSeikyuusyoBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinyno("wwwwwwww");
        khSeikyuusyoBean.setIrTsintelno("wwwwwwwwwwwwww");
        khSeikyuusyoBean.setIrTsinadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrHhknseiymd("ＷＷ99年12月31日");
        khSeikyuusyoBean.setIrHhknsei(C_Hhknsei.MALE);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("wwwwwwww");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("9999年12月31日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後99年");
        khSeikyuusyoBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrHhknseiymdhenkouumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrHhknseihenkouumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrHenkankinumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.EUR);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);
        khSeikyuusyoBean.setIrSaikensetumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_seinengappiseiteisei_sks", C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS);

        khSeikyuusyoBean.setIrSyono("10000000001");
        khSeikyuusyoBean.setIrKyknmkj("佐藤美雪");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");
        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");
        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");
        khSeikyuusyoBean.setIrTsinadr3kj("２－４－３５");
        khSeikyuusyoBean.setIrHhknseiymd("平成10年11月20日");
        khSeikyuusyoBean.setIrHhknsei(C_Hhknsei.FEMALE);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月26日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後15年");
        khSeikyuusyoBean.setIrBanknmkj("青森県三沢市細谷銀行");
        khSeikyuusyoBean.setIrKzmeiginmkn("ケイメイ ゼロイチニサンゼロイチニサ");

        khSeikyuusyoBean.setIrHhknseiymdhenkouumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrHhknseihenkouumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrHenkankinumukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.EUR);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);
        khSeikyuusyoBean.setIrSaikensetumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_seinengappiseiteisei_sks", C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS);

        khSeikyuusyoBean.setIrSyono("10000000001");
        khSeikyuusyoBean.setIrKyknmkj("佐藤美雪");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");
        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");
        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");
        khSeikyuusyoBean.setIrTsinadr3kj("２－４－３５");
        khSeikyuusyoBean.setIrHhknseiymd("平成10年11月20日");
        khSeikyuusyoBean.setIrHhknsei(C_Hhknsei.FEMALE);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月26日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後15年");
        khSeikyuusyoBean.setIrBanknmkj("青森県三沢市細谷銀行");
        khSeikyuusyoBean.setIrKzmeiginmkn("ケイメイ ゼロイチニサンゼロイチニサ");

        khSeikyuusyoBean.setIrHhknseiymdhenkouumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrHhknseihenkouumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrHenkankinumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);
        khSeikyuusyoBean.setIrSaikensetumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_seinengappiseiteisei_sks", C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS);

        khSeikyuusyoBean.setIrSyono("10000000001");
        khSeikyuusyoBean.setIrKyknmkj("佐藤美雪");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");
        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");
        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");
        khSeikyuusyoBean.setIrTsinadr3kj("２－４－３５");
        khSeikyuusyoBean.setIrHhknseiymd("平成10年11月20日");
        khSeikyuusyoBean.setIrHhknsei(C_Hhknsei.FEMALE);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月26日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後15年");
        khSeikyuusyoBean.setIrBanknmkj("青森県三沢市細谷銀行");
        khSeikyuusyoBean.setIrKzmeiginmkn("ケイメイ ゼロイチニサンゼロイチニサ");

        khSeikyuusyoBean.setIrHhknseiymdhenkouumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrHhknseihenkouumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrHenkankinumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);
        khSeikyuusyoBean.setIrSaikensetumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_seinengappiseiteisei_sks", C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS);

        khSeikyuusyoBean.setIrSyono("10000000001");
        khSeikyuusyoBean.setIrKyknmkj("佐藤美雪");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");
        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");
        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");
        khSeikyuusyoBean.setIrTsinadr3kj("２－４－３５");
        khSeikyuusyoBean.setIrHhknseiymd("平成10年11月20日");
        khSeikyuusyoBean.setIrHhknsei(C_Hhknsei.FEMALE);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月26日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後15年");
        khSeikyuusyoBean.setIrBanknmkj("青森県三沢市細谷銀行");
        khSeikyuusyoBean.setIrKzmeiginmkn("ケイメイ ゼロイチニサンゼロイチニサ");

        khSeikyuusyoBean.setIrHhknseiymdhenkouumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrHhknseihenkouumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrHenkankinumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.DANTAI);
        khSeikyuusyoBean.setIrSaikensetumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_seinengappiseiteisei_sks", C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS);

        khSeikyuusyoBean.setIrSyono("10000000001");
        khSeikyuusyoBean.setIrKyknmkj("佐藤美雪");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");
        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");
        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");
        khSeikyuusyoBean.setIrTsinadr3kj("２－４－３５");
        khSeikyuusyoBean.setIrHhknseiymd("平成10年11月20日");
        khSeikyuusyoBean.setIrHhknsei(C_Hhknsei.FEMALE);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月26日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後15年");
        khSeikyuusyoBean.setIrBanknmkj("青森県三沢市細谷銀行");
        khSeikyuusyoBean.setIrKzmeiginmkn("ケイメイ ゼロイチニサンゼロイチニサ");

        khSeikyuusyoBean.setIrHhknseiymdhenkouumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrHhknseihenkouumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrHenkankinumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.DANTAI);
        khSeikyuusyoBean.setIrSaikensetumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_seinengappiseiteisei_sks", C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS);

        khSeikyuusyoBean.setIrSyono("10000000001");
        khSeikyuusyoBean.setIrKyknmkj("佐藤美雪");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");
        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");
        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");
        khSeikyuusyoBean.setIrTsinadr3kj("２－４－３５");
        khSeikyuusyoBean.setIrHhknseiymd("平成10年11月20日");
        khSeikyuusyoBean.setIrHhknsei(C_Hhknsei.FEMALE);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月26日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後15年");
        khSeikyuusyoBean.setIrBanknmkj("青森県三沢市細谷銀行");
        khSeikyuusyoBean.setIrKzmeiginmkn("ケイメイ ゼロイチニサンゼロイチニサ");

        khSeikyuusyoBean.setIrHhknseiymdhenkouumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrHhknseihenkouumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrHenkankinumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.EUR);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);
        khSeikyuusyoBean.setIrSaikensetumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_seinengappiseiteisei_sks", C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS);

        khSeikyuusyoBean.setIrSyono("10000000001");
        khSeikyuusyoBean.setIrKyknmkj("佐藤美雪");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");
        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");
        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");
        khSeikyuusyoBean.setIrTsinadr3kj("２－４－３５");
        khSeikyuusyoBean.setIrHhknseiymd("平成10年11月20日");
        khSeikyuusyoBean.setIrHhknsei(C_Hhknsei.FEMALE);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月26日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後15年");
        khSeikyuusyoBean.setIrBanknmkj("青森県三沢市細谷銀行");
        khSeikyuusyoBean.setIrKzmeiginmkn("ケイメイ ゼロイチニサンゼロイチニサ");

        khSeikyuusyoBean.setIrHhknseiymdhenkouumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrHhknseihenkouumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrHenkankinumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.EUR);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);
        khSeikyuusyoBean.setIrSaikensetumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_seinengappiseiteisei_sks", C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS);

        khSeikyuusyoBean.setIrSyono("10000000001");
        khSeikyuusyoBean.setIrKyknmkj("佐藤美雪");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");
        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");
        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");
        khSeikyuusyoBean.setIrTsinadr3kj("２－４－３５");
        khSeikyuusyoBean.setIrHhknseiymd("平成10年11月20日");
        khSeikyuusyoBean.setIrHhknsei(C_Hhknsei.FEMALE);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月26日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後15年");
        khSeikyuusyoBean.setIrBanknmkj("青森県三沢市細谷銀行");
        khSeikyuusyoBean.setIrKzmeiginmkn("ケイメイ ゼロイチニサンゼロイチニサ");

        khSeikyuusyoBean.setIrHhknseiymdhenkouumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrHhknseihenkouumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrHenkankinumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.EUR);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.DANTAI);
        khSeikyuusyoBean.setIrSaikensetumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_seinengappiseiteisei_sks", C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS);

        khSeikyuusyoBean.setIrSyono("10000000001");
        khSeikyuusyoBean.setIrKyknmkj("佐藤美雪");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");
        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");
        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");
        khSeikyuusyoBean.setIrTsinadr3kj("２－４－３５");
        khSeikyuusyoBean.setIrHhknseiymd("平成10年11月20日");
        khSeikyuusyoBean.setIrHhknsei(C_Hhknsei.FEMALE);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月26日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後15年");
        khSeikyuusyoBean.setIrBanknmkj("青森県三沢市細谷銀行");
        khSeikyuusyoBean.setIrKzmeiginmkn("ケイメイ ゼロイチニサンゼロイチニサ");

        khSeikyuusyoBean.setIrHhknseiymdhenkouumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrHhknseihenkouumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrHenkankinumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.EUR);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.DANTAI);
        khSeikyuusyoBean.setIrSaikensetumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

}
