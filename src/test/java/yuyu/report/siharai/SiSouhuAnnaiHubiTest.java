package yuyu.report.siharai;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.siharai.bean.report.SiSouhuannaihubiBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 不備訂正書の送付案内帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiSouhuAnnaiHubiTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private  SiSouhuannaihubiBean siSouhuannaihubiBean;

    @Inject
    private  BzKokyakuAtesakiBean bzKokyakuAtesakiBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("wwwwwww");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("www-wwww");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");

        siSouhuannaihubiBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSouhuannaihubiBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSouhuannaihubiBean.setIrMsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSouhuannaihubiBean.setIrMsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSouhuannaihubiBean.setIrMsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSouhuannaihubiBean.setIrMsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSouhuannaihubiBean.setIrMsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSouhuannaihubiBean.setIrSyono("wwwwwwwwwww");
        siSouhuannaihubiBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            +"ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            +"ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            +"ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            +"ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            +"ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            +"ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            +"ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            +"ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            +"ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            );

        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("お手続の内容：名義変更\n契約者さまの性別のご記入がございませんでした。"
            +"同封の【書類整備に関する回答書】をご確認のうえ、ご整備をお願いいたします。");

        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

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
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj(null);
        bzKokyakuAtesakiBean.setIrHknkisynm(null);
        bzKokyakuAtesakiBean.setIrToiawasetelno(null);

        siSouhuannaihubiBean.setIrMsg1(null);
        siSouhuannaihubiBean.setIrMsg2(null);
        siSouhuannaihubiBean.setIrMsg3(null);
        siSouhuannaihubiBean.setIrMsg4(null);
        siSouhuannaihubiBean.setIrMsg5(null);
        siSouhuannaihubiBean.setIrMsg6(null);
        siSouhuannaihubiBean.setIrMsg7(null);
        siSouhuannaihubiBean.setIrSyono(null);
        siSouhuannaihubiBean.setIrHhknnmkj(null);
        siSouhuannaihubiBean.setIrHubirenrakuran(null);

        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

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
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("");
        bzKokyakuAtesakiBean.setIrHknkisynm("");
        bzKokyakuAtesakiBean.setIrToiawasetelno("");

        siSouhuannaihubiBean.setIrMsg1("");
        siSouhuannaihubiBean.setIrMsg2("");
        siSouhuannaihubiBean.setIrMsg3("");
        siSouhuannaihubiBean.setIrMsg4("");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("");
        siSouhuannaihubiBean.setIrHhknnmkj("");
        siSouhuannaihubiBean.setIrHubirenrakuran("");

        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");



        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");



        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");



        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");



        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");



        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");



        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");



        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");



        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");



        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");



        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");



        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testCreateReport21(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");



        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testCreateReport22(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");



        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testCreateReport23(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");



        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testCreateReport24(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");



        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testCreateReport25(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);
        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");



        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testCreateReport26(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");



        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testCreateReport27(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");



        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testCreateReport28(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");



        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(290)
    @Transactional
    public void testCreateReport29(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");



        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(300)
    @Transactional
    public void testCreateReport30(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(310)
    @Transactional
    public void testCreateReport31(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(320)
    @Transactional
    public void testCreateReport32(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(330)
    @Transactional
    public void testCreateReport33(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(340)
    @Transactional
    public void testCreateReport34(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ"
            + "ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(350)
    @Transactional
    public void testCreateReport35(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "SiSouhuAnnaiHubiTest", C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("平成26年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        siSouhuannaihubiBean.setIrMsg1("いつもお引立てをいただきありがとうございます。");
        siSouhuannaihubiBean.setIrMsg2("このたび、ご提出いただきました書類について、ご整備いただく事項がございます。");
        siSouhuannaihubiBean.setIrMsg3("お手数ですが、下記事項をご確認のうえ、書類整備に関する回答書・必要書類をご送付くだ");
        siSouhuannaihubiBean.setIrMsg4("さいますようお願いいたします。");
        siSouhuannaihubiBean.setIrMsg5("");
        siSouhuannaihubiBean.setIrMsg6("");
        siSouhuannaihubiBean.setIrMsg7("");
        siSouhuannaihubiBean.setIrSyono("10000000001");
        siSouhuannaihubiBean.setIrHhknnmkj("被保険者名（漢字）");
        siSouhuannaihubiBean.setIrHubirenrakuran("１\n２\n３\n４\n５\n６\n７\n８\n９\n０");

        reportTestBean.addParamObjects(siSouhuannaihubiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
