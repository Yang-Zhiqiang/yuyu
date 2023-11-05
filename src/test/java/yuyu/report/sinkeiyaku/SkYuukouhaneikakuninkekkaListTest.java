package yuyu.report.sinkeiyaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_CreditTrkjkKbn;
import yuyu.def.classification.C_CreditYuukoukakKbn;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_MossyoumetuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SkSyanailistheaderBean;
import yuyu.def.sinkeiyaku.bean.report.SkYuukouhaneikakuninkekkalistDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 有効性反映確認結果リスト帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkYuukouhaneikakuninkekkaListTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkSyanailistheaderBean skSyanailistheaderBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYuukouhaneikakninkekkaListTest", C_SyoruiCdKbn.SK_YUUKOUHANEIKAKUNINKEKKALIST);

        skSyanailistheaderBean.setIrAtesakisosiki(null);
        skSyanailistheaderBean.setIrTyouhyousakuseiymd(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkYuukouhaneikakuninkekkalistDataSourceBean skYuukouhaneikakuninkekkalistDataSourceBean = new SkYuukouhaneikakuninkekkalistDataSourceBean();

        skYuukouhaneikakuninkekkalistDataSourceBean.setIrMosno(null);
        skYuukouhaneikakuninkekkalistDataSourceBean.setIrCreditkessaiyouno(null);
        skYuukouhaneikakuninkekkalistDataSourceBean.setIrMossyoumetukbn(null);
        skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredittrkjkkbn(null);
        skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredityuukoukakkbn(null);
        skYuukouhaneikakuninkekkalistDataSourceBean.setIrDbhanei(null);
        skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredittrkhaneierrriyuu(null);

        dataSouceList.add(skYuukouhaneikakuninkekkalistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYuukouhaneikakninkekkaListTest", C_SyoruiCdKbn.SK_YUUKOUHANEIKAKUNINKEKKALIST);

        skSyanailistheaderBean.setIrAtesakisosiki("");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkYuukouhaneikakuninkekkalistDataSourceBean skYuukouhaneikakuninkekkalistDataSourceBean = new SkYuukouhaneikakuninkekkalistDataSourceBean();

        skYuukouhaneikakuninkekkalistDataSourceBean.setIrMosno("");
        skYuukouhaneikakuninkekkalistDataSourceBean.setIrCreditkessaiyouno("");
        skYuukouhaneikakuninkekkalistDataSourceBean.setIrMossyoumetukbn(C_MossyoumetuKbn.BLNK);
        skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredittrkjkkbn(C_CreditTrkjkKbn.BLNK);
        skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredityuukoukakkbn(null);
        skYuukouhaneikakuninkekkalistDataSourceBean.setIrDbhanei(null);
        skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredittrkhaneierrriyuu("");

        dataSouceList.add(skYuukouhaneikakuninkekkalistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYuukouhaneikakninkekkaListTest", C_SyoruiCdKbn.SK_YUUKOUHANEIKAKUNINKEKKALIST);

        skSyanailistheaderBean.setIrAtesakisosiki("代理店契約室　御中");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("2019年 7月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 14; i++) {

            SkYuukouhaneikakuninkekkalistDataSourceBean skYuukouhaneikakuninkekkalistDataSourceBean = new SkYuukouhaneikakuninkekkalistDataSourceBean();

            skYuukouhaneikakuninkekkalistDataSourceBean.setIrMosno("100000001");
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrCreditkessaiyouno("10000000100000111111010102");
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrMossyoumetukbn(C_MossyoumetuKbn.MIKAKUTEI);
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredittrkjkkbn(C_CreditTrkjkKbn.SUMI);
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredityuukoukakkbn(C_CreditYuukoukakKbn.NG);
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrDbhanei(C_Dbhanei.SUMI);
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredittrkhaneierrriyuu("更新エラー　申込消滅　消滅理由　申込取消");

            dataSouceList.add(skYuukouhaneikakuninkekkalistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYuukouhaneikakninkekkaListTest", C_SyoruiCdKbn.SK_YUUKOUHANEIKAKUNINKEKKALIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 15; i++) {

            SkYuukouhaneikakuninkekkalistDataSourceBean skYuukouhaneikakuninkekkalistDataSourceBean = new SkYuukouhaneikakuninkekkalistDataSourceBean();

            skYuukouhaneikakuninkekkalistDataSourceBean.setIrMosno("wwwwwwwww");
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrMossyoumetukbn(C_MossyoumetuKbn.YUUKOUKIKANKEIKA);
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredittrkjkkbn(C_CreditTrkjkKbn.NG);
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredityuukoukakkbn(C_CreditYuukoukakKbn.NG);
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrDbhanei(C_Dbhanei.NONE);
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredittrkhaneierrriyuu("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            dataSouceList.add(skYuukouhaneikakuninkekkalistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYuukouhaneikakninkekkaListTest", C_SyoruiCdKbn.SK_YUUKOUHANEIKAKUNINKEKKALIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 16; i++) {

            SkYuukouhaneikakuninkekkalistDataSourceBean skYuukouhaneikakuninkekkalistDataSourceBean = new SkYuukouhaneikakuninkekkalistDataSourceBean();

            skYuukouhaneikakuninkekkalistDataSourceBean.setIrMosno("wwwwwwwww");
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrMossyoumetukbn(C_MossyoumetuKbn.YUUKOUKIKANKEIKA);
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredittrkjkkbn(C_CreditTrkjkKbn.NG);
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredityuukoukakkbn(C_CreditYuukoukakKbn.NG);
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrDbhanei(C_Dbhanei.NONE);
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredittrkhaneierrriyuu("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            dataSouceList.add(skYuukouhaneikakuninkekkalistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYuukouhaneikakninkekkaListTest", C_SyoruiCdKbn.SK_YUUKOUHANEIKAKUNINKEKKALIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 999; i++) {

            SkYuukouhaneikakuninkekkalistDataSourceBean skYuukouhaneikakuninkekkalistDataSourceBean = new SkYuukouhaneikakuninkekkalistDataSourceBean();

            skYuukouhaneikakuninkekkalistDataSourceBean.setIrMosno("wwwwwwwww");
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrMossyoumetukbn(C_MossyoumetuKbn.YUUKOUKIKANKEIKA);
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredittrkjkkbn(C_CreditTrkjkKbn.NG);
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredityuukoukakkbn(C_CreditYuukoukakKbn.NG);
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrDbhanei(C_Dbhanei.NONE);
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredittrkhaneierrriyuu("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            dataSouceList.add(skYuukouhaneikakuninkekkalistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYuukouhaneikakninkekkaListTest", C_SyoruiCdKbn.SK_YUUKOUHANEIKAKUNINKEKKALIST);

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
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkYuukouhaneikakninkekkaListTest", C_SyoruiCdKbn.SK_YUUKOUHANEIKAKUNINKEKKALIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 14984; i++) {

            SkYuukouhaneikakuninkekkalistDataSourceBean skYuukouhaneikakuninkekkalistDataSourceBean = new SkYuukouhaneikakuninkekkalistDataSourceBean();

            skYuukouhaneikakuninkekkalistDataSourceBean.setIrMosno("wwwwwwwww");
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrCreditkessaiyouno("wwwwwwwwwwwwwwwwwwwwwwwwww");
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrMossyoumetukbn(C_MossyoumetuKbn.YUUKOUKIKANKEIKA);
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredittrkjkkbn(C_CreditTrkjkKbn.NG);
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredityuukoukakkbn(C_CreditYuukoukakKbn.NG);
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrDbhanei(C_Dbhanei.NONE);
            skYuukouhaneikakuninkekkalistDataSourceBean.setIrCredittrkhaneierrriyuu("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            dataSouceList.add(skYuukouhaneikakuninkekkalistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}