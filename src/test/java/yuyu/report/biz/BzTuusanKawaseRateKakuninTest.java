package yuyu.report.biz;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzTuusanKawaseRateKakuninBean;
import yuyu.def.biz.bean.report.BzTuusanKawaseRateKakuninDataSourceBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 通算判定用為替レート確認書 帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzTuusanKawaseRateKakuninTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzTuusanKawaseRateKakuninBean bzTuusanKawaseRateKakuninBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzTuusanKawaseRateKakuninTest_case1", C_SyoruiCdKbn.CM_TUUSANKAWASERATEKAKUNIN);

        bzTuusanKawaseRateKakuninBean.setIrSyoribi(null);
        bzTuusanKawaseRateKakuninBean.setIrNendoymd(null);
        bzTuusanKawaseRateKakuninBean.setIrTsnhntiyukawaserate1(null);
        bzTuusanKawaseRateKakuninBean.setIrTsnhntiyukawaserate2(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzTuusanKawaseRateKakuninDataSourceBean bzTuusanKawaseRateKakuninDSBean = new BzTuusanKawaseRateKakuninDataSourceBean();


        for (int i=0; i < 12; i++){
            bzTuusanKawaseRateKakuninDSBean.setIrZennendogseigyouymd(null);
            bzTuusanKawaseRateKakuninDSBean.setIrKwsrate1(null);
            bzTuusanKawaseRateKakuninDSBean.setIrKwsrate2(null);

            dataSouceList.add(bzTuusanKawaseRateKakuninDSBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzTuusanKawaseRateKakuninBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzTuusanKawaseRateKakuninTest_case2", C_SyoruiCdKbn.CM_TUUSANKAWASERATEKAKUNIN);

        bzTuusanKawaseRateKakuninBean.setIrSyoribi(BizDate.valueOf("20170301"));
        bzTuusanKawaseRateKakuninBean.setIrNendoymd(BizDate.valueOf("20180301"));
        bzTuusanKawaseRateKakuninBean.setIrTsnhntiyukawaserate1(BizNumber.valueOf(0));
        bzTuusanKawaseRateKakuninBean.setIrTsnhntiyukawaserate2(BizNumber.valueOf(0));

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzTuusanKawaseRateKakuninDataSourceBean bzTuusanKawaseRateKakuninDSBean = new BzTuusanKawaseRateKakuninDataSourceBean();


        for (int i=0; i < 12; i++){
            bzTuusanKawaseRateKakuninDSBean.setIrZennendogseigyouymd(BizDate.valueOf("20170501"));
            bzTuusanKawaseRateKakuninDSBean.setIrKwsrate1(BizNumber.valueOf(0));
            bzTuusanKawaseRateKakuninDSBean.setIrKwsrate2(BizNumber.valueOf(0));

            dataSouceList.add(bzTuusanKawaseRateKakuninDSBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzTuusanKawaseRateKakuninBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }



    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzTuusanKawaseRateKakuninTest_case3", C_SyoruiCdKbn.CM_TUUSANKAWASERATEKAKUNIN);

        bzTuusanKawaseRateKakuninBean.setIrSyoribi(BizDate.valueOf("20170301"));
        bzTuusanKawaseRateKakuninBean.setIrNendoymd(BizDate.valueOf("20170401"));
        bzTuusanKawaseRateKakuninBean.setIrTsnhntiyukawaserate1(BizNumber.valueOf(101.1));
        bzTuusanKawaseRateKakuninBean.setIrTsnhntiyukawaserate2(BizNumber.valueOf(201.1));

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzTuusanKawaseRateKakuninDataSourceBean bzTuusanKawaseRateKakuninDSBean = new BzTuusanKawaseRateKakuninDataSourceBean();


        for (int i=0; i < 12; i++){
            bzTuusanKawaseRateKakuninDSBean.setIrZennendogseigyouymd(BizDate.valueOf("20170501"));
            bzTuusanKawaseRateKakuninDSBean.setIrKwsrate1(BizNumber.valueOf(301.1));
            bzTuusanKawaseRateKakuninDSBean.setIrKwsrate2(BizNumber.valueOf(401.1));

            dataSouceList.add(bzTuusanKawaseRateKakuninDSBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzTuusanKawaseRateKakuninBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzTuusanKawaseRateKakuninTest_case4", C_SyoruiCdKbn.CM_TUUSANKAWASERATEKAKUNIN);

        bzTuusanKawaseRateKakuninBean.setIrSyoribi(BizDate.valueOf("20170301"));
        bzTuusanKawaseRateKakuninBean.setIrNendoymd(BizDate.valueOf("20170401"));
        bzTuusanKawaseRateKakuninBean.setIrTsnhntiyukawaserate1(BizNumber.valueOf(101));
        bzTuusanKawaseRateKakuninBean.setIrTsnhntiyukawaserate2(BizNumber.valueOf(201));

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzTuusanKawaseRateKakuninDataSourceBean bzTuusanKawaseRateKakuninDSBean = new BzTuusanKawaseRateKakuninDataSourceBean();


        for (int i=0; i < 12; i++){
            bzTuusanKawaseRateKakuninDSBean.setIrZennendogseigyouymd(BizDate.valueOf("20170501"));
            bzTuusanKawaseRateKakuninDSBean.setIrKwsrate1(BizNumber.valueOf(301));
            bzTuusanKawaseRateKakuninDSBean.setIrKwsrate2(BizNumber.valueOf(401));

            dataSouceList.add(bzTuusanKawaseRateKakuninDSBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzTuusanKawaseRateKakuninBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzTuusanKawaseRateKakuninTest_case5", C_SyoruiCdKbn.CM_TUUSANKAWASERATEKAKUNIN);

        bzTuusanKawaseRateKakuninBean.setIrSyoribi(BizDate.valueOf("20170301"));
        bzTuusanKawaseRateKakuninBean.setIrNendoymd(BizDate.valueOf("20170401"));
        bzTuusanKawaseRateKakuninBean.setIrTsnhntiyukawaserate1(BizNumber.valueOf(10.22));
        bzTuusanKawaseRateKakuninBean.setIrTsnhntiyukawaserate2(BizNumber.valueOf(20.22));

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzTuusanKawaseRateKakuninDataSourceBean bzTuusanKawaseRateKakuninDSBean = new BzTuusanKawaseRateKakuninDataSourceBean();


        for (int i=0; i < 12; i++){
            bzTuusanKawaseRateKakuninDSBean.setIrZennendogseigyouymd(BizDate.valueOf("20170501"));
            bzTuusanKawaseRateKakuninDSBean.setIrKwsrate1(BizNumber.valueOf(30.22));
            bzTuusanKawaseRateKakuninDSBean.setIrKwsrate2(BizNumber.valueOf(40.22));

            dataSouceList.add(bzTuusanKawaseRateKakuninDSBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzTuusanKawaseRateKakuninBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzTuusanKawaseRateKakuninTest_case6", C_SyoruiCdKbn.CM_TUUSANKAWASERATEKAKUNIN);

        bzTuusanKawaseRateKakuninBean.setIrSyoribi(BizDate.valueOf("99991231"));
        bzTuusanKawaseRateKakuninBean.setIrNendoymd(BizDate.valueOf("99991231"));
        bzTuusanKawaseRateKakuninBean.setIrTsnhntiyukawaserate1(BizNumber.valueOf(999.9900));
        bzTuusanKawaseRateKakuninBean.setIrTsnhntiyukawaserate2(BizNumber.valueOf(999.9900));


        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzTuusanKawaseRateKakuninDataSourceBean bzTuusanKawaseRateKakuninDSBean = new BzTuusanKawaseRateKakuninDataSourceBean();


        for (int i=0; i < 12; i++){
            bzTuusanKawaseRateKakuninDSBean.setIrZennendogseigyouymd(BizDate.valueOf("99991231"));
            bzTuusanKawaseRateKakuninDSBean.setIrKwsrate1(BizNumber.valueOf(999.99));
            bzTuusanKawaseRateKakuninDSBean.setIrKwsrate2(BizNumber.valueOf(999.99));

            dataSouceList.add(bzTuusanKawaseRateKakuninDSBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzTuusanKawaseRateKakuninBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzTuusanKawaseRateKakuninTest_case1", C_SyoruiCdKbn.CM_TUUSANKAWASERATEKAKUNIN);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, bzTuusanKawaseRateKakuninBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }



}
