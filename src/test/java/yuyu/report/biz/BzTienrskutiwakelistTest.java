package yuyu.report.biz;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.def.biz.bean.report.BzTienrskutiwakelistBean;
import yuyu.def.biz.bean.report.BzTienrskutiwakelistDataSourceBean;
/**
 * 支払遅延利息内訳リスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzTienrskutiwakelistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzTienrskutiwakelistBean bzTienrskutiwakelistBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzTienrskutiwakelistTest", C_SyoruiCdKbn.CM_TIENRSKUTIWAKELIST);

        bzTienrskutiwakelistBean.setIrSyoribiwareki(null);

        bzTienrskutiwakelistBean.setIrDenym(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzTienrskutiwakelistDataSourceBean bzTienrskutiwakelistDataSourceBean = new BzTienrskutiwakelistDataSourceBean();

        bzTienrskutiwakelistDataSourceBean.setIrHuridenatesakinm(null);
        bzTienrskutiwakelistDataSourceBean.setIrSyorinm(null);
        bzTienrskutiwakelistDataSourceBean.setIrKensuu(null);
        bzTienrskutiwakelistDataSourceBean.setIrKarikatagk(null);
        bzTienrskutiwakelistDataSourceBean.setIrKasikatagk(null);

        dataSouceList.add(bzTienrskutiwakelistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzTienrskutiwakelistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzTienrskutiwakelistTest", C_SyoruiCdKbn.CM_TIENRSKUTIWAKELIST);

        bzTienrskutiwakelistBean.setIrSyoribiwareki("");

        bzTienrskutiwakelistBean.setIrDenym("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzTienrskutiwakelistDataSourceBean bzTienrskutiwakelistDataSourceBean = new BzTienrskutiwakelistDataSourceBean();

        bzTienrskutiwakelistDataSourceBean.setIrHuridenatesakinm("");
        bzTienrskutiwakelistDataSourceBean.setIrSyorinm("");
        bzTienrskutiwakelistDataSourceBean.setIrKensuu(0);
        bzTienrskutiwakelistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(0));
        bzTienrskutiwakelistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(0));

        dataSouceList.add(bzTienrskutiwakelistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzTienrskutiwakelistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzTienrskutiwakelistTest", C_SyoruiCdKbn.CM_TIENRSKUTIWAKELIST);

        bzTienrskutiwakelistBean.setIrSyoribiwareki("平成27年 8月12日");

        bzTienrskutiwakelistBean.setIrDenym("平成２７年７月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 35; i++) {
            BzTienrskutiwakelistDataSourceBean bzTienrskutiwakelistDataSourceBean = new BzTienrskutiwakelistDataSourceBean();

            bzTienrskutiwakelistDataSourceBean.setIrHuridenatesakinm("保全支払サービス室");
            bzTienrskutiwakelistDataSourceBean.setIrSyorinm("処理名処理名処理名");
            bzTienrskutiwakelistDataSourceBean.setIrKensuu(2);
            bzTienrskutiwakelistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(2160));
            bzTienrskutiwakelistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(160));

            dataSouceList.add(bzTienrskutiwakelistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzTienrskutiwakelistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzTienrskutiwakelistTest", C_SyoruiCdKbn.CM_TIENRSKUTIWAKELIST);

        bzTienrskutiwakelistBean.setIrSyoribiwareki("平成27年 8月12日");

        bzTienrskutiwakelistBean.setIrDenym("平成２７年７月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<>();

        reportTestBean.addParamObjects(dataSouceList, bzTienrskutiwakelistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzTienrskutiwakelistTest", C_SyoruiCdKbn.CM_TIENRSKUTIWAKELIST);

        bzTienrskutiwakelistBean.setIrSyoribiwareki("ＷＷ99年99月99日");

        bzTienrskutiwakelistBean.setIrDenym("ＷＷ９９年９９月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzTienrskutiwakelistDataSourceBean bzTienrskutiwakelistDataSourceBean = new BzTienrskutiwakelistDataSourceBean();

        bzTienrskutiwakelistDataSourceBean.setIrHuridenatesakinm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzTienrskutiwakelistDataSourceBean.setIrSyorinm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzTienrskutiwakelistDataSourceBean.setIrKensuu(9999999);
        bzTienrskutiwakelistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(99999999999999L));
        bzTienrskutiwakelistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(99999999999999L));

        dataSouceList.add(bzTienrskutiwakelistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzTienrskutiwakelistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzTienrskutiwakelistTest", C_SyoruiCdKbn.CM_TIENRSKUTIWAKELIST);

        bzTienrskutiwakelistBean.setIrSyoribiwareki("平成27年 8月12日");

        bzTienrskutiwakelistBean.setIrDenym("平成２７年７月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 20; i++) {
            BzTienrskutiwakelistDataSourceBean bzTienrskutiwakelistDataSourceBean = new BzTienrskutiwakelistDataSourceBean();

            bzTienrskutiwakelistDataSourceBean.setIrHuridenatesakinm("保全支払サービス室１");
            bzTienrskutiwakelistDataSourceBean.setIrSyorinm("処理名処理名処理名");
            bzTienrskutiwakelistDataSourceBean.setIrKensuu(2);
            bzTienrskutiwakelistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(2160));
            bzTienrskutiwakelistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(160));


            dataSouceList.add(bzTienrskutiwakelistDataSourceBean);
        }

        for (int i = 0; i <40; i++) {
            BzTienrskutiwakelistDataSourceBean bzTienrskutiwakelistDataSourceBean = new BzTienrskutiwakelistDataSourceBean();

            bzTienrskutiwakelistDataSourceBean.setIrHuridenatesakinm("保全支払サービス室２");
            bzTienrskutiwakelistDataSourceBean.setIrSyorinm("処理名処理名処理名");
            bzTienrskutiwakelistDataSourceBean.setIrKensuu(3);
            bzTienrskutiwakelistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(300));
            bzTienrskutiwakelistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(100));


            dataSouceList.add(bzTienrskutiwakelistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzTienrskutiwakelistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzTienrskutiwakelistTest", C_SyoruiCdKbn.CM_TIENRSKUTIWAKELIST);

        bzTienrskutiwakelistBean.setIrSyoribiwareki("平成27年 8月12日");

        bzTienrskutiwakelistBean.setIrDenym("平成２７年７月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();


        BzTienrskutiwakelistDataSourceBean bzTienrskutiwakelistDataSourceBean = new BzTienrskutiwakelistDataSourceBean();

        bzTienrskutiwakelistDataSourceBean.setIrHuridenatesakinm("保全支払サービス室");
        bzTienrskutiwakelistDataSourceBean.setIrSyorinm("処理名処理名処理名");
        bzTienrskutiwakelistDataSourceBean.setIrKensuu(999);
        bzTienrskutiwakelistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(999));
        bzTienrskutiwakelistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(999));

        dataSouceList.add(bzTienrskutiwakelistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzTienrskutiwakelistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzTienrskutiwakelistTest", C_SyoruiCdKbn.CM_TIENRSKUTIWAKELIST);

        bzTienrskutiwakelistBean.setIrSyoribiwareki("平成27年 8月12日");

        bzTienrskutiwakelistBean.setIrDenym("平成２７年７月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();


        BzTienrskutiwakelistDataSourceBean bzTienrskutiwakelistDataSourceBean = new BzTienrskutiwakelistDataSourceBean();

        bzTienrskutiwakelistDataSourceBean.setIrHuridenatesakinm("保全支払サービス室");
        bzTienrskutiwakelistDataSourceBean.setIrSyorinm("処理名処理名処理名");
        bzTienrskutiwakelistDataSourceBean.setIrKensuu(9999);
        bzTienrskutiwakelistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(9999));
        bzTienrskutiwakelistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(9999));

        dataSouceList.add(bzTienrskutiwakelistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzTienrskutiwakelistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzTienrskutiwakelistTest", C_SyoruiCdKbn.CM_TIENRSKUTIWAKELIST);

        bzTienrskutiwakelistBean.setIrSyoribiwareki("平成27年 8月12日");

        bzTienrskutiwakelistBean.setIrDenym("平成２７年７月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 16; i++) {
            BzTienrskutiwakelistDataSourceBean bzTienrskutiwakelistDataSourceBean = new BzTienrskutiwakelistDataSourceBean();

            bzTienrskutiwakelistDataSourceBean.setIrHuridenatesakinm("保全支払サービス室");
            bzTienrskutiwakelistDataSourceBean.setIrSyorinm("処理名処理名処理名");
            bzTienrskutiwakelistDataSourceBean.setIrKensuu(1);
            bzTienrskutiwakelistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(2));
            bzTienrskutiwakelistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(3));

            dataSouceList.add(bzTienrskutiwakelistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzTienrskutiwakelistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzTienrskutiwakelistTest", C_SyoruiCdKbn.CM_TIENRSKUTIWAKELIST);

        bzTienrskutiwakelistBean.setIrSyoribiwareki("平成27年 8月12日");

        bzTienrskutiwakelistBean.setIrDenym("平成２７年７月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 17; i++) {
            BzTienrskutiwakelistDataSourceBean bzTienrskutiwakelistDataSourceBean = new BzTienrskutiwakelistDataSourceBean();

            bzTienrskutiwakelistDataSourceBean.setIrHuridenatesakinm("保全支払サービス室");
            bzTienrskutiwakelistDataSourceBean.setIrSyorinm("処理名処理名処理名");
            bzTienrskutiwakelistDataSourceBean.setIrKensuu(1);
            bzTienrskutiwakelistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(2));
            bzTienrskutiwakelistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(3));

            dataSouceList.add(bzTienrskutiwakelistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzTienrskutiwakelistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzTienrskutiwakelistTest", C_SyoruiCdKbn.CM_TIENRSKUTIWAKELIST);

        bzTienrskutiwakelistBean.setIrSyoribiwareki("平成27年 8月12日");

        bzTienrskutiwakelistBean.setIrDenym("平成２７年７月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 18; i++) {
            BzTienrskutiwakelistDataSourceBean bzTienrskutiwakelistDataSourceBean = new BzTienrskutiwakelistDataSourceBean();

            bzTienrskutiwakelistDataSourceBean.setIrHuridenatesakinm("保全支払サービス室");
            bzTienrskutiwakelistDataSourceBean.setIrSyorinm("処理名処理名処理名");
            bzTienrskutiwakelistDataSourceBean.setIrKensuu(1);
            bzTienrskutiwakelistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(2));
            bzTienrskutiwakelistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(3));

            dataSouceList.add(bzTienrskutiwakelistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzTienrskutiwakelistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzTienrskutiwakelistTest", C_SyoruiCdKbn.CM_TIENRSKUTIWAKELIST);

        bzTienrskutiwakelistBean.setIrSyoribiwareki("平成27年 8月12日");

        bzTienrskutiwakelistBean.setIrDenym("平成２７年７月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 16980; i++) {
            BzTienrskutiwakelistDataSourceBean bzTienrskutiwakelistDataSourceBean = new BzTienrskutiwakelistDataSourceBean();

            bzTienrskutiwakelistDataSourceBean.setIrHuridenatesakinm("保全支払サービス室");
            bzTienrskutiwakelistDataSourceBean.setIrSyorinm("処理名処理名処理名");
            bzTienrskutiwakelistDataSourceBean.setIrKensuu(1);
            bzTienrskutiwakelistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(0));
            bzTienrskutiwakelistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(0));

            dataSouceList.add(bzTienrskutiwakelistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzTienrskutiwakelistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
