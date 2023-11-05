package yuyu.report.sinkeiyaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzDairitenAtesakiBean;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.sinkeiyaku.bean.report.SkHubituutiBean;
import yuyu.def.sinkeiyaku.bean.report.SkHubituutityoubunDataSourceBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 不備通知書帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkHubiTuutiTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkHubituutiBean skHubituutiBean;

    @Inject
    private BzDairitenAtesakiBean bzDairitenAtesakiBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj(null);
        bzDairitenAtesakiBean.setIrTratkitantounmkj(null);
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi(null);
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1(null);
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2(null);
        bzDairitenAtesakiBean.setIrDrtenhassouymd(null);
        bzDairitenAtesakiBean.setIrToiawasetantounm(null);
        bzDairitenAtesakiBean.setIrToiawasetelno(null);
        bzDairitenAtesakiBean.setIrToiawasefaxno(null);

        skHubituutiBean.setIrMosno(null);
        skHubituutiBean.setIrAitemosno(null);
        skHubituutiBean.setIrDrtenjimcd(null);
        skHubituutiBean.setIrKyknmkj(null);
        skHubituutiBean.setIrHhknnmkj(null);
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1(null);
        skHubituutiBean.setIrSkhubinaiyou1(null);
        skHubituutiBean.setIrSkseibisijinaiyou1(null);
        skHubituutiBean.setIrSkrenrakujikou1(null);

        skHubituutiBean.setIrSkhubikoumoku2(null);
        skHubituutiBean.setIrSkhubinaiyou2(null);
        skHubituutiBean.setIrSkseibisijinaiyou2(null);
        skHubituutiBean.setIrSkrenrakujikou2(null);

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(1);

        skHubituutiBean.setIrOyadrtencd(null);
        skHubituutiBean.setIrAisyoumei(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku(null);
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou(null);
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou(null);
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou(null);

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("");
        bzDairitenAtesakiBean.setIrDrtenhassouymd("");
        bzDairitenAtesakiBean.setIrToiawasetantounm("");
        bzDairitenAtesakiBean.setIrToiawasetelno("");
        bzDairitenAtesakiBean.setIrToiawasefaxno("");

        skHubituutiBean.setIrMosno("");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("");
        skHubituutiBean.setIrKyknmkj("");
        skHubituutiBean.setIrHhknnmkj("");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("");
        skHubituutiBean.setIrSkhubinaiyou1("");
        skHubituutiBean.setIrSkseibisijinaiyou1("");
        skHubituutiBean.setIrSkrenrakujikou1("");

        skHubituutiBean.setIrSkhubikoumoku2("");
        skHubituutiBean.setIrSkhubinaiyou2("");
        skHubituutiBean.setIrSkseibisijinaiyou2("");
        skHubituutiBean.setIrSkrenrakujikou2("");

        skHubituutiBean.setIrSkhubikoumoku3("");
        skHubituutiBean.setIrSkhubinaiyou3("");
        skHubituutiBean.setIrSkseibisijinaiyou3("");
        skHubituutiBean.setIrSkrenrakujikou3("");

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(1);

        skHubituutiBean.setIrOyadrtencd("");
        skHubituutiBean.setIrAisyoumei("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("100-000-002");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(2);
        skHubituutiBean.setIrTuujyououthubikensuu(3);

        skHubituutiBean.setIrOyadrtencd(YuyuSinkeiyakuConfig.getInstance().getSmbcnikkousyouken());
        skHubituutiBean.setIrAisyoumei("生命保険");
        skHubituutiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 2; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwwww");

        skHubituutiBean.setIrMosno("wwwwwwwwwww");
        skHubituutiBean.setIrAitemosno("wwwwwwwwwww");
        skHubituutiBean.setIrDrtenjimcd("9999");
        skHubituutiBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkhubinaiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkseibisijinaiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkhubinaiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkseibisijinaiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkhubinaiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkseibisijinaiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷ");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷ");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno(null);
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");
        skHubituutiBean.setIrOyadrtencd("1234567");
        skHubituutiBean.setIrKarisakuseiumu(C_UmuKbn.NONE);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(2);
        skHubituutiBean.setIrAisyoumei("生命保険");
        skHubituutiBean.setIrKarisakuseiumu(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_DOUITU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2(null);
        skHubituutiBean.setIrSkhubinaiyou2(null);
        skHubituutiBean.setIrSkseibisijinaiyou2(null);
        skHubituutiBean.setIrSkrenrakujikou2(null);

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(2);
        skHubituutiBean.setIrTuujyououthubikensuu(1);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 2; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_DOUITU);

        skHubituutiBean.setIrSkhubikoumoku1(null);
        skHubituutiBean.setIrSkhubinaiyou1(null);
        skHubituutiBean.setIrSkseibisijinaiyou1(null);
        skHubituutiBean.setIrSkrenrakujikou1(null);

        skHubituutiBean.setIrSkhubikoumoku2(null);
        skHubituutiBean.setIrSkhubinaiyou2(null);
        skHubituutiBean.setIrSkseibisijinaiyou2(null);
        skHubituutiBean.setIrSkrenrakujikou2(null);

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(3);
        skHubituutiBean.setIrTuujyououthubikensuu(0);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 3; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_DOUITU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2(null);
        skHubituutiBean.setIrSkhubinaiyou2(null);
        skHubituutiBean.setIrSkseibisijinaiyou2(null);
        skHubituutiBean.setIrSkrenrakujikou2(null);

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(1);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1(null);
        skHubituutiBean.setIrSkhubinaiyou1(null);
        skHubituutiBean.setIrSkseibisijinaiyou1(null);
        skHubituutiBean.setIrSkrenrakujikou1(null);

        skHubituutiBean.setIrSkhubikoumoku2(null);
        skHubituutiBean.setIrSkhubinaiyou2(null);
        skHubituutiBean.setIrSkseibisijinaiyou2(null);
        skHubituutiBean.setIrSkrenrakujikou2(null);

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(46);
        skHubituutiBean.setIrTuujyououthubikensuu(0);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean1 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean2 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean3 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean4 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean5 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean6 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean7 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean8 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean9 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean10 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean11 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean12 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean13 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean14 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean15 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean16 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean17 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean18 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean19 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean20 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean21 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean22 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean23 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean24 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean25 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean26 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean27 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean28 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean29 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean30 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean31 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean32 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean33 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean34 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean35 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean36 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean37 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean38 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean39 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean40 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean41 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean42 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean43 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean44 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean45 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean46 = new SkHubituutityoubunDataSourceBean();

        skHubituutityoubunDataSourceBean1.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean1.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean1.setIrSkseibisijinaiyou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷ");
        skHubituutityoubunDataSourceBean1.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean2.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean2.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean2.setIrSkseibisijinaiyou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷ");
        skHubituutityoubunDataSourceBean2.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");


        skHubituutityoubunDataSourceBean3.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean3.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean3.setIrSkseibisijinaiyou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷ");
        skHubituutityoubunDataSourceBean3.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean4.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean4.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean4.setIrSkseibisijinaiyou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutityoubunDataSourceBean4.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean5.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean5.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean5.setIrSkseibisijinaiyou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutityoubunDataSourceBean5.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean6.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean6.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean6.setIrSkseibisijinaiyou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutityoubunDataSourceBean6.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean7.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean7.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean7.setIrSkseibisijinaiyou("Ｗ\nＷ\nＷ");
        skHubituutityoubunDataSourceBean7.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean8.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean8.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean8.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean8.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean9.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean9.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean9.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean9.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean10.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean10.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean10.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean10.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean11.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean11.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean11.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean11.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean12.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean12.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean12.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean12.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean13.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean13.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean13.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean13.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean14.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean14.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean14.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean14.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean15.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean15.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean15.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean15.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean16.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean16.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean16.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean16.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean17.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean17.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean17.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean17.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean18.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean18.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean18.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean18.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean19.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean19.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean19.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean19.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean20.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean20.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean20.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean20.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean21.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean21.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean21.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean21.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean22.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean22.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean22.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean22.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean23.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean23.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean23.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean23.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean24.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean24.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean24.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean24.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean25.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean25.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean25.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean25.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean26.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean26.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean26.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean26.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean27.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean27.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean27.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean27.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean28.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean28.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean28.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean28.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷ");

        skHubituutityoubunDataSourceBean29.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean29.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean29.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean29.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷ");

        skHubituutityoubunDataSourceBean30.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean30.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean30.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean30.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean31.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean31.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean31.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean31.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "Ｗ");

        skHubituutityoubunDataSourceBean32.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean32.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean32.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean32.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷ");

        skHubituutityoubunDataSourceBean33.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean33.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean33.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean33.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷ");

        skHubituutityoubunDataSourceBean34.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean34.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean34.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean34.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean35.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean35.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean35.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean35.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean36.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean36.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean36.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean36.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "Ｗ");

        skHubituutityoubunDataSourceBean37.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean37.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean37.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean37.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean38.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean38.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean38.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean38.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean39.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean39.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean39.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean39.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean40.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean40.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean40.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean40.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean41.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean41.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean41.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean41.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean42.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean42.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean42.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean42.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean43.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean43.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean43.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean43.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean44.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean44.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean44.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean44.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean45.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean45.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean45.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean45.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean46.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean46.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean46.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean46.setIrSkrenrakujikou("Ｗ\nＷ\nＷ\nＷ\nＷ\nＷ\nＷ\nＷ\nＷ\nＷ\nＷ\nＷ\nＷ\n"
            + "Ｗ\nＷ");

        dataSouceList.add(skHubituutityoubunDataSourceBean1);
        dataSouceList.add(skHubituutityoubunDataSourceBean2);
        dataSouceList.add(skHubituutityoubunDataSourceBean3);
        dataSouceList.add(skHubituutityoubunDataSourceBean4);
        dataSouceList.add(skHubituutityoubunDataSourceBean5);
        dataSouceList.add(skHubituutityoubunDataSourceBean6);
        dataSouceList.add(skHubituutityoubunDataSourceBean7);
        dataSouceList.add(skHubituutityoubunDataSourceBean8);
        dataSouceList.add(skHubituutityoubunDataSourceBean9);
        dataSouceList.add(skHubituutityoubunDataSourceBean10);
        dataSouceList.add(skHubituutityoubunDataSourceBean11);
        dataSouceList.add(skHubituutityoubunDataSourceBean12);
        dataSouceList.add(skHubituutityoubunDataSourceBean13);
        dataSouceList.add(skHubituutityoubunDataSourceBean14);
        dataSouceList.add(skHubituutityoubunDataSourceBean15);
        dataSouceList.add(skHubituutityoubunDataSourceBean16);
        dataSouceList.add(skHubituutityoubunDataSourceBean17);
        dataSouceList.add(skHubituutityoubunDataSourceBean18);
        dataSouceList.add(skHubituutityoubunDataSourceBean19);
        dataSouceList.add(skHubituutityoubunDataSourceBean20);
        dataSouceList.add(skHubituutityoubunDataSourceBean21);
        dataSouceList.add(skHubituutityoubunDataSourceBean22);
        dataSouceList.add(skHubituutityoubunDataSourceBean23);
        dataSouceList.add(skHubituutityoubunDataSourceBean24);
        dataSouceList.add(skHubituutityoubunDataSourceBean25);
        dataSouceList.add(skHubituutityoubunDataSourceBean26);
        dataSouceList.add(skHubituutityoubunDataSourceBean27);
        dataSouceList.add(skHubituutityoubunDataSourceBean28);
        dataSouceList.add(skHubituutityoubunDataSourceBean29);
        dataSouceList.add(skHubituutityoubunDataSourceBean30);
        dataSouceList.add(skHubituutityoubunDataSourceBean31);
        dataSouceList.add(skHubituutityoubunDataSourceBean32);
        dataSouceList.add(skHubituutityoubunDataSourceBean33);
        dataSouceList.add(skHubituutityoubunDataSourceBean34);
        dataSouceList.add(skHubituutityoubunDataSourceBean35);
        dataSouceList.add(skHubituutityoubunDataSourceBean36);
        dataSouceList.add(skHubituutityoubunDataSourceBean37);
        dataSouceList.add(skHubituutityoubunDataSourceBean38);
        dataSouceList.add(skHubituutityoubunDataSourceBean39);
        dataSouceList.add(skHubituutityoubunDataSourceBean40);
        dataSouceList.add(skHubituutityoubunDataSourceBean41);
        dataSouceList.add(skHubituutityoubunDataSourceBean42);
        dataSouceList.add(skHubituutityoubunDataSourceBean43);
        dataSouceList.add(skHubituutityoubunDataSourceBean44);
        dataSouceList.add(skHubituutityoubunDataSourceBean45);
        dataSouceList.add(skHubituutityoubunDataSourceBean46);

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("Ｗ\nＷ\nＷ");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("Ｗ\nＷ\nＷ");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("Ｗ\nＷ\nＷ");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testCreateReport21(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testCreateReport22(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testCreateReport23(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testCreateReport24(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testCreateReport25(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testCreateReport26(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("Ｗ\nＷ\nＷ\nＷ\nＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("Ｗ\nＷ\nＷ\nＷ\nＷ");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("Ｗ\nＷ\nＷ\nＷ\nＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testCreateReport27(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(2);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testCreateReport28(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(2);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(290)
    @Transactional
    public void testCreateReport29(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(2);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(300)
    @Transactional
    public void testCreateReport30(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(2);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(310)
    @Transactional
    public void testCreateReport31(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(2);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(320)
    @Transactional
    public void testCreateReport32(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(2);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(330)
    @Transactional
    public void testCreateReport33(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("Ｗ\nＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(2);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(340)
    @Transactional
    public void testCreateReport34(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("");
        skHubituutiBean.setIrSkhubinaiyou1("");
        skHubituutiBean.setIrSkseibisijinaiyou1("");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("");
        skHubituutiBean.setIrSkhubinaiyou2("");
        skHubituutiBean.setIrSkseibisijinaiyou2("");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("");
        skHubituutiBean.setIrSkhubinaiyou3("");
        skHubituutiBean.setIrSkseibisijinaiyou3("");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(350)
    @Transactional
    public void testCreateReport35(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1(null);
        skHubituutiBean.setIrSkhubinaiyou1(null);
        skHubituutiBean.setIrSkseibisijinaiyou1(null);
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2(null);
        skHubituutiBean.setIrSkhubinaiyou2(null);
        skHubituutiBean.setIrSkseibisijinaiyou2(null);
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();


        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(360)
    @Transactional
    public void testCreateReport36(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(370)
    @Transactional
    public void testCreateReport37(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1(null);

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2(null);

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(380)
    @Transactional
    public void testCreateReport38(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1("機機機機機機機機機機機機関名１");
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2("（機機機機機機機機機機機機関名２）");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-303");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(2);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        skHubituutiBean.setIrOyadrtencd(YuyuSinkeiyakuConfig.getInstance().getSmbcsintakubank());

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 2; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(390)
    @Transactional
    public void testCreateReport39(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj(null);
        bzDairitenAtesakiBean.setIrTratkitantounmkj(null);
        bzDairitenAtesakiBean.setIrDrtenhassouymd(null);
        bzDairitenAtesakiBean.setIrToiawasetantounm(null);
        bzDairitenAtesakiBean.setIrToiawasetelno(null);
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi(null);
        bzDairitenAtesakiBean.setIrToiawasefaxno(null);
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno(null);
        skHubituutiBean.setIrAitemosno(null);
        skHubituutiBean.setIrDrtenjimcd(null);
        skHubituutiBean.setIrKyknmkj(null);
        skHubituutiBean.setIrHhknnmkj(null);
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1(null);
        skHubituutiBean.setIrSkhubinaiyou1(null);
        skHubituutiBean.setIrSkseibisijinaiyou1(null);
        skHubituutiBean.setIrSkrenrakujikou1(null);

        skHubituutiBean.setIrSkhubikoumoku2(null);
        skHubituutiBean.setIrSkhubinaiyou2(null);
        skHubituutiBean.setIrSkseibisijinaiyou2(null);
        skHubituutiBean.setIrSkrenrakujikou2(null);

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(1);
        skHubituutiBean.setIrOyadrtencd(null);
        skHubituutiBean.setIrAisyoumei(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku(null);
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou(null);
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou(null);
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou(null);

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(400)
    @Transactional
    public void testCreateReport40(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("");
        bzDairitenAtesakiBean.setIrDrtenhassouymd("");
        bzDairitenAtesakiBean.setIrToiawasetantounm("");
        bzDairitenAtesakiBean.setIrToiawasetelno("");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("");
        bzDairitenAtesakiBean.setIrToiawasefaxno("");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("");
        skHubituutiBean.setIrKyknmkj("");
        skHubituutiBean.setIrHhknnmkj("");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("");
        skHubituutiBean.setIrSkhubinaiyou1("");
        skHubituutiBean.setIrSkseibisijinaiyou1("");
        skHubituutiBean.setIrSkrenrakujikou1("");

        skHubituutiBean.setIrSkhubikoumoku2("");
        skHubituutiBean.setIrSkhubinaiyou2("");
        skHubituutiBean.setIrSkseibisijinaiyou2("");
        skHubituutiBean.setIrSkrenrakujikou2("");

        skHubituutiBean.setIrSkhubikoumoku3("");
        skHubituutiBean.setIrSkhubinaiyou3("");
        skHubituutiBean.setIrSkseibisijinaiyou3("");
        skHubituutiBean.setIrSkrenrakujikou3("");

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(1);
        skHubituutiBean.setIrOyadrtencd("");
        skHubituutiBean.setIrAisyoumei("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(410)
    @Transactional
    public void testCreateReport41(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("100-000-002");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(2);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");
        skHubituutiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 2; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(420)
    @Transactional
    public void testCreateReport42(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenhassouymd("99月99日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("wwww");
        bzDairitenAtesakiBean.setIrToiawasefaxno("wwwwwwwwwwwwwww");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("wwwwwwwwwww");
        skHubituutiBean.setIrAitemosno("wwwwwwwwwww");
        skHubituutiBean.setIrDrtenjimcd("9999");
        skHubituutiBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkhubinaiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkseibisijinaiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkhubinaiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkseibisijinaiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkhubinaiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkseibisijinaiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrOyadrtencd(YuyuSinkeiyakuConfig.getInstance().getSmbcnikkousyouken());
        skHubituutiBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷ");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
                + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(430)
    @Transactional
    public void testCreateReport43(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno(null);
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1(null);
        skHubituutiBean.setIrSkhubinaiyou1(null);
        skHubituutiBean.setIrSkseibisijinaiyou1(null);
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2(null);
        skHubituutiBean.setIrSkhubinaiyou2(null);
        skHubituutiBean.setIrSkseibisijinaiyou2(null);
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");
        skHubituutiBean.setIrKarisakuseiumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(440)
    @Transactional
    public void testCreateReport44(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("");
        skHubituutiBean.setIrSkhubinaiyou1("");
        skHubituutiBean.setIrSkseibisijinaiyou1("");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("");
        skHubituutiBean.setIrSkhubinaiyou2("");
        skHubituutiBean.setIrSkseibisijinaiyou2("");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("");
        skHubituutiBean.setIrSkhubinaiyou3("");
        skHubituutiBean.setIrSkseibisijinaiyou3("");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");
        skHubituutiBean.setIrKarisakuseiumu(null);

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(450)
    @Transactional
    public void testCreateReport45(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1(null);

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2(null);

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(460)
    @Transactional
    public void testCreateReport46(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(470)
    @Transactional
    public void testCreateReport47(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(480)
    @Transactional
    public void testCreateReport48(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(2);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(490)
    @Transactional
    public void testCreateReport49(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_DOUITU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2(null);
        skHubituutiBean.setIrSkhubinaiyou2(null);
        skHubituutiBean.setIrSkseibisijinaiyou2(null);
        skHubituutiBean.setIrSkrenrakujikou2(null);

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(2);
        skHubituutiBean.setIrTuujyououthubikensuu(1);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 2; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(500)
    @Transactional
    public void testCreateReport50(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_DOUITU);

        skHubituutiBean.setIrSkhubikoumoku1(null);
        skHubituutiBean.setIrSkhubinaiyou1(null);
        skHubituutiBean.setIrSkseibisijinaiyou1(null);
        skHubituutiBean.setIrSkrenrakujikou1(null);

        skHubituutiBean.setIrSkhubikoumoku2(null);
        skHubituutiBean.setIrSkhubinaiyou2(null);
        skHubituutiBean.setIrSkseibisijinaiyou2(null);
        skHubituutiBean.setIrSkrenrakujikou2(null);

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(3);
        skHubituutiBean.setIrTuujyououthubikensuu(0);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 3; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(510)
    @Transactional
    public void testCreateReport51(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_DOUITU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2(null);
        skHubituutiBean.setIrSkhubinaiyou2(null);
        skHubituutiBean.setIrSkseibisijinaiyou2(null);
        skHubituutiBean.setIrSkrenrakujikou2(null);

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(1);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(520)
    @Transactional
    public void testCreateReport52(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1(null);
        skHubituutiBean.setIrSkhubinaiyou1(null);
        skHubituutiBean.setIrSkseibisijinaiyou1(null);
        skHubituutiBean.setIrSkrenrakujikou1(null);

        skHubituutiBean.setIrSkhubikoumoku2(null);
        skHubituutiBean.setIrSkhubinaiyou2(null);
        skHubituutiBean.setIrSkseibisijinaiyou2(null);
        skHubituutiBean.setIrSkrenrakujikou2(null);

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(46);
        skHubituutiBean.setIrTuujyououthubikensuu(0);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean1 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean2 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean3 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean4 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean5 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean6 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean7 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean8 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean9 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean10 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean11 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean12 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean13 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean14 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean15 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean16 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean17 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean18 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean19 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean20 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean21 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean22 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean23 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean24 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean25 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean26 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean27 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean28 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean29 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean30 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean31 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean32 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean33 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean34 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean35 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean36 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean37 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean38 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean39 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean40 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean41 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean42 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean43 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean44 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean45 = new SkHubituutityoubunDataSourceBean();
        SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean46 = new SkHubituutityoubunDataSourceBean();

        skHubituutityoubunDataSourceBean1.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean1.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean1.setIrSkseibisijinaiyou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷ");
        skHubituutityoubunDataSourceBean1.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean2.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean2.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean2.setIrSkseibisijinaiyou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷ");
        skHubituutityoubunDataSourceBean2.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");


        skHubituutityoubunDataSourceBean3.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean3.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean3.setIrSkseibisijinaiyou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷ");
        skHubituutityoubunDataSourceBean3.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean4.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean4.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean4.setIrSkseibisijinaiyou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutityoubunDataSourceBean4.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean5.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean5.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean5.setIrSkseibisijinaiyou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutityoubunDataSourceBean5.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean6.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean6.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean6.setIrSkseibisijinaiyou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutityoubunDataSourceBean6.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean7.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean7.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean7.setIrSkseibisijinaiyou("Ｗ\nＷ\nＷ");
        skHubituutityoubunDataSourceBean7.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean8.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean8.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean8.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean8.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean9.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean9.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean9.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean9.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean10.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean10.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean10.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean10.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean11.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean11.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean11.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean11.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean12.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean12.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean12.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean12.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean13.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean13.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean13.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean13.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean14.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean14.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean14.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean14.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean15.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean15.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean15.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean15.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean16.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean16.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean16.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean16.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean17.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean17.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean17.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean17.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean18.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean18.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean18.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean18.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean19.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean19.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean19.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean19.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean20.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean20.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean20.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean20.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean21.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean21.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean21.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean21.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean22.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean22.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean22.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean22.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean23.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean23.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean23.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean23.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean24.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean24.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean24.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean24.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean25.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean25.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean25.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean25.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean26.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean26.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean26.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean26.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean27.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean27.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean27.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean27.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean28.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean28.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean28.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean28.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷ");

        skHubituutityoubunDataSourceBean29.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean29.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean29.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean29.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷ");

        skHubituutityoubunDataSourceBean30.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean30.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean30.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean30.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean31.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean31.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean31.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean31.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "Ｗ");

        skHubituutityoubunDataSourceBean32.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean32.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean32.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean32.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷ");

        skHubituutityoubunDataSourceBean33.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean33.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean33.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean33.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷ");

        skHubituutityoubunDataSourceBean34.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean34.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean34.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean34.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean35.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean35.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean35.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean35.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean36.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean36.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean36.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean36.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "Ｗ");

        skHubituutityoubunDataSourceBean37.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean37.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean37.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean37.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean38.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean38.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean38.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean38.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean39.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean39.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean39.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean39.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean40.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean40.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean40.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean40.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean41.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean41.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean41.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean41.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean42.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean42.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean42.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean42.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean43.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean43.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean43.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean43.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean44.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean44.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean44.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean44.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean45.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean45.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean45.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean45.setIrSkrenrakujikou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutityoubunDataSourceBean46.setIrSkhubikoumoku("不備項目");
        skHubituutityoubunDataSourceBean46.setIrSkhubinaiyou("不備内容");
        skHubituutityoubunDataSourceBean46.setIrSkseibisijinaiyou("新契約整備指示内容");
        skHubituutityoubunDataSourceBean46.setIrSkrenrakujikou("Ｗ\nＷ\nＷ\nＷ\nＷ\nＷ\nＷ\nＷ\nＷ\nＷ\nＷ\nＷ\nＷ\n"
            + "Ｗ\nＷ");

        dataSouceList.add(skHubituutityoubunDataSourceBean1);
        dataSouceList.add(skHubituutityoubunDataSourceBean2);
        dataSouceList.add(skHubituutityoubunDataSourceBean3);
        dataSouceList.add(skHubituutityoubunDataSourceBean4);
        dataSouceList.add(skHubituutityoubunDataSourceBean5);
        dataSouceList.add(skHubituutityoubunDataSourceBean6);
        dataSouceList.add(skHubituutityoubunDataSourceBean7);
        dataSouceList.add(skHubituutityoubunDataSourceBean8);
        dataSouceList.add(skHubituutityoubunDataSourceBean9);
        dataSouceList.add(skHubituutityoubunDataSourceBean10);
        dataSouceList.add(skHubituutityoubunDataSourceBean11);
        dataSouceList.add(skHubituutityoubunDataSourceBean12);
        dataSouceList.add(skHubituutityoubunDataSourceBean13);
        dataSouceList.add(skHubituutityoubunDataSourceBean14);
        dataSouceList.add(skHubituutityoubunDataSourceBean15);
        dataSouceList.add(skHubituutityoubunDataSourceBean16);
        dataSouceList.add(skHubituutityoubunDataSourceBean17);
        dataSouceList.add(skHubituutityoubunDataSourceBean18);
        dataSouceList.add(skHubituutityoubunDataSourceBean19);
        dataSouceList.add(skHubituutityoubunDataSourceBean20);
        dataSouceList.add(skHubituutityoubunDataSourceBean21);
        dataSouceList.add(skHubituutityoubunDataSourceBean22);
        dataSouceList.add(skHubituutityoubunDataSourceBean23);
        dataSouceList.add(skHubituutityoubunDataSourceBean24);
        dataSouceList.add(skHubituutityoubunDataSourceBean25);
        dataSouceList.add(skHubituutityoubunDataSourceBean26);
        dataSouceList.add(skHubituutityoubunDataSourceBean27);
        dataSouceList.add(skHubituutityoubunDataSourceBean28);
        dataSouceList.add(skHubituutityoubunDataSourceBean29);
        dataSouceList.add(skHubituutityoubunDataSourceBean30);
        dataSouceList.add(skHubituutityoubunDataSourceBean31);
        dataSouceList.add(skHubituutityoubunDataSourceBean32);
        dataSouceList.add(skHubituutityoubunDataSourceBean33);
        dataSouceList.add(skHubituutityoubunDataSourceBean34);
        dataSouceList.add(skHubituutityoubunDataSourceBean35);
        dataSouceList.add(skHubituutityoubunDataSourceBean36);
        dataSouceList.add(skHubituutityoubunDataSourceBean37);
        dataSouceList.add(skHubituutityoubunDataSourceBean38);
        dataSouceList.add(skHubituutityoubunDataSourceBean39);
        dataSouceList.add(skHubituutityoubunDataSourceBean40);
        dataSouceList.add(skHubituutityoubunDataSourceBean41);
        dataSouceList.add(skHubituutityoubunDataSourceBean42);
        dataSouceList.add(skHubituutityoubunDataSourceBean43);
        dataSouceList.add(skHubituutityoubunDataSourceBean44);
        dataSouceList.add(skHubituutityoubunDataSourceBean45);
        dataSouceList.add(skHubituutityoubunDataSourceBean46);

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(530)
    @Transactional
    public void testCreateReport53(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(540)
    @Transactional
    public void testCreateReport54(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(550)
    @Transactional
    public void testCreateReport55(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(560)
    @Transactional
    public void testCreateReport56(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(570)
    @Transactional
    public void testCreateReport57(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(580)
    @Transactional
    public void testCreateReport58(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(590)
    @Transactional
    public void testCreateReport59(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("Ｗ\nＷ\nＷ");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("Ｗ\nＷ\nＷ");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("Ｗ\nＷ\nＷ");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(600)
    @Transactional
    public void testCreateReport60(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(610)
    @Transactional
    public void testCreateReport61(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(620)
    @Transactional
    public void testCreateReport62(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(630)
    @Transactional
    public void testCreateReport63(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(640)
    @Transactional
    public void testCreateReport64(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(650)
    @Transactional
    public void testCreateReport65(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(660)
    @Transactional
    public void testCreateReport66(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(670)
    @Transactional
    public void testCreateReport67(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(680)
    @Transactional
    public void testCreateReport68(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("Ｗ\nＷ\nＷ\nＷ\nＷ");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("Ｗ\nＷ\nＷ\nＷ\nＷ");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("Ｗ\nＷ\nＷ\nＷ\nＷ");

        skHubituutiBean.setIrTyoubunouthubikensuu(0);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        reportTestBean.addParamObjects(skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(690)
    @Transactional
    public void testCreateReport69(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.SHOP);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(2);
        skHubituutiBean.setIrTuujyououthubikensuu(1);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 2; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(700)
    @Transactional
    public void testCreateReport70(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(710)
    @Transactional
    public void testCreateReport71(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(720)
    @Transactional
    public void testCreateReport72(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(730)
    @Transactional
    public void testCreateReport73(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(740)
    @Transactional
    public void testCreateReport74(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(750)
    @Transactional
    public void testCreateReport75(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(760)
    @Transactional
    public void testCreateReport76(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(770)
    @Transactional
    public void testCreateReport77(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(780)
    @Transactional
    public void testCreateReport78(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("Ｗ\nＷ\nＷ");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("Ｗ\nＷ");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("新契約不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("新契約不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(790)
    @Transactional
    public void testCreateReport79(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(2);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 2; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(800)
    @Transactional
    public void testCreateReport80(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(2);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 2; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(810)
    @Transactional
    public void testCreateReport81(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(2);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 2; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(820)
    @Transactional
    public void testCreateReport82(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(2);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 2; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(830)
    @Transactional
    public void testCreateReport83(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("田中　太郎");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_BETU);

        skHubituutiBean.setIrSkhubikoumoku1("不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1("不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2("不備項目（2件目）");
        skHubituutiBean.setIrSkhubinaiyou2("不備内容（2件目）");
        skHubituutiBean.setIrSkseibisijinaiyou2("新契約整備指示内容（2件目）");
        skHubituutiBean.setIrSkrenrakujikou2("新契約連絡事項（2件目）");

        skHubituutiBean.setIrSkhubikoumoku3("不備項目（3件目）");
        skHubituutiBean.setIrSkhubinaiyou3("不備内容（3件目）");
        skHubituutiBean.setIrSkseibisijinaiyou3("新契約整備指示内容（3件目）");
        skHubituutiBean.setIrSkrenrakujikou3("新契約連絡事項（3件目）");

        skHubituutiBean.setIrTyoubunouthubikensuu(2);
        skHubituutiBean.setIrTuujyououthubikensuu(3);
        skHubituutiBean.setIrAisyoumei("Ｗ\nＷ");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 2; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(840)
    @Transactional
    public void testCreateReport84(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_DOUITU);

        skHubituutiBean.setIrSkhubikoumoku1("新契約不備項目（1件目）");
        skHubituutiBean.setIrSkhubinaiyou1(null);
        skHubituutiBean.setIrSkseibisijinaiyou1(null);
        skHubituutiBean.setIrSkrenrakujikou1(null);

        skHubituutiBean.setIrSkhubikoumoku2(null);
        skHubituutiBean.setIrSkhubinaiyou2(null);
        skHubituutiBean.setIrSkseibisijinaiyou2(null);
        skHubituutiBean.setIrSkrenrakujikou2(null);

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(1);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(850)
    @Transactional
    public void testCreateReport85(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_DOUITU);

        skHubituutiBean.setIrSkhubikoumoku1(null);
        skHubituutiBean.setIrSkhubinaiyou1("新契約不備内容（1件目）");
        skHubituutiBean.setIrSkseibisijinaiyou1(null);
        skHubituutiBean.setIrSkrenrakujikou1(null);

        skHubituutiBean.setIrSkhubikoumoku2(null);
        skHubituutiBean.setIrSkhubinaiyou2(null);
        skHubituutiBean.setIrSkseibisijinaiyou2(null);
        skHubituutiBean.setIrSkrenrakujikou2(null);

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(1);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(860)
    @Transactional
    public void testCreateReport86(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_DOUITU);

        skHubituutiBean.setIrSkhubikoumoku1(null);
        skHubituutiBean.setIrSkhubinaiyou1(null);
        skHubituutiBean.setIrSkseibisijinaiyou1("新契約整備指示内容（1件目）");
        skHubituutiBean.setIrSkrenrakujikou1(null);

        skHubituutiBean.setIrSkhubikoumoku2(null);
        skHubituutiBean.setIrSkhubinaiyou2(null);
        skHubituutiBean.setIrSkseibisijinaiyou2(null);
        skHubituutiBean.setIrSkrenrakujikou2(null);

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(1);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(870)
    @Transactional
    public void testCreateReport87(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHubiTuutiTest", C_SyoruiCdKbn.SK_HUBITUUTI);

        bzDairitenAtesakiBean.setIrDrtennmkj("ＳＭＢＣ信託銀行");
        bzDairitenAtesakiBean.setIrTratkitantounmkj("取扱者担当者１");
        bzDairitenAtesakiBean.setIrDrtenhassouymd(" 7月10日");
        bzDairitenAtesakiBean.setIrToiawasetantounm("問合せ先担当者１");
        bzDairitenAtesakiBean.setIrToiawasetelno("0120-232-507");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi("FAX：");
        bzDairitenAtesakiBean.setIrToiawasefaxno("06-6937-1137");
        bzDairitenAtesakiBean.setIrSkeijimukbn(C_SkeijimuKbn.MIZUHO);

        skHubituutiBean.setIrMosno("100-000-001");
        skHubituutiBean.setIrAitemosno("");
        skHubituutiBean.setIrDrtenjimcd("0123");
        skHubituutiBean.setIrKyknmkj("");
        skHubituutiBean.setIrHhknnmkj("田中　次郎");
        skHubituutiBean.setIrKykkbn(C_KykKbn.KEIHI_DOUITU);

        skHubituutiBean.setIrSkhubikoumoku1(null);
        skHubituutiBean.setIrSkhubinaiyou1(null);
        skHubituutiBean.setIrSkseibisijinaiyou1(null);
        skHubituutiBean.setIrSkrenrakujikou1("新契約連絡事項（1件目）");

        skHubituutiBean.setIrSkhubikoumoku2(null);
        skHubituutiBean.setIrSkhubinaiyou2(null);
        skHubituutiBean.setIrSkseibisijinaiyou2(null);
        skHubituutiBean.setIrSkrenrakujikou2(null);

        skHubituutiBean.setIrSkhubikoumoku3(null);
        skHubituutiBean.setIrSkhubinaiyou3(null);
        skHubituutiBean.setIrSkseibisijinaiyou3(null);
        skHubituutiBean.setIrSkrenrakujikou3(null);

        skHubituutiBean.setIrTyoubunouthubikensuu(1);
        skHubituutiBean.setIrTuujyououthubikensuu(1);
        skHubituutiBean.setIrAisyoumei("生命保険");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 1; i++) {
            SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean = new SkHubituutityoubunDataSourceBean();

            skHubituutityoubunDataSourceBean.setIrSkhubikoumoku("不備項目");
            skHubituutityoubunDataSourceBean.setIrSkhubinaiyou("不備内容");
            skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou("新契約整備指示内容");
            skHubituutityoubunDataSourceBean.setIrSkrenrakujikou("新契約連絡事項");

            dataSouceList.add(skHubituutityoubunDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skHubituutiBean, bzDairitenAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}