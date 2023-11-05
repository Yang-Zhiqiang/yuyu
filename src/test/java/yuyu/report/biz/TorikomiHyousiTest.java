package yuyu.report.biz;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.workflow.bean.report.TorikomiHyousiDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 取込用表紙用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class TorikomiHyousiTest {

    @Inject
    private CreateReport createReport;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "TorikomiHyousiTest", C_SyoruiCdKbn.WF_HYOUSI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        TorikomiHyousiDataSourceBean torikomiHyousiDataSourceBean = new TorikomiHyousiDataSourceBean();

        torikomiHyousiDataSourceBean.setSousasyanm("");
        torikomiHyousiDataSourceBean.setSubSystemNm("");
        torikomiHyousiDataSourceBean.setJimutetuzukinm("");
        torikomiHyousiDataSourceBean.setMosno("");
        torikomiHyousiDataSourceBean.setSyoruinm("");
        torikomiHyousiDataSourceBean.setWorkflowDocumentId("");

        dataSouceList.add(torikomiHyousiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "TorikomiHyousiTest", C_SyoruiCdKbn.WF_HYOUSI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        TorikomiHyousiDataSourceBean torikomiHyousiDataSourceBean = new TorikomiHyousiDataSourceBean();

        torikomiHyousiDataSourceBean.setSousasyanm(null);
        torikomiHyousiDataSourceBean.setSubSystemNm(null);
        torikomiHyousiDataSourceBean.setJimutetuzukinm(null);
        torikomiHyousiDataSourceBean.setMosno(null);
        torikomiHyousiDataSourceBean.setSyoruinm(null);
        torikomiHyousiDataSourceBean.setWorkflowDocumentId(null);

        dataSouceList.add(torikomiHyousiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "TorikomiHyousiTest", C_SyoruiCdKbn.WF_HYOUSI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        TorikomiHyousiDataSourceBean torikomiHyousiDataSourceBean = new TorikomiHyousiDataSourceBean();

        torikomiHyousiDataSourceBean.setSousasyanm("操作者");
        torikomiHyousiDataSourceBean.setSubSystemNm("新契約");
        torikomiHyousiDataSourceBean.setJimutetuzukinm("事務手続");
        torikomiHyousiDataSourceBean.setMosno("791112220");
        torikomiHyousiDataSourceBean.setSyoruinm("書類名");
        torikomiHyousiDataSourceBean.setWorkflowDocumentId("yuyu00h2djkqxgibacz85y");

        dataSouceList.add(torikomiHyousiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "TorikomiHyousiTest", C_SyoruiCdKbn.WF_HYOUSI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        TorikomiHyousiDataSourceBean torikomiHyousiDataSourceBean = new TorikomiHyousiDataSourceBean();

        torikomiHyousiDataSourceBean.setSousasyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        torikomiHyousiDataSourceBean.setSubSystemNm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        torikomiHyousiDataSourceBean.setJimutetuzukinm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        torikomiHyousiDataSourceBean.setMosno("wwwwwwwww");
        torikomiHyousiDataSourceBean.setSyoruinm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        torikomiHyousiDataSourceBean.setWorkflowDocumentId("wwwwwwwwwwwwwwwwwwwwwwww");

        dataSouceList.add(torikomiHyousiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "TorikomiHyousiTest", C_SyoruiCdKbn.WF_HYOUSI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        TorikomiHyousiDataSourceBean torikomiHyousiDataSourceBean = new TorikomiHyousiDataSourceBean();

        torikomiHyousiDataSourceBean.setSousasyanm("");
        torikomiHyousiDataSourceBean.setSubSystemNm("契約保全");
        torikomiHyousiDataSourceBean.setJimutetuzukinm("");
        torikomiHyousiDataSourceBean.setSyono("");
        torikomiHyousiDataSourceBean.setSyoruinm("");
        torikomiHyousiDataSourceBean.setWorkflowDocumentId("");

        dataSouceList.add(torikomiHyousiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "TorikomiHyousiTest", C_SyoruiCdKbn.WF_HYOUSI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        TorikomiHyousiDataSourceBean torikomiHyousiDataSourceBean = new TorikomiHyousiDataSourceBean();

        torikomiHyousiDataSourceBean.setSousasyanm(null);
        torikomiHyousiDataSourceBean.setSubSystemNm("契約保全");
        torikomiHyousiDataSourceBean.setJimutetuzukinm(null);
        torikomiHyousiDataSourceBean.setSyono(null);
        torikomiHyousiDataSourceBean.setSyoruinm(null);
        torikomiHyousiDataSourceBean.setWorkflowDocumentId(null);

        dataSouceList.add(torikomiHyousiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "TorikomiHyousiTest", C_SyoruiCdKbn.WF_HYOUSI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        TorikomiHyousiDataSourceBean torikomiHyousiDataSourceBean = new TorikomiHyousiDataSourceBean();

        torikomiHyousiDataSourceBean.setSousasyanm("操作者");
        torikomiHyousiDataSourceBean.setSubSystemNm("契約保全");
        torikomiHyousiDataSourceBean.setJimutetuzukinm("事務手続");
        torikomiHyousiDataSourceBean.setSyono("11807111118");
        torikomiHyousiDataSourceBean.setSyoruinm("書類名");
        torikomiHyousiDataSourceBean.setWorkflowDocumentId("yuyu00h2djkqxgibacz85y");

        dataSouceList.add(torikomiHyousiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "TorikomiHyousiTest", C_SyoruiCdKbn.WF_HYOUSI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        TorikomiHyousiDataSourceBean torikomiHyousiDataSourceBean = new TorikomiHyousiDataSourceBean();

        torikomiHyousiDataSourceBean.setSousasyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        torikomiHyousiDataSourceBean.setSubSystemNm("保険金給付金支払");
        torikomiHyousiDataSourceBean.setJimutetuzukinm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        torikomiHyousiDataSourceBean.setSyono("wwwwwwwwwww");
        torikomiHyousiDataSourceBean.setSyoruinm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        torikomiHyousiDataSourceBean.setWorkflowDocumentId("wwwwwwwwwwwwwwwwwwwwwwww");

        dataSouceList.add(torikomiHyousiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "TorikomiHyousiTest", C_SyoruiCdKbn.WF_HYOUSI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        TorikomiHyousiDataSourceBean torikomiHyousiDataSourceBean = new TorikomiHyousiDataSourceBean();

        torikomiHyousiDataSourceBean.setSousasyanm("");
        torikomiHyousiDataSourceBean.setSubSystemNm("年金支払");
        torikomiHyousiDataSourceBean.setJimutetuzukinm("");
        torikomiHyousiDataSourceBean.setNksysyno("");
        torikomiHyousiDataSourceBean.setSyoruinm("");
        torikomiHyousiDataSourceBean.setWorkflowDocumentId("");

        dataSouceList.add(torikomiHyousiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "TorikomiHyousiTest", C_SyoruiCdKbn.WF_HYOUSI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        TorikomiHyousiDataSourceBean torikomiHyousiDataSourceBean = new TorikomiHyousiDataSourceBean();

        torikomiHyousiDataSourceBean.setSousasyanm(null);
        torikomiHyousiDataSourceBean.setSubSystemNm("年金支払");
        torikomiHyousiDataSourceBean.setJimutetuzukinm(null);
        torikomiHyousiDataSourceBean.setNksysyno(null);
        torikomiHyousiDataSourceBean.setSyoruinm(null);
        torikomiHyousiDataSourceBean.setWorkflowDocumentId(null);

        dataSouceList.add(torikomiHyousiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "TorikomiHyousiTest", C_SyoruiCdKbn.WF_HYOUSI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        TorikomiHyousiDataSourceBean torikomiHyousiDataSourceBean = new TorikomiHyousiDataSourceBean();

        torikomiHyousiDataSourceBean.setSousasyanm("操作者");
        torikomiHyousiDataSourceBean.setSubSystemNm("年金支払");
        torikomiHyousiDataSourceBean.setJimutetuzukinm("事務手続");
        torikomiHyousiDataSourceBean.setNksysyno("11807111118");
        torikomiHyousiDataSourceBean.setSyoruinm("書類名");
        torikomiHyousiDataSourceBean.setWorkflowDocumentId("yuyu00h2djkqxgibacz85y");

        dataSouceList.add(torikomiHyousiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "TorikomiHyousiTest", C_SyoruiCdKbn.WF_HYOUSI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        TorikomiHyousiDataSourceBean torikomiHyousiDataSourceBean = new TorikomiHyousiDataSourceBean();

        torikomiHyousiDataSourceBean.setSousasyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        torikomiHyousiDataSourceBean.setSubSystemNm("年金支払");
        torikomiHyousiDataSourceBean.setJimutetuzukinm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        torikomiHyousiDataSourceBean.setNksysyno("wwwwwwwwwww");
        torikomiHyousiDataSourceBean.setSyoruinm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        torikomiHyousiDataSourceBean.setWorkflowDocumentId("wwwwwwwwwwwwwwwwwwwwwwww");

        dataSouceList.add(torikomiHyousiDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
