package yuyu.report.sinkeiyaku;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzDairitenAtesakiBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.sinkeiyaku.bean.report.SkHenkiniraisyoSouhuBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 返金依頼書（送付案内）帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkHenkiniraisyoSouhuTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzDairitenAtesakiBean bzDairitenAtesakiBean;

    @Inject
    private SkHenkiniraisyoSouhuBean skHenkiniraisyoSouhuBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_henkiniraisyo_souhu", C_SyoruiCdKbn.SK_HENKINIRAISYO_SOUHU);

        skHenkiniraisyoSouhuBean.setIrMosno(null);
        skHenkiniraisyoSouhuBean.setIrKyknmkj(null);
        skHenkiniraisyoSouhuBean.setIrSyokairsymd(null);
        skHenkiniraisyoSouhuBean.setIrRsgaku(null);
        skHenkiniraisyoSouhuBean.setIrDai1kaip(null);
        skHenkiniraisyoSouhuBean.setIrKajyoup(null);
        skHenkiniraisyoSouhuBean.setIrKajyoupumu(C_UmuKbn.ARI);
        skHenkiniraisyoSouhuBean.setIrNyknnrkumu(C_UmuKbn.ARI);

        bzDairitenAtesakiBean.setIrDrtennmkj(null);
        bzDairitenAtesakiBean.setIrTratkitantounmkj(null);
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1(null);
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2(null);
        bzDairitenAtesakiBean.setIrHknkisynm(null);
        bzDairitenAtesakiBean.setIrToiawasesosiki(null);
        bzDairitenAtesakiBean.setIrToiawasetelno(null);
        bzDairitenAtesakiBean.setIrToiawasefaxno(null);
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi(null);

        reportTestBean.addParamObjects(skHenkiniraisyoSouhuBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_henkiniraisyo_souhu", C_SyoruiCdKbn.SK_HENKINIRAISYO_SOUHU);

        skHenkiniraisyoSouhuBean.setIrMosno("");
        skHenkiniraisyoSouhuBean.setIrKyknmkj("");
        skHenkiniraisyoSouhuBean.setIrSyokairsymd(null);
        skHenkiniraisyoSouhuBean.setIrRsgaku(null);
        skHenkiniraisyoSouhuBean.setIrDai1kaip(null);
        skHenkiniraisyoSouhuBean.setIrKajyoup(null);
        skHenkiniraisyoSouhuBean.setIrKajyoupumu(C_UmuKbn.ARI);
        skHenkiniraisyoSouhuBean.setIrNyknnrkumu(C_UmuKbn.ARI);

        bzDairitenAtesakiBean.setIrDrtennmkj("");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("");
        bzDairitenAtesakiBean.setIrHknkisynm("");
        bzDairitenAtesakiBean.setIrToiawasesosiki("");
        bzDairitenAtesakiBean.setIrToiawasetelno("");
        bzDairitenAtesakiBean.setIrToiawasefaxno("");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("");

        reportTestBean.addParamObjects(skHenkiniraisyoSouhuBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_henkiniraisyo_souhu", C_SyoruiCdKbn.SK_HENKINIRAISYO_SOUHU);

        skHenkiniraisyoSouhuBean.setIrMosno("860000017");
        skHenkiniraisyoSouhuBean.setIrKyknmkj("契約者名");
        skHenkiniraisyoSouhuBean.setIrSyokairsymd(BizDate.valueOf(20181201));
        skHenkiniraisyoSouhuBean.setIrRsgaku(BizCurrency.valueOf(3000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrDai1kaip(BizCurrency.valueOf(4000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoup(BizCurrency.valueOf(6000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoupumu(C_UmuKbn.ARI);
        skHenkiniraisyoSouhuBean.setIrNyknnrkumu(C_UmuKbn.ARI);

        bzDairitenAtesakiBean.setIrDrtennmkj("みずほ銀行　新宿支店");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("住生　太郎");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("みずほ銀行");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（ビジネスサービス部）");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-783");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");

        reportTestBean.addParamObjects(skHenkiniraisyoSouhuBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_henkiniraisyo_souhu", C_SyoruiCdKbn.SK_HENKINIRAISYO_SOUHU);

        skHenkiniraisyoSouhuBean.setIrMosno("wwwwwwwww");
        skHenkiniraisyoSouhuBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHenkiniraisyoSouhuBean.setIrSyokairsymd(BizDate.valueOf(20991228));
        skHenkiniraisyoSouhuBean.setIrRsgaku(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrDai1kaip(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoup(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoupumu(C_UmuKbn.ARI);
        skHenkiniraisyoSouhuBean.setIrNyknnrkumu(C_UmuKbn.ARI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ）");
        bzDairitenAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");

        reportTestBean.addParamObjects(skHenkiniraisyoSouhuBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_henkiniraisyo_souhu", C_SyoruiCdKbn.SK_HENKINIRAISYO_SOUHU);

        skHenkiniraisyoSouhuBean.setIrMosno("860000017");
        skHenkiniraisyoSouhuBean.setIrKyknmkj("契約者名");
        skHenkiniraisyoSouhuBean.setIrSyokairsymd(BizDate.valueOf(20180101));
        skHenkiniraisyoSouhuBean.setIrRsgaku(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrDai1kaip(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoup(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoupumu(C_UmuKbn.ARI);
        skHenkiniraisyoSouhuBean.setIrNyknnrkumu(C_UmuKbn.ARI);

        bzDairitenAtesakiBean.setIrDrtennmkj("みずほ銀行　新宿支店");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("住生　太郎");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("みずほ銀行");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（ビジネスサービス部）");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-783");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");

        reportTestBean.addParamObjects(skHenkiniraisyoSouhuBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_henkiniraisyo_souhu", C_SyoruiCdKbn.SK_HENKINIRAISYO_SOUHU);

        skHenkiniraisyoSouhuBean.setIrMosno("860000017");
        skHenkiniraisyoSouhuBean.setIrKyknmkj("契約者名");
        skHenkiniraisyoSouhuBean.setIrSyokairsymd(BizDate.valueOf(20180101));
        skHenkiniraisyoSouhuBean.setIrRsgaku(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrDai1kaip(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoup(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoupumu(C_UmuKbn.ARI);
        skHenkiniraisyoSouhuBean.setIrNyknnrkumu(C_UmuKbn.ARI);

        bzDairitenAtesakiBean.setIrDrtennmkj("みずほ銀行　新宿支店");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("住生　太郎");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("みずほ銀行");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（ビジネスサービス部）");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-783");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");

        reportTestBean.addParamObjects(skHenkiniraisyoSouhuBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_henkiniraisyo_souhu", C_SyoruiCdKbn.SK_HENKINIRAISYO_SOUHU);

        skHenkiniraisyoSouhuBean.setIrMosno("860000017");
        skHenkiniraisyoSouhuBean.setIrKyknmkj("契約者名");
        skHenkiniraisyoSouhuBean.setIrSyokairsymd(BizDate.valueOf(20180101));
        skHenkiniraisyoSouhuBean.setIrRsgaku(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrDai1kaip(BizCurrency.valueOf(9.4, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoup(BizCurrency.valueOf(9.7, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoupumu(C_UmuKbn.ARI);
        skHenkiniraisyoSouhuBean.setIrNyknnrkumu(C_UmuKbn.ARI);

        bzDairitenAtesakiBean.setIrDrtennmkj("みずほ銀行　新宿支店");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("住生　太郎");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("みずほ銀行");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（ビジネスサービス部）");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-783");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");

        reportTestBean.addParamObjects(skHenkiniraisyoSouhuBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_henkiniraisyo_souhu", C_SyoruiCdKbn.SK_HENKINIRAISYO_SOUHU);

        skHenkiniraisyoSouhuBean.setIrMosno("860000017");
        skHenkiniraisyoSouhuBean.setIrKyknmkj("契約者名");
        skHenkiniraisyoSouhuBean.setIrSyokairsymd(BizDate.valueOf(20180101));
        skHenkiniraisyoSouhuBean.setIrRsgaku(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrDai1kaip(BizCurrency.valueOf(9.55, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoup(BizCurrency.valueOf(9.88, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoupumu(C_UmuKbn.ARI);
        skHenkiniraisyoSouhuBean.setIrNyknnrkumu(C_UmuKbn.ARI);

        bzDairitenAtesakiBean.setIrDrtennmkj("みずほ銀行　新宿支店");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("住生　太郎");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("みずほ銀行");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（ビジネスサービス部）");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-783");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");

        reportTestBean.addParamObjects(skHenkiniraisyoSouhuBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_henkiniraisyo_souhu", C_SyoruiCdKbn.SK_HENKINIRAISYO_SOUHU);

        skHenkiniraisyoSouhuBean.setIrMosno("860000017");
        skHenkiniraisyoSouhuBean.setIrKyknmkj("契約者名");
        skHenkiniraisyoSouhuBean.setIrSyokairsymd(BizDate.valueOf(20180101));
        skHenkiniraisyoSouhuBean.setIrRsgaku(BizCurrency.valueOf(9.222, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrDai1kaip(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoup(BizCurrency.valueOf(9.444, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoupumu(C_UmuKbn.ARI);
        skHenkiniraisyoSouhuBean.setIrNyknnrkumu(C_UmuKbn.ARI);

        bzDairitenAtesakiBean.setIrDrtennmkj("みずほ銀行　新宿支店");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("住生　太郎");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("みずほ銀行");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（ビジネスサービス部）");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-783");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");

        reportTestBean.addParamObjects(skHenkiniraisyoSouhuBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_henkiniraisyo_souhu", C_SyoruiCdKbn.SK_HENKINIRAISYO_SOUHU);

        skHenkiniraisyoSouhuBean.setIrMosno("860000017");
        skHenkiniraisyoSouhuBean.setIrKyknmkj("契約者名");
        skHenkiniraisyoSouhuBean.setIrSyokairsymd(BizDate.valueOf(20180101));
        skHenkiniraisyoSouhuBean.setIrRsgaku(BizCurrency.valueOf(3000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrDai1kaip(BizCurrency.valueOf(4000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoup(BizCurrency.valueOf(6000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoupumu(C_UmuKbn.NONE);
        skHenkiniraisyoSouhuBean.setIrNyknnrkumu(C_UmuKbn.ARI);

        bzDairitenAtesakiBean.setIrDrtennmkj("みずほ銀行　新宿支店");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("住生　太郎");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("みずほ銀行");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（ビジネスサービス部）");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-783");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");

        reportTestBean.addParamObjects(skHenkiniraisyoSouhuBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_henkiniraisyo_souhu", C_SyoruiCdKbn.SK_HENKINIRAISYO_SOUHU);

        skHenkiniraisyoSouhuBean.setIrMosno("860000017");
        skHenkiniraisyoSouhuBean.setIrKyknmkj("契約者名");
        skHenkiniraisyoSouhuBean.setIrSyokairsymd(BizDate.valueOf(20180101));
        skHenkiniraisyoSouhuBean.setIrRsgaku(BizCurrency.valueOf(3000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrDai1kaip(BizCurrency.valueOf(4000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoup(BizCurrency.valueOf(6000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoupumu(C_UmuKbn.NONE);
        skHenkiniraisyoSouhuBean.setIrNyknnrkumu(C_UmuKbn.NONE);

        bzDairitenAtesakiBean.setIrDrtennmkj("みずほ銀行　新宿支店");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("住生　太郎");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("みずほ銀行");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（ビジネスサービス部）");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-783");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");

        reportTestBean.addParamObjects(skHenkiniraisyoSouhuBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_henkiniraisyo_souhu", C_SyoruiCdKbn.SK_HENKINIRAISYO_SOUHU);

        skHenkiniraisyoSouhuBean.setIrMosno("860000017");
        skHenkiniraisyoSouhuBean.setIrKyknmkj("契約者名");
        skHenkiniraisyoSouhuBean.setIrSyokairsymd(BizDate.valueOf(20180101));
        skHenkiniraisyoSouhuBean.setIrRsgaku(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrDai1kaip(BizCurrency.valueOf(4000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoup(BizCurrency.valueOf(6000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoupumu(C_UmuKbn.ARI);
        skHenkiniraisyoSouhuBean.setIrNyknnrkumu(C_UmuKbn.ARI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（ＷＷＷＷＷＷＷＷＷＷ）");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-783");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");

        reportTestBean.addParamObjects(skHenkiniraisyoSouhuBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_henkiniraisyo_souhu", C_SyoruiCdKbn.SK_HENKINIRAISYO_SOUHU);

        skHenkiniraisyoSouhuBean.setIrMosno("860000017");
        skHenkiniraisyoSouhuBean.setIrKyknmkj("契約者名");
        skHenkiniraisyoSouhuBean.setIrSyokairsymd(BizDate.valueOf(20180101));
        skHenkiniraisyoSouhuBean.setIrRsgaku(BizCurrency.valueOf(3000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrDai1kaip(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoup(BizCurrency.valueOf(6000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoupumu(C_UmuKbn.ARI);
        skHenkiniraisyoSouhuBean.setIrNyknnrkumu(C_UmuKbn.ARI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（ＷＷＷＷＷＷＷＷＷＷＷ）");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-783");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");

        reportTestBean.addParamObjects(skHenkiniraisyoSouhuBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_henkiniraisyo_souhu", C_SyoruiCdKbn.SK_HENKINIRAISYO_SOUHU);

        skHenkiniraisyoSouhuBean.setIrMosno("860000017");
        skHenkiniraisyoSouhuBean.setIrKyknmkj("契約者名");
        skHenkiniraisyoSouhuBean.setIrSyokairsymd(BizDate.valueOf(20180101));
        skHenkiniraisyoSouhuBean.setIrRsgaku(BizCurrency.valueOf(3000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrDai1kaip(BizCurrency.valueOf(4000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoup(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoupumu(C_UmuKbn.ARI);
        skHenkiniraisyoSouhuBean.setIrNyknnrkumu(C_UmuKbn.ARI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（ＷＷＷＷＷＷＷＷＷＷＷＷ）");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-783");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");

        reportTestBean.addParamObjects(skHenkiniraisyoSouhuBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_henkiniraisyo_souhu", C_SyoruiCdKbn.SK_HENKINIRAISYO_SOUHU);

        skHenkiniraisyoSouhuBean.setIrMosno("860000017");
        skHenkiniraisyoSouhuBean.setIrKyknmkj("契約者名");
        skHenkiniraisyoSouhuBean.setIrSyokairsymd(BizDate.valueOf(20180101));
        skHenkiniraisyoSouhuBean.setIrRsgaku(BizCurrency.valueOf(3000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrDai1kaip(BizCurrency.valueOf(4000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoup(BizCurrency.valueOf(6000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoupumu(C_UmuKbn.ARI);
        skHenkiniraisyoSouhuBean.setIrNyknnrkumu(C_UmuKbn.ARI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("住生　太郎");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("みずほ銀行");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（ビジネスサービス部）");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-783");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");

        reportTestBean.addParamObjects(skHenkiniraisyoSouhuBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_henkiniraisyo_souhu", C_SyoruiCdKbn.SK_HENKINIRAISYO_SOUHU);

        skHenkiniraisyoSouhuBean.setIrMosno("860000017");
        skHenkiniraisyoSouhuBean.setIrKyknmkj("契約者名");
        skHenkiniraisyoSouhuBean.setIrSyokairsymd(BizDate.valueOf(20180101));
        skHenkiniraisyoSouhuBean.setIrRsgaku(BizCurrency.valueOf(3000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrDai1kaip(BizCurrency.valueOf(4000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoup(BizCurrency.valueOf(6000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoupumu(C_UmuKbn.ARI);
        skHenkiniraisyoSouhuBean.setIrNyknnrkumu(C_UmuKbn.ARI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("住生　太郎");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("みずほ銀行");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（ビジネスサービス部）");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-783");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");

        reportTestBean.addParamObjects(skHenkiniraisyoSouhuBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_henkiniraisyo_souhu", C_SyoruiCdKbn.SK_HENKINIRAISYO_SOUHU);

        skHenkiniraisyoSouhuBean.setIrMosno("860000017");
        skHenkiniraisyoSouhuBean.setIrKyknmkj("契約者名");
        skHenkiniraisyoSouhuBean.setIrSyokairsymd(BizDate.valueOf(20180101));
        skHenkiniraisyoSouhuBean.setIrRsgaku(BizCurrency.valueOf(3000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrDai1kaip(BizCurrency.valueOf(4000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoup(BizCurrency.valueOf(6000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoupumu(C_UmuKbn.ARI);
        skHenkiniraisyoSouhuBean.setIrNyknnrkumu(C_UmuKbn.ARI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("住生　太郎");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("みずほ銀行");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（ビジネスサービス部）");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-783");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");

        reportTestBean.addParamObjects(skHenkiniraisyoSouhuBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_henkiniraisyo_souhu", C_SyoruiCdKbn.SK_HENKINIRAISYO_SOUHU);

        skHenkiniraisyoSouhuBean.setIrMosno("860000017");
        skHenkiniraisyoSouhuBean.setIrKyknmkj("契約者名");
        skHenkiniraisyoSouhuBean.setIrSyokairsymd(BizDate.valueOf(20180101));
        skHenkiniraisyoSouhuBean.setIrRsgaku(BizCurrency.valueOf(3000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrDai1kaip(BizCurrency.valueOf(4000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoup(BizCurrency.valueOf(6000, BizCurrencyTypes.AU_DOLLAR));
        skHenkiniraisyoSouhuBean.setIrKajyoupumu(C_UmuKbn.ARI);
        skHenkiniraisyoSouhuBean.setIrNyknnrkumu(C_UmuKbn.ARI);

        bzDairitenAtesakiBean.setIrDrtennmkj("Ｗ\nＷ\nＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("Ｗ\nＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("Ｗ\nＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（Ｗ\nＷ）");
        bzDairitenAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzDairitenAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-783");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");

        reportTestBean.addParamObjects(skHenkiniraisyoSouhuBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
