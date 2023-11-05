package yuyu.report.hozen;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.bean.report.KhGensenListBean;
import yuyu.def.hozen.bean.report.KhGensenListDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 源泉徴収リスト 帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhGensentyousyuulistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhGensenListBean khGensenListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhGensentyousyuulistTest", C_SyoruiCdKbn.NK_GNSNLIST);
        khGensenListBean.setIrTantsitunmkj(null);
        khGensenListBean.setIrSyoriymd(null);
        khGensenListBean.setIrGstsym(null);
        khGensenListBean.setIrKensuu(null);
        khGensenListBean.setIrHozonkkn(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhGensenListDataSourceBean khGensenListDataSourceBean = null;

        for (int i = 0; i < 1; i++) {

            khGensenListDataSourceBean = new KhGensenListDataSourceBean();

            khGensenListDataSourceBean.setIrTodoufukenNm(null);
            khGensenListDataSourceBean.setIrKinounm(null);
            khGensenListDataSourceBean.setIrShrymd(null);
            khGensenListDataSourceBean.setIrSyono(null);
            khGensenListDataSourceBean.setIrSaeki(null);
            khGensenListDataSourceBean.setIrYengstszeigknationaltax(null);
            khGensenListDataSourceBean.setIrYengstszeigklocaltax(null);
            khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
            khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khGensenListDataSourceBean);
        }

        KhGensenListDataSourceBean khGensenListDataSourceBean1 = new KhGensenListDataSourceBean();

        khGensenListDataSourceBean1.setIrTodoufukenNm(null);
        khGensenListDataSourceBean1.setIrGoukeiinfotodouhuken(null);
        khGensenListDataSourceBean1.setIrSaekigoukeitodouhuken(null);
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeikkzei(null);
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeithzei(null);
        khGensenListDataSourceBean1.setIrKensuugoukei(null);
        khGensenListDataSourceBean1.setIrGoukeiumukbntodouhuken(C_UmuKbn.ARI);
        khGensenListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);

        KhGensenListDataSourceBean khGensenListDataSourceBean2 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean2.setIrTodoufukenNm("");
        khGensenListDataSourceBean2.setIrSaekisougoukei(null);
        khGensenListDataSourceBean2.setIrYengstszeigksoukeikkzei(null);
        khGensenListDataSourceBean2.setIrYengstszeigksoukeithzei(null);
        khGensenListDataSourceBean2.setIrKensuusougoukei(null);
        khGensenListDataSourceBean2.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khGensenListDataSourceBean1);
        dataSouceList.add(khGensenListDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, khGensenListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhGensentyousyuulistTest", C_SyoruiCdKbn.NK_GNSNLIST);
        khGensenListBean.setIrTantsitunmkj("");
        khGensenListBean.setIrSyoriymd("");
        khGensenListBean.setIrGstsym("");
        khGensenListBean.setIrKensuu(0);
        khGensenListBean.setIrHozonkkn("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhGensenListDataSourceBean khGensenListDataSourceBean = null;

        for (int i = 0; i < 1; i++) {

            khGensenListDataSourceBean = new KhGensenListDataSourceBean();

            khGensenListDataSourceBean.setIrTodoufukenNm("");
            khGensenListDataSourceBean.setIrKinounm("");
            khGensenListDataSourceBean.setIrShrymd("");
            khGensenListDataSourceBean.setIrSyono("");
            khGensenListDataSourceBean.setIrSaeki(null);
            khGensenListDataSourceBean.setIrYengstszeigknationaltax(null);
            khGensenListDataSourceBean.setIrYengstszeigklocaltax(null);
            khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
            khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khGensenListDataSourceBean);
        }

        KhGensenListDataSourceBean khGensenListDataSourceBean1 = new KhGensenListDataSourceBean();

        khGensenListDataSourceBean1.setIrTodoufukenNm("");
        khGensenListDataSourceBean1.setIrGoukeiinfotodouhuken("");
        khGensenListDataSourceBean1.setIrSaekigoukeitodouhuken(null);
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeikkzei(null);
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeithzei(null);
        khGensenListDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(0));
        khGensenListDataSourceBean1.setIrGoukeiumukbntodouhuken(C_UmuKbn.ARI);
        khGensenListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);

        KhGensenListDataSourceBean khGensenListDataSourceBean2 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean2.setIrSaekisougoukei(null);
        khGensenListDataSourceBean2.setIrYengstszeigksoukeikkzei(null);
        khGensenListDataSourceBean2.setIrYengstszeigksoukeithzei(null);
        khGensenListDataSourceBean2.setIrKensuusougoukei(BizNumber.valueOf(0));
        khGensenListDataSourceBean2.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khGensenListDataSourceBean1);
        dataSouceList.add(khGensenListDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, khGensenListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhGensentyousyuulistTest", C_SyoruiCdKbn.NK_GNSNLIST);
        khGensenListBean.setIrTantsitunmkj("保全支払サービス室");
        khGensenListBean.setIrSyoriymd("2018年 1月 1日");
        khGensenListBean.setIrGstsym("平成 2年 2月");
        khGensenListBean.setIrKensuu(1);
        khGensenListBean.setIrHozonkkn("3年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhGensenListDataSourceBean khGensenListDataSourceBean = null;

        for (int i = 0; i < 1; i++) {

            khGensenListDataSourceBean = new KhGensenListDataSourceBean();

            khGensenListDataSourceBean.setIrTodoufukenNm("東京都");
            khGensenListDataSourceBean.setIrKinounm("解約");
            khGensenListDataSourceBean.setIrShrymd("2018年 3月 3日");
            khGensenListDataSourceBean.setIrSyono("12345678901");
            khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(300));
            khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(400));
            khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(500));
            khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
            khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khGensenListDataSourceBean);
        }

        KhGensenListDataSourceBean khGensenListDataSourceBean1 = new KhGensenListDataSourceBean();

        khGensenListDataSourceBean1.setIrTodoufukenNm("東京都");

        khGensenListDataSourceBean1.setIrGoukeiinfotodouhuken("東京都合計");
        khGensenListDataSourceBean1.setIrSaekigoukeitodouhuken(BizCurrency.valueOf(301));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeikkzei(BizCurrency.valueOf(401));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeithzei(BizCurrency.valueOf(501));
        khGensenListDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1));
        khGensenListDataSourceBean1.setIrGoukeiumukbntodouhuken(C_UmuKbn.ARI);
        khGensenListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);

        KhGensenListDataSourceBean khGensenListDataSourceBean2 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean2.setIrSaekisougoukei(BizCurrency.valueOf(302));
        khGensenListDataSourceBean2.setIrYengstszeigksoukeikkzei(BizCurrency.valueOf(402));
        khGensenListDataSourceBean2.setIrYengstszeigksoukeithzei(BizCurrency.valueOf(502));
        khGensenListDataSourceBean2.setIrKensuusougoukei(BizNumber.valueOf(1));
        khGensenListDataSourceBean2.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khGensenListDataSourceBean1);
        dataSouceList.add(khGensenListDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, khGensenListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhGensentyousyuulistTest", C_SyoruiCdKbn.NK_GNSNLIST);
        khGensenListBean.setIrTantsitunmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khGensenListBean.setIrSyoriymd("9999年99月99日");
        khGensenListBean.setIrGstsym("ＷＷ99年99月");
        khGensenListBean.setIrKensuu(999);
        khGensenListBean.setIrHozonkkn("99年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhGensenListDataSourceBean khGensenListDataSourceBean = null;

        for (int i = 0; i < 999; i++) {

            khGensenListDataSourceBean = new KhGensenListDataSourceBean();

            khGensenListDataSourceBean.setIrTodoufukenNm("ＷＷＷＷ");
            khGensenListDataSourceBean.setIrKinounm("ＷＷＷＷＷ");
            khGensenListDataSourceBean.setIrShrymd("9999年99月99日");
            khGensenListDataSourceBean.setIrSyono("wwwwwwwwwww");
            khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(999999999));
            khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(999999999));
            khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(999999999));
            khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
            khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khGensenListDataSourceBean);
        }

        KhGensenListDataSourceBean khGensenListDataSourceBean1 = new KhGensenListDataSourceBean();

        khGensenListDataSourceBean1.setIrTodoufukenNm("ＷＷＷＷ");

        khGensenListDataSourceBean1.setIrGoukeiinfotodouhuken("ＷＷＷＷＷＷ");
        khGensenListDataSourceBean1.setIrSaekigoukeitodouhuken(BizCurrency.valueOf(9999999999L));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeikkzei(BizCurrency.valueOf(9999999999L));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeithzei(BizCurrency.valueOf(9999999999L));
        khGensenListDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(999));
        khGensenListDataSourceBean1.setIrGoukeiumukbntodouhuken(C_UmuKbn.ARI);
        khGensenListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);

        KhGensenListDataSourceBean khGensenListDataSourceBean2 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean2.setIrSaekisougoukei(BizCurrency.valueOf(99999999999L));
        khGensenListDataSourceBean2.setIrYengstszeigksoukeikkzei(BizCurrency.valueOf(99999999999L));
        khGensenListDataSourceBean2.setIrYengstszeigksoukeithzei(BizCurrency.valueOf(99999999999L));
        khGensenListDataSourceBean2.setIrKensuusougoukei(BizNumber.valueOf(999));
        khGensenListDataSourceBean2.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khGensenListDataSourceBean1);
        dataSouceList.add(khGensenListDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, khGensenListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhGensentyousyuulistTest", C_SyoruiCdKbn.NK_GNSNLIST);
        khGensenListBean.setIrTantsitunmkj("保全支払サービス室");
        khGensenListBean.setIrSyoriymd("2018年 1月 1日");
        khGensenListBean.setIrGstsym("平成 2年 2月");
        khGensenListBean.setIrKensuu(1);
        khGensenListBean.setIrHozonkkn("3年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhGensenListDataSourceBean khGensenListDataSourceBean = null;

        for (int i = 0; i < 1; i++) {

            khGensenListDataSourceBean = new KhGensenListDataSourceBean();

            khGensenListDataSourceBean.setIrTodoufukenNm("東京都");
            khGensenListDataSourceBean.setIrKinounm("解約");
            khGensenListDataSourceBean.setIrShrymd("2018年 3月 3日");
            khGensenListDataSourceBean.setIrSyono("12345678901");
            khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(3002));
            khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(4002));
            khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(5002));
            khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
            khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khGensenListDataSourceBean);
        }

        KhGensenListDataSourceBean khGensenListDataSourceBean1 = new KhGensenListDataSourceBean();

        khGensenListDataSourceBean1.setIrTodoufukenNm("東京都");

        khGensenListDataSourceBean1.setIrGoukeiinfotodouhuken("東京都合計");
        khGensenListDataSourceBean1.setIrSaekigoukeitodouhuken(BizCurrency.valueOf(3003));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeikkzei(BizCurrency.valueOf(4003));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeithzei(BizCurrency.valueOf(5003));
        khGensenListDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1));
        khGensenListDataSourceBean1.setIrGoukeiumukbntodouhuken(C_UmuKbn.ARI);
        khGensenListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);

        KhGensenListDataSourceBean khGensenListDataSourceBean2 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean2.setIrSaekisougoukei(BizCurrency.valueOf(3004));
        khGensenListDataSourceBean2.setIrYengstszeigksoukeikkzei(BizCurrency.valueOf(4004));
        khGensenListDataSourceBean2.setIrYengstszeigksoukeithzei(BizCurrency.valueOf(5004));
        khGensenListDataSourceBean2.setIrKensuusougoukei(BizNumber.valueOf(1));
        khGensenListDataSourceBean2.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khGensenListDataSourceBean1);
        dataSouceList.add(khGensenListDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, khGensenListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhGensentyousyuulistTest", C_SyoruiCdKbn.NK_GNSNLIST);
        khGensenListBean.setIrTantsitunmkj("保全支払サービス室");
        khGensenListBean.setIrSyoriymd("2015年 6月30日");
        khGensenListBean.setIrGstsym("平成27年 6月");
        khGensenListBean.setIrKensuu(10);
        khGensenListBean.setIrHozonkkn("7年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhGensenListDataSourceBean khGensenListDataSourceBean = null;

        khGensenListDataSourceBean = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean.setIrTodoufukenNm("東京都");
        khGensenListDataSourceBean.setIrKinounm("減額");
        khGensenListDataSourceBean.setIrShrymd("2015年 6月10日");
        khGensenListDataSourceBean.setIrSyono("99999999014");
        khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(100000001));
        khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(200000001));
        khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(300000001));
        khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        dataSouceList.add(khGensenListDataSourceBean);

        khGensenListDataSourceBean = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean.setIrTodoufukenNm("東京都");
        khGensenListDataSourceBean.setIrKinounm("解約");
        khGensenListDataSourceBean.setIrShrymd("2015年 6月10日");
        khGensenListDataSourceBean.setIrSyono("99999999018");
        khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(100000002));
        khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(200000002));
        khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(300000002));
        khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        dataSouceList.add(khGensenListDataSourceBean);

        khGensenListDataSourceBean = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean.setIrTodoufukenNm("東京都");
        khGensenListDataSourceBean.setIrKinounm("減額");
        khGensenListDataSourceBean.setIrShrymd("2015年 6月15日");
        khGensenListDataSourceBean.setIrSyono("99999999010");
        khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(100000003));
        khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(200000003));
        khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(300000003));
        khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        dataSouceList.add(khGensenListDataSourceBean);

        khGensenListDataSourceBean = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean.setIrTodoufukenNm("東京都");
        khGensenListDataSourceBean.setIrKinounm("解約");
        khGensenListDataSourceBean.setIrShrymd("2015年 6月22日");
        khGensenListDataSourceBean.setIrSyono("99999999001");
        khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(100000004));
        khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(200000004));
        khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(300000004));
        khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        dataSouceList.add(khGensenListDataSourceBean);

        khGensenListDataSourceBean = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean.setIrTodoufukenNm("東京都");
        khGensenListDataSourceBean.setIrKinounm("解約");
        khGensenListDataSourceBean.setIrShrymd("2015年 6月24日");
        khGensenListDataSourceBean.setIrSyono("99999999023");
        khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(100000005));
        khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(200000005));
        khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(300000005));
        khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        dataSouceList.add(khGensenListDataSourceBean);


        KhGensenListDataSourceBean khGensenListDataSourceBean1 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean1.setIrTodoufukenNm("東京都");
        khGensenListDataSourceBean1.setIrGoukeiinfotodouhuken("東京都合計");
        khGensenListDataSourceBean1.setIrSaekigoukeitodouhuken(BizCurrency.valueOf(500000015));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeikkzei(BizCurrency.valueOf(1000000015));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeithzei(BizCurrency.valueOf(1500000015));
        khGensenListDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(5));
        khGensenListDataSourceBean1.setIrGoukeiumukbntodouhuken(C_UmuKbn.ARI);
        khGensenListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        dataSouceList.add(khGensenListDataSourceBean1);

        khGensenListDataSourceBean = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean.setIrTodoufukenNm("神奈川県");
        khGensenListDataSourceBean.setIrKinounm("解約");
        khGensenListDataSourceBean.setIrShrymd("2015年 6月 9日");
        khGensenListDataSourceBean.setIrSyono("99999998005");
        khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(400000001));
        khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(500000001));
        khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(600000001));
        khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        dataSouceList.add(khGensenListDataSourceBean);

        khGensenListDataSourceBean = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean.setIrTodoufukenNm("神奈川県");
        khGensenListDataSourceBean.setIrKinounm("減額");
        khGensenListDataSourceBean.setIrShrymd("2015年 6月 9日");
        khGensenListDataSourceBean.setIrSyono("99999998007");
        khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(400000002));
        khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(500000002));
        khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(600000002));
        khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        dataSouceList.add(khGensenListDataSourceBean);

        khGensenListDataSourceBean = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean.setIrTodoufukenNm("神奈川県");
        khGensenListDataSourceBean.setIrKinounm("減額");
        khGensenListDataSourceBean.setIrShrymd("2015年 6月 9日");
        khGensenListDataSourceBean.setIrSyono("99999999018");
        khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(400000003));
        khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(500000003));
        khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(600000003));
        khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        dataSouceList.add(khGensenListDataSourceBean);

        khGensenListDataSourceBean = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean.setIrTodoufukenNm("神奈川県");
        khGensenListDataSourceBean.setIrKinounm("解約");
        khGensenListDataSourceBean.setIrShrymd("2015年 6月25日");
        khGensenListDataSourceBean.setIrSyono("99999998011");
        khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(400000004));
        khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(500000004));
        khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(600000004));
        khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        dataSouceList.add(khGensenListDataSourceBean);

        khGensenListDataSourceBean = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean.setIrTodoufukenNm("神奈川県");
        khGensenListDataSourceBean.setIrKinounm("解約");
        khGensenListDataSourceBean.setIrShrymd("2015年 6月30日");
        khGensenListDataSourceBean.setIrSyono("99999998025");
        khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(400000005));
        khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(500000005));
        khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(600000005));
        khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        dataSouceList.add(khGensenListDataSourceBean);

        khGensenListDataSourceBean1 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean1.setIrTodoufukenNm("神奈川県");
        khGensenListDataSourceBean1.setIrGoukeiinfotodouhuken("神奈川県合計");
        khGensenListDataSourceBean1.setIrSaekigoukeitodouhuken(BizCurrency.valueOf(2000000015));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeikkzei(BizCurrency.valueOf(2500000015L));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeithzei(BizCurrency.valueOf(3000000015L));
        khGensenListDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(5));
        khGensenListDataSourceBean1.setIrGoukeiumukbntodouhuken(C_UmuKbn.ARI);
        khGensenListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        dataSouceList.add(khGensenListDataSourceBean1);

        KhGensenListDataSourceBean khGensenListDataSourceBean2 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean2.setIrTodoufukenNm("");
        khGensenListDataSourceBean2.setIrSaekisougoukei(BizCurrency.valueOf(2500000030L));
        khGensenListDataSourceBean2.setIrYengstszeigksoukeikkzei(BizCurrency.valueOf(3500000030L));
        khGensenListDataSourceBean2.setIrYengstszeigksoukeithzei(BizCurrency.valueOf(4500000030L));
        khGensenListDataSourceBean2.setIrKensuusougoukei(BizNumber.valueOf(10));
        khGensenListDataSourceBean2.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khGensenListDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, khGensenListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhGensentyousyuulistTest", C_SyoruiCdKbn.NK_GNSNLIST);
        khGensenListBean.setIrTantsitunmkj("保全支払サービス室");
        khGensenListBean.setIrSyoriymd("2018年 1月 1日");
        khGensenListBean.setIrGstsym("平成 2年 2月");
        khGensenListBean.setIrKensuu(19);
        khGensenListBean.setIrHozonkkn("3年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhGensenListDataSourceBean khGensenListDataSourceBean = null;

        for (int i = 0; i < 19; i++) {

            khGensenListDataSourceBean = new KhGensenListDataSourceBean();

            khGensenListDataSourceBean.setIrTodoufukenNm("東京都");
            khGensenListDataSourceBean.setIrKinounm("解約");
            khGensenListDataSourceBean.setIrShrymd("2018年 3月 3日");
            khGensenListDataSourceBean.setIrSyono("12345678901");
            khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(3002));
            khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(4002));
            khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(5002));
            khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
            khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khGensenListDataSourceBean);
        }


        KhGensenListDataSourceBean khGensenListDataSourceBean1 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean1.setIrTodoufukenNm("東京都");

        khGensenListDataSourceBean1.setIrGoukeiinfotodouhuken("東京都合計");
        khGensenListDataSourceBean1.setIrSaekigoukeitodouhuken(BizCurrency.valueOf(3003));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeikkzei(BizCurrency.valueOf(4003));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeithzei(BizCurrency.valueOf(5003));
        khGensenListDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(19));
        khGensenListDataSourceBean1.setIrGoukeiumukbntodouhuken(C_UmuKbn.ARI);
        khGensenListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        dataSouceList.add(khGensenListDataSourceBean1);

        KhGensenListDataSourceBean khGensenListDataSourceBean2 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean2.setIrSaekisougoukei(BizCurrency.valueOf(3004));
        khGensenListDataSourceBean2.setIrYengstszeigksoukeikkzei(BizCurrency.valueOf(4004));
        khGensenListDataSourceBean2.setIrYengstszeigksoukeithzei(BizCurrency.valueOf(5004));
        khGensenListDataSourceBean2.setIrKensuusougoukei(BizNumber.valueOf(19));
        khGensenListDataSourceBean2.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khGensenListDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, khGensenListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhGensentyousyuulistTest", C_SyoruiCdKbn.NK_GNSNLIST);
        khGensenListBean.setIrTantsitunmkj("保全支払サービス室");
        khGensenListBean.setIrSyoriymd("2018年 1月 1日");
        khGensenListBean.setIrGstsym("平成 2年 2月");
        khGensenListBean.setIrKensuu(20);
        khGensenListBean.setIrHozonkkn("3年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhGensenListDataSourceBean khGensenListDataSourceBean = null;

        for (int i = 0; i < 20; i++) {

            khGensenListDataSourceBean = new KhGensenListDataSourceBean();

            khGensenListDataSourceBean.setIrTodoufukenNm("東京都");
            khGensenListDataSourceBean.setIrKinounm("解約");
            khGensenListDataSourceBean.setIrShrymd("2018年 3月 3日");
            khGensenListDataSourceBean.setIrSyono("12345678901");
            khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(3002));
            khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(4002));
            khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(5002));
            khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
            khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khGensenListDataSourceBean);
        }


        KhGensenListDataSourceBean khGensenListDataSourceBean1 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean1.setIrTodoufukenNm("東京都");

        khGensenListDataSourceBean1.setIrGoukeiinfotodouhuken("東京都合計");
        khGensenListDataSourceBean1.setIrSaekigoukeitodouhuken(BizCurrency.valueOf(3003));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeikkzei(BizCurrency.valueOf(4003));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeithzei(BizCurrency.valueOf(5003));
        khGensenListDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(20));
        khGensenListDataSourceBean1.setIrGoukeiumukbntodouhuken(C_UmuKbn.ARI);
        khGensenListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khGensenListDataSourceBean1);

        KhGensenListDataSourceBean khGensenListDataSourceBean2 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean2.setIrSaekisougoukei(BizCurrency.valueOf(3004));
        khGensenListDataSourceBean2.setIrYengstszeigksoukeikkzei(BizCurrency.valueOf(4004));
        khGensenListDataSourceBean2.setIrYengstszeigksoukeithzei(BizCurrency.valueOf(5004));
        khGensenListDataSourceBean2.setIrKensuusougoukei(BizNumber.valueOf(20));
        khGensenListDataSourceBean2.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khGensenListDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, khGensenListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhGensentyousyuulistTest", C_SyoruiCdKbn.NK_GNSNLIST);
        khGensenListBean.setIrTantsitunmkj("保全支払サービス室");
        khGensenListBean.setIrSyoriymd("2018年 1月 1日");
        khGensenListBean.setIrGstsym("平成 2年 2月");
        khGensenListBean.setIrKensuu(21);
        khGensenListBean.setIrHozonkkn("3年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhGensenListDataSourceBean khGensenListDataSourceBean = null;

        for (int i = 0; i < 21; i++) {

            khGensenListDataSourceBean = new KhGensenListDataSourceBean();

            khGensenListDataSourceBean.setIrTodoufukenNm("東京都");
            khGensenListDataSourceBean.setIrKinounm("解約");
            khGensenListDataSourceBean.setIrShrymd("2018年 3月 3日");
            khGensenListDataSourceBean.setIrSyono("12345678901");
            khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(3002));
            khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(4002));
            khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(5002));
            khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
            khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khGensenListDataSourceBean);
        }


        KhGensenListDataSourceBean khGensenListDataSourceBean1 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean1.setIrTodoufukenNm("東京都");

        khGensenListDataSourceBean1.setIrGoukeiinfotodouhuken("東京都合計");
        khGensenListDataSourceBean1.setIrSaekigoukeitodouhuken(BizCurrency.valueOf(3003));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeikkzei(BizCurrency.valueOf(4003));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeithzei(BizCurrency.valueOf(5003));
        khGensenListDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(21));
        khGensenListDataSourceBean1.setIrGoukeiumukbntodouhuken(C_UmuKbn.ARI);
        khGensenListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khGensenListDataSourceBean1);

        KhGensenListDataSourceBean khGensenListDataSourceBean2 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean2.setIrSaekisougoukei(BizCurrency.valueOf(3004));
        khGensenListDataSourceBean2.setIrYengstszeigksoukeikkzei(BizCurrency.valueOf(4004));
        khGensenListDataSourceBean2.setIrYengstszeigksoukeithzei(BizCurrency.valueOf(5004));
        khGensenListDataSourceBean2.setIrKensuusougoukei(BizNumber.valueOf(21));
        khGensenListDataSourceBean2.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khGensenListDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, khGensenListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }



    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhGensentyousyuulistTest", C_SyoruiCdKbn.NK_GNSNLIST);
        khGensenListBean.setIrTantsitunmkj("保全支払サービス室");
        khGensenListBean.setIrSyoriymd("2018年 1月 1日");
        khGensenListBean.setIrGstsym("平成 2年 2月");
        khGensenListBean.setIrKensuu(19979);
        khGensenListBean.setIrHozonkkn("3年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhGensenListDataSourceBean khGensenListDataSourceBean = null;

        for (int i = 0; i < 19979; i++) {

            khGensenListDataSourceBean = new KhGensenListDataSourceBean();

            khGensenListDataSourceBean.setIrTodoufukenNm("東京都");
            khGensenListDataSourceBean.setIrKinounm("解約");
            khGensenListDataSourceBean.setIrShrymd("2018年 3月 3日");
            khGensenListDataSourceBean.setIrSyono("12345678901");
            khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(3002));
            khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(4002));
            khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(5002));
            khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
            khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khGensenListDataSourceBean);
        }

        KhGensenListDataSourceBean khGensenListDataSourceBean1 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean1.setIrTodoufukenNm("東京都");

        khGensenListDataSourceBean1.setIrGoukeiinfotodouhuken("東京都合計");
        khGensenListDataSourceBean1.setIrSaekigoukeitodouhuken(BizCurrency.valueOf(3003));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeikkzei(BizCurrency.valueOf(4003));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeithzei(BizCurrency.valueOf(5003));
        khGensenListDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(19979));
        khGensenListDataSourceBean1.setIrGoukeiumukbntodouhuken(C_UmuKbn.ARI);
        khGensenListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khGensenListDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, khGensenListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhGensentyousyuulistTest", C_SyoruiCdKbn.NK_GNSNLIST);
        khGensenListBean.setIrTantsitunmkj("保全支払サービス室");
        khGensenListBean.setIrSyoriymd("2018年 1月 1日");
        khGensenListBean.setIrGstsym("平成 2年 2月");
        khGensenListBean.setIrKensuu(0);
        khGensenListBean.setIrHozonkkn("3年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        KhGensenListDataSourceBean khGensenListDataSourceBean2 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean2.setIrSaekisougoukei(BizCurrency.valueOf(0));
        khGensenListDataSourceBean2.setIrYengstszeigksoukeikkzei(BizCurrency.valueOf(0));
        khGensenListDataSourceBean2.setIrYengstszeigksoukeithzei(BizCurrency.valueOf(0));
        khGensenListDataSourceBean2.setIrKensuusougoukei(BizNumber.valueOf(0));
        khGensenListDataSourceBean2.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khGensenListDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, khGensenListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhGensentyousyuulistTest", C_SyoruiCdKbn.NK_GNSNLIST);
        khGensenListBean.setIrTantsitunmkj("保全支払サービス室");
        khGensenListBean.setIrSyoriymd("2018年 1月 1日");
        khGensenListBean.setIrGstsym("平成 2年 2月");
        khGensenListBean.setIrKensuu(1);
        khGensenListBean.setIrHozonkkn("3年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhGensenListDataSourceBean khGensenListDataSourceBean = null;

        for (int i = 0; i < 1; i++) {

            khGensenListDataSourceBean = new KhGensenListDataSourceBean();

            khGensenListDataSourceBean.setIrTodoufukenNm("東京都");
            khGensenListDataSourceBean.setIrKinounm("解約");
            khGensenListDataSourceBean.setIrShrymd("2018年 3月 3日");
            khGensenListDataSourceBean.setIrSyono("12345678901");
            khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(0));
            khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(0));
            khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(0));
            khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
            khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khGensenListDataSourceBean);
        }

        KhGensenListDataSourceBean khGensenListDataSourceBean1 = new KhGensenListDataSourceBean();

        khGensenListDataSourceBean1.setIrTodoufukenNm("東京都");

        khGensenListDataSourceBean1.setIrGoukeiinfotodouhuken("東京都合計");
        khGensenListDataSourceBean1.setIrSaekigoukeitodouhuken(BizCurrency.valueOf(0));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeikkzei(BizCurrency.valueOf(0));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeithzei(BizCurrency.valueOf(0));
        khGensenListDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(1));
        khGensenListDataSourceBean1.setIrGoukeiumukbntodouhuken(C_UmuKbn.ARI);
        khGensenListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);

        KhGensenListDataSourceBean khGensenListDataSourceBean2 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean2.setIrSaekisougoukei(BizCurrency.valueOf(0));
        khGensenListDataSourceBean2.setIrYengstszeigksoukeikkzei(BizCurrency.valueOf(0));
        khGensenListDataSourceBean2.setIrYengstszeigksoukeithzei(BizCurrency.valueOf(0));
        khGensenListDataSourceBean2.setIrKensuusougoukei(BizNumber.valueOf(1));
        khGensenListDataSourceBean2.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khGensenListDataSourceBean1);
        dataSouceList.add(khGensenListDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, khGensenListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhGensentyousyuulistTest", C_SyoruiCdKbn.NK_GNSNLIST);
        khGensenListBean.setIrTantsitunmkj("保全支払サービス室");
        khGensenListBean.setIrSyoriymd("2018年 1月 1日");
        khGensenListBean.setIrGstsym("平成 2年 2月");
        khGensenListBean.setIrKensuu(60);
        khGensenListBean.setIrHozonkkn("3年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhGensenListDataSourceBean khGensenListDataSourceBean = null;

        for (int i = 0; i < 19; i++) {

            khGensenListDataSourceBean = new KhGensenListDataSourceBean();

            khGensenListDataSourceBean.setIrTodoufukenNm("東京都");
            khGensenListDataSourceBean.setIrKinounm("解約");
            khGensenListDataSourceBean.setIrShrymd("2018年 3月 3日");
            khGensenListDataSourceBean.setIrSyono("12345678901");
            khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(0));
            khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(0));
            khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(0));
            khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
            khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khGensenListDataSourceBean);
        }

        KhGensenListDataSourceBean khGensenListDataSourceBean1 = null;
        khGensenListDataSourceBean1 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean1.setIrTodoufukenNm("東京都");

        khGensenListDataSourceBean1.setIrGoukeiinfotodouhuken("東京都合計");
        khGensenListDataSourceBean1.setIrSaekigoukeitodouhuken(BizCurrency.valueOf(0));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeikkzei(BizCurrency.valueOf(0));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeithzei(BizCurrency.valueOf(0));
        khGensenListDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(19));
        khGensenListDataSourceBean1.setIrGoukeiumukbntodouhuken(C_UmuKbn.ARI);
        khGensenListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        dataSouceList.add(khGensenListDataSourceBean1);

        for (int i = 0; i < 20; i++) {

            khGensenListDataSourceBean = new KhGensenListDataSourceBean();

            khGensenListDataSourceBean.setIrTodoufukenNm("千葉県");
            khGensenListDataSourceBean.setIrKinounm("解約");
            khGensenListDataSourceBean.setIrShrymd("2018年 3月 3日");
            khGensenListDataSourceBean.setIrSyono("12345678901");
            khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(0));
            khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(0));
            khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(0));
            khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
            khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khGensenListDataSourceBean);
        }

        khGensenListDataSourceBean1 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean1.setIrTodoufukenNm("千葉県");

        khGensenListDataSourceBean1.setIrGoukeiinfotodouhuken("千葉県合計");
        khGensenListDataSourceBean1.setIrSaekigoukeitodouhuken(BizCurrency.valueOf(0));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeikkzei(BizCurrency.valueOf(0));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeithzei(BizCurrency.valueOf(0));
        khGensenListDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(20));
        khGensenListDataSourceBean1.setIrGoukeiumukbntodouhuken(C_UmuKbn.ARI);
        khGensenListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        dataSouceList.add(khGensenListDataSourceBean1);


        for (int i = 0; i < 21; i++) {

            khGensenListDataSourceBean = new KhGensenListDataSourceBean();

            khGensenListDataSourceBean.setIrTodoufukenNm("神奈川県");
            khGensenListDataSourceBean.setIrKinounm("解約");
            khGensenListDataSourceBean.setIrShrymd("2018年 3月 3日");
            khGensenListDataSourceBean.setIrSyono("12345678901");
            khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(0));
            khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(0));
            khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(0));
            khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
            khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khGensenListDataSourceBean);
        }

        khGensenListDataSourceBean1 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean1.setIrTodoufukenNm("神奈川県");

        khGensenListDataSourceBean1.setIrGoukeiinfotodouhuken("神奈川県合計");
        khGensenListDataSourceBean1.setIrSaekigoukeitodouhuken(BizCurrency.valueOf(0));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeikkzei(BizCurrency.valueOf(0));
        khGensenListDataSourceBean1.setIrYengstszeigktdhkkeithzei(BizCurrency.valueOf(0));
        khGensenListDataSourceBean1.setIrKensuugoukei(BizNumber.valueOf(21));
        khGensenListDataSourceBean1.setIrGoukeiumukbntodouhuken(C_UmuKbn.ARI);
        khGensenListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        dataSouceList.add(khGensenListDataSourceBean1);

        KhGensenListDataSourceBean khGensenListDataSourceBean2 = new KhGensenListDataSourceBean();
        khGensenListDataSourceBean2.setIrSaekisougoukei(BizCurrency.valueOf(0));
        khGensenListDataSourceBean2.setIrYengstszeigksoukeikkzei(BizCurrency.valueOf(0));
        khGensenListDataSourceBean2.setIrYengstszeigksoukeithzei(BizCurrency.valueOf(0));
        khGensenListDataSourceBean2.setIrKensuusougoukei(BizNumber.valueOf(60));
        khGensenListDataSourceBean2.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
        khGensenListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khGensenListDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, khGensenListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
