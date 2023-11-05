package yuyu.report.biz;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzHojyobolistBean;
import yuyu.def.biz.bean.report.BzHojyobolistDataSourceBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 補助簿リスト帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzHojyoboListTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzHojyobolistBean bzHojyobolistBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzHojyoboListTest", C_SyoruiCdKbn.CM_HOJYOBOLIST);

        bzHojyobolistBean.setIrSyoriymd(null);
        bzHojyobolistBean.setIrDenym(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0;i< 1;i++){

            BzHojyobolistDataSourceBean bzHojyobolistDataSourceBean = new BzHojyobolistDataSourceBean();

            bzHojyobolistDataSourceBean.setIrHjybtantositunm(null);
            bzHojyobolistDataSourceBean.setIrKanjyoukmkcd(null);
            bzHojyobolistDataSourceBean.setIrKanjyoukmknm(null);
            bzHojyobolistDataSourceBean.setIrSyorisyokantantcd(null);
            bzHojyobolistDataSourceBean.setIrSyorisyokantantnm(null);
            bzHojyobolistDataSourceBean.setIrDenymd(null);
            bzHojyobolistDataSourceBean.setIrKarikatagk(null);
            bzHojyobolistDataSourceBean.setIrKasikatagk(null);
            bzHojyobolistDataSourceBean.setIrKarikatakmkkeigk(BizCurrency.valueOf(0));
            bzHojyobolistDataSourceBean.setIrKasikatakmkkeigk(BizCurrency.valueOf(0));
            bzHojyobolistDataSourceBean.setIrKarikataruigk(BizCurrency.valueOf(0));
            bzHojyobolistDataSourceBean.setIrKasikataruigk(BizCurrency.valueOf(0));

            dataSouceList.add(bzHojyobolistDataSourceBean);

        }

        reportTestBean.addParamObjects(dataSouceList, bzHojyobolistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzHojyoboListTest", C_SyoruiCdKbn.CM_HOJYOBOLIST);

        bzHojyobolistBean.setIrSyoriymd("");
        bzHojyobolistBean.setIrDenym("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0;i<1;i++){

            BzHojyobolistDataSourceBean bzHojyobolistDataSourceBean = new BzHojyobolistDataSourceBean();

            bzHojyobolistDataSourceBean.setIrHjybtantositunm("");
            bzHojyobolistDataSourceBean.setIrKanjyoukmkcd("");
            bzHojyobolistDataSourceBean.setIrKanjyoukmknm("");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantcd("");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantnm("");
            bzHojyobolistDataSourceBean.setIrDenymd("");
            bzHojyobolistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(0));
            bzHojyobolistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(0));
            bzHojyobolistDataSourceBean.setIrKarikatakmkkeigk(BizCurrency.valueOf(0));
            bzHojyobolistDataSourceBean.setIrKasikatakmkkeigk(BizCurrency.valueOf(0));
            bzHojyobolistDataSourceBean.setIrKarikataruigk(BizCurrency.valueOf(0));
            bzHojyobolistDataSourceBean.setIrKasikataruigk(BizCurrency.valueOf(0));

            dataSouceList.add(bzHojyobolistDataSourceBean);

        }

        reportTestBean.addParamObjects(dataSouceList, bzHojyobolistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzHojyoboListTest", C_SyoruiCdKbn.CM_HOJYOBOLIST);

        bzHojyobolistBean.setIrSyoriymd("平成27年 8月12日");
        bzHojyobolistBean.setIrDenym("平成２７年　７月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0;i<1;i++){

            BzHojyobolistDataSourceBean bzHojyobolistDataSourceBean = new BzHojyobolistDataSourceBean();

            bzHojyobolistDataSourceBean.setIrHjybtantositunm("保全支払サービス室");
            bzHojyobolistDataSourceBean.setIrKanjyoukmkcd("６０１２１");
            bzHojyobolistDataSourceBean.setIrKanjyoukmknm("その他返戻金／その他（普通）　集計リスト");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantcd("551");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantnm("収納サービス室");
            bzHojyobolistDataSourceBean.setIrDenymd("平成27年 7月 1日");
            bzHojyobolistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(100));
            bzHojyobolistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(200));
            bzHojyobolistDataSourceBean.setIrKarikatakmkkeigk(BizCurrency.valueOf(300));
            bzHojyobolistDataSourceBean.setIrKasikatakmkkeigk(BizCurrency.valueOf(400));
            bzHojyobolistDataSourceBean.setIrKarikataruigk(BizCurrency.valueOf(500));
            bzHojyobolistDataSourceBean.setIrKasikataruigk(BizCurrency.valueOf(600));

            dataSouceList.add(bzHojyobolistDataSourceBean);

        }

        reportTestBean.addParamObjects(dataSouceList, bzHojyobolistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzHojyoboListTest", C_SyoruiCdKbn.CM_HOJYOBOLIST);

        bzHojyobolistBean.setIrSyoriymd("ＷＷ99年99月99日");
        bzHojyobolistBean.setIrDenym("ＷＷ９９年９９月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0;i<1;i++){

            BzHojyobolistDataSourceBean bzHojyobolistDataSourceBean = new BzHojyobolistDataSourceBean();

            bzHojyobolistDataSourceBean.setIrHjybtantositunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzHojyobolistDataSourceBean.setIrKanjyoukmkcd("ＷＷＷＷＷ");
            bzHojyobolistDataSourceBean.setIrKanjyoukmknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantcd("www");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzHojyobolistDataSourceBean.setIrDenymd("ＷＷ99年99月99日");
            bzHojyobolistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(99999999999999L));
            bzHojyobolistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(99999999999999L));
            bzHojyobolistDataSourceBean.setIrKarikatakmkkeigk(BizCurrency.valueOf(99999999999999L));
            bzHojyobolistDataSourceBean.setIrKasikatakmkkeigk(BizCurrency.valueOf(99999999999999L));
            bzHojyobolistDataSourceBean.setIrKarikataruigk(BizCurrency.valueOf(99999999999999L));
            bzHojyobolistDataSourceBean.setIrKasikataruigk(BizCurrency.valueOf(99999999999999L));

            dataSouceList.add(bzHojyobolistDataSourceBean);

        }

        reportTestBean.addParamObjects(dataSouceList, bzHojyobolistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzHojyoboListTest", C_SyoruiCdKbn.CM_HOJYOBOLIST);

        bzHojyobolistBean.setIrSyoriymd("平成27年 8月12日");

        bzHojyobolistBean.setIrDenym("平成２７年　７月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0;i<24956;i++){

            BzHojyobolistDataSourceBean bzHojyobolistDataSourceBean = new BzHojyobolistDataSourceBean();

            bzHojyobolistDataSourceBean.setIrHjybtantositunm("保全支払サービス室");
            bzHojyobolistDataSourceBean.setIrKanjyoukmkcd("６０１２１");
            bzHojyobolistDataSourceBean.setIrKanjyoukmknm("その他返戻金／その他（普通）　集計リスト");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantcd("551");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantnm("収納サービス室");
            bzHojyobolistDataSourceBean.setIrDenymd("平成27年 7月 1日");
            bzHojyobolistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKarikatakmkkeigk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKasikatakmkkeigk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKarikataruigk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKasikataruigk(BizCurrency.valueOf(9999));

            dataSouceList.add(bzHojyobolistDataSourceBean);

        }

        reportTestBean.addParamObjects(dataSouceList, bzHojyobolistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzHojyoboListTest", C_SyoruiCdKbn.CM_HOJYOBOLIST);

        bzHojyobolistBean.setIrSyoriymd("平成27年 8月12日");

        bzHojyobolistBean.setIrDenym("平成２７年　７月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0;i<20;i++){

            BzHojyobolistDataSourceBean bzHojyobolistDataSourceBean = new BzHojyobolistDataSourceBean();

            bzHojyobolistDataSourceBean.setIrHjybtantositunm("保全支払サービス室");
            bzHojyobolistDataSourceBean.setIrKanjyoukmkcd("６０１２１");
            bzHojyobolistDataSourceBean.setIrKanjyoukmknm("その他返戻金／その他（普通）　集計リスト");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantcd("551");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantnm("収納サービス室");
            bzHojyobolistDataSourceBean.setIrDenymd("平成27年 7月 1日");
            bzHojyobolistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKarikatakmkkeigk(null);
            bzHojyobolistDataSourceBean.setIrKasikatakmkkeigk(null);
            bzHojyobolistDataSourceBean.setIrKarikataruigk(null);
            bzHojyobolistDataSourceBean.setIrKasikataruigk(null);

            dataSouceList.add(bzHojyobolistDataSourceBean);

        }
        for(int i = 0;i<14;i++){

            BzHojyobolistDataSourceBean bzHojyobolistDataSourceBean = new BzHojyobolistDataSourceBean();

            bzHojyobolistDataSourceBean.setIrHjybtantositunm("保全支払サービス室");
            bzHojyobolistDataSourceBean.setIrKanjyoukmkcd("６０１２１");
            bzHojyobolistDataSourceBean.setIrKanjyoukmknm("その他返戻金／その他（普通）　集計リスト");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantcd("552");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantnm("収納サービス室");
            bzHojyobolistDataSourceBean.setIrDenymd("平成27年 7月 1日");
            bzHojyobolistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKarikatakmkkeigk(null);
            bzHojyobolistDataSourceBean.setIrKasikatakmkkeigk(null);
            bzHojyobolistDataSourceBean.setIrKarikataruigk(null);
            bzHojyobolistDataSourceBean.setIrKasikataruigk(null);

            dataSouceList.add(bzHojyobolistDataSourceBean);

        }
        for(int i = 0;i<1;i++){

            BzHojyobolistDataSourceBean bzHojyobolistDataSourceBean = new BzHojyobolistDataSourceBean();

            bzHojyobolistDataSourceBean.setIrHjybtantositunm("保全支払サービス室");
            bzHojyobolistDataSourceBean.setIrKanjyoukmkcd("６０１２１");
            bzHojyobolistDataSourceBean.setIrKanjyoukmknm("その他返戻金／その他（普通）　集計リスト");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantcd("552");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantnm("収納サービス室");
            bzHojyobolistDataSourceBean.setIrDenymd("平成27年 7月 1日");
            bzHojyobolistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKarikatakmkkeigk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKasikatakmkkeigk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKarikataruigk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKasikataruigk(BizCurrency.valueOf(9999));

            dataSouceList.add(bzHojyobolistDataSourceBean);

        }
        for(int i = 0;i<19;i++){

            BzHojyobolistDataSourceBean bzHojyobolistDataSourceBean = new BzHojyobolistDataSourceBean();

            bzHojyobolistDataSourceBean.setIrHjybtantositunm("保全支払サービス室");
            bzHojyobolistDataSourceBean.setIrKanjyoukmkcd("６０１２２");
            bzHojyobolistDataSourceBean.setIrKanjyoukmknm("その他返戻金／その他（普通）　集計リスト");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantcd("552");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantnm("収納サービス室");
            bzHojyobolistDataSourceBean.setIrDenymd("平成27年 7月 1日");
            bzHojyobolistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKarikatakmkkeigk(null);
            bzHojyobolistDataSourceBean.setIrKasikatakmkkeigk(null);
            bzHojyobolistDataSourceBean.setIrKarikataruigk(null);
            bzHojyobolistDataSourceBean.setIrKasikataruigk(null);

            dataSouceList.add(bzHojyobolistDataSourceBean);

        }
        for(int i = 0;i<1;i++){

            BzHojyobolistDataSourceBean bzHojyobolistDataSourceBean = new BzHojyobolistDataSourceBean();

            bzHojyobolistDataSourceBean.setIrHjybtantositunm("保全支払サービス室");
            bzHojyobolistDataSourceBean.setIrKanjyoukmkcd("６０１２２");
            bzHojyobolistDataSourceBean.setIrKanjyoukmknm("その他返戻金／その他（普通）　集計リスト");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantcd("552");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantnm("収納サービス室");
            bzHojyobolistDataSourceBean.setIrDenymd("平成27年 7月 1日");
            bzHojyobolistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKarikatakmkkeigk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKasikatakmkkeigk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKarikataruigk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKasikataruigk(BizCurrency.valueOf(9999));

            dataSouceList.add(bzHojyobolistDataSourceBean);

        }

        reportTestBean.addParamObjects(dataSouceList, bzHojyobolistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzHojyoboListTest", C_SyoruiCdKbn.CM_HOJYOBOLIST);

        bzHojyobolistBean.setIrSyoriymd("");
        bzHojyobolistBean.setIrDenym("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, bzHojyobolistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzHojyoboListTest", C_SyoruiCdKbn.CM_HOJYOBOLIST);

        bzHojyobolistBean.setIrSyoriymd("平成27年 8月12日");
        bzHojyobolistBean.setIrDenym("平成２７年　７月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0;i<1;i++){

            BzHojyobolistDataSourceBean bzHojyobolistDataSourceBean = new BzHojyobolistDataSourceBean();

            bzHojyobolistDataSourceBean.setIrHjybtantositunm("保全支払サービス室");
            bzHojyobolistDataSourceBean.setIrKanjyoukmkcd("６０１２１");
            bzHojyobolistDataSourceBean.setIrKanjyoukmknm("その他返戻金／その他（普通）　集計リスト");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantcd("551");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantnm("収納サービス室");
            bzHojyobolistDataSourceBean.setIrDenymd("平成27年 7月 1日");
            bzHojyobolistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(100));
            bzHojyobolistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(200));
            bzHojyobolistDataSourceBean.setIrKarikatakmkkeigk(null);
            bzHojyobolistDataSourceBean.setIrKasikatakmkkeigk(null);
            bzHojyobolistDataSourceBean.setIrKarikataruigk(null);
            bzHojyobolistDataSourceBean.setIrKasikataruigk(null);

            dataSouceList.add(bzHojyobolistDataSourceBean);

        }
        for(int i = 0;i<1;i++){

            BzHojyobolistDataSourceBean bzHojyobolistDataSourceBean = new BzHojyobolistDataSourceBean();

            bzHojyobolistDataSourceBean.setIrHjybtantositunm("保全支払サービス室");
            bzHojyobolistDataSourceBean.setIrKanjyoukmkcd("６０１２１");
            bzHojyobolistDataSourceBean.setIrKanjyoukmknm("その他返戻金／その他（普通）　集計リスト");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantcd("551");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantnm("収納サービス室");
            bzHojyobolistDataSourceBean.setIrDenymd("平成27年 7月 2日");
            bzHojyobolistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(300));
            bzHojyobolistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(500));
            bzHojyobolistDataSourceBean.setIrKarikatakmkkeigk(BizCurrency.valueOf(400));
            bzHojyobolistDataSourceBean.setIrKasikatakmkkeigk(BizCurrency.valueOf(700));
            bzHojyobolistDataSourceBean.setIrKarikataruigk(BizCurrency.valueOf(8000));
            bzHojyobolistDataSourceBean.setIrKasikataruigk(BizCurrency.valueOf(9000));

            dataSouceList.add(bzHojyobolistDataSourceBean);

        }

        reportTestBean.addParamObjects(dataSouceList, bzHojyobolistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "BzHojyoboListTest", C_SyoruiCdKbn.CM_HOJYOBOLIST);

        bzHojyobolistBean.setIrSyoriymd("平成27年 8月12日");
        bzHojyobolistBean.setIrDenym("平成２７年　７月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for(int i = 0;i<1;i++){

            BzHojyobolistDataSourceBean bzHojyobolistDataSourceBean = new BzHojyobolistDataSourceBean();

            bzHojyobolistDataSourceBean.setIrHjybtantositunm("保全支払サービス室");
            bzHojyobolistDataSourceBean.setIrKanjyoukmkcd("６０１２１");
            bzHojyobolistDataSourceBean.setIrKanjyoukmknm("その他返戻金／その他（普通）　集計リスト");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantcd("551");
            bzHojyobolistDataSourceBean.setIrSyorisyokantantnm("収納サービス室");
            bzHojyobolistDataSourceBean.setIrDenymd("平成27年 7月 2日");
            bzHojyobolistDataSourceBean.setIrKarikatagk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKasikatagk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKarikatakmkkeigk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKasikatakmkkeigk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKarikataruigk(BizCurrency.valueOf(9999));
            bzHojyobolistDataSourceBean.setIrKasikataruigk(BizCurrency.valueOf(9999));

            dataSouceList.add(bzHojyobolistDataSourceBean);

        }

        reportTestBean.addParamObjects(dataSouceList, bzHojyobolistBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
