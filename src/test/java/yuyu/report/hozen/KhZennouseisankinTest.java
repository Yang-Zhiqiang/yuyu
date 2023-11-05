package yuyu.report.hozen;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Bknkessankbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.bean.report.KhZennouseisankinMeisaiListBean;
import yuyu.def.hozen.bean.report.KhZennouseisankinMeisaiListDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 前納精算金明細リスト 帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhZennouseisankinTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhZennouseisankinMeisaiListBean khZennouseisankinMeisaiListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennouseisankinTest",
                C_SyoruiCdKbn.KK_ZENNOUSEISANKINMEISAILIST_GENGAKU);
        khZennouseisankinMeisaiListBean.setIrTantsitunmkj("");
        khZennouseisankinMeisaiListBean.setIrKessannnd("");
        khZennouseisankinMeisaiListBean.setIrBknkessankbn(C_Bknkessankbn.BLNK);
        khZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd("");
        khZennouseisankinMeisaiListBean.setIrHozonkkn("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean = new KhZennouseisankinMeisaiListDataSourceBean();

        khZennouseisankinMeisaiListDataSourceBean.setIrBkncd("");
        khZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel("");
        khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd("");
        khZennouseisankinMeisaiListDataSourceBean.setIrSyono("");
        khZennouseisankinMeisaiListDataSourceBean.setIrYenseisankin(BizCurrency.valueOf(0));
        khZennouseisankinMeisaiListDataSourceBean.setIrBknkktinnd("");
        khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiym("");
        khZennouseisankinMeisaiListDataSourceBean.setIrSeisankinkensuugoukei(BizNumber.valueOf(0));
        khZennouseisankinMeisaiListDataSourceBean.setIrSeisankingakugoukei(BizCurrency.valueOf(0));
        khZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennouseisankinTest",
                C_SyoruiCdKbn.KK_ZENNOUSEISANKINMEISAILIST_GENGAKU);
        khZennouseisankinMeisaiListBean.setIrTantsitunmkj(null);
        khZennouseisankinMeisaiListBean.setIrKessannnd(null);
        khZennouseisankinMeisaiListBean.setIrBknkessankbn(null);
        khZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd(null);
        khZennouseisankinMeisaiListBean.setIrHozonkkn(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean = new KhZennouseisankinMeisaiListDataSourceBean();

        khZennouseisankinMeisaiListDataSourceBean.setIrBkncd(null);
        khZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel(null);
        khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd(null);
        khZennouseisankinMeisaiListDataSourceBean.setIrSyono(null);
        khZennouseisankinMeisaiListDataSourceBean.setIrYenseisankin(null);
        khZennouseisankinMeisaiListDataSourceBean.setIrBknkktinnd(null);
        khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiym(null);
        khZennouseisankinMeisaiListDataSourceBean.setIrSeisankinkensuugoukei(null);
        khZennouseisankinMeisaiListDataSourceBean.setIrSeisankingakugoukei(null);
        khZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennouseisankinTest",
                C_SyoruiCdKbn.KK_ZENNOUSEISANKINMEISAILIST_GENGAKU);
        khZennouseisankinMeisaiListBean.setIrTantsitunmkj("保全支払サービス室");
        khZennouseisankinMeisaiListBean.setIrKessannnd("2018年度");
        khZennouseisankinMeisaiListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        khZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");
        khZennouseisankinMeisaiListBean.setIrHozonkkn("3年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean = new KhZennouseisankinMeisaiListDataSourceBean();

        khZennouseisankinMeisaiListDataSourceBean.setIrBkncd("PC12");
        khZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel("豪ドル建個人年金保険（一時払）（準有配）");
        khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd("2018年 3月 3日");
        khZennouseisankinMeisaiListDataSourceBean.setIrSyono("10000000001");
        khZennouseisankinMeisaiListDataSourceBean.setIrYenseisankin(BizCurrency.valueOf(999));
        khZennouseisankinMeisaiListDataSourceBean.setIrBknkktinnd("2017年度");
        khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiym("2018年 1月");
        khZennouseisankinMeisaiListDataSourceBean.setIrSeisankinkensuugoukei(BizNumber.valueOf(123));
        khZennouseisankinMeisaiListDataSourceBean.setIrSeisankingakugoukei(BizCurrency.valueOf(101));
        khZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);


        dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennouseisankinTest",
                C_SyoruiCdKbn.KK_ZENNOUSEISANKINMEISAILIST_GENGAKU);
        khZennouseisankinMeisaiListBean.setIrTantsitunmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khZennouseisankinMeisaiListBean.setIrKessannnd("9999年度");
        khZennouseisankinMeisaiListBean.setIrBknkessankbn(C_Bknkessankbn.SHNK);
        khZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd("9999年99月99日");
        khZennouseisankinMeisaiListBean.setIrHozonkkn("99ＷＷ");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean = new KhZennouseisankinMeisaiListDataSourceBean();

        khZennouseisankinMeisaiListDataSourceBean.setIrBkncd("wwww");
        khZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd("9999年99月99日");
        khZennouseisankinMeisaiListDataSourceBean.setIrSyono("wwwwwwwwwww");
        khZennouseisankinMeisaiListDataSourceBean.setIrYenseisankin(BizCurrency.valueOf(9999999999L));
        khZennouseisankinMeisaiListDataSourceBean.setIrBknkktinnd("9999年度");
        khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiym("9999年99月");
        khZennouseisankinMeisaiListDataSourceBean.setIrSeisankinkensuugoukei(BizNumber.valueOf(999999));
        khZennouseisankinMeisaiListDataSourceBean.setIrSeisankingakugoukei(BizCurrency.valueOf(999999999999999L));
        khZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennouseisankinTest",
                C_SyoruiCdKbn.KK_ZENNOUSEISANKINMEISAILIST_GENGAKU);
        khZennouseisankinMeisaiListBean.setIrTantsitunmkj("保全支払サービス室");
        khZennouseisankinMeisaiListBean.setIrKessannnd("2018年度");
        khZennouseisankinMeisaiListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        khZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");
        khZennouseisankinMeisaiListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 33; i++) {

            KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean = new KhZennouseisankinMeisaiListDataSourceBean();

            khZennouseisankinMeisaiListDataSourceBean.setIrBkncd("PC12");
            khZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel("豪ドル建個人年金保険（一時払）（準有配）");
            khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd("2018年 3月 3日");
            khZennouseisankinMeisaiListDataSourceBean.setIrSyono("10000000001");
            khZennouseisankinMeisaiListDataSourceBean.setIrYenseisankin(BizCurrency.valueOf(9999));
            khZennouseisankinMeisaiListDataSourceBean.setIrBknkktinnd("2018年度");
            khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiym("2018年 4月");
            khZennouseisankinMeisaiListDataSourceBean.setIrSeisankinkensuugoukei(BizNumber.valueOf(1234));
            khZennouseisankinMeisaiListDataSourceBean.setIrSeisankingakugoukei(BizCurrency.valueOf(1001));
            khZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennouseisankinTest",
                C_SyoruiCdKbn.KK_ZENNOUSEISANKINMEISAILIST_GENGAKU);
        khZennouseisankinMeisaiListBean.setIrTantsitunmkj("保全支払サービス室");
        khZennouseisankinMeisaiListBean.setIrKessannnd("2018年度");
        khZennouseisankinMeisaiListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        khZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");
        khZennouseisankinMeisaiListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 34; i++) {

            KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean = new KhZennouseisankinMeisaiListDataSourceBean();

            khZennouseisankinMeisaiListDataSourceBean.setIrBkncd("PC02");
            khZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel("豪ドル建個人年金保険（一時払）（準有配）");
            khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd("2018年 3月 3日");
            khZennouseisankinMeisaiListDataSourceBean.setIrSyono("10000000001");
            khZennouseisankinMeisaiListDataSourceBean.setIrYenseisankin(BizCurrency.valueOf(9999));
            khZennouseisankinMeisaiListDataSourceBean.setIrBknkktinnd("2018年度");
            khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiym("2018年 4月");
            khZennouseisankinMeisaiListDataSourceBean.setIrSeisankinkensuugoukei(BizNumber.valueOf(1234));
            khZennouseisankinMeisaiListDataSourceBean.setIrSeisankingakugoukei(BizCurrency.valueOf(1001));
            khZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennouseisankinTest",
                C_SyoruiCdKbn.KK_ZENNOUSEISANKINMEISAILIST_GENGAKU);
        khZennouseisankinMeisaiListBean.setIrTantsitunmkj("保全支払サービス室");
        khZennouseisankinMeisaiListBean.setIrKessannnd("2018年度");
        khZennouseisankinMeisaiListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        khZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");
        khZennouseisankinMeisaiListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 35; i++) {

            KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean = new KhZennouseisankinMeisaiListDataSourceBean();

            khZennouseisankinMeisaiListDataSourceBean.setIrBkncd("PC02");
            khZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel("豪ドル建個人年金保険（一時払）（準有配）");
            khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd("2018年 3月 3日");
            khZennouseisankinMeisaiListDataSourceBean.setIrSyono("10000000001");
            khZennouseisankinMeisaiListDataSourceBean.setIrYenseisankin(BizCurrency.valueOf(9999));
            khZennouseisankinMeisaiListDataSourceBean.setIrBknkktinnd("2018年度");
            khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiym("2018年 4月");
            khZennouseisankinMeisaiListDataSourceBean.setIrSeisankinkensuugoukei(BizNumber.valueOf(1234));
            khZennouseisankinMeisaiListDataSourceBean.setIrSeisankingakugoukei(BizCurrency.valueOf(1001));
            khZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }



    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennouseisankinTest",
                C_SyoruiCdKbn.KK_ZENNOUSEISANKINMEISAILIST_GENGAKU);
        khZennouseisankinMeisaiListBean.setIrTantsitunmkj("保全支払サービス室");
        khZennouseisankinMeisaiListBean.setIrKessannnd("2018年度");
        khZennouseisankinMeisaiListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        khZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");
        khZennouseisankinMeisaiListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 9999; i++) {

            KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean = new KhZennouseisankinMeisaiListDataSourceBean();

            khZennouseisankinMeisaiListDataSourceBean.setIrBkncd(String.valueOf(i));
            khZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd("9999年99月99日");
            khZennouseisankinMeisaiListDataSourceBean.setIrSyono("wwwwwwwwwww");
            khZennouseisankinMeisaiListDataSourceBean.setIrYenseisankin(BizCurrency.valueOf(9999999999L));
            khZennouseisankinMeisaiListDataSourceBean.setIrBknkktinnd("9999年度");
            khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiym("9999年99月");
            khZennouseisankinMeisaiListDataSourceBean.setIrSeisankinkensuugoukei(BizNumber.valueOf(999999));
            khZennouseisankinMeisaiListDataSourceBean.setIrSeisankingakugoukei(BizCurrency.valueOf(999999999999999L));
            khZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennouseisankinTest",
                C_SyoruiCdKbn.KK_ZENNOUSEISANKINMEISAILIST_GENGAKU);
        khZennouseisankinMeisaiListBean.setIrTantsitunmkj("保全支払サービス室");
        khZennouseisankinMeisaiListBean.setIrKessannnd("2018年度");
        khZennouseisankinMeisaiListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        khZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");
        khZennouseisankinMeisaiListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean1 = new KhZennouseisankinMeisaiListDataSourceBean();

        khZennouseisankinMeisaiListDataSourceBean1.setIrBkncd("PC12");
        khZennouseisankinMeisaiListDataSourceBean1.setIrHknsyruilevel("米ドル建個人年金保険（一時払）（準有配）");
        khZennouseisankinMeisaiListDataSourceBean1.setIrBknkktiymd("2018年 3月 3日");
        khZennouseisankinMeisaiListDataSourceBean1.setIrSyono("10000000001");
        khZennouseisankinMeisaiListDataSourceBean1.setIrYenseisankin(BizCurrency.valueOf(9999));
        khZennouseisankinMeisaiListDataSourceBean1.setIrBknkktinnd("2017年度");
        khZennouseisankinMeisaiListDataSourceBean1.setIrBknkktiym("2017年 4月");
        khZennouseisankinMeisaiListDataSourceBean1.setIrSeisankinkensuugoukei(BizNumber.valueOf(1234));
        khZennouseisankinMeisaiListDataSourceBean1.setIrSeisankingakugoukei(BizCurrency.valueOf(1001));
        khZennouseisankinMeisaiListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean1);

        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean2 = new KhZennouseisankinMeisaiListDataSourceBean();

        khZennouseisankinMeisaiListDataSourceBean2.setIrBkncd("PC12");
        khZennouseisankinMeisaiListDataSourceBean2.setIrHknsyruilevel("米ドル建個人年金保険（一時払）（準有配）");
        khZennouseisankinMeisaiListDataSourceBean2.setIrBknkktiymd("2018年 3月 3日");
        khZennouseisankinMeisaiListDataSourceBean2.setIrSyono("10000000001");
        khZennouseisankinMeisaiListDataSourceBean2.setIrYenseisankin(BizCurrency.valueOf(9999));
        khZennouseisankinMeisaiListDataSourceBean2.setIrBknkktinnd("2017年度");
        khZennouseisankinMeisaiListDataSourceBean2.setIrBknkktiym("2018年 1月");
        khZennouseisankinMeisaiListDataSourceBean2.setIrSeisankinkensuugoukei(BizNumber.valueOf(1234));
        khZennouseisankinMeisaiListDataSourceBean2.setIrSeisankingakugoukei(BizCurrency.valueOf(1001));
        khZennouseisankinMeisaiListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean2);

        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean3 = new KhZennouseisankinMeisaiListDataSourceBean();

        khZennouseisankinMeisaiListDataSourceBean3.setIrBkncd("PC12");
        khZennouseisankinMeisaiListDataSourceBean3.setIrHknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        khZennouseisankinMeisaiListDataSourceBean3.setIrBknkktiymd("2018年 3月 3日");
        khZennouseisankinMeisaiListDataSourceBean3.setIrSyono("10000000001");
        khZennouseisankinMeisaiListDataSourceBean3.setIrYenseisankin(BizCurrency.valueOf(9999));
        khZennouseisankinMeisaiListDataSourceBean3.setIrBknkktinnd("2017年度");
        khZennouseisankinMeisaiListDataSourceBean3.setIrBknkktiym("2018年 1月");
        khZennouseisankinMeisaiListDataSourceBean3.setIrSeisankinkensuugoukei(BizNumber.valueOf(1234));
        khZennouseisankinMeisaiListDataSourceBean3.setIrSeisankingakugoukei(BizCurrency.valueOf(1001));
        khZennouseisankinMeisaiListDataSourceBean3.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean3);

        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean4 = new KhZennouseisankinMeisaiListDataSourceBean();

        khZennouseisankinMeisaiListDataSourceBean4.setIrBkncd("PC12");
        khZennouseisankinMeisaiListDataSourceBean4.setIrHknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        khZennouseisankinMeisaiListDataSourceBean4.setIrBknkktiymd("2018年 3月 3日");
        khZennouseisankinMeisaiListDataSourceBean4.setIrSyono("10000000001");
        khZennouseisankinMeisaiListDataSourceBean4.setIrYenseisankin(BizCurrency.valueOf(9999));
        khZennouseisankinMeisaiListDataSourceBean4.setIrBknkktinnd("2018年度");
        khZennouseisankinMeisaiListDataSourceBean4.setIrBknkktiym("2018年 1月");
        khZennouseisankinMeisaiListDataSourceBean4.setIrSeisankinkensuugoukei(BizNumber.valueOf(1234));
        khZennouseisankinMeisaiListDataSourceBean4.setIrSeisankingakugoukei(BizCurrency.valueOf(1001));
        khZennouseisankinMeisaiListDataSourceBean4.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean4);

        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean5 = new KhZennouseisankinMeisaiListDataSourceBean();

        khZennouseisankinMeisaiListDataSourceBean5.setIrBkncd("PC02");
        khZennouseisankinMeisaiListDataSourceBean5.setIrHknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        khZennouseisankinMeisaiListDataSourceBean5.setIrBknkktiymd("2018年 3月 3日");
        khZennouseisankinMeisaiListDataSourceBean5.setIrSyono("10000000001");
        khZennouseisankinMeisaiListDataSourceBean5.setIrYenseisankin(BizCurrency.valueOf(9999));
        khZennouseisankinMeisaiListDataSourceBean5.setIrBknkktinnd("2018年度");
        khZennouseisankinMeisaiListDataSourceBean5.setIrBknkktiym("2018年 1月");
        khZennouseisankinMeisaiListDataSourceBean5.setIrSeisankinkensuugoukei(BizNumber.valueOf(1234));
        khZennouseisankinMeisaiListDataSourceBean5.setIrSeisankingakugoukei(BizCurrency.valueOf(1001));
        khZennouseisankinMeisaiListDataSourceBean5.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean5);

        reportTestBean.addParamObjects(dataSouceList, khZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennouseisankinTest",
                C_SyoruiCdKbn.KK_ZENNOUSEISANKINMEISAILIST_GENGAKU);
        khZennouseisankinMeisaiListBean.setIrTantsitunmkj("保全支払サービス室");
        khZennouseisankinMeisaiListBean.setIrKessannnd("2018年度");
        khZennouseisankinMeisaiListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        khZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");
        khZennouseisankinMeisaiListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean1 = new KhZennouseisankinMeisaiListDataSourceBean();

        khZennouseisankinMeisaiListDataSourceBean1.setIrBkncd("PC12");
        khZennouseisankinMeisaiListDataSourceBean1.setIrHknsyruilevel("米ドル建個人年金保険（一時払）（準有配）");
        khZennouseisankinMeisaiListDataSourceBean1.setIrBknkktiymd("2018年 3月 3日");
        khZennouseisankinMeisaiListDataSourceBean1.setIrSyono("10000000001");
        khZennouseisankinMeisaiListDataSourceBean1.setIrYenseisankin(BizCurrency.valueOf(100));
        khZennouseisankinMeisaiListDataSourceBean1.setIrBknkktinnd("2017年度");
        khZennouseisankinMeisaiListDataSourceBean1.setIrBknkktiym("2017年 4月");
        khZennouseisankinMeisaiListDataSourceBean1.setIrSeisankinkensuugoukei(BizNumber.valueOf(1));
        khZennouseisankinMeisaiListDataSourceBean1.setIrSeisankingakugoukei(BizCurrency.valueOf(100));
        khZennouseisankinMeisaiListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean1);

        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean2 = new KhZennouseisankinMeisaiListDataSourceBean();

        khZennouseisankinMeisaiListDataSourceBean2.setIrBkncd("PC12");
        khZennouseisankinMeisaiListDataSourceBean2.setIrHknsyruilevel("米ドル建個人年金保険（一時払）（準有配）");
        khZennouseisankinMeisaiListDataSourceBean2.setIrBknkktiymd("2018年 3月 3日");
        khZennouseisankinMeisaiListDataSourceBean2.setIrSyono("10000000001");
        khZennouseisankinMeisaiListDataSourceBean2.setIrYenseisankin(BizCurrency.valueOf(200));
        khZennouseisankinMeisaiListDataSourceBean2.setIrBknkktinnd("2017年度");
        khZennouseisankinMeisaiListDataSourceBean2.setIrBknkktiym("2018年 1月");
        khZennouseisankinMeisaiListDataSourceBean2.setIrSeisankinkensuugoukei(BizNumber.valueOf(1));
        khZennouseisankinMeisaiListDataSourceBean2.setIrSeisankingakugoukei(BizCurrency.valueOf(200));
        khZennouseisankinMeisaiListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean2);

        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean3 = new KhZennouseisankinMeisaiListDataSourceBean();

        khZennouseisankinMeisaiListDataSourceBean3.setIrBkncd("PC12");
        khZennouseisankinMeisaiListDataSourceBean3.setIrHknsyruilevel("米ドル建個人年金保険（一時払）（準有配）");
        khZennouseisankinMeisaiListDataSourceBean3.setIrBknkktiymd("");
        khZennouseisankinMeisaiListDataSourceBean3.setIrSyono("");
        khZennouseisankinMeisaiListDataSourceBean3.setIrYenseisankin(null);
        khZennouseisankinMeisaiListDataSourceBean3.setIrBknkktinnd("2017年度");
        khZennouseisankinMeisaiListDataSourceBean3.setIrBknkktiym("");
        khZennouseisankinMeisaiListDataSourceBean3.setIrSeisankinkensuugoukei(BizNumber.valueOf(2));
        khZennouseisankinMeisaiListDataSourceBean3.setIrSeisankingakugoukei(BizCurrency.valueOf(300));
        khZennouseisankinMeisaiListDataSourceBean3.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean3);

        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean4 = new KhZennouseisankinMeisaiListDataSourceBean();

        khZennouseisankinMeisaiListDataSourceBean4.setIrBkncd("PC12");
        khZennouseisankinMeisaiListDataSourceBean4.setIrHknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        khZennouseisankinMeisaiListDataSourceBean4.setIrBknkktiymd("2018年 3月 3日");
        khZennouseisankinMeisaiListDataSourceBean4.setIrSyono("10000000001");
        khZennouseisankinMeisaiListDataSourceBean4.setIrYenseisankin(BizCurrency.valueOf(300));
        khZennouseisankinMeisaiListDataSourceBean4.setIrBknkktinnd("2017年度");
        khZennouseisankinMeisaiListDataSourceBean4.setIrBknkktiym("2017年 4月");
        khZennouseisankinMeisaiListDataSourceBean4.setIrSeisankinkensuugoukei(BizNumber.valueOf(1));
        khZennouseisankinMeisaiListDataSourceBean4.setIrSeisankingakugoukei(BizCurrency.valueOf(300));
        khZennouseisankinMeisaiListDataSourceBean4.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean4);

        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean5 = new KhZennouseisankinMeisaiListDataSourceBean();

        khZennouseisankinMeisaiListDataSourceBean5.setIrBkncd("PC12");
        khZennouseisankinMeisaiListDataSourceBean5.setIrHknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        khZennouseisankinMeisaiListDataSourceBean5.setIrBknkktiymd("");
        khZennouseisankinMeisaiListDataSourceBean5.setIrSyono("");
        khZennouseisankinMeisaiListDataSourceBean5.setIrYenseisankin(null);
        khZennouseisankinMeisaiListDataSourceBean5.setIrBknkktinnd("2017年度");
        khZennouseisankinMeisaiListDataSourceBean5.setIrBknkktiym("");
        khZennouseisankinMeisaiListDataSourceBean5.setIrSeisankinkensuugoukei(BizNumber.valueOf(1));
        khZennouseisankinMeisaiListDataSourceBean5.setIrSeisankingakugoukei(BizCurrency.valueOf(300));
        khZennouseisankinMeisaiListDataSourceBean5.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean5);

        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean6 = new KhZennouseisankinMeisaiListDataSourceBean();

        khZennouseisankinMeisaiListDataSourceBean6.setIrBkncd("PC12");
        khZennouseisankinMeisaiListDataSourceBean6.setIrHknsyruilevel("");
        khZennouseisankinMeisaiListDataSourceBean6.setIrBknkktiymd("");
        khZennouseisankinMeisaiListDataSourceBean6.setIrSyono("");
        khZennouseisankinMeisaiListDataSourceBean6.setIrYenseisankin(null);
        khZennouseisankinMeisaiListDataSourceBean6.setIrBknkktinnd("2017年度");
        khZennouseisankinMeisaiListDataSourceBean6.setIrBknkktiym("");
        khZennouseisankinMeisaiListDataSourceBean6.setIrSeisankinkensuugoukei(BizNumber.valueOf(3));
        khZennouseisankinMeisaiListDataSourceBean6.setIrSeisankingakugoukei(BizCurrency.valueOf(600));
        khZennouseisankinMeisaiListDataSourceBean6.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean6);

        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean7 = new KhZennouseisankinMeisaiListDataSourceBean();

        khZennouseisankinMeisaiListDataSourceBean7.setIrBkncd("PC12");
        khZennouseisankinMeisaiListDataSourceBean7.setIrHknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        khZennouseisankinMeisaiListDataSourceBean7.setIrBknkktiymd("2018年 3月 3日");
        khZennouseisankinMeisaiListDataSourceBean7.setIrSyono("10000000001");
        khZennouseisankinMeisaiListDataSourceBean7.setIrYenseisankin(BizCurrency.valueOf(400));
        khZennouseisankinMeisaiListDataSourceBean7.setIrBknkktinnd("2018年度");
        khZennouseisankinMeisaiListDataSourceBean7.setIrBknkktiym("2018年 4月");
        khZennouseisankinMeisaiListDataSourceBean7.setIrSeisankinkensuugoukei(BizNumber.valueOf(1));
        khZennouseisankinMeisaiListDataSourceBean7.setIrSeisankingakugoukei(BizCurrency.valueOf(400));
        khZennouseisankinMeisaiListDataSourceBean7.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean7);

        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean8 = new KhZennouseisankinMeisaiListDataSourceBean();

        khZennouseisankinMeisaiListDataSourceBean8.setIrBkncd("PC12");
        khZennouseisankinMeisaiListDataSourceBean8.setIrHknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        khZennouseisankinMeisaiListDataSourceBean8.setIrBknkktiymd("");
        khZennouseisankinMeisaiListDataSourceBean8.setIrSyono("");
        khZennouseisankinMeisaiListDataSourceBean8.setIrYenseisankin(null);
        khZennouseisankinMeisaiListDataSourceBean8.setIrBknkktinnd("2018年度");
        khZennouseisankinMeisaiListDataSourceBean8.setIrBknkktiym("");
        khZennouseisankinMeisaiListDataSourceBean8.setIrSeisankinkensuugoukei(BizNumber.valueOf(1));
        khZennouseisankinMeisaiListDataSourceBean8.setIrSeisankingakugoukei(BizCurrency.valueOf(400));
        khZennouseisankinMeisaiListDataSourceBean8.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean8);

        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean9 = new KhZennouseisankinMeisaiListDataSourceBean();

        khZennouseisankinMeisaiListDataSourceBean9.setIrBkncd("PC12");
        khZennouseisankinMeisaiListDataSourceBean9.setIrHknsyruilevel("");
        khZennouseisankinMeisaiListDataSourceBean9.setIrBknkktiymd("");
        khZennouseisankinMeisaiListDataSourceBean9.setIrSyono("");
        khZennouseisankinMeisaiListDataSourceBean9.setIrYenseisankin(null);
        khZennouseisankinMeisaiListDataSourceBean9.setIrBknkktinnd("2018年度");
        khZennouseisankinMeisaiListDataSourceBean9.setIrBknkktiym("");
        khZennouseisankinMeisaiListDataSourceBean9.setIrSeisankinkensuugoukei(BizNumber.valueOf(1));
        khZennouseisankinMeisaiListDataSourceBean9.setIrSeisankingakugoukei(BizCurrency.valueOf(400));
        khZennouseisankinMeisaiListDataSourceBean9.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean9);

        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean10 = new KhZennouseisankinMeisaiListDataSourceBean();

        khZennouseisankinMeisaiListDataSourceBean10.setIrBkncd("PC12");
        khZennouseisankinMeisaiListDataSourceBean10.setIrHknsyruilevel("");
        khZennouseisankinMeisaiListDataSourceBean10.setIrBknkktiymd("");
        khZennouseisankinMeisaiListDataSourceBean10.setIrSyono("");
        khZennouseisankinMeisaiListDataSourceBean10.setIrYenseisankin(null);
        khZennouseisankinMeisaiListDataSourceBean10.setIrBknkktinnd("");
        khZennouseisankinMeisaiListDataSourceBean10.setIrBknkktiym("");
        khZennouseisankinMeisaiListDataSourceBean10.setIrSeisankinkensuugoukei(BizNumber.valueOf(4));
        khZennouseisankinMeisaiListDataSourceBean10.setIrSeisankingakugoukei(BizCurrency.valueOf(1000));
        khZennouseisankinMeisaiListDataSourceBean10.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khZennouseisankinMeisaiListDataSourceBean10);

        reportTestBean.addParamObjects(dataSouceList, khZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhZennouseisankinTest",
                C_SyoruiCdKbn.KK_ZENNOUSEISANKINMEISAILIST_GENGAKU);
        khZennouseisankinMeisaiListBean.setIrTantsitunmkj("保全支払サービス室");
        khZennouseisankinMeisaiListBean.setIrKessannnd("2018年度");
        khZennouseisankinMeisaiListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        khZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");
        khZennouseisankinMeisaiListBean.setIrHozonkkn("3年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, khZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

}
