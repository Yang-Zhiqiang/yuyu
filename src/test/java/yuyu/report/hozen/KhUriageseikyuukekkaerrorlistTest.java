package yuyu.report.hozen;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_AuthoriKbn;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhUriageSeikyuuKekkaErrorListBean;
import yuyu.def.hozen.bean.report.KhUriageSeikyuuKekkaErrorListDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 売上請求結果エラーリストテスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhUriageseikyuukekkaerrorlistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhUriageSeikyuuKekkaErrorListBean khUriageSeikyuuKekkaErrorListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "khUriageSeikyuuKekkaErrorListBean",
                C_SyoruiCdKbn.KK_URIAGEKEKKATRSKS_MISSLIST);

        khUriageSeikyuuKekkaErrorListBean.setIrTantousitunm("");
        khUriageSeikyuuKekkaErrorListBean.setIrSyoribi(null);
        khUriageSeikyuuKekkaErrorListBean.setIrKensuu(null);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhUriageSeikyuuKekkaErrorListDataSourceBean khUriageSeikyuuKekkaErrorListDataSourceBean = null;

        for (int i = 0; i < 1; i++) {

            khUriageSeikyuuKekkaErrorListDataSourceBean = new KhUriageSeikyuuKekkaErrorListDataSourceBean();

            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrSyono("");
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCreditkessaiyouno("");
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrUriageymd(null);
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCredituriagegk(null);
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCredituriagengjiyuu(null);
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrErrorcd("");
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrAuthorikbn(null);
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrKinounm("");
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCredituriageseikyuukbn(null);

            iReportDataSouceBean.add(khUriageSeikyuuKekkaErrorListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khUriageSeikyuuKekkaErrorListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "khUriageSeikyuuKekkaErrorListBean",
                C_SyoruiCdKbn.KK_URIAGEKEKKATRSKS_MISSLIST);

        khUriageSeikyuuKekkaErrorListBean.setIrTantousitunm(null);
        khUriageSeikyuuKekkaErrorListBean.setIrSyoribi(null);
        khUriageSeikyuuKekkaErrorListBean.setIrKensuu(null);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhUriageSeikyuuKekkaErrorListDataSourceBean khUriageSeikyuuKekkaErrorListDataSourceBean = null;

        for (int i = 0; i < 1; i++) {

            khUriageSeikyuuKekkaErrorListDataSourceBean = new KhUriageSeikyuuKekkaErrorListDataSourceBean();

            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrSyono(null);
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCreditkessaiyouno(null);
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrUriageymd(null);
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCredituriagegk(null);
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCredituriagengjiyuu(null);
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrErrorcd(null);
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrAuthorikbn(null);
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrKinounm(null);
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCredituriageseikyuukbn(null);

            iReportDataSouceBean.add(khUriageSeikyuuKekkaErrorListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khUriageSeikyuuKekkaErrorListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "khUriageSeikyuuKekkaErrorListBean",
                C_SyoruiCdKbn.KK_URIAGEKEKKATRSKS_MISSLIST);

        khUriageSeikyuuKekkaErrorListBean.setIrTantousitunm("担当室００１０００１担当室００１０００１");
        khUriageSeikyuuKekkaErrorListBean.setIrSyoribi(BizDate.valueOf("20020220"));
        khUriageSeikyuuKekkaErrorListBean.setIrKensuu(15);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhUriageSeikyuuKekkaErrorListDataSourceBean khUriageSeikyuuKekkaErrorListDataSourceBean = null;

        for (int i = 0; i < 15; i++) {

            khUriageSeikyuuKekkaErrorListDataSourceBean = new KhUriageSeikyuuKekkaErrorListDataSourceBean();

            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrSyono("86001230223");
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCreditkessaiyouno("75236418975412896342689517");
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrUriageymd(BizDate.valueOf("20130123"));
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCredituriagegk(BizCurrency.valueOf(1867534210));
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.YUUKOUKIGENERROR);
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrErrorcd("k04");
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrAuthorikbn(C_AuthoriKbn.AUTHORIJISSI);
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrKinounm("売上請求結果エラー");
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCredituriageseikyuukbn(C_CreditUriageSeikyuuKbn.RINJI);

            iReportDataSouceBean.add(khUriageSeikyuuKekkaErrorListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khUriageSeikyuuKekkaErrorListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "khUriageSeikyuuKekkaErrorListBean",
                C_SyoruiCdKbn.KK_URIAGEKEKKATRSKS_MISSLIST);

        khUriageSeikyuuKekkaErrorListBean.setIrTantousitunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khUriageSeikyuuKekkaErrorListBean.setIrSyoribi(BizDate.valueOf("99991231"));
        khUriageSeikyuuKekkaErrorListBean.setIrKensuu(999999999);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhUriageSeikyuuKekkaErrorListDataSourceBean khUriageSeikyuuKekkaErrorListDataSourceBean = null;

        for (int i = 0; i < 16; i++) {

            khUriageSeikyuuKekkaErrorListDataSourceBean = new KhUriageSeikyuuKekkaErrorListDataSourceBean();

            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrSyono("wwwwwwwwwww");
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrUriageymd(BizDate.valueOf("99991231"));
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCredituriagegk(BizCurrency.valueOf(9999999999999l));
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.CARDGAISYAERROR);
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrErrorcd("www");
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrAuthorikbn(C_AuthoriKbn.MOSNAINISITAGAU);
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrKinounm("ＷＷＷＷＷＷＷＷＷ");
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCredituriageseikyuukbn(C_CreditUriageSeikyuuKbn.MINUS);

            iReportDataSouceBean.add(khUriageSeikyuuKekkaErrorListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khUriageSeikyuuKekkaErrorListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "khUriageSeikyuuKekkaErrorListBean",
                C_SyoruiCdKbn.KK_URIAGEKEKKATRSKS_MISSLIST);

        khUriageSeikyuuKekkaErrorListBean.setIrTantousitunm("担当室００１０００１担当室００１０００１");
        khUriageSeikyuuKekkaErrorListBean.setIrSyoribi(BizDate.valueOf("20020220"));
        khUriageSeikyuuKekkaErrorListBean.setIrKensuu(17);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhUriageSeikyuuKekkaErrorListDataSourceBean khUriageSeikyuuKekkaErrorListDataSourceBean = null;

        for (int i = 0; i < 17; i++) {

            khUriageSeikyuuKekkaErrorListDataSourceBean = new KhUriageSeikyuuKekkaErrorListDataSourceBean();

            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrSyono("86001230223");
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCreditkessaiyouno("75236418975412896342689517");
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrUriageymd(BizDate.valueOf("20130123"));
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCredituriagegk(BizCurrency.valueOf(123));
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.KINKYUUTEISI);
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrErrorcd("k04");
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrAuthorikbn(C_AuthoriKbn.MOSNAINISITAGAU);
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrKinounm("仮受訂正");
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCredituriageseikyuukbn(C_CreditUriageSeikyuuKbn.MINUS);

            iReportDataSouceBean.add(khUriageSeikyuuKekkaErrorListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khUriageSeikyuuKekkaErrorListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "khUriageSeikyuuKekkaErrorListBean",
                C_SyoruiCdKbn.KK_URIAGEKEKKATRSKS_MISSLIST);

        khUriageSeikyuuKekkaErrorListBean.setIrTantousitunm("担当室００１０００１担当室００１０００１");
        khUriageSeikyuuKekkaErrorListBean.setIrSyoribi(BizDate.valueOf("20020220"));
        khUriageSeikyuuKekkaErrorListBean.setIrKensuu(15984);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhUriageSeikyuuKekkaErrorListDataSourceBean khUriageSeikyuuKekkaErrorListDataSourceBean = null;

        for (int i = 0; i < 15984; i++) {

            khUriageSeikyuuKekkaErrorListDataSourceBean = new KhUriageSeikyuuKekkaErrorListDataSourceBean();

            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrSyono("86001230223");
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCreditkessaiyouno("75236418975412896342689517");
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrUriageymd(BizDate.valueOf("20130123"));
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCredituriagegk(BizCurrency.valueOf(1867534210));
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn.YUUKOUKIGENERROR);
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrErrorcd("k04");
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrAuthorikbn(C_AuthoriKbn.MOSNAINISITAGAU);
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrKinounm("仮受訂正");
            khUriageSeikyuuKekkaErrorListDataSourceBean.setIrCredituriageseikyuukbn(C_CreditUriageSeikyuuKbn.MINUS);

            iReportDataSouceBean.add(khUriageSeikyuuKekkaErrorListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khUriageSeikyuuKekkaErrorListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "khUriageSeikyuuKekkaErrorListBean",
                C_SyoruiCdKbn.KK_URIAGEKEKKATRSKS_MISSLIST);

        khUriageSeikyuuKekkaErrorListBean.setIrTantousitunm("担当室００１０００１担当室００１０００１");
        khUriageSeikyuuKekkaErrorListBean.setIrSyoribi(BizDate.valueOf("20020220"));
        khUriageSeikyuuKekkaErrorListBean.setIrKensuu(0);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(iReportDataSouceBean, khUriageSeikyuuKekkaErrorListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }
}
