package yuyu.report.biz;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzGkFbHurikomiGoukeiListBean;
import yuyu.def.biz.bean.report.BzGkFbHurikomiGoukeiListDataSourceBean;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 外貨ＦＢ振込合計リスト帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzGkFbHuriKomiGoukeiListTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzGkFbHurikomiGoukeiListBean bzGkFbHurikomiGoukeiListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbHuriKomiGoukeiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBFURIKOMIKEI_1);

        bzGkFbHurikomiGoukeiListBean.setIrSyoriymd(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean1 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean2 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean3 = new BzGkFbHurikomiGoukeiListDataSourceBean();

        bzFbHurikomiGoukeiListDataSourceBean1.setIrTantousitunm(null);
        bzFbHurikomiGoukeiListDataSourceBean1.setIrShrhousiteikbn(null);
        bzFbHurikomiGoukeiListDataSourceBean1.setIrGkgyoumucd(null);
        bzFbHurikomiGoukeiListDataSourceBean1.setIrHrkmsiteiymd(null);
        bzFbHurikomiGoukeiListDataSourceBean1.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzFbHurikomiGoukeiListDataSourceBean1.setIrHrkmkensu(null);
        bzFbHurikomiGoukeiListDataSourceBean1.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean1.setIrDenpyogkkei(BizCurrency.valueOf(0));

        bzFbHurikomiGoukeiListDataSourceBean2.setIrTantousitunm(null);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrShrhousiteikbn(null);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrGkgyoumucd(null);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmsiteiymd(null);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmkensu(null);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean2.setIrDenpyogkkei(BizCurrency.valueOf(0));

        bzFbHurikomiGoukeiListDataSourceBean3.setIrTantousitunm(null);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrShrhousiteikbn(null);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrGkgyoumucd(null);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmsiteiymd(null);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmkensu(null);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean3.setIrDenpyogkkei(BizCurrency.valueOf(0));


        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean1);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean2);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, bzGkFbHurikomiGoukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbHuriKomiGoukeiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBFURIKOMIKEI_1);

        bzGkFbHurikomiGoukeiListBean.setIrSyoriymd("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean1 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean2 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean3 = new BzGkFbHurikomiGoukeiListDataSourceBean();

        bzFbHurikomiGoukeiListDataSourceBean1.setIrTantousitunm("");
        bzFbHurikomiGoukeiListDataSourceBean1.setIrShrhousiteikbn(C_ShrhousiteiKbn.BLNK);
        bzFbHurikomiGoukeiListDataSourceBean1.setIrGkgyoumucd(C_Gkgyoumucd.BLNK);
        bzFbHurikomiGoukeiListDataSourceBean1.setIrHrkmsiteiymd("");
        bzFbHurikomiGoukeiListDataSourceBean1.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzFbHurikomiGoukeiListDataSourceBean1.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean1.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean1.setIrDenpyogkkei(BizCurrency.valueOf(0));

        bzFbHurikomiGoukeiListDataSourceBean2.setIrTantousitunm("");
        bzFbHurikomiGoukeiListDataSourceBean2.setIrShrhousiteikbn(C_ShrhousiteiKbn.BLNK);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrGkgyoumucd(C_Gkgyoumucd.BLNK);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmsiteiymd("");
        bzFbHurikomiGoukeiListDataSourceBean2.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean2.setIrDenpyogkkei(BizCurrency.valueOf(0));

        bzFbHurikomiGoukeiListDataSourceBean3.setIrTantousitunm("");
        bzFbHurikomiGoukeiListDataSourceBean3.setIrShrhousiteikbn(C_ShrhousiteiKbn.BLNK);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrGkgyoumucd(C_Gkgyoumucd.BLNK);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmsiteiymd("");
        bzFbHurikomiGoukeiListDataSourceBean3.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean3.setIrDenpyogkkei(BizCurrency.valueOf(0));


        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean1);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean2);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, bzGkFbHurikomiGoukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzFbHuriKomiGoukeiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBFURIKOMIKEI_1);

        bzGkFbHurikomiGoukeiListBean.setIrSyoriymd("平成28年12月29日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean1 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean2 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean3 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean4 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean5 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean6 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean7 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean8 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean9 = new BzGkFbHurikomiGoukeiListDataSourceBean();

        bzFbHurikomiGoukeiListDataSourceBean1.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean1.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzFbHurikomiGoukeiListDataSourceBean1.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzFbHurikomiGoukeiListDataSourceBean1.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzFbHurikomiGoukeiListDataSourceBean1.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean1.setIrHrkmkensu(BizNumber.valueOf(1000));
        bzFbHurikomiGoukeiListDataSourceBean1.setIrHrkmgkkei(BizCurrency.valueOf(2000));
        bzFbHurikomiGoukeiListDataSourceBean1.setIrDenpyogkkei(BizCurrency.valueOf(30000));

        bzFbHurikomiGoukeiListDataSourceBean2.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean2.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmkensu(BizNumber.valueOf(999));
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmgkkei(BizCurrency.valueOf(999));
        bzFbHurikomiGoukeiListDataSourceBean2.setIrDenpyogkkei(BizCurrency.valueOf(999));

        bzFbHurikomiGoukeiListDataSourceBean3.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean3.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmkensu(BizNumber.valueOf(9999));
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmgkkei(BizCurrency.valueOf(9999));
        bzFbHurikomiGoukeiListDataSourceBean3.setIrDenpyogkkei(BizCurrency.valueOf(9999));

        bzFbHurikomiGoukeiListDataSourceBean4.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean4.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean4.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzFbHurikomiGoukeiListDataSourceBean4.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzFbHurikomiGoukeiListDataSourceBean4.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean4.setIrHrkmkensu(BizNumber.valueOf(99999999999L));
        bzFbHurikomiGoukeiListDataSourceBean4.setIrHrkmgkkei(BizCurrency.valueOf(9999999999999.99));
        bzFbHurikomiGoukeiListDataSourceBean4.setIrDenpyogkkei(BizCurrency.valueOf(9999999999999L));

        bzFbHurikomiGoukeiListDataSourceBean5.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean5.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean5.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzFbHurikomiGoukeiListDataSourceBean5.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzFbHurikomiGoukeiListDataSourceBean5.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean5.setIrHrkmkensu(BizNumber.valueOf(1));
        bzFbHurikomiGoukeiListDataSourceBean5.setIrHrkmgkkei(BizCurrency.valueOf(9.1));
        bzFbHurikomiGoukeiListDataSourceBean5.setIrDenpyogkkei(BizCurrency.valueOf(9.1));

        bzFbHurikomiGoukeiListDataSourceBean6.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean6.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean6.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzFbHurikomiGoukeiListDataSourceBean6.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzFbHurikomiGoukeiListDataSourceBean6.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean6.setIrHrkmkensu(BizNumber.valueOf(1));
        bzFbHurikomiGoukeiListDataSourceBean6.setIrHrkmgkkei(BizCurrency.valueOf(9.22));
        bzFbHurikomiGoukeiListDataSourceBean6.setIrDenpyogkkei(BizCurrency.valueOf(9.22));

        bzFbHurikomiGoukeiListDataSourceBean7.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean7.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean7.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzFbHurikomiGoukeiListDataSourceBean7.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzFbHurikomiGoukeiListDataSourceBean7.setIrHrkmsiteiymd("平成30年 2月10日");
        bzFbHurikomiGoukeiListDataSourceBean7.setIrHrkmkensu(BizNumber.valueOf(1));
        bzFbHurikomiGoukeiListDataSourceBean7.setIrHrkmgkkei(BizCurrency.valueOf(9.333));
        bzFbHurikomiGoukeiListDataSourceBean7.setIrDenpyogkkei(BizCurrency.valueOf(9.333));

        bzFbHurikomiGoukeiListDataSourceBean8.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean8.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean8.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzFbHurikomiGoukeiListDataSourceBean8.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzFbHurikomiGoukeiListDataSourceBean8.setIrHrkmsiteiymd("平成30年 2月10日");
        bzFbHurikomiGoukeiListDataSourceBean8.setIrHrkmkensu(BizNumber.valueOf(1));
        bzFbHurikomiGoukeiListDataSourceBean8.setIrHrkmgkkei(BizCurrency.valueOf(9.333));
        bzFbHurikomiGoukeiListDataSourceBean8.setIrDenpyogkkei(BizCurrency.valueOf(9.333));

        bzFbHurikomiGoukeiListDataSourceBean9.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean9.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean9.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzFbHurikomiGoukeiListDataSourceBean9.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzFbHurikomiGoukeiListDataSourceBean9.setIrHrkmsiteiymd("平成30年 2月10日");
        bzFbHurikomiGoukeiListDataSourceBean9.setIrHrkmkensu(BizNumber.valueOf(1));
        bzFbHurikomiGoukeiListDataSourceBean9.setIrHrkmgkkei(BizCurrency.valueOf(9.333));
        bzFbHurikomiGoukeiListDataSourceBean9.setIrDenpyogkkei(BizCurrency.valueOf(9.333));

        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean1);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean2);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean3);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean4);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean5);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean6);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean7);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean8);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean9);

        reportTestBean.addParamObjects(dataSouceList, bzGkFbHurikomiGoukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzFbHuriKomiGoukeiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBFURIKOMIKEI_1);

        bzGkFbHurikomiGoukeiListBean.setIrSyoriymd("ＷＷ99年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean1 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean2 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean3 = new BzGkFbHurikomiGoukeiListDataSourceBean();

        bzFbHurikomiGoukeiListDataSourceBean1.setIrTantousitunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzFbHurikomiGoukeiListDataSourceBean1.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean1.setIrGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        bzFbHurikomiGoukeiListDataSourceBean1.setIrHrkmsiteiymd("ＷＷ99年99月99日");
        bzFbHurikomiGoukeiListDataSourceBean1.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzFbHurikomiGoukeiListDataSourceBean1.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean1.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean1.setIrDenpyogkkei(BizCurrency.valueOf(0));

        bzFbHurikomiGoukeiListDataSourceBean2.setIrTantousitunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzFbHurikomiGoukeiListDataSourceBean2.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmsiteiymd("ＷＷ99年99月99日");
        bzFbHurikomiGoukeiListDataSourceBean2.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean2.setIrDenpyogkkei(BizCurrency.valueOf(0));

        bzFbHurikomiGoukeiListDataSourceBean3.setIrTantousitunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzFbHurikomiGoukeiListDataSourceBean3.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmsiteiymd("ＷＷ99年99月99日");
        bzFbHurikomiGoukeiListDataSourceBean3.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean3.setIrDenpyogkkei(BizCurrency.valueOf(0));


        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean1);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean2);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, bzGkFbHurikomiGoukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzFbHuriKomiGoukeiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBFURIKOMIKEI_1);

        bzGkFbHurikomiGoukeiListBean.setIrSyoriymd("平成28年12月29日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean1 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean2 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean3 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean4 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean5 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean6 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean7 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean8 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean9 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean10 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean11 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean12 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean13 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean14 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean15 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean16 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean17 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean18 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean19 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean20 = new BzGkFbHurikomiGoukeiListDataSourceBean();
        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean21 = new BzGkFbHurikomiGoukeiListDataSourceBean();

        bzFbHurikomiGoukeiListDataSourceBean1.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean1.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzFbHurikomiGoukeiListDataSourceBean1.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        bzFbHurikomiGoukeiListDataSourceBean1.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean1.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzFbHurikomiGoukeiListDataSourceBean1.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean1.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean1.setIrDenpyogkkei(BizCurrency.valueOf(90000));

        bzFbHurikomiGoukeiListDataSourceBean2.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean2.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean2.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean2.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean2.setIrDenpyogkkei(BizCurrency.valueOf(0));

        bzFbHurikomiGoukeiListDataSourceBean3.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean3.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean3.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean3.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean3.setIrDenpyogkkei(BizCurrency.valueOf(0));

        bzFbHurikomiGoukeiListDataSourceBean4.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean4.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean4.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        bzFbHurikomiGoukeiListDataSourceBean4.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean4.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzFbHurikomiGoukeiListDataSourceBean4.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean4.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean4.setIrDenpyogkkei(BizCurrency.valueOf(9999999999999L));

        bzFbHurikomiGoukeiListDataSourceBean5.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean5.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean5.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        bzFbHurikomiGoukeiListDataSourceBean5.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean5.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzFbHurikomiGoukeiListDataSourceBean5.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean5.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean5.setIrDenpyogkkei(BizCurrency.valueOf(0));

        bzFbHurikomiGoukeiListDataSourceBean6.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean6.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean6.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        bzFbHurikomiGoukeiListDataSourceBean6.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean6.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzFbHurikomiGoukeiListDataSourceBean6.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean6.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean6.setIrDenpyogkkei(BizCurrency.valueOf(0));

        bzFbHurikomiGoukeiListDataSourceBean7.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean7.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean7.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        bzFbHurikomiGoukeiListDataSourceBean7.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean7.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzFbHurikomiGoukeiListDataSourceBean7.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean7.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean7.setIrDenpyogkkei(BizCurrency.valueOf(999));

        bzFbHurikomiGoukeiListDataSourceBean8.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean8.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean8.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        bzFbHurikomiGoukeiListDataSourceBean8.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean8.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzFbHurikomiGoukeiListDataSourceBean8.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean8.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean8.setIrDenpyogkkei(BizCurrency.valueOf(0));

        bzFbHurikomiGoukeiListDataSourceBean9.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean9.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean9.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        bzFbHurikomiGoukeiListDataSourceBean9.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean9.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzFbHurikomiGoukeiListDataSourceBean9.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean9.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean9.setIrDenpyogkkei(BizCurrency.valueOf(0));

        bzFbHurikomiGoukeiListDataSourceBean10.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean10.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean10.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        bzFbHurikomiGoukeiListDataSourceBean10.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean10.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzFbHurikomiGoukeiListDataSourceBean10.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean10.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean10.setIrDenpyogkkei(BizCurrency.valueOf(9999));

        bzFbHurikomiGoukeiListDataSourceBean11.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean11.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean11.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        bzFbHurikomiGoukeiListDataSourceBean11.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean11.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzFbHurikomiGoukeiListDataSourceBean11.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean11.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean11.setIrDenpyogkkei(BizCurrency.valueOf(0));

        bzFbHurikomiGoukeiListDataSourceBean12.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean12.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean12.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        bzFbHurikomiGoukeiListDataSourceBean12.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbHurikomiGoukeiListDataSourceBean12.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzFbHurikomiGoukeiListDataSourceBean12.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean12.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean12.setIrDenpyogkkei(BizCurrency.valueOf(0));

        bzFbHurikomiGoukeiListDataSourceBean13.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean13.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean13.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        bzFbHurikomiGoukeiListDataSourceBean13.setIrHrkmsiteiymd("平成30年 1月11日");
        bzFbHurikomiGoukeiListDataSourceBean13.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzFbHurikomiGoukeiListDataSourceBean13.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean13.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean13.setIrDenpyogkkei(BizCurrency.valueOf(9.1));

        bzFbHurikomiGoukeiListDataSourceBean14.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean14.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean14.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        bzFbHurikomiGoukeiListDataSourceBean14.setIrHrkmsiteiymd("平成30年 1月11日");
        bzFbHurikomiGoukeiListDataSourceBean14.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzFbHurikomiGoukeiListDataSourceBean14.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean14.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean14.setIrDenpyogkkei(BizCurrency.valueOf(0));

        bzFbHurikomiGoukeiListDataSourceBean15.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean15.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean15.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        bzFbHurikomiGoukeiListDataSourceBean15.setIrHrkmsiteiymd("平成30年 1月11日");
        bzFbHurikomiGoukeiListDataSourceBean15.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzFbHurikomiGoukeiListDataSourceBean15.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean15.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean15.setIrDenpyogkkei(BizCurrency.valueOf(0));

        bzFbHurikomiGoukeiListDataSourceBean16.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean16.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean16.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        bzFbHurikomiGoukeiListDataSourceBean16.setIrHrkmsiteiymd("平成30年 1月12日");
        bzFbHurikomiGoukeiListDataSourceBean16.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzFbHurikomiGoukeiListDataSourceBean16.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean16.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean16.setIrDenpyogkkei(BizCurrency.valueOf(9.22));

        bzFbHurikomiGoukeiListDataSourceBean17.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean17.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean17.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        bzFbHurikomiGoukeiListDataSourceBean17.setIrHrkmsiteiymd("平成30年 1月12日");
        bzFbHurikomiGoukeiListDataSourceBean17.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzFbHurikomiGoukeiListDataSourceBean17.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean17.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean17.setIrDenpyogkkei(BizCurrency.valueOf(0));

        bzFbHurikomiGoukeiListDataSourceBean18.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean18.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean18.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        bzFbHurikomiGoukeiListDataSourceBean18.setIrHrkmsiteiymd("平成30年 1月12日");
        bzFbHurikomiGoukeiListDataSourceBean18.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzFbHurikomiGoukeiListDataSourceBean18.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean18.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean18.setIrDenpyogkkei(BizCurrency.valueOf(0));

        bzFbHurikomiGoukeiListDataSourceBean19.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean19.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean19.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        bzFbHurikomiGoukeiListDataSourceBean19.setIrHrkmsiteiymd("平成30年 1月13日");
        bzFbHurikomiGoukeiListDataSourceBean19.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzFbHurikomiGoukeiListDataSourceBean19.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean19.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean19.setIrDenpyogkkei(BizCurrency.valueOf(9.333));

        bzFbHurikomiGoukeiListDataSourceBean20.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean20.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean20.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        bzFbHurikomiGoukeiListDataSourceBean20.setIrHrkmsiteiymd("平成30年 1月13日");
        bzFbHurikomiGoukeiListDataSourceBean20.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzFbHurikomiGoukeiListDataSourceBean20.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean20.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean20.setIrDenpyogkkei(BizCurrency.valueOf(0));

        bzFbHurikomiGoukeiListDataSourceBean21.setIrTantousitunm("万事屋");
        bzFbHurikomiGoukeiListDataSourceBean21.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbHurikomiGoukeiListDataSourceBean21.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
        bzFbHurikomiGoukeiListDataSourceBean21.setIrHrkmsiteiymd("平成30年 1月13日");
        bzFbHurikomiGoukeiListDataSourceBean21.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzFbHurikomiGoukeiListDataSourceBean21.setIrHrkmkensu(BizNumber.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean21.setIrHrkmgkkei(BizCurrency.valueOf(0));
        bzFbHurikomiGoukeiListDataSourceBean21.setIrDenpyogkkei(BizCurrency.valueOf(0));

        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean1);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean2);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean3);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean4);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean5);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean6);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean7);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean8);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean9);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean10);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean11);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean12);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean13);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean14);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean15);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean16);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean17);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean18);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean19);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean20);
        dataSouceList.add(bzFbHurikomiGoukeiListDataSourceBean21);

        for(int i = 1;i <9993;i++){

            BzGkFbHurikomiGoukeiListDataSourceBean bzGkFbHurikomiGoukeiListDataSourceBean = new BzGkFbHurikomiGoukeiListDataSourceBean();

            if(i%2 == 1 ){

                bzGkFbHurikomiGoukeiListDataSourceBean.setIrTantousitunm("万事屋");
                bzGkFbHurikomiGoukeiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
                bzGkFbHurikomiGoukeiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
                bzGkFbHurikomiGoukeiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
                bzGkFbHurikomiGoukeiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
                bzGkFbHurikomiGoukeiListDataSourceBean.setIrHrkmkensu(BizNumber.valueOf(0));
                bzGkFbHurikomiGoukeiListDataSourceBean.setIrHrkmgkkei(BizCurrency.valueOf(0));
                bzGkFbHurikomiGoukeiListDataSourceBean.setIrDenpyogkkei(BizCurrency.valueOf(0));
            }

            else{

                bzGkFbHurikomiGoukeiListDataSourceBean.setIrTantousitunm("万事屋");
                bzGkFbHurikomiGoukeiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
                bzGkFbHurikomiGoukeiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
                bzGkFbHurikomiGoukeiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
                bzGkFbHurikomiGoukeiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
                bzGkFbHurikomiGoukeiListDataSourceBean.setIrHrkmkensu(BizNumber.valueOf(0));
                bzGkFbHurikomiGoukeiListDataSourceBean.setIrHrkmgkkei(BizCurrency.valueOf(0));
                bzGkFbHurikomiGoukeiListDataSourceBean.setIrDenpyogkkei(BizCurrency.valueOf(0));
            }
            dataSouceList.add(bzGkFbHurikomiGoukeiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzGkFbHurikomiGoukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzFbHuriKomiGoukeiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBFURIKOMIKEI_1);

        bzGkFbHurikomiGoukeiListBean.setIrSyoriymd("平成28年12月29日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, bzGkFbHurikomiGoukeiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
