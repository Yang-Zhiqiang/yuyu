package yuyu.report.hozen;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_AzukarikinBknkessanKbn;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhAzukarikinBikinLstBean;
import yuyu.def.hozen.bean.report.KhAzukarikinBikinLstDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 預り金備金リスト 帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhAzukarikinbikinTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhAzukarikinBikinLstBean khAzukarikinBikinLstBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhAzukarikinbikinTest",
                C_SyoruiCdKbn.KK_AZUKARIKIN_BIKINLIST);

        khAzukarikinBikinLstBean.setIrTyouhyousakuseiymd("");
        khAzukarikinBikinLstBean.setIrKessannnd("");
        khAzukarikinBikinLstBean.setIrAzukarikinbknkessankbn(null);
        khAzukarikinBikinLstBean.setIrHozonkkn("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhAzukarikinBikinLstDataSourceBean khAzukarikinBikinLstDataSourceBean = new KhAzukarikinBikinLstDataSourceBean();

        khAzukarikinBikinLstDataSourceBean.setIrHknsyruilevel("");
        khAzukarikinBikinLstDataSourceBean.setIrAzukarikintuukasyu("");
        khAzukarikinBikinLstDataSourceBean.setIrKawaserate("");

        khAzukarikinBikinLstDataSourceBean.setIrSyono("");
        khAzukarikinBikinLstDataSourceBean.setIrBkncdkbn(null);
        khAzukarikinBikinLstDataSourceBean.setIrBikinkeijyouymd("");
        khAzukarikinBikinLstDataSourceBean.setIrBknjkukbn(null);
        khAzukarikinBikinLstDataSourceBean.setIrTounendgankin("");
        khAzukarikinBikinLstDataSourceBean.setIrTounendrsk("");
        khAzukarikinBikinLstDataSourceBean.setIrAzukariganrikin("");
        khAzukarikinBikinLstDataSourceBean.setIrAzukarikinhsiymd("");
        khAzukarikinBikinLstDataSourceBean.setIrAzukarikinbknkensuugoukei(BizNumber.valueOf(0));
        khAzukarikinBikinLstDataSourceBean.setIrAzukarikinbkngoukei("");

        dataSouceList.add(khAzukarikinBikinLstDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khAzukarikinBikinLstBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhAzukarikinbikinTest",
                C_SyoruiCdKbn.KK_AZUKARIKIN_BIKINLIST);

        khAzukarikinBikinLstBean.setIrTyouhyousakuseiymd(null);
        khAzukarikinBikinLstBean.setIrKessannnd(null);
        khAzukarikinBikinLstBean.setIrAzukarikinbknkessankbn(null);
        khAzukarikinBikinLstBean.setIrHozonkkn(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhAzukarikinBikinLstDataSourceBean khAzukarikinBikinLstDataSourceBean = new KhAzukarikinBikinLstDataSourceBean();

        khAzukarikinBikinLstDataSourceBean.setIrHknsyruilevel(null);
        khAzukarikinBikinLstDataSourceBean.setIrAzukarikintuukasyu(null);
        khAzukarikinBikinLstDataSourceBean.setIrKawaserate(null);

        khAzukarikinBikinLstDataSourceBean.setIrSyono(null);
        khAzukarikinBikinLstDataSourceBean.setIrBkncdkbn(null);
        khAzukarikinBikinLstDataSourceBean.setIrBikinkeijyouymd(null);
        khAzukarikinBikinLstDataSourceBean.setIrBknjkukbn(null);
        khAzukarikinBikinLstDataSourceBean.setIrTounendgankin(null);
        khAzukarikinBikinLstDataSourceBean.setIrTounendrsk(null);
        khAzukarikinBikinLstDataSourceBean.setIrAzukariganrikin(null);
        khAzukarikinBikinLstDataSourceBean.setIrAzukarikinhsiymd(null);
        khAzukarikinBikinLstDataSourceBean.setIrAzukarikinbknkensuugoukei(null);
        khAzukarikinBikinLstDataSourceBean.setIrAzukarikinbkngoukei(null);

        dataSouceList.add(khAzukarikinBikinLstDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khAzukarikinBikinLstBean);


        reportTestBean.addParamObjects(dataSouceList, khAzukarikinBikinLstBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhAzukarikinbikinTest",
                C_SyoruiCdKbn.KK_AZUKARIKIN_BIKINLIST);

        khAzukarikinBikinLstBean.setIrTyouhyousakuseiymd("2018年 2月 2日");
        khAzukarikinBikinLstBean.setIrKessannnd("2018年度");
        khAzukarikinBikinLstBean.setIrAzukarikinbknkessankbn(C_AzukarikinBknkessanKbn.KESSAN);
        khAzukarikinBikinLstBean.setIrHozonkkn("7年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhAzukarikinBikinLstDataSourceBean khAzukarikinBikinLstDataSourceBean = new KhAzukarikinBikinLstDataSourceBean();

        for (int i = 0; i < 33; i++) {

            khAzukarikinBikinLstDataSourceBean.setIrHknsyruilevel("米ドル建終身保険（一時払）（準有配）");
            khAzukarikinBikinLstDataSourceBean.setIrAzukarikintuukasyu("円");
            khAzukarikinBikinLstDataSourceBean.setIrKawaserate("0.2451");

            khAzukarikinBikinLstDataSourceBean.setIrSyono("17806000024*");
            khAzukarikinBikinLstDataSourceBean.setIrBkncdkbn(C_BkncdKbn.KAIYAKU);
            khAzukarikinBikinLstDataSourceBean.setIrBikinkeijyouymd("20180303");
            khAzukarikinBikinLstDataSourceBean.setIrBknjkukbn(C_BknJkuKbn.SINBI);
            khAzukarikinBikinLstDataSourceBean.setIrTounendgankin("2,005 円");
            khAzukarikinBikinLstDataSourceBean.setIrTounendrsk("2,006 円");
            khAzukarikinBikinLstDataSourceBean.setIrAzukariganrikin("2,007 円");
            khAzukarikinBikinLstDataSourceBean.setIrAzukarikinhsiymd("20180404");
            khAzukarikinBikinLstDataSourceBean.setIrAzukarikinbknkensuugoukei(BizNumber.valueOf(12));
            khAzukarikinBikinLstDataSourceBean.setIrAzukarikinbkngoukei("2,008 円");

            dataSouceList.add(khAzukarikinBikinLstDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khAzukarikinBikinLstBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhAzukarikinbikinTest",
                C_SyoruiCdKbn.KK_AZUKARIKIN_BIKINLIST);

        khAzukarikinBikinLstBean.setIrTyouhyousakuseiymd("9999年99月99日");
        khAzukarikinBikinLstBean.setIrKessannnd("9999年度");
        khAzukarikinBikinLstBean.setIrAzukarikinbknkessankbn(C_AzukarikinBknkessanKbn.DAI1SHNK);
        khAzukarikinBikinLstBean.setIrHozonkkn("Z9ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 34; i++) {

            KhAzukarikinBikinLstDataSourceBean khAzukarikinBikinLstDataSourceBean = new KhAzukarikinBikinLstDataSourceBean();

            khAzukarikinBikinLstDataSourceBean.setIrHknsyruilevel("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khAzukarikinBikinLstDataSourceBean.setIrAzukarikintuukasyu("ＷＷＷ");
            khAzukarikinBikinLstDataSourceBean.setIrKawaserate("999.9999");

            khAzukarikinBikinLstDataSourceBean.setIrSyono("wwwwwwwwwwww");
            khAzukarikinBikinLstDataSourceBean.setIrBkncdkbn(C_BkncdKbn.SIBOUUKETUKE);
            khAzukarikinBikinLstDataSourceBean.setIrBikinkeijyouymd("99991231");
            khAzukarikinBikinLstDataSourceBean.setIrBknjkukbn(C_BknJkuKbn.SAISAISAIBI);
            khAzukarikinBikinLstDataSourceBean.setIrTounendgankin("9,999,999,999 ＷＷＷ");
            khAzukarikinBikinLstDataSourceBean.setIrTounendrsk("9,999,999,999 ＷＷＷ");
            khAzukarikinBikinLstDataSourceBean.setIrAzukariganrikin("9,999,999,999 ＷＷＷ");
            khAzukarikinBikinLstDataSourceBean.setIrAzukarikinhsiymd("99991231");
            khAzukarikinBikinLstDataSourceBean.setIrAzukarikinbknkensuugoukei(BizNumber.valueOf(999));
            khAzukarikinBikinLstDataSourceBean.setIrAzukarikinbkngoukei("9,999,999,999 ＷＷＷ");

            dataSouceList.add(khAzukarikinBikinLstDataSourceBean);

        }
        reportTestBean.addParamObjects(dataSouceList, khAzukarikinBikinLstBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhAzukarikinbikinTest",
                C_SyoruiCdKbn.KK_AZUKARIKIN_BIKINLIST);

        khAzukarikinBikinLstBean.setIrTyouhyousakuseiymd("2018年 2月 2日");
        khAzukarikinBikinLstBean.setIrKessannnd("2018年度");
        khAzukarikinBikinLstBean.setIrAzukarikinbknkessankbn(C_AzukarikinBknkessanKbn.KESSAN);
        khAzukarikinBikinLstBean.setIrHozonkkn("7年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, khAzukarikinBikinLstBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhAzukarikinbikinTest",
                C_SyoruiCdKbn.KK_AZUKARIKIN_BIKINLIST);

        khAzukarikinBikinLstBean.setIrTyouhyousakuseiymd("9999年99月99日");
        khAzukarikinBikinLstBean.setIrKessannnd("9999年度");
        khAzukarikinBikinLstBean.setIrAzukarikinbknkessankbn(C_AzukarikinBknkessanKbn.DAI1SHNK);
        khAzukarikinBikinLstBean.setIrHozonkkn("Z9ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 35; i++) {

            KhAzukarikinBikinLstDataSourceBean khAzukarikinBikinLstDataSourceBean = new KhAzukarikinBikinLstDataSourceBean();

            khAzukarikinBikinLstDataSourceBean.setIrHknsyruilevel("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khAzukarikinBikinLstDataSourceBean.setIrAzukarikintuukasyu("ＷＷＷ");
            khAzukarikinBikinLstDataSourceBean.setIrKawaserate("999.9999");

            khAzukarikinBikinLstDataSourceBean.setIrSyono("wwwwwwwwwwww");
            khAzukarikinBikinLstDataSourceBean.setIrBkncdkbn(C_BkncdKbn.SIBOUUKETUKE);
            khAzukarikinBikinLstDataSourceBean.setIrBikinkeijyouymd("99991231");
            khAzukarikinBikinLstDataSourceBean.setIrBknjkukbn(C_BknJkuKbn.SAISAISAIBI);
            khAzukarikinBikinLstDataSourceBean.setIrTounendgankin("9,999,999,999 ＷＷＷ");
            khAzukarikinBikinLstDataSourceBean.setIrTounendrsk("9,999,999,999 ＷＷＷ");
            khAzukarikinBikinLstDataSourceBean.setIrAzukariganrikin("9,999,999,999 ＷＷＷ");
            khAzukarikinBikinLstDataSourceBean.setIrAzukarikinhsiymd("99991231");
            khAzukarikinBikinLstDataSourceBean.setIrAzukarikinbknkensuugoukei(BizNumber.valueOf(999));
            khAzukarikinBikinLstDataSourceBean.setIrAzukarikinbkngoukei("9,999,999,999 ＷＷＷ");

            dataSouceList.add(khAzukarikinBikinLstDataSourceBean);

        }
        reportTestBean.addParamObjects(dataSouceList, khAzukarikinBikinLstBean);

        createReport.exec(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhAzukarikinbikinTest",
                C_SyoruiCdKbn.KK_AZUKARIKIN_BIKINLIST);

        khAzukarikinBikinLstBean.setIrTyouhyousakuseiymd("9999年99月99日");
        khAzukarikinBikinLstBean.setIrKessannnd("9999年度");
        khAzukarikinBikinLstBean.setIrAzukarikinbknkessankbn(C_AzukarikinBknkessanKbn.DAI1SHNK);
        khAzukarikinBikinLstBean.setIrHozonkkn("Z9ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 3400; i++) {

            KhAzukarikinBikinLstDataSourceBean khAzukarikinBikinLstDataSourceBean = new KhAzukarikinBikinLstDataSourceBean();

            khAzukarikinBikinLstDataSourceBean.setIrHknsyruilevel("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khAzukarikinBikinLstDataSourceBean.setIrAzukarikintuukasyu("ＷＷＷ");
            khAzukarikinBikinLstDataSourceBean.setIrKawaserate("999.9999");

            khAzukarikinBikinLstDataSourceBean.setIrSyono("wwwwwwwwwwww");
            khAzukarikinBikinLstDataSourceBean.setIrBkncdkbn(C_BkncdKbn.SIBOUUKETUKE);
            khAzukarikinBikinLstDataSourceBean.setIrBikinkeijyouymd("99991231");
            khAzukarikinBikinLstDataSourceBean.setIrBknjkukbn(C_BknJkuKbn.SAISAISAIBI);
            khAzukarikinBikinLstDataSourceBean.setIrTounendgankin("9,999,999,999 ＷＷＷ");
            khAzukarikinBikinLstDataSourceBean.setIrTounendrsk("9,999,999,999 ＷＷＷ");
            khAzukarikinBikinLstDataSourceBean.setIrAzukariganrikin("9,999,999,999 ＷＷＷ");
            khAzukarikinBikinLstDataSourceBean.setIrAzukarikinhsiymd("99991231");
            khAzukarikinBikinLstDataSourceBean.setIrAzukarikinbknkensuugoukei(BizNumber.valueOf(999));
            khAzukarikinBikinLstDataSourceBean.setIrAzukarikinbkngoukei("9,999,999,999 ＷＷＷ");

            dataSouceList.add(khAzukarikinBikinLstDataSourceBean);

        }
        reportTestBean.addParamObjects(dataSouceList, khAzukarikinBikinLstBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhAzukarikinbikinTest",
                C_SyoruiCdKbn.KK_AZUKARIKIN_BIKINLIST);

        khAzukarikinBikinLstBean.setIrTyouhyousakuseiymd("9999年99月99日");
        khAzukarikinBikinLstBean.setIrKessannnd("9999年度");
        khAzukarikinBikinLstBean.setIrAzukarikinbknkessankbn(C_AzukarikinBknkessanKbn.DAI1SHNK);
        khAzukarikinBikinLstBean.setIrHozonkkn("Z9ヶ月");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i <34000; i++) {

            KhAzukarikinBikinLstDataSourceBean khAzukarikinBikinLstDataSourceBean = new KhAzukarikinBikinLstDataSourceBean();

            khAzukarikinBikinLstDataSourceBean.setIrHknsyruilevel("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khAzukarikinBikinLstDataSourceBean.setIrAzukarikintuukasyu("ＷＷＷ");
            khAzukarikinBikinLstDataSourceBean.setIrKawaserate("999.9999");

            khAzukarikinBikinLstDataSourceBean.setIrSyono("wwwwwwwwwwww");
            khAzukarikinBikinLstDataSourceBean.setIrBkncdkbn(C_BkncdKbn.SIBOUUKETUKE);
            khAzukarikinBikinLstDataSourceBean.setIrBikinkeijyouymd("99991231");
            khAzukarikinBikinLstDataSourceBean.setIrBknjkukbn(C_BknJkuKbn.SAISAISAIBI);
            khAzukarikinBikinLstDataSourceBean.setIrTounendgankin("9,999,999,999 ＷＷＷ");
            khAzukarikinBikinLstDataSourceBean.setIrTounendrsk("9,999,999,999 ＷＷＷ");
            khAzukarikinBikinLstDataSourceBean.setIrAzukariganrikin("9,999,999,999 ＷＷＷ");
            khAzukarikinBikinLstDataSourceBean.setIrAzukarikinhsiymd("99991231");
            khAzukarikinBikinLstDataSourceBean.setIrAzukarikinbknkensuugoukei(BizNumber.valueOf(999));
            khAzukarikinBikinLstDataSourceBean.setIrAzukarikinbkngoukei("9,999,999,999 ＷＷＷ");

            dataSouceList.add(khAzukarikinBikinLstDataSourceBean);

        }
        reportTestBean.addParamObjects(dataSouceList, khAzukarikinBikinLstBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
