package yuyu.report.siharai;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.siharai.bean.report.SiShrmeisaiSindansyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 支払明細書（診断書料支払）テスト 用クラス
 */
@RunWith(OrderedRunner.class)
public class SiSiharaimeisaiSindansyoTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private  SiShrmeisaiSindansyoBean siShrmeisaiSindansyoBean;

    @Inject
    private  BzKokyakuAtesakiBean bzKokyakuAtesakiBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaimeisaiSindansyoTest", C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        siShrmeisaiSindansyoBean.setIrMsg1("");
        siShrmeisaiSindansyoBean.setIrMsg2("");
        siShrmeisaiSindansyoBean.setIrMsg3("");
        siShrmeisaiSindansyoBean.setIrMsg4("");
        siShrmeisaiSindansyoBean.setIrMsg5("");
        siShrmeisaiSindansyoBean.setIrMsg6("");
        siShrmeisaiSindansyoBean.setIrMsg7("");
        siShrmeisaiSindansyoBean.setIrMsg8("");
        siShrmeisaiSindansyoBean.setIrMsg9("");
        siShrmeisaiSindansyoBean.setIrMsg10("");
        siShrmeisaiSindansyoBean.setIrMsg11("");
        siShrmeisaiSindansyoBean.setIrMsg12("");
        siShrmeisaiSindansyoBean.setIrMsg13("");
        siShrmeisaiSindansyoBean.setIrSyono("");
        siShrmeisaiSindansyoBean.setIrTyakkinymd("");
        siShrmeisaiSindansyoBean.setIrKyuuhuname("");
        siShrmeisaiSindansyoBean.setIrKyhkg(BizCurrency.valueOf(0, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrShrdetailbikou("");
        siShrmeisaiSindansyoBean.setIrShrgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        siShrmeisaiSindansyoBean.setIrBanknmkj("");
        siShrmeisaiSindansyoBean.setIrSitennmkj("");
        siShrmeisaiSindansyoBean.setIrYokinknmkj("");
        siShrmeisaiSindansyoBean.setIrKouzano("");
        siShrmeisaiSindansyoBean.setIrKzmeiginmkn("");

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
        bzKokyakuAtesakiBean.setIrToiawasetelno("");
        bzKokyakuAtesakiBean.setIrHknkisynm("");

        reportTestBean.addParamObjects(siShrmeisaiSindansyoBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaimeisaiSindansyoTest", C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        siShrmeisaiSindansyoBean.setIrMsg1(null);
        siShrmeisaiSindansyoBean.setIrMsg2(null);
        siShrmeisaiSindansyoBean.setIrMsg3(null);
        siShrmeisaiSindansyoBean.setIrMsg4(null);
        siShrmeisaiSindansyoBean.setIrMsg5(null);
        siShrmeisaiSindansyoBean.setIrMsg6(null);
        siShrmeisaiSindansyoBean.setIrMsg7(null);
        siShrmeisaiSindansyoBean.setIrMsg8(null);
        siShrmeisaiSindansyoBean.setIrMsg9(null);
        siShrmeisaiSindansyoBean.setIrMsg10(null);
        siShrmeisaiSindansyoBean.setIrMsg11(null);
        siShrmeisaiSindansyoBean.setIrMsg12(null);
        siShrmeisaiSindansyoBean.setIrMsg13(null);
        siShrmeisaiSindansyoBean.setIrSyono(null);
        siShrmeisaiSindansyoBean.setIrTyakkinymd(null);
        siShrmeisaiSindansyoBean.setIrKyuuhuname(null);
        siShrmeisaiSindansyoBean.setIrKyhkg(BizCurrency.valueOf(4000, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrShrdetailbikou("");
        siShrmeisaiSindansyoBean.setIrShrgk(BizCurrency.valueOf(4000, BizCurrencyTypes.YEN));
        siShrmeisaiSindansyoBean.setIrBanknmkj(null);
        siShrmeisaiSindansyoBean.setIrSitennmkj(null);
        siShrmeisaiSindansyoBean.setIrYokinknmkj(null);
        siShrmeisaiSindansyoBean.setIrKouzano(null);
        siShrmeisaiSindansyoBean.setIrKzmeiginmkn(null);

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
        bzKokyakuAtesakiBean.setIrToiawasetelno(null);
        bzKokyakuAtesakiBean.setIrHknkisynm(null);


        reportTestBean.addParamObjects(siShrmeisaiSindansyoBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaimeisaiSindansyoTest", C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        siShrmeisaiSindansyoBean.setIrMsg1("診断書取得費用相当額お支払いのお知らせ");
        siShrmeisaiSindansyoBean.setIrMsg2("このたびご請求いただきました保険金・給付金等につきましては、別途ご説明のとおり、お支払");
        siShrmeisaiSindansyoBean.setIrMsg3("い等いたしかねるとの結論にいたりました。");
        siShrmeisaiSindansyoBean.setIrMsg4("つきましては、");
        siShrmeisaiSindansyoBean.setIrMsg5("今回のご請求手続きに伴う診断書取得費用相当額について以下のとおりお支払い");
        siShrmeisaiSindansyoBean.setIrMsg6("をさせていただきます。");
        siShrmeisaiSindansyoBean.setIrMsg7("※保険金・給付金等を診断書原本にてご請求いただいたにもかかわらず、");
        siShrmeisaiSindansyoBean.setIrMsg8("　お支払いの要件に該当せず保険金・給付金等を全くお支払いできなかった場合、");
        siShrmeisaiSindansyoBean.setIrMsg9("　診断書取得費用等を勘案し、");
        siShrmeisaiSindansyoBean.setIrMsg10("　当社所定の要件を満たす場合、診断書原本一通につき一律５，４００円をお支払いさせてい");
        siShrmeisaiSindansyoBean.setIrMsg11("　ただきます。");
        siShrmeisaiSindansyoBean.setIrMsg12("　実際の診断書発行費用とは異なりますので、何卒ご了承くださいますようお願い申し上げま");
        siShrmeisaiSindansyoBean.setIrMsg13("　す。");
        siShrmeisaiSindansyoBean.setIrSyono("17806000013");
        siShrmeisaiSindansyoBean.setIrTyakkinymd("平成２６年１２月２９日");
        siShrmeisaiSindansyoBean.setIrKyuuhuname("診断書取得費用相当額");
        siShrmeisaiSindansyoBean.setIrKyhkg(BizCurrency.valueOf(999, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrShrdetailbikou("診断書１２０枚");
        siShrmeisaiSindansyoBean.setIrShrgk(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        siShrmeisaiSindansyoBean.setIrBanknmkj("大阪市中央区銀行");
        siShrmeisaiSindansyoBean.setIrSitennmkj("新栄町支店");
        siShrmeisaiSindansyoBean.setIrYokinknmkj("定期預金");
        siShrmeisaiSindansyoBean.setIrKouzano("12345***");
        siShrmeisaiSindansyoBean.setIrKzmeiginmkn("サトウユミキ");

        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");

        reportTestBean.addParamObjects(siShrmeisaiSindansyoBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaimeisaiSindansyoTest", C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        siShrmeisaiSindansyoBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiSindansyoBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiSindansyoBean.setIrMsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiSindansyoBean.setIrMsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiSindansyoBean.setIrMsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiSindansyoBean.setIrMsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiSindansyoBean.setIrMsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiSindansyoBean.setIrMsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiSindansyoBean.setIrMsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiSindansyoBean.setIrMsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiSindansyoBean.setIrMsg11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiSindansyoBean.setIrMsg12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiSindansyoBean.setIrMsg13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiSindansyoBean.setIrSyono("99999999999");
        siShrmeisaiSindansyoBean.setIrTyakkinymd("ＷＷ９９年９９月９９日");
        siShrmeisaiSindansyoBean.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiSindansyoBean.setIrKyhkg(BizCurrency.valueOf(99999999999.99, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiSindansyoBean.setIrShrgk(BizCurrency.valueOf(99999999999L, BizCurrencyTypes.YEN));
        siShrmeisaiSindansyoBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiSindansyoBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiSindansyoBean.setIrYokinknmkj("ＷＷＷＷＷＷＷ");
        siShrmeisaiSindansyoBean.setIrKouzano("99999***");
        siShrmeisaiSindansyoBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        bzKokyakuAtesakiBean.setIrShsyno("wwwwwww");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("www-wwww");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");


        reportTestBean.addParamObjects(siShrmeisaiSindansyoBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaimeisaiSindansyoTest", C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        siShrmeisaiSindansyoBean.setIrMsg1("診断書取得費用相当額お支払いのお知らせ");
        siShrmeisaiSindansyoBean.setIrMsg2("このたびご請求いただきました保険金・給付金等につきましては、別途ご説明のとおり、お支払");
        siShrmeisaiSindansyoBean.setIrMsg3("い等いたしかねるとの結論にいたりました。");
        siShrmeisaiSindansyoBean.setIrMsg4("つきましては、今回のご請求手続きに伴う診断書取得費用相当額について以下のとおりお支払い");
        siShrmeisaiSindansyoBean.setIrMsg5("をさせていただきます。");
        siShrmeisaiSindansyoBean.setIrMsg6("");
        siShrmeisaiSindansyoBean.setIrMsg7("※保険金・給付金等を診断書原本にてご請求いただいたにもかかわらず、お支払いの要件に該");
        siShrmeisaiSindansyoBean.setIrMsg8("　当せず保険金・給付金等を全くお支払いできなかった場合、診断書取得費用等を勘案し、");
        siShrmeisaiSindansyoBean.setIrMsg9("　当社所定の要件を満たす場合、診断書原本一通につき一律５，４００円をお支払いさせてい");
        siShrmeisaiSindansyoBean.setIrMsg10("　ただきます。");
        siShrmeisaiSindansyoBean.setIrMsg11("　実際の診断書発行費用とは異なりますので、何卒ご了承くださいますようお願い申し上げま");
        siShrmeisaiSindansyoBean.setIrMsg12("　す。");
        siShrmeisaiSindansyoBean.setIrMsg13("");
        siShrmeisaiSindansyoBean.setIrSyono("17806000013");
        siShrmeisaiSindansyoBean.setIrTyakkinymd("平成２６年１２月２９日");
        siShrmeisaiSindansyoBean.setIrKyuuhuname("診断書取得費用相当額");
        siShrmeisaiSindansyoBean.setIrKyhkg(BizCurrency.valueOf(9999, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrShrdetailbikou("診断書１２０枚");
        siShrmeisaiSindansyoBean.setIrShrgk(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        siShrmeisaiSindansyoBean.setIrBanknmkj("大阪市中央区銀行");
        siShrmeisaiSindansyoBean.setIrSitennmkj("新栄町支店");
        siShrmeisaiSindansyoBean.setIrYokinknmkj("定期預金");
        siShrmeisaiSindansyoBean.setIrKouzano("12345***");
        siShrmeisaiSindansyoBean.setIrKzmeiginmkn("タナカユミコ");

        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");

        reportTestBean.addParamObjects(siShrmeisaiSindansyoBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaimeisaiSindansyoTest", C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        siShrmeisaiSindansyoBean.setIrMsg1("診断書取得費用相当額お支払いのお知らせ");
        siShrmeisaiSindansyoBean.setIrMsg2("このたびご請求いただきました保険金・給付金等につきましては、別途ご説明のとおり、お支払");
        siShrmeisaiSindansyoBean.setIrMsg3("い等いたしかねるとの結論にいたりました。");
        siShrmeisaiSindansyoBean.setIrMsg4("つきましては、今回のご請求手続きに伴う診断書取得費用相当額について以下のとおりお支払い");
        siShrmeisaiSindansyoBean.setIrMsg5("をさせていただきます。");
        siShrmeisaiSindansyoBean.setIrMsg6("");
        siShrmeisaiSindansyoBean.setIrMsg7("※保険金・給付金等を診断書原本にてご請求いただいたにもかかわらず、お支払いの要件に該");
        siShrmeisaiSindansyoBean.setIrMsg8("　当せず保険金・給付金等を全くお支払いできなかった場合、診断書取得費用等を勘案し、");
        siShrmeisaiSindansyoBean.setIrMsg9("　当社所定の要件を満たす場合、診断書原本一通につき一律５，４００円をお支払いさせてい");
        siShrmeisaiSindansyoBean.setIrMsg10("　ただきます。");
        siShrmeisaiSindansyoBean.setIrMsg11("　実際の診断書発行費用とは異なりますので、何卒ご了承くださいますようお願い申し上げま");
        siShrmeisaiSindansyoBean.setIrMsg12("　す。");
        siShrmeisaiSindansyoBean.setIrMsg13("");
        siShrmeisaiSindansyoBean.setIrSyono("17806000013");
        siShrmeisaiSindansyoBean.setIrTyakkinymd("平成２６年１２月２９日");
        siShrmeisaiSindansyoBean.setIrKyuuhuname("診断書取得費用相当額");
        siShrmeisaiSindansyoBean.setIrKyhkg(BizCurrency.valueOf(9.1, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrShrdetailbikou("診断書１２０枚");
        siShrmeisaiSindansyoBean.setIrShrgk(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        siShrmeisaiSindansyoBean.setIrBanknmkj("大阪市中央区銀行");
        siShrmeisaiSindansyoBean.setIrSitennmkj("新栄町支店");
        siShrmeisaiSindansyoBean.setIrYokinknmkj("定期預金");
        siShrmeisaiSindansyoBean.setIrKouzano("12345***");
        siShrmeisaiSindansyoBean.setIrKzmeiginmkn("サトウユミキ");

        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");

        reportTestBean.addParamObjects(siShrmeisaiSindansyoBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaimeisaiSindansyoTest", C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        siShrmeisaiSindansyoBean.setIrMsg1("診断書取得費用相当額お支払いのお知らせ");
        siShrmeisaiSindansyoBean.setIrMsg2("このたびご請求いただきました保険金・給付金等につきましては、別途ご説明のとおり、お支払");
        siShrmeisaiSindansyoBean.setIrMsg3("い等いたしかねるとの結論にいたりました。");
        siShrmeisaiSindansyoBean.setIrMsg4("つきましては、今回のご請求手続きに伴う診断書取得費用相当額について以下のとおりお支払い");
        siShrmeisaiSindansyoBean.setIrMsg5("をさせていただきます。");
        siShrmeisaiSindansyoBean.setIrMsg6("");
        siShrmeisaiSindansyoBean.setIrMsg7("※保険金・給付金等を診断書原本にてご請求いただいたにもかかわらず、お支払いの要件に該");
        siShrmeisaiSindansyoBean.setIrMsg8("　当せず保険金・給付金等を全くお支払いできなかった場合、診断書取得費用等を勘案し、");
        siShrmeisaiSindansyoBean.setIrMsg9("　当社所定の要件を満たす場合、診断書原本一通につき一律５，４００円をお支払いさせてい");
        siShrmeisaiSindansyoBean.setIrMsg10("　ただきます。");
        siShrmeisaiSindansyoBean.setIrMsg11("　実際の診断書発行費用とは異なりますので、何卒ご了承くださいますようお願い申し上げま");
        siShrmeisaiSindansyoBean.setIrMsg12("　す。");
        siShrmeisaiSindansyoBean.setIrMsg13("");
        siShrmeisaiSindansyoBean.setIrSyono("17806000013");
        siShrmeisaiSindansyoBean.setIrTyakkinymd("平成２６年１２月２９日");
        siShrmeisaiSindansyoBean.setIrKyuuhuname("診断書取得費用相当額");
        siShrmeisaiSindansyoBean.setIrKyhkg(BizCurrency.valueOf(9.22, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrShrdetailbikou("診断書１２０枚");
        siShrmeisaiSindansyoBean.setIrShrgk(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        siShrmeisaiSindansyoBean.setIrBanknmkj("大阪市中央区銀行");
        siShrmeisaiSindansyoBean.setIrSitennmkj("新栄町支店");
        siShrmeisaiSindansyoBean.setIrYokinknmkj("定期預金");
        siShrmeisaiSindansyoBean.setIrKouzano("12345***");
        siShrmeisaiSindansyoBean.setIrKzmeiginmkn("サトウユミキ");

        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");

        reportTestBean.addParamObjects(siShrmeisaiSindansyoBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaimeisaiSindansyoTest", C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        siShrmeisaiSindansyoBean.setIrMsg1("診断書取得費用相当額お支払いのお知らせ");
        siShrmeisaiSindansyoBean.setIrMsg2("このたびご請求いただきました保険金・給付金等につきましては、別途ご説明のとおり、お支払");
        siShrmeisaiSindansyoBean.setIrMsg3("い等いたしかねるとの結論にいたりました。");
        siShrmeisaiSindansyoBean.setIrMsg4("つきましては、今回のご請求手続きに伴う診断書取得費用相当額について以下のとおりお支払い");
        siShrmeisaiSindansyoBean.setIrMsg5("をさせていただきます。");
        siShrmeisaiSindansyoBean.setIrMsg6("");
        siShrmeisaiSindansyoBean.setIrMsg7("※保険金・給付金等を診断書原本にてご請求いただいたにもかかわらず、お支払いの要件に該");
        siShrmeisaiSindansyoBean.setIrMsg8("　当せず保険金・給付金等を全くお支払いできなかった場合、診断書取得費用等を勘案し、");
        siShrmeisaiSindansyoBean.setIrMsg9("　当社所定の要件を満たす場合、診断書原本一通につき一律５，４００円をお支払いさせてい");
        siShrmeisaiSindansyoBean.setIrMsg10("　ただきます。");
        siShrmeisaiSindansyoBean.setIrMsg11("　実際の診断書発行費用とは異なりますので、何卒ご了承くださいますようお願い申し上げま");
        siShrmeisaiSindansyoBean.setIrMsg12("　す。");
        siShrmeisaiSindansyoBean.setIrMsg13("");
        siShrmeisaiSindansyoBean.setIrSyono("17806000013");
        siShrmeisaiSindansyoBean.setIrTyakkinymd("平成２６年１２月２９日");
        siShrmeisaiSindansyoBean.setIrKyuuhuname("診断書取得費用相当額");
        siShrmeisaiSindansyoBean.setIrKyhkg(BizCurrency.valueOf(9.333, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrShrdetailbikou("診断書１２０枚");
        siShrmeisaiSindansyoBean.setIrShrgk(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        siShrmeisaiSindansyoBean.setIrBanknmkj("大阪市中央区銀行");
        siShrmeisaiSindansyoBean.setIrSitennmkj("新栄町支店");
        siShrmeisaiSindansyoBean.setIrYokinknmkj("定期預金");
        siShrmeisaiSindansyoBean.setIrKouzano("12345***");
        siShrmeisaiSindansyoBean.setIrKzmeiginmkn("サトウユミキ");

        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");

        reportTestBean.addParamObjects(siShrmeisaiSindansyoBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaimeisaiSindansyoTest", C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        siShrmeisaiSindansyoBean.setIrMsg1("診断書取得費用相当額お支払いのお知らせ");
        siShrmeisaiSindansyoBean.setIrMsg2("このたびご請求いただきました保険金・給付金等につきましては、別途ご説明のとおり、お支払");
        siShrmeisaiSindansyoBean.setIrMsg3("い等いたしかねるとの結論にいたりました。");
        siShrmeisaiSindansyoBean.setIrMsg4("つきましては、今回のご請求手続きに伴う診断書取得費用相当額について以下のとおりお支払い");
        siShrmeisaiSindansyoBean.setIrMsg5("をさせていただきます。");
        siShrmeisaiSindansyoBean.setIrMsg6("");
        siShrmeisaiSindansyoBean.setIrMsg7("※保険金・給付金等を診断書原本にてご請求いただいたにもかかわらず、お支払いの要件に該");
        siShrmeisaiSindansyoBean.setIrMsg8("　当せず保険金・給付金等を全くお支払いできなかった場合、診断書取得費用等を勘案し、");
        siShrmeisaiSindansyoBean.setIrMsg9("　当社所定の要件を満たす場合、診断書原本一通につき一律５，４００円をお支払いさせてい");
        siShrmeisaiSindansyoBean.setIrMsg10("　ただきます。");
        siShrmeisaiSindansyoBean.setIrMsg11("　実際の診断書発行費用とは異なりますので、何卒ご了承くださいますようお願い申し上げま");
        siShrmeisaiSindansyoBean.setIrMsg12("　す。");
        siShrmeisaiSindansyoBean.setIrMsg13("");
        siShrmeisaiSindansyoBean.setIrSyono("17806000013");
        siShrmeisaiSindansyoBean.setIrTyakkinymd("平成２６年１２月２９日");
        siShrmeisaiSindansyoBean.setIrKyuuhuname("診断書取得費用相当額");
        siShrmeisaiSindansyoBean.setIrKyhkg(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        siShrmeisaiSindansyoBean.setIrShrdetailbikou("診断書１２０枚");
        siShrmeisaiSindansyoBean.setIrShrgk(BizCurrency.valueOf(0, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrBanknmkj("大阪市中央区銀行");
        siShrmeisaiSindansyoBean.setIrSitennmkj("新栄町支店");
        siShrmeisaiSindansyoBean.setIrYokinknmkj("定期預金");
        siShrmeisaiSindansyoBean.setIrKouzano("12345***");
        siShrmeisaiSindansyoBean.setIrKzmeiginmkn("サトウユミキ");

        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");

        reportTestBean.addParamObjects(siShrmeisaiSindansyoBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaimeisaiSindansyoTest", C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        siShrmeisaiSindansyoBean.setIrMsg1("診断書取得費用相当額お支払いのお知らせ");
        siShrmeisaiSindansyoBean.setIrMsg2("このたびご請求いただきました保険金・給付金等につきましては、別途ご説明のとおり、お支払");
        siShrmeisaiSindansyoBean.setIrMsg3("い等いたしかねるとの結論にいたりました。");
        siShrmeisaiSindansyoBean.setIrMsg4("つきましては、今回のご請求手続きに伴う診断書取得費用相当額について以下のとおりお支払い");
        siShrmeisaiSindansyoBean.setIrMsg5("をさせていただきます。");
        siShrmeisaiSindansyoBean.setIrMsg6("");
        siShrmeisaiSindansyoBean.setIrMsg7("※保険金・給付金等を診断書原本にてご請求いただいたにもかかわらず、お支払いの要件に該");
        siShrmeisaiSindansyoBean.setIrMsg8("　当せず保険金・給付金等を全くお支払いできなかった場合、診断書取得費用等を勘案し、");
        siShrmeisaiSindansyoBean.setIrMsg9("　当社所定の要件を満たす場合、診断書原本一通につき一律５，４００円をお支払いさせてい");
        siShrmeisaiSindansyoBean.setIrMsg10("　ただきます。");
        siShrmeisaiSindansyoBean.setIrMsg11("　実際の診断書発行費用とは異なりますので、何卒ご了承くださいますようお願い申し上げま");
        siShrmeisaiSindansyoBean.setIrMsg12("　す。");
        siShrmeisaiSindansyoBean.setIrMsg13("");
        siShrmeisaiSindansyoBean.setIrSyono("17806000013");
        siShrmeisaiSindansyoBean.setIrTyakkinymd("平成２６年１２月２９日");
        siShrmeisaiSindansyoBean.setIrKyuuhuname("診断書取得費用相当額");
        siShrmeisaiSindansyoBean.setIrKyhkg(BizCurrency.valueOf(4000, BizCurrencyTypes.YEN));
        siShrmeisaiSindansyoBean.setIrShrdetailbikou("診断書１２０枚");
        siShrmeisaiSindansyoBean.setIrShrgk(BizCurrency.valueOf(4000, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrBanknmkj("大阪市中央区銀行");
        siShrmeisaiSindansyoBean.setIrSitennmkj("新栄町支店");
        siShrmeisaiSindansyoBean.setIrYokinknmkj("定期預金");
        siShrmeisaiSindansyoBean.setIrKouzano("12345***");
        siShrmeisaiSindansyoBean.setIrKzmeiginmkn("サトウユミキ");

        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");

        reportTestBean.addParamObjects(siShrmeisaiSindansyoBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaimeisaiSindansyoTest", C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        siShrmeisaiSindansyoBean.setIrMsg1("診断書取得費用相当額お支払いのお知らせ");
        siShrmeisaiSindansyoBean.setIrMsg2("このたびご請求いただきました保険金・給付金等につきましては、別途ご説明のとおり、お支払");
        siShrmeisaiSindansyoBean.setIrMsg3("い等いたしかねるとの結論にいたりました。");
        siShrmeisaiSindansyoBean.setIrMsg4("つきましては、今回のご請求手続きに伴う診断書取得費用相当額について以下のとおりお支払い");
        siShrmeisaiSindansyoBean.setIrMsg5("をさせていただきます。");
        siShrmeisaiSindansyoBean.setIrMsg6("");
        siShrmeisaiSindansyoBean.setIrMsg7("※保険金・給付金等を診断書原本にてご請求いただいたにもかかわらず、お支払いの要件に該");
        siShrmeisaiSindansyoBean.setIrMsg8("　当せず保険金・給付金等を全くお支払いできなかった場合、診断書取得費用等を勘案し、");
        siShrmeisaiSindansyoBean.setIrMsg9("　当社所定の要件を満たす場合、診断書原本一通につき一律５，４００円をお支払いさせてい");
        siShrmeisaiSindansyoBean.setIrMsg10("　ただきます。");
        siShrmeisaiSindansyoBean.setIrMsg11("　実際の診断書発行費用とは異なりますので、何卒ご了承くださいますようお願い申し上げま");
        siShrmeisaiSindansyoBean.setIrMsg12("　す。");
        siShrmeisaiSindansyoBean.setIrMsg13("");
        siShrmeisaiSindansyoBean.setIrSyono("17806000013");
        siShrmeisaiSindansyoBean.setIrTyakkinymd("平成２６年１２月２９日");
        siShrmeisaiSindansyoBean.setIrKyuuhuname("診断書取得費用相当額");
        siShrmeisaiSindansyoBean.setIrKyhkg(BizCurrency.valueOf(99999999999L, BizCurrencyTypes.YEN));
        siShrmeisaiSindansyoBean.setIrShrdetailbikou("診断書１２０枚");
        siShrmeisaiSindansyoBean.setIrShrgk(BizCurrency.valueOf(99999999999.99, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrBanknmkj("大阪市中央区銀行");
        siShrmeisaiSindansyoBean.setIrSitennmkj("新栄町支店");
        siShrmeisaiSindansyoBean.setIrYokinknmkj("定期預金");
        siShrmeisaiSindansyoBean.setIrKouzano("12345***");
        siShrmeisaiSindansyoBean.setIrKzmeiginmkn("サトウユミキ");

        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");

        reportTestBean.addParamObjects(siShrmeisaiSindansyoBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaimeisaiSindansyoTest", C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        siShrmeisaiSindansyoBean.setIrMsg1("診断書取得費用相当額お支払いのお知らせ");
        siShrmeisaiSindansyoBean.setIrMsg2("このたびご請求いただきました保険金・給付金等につきましては、別途ご説明のとおり、お支払");
        siShrmeisaiSindansyoBean.setIrMsg3("い等いたしかねるとの結論にいたりました。");
        siShrmeisaiSindansyoBean.setIrMsg4("つきましては、今回のご請求手続きに伴う診断書取得費用相当額について以下のとおりお支払い");
        siShrmeisaiSindansyoBean.setIrMsg5("をさせていただきます。");
        siShrmeisaiSindansyoBean.setIrMsg6("");
        siShrmeisaiSindansyoBean.setIrMsg7("※保険金・給付金等を診断書原本にてご請求いただいたにもかかわらず、お支払いの要件に該");
        siShrmeisaiSindansyoBean.setIrMsg8("　当せず保険金・給付金等を全くお支払いできなかった場合、診断書取得費用等を勘案し、");
        siShrmeisaiSindansyoBean.setIrMsg9("　当社所定の要件を満たす場合、診断書原本一通につき一律５，４００円をお支払いさせてい");
        siShrmeisaiSindansyoBean.setIrMsg10("　ただきます。");
        siShrmeisaiSindansyoBean.setIrMsg11("　実際の診断書発行費用とは異なりますので、何卒ご了承くださいますようお願い申し上げま");
        siShrmeisaiSindansyoBean.setIrMsg12("　す。");
        siShrmeisaiSindansyoBean.setIrMsg13("");
        siShrmeisaiSindansyoBean.setIrSyono("17806000013");
        siShrmeisaiSindansyoBean.setIrTyakkinymd("平成２６年１２月２９日");
        siShrmeisaiSindansyoBean.setIrKyuuhuname("診断書取得費用相当額");
        siShrmeisaiSindansyoBean.setIrKyhkg(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        siShrmeisaiSindansyoBean.setIrShrdetailbikou("診断書１２０枚");
        siShrmeisaiSindansyoBean.setIrShrgk(BizCurrency.valueOf(999, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrBanknmkj("大阪市中央区銀行");
        siShrmeisaiSindansyoBean.setIrSitennmkj("新栄町支店");
        siShrmeisaiSindansyoBean.setIrYokinknmkj("定期預金");
        siShrmeisaiSindansyoBean.setIrKouzano("12345***");
        siShrmeisaiSindansyoBean.setIrKzmeiginmkn("サトウユミキ");

        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");

        reportTestBean.addParamObjects(siShrmeisaiSindansyoBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaimeisaiSindansyoTest", C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        siShrmeisaiSindansyoBean.setIrMsg1("診断書取得費用相当額お支払いのお知らせ");
        siShrmeisaiSindansyoBean.setIrMsg2("このたびご請求いただきました保険金・給付金等につきましては、別途ご説明のとおり、お支払");
        siShrmeisaiSindansyoBean.setIrMsg3("い等いたしかねるとの結論にいたりました。");
        siShrmeisaiSindansyoBean.setIrMsg4("つきましては、今回のご請求手続きに伴う診断書取得費用相当額について以下のとおりお支払い");
        siShrmeisaiSindansyoBean.setIrMsg5("をさせていただきます。");
        siShrmeisaiSindansyoBean.setIrMsg6("");
        siShrmeisaiSindansyoBean.setIrMsg7("※保険金・給付金等を診断書原本にてご請求いただいたにもかかわらず、お支払いの要件に該");
        siShrmeisaiSindansyoBean.setIrMsg8("　当せず保険金・給付金等を全くお支払いできなかった場合、診断書取得費用等を勘案し、");
        siShrmeisaiSindansyoBean.setIrMsg9("　当社所定の要件を満たす場合、診断書原本一通につき一律５，４００円をお支払いさせてい");
        siShrmeisaiSindansyoBean.setIrMsg10("　ただきます。");
        siShrmeisaiSindansyoBean.setIrMsg11("　実際の診断書発行費用とは異なりますので、何卒ご了承くださいますようお願い申し上げま");
        siShrmeisaiSindansyoBean.setIrMsg12("　す。");
        siShrmeisaiSindansyoBean.setIrMsg13("");
        siShrmeisaiSindansyoBean.setIrSyono("17806000013");
        siShrmeisaiSindansyoBean.setIrTyakkinymd("平成２６年１２月２９日");
        siShrmeisaiSindansyoBean.setIrKyuuhuname("診断書取得費用相当額");
        siShrmeisaiSindansyoBean.setIrKyhkg(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
        siShrmeisaiSindansyoBean.setIrShrdetailbikou("診断書１２０枚");
        siShrmeisaiSindansyoBean.setIrShrgk(BizCurrency.valueOf(9999, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrBanknmkj("大阪市中央区銀行");
        siShrmeisaiSindansyoBean.setIrSitennmkj("新栄町支店");
        siShrmeisaiSindansyoBean.setIrYokinknmkj("定期預金");
        siShrmeisaiSindansyoBean.setIrKouzano("12345***");
        siShrmeisaiSindansyoBean.setIrKzmeiginmkn("サトウユミキ");

        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");

        reportTestBean.addParamObjects(siShrmeisaiSindansyoBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaimeisaiSindansyoTest", C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        siShrmeisaiSindansyoBean.setIrMsg1("診断書取得費用相当額お支払いのお知らせ");
        siShrmeisaiSindansyoBean.setIrMsg2("このたびご請求いただきました保険金・給付金等につきましては、別途ご説明のとおり、お支払");
        siShrmeisaiSindansyoBean.setIrMsg3("い等いたしかねるとの結論にいたりました。");
        siShrmeisaiSindansyoBean.setIrMsg4("つきましては、今回のご請求手続きに伴う診断書取得費用相当額について以下のとおりお支払い");
        siShrmeisaiSindansyoBean.setIrMsg5("をさせていただきます。");
        siShrmeisaiSindansyoBean.setIrMsg6("");
        siShrmeisaiSindansyoBean.setIrMsg7("※保険金・給付金等を診断書原本にてご請求いただいたにもかかわらず、お支払いの要件に該");
        siShrmeisaiSindansyoBean.setIrMsg8("　当せず保険金・給付金等を全くお支払いできなかった場合、診断書取得費用等を勘案し、");
        siShrmeisaiSindansyoBean.setIrMsg9("　当社所定の要件を満たす場合、診断書原本一通につき一律５，４００円をお支払いさせてい");
        siShrmeisaiSindansyoBean.setIrMsg10("　ただきます。");
        siShrmeisaiSindansyoBean.setIrMsg11("　実際の診断書発行費用とは異なりますので、何卒ご了承くださいますようお願い申し上げま");
        siShrmeisaiSindansyoBean.setIrMsg12("　す。");
        siShrmeisaiSindansyoBean.setIrMsg13("");
        siShrmeisaiSindansyoBean.setIrSyono("17806000013");
        siShrmeisaiSindansyoBean.setIrTyakkinymd("平成２６年１２月２９日");
        siShrmeisaiSindansyoBean.setIrKyuuhuname("診断書取得費用相当額");
        siShrmeisaiSindansyoBean.setIrKyhkg(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
        siShrmeisaiSindansyoBean.setIrShrdetailbikou("診断書１２０枚");
        siShrmeisaiSindansyoBean.setIrShrgk(BizCurrency.valueOf(9.1, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrBanknmkj("大阪市中央区銀行");
        siShrmeisaiSindansyoBean.setIrSitennmkj("新栄町支店");
        siShrmeisaiSindansyoBean.setIrYokinknmkj("定期預金");
        siShrmeisaiSindansyoBean.setIrKouzano("12345***");
        siShrmeisaiSindansyoBean.setIrKzmeiginmkn("サトウユミキ");

        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");

        reportTestBean.addParamObjects(siShrmeisaiSindansyoBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaimeisaiSindansyoTest", C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        siShrmeisaiSindansyoBean.setIrMsg1("診断書取得費用相当額お支払いのお知らせ");
        siShrmeisaiSindansyoBean.setIrMsg2("このたびご請求いただきました保険金・給付金等につきましては、別途ご説明のとおり、お支払");
        siShrmeisaiSindansyoBean.setIrMsg3("い等いたしかねるとの結論にいたりました。");
        siShrmeisaiSindansyoBean.setIrMsg4("つきましては、今回のご請求手続きに伴う診断書取得費用相当額について以下のとおりお支払い");
        siShrmeisaiSindansyoBean.setIrMsg5("をさせていただきます。");
        siShrmeisaiSindansyoBean.setIrMsg6("");
        siShrmeisaiSindansyoBean.setIrMsg7("※保険金・給付金等を診断書原本にてご請求いただいたにもかかわらず、お支払いの要件に該");
        siShrmeisaiSindansyoBean.setIrMsg8("　当せず保険金・給付金等を全くお支払いできなかった場合、診断書取得費用等を勘案し、");
        siShrmeisaiSindansyoBean.setIrMsg9("　当社所定の要件を満たす場合、診断書原本一通につき一律５，４００円をお支払いさせてい");
        siShrmeisaiSindansyoBean.setIrMsg10("　ただきます。");
        siShrmeisaiSindansyoBean.setIrMsg11("　実際の診断書発行費用とは異なりますので、何卒ご了承くださいますようお願い申し上げま");
        siShrmeisaiSindansyoBean.setIrMsg12("　す。");
        siShrmeisaiSindansyoBean.setIrMsg13("");
        siShrmeisaiSindansyoBean.setIrSyono("17806000013");
        siShrmeisaiSindansyoBean.setIrTyakkinymd("平成２６年１２月２９日");
        siShrmeisaiSindansyoBean.setIrKyuuhuname("診断書取得費用相当額");
        siShrmeisaiSindansyoBean.setIrKyhkg(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
        siShrmeisaiSindansyoBean.setIrShrdetailbikou("診断書１２０枚");
        siShrmeisaiSindansyoBean.setIrShrgk(BizCurrency.valueOf(9.22, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrBanknmkj("大阪市中央区銀行");
        siShrmeisaiSindansyoBean.setIrSitennmkj("新栄町支店");
        siShrmeisaiSindansyoBean.setIrYokinknmkj("定期預金");
        siShrmeisaiSindansyoBean.setIrKouzano("12345***");
        siShrmeisaiSindansyoBean.setIrKzmeiginmkn("サトウユミキ");

        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");

        reportTestBean.addParamObjects(siShrmeisaiSindansyoBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaimeisaiSindansyoTest", C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        siShrmeisaiSindansyoBean.setIrMsg1("診断書取得費用相当額お支払いのお知らせ");
        siShrmeisaiSindansyoBean.setIrMsg2("このたびご請求いただきました保険金・給付金等につきましては、別途ご説明のとおり、お支払");
        siShrmeisaiSindansyoBean.setIrMsg3("い等いたしかねるとの結論にいたりました。");
        siShrmeisaiSindansyoBean.setIrMsg4("つきましては、今回のご請求手続きに伴う診断書取得費用相当額について以下のとおりお支払い");
        siShrmeisaiSindansyoBean.setIrMsg5("をさせていただきます。");
        siShrmeisaiSindansyoBean.setIrMsg6("");
        siShrmeisaiSindansyoBean.setIrMsg7("※保険金・給付金等を診断書原本にてご請求いただいたにもかかわらず、お支払いの要件に該");
        siShrmeisaiSindansyoBean.setIrMsg8("　当せず保険金・給付金等を全くお支払いできなかった場合、診断書取得費用等を勘案し、");
        siShrmeisaiSindansyoBean.setIrMsg9("　当社所定の要件を満たす場合、診断書原本一通につき一律５，４００円をお支払いさせてい");
        siShrmeisaiSindansyoBean.setIrMsg10("　ただきます。");
        siShrmeisaiSindansyoBean.setIrMsg11("　実際の診断書発行費用とは異なりますので、何卒ご了承くださいますようお願い申し上げま");
        siShrmeisaiSindansyoBean.setIrMsg12("　す。");
        siShrmeisaiSindansyoBean.setIrMsg13("");
        siShrmeisaiSindansyoBean.setIrSyono("17806000013");
        siShrmeisaiSindansyoBean.setIrTyakkinymd("平成２６年１２月２９日");
        siShrmeisaiSindansyoBean.setIrKyuuhuname("診断書取得費用相当額");
        siShrmeisaiSindansyoBean.setIrKyhkg(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        siShrmeisaiSindansyoBean.setIrShrdetailbikou("診断書１２０枚");
        siShrmeisaiSindansyoBean.setIrShrgk(BizCurrency.valueOf(9.333, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrBanknmkj("大阪市中央区銀行");
        siShrmeisaiSindansyoBean.setIrSitennmkj("新栄町支店");
        siShrmeisaiSindansyoBean.setIrYokinknmkj("定期預金");
        siShrmeisaiSindansyoBean.setIrKouzano("12345***");
        siShrmeisaiSindansyoBean.setIrKzmeiginmkn("サトウユミキ");

        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");

        reportTestBean.addParamObjects(siShrmeisaiSindansyoBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaimeisaiSindansyoTest", C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        siShrmeisaiSindansyoBean.setIrMsg1("診断書取得費用相当額お支払いのお知らせ");
        siShrmeisaiSindansyoBean.setIrMsg2("このたびご請求いただきました保険金・給付金等につきましては、別途ご説明のとおり、お支払");
        siShrmeisaiSindansyoBean.setIrMsg3("い等いたしかねるとの結論にいたりました。");
        siShrmeisaiSindansyoBean.setIrMsg4("つきましては、");
        siShrmeisaiSindansyoBean.setIrMsg5("今回のご請求手続きに伴う診断書取得費用相当額について以下のとおりお支払い");
        siShrmeisaiSindansyoBean.setIrMsg6("をさせていただきます。");
        siShrmeisaiSindansyoBean.setIrMsg7("※保険金・給付金等を診断書原本にてご請求いただいたにもかかわらず、");
        siShrmeisaiSindansyoBean.setIrMsg8("　お支払いの要件に該当せず保険金・給付金等を全くお支払いできなかった場合、");
        siShrmeisaiSindansyoBean.setIrMsg9("　診断書取得費用等を勘案し、");
        siShrmeisaiSindansyoBean.setIrMsg10("　当社所定の要件を満たす場合、診断書原本一通につき一律５，４００円をお支払いさせてい");
        siShrmeisaiSindansyoBean.setIrMsg11("　ただきます。");
        siShrmeisaiSindansyoBean.setIrMsg12("　実際の診断書発行費用とは異なりますので、何卒ご了承くださいますようお願い申し上げま");
        siShrmeisaiSindansyoBean.setIrMsg13("　す。");
        siShrmeisaiSindansyoBean.setIrSyono("17806000013");
        siShrmeisaiSindansyoBean.setIrTyakkinymd("平成２６年１２月２９日");
        siShrmeisaiSindansyoBean.setIrKyuuhuname("診断書取得費用相当額");
        siShrmeisaiSindansyoBean.setIrKyhkg(BizCurrency.valueOf(999, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrShrdetailbikou("診断書１２０枚");
        siShrmeisaiSindansyoBean.setIrShrgk(BizCurrency.valueOf(99999999.99, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrBanknmkj("大阪市中央区銀行");
        siShrmeisaiSindansyoBean.setIrSitennmkj("新栄町支店");
        siShrmeisaiSindansyoBean.setIrYokinknmkj("定期預金");
        siShrmeisaiSindansyoBean.setIrKouzano("12345***");
        siShrmeisaiSindansyoBean.setIrKzmeiginmkn("サトウユミキ");

        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");

        reportTestBean.addParamObjects(siShrmeisaiSindansyoBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaimeisaiSindansyoTest", C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        siShrmeisaiSindansyoBean.setIrMsg1("診断書取得費用相当額お支払いのお知らせ");
        siShrmeisaiSindansyoBean.setIrMsg2("このたびご請求いただきました保険金・給付金等につきましては、別途ご説明のとおり、お支払");
        siShrmeisaiSindansyoBean.setIrMsg3("い等いたしかねるとの結論にいたりました。");
        siShrmeisaiSindansyoBean.setIrMsg4("つきましては、");
        siShrmeisaiSindansyoBean.setIrMsg5("今回のご請求手続きに伴う診断書取得費用相当額について以下のとおりお支払い");
        siShrmeisaiSindansyoBean.setIrMsg6("をさせていただきます。");
        siShrmeisaiSindansyoBean.setIrMsg7("※保険金・給付金等を診断書原本にてご請求いただいたにもかかわらず、");
        siShrmeisaiSindansyoBean.setIrMsg8("　お支払いの要件に該当せず保険金・給付金等を全くお支払いできなかった場合、");
        siShrmeisaiSindansyoBean.setIrMsg9("　診断書取得費用等を勘案し、");
        siShrmeisaiSindansyoBean.setIrMsg10("　当社所定の要件を満たす場合、診断書原本一通につき一律５，４００円をお支払いさせてい");
        siShrmeisaiSindansyoBean.setIrMsg11("　ただきます。");
        siShrmeisaiSindansyoBean.setIrMsg12("　実際の診断書発行費用とは異なりますので、何卒ご了承くださいますようお願い申し上げま");
        siShrmeisaiSindansyoBean.setIrMsg13("　す。");
        siShrmeisaiSindansyoBean.setIrSyono("17806000013");
        siShrmeisaiSindansyoBean.setIrTyakkinymd("平成２６年１２月２９日");
        siShrmeisaiSindansyoBean.setIrKyuuhuname("診断書取得費用相当額");
        siShrmeisaiSindansyoBean.setIrKyhkg(BizCurrency.valueOf(999, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrShrdetailbikou("診断書１２０枚");
        siShrmeisaiSindansyoBean.setIrShrgk(BizCurrency.valueOf(999999999.99, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrBanknmkj("大阪市中央区銀行");
        siShrmeisaiSindansyoBean.setIrSitennmkj("新栄町支店");
        siShrmeisaiSindansyoBean.setIrYokinknmkj("定期預金");
        siShrmeisaiSindansyoBean.setIrKouzano("12345***");
        siShrmeisaiSindansyoBean.setIrKzmeiginmkn("サトウユミキ");

        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");

        reportTestBean.addParamObjects(siShrmeisaiSindansyoBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaimeisaiSindansyoTest", C_SyoruiCdKbn.HK_SHMEISAI_SDS);

        siShrmeisaiSindansyoBean.setIrMsg1("診断書取得費用相当額お支払いのお知らせ");
        siShrmeisaiSindansyoBean.setIrMsg2("このたびご請求いただきました保険金・給付金等につきましては、別途ご説明のとおり、お支払");
        siShrmeisaiSindansyoBean.setIrMsg3("い等いたしかねるとの結論にいたりました。");
        siShrmeisaiSindansyoBean.setIrMsg4("つきましては、");
        siShrmeisaiSindansyoBean.setIrMsg5("今回のご請求手続きに伴う診断書取得費用相当額について以下のとおりお支払い");
        siShrmeisaiSindansyoBean.setIrMsg6("をさせていただきます。");
        siShrmeisaiSindansyoBean.setIrMsg7("※保険金・給付金等を診断書原本にてご請求いただいたにもかかわらず、");
        siShrmeisaiSindansyoBean.setIrMsg8("　お支払いの要件に該当せず保険金・給付金等を全くお支払いできなかった場合、");
        siShrmeisaiSindansyoBean.setIrMsg9("　診断書取得費用等を勘案し、");
        siShrmeisaiSindansyoBean.setIrMsg10("　当社所定の要件を満たす場合、診断書原本一通につき一律５，４００円をお支払いさせてい");
        siShrmeisaiSindansyoBean.setIrMsg11("　ただきます。");
        siShrmeisaiSindansyoBean.setIrMsg12("　実際の診断書発行費用とは異なりますので、何卒ご了承くださいますようお願い申し上げま");
        siShrmeisaiSindansyoBean.setIrMsg13("　す。");
        siShrmeisaiSindansyoBean.setIrSyono("17806000013");
        siShrmeisaiSindansyoBean.setIrTyakkinymd("平成２６年１２月２９日");
        siShrmeisaiSindansyoBean.setIrKyuuhuname("診断書取得費用相当額");
        siShrmeisaiSindansyoBean.setIrKyhkg(BizCurrency.valueOf(999, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrShrdetailbikou("診断書１２０枚");
        siShrmeisaiSindansyoBean.setIrShrgk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.MANYEN));
        siShrmeisaiSindansyoBean.setIrBanknmkj("大阪市中央区銀行");
        siShrmeisaiSindansyoBean.setIrSitennmkj("新栄町支店");
        siShrmeisaiSindansyoBean.setIrYokinknmkj("定期預金");
        siShrmeisaiSindansyoBean.setIrKouzano("12345***");
        siShrmeisaiSindansyoBean.setIrKzmeiginmkn("サトウユミキ");

        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");

        reportTestBean.addParamObjects(siShrmeisaiSindansyoBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
