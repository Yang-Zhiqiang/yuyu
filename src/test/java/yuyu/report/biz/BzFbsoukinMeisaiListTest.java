package yuyu.report.biz;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzFbSoukinMeisaiListBean;
import yuyu.def.biz.bean.report.BzFbSoukinMeisaiListDataSourceBean;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_YokinKbn;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＦＢ送金明細リスト帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzFbsoukinMeisaiListTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzFbSoukinMeisaiListBean bzFbSoukinMeisaiListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzOnlineFbsouKinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_2);

        bzFbSoukinMeisaiListBean.setIrSyoriymd(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 33; i++) {
            BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean = new BzFbSoukinMeisaiListDataSourceBean();

            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitunm(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
            bzFbSoukinMeisaiListDataSourceBean.setIrGyoumucd(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrKokyakucd(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrBankcd(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrSitencd(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrYokinkbn(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrKouzano(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrKznmkn(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrSyono(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingk(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingkkei(null);

            dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzOnlineFbsouKinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_2);

        bzFbSoukinMeisaiListBean.setIrSyoriymd("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 35; i++) {
            BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean = new BzFbSoukinMeisaiListDataSourceBean();

            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SYUUNOUSV);
            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("");
            bzFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
            bzFbSoukinMeisaiListDataSourceBean.setIrGyoumucd(C_Gyoumucd.BLNK);
            bzFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("");
            bzFbSoukinMeisaiListDataSourceBean.setIrKokyakucd("");
            bzFbSoukinMeisaiListDataSourceBean.setIrBankcd("");
            bzFbSoukinMeisaiListDataSourceBean.setIrSitencd("");
            bzFbSoukinMeisaiListDataSourceBean.setIrYokinkbn(C_YokinKbn.BLNK);
            bzFbSoukinMeisaiListDataSourceBean.setIrKouzano("");
            bzFbSoukinMeisaiListDataSourceBean.setIrKznmkn("");
            bzFbSoukinMeisaiListDataSourceBean.setIrSyono("");
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(0));
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingkkei(BizCurrency.valueOf(0));

            dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzOnlineFbsouKinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_2);

        bzFbSoukinMeisaiListBean.setIrSyoriymd("平成28年12月29日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 35; i++) {
            BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean = new BzFbSoukinMeisaiListDataSourceBean();

            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SYUUNOUSV);
            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("担当室名");
            bzFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
            bzFbSoukinMeisaiListDataSourceBean.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
            bzFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzFbSoukinMeisaiListDataSourceBean.setIrKokyakucd("1234567890");
            bzFbSoukinMeisaiListDataSourceBean.setIrBankcd("1234");
            bzFbSoukinMeisaiListDataSourceBean.setIrSitencd("123");
            bzFbSoukinMeisaiListDataSourceBean.setIrYokinkbn(C_YokinKbn.BETUDAN);
            bzFbSoukinMeisaiListDataSourceBean.setIrKouzano("1234567");
            bzFbSoukinMeisaiListDataSourceBean.setIrKznmkn("カナ");
            bzFbSoukinMeisaiListDataSourceBean.setIrSyono("10000000001");
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(9999));
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingkkei(BizCurrency.valueOf(9999));

            dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzOnlineFbsouKinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_2);

        bzFbSoukinMeisaiListBean.setIrSyoriymd("ＷＷ99年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 35; i++) {
            BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean = new BzFbSoukinMeisaiListDataSourceBean();

            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SYUUNOUSV);
            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
            bzFbSoukinMeisaiListDataSourceBean.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
            bzFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("ＷＷ99年99月99日");
            bzFbSoukinMeisaiListDataSourceBean.setIrKokyakucd("wwwwwwwwww");
            bzFbSoukinMeisaiListDataSourceBean.setIrBankcd("wwww");
            bzFbSoukinMeisaiListDataSourceBean.setIrSitencd("www");
            bzFbSoukinMeisaiListDataSourceBean.setIrYokinkbn(C_YokinKbn.BETUDAN);
            bzFbSoukinMeisaiListDataSourceBean.setIrKouzano("wwwwwww");
            bzFbSoukinMeisaiListDataSourceBean.setIrKznmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzFbSoukinMeisaiListDataSourceBean.setIrSyono("wwwwwwwwwww");
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(999999999999L));
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingkkei(BizCurrency.valueOf(999999999999L));

            dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzOnlineFbsouKinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_2);

        bzFbSoukinMeisaiListBean.setIrSyoriymd("ＷＷ99年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();


        for (int i = 0; i < 100000; i++) {
            BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean = new BzFbSoukinMeisaiListDataSourceBean();

            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SYUUNOUSV);
            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
            bzFbSoukinMeisaiListDataSourceBean.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
            bzFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("ＷＷ99年99月99日");
            bzFbSoukinMeisaiListDataSourceBean.setIrKokyakucd("wwwwwwwwww");
            bzFbSoukinMeisaiListDataSourceBean.setIrBankcd("wwww");
            bzFbSoukinMeisaiListDataSourceBean.setIrSitencd("www");
            bzFbSoukinMeisaiListDataSourceBean.setIrYokinkbn(C_YokinKbn.BETUDAN);
            bzFbSoukinMeisaiListDataSourceBean.setIrKouzano("wwwwwww");
            bzFbSoukinMeisaiListDataSourceBean.setIrKznmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzFbSoukinMeisaiListDataSourceBean.setIrSyono("wwwwwwwwwww");
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(0));
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingkkei(BizCurrency.valueOf(0));

            dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzOnlineFbsouKinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_2);

        bzFbSoukinMeisaiListBean.setIrSyoriymd("平成28年12月29日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 35; i++) {
            BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean = new BzFbSoukinMeisaiListDataSourceBean();

            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SYUUNOUSV);
            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("担当室名");
            bzFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
            bzFbSoukinMeisaiListDataSourceBean.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
            bzFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzFbSoukinMeisaiListDataSourceBean.setIrKokyakucd("1234567890");
            bzFbSoukinMeisaiListDataSourceBean.setIrBankcd("1234");
            bzFbSoukinMeisaiListDataSourceBean.setIrSitencd("123");
            bzFbSoukinMeisaiListDataSourceBean.setIrYokinkbn(C_YokinKbn.BETUDAN);
            bzFbSoukinMeisaiListDataSourceBean.setIrKouzano("1234567");
            bzFbSoukinMeisaiListDataSourceBean.setIrKznmkn("カナ");
            bzFbSoukinMeisaiListDataSourceBean.setIrSyono("10000000001");
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(999));
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingkkei(BizCurrency.valueOf(999));

            dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzOnlineFbsouKinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_2);

        bzFbSoukinMeisaiListBean.setIrSyoriymd("平成28年12月29日");

        reportTestBean.addParamObjects( bzFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzOnlineFbsouKinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_2);

        bzFbSoukinMeisaiListBean.setIrSyoriymd("平成28年12月29日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 9999; i++) {
            BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean = new BzFbSoukinMeisaiListDataSourceBean();

            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SYUUNOUSV);
            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("担当室名");
            bzFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
            bzFbSoukinMeisaiListDataSourceBean.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
            bzFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzFbSoukinMeisaiListDataSourceBean.setIrKokyakucd("1234567890");
            bzFbSoukinMeisaiListDataSourceBean.setIrBankcd("1234");
            bzFbSoukinMeisaiListDataSourceBean.setIrSitencd("123");
            bzFbSoukinMeisaiListDataSourceBean.setIrYokinkbn(C_YokinKbn.BETUDAN);
            bzFbSoukinMeisaiListDataSourceBean.setIrKouzano("1234567");
            bzFbSoukinMeisaiListDataSourceBean.setIrKznmkn("カナ");
            bzFbSoukinMeisaiListDataSourceBean.setIrSyono("10000000001");
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingkkei(BizCurrency.valueOf(1));

            dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzOnlineFbsouKinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_2);

        bzFbSoukinMeisaiListBean.setIrSyoriymd("平成28年12月29日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 999; i++) {
            BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean = new BzFbSoukinMeisaiListDataSourceBean();

            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SYUUNOUSV);
            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("担当室名");
            bzFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
            bzFbSoukinMeisaiListDataSourceBean.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
            bzFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzFbSoukinMeisaiListDataSourceBean.setIrKokyakucd("1234567890");
            bzFbSoukinMeisaiListDataSourceBean.setIrBankcd("1234");
            bzFbSoukinMeisaiListDataSourceBean.setIrSitencd("123");
            bzFbSoukinMeisaiListDataSourceBean.setIrYokinkbn(C_YokinKbn.BETUDAN);
            bzFbSoukinMeisaiListDataSourceBean.setIrKouzano("1234567");
            bzFbSoukinMeisaiListDataSourceBean.setIrKznmkn("カナ");
            bzFbSoukinMeisaiListDataSourceBean.setIrSyono("10000000001");
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingkkei(BizCurrency.valueOf(1));

            dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzOnlineFbsouKinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_2);

        bzFbSoukinMeisaiListBean.setIrSyoriymd("平成28年12月29日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean = new BzFbSoukinMeisaiListDataSourceBean();

        bzFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SYUUNOUSV);
        bzFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("担当室名");
        bzFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbSoukinMeisaiListDataSourceBean.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
        bzFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbSoukinMeisaiListDataSourceBean.setIrKokyakucd("1234567890");
        bzFbSoukinMeisaiListDataSourceBean.setIrBankcd("1234");
        bzFbSoukinMeisaiListDataSourceBean.setIrSitencd("123");
        bzFbSoukinMeisaiListDataSourceBean.setIrYokinkbn(C_YokinKbn.BETUDAN);
        bzFbSoukinMeisaiListDataSourceBean.setIrKouzano("1234567");
        bzFbSoukinMeisaiListDataSourceBean.setIrKznmkn("カナ");
        bzFbSoukinMeisaiListDataSourceBean.setIrSyono("10000000001");
        bzFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(999999999999L));
        bzFbSoukinMeisaiListDataSourceBean.setIrSoukingkkei(BizCurrency.valueOf(999999999999L));

        dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzOnlineFbsouKinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_2);

        bzFbSoukinMeisaiListBean.setIrSyoriymd("平成28年12月29日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 99999; i++) {
            BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean = new BzFbSoukinMeisaiListDataSourceBean();

            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SYUUNOUSV);
            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("担当室名");
            bzFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
            bzFbSoukinMeisaiListDataSourceBean.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
            bzFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzFbSoukinMeisaiListDataSourceBean.setIrKokyakucd("1234567890");
            bzFbSoukinMeisaiListDataSourceBean.setIrBankcd("1234");
            bzFbSoukinMeisaiListDataSourceBean.setIrSitencd("123");
            bzFbSoukinMeisaiListDataSourceBean.setIrYokinkbn(C_YokinKbn.BETUDAN);
            bzFbSoukinMeisaiListDataSourceBean.setIrKouzano("1234567");
            bzFbSoukinMeisaiListDataSourceBean.setIrKznmkn("カナ");
            bzFbSoukinMeisaiListDataSourceBean.setIrSyono("10000000001");
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingkkei(BizCurrency.valueOf(1));

            dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzOnlineFbsouKinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_2);

        bzFbSoukinMeisaiListBean.setIrSyoriymd("平成28年12月29日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 33; i++) {
            BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean = new BzFbSoukinMeisaiListDataSourceBean();

            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SYUUNOUSV);
            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("担当室名");
            bzFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
            bzFbSoukinMeisaiListDataSourceBean.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
            bzFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzFbSoukinMeisaiListDataSourceBean.setIrKokyakucd("1234567890");
            bzFbSoukinMeisaiListDataSourceBean.setIrBankcd("1234");
            bzFbSoukinMeisaiListDataSourceBean.setIrSitencd("123");
            bzFbSoukinMeisaiListDataSourceBean.setIrYokinkbn(C_YokinKbn.BETUDAN);
            bzFbSoukinMeisaiListDataSourceBean.setIrKouzano("1234567");
            bzFbSoukinMeisaiListDataSourceBean.setIrKznmkn("カナ");
            bzFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000001L + i));
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingkkei(BizCurrency.valueOf(1));

            dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzOnlineFbsouKinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_2);

        bzFbSoukinMeisaiListBean.setIrSyoriymd("平成28年12月29日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 34; i++) {
            BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean = new BzFbSoukinMeisaiListDataSourceBean();

            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SYUUNOUSV);
            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("担当室名");
            bzFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
            bzFbSoukinMeisaiListDataSourceBean.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
            bzFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzFbSoukinMeisaiListDataSourceBean.setIrKokyakucd("1234567890");
            bzFbSoukinMeisaiListDataSourceBean.setIrBankcd("1234");
            bzFbSoukinMeisaiListDataSourceBean.setIrSitencd("123");
            bzFbSoukinMeisaiListDataSourceBean.setIrYokinkbn(C_YokinKbn.BETUDAN);
            bzFbSoukinMeisaiListDataSourceBean.setIrKouzano("1234567");
            bzFbSoukinMeisaiListDataSourceBean.setIrKznmkn("カナ");
            bzFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000001L + i));
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingkkei(BizCurrency.valueOf(1));

            dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzOnlineFbsouKinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_2);

        bzFbSoukinMeisaiListBean.setIrSyoriymd("平成28年12月29日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 35; i++) {
            BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean = new BzFbSoukinMeisaiListDataSourceBean();

            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SYUUNOUSV);
            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("担当室名");
            bzFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
            bzFbSoukinMeisaiListDataSourceBean.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
            bzFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzFbSoukinMeisaiListDataSourceBean.setIrKokyakucd("1234567890");
            bzFbSoukinMeisaiListDataSourceBean.setIrBankcd("1234");
            bzFbSoukinMeisaiListDataSourceBean.setIrSitencd("123");
            bzFbSoukinMeisaiListDataSourceBean.setIrYokinkbn(C_YokinKbn.BETUDAN);
            bzFbSoukinMeisaiListDataSourceBean.setIrKouzano("1234567");
            bzFbSoukinMeisaiListDataSourceBean.setIrKznmkn("カナ");
            bzFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000001L + i));
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingkkei(BizCurrency.valueOf(1));

            dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzOnlineFbsouKinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_2);

        bzFbSoukinMeisaiListBean.setIrSyoriymd("平成28年12月29日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 36; i++) {
            BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean = new BzFbSoukinMeisaiListDataSourceBean();

            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SYUUNOUSV);
            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("担当室名");
            bzFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
            bzFbSoukinMeisaiListDataSourceBean.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
            bzFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzFbSoukinMeisaiListDataSourceBean.setIrKokyakucd("1234567890");
            bzFbSoukinMeisaiListDataSourceBean.setIrBankcd("1234");
            bzFbSoukinMeisaiListDataSourceBean.setIrSitencd("123");
            bzFbSoukinMeisaiListDataSourceBean.setIrYokinkbn(C_YokinKbn.BETUDAN);
            bzFbSoukinMeisaiListDataSourceBean.setIrKouzano("1234567");
            bzFbSoukinMeisaiListDataSourceBean.setIrKznmkn("カナ");
            bzFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000001L + i));
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingkkei(BizCurrency.valueOf(1));

            dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzOnlineFbsouKinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_2);

        bzFbSoukinMeisaiListBean.setIrSyoriymd("平成28年12月29日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 3; i++) {
            BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean = new BzFbSoukinMeisaiListDataSourceBean();

            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SYUUNOUSV);
            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("担当室名");
            bzFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
            bzFbSoukinMeisaiListDataSourceBean.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
            bzFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzFbSoukinMeisaiListDataSourceBean.setIrKokyakucd("1234567890");
            bzFbSoukinMeisaiListDataSourceBean.setIrBankcd("1234");
            bzFbSoukinMeisaiListDataSourceBean.setIrSitencd("123");
            bzFbSoukinMeisaiListDataSourceBean.setIrYokinkbn(C_YokinKbn.BETUDAN);
            bzFbSoukinMeisaiListDataSourceBean.setIrKouzano("1234567");
            bzFbSoukinMeisaiListDataSourceBean.setIrKznmkn("カナ");
            bzFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000001L + i));
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingkkei(BizCurrency.valueOf(1));

            dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzOnlineFbsouKinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_2);

        bzFbSoukinMeisaiListBean.setIrSyoriymd("平成28年12月29日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean1 = new BzFbSoukinMeisaiListDataSourceBean();
        BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean2 = new BzFbSoukinMeisaiListDataSourceBean();
        BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean3 = new BzFbSoukinMeisaiListDataSourceBean();
        BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean4 = new BzFbSoukinMeisaiListDataSourceBean();
        BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean5 = new BzFbSoukinMeisaiListDataSourceBean();
        BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean6 = new BzFbSoukinMeisaiListDataSourceBean();
        BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean7 = new BzFbSoukinMeisaiListDataSourceBean();

        bzFbSoukinMeisaiListDataSourceBean1.setIrTantousitucd(C_Tantositucd.SYUUNOUSV);
        bzFbSoukinMeisaiListDataSourceBean1.setIrTantousitunm("担当室名");
        bzFbSoukinMeisaiListDataSourceBean1.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzFbSoukinMeisaiListDataSourceBean1.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
        bzFbSoukinMeisaiListDataSourceBean1.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbSoukinMeisaiListDataSourceBean1.setIrKokyakucd("1234567890");
        bzFbSoukinMeisaiListDataSourceBean1.setIrBankcd("1234");
        bzFbSoukinMeisaiListDataSourceBean1.setIrSitencd("123");
        bzFbSoukinMeisaiListDataSourceBean1.setIrYokinkbn(C_YokinKbn.BETUDAN);
        bzFbSoukinMeisaiListDataSourceBean1.setIrKouzano("1234567");
        bzFbSoukinMeisaiListDataSourceBean1.setIrKznmkn("カナ");
        bzFbSoukinMeisaiListDataSourceBean1.setIrSyono("10000000001");
        bzFbSoukinMeisaiListDataSourceBean1.setIrSoukingk(BizCurrency.valueOf(1));
        bzFbSoukinMeisaiListDataSourceBean1.setIrSoukingkkei(BizCurrency.valueOf(1));

        bzFbSoukinMeisaiListDataSourceBean2.setIrTantousitucd(C_Tantositucd.SYUUNOUSV);
        bzFbSoukinMeisaiListDataSourceBean2.setIrTantousitunm("担当室名");
        bzFbSoukinMeisaiListDataSourceBean2.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzFbSoukinMeisaiListDataSourceBean2.setIrGyoumucd(C_Gyoumucd.KHSISIHARAIYOKUEI);
        bzFbSoukinMeisaiListDataSourceBean2.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbSoukinMeisaiListDataSourceBean2.setIrKokyakucd("1234567890");
        bzFbSoukinMeisaiListDataSourceBean2.setIrBankcd("1234");
        bzFbSoukinMeisaiListDataSourceBean2.setIrSitencd("123");
        bzFbSoukinMeisaiListDataSourceBean2.setIrYokinkbn(C_YokinKbn.BETUDAN);
        bzFbSoukinMeisaiListDataSourceBean2.setIrKouzano("1234567");
        bzFbSoukinMeisaiListDataSourceBean2.setIrKznmkn("カナ");
        bzFbSoukinMeisaiListDataSourceBean2.setIrSyono("10000000002");
        bzFbSoukinMeisaiListDataSourceBean2.setIrSoukingk(BizCurrency.valueOf(1));
        bzFbSoukinMeisaiListDataSourceBean2.setIrSoukingkkei(BizCurrency.valueOf(1));

        bzFbSoukinMeisaiListDataSourceBean3.setIrTantousitucd(C_Tantositucd.SYUUNOUSV);
        bzFbSoukinMeisaiListDataSourceBean3.setIrTantousitunm("担当室名");
        bzFbSoukinMeisaiListDataSourceBean3.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzFbSoukinMeisaiListDataSourceBean3.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
        bzFbSoukinMeisaiListDataSourceBean3.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbSoukinMeisaiListDataSourceBean3.setIrKokyakucd("1234567890");
        bzFbSoukinMeisaiListDataSourceBean3.setIrBankcd("1234");
        bzFbSoukinMeisaiListDataSourceBean3.setIrSitencd("123");
        bzFbSoukinMeisaiListDataSourceBean3.setIrYokinkbn(C_YokinKbn.BETUDAN);
        bzFbSoukinMeisaiListDataSourceBean3.setIrKouzano("1234567");
        bzFbSoukinMeisaiListDataSourceBean3.setIrKznmkn("カナ");
        bzFbSoukinMeisaiListDataSourceBean3.setIrSyono("10000000003");
        bzFbSoukinMeisaiListDataSourceBean3.setIrSoukingk(BizCurrency.valueOf(1));
        bzFbSoukinMeisaiListDataSourceBean3.setIrSoukingkkei(BizCurrency.valueOf(1));

        bzFbSoukinMeisaiListDataSourceBean4.setIrTantousitucd(C_Tantositucd.SYUUNOUSV);
        bzFbSoukinMeisaiListDataSourceBean4.setIrTantousitunm("担当室名");
        bzFbSoukinMeisaiListDataSourceBean4.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbSoukinMeisaiListDataSourceBean4.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
        bzFbSoukinMeisaiListDataSourceBean4.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbSoukinMeisaiListDataSourceBean4.setIrKokyakucd("1234567890");
        bzFbSoukinMeisaiListDataSourceBean4.setIrBankcd("1234");
        bzFbSoukinMeisaiListDataSourceBean4.setIrSitencd("123");
        bzFbSoukinMeisaiListDataSourceBean4.setIrYokinkbn(C_YokinKbn.BETUDAN);
        bzFbSoukinMeisaiListDataSourceBean4.setIrKouzano("1234567");
        bzFbSoukinMeisaiListDataSourceBean4.setIrKznmkn("カナ");
        bzFbSoukinMeisaiListDataSourceBean4.setIrSyono("10000000004");
        bzFbSoukinMeisaiListDataSourceBean4.setIrSoukingk(BizCurrency.valueOf(1));
        bzFbSoukinMeisaiListDataSourceBean4.setIrSoukingkkei(BizCurrency.valueOf(1));

        bzFbSoukinMeisaiListDataSourceBean5.setIrTantousitucd(C_Tantositucd.GYOUMUSINSA);
        bzFbSoukinMeisaiListDataSourceBean5.setIrTantousitunm("担当室名");
        bzFbSoukinMeisaiListDataSourceBean5.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbSoukinMeisaiListDataSourceBean5.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
        bzFbSoukinMeisaiListDataSourceBean5.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbSoukinMeisaiListDataSourceBean5.setIrKokyakucd("1234567890");
        bzFbSoukinMeisaiListDataSourceBean5.setIrBankcd("1234");
        bzFbSoukinMeisaiListDataSourceBean5.setIrSitencd("123");
        bzFbSoukinMeisaiListDataSourceBean5.setIrYokinkbn(C_YokinKbn.BETUDAN);
        bzFbSoukinMeisaiListDataSourceBean5.setIrKouzano("1234567");
        bzFbSoukinMeisaiListDataSourceBean5.setIrKznmkn("カナ");
        bzFbSoukinMeisaiListDataSourceBean5.setIrSyono("10000000005");
        bzFbSoukinMeisaiListDataSourceBean5.setIrSoukingk(BizCurrency.valueOf(1));
        bzFbSoukinMeisaiListDataSourceBean5.setIrSoukingkkei(BizCurrency.valueOf(1));

        bzFbSoukinMeisaiListDataSourceBean6.setIrTantousitucd(C_Tantositucd.GYOUMUSINSA);
        bzFbSoukinMeisaiListDataSourceBean6.setIrTantousitunm("担当室名");
        bzFbSoukinMeisaiListDataSourceBean6.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbSoukinMeisaiListDataSourceBean6.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
        bzFbSoukinMeisaiListDataSourceBean6.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbSoukinMeisaiListDataSourceBean6.setIrKokyakucd("1234567890");
        bzFbSoukinMeisaiListDataSourceBean6.setIrBankcd("1234");
        bzFbSoukinMeisaiListDataSourceBean6.setIrSitencd("123");
        bzFbSoukinMeisaiListDataSourceBean6.setIrYokinkbn(C_YokinKbn.BETUDAN);
        bzFbSoukinMeisaiListDataSourceBean6.setIrKouzano("1234567");
        bzFbSoukinMeisaiListDataSourceBean6.setIrKznmkn("カナ");
        bzFbSoukinMeisaiListDataSourceBean6.setIrSyono("10000000006");
        bzFbSoukinMeisaiListDataSourceBean6.setIrSoukingk(BizCurrency.valueOf(1));
        bzFbSoukinMeisaiListDataSourceBean6.setIrSoukingkkei(BizCurrency.valueOf(1));
        bzFbSoukinMeisaiListDataSourceBean6.setIrSoukinhukabank("【送金不可銀行分】");

        bzFbSoukinMeisaiListDataSourceBean7.setIrTantousitucd(C_Tantositucd.GYOUMUSINSA);
        bzFbSoukinMeisaiListDataSourceBean7.setIrTantousitunm("担当室名");
        bzFbSoukinMeisaiListDataSourceBean7.setIrShrhousiteikbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        bzFbSoukinMeisaiListDataSourceBean7.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
        bzFbSoukinMeisaiListDataSourceBean7.setIrHrkmsiteiymd("平成30年 1月10日");
        bzFbSoukinMeisaiListDataSourceBean7.setIrKokyakucd("1234567890");
        bzFbSoukinMeisaiListDataSourceBean7.setIrBankcd("1234");
        bzFbSoukinMeisaiListDataSourceBean7.setIrSitencd("123");
        bzFbSoukinMeisaiListDataSourceBean7.setIrYokinkbn(C_YokinKbn.BETUDAN);
        bzFbSoukinMeisaiListDataSourceBean7.setIrKouzano("1234567");
        bzFbSoukinMeisaiListDataSourceBean7.setIrKznmkn("カナ");
        bzFbSoukinMeisaiListDataSourceBean7.setIrSyono("10000000007");
        bzFbSoukinMeisaiListDataSourceBean7.setIrSoukingk(BizCurrency.valueOf(1));
        bzFbSoukinMeisaiListDataSourceBean7.setIrSoukingkkei(BizCurrency.valueOf(1));
        bzFbSoukinMeisaiListDataSourceBean7.setIrSoukinhukabank("【送金不可銀行分】");

        dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean1);
        dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean2);
        dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean3);
        dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean4);
        dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean5);
        dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean6);
        dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean7);

        reportTestBean.addParamObjects(dataSouceList, bzFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzOnlineFbsouKinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_2);

        bzFbSoukinMeisaiListBean.setIrSyoriymd("平成28年12月29日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i < 10000; i++) {
            BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean = new BzFbSoukinMeisaiListDataSourceBean();

            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SYUUNOUSV);
            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("担当室名");
            if (i%2 == 0) {
                bzFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
            }
            else {
                bzFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
            }
            bzFbSoukinMeisaiListDataSourceBean.setIrGyoumucd(C_Gyoumucd.KHSISIHARAI2EIGO);
            bzFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzFbSoukinMeisaiListDataSourceBean.setIrKokyakucd("1234567890");
            bzFbSoukinMeisaiListDataSourceBean.setIrBankcd("1234");
            bzFbSoukinMeisaiListDataSourceBean.setIrSitencd("123");
            bzFbSoukinMeisaiListDataSourceBean.setIrYokinkbn(C_YokinKbn.BETUDAN);
            bzFbSoukinMeisaiListDataSourceBean.setIrKouzano("1234567");
            bzFbSoukinMeisaiListDataSourceBean.setIrKznmkn("カナ");
            bzFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000000L + i));
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1111));
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingkkei(BizCurrency.valueOf(2222));

            dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzOnlineFbsouKinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_FBSOUKINMEISAI_2);

        bzFbSoukinMeisaiListBean.setIrSyoriymd(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 33; i++) {
            BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean = new BzFbSoukinMeisaiListDataSourceBean();

            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitunm(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrGyoumucd(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrKokyakucd(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrBankcd(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrSitencd(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrYokinkbn(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrKouzano(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrKznmkn(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrSyono(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingk(null);
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingkkei(null);

            dataSouceList.add(bzFbSoukinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}