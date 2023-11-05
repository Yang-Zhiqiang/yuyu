package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhKykNaiyouOsiraseBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ご契約内容のお知らせ４ 用クラス
 */
@RunWith(OrderedRunner.class)
public class KhKyknaiyouOsirase4Test {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhKykNaiyouOsiraseBean khKykNaiyouOsiraseBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrYendthnkymd("");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("");
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("");
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr("");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("");
        khKykNaiyouOsiraseBean.setIrSakuseisya("");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrYendthnkymd(null);
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom(null);
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg(null);
        khKykNaiyouOsiraseBean.setIrTk3msg(null);
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk(null);
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(null);
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr(null);
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2(null);
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku(null);
        khKykNaiyouOsiraseBean.setIrSakuseisya(null);
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk(null);
        khKykNaiyouOsiraseBean.setIrTrkkzknm1(null);
        khKykNaiyouOsiraseBean.setIrTrkkzknm2(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen(null);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　５月３０日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０２０年　５月２９日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２２年　５月２９日");
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("3，519，785 円");
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr("2，637，396 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("1，297，395 円");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("登録家族名１　様");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("登録家族名２　様");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("4，854，325 円");
        khKykNaiyouOsiraseBean.setIrYobidasimotoKbn(1);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrKykymd("９９９９年１２月３１日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("９９９９年１２月３１日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("９９９９年１２月３１日");
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk4msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisya("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("9，999，999，999 円");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("");
        khKykNaiyouOsiraseBean.setIrSyono("");
        khKykNaiyouOsiraseBean.setIrAisyoumei("たのしみステップ");
        khKykNaiyouOsiraseBean.setIrYakkannmei("");
        khKykNaiyouOsiraseBean.setIrKyknm("");
        khKykNaiyouOsiraseBean.setIrHhknnm("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrKykdairinm("");
        khKykNaiyouOsiraseBean.setIrStdrsknm("");
        khKykNaiyouOsiraseBean.setIrKykymd("");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("");
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("");
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr("");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("");
        khKykNaiyouOsiraseBean.setIrSakuseisya("");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("");


        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

        khKykNaiyouOsiraseBean.setIrSakuseiymd(null);
        khKykNaiyouOsiraseBean.setIrSyono(null);
        khKykNaiyouOsiraseBean.setIrAisyoumei("ふるはーとＪロードグローバル");
        khKykNaiyouOsiraseBean.setIrYakkannmei(null);
        khKykNaiyouOsiraseBean.setIrKyknm(null);
        khKykNaiyouOsiraseBean.setIrHhknnm(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1(null);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2(null);
        khKykNaiyouOsiraseBean.setIrKykdairinm(null);
        khKykNaiyouOsiraseBean.setIrStdrsknm(null);
        khKykNaiyouOsiraseBean.setIrKykymd(null);
        khKykNaiyouOsiraseBean.setIrYendthnkymd(null);
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom(null);
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg(null);
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg(null);
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk(null);
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(null);
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr(null);
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2(null);
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku(null);
        khKykNaiyouOsiraseBean.setIrSakuseisya(null);
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk(null);
        khKykNaiyouOsiraseBean.setIrTrkkzknm1(null);
        khKykNaiyouOsiraseBean.setIrTrkkzknm2(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen(null);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

        khKykNaiyouOsiraseBean.setIrSakuseiymd("20190528");
        khKykNaiyouOsiraseBean.setIrSyono("60806000022");
        khKykNaiyouOsiraseBean.setIrAisyoumei("しんきんらいふ終身S　ふるはーとJロードグローバル");
        khKykNaiyouOsiraseBean.setIrYakkannmei("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        khKykNaiyouOsiraseBean.setIrKyknm("ユ被名　一い");
        khKykNaiyouOsiraseBean.setIrHhknnm("ユ被名　一い２");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1("ユ受名　一い　様");
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2("");
        khKykNaiyouOsiraseBean.setIrKykdairinm("契約者代理人名　様");
        khKykNaiyouOsiraseBean.setIrStdrsknm("被保険者代理人名　様");
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　５月３０日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０２０年　５月２９日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２２年　５月２９日");
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("3，519，785 円");
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr("2，637，396 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("1，297，395 円");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("登録家族名１　様");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("登録家族名２　様");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("4，854，325 円");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrYendthnkymd("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("ＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisya("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("9，999，999，999 円");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　５月３０日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０２０年　５月２９日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２２年　５月２９日");
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("3，519，785 円");
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr("2，637，396 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("1，297，395 円");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("登録家族名１　様");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("登録家族名２　様");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("4，854，325 円");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　５月３０日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０２０年　５月２９日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２２年　５月２９日");
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg(null);
        khKykNaiyouOsiraseBean.setIrTk4msg(null);
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("3，519，785 円");
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr("2，637，396 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("1，297，395 円");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("登録家族名１　様");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("登録家族名２　様");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("2");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("4，854，325 円");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　５月３０日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０２０年　５月２９日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２２年　５月２９日");
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("3，519，785 円");
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr("2，637，396 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("1，297，395 円");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("4，854，325 円");


        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　５月３０日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０２０年　５月２９日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２２年　５月２９日");
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("3，519，785 円");
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr("0 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("1，297，395 円");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("4，854，325 円");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　５月３０日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０２０年　５月２９日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２２年　５月２９日");
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("3，519，785 円");
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr("2，637，396 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("0 円");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("登録家族名１　様");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("4，854，325 円");


        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　５月３０日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０２０年　５月２９日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２２年　５月２９日");
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("3，519，785 円");
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr("0 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("0 円");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("登録家族名１　様");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("登録家族名２　様");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("4，854，325 円");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　５月３０日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０２０年　５月２９日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２２年　５月２９日");
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrTk5msg("");
        khKykNaiyouOsiraseBean.setIrTk6msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("3，519，785 円");
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr("2，637，396 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("1，297，395 円");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("登録家族名１　様");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("登録家族名２　様");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("4，854，325 円");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　５月３０日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０２０年　５月２９日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２２年　５月２９日");
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("3，519，785 円");
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr("2，637，396 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("1，297，395 円");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("登録家族名１　様");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("登録家族名２　様");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("4，854，325 円");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrYendthnkymd("");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("");
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrTk5msg("特約５メッセージ");
        khKykNaiyouOsiraseBean.setIrTk6msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("");
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr("");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("");
        khKykNaiyouOsiraseBean.setIrSakuseisya("");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrYendthnkymd(null);
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom(null);
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg(null);
        khKykNaiyouOsiraseBean.setIrTk3msg(null);
        khKykNaiyouOsiraseBean.setIrTk4msg(null);
        khKykNaiyouOsiraseBean.setIrTk5msg("特約５メッセージ");
        khKykNaiyouOsiraseBean.setIrTk6msg(null);
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk(null);
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(null);
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr(null);
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2(null);
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku(null);
        khKykNaiyouOsiraseBean.setIrSakuseisya(null);
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk(null);
        khKykNaiyouOsiraseBean.setIrTrkkzknm1(null);
        khKykNaiyouOsiraseBean.setIrTrkkzknm2(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen(null);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　５月３０日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０２０年　５月２９日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２２年　５月２９日");
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrTk5msg("特約５メッセージ");
        khKykNaiyouOsiraseBean.setIrTk6msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("3，519，785 円");
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr("2，637，396 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("1，297，395 円");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("代理店事務サ−ビス室");
        khKykNaiyouOsiraseBean.setIrSakuseisya("５９０保総合業務０１");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("登録家族名１　様");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("登録家族名２　様");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("4，854，325 円");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrKykymd("９９９９年１２月３１日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("９９９９年１２月３１日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("９９９９年１２月３１日");
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk4msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk5msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk6msg("");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisya("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("9，999，999，999 円");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testCreateReport21() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrYendthnkymd("");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("");
        khKykNaiyouOsiraseBean.setIrTk1msg("");
        khKykNaiyouOsiraseBean.setIrTk2msg("");
        khKykNaiyouOsiraseBean.setIrTk3msg("");
        khKykNaiyouOsiraseBean.setIrTk4msg("");
        khKykNaiyouOsiraseBean.setIrTk5msg("");
        khKykNaiyouOsiraseBean.setIrTk6msg("特約６メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("");
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr("");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("");
        khKykNaiyouOsiraseBean.setIrSakuseisya("");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testCreateReport22() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrYendthnkymd(null);
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom(null);
        khKykNaiyouOsiraseBean.setIrTk1msg(null);
        khKykNaiyouOsiraseBean.setIrTk2msg(null);
        khKykNaiyouOsiraseBean.setIrTk3msg(null);
        khKykNaiyouOsiraseBean.setIrTk4msg(null);
        khKykNaiyouOsiraseBean.setIrTk5msg(null);
        khKykNaiyouOsiraseBean.setIrTk6msg("特約６メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk(null);
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk(null);
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(null);
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr(null);
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1(null);
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2(null);
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku(null);
        khKykNaiyouOsiraseBean.setIrSakuseisya(null);
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk(null);
        khKykNaiyouOsiraseBean.setIrTrkkzknm1(null);
        khKykNaiyouOsiraseBean.setIrTrkkzknm2(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn(null);
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen(null);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testCreateReport23() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrKykymd("２０１９年　５月３０日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("２０２０年　５月２９日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("２０２２年　５月２９日");
        khKykNaiyouOsiraseBean.setIrTk1msg("特約１メッセージ");
        khKykNaiyouOsiraseBean.setIrTk2msg("特約２メッセージ");
        khKykNaiyouOsiraseBean.setIrTk3msg("特約３メッセージ");
        khKykNaiyouOsiraseBean.setIrTk4msg("特約４メッセージ");
        khKykNaiyouOsiraseBean.setIrTk5msg("特約５メッセージ");
        khKykNaiyouOsiraseBean.setIrTk6msg("特約６メッセージ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("お申し込みいただいておりません");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("未登録");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("3，519，785 円");
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr("2，637，396 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("1，297，395 円");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ダイリテン５１００００１株式会社");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ダイリテン５１００００２株式会社");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku(null);
        khKykNaiyouOsiraseBean.setIrSakuseisya(null);
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("登録済");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("登録家族名１　様");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("登録家族名２　様");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("4，854，325 円");
        khKykNaiyouOsiraseBean.setIrYobidasimotoKbn(2);

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testCreateReport24() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKyknaiyouOsirase4", C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4);

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
        khKykNaiyouOsiraseBean.setIrKykymd("９９９９年１２月３１日");
        khKykNaiyouOsiraseBean.setIrYendthnkymd("９９９９年１２月３１日");
        khKykNaiyouOsiraseBean.setIrDai2hknkknfrom("９９９９年１２月３１日");
        khKykNaiyouOsiraseBean.setIrTk1msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk2msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk3msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk4msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk5msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTk6msg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk("ＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen("9，999，999，999 円");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisyozoku("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSakuseisya("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTrkkzknm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrTrkkzknm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn("1");
        khKykNaiyouOsiraseBean.setIrSbhknkngkyen("9，999，999，999 円");

        reportTestBean.addParamObjects(khKykNaiyouOsiraseBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
