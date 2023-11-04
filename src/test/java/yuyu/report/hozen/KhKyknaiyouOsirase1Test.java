package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.bean.report.KhKykNaiyouOsiraseBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ご契約内容のお知らせ１ 用クラス
 */
@RunWith(OrderedRunner.class)
public class KhKyknaiyouOsirase1Test {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhKykNaiyouOsiraseBean khKykNaiyouOsiraseBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("");
        khKykNaiyouOsiraseBean.setIrSyono("");
        khKykNaiyouOsiraseBean.setIrAisyoumei("");
        khKykNaiyouOsiraseBean.setIrYakkannmei("");
        khKykNaiyouOsiraseBean.setIrKyknm("");
        khKykNaiyouOsiraseBean.setIrHhknnm("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("");
        khKykNaiyouOsiraseBean.setIrKykymd("");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("");
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrTk5msg("特約５メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("");
        khKykNaiyouOsiraseBean.setIrHrktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("");
        khKykNaiyouOsiraseBean.setIrSakuseisya("");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("");

        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("05003");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("");
        khKykNaiyouOsiraseBean.setIrWarningMsg("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd(null);
        khKykNaiyouOsiraseBean.setIrSyono(null);
        khKykNaiyouOsiraseBean.setIrAisyoumei(null);
        khKykNaiyouOsiraseBean.setIrYakkannmei(null);
        khKykNaiyouOsiraseBean.setIrKyknm(null);
        khKykNaiyouOsiraseBean.setIrHhknnm(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm(null);
        khKykNaiyouOsiraseBean.setIrKykymd(null);
        khKykNaiyouOsiraseBean.setIrDai1hknkknto(null);
        khKykNaiyouOsiraseBean.setIrDai1hknkkn(null);
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom(null);
        khKykNaiyouOsiraseBean.setIrDai2hknkknto(null);
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom(null);
        khKykNaiyouOsiraseBean.setIrDai3hknkknto(null);
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg(null);
        khKykNaiyouOsiraseBean.setIrTk3msg(null);
        khKykNaiyouOsiraseBean.setIrTk4msg(null);
        khKykNaiyouOsiraseBean.setIrTk5msg("特約５メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk(null);
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk(null);
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrKihonsktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenhrkgk(null);
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk(null);
        khKykNaiyouOsiraseBean.setIrHrktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate(null);
        khKykNaiyouOsiraseBean.setIrStigikwsrate(null);
        khKykNaiyouOsiraseBean.setIrKijyunkingaku(null);
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate(null);
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen(null);
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka(null);
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen(null);
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka(null);
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(null);
        khKykNaiyouOsiraseBean.setIrMkhgkyen(null);
        khKykNaiyouOsiraseBean.setIrMkhgkwari(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2(null);
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku(null);
        khKykNaiyouOsiraseBean.setIrSakuseisya(null);
        khKykNaiyouOsiraseBean.setIrCalckijyunymd(null);
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen(null);

        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("05003");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk(null);
        khKykNaiyouOsiraseBean.setIrTrkkzknm1(null);
        khKykNaiyouOsiraseBean.setIrTrkkzknm2(null);
        khKykNaiyouOsiraseBean.setIrWarningMsg(null);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("笑顔の約束");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("10");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("２０３２年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("２０３２年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("以降（終身）");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrTk5msg("特約５メッセージ");
        khKykNaiyouOsiraseBean.setIrTk6msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("２０１７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("2，032，970 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("2，012，057 円");


        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("05003");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("登録家族名１　様");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("登録家族名２　様");
        khKykNaiyouOsiraseBean.setIrWarningMsg("（本日の為替レートが取得できないため、直前のレートでの試算結果となります）");
        khKykNaiyouOsiraseBean.setIrYobidasimotoKbn(1);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("99991231");
        khKykNaiyouOsiraseBean.setIrSyono("wwwwwwwwwww");
        khKykNaiyouOsiraseBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYakkannmei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKyknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHhknnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrStdrsknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKykymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("99");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk4msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk5msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("999．99");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("999．99");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("999．99");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("999．99");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("9");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("９９９");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisya("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("9，999，999，999 円");


        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("05003");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");
        khKykNaiyouOsiraseBean.setIrWarningMsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("");
        khKykNaiyouOsiraseBean.setIrSyono("");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみステップ");
        khKykNaiyouOsiraseBean.setIrYakkannmei("");
        khKykNaiyouOsiraseBean.setIrKyknm("");
        khKykNaiyouOsiraseBean.setIrHhknnm("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrStdrsknm("");
        khKykNaiyouOsiraseBean.setIrKykymd("");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("");
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrTk5msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("");
        khKykNaiyouOsiraseBean.setIrHrktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("");
        khKykNaiyouOsiraseBean.setIrSakuseisya("");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("");

        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("05003");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd(null);
        khKykNaiyouOsiraseBean.setIrSyono(null);
        khKykNaiyouOsiraseBean.setIrAisyoumei("ふるはーとＪロードグローバル");
        khKykNaiyouOsiraseBean.setIrYakkannmei(null);
        khKykNaiyouOsiraseBean.setIrKyknm(null);
        khKykNaiyouOsiraseBean.setIrHhknnm(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2(null);
        khKykNaiyouOsiraseBean.setIrStdrsknm(null);
        khKykNaiyouOsiraseBean.setIrKykymd(null);
        khKykNaiyouOsiraseBean.setIrDai1hknkknto(null);
        khKykNaiyouOsiraseBean.setIrDai1hknkkn(null);
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom(null);
        khKykNaiyouOsiraseBean.setIrDai2hknkknto(null);
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom(null);
        khKykNaiyouOsiraseBean.setIrDai3hknkknto(null);
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg(null);
        khKykNaiyouOsiraseBean.setIrTk3msg(null);
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrTk5msg(null);
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk(null);
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk(null);
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrKihonsktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenhrkgk(null);
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk(null);
        khKykNaiyouOsiraseBean.setIrHrktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate(null);
        khKykNaiyouOsiraseBean.setIrStigikwsrate(null);
        khKykNaiyouOsiraseBean.setIrKijyunkingaku(null);
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate(null);
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen(null);
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka(null);
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen(null);
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka(null);
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(null);
        khKykNaiyouOsiraseBean.setIrMkhgkyen(null);
        khKykNaiyouOsiraseBean.setIrMkhgkwari(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2(null);
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku(null);
        khKykNaiyouOsiraseBean.setIrSakuseisya(null);
        khKykNaiyouOsiraseBean.setIrCalckijyunymd(null);

        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("05003");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("しんきんらいふ終身Ｓ　ふるはーとＪロードグローバル");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("10");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("２０３２年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("２０３２年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("以降（終身）");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrTk5msg("");
        khKykNaiyouOsiraseBean.setIrTk6msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("２０１７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("2，032，970 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００２株式会社ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");

        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("05003");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("99991231");
        khKykNaiyouOsiraseBean.setIrSyono("wwwwwwwwwww");
        khKykNaiyouOsiraseBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYakkannmei("");
        khKykNaiyouOsiraseBean.setIrKyknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHhknnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrStdrsknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKykymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk4msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk5msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("999．99");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("999．99");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("999．99");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("999．99");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("9");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("９９９");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisya("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("ＷＷＷＷＷＷＷＷＷＷＷ");

        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("05003");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("笑顔の約束");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("－");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("10");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("２０３２年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("２０３２年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("以降（終身）");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.EUR);
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrTk5msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("２０１７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("2，032，970 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");

        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("笑顔の約束");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("－");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("10");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("２０３２年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("２０３２年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("以降（終身）");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg(null);
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg(null);
        khKykNaiyouOsiraseBean.setIrTk5msg(null);
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("２０１７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("2，032，970 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");

        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05002");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("笑顔の約束");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("－");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("10");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("２０３２年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("２０３２年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("以降（終身）");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrTk5msg("");
        khKykNaiyouOsiraseBean.setIrTk6msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("２０１７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("2，032，970 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");

        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("笑顔の約束");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("－");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("10");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("２０３２年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("２０３２年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("以降（終身）");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrTk5msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("２０１７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("2，032，970 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");

        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05002");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("笑顔の約束");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("－");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("10");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("２０３２年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("２０３２年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("以降（終身）");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrTk5msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("２０１７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("2，032，970 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");

        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("05003");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("笑顔の約束");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("－");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("10");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("２０３２年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("２０３２年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("以降（終身）");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg(null);
        khKykNaiyouOsiraseBean.setIrTk4msg(null);
        khKykNaiyouOsiraseBean.setIrTk5msg(null);
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("２０１７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("2，032，970 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");

        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("笑顔の約束");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("－");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("10");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("２０３２年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("２０３２年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("以降（終身）");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrTk5msg("");
        khKykNaiyouOsiraseBean.setIrTk6msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("2，032，970 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");

        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05002");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("笑顔の約束");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("－");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("10");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("２０３２年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("２０３２年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("以降（終身）");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrTk5msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("２０１７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("2，032，970 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");

        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("笑顔の約束");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("－");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("10");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("２０３２年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("２０３２年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("以降（終身）");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrTk5msg("");
        khKykNaiyouOsiraseBean.setIrTk6msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("２０１７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("2，032，970 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");

        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("05003");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("笑顔の約束");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("－");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("10");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("２０３２年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("２０３２年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("以降（終身）");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrTk5msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("２０１７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("2，032，970 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");

        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("05003");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("笑顔の約束");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("－");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("10");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("２０３２年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("２０３２年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("以降（終身）");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrTk5msg("");
        khKykNaiyouOsiraseBean.setIrTk6msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("２０１７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("2，032，970 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");

        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("05003");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("笑顔の約束");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("10");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("２０３２年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("２０３２年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("以降（終身）");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrTk5msg("特約５メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("２０１７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("2，032，970 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("0 円");


        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("05003");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(210)
    @Transactional
    public void testCreateReport21() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("");
        khKykNaiyouOsiraseBean.setIrSyono("");
        khKykNaiyouOsiraseBean.setIrAisyoumei("");
        khKykNaiyouOsiraseBean.setIrYakkannmei("");
        khKykNaiyouOsiraseBean.setIrKyknm("");
        khKykNaiyouOsiraseBean.setIrHhknnm("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrKykdairinm("");
        khKykNaiyouOsiraseBean.setIrStdrsknm("");
        khKykNaiyouOsiraseBean.setIrKykymd("");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("");
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrTk5msg("");
        khKykNaiyouOsiraseBean.setIrTk6msg("特約６メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("");
        khKykNaiyouOsiraseBean.setIrHrktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("");
        khKykNaiyouOsiraseBean.setIrSakuseisya("");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("");

        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("05003");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testCreateReport22() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd(null);
        khKykNaiyouOsiraseBean.setIrSyono(null);
        khKykNaiyouOsiraseBean.setIrAisyoumei(null);
        khKykNaiyouOsiraseBean.setIrYakkannmei(null);
        khKykNaiyouOsiraseBean.setIrKyknm(null);
        khKykNaiyouOsiraseBean.setIrHhknnm(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrKykdairinm(null);
        khKykNaiyouOsiraseBean.setIrStdrsknm(null);
        khKykNaiyouOsiraseBean.setIrKykymd(null);
        khKykNaiyouOsiraseBean.setIrDai1hknkknto(null);
        khKykNaiyouOsiraseBean.setIrDai1hknkkn(null);
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom(null);
        khKykNaiyouOsiraseBean.setIrDai2hknkknto(null);
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom(null);
        khKykNaiyouOsiraseBean.setIrDai3hknkknto(null);
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg(null);
        khKykNaiyouOsiraseBean.setIrTk3msg(null);
        khKykNaiyouOsiraseBean.setIrTk4msg(null);
        khKykNaiyouOsiraseBean.setIrTk5msg(null);
        khKykNaiyouOsiraseBean.setIrTk6msg("特約６メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk(null);
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk(null);
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrKihonsktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenhrkgk(null);
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk(null);
        khKykNaiyouOsiraseBean.setIrHrktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate(null);
        khKykNaiyouOsiraseBean.setIrStigikwsrate(null);
        khKykNaiyouOsiraseBean.setIrKijyunkingaku(null);
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate(null);
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen(null);
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka(null);
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen(null);
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka(null);
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(null);
        khKykNaiyouOsiraseBean.setIrMkhgkyen(null);
        khKykNaiyouOsiraseBean.setIrMkhgkwari(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2(null);
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku(null);
        khKykNaiyouOsiraseBean.setIrSakuseisya(null);
        khKykNaiyouOsiraseBean.setIrCalckijyunymd(null);
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen(null);

        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("05003");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testCreateReport23() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("笑顔の約束");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrKykdairinm("契約者代理人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("被保険者代理人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("10");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("２０３２年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("２０３２年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("以降（終身）");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrTk5msg("特約５メッセージ");
        khKykNaiyouOsiraseBean.setIrTk6msg("特約６メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("２０１７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("2，032，970 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("2，012，057 円");


        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");

        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("05003");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testCreateReport24() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("99991231");
        khKykNaiyouOsiraseBean.setIrSyono("wwwwwwwwwww");
        khKykNaiyouOsiraseBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYakkannmei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKyknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHhknnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKykdairinm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrStdrsknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKykymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("99");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk4msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk5msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk6msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("999．99");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("999．99");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("999．99");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("999．99");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("9");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("９９９");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisya("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("9，999，999，999 円");


        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("05003");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testCreateReport25() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase1", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("笑顔の約束");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrDai1hknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai1hknkkn("10");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknto("２０３２年　４月２３日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknfrom("２０３２年　４月２４日");
        khKykNaiyouOsiraseBean.setIrDai3hknkknto("以降（終身）");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrTk5msg("特約５メッセージ");
        khKykNaiyouOsiraseBean.setIrTk6msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKihonsktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom("２０１７年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto("２０２７年　４月２３日");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka("16，909．00 米ドル");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("2，032，970 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("");
        khKykNaiyouOsiraseBean.setIrSakuseisya("");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("2，012，057 円");


        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1("05001");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2("05003");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6("");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("登録家族名１　様");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("登録家族名２　様");
        khKykNaiyouOsiraseBean.setIrWarningMsg("（本日の為替レートが取得できないため、直前のレートでの試算結果となります）");
        khKykNaiyouOsiraseBean.setIrYobidasimotoKbn(2);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
