package yuyu.report.siharai;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.siharai.bean.report.SiSeisansksBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 精算金振込依頼書 用クラス
 */
@RunWith(OrderedRunner.class)
public class SiSeisansksTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private  SiSeisansksBean siSeisansksBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiShannaiTest", C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

        siSeisansksBean.setIrSyoriYmdzenkaku("");
        siSeisansksBean.setIrUktnmkj("");
        siSeisansksBean.setIrSyono("");
        siSeisansksBean.setIrHhknnmkj("");
        siSeisansksBean.setIrKykymd("");
        siSeisansksBean.setIrSknnkaisiymd("");
        siSeisansksBean.setIrMsg1("");
        siSeisansksBean.setIrMsg2("");
        siSeisansksBean.setIrMsg3("");
        siSeisansksBean.setIrMsg4("");
        siSeisansksBean.setIrMsg5("");
        siSeisansksBean.setIrMsg6("");
        siSeisansksBean.setIrMsg7("");
        siSeisansksBean.setIrMsg8("");
        siSeisansksBean.setIrMsg9("");
        siSeisansksBean.setIrMsg10("");
        siSeisansksBean.setIrMsg11("");
        siSeisansksBean.setIrMsg12("");
        siSeisansksBean.setIrMsg13("");
        siSeisansksBean.setIrMsg14("");
        siSeisansksBean.setIrMsg15("");
        siSeisansksBean.setIrMsg16("");
        siSeisansksBean.setIrMsg17("");
        siSeisansksBean.setIrMsg18("");
        siSeisansksBean.setIrMsg19("");
        siSeisansksBean.setIrMsg20("");
        siSeisansksBean.setIrMsg21("");
        siSeisansksBean.setIrMsg22("");

        siSeisansksBean.setIrHozonkkn("");
        siSeisansksBean.setIrTsinyno("");
        siSeisansksBean.setIrTsintelno("");
        siSeisansksBean.setIrTsinadr1kj("");
        siSeisansksBean.setIrTsinadr2kj("");
        siSeisansksBean.setIrTsinadr3kj("");
        siSeisansksBean.setIrToritsugisyasyozokunm("");
        siSeisansksBean.setIrToritsugisyakjncd("");
        siSeisansksBean.setIrToritsugisyanm("");
        siSeisansksBean.setIrTyouhyousakuseiymd("");
        siSeisansksBean.setIrShsrtdkdadrhyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrShsrkinyuuhyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrMensekijiyuuhknknhyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrMensekijiyuukyhknhyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrUkthougkdthyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrUkthouendthyjumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(siSeisansksBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", null, "SiShannaiTest", C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);


        siSeisansksBean.setIrSyoriYmdzenkaku(null);
        siSeisansksBean.setIrUktnmkj(null);
        siSeisansksBean.setIrSyono(null);
        siSeisansksBean.setIrHhknnmkj(null);
        siSeisansksBean.setIrKykymd(null);
        siSeisansksBean.setIrSknnkaisiymd(null);
        siSeisansksBean.setIrMsg1(null);
        siSeisansksBean.setIrMsg2(null);
        siSeisansksBean.setIrMsg3(null);
        siSeisansksBean.setIrMsg4(null);
        siSeisansksBean.setIrMsg5(null);
        siSeisansksBean.setIrMsg6(null);
        siSeisansksBean.setIrMsg7(null);
        siSeisansksBean.setIrMsg8(null);
        siSeisansksBean.setIrMsg9(null);
        siSeisansksBean.setIrMsg10(null);
        siSeisansksBean.setIrMsg11(null);
        siSeisansksBean.setIrMsg12(null);
        siSeisansksBean.setIrMsg13(null);
        siSeisansksBean.setIrMsg14(null);
        siSeisansksBean.setIrMsg15(null);
        siSeisansksBean.setIrMsg16(null);
        siSeisansksBean.setIrMsg17(null);
        siSeisansksBean.setIrMsg18(null);
        siSeisansksBean.setIrMsg19(null);
        siSeisansksBean.setIrMsg20(null);
        siSeisansksBean.setIrMsg21(null);
        siSeisansksBean.setIrMsg22(null);

        siSeisansksBean.setIrHozonkkn(null);
        siSeisansksBean.setIrTsinyno(null);
        siSeisansksBean.setIrTsintelno(null);
        siSeisansksBean.setIrTsinadr1kj(null);
        siSeisansksBean.setIrTsinadr2kj(null);
        siSeisansksBean.setIrTsinadr3kj(null);
        siSeisansksBean.setIrToritsugisyasyozokunm(null);
        siSeisansksBean.setIrToritsugisyakjncd(null);
        siSeisansksBean.setIrToritsugisyanm(null);
        siSeisansksBean.setIrTyouhyousakuseiymd(null);
        siSeisansksBean.setIrShsrtdkdadrhyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrShsrkinyuuhyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrMensekijiyuuhknknhyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrMensekijiyuukyhknhyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrUkthougkdthyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrUkthouendthyjumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(siSeisansksBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiShannaiTest", C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);


        siSeisansksBean.setIrSyoriYmdzenkaku("２０２１年４月１日");
        siSeisansksBean.setIrUktnmkj("新契約　太郎1");
        siSeisansksBean.setIrSyono("11807111118");
        siSeisansksBean.setIrHhknnmkj("新契約　太郎2");
        siSeisansksBean.setIrKykymd("２０２０年１２月１日");
        siSeisansksBean.setIrSknnkaisiymd("２０２０年１１月１５日");
        siSeisansksBean.setIrMsg1("このたびは、謹んでお悔やみ申し上げます１。");
        siSeisansksBean.setIrMsg2("このたびは、謹んでお悔やみ申し上げます２。");
        siSeisansksBean.setIrMsg3("このたびは、謹んでお悔やみ申し上げます３。");
        siSeisansksBean.setIrMsg4("このたびは、謹んでお悔やみ申し上げます４。");
        siSeisansksBean.setIrMsg5("このたびは、謹んでお悔やみ申し上げます５。");
        siSeisansksBean.setIrMsg6("このたびは、謹んでお悔やみ申し上げます６。");
        siSeisansksBean.setIrMsg7("このたびは、謹んでお悔やみ申し上げます７。");
        siSeisansksBean.setIrMsg8("このたびは、謹んでお悔やみ申し上げます８。");
        siSeisansksBean.setIrMsg9("このたびは、謹んでお悔やみ申し上げます９。");
        siSeisansksBean.setIrMsg10("このたびは、謹んでお悔やみ申し上げます１０。");
        siSeisansksBean.setIrMsg11("このたびは、謹んでお悔やみ申し上げます１１。");
        siSeisansksBean.setIrMsg12("このたびは、謹んでお悔やみ申し上げます１２。");
        siSeisansksBean.setIrMsg13("このたびは、謹んでお悔やみ申し上げます１３。");
        siSeisansksBean.setIrMsg14("このたびは、謹んでお悔やみ申し上げます１４。");
        siSeisansksBean.setIrMsg15("このたびは、謹んでお悔やみ申し上げます１５。");
        siSeisansksBean.setIrMsg16("このたびは、謹んでお悔やみ申し上げます１６。");
        siSeisansksBean.setIrMsg17("このたびは、謹んでお悔やみ申し上げます１７。");
        siSeisansksBean.setIrMsg18("このたびは、謹んでお悔やみ申し上げます１８。");
        siSeisansksBean.setIrMsg19("このたびは、謹んでお悔やみ申し上げます１９。");
        siSeisansksBean.setIrMsg20("このたびは、謹んでお悔やみ申し上げます２０。");
        siSeisansksBean.setIrMsg21("このたびは、謹んでお悔やみ申し上げます２１。");
        siSeisansksBean.setIrMsg22("このたびは、謹んでお悔やみ申し上げます２２。");

        siSeisansksBean.setIrHozonkkn("5 年");
        siSeisansksBean.setIrTsinyno("1234567");
        siSeisansksBean.setIrTsintelno("12345678901234");
        siSeisansksBean.setIrTsinadr1kj("通信先住所１（漢字）");
        siSeisansksBean.setIrTsinadr2kj("通信先住所２（漢字）");
        siSeisansksBean.setIrTsinadr3kj("通信先住所３（漢字）");
        siSeisansksBean.setIrToritsugisyasyozokunm("取次者所属名");
        siSeisansksBean.setIrToritsugisyakjncd("12345678");
        siSeisansksBean.setIrToritsugisyanm("取次者氏名");
        siSeisansksBean.setIrTyouhyousakuseiymd("2021年4月1日");
        siSeisansksBean.setIrShsrtdkdadrhyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrShsrkinyuuhyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrMensekijiyuuhknknhyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrMensekijiyuukyhknhyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrUkthougkdthyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrUkthouendthyjumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(siSeisansksBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiShannaiTest", C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

        siSeisansksBean.setIrSyono("wwwwwwwwwww");
        siSeisansksBean.setIrUktnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrSyoriYmdzenkaku("９９９９年９９月９９日");
        siSeisansksBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrKykymd("９９９９年９９月９９日");
        siSeisansksBean.setIrSknnkaisiymd("９９９９年９９月９９日");
        siSeisansksBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg21("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg22("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrHozonkkn("99 年");
        siSeisansksBean.setIrTsinyno("wwwwwww");
        siSeisansksBean.setIrTsintelno("wwwwwwwwwwwwww");
        siSeisansksBean.setIrTsinadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrTsinadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrTsinadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrToritsugisyakjncd("wwwwwwww");
        siSeisansksBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrTyouhyousakuseiymd("9999年99月99日");
        siSeisansksBean.setIrShsrtdkdadrhyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrShsrkinyuuhyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrMensekijiyuuhknknhyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrMensekijiyuukyhknhyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrUkthougkdthyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrUkthouendthyjumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(siSeisansksBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiShannaiTest", C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

        siSeisansksBean.setIrSyoriYmdzenkaku("２０２１年４月１日");
        siSeisansksBean.setIrUktnmkj("新契約　太郎1");
        siSeisansksBean.setIrSyono("11807111118");
        siSeisansksBean.setIrHhknnmkj("新契約　太郎2");
        siSeisansksBean.setIrKykymd("２０２０年１２月１日");
        siSeisansksBean.setIrSknnkaisiymd("２０２０年１１月１５日");
        siSeisansksBean.setIrMsg1("このたびは、被保険者さまのご訃報に接し、謹んでお悔やみ申し上げます。");
        siSeisansksBean.setIrMsg2("今般、ご連絡いただきました内容によりますと、該当契約では、下記２のとおり保険約款上の");
        siSeisansksBean.setIrMsg3("免責事由（死亡保険金をお支払いできない事由）に該当するため、死亡保険金のお支払いはい");
        siSeisansksBean.setIrMsg4("たしかねます。");
        siSeisansksBean.setIrMsg5("お役に立てず誠に恐縮ですが、何卒ご了承賜りますようお願い申し上げます。");
        siSeisansksBean.setIrMsg6("当社の保険約款上、被保険者さまが、契約の責任開始日から起算して３年以内に自殺によ");
        siSeisansksBean.setIrMsg7("りお亡くなりの場合は、死亡保険金をお支払いできない旨を定めています。");
        siSeisansksBean.setIrMsg8(null);
        siSeisansksBean.setIrMsg9(null);
        siSeisansksBean.setIrMsg10("＊なお、心神喪失またはこれと同程度の著しい精神障がいがあり、自己の生命を絶つ認識");
        siSeisansksBean.setIrMsg11("　がなかったと認められるときには、死亡保険金をお受け取りいただける場合があります。");
        siSeisansksBean.setIrMsg12("　このような可能性があるときは、お手数ですが当社までご連絡くださいますようお願い");
        siSeisansksBean.setIrMsg13("　いたします。");
        siSeisansksBean.setIrMsg14(null);
        siSeisansksBean.setIrMsg15(null);
        siSeisansksBean.setIrMsg16("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　以上");
        siSeisansksBean.setIrMsg17(null);
        siSeisansksBean.setIrMsg18(null);
        siSeisansksBean.setIrMsg19(null);
        siSeisansksBean.setIrMsg20(null);
        siSeisansksBean.setIrMsg21(null);
        siSeisansksBean.setIrMsg22(null);
        siSeisansksBean.setIrHozonkkn("5 年");
        siSeisansksBean.setIrTsinyno("1234567");
        siSeisansksBean.setIrTsintelno("12345678901234");
        siSeisansksBean.setIrTsinadr1kj("通信先住所１（漢字）");
        siSeisansksBean.setIrTsinadr2kj("通信先住所２（漢字）");
        siSeisansksBean.setIrTsinadr3kj("通信先住所３（漢字）");
        siSeisansksBean.setIrToritsugisyasyozokunm("取次者所属名");
        siSeisansksBean.setIrToritsugisyakjncd("12345678");
        siSeisansksBean.setIrToritsugisyanm("取次者氏名");
        siSeisansksBean.setIrTyouhyousakuseiymd("2021年4月1日");
        siSeisansksBean.setIrShsrtdkdadrhyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrShsrkinyuuhyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrMensekijiyuuhknknhyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrMensekijiyuukyhknhyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrUkthougkdthyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrUkthouendthyjumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(siSeisansksBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiShannaiTest", C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

        siSeisansksBean.setIrSyono("wwwwwwwwwww");
        siSeisansksBean.setIrUktnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrSyoriYmdzenkaku("９９９９年９９月９９日");
        siSeisansksBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrKykymd("９９９９年９９月９９日");
        siSeisansksBean.setIrSknnkaisiymd("９９９９年９９月９９日");
        siSeisansksBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg9("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg10("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg11("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg12("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg13("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg14("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg15("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg16("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg17("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg18("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg19("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg20("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg21("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrMsg22("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrHozonkkn("99 年");
        siSeisansksBean.setIrTsinyno("wwwwwww");
        siSeisansksBean.setIrTsintelno("wwwwwwwwwwwwww");
        siSeisansksBean.setIrTsinadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrTsinadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrTsinadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrToritsugisyasyozokunm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrToritsugisyakjncd("wwwwwwww");
        siSeisansksBean.setIrToritsugisyanm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siSeisansksBean.setIrTyouhyousakuseiymd("9999年99月99日");
        siSeisansksBean.setIrShsrtdkdadrhyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrShsrkinyuuhyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrMensekijiyuuhknknhyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrMensekijiyuukyhknhyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrUkthougkdthyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrUkthouendthyjumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siSeisansksBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiShannaiTest", C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

        siSeisansksBean.setIrSyoriYmdzenkaku("２０２１年４月１日");
        siSeisansksBean.setIrUktnmkj("新契約　太郎1");
        siSeisansksBean.setIrSyono("11807111118");
        siSeisansksBean.setIrHhknnmkj("新契約　太郎2");
        siSeisansksBean.setIrKykymd("２０２０年１２月１日");
        siSeisansksBean.setIrSknnkaisiymd("２０２０年１１月１５日");
        siSeisansksBean.setIrMsg1("このたびは、被保険者さまのご訃報に接し、謹んでお悔やみ申し上げます。");
        siSeisansksBean.setIrMsg2("今般、ご連絡いただきました内容によりますと、該当契約では、下記２のとおり保険約款上の");
        siSeisansksBean.setIrMsg3("免責事由（死亡給付金をお支払いできない事由）に該当するため、死亡給付金のお支払いはい");
        siSeisansksBean.setIrMsg4("たしかねます。");
        siSeisansksBean.setIrMsg5("お役に立てず誠に恐縮ですが、何卒ご了承賜りますようお願い申し上げます。");
        siSeisansksBean.setIrMsg6("当社の保険約款上、被保険者さまが、契約の責任開始日から起算して３年以内に自殺によ");
        siSeisansksBean.setIrMsg7("りお亡くなりの場合は、死亡給付金をお支払いできない旨を定めています。");
        siSeisansksBean.setIrMsg8(null);
        siSeisansksBean.setIrMsg9(null);
        siSeisansksBean.setIrMsg10("＊なお、心神喪失またはこれと同程度の著しい精神障がいがあり、自己の生命を絶つ認識");
        siSeisansksBean.setIrMsg11("　がなかったと認められるときには、死亡給付金をお受け取りいただける場合があります。");
        siSeisansksBean.setIrMsg12("　このような可能性があるときは、お手数ですが当社までご連絡くださいますようお願い");
        siSeisansksBean.setIrMsg13("　いたします。");
        siSeisansksBean.setIrMsg14(null);
        siSeisansksBean.setIrMsg15(null);
        siSeisansksBean.setIrMsg16("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　以上");
        siSeisansksBean.setIrMsg17(null);
        siSeisansksBean.setIrMsg18(null);
        siSeisansksBean.setIrMsg19(null);
        siSeisansksBean.setIrMsg20(null);
        siSeisansksBean.setIrMsg21(null);
        siSeisansksBean.setIrMsg22(null);
        siSeisansksBean.setIrHozonkkn("99 年");
        siSeisansksBean.setIrTsinyno("1234567");
        siSeisansksBean.setIrTsintelno("12345678901234");
        siSeisansksBean.setIrTsinadr1kj("通信先住所１（漢字）");
        siSeisansksBean.setIrTsinadr2kj("通信先住所２（漢字）");
        siSeisansksBean.setIrTsinadr3kj("通信先住所３（漢字）");
        siSeisansksBean.setIrToritsugisyasyozokunm("取次者所属名");
        siSeisansksBean.setIrToritsugisyakjncd("12345678");
        siSeisansksBean.setIrToritsugisyanm("取次者氏名");
        siSeisansksBean.setIrTyouhyousakuseiymd("2021年4月1日");
        siSeisansksBean.setIrShsrtdkdadrhyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrShsrkinyuuhyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrMensekijiyuuhknknhyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrMensekijiyuukyhknhyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrUkthougkdthyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrUkthouendthyjumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siSeisansksBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void createSample1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiShannaiTest", C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

        siSeisansksBean.setIrSyoriYmdzenkaku("");
        siSeisansksBean.setIrUktnmkj("");
        siSeisansksBean.setIrSyono("");
        siSeisansksBean.setIrHhknnmkj("");
        siSeisansksBean.setIrKykymd("");
        siSeisansksBean.setIrSknnkaisiymd("");
        siSeisansksBean.setIrMsg1("");
        siSeisansksBean.setIrMsg2("");
        siSeisansksBean.setIrMsg3("");
        siSeisansksBean.setIrMsg4("");
        siSeisansksBean.setIrMsg5("");
        siSeisansksBean.setIrMsg6("");
        siSeisansksBean.setIrMsg7("");
        siSeisansksBean.setIrMsg8("");
        siSeisansksBean.setIrMsg9("");
        siSeisansksBean.setIrMsg10("");
        siSeisansksBean.setIrMsg11("");
        siSeisansksBean.setIrMsg12("");
        siSeisansksBean.setIrMsg13("");
        siSeisansksBean.setIrMsg14("");
        siSeisansksBean.setIrMsg15("");
        siSeisansksBean.setIrMsg16("");
        siSeisansksBean.setIrMsg17("");
        siSeisansksBean.setIrMsg18("");
        siSeisansksBean.setIrMsg19("");
        siSeisansksBean.setIrMsg20("");
        siSeisansksBean.setIrMsg21("");
        siSeisansksBean.setIrMsg22("");

        siSeisansksBean.setIrHozonkkn("");
        siSeisansksBean.setIrTsinyno("");
        siSeisansksBean.setIrTsintelno("");
        siSeisansksBean.setIrTsinadr1kj("");
        siSeisansksBean.setIrTsinadr2kj("");
        siSeisansksBean.setIrTsinadr3kj("");
        siSeisansksBean.setIrToritsugisyasyozokunm("");
        siSeisansksBean.setIrToritsugisyakjncd("");
        siSeisansksBean.setIrToritsugisyanm("");
        siSeisansksBean.setIrTyouhyousakuseiymd("");
        siSeisansksBean.setIrShsrtdkdadrhyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrShsrkinyuuhyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrMensekijiyuuhknknhyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrMensekijiyuukyhknhyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrUkthougkdthyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrUkthouendthyjumu(C_UmuKbn.NONE);

        reportTestBean.addParamObjects(siSeisansksBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void createSample2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiShannaiTest", C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

        siSeisansksBean.setIrSyoriYmdzenkaku("");
        siSeisansksBean.setIrUktnmkj("");
        siSeisansksBean.setIrSyono("");
        siSeisansksBean.setIrHhknnmkj("");
        siSeisansksBean.setIrKykymd("");
        siSeisansksBean.setIrSknnkaisiymd("");
        siSeisansksBean.setIrMsg1("");
        siSeisansksBean.setIrMsg2("");
        siSeisansksBean.setIrMsg3("");
        siSeisansksBean.setIrMsg4("");
        siSeisansksBean.setIrMsg5("");
        siSeisansksBean.setIrMsg6("");
        siSeisansksBean.setIrMsg7("");
        siSeisansksBean.setIrMsg8("");
        siSeisansksBean.setIrMsg9("");
        siSeisansksBean.setIrMsg10("");
        siSeisansksBean.setIrMsg11("");
        siSeisansksBean.setIrMsg12("");
        siSeisansksBean.setIrMsg13("");
        siSeisansksBean.setIrMsg14("");
        siSeisansksBean.setIrMsg15("");
        siSeisansksBean.setIrMsg16("");
        siSeisansksBean.setIrMsg17("");
        siSeisansksBean.setIrMsg18("");
        siSeisansksBean.setIrMsg19("");
        siSeisansksBean.setIrMsg20("");
        siSeisansksBean.setIrMsg21("");
        siSeisansksBean.setIrMsg22("");

        siSeisansksBean.setIrHozonkkn("");
        siSeisansksBean.setIrTsinyno("");
        siSeisansksBean.setIrTsintelno("");
        siSeisansksBean.setIrTsinadr1kj("");
        siSeisansksBean.setIrTsinadr2kj("");
        siSeisansksBean.setIrTsinadr3kj("");
        siSeisansksBean.setIrToritsugisyasyozokunm("");
        siSeisansksBean.setIrToritsugisyakjncd("");
        siSeisansksBean.setIrToritsugisyanm("");
        siSeisansksBean.setIrTyouhyousakuseiymd("");
        siSeisansksBean.setIrShsrtdkdadrhyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrShsrkinyuuhyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrMensekijiyuuhknknhyjumu(C_UmuKbn.ARI);
        siSeisansksBean.setIrMensekijiyuukyhknhyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrUkthougkdthyjumu(C_UmuKbn.NONE);
        siSeisansksBean.setIrUkthouendthyjumu(C_UmuKbn.ARI);

        reportTestBean.addParamObjects(siSeisansksBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
