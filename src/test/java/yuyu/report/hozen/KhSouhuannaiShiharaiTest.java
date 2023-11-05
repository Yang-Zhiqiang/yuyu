package yuyu.report.hozen;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KykMsnKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.bean.report.KhSouhuannaiBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 支払請求書の送付案内帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhSouhuannaiShiharaiTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhSouhuannaiBean khSouhuannaiBean;

    @Inject
    private BzKokyakuAtesakiBean bzKokyakuAtesakiBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "KhSouhuannaiShiharaiTest",
                    C_SyoruiCdKbn.KK_SHIHARAI_SOUHU);

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

            khSouhuannaiBean.setIrSouhuannaimsg1("");
            khSouhuannaiBean.setIrSouhuannaimsg2("");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSouhuannaimsg4("");
            khSouhuannaiBean.setIrSouhuannaimsg5("");
            khSouhuannaiBean.setIrSouhuannaimsg6("");
            khSouhuannaiBean.setIrSouhuannaimsg7("");
            khSouhuannaiBean.setIrTyouhyoutitle("");
            khSouhuannaiBean.setIrKykymd("");
            khSouhuannaiBean.setIrSyono("");
            khSouhuannaiBean.setIrSyouhnnm("");
            khSouhuannaiBean.setIrHhknnmkj("");
            khSouhuannaiBean.setIrSyoumetuymd("");
            khSouhuannaiBean.setIrHaraimodosikngk(BizCurrency.valueOf(0));
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("");
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "KhSouhuannaiShiharaiTest",
                    C_SyoruiCdKbn.KK_SHIHARAI_SOUHU);

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

            khSouhuannaiBean.setIrSouhuannaimsg1(null);
            khSouhuannaiBean.setIrSouhuannaimsg2(null);
            khSouhuannaiBean.setIrSouhuannaimsg3(null);
            khSouhuannaiBean.setIrSouhuannaimsg4(null);
            khSouhuannaiBean.setIrSouhuannaimsg5(null);
            khSouhuannaiBean.setIrSouhuannaimsg6(null);
            khSouhuannaiBean.setIrSouhuannaimsg7(null);
            khSouhuannaiBean.setIrTyouhyoutitle(null);
            khSouhuannaiBean.setIrKykymd(null);
            khSouhuannaiBean.setIrSyono(null);
            khSouhuannaiBean.setIrSyouhnnm(null);
            khSouhuannaiBean.setIrHhknnmkj(null);
            khSouhuannaiBean.setIrSyoumetuymd(null);
            khSouhuannaiBean.setIrHaraimodosikngk(null);
            khSouhuannaiBean.setIrSyosaihkymd(null);
            khSouhuannaiBean.setIrTyouhyousakuseiymd(null);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "KhSouhuannaiShiharaiTest",
                    C_SyoruiCdKbn.KK_SHIHARAI_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("以下のご契約につきましては、保険料（円貨払込額）のお払込みがないまま保");
            khSouhuannaiBean.setIrSouhuannaimsg4("険料払込みの猶予期間を経過したため、ご契約が消滅しております。");
            khSouhuannaiBean.setIrSouhuannaimsg5("なお、ご契約には、以下のとおりお払戻金がございます。お受取りにはお手続");
            khSouhuannaiBean.setIrSouhuannaimsg6("きが必要となりますので、必要書類をお取りそろえのうえ、ご提出くださいま");
            khSouhuannaiBean.setIrSouhuannaimsg7("すようお願い申し上げます。");
            khSouhuannaiBean.setIrTyouhyoutitle("支払請求手続きのご案内");
            khSouhuannaiBean.setIrKykymd("2019年 3月 3日");
            khSouhuannaiBean.setIrSyono("10000000001");
            khSouhuannaiBean.setIrSyouhnnm("予定利率変動型５年ごと利差配当付指定通貨建個人年金保険");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名");
            khSouhuannaiBean.setIrSyoumetuymd("2019年 4月 4日");
            khSouhuannaiBean.setIrHaraimodosikngk(BizCurrency.valueOf(101));
            khSouhuannaiBean.setIrSyosaihkymd("2019年 5月 5日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("2019年 6月 6日");
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrMynosinkokutaisyouumukbn(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.SETTEI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "KhSouhuannaiShiharaiTest",
                C_SyoruiCdKbn.KK_SHIHARAI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");

        khSouhuannaiBean.setIrSouhuannaimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSouhuannaiBean.setIrSouhuannaimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSouhuannaiBean.setIrSouhuannaimsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSouhuannaiBean.setIrSouhuannaimsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSouhuannaiBean.setIrSouhuannaimsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSouhuannaiBean.setIrSouhuannaimsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSouhuannaiBean.setIrSouhuannaimsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSouhuannaiBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSouhuannaiBean.setIrKykymd("9999年99月99日");
        khSouhuannaiBean.setIrSyono("wwwwwwwwwww");
        khSouhuannaiBean.setIrSyouhnnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSouhuannaiBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSouhuannaiBean.setIrSyoumetuymd("9999年99月99日");
        khSouhuannaiBean.setIrHaraimodosikngk(BizCurrency.valueOf(9999999999L));
        khSouhuannaiBean.setIrSyosaihkymd("9999年99月99日");
        khSouhuannaiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
        khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);

        reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "KhSouhuannaiShiharaiTest",
                    C_SyoruiCdKbn.KK_SHIHARAI_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("以下のご契約につきましては、保険料（円貨払込額）のお払込みがないまま保");
            khSouhuannaiBean.setIrSouhuannaimsg3("険料払込みの猶予期間を経過したため、ご契約が消滅しております。");
            khSouhuannaiBean.setIrSouhuannaimsg4("なお、ご契約には、以下のとおりお払戻金がございます。お受取りにはお手続");
            khSouhuannaiBean.setIrSouhuannaimsg5("きが必要となりますので、必要書類をお取りそろえのうえ、ご提出くださいま");
            khSouhuannaiBean.setIrSouhuannaimsg6("すようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg7("");
            khSouhuannaiBean.setIrTyouhyoutitle("支払請求手続きのご案内");
            khSouhuannaiBean.setIrKykymd("2019年 3月 3日");
            khSouhuannaiBean.setIrSyono("10000000001");
            khSouhuannaiBean.setIrSyouhnnm("５年ごと利差配当付指定通貨建個人年金保険（一時払い）");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名");
            khSouhuannaiBean.setIrSyoumetuymd("2019年 4月 4日");
            khSouhuannaiBean.setIrHaraimodosikngk(BizCurrency.valueOf(1002));
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("2019年 6月 6日");
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "KhSouhuannaiShiharaiTest",
                    C_SyoruiCdKbn.KK_SHIHARAI_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("以下のご契約につきましては、保険料（円貨払込額）のお払込みがないまま保");
            khSouhuannaiBean.setIrSouhuannaimsg3("まま保険料払込みの猶予期間を経過したため、ご契約が消滅しております。");
            khSouhuannaiBean.setIrSouhuannaimsg4("なお、ご契約には、以下のとおりお払戻金がございます。お受取りにはお手続");
            khSouhuannaiBean.setIrSouhuannaimsg5("きが必要となりますので、必要書類をお取りそろえのうえ、ご提出くださいま");
            khSouhuannaiBean.setIrSouhuannaimsg6("すようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg7("");
            khSouhuannaiBean.setIrTyouhyoutitle("支払請求手続きのご案内");
            khSouhuannaiBean.setIrKykymd("2019年 3月 3日");
            khSouhuannaiBean.setIrSyono("10000000001");
            khSouhuannaiBean.setIrSyouhnnm("５年ごと利差配当付指定通貨建終身保険（一時払い）");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名");
            khSouhuannaiBean.setIrSyoumetuymd("2019年 4月 4日");
            khSouhuannaiBean.setIrHaraimodosikngk(BizCurrency.valueOf(1002));
            khSouhuannaiBean.setIrSyosaihkymd(null);
            khSouhuannaiBean.setIrTyouhyousakuseiymd("2019年 6月 6日");
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "KhSouhuannaiShiharaiTest",
                    C_SyoruiCdKbn.KK_SHIHARAI_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("以下のご契約につきましては、保険料（円貨払込額）のお払込みがないまま保");
            khSouhuannaiBean.setIrSouhuannaimsg3("険料払込みの猶予期間を経過したため、ご契約が消滅しております。");
            khSouhuannaiBean.setIrSouhuannaimsg4("なお、ご契約には、以下のとおりお払戻金がございます。お受取りにはお手続");
            khSouhuannaiBean.setIrSouhuannaimsg5("きが必要となりますので、必要書類をお取りそろえのうえ、ご提出くださいま");
            khSouhuannaiBean.setIrSouhuannaimsg6("すようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg7("");
            khSouhuannaiBean.setIrTyouhyoutitle("支払請求手続きのご案内");
            khSouhuannaiBean.setIrKykymd("2019年 3月 3日");
            khSouhuannaiBean.setIrSyono("10000000001");
            khSouhuannaiBean.setIrSyouhnnm("保険種類");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名");
            khSouhuannaiBean.setIrSyoumetuymd("2019年 4月 4日");
            khSouhuannaiBean.setIrHaraimodosikngk(BizCurrency.valueOf(1002));
            khSouhuannaiBean.setIrSyosaihkymd("2019年 5月 5日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("2019年 6月 6日");
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrMynosinkokutaisyouumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.SETTEI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "KhSouhuannaiShiharaiTest",
                    C_SyoruiCdKbn.KK_SHIHARAI_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("以下のご契約につきましては、保険料（円貨払込額）のお払込みがないまま保");
            khSouhuannaiBean.setIrSouhuannaimsg3("険料払込みの猶予期間を経過したため、ご契約が消滅しております。");
            khSouhuannaiBean.setIrSouhuannaimsg4("なお、ご契約には、以下のとおりお払戻金がございます。お受取りにはお手続");
            khSouhuannaiBean.setIrSouhuannaimsg5("きが必要となりますので、必要書類をお取りそろえのうえ、ご提出くださいま");
            khSouhuannaiBean.setIrSouhuannaimsg6("すようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg7("");
            khSouhuannaiBean.setIrTyouhyoutitle("支払請求手続きのご案内");
            khSouhuannaiBean.setIrKykymd("2019年 3月 3日");
            khSouhuannaiBean.setIrSyono("10000000001");
            khSouhuannaiBean.setIrSyouhnnm("保険種類");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名");
            khSouhuannaiBean.setIrSyoumetuymd("2019年 4月 4日");
            khSouhuannaiBean.setIrHaraimodosikngk(BizCurrency.valueOf(1002));
            khSouhuannaiBean.setIrSyosaihkymd("9999年99月99日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("2019年 6月 6日");
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.SEINEN);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "KhSouhuannaiShiharaiTest",
                    C_SyoruiCdKbn.KK_SHIHARAI_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("以下のご契約につきましては、保険料（円貨払込額）のお払込みがないまま保");
            khSouhuannaiBean.setIrSouhuannaimsg4("険料払込みの猶予期間を経過したため、ご契約が消滅しております。");
            khSouhuannaiBean.setIrSouhuannaimsg5("なお、ご契約には、以下のとおりお払戻金がございます。お受取りにはお手続");
            khSouhuannaiBean.setIrSouhuannaimsg6("きが必要となりますので、必要書類をお取りそろえのうえ、ご提出くださいま");
            khSouhuannaiBean.setIrSouhuannaimsg7("すようお願い申し上げます。");
            khSouhuannaiBean.setIrTyouhyoutitle("支払請求手続きのご案内");
            khSouhuannaiBean.setIrKykymd("2019年 3月 3日");
            khSouhuannaiBean.setIrSyono("10000000001");
            khSouhuannaiBean.setIrSyouhnnm("予定利率変動型５年ごと利差配当付指定通貨建個人年金保険");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名");
            khSouhuannaiBean.setIrSyoumetuymd("2019年 4月 4日");
            khSouhuannaiBean.setIrHaraimodosikngk(BizCurrency.valueOf(101));
            khSouhuannaiBean.setIrSyosaihkymd("2019年 5月 5日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("2019年 6月 6日");
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrMynosinkokutaisyouumukbn(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.SETTEI);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.AUD);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "KhSouhuannaiShiharaiTest",
                    C_SyoruiCdKbn.KK_SHIHARAI_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1950000");
            bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
            bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＡＢＣマンション");
            bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("代理店契約室");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("以下のご契約につきましては、保険料のお払込みがないまま保険料払込みの猶");
            khSouhuannaiBean.setIrSouhuannaimsg3("予期間を経過したため、ご契約が消滅しております。");
            khSouhuannaiBean.setIrSouhuannaimsg4("なお、ご契約には、以下のとおりお払戻金がございます。お受取りにはお手続");
            khSouhuannaiBean.setIrSouhuannaimsg5("きが必要となりますので、必要書類をお取りそろえのうえ、ご提出くださいま");
            khSouhuannaiBean.setIrSouhuannaimsg6("すようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg7("");
            khSouhuannaiBean.setIrTyouhyoutitle("支払請求手続きのご案内");
            khSouhuannaiBean.setIrKykymd("2019年 3月 3日");
            khSouhuannaiBean.setIrSyono("10000000001");
            khSouhuannaiBean.setIrSyouhnnm("保険種類");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名");
            khSouhuannaiBean.setIrSyoumetuymd("2019年 4月 4日");
            khSouhuannaiBean.setIrHaraimodosikngk(BizCurrency.valueOf(1002));
            khSouhuannaiBean.setIrSyosaihkymd("9999年99月99日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("2019年 6月 6日");
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.SEINEN);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.JPY);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

}
