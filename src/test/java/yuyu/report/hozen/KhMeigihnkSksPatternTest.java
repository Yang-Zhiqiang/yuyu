package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzSksKaisyasiyouranBean;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.hozen.bean.report.KhSeikyuusyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 名義変更請求書帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhMeigihnkSksPatternTest {

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
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrKyknmkj("住生太郎");
        khSeikyuusyoBean.setIrHhknnmkj("住生すみれ");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("城見１－１－１");
        khSeikyuusyoBean.setIrTsinadr3kj("");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(1);
        khSeikyuusyoBean.setIrSbuktnmkj1("住生太郎");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(100));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsknmkj("住生太郎");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("住生太郎");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("住生一郎");
        khSeikyuusyoBean.setIrTrkkzknmkj2("住生二郎");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2020年 4月 1日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("保存永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrKyknmkj("住生太郎");
        khSeikyuusyoBean.setIrHhknnmkj("住生すみれ");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("城見１－１－１");
        khSeikyuusyoBean.setIrTsinadr3kj("");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(1);
        khSeikyuusyoBean.setIrSbuktnmkj1("住生太郎");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(100));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsknmkj("住生太郎");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("住生すみれ");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("住生一郎");
        khSeikyuusyoBean.setIrTrkkzknmkj2("住生二郎");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2020年 4月 1日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("保存永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrKyknmkj("住生太郎");
        khSeikyuusyoBean.setIrHhknnmkj("住生すみれ");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KAISEIKAIMEI);
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("城見１－１－１");
        khSeikyuusyoBean.setIrTsinadr3kj("");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(1);
        khSeikyuusyoBean.setIrSbuktnmkj1("住生太郎");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(100));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsknmkj("住生太郎");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("住生太郎");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("住生一郎");
        khSeikyuusyoBean.setIrTrkkzknmkj2("住生二郎");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2020年 4月 1日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("保存永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrKyknmkj("住生太郎");
        khSeikyuusyoBean.setIrHhknnmkj("住生すみれ");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KAISEIKAIMEI);
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("城見１－１－１");
        khSeikyuusyoBean.setIrTsinadr3kj("");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(1);
        khSeikyuusyoBean.setIrSbuktnmkj1("住生太郎");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(100));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsknmkj("住生太郎");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("住生すみれ");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("住生一郎");
        khSeikyuusyoBean.setIrTrkkzknmkj2("住生二郎");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2020年 4月 1日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("保存永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrKyknmkj("住生太郎");
        khSeikyuusyoBean.setIrHhknnmkj("住生すみれ");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYKSB);
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("城見１－１－１");
        khSeikyuusyoBean.setIrTsinadr3kj("");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(1);
        khSeikyuusyoBean.setIrSbuktnmkj1("住生太郎");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(100));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsknmkj("住生太郎");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("住生太郎");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("住生一郎");
        khSeikyuusyoBean.setIrTrkkzknmkj2("住生二郎");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2020年 4月 1日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("保存永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrKyknmkj("住生太郎");
        khSeikyuusyoBean.setIrHhknnmkj("住生すみれ");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYKSB);
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("城見１－１－１");
        khSeikyuusyoBean.setIrTsinadr3kj("");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(1);
        khSeikyuusyoBean.setIrSbuktnmkj1("住生太郎");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(100));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsknmkj("住生太郎");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("住生すみれ");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("住生一郎");
        khSeikyuusyoBean.setIrTrkkzknmkj2("住生二郎");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2020年 4月 1日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("保存永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrKyknmkj("住生太郎");
        khSeikyuusyoBean.setIrHhknnmkj("住生すみれ");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.SONOTA);
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("城見１－１－１");
        khSeikyuusyoBean.setIrTsinadr3kj("");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(1);
        khSeikyuusyoBean.setIrSbuktnmkj1("住生太郎");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(100));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsknmkj("住生太郎");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("住生太郎");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("住生一郎");
        khSeikyuusyoBean.setIrTrkkzknmkj2("住生二郎");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2020年 4月 1日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("保存永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrKyknmkj("住生太郎");
        khSeikyuusyoBean.setIrHhknnmkj("住生すみれ");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.SONOTA);
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("城見１－１－１");
        khSeikyuusyoBean.setIrTsinadr3kj("");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(1);
        khSeikyuusyoBean.setIrSbuktnmkj1("住生太郎");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(100));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsknmkj("住生太郎");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("住生すみれ");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("住生一郎");
        khSeikyuusyoBean.setIrTrkkzknmkj2("住生二郎");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2020年 4月 1日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("保存永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
