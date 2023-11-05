package yuyu.report.biz;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzSikinIdouListSokujibunBean;
import yuyu.def.biz.bean.report.BzSikinIdouListSokujibunDataSourceBean;
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
 * 資金移動リスト（即時分）帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzSikinIdouListSokujiTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzSikinIdouListSokujibunBean bzSikinIdouListSokujibunBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulistsokuji", C_SyoruiCdKbn.CM_SIKINIDOULIST_SOKUJI);

        bzSikinIdouListSokujibunBean.setIrSyoribiwareki(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean1 = new BzSikinIdouListSokujibunDataSourceBean();
        bzSikinIdouListSokujibunDataSourceBean1.setIrSikinidoukbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisikinidougroupno(null);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean1.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKaipageno(null);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean2 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean2.setIrSikinidoukbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisikinidougroupno(null);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisiteituukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean2.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKaipageno(null);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean3 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean3.setIrSikinidoukbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisikinidougroupno(null);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukagkskeigk(null);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeiritrhktuukagkskei(null);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKaipageno(null);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukagkkei(null);

        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean1);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean2);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListSokujibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulistsokuji", C_SyoruiCdKbn.CM_SIKINIDOULIST_SOKUJI);

        bzSikinIdouListSokujibunBean.setIrSyoribiwareki(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean1 = new BzSikinIdouListSokujibunDataSourceBean();
        bzSikinIdouListSokujibunDataSourceBean1.setIrSikinidoukbnnm("");
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.BLNK);
        bzSikinIdouListSokujibunDataSourceBean1.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.BLNK);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKaipageno(null);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean2 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean2.setIrSikinidoukbnnm("");
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.BLNK);
        bzSikinIdouListSokujibunDataSourceBean2.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.BLNK);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListSokujibunDataSourceBean2.setIrKaipageno(null);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean3 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean3.setIrSikinidoukbnnm("");
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukasyu(C_Tuukasyu.BLNK);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukagkskeigk(null);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeiritrhktuukagkskei(null);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKaipageno(null);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukagkkei(null);

        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean1);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean2);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListSokujibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulistsokuji", C_SyoruiCdKbn.CM_SIKINIDOULIST_SOKUJI);

        bzSikinIdouListSokujibunBean.setIrSyoribiwareki("2018年 7月 2日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean1 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean1.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(3000));
        bzSikinIdouListSokujibunDataSourceBean1.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean2 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean2.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean2.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(0));
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean2.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean3 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean3.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeiritrhktuukagk(BizCurrency.valueOf(3000));
        bzSikinIdouListSokujibunDataSourceBean3.setIrKaipageno(0);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukagkkei(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));

        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean1);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean2);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListSokujibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulistsokuji", C_SyoruiCdKbn.CM_SIKINIDOULIST_SOKUJI);

        bzSikinIdouListSokujibunBean.setIrSyoribiwareki("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean1 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean1.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean1.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean1.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean2 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean2.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean2.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisikinidoumeisaikbnnm("ＷＷＷＷＷ");
        bzSikinIdouListSokujibunDataSourceBean2.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean3 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean3.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean3.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean4 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean4.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean4.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean5 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean5.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean5.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean6 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean6.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean6.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeiritrhktuukagk(BizCurrency.valueOf(999999999999999l));
        bzSikinIdouListSokujibunDataSourceBean6.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean7 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean7.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeiritrhktuukagk(BizCurrency.valueOf(999999999999999l));
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisikinidoumeisaikbnnm("ＷＷＷＷＷ");
        bzSikinIdouListSokujibunDataSourceBean7.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean8 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean8.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(999999999999999l, BizCurrencyTypes.YEN));
        bzSikinIdouListSokujibunDataSourceBean8.setIrKaipageno(0);

        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.DOLLAR));

        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean1);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean2);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean3);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean4);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean5);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean6);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean7);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean8);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListSokujibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulistsokuji", C_SyoruiCdKbn.CM_SIKINIDOULIST_SOKUJI);

        bzSikinIdouListSokujibunBean.setIrSyoribiwareki("平成28年 7月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean1 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean1.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(101, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(301));
        bzSikinIdouListSokujibunDataSourceBean1.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean2 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean2.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean2.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1001, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(3001));
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean2.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean3 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean3.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(1102, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(3302));
        bzSikinIdouListSokujibunDataSourceBean3.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean4 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean4.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean4.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean5 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean5.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean5.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean6 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean6.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean6.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeiritrhktuukagk(BizCurrency.valueOf(4.1));
        bzSikinIdouListSokujibunDataSourceBean6.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean7 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean7.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean7.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1.21, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeiritrhktuukagk(BizCurrency.valueOf(4.21, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean7.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean8 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean8.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean8.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1.321, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeiritrhktuukagk(BizCurrency.valueOf(4.321, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean8.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean9 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean9.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean9.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeiritrhktuukagk(BizCurrency.valueOf(4000, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean9.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean10 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean10.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(3.631, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(4012.631, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean10.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean11 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean11.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean11.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean11.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean12 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean12.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean12.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean12.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean13 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean13.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean13.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean13.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean13.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean13.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(401, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean13.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean13.setIrKeiritrhktuukagk(BizCurrency.valueOf(401, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean13.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean14 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean14.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean14.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean14.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean14.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean14.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(4001, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean14.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean14.setIrKeiritrhktuukagk(BizCurrency.valueOf(4001, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean14.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean14.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean15 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean15.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean15.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean15.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean15.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(4402, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean15.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean15.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(4402, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean15.setIrKaipageno(0);
        bzSikinIdouListSokujibunDataSourceBean15.setIrKeirisiteituukagkkei(BizCurrency.valueOf(1105.631, BizCurrencyTypes.DOLLAR));

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean16 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean16.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean16.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean16.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean16.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean16.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean16.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean16.setIrKeiritrhktuukagk(BizCurrency.valueOf(999));
        bzSikinIdouListSokujibunDataSourceBean16.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean17 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean17.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean17.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeiritrhktuukagk(BizCurrency.valueOf(0));
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean17.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean18 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean18.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(999));
        bzSikinIdouListSokujibunDataSourceBean18.setIrKaipageno(0);
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeirisiteituukagkkei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean19 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean19.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean19.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.4, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.4));
        bzSikinIdouListSokujibunDataSourceBean19.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean20= new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean20.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean20.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean20.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean20.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean20.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean20.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean20.setIrKeiritrhktuukagk(BizCurrency.valueOf(0));
        bzSikinIdouListSokujibunDataSourceBean20.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean20.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean21 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean21.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean21.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean21.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean21.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(9.4, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean21.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean21.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(9.4));
        bzSikinIdouListSokujibunDataSourceBean21.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean22 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean22.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean22.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean22.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean22.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean22.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean22.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean22.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean22.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean22.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean23 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean23.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean23.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean23.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean23.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean23.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean23.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean23.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean23.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean23.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean24 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean24.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean24.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.54, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.54, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean24.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean25 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean25.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean25.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean25.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean25.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean25.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean25.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean25.setIrKeiritrhktuukagk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean25.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean25.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean26 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean26.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean26.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean26.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean26.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(9.54, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean26.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean26.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(9.54, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean26.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean27 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean27.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean27.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean27.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean27.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean27.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean27.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean27.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean27.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean27.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean28 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean28.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean28.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean28.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean28.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean28.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean28.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean28.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean28.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean28.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean29 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean29.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean29.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean29.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean29.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean29.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.654, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean29.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean29.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.654, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean29.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean30 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean30.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean30.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean30.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean30.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean30.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean30.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean30.setIrKeiritrhktuukagk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean30.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean30.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean31 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean31.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean31.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean31.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean31.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(9.654, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean31.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean31.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(9.654, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean31.setIrKaipageno(0);
        bzSikinIdouListSokujibunDataSourceBean31.setIrKeirisiteituukagkkei(BizCurrency.valueOf(28.594, BizCurrencyTypes.DOLLAR));

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean32 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean32.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean32.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean32.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean32.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean32.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean32.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean32.setIrKeiritrhktuukagk(BizCurrency.valueOf(999, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean32.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean33 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean33.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean33.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean33.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean33.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean33.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean33.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean33.setIrKeiritrhktuukagk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean33.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean33.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean34 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean34.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean34.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean34.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean34.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean34.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean34.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(999, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean34.setIrKaipageno(0);
        bzSikinIdouListSokujibunDataSourceBean34.setIrKeirisiteituukagkkei(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean1);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean2);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean3);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean4);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean5);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean6);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean7);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean8);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean9);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean10);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean11);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean12);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean13);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean14);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean15);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean16);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean17);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean18);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean19);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean20);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean21);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean22);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean23);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean24);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean25);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean26);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean27);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean28);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean29);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean30);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean31);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean32);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean33);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean34);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListSokujibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulistsokuji", C_SyoruiCdKbn.CM_SIKINIDOULIST_SOKUJI);

        bzSikinIdouListSokujibunBean.setIrSyoribiwareki("平成28年 7月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean1 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean1.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.4, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.4, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean1.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean2 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean2.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean2.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean2.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean3 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean3.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean3.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(9.4, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(9.4, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean3.setIrKaipageno(0);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9.4, BizCurrencyTypes.DOLLAR));

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean4 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean4.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean4.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.54, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.54, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean4.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean5 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean5.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean5.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeiritrhktuukagk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean5.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean6 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean6.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean6.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(9.54, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(9.54, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean6.setIrKaipageno(0);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9.54, BizCurrencyTypes.AU_DOLLAR));

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean7 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean7.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean7.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9.654, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeiritrhktuukagk(BizCurrency.valueOf(9.654, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean7.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean8 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean8.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean8.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeiritrhktuukagk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean8.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean9 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean9.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(9.654, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(9.654, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean9.setIrKaipageno(0);
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9.654, BizCurrencyTypes.DOLLAR));

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean10 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean10.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean10.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeiritrhktuukagk(BizCurrency.valueOf(9999, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean10.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean11 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean11.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean11.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeiritrhktuukagk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean11.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean12 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean12.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(9999, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean12.setIrKaipageno(0);
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean1);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean2);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean3);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean4);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean5);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean6);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean7);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean8);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean9);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean10);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean11);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean12);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListSokujibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulistsokuji", C_SyoruiCdKbn.CM_SIKINIDOULIST_SOKUJI);

        bzSikinIdouListSokujibunBean.setIrSyoribiwareki("平成28年 7月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean1 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean1.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean1.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean2 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean2.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean2.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean2.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean3 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean3.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean3.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean4 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean4.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean4.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(999, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeiritrhktuukagk(BizCurrency.valueOf(999, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean4.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean5 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean5.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean5.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeiritrhktuukagk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean5.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean6 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean6.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(999, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(999, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean6.setIrKaipageno(0);

        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisiteituukagkkei(BizCurrency.valueOf(999, BizCurrencyTypes.DOLLAR));

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean7 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean7.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean7.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeiritrhktuukagk(BizCurrency.valueOf(999, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean7.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean8 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean8.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean8.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeiritrhktuukagk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean8.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean9 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean9.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(999, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean9.setIrKaipageno(0);
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeirisiteituukagkkei(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean1);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean2);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean3);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean4);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean5);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean6);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean7);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean8);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean9);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListSokujibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulistsokuji", C_SyoruiCdKbn.CM_SIKINIDOULIST_SOKUJI);

        bzSikinIdouListSokujibunBean.setIrSyoribiwareki("平成28年 7月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

        for (int i = 1; i <= 4; i++) {

            bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

            if (i%2 ==0) {

                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1111111111111.00, BizCurrencyTypes.DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(111111111111111l));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
            }
            else {
                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1000000000000.00, BizCurrencyTypes.DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(100000000000000l));
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
            }

            dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean);
        }

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean5 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean5.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean5.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(4222222222222.00, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(422222222222222l));
        bzSikinIdouListSokujibunDataSourceBean5.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean6 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean6.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean6.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean7 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean7.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean7.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKaipageno(0);

        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean5);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean6);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean7);

        for (int i = 1; i <= 4; i++) {

            bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

            if (i%2 ==0) {

                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1111111111111.00, BizCurrencyTypes.DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(1111111111111.00, BizCurrencyTypes.DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
            }
            else {
                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1000000000000.00, BizCurrencyTypes.DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(1000000000000.00, BizCurrencyTypes.DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
            }

            dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean);
        }

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean12 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean12.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean12.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(4222222222222.00, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(4222222222222.00, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean12.setIrKaipageno(0);
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeirisiteituukagkkei(BizCurrency.valueOf(8444444444444.00, BizCurrencyTypes.DOLLAR));

        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean12);

        for (int i = 1; i <= 4; i++) {

            bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

            if (i%2 ==0) {

                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1111111111111.00, BizCurrencyTypes.AU_DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(111111111111111l));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
            }
            else {
                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1000000000000.00, BizCurrencyTypes.AU_DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(100000000000000l));
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
            }

            dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean);
        }

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean17 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean17.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean17.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(4222222222222.00, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(422222222222222l));
        bzSikinIdouListSokujibunDataSourceBean17.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean18 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean18.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean18.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean18.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean19 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean19.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean19.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean19.setIrKaipageno(0);

        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean17);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean18);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean19);

        for (int i = 1; i <= 4; i++) {

            bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

            if (i%2 ==0) {

                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1111111111111.00, BizCurrencyTypes.AU_DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(1111111111111.00, BizCurrencyTypes.DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
            }
            else {
                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1000000000000.00, BizCurrencyTypes.AU_DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(1000000000000.00, BizCurrencyTypes.DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
            }

            dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean);
        }

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean24 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean24.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean24.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(4222222222222.00, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(4222222222222.00, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean24.setIrKaipageno(0);
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeirisiteituukagkkei(BizCurrency.valueOf(8444444444444.00, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean24);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListSokujibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulistsokuji", C_SyoruiCdKbn.CM_SIKINIDOULIST_SOKUJI);

        bzSikinIdouListSokujibunBean.setIrSyoribiwareki("平成28年 7月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

        for (int i = 1; i <= 32; i++) {

            bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

            if (i%2 == 0) {
                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(103, BizCurrencyTypes.AU_DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(104));
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");

            }
            else {
                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(101, BizCurrencyTypes.AU_DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(102));
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
            }
            dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean);
        }

        bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(9999));
        bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
        bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkkei(BizCurrency.valueOf(999999, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListSokujibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulistsokuji", C_SyoruiCdKbn.CM_SIKINIDOULIST_SOKUJI);

        bzSikinIdouListSokujibunBean.setIrSyoribiwareki("平成28年 7月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

        for (int i = 1; i <= 34; i++) {

            bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

            if (i%2 == 0) {
                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(103, BizCurrencyTypes.AU_DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(104));
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");

            }
            else {
                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(101, BizCurrencyTypes.AU_DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(102));
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
            }
            dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean);
        }

        bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(999999, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(999999));
        bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
        bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkkei(BizCurrency.valueOf(999999, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListSokujibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulistsokuji", C_SyoruiCdKbn.CM_SIKINIDOULIST_SOKUJI);

        bzSikinIdouListSokujibunBean.setIrSyoribiwareki("平成28年 7月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

        for (int i = 1; i <= 36; i++) {

            bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

            if (i%2 == 0) {
                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(103, BizCurrencyTypes.AU_DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(104));
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");

            }
            else {
                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(101, BizCurrencyTypes.AU_DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(102));
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
            }
            dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean);
        }

        bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(9, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(9));
        bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
        bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkkei(BizCurrency.valueOf(99, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListSokujibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulistsokuji", C_SyoruiCdKbn.CM_SIKINIDOULIST_SOKUJI);

        bzSikinIdouListSokujibunBean.setIrSyoribiwareki("平成28年 7月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

        for (int i = 1; i <= 28; i++) {

            bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

            if (i%2 == 0) {
                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(103, BizCurrencyTypes.AU_DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(104));
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");

            }
            else {
                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(101, BizCurrencyTypes.AU_DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(102));
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
            }
            dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean);
        }

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean29 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean29.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean29.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean29.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean29.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean29.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean29.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(9999));
        bzSikinIdouListSokujibunDataSourceBean29.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean29.setIrKaipageno(0);
        bzSikinIdouListSokujibunDataSourceBean29.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9999999999l, BizCurrencyTypes.AU_DOLLAR));

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean30 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean30.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean30.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean30.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean30.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean30.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean30.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean30.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean30.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean30.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean31 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean31.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean31.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean31.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean31.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean31.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean31.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean31.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean31.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean31.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean32 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean32.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean32.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean32.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean32.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(10000, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean32.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean32.setIrKeiritrhktuukagk(BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean32.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean33 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean33.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean33.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean33.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean33.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean33.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean33.setIrKeiritrhktuukagk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean33.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean33.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean34 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean34.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean34.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean34.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean34.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean34.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean34.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(9999, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean34.setIrKaipageno(0);
        bzSikinIdouListSokujibunDataSourceBean34.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9999999999l, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean29);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean30);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean31);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean32);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean33);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean34);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListSokujibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulistsokuji", C_SyoruiCdKbn.CM_SIKINIDOULIST_SOKUJI);

        bzSikinIdouListSokujibunBean.setIrSyoribiwareki("平成28年 7月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

        for (int i = 1; i <= 34; i++) {

            bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

            if (i%2 == 0) {
                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(103, BizCurrencyTypes.AU_DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(104));
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");

            }
            else {
                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(101, BizCurrencyTypes.AU_DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(102));
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
            }
            dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean);
        }

        bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(9999));
        bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);

        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean);

        for (int i = 1; i <= 34; i++) {

            bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

            if (i%2 == 0) {
                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(105, BizCurrencyTypes.AU_DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(106, BizCurrencyTypes.DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(1);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");

            }
            else {
                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(107, BizCurrencyTypes.AU_DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(108, BizCurrencyTypes.DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(1);
            }

            dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean);
        }

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean1 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean1.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(9999));
        bzSikinIdouListSokujibunDataSourceBean1.setIrKaipageno(1);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9999999999l, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListSokujibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulistsokuji", C_SyoruiCdKbn.CM_SIKINIDOULIST_SOKUJI);

        bzSikinIdouListSokujibunBean.setIrSyoribiwareki("平成28年 7月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

        for (int i = 1; i <= 33964; i++) {

            bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

            if (i%2 == 0) {
                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(103, BizCurrencyTypes.AU_DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(104));
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");

            }
            else {
                bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
                bzSikinIdouListSokujibunDataSourceBean.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(101, BizCurrencyTypes.AU_DOLLAR));
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
                bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(102));
                bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
            }
            dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean);
        }

        bzSikinIdouListSokujibunDataSourceBean = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(99999999, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(99999999));
        bzSikinIdouListSokujibunDataSourceBean.setIrKaipageno(0);
        bzSikinIdouListSokujibunDataSourceBean.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9999999999999l, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListSokujibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulistsokuji", C_SyoruiCdKbn.CM_SIKINIDOULIST_SOKUJI);

        bzSikinIdouListSokujibunBean.setIrSyoribiwareki("平成28年 7月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean1 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean1.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzSikinIdouListSokujibunDataSourceBean1.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean2 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean2.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean2.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzSikinIdouListSokujibunDataSourceBean2.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean3 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean3.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean3.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeiritrhktuukagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzSikinIdouListSokujibunDataSourceBean3.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean4 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean4.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzSikinIdouListSokujibunDataSourceBean4.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean5 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean5.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean5.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean6 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean6.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean6.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean7 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean7.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean7.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(2.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeiritrhktuukagk(BizCurrency.valueOf(2.2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean7.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean8 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean8.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean8.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(2.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeiritrhktuukagk(BizCurrency.valueOf(2.2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean8.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean9 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean9.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean9.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(2.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeiritrhktuukagk(BizCurrency.valueOf(2.2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean9.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean10 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean10.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean10.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(2.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeiritrhktuukagk(BizCurrency.valueOf(2.2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean10.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean11 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean11.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean11.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(2.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeiritrhktuukagk(BizCurrency.valueOf(2.2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean11.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean12 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean12.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean12.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(2.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeiritrhktuukagk(BizCurrency.valueOf(2.2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean12.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean13 = new BzSikinIdouListSokujibunDataSourceBean();
        bzSikinIdouListSokujibunDataSourceBean13.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean13.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean13.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean13.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(12.6, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean13.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean13.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(13.2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean13.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean14 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean14.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean14.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean14.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean14.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean14.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean14.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean14.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean14.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean14.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean15 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean15.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean15.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean15.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean15.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean15.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean15.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean15.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean15.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean16 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean16.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean16.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean16.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean16.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean16.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean16.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean16.setIrKeiritrhktuukagk(BizCurrency.valueOf(3.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean16.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean17 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean17.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean17.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeiritrhktuukagk(BizCurrency.valueOf(3.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean17.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean18 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean18.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean18.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeiritrhktuukagk(BizCurrency.valueOf(3.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean18.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean19 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean19.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean19.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeiritrhktuukagk(BizCurrency.valueOf(3.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean19.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean20 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean20.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean20.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean20.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean20.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean20.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean20.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean20.setIrKeiritrhktuukagk(BizCurrency.valueOf(3.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean20.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean20.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean21 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean21.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean21.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean21.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean21.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean21.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean21.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean21.setIrKeiritrhktuukagk(BizCurrency.valueOf(3.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean21.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean22 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean22.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean22.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean22.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean22.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListSokujibunDataSourceBean22.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean22.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean22.setIrKeiritrhktuukagk(BizCurrency.valueOf(3.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean22.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean23 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean23.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean23.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean23.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean23.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListSokujibunDataSourceBean23.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean23.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean23.setIrKeiritrhktuukagk(BizCurrency.valueOf(3.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean23.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean23.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean24 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean24.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean24.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeiritrhktuukagk(BizCurrency.valueOf(3.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean24.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean25 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean25.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean25.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean25.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean25.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(37.2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean25.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean25.setIrKeiritrhktuukagk(BizCurrency.valueOf(38.4, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean25.setIrKaipageno(0);
        bzSikinIdouListSokujibunDataSourceBean25.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9999, BizCurrencyTypes.DOLLAR));

        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean1);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean2);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean3);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean4);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean5);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean6);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean7);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean8);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean9);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean10);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean11);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean12);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean13);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean14);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean15);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean16);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean17);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean18);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean19);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean20);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean21);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean22);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean23);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean24);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean25);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListSokujibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulistsokuji", C_SyoruiCdKbn.CM_SIKINIDOULIST_SOKUJI);

        bzSikinIdouListSokujibunBean.setIrSyoribiwareki("平成28年 7月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean1 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean1.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(2.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukagk(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        bzSikinIdouListSokujibunDataSourceBean1.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean2 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean2.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean2.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(2.2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));
        bzSikinIdouListSokujibunDataSourceBean2.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean3 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean3.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean3.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(2.3, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeiritrhktuukagk(BizCurrency.valueOf(3, BizCurrencyTypes.YEN));
        bzSikinIdouListSokujibunDataSourceBean3.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean4 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean4.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(2.4, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(4, BizCurrencyTypes.YEN));
        bzSikinIdouListSokujibunDataSourceBean4.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean5 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean5.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean5.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean6 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean6.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean6.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean7 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean7.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean7.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(2.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeiritrhktuukagk(BizCurrency.valueOf(2.2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean7.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean8 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean8.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean8.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(2.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeiritrhktuukagk(BizCurrency.valueOf(2.2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean8.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean9 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean9.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean9.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(2.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean9.setIrKeiritrhktuukagk(BizCurrency.valueOf(2.2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean9.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean10 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean10.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean10.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(2.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeiritrhktuukagk(BizCurrency.valueOf(2.2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean10.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean10.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean11 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean11.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean11.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(2.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean11.setIrKeiritrhktuukagk(BizCurrency.valueOf(2.2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean11.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean12 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean12.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean12.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(2.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeiritrhktuukagk(BizCurrency.valueOf(2.2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean12.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean12.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean13 = new BzSikinIdouListSokujibunDataSourceBean();
        bzSikinIdouListSokujibunDataSourceBean13.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean13.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean13.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean13.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(12.6, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean13.setIrKeiritrhktuukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean13.setIrKeiritrhktuukagkskei(BizCurrency.valueOf(13.2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean13.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean14 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean14.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean14.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean14.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean14.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean14.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean14.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean14.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean14.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListSokujibunDataSourceBean14.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean15 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean15.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean15.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean15.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean15.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean15.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListSokujibunDataSourceBean15.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean15.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean15.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean16 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean16.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean16.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean16.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean16.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean16.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean16.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean16.setIrKeiritrhktuukagk(BizCurrency.valueOf(3.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean16.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean17 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean17.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean17.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeiritrhktuukagk(BizCurrency.valueOf(3.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean17.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean17.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean18 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean18.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean18.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean18.setIrKeiritrhktuukagk(BizCurrency.valueOf(3.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean18.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean19 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean19.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean19.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean19.setIrKeiritrhktuukagk(BizCurrency.valueOf(3.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean19.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean20 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean20.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean20.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean20.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean20.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean20.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean20.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean20.setIrKeiritrhktuukagk(BizCurrency.valueOf(3.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean20.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean20.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean21 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean21.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean21.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean21.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean21.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean21.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean21.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean21.setIrKeiritrhktuukagk(BizCurrency.valueOf(3.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean21.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean22 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean22.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean22.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean22.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean22.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListSokujibunDataSourceBean22.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean22.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean22.setIrKeiritrhktuukagk(BizCurrency.valueOf(3.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean22.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean23 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean23.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean23.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean23.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean23.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListSokujibunDataSourceBean23.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean23.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean23.setIrKeiritrhktuukagk(BizCurrency.valueOf(3.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean23.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean23.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean24 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean24.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean24.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3.1, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean24.setIrKeiritrhktuukagk(BizCurrency.valueOf(3.2, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean24.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean25 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean25.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListSokujibunDataSourceBean25.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean25.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean25.setIrKeirisiteituukagkskeigk(BizCurrency.valueOf(37.2, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean25.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean25.setIrKeiritrhktuukagk(BizCurrency.valueOf(38.4, BizCurrencyTypes.AU_DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean25.setIrKaipageno(0);
        bzSikinIdouListSokujibunDataSourceBean25.setIrKeirisiteituukagkkei(BizCurrency.valueOf(9999, BizCurrencyTypes.DOLLAR));

        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean1);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean2);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean3);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean4);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean5);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean6);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean7);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean8);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean9);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean10);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean11);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean12);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean13);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean14);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean15);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean16);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean17);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean18);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean19);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean20);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean21);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean22);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean23);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean24);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean25);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListSokujibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulistsokuji", C_SyoruiCdKbn.CM_SIKINIDOULIST_SOKUJI);

        bzSikinIdouListSokujibunBean.setIrSyoribiwareki("2018年12月12日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean1 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean1.setIrSikinidoukbnnm("");
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1000000000000.00, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean1.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListSokujibunDataSourceBean1.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean2 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean2.setIrSikinidoukbnnm("");
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean2.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1111111111111.00, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean2.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean2.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean3 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean3.setIrSikinidoukbnnm("");
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean3.setIrSeg1cd(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1000000000000.00, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean3.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListSokujibunDataSourceBean3.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean4 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean4.setIrSikinidoukbnnm("");
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListSokujibunDataSourceBean4.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1111111111111.00, BizCurrencyTypes.DOLLAR));
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisiteituukagkskeigk(null);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeiritrhktuukagkskei(null);
        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean4.setIrKaipageno(0);

        bzSikinIdouListSokujibunDataSourceBean4.setIrKeirisiteituukagkkei(BizCurrency.valueOf(8444444444444.00, BizCurrencyTypes.DOLLAR));

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean5 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean5.setIrSikinidoukbnnm("");
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean5.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1000000000000.00, BizCurrencyTypes.EURO));
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean5.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListSokujibunDataSourceBean5.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean6 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean6.setIrSikinidoukbnnm("");
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean6.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1111111111111.00, BizCurrencyTypes.EURO));
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean6.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean6.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean7 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean7.setIrSikinidoukbnnm("");
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean7.setIrSeg1cd(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1000000000000.00, BizCurrencyTypes.EURO));
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeiritrhktuukagk(null);
        bzSikinIdouListSokujibunDataSourceBean7.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListSokujibunDataSourceBean7.setIrKaipageno(0);

        BzSikinIdouListSokujibunDataSourceBean bzSikinIdouListSokujibunDataSourceBean8 = new BzSikinIdouListSokujibunDataSourceBean();

        bzSikinIdouListSokujibunDataSourceBean8.setIrSikinidoukbnnm("");
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListSokujibunDataSourceBean8.setIrSeg1cd(null);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1111111111111.00, BizCurrencyTypes.EURO));
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisiteituukagkskeigk(null);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeiritrhktuukasyu(null);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeiritrhktuukagkskei(null);
        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListSokujibunDataSourceBean8.setIrKaipageno(0);

        bzSikinIdouListSokujibunDataSourceBean8.setIrKeirisiteituukagkkei(BizCurrency.valueOf(8444444444444.00, BizCurrencyTypes.EURO));

        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean1);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean2);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean3);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean4);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean5);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean6);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean7);
        dataSouceList.add(bzSikinIdouListSokujibunDataSourceBean8);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListSokujibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}