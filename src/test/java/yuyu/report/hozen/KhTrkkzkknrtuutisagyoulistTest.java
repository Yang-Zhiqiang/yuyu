package yuyu.report.hozen;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhKanryouTuutiJigoSgyListBean;
import yuyu.def.hozen.bean.report.KhKanryouTuutiJigoSgyListDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 完了通知事後作業リスト 帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhTrkkzkknrtuutisagyoulistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhKanryouTuutiJigoSgyListBean khKanryouTuutiJigoSgyListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTrkkzkknrtuutisagyoulistTest",
                C_SyoruiCdKbn.KK_TRKKZKKNRTUUTISAGYOULIST);

        khKanryouTuutiJigoSgyListBean.setIrTantsitunmkj(null);
        khKanryouTuutiJigoSgyListBean.setIrSyoriymd(null);
        khKanryouTuutiJigoSgyListBean.setIrHozonkkn(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhKanryouTuutiJigoSgyListDataSourceBean khKanryouTuutiJigoSgyListDataSourceBean = new KhKanryouTuutiJigoSgyListDataSourceBean();

        khKanryouTuutiJigoSgyListDataSourceBean.setIrSyono(null);
        khKanryouTuutiJigoSgyListDataSourceBean.setIrShsnmkj(null);
        khKanryouTuutiJigoSgyListDataSourceBean.setIrKyknmkj(null);
        khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou1(null);
        khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou2(null);
        khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou3(null);
        khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou4(null);
        khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou5(null);
        khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou6(null);
        khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou7(null);
        khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou8(null);
        khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyoubikou(null);

        dataSouceList.add(khKanryouTuutiJigoSgyListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khKanryouTuutiJigoSgyListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTrkkzkknrtuutisagyoulistTest",
                C_SyoruiCdKbn.KK_TRKKZKKNRTUUTISAGYOULIST);

        khKanryouTuutiJigoSgyListBean.setIrTantsitunmkj("");
        khKanryouTuutiJigoSgyListBean.setIrSyoriymd("");
        khKanryouTuutiJigoSgyListBean.setIrHozonkkn("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhKanryouTuutiJigoSgyListDataSourceBean khKanryouTuutiJigoSgyListDataSourceBean = new KhKanryouTuutiJigoSgyListDataSourceBean();

        khKanryouTuutiJigoSgyListDataSourceBean.setIrSyono("");
        khKanryouTuutiJigoSgyListDataSourceBean.setIrShsnmkj("");
        khKanryouTuutiJigoSgyListDataSourceBean.setIrKyknmkj("");
        khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou1("");
        khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou2("");
        khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou3("");
        khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou4("");
        khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou5("");
        khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou6("");
        khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou7("");
        khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou8("");
        khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyoubikou("");

        dataSouceList.add(khKanryouTuutiJigoSgyListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khKanryouTuutiJigoSgyListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTrkkzkknrtuutisagyoulistTest",
                C_SyoruiCdKbn.KK_TRKKZKKNRTUUTISAGYOULIST);

        khKanryouTuutiJigoSgyListBean.setIrTantsitunmkj("保全支払サービス室");
        khKanryouTuutiJigoSgyListBean.setIrSyoriymd("2019年 8月 8日");
        khKanryouTuutiJigoSgyListBean.setIrHozonkkn("3年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhKanryouTuutiJigoSgyListDataSourceBean khKanryouTuutiJigoSgyListDataSourceBean = new KhKanryouTuutiJigoSgyListDataSourceBean();

        for (int i = 0; i < 14; i++) {

            khKanryouTuutiJigoSgyListDataSourceBean.setIrSyono("11807111118");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrShsnmkj("送付先氏名");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrKyknmkj("契約者名");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou1("証券＊契約者名漢字１");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou2("証券＊契約者名漢字２");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou3("証券＊契約者名漢字３");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou4("証券＊契約者名漢字４");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou5("証券＊契約者名漢字５");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou6("証券＊契約者名漢字６");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou7("証券＊契約者名漢字７");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou8("本社回送指定あり　※");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyoubikou("事後作業リスト８件以上該当");

            dataSouceList.add(khKanryouTuutiJigoSgyListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khKanryouTuutiJigoSgyListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTrkkzkknrtuutisagyoulistTest",
                C_SyoruiCdKbn.KK_TRKKZKKNRTUUTISAGYOULIST);

        khKanryouTuutiJigoSgyListBean.setIrTantsitunmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKanryouTuutiJigoSgyListBean.setIrSyoriymd("9999年99月99日");
        khKanryouTuutiJigoSgyListBean.setIrHozonkkn("99ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhKanryouTuutiJigoSgyListDataSourceBean khKanryouTuutiJigoSgyListDataSourceBean = new KhKanryouTuutiJigoSgyListDataSourceBean();

        for (int i = 0; i < 15; i++) {

            khKanryouTuutiJigoSgyListDataSourceBean.setIrSyono("wwwwwwwwwww");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou4("ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou5("ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou6("ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou7("ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou8("ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyoubikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            dataSouceList.add(khKanryouTuutiJigoSgyListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khKanryouTuutiJigoSgyListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTrkkzkknrtuutisagyoulistTest",
                C_SyoruiCdKbn.KK_TRKKZKKNRTUUTISAGYOULIST);

        khKanryouTuutiJigoSgyListBean.setIrTantsitunmkj("保全支払サービス室");
        khKanryouTuutiJigoSgyListBean.setIrSyoriymd("2019年 8月 8日");
        khKanryouTuutiJigoSgyListBean.setIrHozonkkn("3年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhKanryouTuutiJigoSgyListDataSourceBean khKanryouTuutiJigoSgyListDataSourceBean = new KhKanryouTuutiJigoSgyListDataSourceBean();

        for (int i = 0; i < 14985; i++) {

            khKanryouTuutiJigoSgyListDataSourceBean.setIrSyono("11807111118");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrShsnmkj("送付先氏名");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrKyknmkj("契約者名");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou1("証券＊契約者名漢字１");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou2("証券＊契約者名漢字２");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou3("証券＊契約者名漢字３");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou4("証券＊契約者名漢字４");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou5("証券＊契約者名漢字５");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou6("証券＊契約者名漢字６");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou7("証券＊契約者名漢字７");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou8("本社回送指定あり　※");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyoubikou("事後作業リスト８件以上該当");

            dataSouceList.add(khKanryouTuutiJigoSgyListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khKanryouTuutiJigoSgyListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTrkkzkknrtuutisagyoulistTest",
                C_SyoruiCdKbn.KK_TRKKZKKNRTUUTISAGYOULIST);

        khKanryouTuutiJigoSgyListBean.setIrTantsitunmkj("保全支払サービス室");
        khKanryouTuutiJigoSgyListBean.setIrSyoriymd("2019年 8月 8日");
        khKanryouTuutiJigoSgyListBean.setIrHozonkkn("3年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhKanryouTuutiJigoSgyListDataSourceBean khKanryouTuutiJigoSgyListDataSourceBean = new KhKanryouTuutiJigoSgyListDataSourceBean();

        for (int i = 0; i < 16; i++) {

            khKanryouTuutiJigoSgyListDataSourceBean.setIrSyono("11807111118");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrShsnmkj("送付先氏名");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrKyknmkj("契約者名");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou1("証券＊契約者名漢字１");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou2("証券＊契約者名漢字２");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou3("証券＊契約者名漢字３");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou4("証券＊契約者名漢字４");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou5("証券＊契約者名漢字５");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou6("証券＊契約者名漢字６");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou7("証券＊契約者名漢字７");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou8("本社回送指定あり　※");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyoubikou("事後作業リスト８件以上該当");

            dataSouceList.add(khKanryouTuutiJigoSgyListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khKanryouTuutiJigoSgyListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTrkkzkknrtuutisagyoulistTest",
                C_SyoruiCdKbn.KK_TRKKZKKNRTUUTISAGYOULIST);

        khKanryouTuutiJigoSgyListBean.setIrTantsitunmkj("保全支払サービス室");
        khKanryouTuutiJigoSgyListBean.setIrSyoriymd("2019年 8月 8日");
        khKanryouTuutiJigoSgyListBean.setIrHozonkkn("3年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, khKanryouTuutiJigoSgyListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhTrkkzkknrtuutisagyoulistTest",
                C_SyoruiCdKbn.KK_TRKKZKKNRTUUTISAGYOULIST);

        khKanryouTuutiJigoSgyListBean.setIrTantsitunmkj("保全支払サービス室");
        khKanryouTuutiJigoSgyListBean.setIrSyoriymd("2019年 8月 8日");
        khKanryouTuutiJigoSgyListBean.setIrHozonkkn("3年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhKanryouTuutiJigoSgyListDataSourceBean khKanryouTuutiJigoSgyListDataSourceBean = new KhKanryouTuutiJigoSgyListDataSourceBean();

        for (int i = 0; i < 999; i++) {

            khKanryouTuutiJigoSgyListDataSourceBean.setIrSyono("11807111118");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrShsnmkj("送付先氏名");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrKyknmkj("契約者名");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou1("証券＊契約者名漢字１");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou2("証券＊契約者名漢字２");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou3("証券＊契約者名漢字３");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou4("証券＊契約者名漢字４");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou5("証券＊契約者名漢字５");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou6("証券＊契約者名漢字６");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou7("証券＊契約者名漢字７");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyou8("");
            khKanryouTuutiJigoSgyListDataSourceBean.setIrJigosagyounaiyoubikou("");

            dataSouceList.add(khKanryouTuutiJigoSgyListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khKanryouTuutiJigoSgyListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


}
