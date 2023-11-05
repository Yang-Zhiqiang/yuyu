package yuyu.report.biz;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzSikinIdouListYendthnkbunBean;
import yuyu.def.biz.bean.report.BzSikinIdouListYendthnkbunDataSourceBean;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 資金移動リスト（円建変更分） 帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzSikinidouListEndthnkTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzSikinIdouListYendthnkbunBean bzSikinIdouListYendthnkbunBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListEndthnkTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_YENDTHNK);

        bzSikinIdouListYendthnkbunBean.setIrSyoribiwareki(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean.setIrKeirisikinidougroupno(null);
        bzSikinIdouListYendthnkbunDataSourceBean.setIrSikinidoukbnnm(null);
        bzSikinIdouListYendthnkbunDataSourceBean.setIrKeirisiteituukasyu(null);
        bzSikinIdouListYendthnkbunDataSourceBean.setIrSeg1cd(null);
        bzSikinIdouListYendthnkbunDataSourceBean.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListYendthnkbunDataSourceBean.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListYendthnkbunDataSourceBean.setIrKeiritrhktuukagk(null);
        bzSikinIdouListYendthnkbunDataSourceBean.setIrKeiriyendthnkkbnnm(null);
        bzSikinIdouListYendthnkbunDataSourceBean.setIrSikinidoulisttyuukimsg(null);
        bzSikinIdouListYendthnkbunDataSourceBean.setSiteituukagoukeigk(null);
        bzSikinIdouListYendthnkbunDataSourceBean.setTrhktuukagoukeigk(null);

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListYendthnkbunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListEndthnkTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_YENDTHNK);

        bzSikinIdouListYendthnkbunBean.setIrSyoribiwareki("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListYendthnkbunDataSourceBean.setIrSikinidoukbnnm("");
        bzSikinIdouListYendthnkbunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.BLNK);
        bzSikinIdouListYendthnkbunDataSourceBean.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListYendthnkbunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.BLNK);
        bzSikinIdouListYendthnkbunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(0));
        bzSikinIdouListYendthnkbunDataSourceBean.setIrKeiriyendthnkkbnnm("");
        bzSikinIdouListYendthnkbunDataSourceBean.setIrSikinidoulisttyuukimsg("");
        bzSikinIdouListYendthnkbunDataSourceBean.setSiteituukagoukeigk(BizCurrency.valueOf(0));
        bzSikinIdouListYendthnkbunDataSourceBean.setTrhktuukagoukeigk(BizCurrency.valueOf(0));

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListYendthnkbunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListEndthnkTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_YENDTHNK);

        bzSikinIdouListYendthnkbunBean.setIrSyoribiwareki("2002年 7月 2日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean1 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrSikinidoukbnnm("資金移動区分名");
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(1500));
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiriyendthnkkbnnm("");
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrSikinidoulisttyuukimsg("注記");
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean1);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean2 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrSikinidoukbnnm("資金移動区分名");
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(5000, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(5500));
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeiriyendthnkkbnnm("取消分");
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrSikinidoulisttyuukimsg("注記");
        bzSikinIdouListYendthnkbunDataSourceBean2.setSiteituukagoukeigk(BizCurrency.valueOf(6000));
        bzSikinIdouListYendthnkbunDataSourceBean2.setTrhktuukagoukeigk(BizCurrency.valueOf(7000));
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListYendthnkbunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListEndthnkTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_YENDTHNK);

        bzSikinIdouListYendthnkbunBean.setIrSyoribiwareki("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean1 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(999999999999999l));
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiriyendthnkkbnnm("");
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrSikinidoulisttyuukimsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean1);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean2 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(0));
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeiriyendthnkkbnnm("ＷＷＷＷＷ");
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrSikinidoulisttyuukimsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListYendthnkbunDataSourceBean2.setSiteituukagoukeigk(BizCurrency.valueOf(9999999999999.99));
        bzSikinIdouListYendthnkbunDataSourceBean2.setTrhktuukagoukeigk(BizCurrency.valueOf(999999999999999L));
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListYendthnkbunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListEndthnkTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_YENDTHNK);

        bzSikinIdouListYendthnkbunBean.setIrSyoribiwareki("2002年 7月 2日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean1 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrSikinidoukbnnm("資金移動区分名１");
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.1));
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiriyendthnkkbnnm("");
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrSikinidoulisttyuukimsg("円建変更取消が発生した場合は、取引通貨額を円本口座から外貨本口座へ資金移動");
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean1);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean2 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrSikinidoukbnnm("資金移動区分名１");
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(0));
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeiriyendthnkkbnnm("取消分");
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrSikinidoulisttyuukimsg("円建変更取消が発生した場合は、取引通貨額を円本口座から外貨本口座へ資金移動");
        bzSikinIdouListYendthnkbunDataSourceBean2.setSiteituukagoukeigk(BizCurrency.valueOf(4.1));
        bzSikinIdouListYendthnkbunDataSourceBean2.setTrhktuukagoukeigk(BizCurrency.valueOf(9.1));

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean2);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean3 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean3.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean3.setIrSikinidoukbnnm("資金移動区分名２");
        bzSikinIdouListYendthnkbunDataSourceBean3.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean3.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean3.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.21, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean3.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean3.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.22));
        bzSikinIdouListYendthnkbunDataSourceBean3.setIrKeiriyendthnkkbnnm("");
        bzSikinIdouListYendthnkbunDataSourceBean3.setIrSikinidoulisttyuukimsg("円建変更取消が発生した場合は、取引通貨額を円本口座から外貨本口座へ資金移動");
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean3);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean4 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean4.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrSikinidoukbnnm("資金移動区分名２");
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrKeiritrhktuukagk(BizCurrency.valueOf(0));
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrKeiriyendthnkkbnnm("取消分");
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrSikinidoulisttyuukimsg("円建変更取消が発生した場合は、取引通貨額を円本口座から外貨本口座へ資金移動");
        bzSikinIdouListYendthnkbunDataSourceBean4.setSiteituukagoukeigk(BizCurrency.valueOf(4.21));
        bzSikinIdouListYendthnkbunDataSourceBean4.setTrhktuukagoukeigk(BizCurrency.valueOf(9.22));
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean4);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean5 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean5.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean5.setIrSikinidoukbnnm("資金移動区分名２");
        bzSikinIdouListYendthnkbunDataSourceBean5.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean5.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean5.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.321, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean5.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean5.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.333));
        bzSikinIdouListYendthnkbunDataSourceBean5.setIrKeiriyendthnkkbnnm("");
        bzSikinIdouListYendthnkbunDataSourceBean5.setIrSikinidoulisttyuukimsg("円建変更取消が発生した場合は、取引通貨額を円本口座から外貨本口座へ資金移動");
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean5);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean6 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean6.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean6.setIrSikinidoukbnnm("資金移動区分名２");
        bzSikinIdouListYendthnkbunDataSourceBean6.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean6.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean6.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean6.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean6.setIrKeiritrhktuukagk(BizCurrency.valueOf(0));
        bzSikinIdouListYendthnkbunDataSourceBean6.setIrKeiriyendthnkkbnnm("取消分");
        bzSikinIdouListYendthnkbunDataSourceBean6.setIrSikinidoulisttyuukimsg("円建変更取消が発生した場合は、取引通貨額を円本口座から外貨本口座へ資金移動");
        bzSikinIdouListYendthnkbunDataSourceBean6.setSiteituukagoukeigk(BizCurrency.valueOf(4.321));
        bzSikinIdouListYendthnkbunDataSourceBean6.setTrhktuukagoukeigk(BizCurrency.valueOf(9.333));
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean6);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean7 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean7.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListYendthnkbunDataSourceBean7.setIrSikinidoukbnnm("資金移動区分名２");
        bzSikinIdouListYendthnkbunDataSourceBean7.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean7.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean7.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.321, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean7.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean7.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.333));
        bzSikinIdouListYendthnkbunDataSourceBean7.setIrKeiriyendthnkkbnnm("");
        bzSikinIdouListYendthnkbunDataSourceBean7.setIrSikinidoulisttyuukimsg("円建変更取消が発生した場合は、取引通貨額を円本口座から外貨本口座へ資金移動");
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean7);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean8 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean8.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrSikinidoukbnnm("資金移動区分名２");
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrKeiritrhktuukagk(BizCurrency.valueOf(0));
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrKeiriyendthnkkbnnm("取消分");
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrSikinidoulisttyuukimsg("円建変更取消が発生した場合は、取引通貨額を円本口座から外貨本口座へ資金移動");
        bzSikinIdouListYendthnkbunDataSourceBean8.setSiteituukagoukeigk(BizCurrency.valueOf(4.321));
        bzSikinIdouListYendthnkbunDataSourceBean8.setTrhktuukagoukeigk(BizCurrency.valueOf(9.333));
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean8);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListYendthnkbunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListEndthnkTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_YENDTHNK);

        bzSikinIdouListYendthnkbunBean.setIrSyoribiwareki("2002年 7月 2日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean1 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(101, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(999));
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiriyendthnkkbnnm("");

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean2 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(0));
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeiriyendthnkkbnnm("取消分");
        bzSikinIdouListYendthnkbunDataSourceBean2.setSiteituukagoukeigk(BizCurrency.valueOf(101));
        bzSikinIdouListYendthnkbunDataSourceBean2.setTrhktuukagoukeigk(BizCurrency.valueOf(999));

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean1);
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListYendthnkbunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListEndthnkTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_YENDTHNK);

        bzSikinIdouListYendthnkbunBean.setIrSyoribiwareki("2002年 7月 2日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 32966; i++) {

            BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean = new BzSikinIdouListYendthnkbunDataSourceBean();

            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
            bzSikinIdouListYendthnkbunDataSourceBean.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(1));
            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeiriyendthnkkbnnm("取消分");

            dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean);
        }

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean1 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(1));
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiriyendthnkkbnnm("取消分");
        bzSikinIdouListYendthnkbunDataSourceBean1.setSiteituukagoukeigk(BizCurrency.valueOf(32967));
        bzSikinIdouListYendthnkbunDataSourceBean1.setTrhktuukagoukeigk(BizCurrency.valueOf(32967));

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListYendthnkbunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListEndthnkTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_YENDTHNK);

        bzSikinIdouListYendthnkbunBean.setIrSyoribiwareki("2002年 7月 2日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i <= 31; i++) {

            BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean = new BzSikinIdouListYendthnkbunDataSourceBean();

            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
            bzSikinIdouListYendthnkbunDataSourceBean.setIrSikinidoukbnnm("資金移動区分名１");
            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
            bzSikinIdouListYendthnkbunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(202));
            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(2002));
            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeiriyendthnkkbnnm("取消分");

            dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean);
        }

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean1 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrSikinidoukbnnm("資金移動区分名１");
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(202));
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(2002));
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiriyendthnkkbnnm("取消分");
        bzSikinIdouListYendthnkbunDataSourceBean1.setSiteituukagoukeigk(BizCurrency.valueOf(6464));
        bzSikinIdouListYendthnkbunDataSourceBean1.setTrhktuukagoukeigk(BizCurrency.valueOf(64064));

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListYendthnkbunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListEndthnkTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_YENDTHNK);

        bzSikinIdouListYendthnkbunBean.setIrSyoribiwareki("2002年 7月 2日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i <= 32; i++) {

            BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean = new BzSikinIdouListYendthnkbunDataSourceBean();

            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
            bzSikinIdouListYendthnkbunDataSourceBean.setIrSikinidoukbnnm("資金移動区分名１");
            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
            bzSikinIdouListYendthnkbunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(202));
            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(2002));
            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeiriyendthnkkbnnm("取消分");

            dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean);
        }

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean1 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrSikinidoukbnnm("資金移動区分名１");
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(202));
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(2002));
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiriyendthnkkbnnm("取消分");
        bzSikinIdouListYendthnkbunDataSourceBean1.setSiteituukagoukeigk(BizCurrency.valueOf(6666));
        bzSikinIdouListYendthnkbunDataSourceBean1.setTrhktuukagoukeigk(BizCurrency.valueOf(66066));

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListYendthnkbunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListEndthnkTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_YENDTHNK);

        bzSikinIdouListYendthnkbunBean.setIrSyoribiwareki("2002年 7月 2日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i <= 33; i++) {

            BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean = new BzSikinIdouListYendthnkbunDataSourceBean();

            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
            bzSikinIdouListYendthnkbunDataSourceBean.setIrSikinidoukbnnm("資金移動区分名１");
            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
            bzSikinIdouListYendthnkbunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(202));
            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(2002));
            bzSikinIdouListYendthnkbunDataSourceBean.setIrKeiriyendthnkkbnnm("取消分");

            dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean);

        }

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean1 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrSikinidoukbnnm("資金移動区分名１");
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(202));
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(2002));
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiriyendthnkkbnnm("取消分");
        bzSikinIdouListYendthnkbunDataSourceBean1.setSiteituukagoukeigk(BizCurrency.valueOf(6868));
        bzSikinIdouListYendthnkbunDataSourceBean1.setTrhktuukagoukeigk(BizCurrency.valueOf(68068));

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListYendthnkbunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListEndthnkTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_YENDTHNK);

        bzSikinIdouListYendthnkbunBean.setIrSyoribiwareki("2002年 7月 2日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListYendthnkbunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListEndthnkTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_YENDTHNK);

        bzSikinIdouListYendthnkbunBean.setIrSyoribiwareki("2002年 7月 2日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean1 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.1));
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean1);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean2 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(5));

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean2);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean3 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean3.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean3.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean3.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListYendthnkbunDataSourceBean3.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.3, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean3.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean3.setIrKeiritrhktuukagk(BizCurrency.valueOf(6));
        bzSikinIdouListYendthnkbunDataSourceBean3.setSiteituukagoukeigk(BizCurrency.valueOf(12.6));
        bzSikinIdouListYendthnkbunDataSourceBean3.setTrhktuukagoukeigk(BizCurrency.valueOf(20.1));
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean3);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean4 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean4.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.1, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrKeiritrhktuukagk(BizCurrency.valueOf(6));

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean4);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean5 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean5.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean5.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean5.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean5.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean5.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean5.setIrKeiritrhktuukagk(BizCurrency.valueOf(7));

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean5);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean6 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean6.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean6.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean6.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean6.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.3, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean6.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean6.setIrKeiritrhktuukagk(BizCurrency.valueOf(8));
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean6);


        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean7 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean7.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean7.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean7.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean7.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.4, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean7.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean7.setIrKeiritrhktuukagk(BizCurrency.valueOf(9));

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean7);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean8 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean8.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.5, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrKeiritrhktuukagk(BizCurrency.valueOf(5));
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean8);


        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean9 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean9.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean9.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean9.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListYendthnkbunDataSourceBean9.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.6, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean9.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean9.setIrKeiritrhktuukagk(BizCurrency.valueOf(8));
        bzSikinIdouListYendthnkbunDataSourceBean9.setSiteituukagoukeigk(BizCurrency.valueOf(26.1));
        bzSikinIdouListYendthnkbunDataSourceBean9.setTrhktuukagoukeigk(BizCurrency.valueOf(43));

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean9);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean10 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean10.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean10.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean10.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean10.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.1, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean10.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean10.setIrKeiritrhktuukagk(BizCurrency.valueOf(5));

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean10);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean11 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean11.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean11.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean11.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean11.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean11.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean11.setIrKeiritrhktuukagk(BizCurrency.valueOf(6));

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean11);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean12 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean12.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean12.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean12.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean12.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.3, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean12.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean12.setIrKeiritrhktuukagk(BizCurrency.valueOf(7));
        bzSikinIdouListYendthnkbunDataSourceBean12.setIrKeiriyendthnkkbnnm("取消分");

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean12);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean13 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean13.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean13.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean13.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean13.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.1, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean13.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean13.setIrKeiritrhktuukagk(BizCurrency.valueOf(5));

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean13);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean14 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean14.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean14.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean14.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean14.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean14.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean14.setIrKeiritrhktuukagk(BizCurrency.valueOf(6));

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean14);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean15 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean15.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean15.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean15.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean15.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.3, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean15.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean15.setIrKeiritrhktuukagk(BizCurrency.valueOf(7));
        bzSikinIdouListYendthnkbunDataSourceBean15.setIrKeiriyendthnkkbnnm("取消分");

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean15);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean16 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean16.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean16.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean16.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListYendthnkbunDataSourceBean16.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.1, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean16.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean16.setIrKeiritrhktuukagk(BizCurrency.valueOf(5));

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean16);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean17 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean17.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean17.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean17.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListYendthnkbunDataSourceBean17.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean17.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean17.setIrKeiritrhktuukagk(BizCurrency.valueOf(6));

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean17);

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean18 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean18.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean18.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean18.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListYendthnkbunDataSourceBean18.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4.3, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean18.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean18.setIrKeiritrhktuukagk(BizCurrency.valueOf(7));
        bzSikinIdouListYendthnkbunDataSourceBean18.setIrKeiriyendthnkkbnnm("取消分");
        bzSikinIdouListYendthnkbunDataSourceBean18.setSiteituukagoukeigk(BizCurrency.valueOf(37.8));
        bzSikinIdouListYendthnkbunDataSourceBean18.setTrhktuukagoukeigk(BizCurrency.valueOf(54));

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean18);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListYendthnkbunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzSikinidouListEndthnkTest", C_SyoruiCdKbn.CM_SIKINIDOULIST_YENDTHNK);

        bzSikinIdouListYendthnkbunBean.setIrSyoribiwareki("2020年12月12日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean1 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrSikinidoukbnnm("");
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999L, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(333333333333333L));
        bzSikinIdouListYendthnkbunDataSourceBean1.setIrKeiriyendthnkkbnnm("");

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean2 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrSikinidoukbnnm("");
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999L, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(333333333333333L));
        bzSikinIdouListYendthnkbunDataSourceBean2.setIrKeiriyendthnkkbnnm("");
        bzSikinIdouListYendthnkbunDataSourceBean2.setSiteituukagoukeigk(BizCurrency.valueOf(19999999999998L, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean2.setTrhktuukagoukeigk(BizCurrency.valueOf(666666666666666L));

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean3 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean3.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean3.setIrSikinidoukbnnm("円建変更取消分");
        bzSikinIdouListYendthnkbunDataSourceBean3.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean3.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean3.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999L, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean3.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean3.setIrKeiritrhktuukagk(BizCurrency.valueOf(333333333333333L));
        bzSikinIdouListYendthnkbunDataSourceBean3.setIrKeiriyendthnkkbnnm("取消分");

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean4 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean4.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrSikinidoukbnnm("円建変更取消分");
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999L, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrKeiritrhktuukagk(BizCurrency.valueOf(333333333333333L));
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrKeiriyendthnkkbnnm("取消分");
        bzSikinIdouListYendthnkbunDataSourceBean4.setSiteituukagoukeigk(BizCurrency.valueOf(19999999999998L, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean4.setTrhktuukagoukeigk(BizCurrency.valueOf(666666666666666L));
        bzSikinIdouListYendthnkbunDataSourceBean4.setIrSikinidoulisttyuukimsg("円建変更取消が発生した場合は、取引通貨額を円本口座から外貨本口座へ資金移動");

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean5 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean5.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean5.setIrSikinidoukbnnm("");
        bzSikinIdouListYendthnkbunDataSourceBean5.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean5.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean5.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999L, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean5.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean5.setIrKeiritrhktuukagk(BizCurrency.valueOf(333333333333333L));
        bzSikinIdouListYendthnkbunDataSourceBean5.setIrKeiriyendthnkkbnnm("");

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean6 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean6.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean6.setIrSikinidoukbnnm("");
        bzSikinIdouListYendthnkbunDataSourceBean6.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean6.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean6.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999L, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean6.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean6.setIrKeiritrhktuukagk(BizCurrency.valueOf(333333333333333L));
        bzSikinIdouListYendthnkbunDataSourceBean6.setIrKeiriyendthnkkbnnm("");
        bzSikinIdouListYendthnkbunDataSourceBean6.setSiteituukagoukeigk(BizCurrency.valueOf(19999999999998L, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean6.setTrhktuukagoukeigk(BizCurrency.valueOf(666666666666666L));

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean7 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean7.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean7.setIrSikinidoukbnnm("円建変更取消分");
        bzSikinIdouListYendthnkbunDataSourceBean7.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean7.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean7.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999L, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean7.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean7.setIrKeiritrhktuukagk(BizCurrency.valueOf(333333333333333L));
        bzSikinIdouListYendthnkbunDataSourceBean7.setIrKeiriyendthnkkbnnm("取消分");

        BzSikinIdouListYendthnkbunDataSourceBean bzSikinIdouListYendthnkbunDataSourceBean8 = new BzSikinIdouListYendthnkbunDataSourceBean();

        bzSikinIdouListYendthnkbunDataSourceBean8.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrSikinidoukbnnm("円建変更取消分");
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999L, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrKeiritrhktuukagk(BizCurrency.valueOf(333333333333333L));
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrKeiriyendthnkkbnnm("取消分");
        bzSikinIdouListYendthnkbunDataSourceBean8.setSiteituukagoukeigk(BizCurrency.valueOf(19999999999998L, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListYendthnkbunDataSourceBean8.setTrhktuukagoukeigk(BizCurrency.valueOf(666666666666666L));
        bzSikinIdouListYendthnkbunDataSourceBean8.setIrSikinidoulisttyuukimsg("円建変更取消が発生した場合は、取引通貨額を円本口座から外貨本口座へ資金移動");

        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean1);
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean2);
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean3);
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean4);
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean5);
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean6);
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean7);
        dataSouceList.add(bzSikinIdouListYendthnkbunDataSourceBean8);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListYendthnkbunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
