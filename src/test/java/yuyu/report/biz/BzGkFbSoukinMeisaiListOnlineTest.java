package yuyu.report.biz;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzGkOnlineFbSoukinMeisaiListBean;
import yuyu.def.biz.bean.report.BzGkOnlineFbSoukinMeisaiListDataSourceBean;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * オンライン外貨ＦＢ送金明細リスト帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzGkFbSoukinMeisaiListOnlineTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzGkOnlineFbSoukinMeisaiListBean bzGkOnlineFbSoukinMeisaiListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBSOUKINMEISAI_2);

        bzGkOnlineFbSoukinMeisaiListBean.setIrSyoriymd(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();

        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(null);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitunm(null);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(null);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(null);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd(null);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd(null);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBankcd(null);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBanknmej(null);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitencd(null);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitennmej(null);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKouzano(null);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej(null);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyono(null);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(0));
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorinm(null);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorisosikicd(null);

        dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzGkOnlineFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBSOUKINMEISAI_2);

        bzGkOnlineFbSoukinMeisaiListBean.setIrSyoriymd("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();

        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.BLNK0);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.BLNK);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.BLNK);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd("");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBankcd("");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBanknmej("");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitencd("");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitennmej("");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKouzano("");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyono("");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(0));
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorinm("");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorisosikicd("");


        dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzGkOnlineFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBSOUKINMEISAI_2);

        bzGkOnlineFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean1 = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
        BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean3 = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
        BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean4 = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
        BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean5 = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
        BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean6 = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
        BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean7 = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();

        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrTantousitunm("万事屋");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrHrkmsiteiymd("平成30年 1月10日");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrGkkokyakucd("1234567890123");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrBankcd("1111");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrBanknmej("ＢＡＮＫ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrSitencd("222");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrSitennmej("ＳＴＯＲＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrKouzano("9876543210");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrSyono("10000000001");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrSoukingk(BizCurrency.valueOf(1000));
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrSyorinm("処理名");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrSyorisosikicd("1236547");

        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrTantousitunm("万事屋");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrHrkmsiteiymd("平成30年 1月10日");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrGkkokyakucd("1234567890123");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrBankcd("1111");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrBanknmej("ＢＡＮＫ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrSitencd("222");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrSitennmej("ＳＴＯＲＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrKouzano("9876543210");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrSyono("10000000003");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrSoukingk(BizCurrency.valueOf(999));
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrSyorinm("処理名");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrSyorisosikicd("1236547");

        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrTantousitunm("万事屋");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrHrkmsiteiymd("平成30年 1月10日");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrGkkokyakucd("1234567890123");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrBankcd("1111");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrBanknmej("ＢＡＮＫ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrSitencd("222");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrSitennmej("ＳＴＯＲＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrKouzano("9876543210");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrSyono("10000000004");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrSoukingk(BizCurrency.valueOf(9999));
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrSyorinm("処理名");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrSyorisosikicd("1236547");

        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrTantousitunm("万事屋");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrHrkmsiteiymd("平成30年 1月10日");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrGkkokyakucd("1234567890123");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrBankcd("1111");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrBanknmej("ＢＡＮＫ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrSitencd("222");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrSitennmej("ＳＴＯＲＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrKouzano("9876543210");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrSyono("10000000005");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrSoukingk(BizCurrency.valueOf(9.1));
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrSyorinm("処理名");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrSyorisosikicd("1236547");

        bzGkOnlineFbSoukinMeisaiListDataSourceBean6.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean6.setIrTantousitunm("万事屋");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean6.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean6.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean6.setIrHrkmsiteiymd("平成30年 1月10日");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean6.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean6.setIrGkkokyakucd("1234567890123");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean6.setIrBankcd("1111");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean6.setIrBanknmej("ＢＡＮＫ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean6.setIrSitencd("222");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean6.setIrSitennmej("ＳＴＯＲＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean6.setIrKouzano("9876543210");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean6.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean6.setIrSyono("10000000006");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean6.setIrSoukingk(BizCurrency.valueOf(9.22));
        bzGkOnlineFbSoukinMeisaiListDataSourceBean6.setIrSyorinm("処理名");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean6.setIrSyorisosikicd("1236547");

        bzGkOnlineFbSoukinMeisaiListDataSourceBean7.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean7.setIrTantousitunm("万事屋");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean7.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean7.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean7.setIrHrkmsiteiymd("平成30年 1月10日");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean7.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean7.setIrGkkokyakucd("1234567890123");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean7.setIrBankcd("1111");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean7.setIrBanknmej("ＢＡＮＫ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean7.setIrSitencd("222");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean7.setIrSitennmej("ＳＴＯＲＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean7.setIrKouzano("9876543210");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean7.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean7.setIrSyono("10000000007");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean7.setIrSoukingk(BizCurrency.valueOf(9.333));
        bzGkOnlineFbSoukinMeisaiListDataSourceBean7.setIrSyorinm("処理名");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean7.setIrSyorisosikicd("1236547");

        dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean1);
        dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean3);
        dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean4);
        dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean5);
        dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean6);
        dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean7);

        reportTestBean.addParamObjects(dataSouceList, bzGkOnlineFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBSOUKINMEISAI_2);

        bzGkOnlineFbSoukinMeisaiListBean.setIrSyoriymd("ＷＷ99年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
        BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean2 = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
        BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean3 = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();

        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("ＷＷ99年99月99日");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd("wwwwwwwwwwwww");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBankcd("wwww");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitencd("www");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKouzano("wwwwwwwwww");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyono("wwwwwwwwwww");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(999999999999.99));
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorinm("ＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorisosikicd("wwwwwww");

        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrTantousitunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrHrkmsiteiymd("ＷＷ99年99月99日");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrGkkokyakucd("wwwwwwwwwwwww");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrBankcd("wwww");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrBanknmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrSitencd("www");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrSitennmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrKouzano("wwwwwwwwww");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrKzmeiginmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrSyono("wwwwwwwwwww");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrSoukingk(BizCurrency.valueOf(1000));
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrSyorinm("ＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrSyorisosikicd("wwwwwww");

        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrTantousitunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrHrkmsiteiymd("ＷＷ99年99月99日");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrGkkokyakucd("wwwwwwwwwwwww");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrBankcd("wwww");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrBanknmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrSitencd("www");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrSitennmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrKouzano("wwwwwwwwww");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrKzmeiginmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrSyono("wwwwwwwwwww");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrSoukingk(BizCurrency.valueOf(999));
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrSyorinm("ＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrSyorisosikicd("wwwwwww");

        dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean);
        dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean2);
        dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, bzGkOnlineFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBSOUKINMEISAI_2);

        bzGkOnlineFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        reportTestBean.addParamObjects(bzGkOnlineFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBSOUKINMEISAI_2);

        bzGkOnlineFbSoukinMeisaiListBean.setIrSyoriymd("ＷＷ99年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
        BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean2 = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("ＷＷ99年99月99日");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd("wwwwwwwwwwwww");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBankcd("wwww");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitencd("www");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKouzano("wwwwwwwwww");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyono("wwwwwwwwwww");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(9999));
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorinm("ＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorisosikicd("wwwwwww");

        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrTantousitunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrHrkmsiteiymd("ＷＷ99年99月99日");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrGkkokyakucd("wwwwwwwwwwwww");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrBankcd("wwww");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrBanknmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrSitencd("www");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrSitennmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrKouzano("wwwwwwwwww");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrKzmeiginmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrSyono("wwwwwwwwwww");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrSoukingk(BizCurrency.valueOf(9.1));
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrSyorinm("ＷＷＷＷＷＷＷＷＷＷ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrSyorisosikicd("wwwwwww");

        dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean);
        dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, bzGkOnlineFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBSOUKINMEISAI_2);

        bzGkOnlineFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0; i <9999; i++) {

            BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("万事屋");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd(String.valueOf(1000000000001L + i));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBankcd("1111");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＢＡＮＫ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitencd("222");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＳＴＯＲＥ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKouzano("9876543210");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＮＡＭＥ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000000L + i));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorinm("処理名");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorisosikicd("1236547");

            dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, bzGkOnlineFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBSOUKINMEISAI_2);

        bzGkOnlineFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0; i <99999; i++) {

            BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("万事屋");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd(String.valueOf(1000000000001L + i));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBankcd("1111");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＢＡＮＫ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitencd("222");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＳＴＯＲＥ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKouzano("9876543210");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＮＡＭＥ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000000L + i));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorinm("処理名");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorisosikicd("1236547");

            dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, bzGkOnlineFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBSOUKINMEISAI_2);

        bzGkOnlineFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0; i <100000; i++) {

            BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("万事屋");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd(String.valueOf(1000000000001L + i));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBankcd("1111");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＢＡＮＫ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitencd("222");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＳＴＯＲＥ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKouzano("9876543210");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＮＡＭＥ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000000L + i));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorinm("処理名");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorisosikicd("1236547");

            dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, bzGkOnlineFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBSOUKINMEISAI_2);

        bzGkOnlineFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0; i <999; i++) {

            BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("万事屋");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd(String.valueOf(1000000000001L + i));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBankcd("1111");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＢＡＮＫ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitencd("222");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＳＴＯＲＥ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKouzano("9876543210");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＮＡＭＥ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000000L + i));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorinm("処理名");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorisosikicd("1236547");

            dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, bzGkOnlineFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBSOUKINMEISAI_2);

        bzGkOnlineFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0; i <9999; i++) {

            BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();

            if ( i%2 == 0){
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("万事屋");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd("1234567890123");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBankcd("1111");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＢＡＮＫ");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitencd("222");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＳＴＯＲＥ");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKouzano("9876543210");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＮＡＭＥ");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyono("10000000001");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorinm("処理名");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorisosikicd("1236547");

                dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean);
            }
            else{
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("万事屋");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd("1234567890123");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBankcd("1111");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＢＡＮＫ");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitencd("222");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＳＴＯＲＥ");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKouzano("9876543210");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＮＡＭＥ");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyono("10000000001");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorinm("処理名");
                bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorisosikicd("1236547");

                dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean);
            }
        }
        reportTestBean.addParamObjects(dataSouceList, bzGkOnlineFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBSOUKINMEISAI_2);

        bzGkOnlineFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0; i <33; i++) {

            BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("万事屋");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd(String.valueOf(1000000000001L + i));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBankcd("1111");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＢＡＮＫ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitencd("222");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＳＴＯＲＥ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKouzano("9876543210");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＮＡＭＥ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000000L + i));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorinm("処理名");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorisosikicd("1236547");

            dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, bzGkOnlineFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBSOUKINMEISAI_2);

        bzGkOnlineFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0; i <34; i++) {

            BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("万事屋");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd(String.valueOf(1000000000001L + i));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBankcd("1111");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＢＡＮＫ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitencd("222");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＳＴＯＲＥ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKouzano("9876543210");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＮＡＭＥ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000000L + i));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorinm("処理名");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorisosikicd("1236547");

            dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, bzGkOnlineFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBSOUKINMEISAI_2);

        bzGkOnlineFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0; i <35; i++) {

            BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("万事屋");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd(String.valueOf(1000000000001L + i));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBankcd("1111");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＢＡＮＫ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitencd("222");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＳＴＯＲＥ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKouzano("9876543210");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＮＡＭＥ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000000L + i));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorinm("処理名");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorisosikicd("1236547");

            dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, bzGkOnlineFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBSOUKINMEISAI_2);

        bzGkOnlineFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean1 = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
        BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean2 = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
        BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean3 = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
        BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean4 = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
        BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean5 = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();

        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrTantousitunm("万事屋");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrHrkmsiteiymd("平成30年 1月10日");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrGkkokyakucd("1000000000001");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrBankcd("1111");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrBanknmej("ＢＡＮＫ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrSitencd("222");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrSitennmej("ＳＴＯＲＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrKouzano("9876543210");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrSyono("10000000001");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrSoukingk(BizCurrency.valueOf(1));
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrSyorinm("処理名");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean1.setIrSyorisosikicd("1236547");

        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrTantousitunm("万事屋");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrHrkmsiteiymd("平成30年 1月10日");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrGkkokyakucd("1000000000001");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrBankcd("1111");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrBanknmej("ＢＡＮＫ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrSitencd("222");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrSitennmej("ＳＴＯＲＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrKouzano("9876543210");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrSyono("10000000001");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrSoukingk(BizCurrency.valueOf(1));
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrSyorinm("処理名");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean2.setIrSyorisosikicd("1236547");

        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrTantousitunm("万事屋");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrHrkmsiteiymd("平成30年 1月 9日");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrGkkokyakucd("1000000000001");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrBankcd("1111");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrBanknmej("ＢＡＮＫ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrSitencd("222");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrSitennmej("ＳＴＯＲＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrKouzano("9876543210");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrSyono("10000000001");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrSoukingk(BizCurrency.valueOf(1));
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrSyorinm("処理名");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean3.setIrSyorisosikicd("1236547");

        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrTantousitunm("万事屋");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrHrkmsiteiymd("平成30年 1月 9日");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrGkkokyakucd("1000000000001");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrBankcd("1111");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrBanknmej("ＢＡＮＫ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrSitencd("222");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrSitennmej("ＳＴＯＲＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrKouzano("9876543210");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrSyono("10000000001");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrSoukingk(BizCurrency.valueOf(1));
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrSyorinm("処理名");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean4.setIrSyorisosikicd("1236547");

        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrTantousitucd(C_Tantositucd.GYOUMUSINSA);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrTantousitunm("万事屋");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrHrkmsiteiymd("平成30年 1月 9日");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrGkkokyakucd("1000000000001");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrBankcd("1111");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrBanknmej("ＢＡＮＫ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrSitencd("222");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrSitennmej("ＳＴＯＲＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrKouzano("9876543210");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrSyono("10000000001");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrSoukingk(BizCurrency.valueOf(1));
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrSyorinm("処理名");
        bzGkOnlineFbSoukinMeisaiListDataSourceBean5.setIrSyorisosikicd("1236547");

        dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean1);
        dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean2);
        dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean3);
        dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean4);
        dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean5);

        reportTestBean.addParamObjects(dataSouceList, bzGkOnlineFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_ONLINE_GKFBSOUKINMEISAI_2);

        bzGkOnlineFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0; i <32; i++) {

            BzGkOnlineFbSoukinMeisaiListDataSourceBean bzGkOnlineFbSoukinMeisaiListDataSourceBean = new BzGkOnlineFbSoukinMeisaiListDataSourceBean();
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("万事屋");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd(String.valueOf(1000000000001L + i));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBankcd("1111");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＢＡＮＫ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitencd("222");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＳＴＯＲＥ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKouzano("9876543210");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＮＡＭＥ");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000000L + i));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorinm("処理名");
            bzGkOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorisosikicd("1236547");

            dataSouceList.add(bzGkOnlineFbSoukinMeisaiListDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, bzGkOnlineFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}