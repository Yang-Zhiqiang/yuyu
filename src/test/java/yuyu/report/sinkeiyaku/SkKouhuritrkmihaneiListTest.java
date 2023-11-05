package yuyu.report.sinkeiyaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.sinkeiyaku.bean.report.SkKouhuriUkTrkMihaneilistDataSourceBean;
import yuyu.def.sinkeiyaku.bean.report.SkSyanailistheaderBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 口座振替登録未反映リスト（申込入力未了分）帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkKouhuritrkmihaneiListTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkSyanailistheaderBean skSyanailistheaderBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKouhuritrkmihaneiListTest", C_SyoruiCdKbn.SK_KOUFURITOUROKUMIHANEILIST);

        skSyanailistheaderBean.setIrAtesakisosiki(null);
        skSyanailistheaderBean.setIrTyouhyousakuseiymd(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKouhuriUkTrkMihaneilistDataSourceBean skKouhuriUkTrkMihaneilistDataSourceBean = new SkKouhuriUkTrkMihaneilistDataSourceBean();

        skKouhuriUkTrkMihaneilistDataSourceBean.setIrKouzahrketrkymd(null);
        skKouhuriUkTrkMihaneilistDataSourceBean.setIrDatajyusinymd(null);
        skKouhuriUkTrkMihaneilistDataSourceBean.setIrMosno(null);
        skKouhuriUkTrkMihaneilistDataSourceBean.setIrOkyakusamano(null);
        skKouhuriUkTrkMihaneilistDataSourceBean.setIrKinyuucd(null);
        skKouhuriUkTrkMihaneilistDataSourceBean.setIrSitencd(null);
        skKouhuriUkTrkMihaneilistDataSourceBean.setIrYokinkbn(null);
        skKouhuriUkTrkMihaneilistDataSourceBean.setIrKouzano(null);
        skKouhuriUkTrkMihaneilistDataSourceBean.setIrKzmeiginmkn(null);

        dataSouceList.add(skKouhuriUkTrkMihaneilistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKouhuritrkmihaneiListTest", C_SyoruiCdKbn.SK_KOUFURITOUROKUMIHANEILIST);

        skSyanailistheaderBean.setIrAtesakisosiki("");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKouhuriUkTrkMihaneilistDataSourceBean skKouhuriUkTrkMihaneilistDataSourceBean = new SkKouhuriUkTrkMihaneilistDataSourceBean();

        skKouhuriUkTrkMihaneilistDataSourceBean.setIrKouzahrketrkymd("");
        skKouhuriUkTrkMihaneilistDataSourceBean.setIrDatajyusinymd("");
        skKouhuriUkTrkMihaneilistDataSourceBean.setIrMosno("");
        skKouhuriUkTrkMihaneilistDataSourceBean.setIrOkyakusamano("");
        skKouhuriUkTrkMihaneilistDataSourceBean.setIrKinyuucd("");
        skKouhuriUkTrkMihaneilistDataSourceBean.setIrSitencd("");
        skKouhuriUkTrkMihaneilistDataSourceBean.setIrYokinkbn(C_YokinKbn.BLNK);
        skKouhuriUkTrkMihaneilistDataSourceBean.setIrKouzano("");
        skKouhuriUkTrkMihaneilistDataSourceBean.setIrKzmeiginmkn("");

        dataSouceList.add(skKouhuriUkTrkMihaneilistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKouhuritrkmihaneiListTest", C_SyoruiCdKbn.SK_KOUFURITOUROKUMIHANEILIST);

        skSyanailistheaderBean.setIrAtesakisosiki("代理店契約室　御中");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("2019年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 14; i++) {

            SkKouhuriUkTrkMihaneilistDataSourceBean skKouhuriUkTrkMihaneilistDataSourceBean = new SkKouhuriUkTrkMihaneilistDataSourceBean();

            skKouhuriUkTrkMihaneilistDataSourceBean.setIrKouzahrketrkymd("20191111");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrDatajyusinymd("20191110");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrMosno("100000001");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrOkyakusamano("1234567890");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrKinyuucd("1001");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrSitencd("101");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrYokinkbn(C_YokinKbn.HUTUU);
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrKouzano("1000001");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrKzmeiginmkn("タナカタイロウ");

            dataSouceList.add(skKouhuriUkTrkMihaneilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKouhuritrkmihaneiListTest", C_SyoruiCdKbn.SK_KOUFURITOUROKUMIHANEILIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 15; i++) {

            SkKouhuriUkTrkMihaneilistDataSourceBean skKouhuriUkTrkMihaneilistDataSourceBean = new SkKouhuriUkTrkMihaneilistDataSourceBean();

            skKouhuriUkTrkMihaneilistDataSourceBean.setIrKouzahrketrkymd("99999999");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrDatajyusinymd("99999999");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrMosno("wwwwwwwww");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrOkyakusamano("wwwwwwwwww");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrKinyuucd("wwww");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrSitencd("www");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrYokinkbn(C_YokinKbn.BETUDAN);
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrKouzano("wwwwwww");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrKzmeiginmkn("wwwwwwwwwwwwwwwwwwwwwwwwwwwwww");

            dataSouceList.add(skKouhuriUkTrkMihaneilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);


        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKouhuritrkmihaneiListTest", C_SyoruiCdKbn.SK_KOUFURITOUROKUMIHANEILIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 16; i++) {

            SkKouhuriUkTrkMihaneilistDataSourceBean skKouhuriUkTrkMihaneilistDataSourceBean = new SkKouhuriUkTrkMihaneilistDataSourceBean();

            skKouhuriUkTrkMihaneilistDataSourceBean.setIrKouzahrketrkymd("99999999");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrDatajyusinymd("99999999");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrMosno("wwwwwwwww");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrOkyakusamano("wwwwwwwwww");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrKinyuucd("wwww");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrSitencd("www");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrYokinkbn(C_YokinKbn.BETUDAN);
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrKouzano("wwwwwww");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrKzmeiginmkn("wwwwwwwwwwwwwwwwwwwwwwwwwwwwww");

            dataSouceList.add(skKouhuriUkTrkMihaneilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKouhuritrkmihaneiListTest", C_SyoruiCdKbn.SK_KOUFURITOUROKUMIHANEILIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 999; i++) {

            SkKouhuriUkTrkMihaneilistDataSourceBean skKouhuriUkTrkMihaneilistDataSourceBean = new SkKouhuriUkTrkMihaneilistDataSourceBean();

            skKouhuriUkTrkMihaneilistDataSourceBean.setIrKouzahrketrkymd("99999999");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrDatajyusinymd("99999999");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrMosno("wwwwwwwww");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrOkyakusamano("wwwwwwwwww");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrKinyuucd("wwww");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrSitencd("www");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrYokinkbn(C_YokinKbn.BETUDAN);
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrKouzano("wwwwwww");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrKzmeiginmkn("wwwwwwwwwwwwwwwwwwwwwwwwwwwwww");

            dataSouceList.add(skKouhuriUkTrkMihaneilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKouhuritrkmihaneiListTest", C_SyoruiCdKbn.SK_KOUFURITOUROKUMIHANEILIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKouhuritrkmihaneiListTest", C_SyoruiCdKbn.SK_KOUFURITOUROKUMIHANEILIST);

        skSyanailistheaderBean.setIrAtesakisosiki("代理店契約室　御中");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("2019年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKouhuriUkTrkMihaneilistDataSourceBean skKouhuriUkTrkMihaneilistDataSourceBean1 = new SkKouhuriUkTrkMihaneilistDataSourceBean();
        SkKouhuriUkTrkMihaneilistDataSourceBean skKouhuriUkTrkMihaneilistDataSourceBean2 = new SkKouhuriUkTrkMihaneilistDataSourceBean();
        SkKouhuriUkTrkMihaneilistDataSourceBean skKouhuriUkTrkMihaneilistDataSourceBean3 = new SkKouhuriUkTrkMihaneilistDataSourceBean();

        skKouhuriUkTrkMihaneilistDataSourceBean1.setIrKouzahrketrkymd("20191111");
        skKouhuriUkTrkMihaneilistDataSourceBean1.setIrDatajyusinymd("20191110");
        skKouhuriUkTrkMihaneilistDataSourceBean1.setIrMosno("100000001");
        skKouhuriUkTrkMihaneilistDataSourceBean1.setIrOkyakusamano("1234567890");
        skKouhuriUkTrkMihaneilistDataSourceBean1.setIrKinyuucd("1001");
        skKouhuriUkTrkMihaneilistDataSourceBean1.setIrSitencd("101");
        skKouhuriUkTrkMihaneilistDataSourceBean1.setIrYokinkbn(C_YokinKbn.HUTUU);
        skKouhuriUkTrkMihaneilistDataSourceBean1.setIrKouzano("1000001");
        skKouhuriUkTrkMihaneilistDataSourceBean1.setIrKzmeiginmkn("ﾀﾅｶﾀｲﾛｳ");

        skKouhuriUkTrkMihaneilistDataSourceBean2.setIrKouzahrketrkymd("20191110");
        skKouhuriUkTrkMihaneilistDataSourceBean2.setIrDatajyusinymd("20191109");
        skKouhuriUkTrkMihaneilistDataSourceBean2.setIrMosno("100000002");
        skKouhuriUkTrkMihaneilistDataSourceBean2.setIrOkyakusamano("1234567891");
        skKouhuriUkTrkMihaneilistDataSourceBean2.setIrKinyuucd("1002");
        skKouhuriUkTrkMihaneilistDataSourceBean2.setIrSitencd("102");
        skKouhuriUkTrkMihaneilistDataSourceBean2.setIrYokinkbn(C_YokinKbn.HUTUU);
        skKouhuriUkTrkMihaneilistDataSourceBean2.setIrKouzano("1000002");
        skKouhuriUkTrkMihaneilistDataSourceBean2.setIrKzmeiginmkn("ﾀﾅｶﾆﾛｳ");

        skKouhuriUkTrkMihaneilistDataSourceBean3.setIrKouzahrketrkymd("20191110");
        skKouhuriUkTrkMihaneilistDataSourceBean3.setIrDatajyusinymd("20191108");
        skKouhuriUkTrkMihaneilistDataSourceBean3.setIrMosno("100000003");
        skKouhuriUkTrkMihaneilistDataSourceBean3.setIrOkyakusamano("1234567892");
        skKouhuriUkTrkMihaneilistDataSourceBean3.setIrKinyuucd("1003");
        skKouhuriUkTrkMihaneilistDataSourceBean3.setIrSitencd("103");
        skKouhuriUkTrkMihaneilistDataSourceBean3.setIrYokinkbn(C_YokinKbn.HUTUU);
        skKouhuriUkTrkMihaneilistDataSourceBean3.setIrKouzano("1000003");
        skKouhuriUkTrkMihaneilistDataSourceBean3.setIrKzmeiginmkn("ﾀﾅｶｻﾝﾛｳ");

        dataSouceList.add(skKouhuriUkTrkMihaneilistDataSourceBean1);
        dataSouceList.add(skKouhuriUkTrkMihaneilistDataSourceBean2);
        dataSouceList.add(skKouhuriUkTrkMihaneilistDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKouhuritrkmihaneiListTest", C_SyoruiCdKbn.SK_KOUFURITOUROKUMIHANEILIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 14984; i++) {

            SkKouhuriUkTrkMihaneilistDataSourceBean skKouhuriUkTrkMihaneilistDataSourceBean = new SkKouhuriUkTrkMihaneilistDataSourceBean();

            skKouhuriUkTrkMihaneilistDataSourceBean.setIrKouzahrketrkymd("99999999");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrDatajyusinymd("99999999");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrMosno("wwwwwwwww");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrOkyakusamano("wwwwwwwwww");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrKinyuucd("wwww");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrSitencd("www");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrYokinkbn(C_YokinKbn.BETUDAN);
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrKouzano("wwwwwww");
            skKouhuriUkTrkMihaneilistDataSourceBean.setIrKzmeiginmkn("wwwwwwwwwwwwwwwwwwwwwwwwwwwwww");

            dataSouceList.add(skKouhuriUkTrkMihaneilistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}