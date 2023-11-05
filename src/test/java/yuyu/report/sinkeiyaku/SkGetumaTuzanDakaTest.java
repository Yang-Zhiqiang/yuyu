package yuyu.report.sinkeiyaku;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SkGetumatuzandakaBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 月末残高チェックリスト（新契約）帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkGetumaTuzanDakaTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private  SkGetumatuzandakaBean skGetumatuzandakaBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkGetumaTuzanDakaTest", C_SyoruiCdKbn.SK_GETUMATUZANDAKACHKLIST);

        skGetumatuzandakaBean.setIrAtesaki(null);
        skGetumatuzandakaBean.setIrTyouhyousakuseiymd(null);
        skGetumatuzandakaBean.setIrSyuukeiym(null);
        skGetumatuzandakaBean.setIrGkkrkhuho2enfst(null);
        skGetumatuzandakaBean.setIrGkkrkhuho2enpkakin(null);
        skGetumatuzandakaBean.setIrGkkrkhuho2dorufstden(null);
        skGetumatuzandakaBean.setIrGkkrkhuho2dorufst(null);
        skGetumatuzandakaBean.setIrGkkrkhuho2dorupkakinden(null);
        skGetumatuzandakaBean.setIrGkkrkhuho2dorupkakin(null);
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorufstden(null);
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorufst(null);
        skGetumatuzandakaBean.setIrGkkrkhuho2audpkakinden(null);
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorupkakin(null);

        reportTestBean.addParamObjects(skGetumatuzandakaBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkGetumaTuzanDakaTest", C_SyoruiCdKbn.SK_GETUMATUZANDAKACHKLIST);

        skGetumatuzandakaBean.setIrAtesaki("");
        skGetumatuzandakaBean.setIrTyouhyousakuseiymd("");
        skGetumatuzandakaBean.setIrSyuukeiym("");
        skGetumatuzandakaBean.setIrGkkrkhuho2enfst(BizCurrency.valueOf(0));
        skGetumatuzandakaBean.setIrGkkrkhuho2enpkakin(BizCurrency.valueOf(0));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorufstden(BizCurrency.valueOf(0));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorufst(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorupkakinden(BizCurrency.valueOf(0));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorupkakin(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorufstden(BizCurrency.valueOf(0));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorufst(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2audpkakinden(BizCurrency.valueOf(0));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorupkakin(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        reportTestBean.addParamObjects(skGetumatuzandakaBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkGetumaTuzanDakaTest", C_SyoruiCdKbn.SK_GETUMATUZANDAKACHKLIST);

        skGetumatuzandakaBean.setIrAtesaki("代理店契約室　御中");
        skGetumatuzandakaBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skGetumatuzandakaBean.setIrSyuukeiym("平成21年 7月");
        skGetumatuzandakaBean.setIrGkkrkhuho2enfst(BizCurrency.valueOf(9999));
        skGetumatuzandakaBean.setIrGkkrkhuho2enpkakin(BizCurrency.valueOf(9999));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorufstden(BizCurrency.valueOf(9999));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorufst(BizCurrency.valueOf(9999, BizCurrencyTypes.DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorupkakinden(BizCurrency.valueOf(9999));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorupkakin(BizCurrency.valueOf(9999, BizCurrencyTypes.DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorufstden(BizCurrency.valueOf(9999));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorufst(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2audpkakinden(BizCurrency.valueOf(9999));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorupkakin(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skGetumatuzandakaBean.setIrSyoruicd(C_SyoruiCdKbn.SK_GETUMATUZANDAKACHKLIST);

        reportTestBean.addParamObjects(skGetumatuzandakaBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkGetumaTuzanDakaTest", C_SyoruiCdKbn.SK_GETUMATUZANDAKACHKLIST);

        skGetumatuzandakaBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skGetumatuzandakaBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        skGetumatuzandakaBean.setIrSyuukeiym("ＷＷ99年99月");
        skGetumatuzandakaBean.setIrGkkrkhuho2enfst(BizCurrency.valueOf(99999999999999L));
        skGetumatuzandakaBean.setIrGkkrkhuho2enpkakin(BizCurrency.valueOf(99999999999999L));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorufstden(BizCurrency.valueOf(99999999999999L));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorufst(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorupkakinden(BizCurrency.valueOf(99999999999999L));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorupkakin(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorufstden(BizCurrency.valueOf(99999999999999L));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorufst(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2audpkakinden(BizCurrency.valueOf(99999999999999L));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorupkakin(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));

        reportTestBean.addParamObjects(skGetumatuzandakaBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkGetumaTuzanDakaTest", C_SyoruiCdKbn.SK_GETUMATUZANDAKACHKLIST);

        skGetumatuzandakaBean.setIrAtesaki("代理店契約室　御中");
        skGetumatuzandakaBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skGetumatuzandakaBean.setIrSyuukeiym("平成21年 7月");
        skGetumatuzandakaBean.setIrGkkrkhuho2enfst(BizCurrency.valueOf(999));
        skGetumatuzandakaBean.setIrGkkrkhuho2enpkakin(BizCurrency.valueOf(999));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorufstden(BizCurrency.valueOf(999));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorufst(BizCurrency.valueOf(999, BizCurrencyTypes.DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorupkakinden(BizCurrency.valueOf(999));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorupkakin(BizCurrency.valueOf(999, BizCurrencyTypes.DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorufstden(BizCurrency.valueOf(999));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorufst(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2audpkakinden(BizCurrency.valueOf(999));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorupkakin(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));

        reportTestBean.addParamObjects(skGetumatuzandakaBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkGetumaTuzanDakaTest", C_SyoruiCdKbn.SK_GETUMATUZANDAKACHKLIST);

        skGetumatuzandakaBean.setIrAtesaki("代理店契約室　御中");
        skGetumatuzandakaBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skGetumatuzandakaBean.setIrSyuukeiym("平成21年 7月");
        skGetumatuzandakaBean.setIrGkkrkhuho2enfst(BizCurrency.valueOf(9.1));
        skGetumatuzandakaBean.setIrGkkrkhuho2enpkakin(BizCurrency.valueOf(9.1));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorufstden(BizCurrency.valueOf(9.1));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorufst(BizCurrency.valueOf(9.1, BizCurrencyTypes.DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorupkakinden(BizCurrency.valueOf(9.1));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorupkakin(BizCurrency.valueOf(9.1, BizCurrencyTypes.DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorufstden(BizCurrency.valueOf(9.1));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorufst(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2audpkakinden(BizCurrency.valueOf(9.1));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorupkakin(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));

        reportTestBean.addParamObjects(skGetumatuzandakaBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkGetumaTuzanDakaTest", C_SyoruiCdKbn.SK_GETUMATUZANDAKACHKLIST);

        skGetumatuzandakaBean.setIrAtesaki("代理店契約室　御中");
        skGetumatuzandakaBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skGetumatuzandakaBean.setIrSyuukeiym("平成21年 7月");
        skGetumatuzandakaBean.setIrGkkrkhuho2enfst(BizCurrency.valueOf(9.22));
        skGetumatuzandakaBean.setIrGkkrkhuho2enpkakin(BizCurrency.valueOf(9.22));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorufstden(BizCurrency.valueOf(9.22));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorufst(BizCurrency.valueOf(9.22, BizCurrencyTypes.DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorupkakinden(BizCurrency.valueOf(9.22));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorupkakin(BizCurrency.valueOf(9.22, BizCurrencyTypes.DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorufstden(BizCurrency.valueOf(9.22));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorufst(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2audpkakinden(BizCurrency.valueOf(9.22));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorupkakin(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));

        reportTestBean.addParamObjects(skGetumatuzandakaBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkGetumaTuzanDakaTest", C_SyoruiCdKbn.SK_GETUMATUZANDAKACHKLIST);

        skGetumatuzandakaBean.setIrAtesaki("代理店契約室　御中");
        skGetumatuzandakaBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skGetumatuzandakaBean.setIrSyuukeiym("平成21年 7月");
        skGetumatuzandakaBean.setIrGkkrkhuho2enfst(BizCurrency.valueOf(9.333));
        skGetumatuzandakaBean.setIrGkkrkhuho2enpkakin(BizCurrency.valueOf(9.333));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorufstden(BizCurrency.valueOf(9.333));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorufst(BizCurrency.valueOf(9.333, BizCurrencyTypes.DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorupkakinden(BizCurrency.valueOf(9.333));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorupkakin(BizCurrency.valueOf(9.333, BizCurrencyTypes.DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorufstden(BizCurrency.valueOf(9.333));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorufst(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2audpkakinden(BizCurrency.valueOf(9.333));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorupkakin(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));

        reportTestBean.addParamObjects(skGetumatuzandakaBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkGetumaTuzanDakaTest", C_SyoruiCdKbn.SK_GETUMATUZANDAKACHKLIST);

        skGetumatuzandakaBean.setIrAtesaki("代理店契約室　御中");
        skGetumatuzandakaBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skGetumatuzandakaBean.setIrSyuukeiym("平成21年 7月");
        skGetumatuzandakaBean.setIrGkkrkhuho2enfst(BizCurrency.valueOf(100));
        skGetumatuzandakaBean.setIrGkkrkhuho2enpkakin(BizCurrency.valueOf(101));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorufstden(BizCurrency.valueOf(102));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorufst(BizCurrency.valueOf(103, BizCurrencyTypes.DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorupkakinden(BizCurrency.valueOf(104));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorupkakin(BizCurrency.valueOf(105, BizCurrencyTypes.DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorufstden(BizCurrency.valueOf(106));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorufst(BizCurrency.valueOf(107, BizCurrencyTypes.AU_DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2audpkakinden(BizCurrency.valueOf(108));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorupkakin(BizCurrency.valueOf(109, BizCurrencyTypes.AU_DOLLAR));

        reportTestBean.addParamObjects(skGetumatuzandakaBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkGetumaTuzanDakaTest", C_SyoruiCdKbn.SK_GETUMATUZANDAKACHKLIST_YENDT);

        skGetumatuzandakaBean.setIrAtesaki("代理店契約室　御中");
        skGetumatuzandakaBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skGetumatuzandakaBean.setIrSyuukeiym("平成21年 7月");
        skGetumatuzandakaBean.setIrGkkrkhuho2enfst(BizCurrency.valueOf(9999));
        skGetumatuzandakaBean.setIrGkkrkhuho2enpkakin(BizCurrency.valueOf(9999));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorufstden(BizCurrency.valueOf(9999));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorufst(BizCurrency.valueOf(9999, BizCurrencyTypes.DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorupkakinden(BizCurrency.valueOf(9999));
        skGetumatuzandakaBean.setIrGkkrkhuho2dorupkakin(BizCurrency.valueOf(9999, BizCurrencyTypes.DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorufstden(BizCurrency.valueOf(9999));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorufst(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skGetumatuzandakaBean.setIrGkkrkhuho2audpkakinden(BizCurrency.valueOf(9999));
        skGetumatuzandakaBean.setIrGkkrkhuho2goudorupkakin(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skGetumatuzandakaBean.setIrSyoruicd(C_SyoruiCdKbn.SK_GETUMATUZANDAKACHKLIST_YENDT);

        reportTestBean.addParamObjects(skGetumatuzandakaBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
