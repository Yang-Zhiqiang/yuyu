package yuyu.report.sinkeiyaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.sinkeiyaku.bean.report.SkHurikominyuukinteiseilistBean;
import yuyu.def.sinkeiyaku.bean.report.SkHurikominyuukinteiseilistDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 振込入金訂正データリスト帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkHuriKominYuukinteiseiListTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkHurikominyuukinteiseilistBean skHurikominyuukinteiseilistBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHuriKominYuukinteiseiListTest", C_SyoruiCdKbn.SK_HURIKOMINYKNTEISEILIST_ENKA);

        skHurikominyuukinteiseilistBean.setIrAtesaki(null);
        skHurikominyuukinteiseilistBean.setIrTyouhyousakuseiymd(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 14; i++) {
            SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean = new SkHurikominyuukinteiseilistDataSourceBean();

            skHurikominyuukinteiseilistDataSourceBean.setIrBankcd(null);
            skHurikominyuukinteiseilistDataSourceBean.setIrSitencd(null);
            skHurikominyuukinteiseilistDataSourceBean.setIrYokinkbn(null);
            skHurikominyuukinteiseilistDataSourceBean.setIrKouzano(null);
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirninnm48(null);
            skHurikominyuukinteiseilistDataSourceBean.setIrNyknkkngk(null);
            skHurikominyuukinteiseilistDataSourceBean.setIrKsnymd(null);
            skHurikominyuukinteiseilistDataSourceBean.setIrKnjyymd(null);
            skHurikominyuukinteiseilistDataSourceBean.setIrIribaraikbn(null);
            skHurikominyuukinteiseilistDataSourceBean.setIrTrhkkbn(null);
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirnincd(null);

            dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHurikominyuukinteiseilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHuriKominYuukinteiseiListTest", C_SyoruiCdKbn.SK_HURIKOMINYKNTEISEILIST_ENKA);

        skHurikominyuukinteiseilistBean.setIrAtesaki("");
        skHurikominyuukinteiseilistBean.setIrTyouhyousakuseiymd("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 14; i++) {
            SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean = new SkHurikominyuukinteiseilistDataSourceBean();

            skHurikominyuukinteiseilistDataSourceBean.setIrBankcd("");
            skHurikominyuukinteiseilistDataSourceBean.setIrSitencd("");
            skHurikominyuukinteiseilistDataSourceBean.setIrYokinkbn(C_YokinKbn.BLNK);
            skHurikominyuukinteiseilistDataSourceBean.setIrKouzano("");
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirninnm48("");
            skHurikominyuukinteiseilistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(0));
            skHurikominyuukinteiseilistDataSourceBean.setIrKsnymd("");
            skHurikominyuukinteiseilistDataSourceBean.setIrKnjyymd("");
            skHurikominyuukinteiseilistDataSourceBean.setIrIribaraikbn("");
            skHurikominyuukinteiseilistDataSourceBean.setIrTrhkkbn("");
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirnincd("");

            dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHurikominyuukinteiseilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHuriKominYuukinteiseiListTest", C_SyoruiCdKbn.SK_HURIKOMINYKNTEISEILIST_ENKA);

        skHurikominyuukinteiseilistBean.setIrAtesaki("代理店契約室　御中");
        skHurikominyuukinteiseilistBean.setIrTyouhyousakuseiymd("H27.08.31");
        skHurikominyuukinteiseilistBean.setIrSyoruicd(C_SyoruiCdKbn.SK_HURIKOMINYKNTEISEILIST_ENKA);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 14; i++) {
            SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean = new SkHurikominyuukinteiseilistDataSourceBean();

            skHurikominyuukinteiseilistDataSourceBean.setIrBankcd("1234");
            skHurikominyuukinteiseilistDataSourceBean.setIrSitencd("123");
            skHurikominyuukinteiseilistDataSourceBean.setIrYokinkbn(C_YokinKbn.HUTUU);
            skHurikominyuukinteiseilistDataSourceBean.setIrKouzano("123456789012");
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirninnm48("振込依頼人名");
            skHurikominyuukinteiseilistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(9999));
            skHurikominyuukinteiseilistDataSourceBean.setIrKsnymd("20160318");
            skHurikominyuukinteiseilistDataSourceBean.setIrKnjyymd("20160320");
            skHurikominyuukinteiseilistDataSourceBean.setIrIribaraikbn("1");
            skHurikominyuukinteiseilistDataSourceBean.setIrTrhkkbn("12");
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirnincd("0987654321");

            dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHurikominyuukinteiseilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHuriKominYuukinteiseiListTest", C_SyoruiCdKbn.SK_HURIKOMINYKNTEISEILIST_GAIKA);

        skHurikominyuukinteiseilistBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHurikominyuukinteiseilistBean.setIrTyouhyousakuseiymd("w99.99.99");
        skHurikominyuukinteiseilistBean.setIrSyoruicd(C_SyoruiCdKbn.SK_HURIKOMINYKNTEISEILIST_GAIKA);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 14; i++) {
            SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean = new SkHurikominyuukinteiseilistDataSourceBean();

            skHurikominyuukinteiseilistDataSourceBean.setIrBankcd("wwww");
            skHurikominyuukinteiseilistDataSourceBean.setIrSitencd("www");
            skHurikominyuukinteiseilistDataSourceBean.setIrYokinkbn(C_YokinKbn.HUTUU);
            skHurikominyuukinteiseilistDataSourceBean.setIrKouzano("wwwwwwwwwwww");
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirninnm48("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skHurikominyuukinteiseilistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
            skHurikominyuukinteiseilistDataSourceBean.setIrKsnymd("99999999");
            skHurikominyuukinteiseilistDataSourceBean.setIrKnjyymd("99999999");
            skHurikominyuukinteiseilistDataSourceBean.setIrIribaraikbn("w");
            skHurikominyuukinteiseilistDataSourceBean.setIrTrhkkbn("ww");
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirnincd("wwwwwwwwww");

            dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHurikominyuukinteiseilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHuriKominYuukinteiseiListTest", C_SyoruiCdKbn.SK_HURIKOMINYKNTEISEILIST_ENKA);

        skHurikominyuukinteiseilistBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHurikominyuukinteiseilistBean.setIrTyouhyousakuseiymd("w99.99.99");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 14; i++) {
            SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean = new SkHurikominyuukinteiseilistDataSourceBean();

            skHurikominyuukinteiseilistDataSourceBean.setIrBankcd("wwww");
            skHurikominyuukinteiseilistDataSourceBean.setIrSitencd("www");
            skHurikominyuukinteiseilistDataSourceBean.setIrYokinkbn(C_YokinKbn.HUTUU);
            skHurikominyuukinteiseilistDataSourceBean.setIrKouzano("wwwwwwwwwwww");
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirninnm48("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skHurikominyuukinteiseilistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(999));
            skHurikominyuukinteiseilistDataSourceBean.setIrKsnymd("99999999");
            skHurikominyuukinteiseilistDataSourceBean.setIrKnjyymd("99999999");
            skHurikominyuukinteiseilistDataSourceBean.setIrIribaraikbn("w");
            skHurikominyuukinteiseilistDataSourceBean.setIrTrhkkbn("ww");
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirnincd("wwwwwwwwww");

            dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHurikominyuukinteiseilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHuriKominYuukinteiseiListTest", C_SyoruiCdKbn.SK_HURIKOMINYKNTEISEILIST_ENKA);

        skHurikominyuukinteiseilistBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHurikominyuukinteiseilistBean.setIrTyouhyousakuseiymd("w99.99.99");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 15; i++) {
            SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean = new SkHurikominyuukinteiseilistDataSourceBean();

            skHurikominyuukinteiseilistDataSourceBean.setIrBankcd("wwww");
            skHurikominyuukinteiseilistDataSourceBean.setIrSitencd("www");
            skHurikominyuukinteiseilistDataSourceBean.setIrYokinkbn(C_YokinKbn.HUTUU);
            skHurikominyuukinteiseilistDataSourceBean.setIrKouzano("wwwwwwwwwwww");
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirninnm48("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skHurikominyuukinteiseilistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(0));
            skHurikominyuukinteiseilistDataSourceBean.setIrKsnymd("99999999");
            skHurikominyuukinteiseilistDataSourceBean.setIrKnjyymd("99999999");
            skHurikominyuukinteiseilistDataSourceBean.setIrIribaraikbn("w");
            skHurikominyuukinteiseilistDataSourceBean.setIrTrhkkbn("ww");
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirnincd("wwwwwwwwww");

            dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHurikominyuukinteiseilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHuriKominYuukinteiseiListTest", C_SyoruiCdKbn.SK_HURIKOMINYKNTEISEILIST_ENKA);

        skHurikominyuukinteiseilistBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHurikominyuukinteiseilistBean.setIrTyouhyousakuseiymd("w99.99.99");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 16; i++) {
            SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean = new SkHurikominyuukinteiseilistDataSourceBean();

            skHurikominyuukinteiseilistDataSourceBean.setIrBankcd("wwww");
            skHurikominyuukinteiseilistDataSourceBean.setIrSitencd("www");
            skHurikominyuukinteiseilistDataSourceBean.setIrYokinkbn(C_YokinKbn.HUTUU);
            skHurikominyuukinteiseilistDataSourceBean.setIrKouzano("wwwwwwwwwwww");
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirninnm48("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skHurikominyuukinteiseilistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(9.1));
            skHurikominyuukinteiseilistDataSourceBean.setIrKsnymd("99999999");
            skHurikominyuukinteiseilistDataSourceBean.setIrKnjyymd("99999999");
            skHurikominyuukinteiseilistDataSourceBean.setIrIribaraikbn("w");
            skHurikominyuukinteiseilistDataSourceBean.setIrTrhkkbn("ww");
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirnincd("wwwwwwwwww");

            dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHurikominyuukinteiseilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHuriKominYuukinteiseiListTest", C_SyoruiCdKbn.SK_HURIKOMINYKNTEISEILIST_ENKA);

        skHurikominyuukinteiseilistBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHurikominyuukinteiseilistBean.setIrTyouhyousakuseiymd("w99.99.99");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 14; i++) {
            SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean = new SkHurikominyuukinteiseilistDataSourceBean();

            skHurikominyuukinteiseilistDataSourceBean.setIrBankcd("wwww");
            skHurikominyuukinteiseilistDataSourceBean.setIrSitencd("www");
            skHurikominyuukinteiseilistDataSourceBean.setIrYokinkbn(C_YokinKbn.HUTUU);
            skHurikominyuukinteiseilistDataSourceBean.setIrKouzano("wwwwwwwwwwww");
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirninnm48("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skHurikominyuukinteiseilistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(9.22));
            skHurikominyuukinteiseilistDataSourceBean.setIrKsnymd("99999999");
            skHurikominyuukinteiseilistDataSourceBean.setIrKnjyymd("99999999");
            skHurikominyuukinteiseilistDataSourceBean.setIrIribaraikbn("w");
            skHurikominyuukinteiseilistDataSourceBean.setIrTrhkkbn("ww");
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirnincd("wwwwwwwwww");

            dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHurikominyuukinteiseilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHuriKominYuukinteiseiListTest", C_SyoruiCdKbn.SK_HURIKOMINYKNTEISEILIST_ENKA);

        skHurikominyuukinteiseilistBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHurikominyuukinteiseilistBean.setIrTyouhyousakuseiymd("w99.99.99");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 14; i++) {
            SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean = new SkHurikominyuukinteiseilistDataSourceBean();

            skHurikominyuukinteiseilistDataSourceBean.setIrBankcd("wwww");
            skHurikominyuukinteiseilistDataSourceBean.setIrSitencd("www");
            skHurikominyuukinteiseilistDataSourceBean.setIrYokinkbn(C_YokinKbn.HUTUU);
            skHurikominyuukinteiseilistDataSourceBean.setIrKouzano("wwwwwwwwwwww");
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirninnm48("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skHurikominyuukinteiseilistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(9.333));
            skHurikominyuukinteiseilistDataSourceBean.setIrKsnymd("99999999");
            skHurikominyuukinteiseilistDataSourceBean.setIrKnjyymd("99999999");
            skHurikominyuukinteiseilistDataSourceBean.setIrIribaraikbn("w");
            skHurikominyuukinteiseilistDataSourceBean.setIrTrhkkbn("ww");
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirnincd("wwwwwwwwww");

            dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHurikominyuukinteiseilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHuriKominYuukinteiseiListTest", C_SyoruiCdKbn.SK_HURIKOMINYKNTEISEILIST_ENKA);

        skHurikominyuukinteiseilistBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHurikominyuukinteiseilistBean.setIrTyouhyousakuseiymd("w99.99.99");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 14985; i++) {
            SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean = new SkHurikominyuukinteiseilistDataSourceBean();

            skHurikominyuukinteiseilistDataSourceBean.setIrBankcd("wwww");
            skHurikominyuukinteiseilistDataSourceBean.setIrSitencd("www");
            skHurikominyuukinteiseilistDataSourceBean.setIrYokinkbn(C_YokinKbn.HUTUU);
            skHurikominyuukinteiseilistDataSourceBean.setIrKouzano("wwwwwwwwwwww");
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirninnm48("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skHurikominyuukinteiseilistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1));
            skHurikominyuukinteiseilistDataSourceBean.setIrKsnymd("99999999");
            skHurikominyuukinteiseilistDataSourceBean.setIrKnjyymd("99999999");
            skHurikominyuukinteiseilistDataSourceBean.setIrIribaraikbn("w");
            skHurikominyuukinteiseilistDataSourceBean.setIrTrhkkbn("ww");
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirnincd("wwwwwwwwww");

            dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHurikominyuukinteiseilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHuriKominYuukinteiseiListTest", C_SyoruiCdKbn.SK_HURIKOMINYKNTEISEILIST_ENKA);

        skHurikominyuukinteiseilistBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHurikominyuukinteiseilistBean.setIrTyouhyousakuseiymd("w99.99.99");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean1 = new SkHurikominyuukinteiseilistDataSourceBean();
        SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean2 = new SkHurikominyuukinteiseilistDataSourceBean();
        SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean3 = new SkHurikominyuukinteiseilistDataSourceBean();
        SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean4 = new SkHurikominyuukinteiseilistDataSourceBean();
        SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean5 = new SkHurikominyuukinteiseilistDataSourceBean();
        SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean6 = new SkHurikominyuukinteiseilistDataSourceBean();
        SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean7 = new SkHurikominyuukinteiseilistDataSourceBean();
        SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean8 = new SkHurikominyuukinteiseilistDataSourceBean();
        SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean9 = new SkHurikominyuukinteiseilistDataSourceBean();
        SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean10 = new SkHurikominyuukinteiseilistDataSourceBean();
        SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean11 = new SkHurikominyuukinteiseilistDataSourceBean();
        SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean12 = new SkHurikominyuukinteiseilistDataSourceBean();
        SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean13 = new SkHurikominyuukinteiseilistDataSourceBean();
        SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean14 = new SkHurikominyuukinteiseilistDataSourceBean();
        SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean15 = new SkHurikominyuukinteiseilistDataSourceBean();
        SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean16 = new SkHurikominyuukinteiseilistDataSourceBean();

        skHurikominyuukinteiseilistDataSourceBean1.setIrNyknkkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skHurikominyuukinteiseilistDataSourceBean2.setIrNyknkkngk(BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR));
        skHurikominyuukinteiseilistDataSourceBean3.setIrNyknkkngk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skHurikominyuukinteiseilistDataSourceBean4.setIrNyknkkngk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skHurikominyuukinteiseilistDataSourceBean5.setIrNyknkkngk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skHurikominyuukinteiseilistDataSourceBean6.setIrNyknkkngk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skHurikominyuukinteiseilistDataSourceBean7.setIrNyknkkngk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skHurikominyuukinteiseilistDataSourceBean8.setIrNyknkkngk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skHurikominyuukinteiseilistDataSourceBean9.setIrNyknkkngk(BizCurrency.valueOf(0));
        skHurikominyuukinteiseilistDataSourceBean10.setIrNyknkkngk(BizCurrency.valueOf(1000));
        skHurikominyuukinteiseilistDataSourceBean11.setIrNyknkkngk(BizCurrency.valueOf(9999999999L));
        skHurikominyuukinteiseilistDataSourceBean12.setIrNyknkkngk(BizCurrency.valueOf(999));
        skHurikominyuukinteiseilistDataSourceBean13.setIrNyknkkngk(BizCurrency.valueOf(9999));
        skHurikominyuukinteiseilistDataSourceBean14.setIrNyknkkngk(BizCurrency.valueOf(9.1));
        skHurikominyuukinteiseilistDataSourceBean15.setIrNyknkkngk(BizCurrency.valueOf(9.22));
        skHurikominyuukinteiseilistDataSourceBean16.setIrNyknkkngk(BizCurrency.valueOf(9.333));

        dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean1);
        dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean2);
        dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean3);
        dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean4);
        dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean5);
        dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean6);
        dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean7);
        dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean8);
        dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean9);
        dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean10);
        dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean11);
        dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean12);
        dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean13);
        dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean14);
        dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean15);
        dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean16);


        reportTestBean.addParamObjects(dataSouceList, skHurikominyuukinteiseilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHuriKominYuukinteiseiListTest", C_SyoruiCdKbn.SK_HURIKOMINYKNTEISEILIST_ENKA_YENDT);

        skHurikominyuukinteiseilistBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHurikominyuukinteiseilistBean.setIrTyouhyousakuseiymd("w99.99.99");
        skHurikominyuukinteiseilistBean.setIrSyoruicd(C_SyoruiCdKbn.SK_HURIKOMINYKNTEISEILIST_ENKA_YENDT);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 14985; i++) {
            SkHurikominyuukinteiseilistDataSourceBean skHurikominyuukinteiseilistDataSourceBean = new SkHurikominyuukinteiseilistDataSourceBean();

            skHurikominyuukinteiseilistDataSourceBean.setIrBankcd("wwww");
            skHurikominyuukinteiseilistDataSourceBean.setIrSitencd("www");
            skHurikominyuukinteiseilistDataSourceBean.setIrYokinkbn(C_YokinKbn.HUTUU);
            skHurikominyuukinteiseilistDataSourceBean.setIrKouzano("wwwwwwwwwwww");
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirninnm48("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skHurikominyuukinteiseilistDataSourceBean.setIrNyknkkngk(BizCurrency.valueOf(1));
            skHurikominyuukinteiseilistDataSourceBean.setIrKsnymd("99999999");
            skHurikominyuukinteiseilistDataSourceBean.setIrKnjyymd("99999999");
            skHurikominyuukinteiseilistDataSourceBean.setIrIribaraikbn("w");
            skHurikominyuukinteiseilistDataSourceBean.setIrTrhkkbn("ww");
            skHurikominyuukinteiseilistDataSourceBean.setIrHrkmirnincd("wwwwwwwwww");

            dataSouceList.add(skHurikominyuukinteiseilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHurikominyuukinteiseilistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
