package yuyu.report.biz;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzFbHurikomiGoukeiListBean;
import yuyu.def.biz.bean.report.BzFbHurikomiGoukeiListDataSourceBean;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＦＢ振込合計リスト帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzFbHuriKomiGoukeiListTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzFbHurikomiGoukeiListBean bzFbHurikomiGoukeiListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzFbHuriKomiGoukeiListTest", C_SyoruiCdKbn.CM_ONLINE_FBFURIKOMIKEI_1);

        bzFbHurikomiGoukeiListBean.setIrSyoriymd(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean = new BzFbHurikomiGoukeiListDataSourceBean();

        bzFbHurikomiGoukeiListDataSourceBean.setIrTantousitunm(null);
        bzFbHurikomiGoukeiListDataSourceBean.setIrShrhousiteikbn(null);
        bzFbHurikomiGoukeiListDataSourceBean.setIrGyoumucd(null);
        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmsiteiymd(null);
        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmgkkei(BizCurrency.valueOf(0));

        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzFbHurikomiGoukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzFbHuriKomiGoukeiListTest", C_SyoruiCdKbn.CM_ONLINE_FBFURIKOMIKEI_1);

        bzFbHurikomiGoukeiListBean.setIrSyoriymd("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean = new BzFbHurikomiGoukeiListDataSourceBean();

        bzFbHurikomiGoukeiListDataSourceBean.setIrTantousitunm("");
        bzFbHurikomiGoukeiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzFbHurikomiGoukeiListDataSourceBean.setIrGyoumucd(C_Gyoumucd.BLNK);
        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmsiteiymd("");
        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmkensu(BizNumber.valueOf(999));
        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmgkkei(BizCurrency.valueOf(999));

        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzFbHurikomiGoukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzFbHuriKomiGoukeiListTest", C_SyoruiCdKbn.CM_ONLINE_FBFURIKOMIKEI_1);

        bzFbHurikomiGoukeiListBean.setIrSyoriymd("平成28年12月29日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean = new BzFbHurikomiGoukeiListDataSourceBean();

        bzFbHurikomiGoukeiListDataSourceBean.setIrTantousitunm("担当室名");
        bzFbHurikomiGoukeiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmkensu(BizNumber.valueOf(1234));
        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmgkkei(BizCurrency.valueOf(5678));

        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzFbHurikomiGoukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzFbHuriKomiGoukeiListTest", C_SyoruiCdKbn.CM_ONLINE_FBFURIKOMIKEI_1);

        bzFbHurikomiGoukeiListBean.setIrSyoriymd("ＷＷ99年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean = new BzFbHurikomiGoukeiListDataSourceBean();

        bzFbHurikomiGoukeiListDataSourceBean.setIrTantousitunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzFbHurikomiGoukeiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmsiteiymd("ＷＷ99年99月99日");
        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmkensu(BizNumber.valueOf(99999999999L));
        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmgkkei(BizCurrency.valueOf(9999999999999L));

        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzFbHurikomiGoukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzFbHuriKomiGoukeiListTest", C_SyoruiCdKbn.CM_ONLINE_FBFURIKOMIKEI_1);

        bzFbHurikomiGoukeiListBean.setIrSyoriymd("平成28年12月29日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean = new BzFbHurikomiGoukeiListDataSourceBean();

        bzFbHurikomiGoukeiListDataSourceBean.setIrTantousitunm("担当室名");
        bzFbHurikomiGoukeiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzFbHurikomiGoukeiListDataSourceBean.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmkensu(BizNumber.valueOf(9999));
        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmgkkei(BizCurrency.valueOf(9999));

        BzFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean2 = new BzFbHurikomiGoukeiListDataSourceBean();

        bzFbHurikomiGoukeiListDataSourceBean2.setIrTantousitunm("担当室名");
        bzFbHurikomiGoukeiListDataSourceBean2.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmkensu(BizNumber.valueOf(9999));
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmgkkei(BizCurrency.valueOf(9999));

        BzFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean3 = new BzFbHurikomiGoukeiListDataSourceBean();

        bzFbHurikomiGoukeiListDataSourceBean3.setIrTantousitunm("担当室名");
        bzFbHurikomiGoukeiListDataSourceBean3.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmkensu(BizNumber.valueOf(9999));
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmgkkei(BizCurrency.valueOf(9999));

        BzFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean4 = new BzFbHurikomiGoukeiListDataSourceBean();

        bzFbHurikomiGoukeiListDataSourceBean4.setIrTantousitunm("担当室名");
        bzFbHurikomiGoukeiListDataSourceBean4.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean4.setIrGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        bzFbHurikomiGoukeiListDataSourceBean4.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean4.setIrHrkmkensu(BizNumber.valueOf(9999));
        bzFbHurikomiGoukeiListDataSourceBean4.setIrHrkmgkkei(BizCurrency.valueOf(9999));

        BzFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean5 = new BzFbHurikomiGoukeiListDataSourceBean();

        bzFbHurikomiGoukeiListDataSourceBean5.setIrTantousitunm("担当室名");
        bzFbHurikomiGoukeiListDataSourceBean5.setIrShrhousiteikbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        bzFbHurikomiGoukeiListDataSourceBean5.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
        bzFbHurikomiGoukeiListDataSourceBean5.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean5.setIrHrkmkensu(BizNumber.valueOf(9999));
        bzFbHurikomiGoukeiListDataSourceBean5.setIrHrkmgkkei(BizCurrency.valueOf(9999));

        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean2);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean3);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean4);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean5);

        for(int i = 1;i <9995;i++){

            BzFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean6 = new BzFbHurikomiGoukeiListDataSourceBean();

            if(i%2 == 1 ){
                bzFbHurikomiGoukeiListDataSourceBean6.setIrTantousitunm("担当室名");
                bzFbHurikomiGoukeiListDataSourceBean6.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
                bzFbHurikomiGoukeiListDataSourceBean6.setIrGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
                bzFbHurikomiGoukeiListDataSourceBean6.setIrHrkmsiteiymd("平成30年 1月10日");
                bzFbHurikomiGoukeiListDataSourceBean6.setIrHrkmkensu(BizNumber.valueOf(9999));
                bzFbHurikomiGoukeiListDataSourceBean6.setIrHrkmgkkei(BizCurrency.valueOf(9999));
            }

            else{
                bzFbHurikomiGoukeiListDataSourceBean6.setIrTantousitunm("担当室名");
                bzFbHurikomiGoukeiListDataSourceBean6.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
                bzFbHurikomiGoukeiListDataSourceBean6.setIrGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
                bzFbHurikomiGoukeiListDataSourceBean6.setIrHrkmsiteiymd("平成30年 1月10日");
                bzFbHurikomiGoukeiListDataSourceBean6.setIrHrkmkensu(BizNumber.valueOf(9999));
                bzFbHurikomiGoukeiListDataSourceBean6.setIrHrkmgkkei(BizCurrency.valueOf(9999));
            }
            dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean6);
        }

        reportTestBean.addParamObjects(dataSouceList, bzFbHurikomiGoukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzFbHuriKomiGoukeiListTest", C_SyoruiCdKbn.CM_ONLINE_FBFURIKOMIKEI_1);

        bzFbHurikomiGoukeiListBean.setIrSyoriymd("平成28年12月29日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 1;i < 1000;i++){

            BzFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean5 = new BzFbHurikomiGoukeiListDataSourceBean();

            if(i%2 == 1 ){
                bzFbHurikomiGoukeiListDataSourceBean5.setIrTantousitunm("担当室名");
                bzFbHurikomiGoukeiListDataSourceBean5.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
                bzFbHurikomiGoukeiListDataSourceBean5.setIrGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
                bzFbHurikomiGoukeiListDataSourceBean5.setIrHrkmsiteiymd("平成30年 1月10日");
                bzFbHurikomiGoukeiListDataSourceBean5.setIrHrkmkensu(BizNumber.valueOf(9999));
                bzFbHurikomiGoukeiListDataSourceBean5.setIrHrkmgkkei(BizCurrency.valueOf(9999));
            }

            else{
                bzFbHurikomiGoukeiListDataSourceBean5.setIrTantousitunm("担当室名");
                bzFbHurikomiGoukeiListDataSourceBean5.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
                bzFbHurikomiGoukeiListDataSourceBean5.setIrGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
                bzFbHurikomiGoukeiListDataSourceBean5.setIrHrkmsiteiymd("平成30年 1月10日");
                bzFbHurikomiGoukeiListDataSourceBean5.setIrHrkmkensu(BizNumber.valueOf(9999));
                bzFbHurikomiGoukeiListDataSourceBean5.setIrHrkmgkkei(BizCurrency.valueOf(9999));
            }
            dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean5);
        }

        reportTestBean.addParamObjects(dataSouceList, bzFbHurikomiGoukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzFbHuriKomiGoukeiListTest", C_SyoruiCdKbn.CM_ONLINE_FBFURIKOMIKEI_1);

        bzFbHurikomiGoukeiListBean.setIrSyoriymd("平成28年12月29日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean = new BzFbHurikomiGoukeiListDataSourceBean();

        bzFbHurikomiGoukeiListDataSourceBean.setIrTantousitunm("担当室名");
        bzFbHurikomiGoukeiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.BLNK);
        bzFbHurikomiGoukeiListDataSourceBean.setIrGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmkensu(BizNumber.valueOf(9999));
        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmgkkei(BizCurrency.valueOf(9999));

        BzFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean2 = new BzFbHurikomiGoukeiListDataSourceBean();

        bzFbHurikomiGoukeiListDataSourceBean2.setIrTantousitunm("担当室名");
        bzFbHurikomiGoukeiListDataSourceBean2.setIrShrhousiteikbn(C_ShrhousiteiKbn.BLNK);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmkensu(BizNumber.valueOf(9999));
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmgkkei(BizCurrency.valueOf(9999));

        BzFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean3 = new BzFbHurikomiGoukeiListDataSourceBean();

        bzFbHurikomiGoukeiListDataSourceBean3.setIrTantousitunm("担当室名");
        bzFbHurikomiGoukeiListDataSourceBean3.setIrShrhousiteikbn(C_ShrhousiteiKbn.BLNK);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrGyoumucd(C_Gyoumucd.NENKINJIDOUSOUKIN);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmkensu(BizNumber.valueOf(9999));
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmgkkei(BizCurrency.valueOf(9999));

        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean2);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, bzFbHurikomiGoukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
