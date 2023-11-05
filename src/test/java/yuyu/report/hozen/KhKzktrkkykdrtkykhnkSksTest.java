package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzSksKaisyasiyouranBean;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.bean.report.KhSeikyuusyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 家族登録・契約者代理特約変更請求書帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhKzktrkkykdrtkykhnkSksTest {

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
            createReport.createNewReportServiceBean("hozen", "", "kh_kzktrkkykdrtkykhnk_sks", C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("");
        khSeikyuusyoBean.setIrTsinyno("");
        khSeikyuusyoBean.setIrTsintelno("");

        khSeikyuusyoBean.setIrTsinadr1kj("");

        khSeikyuusyoBean.setIrTsinadr2kj("");

        khSeikyuusyoBean.setIrTsinadr3kj("");

        khSeikyuusyoBean.setIrTrkkzknmkj1("");

        khSeikyuusyoBean.setIrTrkkzkadr1kj1("");

        khSeikyuusyoBean.setIrTrkkzkadr2kj1("");

        khSeikyuusyoBean.setIrTrkkzkadr3kj1("");

        khSeikyuusyoBean.setIrTrkkzknmkj2("");

        khSeikyuusyoBean.setIrTrkkzkadr1kj2("");

        khSeikyuusyoBean.setIrTrkkzkadr2kj2("");

        khSeikyuusyoBean.setIrTrkkzkadr3kj2("");

        khSeikyuusyoBean.setIrKykdairinmkj("");
        khSeikyuusyoBean.setIrTyouhyoutitle("");

        khSeikyuusyoBean.setIrSouhuannaimsg1("");

        khSeikyuusyoBean.setIrSouhuannaimsg2("");

        khSeikyuusyoBean.setIrSouhuannaimsg3("");

        khSeikyuusyoBean.setIrSouhuannaimsg4("");

        khSeikyuusyoBean.setIrSouhuannaimsg5("");

        khSeikyuusyoBean.setIrTrkkzktelno1("");

        khSeikyuusyoBean.setIrTrkkzktelno2("");
        khSeikyuusyoBean.setIrKykdrtkykhukaumu(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrMousideninkbn(C_MousideninKbn.KYKHONNIN);

        khSeikyuusyoBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);

        khSeikyuusyoBean.setIrStdruktkbn(C_UktKbn.BLNK);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi1(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi2(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrKykdrkbn(C_UktKbn.BLNK);

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
            createReport.createNewReportServiceBean("hozen", "", "kh_kzktrkkykdrtkykhnk_sks", C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS);

        khSeikyuusyoBean.setIrSyono(null);
        khSeikyuusyoBean.setIrTsinyno(null);
        khSeikyuusyoBean.setIrTsintelno(null);

        khSeikyuusyoBean.setIrTsinadr1kj(null);

        khSeikyuusyoBean.setIrTsinadr2kj(null);

        khSeikyuusyoBean.setIrTsinadr3kj(null);

        khSeikyuusyoBean.setIrTrkkzknmkj1(null);

        khSeikyuusyoBean.setIrTrkkzkadr1kj1(null);

        khSeikyuusyoBean.setIrTrkkzkadr2kj1(null);

        khSeikyuusyoBean.setIrTrkkzkadr3kj1(null);

        khSeikyuusyoBean.setIrTrkkzknmkj2(null);

        khSeikyuusyoBean.setIrTrkkzkadr1kj2(null);

        khSeikyuusyoBean.setIrTrkkzkadr2kj2(null);

        khSeikyuusyoBean.setIrTrkkzkadr3kj2(null);

        khSeikyuusyoBean.setIrKykdairinmkj(null);
        khSeikyuusyoBean.setIrTyouhyoutitle(null);

        khSeikyuusyoBean.setIrSouhuannaimsg1(null);

        khSeikyuusyoBean.setIrSouhuannaimsg2(null);

        khSeikyuusyoBean.setIrSouhuannaimsg3(null);

        khSeikyuusyoBean.setIrSouhuannaimsg4(null);

        khSeikyuusyoBean.setIrSouhuannaimsg5(null);

        khSeikyuusyoBean.setIrTrkkzktelno1(null);

        khSeikyuusyoBean.setIrTrkkzktelno2(null);
        khSeikyuusyoBean.setIrKykdrtkykhukaumu(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrMousideninkbn(C_MousideninKbn.KYKHONNIN);

        khSeikyuusyoBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);

        khSeikyuusyoBean.setIrStdruktkbn(C_UktKbn.BLNK);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi1(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi2(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrKykdrkbn(null);

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
            createReport.createNewReportServiceBean("hozen", "", "kh_kzktrkkykdrtkykhnk_sks", C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");

        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");

        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");

        khSeikyuusyoBean.setIrTsinadr3kj("新宿市１ー２ー２２");

        khSeikyuusyoBean.setIrTrkkzknmkj1("住生一郎　様");

        khSeikyuusyoBean.setIrTrkkzkadr1kj1("㋐ｂ１２４３％");

        khSeikyuusyoBean.setIrTrkkzkadr2kj1("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTrkkzkadr3kj1("ＡＢＣマンション");

        khSeikyuusyoBean.setIrTrkkzknmkj2("住生二郎　様");

        khSeikyuusyoBean.setIrTrkkzkadr1kj2("大阪市中央区");

        khSeikyuusyoBean.setIrTrkkzkadr2kj2("新栄町２－５－４５");

        khSeikyuusyoBean.setIrTrkkzkadr3kj2("ＡＢＣマンション");

        khSeikyuusyoBean.setIrKykdairinmkj("住生太郎　様");
        khSeikyuusyoBean.setIrTyouhyoutitle("ご家族登録サービス　兼　保険契約者代理特約変更請求書");

        khSeikyuusyoBean.setIrSouhuannaimsg1("契約者様がご記入ください");

        khSeikyuusyoBean.setIrSouhuannaimsg2("ご家族登録サービスおよび保険契約者代理特約について、次のとおり変更します。");

        khSeikyuusyoBean.setIrSouhuannaimsg3("（詳細は２／２ページのとおり）");

        khSeikyuusyoBean.setIrSouhuannaimsg4("□登録　□変更　□削除");

        khSeikyuusyoBean.setIrSouhuannaimsg5("□　１／２ページに記載の請求者現住所に同じ");

        khSeikyuusyoBean.setIrTrkkzktelno1("1206-6937-2247");

        khSeikyuusyoBean.setIrTrkkzktelno2("1206-6937-3358");
        khSeikyuusyoBean.setIrKykdrtkykhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrMousideninkbn(C_MousideninKbn.KYKHONNIN);

        khSeikyuusyoBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);

        khSeikyuusyoBean.setIrStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi1(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi2(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrKykdrkbn(C_UktKbn.TOUROKUKAZOKU1);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月 8日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_kzktrkkykdrtkykhnk_sks", C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("wwwwwwwwwww");
        khSeikyuusyoBean.setIrTsinyno("wwwwwww");
        khSeikyuusyoBean.setIrTsintelno("wwwwwwwwwwwwww");

        khSeikyuusyoBean.setIrTsinadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrTsinadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrTsinadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrTrkkzknmkj1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrTrkkzkadr1kj1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrTrkkzkadr2kj1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrTrkkzkadr3kj1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrTrkkzknmkj2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrTrkkzkadr1kj2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrTrkkzkadr2kj2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrTrkkzkadr3kj2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrKykdairinmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSeikyuusyoBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrSouhuannaimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrSouhuannaimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrSouhuannaimsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrSouhuannaimsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrSouhuannaimsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrTrkkzktelno1("wwwwwwwwwwwwww");

        khSeikyuusyoBean.setIrTrkkzktelno2("wwwwwwwwwwwwww");
        khSeikyuusyoBean.setIrKykdrtkykhukaumu(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrMousideninkbn(C_MousideninKbn.KYKHONNIN);

        khSeikyuusyoBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);

        khSeikyuusyoBean.setIrStdruktkbn(C_UktKbn.BLNK);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi1(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi2(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrKykdrkbn(C_UktKbn.TOUROKUKAZOKU2);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("wwwwwwww");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("9999年99月99日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 99年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_kzktrkkykdrtkykhnk_sks", C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");

        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");

        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");

        khSeikyuusyoBean.setIrTsinadr3kj("新宿市１ー２ー２２");

        khSeikyuusyoBean.setIrTrkkzknmkj1("住生一郎　様");

        khSeikyuusyoBean.setIrTrkkzkadr1kj1("大阪市中央区");

        khSeikyuusyoBean.setIrTrkkzkadr2kj1("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTrkkzkadr3kj1("ＡＢＣマンション");

        khSeikyuusyoBean.setIrTrkkzknmkj2("住生二郎　様");

        khSeikyuusyoBean.setIrTrkkzkadr1kj2("大阪市中央区");

        khSeikyuusyoBean.setIrTrkkzkadr2kj2("新栄町２－５－４５");

        khSeikyuusyoBean.setIrTrkkzkadr3kj2("ＡＢＣマンション");

        khSeikyuusyoBean.setIrKykdairinmkj("住生太郎　様");
        khSeikyuusyoBean.setIrTyouhyoutitle("ご家族登録サービス　兼　保険契約者代理特約変更請求書");

        khSeikyuusyoBean.setIrSouhuannaimsg1("契約者様がご記入ください");

        khSeikyuusyoBean.setIrSouhuannaimsg2("ご家族登録サービスおよび保険契約者代理特約について、次のとおり変更します。");

        khSeikyuusyoBean.setIrSouhuannaimsg3("（詳細は２／２ページのとおり）");

        khSeikyuusyoBean.setIrSouhuannaimsg4("□登録　□変更　□削除");

        khSeikyuusyoBean.setIrSouhuannaimsg5("□　１／２ページに記載の請求者現住所に同じ");

        khSeikyuusyoBean.setIrTrkkzktelno1("1206-6937-2247");

        khSeikyuusyoBean.setIrTrkkzktelno2("1206-6937-3358");
        khSeikyuusyoBean.setIrKykdrtkykhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrMousideninkbn(C_MousideninKbn.KYKHONNIN);

        khSeikyuusyoBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.SETTEI);

        khSeikyuusyoBean.setIrStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi1(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi2(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrKykdrkbn(C_UktKbn.TOUROKUKAZOKU2);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月 8日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_kzktrkkykdrtkykhnk_sks", C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");

        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");

        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");

        khSeikyuusyoBean.setIrTsinadr3kj("新宿市１ー２ー２２");

        khSeikyuusyoBean.setIrTrkkzknmkj1("住生一郎　様");

        khSeikyuusyoBean.setIrTrkkzkadr1kj1("大阪市中央区");

        khSeikyuusyoBean.setIrTrkkzkadr2kj1("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTrkkzkadr3kj1("ＡＢＣマンション");

        khSeikyuusyoBean.setIrTrkkzknmkj2("住生二郎　様");

        khSeikyuusyoBean.setIrTrkkzkadr1kj2("大阪市中央区");

        khSeikyuusyoBean.setIrTrkkzkadr2kj2("新栄町２－５－４５");

        khSeikyuusyoBean.setIrTrkkzkadr3kj2("ＡＢＣマンション");

        khSeikyuusyoBean.setIrKykdairinmkj("住生太郎　様");
        khSeikyuusyoBean.setIrTyouhyoutitle("ご家族登録サービス変更請求書");

        khSeikyuusyoBean.setIrSouhuannaimsg1("被保険者様がご記入ください");

        khSeikyuusyoBean.setIrSouhuannaimsg2("ご家族登録サービスに登録されている情報を削除します。");

        khSeikyuusyoBean.setIrSouhuannaimsg3("削除する家族情報を選択し、レ印をご記入ください。");

        khSeikyuusyoBean.setIrSouhuannaimsg4("");

        khSeikyuusyoBean.setIrSouhuannaimsg5("");

        khSeikyuusyoBean.setIrTrkkzktelno1("1206-6937-2247");

        khSeikyuusyoBean.setIrTrkkzktelno2("1206-6937-3358");
        khSeikyuusyoBean.setIrKykdrtkykhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrMousideninkbn(C_MousideninKbn.HHKNHONNIN);

        khSeikyuusyoBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);

        khSeikyuusyoBean.setIrStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi1(C_KahiKbn.HUKA);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi2(C_KahiKbn.HUKA);

        khSeikyuusyoBean.setIrKykdrkbn(C_UktKbn.TOUROKUKAZOKU2);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月 8日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_kzktrkkykdrtkykhnk_sks", C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");

        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");

        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");

        khSeikyuusyoBean.setIrTsinadr3kj("新宿市１ー２ー２２");

        khSeikyuusyoBean.setIrTrkkzknmkj1("住生一郎　様");

        khSeikyuusyoBean.setIrTrkkzkadr1kj1("大阪市中央区");

        khSeikyuusyoBean.setIrTrkkzkadr2kj1("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTrkkzkadr3kj1("ＡＢＣマンション");

        khSeikyuusyoBean.setIrTrkkzknmkj2("住生二郎　様");

        khSeikyuusyoBean.setIrTrkkzkadr1kj2("大阪市中央区");

        khSeikyuusyoBean.setIrTrkkzkadr2kj2("新栄町２－５－４５");

        khSeikyuusyoBean.setIrTrkkzkadr3kj2("ＡＢＣマンション");

        khSeikyuusyoBean.setIrKykdairinmkj("住生太郎　様");
        khSeikyuusyoBean.setIrTyouhyoutitle("ご家族登録サービス　兼　保険契約者代理特約変更請求書");

        khSeikyuusyoBean.setIrSouhuannaimsg1("登録家族様がご記入ください");

        khSeikyuusyoBean.setIrSouhuannaimsg2("ご家族登録サービスについて、次のとおり変更します。");

        khSeikyuusyoBean.setIrSouhuannaimsg3("（詳細は２／２ページのとおり）");

        khSeikyuusyoBean.setIrSouhuannaimsg4("□変更　□削除");

        khSeikyuusyoBean.setIrSouhuannaimsg5("□　契約者現住所に同じ");

        khSeikyuusyoBean.setIrTrkkzktelno1("1206-6937-2247");

        khSeikyuusyoBean.setIrTrkkzktelno2("1206-6937-3358");
        khSeikyuusyoBean.setIrKykdrtkykhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrMousideninkbn(C_MousideninKbn.TRKKZK1);

        khSeikyuusyoBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);

        khSeikyuusyoBean.setIrStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi1(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi2(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrKykdrkbn(C_UktKbn.TOUROKUKAZOKU1);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月 8日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_kzktrkkykdrtkykhnk_sks", C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");

        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");

        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");

        khSeikyuusyoBean.setIrTsinadr3kj("新宿市１ー２ー２２");

        khSeikyuusyoBean.setIrTrkkzknmkj1("住生一郎　様");

        khSeikyuusyoBean.setIrTrkkzkadr1kj1("大阪市中央区");

        khSeikyuusyoBean.setIrTrkkzkadr2kj1("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTrkkzkadr3kj1("ＡＢＣマンション");

        khSeikyuusyoBean.setIrTrkkzknmkj2("住生二郎　様");

        khSeikyuusyoBean.setIrTrkkzkadr1kj2("大阪市中央区");

        khSeikyuusyoBean.setIrTrkkzkadr2kj2("新栄町２－５－４５");

        khSeikyuusyoBean.setIrTrkkzkadr3kj2("ＡＢＣマンション");

        khSeikyuusyoBean.setIrKykdairinmkj("住生太郎　様");
        khSeikyuusyoBean.setIrTyouhyoutitle("ご家族登録サービス　兼　保険契約者代理特約変更請求書");

        khSeikyuusyoBean.setIrSouhuannaimsg1("登録家族様がご記入ください");

        khSeikyuusyoBean.setIrSouhuannaimsg2("ご家族登録サービスについて、次のとおり変更します。");

        khSeikyuusyoBean.setIrSouhuannaimsg3("（詳細は２／２ページのとおり）");

        khSeikyuusyoBean.setIrSouhuannaimsg4("□変更　□削除");

        khSeikyuusyoBean.setIrSouhuannaimsg5("□　契約者現住所に同じ");

        khSeikyuusyoBean.setIrTrkkzktelno1("1206-6937-2247");

        khSeikyuusyoBean.setIrTrkkzktelno2("1206-6937-3358");
        khSeikyuusyoBean.setIrKykdrtkykhukaumu(C_UmuKbn.NONE);

        khSeikyuusyoBean.setIrMousideninkbn(C_MousideninKbn.TRKKZK2);

        khSeikyuusyoBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);

        khSeikyuusyoBean.setIrStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi1(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi2(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrKykdrkbn(C_UktKbn.TOUROKUKAZOKU1);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月 8日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_kzktrkkykdrtkykhnk_sks", C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");

        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");

        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");

        khSeikyuusyoBean.setIrTsinadr3kj("新宿市１ー２ー２２");

        khSeikyuusyoBean.setIrTrkkzknmkj1("");

        khSeikyuusyoBean.setIrTrkkzkadr1kj1("大阪市中央区");

        khSeikyuusyoBean.setIrTrkkzkadr2kj1("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTrkkzkadr3kj1("ＡＢＣマンション");

        khSeikyuusyoBean.setIrTrkkzknmkj2("");

        khSeikyuusyoBean.setIrTrkkzkadr1kj2("大阪市中央区");

        khSeikyuusyoBean.setIrTrkkzkadr2kj2("新栄町２－５－４５");

        khSeikyuusyoBean.setIrTrkkzkadr3kj2("ＡＢＣマンション");

        khSeikyuusyoBean.setIrKykdairinmkj("住生太郎　様");
        khSeikyuusyoBean.setIrTyouhyoutitle("ご家族登録サービス変更請求書");

        khSeikyuusyoBean.setIrSouhuannaimsg1("被保険者様がご記入ください");

        khSeikyuusyoBean.setIrSouhuannaimsg2("ご家族登録サービスに登録されている情報を削除します。");

        khSeikyuusyoBean.setIrSouhuannaimsg3("削除する家族情報を選択し、レ印をご記入ください。");

        khSeikyuusyoBean.setIrSouhuannaimsg4("");

        khSeikyuusyoBean.setIrSouhuannaimsg5("");

        khSeikyuusyoBean.setIrTrkkzktelno1("1206-6937-2247");

        khSeikyuusyoBean.setIrTrkkzktelno2("1206-6937-3358");
        khSeikyuusyoBean.setIrKykdrtkykhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrMousideninkbn(C_MousideninKbn.HHKNHONNIN);

        khSeikyuusyoBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);

        khSeikyuusyoBean.setIrStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi1(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi2(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrKykdrkbn(C_UktKbn.TOUROKUKAZOKU2);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("");

        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_kzktrkkykdrtkykhnk_sks", C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");

        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");

        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");

        khSeikyuusyoBean.setIrTsinadr3kj("新宿市１ー２ー２２");

        khSeikyuusyoBean.setIrTrkkzknmkj1(null);

        khSeikyuusyoBean.setIrTrkkzkadr1kj1("大阪市中央区");

        khSeikyuusyoBean.setIrTrkkzkadr2kj1("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTrkkzkadr3kj1("ＡＢＣマンション");

        khSeikyuusyoBean.setIrTrkkzknmkj2(null);

        khSeikyuusyoBean.setIrTrkkzkadr1kj2("大阪市中央区");

        khSeikyuusyoBean.setIrTrkkzkadr2kj2("新栄町２－５－４５");

        khSeikyuusyoBean.setIrTrkkzkadr3kj2("ＡＢＣマンション");

        khSeikyuusyoBean.setIrKykdairinmkj("住生太郎　様");
        khSeikyuusyoBean.setIrTyouhyoutitle("ご家族登録サービス変更請求書");

        khSeikyuusyoBean.setIrSouhuannaimsg1("被保険者様がご記入ください");

        khSeikyuusyoBean.setIrSouhuannaimsg2("ご家族登録サービスに登録されている情報を削除します。");

        khSeikyuusyoBean.setIrSouhuannaimsg3("削除する家族情報を選択し、レ印をご記入ください。");

        khSeikyuusyoBean.setIrSouhuannaimsg4("");

        khSeikyuusyoBean.setIrSouhuannaimsg5("");

        khSeikyuusyoBean.setIrTrkkzktelno1("1206-6937-2247");

        khSeikyuusyoBean.setIrTrkkzktelno2("1206-6937-3358");
        khSeikyuusyoBean.setIrKykdrtkykhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrMousideninkbn(C_MousideninKbn.HHKNHONNIN);

        khSeikyuusyoBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);

        khSeikyuusyoBean.setIrStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi1(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi2(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrKykdrkbn(C_UktKbn.TOUROKUKAZOKU2);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd(null);

        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_kzktrkkykdrtkykhnk_sks", C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");

        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");

        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");

        khSeikyuusyoBean.setIrTsinadr3kj("新宿市１ー２ー２２");

        khSeikyuusyoBean.setIrTrkkzknmkj1("住生一郎　様");

        khSeikyuusyoBean.setIrTrkkzkadr1kj1("大阪市中央区");

        khSeikyuusyoBean.setIrTrkkzkadr2kj1("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTrkkzkadr3kj1("ＡＢＣマンション");

        khSeikyuusyoBean.setIrTrkkzknmkj2("住生二郎　様");

        khSeikyuusyoBean.setIrTrkkzkadr1kj2("大阪市中央区");

        khSeikyuusyoBean.setIrTrkkzkadr2kj2("新栄町２－５－４５");

        khSeikyuusyoBean.setIrTrkkzkadr3kj2("ＡＢＣマンション");

        khSeikyuusyoBean.setIrKykdairinmkj("住生太郎　様");
        khSeikyuusyoBean.setIrTyouhyoutitle("ご家族登録サービス変更請求書");

        khSeikyuusyoBean.setIrSouhuannaimsg1("被保険者様がご記入ください");

        khSeikyuusyoBean.setIrSouhuannaimsg2("ご家族登録サービスに登録されている情報を削除します。");

        khSeikyuusyoBean.setIrSouhuannaimsg3("削除する家族情報を選択し、レ印をご記入ください。");

        khSeikyuusyoBean.setIrSouhuannaimsg4("");

        khSeikyuusyoBean.setIrSouhuannaimsg5("");

        khSeikyuusyoBean.setIrTrkkzktelno1("1206-6937-2247");

        khSeikyuusyoBean.setIrTrkkzktelno2("1206-6937-3358");
        khSeikyuusyoBean.setIrKykdrtkykhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrMousideninkbn(C_MousideninKbn.HHKNHONNIN);

        khSeikyuusyoBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);

        khSeikyuusyoBean.setIrStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi1(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi2(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrKykdrkbn(C_UktKbn.TOUROKUKAZOKU2);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("2026年12月 8日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_kzktrkkykdrtkykhnk_sks", C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS);

        khSeikyuusyoBean.setIrSyono("12345678901");
        khSeikyuusyoBean.setIrTsinyno("0101234");
        khSeikyuusyoBean.setIrTsintelno("1206-6937-1136");

        khSeikyuusyoBean.setIrTsinadr1kj("板橋区巣鴨３丁目");

        khSeikyuusyoBean.setIrTsinadr2kj("横浜市横浜港");

        khSeikyuusyoBean.setIrTsinadr3kj("新宿市１ー２ー２２");

        khSeikyuusyoBean.setIrTrkkzknmkj1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrTrkkzkadr1kj1("大阪市中央区");

        khSeikyuusyoBean.setIrTrkkzkadr2kj1("新栄町１－４－３４");

        khSeikyuusyoBean.setIrTrkkzkadr3kj1("ＡＢＣマンション");

        khSeikyuusyoBean.setIrTrkkzknmkj2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        khSeikyuusyoBean.setIrTrkkzkadr1kj2("大阪市中央区");

        khSeikyuusyoBean.setIrTrkkzkadr2kj2("新栄町２－５－４５");

        khSeikyuusyoBean.setIrTrkkzkadr3kj2("ＡＢＣマンション");

        khSeikyuusyoBean.setIrKykdairinmkj("住生太郎　様");
        khSeikyuusyoBean.setIrTyouhyoutitle("ご家族登録サービス変更請求書");

        khSeikyuusyoBean.setIrSouhuannaimsg1("被保険者様がご記入ください");

        khSeikyuusyoBean.setIrSouhuannaimsg2("ご家族登録サービスに登録されている情報を削除します。");

        khSeikyuusyoBean.setIrSouhuannaimsg3("削除する家族情報を選択し、レ印をご記入ください。");

        khSeikyuusyoBean.setIrSouhuannaimsg4("");

        khSeikyuusyoBean.setIrSouhuannaimsg5("");

        khSeikyuusyoBean.setIrTrkkzktelno1("1206-6937-2247");

        khSeikyuusyoBean.setIrTrkkzktelno2("1206-6937-3358");
        khSeikyuusyoBean.setIrKykdrtkykhukaumu(C_UmuKbn.ARI);

        khSeikyuusyoBean.setIrMousideninkbn(C_MousideninKbn.HHKNHONNIN);

        khSeikyuusyoBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);

        khSeikyuusyoBean.setIrStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi1(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrTrkkzksakujyokahi2(C_KahiKbn.KA);

        khSeikyuusyoBean.setIrKykdrkbn(C_UktKbn.TOUROKUKAZOKU2);

        bzSksKaisyasiyouranBean.setIrToritsugisyasyozokunm("取次者所属名");

        bzSksKaisyasiyouranBean.setIrToritsugisyakjncd("12345678");
        bzSksKaisyasiyouranBean.setIrToritsugisyanm("取次者氏名");
        bzSksKaisyasiyouranBean.setIrTyouhyousakuseiymd("9999年99月99日");

        bzSksKaisyasiyouranBean.setIrHozonkkn("消滅後 15年");

        reportTestBean.addParamObjects(khSeikyuusyoBean, bzSksKaisyasiyouranBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
