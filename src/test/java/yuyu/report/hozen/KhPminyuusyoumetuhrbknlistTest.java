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
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.bean.report.KhPmnySymtjHnrknBknListBean;
import yuyu.def.hozen.bean.report.KhPmnySymtjHnrknBknListDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * Ｐ未入消滅時返戻金備金リスト 帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhPminyuusyoumetuhrbknlistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhPmnySymtjHnrknBknListBean khPmnySymtjHnrknBknListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPminyuusyoumetuhrbknlistTest",
                C_SyoruiCdKbn.AS_PMINYUUSYOUMETUHRBKNLIST);
        khPmnySymtjHnrknBknListBean.setIrTantsitunmkj("");
        khPmnySymtjHnrknBknListBean.setIrKessannnd("");
        khPmnySymtjHnrknBknListBean.setIrBknkessankbn(C_Bknkessankbn.BLNK);
        khPmnySymtjHnrknBknListBean.setIrTyouhyousakuseiymd("");
        khPmnySymtjHnrknBknListBean.setIrHozonkkn("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean = new KhPmnySymtjHnrknBknListDataSourceBean();

        khPmnySymtjHnrknBknListDataSourceBean.setIrKbnkeirihknsyuruinm(C_Segcd.BLNK);
        khPmnySymtjHnrknBknListDataSourceBean.setIrBkncd("");
        khPmnySymtjHnrknBknListDataSourceBean.setIrBknkktiymd("");
        khPmnySymtjHnrknBknListDataSourceBean.setIrSisyacd("");
        khPmnySymtjHnrknBknListDataSourceBean.setIrKigou("");
        khPmnySymtjHnrknBknListDataSourceBean.setIrSyono("");
        khPmnySymtjHnrknBknListDataSourceBean.setIrBkngk(BizCurrency.valueOf(0));
        khPmnySymtjHnrknBknListDataSourceBean.setIrBknkktinnd("");
        khPmnySymtjHnrknBknListDataSourceBean.setIrBikinkensuugoukei(BizNumber.ZERO);
        khPmnySymtjHnrknBknListDataSourceBean.setIrBikingakugoukei(BizCurrency.valueOf(0));
        khPmnySymtjHnrknBknListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khPmnySymtjHnrknBknListDataSourceBean.setIrGoukeitani("");


        dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khPmnySymtjHnrknBknListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPminyuusyoumetuhrbknlistTest",
                C_SyoruiCdKbn.AS_PMINYUUSYOUMETUHRBKNLIST);
        khPmnySymtjHnrknBknListBean.setIrTantsitunmkj(null);
        khPmnySymtjHnrknBknListBean.setIrKessannnd(null);
        khPmnySymtjHnrknBknListBean.setIrBknkessankbn(null);
        khPmnySymtjHnrknBknListBean.setIrTyouhyousakuseiymd(null);
        khPmnySymtjHnrknBknListBean.setIrHozonkkn(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean = new KhPmnySymtjHnrknBknListDataSourceBean();

        khPmnySymtjHnrknBknListDataSourceBean.setIrKbnkeirihknsyuruinm(null);
        khPmnySymtjHnrknBknListDataSourceBean.setIrBkncd(null);
        khPmnySymtjHnrknBknListDataSourceBean.setIrBknkktiymd(null);
        khPmnySymtjHnrknBknListDataSourceBean.setIrSisyacd(null);
        khPmnySymtjHnrknBknListDataSourceBean.setIrKigou(null);
        khPmnySymtjHnrknBknListDataSourceBean.setIrSyono(null);
        khPmnySymtjHnrknBknListDataSourceBean.setIrBkngk(null);
        khPmnySymtjHnrknBknListDataSourceBean.setIrBknkktinnd(null);
        khPmnySymtjHnrknBknListDataSourceBean.setIrBikinkensuugoukei(null);
        khPmnySymtjHnrknBknListDataSourceBean.setIrBikingakugoukei(null);
        khPmnySymtjHnrknBknListDataSourceBean.setIrGoukeiumukbn(null);
        khPmnySymtjHnrknBknListDataSourceBean.setIrGoukeitani(null);


        dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khPmnySymtjHnrknBknListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPminyuusyoumetuhrbknlistTest",
                C_SyoruiCdKbn.AS_PMINYUUSYOUMETUHRBKNLIST);
        khPmnySymtjHnrknBknListBean.setIrTantsitunmkj("保全支払サービス室");
        khPmnySymtjHnrknBknListBean.setIrKessannnd("2018年度");
        khPmnySymtjHnrknBknListBean.setIrBknkessankbn(C_Bknkessankbn.KESSAN);
        khPmnySymtjHnrknBknListBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
        khPmnySymtjHnrknBknListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean = new KhPmnySymtjHnrknBknListDataSourceBean();

        khPmnySymtjHnrknBknListDataSourceBean.setIrKbnkeirihknsyuruinm(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        khPmnySymtjHnrknBknListDataSourceBean.setIrBkncd("PC12");
        khPmnySymtjHnrknBknListDataSourceBean.setIrBknkktiymd("2019年 3月 3日");
        khPmnySymtjHnrknBknListDataSourceBean.setIrSisyacd("727");
        khPmnySymtjHnrknBknListDataSourceBean.setIrKigou("ﾅH");
        khPmnySymtjHnrknBknListDataSourceBean.setIrSyono("10000000001");
        khPmnySymtjHnrknBknListDataSourceBean.setIrBkngk(BizCurrency.valueOf(101));
        khPmnySymtjHnrknBknListDataSourceBean.setIrBknkktinnd("2019年度");
        khPmnySymtjHnrknBknListDataSourceBean.setIrBikinkensuugoukei(BizNumber.valueOf(102));
        khPmnySymtjHnrknBknListDataSourceBean.setIrBikingakugoukei(BizCurrency.valueOf(103));
        khPmnySymtjHnrknBknListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khPmnySymtjHnrknBknListDataSourceBean.setIrGoukeitani("2020年度");

        dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khPmnySymtjHnrknBknListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPminyuusyoumetuhrbknlistTest",
                C_SyoruiCdKbn.AS_PMINYUUSYOUMETUHRBKNLIST);
        khPmnySymtjHnrknBknListBean.setIrTantsitunmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khPmnySymtjHnrknBknListBean.setIrKessannnd("9999年度");
        khPmnySymtjHnrknBknListBean.setIrBknkessankbn(C_Bknkessankbn.SHNK);
        khPmnySymtjHnrknBknListBean.setIrTyouhyousakuseiymd("9999年99月99日");
        khPmnySymtjHnrknBknListBean.setIrHozonkkn("99ＷＷ");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean = new KhPmnySymtjHnrknBknListDataSourceBean();

        khPmnySymtjHnrknBknListDataSourceBean.setIrKbnkeirihknsyuruinm(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
        khPmnySymtjHnrknBknListDataSourceBean.setIrBkncd("wwww");
        khPmnySymtjHnrknBknListDataSourceBean.setIrBknkktiymd("9999年99月99日");
        khPmnySymtjHnrknBknListDataSourceBean.setIrSisyacd("www");
        khPmnySymtjHnrknBknListDataSourceBean.setIrKigou("ww");
        khPmnySymtjHnrknBknListDataSourceBean.setIrSyono("wwwwwwwwwww");
        khPmnySymtjHnrknBknListDataSourceBean.setIrBkngk(BizCurrency.valueOf(99999999999L));
        khPmnySymtjHnrknBknListDataSourceBean.setIrBknkktinnd("9999年度");
        khPmnySymtjHnrknBknListDataSourceBean.setIrBikinkensuugoukei(BizNumber.valueOf(999999));
        khPmnySymtjHnrknBknListDataSourceBean.setIrBikingakugoukei(BizCurrency.valueOf(9999999999999L));
        khPmnySymtjHnrknBknListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khPmnySymtjHnrknBknListDataSourceBean.setIrGoukeitani("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");


        dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khPmnySymtjHnrknBknListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPminyuusyoumetuhrbknlistTest",
                C_SyoruiCdKbn.AS_PMINYUUSYOUMETUHRBKNLIST);
        khPmnySymtjHnrknBknListBean.setIrTantsitunmkj("保全支払サービス室");
        khPmnySymtjHnrknBknListBean.setIrKessannnd("2018年度");
        khPmnySymtjHnrknBknListBean.setIrBknkessankbn(C_Bknkessankbn.SHNK);
        khPmnySymtjHnrknBknListBean.setIrTyouhyousakuseiymd("2018年12月30日");
        khPmnySymtjHnrknBknListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean = new KhPmnySymtjHnrknBknListDataSourceBean();

        khPmnySymtjHnrknBknListDataSourceBean.setIrKbnkeirihknsyuruinm(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        khPmnySymtjHnrknBknListDataSourceBean.setIrBkncd("PC12");
        khPmnySymtjHnrknBknListDataSourceBean.setIrBknkktiymd("2018年11月20日");
        khPmnySymtjHnrknBknListDataSourceBean.setIrSisyacd("727");
        khPmnySymtjHnrknBknListDataSourceBean.setIrKigou("ﾅH");
        khPmnySymtjHnrknBknListDataSourceBean.setIrSyono("10000000001");
        khPmnySymtjHnrknBknListDataSourceBean.setIrBkngk(BizCurrency.valueOf(1001));
        khPmnySymtjHnrknBknListDataSourceBean.setIrBknkktinnd("2018年度");
        khPmnySymtjHnrknBknListDataSourceBean.setIrBikinkensuugoukei(BizNumber.valueOf(1002));
        khPmnySymtjHnrknBknListDataSourceBean.setIrBikingakugoukei(BizCurrency.valueOf(1003));
        khPmnySymtjHnrknBknListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khPmnySymtjHnrknBknListDataSourceBean.setIrGoukeitani("2018年度");


        dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khPmnySymtjHnrknBknListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPminyuusyoumetuhrbknlistTest",
                C_SyoruiCdKbn.AS_PMINYUUSYOUMETUHRBKNLIST);
        khPmnySymtjHnrknBknListBean.setIrTantsitunmkj("保全支払サービス室");
        khPmnySymtjHnrknBknListBean.setIrKessannnd("2018年度");
        khPmnySymtjHnrknBknListBean.setIrBknkessankbn(C_Bknkessankbn.SHNK);
        khPmnySymtjHnrknBknListBean.setIrTyouhyousakuseiymd("2018年12月30日");
        khPmnySymtjHnrknBknListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean = new KhPmnySymtjHnrknBknListDataSourceBean();

        dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khPmnySymtjHnrknBknListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPminyuusyoumetuhrbknlistTest",
                C_SyoruiCdKbn.AS_PMINYUUSYOUMETUHRBKNLIST);
        khPmnySymtjHnrknBknListBean.setIrTantsitunmkj("保全支払サービス室");
        khPmnySymtjHnrknBknListBean.setIrKessannnd("2018年度");
        khPmnySymtjHnrknBknListBean.setIrBknkessankbn(C_Bknkessankbn.KESSAN);
        khPmnySymtjHnrknBknListBean.setIrTyouhyousakuseiymd("2018年12月30日");
        khPmnySymtjHnrknBknListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean;

        for (int i = 0; i < 28; i++) {

            khPmnySymtjHnrknBknListDataSourceBean = new KhPmnySymtjHnrknBknListDataSourceBean();
            khPmnySymtjHnrknBknListDataSourceBean.setIrKbnkeirihknsyuruinm(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
            khPmnySymtjHnrknBknListDataSourceBean.setIrBkncd("PC12");
            khPmnySymtjHnrknBknListDataSourceBean.setIrBknkktiymd("2018年11月20日");
            khPmnySymtjHnrknBknListDataSourceBean.setIrSisyacd("727");
            khPmnySymtjHnrknBknListDataSourceBean.setIrKigou("ﾅH");
            khPmnySymtjHnrknBknListDataSourceBean.setIrSyono("10000000001");
            khPmnySymtjHnrknBknListDataSourceBean.setIrBkngk(BizCurrency.valueOf(10));
            khPmnySymtjHnrknBknListDataSourceBean.setIrBknkktinnd("2018年度");

            dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean);
        }

        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean1 = new KhPmnySymtjHnrknBknListDataSourceBean();

        khPmnySymtjHnrknBknListDataSourceBean1.setIrKbnkeirihknsyuruinm(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
        khPmnySymtjHnrknBknListDataSourceBean1.setIrBkncd("PC12");
        khPmnySymtjHnrknBknListDataSourceBean1.setIrBknkktiymd("2018年11月20日");
        khPmnySymtjHnrknBknListDataSourceBean1.setIrSisyacd("727");
        khPmnySymtjHnrknBknListDataSourceBean1.setIrKigou("ﾅH");
        khPmnySymtjHnrknBknListDataSourceBean1.setIrSyono("10000000001");
        khPmnySymtjHnrknBknListDataSourceBean1.setIrBkngk(BizCurrency.valueOf(10));
        khPmnySymtjHnrknBknListDataSourceBean1.setIrBknkktinnd("2018年度");
        khPmnySymtjHnrknBknListDataSourceBean1.setIrBikinkensuugoukei(BizNumber.valueOf(29));
        khPmnySymtjHnrknBknListDataSourceBean1.setIrBikingakugoukei(BizCurrency.valueOf(290));
        khPmnySymtjHnrknBknListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khPmnySymtjHnrknBknListDataSourceBean1.setIrGoukeitani("2018年度");


        dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, khPmnySymtjHnrknBknListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPminyuusyoumetuhrbknlistTest",
                C_SyoruiCdKbn.AS_PMINYUUSYOUMETUHRBKNLIST);
        khPmnySymtjHnrknBknListBean.setIrTantsitunmkj("保全支払サービス室");
        khPmnySymtjHnrknBknListBean.setIrKessannnd("2018年度");
        khPmnySymtjHnrknBknListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        khPmnySymtjHnrknBknListBean.setIrTyouhyousakuseiymd("2018年12月30日");
        khPmnySymtjHnrknBknListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean;

        for (int i = 0; i < 29; i++) {

            khPmnySymtjHnrknBknListDataSourceBean = new KhPmnySymtjHnrknBknListDataSourceBean();
            khPmnySymtjHnrknBknListDataSourceBean.setIrKbnkeirihknsyuruinm(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
            khPmnySymtjHnrknBknListDataSourceBean.setIrBkncd("PC12");
            khPmnySymtjHnrknBknListDataSourceBean.setIrBknkktiymd("2018年11月20日");
            khPmnySymtjHnrknBknListDataSourceBean.setIrSisyacd("727");
            khPmnySymtjHnrknBknListDataSourceBean.setIrKigou("ﾅH");
            khPmnySymtjHnrknBknListDataSourceBean.setIrSyono("10000000001");
            khPmnySymtjHnrknBknListDataSourceBean.setIrBkngk(BizCurrency.valueOf(10));
            khPmnySymtjHnrknBknListDataSourceBean.setIrBknkktinnd("2018年度");

            dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean);
        }

        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean1 = new KhPmnySymtjHnrknBknListDataSourceBean();

        khPmnySymtjHnrknBknListDataSourceBean1.setIrKbnkeirihknsyuruinm(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
        khPmnySymtjHnrknBknListDataSourceBean1.setIrBkncd("PC12");
        khPmnySymtjHnrknBknListDataSourceBean1.setIrBknkktiymd("2018年11月20日");
        khPmnySymtjHnrknBknListDataSourceBean1.setIrSisyacd("727");
        khPmnySymtjHnrknBknListDataSourceBean1.setIrKigou("ﾅH");
        khPmnySymtjHnrknBknListDataSourceBean1.setIrSyono("10000000001");
        khPmnySymtjHnrknBknListDataSourceBean1.setIrBkngk(BizCurrency.valueOf(10));
        khPmnySymtjHnrknBknListDataSourceBean1.setIrBknkktinnd("2018年度");
        khPmnySymtjHnrknBknListDataSourceBean1.setIrBikinkensuugoukei(BizNumber.valueOf(30));
        khPmnySymtjHnrknBknListDataSourceBean1.setIrBikingakugoukei(BizCurrency.valueOf(300));
        khPmnySymtjHnrknBknListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khPmnySymtjHnrknBknListDataSourceBean1.setIrGoukeitani("2018年度");

        dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, khPmnySymtjHnrknBknListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPminyuusyoumetuhrbknlistTest",
                C_SyoruiCdKbn.AS_PMINYUUSYOUMETUHRBKNLIST);
        khPmnySymtjHnrknBknListBean.setIrTantsitunmkj("保全支払サービス室");
        khPmnySymtjHnrknBknListBean.setIrKessannnd("2018年度");
        khPmnySymtjHnrknBknListBean.setIrBknkessankbn(C_Bknkessankbn.SHNK);
        khPmnySymtjHnrknBknListBean.setIrTyouhyousakuseiymd("2018年12月30日");
        khPmnySymtjHnrknBknListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean;

        for (int i = 0; i < 30; i++) {

            khPmnySymtjHnrknBknListDataSourceBean = new KhPmnySymtjHnrknBknListDataSourceBean();
            khPmnySymtjHnrknBknListDataSourceBean.setIrKbnkeirihknsyuruinm(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
            khPmnySymtjHnrknBknListDataSourceBean.setIrBkncd("PC12");
            khPmnySymtjHnrknBknListDataSourceBean.setIrBknkktiymd("2018年11月20日");
            khPmnySymtjHnrknBknListDataSourceBean.setIrSisyacd("727");
            khPmnySymtjHnrknBknListDataSourceBean.setIrKigou("ﾅH");
            khPmnySymtjHnrknBknListDataSourceBean.setIrSyono("10000000001");
            khPmnySymtjHnrknBknListDataSourceBean.setIrBkngk(BizCurrency.valueOf(10));
            khPmnySymtjHnrknBknListDataSourceBean.setIrBknkktinnd("2018年度");

            dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean);
        }

        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean1 = new KhPmnySymtjHnrknBknListDataSourceBean();

        khPmnySymtjHnrknBknListDataSourceBean1.setIrKbnkeirihknsyuruinm(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
        khPmnySymtjHnrknBknListDataSourceBean1.setIrBkncd("PC12");
        khPmnySymtjHnrknBknListDataSourceBean1.setIrBknkktiymd("2018年11月20日");
        khPmnySymtjHnrknBknListDataSourceBean1.setIrSisyacd("727");
        khPmnySymtjHnrknBknListDataSourceBean1.setIrKigou("ﾅH");
        khPmnySymtjHnrknBknListDataSourceBean1.setIrSyono("10000000001");
        khPmnySymtjHnrknBknListDataSourceBean1.setIrBkngk(BizCurrency.valueOf(10));
        khPmnySymtjHnrknBknListDataSourceBean1.setIrBknkktinnd("2018年度");
        khPmnySymtjHnrknBknListDataSourceBean1.setIrBikinkensuugoukei(BizNumber.valueOf(31));
        khPmnySymtjHnrknBknListDataSourceBean1.setIrBikingakugoukei(BizCurrency.valueOf(310));
        khPmnySymtjHnrknBknListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khPmnySymtjHnrknBknListDataSourceBean1.setIrGoukeitani("2018年度");

        dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, khPmnySymtjHnrknBknListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPminyuusyoumetuhrbknlistTest",
                C_SyoruiCdKbn.AS_PMINYUUSYOUMETUHRBKNLIST);
        khPmnySymtjHnrknBknListBean.setIrTantsitunmkj("保全支払サービス室");
        khPmnySymtjHnrknBknListBean.setIrKessannnd("2018年度");
        khPmnySymtjHnrknBknListBean.setIrBknkessankbn(C_Bknkessankbn.SHNK);
        khPmnySymtjHnrknBknListBean.setIrTyouhyousakuseiymd("2018年12月30日");
        khPmnySymtjHnrknBknListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean;

        for (int i = 0; i < 29999; i++) {

            khPmnySymtjHnrknBknListDataSourceBean = new KhPmnySymtjHnrknBknListDataSourceBean();
            khPmnySymtjHnrknBknListDataSourceBean.setIrKbnkeirihknsyuruinm(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
            khPmnySymtjHnrknBknListDataSourceBean.setIrBkncd("PC12");
            khPmnySymtjHnrknBknListDataSourceBean.setIrBknkktiymd("2018年11月20日");
            khPmnySymtjHnrknBknListDataSourceBean.setIrSisyacd("727");
            khPmnySymtjHnrknBknListDataSourceBean.setIrKigou("ﾅH");
            khPmnySymtjHnrknBknListDataSourceBean.setIrSyono("10000000001");
            khPmnySymtjHnrknBknListDataSourceBean.setIrBkngk(BizCurrency.valueOf(10));
            khPmnySymtjHnrknBknListDataSourceBean.setIrBknkktinnd("2018年度");

            dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean);
        }

        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean3 = new KhPmnySymtjHnrknBknListDataSourceBean();

        khPmnySymtjHnrknBknListDataSourceBean3.setIrKbnkeirihknsyuruinm(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
        khPmnySymtjHnrknBknListDataSourceBean3.setIrBkncd("PC12");
        khPmnySymtjHnrknBknListDataSourceBean3.setIrBknkktiymd("2018年11月20日");
        khPmnySymtjHnrknBknListDataSourceBean3.setIrSisyacd("727");
        khPmnySymtjHnrknBknListDataSourceBean3.setIrKigou("ﾅH");
        khPmnySymtjHnrknBknListDataSourceBean3.setIrSyono("10000009999");
        khPmnySymtjHnrknBknListDataSourceBean3.setIrBkngk(BizCurrency.valueOf(10));
        khPmnySymtjHnrknBknListDataSourceBean3.setIrBknkktinnd("2018年度");
        khPmnySymtjHnrknBknListDataSourceBean3.setIrBikinkensuugoukei(BizNumber.valueOf(30000));
        khPmnySymtjHnrknBknListDataSourceBean3.setIrBikingakugoukei(BizCurrency.valueOf(300000));
        khPmnySymtjHnrknBknListDataSourceBean3.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khPmnySymtjHnrknBknListDataSourceBean3.setIrGoukeitani("2018年度");

        dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, khPmnySymtjHnrknBknListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhPminyuusyoumetuhrbknlistTest",
                C_SyoruiCdKbn.AS_PMINYUUSYOUMETUHRBKNLIST);
        khPmnySymtjHnrknBknListBean.setIrTantsitunmkj("保全支払サービス室");
        khPmnySymtjHnrknBknListBean.setIrKessannnd("2018年度");
        khPmnySymtjHnrknBknListBean.setIrBknkessankbn(C_Bknkessankbn.SHNK);
        khPmnySymtjHnrknBknListBean.setIrTyouhyousakuseiymd("2018年12月30日");
        khPmnySymtjHnrknBknListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean;

        for (int i = 0; i < 16; i++) {

            khPmnySymtjHnrknBknListDataSourceBean = new KhPmnySymtjHnrknBknListDataSourceBean();
            khPmnySymtjHnrknBknListDataSourceBean.setIrKbnkeirihknsyuruinm(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
            khPmnySymtjHnrknBknListDataSourceBean.setIrBkncd("PC12");
            khPmnySymtjHnrknBknListDataSourceBean.setIrBknkktiymd("2018年11月20日");
            khPmnySymtjHnrknBknListDataSourceBean.setIrSisyacd("727");
            khPmnySymtjHnrknBknListDataSourceBean.setIrKigou("ﾅH");
            khPmnySymtjHnrknBknListDataSourceBean.setIrSyono("10000000001");
            khPmnySymtjHnrknBknListDataSourceBean.setIrBkngk(BizCurrency.valueOf(10000));
            khPmnySymtjHnrknBknListDataSourceBean.setIrBknkktinnd("2018年度");
            khPmnySymtjHnrknBknListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean);
        }

        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean2 = new KhPmnySymtjHnrknBknListDataSourceBean();

        khPmnySymtjHnrknBknListDataSourceBean2.setIrKbnkeirihknsyuruinm(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
        khPmnySymtjHnrknBknListDataSourceBean2.setIrBkncd("PC12");
        khPmnySymtjHnrknBknListDataSourceBean2.setIrBknkktiymd("2018年11月20日");
        khPmnySymtjHnrknBknListDataSourceBean2.setIrSisyacd("727");
        khPmnySymtjHnrknBknListDataSourceBean2.setIrKigou("ﾅH");
        khPmnySymtjHnrknBknListDataSourceBean2.setIrSyono("10000000001");
        khPmnySymtjHnrknBknListDataSourceBean2.setIrBkngk(BizCurrency.valueOf(10000));
        khPmnySymtjHnrknBknListDataSourceBean2.setIrBknkktinnd("2018年度");
        khPmnySymtjHnrknBknListDataSourceBean2.setIrBikinkensuugoukei(BizNumber.valueOf(17));
        khPmnySymtjHnrknBknListDataSourceBean2.setIrBikingakugoukei(BizCurrency.valueOf(170000));
        khPmnySymtjHnrknBknListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khPmnySymtjHnrknBknListDataSourceBean2.setIrGoukeitani("2018年度");

        dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean2);

        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean3 = new KhPmnySymtjHnrknBknListDataSourceBean();

        khPmnySymtjHnrknBknListDataSourceBean3.setIrKbnkeirihknsyuruinm(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
        khPmnySymtjHnrknBknListDataSourceBean3.setIrBkncd("PC12");
        khPmnySymtjHnrknBknListDataSourceBean3.setIrBknkktiymd("2018年11月20日");
        khPmnySymtjHnrknBknListDataSourceBean3.setIrSisyacd("727");
        khPmnySymtjHnrknBknListDataSourceBean3.setIrKigou("ﾅH");
        khPmnySymtjHnrknBknListDataSourceBean3.setIrSyono("10000000001");
        khPmnySymtjHnrknBknListDataSourceBean3.setIrBkngk(BizCurrency.valueOf(10000));
        khPmnySymtjHnrknBknListDataSourceBean3.setIrBknkktinnd("2019年度");
        khPmnySymtjHnrknBknListDataSourceBean3.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean3);

        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean4 = new KhPmnySymtjHnrknBknListDataSourceBean();

        khPmnySymtjHnrknBknListDataSourceBean4.setIrKbnkeirihknsyuruinm(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
        khPmnySymtjHnrknBknListDataSourceBean4.setIrBkncd("PC12");
        khPmnySymtjHnrknBknListDataSourceBean4.setIrBknkktiymd("2018年11月20日");
        khPmnySymtjHnrknBknListDataSourceBean4.setIrSisyacd("727");
        khPmnySymtjHnrknBknListDataSourceBean4.setIrKigou("ﾅH");
        khPmnySymtjHnrknBknListDataSourceBean4.setIrSyono("10000000001");
        khPmnySymtjHnrknBknListDataSourceBean4.setIrBkngk(BizCurrency.valueOf(10000));
        khPmnySymtjHnrknBknListDataSourceBean4.setIrBknkktinnd("2019年度");
        khPmnySymtjHnrknBknListDataSourceBean4.setIrBikinkensuugoukei(BizNumber.valueOf(2));
        khPmnySymtjHnrknBknListDataSourceBean4.setIrBikingakugoukei(BizCurrency.valueOf(20000));
        khPmnySymtjHnrknBknListDataSourceBean4.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khPmnySymtjHnrknBknListDataSourceBean4.setIrGoukeitani("2019年度");

        dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean4);


        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean5 = new KhPmnySymtjHnrknBknListDataSourceBean();

        khPmnySymtjHnrknBknListDataSourceBean5.setIrKbnkeirihknsyuruinm(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
        khPmnySymtjHnrknBknListDataSourceBean5.setIrBkncd("PC12");
        khPmnySymtjHnrknBknListDataSourceBean5.setIrBikinkensuugoukei(BizNumber.valueOf(19));
        khPmnySymtjHnrknBknListDataSourceBean5.setIrBikingakugoukei(BizCurrency.valueOf(190000));
        khPmnySymtjHnrknBknListDataSourceBean5.setIrGoukeiumukbn(C_UmuKbn.ARI);
        khPmnySymtjHnrknBknListDataSourceBean5.setIrGoukeitani("米ドル建個人年金保険（一時払）（準有配）");

        dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean5);

        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean6;

        for (int i = 0; i < 2; i++) {

            khPmnySymtjHnrknBknListDataSourceBean6 = new KhPmnySymtjHnrknBknListDataSourceBean();
            khPmnySymtjHnrknBknListDataSourceBean6.setIrKbnkeirihknsyuruinm(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            khPmnySymtjHnrknBknListDataSourceBean6.setIrBkncd("PC12");
            khPmnySymtjHnrknBknListDataSourceBean6.setIrBknkktiymd("2018年11月20日");
            khPmnySymtjHnrknBknListDataSourceBean6.setIrSisyacd("727");
            khPmnySymtjHnrknBknListDataSourceBean6.setIrKigou("ﾅH");
            khPmnySymtjHnrknBknListDataSourceBean6.setIrSyono("10000000003");
            khPmnySymtjHnrknBknListDataSourceBean6.setIrBkngk(BizCurrency.valueOf(10000));
            khPmnySymtjHnrknBknListDataSourceBean6.setIrBknkktinnd("2019年度");
            khPmnySymtjHnrknBknListDataSourceBean6.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean6);
        }


        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean7 = new KhPmnySymtjHnrknBknListDataSourceBean();

        khPmnySymtjHnrknBknListDataSourceBean7.setIrKbnkeirihknsyuruinm(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        khPmnySymtjHnrknBknListDataSourceBean7.setIrBkncd("PC12");
        khPmnySymtjHnrknBknListDataSourceBean7.setIrBknkktiymd("2018年11月20日");
        khPmnySymtjHnrknBknListDataSourceBean7.setIrSisyacd("727");
        khPmnySymtjHnrknBknListDataSourceBean7.setIrKigou("ﾅH");
        khPmnySymtjHnrknBknListDataSourceBean7.setIrSyono("10000000001");
        khPmnySymtjHnrknBknListDataSourceBean7.setIrBkngk(BizCurrency.valueOf(10000));
        khPmnySymtjHnrknBknListDataSourceBean7.setIrBknkktinnd("2019年度");
        khPmnySymtjHnrknBknListDataSourceBean7.setIrBikinkensuugoukei(BizNumber.valueOf(3));
        khPmnySymtjHnrknBknListDataSourceBean7.setIrBikingakugoukei(BizCurrency.valueOf(30000));
        khPmnySymtjHnrknBknListDataSourceBean7.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khPmnySymtjHnrknBknListDataSourceBean7.setIrGoukeitani("2019年度");

        dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean7);


        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean8 = new KhPmnySymtjHnrknBknListDataSourceBean();

        khPmnySymtjHnrknBknListDataSourceBean8.setIrKbnkeirihknsyuruinm(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        khPmnySymtjHnrknBknListDataSourceBean8.setIrBkncd("PC12");
        khPmnySymtjHnrknBknListDataSourceBean8.setIrBknkktiymd("2018年11月20日");
        khPmnySymtjHnrknBknListDataSourceBean8.setIrSisyacd("727");
        khPmnySymtjHnrknBknListDataSourceBean8.setIrKigou("ﾅH");
        khPmnySymtjHnrknBknListDataSourceBean8.setIrSyono("10000000001");
        khPmnySymtjHnrknBknListDataSourceBean8.setIrBkngk(BizCurrency.valueOf(10000));
        khPmnySymtjHnrknBknListDataSourceBean8.setIrBknkktinnd("2020年度");
        khPmnySymtjHnrknBknListDataSourceBean8.setIrBikinkensuugoukei(BizNumber.valueOf(1));
        khPmnySymtjHnrknBknListDataSourceBean8.setIrBikingakugoukei(BizCurrency.valueOf(10000));
        khPmnySymtjHnrknBknListDataSourceBean8.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khPmnySymtjHnrknBknListDataSourceBean8.setIrGoukeitani("2020年度");

        dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean8);


        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean9 = new KhPmnySymtjHnrknBknListDataSourceBean();

        khPmnySymtjHnrknBknListDataSourceBean9.setIrKbnkeirihknsyuruinm(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        khPmnySymtjHnrknBknListDataSourceBean9.setIrBkncd("PC12");
        khPmnySymtjHnrknBknListDataSourceBean9.setIrBikinkensuugoukei(BizNumber.valueOf(4));
        khPmnySymtjHnrknBknListDataSourceBean9.setIrBikingakugoukei(BizCurrency.valueOf(40000));
        khPmnySymtjHnrknBknListDataSourceBean9.setIrGoukeiumukbn(C_UmuKbn.ARI);
        khPmnySymtjHnrknBknListDataSourceBean9.setIrGoukeitani("米ドル建終身保険（一時払）（準有配）");

        dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean9);

        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDataSourceBean10 = new KhPmnySymtjHnrknBknListDataSourceBean();

        khPmnySymtjHnrknBknListDataSourceBean10.setIrBkncd("PC12");
        khPmnySymtjHnrknBknListDataSourceBean10.setIrBikinkensuugoukei(BizNumber.valueOf(23));
        khPmnySymtjHnrknBknListDataSourceBean10.setIrBikingakugoukei(BizCurrency.valueOf(230000));
        khPmnySymtjHnrknBknListDataSourceBean10.setIrGoukeiumukbn(C_UmuKbn.ARI);
        khPmnySymtjHnrknBknListDataSourceBean10.setIrGoukeitani("RBK2");

        dataSouceList.add(khPmnySymtjHnrknBknListDataSourceBean10);

        reportTestBean.addParamObjects(dataSouceList, khPmnySymtjHnrknBknListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
