package yuyu.report.siharai;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.siharai.bean.report.SiShrmeisaiBean;
import yuyu.def.siharai.bean.report.SiShrmeisaiDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 支払明細書帳票テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SiSiharaiMeisaiTest extends AbstractTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SiShrmeisaiBean siShrmeisaiBean;

    @Inject
    HenkanTuuka henkanTuuka;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaiMeisaiTest", C_SyoruiCdKbn.HK_SHRMESS);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        siShrmeisaiBean.setIrTyouhyousakuseiymd("");
        siShrmeisaiBean.setIrShsyno("");
        siShrmeisaiBean.setIrShadr1kj("");
        siShrmeisaiBean.setIrShadr2kj("");
        siShrmeisaiBean.setIrShadr3kj("");
        siShrmeisaiBean.setIrShsnmkj("");
        siShrmeisaiBean.setIrToiawasesosiki("");
        siShrmeisaiBean.setIrToiawaseyno("");
        siShrmeisaiBean.setIrToiawaseadr1kj("");
        siShrmeisaiBean.setIrToiawaseadr2kj("");
        siShrmeisaiBean.setIrToiawaseadr3kj("");
        siShrmeisaiBean.setIrToiawasetelno("");
        siShrmeisaiBean.setIrSyono("");
        siShrmeisaiBean.setIrKyknmkj("");
        siShrmeisaiBean.setIrHhknnmkj("");
        siShrmeisaiBean.setIrTyakkinymd("");
        siShrmeisaiBean.setIrShrgk(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrBanknmkj("");
        siShrmeisaiBean.setIrSitennmkj("");
        siShrmeisaiBean.setIrShrtuukasyu(C_Tuukasyu.JPY);
        siShrmeisaiBean.setIrYokinknmkj("");
        siShrmeisaiBean.setIrKouzano("");
        siShrmeisaiBean.setIrKzmeiginmkn("");
        siShrmeisaiBean.setIrShrgk2(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrSynykngk(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrHtykeihi(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrKztkgk(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrItjsytkkgkhyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrKykhnkkaisuu(0);
        siShrmeisaiBean.setIrKztkgkhyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrCctelno("");
        siShrmeisaiBean.setIrKouzahyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrSaikenshrumukbn(C_UmuKbn.NONE);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean = new SiShrmeisaiDataSourceBean();

        siShrmeisaiDataSourceBean.setIrKyuuhuname("");
        siShrmeisaiDataSourceBean.setIrKyhkg(BizCurrency.valueOf(0));
        siShrmeisaiDataSourceBean.setIrShrdetailbikou("");

        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean);
        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siShrmeisaiBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaiMeisaiTest", C_SyoruiCdKbn.HK_SHRMESS);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        siShrmeisaiBean.setIrTyouhyousakuseiymd(null);
        siShrmeisaiBean.setIrShsyno(null);
        siShrmeisaiBean.setIrShadr1kj(null);
        siShrmeisaiBean.setIrShadr2kj(null);
        siShrmeisaiBean.setIrShadr3kj(null);
        siShrmeisaiBean.setIrShsnmkj(null);
        siShrmeisaiBean.setIrToiawasesosiki(null);
        siShrmeisaiBean.setIrToiawaseyno(null);
        siShrmeisaiBean.setIrToiawaseadr1kj(null);
        siShrmeisaiBean.setIrToiawaseadr2kj(null);
        siShrmeisaiBean.setIrToiawaseadr3kj(null);
        siShrmeisaiBean.setIrToiawasetelno(null);
        siShrmeisaiBean.setIrSyono(null);
        siShrmeisaiBean.setIrKyknmkj(null);
        siShrmeisaiBean.setIrHhknnmkj(null);
        siShrmeisaiBean.setIrTyakkinymd(null);
        siShrmeisaiBean.setIrShrgk(null);
        siShrmeisaiBean.setIrBanknmkj(null);
        siShrmeisaiBean.setIrSitennmkj(null);
        siShrmeisaiBean.setIrShrtuukasyu(null);
        siShrmeisaiBean.setIrYokinknmkj(null);
        siShrmeisaiBean.setIrKouzano(null);
        siShrmeisaiBean.setIrKzmeiginmkn(null);
        siShrmeisaiBean.setIrShrgk2(null);
        siShrmeisaiBean.setIrSynykngk(null);
        siShrmeisaiBean.setIrHtykeihi(null);
        siShrmeisaiBean.setIrShrkyksyahtykeihi(null);
        siShrmeisaiBean.setIrKztkgk(null);
        siShrmeisaiBean.setIrItjsytkkgkhyoujiumukbn(null);
        siShrmeisaiBean.setIrKykhnkkaisuu(null);
        siShrmeisaiBean.setIrKztkgkhyoujiumukbn(null);
        siShrmeisaiBean.setIrCctelno(null);
        siShrmeisaiBean.setIrKouzahyoujiumukbn(null);
        siShrmeisaiBean.setIrSaikenshrumukbn(null);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean = new SiShrmeisaiDataSourceBean();

        siShrmeisaiDataSourceBean.setIrKyuuhuname(null);
        siShrmeisaiDataSourceBean.setIrKyhkg(null);
        siShrmeisaiDataSourceBean.setIrShrdetailbikou(null);

        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean);

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siShrmeisaiBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaiMeisaiTest", C_SyoruiCdKbn.HK_SHRMESS);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        siShrmeisaiBean.setIrTyouhyousakuseiymd("2014年12月26日");
        siShrmeisaiBean.setIrShsyno("1950000");
        siShrmeisaiBean.setIrShadr1kj("大阪市中央区");
        siShrmeisaiBean.setIrShadr2kj("新栄町１－４－３４");
        siShrmeisaiBean.setIrShadr3kj("ABCマンション");
        siShrmeisaiBean.setIrShsnmkj("新契約　太郎");
        siShrmeisaiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        siShrmeisaiBean.setIrToiawaseyno("540-8512");
        siShrmeisaiBean.setIrToiawaseadr1kj("１－４－３５");
        siShrmeisaiBean.setIrToiawaseadr2kj("住友生命保険相互会社");
        siShrmeisaiBean.setIrToiawaseadr3kj("代理店契約室");
        siShrmeisaiBean.setIrToiawasetelno("1206-6937-1136");
        siShrmeisaiBean.setIrSyono("11807111118");
        siShrmeisaiBean.setIrKyknmkj("新契約　太郎１");
        siShrmeisaiBean.setIrHhknnmkj("新契約　太郎２");
        siShrmeisaiBean.setIrShrgk(BizCurrency.valueOf(123456789,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiBean.setIrTyakkinymd("２０１４年１２月２９日");
        siShrmeisaiBean.setIrBanknmkj("銀行名");
        siShrmeisaiBean.setIrSitennmkj("支店名");
        siShrmeisaiBean.setIrShrtuukasyu(C_Tuukasyu.USD);
        siShrmeisaiBean.setIrYokinknmkj("普通預金");
        siShrmeisaiBean.setIrKouzano("12345*******");
        siShrmeisaiBean.setIrKzmeiginmkn("スミセイ");
        siShrmeisaiBean.setIrShrgk2(BizCurrency.valueOf(223456789,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiBean.setIrSynykngk(BizCurrency.valueOf(323456789));
        siShrmeisaiBean.setIrHtykeihi(BizCurrency.valueOf(423456789));
        siShrmeisaiBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(523456789));
        siShrmeisaiBean.setIrKztkgk(BizCurrency.valueOf(4444444444444L));
        siShrmeisaiBean.setIrItjsytkkgkhyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrKykhnkkaisuu(0);
        siShrmeisaiBean.setIrKztkgkhyoujiumukbn(C_UmuKbn.ARI);
        siShrmeisaiBean.setIrCctelno("０１２０-５０６-０８１");
        siShrmeisaiBean.setIrKouzahyoujiumukbn(C_UmuKbn.ARI);
        siShrmeisaiBean.setIrSaikenshrumukbn(C_UmuKbn.NONE);


        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean = new SiShrmeisaiDataSourceBean();

        siShrmeisaiDataSourceBean.setIrKyuuhuname("死亡保険金");
        siShrmeisaiDataSourceBean.setIrKyhkg(BizCurrency.valueOf(7234567.89,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean.setIrShrdetailbikou("死亡日");

        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean);

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siShrmeisaiBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaiMeisaiTest", C_SyoruiCdKbn.HK_SHRMESS);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        siShrmeisaiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        siShrmeisaiBean.setIrShsyno("9999999");
        siShrmeisaiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiBean.setIrToiawaseyno("999-9999");
        siShrmeisaiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        siShrmeisaiBean.setIrSyono("ＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiBean.setIrTyakkinymd("９９９９年９９月９９日");
        siShrmeisaiBean.setIrShrgk(BizCurrency.valueOf(123456789,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiBean.setIrShrtuukasyu(C_Tuukasyu.USD);
        siShrmeisaiBean.setIrYokinknmkj("ＷＷＷＷＷＷＷ");
        siShrmeisaiBean.setIrKouzano("wwwwwwwwwwww");
        siShrmeisaiBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShrmeisaiBean.setIrShrgk2(BizCurrency.valueOf(88888888888.88,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiBean.setIrSynykngk(BizCurrency.valueOf(7777777777777L));
        siShrmeisaiBean.setIrHtykeihi(BizCurrency.valueOf(6666666666666L));
        siShrmeisaiBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(5555555555555L));
        siShrmeisaiBean.setIrKztkgk(BizCurrency.valueOf(4444444444444L));
        siShrmeisaiBean.setIrItjsytkkgkhyoujiumukbn(C_UmuKbn.ARI);
        siShrmeisaiBean.setIrKykhnkkaisuu(1);
        siShrmeisaiBean.setIrKztkgkhyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrCctelno("０１２０-５０６-０８１");
        siShrmeisaiBean.setIrKouzahyoujiumukbn(C_UmuKbn.ARI);
        siShrmeisaiBean.setIrSaikenshrumukbn(C_UmuKbn.ARI);
        siShrmeisaiBean.setIrMsg1("フリーメッセージ１ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg2("フリーメッセージ２ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg3("フリーメッセージ３ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg4("フリーメッセージ４ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg5("フリーメッセージ５ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg6("フリーメッセージ６ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg7("フリーメッセージ７ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg8("フリーメッセージ８ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg9("フリーメッセージ９ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg10("フリーメッセージ１０ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg11("フリーメッセージ１１ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg12("フリーメッセージ１２ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg13("フリーメッセージ１３ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg14("フリーメッセージ１４ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg15("フリーメッセージ１５ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg16("フリーメッセージ１６ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg17("フリーメッセージ１７ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg18("フリーメッセージ１８ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg19("フリーメッセージ１９ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg20("フリーメッセージ２０ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg21("フリーメッセージ２１ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg22("フリーメッセージ２２ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg23("フリーメッセージ２３ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg24("フリーメッセージ２４ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg25("フリーメッセージ２５ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg26("フリーメッセージ２６ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg27("フリーメッセージ２７ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg28("フリーメッセージ２８ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg29("フリーメッセージ２９ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg30("フリーメッセージ３０ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg31("フリーメッセージ３１ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg32("フリーメッセージ３２ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg33("フリーメッセージ３３ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg34("フリーメッセージ３４ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg35("フリーメッセージ３５ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg36("フリーメッセージ３６ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg37("フリーメッセージ３７ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg38("フリーメッセージ３８ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg39("フリーメッセージ３９ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg40("フリーメッセージ４０ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg41("フリーメッセージ４１ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg42("フリーメッセージ４２ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg43("フリーメッセージ４３ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg44("フリーメッセージ４４ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg45("フリーメッセージ４５ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");
        siShrmeisaiBean.setIrMsg46("フリーメッセージ４６ＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮＮ");



        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean1 = new SiShrmeisaiDataSourceBean();

        siShrmeisaiDataSourceBean1.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷ０１");
        siShrmeisaiDataSourceBean1.setIrKyhkg(BizCurrency.valueOf(12345678901.01,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean1.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ０１");
        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean1);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean2 = new SiShrmeisaiDataSourceBean();
        siShrmeisaiDataSourceBean2.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷ０２");
        siShrmeisaiDataSourceBean2.setIrKyhkg(BizCurrency.valueOf(12345678902.01,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean2.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ０２");
        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean2);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean3 = new SiShrmeisaiDataSourceBean();
        siShrmeisaiDataSourceBean3.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷ０３");
        siShrmeisaiDataSourceBean3.setIrKyhkg(BizCurrency.valueOf(12345678903.01,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean3.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ０３");
        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean3);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean4 = new SiShrmeisaiDataSourceBean();
        siShrmeisaiDataSourceBean4.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷ０４");
        siShrmeisaiDataSourceBean4.setIrKyhkg(BizCurrency.valueOf(12345678904.01,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean4.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ０４");
        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean4);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean5 = new SiShrmeisaiDataSourceBean();
        siShrmeisaiDataSourceBean5.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷ０５");
        siShrmeisaiDataSourceBean5.setIrKyhkg(BizCurrency.valueOf(12345678905.01,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean5.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ０５");
        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean5);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean6 = new SiShrmeisaiDataSourceBean();
        siShrmeisaiDataSourceBean6.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷ０６");
        siShrmeisaiDataSourceBean6.setIrKyhkg(BizCurrency.valueOf(12345678906.01,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean6.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ０６");
        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean6);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean7 = new SiShrmeisaiDataSourceBean();
        siShrmeisaiDataSourceBean7.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷ０７");
        siShrmeisaiDataSourceBean7.setIrKyhkg(BizCurrency.valueOf(12345678907.01,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean7.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ０７");
        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean7);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean8 = new SiShrmeisaiDataSourceBean();
        siShrmeisaiDataSourceBean8.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷ０８");
        siShrmeisaiDataSourceBean8.setIrKyhkg(BizCurrency.valueOf(12345678908.01,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean8.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ０８");
        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean8);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean9 = new SiShrmeisaiDataSourceBean();
        siShrmeisaiDataSourceBean9.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷ０９");
        siShrmeisaiDataSourceBean9.setIrKyhkg(BizCurrency.valueOf(12345678909.01,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean9.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ０９");
        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean9);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean10 = new SiShrmeisaiDataSourceBean();
        siShrmeisaiDataSourceBean10.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷ１０");
        siShrmeisaiDataSourceBean10.setIrKyhkg(BizCurrency.valueOf(12345678910.01,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean10.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１０");
        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean10);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean11 = new SiShrmeisaiDataSourceBean();
        siShrmeisaiDataSourceBean11.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷ１１");
        siShrmeisaiDataSourceBean11.setIrKyhkg(BizCurrency.valueOf(12345678911.01,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean11.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１１");
        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean11);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean12 = new SiShrmeisaiDataSourceBean();
        siShrmeisaiDataSourceBean12.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷ１２");
        siShrmeisaiDataSourceBean12.setIrKyhkg(BizCurrency.valueOf(12345678912.01,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean12.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１２");
        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean12);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean13 = new SiShrmeisaiDataSourceBean();
        siShrmeisaiDataSourceBean13.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷ１３");
        siShrmeisaiDataSourceBean13.setIrKyhkg(BizCurrency.valueOf(12345678913.01,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean13.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１３");
        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean13);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean14 = new SiShrmeisaiDataSourceBean();
        siShrmeisaiDataSourceBean14.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷ１４");
        siShrmeisaiDataSourceBean14.setIrKyhkg(BizCurrency.valueOf(12345678914.01,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean14.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１４");
        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean14);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean15 = new SiShrmeisaiDataSourceBean();
        siShrmeisaiDataSourceBean15.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷ１５");
        siShrmeisaiDataSourceBean15.setIrKyhkg(BizCurrency.valueOf(12345678915.01,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean15.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１５");
        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean15);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean16 = new SiShrmeisaiDataSourceBean();
        siShrmeisaiDataSourceBean16.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷ１６");
        siShrmeisaiDataSourceBean16.setIrKyhkg(BizCurrency.valueOf(12345678916.01,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean16.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１６");
        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean16);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean17 = new SiShrmeisaiDataSourceBean();
        siShrmeisaiDataSourceBean17.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷ１７");
        siShrmeisaiDataSourceBean17.setIrKyhkg(BizCurrency.valueOf(12345678917.01,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean17.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１７");
        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean17);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean18 = new SiShrmeisaiDataSourceBean();
        siShrmeisaiDataSourceBean18.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷ１８");
        siShrmeisaiDataSourceBean18.setIrKyhkg(BizCurrency.valueOf(12345678918.01,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean18.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１８");
        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean18);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean19 = new SiShrmeisaiDataSourceBean();
        siShrmeisaiDataSourceBean19.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷ１９");
        siShrmeisaiDataSourceBean19.setIrKyhkg(BizCurrency.valueOf(12345678919.01,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean19.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ１９");
        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean19);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean20 = new SiShrmeisaiDataSourceBean();
        siShrmeisaiDataSourceBean20.setIrKyuuhuname("ＷＷＷＷＷＷＷＷＷＷＷ２０");
        siShrmeisaiDataSourceBean20.setIrKyhkg(BizCurrency.valueOf(12345678920.01,henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.USD)));
        siShrmeisaiDataSourceBean20.setIrShrdetailbikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ２０");
        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean20);



        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siShrmeisaiBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaiMeisaiTest", C_SyoruiCdKbn.HK_SHRMESS);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        siShrmeisaiBean.setIrTyouhyousakuseiymd("2014年12月26日");
        siShrmeisaiBean.setIrShsyno("1950000");
        siShrmeisaiBean.setIrShadr1kj("大阪市中央区");
        siShrmeisaiBean.setIrShadr2kj("新栄町１－４－３４");
        siShrmeisaiBean.setIrShadr3kj("ABCマンション");
        siShrmeisaiBean.setIrShsnmkj("新契約　太郎");
        siShrmeisaiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        siShrmeisaiBean.setIrToiawaseyno("540-8512");
        siShrmeisaiBean.setIrToiawaseadr1kj("１－４－３５");
        siShrmeisaiBean.setIrToiawaseadr2kj("住友生命保険相互会社");
        siShrmeisaiBean.setIrToiawaseadr3kj("代理店契約室");
        siShrmeisaiBean.setIrToiawasetelno("1206-6937-1136");
        siShrmeisaiBean.setIrSyono("11807111118");
        siShrmeisaiBean.setIrKyknmkj("新契約　太郎１");
        siShrmeisaiBean.setIrHhknnmkj("新契約　太郎２");
        siShrmeisaiBean.setIrShrgk(BizCurrency.valueOf(123456789));
        siShrmeisaiBean.setIrTyakkinymd("２０１４年１２月２９日");
        siShrmeisaiBean.setIrBanknmkj("銀行名");
        siShrmeisaiBean.setIrSitennmkj("支店名");
        siShrmeisaiBean.setIrShrtuukasyu(C_Tuukasyu.JPY);
        siShrmeisaiBean.setIrYokinknmkj("ＷＷＷＷＷＷＷ");
        siShrmeisaiBean.setIrKouzano("12345*******");
        siShrmeisaiBean.setIrKzmeiginmkn("スミセイ");
        siShrmeisaiBean.setIrShrgk2(BizCurrency.valueOf(223456789));
        siShrmeisaiBean.setIrSynykngk(BizCurrency.valueOf(323456789));
        siShrmeisaiBean.setIrHtykeihi(BizCurrency.valueOf(423456789));
        siShrmeisaiBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(523456789));
        siShrmeisaiBean.setIrKztkgk(BizCurrency.valueOf(623456789));
        siShrmeisaiBean.setIrItjsytkkgkhyoujiumukbn(C_UmuKbn.ARI);
        siShrmeisaiBean.setIrKykhnkkaisuu(0);
        siShrmeisaiBean.setIrKztkgkhyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrCctelno("０１２０-５０６-０８１");
        siShrmeisaiBean.setIrKouzahyoujiumukbn(C_UmuKbn.ARI);
        siShrmeisaiBean.setIrSaikenshrumukbn(C_UmuKbn.NONE);


        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean = new SiShrmeisaiDataSourceBean();

        siShrmeisaiDataSourceBean.setIrKyuuhuname("死亡保険金");
        siShrmeisaiDataSourceBean.setIrKyhkg(BizCurrency.valueOf(7234567.89));
        siShrmeisaiDataSourceBean.setIrShrdetailbikou("死亡日");

        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean);

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siShrmeisaiBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaiMeisaiTest", C_SyoruiCdKbn.HK_SHRMESS);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        siShrmeisaiBean.setIrTyouhyousakuseiymd("");
        siShrmeisaiBean.setIrShsyno("");
        siShrmeisaiBean.setIrShadr1kj("");
        siShrmeisaiBean.setIrShadr2kj("");
        siShrmeisaiBean.setIrShadr3kj("");
        siShrmeisaiBean.setIrShsnmkj("");
        siShrmeisaiBean.setIrToiawasesosiki("");
        siShrmeisaiBean.setIrToiawaseyno("");
        siShrmeisaiBean.setIrToiawaseadr1kj("");
        siShrmeisaiBean.setIrToiawaseadr2kj("");
        siShrmeisaiBean.setIrToiawaseadr3kj("");
        siShrmeisaiBean.setIrToiawasetelno("");
        siShrmeisaiBean.setIrSyono("");
        siShrmeisaiBean.setIrKyknmkj("");
        siShrmeisaiBean.setIrHhknnmkj("");
        siShrmeisaiBean.setIrTyakkinymd("");
        siShrmeisaiBean.setIrShrgk(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrBanknmkj("");
        siShrmeisaiBean.setIrSitennmkj("");
        siShrmeisaiBean.setIrShrtuukasyu(C_Tuukasyu.JPY);
        siShrmeisaiBean.setIrYokinknmkj("");
        siShrmeisaiBean.setIrKouzano("");
        siShrmeisaiBean.setIrKzmeiginmkn("");
        siShrmeisaiBean.setIrShrgk2(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrSynykngk(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrHtykeihi(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrKztkgk(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrItjsytkkgkhyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrKykhnkkaisuu(0);
        siShrmeisaiBean.setIrKztkgkhyoujiumukbn(C_UmuKbn.ARI);
        siShrmeisaiBean.setIrCctelno("");
        siShrmeisaiBean.setIrKouzahyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrSaikenshrumukbn(C_UmuKbn.NONE);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean = new SiShrmeisaiDataSourceBean();

        siShrmeisaiDataSourceBean.setIrKyuuhuname("");
        siShrmeisaiDataSourceBean.setIrKyhkg(BizCurrency.valueOf(0));
        siShrmeisaiDataSourceBean.setIrShrdetailbikou("");

        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean);
        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siShrmeisaiBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaiMeisaiTest", C_SyoruiCdKbn.HK_SHRMESS);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        siShrmeisaiBean.setIrTyouhyousakuseiymd("");
        siShrmeisaiBean.setIrShsyno("");
        siShrmeisaiBean.setIrShadr1kj("");
        siShrmeisaiBean.setIrShadr2kj("");
        siShrmeisaiBean.setIrShadr3kj("");
        siShrmeisaiBean.setIrShsnmkj("");
        siShrmeisaiBean.setIrToiawasesosiki("");
        siShrmeisaiBean.setIrToiawaseyno("");
        siShrmeisaiBean.setIrToiawaseadr1kj("");
        siShrmeisaiBean.setIrToiawaseadr2kj("");
        siShrmeisaiBean.setIrToiawaseadr3kj("");
        siShrmeisaiBean.setIrToiawasetelno("");
        siShrmeisaiBean.setIrSyono("");
        siShrmeisaiBean.setIrKyknmkj("");
        siShrmeisaiBean.setIrHhknnmkj("");
        siShrmeisaiBean.setIrTyakkinymd("");
        siShrmeisaiBean.setIrShrgk(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrBanknmkj("");
        siShrmeisaiBean.setIrSitennmkj("");
        siShrmeisaiBean.setIrShrtuukasyu(C_Tuukasyu.JPY);
        siShrmeisaiBean.setIrYokinknmkj("");
        siShrmeisaiBean.setIrKouzano("");
        siShrmeisaiBean.setIrKzmeiginmkn("");
        siShrmeisaiBean.setIrShrgk2(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrSynykngk(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrHtykeihi(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrKztkgk(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrItjsytkkgkhyoujiumukbn(C_UmuKbn.ARI);
        siShrmeisaiBean.setIrKykhnkkaisuu(1);
        siShrmeisaiBean.setIrKztkgkhyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrCctelno("");
        siShrmeisaiBean.setIrKouzahyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrSaikenshrumukbn(C_UmuKbn.NONE);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean = new SiShrmeisaiDataSourceBean();

        siShrmeisaiDataSourceBean.setIrKyuuhuname("");
        siShrmeisaiDataSourceBean.setIrKyhkg(BizCurrency.valueOf(0));
        siShrmeisaiDataSourceBean.setIrShrdetailbikou("");

        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean);
        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siShrmeisaiBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaiMeisaiTest", C_SyoruiCdKbn.HK_SHRMESS);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        siShrmeisaiBean.setIrTyouhyousakuseiymd("");
        siShrmeisaiBean.setIrShsyno("");
        siShrmeisaiBean.setIrShadr1kj("");
        siShrmeisaiBean.setIrShadr2kj("");
        siShrmeisaiBean.setIrShadr3kj("");
        siShrmeisaiBean.setIrShsnmkj("");
        siShrmeisaiBean.setIrToiawasesosiki("");
        siShrmeisaiBean.setIrToiawaseyno("");
        siShrmeisaiBean.setIrToiawaseadr1kj("");
        siShrmeisaiBean.setIrToiawaseadr2kj("");
        siShrmeisaiBean.setIrToiawaseadr3kj("");
        siShrmeisaiBean.setIrToiawasetelno("");
        siShrmeisaiBean.setIrSyono("");
        siShrmeisaiBean.setIrKyknmkj("");
        siShrmeisaiBean.setIrHhknnmkj("");
        siShrmeisaiBean.setIrTyakkinymd("");
        siShrmeisaiBean.setIrShrgk(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrBanknmkj("");
        siShrmeisaiBean.setIrSitennmkj("");
        siShrmeisaiBean.setIrShrtuukasyu(C_Tuukasyu.JPY);
        siShrmeisaiBean.setIrYokinknmkj("");
        siShrmeisaiBean.setIrKouzano("");
        siShrmeisaiBean.setIrKzmeiginmkn("");
        siShrmeisaiBean.setIrShrgk2(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrSynykngk(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrHtykeihi(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrKztkgk(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrItjsytkkgkhyoujiumukbn(C_UmuKbn.ARI);
        siShrmeisaiBean.setIrKykhnkkaisuu(0);
        siShrmeisaiBean.setIrKztkgkhyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrCctelno("");
        siShrmeisaiBean.setIrKouzahyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrSaikenshrumukbn(C_UmuKbn.NONE);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean = new SiShrmeisaiDataSourceBean();

        siShrmeisaiDataSourceBean.setIrKyuuhuname("");
        siShrmeisaiDataSourceBean.setIrKyhkg(BizCurrency.valueOf(0));
        siShrmeisaiDataSourceBean.setIrShrdetailbikou("");

        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean);
        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siShrmeisaiBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaiMeisaiTest", C_SyoruiCdKbn.HK_SHRMESS);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        siShrmeisaiBean.setIrTyouhyousakuseiymd("");
        siShrmeisaiBean.setIrShsyno("");
        siShrmeisaiBean.setIrShadr1kj("");
        siShrmeisaiBean.setIrShadr2kj("");
        siShrmeisaiBean.setIrShadr3kj("");
        siShrmeisaiBean.setIrShsnmkj("");
        siShrmeisaiBean.setIrToiawasesosiki("");
        siShrmeisaiBean.setIrToiawaseyno("");
        siShrmeisaiBean.setIrToiawaseadr1kj("");
        siShrmeisaiBean.setIrToiawaseadr2kj("");
        siShrmeisaiBean.setIrToiawaseadr3kj("");
        siShrmeisaiBean.setIrToiawasetelno("");
        siShrmeisaiBean.setIrSyono("");
        siShrmeisaiBean.setIrKyknmkj("");
        siShrmeisaiBean.setIrHhknnmkj("");
        siShrmeisaiBean.setIrTyakkinymd("");
        siShrmeisaiBean.setIrShrgk(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrBanknmkj("");
        siShrmeisaiBean.setIrSitennmkj("");
        siShrmeisaiBean.setIrShrtuukasyu(C_Tuukasyu.JPY);
        siShrmeisaiBean.setIrYokinknmkj("");
        siShrmeisaiBean.setIrKouzano("");
        siShrmeisaiBean.setIrKzmeiginmkn("");
        siShrmeisaiBean.setIrShrgk2(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrSynykngk(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrHtykeihi(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrKztkgk(null);
        siShrmeisaiBean.setIrItjsytkkgkhyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrKykhnkkaisuu(0);
        siShrmeisaiBean.setIrKztkgkhyoujiumukbn(C_UmuKbn.ARI);
        siShrmeisaiBean.setIrCctelno("");
        siShrmeisaiBean.setIrKouzahyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrSaikenshrumukbn(C_UmuKbn.NONE);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean = new SiShrmeisaiDataSourceBean();

        siShrmeisaiDataSourceBean.setIrKyuuhuname("");
        siShrmeisaiDataSourceBean.setIrKyhkg(BizCurrency.valueOf(0));
        siShrmeisaiDataSourceBean.setIrShrdetailbikou("");

        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean);
        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siShrmeisaiBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaiMeisaiTest", C_SyoruiCdKbn.HK_SHRMESS);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        siShrmeisaiBean.setIrTyouhyousakuseiymd("");
        siShrmeisaiBean.setIrShsyno("");
        siShrmeisaiBean.setIrShadr1kj("");
        siShrmeisaiBean.setIrShadr2kj("");
        siShrmeisaiBean.setIrShadr3kj("");
        siShrmeisaiBean.setIrShsnmkj("");
        siShrmeisaiBean.setIrToiawasesosiki("");
        siShrmeisaiBean.setIrToiawaseyno("");
        siShrmeisaiBean.setIrToiawaseadr1kj("");
        siShrmeisaiBean.setIrToiawaseadr2kj("");
        siShrmeisaiBean.setIrToiawaseadr3kj("");
        siShrmeisaiBean.setIrToiawasetelno("");
        siShrmeisaiBean.setIrSyono("");
        siShrmeisaiBean.setIrKyknmkj("");
        siShrmeisaiBean.setIrHhknnmkj("");
        siShrmeisaiBean.setIrTyakkinymd("");
        siShrmeisaiBean.setIrShrgk(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrBanknmkj("");
        siShrmeisaiBean.setIrSitennmkj("");
        siShrmeisaiBean.setIrShrtuukasyu(C_Tuukasyu.JPY);
        siShrmeisaiBean.setIrYokinknmkj("");
        siShrmeisaiBean.setIrKouzano("");
        siShrmeisaiBean.setIrKzmeiginmkn("");
        siShrmeisaiBean.setIrShrgk2(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrSynykngk(null);
        siShrmeisaiBean.setIrHtykeihi(null);
        siShrmeisaiBean.setIrShrkyksyahtykeihi(null);
        siShrmeisaiBean.setIrKztkgk(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrItjsytkkgkhyoujiumukbn(C_UmuKbn.ARI);
        siShrmeisaiBean.setIrKykhnkkaisuu(1);
        siShrmeisaiBean.setIrKztkgkhyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrCctelno("");
        siShrmeisaiBean.setIrKouzahyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrSaikenshrumukbn(C_UmuKbn.NONE);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean = new SiShrmeisaiDataSourceBean();

        siShrmeisaiDataSourceBean.setIrKyuuhuname("");
        siShrmeisaiDataSourceBean.setIrKyhkg(BizCurrency.valueOf(0));
        siShrmeisaiDataSourceBean.setIrShrdetailbikou("");

        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean);
        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siShrmeisaiBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiSiharaiMeisaiTest", C_SyoruiCdKbn.HK_SHRMESS);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        siShrmeisaiBean.setIrTyouhyousakuseiymd("");
        siShrmeisaiBean.setIrShsyno("");
        siShrmeisaiBean.setIrShadr1kj("");
        siShrmeisaiBean.setIrShadr2kj("");
        siShrmeisaiBean.setIrShadr3kj("");
        siShrmeisaiBean.setIrShsnmkj("");
        siShrmeisaiBean.setIrToiawasesosiki("");
        siShrmeisaiBean.setIrToiawaseyno("");
        siShrmeisaiBean.setIrToiawaseadr1kj("");
        siShrmeisaiBean.setIrToiawaseadr2kj("");
        siShrmeisaiBean.setIrToiawaseadr3kj("");
        siShrmeisaiBean.setIrToiawasetelno("");
        siShrmeisaiBean.setIrSyono("");
        siShrmeisaiBean.setIrKyknmkj("");
        siShrmeisaiBean.setIrHhknnmkj("");
        siShrmeisaiBean.setIrTyakkinymd("");
        siShrmeisaiBean.setIrShrgk(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrBanknmkj("");
        siShrmeisaiBean.setIrSitennmkj("");
        siShrmeisaiBean.setIrShrtuukasyu(C_Tuukasyu.JPY);
        siShrmeisaiBean.setIrYokinknmkj("");
        siShrmeisaiBean.setIrKouzano("");
        siShrmeisaiBean.setIrKzmeiginmkn("");
        siShrmeisaiBean.setIrShrgk2(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrSynykngk(null);
        siShrmeisaiBean.setIrHtykeihi(null);
        siShrmeisaiBean.setIrShrkyksyahtykeihi(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrKztkgk(BizCurrency.valueOf(0));
        siShrmeisaiBean.setIrItjsytkkgkhyoujiumukbn(C_UmuKbn.ARI);
        siShrmeisaiBean.setIrKykhnkkaisuu(0);
        siShrmeisaiBean.setIrKztkgkhyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrCctelno("");
        siShrmeisaiBean.setIrKouzahyoujiumukbn(C_UmuKbn.NONE);
        siShrmeisaiBean.setIrSaikenshrumukbn(C_UmuKbn.NONE);

        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean = new SiShrmeisaiDataSourceBean();

        siShrmeisaiDataSourceBean.setIrKyuuhuname("");
        siShrmeisaiDataSourceBean.setIrKyhkg(BizCurrency.valueOf(0));
        siShrmeisaiDataSourceBean.setIrShrdetailbikou("");

        iReportDataSouceBeanLst.add(siShrmeisaiDataSourceBean);
        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siShrmeisaiBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }


}