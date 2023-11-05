package yuyu.report.sinkeiyaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SkCreditcardkaiintourokunglistDataSourceBean;
import yuyu.def.sinkeiyaku.bean.report.SkSyanailistheaderBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * クレジットカ－ド会員登録ＮＧリスト帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkCreditkaiintourokungListTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkSyanailistheaderBean skSyanailistheaderBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCreditkaiintourokungListTest", C_SyoruiCdKbn.SK_CREDITCARDKAIINTOUROKUNGLIST);

        skSyanailistheaderBean.setIrAtesakisosiki(null);
        skSyanailistheaderBean.setIrTyouhyousakuseiymd(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkCreditcardkaiintourokunglistDataSourceBean skCreditcardkaiintourokunglistDataSourceBean = new SkCreditcardkaiintourokunglistDataSourceBean();
        skCreditcardkaiintourokunglistDataSourceBean.setIrMosno(null);
        skCreditcardkaiintourokunglistDataSourceBean.setIrCreditkessaiyouno(null);
        skCreditcardkaiintourokunglistDataSourceBean.setIrCreditqrerrorcd(null);
        skCreditcardkaiintourokunglistDataSourceBean.setIrBluegateerrorcd(null);
        skCreditcardkaiintourokunglistDataSourceBean.setIrDbhanei(null);
        skCreditcardkaiintourokunglistDataSourceBean.setIrCredittrkhaneierrriyuu(null);
        dataSouceList.add(skCreditcardkaiintourokunglistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCreditkaiintourokungListTest", C_SyoruiCdKbn.SK_CREDITCARDKAIINTOUROKUNGLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkCreditcardkaiintourokunglistDataSourceBean skCreditcardkaiintourokunglistDataSourceBean = new SkCreditcardkaiintourokunglistDataSourceBean();
        skCreditcardkaiintourokunglistDataSourceBean.setIrMosno("");
        skCreditcardkaiintourokunglistDataSourceBean.setIrCreditkessaiyouno("");
        skCreditcardkaiintourokunglistDataSourceBean.setIrCreditqrerrorcd("");
        skCreditcardkaiintourokunglistDataSourceBean.setIrBluegateerrorcd("");
        skCreditcardkaiintourokunglistDataSourceBean.setIrDbhanei(null);
        skCreditcardkaiintourokunglistDataSourceBean.setIrCredittrkhaneierrriyuu("");
        dataSouceList.add(skCreditcardkaiintourokunglistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCreditkaiintourokungListTest", C_SyoruiCdKbn.SK_CREDITCARDKAIINTOUROKUNGLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("代理店契約室 御中");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("2019年10月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 14; i++) {
            SkCreditcardkaiintourokunglistDataSourceBean skCreditcardkaiintourokunglistDataSourceBean = new SkCreditcardkaiintourokunglistDataSourceBean();
            skCreditcardkaiintourokunglistDataSourceBean.setIrMosno("100120001");
            skCreditcardkaiintourokunglistDataSourceBean.setIrCreditkessaiyouno("10000000100000111111010102");
            skCreditcardkaiintourokunglistDataSourceBean.setIrCreditqrerrorcd("10010001001000");
            skCreditcardkaiintourokunglistDataSourceBean.setIrBluegateerrorcd("12345678");
            skCreditcardkaiintourokunglistDataSourceBean.setIrDbhanei(C_Dbhanei.NONE);
            skCreditcardkaiintourokunglistDataSourceBean.setIrCredittrkhaneierrriyuu("払込経路エラー　払込経路がクレジット扱以外");
            dataSouceList.add(skCreditcardkaiintourokunglistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCreditkaiintourokungListTest", C_SyoruiCdKbn.SK_CREDITCARDKAIINTOUROKUNGLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 15; i++) {
            SkCreditcardkaiintourokunglistDataSourceBean skCreditcardkaiintourokunglistDataSourceBean = new SkCreditcardkaiintourokunglistDataSourceBean();
            skCreditcardkaiintourokunglistDataSourceBean.setIrMosno("wwwwwwwww");
            skCreditcardkaiintourokunglistDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
            skCreditcardkaiintourokunglistDataSourceBean.setIrCreditqrerrorcd("wwwwwwwwwwwww");
            skCreditcardkaiintourokunglistDataSourceBean.setIrBluegateerrorcd("wwwwwwww");
            skCreditcardkaiintourokunglistDataSourceBean.setIrDbhanei(C_Dbhanei.SUMI);
            skCreditcardkaiintourokunglistDataSourceBean.setIrCredittrkhaneierrriyuu("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            dataSouceList.add(skCreditcardkaiintourokunglistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCreditkaiintourokungListTest", C_SyoruiCdKbn.SK_CREDITCARDKAIINTOUROKUNGLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("代理店契約室 御中");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("2019年10月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 16; i++) {
            SkCreditcardkaiintourokunglistDataSourceBean skCreditcardkaiintourokunglistDataSourceBean = new SkCreditcardkaiintourokunglistDataSourceBean();
            skCreditcardkaiintourokunglistDataSourceBean.setIrMosno("100120001");
            skCreditcardkaiintourokunglistDataSourceBean.setIrCreditkessaiyouno("10000000100000111111010102");
            skCreditcardkaiintourokunglistDataSourceBean.setIrCreditqrerrorcd("10010001001000");
            skCreditcardkaiintourokunglistDataSourceBean.setIrBluegateerrorcd("12345678");
            skCreditcardkaiintourokunglistDataSourceBean.setIrDbhanei(C_Dbhanei.NONE);
            skCreditcardkaiintourokunglistDataSourceBean.setIrCredittrkhaneierrriyuu("払込経路エラー　払込経路がクレジット扱以外");
            dataSouceList.add(skCreditcardkaiintourokunglistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCreditkaiintourokungListTest", C_SyoruiCdKbn.SK_CREDITCARDKAIINTOUROKUNGLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("代理店契約室 御中");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("2019年10月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 999; i++) {
            SkCreditcardkaiintourokunglistDataSourceBean skCreditcardkaiintourokunglistDataSourceBean = new SkCreditcardkaiintourokunglistDataSourceBean();
            skCreditcardkaiintourokunglistDataSourceBean.setIrMosno("100120001");
            skCreditcardkaiintourokunglistDataSourceBean.setIrCreditkessaiyouno("10000000100000111111010102");
            skCreditcardkaiintourokunglistDataSourceBean.setIrCreditqrerrorcd("10010001001000");
            skCreditcardkaiintourokunglistDataSourceBean.setIrBluegateerrorcd("12345678");
            skCreditcardkaiintourokunglistDataSourceBean.setIrDbhanei(C_Dbhanei.NONE);
            skCreditcardkaiintourokunglistDataSourceBean.setIrCredittrkhaneierrriyuu("払込経路エラー　払込経路がクレジット扱以外");
            dataSouceList.add(skCreditcardkaiintourokunglistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCreditkaiintourokungListTest", C_SyoruiCdKbn.SK_CREDITCARDKAIINTOUROKUNGLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("代理店契約室 御中");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("2019年10月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 14985; i++) {
            SkCreditcardkaiintourokunglistDataSourceBean skCreditcardkaiintourokunglistDataSourceBean = new SkCreditcardkaiintourokunglistDataSourceBean();
            skCreditcardkaiintourokunglistDataSourceBean.setIrMosno("100120001");
            skCreditcardkaiintourokunglistDataSourceBean.setIrCreditkessaiyouno("10000000100000111111010102");
            skCreditcardkaiintourokunglistDataSourceBean.setIrCreditqrerrorcd("10010001001000");
            skCreditcardkaiintourokunglistDataSourceBean.setIrBluegateerrorcd("12345678");
            skCreditcardkaiintourokunglistDataSourceBean.setIrDbhanei(C_Dbhanei.NONE);
            skCreditcardkaiintourokunglistDataSourceBean.setIrCredittrkhaneierrriyuu("払込経路エラー　払込経路がクレジット扱以外");
            dataSouceList.add(skCreditcardkaiintourokunglistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkCreditkaiintourokungListTest", C_SyoruiCdKbn.SK_CREDITCARDKAIINTOUROKUNGLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("代理店契約室 御中");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("2019年10月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

}