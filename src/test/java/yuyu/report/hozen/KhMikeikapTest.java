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
import yuyu.def.hozen.bean.report.KhMikeikapHenkinListBean;
import yuyu.def.hozen.bean.report.KhMikeikapHenkinListDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 未経過Ｐ返金リスト 帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhMikeikapTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhMikeikapHenkinListBean khMikeikapHenkinListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMikeikapTest",
                C_SyoruiCdKbn.KK_MKKPHENKINLIST_GENGAKU);

        khMikeikapHenkinListBean.setIrTantsitunmkj("");
        khMikeikapHenkinListBean.setIrKessannnd("");

        khMikeikapHenkinListBean.setIrBknkessankbn(C_Bknkessankbn.BLNK);
        khMikeikapHenkinListBean.setIrTyouhyousakuseiymd("");

        khMikeikapHenkinListBean.setIrHozonkkn("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean = new KhMikeikapHenkinListDataSourceBean();


        khMikeikapHenkinListDataSourceBean.setIrBkncd("");
        khMikeikapHenkinListDataSourceBean.setIrHknsyruilevel("");
        khMikeikapHenkinListDataSourceBean.setIrMikeikapkktiymd("");
        khMikeikapHenkinListDataSourceBean.setIrSyono("");

        khMikeikapHenkinListDataSourceBean.setIrMikeikap(BizCurrency.valueOf(0));
        khMikeikapHenkinListDataSourceBean.setIrMikeikapkktinnd("");

        khMikeikapHenkinListDataSourceBean.setIrMikeikapkktiym("");

        khMikeikapHenkinListDataSourceBean.setIrHenkinkensuugoukei(BizNumber.valueOf(0));

        khMikeikapHenkinListDataSourceBean.setIrHenkingakugoukei(BizCurrency.valueOf(0));

        khMikeikapHenkinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khMikeikapHenkinListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khMikeikapHenkinListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMikeikapTest",
                C_SyoruiCdKbn.KK_MKKPHENKINLIST_GENGAKU);

        khMikeikapHenkinListBean.setIrTantsitunmkj(null);
        khMikeikapHenkinListBean.setIrKessannnd(null);

        khMikeikapHenkinListBean.setIrBknkessankbn(null);
        khMikeikapHenkinListBean.setIrTyouhyousakuseiymd(null);

        khMikeikapHenkinListBean.setIrHozonkkn(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean = new KhMikeikapHenkinListDataSourceBean();


        khMikeikapHenkinListDataSourceBean.setIrBkncd(null);
        khMikeikapHenkinListDataSourceBean.setIrHknsyruilevel(null);
        khMikeikapHenkinListDataSourceBean.setIrMikeikapkktiymd(null);
        khMikeikapHenkinListDataSourceBean.setIrSyono(null);

        khMikeikapHenkinListDataSourceBean.setIrMikeikap(null);
        khMikeikapHenkinListDataSourceBean.setIrMikeikapkktinnd(null);

        khMikeikapHenkinListDataSourceBean.setIrMikeikapkktiym(null);

        khMikeikapHenkinListDataSourceBean.setIrHenkinkensuugoukei(null);

        khMikeikapHenkinListDataSourceBean.setIrHenkingakugoukei(null);

        khMikeikapHenkinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khMikeikapHenkinListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khMikeikapHenkinListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMikeikapTest",
                C_SyoruiCdKbn.KK_MKKPHENKINLIST_GENGAKU);

        khMikeikapHenkinListBean.setIrTantsitunmkj("保全支払サービス室");
        khMikeikapHenkinListBean.setIrKessannnd("2018年度");

        khMikeikapHenkinListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        khMikeikapHenkinListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");

        khMikeikapHenkinListBean.setIrHozonkkn("3年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean = new KhMikeikapHenkinListDataSourceBean();


        khMikeikapHenkinListDataSourceBean.setIrBkncd("PC12");
        khMikeikapHenkinListDataSourceBean.setIrHknsyruilevel("豪ドル建個人年金保険（一時払）（準有配）");
        khMikeikapHenkinListDataSourceBean.setIrMikeikapkktiymd("2018年 3月 3日");
        khMikeikapHenkinListDataSourceBean.setIrSyono("10000000001");

        khMikeikapHenkinListDataSourceBean.setIrMikeikap(BizCurrency.valueOf(999));
        khMikeikapHenkinListDataSourceBean.setIrMikeikapkktinnd("2017年度");

        khMikeikapHenkinListDataSourceBean.setIrMikeikapkktiym("2018年 1月");

        khMikeikapHenkinListDataSourceBean.setIrHenkinkensuugoukei(BizNumber.valueOf(123));

        khMikeikapHenkinListDataSourceBean.setIrHenkingakugoukei(BizCurrency.valueOf(101));

        khMikeikapHenkinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);


        dataSouceList.add(khMikeikapHenkinListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khMikeikapHenkinListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMikeikapTest",
                C_SyoruiCdKbn.KK_MKKPHENKINLIST_GENGAKU);

        khMikeikapHenkinListBean.setIrTantsitunmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khMikeikapHenkinListBean.setIrKessannnd("9999年度");

        khMikeikapHenkinListBean.setIrBknkessankbn(C_Bknkessankbn.SHNK);
        khMikeikapHenkinListBean.setIrTyouhyousakuseiymd("9999年99月99日");

        khMikeikapHenkinListBean.setIrHozonkkn("99ＷＷ");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean = new KhMikeikapHenkinListDataSourceBean();


        khMikeikapHenkinListDataSourceBean.setIrBkncd("wwww");
        khMikeikapHenkinListDataSourceBean.setIrHknsyruilevel("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khMikeikapHenkinListDataSourceBean.setIrMikeikapkktiymd("9999年99月99日");
        khMikeikapHenkinListDataSourceBean.setIrSyono("wwwwwwwwwww");

        khMikeikapHenkinListDataSourceBean.setIrMikeikap(BizCurrency.valueOf(9999999999L));
        khMikeikapHenkinListDataSourceBean.setIrMikeikapkktinnd("9999年度");

        khMikeikapHenkinListDataSourceBean.setIrMikeikapkktiym("9999年99月");

        khMikeikapHenkinListDataSourceBean.setIrHenkinkensuugoukei(BizNumber.valueOf(999999));

        khMikeikapHenkinListDataSourceBean.setIrHenkingakugoukei(BizCurrency.valueOf(999999999999999L));

        khMikeikapHenkinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khMikeikapHenkinListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khMikeikapHenkinListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMikeikapTest",
                C_SyoruiCdKbn.KK_MKKPHENKINLIST_GENGAKU);

        khMikeikapHenkinListBean.setIrTantsitunmkj("保全支払サービス室");
        khMikeikapHenkinListBean.setIrKessannnd("2018年度");

        khMikeikapHenkinListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        khMikeikapHenkinListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");

        khMikeikapHenkinListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 33; i++) {

            KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean = new KhMikeikapHenkinListDataSourceBean();


            khMikeikapHenkinListDataSourceBean.setIrBkncd("PC12");
            khMikeikapHenkinListDataSourceBean.setIrHknsyruilevel("豪ドル建個人年金保険（一時払）（準有配）");
            khMikeikapHenkinListDataSourceBean.setIrMikeikapkktiymd("2018年 3月 3日");
            khMikeikapHenkinListDataSourceBean.setIrSyono("10000000001");

            khMikeikapHenkinListDataSourceBean.setIrMikeikap(BizCurrency.valueOf(9999));
            khMikeikapHenkinListDataSourceBean.setIrMikeikapkktinnd("2018年度");

            khMikeikapHenkinListDataSourceBean.setIrMikeikapkktiym("2018年 4月");

            khMikeikapHenkinListDataSourceBean.setIrHenkinkensuugoukei(BizNumber.valueOf(1234));

            khMikeikapHenkinListDataSourceBean.setIrHenkingakugoukei(BizCurrency.valueOf(1001));

            khMikeikapHenkinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khMikeikapHenkinListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khMikeikapHenkinListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMikeikapTest",
                C_SyoruiCdKbn.KK_MKKPHENKINLIST_GENGAKU);

        khMikeikapHenkinListBean.setIrTantsitunmkj("保全支払サービス室");
        khMikeikapHenkinListBean.setIrKessannnd("2018年度");

        khMikeikapHenkinListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        khMikeikapHenkinListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");

        khMikeikapHenkinListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 34; i++) {

            KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean = new KhMikeikapHenkinListDataSourceBean();


            khMikeikapHenkinListDataSourceBean.setIrBkncd("PC02");
            khMikeikapHenkinListDataSourceBean.setIrHknsyruilevel("豪ドル建個人年金保険（一時払）（準有配）");
            khMikeikapHenkinListDataSourceBean.setIrMikeikapkktiymd("2018年 3月 3日");
            khMikeikapHenkinListDataSourceBean.setIrSyono("10000000001");

            khMikeikapHenkinListDataSourceBean.setIrMikeikap(BizCurrency.valueOf(9999));
            khMikeikapHenkinListDataSourceBean.setIrMikeikapkktinnd("2018年度");

            khMikeikapHenkinListDataSourceBean.setIrMikeikapkktiym("2018年 4月");

            khMikeikapHenkinListDataSourceBean.setIrHenkinkensuugoukei(BizNumber.valueOf(1234));

            khMikeikapHenkinListDataSourceBean.setIrHenkingakugoukei(BizCurrency.valueOf(1001));

            khMikeikapHenkinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khMikeikapHenkinListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khMikeikapHenkinListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMikeikapTest",
                C_SyoruiCdKbn.KK_MKKPHENKINLIST_GENGAKU);

        khMikeikapHenkinListBean.setIrTantsitunmkj("保全支払サービス室");
        khMikeikapHenkinListBean.setIrKessannnd("2018年度");

        khMikeikapHenkinListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        khMikeikapHenkinListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");

        khMikeikapHenkinListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 35; i++) {

            KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean = new KhMikeikapHenkinListDataSourceBean();


            khMikeikapHenkinListDataSourceBean.setIrBkncd("PC02");
            khMikeikapHenkinListDataSourceBean.setIrHknsyruilevel("豪ドル建個人年金保険（一時払）（準有配）");
            khMikeikapHenkinListDataSourceBean.setIrMikeikapkktiymd("2018年 3月 3日");
            khMikeikapHenkinListDataSourceBean.setIrSyono("10000000001");

            khMikeikapHenkinListDataSourceBean.setIrMikeikap(BizCurrency.valueOf(9999));
            khMikeikapHenkinListDataSourceBean.setIrMikeikapkktinnd("2018年度");

            khMikeikapHenkinListDataSourceBean.setIrMikeikapkktiym("2018年 4月");

            khMikeikapHenkinListDataSourceBean.setIrHenkinkensuugoukei(BizNumber.valueOf(1234));

            khMikeikapHenkinListDataSourceBean.setIrHenkingakugoukei(BizCurrency.valueOf(1001));

            khMikeikapHenkinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khMikeikapHenkinListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khMikeikapHenkinListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMikeikapTest",
                C_SyoruiCdKbn.KK_MKKPHENKINLIST_GENGAKU);

        khMikeikapHenkinListBean.setIrTantsitunmkj("保全支払サービス室");
        khMikeikapHenkinListBean.setIrKessannnd("2018年度");

        khMikeikapHenkinListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        khMikeikapHenkinListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");

        khMikeikapHenkinListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 339966; i++) {

            KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean = new KhMikeikapHenkinListDataSourceBean();


            khMikeikapHenkinListDataSourceBean.setIrBkncd("wwww");
            khMikeikapHenkinListDataSourceBean.setIrHknsyruilevel("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khMikeikapHenkinListDataSourceBean.setIrMikeikapkktiymd("9999年99月99日");
            khMikeikapHenkinListDataSourceBean.setIrSyono("wwwwwwwwwww");

            khMikeikapHenkinListDataSourceBean.setIrMikeikap(BizCurrency.valueOf(9999999999L));
            khMikeikapHenkinListDataSourceBean.setIrMikeikapkktinnd("9999年度");

            khMikeikapHenkinListDataSourceBean.setIrMikeikapkktiym("9999年99月");

            khMikeikapHenkinListDataSourceBean.setIrHenkinkensuugoukei(BizNumber.valueOf(999999));

            khMikeikapHenkinListDataSourceBean.setIrHenkingakugoukei(BizCurrency.valueOf(999999999999999L));

            khMikeikapHenkinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khMikeikapHenkinListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khMikeikapHenkinListBean);

        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMikeikapTest",
                C_SyoruiCdKbn.KK_MKKPHENKINLIST_GENGAKU);

        khMikeikapHenkinListBean.setIrTantsitunmkj("保全支払サービス室");
        khMikeikapHenkinListBean.setIrKessannnd("2018年度");

        khMikeikapHenkinListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        khMikeikapHenkinListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");

        khMikeikapHenkinListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean1 = new KhMikeikapHenkinListDataSourceBean();


        khMikeikapHenkinListDataSourceBean1.setIrBkncd("PC12");
        khMikeikapHenkinListDataSourceBean1.setIrHknsyruilevel("米ドル建個人年金保険（一時払）（準有配）");
        khMikeikapHenkinListDataSourceBean1.setIrMikeikapkktiymd("2018年 3月 3日");
        khMikeikapHenkinListDataSourceBean1.setIrSyono("10000000001");

        khMikeikapHenkinListDataSourceBean1.setIrMikeikap(BizCurrency.valueOf(9999));
        khMikeikapHenkinListDataSourceBean1.setIrMikeikapkktinnd("2017年度");

        khMikeikapHenkinListDataSourceBean1.setIrMikeikapkktiym("2017年 4月");

        khMikeikapHenkinListDataSourceBean1.setIrHenkinkensuugoukei(BizNumber.valueOf(1234));

        khMikeikapHenkinListDataSourceBean1.setIrHenkingakugoukei(BizCurrency.valueOf(1001));

        khMikeikapHenkinListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khMikeikapHenkinListDataSourceBean1);

        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean2 = new KhMikeikapHenkinListDataSourceBean();


        khMikeikapHenkinListDataSourceBean2.setIrBkncd("PC12");
        khMikeikapHenkinListDataSourceBean2.setIrHknsyruilevel("米ドル建個人年金保険（一時払）（準有配）");
        khMikeikapHenkinListDataSourceBean2.setIrMikeikapkktiymd("2018年 3月 3日");
        khMikeikapHenkinListDataSourceBean2.setIrSyono("10000000001");

        khMikeikapHenkinListDataSourceBean2.setIrMikeikap(BizCurrency.valueOf(9999));
        khMikeikapHenkinListDataSourceBean2.setIrMikeikapkktinnd("2017年度");

        khMikeikapHenkinListDataSourceBean2.setIrMikeikapkktiym("2018年 1月");

        khMikeikapHenkinListDataSourceBean2.setIrHenkinkensuugoukei(BizNumber.valueOf(1234));

        khMikeikapHenkinListDataSourceBean2.setIrHenkingakugoukei(BizCurrency.valueOf(1001));

        khMikeikapHenkinListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khMikeikapHenkinListDataSourceBean2);

        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean3 = new KhMikeikapHenkinListDataSourceBean();


        khMikeikapHenkinListDataSourceBean3.setIrBkncd("PC12");
        khMikeikapHenkinListDataSourceBean3.setIrHknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        khMikeikapHenkinListDataSourceBean3.setIrMikeikapkktiymd("2018年 3月 3日");
        khMikeikapHenkinListDataSourceBean3.setIrSyono("10000000001");

        khMikeikapHenkinListDataSourceBean3.setIrMikeikap(BizCurrency.valueOf(9999));
        khMikeikapHenkinListDataSourceBean3.setIrMikeikapkktinnd("2017年度");

        khMikeikapHenkinListDataSourceBean3.setIrMikeikapkktiym("2018年 1月");

        khMikeikapHenkinListDataSourceBean3.setIrHenkinkensuugoukei(BizNumber.valueOf(1234));

        khMikeikapHenkinListDataSourceBean3.setIrHenkingakugoukei(BizCurrency.valueOf(1001));

        khMikeikapHenkinListDataSourceBean3.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khMikeikapHenkinListDataSourceBean3);

        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean4 = new KhMikeikapHenkinListDataSourceBean();


        khMikeikapHenkinListDataSourceBean4.setIrBkncd("PC12");
        khMikeikapHenkinListDataSourceBean4.setIrHknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        khMikeikapHenkinListDataSourceBean4.setIrMikeikapkktiymd("2018年 3月 3日");
        khMikeikapHenkinListDataSourceBean4.setIrSyono("10000000001");

        khMikeikapHenkinListDataSourceBean4.setIrMikeikap(BizCurrency.valueOf(9999));
        khMikeikapHenkinListDataSourceBean4.setIrMikeikapkktinnd("2018年度");

        khMikeikapHenkinListDataSourceBean4.setIrMikeikapkktiym("2018年 1月");

        khMikeikapHenkinListDataSourceBean4.setIrHenkinkensuugoukei(BizNumber.valueOf(1234));

        khMikeikapHenkinListDataSourceBean4.setIrHenkingakugoukei(BizCurrency.valueOf(1001));

        khMikeikapHenkinListDataSourceBean4.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khMikeikapHenkinListDataSourceBean4);

        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean5 = new KhMikeikapHenkinListDataSourceBean();


        khMikeikapHenkinListDataSourceBean5.setIrBkncd("PC02");
        khMikeikapHenkinListDataSourceBean5.setIrHknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        khMikeikapHenkinListDataSourceBean5.setIrMikeikapkktiymd("2018年 3月 3日");
        khMikeikapHenkinListDataSourceBean5.setIrSyono("10000000001");

        khMikeikapHenkinListDataSourceBean5.setIrMikeikap(BizCurrency.valueOf(9999));
        khMikeikapHenkinListDataSourceBean5.setIrMikeikapkktinnd("2018年度");

        khMikeikapHenkinListDataSourceBean5.setIrMikeikapkktiym("2018年 1月");

        khMikeikapHenkinListDataSourceBean5.setIrHenkinkensuugoukei(BizNumber.valueOf(1234));

        khMikeikapHenkinListDataSourceBean5.setIrHenkingakugoukei(BizCurrency.valueOf(1001));

        khMikeikapHenkinListDataSourceBean5.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khMikeikapHenkinListDataSourceBean5);

        reportTestBean.addParamObjects(dataSouceList, khMikeikapHenkinListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMikeikapTest",
                C_SyoruiCdKbn.KK_MKKPHENKINLIST_GENGAKU);

        khMikeikapHenkinListBean.setIrTantsitunmkj("保全支払サービス室");
        khMikeikapHenkinListBean.setIrKessannnd("2018年度");

        khMikeikapHenkinListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        khMikeikapHenkinListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");

        khMikeikapHenkinListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean1 = new KhMikeikapHenkinListDataSourceBean();


        khMikeikapHenkinListDataSourceBean1.setIrBkncd("PC12");
        khMikeikapHenkinListDataSourceBean1.setIrHknsyruilevel("米ドル建個人年金保険（一時払）（準有配）");
        khMikeikapHenkinListDataSourceBean1.setIrMikeikapkktiymd("2018年 3月 3日");
        khMikeikapHenkinListDataSourceBean1.setIrSyono("10000000001");

        khMikeikapHenkinListDataSourceBean1.setIrMikeikap(BizCurrency.valueOf(100));
        khMikeikapHenkinListDataSourceBean1.setIrMikeikapkktinnd("2017年度");

        khMikeikapHenkinListDataSourceBean1.setIrMikeikapkktiym("2017年 4月");

        khMikeikapHenkinListDataSourceBean1.setIrHenkinkensuugoukei(BizNumber.valueOf(1));

        khMikeikapHenkinListDataSourceBean1.setIrHenkingakugoukei(BizCurrency.valueOf(100));

        khMikeikapHenkinListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khMikeikapHenkinListDataSourceBean1);

        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean2 = new KhMikeikapHenkinListDataSourceBean();


        khMikeikapHenkinListDataSourceBean2.setIrBkncd("PC12");
        khMikeikapHenkinListDataSourceBean2.setIrHknsyruilevel("米ドル建個人年金保険（一時払）（準有配）");
        khMikeikapHenkinListDataSourceBean2.setIrMikeikapkktiymd("2018年 3月 3日");
        khMikeikapHenkinListDataSourceBean2.setIrSyono("10000000001");

        khMikeikapHenkinListDataSourceBean2.setIrMikeikap(BizCurrency.valueOf(200));
        khMikeikapHenkinListDataSourceBean2.setIrMikeikapkktinnd("2017年度");

        khMikeikapHenkinListDataSourceBean2.setIrMikeikapkktiym("2018年 1月");

        khMikeikapHenkinListDataSourceBean2.setIrHenkinkensuugoukei(BizNumber.valueOf(1));

        khMikeikapHenkinListDataSourceBean2.setIrHenkingakugoukei(BizCurrency.valueOf(200));

        khMikeikapHenkinListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khMikeikapHenkinListDataSourceBean2);

        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean3 = new KhMikeikapHenkinListDataSourceBean();


        khMikeikapHenkinListDataSourceBean3.setIrBkncd("PC12");
        khMikeikapHenkinListDataSourceBean3.setIrHknsyruilevel("米ドル建個人年金保険（一時払）（準有配）");
        khMikeikapHenkinListDataSourceBean3.setIrMikeikapkktiymd("");
        khMikeikapHenkinListDataSourceBean3.setIrSyono("");

        khMikeikapHenkinListDataSourceBean3.setIrMikeikap(null);
        khMikeikapHenkinListDataSourceBean3.setIrMikeikapkktinnd("2017年度");

        khMikeikapHenkinListDataSourceBean3.setIrMikeikapkktiym("");

        khMikeikapHenkinListDataSourceBean3.setIrHenkinkensuugoukei(BizNumber.valueOf(2));

        khMikeikapHenkinListDataSourceBean3.setIrHenkingakugoukei(BizCurrency.valueOf(300));

        khMikeikapHenkinListDataSourceBean3.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khMikeikapHenkinListDataSourceBean3);

        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean4 = new KhMikeikapHenkinListDataSourceBean();


        khMikeikapHenkinListDataSourceBean4.setIrBkncd("PC12");
        khMikeikapHenkinListDataSourceBean4.setIrHknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        khMikeikapHenkinListDataSourceBean4.setIrMikeikapkktiymd("2018年 3月 3日");
        khMikeikapHenkinListDataSourceBean4.setIrSyono("10000000001");

        khMikeikapHenkinListDataSourceBean4.setIrMikeikap(BizCurrency.valueOf(300));
        khMikeikapHenkinListDataSourceBean4.setIrMikeikapkktinnd("2017年度");

        khMikeikapHenkinListDataSourceBean4.setIrMikeikapkktiym("2017年 4月");

        khMikeikapHenkinListDataSourceBean4.setIrHenkinkensuugoukei(BizNumber.valueOf(1));

        khMikeikapHenkinListDataSourceBean4.setIrHenkingakugoukei(BizCurrency.valueOf(300));

        khMikeikapHenkinListDataSourceBean4.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khMikeikapHenkinListDataSourceBean4);

        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean5 = new KhMikeikapHenkinListDataSourceBean();


        khMikeikapHenkinListDataSourceBean5.setIrBkncd("PC12");
        khMikeikapHenkinListDataSourceBean5.setIrHknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        khMikeikapHenkinListDataSourceBean5.setIrMikeikapkktiymd("");
        khMikeikapHenkinListDataSourceBean5.setIrSyono("");

        khMikeikapHenkinListDataSourceBean5.setIrMikeikap(null);
        khMikeikapHenkinListDataSourceBean5.setIrMikeikapkktinnd("2017年度");

        khMikeikapHenkinListDataSourceBean5.setIrMikeikapkktiym("");

        khMikeikapHenkinListDataSourceBean5.setIrHenkinkensuugoukei(BizNumber.valueOf(1));

        khMikeikapHenkinListDataSourceBean5.setIrHenkingakugoukei(BizCurrency.valueOf(300));

        khMikeikapHenkinListDataSourceBean5.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khMikeikapHenkinListDataSourceBean5);

        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean6 = new KhMikeikapHenkinListDataSourceBean();


        khMikeikapHenkinListDataSourceBean6.setIrBkncd("PC12");
        khMikeikapHenkinListDataSourceBean6.setIrHknsyruilevel("");
        khMikeikapHenkinListDataSourceBean6.setIrMikeikapkktiymd("");
        khMikeikapHenkinListDataSourceBean6.setIrSyono("");

        khMikeikapHenkinListDataSourceBean6.setIrMikeikap(null);
        khMikeikapHenkinListDataSourceBean6.setIrMikeikapkktinnd("2017年度");

        khMikeikapHenkinListDataSourceBean6.setIrMikeikapkktiym("");

        khMikeikapHenkinListDataSourceBean6.setIrHenkinkensuugoukei(BizNumber.valueOf(3));

        khMikeikapHenkinListDataSourceBean6.setIrHenkingakugoukei(BizCurrency.valueOf(600));

        khMikeikapHenkinListDataSourceBean6.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khMikeikapHenkinListDataSourceBean6);

        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean7 = new KhMikeikapHenkinListDataSourceBean();


        khMikeikapHenkinListDataSourceBean7.setIrBkncd("PC12");
        khMikeikapHenkinListDataSourceBean7.setIrHknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        khMikeikapHenkinListDataSourceBean7.setIrMikeikapkktiymd("2018年 3月 3日");
        khMikeikapHenkinListDataSourceBean7.setIrSyono("10000000001");

        khMikeikapHenkinListDataSourceBean7.setIrMikeikap(BizCurrency.valueOf(400));
        khMikeikapHenkinListDataSourceBean7.setIrMikeikapkktinnd("2018年度");

        khMikeikapHenkinListDataSourceBean7.setIrMikeikapkktiym("2018年 4月");

        khMikeikapHenkinListDataSourceBean7.setIrHenkinkensuugoukei(BizNumber.valueOf(1));

        khMikeikapHenkinListDataSourceBean7.setIrHenkingakugoukei(BizCurrency.valueOf(400));

        khMikeikapHenkinListDataSourceBean7.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khMikeikapHenkinListDataSourceBean7);

        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean8 = new KhMikeikapHenkinListDataSourceBean();


        khMikeikapHenkinListDataSourceBean8.setIrBkncd("PC12");
        khMikeikapHenkinListDataSourceBean8.setIrHknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        khMikeikapHenkinListDataSourceBean8.setIrMikeikapkktiymd("");
        khMikeikapHenkinListDataSourceBean8.setIrSyono("");

        khMikeikapHenkinListDataSourceBean8.setIrMikeikap(null);
        khMikeikapHenkinListDataSourceBean8.setIrMikeikapkktinnd("2018年度");

        khMikeikapHenkinListDataSourceBean8.setIrMikeikapkktiym("");

        khMikeikapHenkinListDataSourceBean8.setIrHenkinkensuugoukei(BizNumber.valueOf(1));

        khMikeikapHenkinListDataSourceBean8.setIrHenkingakugoukei(BizCurrency.valueOf(400));

        khMikeikapHenkinListDataSourceBean8.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khMikeikapHenkinListDataSourceBean8);

        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean9 = new KhMikeikapHenkinListDataSourceBean();


        khMikeikapHenkinListDataSourceBean9.setIrBkncd("PC12");
        khMikeikapHenkinListDataSourceBean9.setIrHknsyruilevel("");
        khMikeikapHenkinListDataSourceBean9.setIrMikeikapkktiymd("");
        khMikeikapHenkinListDataSourceBean9.setIrSyono("");

        khMikeikapHenkinListDataSourceBean9.setIrMikeikap(null);
        khMikeikapHenkinListDataSourceBean9.setIrMikeikapkktinnd("2018年度");

        khMikeikapHenkinListDataSourceBean9.setIrMikeikapkktiym("");

        khMikeikapHenkinListDataSourceBean9.setIrHenkinkensuugoukei(BizNumber.valueOf(1));

        khMikeikapHenkinListDataSourceBean9.setIrHenkingakugoukei(BizCurrency.valueOf(400));

        khMikeikapHenkinListDataSourceBean9.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khMikeikapHenkinListDataSourceBean9);

        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDataSourceBean10 = new KhMikeikapHenkinListDataSourceBean();


        khMikeikapHenkinListDataSourceBean10.setIrBkncd("PC12");
        khMikeikapHenkinListDataSourceBean10.setIrHknsyruilevel("");
        khMikeikapHenkinListDataSourceBean10.setIrMikeikapkktiymd("");
        khMikeikapHenkinListDataSourceBean10.setIrSyono("");

        khMikeikapHenkinListDataSourceBean10.setIrMikeikap(null);
        khMikeikapHenkinListDataSourceBean10.setIrMikeikapkktinnd("");

        khMikeikapHenkinListDataSourceBean10.setIrMikeikapkktiym("");

        khMikeikapHenkinListDataSourceBean10.setIrHenkinkensuugoukei(BizNumber.valueOf(4));

        khMikeikapHenkinListDataSourceBean10.setIrHenkingakugoukei(BizCurrency.valueOf(1000));

        khMikeikapHenkinListDataSourceBean10.setIrGoukeiumukbn(C_UmuKbn.ARI);

        dataSouceList.add(khMikeikapHenkinListDataSourceBean10);

        reportTestBean.addParamObjects(dataSouceList, khMikeikapHenkinListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhMikeikapTest",
                C_SyoruiCdKbn.KK_MKKPHENKINLIST_GENGAKU);

        khMikeikapHenkinListBean.setIrTantsitunmkj("保全支払サービス室");
        khMikeikapHenkinListBean.setIrKessannnd("2018年度");

        khMikeikapHenkinListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        khMikeikapHenkinListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");

        khMikeikapHenkinListBean.setIrHozonkkn("3年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, khMikeikapHenkinListBean);

        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

}
