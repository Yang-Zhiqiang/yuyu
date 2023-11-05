package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_SoukinsakisiteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_ZeimuNaiyouHnsyuCtrlKbn;
import yuyu.def.hozen.bean.report.KhTtdkkanryouBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * お手続き完了のお知らせ　契約取消
 */
@RunWith(OrderedRunner.class)
public class KhTtdkkrTorikesiTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhTtdkkanryouBean khTtdkkanryouBean;
    @Inject
    private BzKokyakuAtesakiBean bzKokyakuAtesakiBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("");
        bzKokyakuAtesakiBean.setIrShsyno("");
        bzKokyakuAtesakiBean.setIrShadr1kj("");
        bzKokyakuAtesakiBean.setIrShadr2kj("");
        bzKokyakuAtesakiBean.setIrShadr3kj("");
        bzKokyakuAtesakiBean.setIrShsnmkj("");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("");
        bzKokyakuAtesakiBean.setIrToiawaseyno("");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("");
        bzKokyakuAtesakiBean.setIrHknkisynm("");
        bzKokyakuAtesakiBean.setIrToiawasetelno("");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBKAIJO);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
        khTtdkkanryouBean.setIrHtsiryosyukbn(C_HtsiryosyuKbn.BLNK);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("");
        khTtdkkanryouBean.setIrKyknmkj("");
        khTtdkkanryouBean.setIrHhknnmkj("");
        khTtdkkanryouBean.setIrShrymd("");
        khTtdkkanryouBean.setIrCalckijyunymd("");
        khTtdkkanryouBean.setIrTekiyou1("");
        khTtdkkanryouBean.setIrKngkmeisai1(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("");
        khTtdkkanryouBean.setIrBikou1("");
        khTtdkkanryouBean.setIrTekiyou2("");
        khTtdkkanryouBean.setIrKngkmeisai2(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("");
        khTtdkkanryouBean.setIrBikou2("");
        khTtdkkanryouBean.setIrTekiyou3("");
        khTtdkkanryouBean.setIrKngkmeisai3(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("");
        khTtdkkanryouBean.setIrBikou3("");
        khTtdkkanryouBean.setIrTekiyou4("");
        khTtdkkanryouBean.setIrKngkmeisai4(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("");
        khTtdkkanryouBean.setIrBikou4("");
        khTtdkkanryouBean.setIrTekiyou5("");
        khTtdkkanryouBean.setIrKngkmeisai5(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("");
        khTtdkkanryouBean.setIrBikou5("");
        khTtdkkanryouBean.setIrTekiyou6("");
        khTtdkkanryouBean.setIrKngkmeisai6(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("");
        khTtdkkanryouBean.setIrBikou6("");
        khTtdkkanryouBean.setIrTekiyou7("");
        khTtdkkanryouBean.setIrKngkmeisai7(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("");
        khTtdkkanryouBean.setIrBikou7("");
        khTtdkkanryouBean.setIrTekiyou8("");
        khTtdkkanryouBean.setIrKngkmeisai8(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("");
        khTtdkkanryouBean.setIrBikou8("");
        khTtdkkanryouBean.setIrTekiyou9("");
        khTtdkkanryouBean.setIrKngkmeisai9(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("");
        khTtdkkanryouBean.setIrBikou9("");
        khTtdkkanryouBean.setIrTekiyou10("");
        khTtdkkanryouBean.setIrKngkmeisai10(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("");
        khTtdkkanryouBean.setIrBikou10("");
        khTtdkkanryouBean.setIrShrgk(null);
        khTtdkkanryouBean.setIrShrtuukasyuryk("");
        khTtdkkanryouBean.setIrBanknmkj("");
        khTtdkkanryouBean.setIrSitennmkj("");
        khTtdkkanryouBean.setIrYokinkbn(null);
        khTtdkkanryouBean.setIrKouzano("");
        khTtdkkanryouBean.setIrKzmeiginmkn("");
        khTtdkkanryouBean.setIrSynykngk(null);
        khTtdkkanryouBean.setIrHtykeihi(null);
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(null);


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }



    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(null);
        bzKokyakuAtesakiBean.setIrShsyno(null);
        bzKokyakuAtesakiBean.setIrShadr1kj(null);
        bzKokyakuAtesakiBean.setIrShadr2kj(null);
        bzKokyakuAtesakiBean.setIrShadr3kj(null);
        bzKokyakuAtesakiBean.setIrShsnmkj(null);
        bzKokyakuAtesakiBean.setIrToiawasesosiki(null);
        bzKokyakuAtesakiBean.setIrToiawaseyno(null);
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj(null);
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj(null);
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj(null);
        bzKokyakuAtesakiBean.setIrHknkisynm(null);
        bzKokyakuAtesakiBean.setIrToiawasetelno(null);
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1(null);
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2(null);


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBKAIJO);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
        khTtdkkanryouBean.setIrHtsiryosyukbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono(null);
        khTtdkkanryouBean.setIrKyknmkj(null);
        khTtdkkanryouBean.setIrHhknnmkj(null);
        khTtdkkanryouBean.setIrShrymd(null);
        khTtdkkanryouBean.setIrCalckijyunymd(null);
        khTtdkkanryouBean.setIrTekiyou1(null);
        khTtdkkanryouBean.setIrKngkmeisai1(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm1(null);
        khTtdkkanryouBean.setIrBikou1(null);
        khTtdkkanryouBean.setIrTekiyou2(null);
        khTtdkkanryouBean.setIrKngkmeisai2(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm2(null);
        khTtdkkanryouBean.setIrBikou2(null);
        khTtdkkanryouBean.setIrTekiyou3(null);
        khTtdkkanryouBean.setIrKngkmeisai3(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm3(null);
        khTtdkkanryouBean.setIrBikou3(null);
        khTtdkkanryouBean.setIrTekiyou4(null);
        khTtdkkanryouBean.setIrKngkmeisai4(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm4(null);
        khTtdkkanryouBean.setIrBikou4(null);
        khTtdkkanryouBean.setIrTekiyou5(null);
        khTtdkkanryouBean.setIrKngkmeisai5(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm5(null);
        khTtdkkanryouBean.setIrBikou5(null);
        khTtdkkanryouBean.setIrTekiyou6(null);
        khTtdkkanryouBean.setIrKngkmeisai6(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm6(null);
        khTtdkkanryouBean.setIrBikou6(null);
        khTtdkkanryouBean.setIrTekiyou7(null);
        khTtdkkanryouBean.setIrKngkmeisai7(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm7(null);
        khTtdkkanryouBean.setIrBikou7(null);
        khTtdkkanryouBean.setIrTekiyou8(null);
        khTtdkkanryouBean.setIrKngkmeisai8(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm8(null);
        khTtdkkanryouBean.setIrBikou8(null);
        khTtdkkanryouBean.setIrTekiyou9(null);
        khTtdkkanryouBean.setIrKngkmeisai9(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm9(null);
        khTtdkkanryouBean.setIrBikou9(null);
        khTtdkkanryouBean.setIrTekiyou10(null);
        khTtdkkanryouBean.setIrKngkmeisai10(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm10(null);
        khTtdkkanryouBean.setIrBikou10(null);
        khTtdkkanryouBean.setIrShrgk(null);
        khTtdkkanryouBean.setIrShrtuukasyuryk(null);
        khTtdkkanryouBean.setIrBanknmkj(null);
        khTtdkkanryouBean.setIrSitennmkj(null);
        khTtdkkanryouBean.setIrYokinkbn(null);
        khTtdkkanryouBean.setIrKouzano(null);
        khTtdkkanryouBean.setIrKzmeiginmkn(null);
        khTtdkkanryouBean.setIrSynykngk(null);
        khTtdkkanryouBean.setIrHtykeihi(null);
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(null);


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }



    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBMENSEKI);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
        khTtdkkanryouBean.setIrHtsiryosyukbn(C_HtsiryosyuKbn.BLNK);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(1.11));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("豪ドル");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(2.22));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("ユーロ");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(3.33));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("米ドル");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(4.44));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("豪ドル");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(5.55));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("ユーロ");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(6.67));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("米ドル");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(7.77));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("豪ドル");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(8.88));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("ユーロ");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("米ドル");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(1.12));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("豪ドル");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(6.66));
        khTtdkkanryouBean.setIrShrtuukasyuryk("米ドル");
        khTtdkkanryouBean.setIrBanknmkj("送金先銀行名");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(7));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }


    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBKAIJO);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(111.11));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("米ドル");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(222.22));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("豪ドル");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(333.33));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("ユーロ");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(444.44));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("米ドル");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(555.55));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("豪ドル");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(666.67));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("ユーロ");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(777.77));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("米ドル");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(888.88));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("豪ドル");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("ユーロ");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(111.12));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("米ドル");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(666.66));
        khTtdkkanryouBean.setIrShrtuukasyuryk("ユーロ");
        khTtdkkanryouBean.setIrBanknmkj("送金先銀行名");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.TOUZA);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(777777));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(888888));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(999999));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }


    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBMENSEKI);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
        khTtdkkanryouBean.setIrHtsiryosyukbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(1111.11));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("ユーロ");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(2222.22));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("米ドル");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(3333.33));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("豪ドル");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(4444.44));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("ユーロ");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(5555.55));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("米ドル");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(6666.67));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("豪ドル");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(7777.77));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("ユーロ");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(8888.88));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("米ドル");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("豪ドル");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(1111.12));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("ユーロ");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(6666.66));
        khTtdkkanryouBean.setIrShrtuukasyuryk("豪ドル");
        khTtdkkanryouBean.setIrBanknmkj("送金先銀行名");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBKAIJO);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(1111111.11));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("豪ドル");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(2222222.22));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("豪ドル");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(3333333.33));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("豪ドル");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(4444444.44));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("豪ドル");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(5555555.55));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("豪ドル");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(6666666.67));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("豪ドル");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(7777777.77));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("豪ドル");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(8888888.88));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("豪ドル");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("豪ドル");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(1111111.12));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("豪ドル");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(6666666.66));
        khTtdkkanryouBean.setIrShrtuukasyuryk("豪ドル");
        khTtdkkanryouBean.setIrBanknmkj("送金先銀行名");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }


    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBKAIJO);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(111));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("豪ドル");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(222));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("豪ドル");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(333));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("豪ドル");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(444));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("豪ドル");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(555));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("豪ドル");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(667));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("豪ドル");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(777));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("豪ドル");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(888));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("豪ドル");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(999));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("豪ドル");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(112));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("豪ドル");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(666));
        khTtdkkanryouBean.setIrShrtuukasyuryk("豪ドル");
        khTtdkkanryouBean.setIrBanknmkj("");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }


    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(111.1));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("豪ドル");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(222.2));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("豪ドル");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(333.3));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("豪ドル");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(444.4));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("豪ドル");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(555.5));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("豪ドル");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(666.7));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("豪ドル");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(777.7));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("豪ドル");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(888.8));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("豪ドル");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(999.9));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("豪ドル");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(111.2));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("豪ドル");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(666.6));
        khTtdkkanryouBean.setIrShrtuukasyuryk("豪ドル");
        khTtdkkanryouBean.setIrBanknmkj("送金先銀行名");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }


    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBMENSEKI);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(1));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("円");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(2));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("円");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(3));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("円");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(4));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("円");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(5));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("円");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(6));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("円");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(7));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("円");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(8));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("円");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("円");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(1));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("円");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(6));
        khTtdkkanryouBean.setIrShrtuukasyuryk("円");
        khTtdkkanryouBean.setIrBanknmkj("送金先銀行名");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }


    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBMENSEKI);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(111111));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("円");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(222222));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("円");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(333333));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("円");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(444444));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("円");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(555555));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("円");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(666667));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("円");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(777777));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("円");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(888888));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("円");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(999999));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("円");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(111112));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("円");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(666666));
        khTtdkkanryouBean.setIrShrtuukasyuryk("円");
        khTtdkkanryouBean.setIrBanknmkj("送金先銀行名");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }


    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBMENSEKI);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(1111111111));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("円");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(2222222222L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("円");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(3333333333L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("円");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(4444444444L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("円");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(5555555555L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("円");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(6666666667L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("円");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("円");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("円");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("円");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(1111111112));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("円");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(6666666666L));
        khTtdkkanryouBean.setIrShrtuukasyuryk("円");
        khTtdkkanryouBean.setIrBanknmkj("送金先銀行名");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }


    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBKAIJO);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
        khTtdkkanryouBean.setIrHtsiryosyukbn(C_HtsiryosyuKbn.BLNK);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("円");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("円");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("円");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("円");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("円");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("円");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("円");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("円");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("円");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("円");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrShrtuukasyuryk("円");
        khTtdkkanryouBean.setIrBanknmkj("送金先銀行名");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }


    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBKAIJO);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
        khTtdkkanryouBean.setIrHtsiryosyukbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI);
        khTtdkkanryouBean.setIrSyono("ＸＸＸＸＸＸＸＸＸＸＸ");
        khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrShrymd("9999年99月99日");
        khTtdkkanryouBean.setIrCalckijyunymd("9999年99月99日");
        khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou10("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrShrtuukasyuryk("ＷＷＷ");
        khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("99999999");
        khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }



    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.KYKTORIKESI);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(1111111111));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("円");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(2222222222L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("円");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(3333333333L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("円");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(4444444444L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("円");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(5555555555L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("円");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(6666666667L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("円");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("円");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("円");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("円");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(1111111112L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("円");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(6666666666L));
        khTtdkkanryouBean.setIrShrtuukasyuryk("円");
        khTtdkkanryouBean.setIrBanknmkj("送金先銀行名");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }


    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(111111));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("円");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(222222));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("円");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(333333));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("円");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(444444));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("円");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(555555));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("円");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(666667));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("円");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(777777));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("円");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(888888));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("円");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(999999));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("円");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(111112));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("円");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(666666));
        khTtdkkanryouBean.setIrShrtuukasyuryk("円");
        khTtdkkanryouBean.setIrBanknmkj("送金先銀行名");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }


    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(1111111.11));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("豪ドル");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(2222222.22));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("ユーロ");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(3333333.33));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("米ドル");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(4444444.44));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("豪ドル");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(5555555.55));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("ユーロ");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(6666666.67));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("米ドル");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(7777777.77));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("豪ドル");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(8888888.88));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("ユーロ");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("米ドル");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(1111111.12));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("豪ドル");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(6666666.66));
        khTtdkkanryouBean.setIrShrtuukasyuryk("米ドル");
        khTtdkkanryouBean.setIrBanknmkj("送金先銀行名");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(111.11));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("ユーロ");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(222.22));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("米ドル");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(333.33));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("豪ドル");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(444.44));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("ユーロ");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(555.55));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("米ドル");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(666.67));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("豪ドル");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(777.77));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("ユーロ");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(888.88));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("米ドル");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("豪ドル");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(111.12));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("ユーロ");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(666.66));
        khTtdkkanryouBean.setIrShrtuukasyuryk("米ドル");
        khTtdkkanryouBean.setIrBanknmkj("送金先銀行名");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(111.1));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("米ドル");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(222.2));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("米ドル");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(333.3));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("米ドル");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(444.4));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("米ドル");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(555.5));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("米ドル");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(666.7));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("米ドル");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(777.7));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("米ドル");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(888.8));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("米ドル");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(999.9));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("米ドル");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(111.2));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("米ドル");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(666.6));
        khTtdkkanryouBean.setIrShrtuukasyuryk("ユーロ");
        khTtdkkanryouBean.setIrBanknmkj("送金先銀行名");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }


    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(1.11));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("米ドル");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(2.22));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("豪ドル");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(3.33));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("ユーロ");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(4.44));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("米ドル");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(5.55));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("豪ドル");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(6.67));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("ユーロ");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(7.77));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("米ドル");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(8.88));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("豪ドル");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("ユーロ");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(1.12));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("米ドル");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(6.66));
        khTtdkkanryouBean.setIrShrtuukasyuryk("ユーロ");
        khTtdkkanryouBean.setIrBanknmkj("送金先銀行名");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.TOUZA);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }


    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(1111.11));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("米ドル");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(2222.22));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("米ドル");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(3333.33));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("米ドル");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(4444.44));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("米ドル");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(5555.55));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("米ドル");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(6666.67));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("米ドル");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(7777.77));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("米ドル");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(8888.88));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("米ドル");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("米ドル");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(1111.12));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("米ドル");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(6666.66));
        khTtdkkanryouBean.setIrShrtuukasyuryk("豪ドル");
        khTtdkkanryouBean.setIrBanknmkj("送金先銀行名");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }


    @Test
    @TestOrder(210)
    @Transactional
    public void testCreateReport21() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(111));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("米ドル");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(222));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("米ドル");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(333));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("米ドル");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(444));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("米ドル");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(555));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("米ドル");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(667));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("米ドル");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(777));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("米ドル");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(888));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("米ドル");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(999));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("米ドル");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(112));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("米ドル");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(666));
        khTtdkkanryouBean.setIrShrtuukasyuryk("豪ドル");
        khTtdkkanryouBean.setIrBanknmkj("送金先銀行名");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }


    @Test
    @TestOrder(220)
    @Transactional
    public void testCreateReport22() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(1));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("円");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(2));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("円");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(3));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("円");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(4));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("円");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(5));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("円");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(6));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("円");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(7));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("円");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(8));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("円");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("円");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(1));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("円");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(6));
        khTtdkkanryouBean.setIrShrtuukasyuryk("円");
        khTtdkkanryouBean.setIrBanknmkj("送金先銀行名");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }


    @Test
    @TestOrder(230)
    @Transactional
    public void testCreateReport23() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("円");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("円");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("円");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("円");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("円");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("円");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("円");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("円");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("円");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("円");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrShrtuukasyuryk("円");
        khTtdkkanryouBean.setIrBanknmkj("送金先銀行名");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }
    @Test
    @TestOrder(240)
    @Transactional
    public void testCreateReport24() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("");
        bzKokyakuAtesakiBean.setIrShsyno("");
        bzKokyakuAtesakiBean.setIrShadr1kj("");
        bzKokyakuAtesakiBean.setIrShadr2kj("");
        bzKokyakuAtesakiBean.setIrShadr3kj("");
        bzKokyakuAtesakiBean.setIrShsnmkj("");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("");
        bzKokyakuAtesakiBean.setIrToiawaseyno("");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("");
        bzKokyakuAtesakiBean.setIrHknkisynm("");
        bzKokyakuAtesakiBean.setIrToiawasetelno("");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("");
        khTtdkkanryouBean.setIrKyknmkj("");
        khTtdkkanryouBean.setIrHhknnmkj("");
        khTtdkkanryouBean.setIrShrymd("");
        khTtdkkanryouBean.setIrCalckijyunymd("");
        khTtdkkanryouBean.setIrTekiyou1("");
        khTtdkkanryouBean.setIrKngkmeisai1(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("");
        khTtdkkanryouBean.setIrBikou1("");
        khTtdkkanryouBean.setIrTekiyou2("");
        khTtdkkanryouBean.setIrKngkmeisai2(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("");
        khTtdkkanryouBean.setIrBikou2("");
        khTtdkkanryouBean.setIrTekiyou3("");
        khTtdkkanryouBean.setIrKngkmeisai3(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("");
        khTtdkkanryouBean.setIrBikou3("");
        khTtdkkanryouBean.setIrTekiyou4("");
        khTtdkkanryouBean.setIrKngkmeisai4(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("");
        khTtdkkanryouBean.setIrBikou4("");
        khTtdkkanryouBean.setIrTekiyou5("");
        khTtdkkanryouBean.setIrKngkmeisai5(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("");
        khTtdkkanryouBean.setIrBikou5("");
        khTtdkkanryouBean.setIrTekiyou6("");
        khTtdkkanryouBean.setIrKngkmeisai6(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("");
        khTtdkkanryouBean.setIrBikou6("");
        khTtdkkanryouBean.setIrTekiyou7("");
        khTtdkkanryouBean.setIrKngkmeisai7(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("");
        khTtdkkanryouBean.setIrBikou7("");
        khTtdkkanryouBean.setIrTekiyou8("");
        khTtdkkanryouBean.setIrKngkmeisai8(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("");
        khTtdkkanryouBean.setIrBikou8("");
        khTtdkkanryouBean.setIrTekiyou9("");
        khTtdkkanryouBean.setIrKngkmeisai9(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("");
        khTtdkkanryouBean.setIrBikou9("");
        khTtdkkanryouBean.setIrTekiyou10("");
        khTtdkkanryouBean.setIrKngkmeisai10(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("");
        khTtdkkanryouBean.setIrBikou10("");
        khTtdkkanryouBean.setIrShrgk(null);
        khTtdkkanryouBean.setIrShrtuukasyuryk("");
        khTtdkkanryouBean.setIrBanknmkj("");
        khTtdkkanryouBean.setIrSitennmkj("");
        khTtdkkanryouBean.setIrYokinkbn(null);
        khTtdkkanryouBean.setIrKouzano("");
        khTtdkkanryouBean.setIrKzmeiginmkn("");
        khTtdkkanryouBean.setIrSynykngk(null);
        khTtdkkanryouBean.setIrHtykeihi(null);
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(null);


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }



    @Test
    @TestOrder(250)
    @Transactional
    public void testCreateReport25() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(null);
        bzKokyakuAtesakiBean.setIrShsyno(null);
        bzKokyakuAtesakiBean.setIrShadr1kj(null);
        bzKokyakuAtesakiBean.setIrShadr2kj(null);
        bzKokyakuAtesakiBean.setIrShadr3kj(null);
        bzKokyakuAtesakiBean.setIrShsnmkj(null);
        bzKokyakuAtesakiBean.setIrToiawasesosiki(null);
        bzKokyakuAtesakiBean.setIrToiawaseyno(null);
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj(null);
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj(null);
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj(null);
        bzKokyakuAtesakiBean.setIrHknkisynm(null);
        bzKokyakuAtesakiBean.setIrToiawasetelno(null);
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1(null);
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2(null);


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono(null);
        khTtdkkanryouBean.setIrKyknmkj(null);
        khTtdkkanryouBean.setIrHhknnmkj(null);
        khTtdkkanryouBean.setIrShrymd(null);
        khTtdkkanryouBean.setIrCalckijyunymd(null);
        khTtdkkanryouBean.setIrTekiyou1(null);
        khTtdkkanryouBean.setIrKngkmeisai1(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm1(null);
        khTtdkkanryouBean.setIrBikou1(null);
        khTtdkkanryouBean.setIrTekiyou2(null);
        khTtdkkanryouBean.setIrKngkmeisai2(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm2(null);
        khTtdkkanryouBean.setIrBikou2(null);
        khTtdkkanryouBean.setIrTekiyou3(null);
        khTtdkkanryouBean.setIrKngkmeisai3(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm3(null);
        khTtdkkanryouBean.setIrBikou3(null);
        khTtdkkanryouBean.setIrTekiyou4(null);
        khTtdkkanryouBean.setIrKngkmeisai4(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm4(null);
        khTtdkkanryouBean.setIrBikou4(null);
        khTtdkkanryouBean.setIrTekiyou5(null);
        khTtdkkanryouBean.setIrKngkmeisai5(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm5(null);
        khTtdkkanryouBean.setIrBikou5(null);
        khTtdkkanryouBean.setIrTekiyou6(null);
        khTtdkkanryouBean.setIrKngkmeisai6(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm6(null);
        khTtdkkanryouBean.setIrBikou6(null);
        khTtdkkanryouBean.setIrTekiyou7(null);
        khTtdkkanryouBean.setIrKngkmeisai7(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm7(null);
        khTtdkkanryouBean.setIrBikou7(null);
        khTtdkkanryouBean.setIrTekiyou8(null);
        khTtdkkanryouBean.setIrKngkmeisai8(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm8(null);
        khTtdkkanryouBean.setIrBikou8(null);
        khTtdkkanryouBean.setIrTekiyou9(null);
        khTtdkkanryouBean.setIrKngkmeisai9(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm9(null);
        khTtdkkanryouBean.setIrBikou9(null);
        khTtdkkanryouBean.setIrTekiyou10(null);
        khTtdkkanryouBean.setIrKngkmeisai10(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm10(null);
        khTtdkkanryouBean.setIrBikou10(null);
        khTtdkkanryouBean.setIrShrgk(null);
        khTtdkkanryouBean.setIrShrtuukasyuryk(null);
        khTtdkkanryouBean.setIrBanknmkj(null);
        khTtdkkanryouBean.setIrSitennmkj(null);
        khTtdkkanryouBean.setIrYokinkbn(null);
        khTtdkkanryouBean.setIrKouzano(null);
        khTtdkkanryouBean.setIrKzmeiginmkn(null);
        khTtdkkanryouBean.setIrSynykngk(null);
        khTtdkkanryouBean.setIrHtykeihi(null);
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(null);


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }
    @Test
    @TestOrder(260)
    @Transactional
    public void testCreateReport26() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("ＸＸＸＸＸＸＸＸＸＸＸ");
        khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrShrymd("9999年99月99日");
        khTtdkkanryouBean.setIrCalckijyunymd("9999年99月99日");
        khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou10("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrShrtuukasyuryk("ＷＷＷ");
        khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("99999999");
        khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }


    @Test
    @TestOrder(270)
    @Transactional
    public void testCreateReport27() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("");
        bzKokyakuAtesakiBean.setIrShsyno("");
        bzKokyakuAtesakiBean.setIrShadr1kj("");
        bzKokyakuAtesakiBean.setIrShadr2kj("");
        bzKokyakuAtesakiBean.setIrShadr3kj("");
        bzKokyakuAtesakiBean.setIrShsnmkj("");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("");
        bzKokyakuAtesakiBean.setIrToiawaseyno("");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("");
        bzKokyakuAtesakiBean.setIrHknkisynm("");
        bzKokyakuAtesakiBean.setIrToiawasetelno("");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.KAIJO);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
        khTtdkkanryouBean.setIrHtsiryosyukbn(C_HtsiryosyuKbn.BLNK);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("");
        khTtdkkanryouBean.setIrKyknmkj("");
        khTtdkkanryouBean.setIrHhknnmkj("");
        khTtdkkanryouBean.setIrShrymd("");
        khTtdkkanryouBean.setIrCalckijyunymd("");
        khTtdkkanryouBean.setIrTekiyou1("");
        khTtdkkanryouBean.setIrKngkmeisai1(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("");
        khTtdkkanryouBean.setIrBikou1("");
        khTtdkkanryouBean.setIrTekiyou2("");
        khTtdkkanryouBean.setIrKngkmeisai2(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("");
        khTtdkkanryouBean.setIrBikou2("");
        khTtdkkanryouBean.setIrTekiyou3("");
        khTtdkkanryouBean.setIrKngkmeisai3(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("");
        khTtdkkanryouBean.setIrBikou3("");
        khTtdkkanryouBean.setIrTekiyou4("");
        khTtdkkanryouBean.setIrKngkmeisai4(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("");
        khTtdkkanryouBean.setIrBikou4("");
        khTtdkkanryouBean.setIrTekiyou5("");
        khTtdkkanryouBean.setIrKngkmeisai5(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("");
        khTtdkkanryouBean.setIrBikou5("");
        khTtdkkanryouBean.setIrTekiyou6("");
        khTtdkkanryouBean.setIrKngkmeisai6(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("");
        khTtdkkanryouBean.setIrBikou6("");
        khTtdkkanryouBean.setIrTekiyou7("");
        khTtdkkanryouBean.setIrKngkmeisai7(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("");
        khTtdkkanryouBean.setIrBikou7("");
        khTtdkkanryouBean.setIrTekiyou8("");
        khTtdkkanryouBean.setIrKngkmeisai8(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("");
        khTtdkkanryouBean.setIrBikou8("");
        khTtdkkanryouBean.setIrTekiyou9("");
        khTtdkkanryouBean.setIrKngkmeisai9(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("");
        khTtdkkanryouBean.setIrBikou9("");
        khTtdkkanryouBean.setIrTekiyou10("");
        khTtdkkanryouBean.setIrKngkmeisai10(null);
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("");
        khTtdkkanryouBean.setIrBikou10("");
        khTtdkkanryouBean.setIrShrgk(null);
        khTtdkkanryouBean.setIrShrtuukasyuryk("");
        khTtdkkanryouBean.setIrBanknmkj("");
        khTtdkkanryouBean.setIrSitennmkj("");
        khTtdkkanryouBean.setIrYokinkbn(null);
        khTtdkkanryouBean.setIrKouzano("");
        khTtdkkanryouBean.setIrKzmeiginmkn("");
        khTtdkkanryouBean.setIrSynykngk(null);
        khTtdkkanryouBean.setIrHtykeihi(null);
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(null);


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testCreateReport28() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBKAIJO);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("12345678987");
        khTtdkkanryouBean.setIrKyknmkj("契約者");
        khTtdkkanryouBean.setIrHhknnmkj("被保険者");
        khTtdkkanryouBean.setIrShrymd("2023年 2月 2日");
        khTtdkkanryouBean.setIrCalckijyunymd("2024年 2月 2日");
        khTtdkkanryouBean.setIrTekiyou1("摘要1");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(1111111111));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("円");
        khTtdkkanryouBean.setIrBikou1("備考1");
        khTtdkkanryouBean.setIrTekiyou2("摘要2");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(2222222222L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("円");
        khTtdkkanryouBean.setIrBikou2("備考2");
        khTtdkkanryouBean.setIrTekiyou3("摘要3");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(3333333333L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("円");
        khTtdkkanryouBean.setIrBikou3("備考3");
        khTtdkkanryouBean.setIrTekiyou4("摘要4");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(4444444444L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("円");
        khTtdkkanryouBean.setIrBikou4("備考4");
        khTtdkkanryouBean.setIrTekiyou5("摘要5");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(5555555555L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("円");
        khTtdkkanryouBean.setIrBikou5("備考5");
        khTtdkkanryouBean.setIrTekiyou6("摘要6");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(6666666667L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("円");
        khTtdkkanryouBean.setIrBikou6("備考6");
        khTtdkkanryouBean.setIrTekiyou7("摘要7");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("円");
        khTtdkkanryouBean.setIrBikou7("備考7");
        khTtdkkanryouBean.setIrTekiyou8("摘要8");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("円");
        khTtdkkanryouBean.setIrBikou8("備考8");
        khTtdkkanryouBean.setIrTekiyou9("摘要9");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("円");
        khTtdkkanryouBean.setIrBikou9("備考9");
        khTtdkkanryouBean.setIrTekiyou10("摘要10");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(1111111112L));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("円");
        khTtdkkanryouBean.setIrBikou10("備考10");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(6666666666L));
        khTtdkkanryouBean.setIrShrtuukasyuryk("円");
        khTtdkkanryouBean.setIrBanknmkj("送金先銀行名");
        khTtdkkanryouBean.setIrSitennmkj("送金先支店名");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("12345678");
        khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(7777777777L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(290)
    @Transactional
    public void testCreateReport29() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("ＸＸＸＸＸＸＸＸＸＸＸ");
        khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrShrymd("9999年99月99日");
        khTtdkkanryouBean.setIrCalckijyunymd("9999年99月99日");
        khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou10("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrShrtuukasyuryk("ＷＷＷ");
        khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("99999999");
        khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));


        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }
    @Test
    @TestOrder(300)
    @Transactional
    public void testCreateReport30() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTtdkkrTorikesiTest", C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");


        khTtdkkanryouBean.setIrSyorikbn(C_SyoriKbn.SBKAIJO);
        khTtdkkanryouBean.setIrSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);
        khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
        khTtdkkanryouBean.setIrHtsiryosyukbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);
        khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
        khTtdkkanryouBean.setIrSyono("ＸＸＸＸＸＸＸＸＸＸＸ");
        khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrShrymd("9999年99月99日");
        khTtdkkanryouBean.setIrCalckijyunymd("9999年99月99日");
        khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm1("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm2("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm3("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm4("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm5("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm6("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm7("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm8("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm9("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrTekiyou10("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrKngkmeisai10(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrKngkmisituukasyunm10("ＷＷＷ");
        khTtdkkanryouBean.setIrBikou10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999.99));
        khTtdkkanryouBean.setIrShrtuukasyuryk("ＷＷＷ");
        khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
        khTtdkkanryouBean.setIrKouzano("99999999");
        khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
        khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));

        reportTestBean.addParamObjects(khTtdkkanryouBean,bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }
}