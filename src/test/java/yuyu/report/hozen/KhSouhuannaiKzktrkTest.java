package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhSouhuannaiBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 家族登録・契約者代理特約変更の送付案内帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhSouhuannaiKzktrkTest {

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
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "KhSouhuannaiKzktrkTest",
                C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SOUHU);

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
        khSouhuannaiBean.setIrTyouhyoutitle("");
        khSouhuannaiBean.setIrSyono("");
        khSouhuannaiBean.setIrSksnm("");
        khSouhuannaiBean.setIrMousideninkbn(C_MousideninKbn.KYKHONNIN);
        khSouhuannaiBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.SETTEI);

        reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "KhSouhuannaiKzktrkTest",
                C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SOUHU);

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
        khSouhuannaiBean.setIrTyouhyoutitle(null);
        khSouhuannaiBean.setIrSyono(null);
        khSouhuannaiBean.setIrSksnm(null);
        khSouhuannaiBean.setIrMousideninkbn(C_MousideninKbn.KYKHONNIN);
        khSouhuannaiBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.SETTEI);

        reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "KhSouhuannaiKzktrkTest",
                C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SOUHU);

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
        khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
        khSouhuannaiBean.setIrTyouhyoutitle("ご家族登録サービス変更手続きのご案内");
        khSouhuannaiBean.setIrSyono("10000000001");
        khSouhuannaiBean.setIrSksnm("「ご家族登録サービス変更請求書」（同封しています）");
        khSouhuannaiBean.setIrMousideninkbn(C_MousideninKbn.KYKHONNIN);
        khSouhuannaiBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.SETTEI);

        reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "KhSouhuannaiKzktrkTest",
                C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");

        khSouhuannaiBean.setIrSouhuannaimsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSouhuannaiBean.setIrSouhuannaimsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSouhuannaiBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSouhuannaiBean.setIrSyono("wwwwwwwwwww");
        khSouhuannaiBean.setIrSksnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSouhuannaiBean.setIrMousideninkbn(C_MousideninKbn.KYKHONNIN);
        khSouhuannaiBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.SETTEI);

        reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "KhSouhuannaiKzktrkTest",
                C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SOUHU);

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
        khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
        khSouhuannaiBean.setIrTyouhyoutitle("ご家族登録サービス・保険契約者代理特約変更手続きのご案内");
        khSouhuannaiBean.setIrSyono("10000000001");
        khSouhuannaiBean.setIrSksnm("「ご家族登録サービス　兼　保険契約者代理特約変更請求書」（同封しています）");
        khSouhuannaiBean.setIrMousideninkbn(C_MousideninKbn.KYKHONNIN);
        khSouhuannaiBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);

        reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "KhSouhuannaiKzktrkTest",
                C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SOUHU);

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
        khSouhuannaiBean.setIrSouhuannaimsg2("お申し出いただきました手続きについて、以下のとおりご案内いたします。");
        khSouhuannaiBean.setIrTyouhyoutitle("ご家族登録サービス変更手続きのご案内");
        khSouhuannaiBean.setIrSyono("10000000001");
        khSouhuannaiBean.setIrSksnm("「ご家族登録サービス変更請求書」（同封しています）");
        khSouhuannaiBean.setIrMousideninkbn(C_MousideninKbn.HHKNHONNIN);
        khSouhuannaiBean.setIrKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.SETTEI);

        reportTestBean.addParamObjects(khSouhuannaiBean, bzKokyakuAtesakiBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

}
