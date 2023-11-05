package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.biz.bean.report.BzSksKaisyasiyouranBean;
import yuyu.def.classification.C_GengkhouKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.bean.report.KhSeikyuusyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 減額請求書テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class KhGengakuSksTest extends AbstractTest {

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
            createReport.createNewReportServiceBean("hozen", "", "KhSeikyuusyo", C_SyoruiCdKbn.KK_GENGAKU_SKS);
        khSeikyuusyoBean.setIrSyono("wwwwwwwwwww");
        khSeikyuusyoBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinyno("wwwwwww");
        khSeikyuusyoBean.setIrTsintelno("wwwwwwwwwwwwww");
        khSeikyuusyoBean.setIrTsinadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(9999999999.99));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(9999999999.99));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(9999999999.99));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(9999999999.99));
        khSeikyuusyoBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.SD);
        khSeikyuusyoBean.setIrKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("wwwwwwww");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 99年");


        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSeikyuusyo", C_SyoruiCdKbn.KK_GENGAKU_SKS);
        khSeikyuusyoBean.setIrSyono("10000000001");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(500));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(200));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(400));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(100));
        khSeikyuusyoBean.setIrBanknmkj("保険料振替口座銀行名");
        khSeikyuusyoBean.setIrKzmeiginmkn("保険料振替口座名義人氏名");
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.SD);
        khSeikyuusyoBean.setIrKykjyoutai(C_Kykjyoutai.ZENNOU);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSeikyuusyo", C_SyoruiCdKbn.KK_GENGAKU_SKS);
        khSeikyuusyoBean.setIrSyono("");
        khSeikyuusyoBean.setIrKyknmkj("");
        khSeikyuusyoBean.setIrTsinyno("");
        khSeikyuusyoBean.setIrTsintelno("");
        khSeikyuusyoBean.setIrTsinadr1kj("");
        khSeikyuusyoBean.setIrTsinadr2kj("");
        khSeikyuusyoBean.setIrTsinadr3kj("");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrBanknmkj("");
        khSeikyuusyoBean.setIrKzmeiginmkn("");
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.SD);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("");
        bzSksKaisyasiyouranBean.setIrHozonkkn("");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSeikyuusyo", C_SyoruiCdKbn.KK_GENGAKU_SKS);
        khSeikyuusyoBean.setIrSyono(null);
        khSeikyuusyoBean.setIrKyknmkj(null);
        khSeikyuusyoBean.setIrTsinyno(null);
        khSeikyuusyoBean.setIrTsintelno(null);
        khSeikyuusyoBean.setIrTsinadr1kj(null);
        khSeikyuusyoBean.setIrTsinadr2kj(null);
        khSeikyuusyoBean.setIrTsinadr3kj(null);
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterp(null);
        khSeikyuusyoBean.setIrBanknmkj(null);
        khSeikyuusyoBean.setIrKzmeiginmkn(null);
        khSeikyuusyoBean.setIrKyktuukasyu(null);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.SD);
        khSeikyuusyoBean.setIrAfterkijyunkingaku(null);
        khSeikyuusyoBean.setIrHrkp(null);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);
        khSeikyuusyoBean.setIrSyouhnhanteikekka(SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyanm(null);
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd(null);
        bzSksKaisyasiyouranBean.setIrHozonkkn(null);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSeikyuusyo", C_SyoruiCdKbn.KK_GENGAKU_SKS);
        khSeikyuusyoBean.setIrSyono("wwwwwwwwwww");
        khSeikyuusyoBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinyno("wwwwwww");
        khSeikyuusyoBean.setIrTsintelno("wwwwwwwwwwwwww");
        khSeikyuusyoBean.setIrTsinadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTsinadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(9999999999.99));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(9999999999.99));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(9999999999.99));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(9999999999.99));
        khSeikyuusyoBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);
        khSeikyuusyoBean.setIrKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("wwwwwwww");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 99年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSeikyuusyo", C_SyoruiCdKbn.KK_GENGAKU_SKS);
        khSeikyuusyoBean.setIrSyono("10000000001");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(600));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(300));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(400));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(100));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSeikyuusyo", C_SyoruiCdKbn.KK_GENGAKU_SKS);
        khSeikyuusyoBean.setIrSyono(null);
        khSeikyuusyoBean.setIrKyknmkj(null);
        khSeikyuusyoBean.setIrTsinyno(null);
        khSeikyuusyoBean.setIrTsintelno(null);
        khSeikyuusyoBean.setIrTsinadr1kj(null);
        khSeikyuusyoBean.setIrTsinadr2kj(null);
        khSeikyuusyoBean.setIrTsinadr3kj(null);
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);
        khSeikyuusyoBean.setIrKykjyoutai(C_Kykjyoutai.ITIJIBARAI);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyanm(null);
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd(null);
        bzSksKaisyasiyouranBean.setIrHozonkkn(null);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSeikyuusyo", C_SyoruiCdKbn.KK_GENGAKU_SKS);
        khSeikyuusyoBean.setIrSyono(null);
        khSeikyuusyoBean.setIrKyknmkj(null);
        khSeikyuusyoBean.setIrTsinyno(null);
        khSeikyuusyoBean.setIrTsintelno(null);
        khSeikyuusyoBean.setIrTsinadr1kj(null);
        khSeikyuusyoBean.setIrTsinadr2kj(null);
        khSeikyuusyoBean.setIrTsinadr3kj(null);
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(999));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(999));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(999));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(999));
        khSeikyuusyoBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.SD);
        khSeikyuusyoBean.setIrKykjyoutai(C_Kykjyoutai.ITIJIBARAI);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyanm(null);
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd(null);
        bzSksKaisyasiyouranBean.setIrHozonkkn(null);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSeikyuusyo", C_SyoruiCdKbn.KK_GENGAKU_SKS);
        khSeikyuusyoBean.setIrSyono(null);
        khSeikyuusyoBean.setIrKyknmkj(null);
        khSeikyuusyoBean.setIrTsinyno(null);
        khSeikyuusyoBean.setIrTsintelno(null);
        khSeikyuusyoBean.setIrTsinadr1kj(null);
        khSeikyuusyoBean.setIrTsinadr2kj(null);
        khSeikyuusyoBean.setIrTsinadr3kj(null);
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(9999));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(9999));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(9999));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(9999));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.SD);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyanm(null);
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd(null);
        bzSksKaisyasiyouranBean.setIrHozonkkn(null);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSeikyuusyo", C_SyoruiCdKbn.KK_GENGAKU_SKS);
        khSeikyuusyoBean.setIrSyono(null);
        khSeikyuusyoBean.setIrKyknmkj(null);
        khSeikyuusyoBean.setIrTsinyno(null);
        khSeikyuusyoBean.setIrTsintelno(null);
        khSeikyuusyoBean.setIrTsinadr1kj(null);
        khSeikyuusyoBean.setIrTsinadr2kj(null);
        khSeikyuusyoBean.setIrTsinadr3kj(null);
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(9.1));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(9.1));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(9.1));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(9.1));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.SD);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.DANTAI);

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
    public void testCreateReport11(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSeikyuusyo", C_SyoruiCdKbn.KK_GENGAKU_SKS);
        khSeikyuusyoBean.setIrSyono(null);
        khSeikyuusyoBean.setIrKyknmkj(null);
        khSeikyuusyoBean.setIrTsinyno(null);
        khSeikyuusyoBean.setIrTsintelno(null);
        khSeikyuusyoBean.setIrTsinadr1kj(null);
        khSeikyuusyoBean.setIrTsinadr2kj(null);
        khSeikyuusyoBean.setIrTsinadr3kj(null);
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(9.22));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(9.22));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(9.22));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(9.22));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.SD);
        khSeikyuusyoBean.setIrAfterkijyunkingaku(BizCurrency.valueOf(999));
        khSeikyuusyoBean.setIrHrkp(BizCurrency.valueOf(999));
        khSeikyuusyoBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyanm(null);
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd(null);
        bzSksKaisyasiyouranBean.setIrHozonkkn(null);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSeikyuusyo", C_SyoruiCdKbn.KK_GENGAKU_SKS);
        khSeikyuusyoBean.setIrSyono(null);
        khSeikyuusyoBean.setIrKyknmkj(null);
        khSeikyuusyoBean.setIrTsinyno(null);
        khSeikyuusyoBean.setIrTsintelno(null);
        khSeikyuusyoBean.setIrTsinadr1kj(null);
        khSeikyuusyoBean.setIrTsinadr2kj(null);
        khSeikyuusyoBean.setIrTsinadr3kj(null);
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(9.333));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(9.333));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(9.333));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(9.333));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.SD);
        khSeikyuusyoBean.setIrAfterkijyunkingaku(BizCurrency.valueOf(999));
        khSeikyuusyoBean.setIrHrkp(BizCurrency.valueOf(999));
        khSeikyuusyoBean.setIrSyouhnhanteikekka(SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyanm(null);
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd(null);
        bzSksKaisyasiyouranBean.setIrHozonkkn(null);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSeikyuusyo", C_SyoruiCdKbn.KK_GENGAKU_SKS);
        khSeikyuusyoBean.setIrSyono(null);
        khSeikyuusyoBean.setIrKyknmkj(null);
        khSeikyuusyoBean.setIrTsinyno(null);
        khSeikyuusyoBean.setIrTsintelno(null);
        khSeikyuusyoBean.setIrTsinadr1kj(null);
        khSeikyuusyoBean.setIrTsinadr2kj(null);
        khSeikyuusyoBean.setIrTsinadr3kj(null);
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(999));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(999));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(999));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(999));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyanm(null);
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd(null);
        bzSksKaisyasiyouranBean.setIrHozonkkn(null);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSeikyuusyo", C_SyoruiCdKbn.KK_GENGAKU_SKS);
        khSeikyuusyoBean.setIrSyono(null);
        khSeikyuusyoBean.setIrKyknmkj(null);
        khSeikyuusyoBean.setIrTsinyno(null);
        khSeikyuusyoBean.setIrTsintelno(null);
        khSeikyuusyoBean.setIrTsinadr1kj(null);
        khSeikyuusyoBean.setIrTsinadr2kj(null);
        khSeikyuusyoBean.setIrTsinadr3kj(null);
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(9999));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(9999));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(9999));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(9999));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.NONE);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyanm(null);
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd(null);
        bzSksKaisyasiyouranBean.setIrHozonkkn(null);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSeikyuusyo", C_SyoruiCdKbn.KK_GENGAKU_SKS);
        khSeikyuusyoBean.setIrSyono(null);
        khSeikyuusyoBean.setIrKyknmkj(null);
        khSeikyuusyoBean.setIrTsinyno(null);
        khSeikyuusyoBean.setIrTsintelno(null);
        khSeikyuusyoBean.setIrTsinadr1kj(null);
        khSeikyuusyoBean.setIrTsinadr2kj(null);
        khSeikyuusyoBean.setIrTsinadr3kj(null);
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(9.1));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(9.1));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(9.1));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(9.1));
        khSeikyuusyoBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);
        khSeikyuusyoBean.setIrKykjyoutai(C_Kykjyoutai.ZENNOU);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyanm(null);
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd(null);
        bzSksKaisyasiyouranBean.setIrHozonkkn(null);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSeikyuusyo", C_SyoruiCdKbn.KK_GENGAKU_SKS);
        khSeikyuusyoBean.setIrSyono(null);
        khSeikyuusyoBean.setIrKyknmkj(null);
        khSeikyuusyoBean.setIrTsinyno(null);
        khSeikyuusyoBean.setIrTsintelno(null);
        khSeikyuusyoBean.setIrTsinadr1kj(null);
        khSeikyuusyoBean.setIrTsinadr2kj(null);
        khSeikyuusyoBean.setIrTsinadr3kj(null);
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(9.22));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(9.22));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(9.22));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(9.22));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);

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
            createReport.createNewReportServiceBean("hozen", "", "KhSeikyuusyo", C_SyoruiCdKbn.KK_GENGAKU_SKS);
        khSeikyuusyoBean.setIrSyono(null);
        khSeikyuusyoBean.setIrKyknmkj(null);
        khSeikyuusyoBean.setIrTsinyno(null);
        khSeikyuusyoBean.setIrTsintelno(null);
        khSeikyuusyoBean.setIrTsinadr1kj(null);
        khSeikyuusyoBean.setIrTsinadr2kj(null);
        khSeikyuusyoBean.setIrTsinadr3kj(null);
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(9.333));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(9.333));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(9.333));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(9.333));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd(null);
        bzSksKaisyasiyouranBean.setIrToritsugisyanm(null);
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd(null);
        bzSksKaisyasiyouranBean.setIrHozonkkn(null);

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(600));
        khSeikyuusyoBean.setIrAfterkihons(null);
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(400));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(100));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.SD);
        khSeikyuusyoBean.setIrKyktuukasyu(null);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(600));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(400));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(100));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.SD);
        khSeikyuusyoBean.setIrKihonssyurui("");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(600));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(400));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(100));
        khSeikyuusyoBean.setIrBanknmkj("保険料振替口座銀行名");
        khSeikyuusyoBean.setIrKzmeiginmkn("保険料振替口座名義人氏名");
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.SD);
        khSeikyuusyoBean.setIrKihonssyurui("通算限度");
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.NONE);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testCreateReport21(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(600));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.DOLLAR));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(400));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(100));
        khSeikyuusyoBean.setIrBanknmkj("保険料振替口座銀行名");
        khSeikyuusyoBean.setIrKzmeiginmkn("保険料振替口座名義人氏名");
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.SD);
        khSeikyuusyoBean.setIrKihonssyurui("ＷＷＷＷＷＷＷＷＷＷ");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testCreateReport22(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(600));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(300));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(400));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(100));
        khSeikyuusyoBean.setIrBanknmkj("保険料振替口座銀行名");
        khSeikyuusyoBean.setIrKzmeiginmkn("保険料振替口座名義人氏名");
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.SD);
        khSeikyuusyoBean.setIrKihonssyurui("通算限度");
        khSeikyuusyoBean.setIrAfterkijyunkingaku(BizCurrency.valueOf(301));
        khSeikyuusyoBean.setIrHrkp(BizCurrency.valueOf(302));
        khSeikyuusyoBean.setIrSyouhnhanteikekka(SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testCreateReport23(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(600));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(300));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(400));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(100));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);
        khSeikyuusyoBean.setIrKihonssyurui("通算限度");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(240)
    @Transactional
    public void testCreateReport24(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.SD);
        khSeikyuusyoBean.setIrKihonssyurui("通算限度");
        khSeikyuusyoBean.setIrAfterkijyunkingaku(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrHrkp(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrSyouhnhanteikekka(SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(250)
    @Transactional
    public void testCreateReport25(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(999));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrBanknmkj("保険料振替口座銀行名");
        khSeikyuusyoBean.setIrKzmeiginmkn("保険料振替口座名義人氏名");
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.SD);
        khSeikyuusyoBean.setIrKihonssyurui("通算限度");
        khSeikyuusyoBean.setIrAfterkijyunkingaku(BizCurrency.valueOf(999));
        khSeikyuusyoBean.setIrHrkp(BizCurrency.valueOf(999));
        khSeikyuusyoBean.setIrSyouhnhanteikekka(SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testCreateReport26(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(9999));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.SD);
        khSeikyuusyoBean.setIrKihonssyurui("通算限度");
        khSeikyuusyoBean.setIrAfterkijyunkingaku(BizCurrency.valueOf(9999));
        khSeikyuusyoBean.setIrHrkp(BizCurrency.valueOf(9999));
        khSeikyuusyoBean.setIrSyouhnhanteikekka(SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testCreateReport27(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(9999999999L));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.SD);
        khSeikyuusyoBean.setIrKihonssyurui("通算限度");
        khSeikyuusyoBean.setIrAfterkijyunkingaku(BizCurrency.valueOf(9999999999L));
        khSeikyuusyoBean.setIrHrkp(BizCurrency.valueOf(9999999999L));
        khSeikyuusyoBean.setIrSyouhnhanteikekka(SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testCreateReport28(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(500));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(100));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);
        khSeikyuusyoBean.setIrKihonssyurui("通算限度");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(290)
    @Transactional
    public void testCreateReport29(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);
        khSeikyuusyoBean.setIrKihonssyurui("通算限度");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(300)
    @Transactional
    public void testCreateReport30(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(999));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(999));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);
        khSeikyuusyoBean.setIrSyouhnhanteikekka(SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN);
        khSeikyuusyoBean.setIrKihonssyurui("通算限度");
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);
        khSeikyuusyoBean.setIrSaikensetumu(C_UmuKbn.NONE);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(310)
    @Transactional
    public void testCreateReport31(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(9999));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(9999));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);
        khSeikyuusyoBean.setIrSyouhnhanteikekka(SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN);
        khSeikyuusyoBean.setIrKihonssyurui("通算限度");
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);
        khSeikyuusyoBean.setIrSaikensetumu(C_UmuKbn.ARI);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(320)
    @Transactional
    public void testCreateReport32(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(9999999999L));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(9999999999L));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);
        khSeikyuusyoBean.setIrSyouhnhanteikekka(SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN);
        khSeikyuusyoBean.setIrKihonssyurui("通算限度");
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.DANTAI);
        khSeikyuusyoBean.setIrSaikensetumu(C_UmuKbn.ARI);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(330)
    @Transactional
    public void testCreateReport33(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(600));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(300));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(400));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(100));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);
        khSeikyuusyoBean.setIrSaikensetumu(C_UmuKbn.NONE);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(340)
    @Transactional
    public void testCreateReport34(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(600));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(300));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(400));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(100));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);
        khSeikyuusyoBean.setIrSaikensetumu(C_UmuKbn.ARI);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(350)
    @Transactional
    public void testCreateReport35(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(600));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(300));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(400));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(100));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.DANTAI);
        khSeikyuusyoBean.setIrSaikensetumu(C_UmuKbn.NONE);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(360)
    @Transactional
    public void testCreateReport36(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(600));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(300));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(400));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(100));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);
        khSeikyuusyoBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.NONE);
        khSeikyuusyoBean.setIrHrkkeiro(C_Hrkkeiro.DANTAI);
        khSeikyuusyoBean.setIrSaikensetumu(C_UmuKbn.ARI);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(370)
    @Transactional
    public void testCreateReport37(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrKyktuukasyu(null);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);
        khSeikyuusyoBean.setIrSyouhnhanteikekka(SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN);
        khSeikyuusyoBean.setIrKihonssyurui(null);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(380)
    @Transactional
    public void testCreateReport38(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(9999999999L));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(9999999999L));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.SD);
        khSeikyuusyoBean.setIrSyouhnhanteikekka(SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN);
        khSeikyuusyoBean.setIrKihonssyurui("通算限度");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(390)
    @Transactional
    public void testCreateReport39(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(200));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(100));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);
        khSeikyuusyoBean.setIrSyouhnhanteikekka(SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN);
        khSeikyuusyoBean.setIrKihonssyurui("");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(400)
    @Transactional
    public void testCreateReport40(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(9999999999.99));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(9999999999.99));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);
        khSeikyuusyoBean.setIrSyouhnhanteikekka(SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN);
        khSeikyuusyoBean.setIrKihonssyurui("ＷＷＷＷＷＷＷＷＷＷ");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(410)
    @Transactional
    public void testCreateReport41(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_gengaku_sks", C_SyoruiCdKbn.KK_GENGAKU_SKS);

        khSeikyuusyoBean.setIrSyono("17806000013");
        khSeikyuusyoBean.setIrKyknmkj("契約者名");
        khSeikyuusyoBean.setIrTsinyno("1234567");
        khSeikyuusyoBean.setIrTsintelno("98765432101234");
        khSeikyuusyoBean.setIrTsinadr1kj("通信先住所１（漢字）");
        khSeikyuusyoBean.setIrTsinadr2kj("通信先住所２（漢字）");
        khSeikyuusyoBean.setIrTsinadr3kj("通信先住所３（漢字）");
        khSeikyuusyoBean.setIrBeforekihons(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterkihons(BizCurrency.valueOf(9999999999L));
        khSeikyuusyoBean.setIrBeforep(BizCurrency.valueOf(0));
        khSeikyuusyoBean.setIrAfterp(BizCurrency.valueOf(9999999999L));
        khSeikyuusyoBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSeikyuusyoBean.setIrGengkhoukbn(C_GengkhouKbn.PD);
        khSeikyuusyoBean.setIrSyouhnhanteikekka(SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN);
        khSeikyuusyoBean.setIrKihonssyurui("通算限度");

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");
        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("平成26年12月 8日");
        bzSksKaisyasiyouranBean.setIrHozonkkn("　消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
