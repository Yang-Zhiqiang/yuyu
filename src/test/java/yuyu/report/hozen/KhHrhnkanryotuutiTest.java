package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhHrhnKanryoTuutiBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 払変完了通知（ＰＤＦ） 用クラス
 */
@RunWith(OrderedRunner.class)
public class KhHrhnkanryotuutiTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhHrhnKanryoTuutiBean khHrhnKanryoTuutiBean;

    @Inject
    private BzKokyakuAtesakiBean bzKokyakuAtesakiBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhHrhnkanryotuutiTest", C_SyoruiCdKbn.KK_HRIHEN_TTDKKR);


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

        khHrhnKanryoTuutiBean.setIrKouzamaskingmsg("");
        khHrhnKanryoTuutiBean.setIrSyono("");
        khHrhnKanryoTuutiBean.setIrKyknmkj("");
        khHrhnKanryoTuutiBean.setIrHhknnmkj("");
        khHrhnKanryoTuutiBean.setIrHrkkaisuutkiktbrisyu("");
        khHrhnKanryoTuutiBean.setIrHrkkeiro(null);
        khHrhnKanryoTuutiBean.setIrHrkp(null);
        khHrhnKanryoTuutiBean.setIrKouryokuhasseiym(null);
        khHrhnKanryoTuutiBean.setIrTyouhyousakuseiymd("");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta1("");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta2("");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta3("");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta4("");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta5("");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta6("");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta7("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta1("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta2("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta3("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta4("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta5("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta6("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta7("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta8("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta9("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta10("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta11("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta12("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta13("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta14("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta15("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta16("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta17("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta18("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta19("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta20("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta21("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta22("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta23("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta24("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta25("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta26("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta27("");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta28("");


        reportTestBean.addParamObjects(khHrhnKanryoTuutiBean, bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhHrhnkanryotuutiTest", C_SyoruiCdKbn.KK_HRIHEN_TTDKKR);

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

        khHrhnKanryoTuutiBean.setIrKouzamaskingmsg(null);
        khHrhnKanryoTuutiBean.setIrSyono(null);
        khHrhnKanryoTuutiBean.setIrKyknmkj(null);
        khHrhnKanryoTuutiBean.setIrHhknnmkj(null);
        khHrhnKanryoTuutiBean.setIrHrkkaisuutkiktbrisyu(null);
        khHrhnKanryoTuutiBean.setIrHrkkeiro(null);
        khHrhnKanryoTuutiBean.setIrHrkp(null);
        khHrhnKanryoTuutiBean.setIrKouryokuhasseiym(null);
        khHrhnKanryoTuutiBean.setIrTyouhyousakuseiymd(null);
        khHrhnKanryoTuutiBean.setIrMsgarea34keta1(null);
        khHrhnKanryoTuutiBean.setIrMsgarea34keta2(null);
        khHrhnKanryoTuutiBean.setIrMsgarea34keta3(null);
        khHrhnKanryoTuutiBean.setIrMsgarea34keta4(null);
        khHrhnKanryoTuutiBean.setIrMsgarea34keta5(null);
        khHrhnKanryoTuutiBean.setIrMsgarea34keta6(null);
        khHrhnKanryoTuutiBean.setIrMsgarea34keta7(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta1(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta2(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta3(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta4(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta5(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta6(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta7(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta8(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta9(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta10(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta11(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta12(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta13(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta14(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta15(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta16(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta17(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta18(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta19(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta20(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta21(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta22(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta23(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta24(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta25(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta26(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta27(null);
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta28(null);

        reportTestBean.addParamObjects(khHrhnKanryoTuutiBean, bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhHrhnkanryotuutiTest", C_SyoruiCdKbn.KK_HRIHEN_TTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("0101234");
        bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
        bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
        bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
        bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
        bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

        khHrhnKanryoTuutiBean.setIrKouzamaskingmsg("※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。");
        khHrhnKanryoTuutiBean.setIrSyono("12345678901");
        khHrhnKanryoTuutiBean.setIrKyknmkj("契約　太郎");
        khHrhnKanryoTuutiBean.setIrHhknnmkj("被保険者　太郎");
        khHrhnKanryoTuutiBean.setIrHrkkaisuutkiktbrisyu("月払い");
        khHrhnKanryoTuutiBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);
        khHrhnKanryoTuutiBean.setIrHrkp(BizCurrency.valueOf(1000));
        khHrhnKanryoTuutiBean.setIrKouryokuhasseiym(BizDateYM.valueOf("199703"));
        khHrhnKanryoTuutiBean.setIrTyouhyousakuseiymd("19960301");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta1("メッセージエリア１");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta2("メッセージエリア２");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta3("メッセージエリア３");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta4("メッセージエリア４");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta5("メッセージエリア５");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta6("メッセージエリア６");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta7("メッセージエリア７");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta1("振替予告メッセージ１");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta2("振替予告メッセージ２");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta3("振替予告メッセージ３");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta4("振替予告メッセージ４");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta5("振替予告メッセージ５");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta6("振替予告メッセージ６");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta7("振替予告メッセージ７");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta8("振替予告メッセージ８");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta9("振替予告メッセージ９");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta10("振替予告メッセージ１０");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta11("振替予告メッセージ１１");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta12("振替予告メッセージ１２");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta13("振替予告メッセージ１３");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta14("振替予告メッセージ１４");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta15("振替予告メッセージ１５");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta16("振替予告メッセージ１６");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta17("振替予告メッセージ１７");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta18("振替予告メッセージ１８");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta19("振替予告メッセージ１９");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta20("振替予告メッセージ２０");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta21("振替予告メッセージ２１");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta22("振替予告メッセージ２２");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta23("振替予告メッセージ２３");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta24("振替予告メッセージ２４");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta25("振替予告メッセージ２５");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta26("振替予告メッセージ２６");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta27("振替予告メッセージ２７");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta28("振替予告メッセージ２８");


        reportTestBean.addParamObjects(khHrhnKanryoTuutiBean, bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhHrhnkanryotuutiTest", C_SyoruiCdKbn.KK_HRIHEN_TTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("wwwwwww");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("www-wwww");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("(ww)wwww-wwwww");

        khHrhnKanryoTuutiBean.setIrKouzamaskingmsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrSyono("wwwwwwwwwww");
        khHrhnKanryoTuutiBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkkaisuutkiktbrisyu("ＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkkeiro(C_Hrkkeiro.CREDIT);
        khHrhnKanryoTuutiBean.setIrHrkp(BizCurrency.valueOf(9999999999999l));
        khHrhnKanryoTuutiBean.setIrKouryokuhasseiym(BizDateYM.valueOf("201712"));
        khHrhnKanryoTuutiBean.setIrTyouhyousakuseiymd("20171229");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta21("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta22("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta23("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta24("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta25("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta26("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta27("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta28("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");


        reportTestBean.addParamObjects(khHrhnKanryoTuutiBean, bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhHrhnkanryotuutiTest", C_SyoruiCdKbn.KK_HRIHEN_TTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("0101234");
        bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
        bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
        bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
        bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
        bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

        khHrhnKanryoTuutiBean.setIrKouzamaskingmsg("※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。");
        khHrhnKanryoTuutiBean.setIrSyono("12345678901");
        khHrhnKanryoTuutiBean.setIrKyknmkj("契約　太郎");
        khHrhnKanryoTuutiBean.setIrHhknnmkj("被保険者　太郎");
        khHrhnKanryoTuutiBean.setIrHrkkaisuutkiktbrisyu("月払い");
        khHrhnKanryoTuutiBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);
        khHrhnKanryoTuutiBean.setIrHrkp(BizCurrency.valueOf(999.1,BizCurrencyTypes.DOLLAR));
        khHrhnKanryoTuutiBean.setIrKouryokuhasseiym(BizDateYM.valueOf("199703"));
        khHrhnKanryoTuutiBean.setIrTyouhyousakuseiymd("19960301");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta1("メッセージエリア１");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta2("メッセージエリア２");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta3("メッセージエリア３");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta4("メッセージエリア４");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta5("メッセージエリア５");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta6("メッセージエリア６");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta7("メッセージエリア７");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta1("振替予告メッセージ１");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta2("振替予告メッセージ２");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta3("振替予告メッセージ３");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta4("振替予告メッセージ４");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta5("振替予告メッセージ５");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta6("振替予告メッセージ６");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta7("振替予告メッセージ７");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta8("振替予告メッセージ８");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta9("振替予告メッセージ９");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta10("振替予告メッセージ１０");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta11("振替予告メッセージ１１");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta12("振替予告メッセージ１２");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta13("振替予告メッセージ１３");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta14("振替予告メッセージ１４");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta15("振替予告メッセージ１５");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta16("振替予告メッセージ１６");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta17("振替予告メッセージ１７");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta18("振替予告メッセージ１８");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta19("振替予告メッセージ１９");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta20("振替予告メッセージ２０");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta21("振替予告メッセージ２１");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta22("振替予告メッセージ２２");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta23("振替予告メッセージ２３");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta24("振替予告メッセージ２４");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta25("振替予告メッセージ２５");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta26("振替予告メッセージ２６");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta27("振替予告メッセージ２７");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta28("振替予告メッセージ２８");


        reportTestBean.addParamObjects(khHrhnKanryoTuutiBean, bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhHrhnkanryotuutiTest", C_SyoruiCdKbn.KK_HRIHEN_TTDKKR);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("0101234");
        bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
        bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
        bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
        bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
        bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

        khHrhnKanryoTuutiBean.setIrKouzamaskingmsg("※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。");
        khHrhnKanryoTuutiBean.setIrSyono("12345678901");
        khHrhnKanryoTuutiBean.setIrKyknmkj("契約　太郎");
        khHrhnKanryoTuutiBean.setIrHhknnmkj("被保険者　太郎");
        khHrhnKanryoTuutiBean.setIrHrkkaisuutkiktbrisyu("月払い");
        khHrhnKanryoTuutiBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);
        khHrhnKanryoTuutiBean.setIrHrkp(BizCurrency.valueOf(9999999999999l, BizCurrencyTypes.DOLLAR));
        khHrhnKanryoTuutiBean.setIrKouryokuhasseiym(BizDateYM.valueOf("199703"));
        khHrhnKanryoTuutiBean.setIrTyouhyousakuseiymd("19960301");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta1("メッセージエリア１");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta2("メッセージエリア２");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta3("メッセージエリア３");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta4("メッセージエリア４");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta5("メッセージエリア５");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta6("メッセージエリア６");
        khHrhnKanryoTuutiBean.setIrMsgarea34keta7("メッセージエリア７");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta1("振替予告メッセージ１");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta2("振替予告メッセージ２");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta3("振替予告メッセージ３");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta4("振替予告メッセージ４");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta5("振替予告メッセージ５");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta6("振替予告メッセージ６");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta7("振替予告メッセージ７");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta8("振替予告メッセージ８");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta9("振替予告メッセージ９");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta10("振替予告メッセージ１０");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta11("振替予告メッセージ１１");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta12("振替予告メッセージ１２");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta13("振替予告メッセージ１３");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta14("振替予告メッセージ１４");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta15("振替予告メッセージ１５");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta16("振替予告メッセージ１６");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta17("振替予告メッセージ１７");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta18("振替予告メッセージ１８");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta19("振替予告メッセージ１９");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta20("振替予告メッセージ２０");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta21("振替予告メッセージ２１");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta22("振替予告メッセージ２２");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta23("振替予告メッセージ２３");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta24("振替予告メッセージ２４");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta25("振替予告メッセージ２５");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta26("振替予告メッセージ２６");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta27("振替予告メッセージ２７");
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta28("振替予告メッセージ２８");


        reportTestBean.addParamObjects(khHrhnKanryoTuutiBean, bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
