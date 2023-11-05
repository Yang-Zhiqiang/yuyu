package yuyu.report.sinkeiyaku;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SkMiseirijiyuuKrksyuukeiBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 未整理事由別仮受金集計表帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkMiseiriJiyuuKrkSyuukeiTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkMiseirijiyuuKrksyuukeiBean skMiseirijiyuuKrksyuukeiBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki(null);
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd(null);
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(99);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo(null);
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm(null);
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(1001, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(1002, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(1003, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(1004, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(1005, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(1006, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(1111);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(1112);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(1113);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(1114);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(1115);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(1116);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(2001, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(2002, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(2003, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(2004, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(2111);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(2112);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(2113);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(2114);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(3001, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(3002, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(3003, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(3004, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(3005, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(3111);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(3112);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(3113);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(3114);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(3115);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(4001, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(4002, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(4111);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(4112);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(5001, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(5002, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(5003, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(5004, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(5111);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(5112);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(5113);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(5114);
        skMiseirijiyuuKrksyuukeiBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("ＷＷ99ＷＷ");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("ＷＷＷＷＷ");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(999999);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(999999);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(999999);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(999999);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(999999);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(9999999999999L));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(9999999999999L));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(9999999999999L));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(9999999999999L));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(999);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(999);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(999);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(999);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(999);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(999);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(999);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(999);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(999);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(999);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(999);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(999);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(9999);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(9999);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(9999);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(9999);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(9999);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(1117);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(2115);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(3116);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(4113);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(5115);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(999999999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(999999999);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(999999999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(999999999);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(999999999);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(999);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(999);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(999);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(0));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(6111);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(9.1));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(9.1));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(9.1));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(9.1));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(9.1));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(999999999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(9.22));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(9.22));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(9.22));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(9.22));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(9.22));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(9.333));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(9.333));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(9.333));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(9.333));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(9.333));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(9999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(9999));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(9999));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(9999));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(9999));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(9999));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(1007, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(2005, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(3006, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(4003, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(5005, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(999999999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(999999999);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(999999999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(999999999);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(999999999);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(999999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(999999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(999999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(999999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(999999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(0));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testCreateReport21(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testCreateReport22(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(0));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testCreateReport23(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(0));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testCreateReport24(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(0));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testCreateReport25(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(0));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testCreateReport26(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(6001, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testCreateReport27(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(999999999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(999999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(0));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testCreateReport28(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(290)
    @Transactional
    public void testCreateReport29(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(300)
    @Transactional
    public void testCreateReport30(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(310)
    @Transactional
    public void testCreateReport31(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(320)
    @Transactional
    public void testCreateReport32(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("豪ドル");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(330)
    @Transactional
    public void testCreateReport33(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(9.1));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(0));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(340)
    @Transactional
    public void testCreateReport34(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(9.22));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(0));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(350)
    @Transactional
    public void testCreateReport35(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(9.333));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(0));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(360)
    @Transactional
    public void testCreateReport36(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(9999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(0));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(370)
    @Transactional
    public void testCreateReport37(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(1001));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(1002));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(1003));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(1004));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(1005));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(1006));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(1111);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(1112);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(1113);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(1114);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(1115);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(1116);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(2001));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(2002));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(2003));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(2004));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(2111);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(2112);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(2113);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(2114);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(3001));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(3002));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(3003));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(3004));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(3005));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(3111);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(3112);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(3113);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(3114);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(3115);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(4001));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(4002));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(4111);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(4112);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(5001));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(5002));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(5003));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(5004));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(5111);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(5112);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(5113);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(5114);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(6001));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(6002));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(6003));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(6004));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(6005));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(6006));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(7001));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(7002));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(7003));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(7004));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(8001));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(8002));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(8003));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(8004));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(8005));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(9001));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(9002));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(9101));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(9102));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(9103));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(9104));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(380)
    @Transactional
    public void testCreateReport38(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(999);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(999);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(999);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(999);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(999);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(999);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(999);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(999);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(999);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(999);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(999);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(999);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(999));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(999));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(999));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(999));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(999));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(390)
    @Transactional
    public void testCreateReport39(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("ＷＷ99ＷＷ");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("ＷＷＷＷＷ");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(999999);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(999999);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(999999);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(999999);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(9999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(999999);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(999999);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(9999999999999L));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(9999999999999L));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(9999999999999L));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(9999999999999L));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(9999999999999L));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(400)
    @Transactional
    public void testCreateReport40(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(0));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(410)
    @Transactional
    public void testCreateReport41(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(999999999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(999999999);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(999999999);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(999999999);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(999999999);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(999999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(999999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(999999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(999999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(999999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(0));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(420)
    @Transactional
    public void testCreateReport42(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(999));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(0));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(430)
    @Transactional
    public void testCreateReport43(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("決算");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(9999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(999999999);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(0);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(0);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(0);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(0);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(0);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(0);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(0);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(0);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(0);

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknsyen(BizCurrency.valueOf(999999999999999L));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmryen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbariyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsydkhktyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirtyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkkjstyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjksydksmkyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihbyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthuketyyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKtknkgsimihknkyksykityyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetcyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirtyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirtyen(BizCurrency.valueOf(0));

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenkyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrksyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkikyen(BizCurrency.valueOf(0));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskjyen(BizCurrency.valueOf(0));

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(440)
    @Transactional
    public void testCreateReport44(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkMiseiriJiyuuKrkSyuukeiTest", C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI_YENDT);

        skMiseirijiyuuKrksyuukeiBean.setIrAtesaki("代理店契約室　御中");
        skMiseirijiyuuKrksyuukeiBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skMiseirijiyuuKrksyuukeiBean.setIrPageno(1);
        skMiseirijiyuuKrksyuukeiBean.setIrNendo("平成26年度");
        skMiseirijiyuuKrksyuukeiBean.setIrShnknm("第３四半期");
        skMiseirijiyuuKrksyuukeiBean.setIrNyukintuuka("円");

        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkmskseikirnrknrknasi(BizCurrency.valueOf(1001));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkskktnrkmr(BizCurrency.valueOf(1002));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgksisyaketmr(BizCurrency.valueOf(1003));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkhnkmhbari(BizCurrency.valueOf(1004));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgkkethhbari(BizCurrency.valueOf(1005));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrgketc(BizCurrency.valueOf(1006));
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuumskskrnrknrkns(1111);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuskktnrkmr(1112);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuusisyaketmr(1113);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukhnkmhbari(1114);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuukethhbari(1115);
        skMiseirijiyuuKrksyuukeiBean.setIrMsrkensuuetc(1116);

        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgketsyadkhketty(BizCurrency.valueOf(2001));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgsisnirty(BizCurrency.valueOf(2002));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykghnsskykkakjsty(BizCurrency.valueOf(2003));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykgtkbtjknsydksmk(BizCurrency.valueOf(2004));
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuktsydkhktty(2111);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensusisnirty(2112);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensuhnsskykkakjs(2113);
        skMiseirijiyuuKrksyuukeiBean.setIrDkhkttykensutkbtjknsydks(2114);

        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgnyknniyuhb(BizCurrency.valueOf(3001));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsyrihb(BizCurrency.valueOf(3002));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsirthukety(BizCurrency.valueOf(3003));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgsimihknkyksykity(BizCurrency.valueOf(3004));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankgetc(BizCurrency.valueOf(3005));
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuunyknniyuhb(3111);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusyrihb(3112);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusirthukety(3113);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuusihkyksykity(3114);
        skMiseirijiyuuKrksyuukeiBean.setIrKetkankenuuetc(3115);

        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgmsirt(BizCurrency.valueOf(4001));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkgsirt(BizCurrency.valueOf(4002));
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuumsirt(4111);
        skMiseirijiyuuKrksyuukeiBean.setIrSknnkisyknndkensuusirt(4112);

        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmawsenk(BizCurrency.valueOf(5001));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgmskmtrks(BizCurrency.valueOf(5002));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgykkknkik(BizCurrency.valueOf(5003));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkgnyknskj(BizCurrency.valueOf(5004));
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumawsenk(5111);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuumskmtrks(5112);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkkensuukkknkik(5113);
        skMiseirijiyuuKrksyuukeiBean.setIrHsirtkensuunyknskj(5114);
        skMiseirijiyuuKrksyuukeiBean.setIrSyoruicd(C_SyoruiCdKbn.SK_MSRJIYUUBETUKARIUKEKINSYUUKEI_YENDT);

        reportTestBean.addParamObjects(skMiseirijiyuuKrksyuukeiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}