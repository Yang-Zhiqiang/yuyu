package yuyu.report.siharai;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.siharai.bean.report.SiShannaiBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 送付案内帳票テスト 用クラス
 */
@RunWith(OrderedRunner.class)
public class SiShannaiTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private  SiShannaiBean siShannaiBean;

    @Inject
    private  BzKokyakuAtesakiBean bzKokyakuAtesakiBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiShannaiTest", C_SyoruiCdKbn.HK_SOUHU);

        siShannaiBean.setIrSyono("");
        siShannaiBean.setIrTyouhyoutitle("");
        siShannaiBean.setIrMsg1("");
        siShannaiBean.setIrMsg2("");
        siShannaiBean.setIrMsg3("");
        siShannaiBean.setIrMsg4("");
        siShannaiBean.setIrMsg5("");
        siShannaiBean.setIrMsg6("");
        siShannaiBean.setIrMsg7("");
        siShannaiBean.setIrMsg8("");
        siShannaiBean.setIrMsg9("");
        siShannaiBean.setIrMsg10("");
        siShannaiBean.setIrMsg11("");
        siShannaiBean.setIrMsg12("");
        siShannaiBean.setIrMsg13("");
        siShannaiBean.setIrMsg14("");
        siShannaiBean.setIrMsg15("");
        siShannaiBean.setIrMsg16("");
        siShannaiBean.setIrMsg17("");
        siShannaiBean.setIrMsg18("");
        siShannaiBean.setIrMsg19("");
        siShannaiBean.setIrMsg20("");
        siShannaiBean.setIrMsg21("");
        siShannaiBean.setIrMsg22("");
        siShannaiBean.setIrMsg23("");
        siShannaiBean.setIrMsg24("");
        siShannaiBean.setIrMsg25("");
        siShannaiBean.setIrMsg26("");
        siShannaiBean.setIrMsg27("");
        siShannaiBean.setIrMsg28("");
        siShannaiBean.setIrMsg29("");
        siShannaiBean.setIrMsg30("");
        siShannaiBean.setIrMsg31("");
        siShannaiBean.setIrMsg32("");
        siShannaiBean.setIrMsg33("");
        siShannaiBean.setIrMsg34("");
        siShannaiBean.setIrMsg35("");
        siShannaiBean.setIrMsg36("");
        siShannaiBean.setIrMsg37("");

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

        reportTestBean.addParamObjects(siShannaiBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", null, "SiShannaiTest", C_SyoruiCdKbn.HK_SOUHU);

        siShannaiBean.setIrSyono(null);
        siShannaiBean.setIrTyouhyoutitle(null);
        siShannaiBean.setIrMsg1(null);
        siShannaiBean.setIrMsg2(null);
        siShannaiBean.setIrMsg3(null);
        siShannaiBean.setIrMsg4(null);
        siShannaiBean.setIrMsg5(null);
        siShannaiBean.setIrMsg6(null);
        siShannaiBean.setIrMsg7(null);
        siShannaiBean.setIrMsg8(null);
        siShannaiBean.setIrMsg9(null);
        siShannaiBean.setIrMsg10(null);
        siShannaiBean.setIrMsg11(null);
        siShannaiBean.setIrMsg12(null);
        siShannaiBean.setIrMsg13(null);
        siShannaiBean.setIrMsg14(null);
        siShannaiBean.setIrMsg15(null);
        siShannaiBean.setIrMsg16(null);
        siShannaiBean.setIrMsg17(null);
        siShannaiBean.setIrMsg18(null);
        siShannaiBean.setIrMsg19(null);
        siShannaiBean.setIrMsg20(null);
        siShannaiBean.setIrMsg21(null);
        siShannaiBean.setIrMsg22(null);
        siShannaiBean.setIrMsg23(null);
        siShannaiBean.setIrMsg24(null);
        siShannaiBean.setIrMsg25(null);
        siShannaiBean.setIrMsg26(null);
        siShannaiBean.setIrMsg27(null);
        siShannaiBean.setIrMsg28(null);
        siShannaiBean.setIrMsg29(null);
        siShannaiBean.setIrMsg30(null);
        siShannaiBean.setIrMsg31(null);
        siShannaiBean.setIrMsg32(null);
        siShannaiBean.setIrMsg33(null);
        siShannaiBean.setIrMsg34(null);
        siShannaiBean.setIrMsg35(null);
        siShannaiBean.setIrMsg36(null);
        siShannaiBean.setIrMsg37(null);

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

        reportTestBean.addParamObjects(siShannaiBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiShannaiTest", C_SyoruiCdKbn.HK_SOUHU);

        siShannaiBean.setIrSyono("10000000001");
        siShannaiBean.setIrTyouhyoutitle("死亡保険金請求手続きのご案内 ");
        siShannaiBean.setIrMsg1("このたびご訃報に接し、ご一同様にはさぞかしお力落としのことと謹んでお悔やみ申し上げます。");
        siShannaiBean.setIrMsg2("故人ご生前にはひとかたならぬご愛顧を賜り、誠にありがとうございました。");
        siShannaiBean.setIrMsg3("下記のとおりご案内申し上げますので、請求書類をお取りそろえのうえ、ご提出くださいますよう");
        siShannaiBean.setIrMsg4("お願い申し上げます。");
        siShannaiBean.setIrMsg5(null);
        siShannaiBean.setIrMsg6("【ご提出いただく書類】");
        siShannaiBean.setIrMsg7("　　　別添えの『ご提出書類について』をご確認ください。");
        siShannaiBean.setIrMsg8(null);
        siShannaiBean.setIrMsg9("　※この『死亡保険金請求手続きのご案内』は手続きが完了するまでの間、別添えの『ご提出書");
        siShannaiBean.setIrMsg10("　　類について』とあわせて保管くださいますようお願い申し上げます。");
        siShannaiBean.setIrMsg11(null);
        siShannaiBean.setIrMsg12("【円貨でのお支払いについて】");
        siShannaiBean.setIrMsg13("　・保険金を円貨によりお受け取りできます。");
        siShannaiBean.setIrMsg14("　　円貨でお受取りになる場合、為替レートの変動による影響を受けます。");
        siShannaiBean.setIrMsg15("　・円貨への換算に適用する為替レートは、請求日（整備された必要書類が当社に到着した日）");
        siShannaiBean.setIrMsg16("　　における、当社所定の為替レート「ＴＴＭ（対顧客電信売買相場仲値）－５０銭」となり");
        siShannaiBean.setIrMsg17("　　ます。");
        siShannaiBean.setIrMsg18("　・当社所定の為替レートは、住友生命ホームページにてご確認いただけます。");
        siShannaiBean.setIrMsg19(null);
        siShannaiBean.setIrMsg20("【指定通貨（外貨）でのお支払いについて】");
        siShannaiBean.setIrMsg21("　・保険金を指定された通貨（外貨）でお受け取りできます。指定通貨（外貨）でのお受取りが");
        siShannaiBean.setIrMsg22("　　可能な日本国内にある金融機関口座をご指定ください。");
        siShannaiBean.setIrMsg23("　　※円貨口座を記入されると、当社から送金した指定通貨（外貨）が自動的に円貨に両替され");
        siShannaiBean.setIrMsg24("　　　て入金される場合があります。 ");
        siShannaiBean.setIrMsg25(null);
        siShannaiBean.setIrMsg26("【初期死亡時円換算支払額最低保証特約について】");
        siShannaiBean.setIrMsg27("　・保険金の円換算額が基準金額を下回るときは、基準金額をお支払いします。");
        siShannaiBean.setIrMsg28("　・指定通貨建の保険金をお支払いすることもできます。");
        siShannaiBean.setIrMsg29("　　この場合、基準金額の最低保証はありません。");
        siShannaiBean.setIrMsg30(null);
        siShannaiBean.setIrMsg31("※別添えの『ご提出書類について』に記載されている書類の他に書類をご提出いただくことが");
        siShannaiBean.setIrMsg32("　ありますので、あらかじめご了承ください。");
        siShannaiBean.setIrMsg33("※戸籍関係書類につきましては、個人情報保護法遵守の観点から、必要事項確認後に廃棄させて");
        siShannaiBean.setIrMsg34("　いただきます。戸籍関係書類が他にご入用等の場合は、写しをご提出ください。");
        siShannaiBean.setIrMsg35("※主治医による証明書（診断書）の証明など請求にかかる費用につきましては、お客さまのご負");
        siShannaiBean.setIrMsg36("　担になりますのでご了承ください。");
        siShannaiBean.setIrMsg37("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　以上");

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2014年12月26日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("問合せ先住所２（漢字）");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("代理店契約室");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        reportTestBean.addParamObjects(siShannaiBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }



    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiShannaiTest", C_SyoruiCdKbn.HK_SOUHU);

        siShannaiBean.setIrSyono("99999999999");
        siShannaiBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg21("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg22("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg23("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg24("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg25("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg26("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg27("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg28("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg29("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg30("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg31("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg32("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg33("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg34("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg35("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg36("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siShannaiBean.setIrMsg37("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");

        reportTestBean.addParamObjects(siShannaiBean,bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
