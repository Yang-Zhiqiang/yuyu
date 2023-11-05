package yuyu.report.sinkeiyaku;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.sinkeiyaku.bean.report.SkHandkarikanjyouBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ハンド仮勘定票帳票テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SkHandKariKanjyouTest extends AbstractTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkHandkarikanjyouBean skHandkarikanjoBean;


    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHandKariKanjyou", C_SyoruiCdKbn.SK_HANDKARIKANJYOU);

        skHandkarikanjoBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        skHandkarikanjoBean.setIrKanjyoukmknm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHandkarikanjoBean.setIrHndkarikanjyono(99999);
        skHandkarikanjoBean.setIrMosno("XXXXXXXXX");
        skHandkarikanjoBean.setIrDenkihyouymd("ＷＷ99年99月99日");
        skHandkarikanjoBean.setIrDenymd("ＷＷ99年99月99日");
        skHandkarikanjoBean.setIrTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        skHandkarikanjoBean.setIrDengkhrktuuka("9,999,999,999.99 ＷＷＷ");
        skHandkarikanjoBean.setIrDengkyenkansan("999,999,999,999 円");
        skHandkarikanjoBean.setIrDenkwsratetekiymd("ＷＷ99年99月99日");
        skHandkarikanjoBean.setIrKinounm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHandkarikanjoBean.setIrSousasyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHandkarikanjoBean.setIrDenrenno("XXXXXXXXXXXXXXXXXXXX");
        skHandkarikanjoBean.setIrEdano(99);
        skHandkarikanjoBean.setIrSyoruicd(C_SyoruiCdKbn.SK_HANDKARIKANJYOU);

        reportTestBean.addParamObjects(skHandkarikanjoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHandKariKanjyou", C_SyoruiCdKbn.SK_HANDKARIKANJYOU);

        skHandkarikanjoBean.setIrTyouhyousakuseiymd("平成21年1月6日");
        skHandkarikanjoBean.setIrKanjyoukmknm("勘定科目名");
        skHandkarikanjoBean.setIrHndkarikanjyono(12349);
        skHandkarikanjoBean.setIrMosno("123456789");
        skHandkarikanjoBean.setIrDenkihyouymd("平成32年10月20日");
        skHandkarikanjoBean.setIrDenymd("平成43年9月19日");
        skHandkarikanjoBean.setIrTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skHandkarikanjoBean.setIrDengkhrktuuka("1,234,567,890.12 ドル");
        skHandkarikanjoBean.setIrDengkyenkansan("123,456,789,012 円");
        skHandkarikanjoBean.setIrDenkwsratetekiymd("平成54年7月23日");
        skHandkarikanjoBean.setIrKinounm("機能名");
        skHandkarikanjoBean.setIrSousasyanm("操作者名");
        skHandkarikanjoBean.setIrDenrenno("1234567890");
        skHandkarikanjoBean.setIrEdano(28);
        skHandkarikanjoBean.setIrSyoruicd(C_SyoruiCdKbn.SK_HANDKARIKANJYOU);

        reportTestBean.addParamObjects(skHandkarikanjoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHandKariKanjyou", C_SyoruiCdKbn.SK_HANDKARIKANJYOU);

        skHandkarikanjoBean.setIrTyouhyousakuseiymd("");
        skHandkarikanjoBean.setIrKanjyoukmknm("");
        skHandkarikanjoBean.setIrHndkarikanjyono(0);
        skHandkarikanjoBean.setIrMosno("");
        skHandkarikanjoBean.setIrDenkihyouymd("");
        skHandkarikanjoBean.setIrDenymd("");
        skHandkarikanjoBean.setIrTaisyakukbn(C_TaisyakuKbn.BLNK);
        skHandkarikanjoBean.setIrDengkhrktuuka("");
        skHandkarikanjoBean.setIrDengkyenkansan("");
        skHandkarikanjoBean.setIrDenkwsratetekiymd("");
        skHandkarikanjoBean.setIrKinounm("");
        skHandkarikanjoBean.setIrSousasyanm("");
        skHandkarikanjoBean.setIrDenrenno("");
        skHandkarikanjoBean.setIrEdano(0);
        skHandkarikanjoBean.setIrSyoruicd(C_SyoruiCdKbn.SK_HANDKARIKANJYOU);

        reportTestBean.addParamObjects(skHandkarikanjoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHandKariKanjyou", C_SyoruiCdKbn.SK_HANDKARIKANJYOU);

        skHandkarikanjoBean.setIrTyouhyousakuseiymd(null);
        skHandkarikanjoBean.setIrKanjyoukmknm(null);
        skHandkarikanjoBean.setIrHndkarikanjyono(null);
        skHandkarikanjoBean.setIrMosno(null);
        skHandkarikanjoBean.setIrDenkihyouymd(null);
        skHandkarikanjoBean.setIrDenymd(null);
        skHandkarikanjoBean.setIrTaisyakukbn(null);
        skHandkarikanjoBean.setIrDengkhrktuuka(null);
        skHandkarikanjoBean.setIrDengkyenkansan(null);
        skHandkarikanjoBean.setIrDenkwsratetekiymd(null);
        skHandkarikanjoBean.setIrKinounm(null);
        skHandkarikanjoBean.setIrSousasyanm(null);
        skHandkarikanjoBean.setIrDenrenno(null);
        skHandkarikanjoBean.setIrEdano(null);
        skHandkarikanjoBean.setIrSyoruicd(C_SyoruiCdKbn.SK_HANDKARIKANJYOU);

        reportTestBean.addParamObjects(skHandkarikanjoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHandKariKanjyou", C_SyoruiCdKbn.SK_HANDKARIKANJYOU_YENDT);

        skHandkarikanjoBean.setIrTyouhyousakuseiymd("平成21年1月6日");
        skHandkarikanjoBean.setIrKanjyoukmknm("勘定科目名");
        skHandkarikanjoBean.setIrHndkarikanjyono(12349);
        skHandkarikanjoBean.setIrMosno("123456789");
        skHandkarikanjoBean.setIrDenkihyouymd("平成32年10月20日");
        skHandkarikanjoBean.setIrDenymd("平成43年9月19日");
        skHandkarikanjoBean.setIrTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skHandkarikanjoBean.setIrDengkhrktuuka("1,234,567,890.12 ドル");
        skHandkarikanjoBean.setIrDengkyenkansan("123,456,789,012 円");
        skHandkarikanjoBean.setIrDenkwsratetekiymd("平成54年7月23日");
        skHandkarikanjoBean.setIrKinounm("機能名");
        skHandkarikanjoBean.setIrSousasyanm("操作者名");
        skHandkarikanjoBean.setIrDenrenno("1234567890");
        skHandkarikanjoBean.setIrEdano(28);
        skHandkarikanjoBean.setIrSyoruicd(C_SyoruiCdKbn.SK_HANDKARIKANJYOU_YENDT);

        reportTestBean.addParamObjects(skHandkarikanjoBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
