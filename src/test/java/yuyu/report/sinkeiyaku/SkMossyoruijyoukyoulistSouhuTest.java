package yuyu.report.sinkeiyaku;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzDairitenAtesakiBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込書類送付状況リスト（送付案内）帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkMossyoruijyoukyoulistSouhuTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzDairitenAtesakiBean bzDairitenAtesakiBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkMossyoruijyoukyoulistTest",
                C_SyoruiCdKbn.SK_MOSSOUHUJYOUKYOULIST_SOUHU);

        bzDairitenAtesakiBean.setIrTyouhyousakuseiymd("");
        bzDairitenAtesakiBean.setIrDrtennmkj("");
        bzDairitenAtesakiBean.setIrHknkisynm("");
        bzDairitenAtesakiBean.setIrToiawasesosiki("");
        bzDairitenAtesakiBean.setIrToiawasetantounm("");
        bzDairitenAtesakiBean.setIrToiawasetelno("");

        reportTestBean.addParamObjects(bzDairitenAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkMossyoruijyoukyoulistTest",
                C_SyoruiCdKbn.SK_MOSSOUHUJYOUKYOULIST_SOUHU);

        bzDairitenAtesakiBean.setIrTyouhyousakuseiymd(null);
        bzDairitenAtesakiBean.setIrDrtennmkj(null);
        bzDairitenAtesakiBean.setIrHknkisynm(null);
        bzDairitenAtesakiBean.setIrToiawasesosiki(null);
        bzDairitenAtesakiBean.setIrToiawasetantounm(null);
        bzDairitenAtesakiBean.setIrToiawasetelno(null);

        reportTestBean.addParamObjects(bzDairitenAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkMossyoruijyoukyoulistTest",
                C_SyoruiCdKbn.SK_MOSSOUHUJYOUKYOULIST_SOUHU);

        bzDairitenAtesakiBean.setIrTyouhyousakuseiymd("平成21年12月30日");
        bzDairitenAtesakiBean.setIrDrtennmkj("送付先代理店名");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetantounm("担当者名");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");

        reportTestBean.addParamObjects(bzDairitenAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "skcommon", "SkMossyoruijyoukyoulistTest",
                C_SyoruiCdKbn.SK_MOSSOUHUJYOUKYOULIST_SOUHU);

        bzDairitenAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwww");

        reportTestBean.addParamObjects(bzDairitenAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }
}