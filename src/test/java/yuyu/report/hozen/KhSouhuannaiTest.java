package yuyu.report.hozen;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.classification.C_JyudkaigomaebaraiTkykhnkKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_Khhrshrjiyuu;
import yuyu.def.classification.C_KykMsnKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_MousideIkouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tmttknitenkbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.bean.report.KhSouhuannaiBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 送付案内用クラス
 */
@RunWith(OrderedRunner.class)
public class KhSouhuannaiTest {

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
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("wwwwwww");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("wwwwwww");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(ww)wwww-wwwww");

            khSouhuannaiBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrSouhuannaimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrSouhuannaimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrSouhuannaimsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrSouhuannaimsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrSouhuannaimsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrSouhuannaimsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrSyono("wwwwwwwwwww");
            khSouhuannaiBean.setIrSyouhnnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrSyosaihkymd("ＷＷ99年99月99日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SYOSAIHK_SOUHU);
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
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(null);
            bzKokyakuAtesakiBean.setIrShsyno(null);
            bzKokyakuAtesakiBean.setIrShadr1kj(null);
            bzKokyakuAtesakiBean.setIrShadr2kj(null);
            bzKokyakuAtesakiBean.setIrShadr3kj(null);
            bzKokyakuAtesakiBean.setIrShsnmkj(null);
            bzKokyakuAtesakiBean.setIrToiawasesosiki(null);
            bzKokyakuAtesakiBean.setIrToiawaseyno(null);
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj(null);
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj(null);
            bzKokyakuAtesakiBean.setIrHknkisynm(null);
            bzKokyakuAtesakiBean.setIrToiawasetelno(null);

            khSouhuannaiBean.setIrTyouhyoutitle(null);
            khSouhuannaiBean.setIrSouhuannaimsg1(null);
            khSouhuannaiBean.setIrSouhuannaimsg2(null);
            khSouhuannaiBean.setIrSouhuannaimsg3(null);
            khSouhuannaiBean.setIrSouhuannaimsg4(null);
            khSouhuannaiBean.setIrSouhuannaimsg5(null);
            khSouhuannaiBean.setIrSouhuannaimsg6(null);
            khSouhuannaiBean.setIrSyono(null);
            khSouhuannaiBean.setIrSyouhnnm(null);
            khSouhuannaiBean.setIrHhknnmkj(null);
            khSouhuannaiBean.setIrSyosaihkymd(null);
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SYOSAIHK_SOUHU);
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
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("");
            bzKokyakuAtesakiBean.setIrShsyno("");
            bzKokyakuAtesakiBean.setIrShadr1kj("");
            bzKokyakuAtesakiBean.setIrShadr2kj("");
            bzKokyakuAtesakiBean.setIrShadr3kj("");
            bzKokyakuAtesakiBean.setIrShsnmkj("");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("");
            bzKokyakuAtesakiBean.setIrToiawaseyno("");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("");
            bzKokyakuAtesakiBean.setIrHknkisynm("");
            bzKokyakuAtesakiBean.setIrToiawasetelno("");

