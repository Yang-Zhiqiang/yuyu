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
import yuyu.def.hozen.bean.report.KhYendthnkHrBikinListBean;
import yuyu.def.hozen.bean.report.KhYendthnkHrBikinListDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 円建変更時返戻金備金リスト 帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhYendthnkbikinlistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private  KhYendthnkHrBikinListBean khYendthnkHrBikinListBean ;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhYendthnkbikinlistTest", C_SyoruiCdKbn.KK_YENDTHNK_BIKINLIST);
        khYendthnkHrBikinListBean.setIrTantsitunmkj("");
        khYendthnkHrBikinListBean.setIrKessannnd("");
        khYendthnkHrBikinListBean.setIrBknkessankbn(C_Bknkessankbn.BLNK);
        khYendthnkHrBikinListBean.setIrTyouhyousakuseiymdwareki("");
        khYendthnkHrBikinListBean.setIrHozonkkn("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean  = new KhYendthnkHrBikinListDataSourceBean();

        khYendthnkHrBikinListDataSourceBean.setIrKbnkeirihknsyuruinm(C_Segcd.BLNK);
        khYendthnkHrBikinListDataSourceBean.setIrBkncd("");
        khYendthnkHrBikinListDataSourceBean.setIrBknkktiymdwareki("");
        khYendthnkHrBikinListDataSourceBean.setIrSisyacd("");
        khYendthnkHrBikinListDataSourceBean.setIrKigou("");
        khYendthnkHrBikinListDataSourceBean.setIrSyono("");
        khYendthnkHrBikinListDataSourceBean.setIrBkngk(BizCurrency.valueOf(0));
        khYendthnkHrBikinListDataSourceBean.setIrBknkktinnd("");
        khYendthnkHrBikinListDataSourceBean.setIrBikinkensuugoukei(BizNumber.ZERO);
        khYendthnkHrBikinListDataSourceBean.setIrBikingakugoukei(BizCurrency.valueOf(0));
        khYendthnkHrBikinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khYendthnkHrBikinListDataSourceBean.setIrGoukeitani("");


        dataSouceList.add(khYendthnkHrBikinListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khYendthnkHrBikinListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhYendthnkbikinlistTest", C_SyoruiCdKbn.KK_YENDTHNK_BIKINLIST);
        khYendthnkHrBikinListBean.setIrTantsitunmkj(null);
        khYendthnkHrBikinListBean.setIrKessannnd(null);
        khYendthnkHrBikinListBean.setIrBknkessankbn(null);
        khYendthnkHrBikinListBean.setIrTyouhyousakuseiymdwareki(null);
        khYendthnkHrBikinListBean.setIrHozonkkn(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean  = new KhYendthnkHrBikinListDataSourceBean();

        khYendthnkHrBikinListDataSourceBean.setIrKbnkeirihknsyuruinm(null);
        khYendthnkHrBikinListDataSourceBean.setIrBkncd(null);
        khYendthnkHrBikinListDataSourceBean.setIrBknkktiymdwareki(null);
        khYendthnkHrBikinListDataSourceBean.setIrSisyacd(null);
        khYendthnkHrBikinListDataSourceBean.setIrKigou(null);
        khYendthnkHrBikinListDataSourceBean.setIrSyono(null);
        khYendthnkHrBikinListDataSourceBean.setIrBkngk(BizCurrency.valueOf(0));
        khYendthnkHrBikinListDataSourceBean.setIrBknkktinnd(null);
        khYendthnkHrBikinListDataSourceBean.setIrBikinkensuugoukei(BizNumber.ZERO);
        khYendthnkHrBikinListDataSourceBean.setIrBikingakugoukei(BizCurrency.valueOf(0));
        khYendthnkHrBikinListDataSourceBean.setIrGoukeiumukbn(null);
        khYendthnkHrBikinListDataSourceBean.setIrGoukeitani(null);


        dataSouceList.add(khYendthnkHrBikinListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khYendthnkHrBikinListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhYendthnkbikinlistTest", C_SyoruiCdKbn.KK_YENDTHNK_BIKINLIST);
        khYendthnkHrBikinListBean.setIrTantsitunmkj("保全支払サービス室");
        khYendthnkHrBikinListBean.setIrKessannnd("平成27年度");
        khYendthnkHrBikinListBean.setIrBknkessankbn(C_Bknkessankbn.SHNK);
        khYendthnkHrBikinListBean.setIrTyouhyousakuseiymdwareki("平成 2年 2月 2日");
        khYendthnkHrBikinListBean.setIrHozonkkn("99ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean  = new KhYendthnkHrBikinListDataSourceBean();

        khYendthnkHrBikinListDataSourceBean.setIrKbnkeirihknsyuruinm(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        khYendthnkHrBikinListDataSourceBean.setIrBkncd("PC12");
        khYendthnkHrBikinListDataSourceBean.setIrBknkktiymdwareki("平成 3年 3月 3日");
        khYendthnkHrBikinListDataSourceBean.setIrSisyacd("727");
        khYendthnkHrBikinListDataSourceBean.setIrKigou("ﾅH");
        khYendthnkHrBikinListDataSourceBean.setIrSyono("10000000001");
        khYendthnkHrBikinListDataSourceBean.setIrBkngk(BizCurrency.valueOf(999));
        khYendthnkHrBikinListDataSourceBean.setIrBknkktinnd("平成27年度");
        khYendthnkHrBikinListDataSourceBean.setIrBikinkensuugoukei(BizNumber.valueOf(999));
        khYendthnkHrBikinListDataSourceBean.setIrBikingakugoukei(BizCurrency.valueOf(999));
        khYendthnkHrBikinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khYendthnkHrBikinListDataSourceBean.setIrGoukeitani("平成27年度");


        dataSouceList.add(khYendthnkHrBikinListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khYendthnkHrBikinListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhYendthnkbikinlistTest", C_SyoruiCdKbn.KK_YENDTHNK_BIKINLIST);
        khYendthnkHrBikinListBean.setIrTantsitunmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khYendthnkHrBikinListBean.setIrKessannnd("ＷＷ99ＷＷＷＷＷ");
        khYendthnkHrBikinListBean.setIrBknkessankbn(C_Bknkessankbn.BLNK);
        khYendthnkHrBikinListBean.setIrTyouhyousakuseiymdwareki("ＷＷ99年99月99日");
        khYendthnkHrBikinListBean.setIrHozonkkn("99ＷＷ");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean  = new KhYendthnkHrBikinListDataSourceBean();

        khYendthnkHrBikinListDataSourceBean.setIrKbnkeirihknsyuruinm(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
        khYendthnkHrBikinListDataSourceBean.setIrBkncd("wwww");
        khYendthnkHrBikinListDataSourceBean.setIrBknkktiymdwareki("ＷＷ99年99月99日");
        khYendthnkHrBikinListDataSourceBean.setIrSisyacd("www");
        khYendthnkHrBikinListDataSourceBean.setIrKigou("ww");
        khYendthnkHrBikinListDataSourceBean.setIrSyono("wwwwwwwwwww");
        khYendthnkHrBikinListDataSourceBean.setIrBkngk(BizCurrency.valueOf(99999999999L));
        khYendthnkHrBikinListDataSourceBean.setIrBknkktinnd("ＷＷ99ＷＷ");
        khYendthnkHrBikinListDataSourceBean.setIrBikinkensuugoukei(BizNumber.valueOf(999999));
        khYendthnkHrBikinListDataSourceBean.setIrBikingakugoukei(BizCurrency.valueOf(9999999999999L));
        khYendthnkHrBikinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khYendthnkHrBikinListDataSourceBean.setIrGoukeitani("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");


        dataSouceList.add(khYendthnkHrBikinListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khYendthnkHrBikinListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhYendthnkbikinlistTest", C_SyoruiCdKbn.KK_YENDTHNK_BIKINLIST);
        khYendthnkHrBikinListBean.setIrTantsitunmkj("保全支払サービス室");
        khYendthnkHrBikinListBean.setIrKessannnd("平成27年度");
        khYendthnkHrBikinListBean.setIrBknkessankbn(C_Bknkessankbn.SHNK);
        khYendthnkHrBikinListBean.setIrTyouhyousakuseiymdwareki("平成27年12月30日");
        khYendthnkHrBikinListBean.setIrHozonkkn("99ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean  = new KhYendthnkHrBikinListDataSourceBean();

        khYendthnkHrBikinListDataSourceBean.setIrKbnkeirihknsyuruinm(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        khYendthnkHrBikinListDataSourceBean.setIrBkncd("PC12");
        khYendthnkHrBikinListDataSourceBean.setIrBknkktiymdwareki("平成27年11月20日");
        khYendthnkHrBikinListDataSourceBean.setIrSisyacd("727");
        khYendthnkHrBikinListDataSourceBean.setIrKigou("ﾅH");
        khYendthnkHrBikinListDataSourceBean.setIrSyono("10000000001");
        khYendthnkHrBikinListDataSourceBean.setIrBkngk(BizCurrency.valueOf(9999));
        khYendthnkHrBikinListDataSourceBean.setIrBknkktinnd("平成27年度");
        khYendthnkHrBikinListDataSourceBean.setIrBikinkensuugoukei(BizNumber.valueOf(9999));
        khYendthnkHrBikinListDataSourceBean.setIrBikingakugoukei(BizCurrency.valueOf(9999));
        khYendthnkHrBikinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khYendthnkHrBikinListDataSourceBean.setIrGoukeitani("平成27年度");


        dataSouceList.add(khYendthnkHrBikinListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khYendthnkHrBikinListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhYendthnkbikinlistTest", C_SyoruiCdKbn.KK_YENDTHNK_BIKINLIST);
        khYendthnkHrBikinListBean.setIrTantsitunmkj("保全支払サービス室");
        khYendthnkHrBikinListBean.setIrKessannnd("平成27年度");
        khYendthnkHrBikinListBean.setIrBknkessankbn(C_Bknkessankbn.SHNK);
        khYendthnkHrBikinListBean.setIrTyouhyousakuseiymdwareki("平成27年12月30日");
        khYendthnkHrBikinListBean.setIrHozonkkn("99ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean  = new KhYendthnkHrBikinListDataSourceBean();

        dataSouceList.add(khYendthnkHrBikinListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khYendthnkHrBikinListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhYendthnkbikinlistTest", C_SyoruiCdKbn.KK_YENDTHNK_BIKINLIST);
        khYendthnkHrBikinListBean.setIrTantsitunmkj("保全支払サービス室");
        khYendthnkHrBikinListBean.setIrKessannnd("平成27年度");
        khYendthnkHrBikinListBean.setIrBknkessankbn(C_Bknkessankbn.KESSAN);
        khYendthnkHrBikinListBean.setIrTyouhyousakuseiymdwareki("平成27年12月30日");
        khYendthnkHrBikinListBean.setIrHozonkkn("99ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean;

        for (int i = 0; i < 28; i++) {

            khYendthnkHrBikinListDataSourceBean  = new KhYendthnkHrBikinListDataSourceBean();
            khYendthnkHrBikinListDataSourceBean.setIrKbnkeirihknsyuruinm(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
            khYendthnkHrBikinListDataSourceBean.setIrBkncd("PC12");
            khYendthnkHrBikinListDataSourceBean.setIrBknkktiymdwareki("平成27年11月20日");
            khYendthnkHrBikinListDataSourceBean.setIrSisyacd("727");
            khYendthnkHrBikinListDataSourceBean.setIrKigou("ﾅH");
            khYendthnkHrBikinListDataSourceBean.setIrSyono("10000000001");
            khYendthnkHrBikinListDataSourceBean.setIrBkngk(BizCurrency.valueOf(10));
            khYendthnkHrBikinListDataSourceBean.setIrBknkktinnd("平成27年度");

            dataSouceList.add(khYendthnkHrBikinListDataSourceBean);
        }

        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean1  = new KhYendthnkHrBikinListDataSourceBean();

        khYendthnkHrBikinListDataSourceBean1.setIrKbnkeirihknsyuruinm(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
        khYendthnkHrBikinListDataSourceBean1.setIrBkncd("PC12");
        khYendthnkHrBikinListDataSourceBean1.setIrBknkktiymdwareki("平成27年11月20日");
        khYendthnkHrBikinListDataSourceBean1.setIrSisyacd("727");
        khYendthnkHrBikinListDataSourceBean1.setIrKigou("ﾅH");
        khYendthnkHrBikinListDataSourceBean1.setIrSyono("10000000001");
        khYendthnkHrBikinListDataSourceBean1.setIrBkngk(BizCurrency.valueOf(10));
        khYendthnkHrBikinListDataSourceBean1.setIrBknkktinnd("平成27年度");
        khYendthnkHrBikinListDataSourceBean1.setIrBikinkensuugoukei(BizNumber.valueOf(29));
        khYendthnkHrBikinListDataSourceBean1.setIrBikingakugoukei(BizCurrency.valueOf(290));
        khYendthnkHrBikinListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khYendthnkHrBikinListDataSourceBean1.setIrGoukeitani("平成27年度");


        dataSouceList.add(khYendthnkHrBikinListDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, khYendthnkHrBikinListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhYendthnkbikinlistTest", C_SyoruiCdKbn.KK_YENDTHNK_BIKINLIST);
        khYendthnkHrBikinListBean.setIrTantsitunmkj("保全支払サービス室");
        khYendthnkHrBikinListBean.setIrKessannnd("平成27年度");
        khYendthnkHrBikinListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        khYendthnkHrBikinListBean.setIrTyouhyousakuseiymdwareki("平成27年12月30日");
        khYendthnkHrBikinListBean.setIrHozonkkn("99ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean;

        for (int i = 0; i < 29; i++) {

            khYendthnkHrBikinListDataSourceBean  = new KhYendthnkHrBikinListDataSourceBean();
            khYendthnkHrBikinListDataSourceBean.setIrKbnkeirihknsyuruinm(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
            khYendthnkHrBikinListDataSourceBean.setIrBkncd("PC12");
            khYendthnkHrBikinListDataSourceBean.setIrBknkktiymdwareki("平成27年11月20日");
            khYendthnkHrBikinListDataSourceBean.setIrSisyacd("727");
            khYendthnkHrBikinListDataSourceBean.setIrKigou("ﾅH");
            khYendthnkHrBikinListDataSourceBean.setIrSyono("10000000001");
            khYendthnkHrBikinListDataSourceBean.setIrBkngk(BizCurrency.valueOf(10));
            khYendthnkHrBikinListDataSourceBean.setIrBknkktinnd("平成27年度");

            dataSouceList.add(khYendthnkHrBikinListDataSourceBean);
        }

        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean1  = new KhYendthnkHrBikinListDataSourceBean();

        khYendthnkHrBikinListDataSourceBean1.setIrKbnkeirihknsyuruinm(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
        khYendthnkHrBikinListDataSourceBean1.setIrBkncd("PC12");
        khYendthnkHrBikinListDataSourceBean1.setIrBknkktiymdwareki("平成27年11月20日");
        khYendthnkHrBikinListDataSourceBean1.setIrSisyacd("727");
        khYendthnkHrBikinListDataSourceBean1.setIrKigou("ﾅH");
        khYendthnkHrBikinListDataSourceBean1.setIrSyono("10000000001");
        khYendthnkHrBikinListDataSourceBean1.setIrBkngk(BizCurrency.valueOf(10));
        khYendthnkHrBikinListDataSourceBean1.setIrBknkktinnd("平成27年度");
        khYendthnkHrBikinListDataSourceBean1.setIrBikinkensuugoukei(BizNumber.valueOf(30));
        khYendthnkHrBikinListDataSourceBean1.setIrBikingakugoukei(BizCurrency.valueOf(300));
        khYendthnkHrBikinListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khYendthnkHrBikinListDataSourceBean1.setIrGoukeitani("平成27年度");

        dataSouceList.add(khYendthnkHrBikinListDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, khYendthnkHrBikinListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhYendthnkbikinlistTest", C_SyoruiCdKbn.KK_YENDTHNK_BIKINLIST);
        khYendthnkHrBikinListBean.setIrTantsitunmkj("保全支払サービス室");
        khYendthnkHrBikinListBean.setIrKessannnd("平成27年度");
        khYendthnkHrBikinListBean.setIrBknkessankbn(C_Bknkessankbn.SHNK);
        khYendthnkHrBikinListBean.setIrTyouhyousakuseiymdwareki("平成27年12月30日");
        khYendthnkHrBikinListBean.setIrHozonkkn("99ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean;

        for (int i = 0; i < 30; i++) {

            khYendthnkHrBikinListDataSourceBean  = new KhYendthnkHrBikinListDataSourceBean();
            khYendthnkHrBikinListDataSourceBean.setIrKbnkeirihknsyuruinm(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
            khYendthnkHrBikinListDataSourceBean.setIrBkncd("PC12");
            khYendthnkHrBikinListDataSourceBean.setIrBknkktiymdwareki("平成27年11月20日");
            khYendthnkHrBikinListDataSourceBean.setIrSisyacd("727");
            khYendthnkHrBikinListDataSourceBean.setIrKigou("ﾅH");
            khYendthnkHrBikinListDataSourceBean.setIrSyono("10000000001");
            khYendthnkHrBikinListDataSourceBean.setIrBkngk(BizCurrency.valueOf(10));
            khYendthnkHrBikinListDataSourceBean.setIrBknkktinnd("平成27年度");

            dataSouceList.add(khYendthnkHrBikinListDataSourceBean);
        }

        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean1  = new KhYendthnkHrBikinListDataSourceBean();

        khYendthnkHrBikinListDataSourceBean1.setIrKbnkeirihknsyuruinm(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
        khYendthnkHrBikinListDataSourceBean1.setIrBkncd("PC12");
        khYendthnkHrBikinListDataSourceBean1.setIrBknkktiymdwareki("平成27年11月20日");
        khYendthnkHrBikinListDataSourceBean1.setIrSisyacd("727");
        khYendthnkHrBikinListDataSourceBean1.setIrKigou("ﾅH");
        khYendthnkHrBikinListDataSourceBean1.setIrSyono("10000000001");
        khYendthnkHrBikinListDataSourceBean1.setIrBkngk(BizCurrency.valueOf(10));
        khYendthnkHrBikinListDataSourceBean1.setIrBknkktinnd("平成27年度");
        khYendthnkHrBikinListDataSourceBean1.setIrBikinkensuugoukei(BizNumber.valueOf(31));
        khYendthnkHrBikinListDataSourceBean1.setIrBikingakugoukei(BizCurrency.valueOf(310));
        khYendthnkHrBikinListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khYendthnkHrBikinListDataSourceBean1.setIrGoukeitani("平成27年度");

        dataSouceList.add(khYendthnkHrBikinListDataSourceBean1);

        reportTestBean.addParamObjects(dataSouceList, khYendthnkHrBikinListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhYendthnkbikinlistTest", C_SyoruiCdKbn.KK_YENDTHNK_BIKINLIST);
        khYendthnkHrBikinListBean.setIrTantsitunmkj("保全支払サービス室");
        khYendthnkHrBikinListBean.setIrKessannnd("平成27年度");
        khYendthnkHrBikinListBean.setIrBknkessankbn(C_Bknkessankbn.SHNK);
        khYendthnkHrBikinListBean.setIrTyouhyousakuseiymdwareki("平成27年12月30日");
        khYendthnkHrBikinListBean.setIrHozonkkn("99ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean;

        for (int i = 0; i < 299969; i++) {

            khYendthnkHrBikinListDataSourceBean  = new KhYendthnkHrBikinListDataSourceBean();
            khYendthnkHrBikinListDataSourceBean.setIrKbnkeirihknsyuruinm(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
            khYendthnkHrBikinListDataSourceBean.setIrBkncd("PC12");
            khYendthnkHrBikinListDataSourceBean.setIrBknkktiymdwareki("平成27年11月20日");
            khYendthnkHrBikinListDataSourceBean.setIrSisyacd("727");
            khYendthnkHrBikinListDataSourceBean.setIrKigou("ﾅH");
            khYendthnkHrBikinListDataSourceBean.setIrSyono("10000000001");
            khYendthnkHrBikinListDataSourceBean.setIrBkngk(BizCurrency.valueOf(10));
            khYendthnkHrBikinListDataSourceBean.setIrBknkktinnd("平成27年度");

            dataSouceList.add(khYendthnkHrBikinListDataSourceBean);
        }

        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean3  = new KhYendthnkHrBikinListDataSourceBean();

        khYendthnkHrBikinListDataSourceBean3.setIrKbnkeirihknsyuruinm(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
        khYendthnkHrBikinListDataSourceBean3.setIrBkncd("PC12");
        khYendthnkHrBikinListDataSourceBean3.setIrBknkktiymdwareki("平成27年11月20日");
        khYendthnkHrBikinListDataSourceBean3.setIrSisyacd("727");
        khYendthnkHrBikinListDataSourceBean3.setIrKigou("ﾅH");
        khYendthnkHrBikinListDataSourceBean3.setIrSyono("10000009999");
        khYendthnkHrBikinListDataSourceBean3.setIrBkngk(BizCurrency.valueOf(1));
        khYendthnkHrBikinListDataSourceBean3.setIrBknkktinnd("平成27年度");
        khYendthnkHrBikinListDataSourceBean3.setIrBikinkensuugoukei(BizNumber.valueOf(9999));
        khYendthnkHrBikinListDataSourceBean3.setIrBikingakugoukei(BizCurrency.valueOf(9999));
        khYendthnkHrBikinListDataSourceBean3.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khYendthnkHrBikinListDataSourceBean3.setIrGoukeitani("平成27年度");

        dataSouceList.add(khYendthnkHrBikinListDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, khYendthnkHrBikinListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhYendthnkbikinlistTest", C_SyoruiCdKbn.KK_YENDTHNK_BIKINLIST);
        khYendthnkHrBikinListBean.setIrTantsitunmkj("保全支払サービス室");
        khYendthnkHrBikinListBean.setIrKessannnd("平成27年度");
        khYendthnkHrBikinListBean.setIrBknkessankbn(C_Bknkessankbn.SHNK);
        khYendthnkHrBikinListBean.setIrTyouhyousakuseiymdwareki("平成27年12月30日");
        khYendthnkHrBikinListBean.setIrHozonkkn("99ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean;

        for (int i = 0; i < 16; i++) {

            khYendthnkHrBikinListDataSourceBean  = new KhYendthnkHrBikinListDataSourceBean();
            khYendthnkHrBikinListDataSourceBean.setIrKbnkeirihknsyuruinm(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
            khYendthnkHrBikinListDataSourceBean.setIrBkncd("PC12");
            khYendthnkHrBikinListDataSourceBean.setIrBknkktiymdwareki("平成27年11月20日");
            khYendthnkHrBikinListDataSourceBean.setIrSisyacd("727");
            khYendthnkHrBikinListDataSourceBean.setIrKigou("ﾅH");
            khYendthnkHrBikinListDataSourceBean.setIrSyono("10000000001");
            khYendthnkHrBikinListDataSourceBean.setIrBkngk(BizCurrency.valueOf(10000));
            khYendthnkHrBikinListDataSourceBean.setIrBknkktinnd("平成27年度");
            khYendthnkHrBikinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khYendthnkHrBikinListDataSourceBean);
        }

        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean2  = new KhYendthnkHrBikinListDataSourceBean();

        khYendthnkHrBikinListDataSourceBean2.setIrKbnkeirihknsyuruinm(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
        khYendthnkHrBikinListDataSourceBean2.setIrBkncd("PC12");
        khYendthnkHrBikinListDataSourceBean2.setIrBknkktiymdwareki("平成27年11月20日");
        khYendthnkHrBikinListDataSourceBean2.setIrSisyacd("727");
        khYendthnkHrBikinListDataSourceBean2.setIrKigou("ﾅH");
        khYendthnkHrBikinListDataSourceBean2.setIrSyono("10000000001");
        khYendthnkHrBikinListDataSourceBean2.setIrBkngk(BizCurrency.valueOf(10000));
        khYendthnkHrBikinListDataSourceBean2.setIrBknkktinnd("平成27年度");
        khYendthnkHrBikinListDataSourceBean2.setIrBikinkensuugoukei(BizNumber.valueOf(17));
        khYendthnkHrBikinListDataSourceBean2.setIrBikingakugoukei(BizCurrency.valueOf(170000));
        khYendthnkHrBikinListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khYendthnkHrBikinListDataSourceBean2.setIrGoukeitani("平成27年度");

        dataSouceList.add(khYendthnkHrBikinListDataSourceBean2);

        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean3  = new KhYendthnkHrBikinListDataSourceBean();

        khYendthnkHrBikinListDataSourceBean3.setIrKbnkeirihknsyuruinm(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
        khYendthnkHrBikinListDataSourceBean3.setIrBkncd("PC12");
        khYendthnkHrBikinListDataSourceBean3.setIrBknkktiymdwareki("平成27年11月20日");
        khYendthnkHrBikinListDataSourceBean3.setIrSisyacd("727");
        khYendthnkHrBikinListDataSourceBean3.setIrKigou("ﾅH");
        khYendthnkHrBikinListDataSourceBean3.setIrSyono("10000000001");
        khYendthnkHrBikinListDataSourceBean3.setIrBkngk(BizCurrency.valueOf(10000));
        khYendthnkHrBikinListDataSourceBean3.setIrBknkktinnd("平成28年度");
        khYendthnkHrBikinListDataSourceBean3.setIrGoukeiumukbn(C_UmuKbn.NONE);

        dataSouceList.add(khYendthnkHrBikinListDataSourceBean3);

        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean4  = new KhYendthnkHrBikinListDataSourceBean();

        khYendthnkHrBikinListDataSourceBean4.setIrKbnkeirihknsyuruinm(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
        khYendthnkHrBikinListDataSourceBean4.setIrBkncd("PC12");
        khYendthnkHrBikinListDataSourceBean4.setIrBknkktiymdwareki("平成27年11月20日");
        khYendthnkHrBikinListDataSourceBean4.setIrSisyacd("727");
        khYendthnkHrBikinListDataSourceBean4.setIrKigou("ﾅH");
        khYendthnkHrBikinListDataSourceBean4.setIrSyono("10000000001");
        khYendthnkHrBikinListDataSourceBean4.setIrBkngk(BizCurrency.valueOf(10000));
        khYendthnkHrBikinListDataSourceBean4.setIrBknkktinnd("平成28年度");
        khYendthnkHrBikinListDataSourceBean4.setIrBikinkensuugoukei(BizNumber.valueOf(2));
        khYendthnkHrBikinListDataSourceBean4.setIrBikingakugoukei(BizCurrency.valueOf(20000));
        khYendthnkHrBikinListDataSourceBean4.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khYendthnkHrBikinListDataSourceBean4.setIrGoukeitani("平成28年度");

        dataSouceList.add(khYendthnkHrBikinListDataSourceBean4);


        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean5  = new KhYendthnkHrBikinListDataSourceBean();

        khYendthnkHrBikinListDataSourceBean5.setIrKbnkeirihknsyuruinm(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
        khYendthnkHrBikinListDataSourceBean5.setIrBkncd("PC12");
        khYendthnkHrBikinListDataSourceBean5.setIrBikinkensuugoukei(BizNumber.valueOf(19));
        khYendthnkHrBikinListDataSourceBean5.setIrBikingakugoukei(BizCurrency.valueOf(190000));
        khYendthnkHrBikinListDataSourceBean5.setIrGoukeiumukbn(C_UmuKbn.ARI);
        khYendthnkHrBikinListDataSourceBean5.setIrGoukeitani("米ドル建個人年金保険（一時払）（準有配）");

        dataSouceList.add(khYendthnkHrBikinListDataSourceBean5);

        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean6;

        for (int i = 0; i < 2; i++) {

            khYendthnkHrBikinListDataSourceBean6  = new KhYendthnkHrBikinListDataSourceBean();
            khYendthnkHrBikinListDataSourceBean6.setIrKbnkeirihknsyuruinm(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            khYendthnkHrBikinListDataSourceBean6.setIrBkncd("PC12");
            khYendthnkHrBikinListDataSourceBean6.setIrBknkktiymdwareki("平成27年11月20日");
            khYendthnkHrBikinListDataSourceBean6.setIrSisyacd("727");
            khYendthnkHrBikinListDataSourceBean6.setIrKigou("ﾅH");
            khYendthnkHrBikinListDataSourceBean6.setIrSyono("10000000003");
            khYendthnkHrBikinListDataSourceBean6.setIrBkngk(BizCurrency.valueOf(10000));
            khYendthnkHrBikinListDataSourceBean6.setIrBknkktinnd("平成28年度");
            khYendthnkHrBikinListDataSourceBean6.setIrGoukeiumukbn(C_UmuKbn.NONE);

            dataSouceList.add(khYendthnkHrBikinListDataSourceBean6);
        }


        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean7  = new KhYendthnkHrBikinListDataSourceBean();

        khYendthnkHrBikinListDataSourceBean7.setIrKbnkeirihknsyuruinm(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        khYendthnkHrBikinListDataSourceBean7.setIrBkncd("PC12");
        khYendthnkHrBikinListDataSourceBean7.setIrBknkktiymdwareki("平成27年11月20日");
        khYendthnkHrBikinListDataSourceBean7.setIrSisyacd("727");
        khYendthnkHrBikinListDataSourceBean7.setIrKigou("ﾅH");
        khYendthnkHrBikinListDataSourceBean7.setIrSyono("10000000001");
        khYendthnkHrBikinListDataSourceBean7.setIrBkngk(BizCurrency.valueOf(10000));
        khYendthnkHrBikinListDataSourceBean7.setIrBknkktinnd("平成28年度");
        khYendthnkHrBikinListDataSourceBean7.setIrBikinkensuugoukei(BizNumber.valueOf(3));
        khYendthnkHrBikinListDataSourceBean7.setIrBikingakugoukei(BizCurrency.valueOf(30000));
        khYendthnkHrBikinListDataSourceBean7.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khYendthnkHrBikinListDataSourceBean7.setIrGoukeitani("平成28年度");

        dataSouceList.add(khYendthnkHrBikinListDataSourceBean7);


        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean8  = new KhYendthnkHrBikinListDataSourceBean();

        khYendthnkHrBikinListDataSourceBean8.setIrKbnkeirihknsyuruinm(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        khYendthnkHrBikinListDataSourceBean8.setIrBkncd("PC12");
        khYendthnkHrBikinListDataSourceBean8.setIrBknkktiymdwareki("平成27年11月20日");
        khYendthnkHrBikinListDataSourceBean8.setIrSisyacd("727");
        khYendthnkHrBikinListDataSourceBean8.setIrKigou("ﾅH");
        khYendthnkHrBikinListDataSourceBean8.setIrSyono("10000000001");
        khYendthnkHrBikinListDataSourceBean8.setIrBkngk(BizCurrency.valueOf(10000));
        khYendthnkHrBikinListDataSourceBean8.setIrBknkktinnd("平成29年度");
        khYendthnkHrBikinListDataSourceBean8.setIrBikinkensuugoukei(BizNumber.valueOf(1));
        khYendthnkHrBikinListDataSourceBean8.setIrBikingakugoukei(BizCurrency.valueOf(10000));
        khYendthnkHrBikinListDataSourceBean8.setIrGoukeiumukbn(C_UmuKbn.NONE);
        khYendthnkHrBikinListDataSourceBean8.setIrGoukeitani("平成29年度");

        dataSouceList.add(khYendthnkHrBikinListDataSourceBean8);


        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean9  = new KhYendthnkHrBikinListDataSourceBean();

        khYendthnkHrBikinListDataSourceBean9.setIrKbnkeirihknsyuruinm(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        khYendthnkHrBikinListDataSourceBean9.setIrBkncd("PC12");
        khYendthnkHrBikinListDataSourceBean9.setIrBikinkensuugoukei(BizNumber.valueOf(4));
        khYendthnkHrBikinListDataSourceBean9.setIrBikingakugoukei(BizCurrency.valueOf(40000));
        khYendthnkHrBikinListDataSourceBean9.setIrGoukeiumukbn(C_UmuKbn.ARI);
        khYendthnkHrBikinListDataSourceBean9.setIrGoukeitani("米ドル建終身保険（一時払）（準有配）");

        dataSouceList.add(khYendthnkHrBikinListDataSourceBean9);

        KhYendthnkHrBikinListDataSourceBean  khYendthnkHrBikinListDataSourceBean10  = new KhYendthnkHrBikinListDataSourceBean();

        khYendthnkHrBikinListDataSourceBean10.setIrBkncd("PC12");
        khYendthnkHrBikinListDataSourceBean10.setIrBikinkensuugoukei(BizNumber.valueOf(23));
        khYendthnkHrBikinListDataSourceBean10.setIrBikingakugoukei(BizCurrency.valueOf(230000));
        khYendthnkHrBikinListDataSourceBean10.setIrGoukeiumukbn(C_UmuKbn.ARI);
        khYendthnkHrBikinListDataSourceBean10.setIrGoukeitani("RBK2");

        dataSouceList.add(khYendthnkHrBikinListDataSourceBean10);

        reportTestBean.addParamObjects(dataSouceList, khYendthnkHrBikinListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
