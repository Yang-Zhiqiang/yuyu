package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhHrhnTtdkAnnaiBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 払変手続案内テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhhrhnttdkannaiTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzKokyakuAtesakiBean bzKokyakuAtesakiBean;

    @Inject
    private KhHrhnTtdkAnnaiBean khHrhnTtdkAnnaiBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhhrhnttdkannaiTest",
                C_SyoruiCdKbn.AS_HRHNTTDKANNAI);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(null);
        bzKokyakuAtesakiBean.setIrShsyno(null);
        bzKokyakuAtesakiBean.setIrShadr1kj(null);
        bzKokyakuAtesakiBean.setIrShadr2kj(null);
        bzKokyakuAtesakiBean.setIrShadr3kj(null);
        bzKokyakuAtesakiBean.setIrShsnmkj(null);
        bzKokyakuAtesakiBean.setIrToiawaseyno(null);
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj(null);
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj(null);
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj(null);
        bzKokyakuAtesakiBean.setIrHknkisynm(null);
        bzKokyakuAtesakiBean.setIrToiawasesosiki(null);
        bzKokyakuAtesakiBean.setIrToiawasetelno(null);

        khHrhnTtdkAnnaiBean.setIrSyono(null);
        khHrhnTtdkAnnaiBean.setIrKyknmkj(null);
        khHrhnTtdkAnnaiBean.setIrTeisyutusyorui(null);
        khHrhnTtdkAnnaiBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);

        reportTestBean.addParamObjects(khHrhnTtdkAnnaiBean, bzKokyakuAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhhrhnttdkannaiTest",
                C_SyoruiCdKbn.AS_HRHNTTDKANNAI);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("");
        bzKokyakuAtesakiBean.setIrShsyno("");
        bzKokyakuAtesakiBean.setIrShadr1kj("");
        bzKokyakuAtesakiBean.setIrShadr2kj("");
        bzKokyakuAtesakiBean.setIrShadr3kj("");
        bzKokyakuAtesakiBean.setIrShsnmkj("");
        bzKokyakuAtesakiBean.setIrToiawaseyno("");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("");
        bzKokyakuAtesakiBean.setIrHknkisynm("");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("");
        bzKokyakuAtesakiBean.setIrToiawasetelno("");

        khHrhnTtdkAnnaiBean.setIrSyono("");
        khHrhnTtdkAnnaiBean.setIrKyknmkj("");
        khHrhnTtdkAnnaiBean.setIrTeisyutusyorui("");
        khHrhnTtdkAnnaiBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);

        reportTestBean.addParamObjects(khHrhnTtdkAnnaiBean, bzKokyakuAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhhrhnttdkannaiTest",
                C_SyoruiCdKbn.AS_HRHNTTDKANNAI);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成22年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
        bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
        bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
        bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
        bzKokyakuAtesakiBean.setIrToiawaseyno("765-4321");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        khHrhnTtdkAnnaiBean.setIrSyono("11807111118");
        khHrhnTtdkAnnaiBean.setIrKyknmkj("契約者名");
        khHrhnTtdkAnnaiBean.setIrTeisyutusyorui("生命保険料口座振替申込書");
        khHrhnTtdkAnnaiBean.setIrHrkkeiro(C_Hrkkeiro.KOUHURI);

        reportTestBean.addParamObjects(khHrhnTtdkAnnaiBean, bzKokyakuAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhhrhnttdkannaiTest",
                C_SyoruiCdKbn.AS_HRHNTTDKANNAI);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("wwwwwww");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("www-wwww");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");

        khHrhnTtdkAnnaiBean.setIrSyono("wwwwwwwwwww");
        khHrhnTtdkAnnaiBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnTtdkAnnaiBean.setIrTeisyutusyorui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnTtdkAnnaiBean.setIrHrkkeiro(C_Hrkkeiro.DANTAI);

        reportTestBean.addParamObjects(khHrhnTtdkAnnaiBean, bzKokyakuAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }
    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhhrhnttdkannaiTest",
                C_SyoruiCdKbn.AS_HRHNTTDKANNAI);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("wwwwwww");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("www-wwww");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");

        khHrhnTtdkAnnaiBean.setIrSyono("wwwwwwwwwww");
        khHrhnTtdkAnnaiBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khHrhnTtdkAnnaiBean.setIrTeisyutusyorui("保険料クレジットカード扱い申込書");
        khHrhnTtdkAnnaiBean.setIrHrkkeiro(C_Hrkkeiro.CREDIT);

        reportTestBean.addParamObjects(khHrhnTtdkAnnaiBean, bzKokyakuAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }
}
