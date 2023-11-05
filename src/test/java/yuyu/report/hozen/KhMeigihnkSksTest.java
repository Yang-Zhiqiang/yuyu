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
import yuyu.def.classification.C_UktKbn;
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
public class KhMeigihnkSksTest {

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

        khSeikyuusyoBean.setIrSyono("XXXXXXXXXXX");

        khSeikyuusyoBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);

        khSeikyuusyoBean.setIrTsinadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrTsinadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrTsinadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);

        khSeikyuusyoBean.setIrSbuktnmkj1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrSbuktnmkj2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrSbuktnmkj3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrSbuktnmkj4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(999));

        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(999));

        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(999));

        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(999));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HONNIN);

        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);

        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("XXXXXXXX");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("9999年99月99日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("99年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100002");

        khSeikyuusyoBean.setIrKyknmkj("契約者名");

        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KAISEIKAIMEI);

        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");

        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");

        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);

        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");

        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");

        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");

        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");

        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));

        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));

        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));

        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsknmkj("指定代理請求人名");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);

        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);

        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100003");

        khSeikyuusyoBean.setIrKyknmkj("契約者名");

        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYKSB);

        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");

        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");

        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(6);
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);

        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);

        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100004");

        khSeikyuusyoBean.setIrKyknmkj("契約者名");

        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.SONOTA);

        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");

        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");

        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(5);
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsknmkj("");

        khSeikyuusyoBean.setIrStdruktkbn(C_UktKbn.NASI);
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);

        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);

        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("");

        khSeikyuusyoBean.setIrKyknmkj("");

        khSeikyuusyoBean.setIrHhknnmkj("");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);

        khSeikyuusyoBean.setIrTsinadr1kj("");

        khSeikyuusyoBean.setIrTsinadr2kj("");

        khSeikyuusyoBean.setIrTsinadr3kj("");

        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);

        khSeikyuusyoBean.setIrSbuktnmkj1("");

        khSeikyuusyoBean.setIrSbuktnmkj2("");

        khSeikyuusyoBean.setIrSbuktnmkj3("");

        khSeikyuusyoBean.setIrSbuktnmkj4("");

        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));

        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));

        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));

        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsknmkj(null);

        khSeikyuusyoBean.setIrStdruktkbn(C_UktKbn.SONOTA);
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);

        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);

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
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono(null);

        khSeikyuusyoBean.setIrKyknmkj(null);

        khSeikyuusyoBean.setIrHhknnmkj(null);
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);

        khSeikyuusyoBean.setIrTsinadr1kj(null);

        khSeikyuusyoBean.setIrTsinadr2kj(null);

        khSeikyuusyoBean.setIrTsinadr3kj(null);

        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrSbuktnin(4);

        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");

        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");

        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");

        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");

        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));

        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));

        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));

        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrStdrsknmkj("指定代理請求人名");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);

        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);

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
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100007");

        khSeikyuusyoBean.setIrKyknmkj("契約者名");

        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);

        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");

        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");

        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrSbuktnin(0);
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsknmkj("指定代理請求人名");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);

        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.HUYOU);

        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100008");

        khSeikyuusyoBean.setIrKyknmkj("契約者名");

        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYKSB);

        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");

        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");

        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrSbuktnin(4);

        khSeikyuusyoBean.setIrSbuktnmkj1("");

        khSeikyuusyoBean.setIrSbuktnmkj2("");

        khSeikyuusyoBean.setIrSbuktnmkj3("");

        khSeikyuusyoBean.setIrSbuktnmkj4("");

        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));

        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));

        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));

        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrStdrsknmkj("");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);

        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.HUYOU);

        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.HUYOU);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100009");

        khSeikyuusyoBean.setIrKyknmkj("契約者名");

        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);

        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");

        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");

        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);

        khSeikyuusyoBean.setIrSbuktnmkj1("");

        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");

        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");

        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");

        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwari1(null);

        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));

        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));

        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrStdrsknmkj("");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);

        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);

        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.HUYOU);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100010");

        khSeikyuusyoBean.setIrKyknmkj("契約者名");

        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);

        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");

        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");

        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);

        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");

        khSeikyuusyoBean.setIrSbuktnmkj2("");

        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");

        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");

        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));

        khSeikyuusyoBean.setIrSbubnwari2(null);

        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));

        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrStdrsknmkj("");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);

        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);

        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100011");

        khSeikyuusyoBean.setIrKyknmkj("契約者名");

        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);

        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");

        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");

        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);

        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");

        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");

        khSeikyuusyoBean.setIrSbuktnmkj3("");

        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");

        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));

        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));

        khSeikyuusyoBean.setIrSbubnwari3(null);

        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrStdrsknmkj("");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);

        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);

        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100012");

        khSeikyuusyoBean.setIrKyknmkj("契約者名");

        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);

        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");

        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");

        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);

        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");

        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");

        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");

        khSeikyuusyoBean.setIrSbuktnmkj4("");

        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));

        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));

        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));

        khSeikyuusyoBean.setIrSbubnwari4(null);
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrStdrsknmkj("");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);

        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);

        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("XXXXXXXXXXX");

        khSeikyuusyoBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);

        khSeikyuusyoBean.setIrTsinadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrTsinadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrTsinadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);

        khSeikyuusyoBean.setIrSbuktnmkj1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrSbuktnmkj2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrSbuktnmkj3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrSbuktnmkj4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(999));

        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(999));

        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(999));

        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(999));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HONNIN);

        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);

        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);

        khSeikyuusyoBean.setIrNkuktnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("XXXXXXXX");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("9999年99月99日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("99年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100002");

        khSeikyuusyoBean.setIrKyknmkj("契約者名");

        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KAISEIKAIMEI);

        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");

        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");

        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);

        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");

        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");

        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");

        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");

        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));

        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));

        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));

        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsknmkj("指定代理請求人名");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);

        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);

        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);

        khSeikyuusyoBean.setIrNkuktnm("年金受取人名");

        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("");

        khSeikyuusyoBean.setIrKyknmkj("");

        khSeikyuusyoBean.setIrHhknnmkj("");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);

        khSeikyuusyoBean.setIrTsinadr1kj("");

        khSeikyuusyoBean.setIrTsinadr2kj("");

        khSeikyuusyoBean.setIrTsinadr3kj("");

        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);

        khSeikyuusyoBean.setIrSbuktnmkj1("");

        khSeikyuusyoBean.setIrSbuktnmkj2("");

        khSeikyuusyoBean.setIrSbuktnmkj3("");

        khSeikyuusyoBean.setIrSbuktnmkj4("");

        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));

        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));

        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));

        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsknmkj(null);

        khSeikyuusyoBean.setIrStdruktkbn(C_UktKbn.SONOTA);
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);

        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);

        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);

        khSeikyuusyoBean.setIrNkuktnm("");

        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("");

        bzSksKaisyasiyouranBean.setIrHozonkkn("");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono(null);
        khSeikyuusyoBean.setIrKyknmkj(null);
        khSeikyuusyoBean.setIrHhknnmkj(null);
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        khSeikyuusyoBean.setIrTsinadr1kj(null);
        khSeikyuusyoBean.setIrTsinadr2kj(null);
        khSeikyuusyoBean.setIrTsinadr3kj(null);
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);
        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");
        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");
        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");
        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));
        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));
        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));
        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrStdrsknmkj("指定代理請求人名");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm(null);
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyanm(null);
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd(null);

        bzSksKaisyasiyouranBean.setIrHozonkkn(null);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100002");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KAISEIKAIMEI);
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");
        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);
        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");
        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");
        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");
        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));
        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));
        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));
        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsknmkj("指定代理請求人名");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("年金受取人名");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.NONE);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100002");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);
        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");
        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");
        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");
        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));
        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));
        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));
        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrStdrsknmkj("指定代理請求人名");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm(null);
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100002");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);
        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");
        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");
        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");
        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));
        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));
        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));
        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrStdrsknmkj("指定代理請求人名");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm(null);
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.NONE);
        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100002");

        khSeikyuusyoBean.setIrKyknmkj("契約者名");

        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KAISEIKAIMEI);

        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");

        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");

        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);

        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");

        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");

        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");

        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");

        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));

        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));

        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));

        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsknmkj("指定代理請求人名");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);

        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);

        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);

        khSeikyuusyoBean.setIrNkuktnm("年金受取人名");

        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testCreateReport21(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100002");

        khSeikyuusyoBean.setIrKyknmkj("契約者名");

        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KAISEIKAIMEI);

        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");

        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");

        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);

        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");

        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");

        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");

        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");

        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));

        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));

        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));

        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrStdrsknmkj("指定代理請求人名");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);

        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);

        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);

        khSeikyuusyoBean.setIrNkuktnm("年金受取人名");

        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.NONE);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testCreateReport22(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100002");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");
        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);
        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");
        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");
        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");
        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));
        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));
        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));
        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsknmkj("指定代理請求人名");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("年金受取人名");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("");
        khSeikyuusyoBean.setIrTrkkzknmkj2("");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testCreateReport23(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100002");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KAISEIKAIMEI);
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");
        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);
        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");
        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");
        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");
        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));
        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));
        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));
        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsknmkj("指定代理請求人名");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("年金受取人名");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("");
        khSeikyuusyoBean.setIrTrkkzknmkj2("");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testCreateReport24(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100002");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYKSB);
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");
        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);
        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");
        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");
        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");
        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));
        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));
        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));
        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsknmkj("");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("年金受取人名");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("");
        khSeikyuusyoBean.setIrTrkkzknmkj2("");
        khSeikyuusyoBean.setIrStdruktkbn(C_UktKbn.NASI);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testCreateReport25(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100002");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.SONOTA);
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");
        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);
        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");
        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");
        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");
        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));
        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));
        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));
        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsknmkj("");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("年金受取人名");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("田中太郎");
        khSeikyuusyoBean.setIrTrkkzknmkj2("");
        khSeikyuusyoBean.setIrStdruktkbn(C_UktKbn.NASI);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testCreateReport26(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100002");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.SONOTA);
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");
        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);
        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");
        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");
        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");
        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));
        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));
        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));
        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsknmkj(null);
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("年金受取人名");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("");
        khSeikyuusyoBean.setIrTrkkzknmkj2("田中次郎");
        khSeikyuusyoBean.setIrStdruktkbn(C_UktKbn.SONOTA);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testCreateReport27(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100002");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.SONOTA);
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");
        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);
        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");
        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");
        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");
        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));
        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));
        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));
        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrStdrsknmkj("指定代理請求人名");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("年金受取人名");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("田中太郎");
        khSeikyuusyoBean.setIrTrkkzknmkj2("田中次郎");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testCreateReport28(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100002");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.SONOTA);
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");
        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);
        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");
        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");
        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");
        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));
        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));
        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));
        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrStdrsknmkj("");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("年金受取人名");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTrkkzknmkj2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(290)
    @Transactional
    public void testCreateReport29(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100002");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");
        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);
        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");
        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");
        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");
        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));
        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));
        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));
        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsknmkj(null);
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("年金受取人名");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("");
        khSeikyuusyoBean.setIrTrkkzknmkj2("田中次郎");
        khSeikyuusyoBean.setIrStdruktkbn(C_UktKbn.SONOTA);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(300)
    @Transactional
    public void testCreateReport30(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100002");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");
        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);
        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");
        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");
        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");
        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));
        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));
        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));
        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrStdrsknmkj("指定代理請求人名");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("年金受取人名");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("田中太郎");
        khSeikyuusyoBean.setIrTrkkzknmkj2("田中次郎");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(310)
    @Transactional
    public void testCreateReport31(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100002");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");
        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrSibousuktumukbn1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSibousuktumukbn4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(4);
        khSeikyuusyoBean.setIrSbuktnmkj1("死亡受取人名１");
        khSeikyuusyoBean.setIrSbuktnmkj2("死亡受取人名２");
        khSeikyuusyoBean.setIrSbuktnmkj3("死亡受取人名３");
        khSeikyuusyoBean.setIrSbuktnmkj4("死亡受取人名４");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu2(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu3(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwariumu4(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(10));
        khSeikyuusyoBean.setIrSbubnwari2(BizNumber.valueOf(20));
        khSeikyuusyoBean.setIrSbubnwari3(BizNumber.valueOf(30));
        khSeikyuusyoBean.setIrSbubnwari4(BizNumber.valueOf(40));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrStdrsknmkj("");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("年金受取人名");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTrkkzknmkj2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(320)
    @Transactional
    public void testCreateReport32(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_meigihnk_sks", C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        khSeikyuusyoBean.setIrSyono("10808100003");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrHhknnmkj("被保険者名");
        khSeikyuusyoBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KAISEIKAIMEI);
        khSeikyuusyoBean.setIrTsinadr1kj("大阪市中央区");
        khSeikyuusyoBean.setIrTsinadr2kj("新栄町１－４－３４");
        khSeikyuusyoBean.setIrTsinadr3kj("ＡＢＣマンション");
        khSeikyuusyoBean.setIrSiboukyhkuktumukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbuktnin(6);
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HGU);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2018年 6月 6日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(330)
    @Transactional
    public void testCreateReport33(){

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
    @TestOrder(340)
    @Transactional
    public void testCreateReport34(){

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
        khSeikyuusyoBean.setIrSbuktnin(4);
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
    @TestOrder(350)
    @Transactional
    public void testCreateReport35(){

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
        khSeikyuusyoBean.setIrSbuktnin(4);
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
    @TestOrder(360)
    @Transactional
    public void testCreateReport36(){

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
        khSeikyuusyoBean.setIrSbuktnin(4);
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
    @TestOrder(370)
    @Transactional
    public void testCreateReport37(){

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
        khSeikyuusyoBean.setIrSbuktnin(4);
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
        khSeikyuusyoBean.setIrTrkkzknmkj1("");
        khSeikyuusyoBean.setIrTrkkzknmkj2("");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2020年 4月 1日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("保存永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(380)
    @Transactional
    public void testCreateReport38(){

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
        khSeikyuusyoBean.setIrSbuktnin(4);
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
        khSeikyuusyoBean.setIrTrkkzknmkj2("");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2020年 4月 1日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("保存永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(390)
    @Transactional
    public void testCreateReport39(){

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
        khSeikyuusyoBean.setIrSbuktnin(4);
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
        khSeikyuusyoBean.setIrTrkkzknmkj1("");
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
    @TestOrder(400)
    @Transactional
    public void testCreateReport40(){

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
        khSeikyuusyoBean.setIrSbuktnin(4);
        khSeikyuusyoBean.setIrSbuktnmkj1("住生太郎");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(100));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsknmkj("住生太郎");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HONNIN);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("住生太郎");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("");
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
    @TestOrder(410)
    @Transactional
    public void testCreateReport41(){

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
        khSeikyuusyoBean.setIrSbuktnin(4);
        khSeikyuusyoBean.setIrSbuktnmkj1("住生太郎");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(100));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsknmkj("住生太郎");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HONNIN);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("住生太郎");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("住生一郎");
        khSeikyuusyoBean.setIrTrkkzknmkj2("");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2020年 4月 1日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("保存永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(420)
    @Transactional
    public void testCreateReport42(){

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
        khSeikyuusyoBean.setIrSbuktnin(4);
        khSeikyuusyoBean.setIrSbuktnmkj1("住生太郎");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(100));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsknmkj("住生太郎");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HONNIN);
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
    @TestOrder(430)
    @Transactional
    public void testCreateReport43(){

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
        khSeikyuusyoBean.setIrSbuktnin(4);
        khSeikyuusyoBean.setIrSbuktnmkj1("住生太郎");
        khSeikyuusyoBean.setIrSbubnwariumu1(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrSbubnwari1(BizNumber.valueOf(100));
        khSeikyuusyoBean.setIrStdrsktkyhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsktkyuuktmukbn(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrStdrsknmkj("住生太郎");
        khSeikyuusyoBean.setIrKkkyktdk(C_Tdk.HONNIN);
        khSeikyuusyoBean.setIrAeoikakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrFatcakakuninyhkbn(C_YouhiblnkKbn.YOU);
        khSeikyuusyoBean.setIrNkuktnm("住生太郎");
        khSeikyuusyoBean.setIrNkhknumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        khSeikyuusyoBean.setIrTrkkzknmkj1("");
        khSeikyuusyoBean.setIrTrkkzknmkj2("");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2020年 4月 1日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("保存永久");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
