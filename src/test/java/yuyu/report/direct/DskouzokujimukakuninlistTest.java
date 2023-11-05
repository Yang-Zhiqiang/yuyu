package yuyu.report.direct;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DsKzkJmKknHsJyKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.direct.bean.report.DsKzkjmkknListBean;
import yuyu.def.direct.bean.report.DsKzkjmkknListDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
/**
 * ＤＳ後続事務確認リスト<br />
 */
@RunWith(OrderedRunner.class)
public class DskouzokujimukakuninlistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private DsKzkjmkknListBean dsKzkjmkknListBean;


    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("direct", "", "DskouzokujimukakuninlistTest", C_SyoruiCdKbn.DS_KOUZOKUJIMUKAKUNINLIST);

        dsKzkjmkknListBean.setIrTyouhyousakuseiymd(null);

        dsKzkjmkknListBean.setIrKensuu(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            DsKzkjmkknListDataSourceBean dsKzkjmkknListDataSourceBean = new DsKzkjmkknListDataSourceBean();

            dsKzkjmkknListDataSourceBean.setIrDskzkjmkknhsjykbn(null);
            dsKzkjmkknListDataSourceBean.setIrKyknmkj(null);
            dsKzkjmkknListDataSourceBean.setIrSyono(null);
            dsKzkjmkknListDataSourceBean.setIrMessage(null);

            dataSouceList.add(dsKzkjmkknListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, dsKzkjmkknListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("direct", "", "DskouzokujimukakuninlistTest", C_SyoruiCdKbn.DS_KOUZOKUJIMUKAKUNINLIST);

        dsKzkjmkknListBean.setIrTyouhyousakuseiymd("");

        dsKzkjmkknListBean.setIrKensuu(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            DsKzkjmkknListDataSourceBean dsKzkjmkknListDataSourceBean = new DsKzkjmkknListDataSourceBean();

            dsKzkjmkknListDataSourceBean.setIrDskzkjmkknhsjykbn(null);
            dsKzkjmkknListDataSourceBean.setIrKyknmkj("");
            dsKzkjmkknListDataSourceBean.setIrSyono("");
            dsKzkjmkknListDataSourceBean.setIrMessage("");

            dataSouceList.add(dsKzkjmkknListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, dsKzkjmkknListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("direct", "", "DskouzokujimukakuninlistTest", C_SyoruiCdKbn.DS_KOUZOKUJIMUKAKUNINLIST);

        dsKzkjmkknListBean.setIrTyouhyousakuseiymd("平成27年8月12日");

        dsKzkjmkknListBean.setIrKensuu(1);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 0; i++) {
            DsKzkjmkknListDataSourceBean dsKzkjmkknListDataSourceBean = new DsKzkjmkknListDataSourceBean();

            dsKzkjmkknListDataSourceBean.setIrDskzkjmkknhsjykbn(C_DsKzkJmKknHsJyKbn.NAYOSESAKIKEIYAKUIDOUTYUU);
            dsKzkjmkknListDataSourceBean.setIrKyknmkj("契約者名");
            dsKzkjmkknListDataSourceBean.setIrSyono("10000000001");
            dsKzkjmkknListDataSourceBean.setIrMessage("メッセージ");

            dataSouceList.add(dsKzkjmkknListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, dsKzkjmkknListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("direct", "", "DskouzokujimukakuninlistTest", C_SyoruiCdKbn.DS_KOUZOKUJIMUKAKUNINLIST);

        dsKzkjmkknListBean.setIrTyouhyousakuseiymd("平成27年8月12日");

        dsKzkjmkknListBean.setIrKensuu(222);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 9; i++) {
            DsKzkjmkknListDataSourceBean dsKzkjmkknListDataSourceBean = new DsKzkjmkknListDataSourceBean();

            dsKzkjmkknListDataSourceBean.setIrDskzkjmkknhsjykbn(C_DsKzkJmKknHsJyKbn.NAYOSESAKIHUMEI);
            dsKzkjmkknListDataSourceBean.setIrKyknmkj("契約者名");
            dsKzkjmkknListDataSourceBean.setIrSyono("10000000001");
            dsKzkjmkknListDataSourceBean.setIrMessage("メッセージ");

            dataSouceList.add(dsKzkjmkknListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, dsKzkjmkknListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("direct", "", "DskouzokujimukakuninlistTest", C_SyoruiCdKbn.DS_KOUZOKUJIMUKAKUNINLIST);

        dsKzkjmkknListBean.setIrTyouhyousakuseiymd("平成27年8月12日");

        dsKzkjmkknListBean.setIrKensuu(3333);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 10; i++) {
            DsKzkjmkknListDataSourceBean dsKzkjmkknListDataSourceBean = new DsKzkjmkknListDataSourceBean();

            dsKzkjmkknListDataSourceBean.setIrDskzkjmkknhsjykbn(C_DsKzkJmKknHsJyKbn.NAYOSESAKIKEIYAKUIDOUTYUU);
            dsKzkjmkknListDataSourceBean.setIrKyknmkj("契約者名");
            dsKzkjmkknListDataSourceBean.setIrSyono("10000000001");
            dsKzkjmkknListDataSourceBean.setIrMessage("メッセージ");

            dataSouceList.add(dsKzkjmkknListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, dsKzkjmkknListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("direct", "", "DskouzokujimukakuninlistTest", C_SyoruiCdKbn.DS_KOUZOKUJIMUKAKUNINLIST);

        dsKzkjmkknListBean.setIrTyouhyousakuseiymd("ＷＷ９９年９９月９９日");

        dsKzkjmkknListBean.setIrKensuu(99999);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 11; i++) {
            DsKzkjmkknListDataSourceBean dsKzkjmkknListDataSourceBean = new DsKzkjmkknListDataSourceBean();

            dsKzkjmkknListDataSourceBean.setIrDskzkjmkknhsjykbn(C_DsKzkJmKknHsJyKbn.NAYOSESAKIKEIYAKUIDOUTYUU);
            dsKzkjmkknListDataSourceBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            dsKzkjmkknListDataSourceBean.setIrSyono("WWWWWWWWWWW");
            dsKzkjmkknListDataSourceBean.setIrMessage("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            dataSouceList.add(dsKzkjmkknListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, dsKzkjmkknListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("direct", "", "DskouzokujimukakuninlistTest", C_SyoruiCdKbn.DS_KOUZOKUJIMUKAKUNINLIST);

        dsKzkjmkknListBean.setIrTyouhyousakuseiymd("ＷＷ９９年９９月９９日");

        dsKzkjmkknListBean.setIrKensuu(99999);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 9990; i++) {
            DsKzkjmkknListDataSourceBean dsKzkjmkknListDataSourceBean = new DsKzkjmkknListDataSourceBean();

            dsKzkjmkknListDataSourceBean.setIrDskzkjmkknhsjykbn(C_DsKzkJmKknHsJyKbn.NAYOSESAKIKEIYAKUIDOUTYUU);
            dsKzkjmkknListDataSourceBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            dsKzkjmkknListDataSourceBean.setIrSyono("WWWWWWWWWWW");
            dsKzkjmkknListDataSourceBean.setIrMessage("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            dataSouceList.add(dsKzkjmkknListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, dsKzkjmkknListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("direct", "", "DskouzokujimukakuninlistTest", C_SyoruiCdKbn.DS_KOUZOKUJIMUKAKUNINLIST);

        dsKzkjmkknListBean.setIrTyouhyousakuseiymd("平成27年8月12日");

        dsKzkjmkknListBean.setIrKensuu(1);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        DsKzkjmkknListDataSourceBean dsKzkjmkknListDataSourceBean = new DsKzkjmkknListDataSourceBean();

        dsKzkjmkknListDataSourceBean.setIrDskzkjmkknhsjykbn(C_DsKzkJmKknHsJyKbn.NAYOSESAKIKEIYAKUIDOUTYUU);
        dsKzkjmkknListDataSourceBean.setIrKyknmkj("契約者名");
        dsKzkjmkknListDataSourceBean.setIrSyono("10000000001");
        dsKzkjmkknListDataSourceBean.setIrMessage("メッセージ");

        dataSouceList.add(dsKzkjmkknListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, dsKzkjmkknListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
