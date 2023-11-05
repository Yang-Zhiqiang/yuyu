package yuyu.report.biz;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzSikinIdouListTyakkinbibunBean;
import yuyu.def.biz.bean.report.BzSikinIdouListTyakkinbibunDataSourceBean;
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
 * 資金移動リスト（着金日分）帳票テスト用クラス<br />
 */

@RunWith(OrderedRunner.class)
public class BzSikinIdouListTyakkinbiTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzSikinIdouListTyakkinbibunBean bzSikinIdouListTyakkinbibunBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisttyakkinbi", C_SyoruiCdKbn.CM_SIKINIDOULIST_TYAKKINBI);

        bzSikinIdouListTyakkinbibunBean.setIrSyoribiwareki(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean = new BzSikinIdouListTyakkinbibunDataSourceBean();

        bzSikinIdouListTyakkinbibunDataSourceBean.setIrSikinidoukbnnm(null);
        bzSikinIdouListTyakkinbibunDataSourceBean.setIrTyakkinymdwareki(null);
        bzSikinIdouListTyakkinbibunDataSourceBean.setIrSeg1cd(null);
        bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisiteituukasyu(null);
        bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisiteituukagkgaika(null);
        bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeiritrhktuukasyugaika(null);
        bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeiritrhktuukagkgaika(null);
        bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisikinidoumeisaikbnnm(null);
        bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisikinidougroupno(null);

        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListTyakkinbibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisttyakkinbi", C_SyoruiCdKbn.CM_SIKINIDOULIST_TYAKKINBI);

        bzSikinIdouListTyakkinbibunBean.setIrSyoribiwareki("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean = new BzSikinIdouListTyakkinbibunDataSourceBean();

        bzSikinIdouListTyakkinbibunDataSourceBean.setIrSikinidoukbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean.setIrTyakkinymdwareki("");
        bzSikinIdouListTyakkinbibunDataSourceBean.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.BLNK);
        bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(0));
        bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeiritrhktuukasyugaika(C_Tuukasyu.BLNK);
        bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(0));
        bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);

        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListTyakkinbibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisttyakkinbi", C_SyoruiCdKbn.CM_SIKINIDOULIST_TYAKKINBI);

        bzSikinIdouListTyakkinbibunBean.setIrSyoribiwareki("2028年 7月22日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean1 = new BzSikinIdouListTyakkinbibunDataSourceBean();

        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrTyakkinymdwareki("2027年12月31日");
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300));
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeiritrhktuukasyugaika(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400));
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);

        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean1);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean2 = new BzSikinIdouListTyakkinbibunDataSourceBean();

        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrTyakkinymdwareki("2028年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3002));
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeiritrhktuukasyugaika(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(4002));
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);

        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListTyakkinbibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisttyakkinbi", C_SyoruiCdKbn.CM_SIKINIDOULIST_TYAKKINBI);

        bzSikinIdouListTyakkinbibunBean.setIrSyoribiwareki("平成28年 7月23日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean1 = new BzSikinIdouListTyakkinbibunDataSourceBean();

        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrTyakkinymdwareki("平成28年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(30020.2));
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeiritrhktuukasyugaika(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(40020.3));
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);

        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean1);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean2 = new BzSikinIdouListTyakkinbibunDataSourceBean();

        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrTyakkinymdwareki("平成28年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeiritrhktuukasyugaika(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);

        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListTyakkinbibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisttyakkinbi", C_SyoruiCdKbn.CM_SIKINIDOULIST_TYAKKINBI);

        bzSikinIdouListTyakkinbibunBean.setIrSyoribiwareki("平成28年 7月24日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean1 = new BzSikinIdouListTyakkinbibunDataSourceBean();

        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrTyakkinymdwareki("平成28年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(3002001.125));
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeiritrhktuukasyugaika(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(4002001.342));
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);

        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean1);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean2 = new BzSikinIdouListTyakkinbibunDataSourceBean();

        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrSikinidoukbnnm("ＦＢ送金予定／預り金");
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrTyakkinymdwareki("平成28年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999.99));
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeiritrhktuukasyugaika(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(9999999999999.99));
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);

        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListTyakkinbibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisttyakkinbi", C_SyoruiCdKbn.CM_SIKINIDOULIST_TYAKKINBI);

        bzSikinIdouListTyakkinbibunBean.setIrSyoribiwareki("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean;
        for (int i = 0; i < 33966; i++) {

            bzSikinIdouListTyakkinbibunDataSourceBean = new BzSikinIdouListTyakkinbibunDataSourceBean();

            bzSikinIdouListTyakkinbibunDataSourceBean.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrTyakkinymdwareki("9999年99月99日");
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisikinidoumeisaikbnnm("ＷＷＷＷＷ");
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);

            dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListTyakkinbibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisttyakkinbi", C_SyoruiCdKbn.CM_SIKINIDOULIST_TYAKKINBI);

        bzSikinIdouListTyakkinbibunBean.setIrSyoribiwareki("ＷＷ99年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean;
        for (int i = 0; i < 33; i++) {

            bzSikinIdouListTyakkinbibunDataSourceBean = new BzSikinIdouListTyakkinbibunDataSourceBean();

            bzSikinIdouListTyakkinbibunDataSourceBean.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrTyakkinymdwareki("ＷＷ99年99月99日");
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisikinidoumeisaikbnnm("ＷＷＷＷＷ");
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);

            dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListTyakkinbibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisttyakkinbi", C_SyoruiCdKbn.CM_SIKINIDOULIST_TYAKKINBI);

        bzSikinIdouListTyakkinbibunBean.setIrSyoribiwareki("ＷＷ99年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean;
        for (int i = 0; i < 34; i++) {

            bzSikinIdouListTyakkinbibunDataSourceBean = new BzSikinIdouListTyakkinbibunDataSourceBean();

            bzSikinIdouListTyakkinbibunDataSourceBean.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrTyakkinymdwareki("ＷＷ99年99月99日");
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisikinidoumeisaikbnnm("ＷＷＷＷＷ");
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);

            dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListTyakkinbibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisttyakkinbi", C_SyoruiCdKbn.CM_SIKINIDOULIST_TYAKKINBI);

        bzSikinIdouListTyakkinbibunBean.setIrSyoribiwareki("ＷＷ99年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean;
        for (int i = 0; i < 35; i++) {

            bzSikinIdouListTyakkinbibunDataSourceBean = new BzSikinIdouListTyakkinbibunDataSourceBean();

            bzSikinIdouListTyakkinbibunDataSourceBean.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrTyakkinymdwareki("ＷＷ99年99月99日");
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisikinidoumeisaikbnnm("ＷＷＷＷＷ");
            bzSikinIdouListTyakkinbibunDataSourceBean.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);

            dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListTyakkinbibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisttyakkinbi", C_SyoruiCdKbn.CM_SIKINIDOULIST_TYAKKINBI);

        bzSikinIdouListTyakkinbibunBean.setIrSyoribiwareki("ＷＷ99年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean1 = new BzSikinIdouListTyakkinbibunDataSourceBean();

        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrTyakkinymdwareki("平成27年12月31日");
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999.99));
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(9999999999999.99));
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisikinidoumeisaikbnnm("ＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);

        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean1);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean2 = new BzSikinIdouListTyakkinbibunDataSourceBean();

        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrTyakkinymdwareki("平成27年12月31日");
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999.99));
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(9999999999999.99));
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisikinidoumeisaikbnnm("ＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.BLNK);

        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean2);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean3 = new BzSikinIdouListTyakkinbibunDataSourceBean();

        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrTyakkinymdwareki("平成27年12月31日");
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999.99));
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(9999999999999.99));
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrKeirisikinidoumeisaikbnnm("ＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);

        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean3);


        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean4 = new BzSikinIdouListTyakkinbibunDataSourceBean();

        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrTyakkinymdwareki("平成28年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(9999999999999.99));
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(9999999999999.99));
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrKeirisikinidoumeisaikbnnm("ＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);

        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean4);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListTyakkinbibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisttyakkinbi", C_SyoruiCdKbn.CM_SIKINIDOULIST_TYAKKINBI);

        bzSikinIdouListTyakkinbibunBean.setIrSyoribiwareki("ＷＷ99年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean = new BzSikinIdouListTyakkinbibunDataSourceBean();

        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListTyakkinbibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisttyakkinbi", C_SyoruiCdKbn.CM_SIKINIDOULIST_TYAKKINBI);

        bzSikinIdouListTyakkinbibunBean.setIrSyoribiwareki("ＷＷ99年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean1 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrTyakkinymdwareki("平成27年12月31日");
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean1);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean2 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrTyakkinymdwareki("平成27年12月31日");
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean2);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean3 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrTyakkinymdwareki("平成27年12月31日");
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean3);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean4 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrTyakkinymdwareki("平成28年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean4);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean5 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean5.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean5.setIrTyakkinymdwareki("平成28年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean5.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListTyakkinbibunDataSourceBean5.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean5.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
        bzSikinIdouListTyakkinbibunDataSourceBean5.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean5.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
        bzSikinIdouListTyakkinbibunDataSourceBean5.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListTyakkinbibunDataSourceBean5.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean5);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean6 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean6.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean6.setIrTyakkinymdwareki("平成28年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean6.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean6.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean6.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
        bzSikinIdouListTyakkinbibunDataSourceBean6.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean6.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
        bzSikinIdouListTyakkinbibunDataSourceBean6.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean6.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);

        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean6);


        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean7 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean7.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean7.setIrTyakkinymdwareki("平成28年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean7.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean7.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean7.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
        bzSikinIdouListTyakkinbibunDataSourceBean7.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean7.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
        bzSikinIdouListTyakkinbibunDataSourceBean7.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListTyakkinbibunDataSourceBean7.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean7);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean8 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean8.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean8.setIrTyakkinymdwareki("平成28年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean8.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean8.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean8.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
        bzSikinIdouListTyakkinbibunDataSourceBean8.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean8.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
        bzSikinIdouListTyakkinbibunDataSourceBean8.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean8.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean8);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean9 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean9.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean9.setIrTyakkinymdwareki("平成28年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean9.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean9.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean9.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
        bzSikinIdouListTyakkinbibunDataSourceBean9.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean9.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
        bzSikinIdouListTyakkinbibunDataSourceBean9.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListTyakkinbibunDataSourceBean9.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean9);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean10 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean10.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean10.setIrTyakkinymdwareki("平成28年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean10.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListTyakkinbibunDataSourceBean10.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean10.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
        bzSikinIdouListTyakkinbibunDataSourceBean10.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean10.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
        bzSikinIdouListTyakkinbibunDataSourceBean10.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean10.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean10);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean11 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean11.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean11.setIrTyakkinymdwareki("平成28年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean11.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListTyakkinbibunDataSourceBean11.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean11.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
        bzSikinIdouListTyakkinbibunDataSourceBean11.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean11.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
        bzSikinIdouListTyakkinbibunDataSourceBean11.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean11.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean11);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean12 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean12.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean12.setIrTyakkinymdwareki("平成28年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean12.setIrSeg1cd(C_Segcd.BLNK);
        bzSikinIdouListTyakkinbibunDataSourceBean12.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean12.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
        bzSikinIdouListTyakkinbibunDataSourceBean12.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean12.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
        bzSikinIdouListTyakkinbibunDataSourceBean12.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListTyakkinbibunDataSourceBean12.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean12);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean13 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean13.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean13.setIrTyakkinymdwareki("平成28年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean13.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean13.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean13.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
        bzSikinIdouListTyakkinbibunDataSourceBean13.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean13.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
        bzSikinIdouListTyakkinbibunDataSourceBean13.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean13.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean13);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean14 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean14.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean14.setIrTyakkinymdwareki("平成28年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean14.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean14.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean14.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
        bzSikinIdouListTyakkinbibunDataSourceBean14.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean14.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
        bzSikinIdouListTyakkinbibunDataSourceBean14.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean14.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean14);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean15 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean15.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean15.setIrTyakkinymdwareki("平成28年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean15.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean15.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean15.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
        bzSikinIdouListTyakkinbibunDataSourceBean15.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean15.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
        bzSikinIdouListTyakkinbibunDataSourceBean15.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListTyakkinbibunDataSourceBean15.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean15);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean16 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean16.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean16.setIrTyakkinymdwareki("平成28年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean16.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean16.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean16.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
        bzSikinIdouListTyakkinbibunDataSourceBean16.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean16.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
        bzSikinIdouListTyakkinbibunDataSourceBean16.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean16.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean16);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean17 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean17.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean17.setIrTyakkinymdwareki("平成28年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean17.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean17.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean17.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
        bzSikinIdouListTyakkinbibunDataSourceBean17.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean17.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
        bzSikinIdouListTyakkinbibunDataSourceBean17.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean17.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean17);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean18 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean18.setIrSikinidoukbnnm("ＷＷＷＷＷＷＷＷＷＷ");
        bzSikinIdouListTyakkinbibunDataSourceBean18.setIrTyakkinymdwareki("平成28年 1月 1日");
        bzSikinIdouListTyakkinbibunDataSourceBean18.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean18.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean18.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(300200.25));
        bzSikinIdouListTyakkinbibunDataSourceBean18.setIrKeiritrhktuukasyugaika(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean18.setIrKeiritrhktuukagkgaika(BizCurrency.valueOf(400200.36));
        bzSikinIdouListTyakkinbibunDataSourceBean18.setIrKeirisikinidoumeisaikbnnm("ＤＳ解約分");
        bzSikinIdouListTyakkinbibunDataSourceBean18.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean18);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListTyakkinbibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bz_sikinidoulisttyakkinbi", C_SyoruiCdKbn.CM_SIKINIDOULIST_TYAKKINBI);

        bzSikinIdouListTyakkinbibunBean.setIrSyoribiwareki("2018年12月12日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean1 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrSikinidoukbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrTyakkinymdwareki("2018年12月14日");
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1000000000000.00));
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeiritrhktuukasyugaika(null);
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeiritrhktuukagkgaika(null);
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean1.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean1);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean2 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrSikinidoukbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrTyakkinymdwareki("2018年12月14日");
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrSeg1cd(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1000000000000.00));
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeiritrhktuukasyugaika(null);
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeiritrhktuukagkgaika(null);
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean2.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean2);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean3 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrSikinidoukbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrTyakkinymdwareki("2018年12月14日");
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrSeg1cd(C_Segcd.USDKOJINNENKINHIJYNBRJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1000000000000.00));
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrKeiritrhktuukasyugaika(null);
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrKeiritrhktuukagkgaika(null);
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean3.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean3);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean4 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrSikinidoukbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrTyakkinymdwareki("2018年12月14日");
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1000000000000.00));
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrKeiritrhktuukasyugaika(null);
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrKeiritrhktuukagkgaika(null);
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean4.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean4);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean5 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean5.setIrSikinidoukbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean5.setIrTyakkinymdwareki("2018年12月14日");
        bzSikinIdouListTyakkinbibunDataSourceBean5.setIrSeg1cd(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
        bzSikinIdouListTyakkinbibunDataSourceBean5.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean5.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1000000000000.00));
        bzSikinIdouListTyakkinbibunDataSourceBean5.setIrKeiritrhktuukasyugaika(null);
        bzSikinIdouListTyakkinbibunDataSourceBean5.setIrKeiritrhktuukagkgaika(null);
        bzSikinIdouListTyakkinbibunDataSourceBean5.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean5.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);
        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean5);

        BzSikinIdouListTyakkinbibunDataSourceBean bzSikinIdouListTyakkinbibunDataSourceBean6 = new BzSikinIdouListTyakkinbibunDataSourceBean();
        bzSikinIdouListTyakkinbibunDataSourceBean6.setIrSikinidoukbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean6.setIrTyakkinymdwareki("2018年12月14日");
        bzSikinIdouListTyakkinbibunDataSourceBean6.setIrSeg1cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
        bzSikinIdouListTyakkinbibunDataSourceBean6.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        bzSikinIdouListTyakkinbibunDataSourceBean6.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(1000000000000.00));
        bzSikinIdouListTyakkinbibunDataSourceBean6.setIrKeiritrhktuukasyugaika(null);
        bzSikinIdouListTyakkinbibunDataSourceBean6.setIrKeiritrhktuukagkgaika(null);
        bzSikinIdouListTyakkinbibunDataSourceBean6.setIrKeirisikinidoumeisaikbnnm("");
        bzSikinIdouListTyakkinbibunDataSourceBean6.setIrKeirisikinidougroupno(C_SikinidougroupKbn.DUMMY);

        dataSouceList.add(bzSikinIdouListTyakkinbibunDataSourceBean6);

        reportTestBean.addParamObjects(dataSouceList, bzSikinIdouListTyakkinbibunBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}