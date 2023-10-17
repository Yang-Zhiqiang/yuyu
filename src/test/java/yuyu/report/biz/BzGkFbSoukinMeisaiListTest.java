package yuyu.report.biz;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzGkFbSoukinMeisaiListBean;
import yuyu.def.biz.bean.report.BzGkFbSoukinMeisaiListDataSourceBean;
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
 * 外貨ＦＢ送金明細リスト帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzGkFbSoukinMeisaiListTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzGkFbSoukinMeisaiListBean bzGkFbSoukinMeisaiListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);

        bzGkFbSoukinMeisaiListBean.setIrSyoriymd(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean = new BzGkFbSoukinMeisaiListDataSourceBean();

        bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(null);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitunm(null);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(null);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(null);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd(null);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd(null);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrBankcd(null);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrBanknmej(null);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrSitencd(null);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrSitennmej(null);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrKouzano(null);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej(null);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrSyono(null);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(0));

        dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzGkFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);

        bzGkFbSoukinMeisaiListBean.setIrSyoriymd("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean = new BzGkFbSoukinMeisaiListDataSourceBean();

        bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.BLNK0);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.BLNK);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.BLNK);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd("");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrBankcd("");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrBanknmej("");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrSitencd("");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrSitennmej("");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrKouzano("");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrSyono("");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(0));

        dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzGkFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);

        bzGkFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean1 = new BzGkFbSoukinMeisaiListDataSourceBean();
        BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean3 = new BzGkFbSoukinMeisaiListDataSourceBean();
        BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean4 = new BzGkFbSoukinMeisaiListDataSourceBean();
        BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean5 = new BzGkFbSoukinMeisaiListDataSourceBean();
        BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean6 = new BzGkFbSoukinMeisaiListDataSourceBean();
        BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean7 = new BzGkFbSoukinMeisaiListDataSourceBean();

        bzGkFbSoukinMeisaiListDataSourceBean1.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrTantousitunm("万事屋");
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrHrkmsiteiymd("平成30年 1月10日");
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrGkkokyakucd("1234567890123");
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrBankcd("1111");
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrBanknmej("ＢＡＮＫ");
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrSitencd("222");
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrSitennmej("ＳＴＯＲＥ");
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrKouzano("9876543210");
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrSyono("10000000001");
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrSoukingk(BizCurrency.valueOf(1000));


        bzGkFbSoukinMeisaiListDataSourceBean3.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrTantousitunm("万事屋");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrHrkmsiteiymd("平成30年 1月10日");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrGkkokyakucd("1234567890123");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrBankcd("1111");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrBanknmej("ＢＡＮＫ");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrSitencd("222");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrSitennmej("ＳＴＯＲＥ");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrKouzano("9876543210");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrSyono("10000000003");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrSoukingk(BizCurrency.valueOf(999));

        bzGkFbSoukinMeisaiListDataSourceBean4.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrTantousitunm("万事屋");
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrHrkmsiteiymd("平成30年 1月10日");
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrGkkokyakucd("1234567890123");
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrBankcd("1111");
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrBanknmej("ＢＡＮＫ");
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrSitencd("222");
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrSitennmej("ＳＴＯＲＥ");
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrKouzano("9876543210");
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrSyono("10000000004");
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrSoukingk(BizCurrency.valueOf(9999));

        bzGkFbSoukinMeisaiListDataSourceBean5.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrTantousitunm("万事屋");
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrHrkmsiteiymd("平成30年 1月10日");
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrGkkokyakucd("1234567890123");
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrBankcd("1111");
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrBanknmej("ＢＡＮＫ");
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrSitencd("222");
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrSitennmej("ＳＴＯＲＥ");
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrKouzano("9876543210");
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrSyono("10000000005");
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrSoukingk(BizCurrency.valueOf(9.1));

        bzGkFbSoukinMeisaiListDataSourceBean6.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkFbSoukinMeisaiListDataSourceBean6.setIrTantousitunm("万事屋");
        bzGkFbSoukinMeisaiListDataSourceBean6.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzGkFbSoukinMeisaiListDataSourceBean6.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzGkFbSoukinMeisaiListDataSourceBean6.setIrHrkmsiteiymd("平成30年 1月10日");
        bzGkFbSoukinMeisaiListDataSourceBean6.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzGkFbSoukinMeisaiListDataSourceBean6.setIrGkkokyakucd("1234567890123");
        bzGkFbSoukinMeisaiListDataSourceBean6.setIrBankcd("1111");
        bzGkFbSoukinMeisaiListDataSourceBean6.setIrBanknmej("ＢＡＮＫ");
        bzGkFbSoukinMeisaiListDataSourceBean6.setIrSitencd("222");
        bzGkFbSoukinMeisaiListDataSourceBean6.setIrSitennmej("ＳＴＯＲＥ");
        bzGkFbSoukinMeisaiListDataSourceBean6.setIrKouzano("9876543210");
        bzGkFbSoukinMeisaiListDataSourceBean6.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkFbSoukinMeisaiListDataSourceBean6.setIrSyono("10000000006");
        bzGkFbSoukinMeisaiListDataSourceBean6.setIrSoukingk(BizCurrency.valueOf(9.22));

        bzGkFbSoukinMeisaiListDataSourceBean7.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkFbSoukinMeisaiListDataSourceBean7.setIrTantousitunm("万事屋");
        bzGkFbSoukinMeisaiListDataSourceBean7.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzGkFbSoukinMeisaiListDataSourceBean7.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzGkFbSoukinMeisaiListDataSourceBean7.setIrHrkmsiteiymd("平成30年 1月10日");
        bzGkFbSoukinMeisaiListDataSourceBean7.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzGkFbSoukinMeisaiListDataSourceBean7.setIrGkkokyakucd("1234567890123");
        bzGkFbSoukinMeisaiListDataSourceBean7.setIrBankcd("1111");
        bzGkFbSoukinMeisaiListDataSourceBean7.setIrBanknmej("ＢＡＮＫ");
        bzGkFbSoukinMeisaiListDataSourceBean7.setIrSitencd("222");
        bzGkFbSoukinMeisaiListDataSourceBean7.setIrSitennmej("ＳＴＯＲＥ");
        bzGkFbSoukinMeisaiListDataSourceBean7.setIrKouzano("9876543210");
        bzGkFbSoukinMeisaiListDataSourceBean7.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkFbSoukinMeisaiListDataSourceBean7.setIrSyono("10000000007");
        bzGkFbSoukinMeisaiListDataSourceBean7.setIrSoukingk(BizCurrency.valueOf(9.333));

        dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean1);
        dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean3);
        dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean4);
        dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean5);
        dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean6);
        dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean7);

        reportTestBean.addParamObjects(dataSouceList, bzGkFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);

        bzGkFbSoukinMeisaiListBean.setIrSyoriymd("ＷＷ99年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean = new BzGkFbSoukinMeisaiListDataSourceBean();
        BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean2 = new BzGkFbSoukinMeisaiListDataSourceBean();
        BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean3 = new BzGkFbSoukinMeisaiListDataSourceBean();

        bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("ＷＷ99年99月99日");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd("wwwwwwwwwwwww");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrBankcd("wwww");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrSitencd("www");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrKouzano("wwwwwwwwww");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrSyono("wwwwwwwwwww");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(999999999999.99));

        bzGkFbSoukinMeisaiListDataSourceBean2.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrTantousitunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrHrkmsiteiymd("ＷＷ99年99月99日");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrGkkokyakucd("wwwwwwwwwwwww");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrBankcd("wwww");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrBanknmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrSitencd("www");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrSitennmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrKouzano("wwwwwwwwww");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrKzmeiginmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrSyono("wwwwwwwwwww");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrSoukingk(BizCurrency.valueOf(1000));

        bzGkFbSoukinMeisaiListDataSourceBean3.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrTantousitunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrHrkmsiteiymd("ＷＷ99年99月99日");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrGkkokyakucd("wwwwwwwwwwwww");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrBankcd("wwww");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrBanknmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrSitencd("www");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrSitennmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrKouzano("wwwwwwwwww");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrKzmeiginmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrSyono("wwwwwwwwwww");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrSoukingk(BizCurrency.valueOf(999));

        dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean);
        dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean2);
        dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, bzGkFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);

        bzGkFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        reportTestBean.addParamObjects(bzGkFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);

        bzGkFbSoukinMeisaiListBean.setIrSyoriymd("ＷＷ99年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean = new BzGkFbSoukinMeisaiListDataSourceBean();
        BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean2 = new BzGkFbSoukinMeisaiListDataSourceBean();
        bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("ＷＷ99年99月99日");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.USD);
        bzGkFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd("wwwwwwwwwwwww");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrBankcd("wwww");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrSitencd("www");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrKouzano("wwwwwwwwww");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrSyono("wwwwwwwwwww");
        bzGkFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(9999));

        bzGkFbSoukinMeisaiListDataSourceBean2.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrTantousitunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU2EIGO);
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrHrkmsiteiymd("ＷＷ99年99月99日");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrShrtuukasyu(C_Tuukasyu.EUR);
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrGkkokyakucd("wwwwwwwwwwwww");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrBankcd("wwww");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrBanknmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrSitencd("www");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrSitennmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrKouzano("wwwwwwwwww");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrKzmeiginmej("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrSyono("wwwwwwwwwww");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrSoukingk(BizCurrency.valueOf(9.1));

        dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean);
        dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, bzGkFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);

        bzGkFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0; i <9999; i++) {

            BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean = new BzGkFbSoukinMeisaiListDataSourceBean();
            bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("万事屋");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd(String.valueOf(1000000000001L + i));
            bzGkFbSoukinMeisaiListDataSourceBean.setIrBankcd("1111");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＢＡＮＫ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSitencd("222");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＳＴＯＲＥ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrKouzano("9876543210");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＮＡＭＥ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000000L + i));
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));

            dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, bzGkFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);

        bzGkFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0; i <99999; i++) {

            BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean = new BzGkFbSoukinMeisaiListDataSourceBean();
            bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("万事屋");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd(String.valueOf(1000000000001L + i));
            bzGkFbSoukinMeisaiListDataSourceBean.setIrBankcd("1111");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＢＡＮＫ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSitencd("222");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＳＴＯＲＥ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrKouzano("9876543210");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＮＡＭＥ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000000L + i));
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));

            dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, bzGkFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);

        bzGkFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0; i <100000; i++) {

            BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean = new BzGkFbSoukinMeisaiListDataSourceBean();
            bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("万事屋");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd(String.valueOf(1000000000001L + i));
            bzGkFbSoukinMeisaiListDataSourceBean.setIrBankcd("1111");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＢＡＮＫ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSitencd("222");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＳＴＯＲＥ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrKouzano("9876543210");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＮＡＭＥ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000000L + i));
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));

            dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, bzGkFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);

        bzGkFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0; i <999; i++) {

            BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean = new BzGkFbSoukinMeisaiListDataSourceBean();
            bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("万事屋");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd(String.valueOf(1000000000001L + i));
            bzGkFbSoukinMeisaiListDataSourceBean.setIrBankcd("1111");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＢＡＮＫ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSitencd("222");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＳＴＯＲＥ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrKouzano("9876543210");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＮＡＭＥ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000000L + i));
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));

            dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, bzGkFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);

        bzGkFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0; i <9999; i++) {

            BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean = new BzGkFbSoukinMeisaiListDataSourceBean();

            if ( i%2 == 0){
                bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
                bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("万事屋");
                bzGkFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
                bzGkFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
                bzGkFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
                bzGkFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
                bzGkFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd("1234567890123");
                bzGkFbSoukinMeisaiListDataSourceBean.setIrBankcd("1111");
                bzGkFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＢＡＮＫ");
                bzGkFbSoukinMeisaiListDataSourceBean.setIrSitencd("222");
                bzGkFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＳＴＯＲＥ");
                bzGkFbSoukinMeisaiListDataSourceBean.setIrKouzano("9876543210");
                bzGkFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＮＡＭＥ");
                bzGkFbSoukinMeisaiListDataSourceBean.setIrSyono("10000000001");
                bzGkFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));

                dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean);
            }
            else{
                bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
                bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("万事屋");
                bzGkFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
                bzGkFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.NENKINJIDOU3EIDO);
                bzGkFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
                bzGkFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
                bzGkFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd("1234567890123");
                bzGkFbSoukinMeisaiListDataSourceBean.setIrBankcd("1111");
                bzGkFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＢＡＮＫ");
                bzGkFbSoukinMeisaiListDataSourceBean.setIrSitencd("222");
                bzGkFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＳＴＯＲＥ");
                bzGkFbSoukinMeisaiListDataSourceBean.setIrKouzano("9876543210");
                bzGkFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＮＡＭＥ");
                bzGkFbSoukinMeisaiListDataSourceBean.setIrSyono("10000000001");
                bzGkFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));

                dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean);
            }
        }
        reportTestBean.addParamObjects(dataSouceList, bzGkFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);

        bzGkFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0; i <33; i++) {

            BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean = new BzGkFbSoukinMeisaiListDataSourceBean();
            bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("万事屋");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd(String.valueOf(1000000000001L + i));
            bzGkFbSoukinMeisaiListDataSourceBean.setIrBankcd("1111");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＢＡＮＫ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSitencd("222");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＳＴＯＲＥ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrKouzano("9876543210");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＮＡＭＥ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000000L + i));
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));

            dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, bzGkFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);

        bzGkFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0; i <34; i++) {

            BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean = new BzGkFbSoukinMeisaiListDataSourceBean();
            bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("万事屋");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd(String.valueOf(1000000000001L + i));
            bzGkFbSoukinMeisaiListDataSourceBean.setIrBankcd("1111");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＢＡＮＫ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSitencd("222");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＳＴＯＲＥ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrKouzano("9876543210");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＮＡＭＥ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000000L + i));
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));

            dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, bzGkFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);

        bzGkFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0; i <35; i++) {

            BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean = new BzGkFbSoukinMeisaiListDataSourceBean();
            bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("万事屋");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd(String.valueOf(1000000000001L + i));
            bzGkFbSoukinMeisaiListDataSourceBean.setIrBankcd("1111");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＢＡＮＫ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSitencd("222");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＳＴＯＲＥ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrKouzano("9876543210");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＮＡＭＥ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000000L + i));
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));

            dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, bzGkFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);

        bzGkFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean1 = new BzGkFbSoukinMeisaiListDataSourceBean();
        BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean2 = new BzGkFbSoukinMeisaiListDataSourceBean();
        BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean3 = new BzGkFbSoukinMeisaiListDataSourceBean();
        BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean4 = new BzGkFbSoukinMeisaiListDataSourceBean();
        BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean5 = new BzGkFbSoukinMeisaiListDataSourceBean();

        bzGkFbSoukinMeisaiListDataSourceBean1.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrTantousitunm("万事屋");
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrHrkmsiteiymd("平成30年 1月10日");
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrGkkokyakucd("1000000000001");
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrBankcd("1111");
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrBanknmej("ＢＡＮＫ");
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrSitencd("222");
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrSitennmej("ＳＴＯＲＥ");
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrKouzano("9876543210");
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrSyono("10000000001");
        bzGkFbSoukinMeisaiListDataSourceBean1.setIrSoukingk(BizCurrency.valueOf(1));

        bzGkFbSoukinMeisaiListDataSourceBean2.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrTantousitunm("万事屋");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrHrkmsiteiymd("平成30年 1月10日");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrGkkokyakucd("1000000000001");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrBankcd("1111");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrBanknmej("ＢＡＮＫ");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrSitencd("222");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrSitennmej("ＳＴＯＲＥ");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrKouzano("9876543210");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrSyono("10000000001");
        bzGkFbSoukinMeisaiListDataSourceBean2.setIrSoukingk(BizCurrency.valueOf(1));

        bzGkFbSoukinMeisaiListDataSourceBean3.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrTantousitunm("万事屋");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrHrkmsiteiymd("平成30年 1月 9日");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrGkkokyakucd("1000000000001");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrBankcd("1111");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrBanknmej("ＢＡＮＫ");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrSitencd("222");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrSitennmej("ＳＴＯＲＥ");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrKouzano("9876543210");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrSyono("10000000001");
        bzGkFbSoukinMeisaiListDataSourceBean3.setIrSoukingk(BizCurrency.valueOf(1));

        bzGkFbSoukinMeisaiListDataSourceBean4.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrTantousitunm("万事屋");
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrHrkmsiteiymd("平成30年 1月 9日");
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrGkkokyakucd("1000000000001");
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrBankcd("1111");
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrBanknmej("ＢＡＮＫ");
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrSitencd("222");
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrSitennmej("ＳＴＯＲＥ");
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrKouzano("9876543210");
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrSyono("10000000001");
        bzGkFbSoukinMeisaiListDataSourceBean4.setIrSoukingk(BizCurrency.valueOf(1));

        bzGkFbSoukinMeisaiListDataSourceBean5.setIrTantousitucd(C_Tantositucd.GYOUMUSINSA);
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrTantousitunm("万事屋");
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrGkgyoumucd(C_Gkgyoumucd.KHSISIHARAI);
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrHrkmsiteiymd("平成30年 1月 9日");
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrShrtuukasyu(C_Tuukasyu.AUD);
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrGkkokyakucd("1000000000001");
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrBankcd("1111");
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrBanknmej("ＢＡＮＫ");
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrSitencd("222");
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrSitennmej("ＳＴＯＲＥ");
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrKouzano("9876543210");
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrKzmeiginmej("ＮＡＭＥ");
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrSyono("10000000001");
        bzGkFbSoukinMeisaiListDataSourceBean5.setIrSoukingk(BizCurrency.valueOf(1));

        dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean1);
        dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean2);
        dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean3);
        dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean4);
        dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean5);

        reportTestBean.addParamObjects(dataSouceList, bzGkFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzGkFbSoukinMeisaiListTest", C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);

        bzGkFbSoukinMeisaiListBean.setIrSyoriymd("平成30年 2月10日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0; i <32; i++) {

            BzGkFbSoukinMeisaiListDataSourceBean bzGkFbSoukinMeisaiListDataSourceBean = new BzGkFbSoukinMeisaiListDataSourceBean();
            bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(C_Tantositucd.SIHARAIGYOUMU);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrTantousitunm("万事屋");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd("平成30年 1月10日");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(C_Tuukasyu.AUD);
            bzGkFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd(String.valueOf(1000000000001L + i));
            bzGkFbSoukinMeisaiListDataSourceBean.setIrBankcd("1111");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrBanknmej("ＢＡＮＫ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSitencd("222");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSitennmej("ＳＴＯＲＥ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrKouzano("9876543210");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej("ＮＡＭＥ");
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSyono(String.valueOf(10000000000L + i));
            bzGkFbSoukinMeisaiListDataSourceBean.setIrSoukingk(BizCurrency.valueOf(1));

            dataSouceList.add(bzGkFbSoukinMeisaiListDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, bzGkFbSoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}