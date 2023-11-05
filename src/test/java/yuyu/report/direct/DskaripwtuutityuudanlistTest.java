package yuyu.report.direct;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DsKrHnnKakCdTtTydnJyKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.direct.bean.report.DsKaripwtuutiTyuudanListBean;
import yuyu.def.direct.bean.report.DsKaripwtuutiTyuudanListDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 仮パスワード通知作成中断リスト<br />
 */
@RunWith(OrderedRunner.class)
public class DskaripwtuutityuudanlistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private DsKaripwtuutiTyuudanListBean dsKaripwtuutiTyuudanListBean;


    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("direct", "", "DskaripwtuutityuudanlistTest", C_SyoruiCdKbn.DS_KARIPWTUUTITYUUDANLIST);

        dsKaripwtuutiTyuudanListBean.setIrSakuseiymd(null);

        dsKaripwtuutiTyuudanListBean.setIrKensuu(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            DsKaripwtuutiTyuudanListDataSourceBean dsKaripwtuutiTyuudanListDataSourceBean = new DsKaripwtuutiTyuudanListDataSourceBean();

            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskokno(null);
            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskokyakunmkj(null);
            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskrhnnkakcdtttydnjykbn(null);
            dsKaripwtuutiTyuudanListDataSourceBean.setIrMemo(null);

            dataSouceList.add(dsKaripwtuutiTyuudanListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, dsKaripwtuutiTyuudanListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("direct", "", "DskaripwtuutityuudanlistTest", C_SyoruiCdKbn.DS_KARIPWTUUTITYUUDANLIST);

        dsKaripwtuutiTyuudanListBean.setIrSakuseiymd("");

        dsKaripwtuutiTyuudanListBean.setIrKensuu(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            DsKaripwtuutiTyuudanListDataSourceBean dsKaripwtuutiTyuudanListDataSourceBean = new DsKaripwtuutiTyuudanListDataSourceBean();

            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskokno("");
            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskokyakunmkj("");
            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskrhnnkakcdtttydnjykbn(null);
            dsKaripwtuutiTyuudanListDataSourceBean.setIrMemo("");

            dataSouceList.add(dsKaripwtuutiTyuudanListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, dsKaripwtuutiTyuudanListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("direct", "", "DskaripwtuutityuudanlistTest", C_SyoruiCdKbn.DS_KARIPWTUUTITYUUDANLIST);

        dsKaripwtuutiTyuudanListBean.setIrSakuseiymd("平成27年8月12日");

        dsKaripwtuutiTyuudanListBean.setIrKensuu(1);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 0; i++) {
            DsKaripwtuutiTyuudanListDataSourceBean dsKaripwtuutiTyuudanListDataSourceBean = new DsKaripwtuutiTyuudanListDataSourceBean();

            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskokno("1000000001");
            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskokyakunmkj("ＤＳ顧客名（漢字）");
            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskrhnnkakcdtttydnjykbn(C_DsKrHnnKakCdTtTydnJyKbn.NYSHK_JSS_MGS_JSHT_MGHT);
            dsKaripwtuutiTyuudanListDataSourceBean.setIrMemo("メモ");

            dataSouceList.add(dsKaripwtuutiTyuudanListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, dsKaripwtuutiTyuudanListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("direct", "", "DskaripwtuutityuudanlistTest", C_SyoruiCdKbn.DS_KARIPWTUUTITYUUDANLIST);

        dsKaripwtuutiTyuudanListBean.setIrSakuseiymd("平成27年8月12日");

        dsKaripwtuutiTyuudanListBean.setIrKensuu(222);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 9; i++) {
            DsKaripwtuutiTyuudanListDataSourceBean dsKaripwtuutiTyuudanListDataSourceBean = new DsKaripwtuutiTyuudanListDataSourceBean();

            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskokno("1000000001");
            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskokyakunmkj("ＤＳ顧客名（漢字）");
            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskrhnnkakcdtttydnjykbn(C_DsKrHnnKakCdTtTydnJyKbn.KKKSBTY);
            dsKaripwtuutiTyuudanListDataSourceBean.setIrMemo("メモ");

            dataSouceList.add(dsKaripwtuutiTyuudanListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, dsKaripwtuutiTyuudanListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("direct", "", "DskaripwtuutityuudanlistTest", C_SyoruiCdKbn.DS_KARIPWTUUTITYUUDANLIST);

        dsKaripwtuutiTyuudanListBean.setIrSakuseiymd("平成27年8月12日");

        dsKaripwtuutiTyuudanListBean.setIrKensuu(3333);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 10; i++) {
            DsKaripwtuutiTyuudanListDataSourceBean dsKaripwtuutiTyuudanListDataSourceBean = new DsKaripwtuutiTyuudanListDataSourceBean();

            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskokno("1000000001");
            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskokyakunmkj("ＤＳ顧客名（漢字）");
            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskrhnnkakcdtttydnjykbn(C_DsKrHnnKakCdTtTydnJyKbn.NYSHK_JSS_MGS_JSHT_MGHT);
            dsKaripwtuutiTyuudanListDataSourceBean.setIrMemo("メモ");

            dataSouceList.add(dsKaripwtuutiTyuudanListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, dsKaripwtuutiTyuudanListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("direct", "", "DskaripwtuutityuudanlistTest", C_SyoruiCdKbn.DS_KARIPWTUUTITYUUDANLIST);

        dsKaripwtuutiTyuudanListBean.setIrSakuseiymd("ＷＷ９９年９９月９９日");

        dsKaripwtuutiTyuudanListBean.setIrKensuu(99999);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 11; i++) {
            DsKaripwtuutiTyuudanListDataSourceBean dsKaripwtuutiTyuudanListDataSourceBean = new DsKaripwtuutiTyuudanListDataSourceBean();

            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskokno("WWWWWWWWWW");
            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskokyakunmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskrhnnkakcdtttydnjykbn(C_DsKrHnnKakCdTtTydnJyKbn.NYSHK_JSS_MGS_JSHT_MGHT);
            dsKaripwtuutiTyuudanListDataSourceBean.setIrMemo("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            dataSouceList.add(dsKaripwtuutiTyuudanListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, dsKaripwtuutiTyuudanListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("direct", "", "DskaripwtuutityuudanlistTest", C_SyoruiCdKbn.DS_KARIPWTUUTITYUUDANLIST);

        dsKaripwtuutiTyuudanListBean.setIrSakuseiymd("ＷＷ９９年９９月９９日");

        dsKaripwtuutiTyuudanListBean.setIrKensuu(99999);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 9990; i++) {
            DsKaripwtuutiTyuudanListDataSourceBean dsKaripwtuutiTyuudanListDataSourceBean = new DsKaripwtuutiTyuudanListDataSourceBean();

            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskokno("WWWWWWWWWW");
            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskokyakunmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            dsKaripwtuutiTyuudanListDataSourceBean.setIrDskrhnnkakcdtttydnjykbn(C_DsKrHnnKakCdTtTydnJyKbn.NYSHK_JSS_MGS_JSHT_MGHT);
            dsKaripwtuutiTyuudanListDataSourceBean.setIrMemo("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            dataSouceList.add(dsKaripwtuutiTyuudanListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, dsKaripwtuutiTyuudanListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("direct", "", "DskaripwtuutityuudanlistTest", C_SyoruiCdKbn.DS_KARIPWTUUTITYUUDANLIST);

        dsKaripwtuutiTyuudanListBean.setIrSakuseiymd("平成27年8月12日");

        dsKaripwtuutiTyuudanListBean.setIrKensuu(1);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        DsKaripwtuutiTyuudanListDataSourceBean dsKaripwtuutiTyuudanListDataSourceBean = new DsKaripwtuutiTyuudanListDataSourceBean();

        dsKaripwtuutiTyuudanListDataSourceBean.setIrDskokno("1111111111");
        dsKaripwtuutiTyuudanListDataSourceBean.setIrDskokyakunmkj("ＤＳ顧客名（漢字）");
        dsKaripwtuutiTyuudanListDataSourceBean.setIrDskrhnnkakcdtttydnjykbn(C_DsKrHnnKakCdTtTydnJyKbn.NYSHK_JSS_MGS_JSHT_MGHT);
        dsKaripwtuutiTyuudanListDataSourceBean.setIrMemo("メモ");

        dataSouceList.add(dsKaripwtuutiTyuudanListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, dsKaripwtuutiTyuudanListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
