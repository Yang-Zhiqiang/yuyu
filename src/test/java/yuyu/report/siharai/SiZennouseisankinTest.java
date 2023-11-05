package yuyu.report.siharai;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Bknkessankbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.siharai.bean.report.SiZennouseisankinMeisaiListBean;
import yuyu.def.siharai.bean.report.SiZennouseisankinMeisaiListDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 前納精算金明細リスト 帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiZennouseisankinTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SiZennouseisankinMeisaiListBean siZennouseisankinMeisaiListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiZennouseisankinTest",
                C_SyoruiCdKbn.HK_ZENNOUSEISANKINMEISAILIST);
        siZennouseisankinMeisaiListBean.setIrAtesaki("");
        siZennouseisankinMeisaiListBean.setIrKessannnd("");
        siZennouseisankinMeisaiListBean.setIrBknkessankbn(C_Bknkessankbn.BLNK);
        siZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd("");
        siZennouseisankinMeisaiListBean.setIrHozonkkn("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean = new SiZennouseisankinMeisaiListDataSourceBean();

        siZennouseisankinMeisaiListDataSourceBean.setIrBkncd("");
        siZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel("");
        siZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd("");
        siZennouseisankinMeisaiListDataSourceBean.setIrSyono("");
        siZennouseisankinMeisaiListDataSourceBean.setIrZennouseisankin("");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibkncd("");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeihknsyruilevel("");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktinnd("");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktiym("");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeikensuu1(BizNumber.valueOf(0));
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiseisankin("");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siZennouseisankinMeisaiListDataSourceBean.setIrPageno(1);

        dataSouceList.add(siZennouseisankinMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, siZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiZennouseisankinTest",
                C_SyoruiCdKbn.HK_ZENNOUSEISANKINMEISAILIST);
        siZennouseisankinMeisaiListBean.setIrAtesaki(null);
        siZennouseisankinMeisaiListBean.setIrKessannnd(null);
        siZennouseisankinMeisaiListBean.setIrBknkessankbn(null);
        siZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd(null);
        siZennouseisankinMeisaiListBean.setIrHozonkkn(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean = new SiZennouseisankinMeisaiListDataSourceBean();

        siZennouseisankinMeisaiListDataSourceBean.setIrBkncd(null);
        siZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel(null);
        siZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd(null);
        siZennouseisankinMeisaiListDataSourceBean.setIrSyono(null);
        siZennouseisankinMeisaiListDataSourceBean.setIrZennouseisankin(null);
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibkncd(null);
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeihknsyruilevel(null);
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktinnd(null);
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktiym(null);
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeikensuu1(null);
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiseisankin(null);
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siZennouseisankinMeisaiListDataSourceBean.setIrPageno(1);

        dataSouceList.add(siZennouseisankinMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, siZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiZennouseisankinTest",
                C_SyoruiCdKbn.HK_ZENNOUSEISANKINMEISAILIST);
        siZennouseisankinMeisaiListBean.setIrAtesaki("保全支払サービス室");
        siZennouseisankinMeisaiListBean.setIrKessannnd("2018年度");
        siZennouseisankinMeisaiListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        siZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");
        siZennouseisankinMeisaiListBean.setIrHozonkkn("3年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean = new SiZennouseisankinMeisaiListDataSourceBean();

        siZennouseisankinMeisaiListDataSourceBean.setIrBkncd("PC12");
        siZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel("豪ドル建個人年金保険（一時払）（準有配）");
        siZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd("2018年 3月 3日");
        siZennouseisankinMeisaiListDataSourceBean.setIrSyono("10000000001");
        siZennouseisankinMeisaiListDataSourceBean.setIrZennouseisankin("999");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibkncd("PC02");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeihknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktinnd("2017年度");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktiym("2018年 1月");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeikensuu1(BizNumber.valueOf(123));
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiseisankin("101");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siZennouseisankinMeisaiListDataSourceBean.setIrPageno(1);

        dataSouceList.add(siZennouseisankinMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, siZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiZennouseisankinTest",
                C_SyoruiCdKbn.HK_ZENNOUSEISANKINMEISAILIST);
        siZennouseisankinMeisaiListBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siZennouseisankinMeisaiListBean.setIrKessannnd("9999年度");
        siZennouseisankinMeisaiListBean.setIrBknkessankbn(C_Bknkessankbn.SHNK);
        siZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd("9999年99月99日");
        siZennouseisankinMeisaiListBean.setIrHozonkkn("99ＷＷ");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean = new SiZennouseisankinMeisaiListDataSourceBean();

        siZennouseisankinMeisaiListDataSourceBean.setIrBkncd("wwww");
        siZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd("9999年99月99日");
        siZennouseisankinMeisaiListDataSourceBean.setIrSyono("wwwwwwwwwww");
        siZennouseisankinMeisaiListDataSourceBean.setIrZennouseisankin("9,999,999,999");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibkncd("wwww");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeihknsyruilevel("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktinnd("9999年度");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktiym("9999年99月");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeikensuu1(BizNumber.valueOf(999999));
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiseisankin("999,999,999,999,999");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siZennouseisankinMeisaiListDataSourceBean.setIrPageno(1);

        dataSouceList.add(siZennouseisankinMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, siZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiZennouseisankinTest",
                C_SyoruiCdKbn.HK_ZENNOUSEISANKINMEISAILIST);
        siZennouseisankinMeisaiListBean.setIrAtesaki("保全支払サービス室");
        siZennouseisankinMeisaiListBean.setIrKessannnd("2018年度");
        siZennouseisankinMeisaiListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        siZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");
        siZennouseisankinMeisaiListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 33; i++) {

            SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean = new SiZennouseisankinMeisaiListDataSourceBean();

            siZennouseisankinMeisaiListDataSourceBean.setIrBkncd("PC12");
            siZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel("豪ドル建個人年金保険（一時払）（準有配）");
            siZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd("2018年 3月 3日");
            siZennouseisankinMeisaiListDataSourceBean.setIrSyono("10000000001");
            siZennouseisankinMeisaiListDataSourceBean.setIrZennouseisankin("9,999");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibkncd("PC12");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeihknsyruilevel("豪ドル建個人年金保険（一時払）（準有配）");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktinnd("2018年度");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktiym("2018年 4月");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeikensuu1(BizNumber.valueOf(1234));
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiseisankin("1,001");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
            siZennouseisankinMeisaiListDataSourceBean.setIrPageno(1);

            dataSouceList.add(siZennouseisankinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, siZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiZennouseisankinTest",
                C_SyoruiCdKbn.HK_ZENNOUSEISANKINMEISAILIST);
        siZennouseisankinMeisaiListBean.setIrAtesaki("保全支払サービス室");
        siZennouseisankinMeisaiListBean.setIrKessannnd("2018年度");
        siZennouseisankinMeisaiListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        siZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");
        siZennouseisankinMeisaiListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 34; i++) {

            SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean = new SiZennouseisankinMeisaiListDataSourceBean();

            siZennouseisankinMeisaiListDataSourceBean.setIrBkncd("PC02");
            siZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel("豪ドル建個人年金保険（一時払）（準有配）");
            siZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd("2018年 3月 3日");
            siZennouseisankinMeisaiListDataSourceBean.setIrSyono("10000000001");
            siZennouseisankinMeisaiListDataSourceBean.setIrZennouseisankin("9,999");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibkncd("PC02");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeihknsyruilevel("豪ドル建個人年金保険（一時払）（準有配）");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktinnd("2018年度");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktiym("2018年 4月");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeikensuu1(BizNumber.valueOf(1234));
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiseisankin("1,001");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
            siZennouseisankinMeisaiListDataSourceBean.setIrPageno(1);

            dataSouceList.add(siZennouseisankinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, siZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiZennouseisankinTest",
                C_SyoruiCdKbn.HK_ZENNOUSEISANKINMEISAILIST);
        siZennouseisankinMeisaiListBean.setIrAtesaki("保全支払サービス室");
        siZennouseisankinMeisaiListBean.setIrKessannnd("2018年度");
        siZennouseisankinMeisaiListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        siZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");
        siZennouseisankinMeisaiListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 35; i++) {

            SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean = new SiZennouseisankinMeisaiListDataSourceBean();

            siZennouseisankinMeisaiListDataSourceBean.setIrBkncd("PC02");
            siZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel("豪ドル建個人年金保険（一時払）（準有配）");
            siZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd("2018年 3月 3日");
            siZennouseisankinMeisaiListDataSourceBean.setIrSyono("10000000001");
            siZennouseisankinMeisaiListDataSourceBean.setIrZennouseisankin("9,999");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibkncd("PC02");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeihknsyruilevel("豪ドル建個人年金保険（一時払）（準有配）");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktinnd("2018年度");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktiym("2018年 4月");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeikensuu1(BizNumber.valueOf(1234));
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiseisankin("1,001");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
            siZennouseisankinMeisaiListDataSourceBean.setIrPageno(1);

            dataSouceList.add(siZennouseisankinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, siZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiZennouseisankinTest",
                C_SyoruiCdKbn.HK_ZENNOUSEISANKINMEISAILIST);
        siZennouseisankinMeisaiListBean.setIrAtesaki("保全支払サービス室");
        siZennouseisankinMeisaiListBean.setIrKessannnd("2018年度");
        siZennouseisankinMeisaiListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        siZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");
        siZennouseisankinMeisaiListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 9999; i++) {

            SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean = new SiZennouseisankinMeisaiListDataSourceBean();

            siZennouseisankinMeisaiListDataSourceBean.setIrBkncd("wwww");
            siZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd("9999年99月99日");
            siZennouseisankinMeisaiListDataSourceBean.setIrSyono("wwwwwwwwwww");
            siZennouseisankinMeisaiListDataSourceBean.setIrZennouseisankin("9,999,999,999");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibkncd("wwww");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeihknsyruilevel("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktinnd("9999年度");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktiym("9999年99月");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeikensuu1(BizNumber.valueOf(999999));
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiseisankin("999,999,999,999,999");
            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
            siZennouseisankinMeisaiListDataSourceBean.setIrPageno(i + 1);

            dataSouceList.add(siZennouseisankinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, siZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }


    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiZennouseisankinTest",
                C_SyoruiCdKbn.HK_ZENNOUSEISANKINMEISAILIST);
        siZennouseisankinMeisaiListBean.setIrAtesaki("保全支払サービス室");
        siZennouseisankinMeisaiListBean.setIrKessannnd("2018年度");
        siZennouseisankinMeisaiListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        siZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");
        siZennouseisankinMeisaiListBean.setIrHozonkkn("3年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, siZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }


    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiZennouseisankinTest",
                C_SyoruiCdKbn.HK_ZENNOUSEISANKINMEISAILIST);
        siZennouseisankinMeisaiListBean.setIrAtesaki("保全支払サービス室");
        siZennouseisankinMeisaiListBean.setIrKessannnd("2018年度");
        siZennouseisankinMeisaiListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        siZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd("2018年 2月 2日");
        siZennouseisankinMeisaiListBean.setIrHozonkkn("6ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean1 = new SiZennouseisankinMeisaiListDataSourceBean();

        siZennouseisankinMeisaiListDataSourceBean1.setIrBkncd("PC12");
        siZennouseisankinMeisaiListDataSourceBean1.setIrHknsyruilevel("米ドル建個人年金保険（一時払）（準有配）");
        siZennouseisankinMeisaiListDataSourceBean1.setIrBknkktiymd("2017年 4月 4日");
        siZennouseisankinMeisaiListDataSourceBean1.setIrSyono("10000000001");
        siZennouseisankinMeisaiListDataSourceBean1.setIrZennouseisankin("1");
        siZennouseisankinMeisaiListDataSourceBean1.setIrGoukeibkncd("");
        siZennouseisankinMeisaiListDataSourceBean1.setIrGoukeihknsyruilevel("");
        siZennouseisankinMeisaiListDataSourceBean1.setIrGoukeibknkktinnd("");
        siZennouseisankinMeisaiListDataSourceBean1.setIrGoukeibknkktiym("");
        siZennouseisankinMeisaiListDataSourceBean1.setIrGoukeikensuu1(null);
        siZennouseisankinMeisaiListDataSourceBean1.setIrGoukeiseisankin(null);
        siZennouseisankinMeisaiListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siZennouseisankinMeisaiListDataSourceBean1.setIrPageno(1);

        dataSouceList.add(siZennouseisankinMeisaiListDataSourceBean1);

        SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean2 = new SiZennouseisankinMeisaiListDataSourceBean();

        siZennouseisankinMeisaiListDataSourceBean2.setIrBkncd("PC12");
        siZennouseisankinMeisaiListDataSourceBean2.setIrHknsyruilevel("米ドル建個人年金保険（一時払）（準有配）");
        siZennouseisankinMeisaiListDataSourceBean2.setIrBknkktiymd("2017年 4月 4日");
        siZennouseisankinMeisaiListDataSourceBean2.setIrSyono("10000000001");
        siZennouseisankinMeisaiListDataSourceBean2.setIrZennouseisankin("99");
        siZennouseisankinMeisaiListDataSourceBean2.setIrGoukeibkncd("PC12");
        siZennouseisankinMeisaiListDataSourceBean2.setIrGoukeihknsyruilevel("米ドル建個人年金保険（一時払）（準有配）");
        siZennouseisankinMeisaiListDataSourceBean2.setIrGoukeibknkktinnd("2017年度");
        siZennouseisankinMeisaiListDataSourceBean2.setIrGoukeibknkktiym("2017年 4月");
        siZennouseisankinMeisaiListDataSourceBean2.setIrGoukeikensuu1(BizNumber.valueOf(2));
        siZennouseisankinMeisaiListDataSourceBean2.setIrGoukeiseisankin("100");
        siZennouseisankinMeisaiListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siZennouseisankinMeisaiListDataSourceBean2.setIrPageno(1);

        dataSouceList.add(siZennouseisankinMeisaiListDataSourceBean2);

        SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean3 = new SiZennouseisankinMeisaiListDataSourceBean();

        siZennouseisankinMeisaiListDataSourceBean3.setIrBkncd("PC12");
        siZennouseisankinMeisaiListDataSourceBean3.setIrHknsyruilevel("米ドル建個人年金保険（一時払）（準有配）");
        siZennouseisankinMeisaiListDataSourceBean3.setIrBknkktiymd("2018年 1月 3日");
        siZennouseisankinMeisaiListDataSourceBean3.setIrSyono("10000000001");
        siZennouseisankinMeisaiListDataSourceBean3.setIrZennouseisankin("200");
        siZennouseisankinMeisaiListDataSourceBean3.setIrGoukeibkncd("PC12");
        siZennouseisankinMeisaiListDataSourceBean3.setIrGoukeihknsyruilevel("米ドル建個人年金保険（一時払）（準有配）");
        siZennouseisankinMeisaiListDataSourceBean3.setIrGoukeibknkktinnd("2017年度");
        siZennouseisankinMeisaiListDataSourceBean3.setIrGoukeibknkktiym("2018年 1月");
        siZennouseisankinMeisaiListDataSourceBean3.setIrGoukeikensuu1(BizNumber.valueOf(1));
        siZennouseisankinMeisaiListDataSourceBean3.setIrGoukeiseisankin("200");
        siZennouseisankinMeisaiListDataSourceBean3.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siZennouseisankinMeisaiListDataSourceBean3.setIrPageno(2);

        dataSouceList.add(siZennouseisankinMeisaiListDataSourceBean3);

        SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean4 = new SiZennouseisankinMeisaiListDataSourceBean();

        siZennouseisankinMeisaiListDataSourceBean4.setIrBkncd("");
        siZennouseisankinMeisaiListDataSourceBean4.setIrHknsyruilevel("");
        siZennouseisankinMeisaiListDataSourceBean4.setIrBknkktiymd("");
        siZennouseisankinMeisaiListDataSourceBean4.setIrSyono("");
        siZennouseisankinMeisaiListDataSourceBean4.setIrZennouseisankin(null);
        siZennouseisankinMeisaiListDataSourceBean4.setIrGoukeibkncd("PC12");
        siZennouseisankinMeisaiListDataSourceBean4.setIrGoukeihknsyruilevel("米ドル建個人年金保険（一時払）（準有配）");
        siZennouseisankinMeisaiListDataSourceBean4.setIrGoukeibknkktinnd("2017年度");
        siZennouseisankinMeisaiListDataSourceBean4.setIrGoukeibknkktiym("");
        siZennouseisankinMeisaiListDataSourceBean4.setIrGoukeikensuu1(BizNumber.valueOf(3));
        siZennouseisankinMeisaiListDataSourceBean4.setIrGoukeiseisankin("300");
        siZennouseisankinMeisaiListDataSourceBean4.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siZennouseisankinMeisaiListDataSourceBean4.setIrPageno(3);

        dataSouceList.add(siZennouseisankinMeisaiListDataSourceBean4);

        SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean5 = new SiZennouseisankinMeisaiListDataSourceBean();

        siZennouseisankinMeisaiListDataSourceBean5.setIrBkncd("PC12");
        siZennouseisankinMeisaiListDataSourceBean5.setIrHknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        siZennouseisankinMeisaiListDataSourceBean5.setIrBknkktiymd("2017年 4月 4日");
        siZennouseisankinMeisaiListDataSourceBean5.setIrSyono("10000000001");
        siZennouseisankinMeisaiListDataSourceBean5.setIrZennouseisankin("300");
        siZennouseisankinMeisaiListDataSourceBean5.setIrGoukeibkncd("PC12");
        siZennouseisankinMeisaiListDataSourceBean5.setIrGoukeihknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        siZennouseisankinMeisaiListDataSourceBean5.setIrGoukeibknkktinnd("2018年度");
        siZennouseisankinMeisaiListDataSourceBean5.setIrGoukeibknkktiym("2018年 4月");
        siZennouseisankinMeisaiListDataSourceBean5.setIrGoukeikensuu1(BizNumber.valueOf(1));
        siZennouseisankinMeisaiListDataSourceBean5.setIrGoukeiseisankin("300");
        siZennouseisankinMeisaiListDataSourceBean5.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siZennouseisankinMeisaiListDataSourceBean5.setIrPageno(4);

        dataSouceList.add(siZennouseisankinMeisaiListDataSourceBean5);

        SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean6 = new SiZennouseisankinMeisaiListDataSourceBean();

        siZennouseisankinMeisaiListDataSourceBean6.setIrBkncd("");
        siZennouseisankinMeisaiListDataSourceBean6.setIrHknsyruilevel("");
        siZennouseisankinMeisaiListDataSourceBean6.setIrBknkktiymd("");
        siZennouseisankinMeisaiListDataSourceBean6.setIrSyono("");
        siZennouseisankinMeisaiListDataSourceBean6.setIrZennouseisankin(null);
        siZennouseisankinMeisaiListDataSourceBean6.setIrGoukeibkncd("PC12");
        siZennouseisankinMeisaiListDataSourceBean6.setIrGoukeihknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        siZennouseisankinMeisaiListDataSourceBean6.setIrGoukeibknkktinnd("2018年度");
        siZennouseisankinMeisaiListDataSourceBean6.setIrGoukeibknkktiym("");
        siZennouseisankinMeisaiListDataSourceBean6.setIrGoukeikensuu1(BizNumber.valueOf(1));
        siZennouseisankinMeisaiListDataSourceBean6.setIrGoukeiseisankin("300");
        siZennouseisankinMeisaiListDataSourceBean6.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siZennouseisankinMeisaiListDataSourceBean6.setIrPageno(5);

        dataSouceList.add(siZennouseisankinMeisaiListDataSourceBean6);

        SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean7 = new SiZennouseisankinMeisaiListDataSourceBean();

        siZennouseisankinMeisaiListDataSourceBean7.setIrBkncd("");
        siZennouseisankinMeisaiListDataSourceBean7.setIrHknsyruilevel("");
        siZennouseisankinMeisaiListDataSourceBean7.setIrBknkktiymd("");
        siZennouseisankinMeisaiListDataSourceBean7.setIrSyono("");
        siZennouseisankinMeisaiListDataSourceBean7.setIrZennouseisankin(null);
        siZennouseisankinMeisaiListDataSourceBean7.setIrGoukeibkncd("PC12");
        siZennouseisankinMeisaiListDataSourceBean7.setIrGoukeihknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        siZennouseisankinMeisaiListDataSourceBean7.setIrGoukeibknkktinnd("");
        siZennouseisankinMeisaiListDataSourceBean7.setIrGoukeibknkktiym("");
        siZennouseisankinMeisaiListDataSourceBean7.setIrGoukeikensuu1(BizNumber.valueOf(4));
        siZennouseisankinMeisaiListDataSourceBean7.setIrGoukeiseisankin("600");
        siZennouseisankinMeisaiListDataSourceBean7.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siZennouseisankinMeisaiListDataSourceBean7.setIrPageno(6);

        dataSouceList.add(siZennouseisankinMeisaiListDataSourceBean7);

        SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean8 = new SiZennouseisankinMeisaiListDataSourceBean();

        siZennouseisankinMeisaiListDataSourceBean8.setIrBkncd("PC12");
        siZennouseisankinMeisaiListDataSourceBean8.setIrHknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        siZennouseisankinMeisaiListDataSourceBean8.setIrBknkktiymd("2018年 4月 4日");
        siZennouseisankinMeisaiListDataSourceBean8.setIrSyono("10000000001");
        siZennouseisankinMeisaiListDataSourceBean8.setIrZennouseisankin("400");
        siZennouseisankinMeisaiListDataSourceBean8.setIrGoukeibkncd("PC12");
        siZennouseisankinMeisaiListDataSourceBean8.setIrGoukeihknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        siZennouseisankinMeisaiListDataSourceBean8.setIrGoukeibknkktinnd("2018年度");
        siZennouseisankinMeisaiListDataSourceBean8.setIrGoukeibknkktiym("2018年 4月");
        siZennouseisankinMeisaiListDataSourceBean8.setIrGoukeikensuu1(BizNumber.valueOf(1));
        siZennouseisankinMeisaiListDataSourceBean8.setIrGoukeiseisankin("400");
        siZennouseisankinMeisaiListDataSourceBean8.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siZennouseisankinMeisaiListDataSourceBean8.setIrPageno(7);

        dataSouceList.add(siZennouseisankinMeisaiListDataSourceBean8);

        SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean9 = new SiZennouseisankinMeisaiListDataSourceBean();

        siZennouseisankinMeisaiListDataSourceBean9.setIrBkncd("");
        siZennouseisankinMeisaiListDataSourceBean9.setIrHknsyruilevel("");
        siZennouseisankinMeisaiListDataSourceBean9.setIrBknkktiymd("");
        siZennouseisankinMeisaiListDataSourceBean9.setIrSyono("");
        siZennouseisankinMeisaiListDataSourceBean9.setIrZennouseisankin(null);
        siZennouseisankinMeisaiListDataSourceBean9.setIrGoukeibkncd("PC12");
        siZennouseisankinMeisaiListDataSourceBean9.setIrGoukeihknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        siZennouseisankinMeisaiListDataSourceBean9.setIrGoukeibknkktinnd("2018年度");
        siZennouseisankinMeisaiListDataSourceBean9.setIrGoukeibknkktiym("");
        siZennouseisankinMeisaiListDataSourceBean9.setIrGoukeikensuu1(BizNumber.valueOf(1));
        siZennouseisankinMeisaiListDataSourceBean9.setIrGoukeiseisankin("400");
        siZennouseisankinMeisaiListDataSourceBean9.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siZennouseisankinMeisaiListDataSourceBean9.setIrPageno(8);

        dataSouceList.add(siZennouseisankinMeisaiListDataSourceBean9);

        SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean10 = new SiZennouseisankinMeisaiListDataSourceBean();

        siZennouseisankinMeisaiListDataSourceBean10.setIrBkncd("");
        siZennouseisankinMeisaiListDataSourceBean10.setIrHknsyruilevel("");
        siZennouseisankinMeisaiListDataSourceBean10.setIrBknkktiymd("");
        siZennouseisankinMeisaiListDataSourceBean10.setIrSyono("");
        siZennouseisankinMeisaiListDataSourceBean10.setIrZennouseisankin(null);
        siZennouseisankinMeisaiListDataSourceBean10.setIrGoukeibkncd("PC12");
        siZennouseisankinMeisaiListDataSourceBean10.setIrGoukeihknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        siZennouseisankinMeisaiListDataSourceBean10.setIrGoukeibknkktinnd("");
        siZennouseisankinMeisaiListDataSourceBean10.setIrGoukeibknkktiym("");
        siZennouseisankinMeisaiListDataSourceBean10.setIrGoukeikensuu1(BizNumber.valueOf(1));
        siZennouseisankinMeisaiListDataSourceBean10.setIrGoukeiseisankin("400");
        siZennouseisankinMeisaiListDataSourceBean10.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siZennouseisankinMeisaiListDataSourceBean10.setIrPageno(9);

        dataSouceList.add(siZennouseisankinMeisaiListDataSourceBean10);

        SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean11 = new SiZennouseisankinMeisaiListDataSourceBean();

        siZennouseisankinMeisaiListDataSourceBean11.setIrBkncd("");
        siZennouseisankinMeisaiListDataSourceBean11.setIrHknsyruilevel("");
        siZennouseisankinMeisaiListDataSourceBean11.setIrBknkktiymd("");
        siZennouseisankinMeisaiListDataSourceBean11.setIrSyono("");
        siZennouseisankinMeisaiListDataSourceBean11.setIrZennouseisankin(null);
        siZennouseisankinMeisaiListDataSourceBean11.setIrGoukeibkncd("PC12");
        siZennouseisankinMeisaiListDataSourceBean11.setIrGoukeihknsyruilevel("");
        siZennouseisankinMeisaiListDataSourceBean11.setIrGoukeibknkktinnd("");
        siZennouseisankinMeisaiListDataSourceBean11.setIrGoukeibknkktiym("");
        siZennouseisankinMeisaiListDataSourceBean11.setIrGoukeikensuu1(BizNumber.valueOf(5));
        siZennouseisankinMeisaiListDataSourceBean11.setIrGoukeiseisankin("1000");
        siZennouseisankinMeisaiListDataSourceBean11.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siZennouseisankinMeisaiListDataSourceBean11.setIrPageno(10);

        dataSouceList.add(siZennouseisankinMeisaiListDataSourceBean11);

        reportTestBean.addParamObjects(dataSouceList, siZennouseisankinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
