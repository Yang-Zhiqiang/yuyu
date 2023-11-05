package yuyu.report.suuri;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.suuri.bean.report.SrHaitoukinMeisaiListBean;
import yuyu.def.suuri.bean.report.SrHaitoukinMeisaiListDataSourceBean;
import yuyu.def.suuri.bean.report.SrHaitoukinMeisaiListSubDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 積立配当金明細表 帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SrTmttdmeisaiListTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SrHaitoukinMeisaiListBean srHaitoukinMeisaiListBean;

    @Test
    @TestOrder(10)
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("suuri", "", "SrTmttdmeisaiListTest",C_SyoruiCdKbn.SR_TMTTDMEISAILIST);

        srHaitoukinMeisaiListBean.setIrAtesakibukanm(null);
        srHaitoukinMeisaiListBean.setIrSyoriymd(null);
        srHaitoukinMeisaiListBean.setIrHozonkkn(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDataSourceBeanList1 = new ArrayList<SrHaitoukinMeisaiListSubDataSourceBean>();

        for (int i = 0; i < 11; i++) {

            SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDataSourceBean = new SrHaitoukinMeisaiListSubDataSourceBean();
            srHaitoukinMeisaiListSubDataSourceBean.setIrKensuu(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrHsys(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrZennendokurikosid(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrHaitoursk(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendod(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendomatud(null);
            srHaitoukinMeisaiListSubDataSourceBeanList1.add(srHaitoukinMeisaiListSubDataSourceBean);
        }

        SrHaitoukinMeisaiListDataSourceBean srHaitoukinMeisaiListDataSourceBean = new SrHaitoukinMeisaiListDataSourceBean();
        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd(null);
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui(null);
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd(null);
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDataSourceBeanList1);
        dataSouceList.add(srHaitoukinMeisaiListDataSourceBean);

        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDataSourceBeanList2 = new ArrayList<SrHaitoukinMeisaiListSubDataSourceBean>();
        for (int i = 0; i < 11; i++) {

            SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDataSourceBean = new SrHaitoukinMeisaiListSubDataSourceBean();
            srHaitoukinMeisaiListSubDataSourceBean = new SrHaitoukinMeisaiListSubDataSourceBean();
            srHaitoukinMeisaiListSubDataSourceBean.setIrKensuu(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrHsys(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrZennendokurikosid(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrHaitoursk(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendod(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendomatud(null);
            srHaitoukinMeisaiListSubDataSourceBeanList2.add(srHaitoukinMeisaiListSubDataSourceBean);
        }

        srHaitoukinMeisaiListDataSourceBean = new SrHaitoukinMeisaiListDataSourceBean();
        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd(null);
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui(null);
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd(null);
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDataSourceBeanList2);
        dataSouceList.add(srHaitoukinMeisaiListDataSourceBean);
        reportTestBean.addParamObjects(dataSouceList, srHaitoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("suuri", "", "SrTmttdmeisaiListTest",C_SyoruiCdKbn.SR_TMTTDMEISAILIST);

        srHaitoukinMeisaiListBean.setIrAtesakibukanm("");
        srHaitoukinMeisaiListBean.setIrSyoriymd("");
        srHaitoukinMeisaiListBean.setIrHozonkkn("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDataSourceBeanList1 = new ArrayList<SrHaitoukinMeisaiListSubDataSourceBean>();

        for (int i = 0; i < 11; i++) {

            SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDataSourceBean = new SrHaitoukinMeisaiListSubDataSourceBean();
            srHaitoukinMeisaiListSubDataSourceBean.setIrKensuu(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrHsys(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrZennendokurikosid(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrHaitoursk(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendod(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendomatud(null);
            srHaitoukinMeisaiListSubDataSourceBeanList1.add(srHaitoukinMeisaiListSubDataSourceBean);
        }

        SrHaitoukinMeisaiListDataSourceBean srHaitoukinMeisaiListDataSourceBean = new SrHaitoukinMeisaiListDataSourceBean();
        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("");
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("");
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("");
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDataSourceBeanList1);
        dataSouceList.add(srHaitoukinMeisaiListDataSourceBean);

        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDataSourceBeanList2 = new ArrayList<SrHaitoukinMeisaiListSubDataSourceBean>();

        for (int i = 0; i < 11; i++) {

            SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDataSourceBean = new SrHaitoukinMeisaiListSubDataSourceBean();
            srHaitoukinMeisaiListSubDataSourceBean.setIrKensuu(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrHsys(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrZennendokurikosid(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrHaitoursk(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendod(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendomatud(null);
            srHaitoukinMeisaiListSubDataSourceBeanList2.add(srHaitoukinMeisaiListSubDataSourceBean);
        }

        srHaitoukinMeisaiListDataSourceBean = new SrHaitoukinMeisaiListDataSourceBean();
        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("");
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("");
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("");
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDataSourceBeanList2);
        dataSouceList.add(srHaitoukinMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, srHaitoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("suuri", "", "SrTmttdmeisaiListTest",C_SyoruiCdKbn.SR_TMTTDMEISAILIST);

        srHaitoukinMeisaiListBean.setIrAtesakibukanm("収納サービス室　御中");
        srHaitoukinMeisaiListBean.setIrSyoriymd("2019年 8月12日");
        srHaitoukinMeisaiListBean.setIrHozonkkn("10年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDataSourceBeanList1 = new ArrayList<SrHaitoukinMeisaiListSubDataSourceBean>();

        for (int i = 0; i < 11; i++) {

            SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDataSourceBean = new SrHaitoukinMeisaiListSubDataSourceBean();
            srHaitoukinMeisaiListSubDataSourceBean.setIrKensuu(999);
            srHaitoukinMeisaiListSubDataSourceBean.setIrHsys(BizCurrency.valueOf(999));
            srHaitoukinMeisaiListSubDataSourceBean.setIrZennendokurikosid(BizCurrency.valueOf(999));
            srHaitoukinMeisaiListSubDataSourceBean.setIrHaitoursk(BizCurrency.valueOf(999));
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendod(BizCurrency.valueOf(999));
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendomatud(BizCurrency.valueOf(999));
            srHaitoukinMeisaiListSubDataSourceBeanList1.add(srHaitoukinMeisaiListSubDataSourceBean);
        }

        SrHaitoukinMeisaiListDataSourceBean srHaitoukinMeisaiListDataSourceBean = new SrHaitoukinMeisaiListDataSourceBean();
        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("０１０４");
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("保険種類");
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("1C");
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDataSourceBeanList1);
        dataSouceList.add(srHaitoukinMeisaiListDataSourceBean);

        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDataSourceBeanList2 = new ArrayList<SrHaitoukinMeisaiListSubDataSourceBean>();

        for (int i = 0; i < 11; i++) {

            SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDataSourceBean = new SrHaitoukinMeisaiListSubDataSourceBean();
            srHaitoukinMeisaiListSubDataSourceBean.setIrKensuu(999);
            srHaitoukinMeisaiListSubDataSourceBean.setIrHsys(BizCurrency.valueOf(999));
            srHaitoukinMeisaiListSubDataSourceBean.setIrZennendokurikosid(BizCurrency.valueOf(999));
            srHaitoukinMeisaiListSubDataSourceBean.setIrHaitoursk(BizCurrency.valueOf(999));
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendod(BizCurrency.valueOf(999));
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendomatud(BizCurrency.valueOf(999));
            srHaitoukinMeisaiListSubDataSourceBeanList2.add(srHaitoukinMeisaiListSubDataSourceBean);
        }

        srHaitoukinMeisaiListDataSourceBean = new SrHaitoukinMeisaiListDataSourceBean();
        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("０１０４");
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("保険種類");
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("1D");
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDataSourceBeanList2);
        dataSouceList.add(srHaitoukinMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, srHaitoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("suuri", "", "SrTmttdmeisaiListTest",C_SyoruiCdKbn.SR_TMTTDMEISAILIST);

        srHaitoukinMeisaiListBean.setIrAtesakibukanm("収納サービス室　御中");
        srHaitoukinMeisaiListBean.setIrSyoriymd("2019年 8月12日");
        srHaitoukinMeisaiListBean.setIrHozonkkn("10ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDataSourceBeanList1 = new ArrayList<SrHaitoukinMeisaiListSubDataSourceBean>();

        for (int i = 0; i < 11; i++) {

            SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDataSourceBean = new SrHaitoukinMeisaiListSubDataSourceBean();
            srHaitoukinMeisaiListSubDataSourceBean.setIrKensuu(1001);
            srHaitoukinMeisaiListSubDataSourceBean.setIrHsys(BizCurrency.valueOf(2001));
            srHaitoukinMeisaiListSubDataSourceBean.setIrZennendokurikosid(BizCurrency.valueOf(2002));
            srHaitoukinMeisaiListSubDataSourceBean.setIrHaitoursk(BizCurrency.valueOf(2003));
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendod(BizCurrency.valueOf(2004));
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendomatud(BizCurrency.valueOf(2005));
            srHaitoukinMeisaiListSubDataSourceBeanList1.add(srHaitoukinMeisaiListSubDataSourceBean);
        }

        SrHaitoukinMeisaiListDataSourceBean srHaitoukinMeisaiListDataSourceBean = new SrHaitoukinMeisaiListDataSourceBean();
        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("０１０４");
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("保険種類");
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("1C");
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDataSourceBeanList1);
        dataSouceList.add(srHaitoukinMeisaiListDataSourceBean);

        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDataSourceBeanList2 = new ArrayList<SrHaitoukinMeisaiListSubDataSourceBean>();

        for (int i = 0; i < 11; i++) {

            SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDataSourceBean = new SrHaitoukinMeisaiListSubDataSourceBean();
            srHaitoukinMeisaiListSubDataSourceBean.setIrKensuu(1001);
            srHaitoukinMeisaiListSubDataSourceBean.setIrHsys(BizCurrency.valueOf(2001));
            srHaitoukinMeisaiListSubDataSourceBean.setIrZennendokurikosid(BizCurrency.valueOf(2002));
            srHaitoukinMeisaiListSubDataSourceBean.setIrHaitoursk(BizCurrency.valueOf(2003));
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendod(BizCurrency.valueOf(2004));
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendomatud(BizCurrency.valueOf(2005));
            srHaitoukinMeisaiListSubDataSourceBeanList2.add(srHaitoukinMeisaiListSubDataSourceBean);
        }

        srHaitoukinMeisaiListDataSourceBean = new SrHaitoukinMeisaiListDataSourceBean();
        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("０１０４");
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("保険種類");
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("1D");
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDataSourceBeanList2);
        dataSouceList.add(srHaitoukinMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, srHaitoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    public void testCreateReport5() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("suuri", "", "SrTmttdmeisaiListTest",C_SyoruiCdKbn.SR_TMTTDMEISAILIST);

        srHaitoukinMeisaiListBean.setIrAtesakibukanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        srHaitoukinMeisaiListBean.setIrSyoriymd("9999年12月31日");
        srHaitoukinMeisaiListBean.setIrHozonkkn("99ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1998; i++) {

            List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDataSourceBeanList = new ArrayList<SrHaitoukinMeisaiListSubDataSourceBean>();

            for (int j = 0; j < 11; j++) {

                SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDataSourceBean = new SrHaitoukinMeisaiListSubDataSourceBean();
                srHaitoukinMeisaiListSubDataSourceBean.setIrKensuu(999999999);
                srHaitoukinMeisaiListSubDataSourceBean.setIrHsys(BizCurrency.valueOf(999999999999999l));
                srHaitoukinMeisaiListSubDataSourceBean.setIrZennendokurikosid(BizCurrency.valueOf(999999999999999l));
                srHaitoukinMeisaiListSubDataSourceBean.setIrHaitoursk(BizCurrency.valueOf(999999999999999l));
                srHaitoukinMeisaiListSubDataSourceBean.setIrTounendod(BizCurrency.valueOf(999999999999999l));
                srHaitoukinMeisaiListSubDataSourceBean.setIrTounendomatud(BizCurrency.valueOf(999999999999999l));
                srHaitoukinMeisaiListSubDataSourceBeanList.add(srHaitoukinMeisaiListSubDataSourceBean);
            }

            SrHaitoukinMeisaiListDataSourceBean srHaitoukinMeisaiListDataSourceBean = new SrHaitoukinMeisaiListDataSourceBean();
            srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("ＷＷＷＷ");
            srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("ＷＷＷＷ");
            srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("ww");
            srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDataSourceBeanList);
            dataSouceList.add(srHaitoukinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, srHaitoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    public void testCreateReport6() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("suuri", "", "SrTmttdmeisaiListTest",C_SyoruiCdKbn.SR_TMTTDMEISAILIST);

        srHaitoukinMeisaiListBean.setIrAtesakibukanm("収納サービス室　御中");
        srHaitoukinMeisaiListBean.setIrSyoriymd("2019年 8月12日");
        srHaitoukinMeisaiListBean.setIrHozonkkn("1年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDataSourceBeanList1 = new ArrayList<SrHaitoukinMeisaiListSubDataSourceBean>();

        for (int i = 0; i < 11; i++) {

            SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDataSourceBean = new SrHaitoukinMeisaiListSubDataSourceBean();
            srHaitoukinMeisaiListSubDataSourceBean.setIrKensuu(0);
            srHaitoukinMeisaiListSubDataSourceBean.setIrHsys(BizCurrency.valueOf(0));
            srHaitoukinMeisaiListSubDataSourceBean.setIrZennendokurikosid(BizCurrency.valueOf(0));
            srHaitoukinMeisaiListSubDataSourceBean.setIrHaitoursk(BizCurrency.valueOf(0));
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendod(BizCurrency.valueOf(0));
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendomatud(BizCurrency.valueOf(0));
            srHaitoukinMeisaiListSubDataSourceBeanList1.add(srHaitoukinMeisaiListSubDataSourceBean);
        }

        SrHaitoukinMeisaiListDataSourceBean srHaitoukinMeisaiListDataSourceBean = new SrHaitoukinMeisaiListDataSourceBean();
        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("０１０４");
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("保険種類");
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("1C");
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDataSourceBeanList1);
        dataSouceList.add(srHaitoukinMeisaiListDataSourceBean);

        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDataSourceBeanList2 = new ArrayList<SrHaitoukinMeisaiListSubDataSourceBean>();

        for (int i = 0; i < 11; i++) {

            SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDataSourceBean = new SrHaitoukinMeisaiListSubDataSourceBean();
            srHaitoukinMeisaiListSubDataSourceBean.setIrKensuu(1001);
            srHaitoukinMeisaiListSubDataSourceBean.setIrHsys(BizCurrency.valueOf(2001));
            srHaitoukinMeisaiListSubDataSourceBean.setIrZennendokurikosid(BizCurrency.valueOf(2002));
            srHaitoukinMeisaiListSubDataSourceBean.setIrHaitoursk(BizCurrency.valueOf(2003));
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendod(BizCurrency.valueOf(2004));
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendomatud(BizCurrency.valueOf(2005));
            srHaitoukinMeisaiListSubDataSourceBeanList2.add(srHaitoukinMeisaiListSubDataSourceBean);
        }

        srHaitoukinMeisaiListDataSourceBean = new SrHaitoukinMeisaiListDataSourceBean();
        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("０１０４");
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("保険種類");
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("1D");
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDataSourceBeanList2);
        dataSouceList.add(srHaitoukinMeisaiListDataSourceBean);

        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDataSourceBeanList3 = new ArrayList<SrHaitoukinMeisaiListSubDataSourceBean>();

        for (int i = 0; i < 11; i++) {

            SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDataSourceBean = new SrHaitoukinMeisaiListSubDataSourceBean();
            srHaitoukinMeisaiListSubDataSourceBean.setIrKensuu(999999999);
            srHaitoukinMeisaiListSubDataSourceBean.setIrHsys(BizCurrency.valueOf(999999999999999l));
            srHaitoukinMeisaiListSubDataSourceBean.setIrZennendokurikosid(BizCurrency.valueOf(999999999999999l));
            srHaitoukinMeisaiListSubDataSourceBean.setIrHaitoursk(BizCurrency.valueOf(999999999999999l));
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendod(BizCurrency.valueOf(999999999999999l));
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendomatud(BizCurrency.valueOf(999999999999999l));
            srHaitoukinMeisaiListSubDataSourceBeanList3.add(srHaitoukinMeisaiListSubDataSourceBean);
        }

        srHaitoukinMeisaiListDataSourceBean = new SrHaitoukinMeisaiListDataSourceBean();
        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("０１０４");
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("合　計");
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("");
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDataSourceBeanList3);
        dataSouceList.add(srHaitoukinMeisaiListDataSourceBean);

        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDataSourceBeanListnull = new ArrayList<SrHaitoukinMeisaiListSubDataSourceBean>();

        for (int i = 0; i < 11; i++) {

            SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDataSourceBean = new SrHaitoukinMeisaiListSubDataSourceBean();
            srHaitoukinMeisaiListSubDataSourceBean.setIrKensuu(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrHsys(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrZennendokurikosid(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrHaitoursk(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendod(null);
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendomatud(null);
            srHaitoukinMeisaiListSubDataSourceBeanListnull.add(srHaitoukinMeisaiListSubDataSourceBean);
        }

        srHaitoukinMeisaiListDataSourceBean = new SrHaitoukinMeisaiListDataSourceBean();
        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("０１０４");
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("");
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("");
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDataSourceBeanListnull);
        dataSouceList.add(srHaitoukinMeisaiListDataSourceBean);

        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDataSourceBeanList4 = new ArrayList<SrHaitoukinMeisaiListSubDataSourceBean>();

        for (int i = 0; i < 11; i++) {

            SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDataSourceBean = new SrHaitoukinMeisaiListSubDataSourceBean();
            srHaitoukinMeisaiListSubDataSourceBean.setIrKensuu(999);
            srHaitoukinMeisaiListSubDataSourceBean.setIrHsys(BizCurrency.valueOf(999));
            srHaitoukinMeisaiListSubDataSourceBean.setIrZennendokurikosid(BizCurrency.valueOf(999));
            srHaitoukinMeisaiListSubDataSourceBean.setIrHaitoursk(BizCurrency.valueOf(999));
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendod(BizCurrency.valueOf(999));
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendomatud(BizCurrency.valueOf(999));
            srHaitoukinMeisaiListSubDataSourceBeanList4.add(srHaitoukinMeisaiListSubDataSourceBean);
        }

        srHaitoukinMeisaiListDataSourceBean = new SrHaitoukinMeisaiListDataSourceBean();
        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("３１０２");
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("保険種類");
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("1U");
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDataSourceBeanList4);
        dataSouceList.add(srHaitoukinMeisaiListDataSourceBean);

        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDataSourceBeanList5 = new ArrayList<SrHaitoukinMeisaiListSubDataSourceBean>();

        for (int i = 0; i < 11; i++) {

            SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDataSourceBean = new SrHaitoukinMeisaiListSubDataSourceBean();
            srHaitoukinMeisaiListSubDataSourceBean.setIrKensuu(9999);
            srHaitoukinMeisaiListSubDataSourceBean.setIrHsys(BizCurrency.valueOf(9999));
            srHaitoukinMeisaiListSubDataSourceBean.setIrZennendokurikosid(BizCurrency.valueOf(9999));
            srHaitoukinMeisaiListSubDataSourceBean.setIrHaitoursk(BizCurrency.valueOf(9999));
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendod(BizCurrency.valueOf(9999));
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendomatud(BizCurrency.valueOf(9999));
            srHaitoukinMeisaiListSubDataSourceBeanList5.add(srHaitoukinMeisaiListSubDataSourceBean);
        }

        srHaitoukinMeisaiListDataSourceBean = new SrHaitoukinMeisaiListDataSourceBean();
        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("３１０２");
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("合　計");
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("");
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDataSourceBeanList5);
        dataSouceList.add(srHaitoukinMeisaiListDataSourceBean);

        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDataSourceBeanList6 = new ArrayList<SrHaitoukinMeisaiListSubDataSourceBean>();

        for (int i = 0; i < 11; i++) {

            SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDataSourceBean = new SrHaitoukinMeisaiListSubDataSourceBean();
            srHaitoukinMeisaiListSubDataSourceBean.setIrKensuu(999999999);
            srHaitoukinMeisaiListSubDataSourceBean.setIrHsys(BizCurrency.valueOf(999999999999999l));
            srHaitoukinMeisaiListSubDataSourceBean.setIrZennendokurikosid(BizCurrency.valueOf(999999999999999l));
            srHaitoukinMeisaiListSubDataSourceBean.setIrHaitoursk(BizCurrency.valueOf(999999999999999l));
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendod(BizCurrency.valueOf(999999999999999l));
            srHaitoukinMeisaiListSubDataSourceBean.setIrTounendomatud(BizCurrency.valueOf(999999999999999l));
            srHaitoukinMeisaiListSubDataSourceBeanList6.add(srHaitoukinMeisaiListSubDataSourceBean);
        }

        srHaitoukinMeisaiListDataSourceBean = new SrHaitoukinMeisaiListDataSourceBean();
        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("全種合計");
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("");
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("");
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDataSourceBeanList6);
        dataSouceList.add(srHaitoukinMeisaiListDataSourceBean);

        srHaitoukinMeisaiListDataSourceBean = new SrHaitoukinMeisaiListDataSourceBean();
        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("全種合計");
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("");
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("");
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDataSourceBeanListnull);
        dataSouceList.add(srHaitoukinMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, srHaitoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
