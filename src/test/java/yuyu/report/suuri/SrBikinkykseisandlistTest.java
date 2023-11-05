package yuyu.report.suuri;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.suuri.bean.report.SrBknHaitoukinMeisaiListBean;
import yuyu.def.suuri.bean.report.SrBknHaitoukinMeisaiListDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 備金契約精算Ｄ集計表帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SrBikinkykseisandlistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SrBknHaitoukinMeisaiListBean srBknHaitoukinMeisaiListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SrBikinkykseisandlistTest", C_SyoruiCdKbn.SR_BIKINKYKSEISANDLIST);

        srBknHaitoukinMeisaiListBean.setIrAtesakibukanm(null);
        srBknHaitoukinMeisaiListBean.setIrSyoriymd(null);
        srBknHaitoukinMeisaiListBean.setIrHozonkkn(null);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<IReportDataSouceBean>();
        SrBknHaitoukinMeisaiListDataSourceBean srBknHaitoukinMeisaiListDataSourceBean = new SrBknHaitoukinMeisaiListDataSourceBean();

        srBknHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrHknsyurui(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd(null);

        srBknHaitoukinMeisaiListDataSourceBean.setIrKensuusbkds(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrKensuumnk(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrKensuukaiyaku(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrKensuusikkou(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrKensuuetc(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrKensuugoukei12(null);

        srBknHaitoukinMeisaiListDataSourceBean.setIrRsksbkds(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrRskmnk(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrRskkaiyaku(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrRsksikkou(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrRsketc(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrRskgoukei(null);

        srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinsbkds(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinmnk(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinkaiyaku(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinsikkou(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinetc(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukingoukei(null);
        iReportDataSouceBeanLst.add(srBknHaitoukinMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, srBknHaitoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SrBikinkykseisandlistTest", C_SyoruiCdKbn.SR_BIKINKYKSEISANDLIST);

        srBknHaitoukinMeisaiListBean.setIrAtesakibukanm("");
        srBknHaitoukinMeisaiListBean.setIrSyoriymd("");
        srBknHaitoukinMeisaiListBean.setIrHozonkkn("");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<IReportDataSouceBean>();
        SrBknHaitoukinMeisaiListDataSourceBean srBknHaitoukinMeisaiListDataSourceBean = new SrBknHaitoukinMeisaiListDataSourceBean();

        srBknHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("");
        srBknHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("");
        srBknHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("");

        srBknHaitoukinMeisaiListDataSourceBean.setIrKensuusbkds(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrKensuumnk(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrKensuukaiyaku(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrKensuusikkou(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrKensuuetc(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrKensuugoukei12(null);

        srBknHaitoukinMeisaiListDataSourceBean.setIrRsksbkds(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrRskmnk(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrRskkaiyaku(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrRsksikkou(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrRsketc(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrRskgoukei(null);

        srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinsbkds(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinmnk(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinkaiyaku(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinsikkou(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinetc(null);
        srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukingoukei(null);
        iReportDataSouceBeanLst.add(srBknHaitoukinMeisaiListDataSourceBean);

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, srBknHaitoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SrBikinkykseisandlistTest", C_SyoruiCdKbn.SR_BIKINKYKSEISANDLIST);

        srBknHaitoukinMeisaiListBean.setIrAtesakibukanm("収納サービス室");
        srBknHaitoukinMeisaiListBean.setIrSyoriymd("2016年 1月 8日");
        srBknHaitoukinMeisaiListBean.setIrHozonkkn("99年");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 5; i++) {
            SrBknHaitoukinMeisaiListDataSourceBean srBknHaitoukinMeisaiListDataSourceBean = new SrBknHaitoukinMeisaiListDataSourceBean();

            srBknHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("０１０４");
            srBknHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("保険種類");
            srBknHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("0S");

            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuusbkds(BizNumber.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuumnk(BizNumber.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuukaiyaku(BizNumber.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuusikkou(BizNumber.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuuetc(BizNumber.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuugoukei12(BizNumber.valueOf(999));

            srBknHaitoukinMeisaiListDataSourceBean.setIrRsksbkds(BizCurrency.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean.setIrRskmnk(BizCurrency.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean.setIrRskkaiyaku(BizCurrency.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean.setIrRsksikkou(BizCurrency.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean.setIrRsketc(BizCurrency.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean.setIrRskgoukei(BizCurrency.valueOf(999));

            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinsbkds(BizCurrency.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinmnk(BizCurrency.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinkaiyaku(BizCurrency.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinsikkou(BizCurrency.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinetc(BizCurrency.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukingoukei(BizCurrency.valueOf(999));
            iReportDataSouceBeanLst.add(srBknHaitoukinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, srBknHaitoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SrBikinkykseisandlistTest", C_SyoruiCdKbn.SR_BIKINKYKSEISANDLIST);

        srBknHaitoukinMeisaiListBean.setIrAtesakibukanm("収納サービス室");
        srBknHaitoukinMeisaiListBean.setIrSyoriymd("2016年 1月 8日");
        srBknHaitoukinMeisaiListBean.setIrHozonkkn("10ヶ月");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 10; i++) {
            SrBknHaitoukinMeisaiListDataSourceBean srBknHaitoukinMeisaiListDataSourceBean = new SrBknHaitoukinMeisaiListDataSourceBean();

            srBknHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("０１０４");
            srBknHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("保険種類");
            srBknHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("0S");

            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuusbkds(BizNumber.valueOf(1001));
            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuumnk(BizNumber.valueOf(1002));
            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuukaiyaku(BizNumber.valueOf(1003));
            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuusikkou(BizNumber.valueOf(1004));
            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuuetc(BizNumber.valueOf(1005));
            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuugoukei12(BizNumber.valueOf(1006));

            srBknHaitoukinMeisaiListDataSourceBean.setIrRsksbkds(BizCurrency.valueOf(2001));
            srBknHaitoukinMeisaiListDataSourceBean.setIrRskmnk(BizCurrency.valueOf(2002));
            srBknHaitoukinMeisaiListDataSourceBean.setIrRskkaiyaku(BizCurrency.valueOf(2003));
            srBknHaitoukinMeisaiListDataSourceBean.setIrRsksikkou(BizCurrency.valueOf(2004));
            srBknHaitoukinMeisaiListDataSourceBean.setIrRsketc(BizCurrency.valueOf(2005));
            srBknHaitoukinMeisaiListDataSourceBean.setIrRskgoukei(BizCurrency.valueOf(2006));

            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinsbkds(BizCurrency.valueOf(3001));
            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinmnk(BizCurrency.valueOf(3002));
            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinkaiyaku(BizCurrency.valueOf(3003));
            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinsikkou(BizCurrency.valueOf(3004));
            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinetc(BizCurrency.valueOf(3005));
            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukingoukei(BizCurrency.valueOf(3006));
            iReportDataSouceBeanLst.add(srBknHaitoukinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, srBknHaitoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SrBikinkykseisandlistTest", C_SyoruiCdKbn.SR_BIKINKYKSEISANDLIST);

        srBknHaitoukinMeisaiListBean.setIrAtesakibukanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        srBknHaitoukinMeisaiListBean.setIrSyoriymd("9999年12月31日");
        srBknHaitoukinMeisaiListBean.setIrHozonkkn("99ヶ月");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 4995; i++) {
            SrBknHaitoukinMeisaiListDataSourceBean srBknHaitoukinMeisaiListDataSourceBean = new SrBknHaitoukinMeisaiListDataSourceBean();

            srBknHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("ＷＷＷＷ");
            srBknHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("ＷＷＷＷ");
            srBknHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("ww");

            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuusbkds(BizNumber.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuumnk(BizNumber.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuukaiyaku(BizNumber.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuusikkou(BizNumber.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuuetc(BizNumber.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuugoukei12(BizNumber.valueOf(999999999999l));

            srBknHaitoukinMeisaiListDataSourceBean.setIrRsksbkds(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean.setIrRskmnk(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean.setIrRskkaiyaku(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean.setIrRsksikkou(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean.setIrRsketc(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean.setIrRskgoukei(BizCurrency.valueOf(999999999999l));

            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinsbkds(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinmnk(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinkaiyaku(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinsikkou(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinetc(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukingoukei(BizCurrency.valueOf(999999999999l));
            iReportDataSouceBeanLst.add(srBknHaitoukinMeisaiListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, srBknHaitoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SrBikinkykseisandlistTest", C_SyoruiCdKbn.SR_BIKINKYKSEISANDLIST);

        srBknHaitoukinMeisaiListBean.setIrAtesakibukanm("収納サービス室");
        srBknHaitoukinMeisaiListBean.setIrSyoriymd("2018年 7月18日");
        srBknHaitoukinMeisaiListBean.setIrHozonkkn("1年");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 5; i++) {
            SrBknHaitoukinMeisaiListDataSourceBean srBknHaitoukinMeisaiListDataSourceBean1 = new SrBknHaitoukinMeisaiListDataSourceBean();

            srBknHaitoukinMeisaiListDataSourceBean1.setIrKbnkeirisegcd("０２０４");
            srBknHaitoukinMeisaiListDataSourceBean1.setIrHknsyurui("保険種類");
            srBknHaitoukinMeisaiListDataSourceBean1.setIrSyukeiyakusyuruicd("0S");

            srBknHaitoukinMeisaiListDataSourceBean1.setIrKensuusbkds(BizNumber.valueOf(0));
            srBknHaitoukinMeisaiListDataSourceBean1.setIrKensuumnk(BizNumber.valueOf(0));
            srBknHaitoukinMeisaiListDataSourceBean1.setIrKensuukaiyaku(BizNumber.valueOf(0));
            srBknHaitoukinMeisaiListDataSourceBean1.setIrKensuusikkou(BizNumber.valueOf(0));
            srBknHaitoukinMeisaiListDataSourceBean1.setIrKensuuetc(BizNumber.valueOf(0));
            srBknHaitoukinMeisaiListDataSourceBean1.setIrKensuugoukei12(BizNumber.valueOf(0));

            srBknHaitoukinMeisaiListDataSourceBean1.setIrRsksbkds(BizCurrency.valueOf(0));
            srBknHaitoukinMeisaiListDataSourceBean1.setIrRskmnk(BizCurrency.valueOf(0));
            srBknHaitoukinMeisaiListDataSourceBean1.setIrRskkaiyaku(BizCurrency.valueOf(0));
            srBknHaitoukinMeisaiListDataSourceBean1.setIrRsksikkou(BizCurrency.valueOf(0));
            srBknHaitoukinMeisaiListDataSourceBean1.setIrRsketc(BizCurrency.valueOf(0));
            srBknHaitoukinMeisaiListDataSourceBean1.setIrRskgoukei(BizCurrency.valueOf(0));

            srBknHaitoukinMeisaiListDataSourceBean1.setIrHaitoukinsbkds(BizCurrency.valueOf(0));
            srBknHaitoukinMeisaiListDataSourceBean1.setIrHaitoukinmnk(BizCurrency.valueOf(0));
            srBknHaitoukinMeisaiListDataSourceBean1.setIrHaitoukinkaiyaku(BizCurrency.valueOf(0));
            srBknHaitoukinMeisaiListDataSourceBean1.setIrHaitoukinsikkou(BizCurrency.valueOf(0));
            srBknHaitoukinMeisaiListDataSourceBean1.setIrHaitoukinetc(BizCurrency.valueOf(0));
            srBknHaitoukinMeisaiListDataSourceBean1.setIrHaitoukingoukei(BizCurrency.valueOf(0));
            iReportDataSouceBeanLst.add(srBknHaitoukinMeisaiListDataSourceBean1);
        }

        for (int i = 0; i < 5; i++) {
            SrBknHaitoukinMeisaiListDataSourceBean srBknHaitoukinMeisaiListDataSourceBean2 = new SrBknHaitoukinMeisaiListDataSourceBean();

            srBknHaitoukinMeisaiListDataSourceBean2.setIrKbnkeirisegcd("０２０４");
            srBknHaitoukinMeisaiListDataSourceBean2.setIrHknsyurui("保険種類");
            srBknHaitoukinMeisaiListDataSourceBean2.setIrSyukeiyakusyuruicd("0T");

            srBknHaitoukinMeisaiListDataSourceBean2.setIrKensuusbkds(BizNumber.valueOf(9009));
            srBknHaitoukinMeisaiListDataSourceBean2.setIrKensuumnk(BizNumber.valueOf(9008));
            srBknHaitoukinMeisaiListDataSourceBean2.setIrKensuukaiyaku(BizNumber.valueOf(9007));
            srBknHaitoukinMeisaiListDataSourceBean2.setIrKensuusikkou(BizNumber.valueOf(9006));
            srBknHaitoukinMeisaiListDataSourceBean2.setIrKensuuetc(BizNumber.valueOf(9005));
            srBknHaitoukinMeisaiListDataSourceBean2.setIrKensuugoukei12(BizNumber.valueOf(9004));

            srBknHaitoukinMeisaiListDataSourceBean2.setIrRsksbkds(BizCurrency.valueOf(8009));
            srBknHaitoukinMeisaiListDataSourceBean2.setIrRskmnk(BizCurrency.valueOf(8008));
            srBknHaitoukinMeisaiListDataSourceBean2.setIrRskkaiyaku(BizCurrency.valueOf(8007));
            srBknHaitoukinMeisaiListDataSourceBean2.setIrRsksikkou(BizCurrency.valueOf(8006));
            srBknHaitoukinMeisaiListDataSourceBean2.setIrRsketc(BizCurrency.valueOf(8005));
            srBknHaitoukinMeisaiListDataSourceBean2.setIrRskgoukei(BizCurrency.valueOf(8004));

            srBknHaitoukinMeisaiListDataSourceBean2.setIrHaitoukinsbkds(BizCurrency.valueOf(7009));
            srBknHaitoukinMeisaiListDataSourceBean2.setIrHaitoukinmnk(BizCurrency.valueOf(7008));
            srBknHaitoukinMeisaiListDataSourceBean2.setIrHaitoukinkaiyaku(BizCurrency.valueOf(7007));
            srBknHaitoukinMeisaiListDataSourceBean2.setIrHaitoukinsikkou(BizCurrency.valueOf(7006));
            srBknHaitoukinMeisaiListDataSourceBean2.setIrHaitoukinetc(BizCurrency.valueOf(7005));
            srBknHaitoukinMeisaiListDataSourceBean2.setIrHaitoukingoukei(BizCurrency.valueOf(7004));
            iReportDataSouceBeanLst.add(srBknHaitoukinMeisaiListDataSourceBean2);
        }

        for (int i = 0; i < 5; i++) {
            SrBknHaitoukinMeisaiListDataSourceBean srBknHaitoukinMeisaiListDataSourceBean3 = new SrBknHaitoukinMeisaiListDataSourceBean();

            srBknHaitoukinMeisaiListDataSourceBean3.setIrKbnkeirisegcd("０２０４");
            srBknHaitoukinMeisaiListDataSourceBean3.setIrHknsyurui("合計");
            srBknHaitoukinMeisaiListDataSourceBean3.setIrSyukeiyakusyuruicd(null);

            srBknHaitoukinMeisaiListDataSourceBean3.setIrKensuusbkds(BizNumber.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean3.setIrKensuumnk(BizNumber.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean3.setIrKensuukaiyaku(BizNumber.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean3.setIrKensuusikkou(BizNumber.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean3.setIrKensuuetc(BizNumber.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean3.setIrKensuugoukei12(BizNumber.valueOf(999999999999l));

            srBknHaitoukinMeisaiListDataSourceBean3.setIrRsksbkds(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean3.setIrRskmnk(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean3.setIrRskkaiyaku(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean3.setIrRsksikkou(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean3.setIrRsketc(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean3.setIrRskgoukei(BizCurrency.valueOf(999999999999l));

            srBknHaitoukinMeisaiListDataSourceBean3.setIrHaitoukinsbkds(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean3.setIrHaitoukinmnk(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean3.setIrHaitoukinkaiyaku(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean3.setIrHaitoukinsikkou(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean3.setIrHaitoukinetc(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean3.setIrHaitoukingoukei(BizCurrency.valueOf(999999999999l));
            iReportDataSouceBeanLst.add(srBknHaitoukinMeisaiListDataSourceBean3);
        }

        for (int i = 0; i < 5; i++) {
            SrBknHaitoukinMeisaiListDataSourceBean srBknHaitoukinMeisaiListDataSourceBean4 = new SrBknHaitoukinMeisaiListDataSourceBean();

            srBknHaitoukinMeisaiListDataSourceBean4.setIrKbnkeirisegcd("３１０２");
            srBknHaitoukinMeisaiListDataSourceBean4.setIrHknsyurui("保険種類");
            srBknHaitoukinMeisaiListDataSourceBean4.setIrSyukeiyakusyuruicd("0U");

            srBknHaitoukinMeisaiListDataSourceBean4.setIrKensuusbkds(BizNumber.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean4.setIrKensuumnk(BizNumber.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean4.setIrKensuukaiyaku(BizNumber.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean4.setIrKensuusikkou(BizNumber.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean4.setIrKensuuetc(BizNumber.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean4.setIrKensuugoukei12(BizNumber.valueOf(999));

            srBknHaitoukinMeisaiListDataSourceBean4.setIrRsksbkds(BizCurrency.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean4.setIrRskmnk(BizCurrency.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean4.setIrRskkaiyaku(BizCurrency.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean4.setIrRsksikkou(BizCurrency.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean4.setIrRsketc(BizCurrency.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean4.setIrRskgoukei(BizCurrency.valueOf(999));

            srBknHaitoukinMeisaiListDataSourceBean4.setIrHaitoukinsbkds(BizCurrency.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean4.setIrHaitoukinmnk(BizCurrency.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean4.setIrHaitoukinkaiyaku(BizCurrency.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean4.setIrHaitoukinsikkou(BizCurrency.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean4.setIrHaitoukinetc(BizCurrency.valueOf(999));
            srBknHaitoukinMeisaiListDataSourceBean4.setIrHaitoukingoukei(BizCurrency.valueOf(999));
            iReportDataSouceBeanLst.add(srBknHaitoukinMeisaiListDataSourceBean4);
        }

        for (int i = 0; i < 5; i++) {
            SrBknHaitoukinMeisaiListDataSourceBean srBknHaitoukinMeisaiListDataSourceBean5 = new SrBknHaitoukinMeisaiListDataSourceBean();

            srBknHaitoukinMeisaiListDataSourceBean5.setIrKbnkeirisegcd("３１０２");
            srBknHaitoukinMeisaiListDataSourceBean5.setIrHknsyurui("合計");
            srBknHaitoukinMeisaiListDataSourceBean5.setIrSyukeiyakusyuruicd(null);

            srBknHaitoukinMeisaiListDataSourceBean5.setIrKensuusbkds(BizNumber.valueOf(9999));
            srBknHaitoukinMeisaiListDataSourceBean5.setIrKensuumnk(BizNumber.valueOf(9999));
            srBknHaitoukinMeisaiListDataSourceBean5.setIrKensuukaiyaku(BizNumber.valueOf(9999));
            srBknHaitoukinMeisaiListDataSourceBean5.setIrKensuusikkou(BizNumber.valueOf(9999));
            srBknHaitoukinMeisaiListDataSourceBean5.setIrKensuuetc(BizNumber.valueOf(9999));
            srBknHaitoukinMeisaiListDataSourceBean5.setIrKensuugoukei12(BizNumber.valueOf(9999));

            srBknHaitoukinMeisaiListDataSourceBean5.setIrRsksbkds(BizCurrency.valueOf(9999));
            srBknHaitoukinMeisaiListDataSourceBean5.setIrRskmnk(BizCurrency.valueOf(9999));
            srBknHaitoukinMeisaiListDataSourceBean5.setIrRskkaiyaku(BizCurrency.valueOf(9999));
            srBknHaitoukinMeisaiListDataSourceBean5.setIrRsksikkou(BizCurrency.valueOf(9999));
            srBknHaitoukinMeisaiListDataSourceBean5.setIrRsketc(BizCurrency.valueOf(9999));
            srBknHaitoukinMeisaiListDataSourceBean5.setIrRskgoukei(BizCurrency.valueOf(9999));

            srBknHaitoukinMeisaiListDataSourceBean5.setIrHaitoukinsbkds(BizCurrency.valueOf(9999));
            srBknHaitoukinMeisaiListDataSourceBean5.setIrHaitoukinmnk(BizCurrency.valueOf(9999));
            srBknHaitoukinMeisaiListDataSourceBean5.setIrHaitoukinkaiyaku(BizCurrency.valueOf(9999));
            srBknHaitoukinMeisaiListDataSourceBean5.setIrHaitoukinsikkou(BizCurrency.valueOf(9999));
            srBknHaitoukinMeisaiListDataSourceBean5.setIrHaitoukinetc(BizCurrency.valueOf(9999));
            srBknHaitoukinMeisaiListDataSourceBean5.setIrHaitoukingoukei(BizCurrency.valueOf(9999));
            iReportDataSouceBeanLst.add(srBknHaitoukinMeisaiListDataSourceBean5);
        }

        for (int i = 0; i < 5; i++) {
            SrBknHaitoukinMeisaiListDataSourceBean srBknHaitoukinMeisaiListDataSourceBean6 = new SrBknHaitoukinMeisaiListDataSourceBean();

            srBknHaitoukinMeisaiListDataSourceBean6.setIrKbnkeirisegcd("全種合計");
            srBknHaitoukinMeisaiListDataSourceBean6.setIrHknsyurui(null);
            srBknHaitoukinMeisaiListDataSourceBean6.setIrSyukeiyakusyuruicd(null);

            srBknHaitoukinMeisaiListDataSourceBean6.setIrKensuusbkds(BizNumber.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean6.setIrKensuumnk(BizNumber.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean6.setIrKensuukaiyaku(BizNumber.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean6.setIrKensuusikkou(BizNumber.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean6.setIrKensuuetc(BizNumber.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean6.setIrKensuugoukei12(BizNumber.valueOf(999999999999l));

            srBknHaitoukinMeisaiListDataSourceBean6.setIrRsksbkds(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean6.setIrRskmnk(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean6.setIrRskkaiyaku(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean6.setIrRsksikkou(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean6.setIrRsketc(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean6.setIrRskgoukei(BizCurrency.valueOf(999999999999l));

            srBknHaitoukinMeisaiListDataSourceBean6.setIrHaitoukinsbkds(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean6.setIrHaitoukinmnk(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean6.setIrHaitoukinkaiyaku(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean6.setIrHaitoukinsikkou(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean6.setIrHaitoukinetc(BizCurrency.valueOf(999999999999l));
            srBknHaitoukinMeisaiListDataSourceBean6.setIrHaitoukingoukei(BizCurrency.valueOf(999999999999l));
            iReportDataSouceBeanLst.add(srBknHaitoukinMeisaiListDataSourceBean6);
        }

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, srBknHaitoukinMeisaiListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}