package yuyu.report.siharai;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.siharai.bean.report.SiJikouDenMeisaiListBean;
import yuyu.def.siharai.bean.report.SiJikouDenMeisaiListDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 時効伝票明細リスト 帳票テスト 用クラス
 */
@RunWith(OrderedRunner.class)
public class SiJikoudenmeisailistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SiJikouDenMeisaiListBean siJikouDenMeisaiListBean;


    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiJikoudenmeisailistTest",
                C_SyoruiCdKbn.HK_JIKOUDENMEISAILIST);
        siJikouDenMeisaiListBean.setIrAtesaki("");
        siJikouDenMeisaiListBean.setIrKessannnd("");
        siJikouDenMeisaiListBean.setIrTyouhyousakuseiymd("");
        siJikouDenMeisaiListBean.setIrHozonkkn("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        SiJikouDenMeisaiListDataSourceBean siJikouDenMeisaiListDataSourceBean = new SiJikouDenMeisaiListDataSourceBean();

        siJikouDenMeisaiListDataSourceBean.setIrBkncd("");
        siJikouDenMeisaiListDataSourceBean.setIrSyono("");
        siJikouDenMeisaiListDataSourceBean.setIrKasitukekgk("");
        siJikouDenMeisaiListDataSourceBean.setIrTatekaekgk("");
        siJikouDenMeisaiListDataSourceBean.setIrKrkgkstr("");
        siJikouDenMeisaiListDataSourceBean.setIrKaribaraikgk("");
        siJikouDenMeisaiListDataSourceBean.setIrZatusyunyukgk("");
        siJikouDenMeisaiListDataSourceBean.setIrHkgk("");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeihknsyruilevel("");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeibkncd("");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeikasitukekgk("");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeitatekaekgk("");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeikrkgk("");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeikaribaraikgk("");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeizatusyunyukgk("");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeihkgk("");
        siJikouDenMeisaiListDataSourceBean.setIrSougoukeiumukbn(C_UmuKbn.NONE);
        siJikouDenMeisaiListDataSourceBean.setIrPageno(1);

        dataSouceList.add(siJikouDenMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, siJikouDenMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiJikoudenmeisailistTest",
                C_SyoruiCdKbn.HK_JIKOUDENMEISAILIST);
        siJikouDenMeisaiListBean.setIrAtesaki(null);
        siJikouDenMeisaiListBean.setIrKessannnd(null);
        siJikouDenMeisaiListBean.setIrTyouhyousakuseiymd(null);
        siJikouDenMeisaiListBean.setIrHozonkkn(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        SiJikouDenMeisaiListDataSourceBean siJikouDenMeisaiListDataSourceBean = new SiJikouDenMeisaiListDataSourceBean();

        siJikouDenMeisaiListDataSourceBean.setIrBkncd(null);
        siJikouDenMeisaiListDataSourceBean.setIrSyono(null);
        siJikouDenMeisaiListDataSourceBean.setIrKasitukekgk(null);
        siJikouDenMeisaiListDataSourceBean.setIrTatekaekgk(null);
        siJikouDenMeisaiListDataSourceBean.setIrKrkgkstr(null);
        siJikouDenMeisaiListDataSourceBean.setIrKaribaraikgk(null);
        siJikouDenMeisaiListDataSourceBean.setIrZatusyunyukgk(null);
        siJikouDenMeisaiListDataSourceBean.setIrHkgk(null);
        siJikouDenMeisaiListDataSourceBean.setIrGoukeihknsyruilevel(null);
        siJikouDenMeisaiListDataSourceBean.setIrGoukeibkncd(null);
        siJikouDenMeisaiListDataSourceBean.setIrGoukeikasitukekgk(null);
        siJikouDenMeisaiListDataSourceBean.setIrGoukeitatekaekgk(null);
        siJikouDenMeisaiListDataSourceBean.setIrGoukeikrkgk(null);
        siJikouDenMeisaiListDataSourceBean.setIrGoukeikaribaraikgk(null);
        siJikouDenMeisaiListDataSourceBean.setIrGoukeizatusyunyukgk(null);
        siJikouDenMeisaiListDataSourceBean.setIrGoukeihkgk(null);
        siJikouDenMeisaiListDataSourceBean.setIrSougoukeiumukbn(C_UmuKbn.NONE);
        siJikouDenMeisaiListDataSourceBean.setIrPageno(1);

        dataSouceList.add(siJikouDenMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, siJikouDenMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiJikoudenmeisailistTest",
                C_SyoruiCdKbn.HK_JIKOUDENMEISAILIST);
        siJikouDenMeisaiListBean.setIrAtesaki("支払業務室－Ｗ");
        siJikouDenMeisaiListBean.setIrKessannnd("2015年度");
        siJikouDenMeisaiListBean.setIrTyouhyousakuseiymd("20150819");
        siJikouDenMeisaiListBean.setIrHozonkkn("9 年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        SiJikouDenMeisaiListDataSourceBean siJikouDenMeisaiListDataSourceBean = new SiJikouDenMeisaiListDataSourceBean();

        siJikouDenMeisaiListDataSourceBean.setIrBkncd("PECA");
        siJikouDenMeisaiListDataSourceBean.setIrSyono("11807111484");
        siJikouDenMeisaiListDataSourceBean.setIrKasitukekgk("999");
        siJikouDenMeisaiListDataSourceBean.setIrTatekaekgk("999");
        siJikouDenMeisaiListDataSourceBean.setIrKrkgkstr("999");
        siJikouDenMeisaiListDataSourceBean.setIrKaribaraikgk("999");
        siJikouDenMeisaiListDataSourceBean.setIrZatusyunyukgk("999");
        siJikouDenMeisaiListDataSourceBean.setIrHkgk("999");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeihknsyruilevel("米ドル建低解約返戻金型特別終身（準有配）");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeibkncd("PECA");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeikasitukekgk("999");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeitatekaekgk("999");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeikrkgk("999");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeikaribaraikgk("999");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeizatusyunyukgk("999");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeihkgk("999");
        siJikouDenMeisaiListDataSourceBean.setIrSougoukeiumukbn(C_UmuKbn.NONE);
        siJikouDenMeisaiListDataSourceBean.setIrPageno(1);

        dataSouceList.add(siJikouDenMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, siJikouDenMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiJikoudenmeisailistTest",
                C_SyoruiCdKbn.HK_JIKOUDENMEISAILIST);
        siJikouDenMeisaiListBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siJikouDenMeisaiListBean.setIrKessannnd("ＷＷＷＷＷＷ");
        siJikouDenMeisaiListBean.setIrTyouhyousakuseiymd("99991231");
        siJikouDenMeisaiListBean.setIrHozonkkn("ＷＷＷ");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        SiJikouDenMeisaiListDataSourceBean siJikouDenMeisaiListDataSourceBean = new SiJikouDenMeisaiListDataSourceBean();

        siJikouDenMeisaiListDataSourceBean.setIrBkncd("wwww");
        siJikouDenMeisaiListDataSourceBean.setIrSyono("wwwwwwwwwww");
        siJikouDenMeisaiListDataSourceBean.setIrKasitukekgk("99999999999");
        siJikouDenMeisaiListDataSourceBean.setIrTatekaekgk("99999999999");
        siJikouDenMeisaiListDataSourceBean.setIrKrkgkstr("99999999999");
        siJikouDenMeisaiListDataSourceBean.setIrKaribaraikgk("99999999999");
        siJikouDenMeisaiListDataSourceBean.setIrZatusyunyukgk("99999999999");
        siJikouDenMeisaiListDataSourceBean.setIrHkgk("99999999999");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeihknsyruilevel("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeibkncd("ＷＷＷＷ");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeikasitukekgk("99999999999");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeitatekaekgk("99999999999");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeikrkgk("99999999999");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeikaribaraikgk("99999999999");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeizatusyunyukgk("99999999999");
        siJikouDenMeisaiListDataSourceBean.setIrGoukeihkgk("99999999999");
        siJikouDenMeisaiListDataSourceBean.setIrSougoukeiumukbn(C_UmuKbn.NONE);
        siJikouDenMeisaiListDataSourceBean.setIrPageno(1);

        dataSouceList.add(siJikouDenMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, siJikouDenMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiJikoudenmeisailistTest",
                C_SyoruiCdKbn.HK_JIKOUDENMEISAILIST);
        siJikouDenMeisaiListBean.setIrAtesaki("支払業務室－Ｗ");
        siJikouDenMeisaiListBean.setIrKessannnd("2015年度");
        siJikouDenMeisaiListBean.setIrTyouhyousakuseiymd("20150819");
        siJikouDenMeisaiListBean.setIrHozonkkn("9 年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 9999; i++) {
            SiJikouDenMeisaiListDataSourceBean siJikouDenMeisaiListDataSourceBean = new SiJikouDenMeisaiListDataSourceBean();

            siJikouDenMeisaiListDataSourceBean.setIrBkncd("PC12");
            siJikouDenMeisaiListDataSourceBean.setIrSyono("11807111484");
            siJikouDenMeisaiListDataSourceBean.setIrKasitukekgk("1000");
            siJikouDenMeisaiListDataSourceBean.setIrTatekaekgk("1000");
            siJikouDenMeisaiListDataSourceBean.setIrKrkgkstr("1000");
            siJikouDenMeisaiListDataSourceBean.setIrKaribaraikgk("1000");
            siJikouDenMeisaiListDataSourceBean.setIrZatusyunyukgk("1000");
            siJikouDenMeisaiListDataSourceBean.setIrHkgk("1000");
            siJikouDenMeisaiListDataSourceBean.setIrGoukeihknsyruilevel("米ドル建低解約返戻金型特別終身（準有配）");
            siJikouDenMeisaiListDataSourceBean.setIrSougoukeiumukbn(C_UmuKbn.NONE);
            siJikouDenMeisaiListDataSourceBean.setIrPageno(i);

            dataSouceList.add(siJikouDenMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, siJikouDenMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiJikoudenmeisailistTest",
                C_SyoruiCdKbn.HK_JIKOUDENMEISAILIST);
        siJikouDenMeisaiListBean.setIrAtesaki("支払業務室－Ｗ");
        siJikouDenMeisaiListBean.setIrKessannnd("2015年度");
        siJikouDenMeisaiListBean.setIrTyouhyousakuseiymd("20150819");
        siJikouDenMeisaiListBean.setIrHozonkkn("9 年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 11; i++) {
            SiJikouDenMeisaiListDataSourceBean siJikouDenMeisaiListDataSourceBean1_1 = new SiJikouDenMeisaiListDataSourceBean();

            siJikouDenMeisaiListDataSourceBean1_1.setIrBkncd("PC02");
            siJikouDenMeisaiListDataSourceBean1_1.setIrSyono("11807111118");
            siJikouDenMeisaiListDataSourceBean1_1.setIrKasitukekgk("9999");
            siJikouDenMeisaiListDataSourceBean1_1.setIrTatekaekgk("9999");
            siJikouDenMeisaiListDataSourceBean1_1.setIrKrkgkstr("9999");
            siJikouDenMeisaiListDataSourceBean1_1.setIrKaribaraikgk("9999");
            siJikouDenMeisaiListDataSourceBean1_1.setIrZatusyunyukgk("9999");
            siJikouDenMeisaiListDataSourceBean1_1.setIrHkgk("9999");
            siJikouDenMeisaiListDataSourceBean1_1.setIrGoukeihknsyruilevel("豪ドル建個人年金（一時払）（準有配）");
            siJikouDenMeisaiListDataSourceBean1_1.setIrSougoukeiumukbn(C_UmuKbn.NONE);
            siJikouDenMeisaiListDataSourceBean1_1.setIrPageno(1);

            dataSouceList.add(siJikouDenMeisaiListDataSourceBean1_1);
        }

        for (int i = 0; i < 11; i++) {
            SiJikouDenMeisaiListDataSourceBean siJikouDenMeisaiListDataSourceBean1_2 = new SiJikouDenMeisaiListDataSourceBean();

            siJikouDenMeisaiListDataSourceBean1_2.setIrBkncd("PC12");
            siJikouDenMeisaiListDataSourceBean1_2.setIrSyono("11807111129");
            siJikouDenMeisaiListDataSourceBean1_2.setIrKasitukekgk("9999");
            siJikouDenMeisaiListDataSourceBean1_2.setIrTatekaekgk("9999");
            siJikouDenMeisaiListDataSourceBean1_2.setIrKrkgkstr("9999");
            siJikouDenMeisaiListDataSourceBean1_2.setIrKaribaraikgk("9999");
            siJikouDenMeisaiListDataSourceBean1_2.setIrZatusyunyukgk("9999");
            siJikouDenMeisaiListDataSourceBean1_2.setIrHkgk("9999");
            siJikouDenMeisaiListDataSourceBean1_2.setIrGoukeihknsyruilevel("豪ドル建個人年金（一時払）（準有配）");
            siJikouDenMeisaiListDataSourceBean1_2.setIrSougoukeiumukbn(C_UmuKbn.NONE);
            siJikouDenMeisaiListDataSourceBean1_2.setIrPageno(1);

            dataSouceList.add(siJikouDenMeisaiListDataSourceBean1_2);
        }

        for (int i = 0; i < 10; i++) {
            SiJikouDenMeisaiListDataSourceBean siJikouDenMeisaiListDataSourceBean1_3 = new SiJikouDenMeisaiListDataSourceBean();

            siJikouDenMeisaiListDataSourceBean1_3.setIrBkncd("PEC2");
            siJikouDenMeisaiListDataSourceBean1_3.setIrSyono("11807111130");
            siJikouDenMeisaiListDataSourceBean1_3.setIrKasitukekgk("9999");
            siJikouDenMeisaiListDataSourceBean1_3.setIrTatekaekgk("9999");
            siJikouDenMeisaiListDataSourceBean1_3.setIrKrkgkstr("9999");
            siJikouDenMeisaiListDataSourceBean1_3.setIrKaribaraikgk("9999");
            siJikouDenMeisaiListDataSourceBean1_3.setIrZatusyunyukgk("9999");
            siJikouDenMeisaiListDataSourceBean1_3.setIrHkgk("9999");
            siJikouDenMeisaiListDataSourceBean1_3.setIrGoukeihknsyruilevel("豪ドル建個人年金（一時払）（準有配）");
            siJikouDenMeisaiListDataSourceBean1_3.setIrSougoukeiumukbn(C_UmuKbn.NONE);
            siJikouDenMeisaiListDataSourceBean1_3.setIrPageno(1);

            dataSouceList.add(siJikouDenMeisaiListDataSourceBean1_3);
        }

        SiJikouDenMeisaiListDataSourceBean siJikouDenMeisaiListDataSourceBean1_9 = new SiJikouDenMeisaiListDataSourceBean();

        siJikouDenMeisaiListDataSourceBean1_9.setIrBkncd("PECA");
        siJikouDenMeisaiListDataSourceBean1_9.setIrSyono("11807111141");
        siJikouDenMeisaiListDataSourceBean1_9.setIrKasitukekgk("9999");
        siJikouDenMeisaiListDataSourceBean1_9.setIrTatekaekgk("9999");
        siJikouDenMeisaiListDataSourceBean1_9.setIrKrkgkstr("9999");
        siJikouDenMeisaiListDataSourceBean1_9.setIrKaribaraikgk("9999");
        siJikouDenMeisaiListDataSourceBean1_9.setIrZatusyunyukgk("9999");
        siJikouDenMeisaiListDataSourceBean1_9.setIrHkgk("9999");
        siJikouDenMeisaiListDataSourceBean1_9.setIrGoukeihknsyruilevel("豪ドル建個人年金（一時払）（準有配）");
        siJikouDenMeisaiListDataSourceBean1_9.setIrGoukeibkncd("PECA");
        siJikouDenMeisaiListDataSourceBean1_9.setIrGoukeikasitukekgk("9999");
        siJikouDenMeisaiListDataSourceBean1_9.setIrGoukeitatekaekgk("9999");
        siJikouDenMeisaiListDataSourceBean1_9.setIrGoukeikrkgk("9999");
        siJikouDenMeisaiListDataSourceBean1_9.setIrGoukeikaribaraikgk("9999");
        siJikouDenMeisaiListDataSourceBean1_9.setIrGoukeizatusyunyukgk("9999");
        siJikouDenMeisaiListDataSourceBean1_9.setIrGoukeihkgk("9999");
        siJikouDenMeisaiListDataSourceBean1_9.setIrSougoukeiumukbn(C_UmuKbn.NONE);
        siJikouDenMeisaiListDataSourceBean1_9.setIrPageno(1);

        dataSouceList.add(siJikouDenMeisaiListDataSourceBean1_9);

        for (int i = 0; i < 11; i++) {
            SiJikouDenMeisaiListDataSourceBean siJikouDenMeisaiListDataSourceBean2_1 = new SiJikouDenMeisaiListDataSourceBean();

            siJikouDenMeisaiListDataSourceBean2_1.setIrBkncd("PEC2");
            siJikouDenMeisaiListDataSourceBean2_1.setIrSyono("11807111152");
            siJikouDenMeisaiListDataSourceBean2_1.setIrKasitukekgk("0");
            siJikouDenMeisaiListDataSourceBean2_1.setIrTatekaekgk("0");
            siJikouDenMeisaiListDataSourceBean2_1.setIrKrkgkstr("0");
            siJikouDenMeisaiListDataSourceBean2_1.setIrKaribaraikgk("0");
            siJikouDenMeisaiListDataSourceBean2_1.setIrZatusyunyukgk("0");
            siJikouDenMeisaiListDataSourceBean2_1.setIrHkgk("0");
            siJikouDenMeisaiListDataSourceBean2_1.setIrGoukeihknsyruilevel("豪ドル建個人年金（一時払）（準有配）");
            siJikouDenMeisaiListDataSourceBean2_1.setIrSougoukeiumukbn(C_UmuKbn.NONE);
            siJikouDenMeisaiListDataSourceBean2_1.setIrPageno(2);

            dataSouceList.add(siJikouDenMeisaiListDataSourceBean2_1);
        }

        for (int i = 0; i < 11; i++) {
            SiJikouDenMeisaiListDataSourceBean siJikouDenMeisaiListDataSourceBean2_2 = new SiJikouDenMeisaiListDataSourceBean();

            siJikouDenMeisaiListDataSourceBean2_2.setIrBkncd("PEC4");
            siJikouDenMeisaiListDataSourceBean2_2.setIrSyono("11807111163");
            siJikouDenMeisaiListDataSourceBean2_2.setIrKasitukekgk("0");
            siJikouDenMeisaiListDataSourceBean2_2.setIrTatekaekgk("0");
            siJikouDenMeisaiListDataSourceBean2_2.setIrKrkgkstr("0");
            siJikouDenMeisaiListDataSourceBean2_2.setIrKaribaraikgk("0");
            siJikouDenMeisaiListDataSourceBean2_2.setIrZatusyunyukgk("0");
            siJikouDenMeisaiListDataSourceBean2_2.setIrHkgk("0");
            siJikouDenMeisaiListDataSourceBean2_2.setIrGoukeihknsyruilevel("豪ドル建個人年金（一時払）（準有配）");
            siJikouDenMeisaiListDataSourceBean2_2.setIrSougoukeiumukbn(C_UmuKbn.NONE);
            siJikouDenMeisaiListDataSourceBean2_2.setIrPageno(2);

            dataSouceList.add(siJikouDenMeisaiListDataSourceBean2_2);
        }

        for (int i = 0; i < 11; i++) {
            SiJikouDenMeisaiListDataSourceBean siJikouDenMeisaiListDataSourceBean2_3 = new SiJikouDenMeisaiListDataSourceBean();

            siJikouDenMeisaiListDataSourceBean2_3.setIrBkncd("PED2");
            siJikouDenMeisaiListDataSourceBean2_3.setIrSyono("11807111174");
            siJikouDenMeisaiListDataSourceBean2_3.setIrKasitukekgk("0");
            siJikouDenMeisaiListDataSourceBean2_3.setIrTatekaekgk("0");
            siJikouDenMeisaiListDataSourceBean2_3.setIrKrkgkstr("0");
            siJikouDenMeisaiListDataSourceBean2_3.setIrKaribaraikgk("0");
            siJikouDenMeisaiListDataSourceBean2_3.setIrZatusyunyukgk("0");
            siJikouDenMeisaiListDataSourceBean2_3.setIrHkgk("0");
            siJikouDenMeisaiListDataSourceBean2_3.setIrGoukeihknsyruilevel("豪ドル建個人年金（一時払）（準有配）");
            siJikouDenMeisaiListDataSourceBean2_3.setIrSougoukeiumukbn(C_UmuKbn.NONE);
            siJikouDenMeisaiListDataSourceBean2_3.setIrPageno(2);

            dataSouceList.add(siJikouDenMeisaiListDataSourceBean2_3);
        }

        SiJikouDenMeisaiListDataSourceBean siJikouDenMeisaiListDataSourceBean2_9 = new SiJikouDenMeisaiListDataSourceBean();

        siJikouDenMeisaiListDataSourceBean2_9.setIrBkncd("PECB");
        siJikouDenMeisaiListDataSourceBean2_9.setIrSyono("11807111185");
        siJikouDenMeisaiListDataSourceBean2_9.setIrKasitukekgk("0");
        siJikouDenMeisaiListDataSourceBean2_9.setIrTatekaekgk("0");
        siJikouDenMeisaiListDataSourceBean2_9.setIrKrkgkstr("0");
        siJikouDenMeisaiListDataSourceBean2_9.setIrKaribaraikgk("0");
        siJikouDenMeisaiListDataSourceBean2_9.setIrZatusyunyukgk("0");
        siJikouDenMeisaiListDataSourceBean2_9.setIrHkgk("0");
        siJikouDenMeisaiListDataSourceBean2_9.setIrGoukeihknsyruilevel("豪ドル建個人年金（一時払）（準有配）");
        siJikouDenMeisaiListDataSourceBean2_9.setIrGoukeibkncd("PECB");
        siJikouDenMeisaiListDataSourceBean2_9.setIrGoukeikasitukekgk("0");
        siJikouDenMeisaiListDataSourceBean2_9.setIrGoukeitatekaekgk("0");
        siJikouDenMeisaiListDataSourceBean2_9.setIrGoukeikrkgk("0");
        siJikouDenMeisaiListDataSourceBean2_9.setIrGoukeikaribaraikgk("0");
        siJikouDenMeisaiListDataSourceBean2_9.setIrGoukeizatusyunyukgk("0");
        siJikouDenMeisaiListDataSourceBean2_9.setIrGoukeihkgk("0");
        siJikouDenMeisaiListDataSourceBean2_9.setIrSougoukeiumukbn(C_UmuKbn.NONE);
        siJikouDenMeisaiListDataSourceBean2_9.setIrPageno(2);

        dataSouceList.add(siJikouDenMeisaiListDataSourceBean2_9);

        for (int i = 0; i < 34; i++) {
            SiJikouDenMeisaiListDataSourceBean siJikouDenMeisaiListDataSourceBean3 = new SiJikouDenMeisaiListDataSourceBean();

            siJikouDenMeisaiListDataSourceBean3.setIrBkncd("PC12");
            siJikouDenMeisaiListDataSourceBean3.setIrSyono("11807111196");
            siJikouDenMeisaiListDataSourceBean3.setIrKasitukekgk("1001");
            siJikouDenMeisaiListDataSourceBean3.setIrTatekaekgk("1002");
            siJikouDenMeisaiListDataSourceBean3.setIrKrkgkstr("1003");
            siJikouDenMeisaiListDataSourceBean3.setIrKaribaraikgk("1004");
            siJikouDenMeisaiListDataSourceBean3.setIrZatusyunyukgk("1005");
            siJikouDenMeisaiListDataSourceBean3.setIrHkgk("1006");
            siJikouDenMeisaiListDataSourceBean3.setIrGoukeihknsyruilevel("米ドル建低解約返戻金型特別終身（準有配）");
            siJikouDenMeisaiListDataSourceBean3.setIrSougoukeiumukbn(C_UmuKbn.NONE);
            siJikouDenMeisaiListDataSourceBean3.setIrPageno(3);

            dataSouceList.add(siJikouDenMeisaiListDataSourceBean3);
        }

        SiJikouDenMeisaiListDataSourceBean siJikouDenMeisaiListDataSourceBean4 = new SiJikouDenMeisaiListDataSourceBean();

        siJikouDenMeisaiListDataSourceBean4.setIrBkncd("RBK2");
        siJikouDenMeisaiListDataSourceBean4.setIrSyono("11807111200");
        siJikouDenMeisaiListDataSourceBean4.setIrKasitukekgk("1001");
        siJikouDenMeisaiListDataSourceBean4.setIrTatekaekgk("1002");
        siJikouDenMeisaiListDataSourceBean4.setIrKrkgkstr("1003");
        siJikouDenMeisaiListDataSourceBean4.setIrKaribaraikgk("1004");
        siJikouDenMeisaiListDataSourceBean4.setIrZatusyunyukgk("1005");
        siJikouDenMeisaiListDataSourceBean4.setIrHkgk("1006");
        siJikouDenMeisaiListDataSourceBean4.setIrGoukeihknsyruilevel("米ドル建低解約返戻金型特別終身（準有配）");
        siJikouDenMeisaiListDataSourceBean4.setIrGoukeibkncd("PECB");
        siJikouDenMeisaiListDataSourceBean4.setIrGoukeikasitukekgk("6001");
        siJikouDenMeisaiListDataSourceBean4.setIrGoukeitatekaekgk("6002");
        siJikouDenMeisaiListDataSourceBean4.setIrGoukeikrkgk("6003");
        siJikouDenMeisaiListDataSourceBean4.setIrGoukeikaribaraikgk("6004");
        siJikouDenMeisaiListDataSourceBean4.setIrGoukeizatusyunyukgk("6005");
        siJikouDenMeisaiListDataSourceBean4.setIrGoukeihkgk("6006");
        siJikouDenMeisaiListDataSourceBean4.setIrSougoukeiumukbn(C_UmuKbn.NONE);
        siJikouDenMeisaiListDataSourceBean4.setIrPageno(4);

        dataSouceList.add(siJikouDenMeisaiListDataSourceBean4);

        SiJikouDenMeisaiListDataSourceBean siJikouDenMeisaiListDataSourceBean5 = new SiJikouDenMeisaiListDataSourceBean();

        siJikouDenMeisaiListDataSourceBean5.setIrBkncd("");
        siJikouDenMeisaiListDataSourceBean5.setIrSyono("");
        siJikouDenMeisaiListDataSourceBean5.setIrKasitukekgk("");
        siJikouDenMeisaiListDataSourceBean5.setIrTatekaekgk("");
        siJikouDenMeisaiListDataSourceBean5.setIrKrkgkstr("");
        siJikouDenMeisaiListDataSourceBean5.setIrKaribaraikgk("");
        siJikouDenMeisaiListDataSourceBean5.setIrZatusyunyukgk("");
        siJikouDenMeisaiListDataSourceBean5.setIrHkgk("");
        siJikouDenMeisaiListDataSourceBean5.setIrGoukeihknsyruilevel("米ドル建低解約返戻金型特別終身（準有配）");
        siJikouDenMeisaiListDataSourceBean5.setIrGoukeibkncd("総合計");
        siJikouDenMeisaiListDataSourceBean5.setIrGoukeikasitukekgk("6001");
        siJikouDenMeisaiListDataSourceBean5.setIrGoukeitatekaekgk("6002");
        siJikouDenMeisaiListDataSourceBean5.setIrGoukeikrkgk("6003");
        siJikouDenMeisaiListDataSourceBean5.setIrGoukeikaribaraikgk("6004");
        siJikouDenMeisaiListDataSourceBean5.setIrGoukeizatusyunyukgk("6005");
        siJikouDenMeisaiListDataSourceBean5.setIrGoukeihkgk("6006");
        siJikouDenMeisaiListDataSourceBean5.setIrSougoukeiumukbn(C_UmuKbn.ARI);
        siJikouDenMeisaiListDataSourceBean5.setIrPageno(5);

        dataSouceList.add(siJikouDenMeisaiListDataSourceBean5);

        reportTestBean.addParamObjects(dataSouceList, siJikouDenMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
