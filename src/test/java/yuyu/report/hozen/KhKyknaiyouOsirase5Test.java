package yuyu.report.hozen;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhKykNaiyouOsiraseBean;
import yuyu.def.hozen.bean.report.KhKykNaiyouOsiraseDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ご契約内容のお知らせ5 用クラス
 */
@RunWith(OrderedRunner.class)
public class KhKyknaiyouOsirase5Test {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhKykNaiyouOsiraseBean khKykNaiyouOsiraseBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase5", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE5);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("");
        khKykNaiyouOsiraseBean.setIrSyono("");
        khKykNaiyouOsiraseBean.setIrAisyoumei("");
        khKykNaiyouOsiraseBean.setIrYakkannmei("");
        khKykNaiyouOsiraseBean.setIrKyknm("");
        khKykNaiyouOsiraseBean.setIrHhknnm("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm("");
        khKykNaiyouOsiraseBean.setIrKykdairinm("");
        khKykNaiyouOsiraseBean.setIrStdrsknm("");
        khKykNaiyouOsiraseBean.setIrKykymd("");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("");
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("");
        khKykNaiyouOsiraseBean.setIrSakuseisya("");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean1 = null;

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean1 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean1.setIrKeiyakuoutoubi("");
            khKykNaiyouOsiraseDsBean1.setIrTumitatekngkkyen("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean1);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean2 = null;

        for (int i = 0; i < 3; i++) {

            khKykNaiyouOsiraseDsBean2 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean2.setIrKeiyakuoutoubi("");
            khKykNaiyouOsiraseDsBean2.setIrTumitatekngkkyen("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean2);
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
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase5", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE5);

        khKykNaiyouOsiraseBean.setIrSakuseiymd(null);
        khKykNaiyouOsiraseBean.setIrSyono(null);
        khKykNaiyouOsiraseBean.setIrAisyoumei(null);
        khKykNaiyouOsiraseBean.setIrYakkannmei(null);
        khKykNaiyouOsiraseBean.setIrKyknm(null);
        khKykNaiyouOsiraseBean.setIrHhknnm(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm(null);
        khKykNaiyouOsiraseBean.setIrKykdairinm(null);
        khKykNaiyouOsiraseBean.setIrStdrsknm(null);
        khKykNaiyouOsiraseBean.setIrKykymd(null);
        khKykNaiyouOsiraseBean.setIrYendthnkymd(null);
        khKykNaiyouOsiraseBean.setIrNenkinstartymd(null);
        khKykNaiyouOsiraseBean.setIrNenkinstartnen(null);
        khKykNaiyouOsiraseBean.setIrNenkinsyu(null);
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg(null);
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk(null);
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk(null);
        khKykNaiyouOsiraseBean.setIrKijyunkingaku(null);
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen(null);
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen(null);
        khKykNaiyouOsiraseBean.setIrTumitateriritu(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2(null);
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku(null);
        khKykNaiyouOsiraseBean.setIrSakuseisya(null);
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk(null);
        khKykNaiyouOsiraseBean.setIrTrkkzknm1(null);
        khKykNaiyouOsiraseBean.setIrTrkkzknm2(null);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean1 = null;

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean1 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean1.setIrKeiyakuoutoubi(null);
            khKykNaiyouOsiraseDsBean1.setIrTumitatekngkkyen(null);

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean1);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean2 = null;

        for (int i = 0; i < 3; i++) {

            khKykNaiyouOsiraseDsBean2 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean2.setIrKeiyakuoutoubi(null);
            khKykNaiyouOsiraseDsBean2.setIrTumitatekngkkyen(null);

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean2);
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
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase5", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE5);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ユ受名　一い２　様");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrKykdairinm("契約者代理人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("被保険者代理人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０１８年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("1，187，789 円");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("登録家族名１　様");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("登録家族名２　様");
        khKykNaiyouOsiraseBean.setIrYobidasimotoKbn(1);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean1 = null;

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean1 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean1.setIrKeiyakuoutoubi("2019年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean1.setIrTumitatekngkkyen("1,187,86"+ (i+1) + " 円");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean1);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean2 = null;

        for (int i = 0; i < 3; i++) {

            khKykNaiyouOsiraseDsBean2 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean2.setIrKeiyakuoutoubi("2020年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean2.setIrTumitatekngkkyen("2,298,97"+ (i+1) + " 円");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean2);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase5", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE5);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("99991231");
        khKykNaiyouOsiraseBean.setIrSyono("wwwwwwwwwww");
        khKykNaiyouOsiraseBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrYakkannmei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKyknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrHhknnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrNkuktnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKykdairinm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrStdrsknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKykymd("９９９９年１２月３１日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("９９９９年１２月３１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("９９９９年１２月３１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("９９歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("９．９９％");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisya("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean1 = null;

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean1 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean1.setIrKeiyakuoutoubi("9999年99月99日");
            khKykNaiyouOsiraseDsBean1.setIrTumitatekngkkyen("9,999,999,999 円");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean1);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean2 = null;

        for (int i = 0; i < 3; i++) {

            khKykNaiyouOsiraseDsBean2 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean2.setIrKeiyakuoutoubi("9999年99月99日");
            khKykNaiyouOsiraseDsBean2.setIrTumitatekngkkyen("9,999,999,999 円");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean2);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase5", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE5);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("");
        khKykNaiyouOsiraseBean.setIrSyono("");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみグローバル（定率増加プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("");
        khKykNaiyouOsiraseBean.setIrKyknm("");
        khKykNaiyouOsiraseBean.setIrHhknnm("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrNkuktnm("");
        khKykNaiyouOsiraseBean.setIrKykdairinm("");
        khKykNaiyouOsiraseBean.setIrStdrsknm("");
        khKykNaiyouOsiraseBean.setIrKykymd("");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("");
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("");
        khKykNaiyouOsiraseBean.setIrSakuseisya("");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean1 = null;

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean1 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean1.setIrKeiyakuoutoubi("");
            khKykNaiyouOsiraseDsBean1.setIrTumitatekngkkyen("");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean1);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean2 = null;

        for (int i = 0; i < 3; i++) {

            khKykNaiyouOsiraseDsBean2 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean2.setIrKeiyakuoutoubi("");
            khKykNaiyouOsiraseDsBean2.setIrTumitatekngkkyen("");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean2);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase5", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE5);

        khKykNaiyouOsiraseBean.setIrSakuseiymd(null);
        khKykNaiyouOsiraseBean.setIrSyono(null);
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみステップ");
        khKykNaiyouOsiraseBean.setIrYakkannmei(null);
        khKykNaiyouOsiraseBean.setIrKyknm(null);
        khKykNaiyouOsiraseBean.setIrHhknnm(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2(null);
        khKykNaiyouOsiraseBean.setIrNkuktnm(null);
        khKykNaiyouOsiraseBean.setIrKykdairinm(null);
        khKykNaiyouOsiraseBean.setIrStdrsknm(null);
        khKykNaiyouOsiraseBean.setIrKykymd(null);
        khKykNaiyouOsiraseBean.setIrYendthnkymd(null);
        khKykNaiyouOsiraseBean.setIrNenkinstartymd(null);
        khKykNaiyouOsiraseBean.setIrNenkinstartnen(null);
        khKykNaiyouOsiraseBean.setIrNenkinsyu(null);
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg(null);
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk(null);
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk(null);
        khKykNaiyouOsiraseBean.setIrKijyunkingaku(null);
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen(null);
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen(null);
        khKykNaiyouOsiraseBean.setIrTumitateriritu(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2(null);
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku(null);
        khKykNaiyouOsiraseBean.setIrSakuseisya(null);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean1 = null;

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean1 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean1.setIrKeiyakuoutoubi(null);
            khKykNaiyouOsiraseDsBean1.setIrTumitatekngkkyen(null);

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean1);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean2 = null;

        for (int i = 0; i < 3; i++) {

            khKykNaiyouOsiraseDsBean2 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean2.setIrKeiyakuoutoubi(null);
            khKykNaiyouOsiraseDsBean2.setIrTumitatekngkkyen(null);

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean2);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase5", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE5);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("しんきんらいふ年金Ｓ　たのしみグローバル（指数連動プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrKykdairinm("契約者代理人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("被保険者代理人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０１８年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("1，187，789 円");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("登録家族名１　様");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean1 = null;

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean1 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean1.setIrKeiyakuoutoubi("2019年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean1.setIrTumitatekngkkyen("1,187,86"+ (i+1) + " 円");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean1);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean2 = null;

        for (int i = 0; i < 3; i++) {

            khKykNaiyouOsiraseDsBean2 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean2.setIrKeiyakuoutoubi("2020年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean2.setIrTumitatekngkkyen("2,298,97"+ (i+1) + " 円");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean2);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase5", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE5);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("しんきんらいふ年金Ｓ　たのしみグローバル（定率増加プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrKykdairinm("契約者代理人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("被保険者代理人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０１８年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("1，187，789 円");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean1 = null;

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean1 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean1.setIrKeiyakuoutoubi("2019年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean1.setIrTumitatekngkkyen("1,187,86"+ (i+1) + " 円");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean1);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean2 = null;

        for (int i = 0; i < 3; i++) {

            khKykNaiyouOsiraseDsBean2 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean2.setIrKeiyakuoutoubi("2020年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean2.setIrTumitatekngkkyen("2,298,97"+ (i+1) + " 円");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean2);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase5", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE5);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrKykdairinm("契約者代理人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("被保険者代理人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０１８年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("1，187，789 円");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean1 = null;

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean1 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean1.setIrKeiyakuoutoubi("2019年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean1.setIrTumitatekngkkyen("1,187,86"+ (i+1) + " 円");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean1);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean2 = null;

        for (int i = 0; i < 3; i++) {

            khKykNaiyouOsiraseDsBean2 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean2.setIrKeiyakuoutoubi("2020年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean2.setIrTumitatekngkkyen("2,298,97"+ (i+1) + " 円");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean2);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase5", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE5);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("しんきんらいふ年金Ｓ　たのしみグローバル（定率増加プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrKykdairinm("契約者代理人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("被保険者代理人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０１８年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("1，187，789 円");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean1 = null;

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean1 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean1.setIrKeiyakuoutoubi("2019年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean1.setIrTumitatekngkkyen("1,187,86"+ (i+1) + " 円");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean1);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean2 = null;

        for (int i = 0; i < 3; i++) {

            khKykNaiyouOsiraseDsBean2 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean2.setIrKeiyakuoutoubi("2020年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean2.setIrTumitatekngkkyen("2,298,97"+ (i+1) + " 円");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean2);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase5", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE5);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("しんきんらいふ年金Ｓ　たのしみグローバル（定率増加プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrKykdairinm("契約者代理人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("被保険者代理人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０１８年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("1，187，789 円");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean1 = null;

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean1 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean1.setIrKeiyakuoutoubi("2019年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean1.setIrTumitatekngkkyen("1,187,86"+ (i+1) + " 円");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean1);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean2 = null;

        for (int i = 0; i < 3; i++) {

            khKykNaiyouOsiraseDsBean2 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean2.setIrKeiyakuoutoubi("2020年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean2.setIrTumitatekngkkyen("2,298,97"+ (i+1) + " 円");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean2);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase5", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE5);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("しんきんらいふ年金Ｓ　たのしみグローバル（定率増加プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrKykdairinm("契約者代理人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("被保険者代理人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０１８年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("1，187，789 円");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean1 = null;

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean1 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean1.setIrKeiyakuoutoubi("2019年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean1.setIrTumitatekngkkyen("1,187,86"+ (i+1) + " 円");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean1);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean2 = null;

        for (int i = 0; i < 3; i++) {

            khKykNaiyouOsiraseDsBean2 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean2.setIrKeiyakuoutoubi("2020年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean2.setIrTumitatekngkkyen("2,298,97"+ (i+1) + " 円");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean2);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase5", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE5);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("しんきんらいふ年金Ｓ　たのしみグローバル（定率増加プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrKykdairinm("契約者代理人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("被保険者代理人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０１８年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg(null);
        khKykNaiyouOsiraseBean.setIrTk3msg(null);
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("1，187，789 円");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean1 = null;

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean1 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean1.setIrKeiyakuoutoubi("2019年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean1.setIrTumitatekngkkyen("1,187,86"+ (i+1) + " 円");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean1);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean2 = null;

        for (int i = 0; i < 3; i++) {

            khKykNaiyouOsiraseDsBean2 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean2.setIrKeiyakuoutoubi("2020年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean2.setIrTumitatekngkkyen("2,298,97"+ (i+1) + " 円");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean2);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase5", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE5);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("しんきんらいふ年金Ｓ　たのしみグローバル（定率増加プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrKykdairinm("契約者代理人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("被保険者代理人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０１８年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("1，187，789 円");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean1 = null;

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean1 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean1.setIrKeiyakuoutoubi("2019年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean1.setIrTumitatekngkkyen("1,187,86"+ (i+1) + " 円");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean1);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean2 = null;

        for (int i = 0; i < 3; i++) {

            khKykNaiyouOsiraseDsBean2 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean2.setIrKeiyakuoutoubi("2020年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean2.setIrTumitatekngkkyen("2,298,97"+ (i+1) + " 円");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean2);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase5", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE5);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("しんきんらいふ年金Ｓ　たのしみグローバル（定率増加プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrKykdairinm("契約者代理人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("被保険者代理人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０１８年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk4msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("1，187，789 円");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean1 = null;

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean1 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean1.setIrKeiyakuoutoubi("2019年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean1.setIrTumitatekngkkyen("1,187,86"+ (i+1) + " 円");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean1);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean2 = null;

        for (int i = 0; i < 3; i++) {

            khKykNaiyouOsiraseDsBean2 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean2.setIrKeiyakuoutoubi("2020年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean2.setIrTumitatekngkkyen("2,298,97"+ (i+1) + " 円");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean2);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase5", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE5);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("しんきんらいふ年金Ｓ　たのしみグローバル（定率増加プラン）");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrNkuktnm("年金受取人名　様");
        khKykNaiyouOsiraseBean.setIrKykdairinm("契約者代理人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("被保険者代理人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１７年　４月２１日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０１８年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartymd("２０１９年　４月２１日");
        khKykNaiyouOsiraseBean.setIrNenkinstartnen("２歳");
        khKykNaiyouOsiraseBean.setIrNenkinsyu("５年確定年金");
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKijyunkingaku("1，187，345 円");
        khKykNaiyouOsiraseBean.setIrTumitatekngkkyen("1，187，863 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("0 円");
        khKykNaiyouOsiraseBean.setIrTumitateriritu("４．１８％");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku(null);
        khKykNaiyouOsiraseBean.setIrSakuseisya(null);
        khKykNaiyouOsiraseBean.setIrYobidasimotoKbn(2);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean1 = null;

        for (int i = 0; i < 5; i++) {

            khKykNaiyouOsiraseDsBean1 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean1.setIrKeiyakuoutoubi("2019年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean1.setIrTumitatekngkkyen("1,187,86"+ (i+1) + " 円");

            ytrrtKwsrateP1yearLeftList.add(khKykNaiyouOsiraseDsBean1);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);

        List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = new ArrayList<KhKykNaiyouOsiraseDataSourceBean>();

        KhKykNaiyouOsiraseDataSourceBean khKykNaiyouOsiraseDsBean2 = null;

        for (int i = 0; i < 3; i++) {

            khKykNaiyouOsiraseDsBean2 = new KhKykNaiyouOsiraseDataSourceBean();

            khKykNaiyouOsiraseDsBean2.setIrKeiyakuoutoubi("2020年 "+ (i+1) + "月1" + (i+1) + "日");
            khKykNaiyouOsiraseDsBean2.setIrTumitatekngkkyen("2,298,97"+ (i+1) + " 円");

            ytrrtKwsrateP1yearRightList.add(khKykNaiyouOsiraseDsBean2);
        }

        khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}