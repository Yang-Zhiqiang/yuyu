package yuyu.report.biz;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzSkHonsyaDenpyouListBean;
import yuyu.def.biz.bean.report.BzSkHonsyaDenpyouListDataSourceBean;
import yuyu.def.classification.C_SkDenlistsksKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
/**
 * 新契約本社用伝票リスト 帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzSkhonsyadenpyoulistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzSkHonsyaDenpyouListBean bzSkHonsyaDenpyouListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_SKHONSYADENPYOULIST);

        bzSkHonsyaDenpyouListBean.setIrSyoriymd(null);
        bzSkHonsyaDenpyouListBean.setIrSuitouym(null);
        bzSkHonsyaDenpyouListBean.setIrDenlistskskbn(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSkHonsyaDenpyouListDataSourceBean bzSkHonsyaDenpyouListDataSourceBean = new BzSkHonsyaDenpyouListDataSourceBean();

        bzSkHonsyaDenpyouListDataSourceBean.setIrKanjyoukmkcdkari(null);
        bzSkHonsyaDenpyouListDataSourceBean.setIrKarikanjyoukmknm(null);
        bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoucdkari(null);
        bzSkHonsyaDenpyouListDataSourceBean.setIrDengkkari(null);
        bzSkHonsyaDenpyouListDataSourceBean.setIrKensuukari(null);
        bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoukari(null);
        bzSkHonsyaDenpyouListDataSourceBean.setIrKanjyoukmkcdkasi(null);
        bzSkHonsyaDenpyouListDataSourceBean.setIrKasikanjyoukmknm(null);
        bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoucdkasi(null);
        bzSkHonsyaDenpyouListDataSourceBean.setIrDengkkasi(null);
        bzSkHonsyaDenpyouListDataSourceBean.setIrKensuukasi(null);
        bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoukasi(null);

        dataSouceList.add(bzSkHonsyaDenpyouListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzSkHonsyaDenpyouListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_SKHONSYADENPYOULIST);

        bzSkHonsyaDenpyouListBean.setIrSyoriymd("");
        bzSkHonsyaDenpyouListBean.setIrSuitouym("");
        bzSkHonsyaDenpyouListBean.setIrDenlistskskbn(C_SkDenlistsksKbn.BLNK);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSkHonsyaDenpyouListDataSourceBean bzSkHonsyaDenpyouListDataSourceBean = new BzSkHonsyaDenpyouListDataSourceBean();

        bzSkHonsyaDenpyouListDataSourceBean.setIrKanjyoukmkcdkari("");
        bzSkHonsyaDenpyouListDataSourceBean.setIrKarikanjyoukmknm("");
        bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoucdkari("");
        bzSkHonsyaDenpyouListDataSourceBean.setIrDengkkari(BizCurrency.valueOf(0));
        bzSkHonsyaDenpyouListDataSourceBean.setIrKensuukari(BizNumber.valueOf(0));
        bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoukari("");
        bzSkHonsyaDenpyouListDataSourceBean.setIrKanjyoukmkcdkasi("");
        bzSkHonsyaDenpyouListDataSourceBean.setIrKasikanjyoukmknm("");
        bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoucdkasi("");
        bzSkHonsyaDenpyouListDataSourceBean.setIrDengkkasi(BizCurrency.valueOf(0));
        bzSkHonsyaDenpyouListDataSourceBean.setIrKensuukasi(BizNumber.valueOf(0));
        bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoukasi("");

        dataSouceList.add(bzSkHonsyaDenpyouListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzSkHonsyaDenpyouListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_SKHONSYADENPYOULIST);

        bzSkHonsyaDenpyouListBean.setIrSyoriymd("平成21年12月30日");
        bzSkHonsyaDenpyouListBean.setIrSuitouym("平成21年11月");
        bzSkHonsyaDenpyouListBean.setIrDenlistskskbn(C_SkDenlistsksKbn.GETUMATUSIME);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSkHonsyaDenpyouListDataSourceBean bzSkHonsyaDenpyouListDataSourceBean = new BzSkHonsyaDenpyouListDataSourceBean();

        bzSkHonsyaDenpyouListDataSourceBean.setIrKanjyoukmkcdkari("27352");
        bzSkHonsyaDenpyouListDataSourceBean.setIrKarikanjyoukmknm("保険契約借受金（普保）");
        bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoucdkari("1234567");
        bzSkHonsyaDenpyouListDataSourceBean.setIrDengkkari(BizCurrency.valueOf(999));
        bzSkHonsyaDenpyouListDataSourceBean.setIrKensuukari(BizNumber.valueOf(999));
        bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoukari("摘要（借方）");
        bzSkHonsyaDenpyouListDataSourceBean.setIrKanjyoukmkcdkasi("60101");
        bzSkHonsyaDenpyouListDataSourceBean.setIrKasikanjyoukmknm("初年度初回保険料（普通）");
        bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoucdkasi("7654321");
        bzSkHonsyaDenpyouListDataSourceBean.setIrDengkkasi(BizCurrency.valueOf(999));
        bzSkHonsyaDenpyouListDataSourceBean.setIrKensuukasi(BizNumber.valueOf(999));
        bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoukasi("摘要（貸方）");

        dataSouceList.add(bzSkHonsyaDenpyouListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzSkHonsyaDenpyouListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_SKHONSYADENPYOULIST);

        bzSkHonsyaDenpyouListBean.setIrSyoriymd("ＷＷ99年99月99日");
        bzSkHonsyaDenpyouListBean.setIrSuitouym("ＷＷ99年99月");
        bzSkHonsyaDenpyouListBean.setIrDenlistskskbn(C_SkDenlistsksKbn.DENPYOUSIME);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSkHonsyaDenpyouListDataSourceBean bzSkHonsyaDenpyouListDataSourceBean = new BzSkHonsyaDenpyouListDataSourceBean();

        bzSkHonsyaDenpyouListDataSourceBean.setIrKanjyoukmkcdkari("wwwww");
        bzSkHonsyaDenpyouListDataSourceBean.setIrKarikanjyoukmknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoucdkari("wwwwwww");
        bzSkHonsyaDenpyouListDataSourceBean.setIrDengkkari(BizCurrency.valueOf(9999999999L));
        bzSkHonsyaDenpyouListDataSourceBean.setIrKensuukari(BizNumber.valueOf(99999));
        bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoukari("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSkHonsyaDenpyouListDataSourceBean.setIrKanjyoukmkcdkasi("wwwww");
        bzSkHonsyaDenpyouListDataSourceBean.setIrKasikanjyoukmknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoucdkasi("wwwwwww");
        bzSkHonsyaDenpyouListDataSourceBean.setIrDengkkasi(BizCurrency.valueOf(9999999999L));
        bzSkHonsyaDenpyouListDataSourceBean.setIrKensuukasi(BizNumber.valueOf(99999));
        bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoukasi("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        dataSouceList.add(bzSkHonsyaDenpyouListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzSkHonsyaDenpyouListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_SKHONSYADENPYOULIST);

        bzSkHonsyaDenpyouListBean.setIrSyoriymd("ＷＷ99年99月99日");
        bzSkHonsyaDenpyouListBean.setIrSuitouym("ＷＷ99年99月");
        bzSkHonsyaDenpyouListBean.setIrDenlistskskbn(C_SkDenlistsksKbn.DENPYOUSIME);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 9990; i++) {
            BzSkHonsyaDenpyouListDataSourceBean bzSkHonsyaDenpyouListDataSourceBean = new BzSkHonsyaDenpyouListDataSourceBean();

            bzSkHonsyaDenpyouListDataSourceBean.setIrKanjyoukmkcdkari("wwwww");
            bzSkHonsyaDenpyouListDataSourceBean.setIrKarikanjyoukmknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoucdkari("wwwwwww");
            bzSkHonsyaDenpyouListDataSourceBean.setIrDengkkari(BizCurrency.valueOf(9999));
            bzSkHonsyaDenpyouListDataSourceBean.setIrKensuukari(BizNumber.valueOf(9999));
            bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoukari("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzSkHonsyaDenpyouListDataSourceBean.setIrKanjyoukmkcdkasi("wwwww");
            bzSkHonsyaDenpyouListDataSourceBean.setIrKasikanjyoukmknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoucdkasi("wwwwwww");
            bzSkHonsyaDenpyouListDataSourceBean.setIrDengkkasi(BizCurrency.valueOf(9999));
            bzSkHonsyaDenpyouListDataSourceBean.setIrKensuukasi(BizNumber.valueOf(9999));
            bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoukasi("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            dataSouceList.add(bzSkHonsyaDenpyouListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzSkHonsyaDenpyouListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_SKHONSYADENPYOULIST);

        bzSkHonsyaDenpyouListBean.setIrSyoriymd("平成21年12月30日");
        bzSkHonsyaDenpyouListBean.setIrSuitouym("平成21年11月");
        bzSkHonsyaDenpyouListBean.setIrDenlistskskbn(C_SkDenlistsksKbn.GETUMATUSIME);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i < 10; i++) {
            BzSkHonsyaDenpyouListDataSourceBean bzSkHonsyaDenpyouListDataSourceBean = new BzSkHonsyaDenpyouListDataSourceBean();

            bzSkHonsyaDenpyouListDataSourceBean.setIrKanjyoukmkcdkari("27352");
            bzSkHonsyaDenpyouListDataSourceBean.setIrKarikanjyoukmknm("保険契約借受金（普保）");
            bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoucdkari("1234567");
            bzSkHonsyaDenpyouListDataSourceBean.setIrDengkkari(BizCurrency.valueOf(i));
            bzSkHonsyaDenpyouListDataSourceBean.setIrKensuukari(BizNumber.valueOf(i));
            bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoukari("保険契約借受金");
            bzSkHonsyaDenpyouListDataSourceBean.setIrKanjyoukmkcdkasi("60101");
            bzSkHonsyaDenpyouListDataSourceBean.setIrKasikanjyoukmknm("初年度初回保険料（普通）");
            bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoucdkasi("7654321");
            bzSkHonsyaDenpyouListDataSourceBean.setIrDengkkasi(BizCurrency.valueOf(i));
            bzSkHonsyaDenpyouListDataSourceBean.setIrKensuukasi(BizNumber.valueOf(i));
            bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoukasi("初年度初回保険料");

            dataSouceList.add(bzSkHonsyaDenpyouListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzSkHonsyaDenpyouListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_SKHONSYADENPYOULIST);

        bzSkHonsyaDenpyouListBean.setIrSyoriymd("平成21年12月30日");
        bzSkHonsyaDenpyouListBean.setIrSuitouym("平成21年11月");
        bzSkHonsyaDenpyouListBean.setIrDenlistskskbn(C_SkDenlistsksKbn.GETUMATUSIME);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i < 11; i++) {
            BzSkHonsyaDenpyouListDataSourceBean bzSkHonsyaDenpyouListDataSourceBean = new BzSkHonsyaDenpyouListDataSourceBean();

            bzSkHonsyaDenpyouListDataSourceBean.setIrKanjyoukmkcdkari("27352");
            bzSkHonsyaDenpyouListDataSourceBean.setIrKarikanjyoukmknm("保険契約借受金（普保）");
            bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoucdkari("1234567");
            bzSkHonsyaDenpyouListDataSourceBean.setIrDengkkari(BizCurrency.valueOf(i));
            bzSkHonsyaDenpyouListDataSourceBean.setIrKensuukari(BizNumber.valueOf(i));
            bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoukari("保険契約借受金");
            bzSkHonsyaDenpyouListDataSourceBean.setIrKanjyoukmkcdkasi("60101");
            bzSkHonsyaDenpyouListDataSourceBean.setIrKasikanjyoukmknm("初年度初回保険料（普通）");
            bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoucdkasi("7654321");
            bzSkHonsyaDenpyouListDataSourceBean.setIrDengkkasi(BizCurrency.valueOf(i));
            bzSkHonsyaDenpyouListDataSourceBean.setIrKensuukasi(BizNumber.valueOf(i));
            bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoukasi("初年度初回保険料");

            dataSouceList.add(bzSkHonsyaDenpyouListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzSkHonsyaDenpyouListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_SKHONSYADENPYOULIST);

        bzSkHonsyaDenpyouListBean.setIrSyoriymd("平成21年12月30日");
        bzSkHonsyaDenpyouListBean.setIrSuitouym("平成21年11月");
        bzSkHonsyaDenpyouListBean.setIrDenlistskskbn(C_SkDenlistsksKbn.GETUMATUSIME);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i < 12; i++) {
            BzSkHonsyaDenpyouListDataSourceBean bzSkHonsyaDenpyouListDataSourceBean = new BzSkHonsyaDenpyouListDataSourceBean();

            bzSkHonsyaDenpyouListDataSourceBean.setIrKanjyoukmkcdkari("27352");
            bzSkHonsyaDenpyouListDataSourceBean.setIrKarikanjyoukmknm("保険契約借受金（普保）");
            bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoucdkari("1234567");
            bzSkHonsyaDenpyouListDataSourceBean.setIrDengkkari(BizCurrency.valueOf(i));
            bzSkHonsyaDenpyouListDataSourceBean.setIrKensuukari(BizNumber.valueOf(i));
            bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoukari("保険契約借受金");
            bzSkHonsyaDenpyouListDataSourceBean.setIrKanjyoukmkcdkasi("60101");
            bzSkHonsyaDenpyouListDataSourceBean.setIrKasikanjyoukmknm("初年度初回保険料（普通）");
            bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoucdkasi("7654321");
            bzSkHonsyaDenpyouListDataSourceBean.setIrDengkkasi(BizCurrency.valueOf(i));
            bzSkHonsyaDenpyouListDataSourceBean.setIrKensuukasi(BizNumber.valueOf(i));
            bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoukasi("初年度初回保険料");

            dataSouceList.add(bzSkHonsyaDenpyouListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzSkHonsyaDenpyouListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_SKHONSYADENPYOULIST);

        bzSkHonsyaDenpyouListBean.setIrSyoriymd("平成21年12月30日");
        bzSkHonsyaDenpyouListBean.setIrSuitouym("平成21年11月");
        bzSkHonsyaDenpyouListBean.setIrDenlistskskbn(C_SkDenlistsksKbn.GETUMATUSIME);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSkHonsyaDenpyouListDataSourceBean bzSkHonsyaDenpyouListDataSourceBean = new BzSkHonsyaDenpyouListDataSourceBean();

        dataSouceList.add(bzSkHonsyaDenpyouListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzSkHonsyaDenpyouListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSkhonsyadenpyoulistTest", C_SyoruiCdKbn.CM_SKHONSYADENPYOULIST);

        bzSkHonsyaDenpyouListBean.setIrSyoriymd("平成21年12月30日");
        bzSkHonsyaDenpyouListBean.setIrSuitouym("平成21年11月");
        bzSkHonsyaDenpyouListBean.setIrDenlistskskbn(C_SkDenlistsksKbn.GETUMATUSIME);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSkHonsyaDenpyouListDataSourceBean bzSkHonsyaDenpyouListDataSourceBean = new BzSkHonsyaDenpyouListDataSourceBean();

        bzSkHonsyaDenpyouListDataSourceBean.setIrKanjyoukmkcdkari("27352");
        bzSkHonsyaDenpyouListDataSourceBean.setIrKarikanjyoukmknm("保険契約借受金（普保）");
        bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoucdkari("1234567");
        bzSkHonsyaDenpyouListDataSourceBean.setIrDengkkari(BizCurrency.valueOf(419));
        bzSkHonsyaDenpyouListDataSourceBean.setIrKensuukari(BizNumber.valueOf(522));
        bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoukari("摘要（借方）");
        bzSkHonsyaDenpyouListDataSourceBean.setIrKanjyoukmkcdkasi("60101");
        bzSkHonsyaDenpyouListDataSourceBean.setIrKasikanjyoukmknm("初年度初回保険料（普通）");
        bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoucdkasi("7654321");
        bzSkHonsyaDenpyouListDataSourceBean.setIrDengkkasi(BizCurrency.valueOf(687));
        bzSkHonsyaDenpyouListDataSourceBean.setIrKensuukasi(BizNumber.valueOf(354));
        bzSkHonsyaDenpyouListDataSourceBean.setIrTekiyoukasi("摘要（貸方）");

        dataSouceList.add(bzSkHonsyaDenpyouListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzSkHonsyaDenpyouListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
