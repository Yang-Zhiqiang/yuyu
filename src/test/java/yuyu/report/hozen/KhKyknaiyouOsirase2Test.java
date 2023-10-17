package yuyu.report.hozen;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.bean.report.KhKykNaiyouOsiraseBean;
import yuyu.def.hozen.bean.report.KhKykNaiyouOsiraseDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ご契約内容のお知らせ2 用クラス
 */
@RunWith(OrderedRunner.class)
public class KhKyknaiyouOsirase2Test {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhKykNaiyouOsiraseBean khKykNaiyouOsiraseBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

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
        khKykNaiyouOsiraseBean.setIrNkuktnm("");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("");
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("");
        khKykNaiyouOsiraseBean.setIrHrktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("");
        khKykNaiyouOsiraseBean.setIrSakuseisya("");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("");
        khKykNaiyouOsiraseBean.setIrSisuunm("");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrWarningMsg("");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("");
            khKykNaiyouOsiraseDsBean.setIrSisuu("");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

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
        khKykNaiyouOsiraseBean.setIrNkuktnm(null);
        khKykNaiyouOsiraseBean.setIrNenkinstartymd(null);
        khKykNaiyouOsiraseBean.setIrNenkinstartnen(null);
        khKykNaiyouOsiraseBean.setIrNenkinsyu(null);
        khKykNaiyouOsiraseBean.setIrNkgnsgk(null);
        khKykNaiyouOsiraseBean.setIrCalckijyunymd(null);
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg(null);
        khKykNaiyouOsiraseBean.setIrTk3msg(null);
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk(null);
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk(null);
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenhrkgk(null);
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk(null);
        khKykNaiyouOsiraseBean.setIrHrktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate(null);
        khKykNaiyouOsiraseBean.setIrStigikwsrate(null);
        khKykNaiyouOsiraseBean.setIrKijyunkingaku(null);
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate(null);
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen(null);
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku(null);
        khKykNaiyouOsiraseBean.setIrSakuseisya(null);
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka(null);
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(null);
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen(null);
        khKykNaiyouOsiraseBean.setIrMkhgkyen(null);
        khKykNaiyouOsiraseBean.setIrMkhgkwari(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2(null);
        khKykNaiyouOsiraseBean.setIrTnsmbairitu(null);
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn(null);
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen(null);
        khKykNaiyouOsiraseBean.setIrTumitateriritu(null);
        khKykNaiyouOsiraseBean.setIrSisuunm(null);
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrWarningMsg(null);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi(null);
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai(null);
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka(null);
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen(null);
            khKykNaiyouOsiraseDsBean.setIrSisuu(null);
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu(null);
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu(null);
            khKykNaiyouOsiraseDsBean.setIrKawaserate(null);

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("2，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrWarningMsg("（本日の為替レートが取得できないため、直前のレートでの試算結果となります）");
        khKykNaiyouOsiraseBean.setIrYobidasimotoKbn(1);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

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
        khKykNaiyouOsiraseBean.setIrNkuktnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("９９歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("999．99");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("999．99");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("999．99");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("999．99");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisya("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("９９９");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("９．９９倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("９９．９９％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("９９．９９％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("９．９９％");
        khKykNaiyouOsiraseBean.setIrSisuunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("04");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrWarningMsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ＷＷＷＷ");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("9999年99月99日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("ＷＷＷＷ");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("999,999,999.99 ＷＷＷ");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("9,999,999,999 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("999.99");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("99.99%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("99.99%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("999.99 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("");
        khKykNaiyouOsiraseBean.setIrSyono("");
        khKykNaiyouOsiraseBean.setIrAisyoumei("");
        khKykNaiyouOsiraseBean.setIrYakkannmei("");
        khKykNaiyouOsiraseBean.setIrKyknm("");
        khKykNaiyouOsiraseBean.setIrHhknnm("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrStdrsknm("");
        khKykNaiyouOsiraseBean.setIrKykymd("");
        khKykNaiyouOsiraseBean.setIrNkuktnm("");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("");
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("");
        khKykNaiyouOsiraseBean.setIrHrktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("");
        khKykNaiyouOsiraseBean.setIrSakuseisya("");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("");
        khKykNaiyouOsiraseBean.setIrSisuunm("");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("2");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("");
            khKykNaiyouOsiraseDsBean.setIrSisuu("");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd(null);
        khKykNaiyouOsiraseBean.setIrSyono(null);
        khKykNaiyouOsiraseBean.setIrAisyoumei(null);
        khKykNaiyouOsiraseBean.setIrYakkannmei(null);
        khKykNaiyouOsiraseBean.setIrKyknm(null);
        khKykNaiyouOsiraseBean.setIrHhknnm(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2(null);
        khKykNaiyouOsiraseBean.setIrStdrsknm(null);
        khKykNaiyouOsiraseBean.setIrKykymd(null);
        khKykNaiyouOsiraseBean.setIrNkuktnm(null);
        khKykNaiyouOsiraseBean.setIrNenkinstartymd(null);
        khKykNaiyouOsiraseBean.setIrNenkinstartnen(null);
        khKykNaiyouOsiraseBean.setIrNenkinsyu(null);
        khKykNaiyouOsiraseBean.setIrNkgnsgk(null);
        khKykNaiyouOsiraseBean.setIrCalckijyunymd(null);
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg(null);
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk(null);
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk(null);
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenhrkgk(null);
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk(null);
        khKykNaiyouOsiraseBean.setIrHrktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate(null);
        khKykNaiyouOsiraseBean.setIrStigikwsrate(null);
        khKykNaiyouOsiraseBean.setIrKijyunkingaku(null);
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate(null);
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen(null);
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku(null);
        khKykNaiyouOsiraseBean.setIrSakuseisya(null);
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka(null);
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(null);
        khKykNaiyouOsiraseBean.setIrMkhgkyen(null);
        khKykNaiyouOsiraseBean.setIrMkhgkwari(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2(null);
        khKykNaiyouOsiraseBean.setIrTnsmbairitu(null);
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn(null);
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen(null);
        khKykNaiyouOsiraseBean.setIrTumitateriritu(null);
        khKykNaiyouOsiraseBean.setIrSisuunm(null);
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("2");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn(null);
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi(null);
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai(null);
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka(null);
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen(null);
            khKykNaiyouOsiraseDsBean.setIrSisuu(null);
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu(null);
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu(null);
            khKykNaiyouOsiraseDsBean.setIrKawaserate(null);

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("   ");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("2");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("99991231");
        khKykNaiyouOsiraseBean.setIrSyono("wwwwwwwwwww");
        khKykNaiyouOsiraseBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYakkannmei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKyknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHhknnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrStdrsknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKykymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNkuktnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("９９歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("999．99");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("999．99");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("999．99");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("999．99");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisya("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("９９９");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("９．９９倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("９９．９９％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("９９．９９％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("９．９９％");
        khKykNaiyouOsiraseBean.setIrSisuunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("04");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("2");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ＷＷＷＷ");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("9999年99月99日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("ＷＷＷＷ");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("999,999,999.99 ＷＷＷ");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("9,999,999,999 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("999.99");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("99.99%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("99.99%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("999.99 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("2");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

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
        khKykNaiyouOsiraseBean.setIrNkuktnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("９９歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("999．99");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("999．99");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("999．99");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("999．99");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisya("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("９９９");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("９．９９倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("９９．９９％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("９９．９９％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("９．９９％");
        khKykNaiyouOsiraseBean.setIrSisuunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ＷＷＷＷ");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("9999年99月99日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("ＷＷＷＷ");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("999,999,999.99 ＷＷＷ");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("9,999,999,999 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("999.99");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("99.99%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("99.99%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("999.99 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("02");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（定率増加プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("しんきんらいふ年金Ｓ　たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("しんきんらいふ年金Ｓ　たのしみグローバル（定率増加プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみステップ");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("0 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

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
        khKykNaiyouOsiraseBean.setIrNkuktnm("");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("");
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("");
        khKykNaiyouOsiraseBean.setIrHrktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("");
        khKykNaiyouOsiraseBean.setIrSakuseisya("");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("");
        khKykNaiyouOsiraseBean.setIrSisuunm("");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("06");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("");
            khKykNaiyouOsiraseDsBean.setIrSisuu("");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testCreateReport21() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd(null);
        khKykNaiyouOsiraseBean.setIrSyono(null);
        khKykNaiyouOsiraseBean.setIrAisyoumei(null);
        khKykNaiyouOsiraseBean.setIrYakkannmei(null);
        khKykNaiyouOsiraseBean.setIrKyknm(null);
        khKykNaiyouOsiraseBean.setIrHhknnm(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2(null);
        khKykNaiyouOsiraseBean.setIrStdrsknm(null);
        khKykNaiyouOsiraseBean.setIrKykymd(null);
        khKykNaiyouOsiraseBean.setIrNkuktnm(null);
        khKykNaiyouOsiraseBean.setIrNenkinstartymd(null);
        khKykNaiyouOsiraseBean.setIrNenkinstartnen(null);
        khKykNaiyouOsiraseBean.setIrNenkinsyu(null);
        khKykNaiyouOsiraseBean.setIrNkgnsgk(null);
        khKykNaiyouOsiraseBean.setIrCalckijyunymd(null);
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg(null);
        khKykNaiyouOsiraseBean.setIrTk3msg(null);
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk(null);
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk(null);
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenhrkgk(null);
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk(null);
        khKykNaiyouOsiraseBean.setIrHrktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate(null);
        khKykNaiyouOsiraseBean.setIrStigikwsrate(null);
        khKykNaiyouOsiraseBean.setIrKijyunkingaku(null);
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate(null);
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen(null);
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku(null);
        khKykNaiyouOsiraseBean.setIrSakuseisya(null);
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka(null);
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(null);
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen(null);
        khKykNaiyouOsiraseBean.setIrMkhgkyen(null);
        khKykNaiyouOsiraseBean.setIrMkhgkwari(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2(null);
        khKykNaiyouOsiraseBean.setIrTnsmbairitu(null);
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn(null);
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen(null);
        khKykNaiyouOsiraseBean.setIrTumitateriritu(null);
        khKykNaiyouOsiraseBean.setIrSisuunm(null);
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("06");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi(null);
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai(null);
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka(null);
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen(null);
            khKykNaiyouOsiraseDsBean.setIrSisuu(null);
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu(null);
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu(null);
            khKykNaiyouOsiraseDsBean.setIrKawaserate(null);

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testCreateReport22() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("2，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("06");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testCreateReport23() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

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
        khKykNaiyouOsiraseBean.setIrNkuktnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("９９歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("999．99");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("999．99");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("999．99");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("999．99");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisya("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("９９９");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("９．９９倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("９９．９９％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("９９．９９％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("９．９９％");
        khKykNaiyouOsiraseBean.setIrSisuunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("06");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ＷＷＷＷ");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("9999年99月99日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("ＷＷＷＷ");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("999,999,999.99 ＷＷＷ");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("9,999,999,999 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("999.99");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("99.99%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("99.99%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("999.99 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testCreateReport24() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("0 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("06");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testCreateReport25() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("06");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testCreateReport26() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("06");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testCreateReport27() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("06");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testCreateReport28() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("06");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(290)
    @Transactional
    public void testCreateReport29() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("06");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(300)
    @Transactional
    public void testCreateReport30() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(310)
    @Transactional
    public void testCreateReport31() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(320)
    @Transactional
    public void testCreateReport32() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(330)
    @Transactional
    public void testCreateReport33() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(340)
    @Transactional
    public void testCreateReport34() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(350)
    @Transactional
    public void testCreateReport35() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(360)
    @Transactional
    public void testCreateReport36() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(370)
    @Transactional
    public void testCreateReport37() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(380)
    @Transactional
    public void testCreateReport38() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(390)
    @Transactional
    public void testCreateReport39() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(400)
    @Transactional
    public void testCreateReport40() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("04");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(410)
    @Transactional
    public void testCreateReport41() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("04");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(420)
    @Transactional
    public void testCreateReport42() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("06");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(430)
    @Transactional
    public void testCreateReport43() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("06");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(440)
    @Transactional
    public void testCreateReport44() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("06");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(450)
    @Transactional
    public void testCreateReport45() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("06");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(460)
    @Transactional
    public void testCreateReport46() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("06");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(470)
    @Transactional
    public void testCreateReport47() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("06");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(480)
    @Transactional
    public void testCreateReport48() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("06");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(490)
    @Transactional
    public void testCreateReport49() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("06");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(500)
    @Transactional
    public void testCreateReport50() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("06");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(510)
    @Transactional
    public void testCreateReport51() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("06");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("0");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(520)
    @Transactional
    public void testCreateReport52() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("2，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("05");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 2; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご契約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
        khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("積立金移転");
        khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
        khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動↓定率積立");
        khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
        khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
        khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
        khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
        khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
        khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
        iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);

        for (int i = 3; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご契約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("定率積立");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(530)
    @Transactional
    public void testCreateReport53() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("９．９９倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("９９．９９％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("９９．９９％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("９．９９％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("05");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 2; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご契約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
        khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("積立金移転");
        khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("9999年99月99日");
        khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動↓定率積立");
        khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("999,999,999.99 ＷＷＷ");
        khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("9,999,999,999 円");
        khKykNaiyouOsiraseDsBean.setIrSisuu("999.99");
        khKykNaiyouOsiraseDsBean.setIrSisuuupritu("99.99%");
        khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("99.99%");
        khKykNaiyouOsiraseDsBean.setIrKawaserate("999.99 円");
        iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);

        for (int i = 3; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご契約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("定率積立");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(540)
    @Transactional
    public void testCreateReport54() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("05");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 2; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご契約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
        khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("積立金移転");
        khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("");
        khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動↓定率積立");
        khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("");
        khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("");
        khKykNaiyouOsiraseDsBean.setIrSisuu("");
        khKykNaiyouOsiraseDsBean.setIrSisuuupritu("");
        khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("");
        khKykNaiyouOsiraseDsBean.setIrKawaserate("");
        iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);

        for (int i = 3; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご契約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("定率積立");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(550)
    @Transactional
    public void testCreateReport55() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk(null);
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka(null);
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(null);
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen(null);
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu(null);
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn(null);
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen(null);
        khKykNaiyouOsiraseBean.setIrTumitateriritu(null);
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("05");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 2; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご契約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
        khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("積立金移転");
        khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi(null);
        khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動↓定率積立");
        khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka(null);
        khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen(null);
        khKykNaiyouOsiraseDsBean.setIrSisuu(null);
        khKykNaiyouOsiraseDsBean.setIrSisuuupritu(null);
        khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu(null);
        khKykNaiyouOsiraseDsBean.setIrKawaserate(null);
        iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);

        for (int i = 3; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご契約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("定率積立");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(560)
    @Transactional
    public void testCreateReport56() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("0 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("05");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 2; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご契約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
        khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("積立金移転");
        khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
        khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動↓定率積立");
        khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
        khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
        khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
        khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
        khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
        khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
        iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);

        for (int i = 3; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご契約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("定率積立");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(570)
    @Transactional
    public void testCreateReport57() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("05");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 2; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご契約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
        khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("積立金移転");
        khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
        khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動↓定率積立");
        khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
        khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
        khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
        khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
        khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
        khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
        iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);

        for (int i = 3; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご契約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("定率積立");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(580)
    @Transactional
    public void testCreateReport58() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("05");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 2; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご契約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
        khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("積立金移転");
        khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
        khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動↓定率積立");
        khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
        khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
        khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
        khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
        khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
        khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
        iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);

        for (int i = 3; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご契約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("定率積立");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(590)
    @Transactional
    public void testCreateReport59() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("05");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 2; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご契約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
        khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("積立金移転");
        khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
        khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動↓定率積立");
        khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
        khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
        khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
        khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
        khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
        khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
        iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);

        for (int i = 3; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご契約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("定率積立");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(600)
    @Transactional
    public void testCreateReport60() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("05");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 2; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご契約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
        khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("積立金移転");
        khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
        khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動↓定率積立");
        khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
        khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
        khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
        khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
        khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
        khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
        iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);

        for (int i = 3; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご契約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("定率積立");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(610)
    @Transactional
    public void testCreateReport61() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("05");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("0");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 2; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご契約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
        khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("積立金移転");
        khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
        khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動↓定率積立");
        khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
        khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
        khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
        khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
        khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
        khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
        iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);

        for (int i = 3; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();
            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご契約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("定率積立");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");
            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(620)
    @Transactional
    public void testCreateReport62() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("");
        khKykNaiyouOsiraseBean.setIrSyono("");
        khKykNaiyouOsiraseBean.setIrAisyoumei("");
        khKykNaiyouOsiraseBean.setIrYakkannmei("");
        khKykNaiyouOsiraseBean.setIrKyknm("");
        khKykNaiyouOsiraseBean.setIrHhknnm("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrKykdairinm("");
        khKykNaiyouOsiraseBean.setIrStdrsknm("");
        khKykNaiyouOsiraseBean.setIrKykymd("");
        khKykNaiyouOsiraseBean.setIrNkuktnm("");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("");
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("");
        khKykNaiyouOsiraseBean.setIrHrktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("");
        khKykNaiyouOsiraseBean.setIrSakuseisya("");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("");
        khKykNaiyouOsiraseBean.setIrSisuunm("");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("");
            khKykNaiyouOsiraseDsBean.setIrSisuu("");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(630)
    @Transactional
    public void testCreateReport63() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd(null);
        khKykNaiyouOsiraseBean.setIrSyono(null);
        khKykNaiyouOsiraseBean.setIrAisyoumei(null);
        khKykNaiyouOsiraseBean.setIrYakkannmei(null);
        khKykNaiyouOsiraseBean.setIrKyknm(null);
        khKykNaiyouOsiraseBean.setIrHhknnm(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2(null);
        khKykNaiyouOsiraseBean.setIrKykdairinm(null);
        khKykNaiyouOsiraseBean.setIrStdrsknm(null);
        khKykNaiyouOsiraseBean.setIrKykymd(null);
        khKykNaiyouOsiraseBean.setIrNkuktnm(null);
        khKykNaiyouOsiraseBean.setIrNenkinstartymd(null);
        khKykNaiyouOsiraseBean.setIrNenkinstartnen(null);
        khKykNaiyouOsiraseBean.setIrNenkinsyu(null);
        khKykNaiyouOsiraseBean.setIrNkgnsgk(null);
        khKykNaiyouOsiraseBean.setIrCalckijyunymd(null);
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg(null);
        khKykNaiyouOsiraseBean.setIrTk3msg(null);
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk(null);
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk(null);
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenhrkgk(null);
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk(null);
        khKykNaiyouOsiraseBean.setIrHrktuuka(null);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate(null);
        khKykNaiyouOsiraseBean.setIrStigikwsrate(null);
        khKykNaiyouOsiraseBean.setIrKijyunkingaku(null);
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate(null);
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen(null);
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku(null);
        khKykNaiyouOsiraseBean.setIrSakuseisya(null);
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka(null);
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(null);
        khKykNaiyouOsiraseBean.setIrMkhgkyen(null);
        khKykNaiyouOsiraseBean.setIrMkhgkwari(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2(null);
        khKykNaiyouOsiraseBean.setIrTnsmbairitu(null);
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn(null);
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen(null);
        khKykNaiyouOsiraseBean.setIrTumitateriritu(null);
        khKykNaiyouOsiraseBean.setIrSisuunm(null);
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk(null);
        khKykNaiyouOsiraseBean.setIrTrkkzknm1(null);
        khKykNaiyouOsiraseBean.setIrTrkkzknm2(null);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn(null);
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi(null);
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai(null);
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka(null);
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen(null);
            khKykNaiyouOsiraseDsBean.setIrSisuu(null);
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu(null);
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu(null);
            khKykNaiyouOsiraseDsBean.setIrKawaserate(null);

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(640)
    @Transactional
    public void testCreateReport64() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("   ");
        khKykNaiyouOsiraseBean.setIrKykdairinm("契約者代理人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("被保険者代理人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("登録家族名１　様");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("登録家族名２　様");
        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(650)
    @Transactional
    public void testCreateReport65() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("99991231");
        khKykNaiyouOsiraseBean.setIrSyono("wwwwwwwwwww");
        khKykNaiyouOsiraseBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYakkannmei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKyknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHhknnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrKykdairinm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrStdrsknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKykymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNkuktnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("９９歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk4msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("999．99");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("999．99");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("999．99");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("999．99");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisya("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("0 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("９９９");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("９．９９倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("９９．９９％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("９９．９９％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("９．９９％");
        khKykNaiyouOsiraseBean.setIrSisuunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("04");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ＷＷＷＷ");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("9999年99月99日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("ＷＷＷＷ");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("999,999,999.99 ＷＷＷ");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("9,999,999,999 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("999.99");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("99.99%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("99.99%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("999.99 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(660)
    @Transactional
    public void testCreateReport66() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("   ");
        khKykNaiyouOsiraseBean.setIrKykdairinm("契約者代理人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("被保険者代理人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("2");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("登録家族名１　様");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(670)
    @Transactional
    public void testCreateReport67() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase2", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrNkgnsgk("8，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka("10，000．00 米ドル");
        khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka("17，009．48 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrStigituukahrkgk("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrHrktuuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrYenkhrikmrate("121．01");
        khKykNaiyouOsiraseBean.setIrStigikwsrate("1．2102");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate("121．03");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("");
        khKykNaiyouOsiraseBean.setIrSakuseisya("");
        khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("6，416．18 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("771，418 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("2，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkyen("3，012，057 円");
        khKykNaiyouOsiraseBean.setIrMkhgkwari("５５");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrTnsmbairitu("４．１６倍");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn("４．１７％");
        khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSisuunm("SGI FIA マルチ・アセット指数(米ドル)");
        khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn("03");
        khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn("1");
        khKykNaiyouOsiraseBean.setIrWarningMsg("（本日の為替レートが取得できないため、直前のレートでの試算結果となります）");
        khKykNaiyouOsiraseBean.setIrYobidasimotoKbn(2);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 11; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrTmttknsuiirirekikbn("ご解約時");
            khKykNaiyouOsiraseDsBean.setIrKeiyakuoutoubi("2019年 4月16日");
            khKykNaiyouOsiraseDsBean.setIrTmttknjyoutai("指数連動");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkktuuka("9,879.92 米ドル");
            khKykNaiyouOsiraseDsBean.setIrTumitatekngkkyen("1,187,863 円");
            khKykNaiyouOsiraseDsBean.setIrSisuu("6.77");
            khKykNaiyouOsiraseDsBean.setIrSisuuupritu("1.2%");
            khKykNaiyouOsiraseDsBean.setIrTmttknzoukaritu("5.88%");
            khKykNaiyouOsiraseDsBean.setIrKawaserate("114.33 円");

            iReportDataSouceBean.add(khKykNaiyouOsiraseDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
