package yuyu.report.hozen;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.hozen.bean.report.KhTtdkkanryouBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 *  お手続完了のお知らせ用クラス
 */
@RunWith(OrderedRunner.class)
public class KhTtdkkrDshrTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhTtdkkanryouBean khTtdkkanryouBean;

    @Inject
    private BzKokyakuAtesakiBean bzKokyakuAtesakiBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {
        try {

            ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("hozen", "khcommon", "KhTtdkkrDshrTest",
                    C_SyoruiCdKbn.KK_DSHR_TTDKKR );

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

            khTtdkkanryouBean.setIrTetudukisyukbn(null);
            khTtdkkanryouBean.setIrSyono("");
            khTtdkkanryouBean.setIrKyknmkj("");
            khTtdkkanryouBean.setIrShrymd("");
            khTtdkkanryouBean.setIrTekiyou1("");
            khTtdkkanryouBean.setIrKngkmeisai1(null);
            khTtdkkanryouBean.setIrBikou1("");
            khTtdkkanryouBean.setIrTekiyou2("");
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2("");

            khTtdkkanryouBean.setIrShrgk(null);
            khTtdkkanryouBean.setIrBanknmkj("三井住友銀行");
            khTtdkkanryouBean.setIrSitennmkj("");
            khTtdkkanryouBean.setIrYokinkbn(null);
            khTtdkkanryouBean.setIrKouzano("");
            khTtdkkanryouBean.setIrKzmeiginmkn("");

            khTtdkkanryouBean.setIrOsirasemongon1("");
            khTtdkkanryouBean.setIrOsirasemongon2("");
            khTtdkkanryouBean.setIrOsirasemongon3("");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
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
                createReport.createNewReportServiceBean("hozen", "khcommon", "KhTtdkkrDshrTest",
                    C_SyoruiCdKbn.KK_DSHR_TTDKKR );

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

            khTtdkkanryouBean.setIrTetudukisyukbn(null);
            khTtdkkanryouBean.setIrSyono(null);
            khTtdkkanryouBean.setIrKyknmkj(null);
            khTtdkkanryouBean.setIrShrymd(null);
            khTtdkkanryouBean.setIrTekiyou1(null);
            khTtdkkanryouBean.setIrKngkmeisai1(null);
            khTtdkkanryouBean.setIrBikou1(null);
            khTtdkkanryouBean.setIrTekiyou2(null);
            khTtdkkanryouBean.setIrKngkmeisai2(null);
            khTtdkkanryouBean.setIrBikou2(null);

            khTtdkkanryouBean.setIrShrgk(null);
            khTtdkkanryouBean.setIrBanknmkj("三井住友銀行");
            khTtdkkanryouBean.setIrSitennmkj(null);
            khTtdkkanryouBean.setIrYokinkbn(null);
            khTtdkkanryouBean.setIrKouzano(null);
            khTtdkkanryouBean.setIrKzmeiginmkn(null);

            khTtdkkanryouBean.setIrOsirasemongon1(null);
            khTtdkkanryouBean.setIrOsirasemongon2(null);
            khTtdkkanryouBean.setIrOsirasemongon3(null);

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
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
                createReport.createNewReportServiceBean("hozen", "khcommon", "KhTtdkkrDshrTest",
                    C_SyoruiCdKbn.KK_DSHR_TTDKKR );

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 9月 9日");
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

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.DSHR);
            khTtdkkanryouBean.setIrSyono("12345678987");
            khTtdkkanryouBean.setIrKyknmkj("契約者");
            khTtdkkanryouBean.setIrShrymd("2019年 9月 9日");
            khTtdkkanryouBean.setIrTekiyou1("配当金");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(0));
            khTtdkkanryouBean.setIrBikou1("備考１");
            khTtdkkanryouBean.setIrTekiyou2("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(0));
            khTtdkkanryouBean.setIrBikou2("備考２");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(0));
            khTtdkkanryouBean.setIrBanknmkj("三井住友銀行");
            khTtdkkanryouBean.setIrSitennmkj("東京中央支店");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK );
            khTtdkkanryouBean.setIrKouzano("12345678");
            khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");

            khTtdkkanryouBean.setIrOsirasemongon1("＜ご連絡事項＞");
            khTtdkkanryouBean.setIrOsirasemongon2("　配当金は円貨でお支払いします。");
            khTtdkkanryouBean.setIrOsirasemongon3("今回のお支払の結果、　積立配当金残高は　100 円　になりました。");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
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
                createReport.createNewReportServiceBean("hozen", "khcommon", "KhTtdkkrDshrTest",
                    C_SyoruiCdKbn.KK_DSHR_TTDKKR );

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
            bzKokyakuAtesakiBean.setIrShsyno("9999999");
            bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
            bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
            khTtdkkanryouBean.setIrSyono("XXXXXXXXXXX");
            khTtdkkanryouBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrShrymd("9999年99月99日");
            khTtdkkanryouBean.setIrTekiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrBikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrTekiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrBikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(9999999999999L));
            khTtdkkanryouBean.setIrBanknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrSitennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.TOUZA );
            khTtdkkanryouBean.setIrKouzano("999999999999");
            khTtdkkanryouBean.setIrKzmeiginmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khTtdkkanryouBean.setIrOsirasemongon1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrOsirasemongon2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            khTtdkkanryouBean.setIrOsirasemongon3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
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
                createReport.createNewReportServiceBean("hozen", "khcommon", "KhTtdkkrDshrTest",
                    C_SyoruiCdKbn.KK_DSHR_TTDKKR );

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 9月 9日");
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

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.DSHR );
            khTtdkkanryouBean.setIrSyono("12345678987");
            khTtdkkanryouBean.setIrKyknmkj("契約者");
            khTtdkkanryouBean.setIrShrymd("2019年 9月 9日");
            khTtdkkanryouBean.setIrTekiyou1("配当金");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(999));
            khTtdkkanryouBean.setIrBikou1("備考１");
            khTtdkkanryouBean.setIrTekiyou2("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(222));
            khTtdkkanryouBean.setIrBikou2("備考２");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(333));
            khTtdkkanryouBean.setIrBanknmkj("三井住友銀行");
            khTtdkkanryouBean.setIrSitennmkj("東京中央支店");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.HUTUU );
            khTtdkkanryouBean.setIrKouzano("12345678");
            khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");

            khTtdkkanryouBean.setIrOsirasemongon1("＜ご連絡事項＞");
            khTtdkkanryouBean.setIrOsirasemongon2("　配当金は円貨でお支払いします。");
            khTtdkkanryouBean.setIrOsirasemongon3("今回のお支払の結果、　積立配当金残高は　100 円　になりました。");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
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
                createReport.createNewReportServiceBean("hozen", "khcommon", "KhTtdkkrDshrTest",
                    C_SyoruiCdKbn.KK_DSHR_TTDKKR );

            bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2019年 9月 9日");
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

            khTtdkkanryouBean.setIrTetudukisyukbn(C_TetudukisyuKbn.DSHR );
            khTtdkkanryouBean.setIrSyono("12345678987");
            khTtdkkanryouBean.setIrKyknmkj("契約者");
            khTtdkkanryouBean.setIrShrymd("2019年 9月 9日");
            khTtdkkanryouBean.setIrTekiyou1("配当金");
            khTtdkkanryouBean.setIrKngkmeisai1(BizCurrency.valueOf(1111));
            khTtdkkanryouBean.setIrBikou1("備考１");
            khTtdkkanryouBean.setIrTekiyou2("支払利息");
            khTtdkkanryouBean.setIrKngkmeisai2(BizCurrency.valueOf(2222));
            khTtdkkanryouBean.setIrBikou2("備考２");

            khTtdkkanryouBean.setIrShrgk(BizCurrency.valueOf(3333));
            khTtdkkanryouBean.setIrBanknmkj("");
            khTtdkkanryouBean.setIrSitennmkj("東京中央支店");
            khTtdkkanryouBean.setIrYokinkbn(C_YokinKbn.BLNK );
            khTtdkkanryouBean.setIrKouzano("12345678");
            khTtdkkanryouBean.setIrKzmeiginmkn("送金先口座名義");

            khTtdkkanryouBean.setIrOsirasemongon1("＜ご連絡事項＞");
            khTtdkkanryouBean.setIrOsirasemongon2("　配当金は円貨でお支払いします。");
            khTtdkkanryouBean.setIrOsirasemongon3("今回のお支払の結果、　積立配当金残高は　100 円　になりました。");

            reportTestBean.addParamObjects(khTtdkkanryouBean, bzKokyakuAtesakiBean);
            createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

}