            khSouhuannaiBean.setIrTyouhyoutitle("");
            khSouhuannaiBean.setIrSouhuannaimsg1("");
            khSouhuannaiBean.setIrSouhuannaimsg2("");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSouhuannaimsg4("");
            khSouhuannaiBean.setIrSouhuannaimsg5("");
            khSouhuannaiBean.setIrSouhuannaimsg6("");
            khSouhuannaiBean.setIrSyono("");
            khSouhuannaiBean.setIrSyouhnnm("");
            khSouhuannaiBean.setIrHhknnmkj("");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SYOSAIHK_SOUHU);
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
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrSouhuannaimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrSouhuannaimsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrSyono("wwwwwwwwwww");
            khSouhuannaiBean.setIrSyouhnnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrSyosaihkymd("ＷＷ99年99月99日");
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("このたびご訃報に接し、ご一同様にはさぞかしお力落としのことと謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前にはひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申出いただきました手続きについて、以下のとおりご案内申し上げます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.BLNK);
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

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
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("このたびご訃報に接し、ご一同様にはさぞかしお力落としのことと謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前にはひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申出いただきました手続きについて、以下のとおりご案内申し上げます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("");
            khSouhuannaiBean.setIrHhknnmkj("");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);

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
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");


            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("このたびご訃報に接し、ご一同様にはさぞかしお力落としのことと謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前にはひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申出いただきました手続きについて、以下のとおりご案内申し上げます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.SKS);

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
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");


            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名商品名商品名商品名商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.SKS);
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
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");


            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.BLNK);
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
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("");
            khSouhuannaiBean.setIrSyouhnnm("");
            khSouhuannaiBean.setIrHhknnmkj("");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
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
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono(null);
            khSouhuannaiBean.setIrSyouhnnm(null);
            khSouhuannaiBean.setIrHhknnmkj(null);
            khSouhuannaiBean.setIrSyosaihkymd(null);
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
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
    @TestOrder(120)
    @Transactional
    public void testCreateReport12() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.BLNK);
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
    @TestOrder(130)
    @Transactional
    public void testCreateReport13() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.BLNK);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.BLNK);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("減額手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("wwwwwwwwwww");
            khSouhuannaiBean.setIrSyosaihkymd("ＷＷ99年99月99日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("減額手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.BLNK);
            khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.NONE);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("減額手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("261010101");
            khSouhuannaiBean.setIrSyosaihkymd("平成 5年 9月 8日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.SEINEN);
            khSouhuannaiBean.setIrTargettkhkumu(null);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("被保険者代理特約中途付加手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("wwwwwwwwwww");
            khSouhuannaiBean.setIrSyosaihkymd("ＷＷ99年99月99日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_STDRHNK_SOUHU);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.HONNIN);
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
    @TestOrder(180)
    @Transactional
    public void testCreateReport18() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("被保険者代理特約中途付加手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_STDRHNK_SOUHU);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.BLNK);
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
    @TestOrder(190)
    @Transactional
    public void testCreateReport19() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("被保険者代理特約中途付加手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_STDRHNK_SOUHU);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.HGU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.BLNK);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("被保険者代理特約中途付加手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_STDRHNK_SOUHU);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.OYA);
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
    @TestOrder(210)
    @Transactional
    public void testCreateReport21() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("被保険者代理特約中途付加手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("11012202");
            khSouhuannaiBean.setIrSyosaihkymd("平成 8年 9月 9日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_STDRHNK_SOUHU);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.KO);
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
    @TestOrder(220)
    @Transactional
    public void testCreateReport22() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("被保険者代理特約中途付加手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_STDRHNK_SOUHU);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.SHB);
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
    @TestOrder(230)
    @Transactional
    public void testCreateReport23() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("被保険者代理特約中途付加手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono(null);
            khSouhuannaiBean.setIrSyosaihkymd(null);
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_STDRHNK_SOUHU);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.KYDSM);
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
    @TestOrder(240)
    @Transactional
    public void testCreateReport24() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("被保険者代理特約中途付加手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_STDRHNK_SOUHU);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.MAGO);
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
    @TestOrder(250)
    @Transactional
    public void testCreateReport25() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("被保険者代理特約中途付加手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_STDRHNK_SOUHU);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.KYN);
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
    @TestOrder(260)
    @Transactional
    public void testCreateReport26() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("被保険者代理特約中途付加手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_STDRHNK_SOUHU);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.HTSZN);
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
    @TestOrder(270)
    @Transactional
    public void testCreateReport27() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("被保険者代理特約中途付加手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_STDRHNK_SOUHU);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.SINTOU3);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.SEINEN);
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
    @TestOrder(280)
    @Transactional
    public void testCreateReport28() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("被保険者代理特約中途付加手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_STDRHNK_SOUHU);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.SONOTA);
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
    @TestOrder(290)
    @Transactional
    public void testCreateReport29() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("住所変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("wwwwwwwwwww");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_ADRHNK_SOUHU);
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
    @TestOrder(300)
    @Transactional
    public void testCreateReport30() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("住所変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_ADRHNK_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.BLNK);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(310)
    @Transactional
    public void testCreateReport31() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("住所変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12012011");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_ADRHNK_SOUHU);
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
    @TestOrder(320)
    @Transactional
    public void testCreateReport32() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("重度介護前払特約変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("wwwwwwwwwww");
            khSouhuannaiBean.setIrSyosaihkymd("ＷＷ99年99月99日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU);
            khSouhuannaiBean.setIrJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.HONNIN);
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
    @TestOrder(330)
    @Transactional
    public void testCreateReport33() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("重度介護前払特約変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("10111111");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 6月 5日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU);
            khSouhuannaiBean.setIrJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.HGU);
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
    @TestOrder(340)
    @Transactional
    public void testCreateReport34() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("重度介護前払特約変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 8月 8日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU);
            khSouhuannaiBean.setIrJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU);
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
    @TestOrder(350)
    @Transactional
    public void testCreateReport35() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("重度介護前払特約変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU);
            khSouhuannaiBean.setIrJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.BLNK);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(360)
    @Transactional
    public void testCreateReport36() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("重度介護前払特約変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU);
            khSouhuannaiBean.setIrJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.BLNK);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.BLNK);
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
    @TestOrder(370)
    @Transactional
    public void testCreateReport37() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("重度介護前払特約変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU);
            khSouhuannaiBean.setIrJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.OYA);
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
    @TestOrder(380)
    @Transactional
    public void testCreateReport38() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("重度介護前払特約変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU);
            khSouhuannaiBean.setIrJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.KO);
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
    @TestOrder(390)
    @Transactional
    public void testCreateReport39() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("重度介護前払特約変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono(null);
            khSouhuannaiBean.setIrSyosaihkymd(null);
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU);
            khSouhuannaiBean.setIrJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.SHB);
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
    @TestOrder(400)
    @Transactional
    public void testCreateReport40() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("重度介護前払特約変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU);
            khSouhuannaiBean.setIrJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.KYDSM);
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
    @TestOrder(410)
    @Transactional
    public void testCreateReport41() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("重度介護前払特約変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU);
            khSouhuannaiBean.setIrJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.MAGO);
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
    @TestOrder(420)
    @Transactional
    public void testCreateReport42() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");
            khSouhuannaiBean.setIrTyouhyoutitle("重度介護前払特約変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU);
            khSouhuannaiBean.setIrJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.KYN);
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
    @TestOrder(430)
    @Transactional
    public void testCreateReport43() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("重度介護前払特約変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU);
            khSouhuannaiBean.setIrJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.HTSZN);
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
    @TestOrder(440)
    @Transactional
    public void testCreateReport44() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("重度介護前払特約変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU);
            khSouhuannaiBean.setIrJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.SINTOU3);
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
    @TestOrder(450)
    @Transactional
    public void testCreateReport45() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("重度介護前払特約変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU);
            khSouhuannaiBean.setIrJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.SONOTA);
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
    @TestOrder(460)
    @Transactional
    public void testCreateReport46() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("重度介護前払特約変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU);
            khSouhuannaiBean.setIrJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.BLNK);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(470)
    @Transactional
    public void testCreateReport47() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("重度介護前払特約変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU);
            khSouhuannaiBean.setIrJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.BLNK);
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
    @TestOrder(480)
    @Transactional
    public void testCreateReport48() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("保険証券再発行手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("wwwwwwwwwww");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SYOSAIHK_SOUHU);
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
    @TestOrder(490)
    @Transactional
    public void testCreateReport49() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("保険証券再発行手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("21001010");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SYOSAIHK_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.BLNK);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(500)
    @Transactional
    public void testCreateReport50() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("保険証券再発行手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SYOSAIHK_SOUHU);
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
    @TestOrder(510)
    @Transactional
    public void testCreateReport51() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("生年月日・性訂正手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("wwwwwwwwwww");
            khSouhuannaiBean.setIrSyosaihkymd("ＷＷ99年99月99日");
            khSouhuannaiBean.setIrTuikahrkkin(BizCurrency.valueOf(9999999999l,BizCurrencyTypes.YEN));
            khSouhuannaiBean.setIrCalckijyunymd("9999年12月31日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrHhknseiymdhenkouumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrHhknseihenkouumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrHenkankinumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
            khSouhuannaiBean.setIrTuikahrkkinumu(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(520)
    @Transactional
    public void testCreateReport52() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("生年月日・性訂正手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrTuikahrkkin(BizCurrency.valueOf(999,BizCurrencyTypes.YEN));
            khSouhuannaiBean.setIrCalckijyunymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.BLNK);
            khSouhuannaiBean.setIrHhknseiymdhenkouumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrHhknseihenkouumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrHenkankinumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
            khSouhuannaiBean.setIrTuikahrkkinumu(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(530)
    @Transactional
    public void testCreateReport53() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("生年月日・性訂正手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("30111111");
            khSouhuannaiBean.setIrSyosaihkymd("平成 8年 2月 2日");
            khSouhuannaiBean.setIrTuikahrkkin(BizCurrency.valueOf(9999,BizCurrencyTypes.YEN));
            khSouhuannaiBean.setIrCalckijyunymd("2009年10月11日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.BLNK);
            khSouhuannaiBean.setIrHhknseiymdhenkouumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrHhknseihenkouumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);
            khSouhuannaiBean.setIrHenkankinumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
            khSouhuannaiBean.setIrTuikahrkkinumu(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(540)
    @Transactional
    public void testCreateReport54() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(null);
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("生年月日・性訂正手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono(null);
            khSouhuannaiBean.setIrSyosaihkymd(null);
            khSouhuannaiBean.setIrTuikahrkkin(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
            khSouhuannaiBean.setIrCalckijyunymd(null);
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.SEINEN);
            khSouhuannaiBean.setIrHhknseiymdhenkouumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrHhknseihenkouumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrHenkankinumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
            khSouhuannaiBean.setIrTuikahrkkinumu(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(550)
    @Transactional
    public void testCreateReport55() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("名義変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("wwwwwwwwwww");
            khSouhuannaiBean.setIrSyosaihkymd("ＷＷ99年99月99日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_MEIGIHNK_SOUHU);
            khSouhuannaiBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYKSB);
            khSouhuannaiBean.setIrStdrsktkyumukbn(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrTrhkjikakumukbn(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(560)
    @Transactional
    public void testCreateReport56() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("名義変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_MEIGIHNK_SOUHU);
            khSouhuannaiBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.BLNK);
            khSouhuannaiBean.setIrStdrsktkyumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrTrhkjikakumukbn(C_UmuKbn.NONE);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(570)
    @Transactional
    public void testCreateReport57() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("名義変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("1201010201");
            khSouhuannaiBean.setIrSyosaihkymd("平成 1年 1月 8日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_MEIGIHNK_SOUHU);
            khSouhuannaiBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);
            khSouhuannaiBean.setIrStdrsktkyumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrTrhkjikakumukbn(C_UmuKbn.NONE);
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
    @TestOrder(580)
    @Transactional
    public void testCreateReport58() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("名義変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_MEIGIHNK_SOUHU);
            khSouhuannaiBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KAISEIKAIMEI);
            khSouhuannaiBean.setIrStdrsktkyumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrTrhkjikakumukbn(C_UmuKbn.NONE);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(590)
    @Transactional
    public void testCreateReport59() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("名義変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono(null);
            khSouhuannaiBean.setIrSyosaihkymd(null);
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_MEIGIHNK_SOUHU);
            khSouhuannaiBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.SONOTA);
            khSouhuannaiBean.setIrStdrsktkyumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrTrhkjikakumukbn(C_UmuKbn.NONE);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }
    @Test
    @TestOrder(600)
    @Transactional
    public void testCreateReport60() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("減額手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono(null);
            khSouhuannaiBean.setIrSyosaihkymd(null);
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
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
    @TestOrder(610)
    @Transactional
    public void testCreateReport61() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("住所変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono(null);
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_ADRHNK_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.SEINEN);
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
    @TestOrder(620)
    @Transactional
    public void testCreateReport62() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("保険証券再発行手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono(null);
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SYOSAIHK_SOUHU);
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
    @TestOrder(630)
    @Transactional
    public void testCreateReport63() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("送付案内メッセージ１");
            khSouhuannaiBean.setIrSouhuannaimsg2("送付案内メッセージ２");
            khSouhuannaiBean.setIrSouhuannaimsg3("送付案内メッセージ３");
            khSouhuannaiBean.setIrSouhuannaimsg4("送付案内メッセージ４");
            khSouhuannaiBean.setIrSouhuannaimsg5("送付案内メッセージ５");
            khSouhuannaiBean.setIrSouhuannaimsg6("送付案内メッセージ６");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SBMENSEKI_SOUHU);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(640)
    @Transactional
    public void testCreateReport64() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");


            khSouhuannaiBean.setIrTyouhyoutitle("保険証券再発行手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("送付案内メッセージ１");
            khSouhuannaiBean.setIrSouhuannaimsg2("送付案内メッセージ２");
            khSouhuannaiBean.setIrSouhuannaimsg3("送付案内メッセージ３");
            khSouhuannaiBean.setIrSouhuannaimsg4("送付案内メッセージ４");
            khSouhuannaiBean.setIrSouhuannaimsg5("送付案内メッセージ５");
            khSouhuannaiBean.setIrSouhuannaimsg6("送付案内メッセージ６");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("ＷＷ99年99月99日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SYOSAIHK_SOUHU);
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
    @TestOrder(650)
    @Transactional
    public void testCreateReport65() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_MKHGKHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("wwwwwww");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("www-wwww");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(ww)wwww-wwwww");

            khSouhuannaiBean.setIrSouhuannaimsg1("１ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrSouhuannaimsg2("２ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrSouhuannaimsg3("３ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrSouhuannaimsg4("４ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrSouhuannaimsg5("５ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrSouhuannaimsg6("６ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khSouhuannaiBean.setIrSyono("wwwwwwwwwww");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_MKHGKHNK_SOUHU);
            khSouhuannaiBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(660)
    @Transactional
    public void testCreateReport66() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_MKHGKHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_MKHGKHNK_SOUHU);
            khSouhuannaiBean.setIrTyouhyoutitle("目標額変更手続きのご案内");
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
    @TestOrder(670)
    @Transactional
    public void testCreateReport67() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_MKHGKHNK_SOUHU);

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
            khSouhuannaiBean.setIrSyono(null);
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_MKHGKHNK_SOUHU);
            khSouhuannaiBean.setIrTyouhyoutitle(null);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(680)
    @Transactional
    public void testCreateReport68() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_MKHGKHNK_SOUHU);

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
            khSouhuannaiBean.setIrSyono("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_MKHGKHNK_SOUHU);
            khSouhuannaiBean.setIrTyouhyoutitle("");

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(690)
    @Transactional
    public void testCreateReport69() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("積立金移転手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);
            khSouhuannaiBean.setIrTmttknitenkbn(C_Tmttknitenkbn.BLNK);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(700)
    @Transactional
    public void testCreateReport70() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono(null);
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("積立金移転手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);

            khSouhuannaiBean.setIrTmttknitenkbn(C_Tmttknitenkbn.BLNK);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(710)
    @Transactional
    public void testCreateReport71() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyoruiuktkkigenymd("平成 5年 5月 5日");
            khSouhuannaiBean.setIrTmttknitenuktkstartymd("平成 6年 6月 6日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("積立金移転手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrTmttknitenkbn(C_Tmttknitenkbn.ITEN);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(720)
    @Transactional
    public void testCreateReport72() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("wwwwwwwwwww");
            khSouhuannaiBean.setIrSyoruiuktkkigenymd("ＷＷ99年99月99日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("積立金移転手続きの取消しのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.SEINEN);
            khSouhuannaiBean.setIrTmttknitenkbn(C_Tmttknitenkbn.ITEN_TORIKESI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(730)
    @Transactional
    public void testCreateReport73() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrYendthnkHrgk(null);
            khSouhuannaiBean.setIrSyoruiuktkkigenymd("ＷＷ99年99月99日");
            khSouhuannaiBean.setIrTmttknitenuktkstartymd("ＷＷ99年99月99日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("円建変更時返戻金の請求のご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(740)
    @Transactional
    public void testCreateReport74() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrYendthnkHrgk(BizCurrency.valueOf(123));
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("円建変更時返戻金の請求のご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(750)
    @Transactional
    public void testCreateReport75() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrYendthnkHrgk(BizCurrency.valueOf(9999999999999L));
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("円建変更時返戻金の請求のご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.KYKSB);
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
    @TestOrder(760)
    @Transactional
    public void testCreateReport76() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrYendthnkHrgk(BizCurrency.valueOf(999));
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("円建変更時返戻金の請求のご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
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
    @TestOrder(770)
    @Transactional
    public void testCreateReport77() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("さて、あなた様のご契約につきましては、以前からご連絡しておりますとおり、円建変更時返戻金が");
            khSouhuannaiBean.setIrSouhuannaimsg3("ございます。");
            khSouhuannaiBean.setIrSouhuannaimsg4("お手続き方法などの詳細につきましては、以下をご確認くださいますようお願いいたします。");
            khSouhuannaiBean.setIrSouhuannaimsg5("なお、このご案内と行き違いにお手続きされている場合はあしからずご了承ください。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrYendthnkHrgk(BizCurrency.valueOf(9999));
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("円建変更時返戻金のお受取りのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
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
    @TestOrder(780)
    @Transactional
    public void testCreateReport78() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("さて、あなた様のご契約につきましては、以前からご連絡しておりますとおり、円建変更時返戻金が");
            khSouhuannaiBean.setIrSouhuannaimsg3("ございます。");
            khSouhuannaiBean.setIrSouhuannaimsg4("お手続き方法などの詳細につきましては、以下をご確認くださいますようお願いいたします。");
            khSouhuannaiBean.setIrSouhuannaimsg5("なお、このご案内と行き違いにお手続きされている場合はあしからずご了承ください。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrYendthnkHrgk(BizCurrency.valueOf(0));
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("円建変更時返戻金のお受取りのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
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
    @TestOrder(790)
    @Transactional
    public void testCreateReport79() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("さて、あなた様のご契約につきましては、以前からご連絡しておりますとおり、円建変更時返戻金が");
            khSouhuannaiBean.setIrSouhuannaimsg3("ございます。");
            khSouhuannaiBean.setIrSouhuannaimsg4("お手続き方法などの詳細につきましては、以下をご確認くださいますようお願いいたします。");
            khSouhuannaiBean.setIrSouhuannaimsg5("なお、このご案内と行き違いにお手続きされている場合はあしからずご了承ください。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrYendthnkHrgk(BizCurrency.valueOf(9999999999999.99,BizCurrencyTypes.AU_DOLLAR));
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("円建変更時返戻金のお受取りのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
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
    @TestOrder(800)
    @Transactional
    public void testCreateReport80() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("さて、あなた様のご契約につきましては、以前からご連絡しておりますとおり、円建変更時返戻金が");
            khSouhuannaiBean.setIrSouhuannaimsg3("ございます。");
            khSouhuannaiBean.setIrSouhuannaimsg4("お手続き方法などの詳細につきましては、以下をご確認くださいますようお願いいたします。");
            khSouhuannaiBean.setIrSouhuannaimsg5("なお、このご案内と行き違いにお手続きされている場合はあしからずご了承ください。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrYendthnkHrgk(BizCurrency.valueOf(9.1,BizCurrencyTypes.AU_DOLLAR));
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("円建変更時返戻金のお受取りのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
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
    @TestOrder(810)
    @Transactional
    public void testCreateReport81() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("さて、あなた様のご契約につきましては、以前からご連絡しておりますとおり、円建変更時返戻金が");
            khSouhuannaiBean.setIrSouhuannaimsg3("ございます。");
            khSouhuannaiBean.setIrSouhuannaimsg4("お手続き方法などの詳細につきましては、以下をご確認くださいますようお願いいたします。");
            khSouhuannaiBean.setIrSouhuannaimsg5("なお、このご案内と行き違いにお手続きされている場合はあしからずご了承ください。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrYendthnkHrgk(BizCurrency.valueOf(999.22,BizCurrencyTypes.AU_DOLLAR));
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("円建変更時返戻金のお受取りのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
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
    @TestOrder(820)
    @Transactional
    public void testCreateReport82() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("さて、あなた様のご契約につきましては、以前からご連絡しておりますとおり、円建変更時返戻金が");
            khSouhuannaiBean.setIrSouhuannaimsg3("ございます。");
            khSouhuannaiBean.setIrSouhuannaimsg4("お手続き方法などの詳細につきましては、以下をご確認くださいますようお願いいたします。");
            khSouhuannaiBean.setIrSouhuannaimsg5("なお、このご案内と行き違いにお手続きされている場合はあしからずご了承ください。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrYendthnkHrgk(BizCurrency.valueOf(9999.333,BizCurrencyTypes.AU_DOLLAR));
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("円建変更時返戻金のお受取りのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
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
    @TestOrder(830)
    @Transactional
    public void testCreateReport83() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg4("必要書類をお取りそろえのうえ、提出していただきますようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg5("なお、解約は完備された必要書類が当社に到着した日を持って効力を生じます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrTmttknitenkbn(C_Tmttknitenkbn.ITEN);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.KYKSB);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
            khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.KA);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(840)
    @Transactional
    public void testCreateReport84() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("必要書類をお取りそろえのうえ、提出していただきますようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg4("なお、解約は完備された必要書類が当社に到着した日を持って効力を生じます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrTmttknitenkbn(C_Tmttknitenkbn.ITEN_TORIKESI);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.SEINEN);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.KA);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.NONE);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(850)
    @Transactional
    public void testCreateReport85() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg4("必要書類をお取りそろえのうえ、提出していただきますようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg5("なお、解約は完備された必要書類が当社に到着した日を持って効力を生じます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.SISUU_ONLY);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.KA);
            khSouhuannaiBean.setIrMynosinkokutaisyouumukbn(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(860)
    @Transactional
    public void testCreateReport86() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("必要書類をお取りそろえのうえ、提出していただきますようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg4("なお、解約は完備された必要書類が当社に到着した日を持って効力を生じます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.HUKA);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(870)
    @Transactional
    public void testCreateReport87() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg4("必要書類をお取りそろえのうえ、提出していただきますようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg5("なお、解約は完備された必要書類が当社に到着した日を持って効力を生じます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.SISUU_ONLY);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.SEINEN);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.HUKA);
            khSouhuannaiBean.setIrMynosinkokutaisyouumukbn(C_UmuKbn.ARI);


            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(880)
    @Transactional
    public void testCreateReport88() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("必要書類をお取りそろえのうえ、提出していただきますようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg4("なお、解約は完備された必要書類が当社に到着した日を持って効力を生じます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.HUKA);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(890)
    @Transactional
    public void testCreateReport89() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_GENGAKU_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("減額手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
            khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.SEINEN);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.KA);
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
    @TestOrder(900)
    @Transactional
    public void testCreateReport90() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_GENGAKU_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("減額手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.KA);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrMousideikoukbn(C_MousideIkouKbn.YENNENKIN);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(910)
    @Transactional
    public void testCreateReport91() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                C_SyoruiCdKbn.KK_GENGAKU_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("0101234");
        bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
        bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
        bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
        bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
        bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

        khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
        khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
        khSouhuannaiBean.setIrSyono("12345678901");
        khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
        khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
        khSouhuannaiBean.setIrTyouhyoutitle("減額手続きのご案内");
        khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
        khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.ARI);
        khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR);

        reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(920)
    @Transactional
    public void testCreateReport92() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_GENGAKU_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("減額手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR);
            khSouhuannaiBean.setIrMousideikoukbn(C_MousideIkouKbn.YENSYUUSIN);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(930)
    @Transactional
    public void testCreateReport93() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                C_SyoruiCdKbn.KK_GENGAKU_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("0101234");
        bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
        bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
        bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
        bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
        bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

        khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
        khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
        khSouhuannaiBean.setIrSyono("12345678901");
        khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
        khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
        khSouhuannaiBean.setIrTyouhyoutitle("減額手続きのご案内");
        khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
        khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.NONE);
        khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR);

        reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }
    @Test
    @TestOrder(940)
    @Transactional
    public void testCreateReport94() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyoruiuktkkigenymd("");
            khSouhuannaiBean.setIrTmttknitenuktkstartymd("");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("積立金移転手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrTmttknitenkbn(C_Tmttknitenkbn.ITEN);
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
    @TestOrder(950)
    @Transactional
    public void testCreateReport95() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyoruiuktkkigenymd(null);
            khSouhuannaiBean.setIrTmttknitenuktkstartymd(null);
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("積立金移転手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrTmttknitenkbn(C_Tmttknitenkbn.ITEN);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }
    @Test
    @TestOrder(960)
    @Transactional
    public void testCreateReport96() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyoruiuktkkigenymd("ＷＷ99年99月99日");
            khSouhuannaiBean.setIrTmttknitenuktkstartymd("ＷＷ99年99月99日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("積立金移転手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrTmttknitenkbn(C_Tmttknitenkbn.ITEN);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }
    @Test
    @TestOrder(970)
    @Transactional
    public void testCreateReport97() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("wwwwwwwwwww");
            khSouhuannaiBean.setIrSyoruiuktkkigenymd("");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("積立金移転手続きの取消しのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.SEINEN);
            khSouhuannaiBean.setIrTmttknitenkbn(C_Tmttknitenkbn.ITEN_TORIKESI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }
    @Test
    @TestOrder(980)
    @Transactional
    public void testCreateReport98() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("wwwwwwwwwww");
            khSouhuannaiBean.setIrSyoruiuktkkigenymd(null);
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("積立金移転手続きの取消しのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.SEINEN);
            khSouhuannaiBean.setIrTmttknitenkbn(C_Tmttknitenkbn.ITEN_TORIKESI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }
    @Test
    @TestOrder(990)
    @Transactional
    public void testCreateReport99() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("wwwwwwwwwww");
            khSouhuannaiBean.setIrSyoruiuktkkigenymd("平成 5年 5月 5日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("積立金移転手続きの取消しのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.SEINEN);
            khSouhuannaiBean.setIrTmttknitenkbn(C_Tmttknitenkbn.ITEN_TORIKESI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1000)
    @Transactional
    public void testCreateReport100() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("必要書類をお取りそろえのうえ、提出していただきますようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg4("なお、解約は完備された必要書類が当社に到着した日を持って効力を生じます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrTmttknitenkbn(C_Tmttknitenkbn.ITEN_TORIKESI);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.SKS);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.SEINEN);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.KA);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }
    @Test
    @TestOrder(1010)
    @Transactional
    public void testCreateReport101() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_DSHR_SOUHU );

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2012年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("");
            khSouhuannaiBean.setIrCalckijyunymd("");
            khSouhuannaiBean.setIrTmtthtkinzndk(BizCurrency.valueOf(0));
            khSouhuannaiBean.setIrTyouhyoutitle("配当金支払請求書の送付案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_DSHR_SOUHU);
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
    @TestOrder(1020)
    @Transactional
    public void testCreateReport102() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_DSHR_SOUHU );

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2012年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono(null);
            khSouhuannaiBean.setIrCalckijyunymd(null);
            khSouhuannaiBean.setIrTmtthtkinzndk(null);
            khSouhuannaiBean.setIrTyouhyoutitle("配当金支払請求書の送付案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_DSHR_SOUHU);
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
    @TestOrder(1030)
    @Transactional
    public void testCreateReport103() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_DSHR_SOUHU );

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2012年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrCalckijyunymd("2025年 5月 5日");
            khSouhuannaiBean.setIrTmtthtkinzndk(BizCurrency.valueOf(1234));
            khSouhuannaiBean.setIrTyouhyoutitle("配当金支払請求書の送付案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_DSHR_SOUHU);
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
    @TestOrder(1040)
    @Transactional
    public void testCreateReport104() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_DSHR_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2012年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("wwwwwwwwwww");
            khSouhuannaiBean.setIrCalckijyunymd("9999年99月99日");
            khSouhuannaiBean.setIrTmtthtkinzndk(BizCurrency.valueOf(9999999999999L));
            khSouhuannaiBean.setIrTyouhyoutitle("配当金支払請求書の送付案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_DSHR_SOUHU);
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
    @TestOrder(1050)
    @Transactional
    public void testCreateReport105() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_DSHR_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2012年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrCalckijyunymd("2025年 5月 5日");
            khSouhuannaiBean.setIrTmtthtkinzndk(BizCurrency.valueOf(123));
            khSouhuannaiBean.setIrTyouhyoutitle("配当金支払請求書の送付案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_DSHR_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.SEINEN);
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
    @TestOrder(1060)
    @Transactional
    public void testCreateReport106() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_GENGAKU_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("");
            khSouhuannaiBean.setIrTyouhyoutitle("減額請求書の送付案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);


            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }
    @Test
    @TestOrder(1070)
    @Transactional
    public void testCreateReport107() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_GENGAKU_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(null);
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono(null);
            khSouhuannaiBean.setIrSyosaihkymd(null);
            khSouhuannaiBean.setIrTyouhyoutitle("減額請求書の送付案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
            khSouhuannaiBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);


            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }
    @Test
    @TestOrder(1080)
    @Transactional
    public void testCreateReport108() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_GENGAKU_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2012年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("2025年 5月 5日");
            khSouhuannaiBean.setIrTyouhyoutitle("減額請求書の送付案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.NONE);



            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }
    @Test
    @TestOrder(1090)
    @Transactional
    public void testCreateReport109() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_GENGAKU_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("wwwwwwwwwww");
            khSouhuannaiBean.setIrSyosaihkymd("9999年99月99日");
            khSouhuannaiBean.setIrTyouhyoutitle("減額請求書の送付案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.NONE);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1100)
    @Transactional
    public void testCreateReport110() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_GENGAKU_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("2025年 5月 5日");
            khSouhuannaiBean.setIrTyouhyoutitle("減額請求書の送付案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
            khSouhuannaiBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1110)
    @Transactional
    public void testCreateReport111() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg4("必要書類をお取りそろえのうえ、提出していただきますようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg5("なお、解約は完備された必要書類が当社に到着した日を持って効力を生じます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("2019年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("2019年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrYendthnkymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrTmttknitenkbn(C_Tmttknitenkbn.ITEN);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.KYKSB);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
            khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.KA);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrMynosinkokutaisyouumukbn(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1120)
    @Transactional
    public void testCreateReport112() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("必要書類をお取りそろえのうえ、提出していただきますようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg4("なお、解約は完備された必要書類が当社に到着した日を持って効力を生じます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("2019年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("2019年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrYendthnkymd("20050918");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrTmttknitenkbn(C_Tmttknitenkbn.ITEN_TORIKESI);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.SEINEN);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.KA);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.NONE);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1130)
    @Transactional
    public void testCreateReport113() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_YENDTHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrTyouhyoutitle("円建年金保険変更手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_YENDTHNK_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.SEINEN);
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
    @TestOrder(1140)
    @Transactional
    public void testCreateReport114() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_YENDTHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono(null);
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd(null);
            khSouhuannaiBean.setIrTyouhyoutitle("円建年金保険への変更手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_YENDTHNK_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrMousideikoukbn(C_MousideIkouKbn.YENNENKIN);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN);
            khSouhuannaiBean.setIrKykjyoutai(C_Kykjyoutai.HRKMTYUU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
            khSouhuannaiBean.setIrYendthnkymd("20201212");

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1150)
    @Transactional
    public void testCreateReport115() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_YENDTHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("2025年 5月 5日");
            khSouhuannaiBean.setIrTyouhyoutitle("円建終身保険への変更手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_YENDTHNK_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);
            khSouhuannaiBean.setIrMousideikoukbn(C_MousideIkouKbn.YENSYUUSIN);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1160)
    @Transactional
    public void testCreateReport116() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_YENDTHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("wwwwwwwwwww");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("9999年99月99日");
            khSouhuannaiBean.setIrTyouhyoutitle("円建年金保険変更手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_YENDTHNK_SOUHU);
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
    @TestOrder(1170)
    @Transactional
    public void testCreateReport117() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg4("必要書類をお取りそろえのうえ、提出していただきますようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg5("なお、解約は完備された必要書類が当社に到着した日を持って効力を生じます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.SISUU_ONLY);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.KA);
            khSouhuannaiBean.setIrMynosinkokutaisyouumukbn(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1180)
    @Transactional
    public void testCreateReport118() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                C_SyoruiCdKbn.KK_GENGAKU_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("0101234");
        bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
        bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
        bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
        bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
        bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

        khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
        khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
        khSouhuannaiBean.setIrSyono("12345678901");
        khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
        khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
        khSouhuannaiBean.setIrTyouhyoutitle("減額手続きのご案内");
        khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
        khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.NONE);
        khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19);
        khSouhuannaiBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);

        reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(1190)
    @Transactional
    public void testCreateReport119() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg4("必要書類をお取りそろえのうえ、提出していただきますようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg5("なお、解約は完備された必要書類が当社に到着した日を持って効力を生じます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.KA);
            khSouhuannaiBean.setIrMynosinkokutaisyouumukbn(C_UmuKbn.NONE);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1200)
    @Transactional
    public void testCreateReport120() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg4("必要書類をお取りそろえのうえ、提出していただきますようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg5("なお、解約は完備された必要書類が当社に到着した日を持って効力を生じます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("2019年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("2019年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrTmttknitenkbn(C_Tmttknitenkbn.ITEN);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.KYKSB);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
            khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.KA);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrMynosinkokutaisyouumukbn(C_UmuKbn.NONE);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1210)
    @Transactional
    public void testCreateReport121() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg4("必要書類をお取りそろえのうえ、提出していただきますようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg5("なお、解約は完備された必要書類が当社に到着した日を持って効力を生じます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("2019年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("2019年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrTmttknitenkbn(C_Tmttknitenkbn.ITEN);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.KYKSB);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN);
            khSouhuannaiBean.setIrTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.KA);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);
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
    @TestOrder(1220)
    @Transactional
    public void testCreateReport122() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("住所変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_ADRHNK_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
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
    @TestOrder(1230)
    @Transactional
    public void testCreateReport123() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("名義変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("平成 1年 1月 8日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_MEIGIHNK_SOUHU);
            khSouhuannaiBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYKSB);
            khSouhuannaiBean.setIrStdrsktkyumukbn(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrTrhkjikakumukbn(C_UmuKbn.NONE);
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
    @TestOrder(1240)
    @Transactional
    public void testCreateReport124() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("名義変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("平成 1年 1月 8日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_MEIGIHNK_SOUHU);
            khSouhuannaiBean.setIrMeigihnkjiyuu(C_Meigihnkjiyuu.KYKSB);
            khSouhuannaiBean.setIrStdrsktkyumukbn(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrTrhkjikakumukbn(C_UmuKbn.ARI);
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
    @TestOrder(1250)
    @Transactional
    public void testCreateReport125() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("被保険者代理特約中途付加手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("平成 1年 1月 8日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_STDRHNK_SOUHU);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.HGU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.SETTEI);
            khSouhuannaiBean.setIrJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1260)
    @Transactional
    public void testCreateReport126() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("生年月日・性訂正手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("30111111");
            khSouhuannaiBean.setIrSyosaihkymd("平成 8年 2月 2日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrHhknseiymdhenkouumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrHhknseihenkouumu(C_UmuKbn.ARI);
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
    @TestOrder(1270)
    @Transactional
    public void testCreateReport127() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                C_SyoruiCdKbn.KK_GENGAKU_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("0101234");
        bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
        bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
        bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
        bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
        bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
        bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

        khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
        khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
        khSouhuannaiBean.setIrSyono("12345678901");
        khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
        khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
        khSouhuannaiBean.setIrTyouhyoutitle("減額手続きのご案内");
        khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
        khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSouhuannaiBean.setIrZeiseitkkktkykhukaumu(C_UmuKbn.NONE);
        khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.NONE);
        khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19);
        khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
        khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);
        khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.KA);
        khSouhuannaiBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.SETTEI);

        reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(1280)
    @Transactional
    public void testCreateReport128() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("保険証券再発行手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SYOSAIHK_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
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
    @TestOrder(1290)
    @Transactional
    public void testCreateReport129() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("重度介護前払特約変更手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU);
            khSouhuannaiBean.setIrJyudkaigomaebrtkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA);
            khSouhuannaiBean.setIrKkkyktdk(C_Tdk.HGU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
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
    @TestOrder(1300)
    @Transactional
    public void testCreateReport130() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_MKHGKHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_MKHGKHNK_SOUHU);
            khSouhuannaiBean.setIrTyouhyoutitle("目標額変更手続きのご案内");
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
    @TestOrder(1310)
    @Transactional
    public void testCreateReport131() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrYendthnkHrgk(null);
            khSouhuannaiBean.setIrSyoruiuktkkigenymd("平成 1年 1月 1日");
            khSouhuannaiBean.setIrTmttknitenuktkstartymd("平成 2年 2月 2日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("円建変更時返戻金の請求のご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);
            khSouhuannaiBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.SETTEI);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.KYKSB);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1320)
    @Transactional
    public void testCreateReport132() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrYendthnkHrgk(null);
            khSouhuannaiBean.setIrSyoruiuktkkigenymd("平成 1年 1月 1日");
            khSouhuannaiBean.setIrTmttknitenuktkstartymd("平成 2年 2月 2日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("円建変更時返戻金の請求のご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);
            khSouhuannaiBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.KYKSB);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1330)
    @Transactional
    public void testCreateReport133() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrYendthnkHrgk(null);
            khSouhuannaiBean.setIrSyoruiuktkkigenymd("平成 1年 1月 1日");
            khSouhuannaiBean.setIrTmttknitenuktkstartymd("平成 2年 2月 2日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("円建変更時返戻金の請求のご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
            khSouhuannaiBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.SETTEI);
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
    @TestOrder(1340)
    @Transactional
    public void testCreateReport134() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrYendthnkHrgk(null);
            khSouhuannaiBean.setIrSyoruiuktkkigenymd("平成 1年 1月 1日");
            khSouhuannaiBean.setIrTmttknitenuktkstartymd("平成 2年 2月 2日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("円建変更時返戻金の請求のご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
            khSouhuannaiBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);
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
    @TestOrder(1350)
    @Transactional
    public void testCreateReport135() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyoruiuktkkigenymd("平成 5年 5月 5日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyoutitle("積立金移転手続きの取消しのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrTmttknitenkbn(C_Tmttknitenkbn.ITEN);
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
    @TestOrder(1360)
    @Transactional
    public void testCreateReport136() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_DSHR_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2012年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrCalckijyunymd("2025年 5月 5日");
            khSouhuannaiBean.setIrTmtthtkinzndk(BizCurrency.valueOf(123));
            khSouhuannaiBean.setIrTyouhyoutitle("配当金支払請求書の送付案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_DSHR_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
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
    @TestOrder(1370)
    @Transactional
    public void testCreateReport137() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_YENDTHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("2025年 5月 5日");
            khSouhuannaiBean.setIrTyouhyoutitle("円建年金保険変更手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_YENDTHNK_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
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
    @TestOrder(1380)
    @Transactional
    public void testCreateReport138() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("必要書類をお取りそろえのうえ、提出していただきますようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg4("なお、解約は完備された必要書類が当社に到着した日を持って効力を生じます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("2019年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("2019年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrTmttknitenkbn(C_Tmttknitenkbn.ITEN);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.KYKSB);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.KA);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);
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
    @TestOrder(1390)
    @Transactional
    public void testCreateReport139() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("必要書類をお取りそろえのうえ、提出していただきますようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg4("なお、解約は完備された必要書類が当社に到着した日を持って効力を生じます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.HUKA);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1400)
    @Transactional
    public void testCreateReport140() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg4("必要書類をお取りそろえのうえ、提出していただきますようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg5("なお、解約は完備された必要書類が当社に到着した日を持って効力を生じます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.SISUU_ONLY);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.SEINEN);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.HUKA);
            khSouhuannaiBean.setIrMynosinkokutaisyouumukbn(C_UmuKbn.ARI);


            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1410)
    @Transactional
    public void testCreateReport141() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg4("必要書類をお取りそろえのうえ、提出していただきますようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg5("なお、解約は完備された必要書類が当社に到着した日を持って効力を生じます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.SISUU_ONLY);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.KA);
            khSouhuannaiBean.setIrMynosinkokutaisyouumukbn(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1420)
    @Transactional
    public void testCreateReport142() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("契約者さまのご逝去を悼み、謹んでお悔やみ申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("故人にはご生前ひとかたならぬご愛顧を賜り、誠にありがとうございました。");
            khSouhuannaiBean.setIrSouhuannaimsg3("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg4("必要書類をお取りそろえのうえ、提出していただきますようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg5("なお、解約は完備された必要書類が当社に到着した日を持って効力を生じます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.KA);
            khSouhuannaiBean.setIrMynosinkokutaisyouumukbn(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1430)
    @Transactional
    public void testCreateReport143() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_GENGAKU_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("減額手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20);
            khSouhuannaiBean.setIrKykjyoutai(C_Kykjyoutai.HRKMTYUU);
            khSouhuannaiBean.setIrYendthnkymd("20201212");

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1440)
    @Transactional
    public void testCreateReport144() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_GENGAKU_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("減額手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN);
            khSouhuannaiBean.setIrKykjyoutai(C_Kykjyoutai.HRKMTYUU);
            khSouhuannaiBean.setIrYendthnkymd("20201212");
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1450)
    @Transactional
    public void testCreateReport145() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_GENGAKU_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("減額手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN);
            khSouhuannaiBean.setIrKykjyoutai(C_Kykjyoutai.ZENNOU);
            khSouhuannaiBean.setIrYendthnkymd(null);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1460)
    @Transactional
    public void testCreateReport146() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_GENGAKU_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("減額手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN);
            khSouhuannaiBean.setIrKykjyoutai(C_Kykjyoutai.IKKATUNK);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1470)
    @Transactional
    public void testCreateReport147() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_GENGAKU_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("減額手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN);
            khSouhuannaiBean.setIrKykjyoutai(C_Kykjyoutai.BLNK);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1480)
    @Transactional
    public void testCreateReport148() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("生年月日・性訂正手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("wwwwwwwwwww");
            khSouhuannaiBean.setIrSyosaihkymd("ＷＷ99年99月99日");
            khSouhuannaiBean.setIrTuikahrkkin(BizCurrency.valueOf(9999999999.99,BizCurrencyTypes.AU_DOLLAR));
            khSouhuannaiBean.setIrCalckijyunymd("9999年12月31日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrHhknseiymdhenkouumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrHhknseihenkouumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrHenkankinumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
            khSouhuannaiBean.setIrTuikahrkkinumu(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1490)
    @Transactional
    public void testCreateReport149() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("生年月日・性訂正手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("");
            khSouhuannaiBean.setIrSyosaihkymd("");
            khSouhuannaiBean.setIrTuikahrkkin(BizCurrency.valueOf(999,BizCurrencyTypes.AU_DOLLAR));
            khSouhuannaiBean.setIrCalckijyunymd("");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.BLNK);
            khSouhuannaiBean.setIrHhknseiymdhenkouumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrHhknseihenkouumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrHenkankinumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
            khSouhuannaiBean.setIrTuikahrkkinumu(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1500)
    @Transactional
    public void testCreateReport150() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("生年月日・性訂正手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("30111111");
            khSouhuannaiBean.setIrSyosaihkymd("平成 8年 2月 2日");
            khSouhuannaiBean.setIrTuikahrkkin(BizCurrency.valueOf(9999,BizCurrencyTypes.AU_DOLLAR));
            khSouhuannaiBean.setIrCalckijyunymd("2009年10月11日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.BLNK);
            khSouhuannaiBean.setIrHhknseiymdhenkouumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrHhknseihenkouumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrHenkankinumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
            khSouhuannaiBean.setIrTuikahrkkinumu(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1510)
    @Transactional
    public void testCreateReport151() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("生年月日・性訂正手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono(null);
            khSouhuannaiBean.setIrSyosaihkymd(null);
            khSouhuannaiBean.setIrTuikahrkkin(BizCurrency.valueOf(0,BizCurrencyTypes.AU_DOLLAR));
            khSouhuannaiBean.setIrCalckijyunymd(null);
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.SEINEN);
            khSouhuannaiBean.setIrHhknseiymdhenkouumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrHhknseihenkouumu(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrHenkankinumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
            khSouhuannaiBean.setIrTuikahrkkinumu(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1520)
    @Transactional
    public void testCreateReport152() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("生年月日・性訂正手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("30111111");
            khSouhuannaiBean.setIrSyosaihkymd("平成 8年 2月 2日");
            khSouhuannaiBean.setIrTuikahrkkin(BizCurrency.valueOf(9.1,BizCurrencyTypes.AU_DOLLAR));
            khSouhuannaiBean.setIrCalckijyunymd("2009年10月11日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.BLNK);
            khSouhuannaiBean.setIrHhknseiymdhenkouumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrHhknseihenkouumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrHenkankinumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
            khSouhuannaiBean.setIrTuikahrkkinumu(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1530)
    @Transactional
    public void testCreateReport153() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("生年月日・性訂正手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("30111111");
            khSouhuannaiBean.setIrSyosaihkymd("平成 8年 2月 2日");
            khSouhuannaiBean.setIrTuikahrkkin(BizCurrency.valueOf(9.22,BizCurrencyTypes.AU_DOLLAR));
            khSouhuannaiBean.setIrCalckijyunymd("2009年10月11日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.BLNK);
            khSouhuannaiBean.setIrHhknseiymdhenkouumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrHhknseihenkouumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrHenkankinumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
            khSouhuannaiBean.setIrTuikahrkkinumu(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1540)
    @Transactional
    public void testCreateReport154() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("生年月日・性訂正手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("30111111");
            khSouhuannaiBean.setIrSyosaihkymd("平成 8年 2月 2日");
            khSouhuannaiBean.setIrTuikahrkkin(BizCurrency.valueOf(9.333,BizCurrencyTypes.AU_DOLLAR));
            khSouhuannaiBean.setIrCalckijyunymd("2009年10月11日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.BLNK);
            khSouhuannaiBean.setIrHhknseiymdhenkouumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrHhknseihenkouumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrHenkankinumukbn(C_UmuKbn.NONE);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
            khSouhuannaiBean.setIrTuikahrkkinumu(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1550)
    @Transactional
    public void testCreateReport155() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("生年月日・性訂正手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("30111111");
            khSouhuannaiBean.setIrSyosaihkymd("平成 8年 2月 2日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.BLNK);
            khSouhuannaiBean.setIrHhknseiymdhenkouumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrHhknseihenkouumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrHenkankinumukbn(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.AUD);
            khSouhuannaiBean.setIrTuikahrkkinumu(C_UmuKbn.NONE);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1560)
    @Transactional
    public void testCreateReport156() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_TARGETHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("1234567");
            bzKokyakuAtesakiBean.setIrShadr1kj("東京都品川区");
            bzKokyakuAtesakiBean.setIrShadr2kj("北品川");
            bzKokyakuAtesakiBean.setIrShadr3kj("西新宿新宿アイランドタワー（1階）");
            bzKokyakuAtesakiBean.setIrShsnmkj("生保　太郎");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseyno("1234568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrTyouhyoutitle("生年月日・性訂正手続きのご案内");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("");
            khSouhuannaiBean.setIrSyono("30111111");
            khSouhuannaiBean.setIrSyosaihkymd("平成 8年 2月 2日");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.BLNK);
            khSouhuannaiBean.setIrHhknseiymdhenkouumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrHhknseihenkouumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrHenkankinumukbn(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
            khSouhuannaiBean.setIrTuikahrkkinumu(C_UmuKbn.NONE);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1570)
    @Transactional
    public void testCreateReport157() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSouhuannaimsg3("必要書類をお取りそろえのうえ、提出していただきますようお願い申し上げます。");
            khSouhuannaiBean.setIrSouhuannaimsg4("なお、解約は完備された必要書類が当社に到着した日を持って効力を生じます。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd("2019年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("2019年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("解約請求手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            khSouhuannaiBean.setIrTmttknitenkbn(C_Tmttknitenkbn.ITEN);
            khSouhuannaiBean.setIrKhhrshrjiyuu(C_Khhrshrjiyuu.KYKSB);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.USD);
            khSouhuannaiBean.setIrTargettkhkumu(C_UmuKbn.ARI);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN);
            khSouhuannaiBean.setIrKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrDskaiyakukahikbn(C_KahiKbn.KA);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);
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
    @TestOrder(1580)
    @Transactional
    public void testCreateReport158() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_GENGAKU_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成 2年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");

            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono("12345678901");
            khSouhuannaiBean.setIrSyosaihkymd("平成 3年 3月 3日");
            khSouhuannaiBean.setIrTyouhyousakuseiymd("平成 4年 4月 4日");
            khSouhuannaiBean.setIrTyouhyoutitle("減額手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_GENGAKU_SOUHU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN );
            khSouhuannaiBean.setIrKykjyoutai(C_Kykjyoutai.BLNK);
            khSouhuannaiBean.setIrGsbunritaisyouumukbn(C_UmuKbn.ARI);

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(1590)
    @Transactional
    public void testCreateReport159() {
        try {
            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "kh_souhuannaiTest",
                    C_SyoruiCdKbn.KK_YENDTHNK_SOUHU);

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 2月 2日");
            bzKokyakuAtesakiBean.setIrShsyno("0101234");
            bzKokyakuAtesakiBean.setIrShadr1kj("板橋区巣鴨３丁目");
            bzKokyakuAtesakiBean.setIrShadr2kj("横浜市横浜港");
            bzKokyakuAtesakiBean.setIrShadr3kj("新宿市１ー２ー２２");
            bzKokyakuAtesakiBean.setIrShsnmkj("田中太郎");
            bzKokyakuAtesakiBean.setIrToiawaseyno("123-4568");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("問合せ先住所１（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("問合せ先住所３（漢字）");
            bzKokyakuAtesakiBean.setIrHknkisynm("問合せ先会社名");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
            bzKokyakuAtesakiBean.setIrToiawasetelno("(12)1234-5678");
            khSouhuannaiBean.setIrSouhuannaimsg1("いつもお引立てをいただきありがとうございます。");
            khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
            khSouhuannaiBean.setIrSyono(null);
            khSouhuannaiBean.setIrSyouhnnm("商品名");
            khSouhuannaiBean.setIrHhknnmkj("被保険者名（漢字）");
            khSouhuannaiBean.setIrSyosaihkymd(null);
            khSouhuannaiBean.setIrTyouhyoutitle("円建年金保険への変更手続きのご案内");
            khSouhuannaiBean.setIrSyoruicd(C_SyoruiCdKbn.KK_YENDTHNK_SOUHU);
            khSouhuannaiBean.setIrKykmsnkbn(C_KykMsnKbn.MISEINEN);
            khSouhuannaiBean.setIrMousideikoukbn(C_MousideIkouKbn.YENNENKIN);
            khSouhuannaiBean.setIrSyouhnhanteikekka(SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20);
            khSouhuannaiBean.setIrKykjyoutai(C_Kykjyoutai.HRKMTYUU);
            khSouhuannaiBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
            khSouhuannaiBean.setIrYendthnkymd("20201212");

            reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }


}
