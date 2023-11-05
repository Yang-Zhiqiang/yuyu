package yuyu.report.hozen;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.bean.report.KhKykNaiyouOsiraseBean;
import yuyu.def.hozen.bean.report.KhKykNaiyouOsiraseDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ご契約内容のお知らせ３ 用クラス
 */
@RunWith(OrderedRunner.class)
public class KhKyknaiyouOsirase3Test {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhKykNaiyouOsiraseBean khKykNaiyouOsiraseBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("");
        khKykNaiyouOsiraseBean.setIrSyono("");
        khKykNaiyouOsiraseBean.setIrAisyoumei("");
        khKykNaiyouOsiraseBean.setIrYakkannmei("");
        khKykNaiyouOsiraseBean.setIrHhknnm("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm("");
        khKykNaiyouOsiraseBean.setIrStdrsknm("");
        khKykNaiyouOsiraseBean.setIrKykymd("");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("６か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("");
        khKykNaiyouOsiraseBean.setIrSueokikkn("");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("");
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("");
        khKykNaiyouOsiraseBean.setIrSakuseisya("");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("38，101 円");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05017");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("05019");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("");
        khKykNaiyouOsiraseBean.setIrWarningMsg("");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("");
            khKykNaiyouOsiraseDsBean.setIrPyen("");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 6; i++) {
            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("");
            khKykNaiyouOsiraseDsBean.setIrPyen("");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2(null);
        khKykNaiyouOsiraseBean.setIrSakuseiymd(null);
        khKykNaiyouOsiraseBean.setIrSyono(null);
        khKykNaiyouOsiraseBean.setIrAisyoumei(null);
        khKykNaiyouOsiraseBean.setIrYakkannmei(null);
        khKykNaiyouOsiraseBean.setIrHhknnm(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm(null);
        khKykNaiyouOsiraseBean.setIrStdrsknm(null);
        khKykNaiyouOsiraseBean.setIrKykymd(null);
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn(null);
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("６か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro(null);
        khKykNaiyouOsiraseBean.setIrPhrkkkn(null);
        khKykNaiyouOsiraseBean.setIrNenkinstartymd(null);
        khKykNaiyouOsiraseBean.setIrNenkinstartnen(null);
        khKykNaiyouOsiraseBean.setIrSueokikkn(null);
        khKykNaiyouOsiraseBean.setIrNenkinsyu(null);
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg(null);
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk(null);
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk(null);
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku(null);
        khKykNaiyouOsiraseBean.setIrSakuseisya(null);
        khKykNaiyouOsiraseBean.setIrYenhrkgk(null);
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk(null);
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk(null);
        khKykNaiyouOsiraseBean.setIrCalckijyunymd(null);
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen(null);
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(null);
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk(null);
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("38，101 円");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk(null);
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5(null);
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai(null);
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai(null);
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai(null);
        khKykNaiyouOsiraseBean.setIrHrritusyourai5(null);

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05017");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("05019");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk(null);
        khKykNaiyouOsiraseBean.setIrTrkkzknm1(null);
        khKykNaiyouOsiraseBean.setIrTrkkzknm2(null);
        khKykNaiyouOsiraseBean.setIrWarningMsg(null);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu(null);
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5(null);
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt(null);
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym(null);
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate(null);
            khKykNaiyouOsiraseDsBean.setIrPyen(null);
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka(null);
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn(null);

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu(null);
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5(null);
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt(null);
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym(null);
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate(null);
            khKykNaiyouOsiraseDsBean.setIrPyen(null);
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka(null);
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn(null);

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみ未来グローバル");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("月払");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("６か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("団体");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("４歳");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrSueokikkn("５年");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("16，943 円");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("1，357，901 円");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("8，101 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("18，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("28，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("38，101 円");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("0");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("29 ％");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("58，101 円");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("0");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("19 ％");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05017");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("05019");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("登録家族名１　様");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("登録家族名２　様");
        khKykNaiyouOsiraseBean.setIrWarningMsg("（本日の為替レートが取得できないため、直前のレートでの試算結果となります）");
        khKykNaiyouOsiraseBean.setIrYobidasimotoKbn(1);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 7月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("0.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("0.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2019年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，067円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("17，490．52 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 8月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.95円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

        khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年10月");
        khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
        khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
        khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年10月");
        khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
        khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
        khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
        khKykNaiyouOsiraseDsBean.setFstphyoujikbn("1");

        ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("99991231");
        khKykNaiyouOsiraseBean.setIrSyono("wwwwwwwwwww");
        khKykNaiyouOsiraseBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYakkannmei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHhknnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNkuktnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrStdrsknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKykymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("ＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("１２か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("９９歳");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("９９歳");
        khKykNaiyouOsiraseBean.setIrSueokikkn("９９年");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisya("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("999．99");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("0");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("999 ％");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("0");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("999 ％");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05017");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("05019");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrWarningMsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("9999年12月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("9.99%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("9.99%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("9999年12月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("999．99円");
            khKykNaiyouOsiraseDsBean.setIrPyen("999，999，999円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("999，999，999．99ＷＷＷ");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 6; i++) {
            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("9999年12月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("9.99%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("9.99%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("9999年12月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("999．99円");
            khKykNaiyouOsiraseDsBean.setIrPyen("999，999，999円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("999，999，999．99ＷＷＷ");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("");
        khKykNaiyouOsiraseBean.setIrSyono("");
        khKykNaiyouOsiraseBean.setIrAisyoumei("");
        khKykNaiyouOsiraseBean.setIrYakkannmei("");
        khKykNaiyouOsiraseBean.setIrHhknnm("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrNkuktnm("");
        khKykNaiyouOsiraseBean.setIrStdrsknm("");
        khKykNaiyouOsiraseBean.setIrKykymd("");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("６か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("");
        khKykNaiyouOsiraseBean.setIrSueokikkn("");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("");
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("");
        khKykNaiyouOsiraseBean.setIrSakuseisya("");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("38，101 円");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("48，101 円");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("68，101 円");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05017");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("");
            khKykNaiyouOsiraseDsBean.setIrPyen("");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 6; i++) {
            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("");
            khKykNaiyouOsiraseDsBean.setIrPyen("");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2(null);
        khKykNaiyouOsiraseBean.setIrSakuseiymd(null);
        khKykNaiyouOsiraseBean.setIrSyono(null);
        khKykNaiyouOsiraseBean.setIrAisyoumei(null);
        khKykNaiyouOsiraseBean.setIrYakkannmei(null);
        khKykNaiyouOsiraseBean.setIrHhknnm(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2(null);
        khKykNaiyouOsiraseBean.setIrNkuktnm(null);
        khKykNaiyouOsiraseBean.setIrStdrsknm(null);
        khKykNaiyouOsiraseBean.setIrKykymd(null);
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn(null);
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("６か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro(null);
        khKykNaiyouOsiraseBean.setIrPhrkkkn(null);
        khKykNaiyouOsiraseBean.setIrNenkinstartymd(null);
        khKykNaiyouOsiraseBean.setIrNenkinstartnen(null);
        khKykNaiyouOsiraseBean.setIrSueokikkn(null);
        khKykNaiyouOsiraseBean.setIrNenkinsyu(null);
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg(null);
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk(null);
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk(null);
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku(null);
        khKykNaiyouOsiraseBean.setIrSakuseisya(null);
        khKykNaiyouOsiraseBean.setIrYenhrkgk(null);
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk(null);
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk(null);
        khKykNaiyouOsiraseBean.setIrCalckijyunymd(null);
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen(null);
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(null);
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk(null);
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("38，101 円");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("48，101 円");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5(null);
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai(null);
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai(null);
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("68，101 円");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5(null);

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05017");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu(null);
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5(null);
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt(null);
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym(null);
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate(null);
            khKykNaiyouOsiraseDsBean.setIrPyen(null);
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka(null);
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn(null);

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu(null);
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5(null);
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt(null);
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym(null);
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate(null);
            khKykNaiyouOsiraseDsBean.setIrPyen(null);
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka(null);
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn(null);

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみ未来グローバル");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("月払");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("６か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("団体");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("４歳");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrSueokikkn("５年");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("16，943 円");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("1，357，901 円");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("8，101 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("18，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("28，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("38，101 円");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("48，101 円");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("29 ％");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("58，101 円");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("68，101 円");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("19 ％");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05017");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05045");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("登録家族名１　様");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 7月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("0.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("0.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2019年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，067円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("17，490．52 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 8月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.95円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

        khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年10月");
        khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
        khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
        khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年10月");
        khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
        khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
        khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
        khKykNaiyouOsiraseDsBean.setFstphyoujikbn("0");

        ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("99991231");
        khKykNaiyouOsiraseBean.setIrSyono("wwwwwwwwwww");
        khKykNaiyouOsiraseBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYakkannmei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHhknnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrNkuktnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrStdrsknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKykymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("ＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("１２か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("９９歳");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("９９歳");
        khKykNaiyouOsiraseBean.setIrSueokikkn("９９年");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisya("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("999．99");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("999 ％");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("999 ％");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05017");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("9999年12月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("9.99%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("9.99%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("9999年12月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("999．99円");
            khKykNaiyouOsiraseDsBean.setIrPyen("999，999，999円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("999，999，999．99ＷＷＷ");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 6; i++) {
            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("9999年12月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("9.99%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("9.99%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("9999年12月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("999．99円");
            khKykNaiyouOsiraseDsBean.setIrPyen("999，999，999円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("999，999，999．99ＷＷＷ");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("");
        khKykNaiyouOsiraseBean.setIrSyono("");
        khKykNaiyouOsiraseBean.setIrAisyoumei("");
        khKykNaiyouOsiraseBean.setIrYakkannmei("");
        khKykNaiyouOsiraseBean.setIrHhknnm("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm("");
        khKykNaiyouOsiraseBean.setIrStdrsknm("");
        khKykNaiyouOsiraseBean.setIrKykymd("");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("定期一括なし");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("");
        khKykNaiyouOsiraseBean.setIrSueokikkn("");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("");
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("");
        khKykNaiyouOsiraseBean.setIrSakuseisya("");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("48，101 円");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("68，101 円");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("");
            khKykNaiyouOsiraseDsBean.setIrPyen("");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 6; i++) {
            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("");
            khKykNaiyouOsiraseDsBean.setIrPyen("");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2(null);
        khKykNaiyouOsiraseBean.setIrSakuseiymd(null);
        khKykNaiyouOsiraseBean.setIrSyono(null);
        khKykNaiyouOsiraseBean.setIrAisyoumei(null);
        khKykNaiyouOsiraseBean.setIrYakkannmei(null);
        khKykNaiyouOsiraseBean.setIrHhknnm(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm(null);
        khKykNaiyouOsiraseBean.setIrStdrsknm(null);
        khKykNaiyouOsiraseBean.setIrKykymd(null);
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn(null);
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("定期一括なし");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro(null);
        khKykNaiyouOsiraseBean.setIrPhrkkkn(null);
        khKykNaiyouOsiraseBean.setIrNenkinstartymd(null);
        khKykNaiyouOsiraseBean.setIrNenkinstartnen(null);
        khKykNaiyouOsiraseBean.setIrSueokikkn(null);
        khKykNaiyouOsiraseBean.setIrNenkinsyu(null);
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg(null);
        khKykNaiyouOsiraseBean.setIrTk3msg(null);
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk(null);
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk(null);
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku(null);
        khKykNaiyouOsiraseBean.setIrSakuseisya(null);
        khKykNaiyouOsiraseBean.setIrYenhrkgk(null);
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk(null);
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk(null);
        khKykNaiyouOsiraseBean.setIrCalckijyunymd(null);
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen(null);
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(null);
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk(null);
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk(null);
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("48，101 円");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5(null);
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai(null);
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai(null);
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("68，101 円");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5(null);

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu(null);
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5(null);
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt(null);
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym(null);
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate(null);
            khKykNaiyouOsiraseDsBean.setIrPyen(null);
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka(null);
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn(null);

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu(null);
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5(null);
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt(null);
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym(null);
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate(null);
            khKykNaiyouOsiraseDsBean.setIrPyen(null);
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka(null);
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn(null);

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみ未来グローバル");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("月払");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("定期一括なし");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("団体");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("４歳");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrSueokikkn("５年");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("16，943 円");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("1，357，901 円");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("8，101 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("18，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("28，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("0");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("48，101 円");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("29 ％");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("58，101 円");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("68，101 円");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("19 ％");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.SGKHSYSYSNNENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 7月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("0.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("0.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2019年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，067円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("17，490．52 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 8月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.95円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

        khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年10月");
        khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
        khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
        khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年10月");
        khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
        khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
        khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
        khKykNaiyouOsiraseDsBean.setFstphyoujikbn("1");

        ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("99991231");
        khKykNaiyouOsiraseBean.setIrSyono("wwwwwwwwwww");
        khKykNaiyouOsiraseBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYakkannmei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHhknnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNkuktnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrStdrsknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKykymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("ＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("９９歳");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("９９歳");
        khKykNaiyouOsiraseBean.setIrSueokikkn("９９年");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisya("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("999．99");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("0");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("999 ％");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("999 ％");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.NONE);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("9999年12月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("9.99%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("9.99%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("9999年12月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("999．99円");
            khKykNaiyouOsiraseDsBean.setIrPyen("999，999，999円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("999，999，999．99ＷＷＷ");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 6; i++) {
            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("9999年12月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("9.99%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("9.99%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("9999年12月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("999．99円");
            khKykNaiyouOsiraseDsBean.setIrPyen("999，999，999円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("999，999，999．99ＷＷＷ");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("1");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみ未来グローバル");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("月払");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("定期一括なし");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("団体");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("４歳");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrSueokikkn("５年");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("16，943 円");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("1，357，901 円");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("8，101 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("18，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("28，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("0");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("0");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("29 ％");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("58，101 円");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("0");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("19 ％");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("05019");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 7月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("0.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("0.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2019年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，067円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("17，490．52 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 8月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.95円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

        khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年10月");
        khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
        khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
        khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年10月");
        khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
        khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
        khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
        khKykNaiyouOsiraseDsBean.setFstphyoujikbn("1");

        ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみ未来グローバル");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("月払");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("６か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("団体");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("４歳");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrSueokikkn("５年");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("16，943 円");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("1，357，901 円");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("0");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("0");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("29 ％");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("58，101 円");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("0");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("19 ％");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("05019");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 7月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("0.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("0.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2019年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，067円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("17，490．52 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 8月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.95円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

        khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年10月");
        khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
        khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
        khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年10月");
        khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
        khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
        khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
        khKykNaiyouOsiraseDsBean.setFstphyoujikbn("1");

        ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみ未来グローバル＜学資積立プラン＞");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("月払");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("６か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("団体");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("４歳");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrSueokikkn("５年");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("16，943 円");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("1，357，901 円");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("0");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("0");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("29 ％");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("58，101 円");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("0");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("19 ％");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("05019");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 7月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("0.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("0.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2019年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，067円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("17，490．52 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 8月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.95円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

        khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年10月");
        khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
        khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
        khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年10月");
        khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
        khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
        khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
        khKykNaiyouOsiraseDsBean.setFstphyoujikbn("1");

        ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみ未来ワールド");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("月払");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("６か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("団体");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("４歳");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrSueokikkn("５年");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("16，943 円");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("1，357，901 円");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(null);
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk(null);
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("0");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("0");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("29 ％");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("58，101 円");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("0");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("19 ％");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 7月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("0.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("0.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2019年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，067円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("17，490．52 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 8月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.95円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

        khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年10月");
        khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
        khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
        khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年10月");
        khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
        khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
        khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
        khKykNaiyouOsiraseDsBean.setFstphyoujikbn("1");

        ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみ未来ワールド＜学資積立プラン＞");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("月払");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("６か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("団体");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("４歳");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrSueokikkn("５年");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("16，943 円");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("1，357，901 円");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("8，101 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("18，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("28，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("38，101 円");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("0");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("29 ％");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("58，101 円");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("0");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("19 ％");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 7月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("0.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("0.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2019年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，067円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("17，490．52 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 8月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.95円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

        khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年10月");
        khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
        khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
        khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年10月");
        khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
        khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
        khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
        khKykNaiyouOsiraseDsBean.setFstphyoujikbn("1");

        ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("しんきんらいふ年金Ｓ　たのしみ未来グローバル");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("月払");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("６か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("団体");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("４歳");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrSueokikkn("５年");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("16，943 円");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("1，357，901 円");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("8，101 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("18，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("28，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("38，101 円");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("0");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("29 ％");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("58，101 円");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("0");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("19 ％");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05017");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("05019");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 7月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("0.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("0.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2019年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，067円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("17，490．52 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 8月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.95円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

        khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年10月");
        khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
        khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
        khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年10月");
        khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
        khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
        khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
        khKykNaiyouOsiraseDsBean.setFstphyoujikbn("1");

        ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("しんきんらいふ年金Ｓたのしみ未来グローバル＜学資積立プラン＞");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("月払");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("６か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("団体");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("４歳");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrSueokikkn("５年");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("16，943 円");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("1，357，901 円");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("8，101 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("18，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("28，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("38，101 円");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("0");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("29 ％");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("58，101 円");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("0");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("19 ％");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("05019");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("05019");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 7月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("0.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("0.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2019年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，067円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("17，490．52 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 8月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.95円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

        khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年10月");
        khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
        khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
        khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年10月");
        khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
        khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
        khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
        khKykNaiyouOsiraseDsBean.setFstphyoujikbn("1");

        ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("月払");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("６か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("団体");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("４歳");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrSueokikkn("５年");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("16，943 円");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("1，357，901 円");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("8，101 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("18，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("28，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("38，101 円");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("0");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("29 ％");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("58，101 円");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("0");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("19 ％");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05017");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 7月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("0.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("0.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2019年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，067円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("17，490．52 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 8月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.95円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

        khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年10月");
        khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
        khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
        khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年10月");
        khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
        khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
        khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
        khKykNaiyouOsiraseDsBean.setFstphyoujikbn("1");

        ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testCreateReport21() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみ未来グローバル");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("月払");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("６か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("団体");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("４歳");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrSueokikkn("５年");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("16，943 円");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("1，357，901 円");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("8，101 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("18，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("28，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("38，101 円");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("0");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("29 ％");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("58，101 円");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("0");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("19 ％");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("05019");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 7月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("0.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("0.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2019年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，067円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("17，490．52 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 8月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.95円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

        khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年10月");
        khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
        khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
        khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年10月");
        khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
        khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
        khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
        khKykNaiyouOsiraseDsBean.setFstphyoujikbn("1");

        ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testCreateReport22() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("充実みらいグローバル");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("月払");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("６か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("団体");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("４歳");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrSueokikkn("５年");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("16，943 円");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("1，357，901 円");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("8，101 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("18，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("28，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("38，101 円");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("0");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("29 ％");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("58，101 円");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("0");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("19 ％");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05017");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 7月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("0.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("0.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2019年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，067円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("17，490．52 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 8月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.95円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

        khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年10月");
        khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
        khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
        khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年10月");
        khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
        khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
        khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
        khKykNaiyouOsiraseDsBean.setFstphyoujikbn("1");

        ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testCreateReport23() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("充実みらいグローバル＜学資積立プラン＞");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("月払");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("６か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("団体");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("４歳");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrSueokikkn("５年");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("16，943 円");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("1，357，901 円");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("8，101 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("18，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("28，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("38，101 円");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("0");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("29 ％");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("58，101 円");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("0");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("19 ％");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05017");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 7月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("0.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("0.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2019年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，067円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("17，490．52 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 8月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.95円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

        khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年10月");
        khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
        khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
        khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年10月");
        khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
        khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
        khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
        khKykNaiyouOsiraseDsBean.setFstphyoujikbn("1");

        ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }


    @Test
    @TestOrder(240)
    @Transactional
    public void testCreateReport24() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("");
        khKykNaiyouOsiraseBean.setIrSyono("");
        khKykNaiyouOsiraseBean.setIrAisyoumei("");
        khKykNaiyouOsiraseBean.setIrYakkannmei("");
        khKykNaiyouOsiraseBean.setIrHhknnm("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm("");
        khKykNaiyouOsiraseBean.setIrKykdairinm("");
        khKykNaiyouOsiraseBean.setIrStdrsknm("");
        khKykNaiyouOsiraseBean.setIrKykymd("");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("６か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("");
        khKykNaiyouOsiraseBean.setIrSueokikkn("");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("");
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("");
        khKykNaiyouOsiraseBean.setIrSakuseisya("");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("38，101 円");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05017");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("05019");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("");
            khKykNaiyouOsiraseDsBean.setIrPyen("");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 6; i++) {
            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("");
            khKykNaiyouOsiraseDsBean.setIrPyen("");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testCreateReport25() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2(null);
        khKykNaiyouOsiraseBean.setIrSakuseiymd(null);
        khKykNaiyouOsiraseBean.setIrSyono(null);
        khKykNaiyouOsiraseBean.setIrAisyoumei(null);
        khKykNaiyouOsiraseBean.setIrYakkannmei(null);
        khKykNaiyouOsiraseBean.setIrHhknnm(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm(null);
        khKykNaiyouOsiraseBean.setIrKykdairinm(null);
        khKykNaiyouOsiraseBean.setIrStdrsknm(null);
        khKykNaiyouOsiraseBean.setIrKykymd(null);
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn(null);
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("６か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro(null);
        khKykNaiyouOsiraseBean.setIrPhrkkkn(null);
        khKykNaiyouOsiraseBean.setIrNenkinstartymd(null);
        khKykNaiyouOsiraseBean.setIrNenkinstartnen(null);
        khKykNaiyouOsiraseBean.setIrSueokikkn(null);
        khKykNaiyouOsiraseBean.setIrNenkinsyu(null);
        khKykNaiyouOsiraseBean.setIrSiteituuka(null);
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg(null);
        khKykNaiyouOsiraseBean.setIrTk3msg(null);
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk(null);
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk(null);
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku(null);
        khKykNaiyouOsiraseBean.setIrSakuseisya(null);
        khKykNaiyouOsiraseBean.setIrYenhrkgk(null);
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk(null);
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk(null);
        khKykNaiyouOsiraseBean.setIrCalckijyunymd(null);
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen(null);
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(null);
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk(null);
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("38，101 円");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk(null);
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5(null);
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai(null);
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai(null);
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai(null);
        khKykNaiyouOsiraseBean.setIrHrritusyourai5(null);

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05017");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("05019");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu(null);
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5(null);
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt(null);
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym(null);
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate(null);
            khKykNaiyouOsiraseDsBean.setIrPyen(null);
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka(null);
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn(null);

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu(null);
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5(null);
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt(null);
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym(null);
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate(null);
            khKykNaiyouOsiraseDsBean.setIrPyen(null);
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka(null);
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn(null);

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testCreateReport26() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみ未来グローバル");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrKykdairinm("契約者代理人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("被保険者代理人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("月払");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("６か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("団体");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("４歳");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrSueokikkn("５年");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrTk5msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("16，943 円");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("1，357，901 円");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("8，101 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("18，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("28，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("38，101 円");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("0");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("29 ％");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("58，101 円");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("0");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("19 ％");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05017");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("05019");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 7月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("0.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("0.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2019年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，067円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("17，490．52 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 8月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.95円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

        khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年10月");
        khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
        khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
        khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年10月");
        khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
        khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
        khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
        khKykNaiyouOsiraseDsBean.setFstphyoujikbn("1");

        ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testCreateReport27() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("99991231");
        khKykNaiyouOsiraseBean.setIrSyono("wwwwwwwwwww");
        khKykNaiyouOsiraseBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYakkannmei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHhknnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNkuktnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKykdairinm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrStdrsknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKykymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("ＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("１２か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("９９歳");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("９９歳");
        khKykNaiyouOsiraseBean.setIrSueokikkn("９９年");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.AUD);
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk4msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisya("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYenhrkgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("999．99");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("0");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("999 ％");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("9，999，999，999．99 ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("0");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("999 ％");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05017");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("05019");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("9999年12月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("9.99%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("9.99%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("9999年12月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("999．99円");
            khKykNaiyouOsiraseDsBean.setIrPyen("999，999，999円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("999，999，999．99ＷＷＷ");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 6; i++) {
            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("9999年12月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("9.99%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("9.99%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("9999年12月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("999．99円");
            khKykNaiyouOsiraseDsBean.setIrPyen("999，999，999円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("999，999，999．99ＷＷＷ");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testCreateReport28() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase3",
                C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3);

        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみ未来グローバル");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("指定代理請求人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn("月払");
        khKykNaiyouOsiraseBean.setIrTikiktbrisyurui("６か月定期一括");
        khKykNaiyouOsiraseBean.setIrPhrkkeiro("団体");
        khKykNaiyouOsiraseBean.setIrPhrkkkn("４歳");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrSueokikkn("５年");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrSiteituuka(C_Tuukasyu.USD);
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("");
        khKykNaiyouOsiraseBean.setIrSakuseisya("");

        khKykNaiyouOsiraseBean.setIrYenhrkgk("12，912，909 円");
        khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk("16，943 円");
        khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk("1，357，901 円");
        khKykNaiyouOsiraseBean.setIrCalckijyunymd("２０１８年　４月２４日");
        khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate("120．23");
        khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka("10，000．01 米ドル");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("1，202，300 円");
        khKykNaiyouOsiraseBean.setIrKaiyakujshrgk("8，101 円");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka("25，303．24 米ドル");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("18，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk("28，101 円");
        khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk("38，101 円");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk("0");
        khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5("29 ％");
        khKykNaiyouOsiraseBean.setIrNkgnsyensyourai("58，101 円");
        khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai("9，879．92 米ドル");
        khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai("0");
        khKykNaiyouOsiraseBean.setIrHrritusyourai5("19 ％");

        khKykNaiyouOsiraseBean.setIrZennouumu(C_UmuKbn.ARI);
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7("05017");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8("05018");
        khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9("05019");
        khKykNaiyouOsiraseBean.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5("05044");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("登録家族名１　様");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("登録家族名２　様");
        khKykNaiyouOsiraseBean.setIrWarningMsg("（本日の為替レートが取得できないため、直前のレートでの試算結果となります）");
        khKykNaiyouOsiraseBean.setIrYobidasimotoKbn(2);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean = null;

        for (int i = 0; i < 6; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 7月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("0.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("0.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2019年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，067円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("17，490．52 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年 8月");
            khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
            khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
            khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年 6月");
            khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.95円");
            khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
            khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
            khKykNaiyouOsiraseDsBean.setFstphyoujikbn("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);
        }

        khKykNaiyouOsiraseDsBean = new KhKykNaiyouOsiraseDataSourceBean();

        khKykNaiyouOsiraseDsBean.setIrKeiyakugonogetu("2019年10月");
        khKykNaiyouOsiraseDsBean.setIrYoteiriritu5("7.24%");
        khKykNaiyouOsiraseDsBean.setIrYtirrtcalckijyunrrt("6.14%");
        khKykNaiyouOsiraseDsBean.setIrKawaseratekijyunym("2020年10月");
        khKykNaiyouOsiraseDsBean.setIrKnsnkwsrate("27.15円");
        khKykNaiyouOsiraseDsBean.setIrPyen("9，867円");
        khKykNaiyouOsiraseDsBean.setIrPkyktuuka("85，490．62 米ドル");
        khKykNaiyouOsiraseDsBean.setFstphyoujikbn("1");

        ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean);

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
