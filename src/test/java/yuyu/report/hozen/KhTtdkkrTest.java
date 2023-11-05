package yuyu.report.hozen;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_ZeimuNaiyouHnsyuCtrlKbn;
import yuyu.def.hozen.bean.report.KhTtdkkanryouBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * お手続完了のお知らせ用クラス
 */
@RunWith(OrderedRunner.class)
public class KhTtdkkrTest {

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
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1("保険料積立金額（Ａ）");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(1.11, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（（１）＋（２））×（３）");
            khTtdkkanryouBean.setIrTekiyou2("市場価格調整額（Ｂ）");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(2.22, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("　（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("解約返戻金額（Ａ＋Ｂ）");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(3.33, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("　　　１０５００．００　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(4.44, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("　（２）市場価格調整額");
            khTtdkkanryouBean.setIrTekiyou5("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(5.55, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("　　　５００．００　米ドル");
            khTtdkkanryouBean.setIrTekiyou6("解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(6.66, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("　（３）適用為替レート");
            khTtdkkanryouBean.setIrTekiyou7("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(7.77, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("　　　１１０．００円／米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(8.88, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("必要書類の受付日翌日から５営業日を超えた");
            khTtdkkanryouBean.setIrTekiyou9("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("１０日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(1.88, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888882L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【解約返戻金額について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　解約返戻金額は当社の定める書類が当社の指定した場所に到着した日の翌日から1ヶ月経過した日(解約");
            khTtdkkanryouBean.setIrOsirasemongon3("　日）末の保険料積立金額に市場価格調整(※)を適用した額です。  ");
            khTtdkkanryouBean.setIrOsirasemongon4("　※市場価格調整とは、市場金利の変動に応じた運用資産の価格変動が解約返戻金額に反映される仕組み");
            khTtdkkanryouBean.setIrOsirasemongon5("　　のことです。");
            khTtdkkanryouBean.setIrOsirasemongon6("");
            khTtdkkanryouBean.setIrOsirasemongon7("【適用した為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon8("　解約日における当社が指標として使用する金融機関が公示する「対顧客電信売買相場仲値（TTM）－５０銭」");
            khTtdkkanryouBean.setIrOsirasemongon9("　となります。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆一時所得として総所得に算入される金額＝｛収入金額-必要経費-特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon13("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆計算結果がプラスの場合、他の所得と合算され所得税の課税対象となります。確定申告が必要な場合は、");
            khTtdkkanryouBean.setIrOsirasemongon15("");
            khTtdkkanryouBean.setIrOsirasemongon16("　◆一時所得の特別控除は、年間の一時所得（収入金額－必要経費）の合計額に対して５０万円です。");
            khTtdkkanryouBean.setIrOsirasemongon17("　◆所轄税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("");
            khTtdkkanryouBean.setIrOsirasemongon20("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);


            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("");
            bzKokyakuAtesakiBean.setIrShsyno("");
            bzKokyakuAtesakiBean.setIrShadr1kj("");
            bzKokyakuAtesakiBean.setIrShadr2kj("");
            bzKokyakuAtesakiBean.setIrShadr3kj("");
            bzKokyakuAtesakiBean.setIrShsnmkj("");
            bzKokyakuAtesakiBean.setIrToiawaseyno("");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("");
            bzKokyakuAtesakiBean.setIrHknkisynm("");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("");
            bzKokyakuAtesakiBean.setIrToiawasetelno("");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("");

            khTtdkkanryouBean.setIrTetudukisyukbn(null);
            khTtdkkanryouBean.setIrSyono("");
            khTtdkkanryouBean.setIrKyknmkj("");
            khTtdkkanryouBean.setIrHhknnmkj("");
            khTtdkkanryouBean.setIrShrymd("");
            khTtdkkanryouBean.setIrKaiykymd("");

            khTtdkkanryouBean.setIrTekiyou1("");
            khTtdkkanryouBean.setIrKngkmeisai1(null);
            khTtdkkanryouBean.setIrBikou1("");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("");
            khTtdkkanryouBean.setIrTekiyou8("");
            khTtdkkanryouBean.setIrKngkmeisai8(null);
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9("");
            khTtdkkanryouBean.setIrKngkmeisai9(null);
            khTtdkkanryouBean.setIrBikou9("");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(1));
            khTtdkkanryouBean.setIrBanknmkj("");
            khTtdkkanryouBean.setIrSitennmkj("");
            khTtdkkanryouBean.setIrYokinkbn(null);
            khTtdkkanryouBean.setIrKouzano("");
            khTtdkkanryouBean.setIrKzmeiginmkn("");
            khTtdkkanryouBean.setIrSynykngk(null);
            khTtdkkanryouBean.setIrHtykeihi(null);
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(null);
            khTtdkkanryouBean.setIrKazeinendo("");

            khTtdkkanryouBean.setIrOsirasemongon1("");
            khTtdkkanryouBean.setIrOsirasemongon2("");
            khTtdkkanryouBean.setIrOsirasemongon3("");
            khTtdkkanryouBean.setIrOsirasemongon4("");
            khTtdkkanryouBean.setIrOsirasemongon5("");
            khTtdkkanryouBean.setIrOsirasemongon6("");
            khTtdkkanryouBean.setIrOsirasemongon7("");
            khTtdkkanryouBean.setIrOsirasemongon8("");
            khTtdkkanryouBean.setIrOsirasemongon9("");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("");
            khTtdkkanryouBean.setIrOsirasemongon12("");
            khTtdkkanryouBean.setIrOsirasemongon13("");
            khTtdkkanryouBean.setIrOsirasemongon14("");
            khTtdkkanryouBean.setIrOsirasemongon15("");
            khTtdkkanryouBean.setIrOsirasemongon16("");
            khTtdkkanryouBean.setIrOsirasemongon17("");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("");
            khTtdkkanryouBean.setIrOsirasemongon20("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);


            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(null);
            bzKokyakuAtesakiBean.setIrShsyno(null);
            bzKokyakuAtesakiBean.setIrShadr1kj(null);
            bzKokyakuAtesakiBean.setIrShadr2kj(null);
            bzKokyakuAtesakiBean.setIrShadr3kj(null);
            bzKokyakuAtesakiBean.setIrShsnmkj(null);
            bzKokyakuAtesakiBean.setIrToiawaseyno(null);
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj(null);
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj(null);
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj(null);
            bzKokyakuAtesakiBean.setIrHknkisynm(null);
            bzKokyakuAtesakiBean.setIrToiawasesosiki(null);
            bzKokyakuAtesakiBean.setIrToiawasetelno(null);
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1(null);
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2(null);

            khTtdkkanryouBean.setIrTetudukisyukbn(null);
            khTtdkkanryouBean.setIrSyono(null);
            khTtdkkanryouBean.setIrKyknmkj(null);
            khTtdkkanryouBean.setIrHhknnmkj(null);
            khTtdkkanryouBean.setIrShrymd(null);
            khTtdkkanryouBean.setIrKaiykymd(null);

            khTtdkkanryouBean.setIrTekiyou1(null);
            khTtdkkanryouBean.setIrKngkmeisai1(null);
            khTtdkkanryouBean.setIrBikou1(null);
            khTtdkkanryouBean.setIrTekiyou2(null);
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2(null);
            khTtdkkanryouBean.setIrTekiyou3(null);
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3(null);
            khTtdkkanryouBean.setIrTekiyou4(null);
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4(null);
            khTtdkkanryouBean.setIrTekiyou5(null);
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5(null);
            khTtdkkanryouBean.setIrTekiyou6(null);
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6(null);
            khTtdkkanryouBean.setIrTekiyou7(null);
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7(null);
            khTtdkkanryouBean.setIrTekiyou8(null);
            khTtdkkanryouBean.setIrKngkmeisai8(null);
            khTtdkkanryouBean.setIrBikou8(null);
            khTtdkkanryouBean.setIrTekiyou9(null);
            khTtdkkanryouBean.setIrKngkmeisai9(null);
            khTtdkkanryouBean.setIrBikou9(null);

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(1));
            khTtdkkanryouBean.setIrBanknmkj(null);
            khTtdkkanryouBean.setIrSitennmkj(null);
            khTtdkkanryouBean.setIrYokinkbn(null);
            khTtdkkanryouBean.setIrKouzano(null);
            khTtdkkanryouBean.setIrKzmeiginmkn(null);
            khTtdkkanryouBean.setIrSynykngk(null);
            khTtdkkanryouBean.setIrHtykeihi(null);
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(null);
            khTtdkkanryouBean.setIrKazeinendo(null);

            khTtdkkanryouBean.setIrOsirasemongon1(null);
            khTtdkkanryouBean.setIrOsirasemongon2(null);
            khTtdkkanryouBean.setIrOsirasemongon3(null);
            khTtdkkanryouBean.setIrOsirasemongon4(null);
            khTtdkkanryouBean.setIrOsirasemongon5(null);
            khTtdkkanryouBean.setIrOsirasemongon6(null);
            khTtdkkanryouBean.setIrOsirasemongon7(null);
            khTtdkkanryouBean.setIrOsirasemongon8(null);
            khTtdkkanryouBean.setIrOsirasemongon9(null);
            khTtdkkanryouBean.setIrOsirasemongon10(null);
            khTtdkkanryouBean.setIrOsirasemongon11(null);
            khTtdkkanryouBean.setIrOsirasemongon12(null);
            khTtdkkanryouBean.setIrOsirasemongon13(null);
            khTtdkkanryouBean.setIrOsirasemongon14(null);
            khTtdkkanryouBean.setIrOsirasemongon15(null);
            khTtdkkanryouBean.setIrOsirasemongon16(null);
            khTtdkkanryouBean.setIrOsirasemongon17(null);
            khTtdkkanryouBean.setIrOsirasemongon18(null);
            khTtdkkanryouBean.setIrOsirasemongon19(null);
            khTtdkkanryouBean.setIrOsirasemongon20(null);


            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999l));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999L));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999L));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999L));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999L));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999L));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999L));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999L));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999L));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999L));
            khTtdkkanryouBean.setIrBanknmkj("");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1("保険料積立金額（Ａ）");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(111.11, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（（１）＋（２））×（３）");
            khTtdkkanryouBean.setIrTekiyou2("市場価格調整額（Ｂ）");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(222.22, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou2("　（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("解約返戻金額（Ａ＋Ｂ）");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(333.33, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou3("　　　１０５００．００　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(444.44, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou4("　（２）市場価格調整額");
            khTtdkkanryouBean.setIrTekiyou5("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(555.55, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou5("　　　５００．００　米ドル");
            khTtdkkanryouBean.setIrTekiyou6("解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(666.66, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou6("　（３）適用為替レート");
            khTtdkkanryouBean.setIrTekiyou7("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(777.77, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou7("　　　１１０．００円／米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(888.88, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("必要書類の受付日翌日から５営業日を超えた");
            khTtdkkanryouBean.setIrTekiyou9("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(999.99, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("１０日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(188.88, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888882L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【解約返戻金額について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　解約返戻金額は当社の定める書類が当社の指定した場所に到着した日の翌日から1ヶ月経過した日(解約");
            khTtdkkanryouBean.setIrOsirasemongon3("　日）末の保険料積立金額に市場価格調整(※)を適用した額です。  ");
            khTtdkkanryouBean.setIrOsirasemongon4("　※市場価格調整とは、市場金利の変動に応じた運用資産の価格変動が解約返戻金額に反映される仕組み");
            khTtdkkanryouBean.setIrOsirasemongon5("　　のことです。");
            khTtdkkanryouBean.setIrOsirasemongon6("");
            khTtdkkanryouBean.setIrOsirasemongon7("【適用した為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon8("　解約日における当社が指標として使用する金融機関が公示する「対顧客電信売買相場仲値（TTM）－５０銭」");
            khTtdkkanryouBean.setIrOsirasemongon9("　となります。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆一時所得として総所得に算入される金額＝｛収入金額-必要経費-特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon13("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆計算結果がプラスの場合、他の所得と合算され所得税の課税対象となります。確定申告が必要な場合は、");
            khTtdkkanryouBean.setIrOsirasemongon15("");
            khTtdkkanryouBean.setIrOsirasemongon16("　◆一時所得の特別控除は、年間の一時所得（収入金額－必要経費）の合計額に対して５０万円です。");
            khTtdkkanryouBean.setIrOsirasemongon17("　◆所轄税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("");
            khTtdkkanryouBean.setIrOsirasemongon20("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);


            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("");
            bzKokyakuAtesakiBean.setIrShsyno("");
            bzKokyakuAtesakiBean.setIrShadr1kj("");
            bzKokyakuAtesakiBean.setIrShadr2kj("");
            bzKokyakuAtesakiBean.setIrShadr3kj("");
            bzKokyakuAtesakiBean.setIrShsnmkj("");
            bzKokyakuAtesakiBean.setIrToiawaseyno("");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("");
            bzKokyakuAtesakiBean.setIrHknkisynm("");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("");
            bzKokyakuAtesakiBean.setIrToiawasetelno("");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("");

            khTtdkkanryouBean.setIrTetudukisyukbn(null);
            khTtdkkanryouBean.setIrSyono("");
            khTtdkkanryouBean.setIrKyknmkj("");
            khTtdkkanryouBean.setIrHhknnmkj("");
            khTtdkkanryouBean.setIrShrymd("");
            khTtdkkanryouBean.setIrKaiykymd("");

            khTtdkkanryouBean.setIrTekiyou1("");
            khTtdkkanryouBean.setIrKngkmeisai1(null);
            khTtdkkanryouBean.setIrBikou1("");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("");
            khTtdkkanryouBean.setIrTekiyou8("");
            khTtdkkanryouBean.setIrKngkmeisai8(null);
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9("");
            khTtdkkanryouBean.setIrKngkmeisai9(null);
            khTtdkkanryouBean.setIrBikou9("");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(1));
            khTtdkkanryouBean.setIrBanknmkj("");
            khTtdkkanryouBean.setIrSitennmkj("");
            khTtdkkanryouBean.setIrYokinkbn(null);
            khTtdkkanryouBean.setIrKouzano("");
            khTtdkkanryouBean.setIrKzmeiginmkn("");
            khTtdkkanryouBean.setIrSynykngk(null);
            khTtdkkanryouBean.setIrHtykeihi(null);
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(null);
            khTtdkkanryouBean.setIrKazeinendo("");

            khTtdkkanryouBean.setIrOsirasemongon1("");
            khTtdkkanryouBean.setIrOsirasemongon2("");
            khTtdkkanryouBean.setIrOsirasemongon3("");
            khTtdkkanryouBean.setIrOsirasemongon4("");
            khTtdkkanryouBean.setIrOsirasemongon5("");
            khTtdkkanryouBean.setIrOsirasemongon6("");
            khTtdkkanryouBean.setIrOsirasemongon7("");
            khTtdkkanryouBean.setIrOsirasemongon8("");
            khTtdkkanryouBean.setIrOsirasemongon9("");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("");
            khTtdkkanryouBean.setIrOsirasemongon12("");
            khTtdkkanryouBean.setIrOsirasemongon13("");
            khTtdkkanryouBean.setIrOsirasemongon14("");
            khTtdkkanryouBean.setIrOsirasemongon15("");
            khTtdkkanryouBean.setIrOsirasemongon16("");
            khTtdkkanryouBean.setIrOsirasemongon17("");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("");
            khTtdkkanryouBean.setIrOsirasemongon20("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);



            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(null);
            bzKokyakuAtesakiBean.setIrShsyno(null);
            bzKokyakuAtesakiBean.setIrShadr1kj(null);
            bzKokyakuAtesakiBean.setIrShadr2kj(null);
            bzKokyakuAtesakiBean.setIrShadr3kj(null);
            bzKokyakuAtesakiBean.setIrShsnmkj(null);
            bzKokyakuAtesakiBean.setIrToiawaseyno(null);
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj(null);
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj(null);
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj(null);
            bzKokyakuAtesakiBean.setIrHknkisynm(null);
            bzKokyakuAtesakiBean.setIrToiawasesosiki(null);
            bzKokyakuAtesakiBean.setIrToiawasetelno(null);
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1(null);
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2(null);

            khTtdkkanryouBean.setIrTetudukisyukbn(null);
            khTtdkkanryouBean.setIrSyono(null);
            khTtdkkanryouBean.setIrKyknmkj(null);
            khTtdkkanryouBean.setIrHhknnmkj(null);
            khTtdkkanryouBean.setIrShrymd(null);
            khTtdkkanryouBean.setIrKaiykymd(null);

            khTtdkkanryouBean.setIrTekiyou1(null);
            khTtdkkanryouBean.setIrKngkmeisai1(null);
            khTtdkkanryouBean.setIrBikou1(null);
            khTtdkkanryouBean.setIrTekiyou2(null);
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2(null);
            khTtdkkanryouBean.setIrTekiyou3(null);
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3(null);
            khTtdkkanryouBean.setIrTekiyou4(null);
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4(null);
            khTtdkkanryouBean.setIrTekiyou5(null);
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5(null);
            khTtdkkanryouBean.setIrTekiyou6(null);
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6(null);
            khTtdkkanryouBean.setIrTekiyou7(null);
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7(null);
            khTtdkkanryouBean.setIrTekiyou8(null);
            khTtdkkanryouBean.setIrKngkmeisai8(null);
            khTtdkkanryouBean.setIrBikou8(null);
            khTtdkkanryouBean.setIrTekiyou9(null);
            khTtdkkanryouBean.setIrKngkmeisai9(null);
            khTtdkkanryouBean.setIrBikou9(null);

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(1));
            khTtdkkanryouBean.setIrBanknmkj(null);
            khTtdkkanryouBean.setIrSitennmkj(null);
            khTtdkkanryouBean.setIrYokinkbn(null);
            khTtdkkanryouBean.setIrKouzano(null);
            khTtdkkanryouBean.setIrKzmeiginmkn(null);
            khTtdkkanryouBean.setIrSynykngk(null);
            khTtdkkanryouBean.setIrHtykeihi(null);
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(null);
            khTtdkkanryouBean.setIrKazeinendo(null);

            khTtdkkanryouBean.setIrOsirasemongon1(null);
            khTtdkkanryouBean.setIrOsirasemongon2(null);
            khTtdkkanryouBean.setIrOsirasemongon3(null);
            khTtdkkanryouBean.setIrOsirasemongon4(null);
            khTtdkkanryouBean.setIrOsirasemongon5(null);
            khTtdkkanryouBean.setIrOsirasemongon6(null);
            khTtdkkanryouBean.setIrOsirasemongon7(null);
            khTtdkkanryouBean.setIrOsirasemongon8(null);
            khTtdkkanryouBean.setIrOsirasemongon9(null);
            khTtdkkanryouBean.setIrOsirasemongon10(null);
            khTtdkkanryouBean.setIrOsirasemongon11(null);
            khTtdkkanryouBean.setIrOsirasemongon12(null);
            khTtdkkanryouBean.setIrOsirasemongon13(null);
            khTtdkkanryouBean.setIrOsirasemongon14(null);
            khTtdkkanryouBean.setIrOsirasemongon15(null);
            khTtdkkanryouBean.setIrOsirasemongon16(null);
            khTtdkkanryouBean.setIrOsirasemongon17(null);
            khTtdkkanryouBean.setIrOsirasemongon18(null);
            khTtdkkanryouBean.setIrOsirasemongon19(null);
            khTtdkkanryouBean.setIrOsirasemongon20(null);


            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);


            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1("保険料積立金額（Ａ）");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(1111.11, BizCurrencyTypes.EURO));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（（１）＋（２））×（３）");
            khTtdkkanryouBean.setIrTekiyou2("市場価格調整額（Ｂ）");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(2222.22, BizCurrencyTypes.EURO));
            khTtdkkanryouBean.setIrBikou2("　（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("解約返戻金額（Ａ＋Ｂ）");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(3333.33, BizCurrencyTypes.EURO));
            khTtdkkanryouBean.setIrBikou3("　　　１０５００．００　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(4444.44, BizCurrencyTypes.EURO));
            khTtdkkanryouBean.setIrBikou4("　（２）市場価格調整額");
            khTtdkkanryouBean.setIrTekiyou5("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(5555.55, BizCurrencyTypes.EURO));
            khTtdkkanryouBean.setIrBikou5("　　　５００．００　米ドル");
            khTtdkkanryouBean.setIrTekiyou6("解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(6666.66, BizCurrencyTypes.EURO));
            khTtdkkanryouBean.setIrBikou6("　（３）適用為替レート");
            khTtdkkanryouBean.setIrTekiyou7("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(7777.77, BizCurrencyTypes.EURO));
            khTtdkkanryouBean.setIrBikou7("　　　１１０．００円／米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(8888.88, BizCurrencyTypes.EURO));
            khTtdkkanryouBean.setIrBikou8("必要書類の受付日翌日から５営業日を超えた");
            khTtdkkanryouBean.setIrTekiyou9("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999.99, BizCurrencyTypes.EURO));
            khTtdkkanryouBean.setIrBikou9("１０日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(1888.88, BizCurrencyTypes.EURO));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888881));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888882));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888883));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【解約返戻金額について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　解約返戻金額は当社の定める書類が当社の指定した場所に到着した日の翌日から1ヶ月経過した日(解約");
            khTtdkkanryouBean.setIrOsirasemongon3("　日）末の保険料積立金額に市場価格調整(※)を適用した額です。  ");
            khTtdkkanryouBean.setIrOsirasemongon4("　※市場価格調整とは、市場金利の変動に応じた運用資産の価格変動が解約返戻金額に反映される仕組み");
            khTtdkkanryouBean.setIrOsirasemongon5("　　のことです。");
            khTtdkkanryouBean.setIrOsirasemongon6("");
            khTtdkkanryouBean.setIrOsirasemongon7("【適用した為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon8("　解約日における当社が指標として使用する金融機関が公示する「対顧客電信売買相場仲値（TTM）－５０銭」");
            khTtdkkanryouBean.setIrOsirasemongon9("　となります。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆一時所得として総所得に算入される金額＝｛収入金額-必要経費-特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon13("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆計算結果がプラスの場合、他の所得と合算され所得税の課税対象となります。確定申告が必要な場合は、");
            khTtdkkanryouBean.setIrOsirasemongon15("");
            khTtdkkanryouBean.setIrOsirasemongon16("　◆一時所得の特別控除は、年間の一時所得（収入金額－必要経費）の合計額に対して５０万円です。");
            khTtdkkanryouBean.setIrOsirasemongon17("　◆所轄税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("");
            khTtdkkanryouBean.setIrOsirasemongon20("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);


            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1("保険料積立金額（Ａ）");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(1111111.11, BizCurrencyTypes.AU_DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（（１）＋（２））×（３）");
            khTtdkkanryouBean.setIrTekiyou2("市場価格調整額（Ｂ）");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(2222222.22, BizCurrencyTypes.AU_DOLLAR));
            khTtdkkanryouBean.setIrBikou2("　（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("解約返戻金額（Ａ＋Ｂ）");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(3333333.33, BizCurrencyTypes.AU_DOLLAR));
            khTtdkkanryouBean.setIrBikou3("　　　１０５００．００　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(4444444.44, BizCurrencyTypes.AU_DOLLAR));
            khTtdkkanryouBean.setIrBikou4("　（２）市場価格調整額");
            khTtdkkanryouBean.setIrTekiyou5("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(5555555.55, BizCurrencyTypes.AU_DOLLAR));
            khTtdkkanryouBean.setIrBikou5("　　　５００．００　米ドル");
            khTtdkkanryouBean.setIrTekiyou6("解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(6666666.66, BizCurrencyTypes.AU_DOLLAR));
            khTtdkkanryouBean.setIrBikou6("　（３）適用為替レート");
            khTtdkkanryouBean.setIrTekiyou7("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(7777777.77, BizCurrencyTypes.AU_DOLLAR));
            khTtdkkanryouBean.setIrBikou7("　　　１１０．００円／米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(8888888.88, BizCurrencyTypes.AU_DOLLAR));
            khTtdkkanryouBean.setIrBikou8("必要書類の受付日翌日から５営業日を超えた");
            khTtdkkanryouBean.setIrTekiyou9("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999.99, BizCurrencyTypes.AU_DOLLAR));
            khTtdkkanryouBean.setIrBikou9("１０日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(1888888.88, BizCurrencyTypes.AU_DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8881));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8882));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8883));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【解約返戻金額について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　解約返戻金額は当社の定める書類が当社の指定した場所に到着した日の翌日から1ヶ月経過した日(解約");
            khTtdkkanryouBean.setIrOsirasemongon3("　日）末の保険料積立金額に市場価格調整(※)を適用した額です。  ");
            khTtdkkanryouBean.setIrOsirasemongon4("　※市場価格調整とは、市場金利の変動に応じた運用資産の価格変動が解約返戻金額に反映される仕組み");
            khTtdkkanryouBean.setIrOsirasemongon5("　　のことです。");
            khTtdkkanryouBean.setIrOsirasemongon6("");
            khTtdkkanryouBean.setIrOsirasemongon7("【適用した為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon8("　解約日における当社が指標として使用する金融機関が公示する「対顧客電信売買相場仲値（TTM）－５０銭」");
            khTtdkkanryouBean.setIrOsirasemongon9("　となります。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆一時所得として総所得に算入される金額＝｛収入金額-必要経費-特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon13("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆計算結果がプラスの場合、他の所得と合算され所得税の課税対象となります。確定申告が必要な場合は、");
            khTtdkkanryouBean.setIrOsirasemongon15("");
            khTtdkkanryouBean.setIrOsirasemongon16("　◆一時所得の特別控除は、年間の一時所得（収入金額－必要経費）の合計額に対して５０万円です。");
            khTtdkkanryouBean.setIrOsirasemongon17("　◆所轄税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("");
            khTtdkkanryouBean.setIrOsirasemongon20("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1("保険料積立金額（Ａ）");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(111, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（（１）＋（２））×（３）");
            khTtdkkanryouBean.setIrTekiyou2("市場価格調整額（Ｂ）");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(222, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("　（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("解約返戻金額（Ａ＋Ｂ）");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(333, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("　　　１０５００．００　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(444, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("　（２）市場価格調整額");
            khTtdkkanryouBean.setIrTekiyou5("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(555, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("　　　５００．００　米ドル");
            khTtdkkanryouBean.setIrTekiyou6("解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(666, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("　（３）適用為替レート");
            khTtdkkanryouBean.setIrTekiyou7("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(777, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("　　　１１０．００円／米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(888, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("必要書類の受付日翌日から５営業日を超えた");
            khTtdkkanryouBean.setIrTekiyou9("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(999, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("１０日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(188, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(881));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(882));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(883));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【解約返戻金額について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　解約返戻金額は当社の定める書類が当社の指定した場所に到着した日の翌日から1ヶ月経過した日(解約");
            khTtdkkanryouBean.setIrOsirasemongon3("　日）末の保険料積立金額に市場価格調整(※)を適用した額です。  ");
            khTtdkkanryouBean.setIrOsirasemongon4("　※市場価格調整とは、市場金利の変動に応じた運用資産の価格変動が解約返戻金額に反映される仕組み");
            khTtdkkanryouBean.setIrOsirasemongon5("　　のことです。");
            khTtdkkanryouBean.setIrOsirasemongon6("");
            khTtdkkanryouBean.setIrOsirasemongon7("【適用した為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon8("　解約日における当社が指標として使用する金融機関が公示する「対顧客電信売買相場仲値（TTM）－５０銭」");
            khTtdkkanryouBean.setIrOsirasemongon9("　となります。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆一時所得として総所得に算入される金額＝｛収入金額-必要経費-特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon13("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆計算結果がプラスの場合、他の所得と合算され所得税の課税対象となります。確定申告が必要な場合は、");
            khTtdkkanryouBean.setIrOsirasemongon15("");
            khTtdkkanryouBean.setIrOsirasemongon16("　◆一時所得の特別控除は、年間の一時所得（収入金額－必要経費）の合計額に対して５０万円です。");
            khTtdkkanryouBean.setIrOsirasemongon17("　◆所轄税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("");
            khTtdkkanryouBean.setIrOsirasemongon20("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1("保険料積立金額（Ａ）");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(111.1, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（（１）＋（２））×（３）");
            khTtdkkanryouBean.setIrTekiyou2("市場価格調整額（Ｂ）");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(222.2, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("　（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("解約返戻金額（Ａ＋Ｂ）");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(333.3, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("　　　１０５００．００　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(444.4, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("　（２）市場価格調整額");
            khTtdkkanryouBean.setIrTekiyou5("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(555.5, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("　　　５００．００　米ドル");
            khTtdkkanryouBean.setIrTekiyou6("解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(666.6, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("　（３）適用為替レート");
            khTtdkkanryouBean.setIrTekiyou7("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(777.7, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("　　　１１０．００円／米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(888.8, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("必要書類の受付日翌日から５営業日を超えた");
            khTtdkkanryouBean.setIrTekiyou9("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(999.9, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("１０日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(188.8, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(1));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(2));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(3));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【解約返戻金額について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　解約返戻金額は当社の定める書類が当社の指定した場所に到着した日の翌日から1ヶ月経過した日(解約");
            khTtdkkanryouBean.setIrOsirasemongon3("　日）末の保険料積立金額に市場価格調整(※)を適用した額です。  ");
            khTtdkkanryouBean.setIrOsirasemongon4("　※市場価格調整とは、市場金利の変動に応じた運用資産の価格変動が解約返戻金額に反映される仕組み");
            khTtdkkanryouBean.setIrOsirasemongon5("　　のことです。");
            khTtdkkanryouBean.setIrOsirasemongon6("");
            khTtdkkanryouBean.setIrOsirasemongon7("【適用した為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon8("　解約日における当社が指標として使用する金融機関が公示する「対顧客電信売買相場仲値（TTM）－５０銭」");
            khTtdkkanryouBean.setIrOsirasemongon9("　となります。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆一時所得として総所得に算入される金額＝｛収入金額-必要経費-特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon13("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆計算結果がプラスの場合、他の所得と合算され所得税の課税対象となります。確定申告が必要な場合は、");
            khTtdkkanryouBean.setIrOsirasemongon15("");
            khTtdkkanryouBean.setIrOsirasemongon16("　◆一時所得の特別控除は、年間の一時所得（収入金額－必要経費）の合計額に対して５０万円です。");
            khTtdkkanryouBean.setIrOsirasemongon17("　◆所轄税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("");
            khTtdkkanryouBean.setIrOsirasemongon20("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1("保険料積立金額（Ａ）");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(1));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（（１）＋（２））×（３）");
            khTtdkkanryouBean.setIrTekiyou2("市場価格調整額（Ｂ）");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(2));
            khTtdkkanryouBean.setIrBikou2("　（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("解約返戻金額（Ａ＋Ｂ）");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(3));
            khTtdkkanryouBean.setIrBikou3("　　　１０５００．００　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(4));
            khTtdkkanryouBean.setIrBikou4("　（２）市場価格調整額");
            khTtdkkanryouBean.setIrTekiyou5("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(5));
            khTtdkkanryouBean.setIrBikou5("　　　５００．００　米ドル");
            khTtdkkanryouBean.setIrTekiyou6("解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(6));
            khTtdkkanryouBean.setIrBikou6("　（３）適用為替レート");
            khTtdkkanryouBean.setIrTekiyou7("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(7));
            khTtdkkanryouBean.setIrBikou7("　　　１１０．００円／米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(8));
            khTtdkkanryouBean.setIrBikou8("必要書類の受付日翌日から５営業日を超えた");
            khTtdkkanryouBean.setIrTekiyou9("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9));
            khTtdkkanryouBean.setIrBikou9("１０日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(1));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888882L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【解約返戻金額について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　解約返戻金額は当社の定める書類が当社の指定した場所に到着した日の翌日から1ヶ月経過した日(解約");
            khTtdkkanryouBean.setIrOsirasemongon3("　日）末の保険料積立金額に市場価格調整(※)を適用した額です。  ");
            khTtdkkanryouBean.setIrOsirasemongon4("　※市場価格調整とは、市場金利の変動に応じた運用資産の価格変動が解約返戻金額に反映される仕組み");
            khTtdkkanryouBean.setIrOsirasemongon5("　　のことです。");
            khTtdkkanryouBean.setIrOsirasemongon6("");
            khTtdkkanryouBean.setIrOsirasemongon7("【適用した為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon8("　解約日における当社が指標として使用する金融機関が公示する「対顧客電信売買相場仲値（TTM）－５０銭」");
            khTtdkkanryouBean.setIrOsirasemongon9("　となります。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆一時所得として総所得に算入される金額＝｛収入金額-必要経費-特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon13("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆計算結果がプラスの場合、他の所得と合算され所得税の課税対象となります。確定申告が必要な場合は、");
            khTtdkkanryouBean.setIrOsirasemongon15("");
            khTtdkkanryouBean.setIrOsirasemongon16("　◆一時所得の特別控除は、年間の一時所得（収入金額－必要経費）の合計額に対して５０万円です。");
            khTtdkkanryouBean.setIrOsirasemongon17("　◆所轄税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("");
            khTtdkkanryouBean.setIrOsirasemongon20("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1("保険料積立金額（Ａ）");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(111111));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（（１）＋（２））×（３）");
            khTtdkkanryouBean.setIrTekiyou2("市場価格調整額（Ｂ）");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(222222));
            khTtdkkanryouBean.setIrBikou2("　（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("解約返戻金額（Ａ＋Ｂ）");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(333333));
            khTtdkkanryouBean.setIrBikou3("　　　１０５００．００　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(444444));
            khTtdkkanryouBean.setIrBikou4("　（２）市場価格調整額");
            khTtdkkanryouBean.setIrTekiyou5("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(555555));
            khTtdkkanryouBean.setIrBikou5("　　　５００．００　米ドル");
            khTtdkkanryouBean.setIrTekiyou6("解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(666666));
            khTtdkkanryouBean.setIrBikou6("　（３）適用為替レート");
            khTtdkkanryouBean.setIrTekiyou7("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(777777));
            khTtdkkanryouBean.setIrBikou7("　　　１１０．００円／米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(888888));
            khTtdkkanryouBean.setIrBikou8("必要書類の受付日翌日から５営業日を超えた");
            khTtdkkanryouBean.setIrTekiyou9("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(999999));
            khTtdkkanryouBean.setIrBikou9("１０日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(188888));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888882L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【解約返戻金額について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　解約返戻金額は当社の定める書類が当社の指定した場所に到着した日の翌日から1ヶ月経過した日(解約");
            khTtdkkanryouBean.setIrOsirasemongon3("　日）末の保険料積立金額に市場価格調整(※)を適用した額です。  ");
            khTtdkkanryouBean.setIrOsirasemongon4("　※市場価格調整とは、市場金利の変動に応じた運用資産の価格変動が解約返戻金額に反映される仕組み");
            khTtdkkanryouBean.setIrOsirasemongon5("　　のことです。");
            khTtdkkanryouBean.setIrOsirasemongon6("");
            khTtdkkanryouBean.setIrOsirasemongon7("【適用した為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon8("　解約日における当社が指標として使用する金融機関が公示する「対顧客電信売買相場仲値（TTM）－５０銭」");
            khTtdkkanryouBean.setIrOsirasemongon9("　となります。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆一時所得として総所得に算入される金額＝｛収入金額-必要経費-特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon13("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆計算結果がプラスの場合、他の所得と合算され所得税の課税対象となります。確定申告が必要な場合は、");
            khTtdkkanryouBean.setIrOsirasemongon15("");
            khTtdkkanryouBean.setIrOsirasemongon16("　◆一時所得の特別控除は、年間の一時所得（収入金額－必要経費）の合計額に対して５０万円です。");
            khTtdkkanryouBean.setIrOsirasemongon17("　◆所轄税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("");
            khTtdkkanryouBean.setIrOsirasemongon20("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("問合せ先電話受付可能時間１");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("問合せ先電話受付可能時間２");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1("保険料積立金額（Ａ）");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(1111111111));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（（１）＋（２））×（３）");
            khTtdkkanryouBean.setIrTekiyou2("市場価格調整額（Ｂ）");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(2222222222L));
            khTtdkkanryouBean.setIrBikou2("　（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("解約返戻金額（Ａ＋Ｂ）");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(3333333333L));
            khTtdkkanryouBean.setIrBikou3("　　　１０５００．００　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(4444444444L));
            khTtdkkanryouBean.setIrBikou4("　（２）市場価格調整額");
            khTtdkkanryouBean.setIrTekiyou5("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(5555555555L));
            khTtdkkanryouBean.setIrBikou5("　　　５００．００　米ドル");
            khTtdkkanryouBean.setIrTekiyou6("解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(6666666666L));
            khTtdkkanryouBean.setIrBikou6("　（３）適用為替レート");
            khTtdkkanryouBean.setIrTekiyou7("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(7777777777L));
            khTtdkkanryouBean.setIrBikou7("　　　１１０．００円／米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(8888888888L));
            khTtdkkanryouBean.setIrBikou8("必要書類の受付日翌日から５営業日を超えた");
            khTtdkkanryouBean.setIrTekiyou9("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(1234567890));
            khTtdkkanryouBean.setIrBikou9("１０日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(1888888888));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(888881));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(888882));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(888883));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【解約返戻金額について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　解約返戻金額は当社の定める書類が当社の指定した場所に到着した日の翌日から1ヶ月経過した日(解約");
            khTtdkkanryouBean.setIrOsirasemongon3("　日）末の保険料積立金額に市場価格調整(※)を適用した額です。  ");
            khTtdkkanryouBean.setIrOsirasemongon4("　※市場価格調整とは、市場金利の変動に応じた運用資産の価格変動が解約返戻金額に反映される仕組み");
            khTtdkkanryouBean.setIrOsirasemongon5("　　のことです。");
            khTtdkkanryouBean.setIrOsirasemongon6("");
            khTtdkkanryouBean.setIrOsirasemongon7("【適用した為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon8("　解約日における当社が指標として使用する金融機関が公示する「対顧客電信売買相場仲値（TTM）－５０銭」");
            khTtdkkanryouBean.setIrOsirasemongon9("　となります。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆一時所得として総所得に算入される金額＝｛収入金額-必要経費-特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon13("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆計算結果がプラスの場合、他の所得と合算され所得税の課税対象となります。確定申告が必要な場合は、");
            khTtdkkanryouBean.setIrOsirasemongon15("");
            khTtdkkanryouBean.setIrOsirasemongon16("　◆一時所得の特別控除は、年間の一時所得（収入金額－必要経費）の合計額に対して５０万円です。");
            khTtdkkanryouBean.setIrOsirasemongon17("　◆所轄税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("");
            khTtdkkanryouBean.setIrOsirasemongon20("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");


            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.BLNK);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.BLNK);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.SKS);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.SKS);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(0));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testCreateReport21() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(0));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testCreateReport22() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(0));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testCreateReport23() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(0));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testCreateReport24() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.BLNK);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testCreateReport25() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBanknmkj("");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.BLNK);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testCreateReport26() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(0));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.BLNK);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testCreateReport27() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(0));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.BLNK);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testCreateReport28() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_ADRHNK_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.ADRHNK);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_ADRHNK_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(290)
    @Transactional
    public void testCreateReport29() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_ADRHNK_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.ADRHNK);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_ADRHNK_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(300)
    @Transactional
    public void testCreateReport30() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_ADRHNK_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.ADRHNK);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_ADRHNK_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(310)
    @Transactional
    public void testCreateReport31() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_ADRHNK_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.ADRHNK);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_ADRHNK_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(320)
    @Transactional
    public void testCreateReport32() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(0));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.SKS);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(330)
    @Transactional
    public void testCreateReport33() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.SKS);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }


    @Test
    @TestOrder(340)
    @Transactional
    public void testCreateReport34() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(350)
    @Transactional
    public void testCreateReport35() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }
    @Test
    @TestOrder(360)
    @Transactional
    public void testCreateReport36() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseteluktkkanou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.TARGETSYUUSINKAIYAKU);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("ＷＷ99年99月99日");
            khTtdkkanryouBean.setIrKaiykymd("ＷＷ99年99月99日");

            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou3("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai3(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou4("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai4(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou5("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai5(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou6("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai6(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou7("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai7(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou8("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou9("ＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBikou9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
            khTtdkkanryouBean.setIrKouzano("XXXXXXXXXXXX");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrKazeinendo("ＷＷ99年");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ３");
            khTtdkkanryouBean.setIrOsirasemongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ４");
            khTtdkkanryouBean.setIrOsirasemongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ５");
            khTtdkkanryouBean.setIrOsirasemongon6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ６");
            khTtdkkanryouBean.setIrOsirasemongon7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ７");
            khTtdkkanryouBean.setIrOsirasemongon8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ８");
            khTtdkkanryouBean.setIrOsirasemongon9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ９");
            khTtdkkanryouBean.setIrOsirasemongon10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
            khTtdkkanryouBean.setIrOsirasemongon11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
            khTtdkkanryouBean.setIrOsirasemongon12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
            khTtdkkanryouBean.setIrOsirasemongon13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
            khTtdkkanryouBean.setIrOsirasemongon14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
            khTtdkkanryouBean.setIrOsirasemongon15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
            khTtdkkanryouBean.setIrOsirasemongon16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
            khTtdkkanryouBean.setIrOsirasemongon17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
            khTtdkkanryouBean.setIrOsirasemongon18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
            khTtdkkanryouBean.setIrOsirasemongon19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
            khTtdkkanryouBean.setIrOsirasemongon20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(370)
    @Transactional
    public void testCreateReport37() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(null));
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888882L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.BLNK);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(2));
            khTtdkkanryouBean.setIrZeimumongon1("税務文言１");
            khTtdkkanryouBean.setIrZeimumongon2("税務文言２");
            khTtdkkanryouBean.setIrZeimumongon3("税務文言３");
            khTtdkkanryouBean.setIrZeimumongon4("税務文言４");
            khTtdkkanryouBean.setIrZeimumongon5("税務文言５");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(380)
    @Transactional
    public void testCreateReport38() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(null));
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(0));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888882L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(2));
            khTtdkkanryouBean.setIrZeimumongon1("税務文言１");
            khTtdkkanryouBean.setIrZeimumongon2("税務文言２");
            khTtdkkanryouBean.setIrZeimumongon3("税務文言３");
            khTtdkkanryouBean.setIrZeimumongon4("税務文言４");
            khTtdkkanryouBean.setIrZeimumongon5("税務文言５");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }


    @Test
    @TestOrder(390)
    @Transactional
    public void testCreateReport39() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888882L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(2));
            khTtdkkanryouBean.setIrZeimumongon1("税務文言１");
            khTtdkkanryouBean.setIrZeimumongon2("税務文言２");
            khTtdkkanryouBean.setIrZeimumongon3("税務文言３");
            khTtdkkanryouBean.setIrZeimumongon4("税務文言４");
            khTtdkkanryouBean.setIrZeimumongon5("税務文言５");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }


    @Test
    @TestOrder(400)
    @Transactional
    public void testCreateReport40() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(null));
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(0));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888882L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(2));
            khTtdkkanryouBean.setIrZeimumongon1("税務文言１");
            khTtdkkanryouBean.setIrZeimumongon2("税務文言２");
            khTtdkkanryouBean.setIrZeimumongon3("税務文言３");
            khTtdkkanryouBean.setIrZeimumongon4("税務文言４");
            khTtdkkanryouBean.setIrZeimumongon5("税務文言５");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }


    @Test
    @TestOrder(410)
    @Transactional
    public void testCreateReport41() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888882L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(2));
            khTtdkkanryouBean.setIrZeimumongon1("税務文言１");
            khTtdkkanryouBean.setIrZeimumongon2("税務文言２");
            khTtdkkanryouBean.setIrZeimumongon3("税務文言３");
            khTtdkkanryouBean.setIrZeimumongon4("税務文言４");
            khTtdkkanryouBean.setIrZeimumongon5("税務文言５");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }


    @Test
    @TestOrder(420)
    @Transactional
    public void testCreateReport42() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888882L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKSYASIBOUKAIYAKU);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(2));
            khTtdkkanryouBean.setIrZeimumongon1("税務文言１");
            khTtdkkanryouBean.setIrZeimumongon2("税務文言２");
            khTtdkkanryouBean.setIrZeimumongon3("税務文言３");
            khTtdkkanryouBean.setIrZeimumongon4("税務文言４");
            khTtdkkanryouBean.setIrZeimumongon5("税務文言５");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }


    @Test
    @TestOrder(430)
    @Transactional
    public void testCreateReport43() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(null));
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(0));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888882L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKSYASIBOUKAIYAKU);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(2));
            khTtdkkanryouBean.setIrZeimumongon1("税務文言１");
            khTtdkkanryouBean.setIrZeimumongon2("税務文言２");
            khTtdkkanryouBean.setIrZeimumongon3("税務文言３");
            khTtdkkanryouBean.setIrZeimumongon4("税務文言４");
            khTtdkkanryouBean.setIrZeimumongon5("税務文言５");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }


    @Test
    @TestOrder(440)
    @Transactional
    public void testCreateReport44() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888882L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKSYASIBOUKAIYAKU);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(2));
            khTtdkkanryouBean.setIrZeimumongon1("税務文言１");
            khTtdkkanryouBean.setIrZeimumongon2("税務文言２");
            khTtdkkanryouBean.setIrZeimumongon3("税務文言３");
            khTtdkkanryouBean.setIrZeimumongon4("税務文言４");
            khTtdkkanryouBean.setIrZeimumongon5("税務文言５");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }


    @Test
    @TestOrder(450)
    @Transactional
    public void testCreateReport45() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(null);
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.GSTSZEIGK_ARI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(null);
            khTtdkkanryouBean.setIrZeimumongon1("税務文言１");
            khTtdkkanryouBean.setIrZeimumongon2("税務文言２");
            khTtdkkanryouBean.setIrZeimumongon3("税務文言３");
            khTtdkkanryouBean.setIrZeimumongon4("税務文言４");
            khTtdkkanryouBean.setIrZeimumongon5("税務文言５");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }


    @Test
    @TestOrder(460)
    @Transactional
    public void testCreateReport46() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(null));
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(0));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888882L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.GSTSZEIGK_ARI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(2));
            khTtdkkanryouBean.setIrZeimumongon1("税務文言１");
            khTtdkkanryouBean.setIrZeimumongon2("税務文言２");
            khTtdkkanryouBean.setIrZeimumongon3("税務文言３");
            khTtdkkanryouBean.setIrZeimumongon4("税務文言４");
            khTtdkkanryouBean.setIrZeimumongon5("税務文言５");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }


    @Test
    @TestOrder(470)
    @Transactional
    public void testCreateReport47() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888882L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.GSTSZEIGK_ARI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(2));
            khTtdkkanryouBean.setIrZeimumongon1("税務文言１");
            khTtdkkanryouBean.setIrZeimumongon2("税務文言２");
            khTtdkkanryouBean.setIrZeimumongon3("税務文言３");
            khTtdkkanryouBean.setIrZeimumongon4("税務文言４");
            khTtdkkanryouBean.setIrZeimumongon5("税務文言５");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }


    @Test
    @TestOrder(480)
    @Transactional
    public void testCreateReport48() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888888882L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.GSTSZEIGK_ARI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(8888888888887L));
            khTtdkkanryouBean.setIrZeimumongon1("税務文言１");
            khTtdkkanryouBean.setIrZeimumongon2("税務文言２");
            khTtdkkanryouBean.setIrZeimumongon3("税務文言３");
            khTtdkkanryouBean.setIrZeimumongon4("税務文言４");
            khTtdkkanryouBean.setIrZeimumongon5("税務文言５");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }


    @Test
    @TestOrder(490)
    @Transactional
    public void testCreateReport49() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888888882L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.GSTSZEIGK_ARI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(8888888887L));
            khTtdkkanryouBean.setIrZeimumongon1("税務文言１");
            khTtdkkanryouBean.setIrZeimumongon2("税務文言２");
            khTtdkkanryouBean.setIrZeimumongon3("税務文言３");
            khTtdkkanryouBean.setIrZeimumongon4("税務文言４");
            khTtdkkanryouBean.setIrZeimumongon5("税務文言５");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }


    @Test
    @TestOrder(500)
    @Transactional
    public void testCreateReport50() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8888882));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.GSTSZEIGK_ARI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(8888887));
            khTtdkkanryouBean.setIrZeimumongon1("税務文言１");
            khTtdkkanryouBean.setIrZeimumongon2("税務文言２");
            khTtdkkanryouBean.setIrZeimumongon3("税務文言３");
            khTtdkkanryouBean.setIrZeimumongon4("税務文言４");
            khTtdkkanryouBean.setIrZeimumongon5("税務文言５");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }


    @Test
    @TestOrder(510)
    @Transactional
    public void testCreateReport51() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(8882));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.GSTSZEIGK_ARI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(8887));
            khTtdkkanryouBean.setIrZeimumongon1("");
            khTtdkkanryouBean.setIrZeimumongon2("");
            khTtdkkanryouBean.setIrZeimumongon3("");
            khTtdkkanryouBean.setIrZeimumongon4("");
            khTtdkkanryouBean.setIrZeimumongon5("");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }


    @Test
    @TestOrder(520)
    @Transactional
    public void testCreateReport52() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(882));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.GSTSZEIGK_ARI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(887));
            khTtdkkanryouBean.setIrZeimumongon1(null);
            khTtdkkanryouBean.setIrZeimumongon2(null);
            khTtdkkanryouBean.setIrZeimumongon3(null);
            khTtdkkanryouBean.setIrZeimumongon4(null);
            khTtdkkanryouBean.setIrZeimumongon5(null);
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }


    @Test
    @TestOrder(530)
    @Transactional
    public void testCreateReport53() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(2));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.GSTSZEIGK_ARI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(7));
            khTtdkkanryouBean.setIrZeimumongon1("税務文言１");
            khTtdkkanryouBean.setIrZeimumongon2("税務文言２");
            khTtdkkanryouBean.setIrZeimumongon3("税務文言３");
            khTtdkkanryouBean.setIrZeimumongon4("税務文言４");
            khTtdkkanryouBean.setIrZeimumongon5("税務文言５");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(540)
    @Transactional
    public void testCreateReport54() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.GSTSZEIGK_ARI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrZeimumongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrZeimumongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrZeimumongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrZeimumongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrZeimumongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(550)
    @Transactional
    public void testCreateReport55() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrZeimumongon1(null);
            khTtdkkanryouBean.setIrZeimumongon2(null);
            khTtdkkanryouBean.setIrZeimumongon3(null);
            khTtdkkanryouBean.setIrZeimumongon4(null);
            khTtdkkanryouBean.setIrZeimumongon5(null);
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(560)
    @Transactional
    public void testCreateReport56() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrZeimumongon1("");
            khTtdkkanryouBean.setIrZeimumongon2("");
            khTtdkkanryouBean.setIrZeimumongon3("");
            khTtdkkanryouBean.setIrZeimumongon4("");
            khTtdkkanryouBean.setIrZeimumongon5("");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }
    @Test
    @TestOrder(570)
    @Transactional
    public void testCreateReport57() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrZeimumongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrZeimumongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrZeimumongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrZeimumongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrZeimumongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(580)
    @Transactional
    public void testCreateReport58() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(2));
            khTtdkkanryouBean.setIrZeimumongon1(null);
            khTtdkkanryouBean.setIrZeimumongon2(null);
            khTtdkkanryouBean.setIrZeimumongon3(null);
            khTtdkkanryouBean.setIrZeimumongon4(null);
            khTtdkkanryouBean.setIrZeimumongon5(null);
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1(null);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(590)
    @Transactional
    public void testCreateReport59() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(2));
            khTtdkkanryouBean.setIrZeimumongon1("税務文言１");
            khTtdkkanryouBean.setIrZeimumongon2("税務文言２");
            khTtdkkanryouBean.setIrZeimumongon3("税務文言３");
            khTtdkkanryouBean.setIrZeimumongon4("税務文言４");
            khTtdkkanryouBean.setIrZeimumongon5("税務文言５");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(600)
    @Transactional
    public void testCreateReport60() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.ARI);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(2));
            khTtdkkanryouBean.setIrZeimumongon1("");
            khTtdkkanryouBean.setIrZeimumongon2("");
            khTtdkkanryouBean.setIrZeimumongon3("");
            khTtdkkanryouBean.setIrZeimumongon4("");
            khTtdkkanryouBean.setIrZeimumongon5("");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(610)
    @Transactional
    public void testCreateReport61() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(2));
            khTtdkkanryouBean.setIrZeimumongon1("税務文言１");
            khTtdkkanryouBean.setIrZeimumongon2("税務文言２");
            khTtdkkanryouBean.setIrZeimumongon3("税務文言３");
            khTtdkkanryouBean.setIrZeimumongon4("税務文言４");
            khTtdkkanryouBean.setIrZeimumongon5("税務文言５");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("支払内容補足文言１支払内容補足文言１");
            khTtdkkanryouBean.setIrYuuyokkntyoukaumu(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(620)
    @Transactional
    public void testCreateReport62() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(2));
            khTtdkkanryouBean.setIrZeimumongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrZeimumongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrZeimumongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrZeimumongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrZeimumongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYuuyokkntyoukaumu(C_UmuKbn.NONE);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }


    @Test
    @TestOrder(630)
    @Transactional
    public void testCreateReport63() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_ttdkkrTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 9年 9月 9日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("大阪市中央区城見");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.KAIYAKU);
            khTtdkkanryouBean.setIrSyono("12345678901");
            khTtdkkanryouBean.setIrKyknmkj("山田");
            khTtdkkanryouBean.setIrHhknnmkj("吉田");
            khTtdkkanryouBean.setIrShrymd("平成 3年 3月 3日");
            khTtdkkanryouBean.setIrKaiykymd("平成 4年 4月 4日");

            khTtdkkanryouBean.setIrTekiyou1(" 解約返戻金額");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(10500.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou1("解約返戻金額＝（１）×（２）");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("（１）保険料積立金");
            khTtdkkanryouBean.setIrTekiyou3("");
            khTtdkkanryouBean.setIrKngkmeisai3(null);
            khTtdkkanryouBean.setIrBikou3("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou4("");
            khTtdkkanryouBean.setIrKngkmeisai4(null);
            khTtdkkanryouBean.setIrBikou4("（２）市場価格調整率");
            khTtdkkanryouBean.setIrTekiyou5("");
            khTtdkkanryouBean.setIrKngkmeisai5(null);
            khTtdkkanryouBean.setIrBikou5("95.12345678　％");
            khTtdkkanryouBean.setIrTekiyou6("");
            khTtdkkanryouBean.setIrKngkmeisai6(null);
            khTtdkkanryouBean.setIrBikou6("（３）解約控除額（※）");
            khTtdkkanryouBean.setIrTekiyou7("");
            khTtdkkanryouBean.setIrKngkmeisai7(null);
            khTtdkkanryouBean.setIrBikou7("10500.00　米ドル");
            khTtdkkanryouBean.setIrTekiyou8("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai8(BizCurrency.valueOf(-100.00, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou8("");
            khTtdkkanryouBean.setIrTekiyou9(" 支払利息");
            khTtdkkanryouBean.setIrKngkmeisai9(BizCurrency.valueOf(16.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBikou9("必要書類の受付日翌日から５営業日を超えた１００日分");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(10216.76, BizCurrencyTypes.DOLLAR));
            khTtdkkanryouBean.setIrBanknmkj("金融機関");
            khTtdkkanryouBean.setIrSitennmkj("支店支店１");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK);
            khTtdkkanryouBean.setIrKouzano("123456789***");
            khTtdkkanryouBean.setIrKzmeiginmkn("口座名義人名");
            khTtdkkanryouBean.setIrSynykngk(BizCurrency.valueOf(8888888888881L));
            khTtdkkanryouBean.setIrHtykeihi(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(8888888888883L));
            khTtdkkanryouBean.setIrKazeinendo("平成 2年");

            khTtdkkanryouBean.setIrOsirasemongon1("【お支払内容について】");
            khTtdkkanryouBean.setIrOsirasemongon2("　◆解約日は完備された手続書類を当社が受け付けた日となります。");
            khTtdkkanryouBean.setIrOsirasemongon3("　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、");
            khTtdkkanryouBean.setIrOsirasemongon4("　　増減します。");
            khTtdkkanryouBean.setIrOsirasemongon5("　　（※）市場価格調整について");
            khTtdkkanryouBean.setIrOsirasemongon6("　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる");
            khTtdkkanryouBean.setIrOsirasemongon7("　　　　　しくみをいいます。");
            khTtdkkanryouBean.setIrOsirasemongon8("　　　　・一般的に、投資時点よりも市場金利が高くなると資産価値が減少し、逆に投資時点よりも市場");
            khTtdkkanryouBean.setIrOsirasemongon9("　　　　　金利が低くなると資産価値が増加します。");
            khTtdkkanryouBean.setIrOsirasemongon10("");
            khTtdkkanryouBean.setIrOsirasemongon11("【適用為替レートについて】");
            khTtdkkanryouBean.setIrOsirasemongon12("　◆円貨支払いのお申し出により、解約返戻金を指定通貨にかえて解約日時点の当社所定の為替レートで");
            khTtdkkanryouBean.setIrOsirasemongon13("　　円に換算してお支払いしています。");
            khTtdkkanryouBean.setIrOsirasemongon14("　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※）－５０銭」となります。");
            khTtdkkanryouBean.setIrOsirasemongon15("　（※）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電");
            khTtdkkanryouBean.setIrOsirasemongon16("　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の");
            khTtdkkanryouBean.setIrOsirasemongon17("　　　　公示値とします。");
            khTtdkkanryouBean.setIrOsirasemongon18("");
            khTtdkkanryouBean.setIrOsirasemongon19("【解約返戻金に対する税務のご説明】");
            khTtdkkanryouBean.setIrOsirasemongon20("　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、指定通");
            khTtdkkanryouBean.setIrOsirasemongon21("　　貨を円貨に換算したうえで、円建の生命保険と同様に取り扱います。");
            khTtdkkanryouBean.setIrOsirasemongon22("　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。");
            khTtdkkanryouBean.setIrOsirasemongon23("　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）");
            khTtdkkanryouBean.setIrOsirasemongon24("　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。");
            khTtdkkanryouBean.setIrOsirasemongon25("　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２");
            khTtdkkanryouBean.setIrOsirasemongon26("　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。");
            khTtdkkanryouBean.setIrOsirasemongon27("　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」");
            khTtdkkanryouBean.setIrOsirasemongon28("　　は、確定申告の際の参考資料となりますので、大切に保管してください。");
            khTtdkkanryouBean.setIrOsirasemongon29("　◆収入金額は、解約日の為替レートにて円換算した金額です。");
            khTtdkkanryouBean.setIrOsirasemongon30("　◆所轄の税務署あてに、支払調書を提出しています。");
            khTtdkkanryouBean.setIrOsirasemongon31("");
            khTtdkkanryouBean.setIrOsirasemongon32("");
            khTtdkkanryouBean.setIrOsirasemongon33("");
            khTtdkkanryouBean.setIrOsirasemongon34("");
            khTtdkkanryouBean.setIrOsirasemongon35("");
            khTtdkkanryouBean.setIrOsirasemongon36("");
            khTtdkkanryouBean.setIrOsirasemongon37("");
            khTtdkkanryouBean.setIrOsirasemongon38("");
            khTtdkkanryouBean.setIrOsirasemongon39("");
            khTtdkkanryouBean.setIrOsirasemongon40("");
            khTtdkkanryouBean.setIrOsirasemongon41("");
            khTtdkkanryouBean.setIrOsirasemongon42("");
            khTtdkkanryouBean.setIrOsirasemongon43("");
            khTtdkkanryouBean.setIrOsirasemongon44("");
            khTtdkkanryouBean.setIrOsirasemongon45("");
            khTtdkkanryouBean.setIrOsirasemongon46("");
            khTtdkkanryouBean.setIrOsirasemongon47("");
            khTtdkkanryouBean.setIrOsirasemongon48("");
            khTtdkkanryouBean.setIrOsirasemongon49("");
            khTtdkkanryouBean.setIrOsirasemongon50("");

            khTtdkkanryouBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_GAIBU_TTDKKR);
            khTtdkkanryouBean.setIrYenshrtktekiumu(C_UmuKbn.NONE);
            khTtdkkanryouBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khTtdkkanryouBean.setIrZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI);
            khTtdkkanryouBean.setIrGsbnrkztsaeki(BizCurrency.valueOf(2));
            khTtdkkanryouBean.setIrZeimumongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrZeimumongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrZeimumongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrZeimumongon4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrZeimumongon5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrnaiyouhskmongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

}
