package yuyu.report.hozen;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhMinusUriageKykDtlListBean;
import yuyu.def.hozen.bean.report.KhMinusUriageKykDtlListDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * マイナス売上契約明細リストテスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhMinusuriagekykdtllistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhMinusUriageKykDtlListBean khMinusUriageKykDtlListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khansyuu", "khminusuriagekykdtllistsks",
                C_SyoruiCdKbn.AS_MINUSURIAGEKYKDTLLIST);

        khMinusUriageKykDtlListBean.setIrTantousitunm("");
        khMinusUriageKykDtlListBean.setIrSyoribi(null);
        khMinusUriageKykDtlListBean.setIrKensuu(null);
        khMinusUriageKykDtlListBean.setIrGoukeikingk(null);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhMinusUriageKykDtlListDataSourceBean khMinusUriageKykDtlListDataSourceBean = null;

        for (int i = 0; i < 1; i++) {

            khMinusUriageKykDtlListDataSourceBean = new KhMinusUriageKykDtlListDataSourceBean();

            khMinusUriageKykDtlListDataSourceBean.setIrSyono("");
            khMinusUriageKykDtlListDataSourceBean.setIrUriageymd(null);
            khMinusUriageKykDtlListDataSourceBean.setIrCreditkessaiyouno("");
            khMinusUriageKykDtlListDataSourceBean.setIrJyuutouym(null);
            khMinusUriageKykDtlListDataSourceBean.setIrCredituriagegk(null);
            khMinusUriageKykDtlListDataSourceBean.setIrKinounm("");

            iReportDataSouceBean.add(khMinusUriageKykDtlListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khMinusUriageKykDtlListBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khansyuu", "khminusuriagekykdtllistsks",
                C_SyoruiCdKbn.AS_MINUSURIAGEKYKDTLLIST);

        khMinusUriageKykDtlListBean.setIrTantousitunm(null);
        khMinusUriageKykDtlListBean.setIrSyoribi(null);
        khMinusUriageKykDtlListBean.setIrKensuu(null);
        khMinusUriageKykDtlListBean.setIrGoukeikingk(null);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhMinusUriageKykDtlListDataSourceBean khMinusUriageKykDtlListDataSourceBean = null;

        for (int i = 0; i < 1; i++) {

            khMinusUriageKykDtlListDataSourceBean = new KhMinusUriageKykDtlListDataSourceBean();

            khMinusUriageKykDtlListDataSourceBean.setIrSyono(null);
            khMinusUriageKykDtlListDataSourceBean.setIrUriageymd(null);
            khMinusUriageKykDtlListDataSourceBean.setIrCreditkessaiyouno(null);
            khMinusUriageKykDtlListDataSourceBean.setIrJyuutouym(null);
            khMinusUriageKykDtlListDataSourceBean.setIrCredituriagegk(null);
            khMinusUriageKykDtlListDataSourceBean.setIrKinounm(null);

            iReportDataSouceBean.add(khMinusUriageKykDtlListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khMinusUriageKykDtlListBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khansyuu", "khminusuriagekykdtllistsks",
                C_SyoruiCdKbn.AS_MINUSURIAGEKYKDTLLIST);

        khMinusUriageKykDtlListBean.setIrTantousitunm("個別収納サービス室");
        khMinusUriageKykDtlListBean.setIrSyoribi(BizDate.valueOf("20200923"));
        khMinusUriageKykDtlListBean.setIrKensuu(14);
        khMinusUriageKykDtlListBean.setIrGoukeikingk(BizCurrency.valueOf(12340000));

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhMinusUriageKykDtlListDataSourceBean khMinusUriageKykDtlListDataSourceBean = null;

        for (int i = 0; i < 14; i++) {

            khMinusUriageKykDtlListDataSourceBean = new KhMinusUriageKykDtlListDataSourceBean();

            khMinusUriageKykDtlListDataSourceBean.setIrSyono("86001230223");
            khMinusUriageKykDtlListDataSourceBean.setIrUriageymd(BizDate.valueOf("20200917"));
            khMinusUriageKykDtlListDataSourceBean.setIrCreditkessaiyouno("32009912345678901234567890");
            khMinusUriageKykDtlListDataSourceBean.setIrJyuutouym(BizDateYM.valueOf("202009"));
            khMinusUriageKykDtlListDataSourceBean.setIrCredituriagegk(BizCurrency.valueOf(80000));
            khMinusUriageKykDtlListDataSourceBean.setIrKinounm("仮受訂正");

            iReportDataSouceBean.add(khMinusUriageKykDtlListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khMinusUriageKykDtlListBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khansyuu", "khminusuriagekykdtllistsks",
                C_SyoruiCdKbn.AS_MINUSURIAGEKYKDTLLIST);

        khMinusUriageKykDtlListBean.setIrTantousitunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khMinusUriageKykDtlListBean.setIrSyoribi(BizDate.valueOf("99991231"));
        khMinusUriageKykDtlListBean.setIrKensuu(999999999);
        khMinusUriageKykDtlListBean.setIrGoukeikingk(BizCurrency.valueOf(9999999999999l));

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhMinusUriageKykDtlListDataSourceBean khMinusUriageKykDtlListDataSourceBean = null;

        for (int i = 0; i < 15; i++) {

            khMinusUriageKykDtlListDataSourceBean = new KhMinusUriageKykDtlListDataSourceBean();

            khMinusUriageKykDtlListDataSourceBean.setIrSyono("wwwwwwwwwww");
            khMinusUriageKykDtlListDataSourceBean.setIrUriageymd(BizDate.valueOf("99991231"));
            khMinusUriageKykDtlListDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
            khMinusUriageKykDtlListDataSourceBean.setIrJyuutouym(BizDateYM.valueOf("999912"));
            khMinusUriageKykDtlListDataSourceBean.setIrCredituriagegk(BizCurrency.valueOf(9999999999999l));
            khMinusUriageKykDtlListDataSourceBean.setIrKinounm("ＷＷＷＷＷＷＷＷＷ");

            iReportDataSouceBean.add(khMinusUriageKykDtlListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khMinusUriageKykDtlListBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khansyuu", "khminusuriagekykdtllistsks",
                C_SyoruiCdKbn.AS_MINUSURIAGEKYKDTLLIST);

        khMinusUriageKykDtlListBean.setIrTantousitunm("個別収納サービス室");
        khMinusUriageKykDtlListBean.setIrSyoribi(BizDate.valueOf("20200923"));
        khMinusUriageKykDtlListBean.setIrKensuu(16);
        khMinusUriageKykDtlListBean.setIrGoukeikingk(BizCurrency.valueOf(456));

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhMinusUriageKykDtlListDataSourceBean khMinusUriageKykDtlListDataSourceBean = null;

        for (int i = 0; i < 16; i++) {

            khMinusUriageKykDtlListDataSourceBean = new KhMinusUriageKykDtlListDataSourceBean();

            khMinusUriageKykDtlListDataSourceBean.setIrSyono("86001230223");
            khMinusUriageKykDtlListDataSourceBean.setIrUriageymd(BizDate.valueOf("20200917"));
            khMinusUriageKykDtlListDataSourceBean.setIrCreditkessaiyouno("32009912345678901234567890");
            khMinusUriageKykDtlListDataSourceBean.setIrJyuutouym(BizDateYM.valueOf("202009"));
            khMinusUriageKykDtlListDataSourceBean.setIrCredituriagegk(BizCurrency.valueOf(123));
            khMinusUriageKykDtlListDataSourceBean.setIrKinounm("仮受訂正");

            iReportDataSouceBean.add(khMinusUriageKykDtlListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khMinusUriageKykDtlListBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khansyuu", "khminusuriagekykdtllistsks",
                C_SyoruiCdKbn.AS_MINUSURIAGEKYKDTLLIST);

        khMinusUriageKykDtlListBean.setIrTantousitunm("個別収納サービス室");
        khMinusUriageKykDtlListBean.setIrSyoribi(BizDate.valueOf("20200923"));
        khMinusUriageKykDtlListBean.setIrKensuu(15983);
        khMinusUriageKykDtlListBean.setIrGoukeikingk(BizCurrency.valueOf(12340000));

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhMinusUriageKykDtlListDataSourceBean khMinusUriageKykDtlListDataSourceBean = null;

        for (int i = 0; i < 15983; i++) {

            khMinusUriageKykDtlListDataSourceBean = new KhMinusUriageKykDtlListDataSourceBean();

            khMinusUriageKykDtlListDataSourceBean.setIrSyono("86001230223");
            khMinusUriageKykDtlListDataSourceBean.setIrUriageymd(BizDate.valueOf("20200917"));
            khMinusUriageKykDtlListDataSourceBean.setIrCreditkessaiyouno("32009912345678901234567890");
            khMinusUriageKykDtlListDataSourceBean.setIrJyuutouym(BizDateYM.valueOf("202009"));
            khMinusUriageKykDtlListDataSourceBean.setIrCredituriagegk(BizCurrency.valueOf(80000));
            khMinusUriageKykDtlListDataSourceBean.setIrKinounm("仮受訂正");

            iReportDataSouceBean.add(khMinusUriageKykDtlListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khMinusUriageKykDtlListBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khansyuu", "khminusuriagekykdtllistsks",
                C_SyoruiCdKbn.AS_MINUSURIAGEKYKDTLLIST);

        khMinusUriageKykDtlListBean.setIrTantousitunm("個別収納サービス室");
        khMinusUriageKykDtlListBean.setIrSyoribi(BizDate.valueOf("20200923"));
        khMinusUriageKykDtlListBean.setIrKensuu(0);
        khMinusUriageKykDtlListBean.setIrGoukeikingk(null);


        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(iReportDataSouceBean, khMinusUriageKykDtlListBean);

        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }
}
