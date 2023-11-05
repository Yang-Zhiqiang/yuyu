package yuyu.report.hozen;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_AzukarikinBknkessanKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhAzukarikinLstBean;
import yuyu.def.hozen.bean.report.KhAzukarikinLstDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 預り金リスト 帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhAzukarikinTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhAzukarikinLstBean khAzukarikinLstBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhAzukarikinTest",
                C_SyoruiCdKbn.KK_AZUKARIKINLIST);

        khAzukarikinLstBean.setIrTyouhyousakuseiymd("");
        khAzukarikinLstBean.setIrKessannnd("");
        khAzukarikinLstBean.setIrAzukarikinbknkessankbn(null);
        khAzukarikinLstBean.setIrHozonkkn("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhAzukarikinLstDataSourceBean khAzukarikinLstDataSourceBean = new KhAzukarikinLstDataSourceBean();

        khAzukarikinLstDataSourceBean.setIrHknsyruilevel("");
        khAzukarikinLstDataSourceBean.setIrAzukarikintuukasyu("");
        khAzukarikinLstDataSourceBean.setIrKawaserate("");

        khAzukarikinLstDataSourceBean.setIrTndazukarikingankin("");
        khAzukarikinLstDataSourceBean.setIrTndazukarikinrsk("");
        khAzukarikinLstDataSourceBean.setIrZndazukarikingankin("");
        khAzukarikinLstDataSourceBean.setIrZndazukarikinrsk("");
        khAzukarikinLstDataSourceBean.setIrZndazukarikinshrgk("");
        khAzukarikinLstDataSourceBean.setIrZndazukarikinshrrskgk("");
        khAzukarikinLstDataSourceBean.setIrTndazukarikinshrgk("");
        khAzukarikinLstDataSourceBean.setIrTndazukarikinshrrskgk("");
        khAzukarikinLstDataSourceBean.setIrZndbknkeirskgk("");
        khAzukarikinLstDataSourceBean.setIrTndbknkeirskgk("");
        khAzukarikinLstDataSourceBean.setIrZndsyoumetumishr("");
        khAzukarikinLstDataSourceBean.setIrTndsyoumetumishr("");
        khAzukarikinLstDataSourceBean.setIrTndsyoumetuukemishr("");
        khAzukarikinLstDataSourceBean.setIrZndsyoumetuukemishr("");
        khAzukarikinLstDataSourceBean.setIrBikinshrgk("");
        khAzukarikinLstDataSourceBean.setIrTndazukarikinrsksyukei("");
        khAzukarikinLstDataSourceBean.setIrZndazukarikinrsksyukei("");

        dataSouceList.add(khAzukarikinLstDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khAzukarikinLstBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhAzukarikinTest",
                C_SyoruiCdKbn.KK_AZUKARIKINLIST);

        khAzukarikinLstBean.setIrTyouhyousakuseiymd(null);
        khAzukarikinLstBean.setIrKessannnd(null);
        khAzukarikinLstBean.setIrAzukarikinbknkessankbn(null);
        khAzukarikinLstBean.setIrHozonkkn(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhAzukarikinLstDataSourceBean khAzukarikinLstDataSourceBean = new KhAzukarikinLstDataSourceBean();

        khAzukarikinLstDataSourceBean.setIrHknsyruilevel(null);
        khAzukarikinLstDataSourceBean.setIrAzukarikintuukasyu(null);
        khAzukarikinLstDataSourceBean.setIrKawaserate(null);

        khAzukarikinLstDataSourceBean.setIrTndazukarikingankin(null);
        khAzukarikinLstDataSourceBean.setIrTndazukarikinrsk(null);
        khAzukarikinLstDataSourceBean.setIrZndazukarikingankin(null);
        khAzukarikinLstDataSourceBean.setIrZndazukarikinrsk(null);
        khAzukarikinLstDataSourceBean.setIrZndazukarikinshrgk(null);
        khAzukarikinLstDataSourceBean.setIrZndazukarikinshrrskgk(null);
        khAzukarikinLstDataSourceBean.setIrTndazukarikinshrgk(null);
        khAzukarikinLstDataSourceBean.setIrTndazukarikinshrrskgk(null);
        khAzukarikinLstDataSourceBean.setIrZndbknkeirskgk(null);
        khAzukarikinLstDataSourceBean.setIrTndbknkeirskgk(null);
        khAzukarikinLstDataSourceBean.setIrZndsyoumetumishr(null);
        khAzukarikinLstDataSourceBean.setIrTndsyoumetumishr(null);
        khAzukarikinLstDataSourceBean.setIrTndsyoumetuukemishr(null);
        khAzukarikinLstDataSourceBean.setIrZndsyoumetuukemishr(null);
        khAzukarikinLstDataSourceBean.setIrBikinshrgk(null);
        khAzukarikinLstDataSourceBean.setIrTndazukarikinrsksyukei(null);
        khAzukarikinLstDataSourceBean.setIrZndazukarikinrsksyukei(null);

        dataSouceList.add(khAzukarikinLstDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khAzukarikinLstBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhAzukarikinTest",
                C_SyoruiCdKbn.KK_AZUKARIKINLIST);

        khAzukarikinLstBean.setIrTyouhyousakuseiymd("2018年 2月 2日");
        khAzukarikinLstBean.setIrKessannnd("2018年度");
        khAzukarikinLstBean.setIrAzukarikinbknkessankbn(C_AzukarikinBknkessanKbn.KESSAN);
        khAzukarikinLstBean.setIrHozonkkn("7年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhAzukarikinLstDataSourceBean khAzukarikinLstDataSourceBean = new KhAzukarikinLstDataSourceBean();

        khAzukarikinLstDataSourceBean.setIrHknsyruilevel("米ドル建終身保険（一時払）（準有配）");
        khAzukarikinLstDataSourceBean.setIrAzukarikintuukasyu("円");
        khAzukarikinLstDataSourceBean.setIrKawaserate("0.2451");

        khAzukarikinLstDataSourceBean.setIrTndazukarikingankin("1,001 円");
        khAzukarikinLstDataSourceBean.setIrTndazukarikinrsk("1,002 円");
        khAzukarikinLstDataSourceBean.setIrZndazukarikingankin("1,003 円");
        khAzukarikinLstDataSourceBean.setIrZndazukarikinrsk("1,004 円");
        khAzukarikinLstDataSourceBean.setIrZndazukarikinshrgk("1,005 円");
        khAzukarikinLstDataSourceBean.setIrZndazukarikinshrrskgk("1,006 円");
        khAzukarikinLstDataSourceBean.setIrTndazukarikinshrgk("1,007 円");
        khAzukarikinLstDataSourceBean.setIrTndazukarikinshrrskgk("1,008 円");
        khAzukarikinLstDataSourceBean.setIrZndbknkeirskgk("1,009 円");
        khAzukarikinLstDataSourceBean.setIrTndbknkeirskgk("1,010 円");
        khAzukarikinLstDataSourceBean.setIrZndsyoumetumishr("1,011 円");
        khAzukarikinLstDataSourceBean.setIrTndsyoumetumishr("1,012 円");
        khAzukarikinLstDataSourceBean.setIrTndsyoumetuukemishr("1,013 円");
        khAzukarikinLstDataSourceBean.setIrZndsyoumetuukemishr("1,014 円");
        khAzukarikinLstDataSourceBean.setIrBikinshrgk("1,015 円");
        khAzukarikinLstDataSourceBean.setIrTndazukarikinrsksyukei("1,016 円");
        khAzukarikinLstDataSourceBean.setIrZndazukarikinrsksyukei("1,017 円");

        dataSouceList.add(khAzukarikinLstDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khAzukarikinLstBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhAzukarikinTest",
                C_SyoruiCdKbn.KK_AZUKARIKINLIST);

        khAzukarikinLstBean.setIrTyouhyousakuseiymd("9999年99月99日");
        khAzukarikinLstBean.setIrKessannnd("9999年度");
        khAzukarikinLstBean.setIrAzukarikinbknkessankbn(C_AzukarikinBknkessanKbn.DAI1SHNK);
        khAzukarikinLstBean.setIrHozonkkn("9年XXヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 2; i++) {

            KhAzukarikinLstDataSourceBean khAzukarikinLstDataSourceBean = new KhAzukarikinLstDataSourceBean();

            khAzukarikinLstDataSourceBean.setIrHknsyruilevel("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrAzukarikintuukasyu("ＷＷＷＷＷＷＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrKawaserate("999.9999 Ｗ");

            khAzukarikinLstDataSourceBean.setIrTndazukarikingankin("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndazukarikinrsk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndazukarikingankin("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndazukarikinrsk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndazukarikinshrgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndazukarikinshrrskgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndazukarikinshrgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndazukarikinshrrskgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndbknkeirskgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndbknkeirskgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndsyoumetumishr("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndsyoumetumishr("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndsyoumetuukemishr("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndsyoumetuukemishr("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrBikinshrgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndazukarikinrsksyukei("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndazukarikinrsksyukei("9,999,999,999 ＷＷＷ");

            dataSouceList.add(khAzukarikinLstDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, khAzukarikinLstBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhAzukarikinTest",
                C_SyoruiCdKbn.KK_AZUKARIKINLIST);

        khAzukarikinLstBean.setIrTyouhyousakuseiymd("2018年 2月 2日");
        khAzukarikinLstBean.setIrKessannnd("2018年度");
        khAzukarikinLstBean.setIrAzukarikinbknkessankbn(C_AzukarikinBknkessanKbn.KESSAN);
        khAzukarikinLstBean.setIrHozonkkn("7年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, khAzukarikinLstBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhAzukarikinTest",
                C_SyoruiCdKbn.KK_AZUKARIKINLIST);

        khAzukarikinLstBean.setIrTyouhyousakuseiymd("9999年99月99日");
        khAzukarikinLstBean.setIrKessannnd("9999年度");
        khAzukarikinLstBean.setIrAzukarikinbknkessankbn(C_AzukarikinBknkessanKbn.DAI1SHNK);
        khAzukarikinLstBean.setIrHozonkkn("9年XXヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 100; i++) {

            KhAzukarikinLstDataSourceBean khAzukarikinLstDataSourceBean = new KhAzukarikinLstDataSourceBean();

            khAzukarikinLstDataSourceBean.setIrHknsyruilevel("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrAzukarikintuukasyu("ＷＷＷＷＷＷＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrKawaserate("999.9999");

            khAzukarikinLstDataSourceBean.setIrTndazukarikingankin("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndazukarikinrsk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndazukarikingankin("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndazukarikinrsk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndazukarikinshrgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndazukarikinshrrskgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndazukarikinshrgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndazukarikinshrrskgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndbknkeirskgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndbknkeirskgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndsyoumetumishr("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndsyoumetumishr("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndsyoumetuukemishr("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndsyoumetuukemishr("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrBikinshrgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndazukarikinrsksyukei("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndazukarikinrsksyukei("9,999,999,999 ＷＷＷ");

            dataSouceList.add(khAzukarikinLstDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, khAzukarikinLstBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhAzukarikinTest",
                C_SyoruiCdKbn.KK_AZUKARIKINLIST);

        khAzukarikinLstBean.setIrTyouhyousakuseiymd("9999年99月99日");
        khAzukarikinLstBean.setIrKessannnd("9999年度");
        khAzukarikinLstBean.setIrAzukarikinbknkessankbn(C_AzukarikinBknkessanKbn.DAI1SHNK);
        khAzukarikinLstBean.setIrHozonkkn("9年XXヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1000; i++) {

            KhAzukarikinLstDataSourceBean khAzukarikinLstDataSourceBean = new KhAzukarikinLstDataSourceBean();

            khAzukarikinLstDataSourceBean.setIrHknsyruilevel("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrAzukarikintuukasyu("ＷＷＷＷＷＷＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrKawaserate("999.9999");

            khAzukarikinLstDataSourceBean.setIrTndazukarikingankin("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndazukarikinrsk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndazukarikingankin("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndazukarikinrsk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndazukarikinshrgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndazukarikinshrrskgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndazukarikinshrgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndazukarikinshrrskgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndbknkeirskgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndbknkeirskgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndsyoumetumishr("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndsyoumetumishr("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndsyoumetuukemishr("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndsyoumetuukemishr("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrBikinshrgk("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrTndazukarikinrsksyukei("9,999,999,999 ＷＷＷ");
            khAzukarikinLstDataSourceBean.setIrZndazukarikinrsksyukei("9,999,999,999 ＷＷＷ");

            dataSouceList.add(khAzukarikinLstDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, khAzukarikinLstBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
