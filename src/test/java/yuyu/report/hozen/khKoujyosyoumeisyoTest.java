package yuyu.report.hozen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhKoujyosyoumeisyoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 控除証明書帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class khKoujyosyoumeisyoTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhKoujyosyoumeisyoBean khKoujyosyoumeisyoBean;
    @Inject
    private BzKokyakuAtesakiBean bzKokyakuAtesakiBean;


    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_koujyosyoumeisyo", C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("wwwwwww");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("www-wwww");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm     ("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("wwwwwwwwwwwwww");
        khKoujyosyoumeisyoBean.setIrMidasisub("ＷＷＷＷＷ");
        khKoujyosyoumeisyoBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKoujyosyoumeisyoBean.setIrSyoumeinnd("９９９９年");
        khKoujyosyoumeisyoBean.setIrUktmidasi("ＷＷＷ");
        khKoujyosyoumeisyoBean.setIrUktnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKoujyosyoumeisyoBean.setIrNenkinuktseiymd("９９９９年９９月９９日");
        khKoujyosyoumeisyoBean.setIrSyono("wwwwwwwwwww");
        khKoujyosyoumeisyoBean.setIrHknsyuruikoujyosyoumei("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKoujyosyoumeisyoBean.setIrNkshrkknkoujyosyoumei("９９年");
        khKoujyosyoumeisyoBean.setIrKeiyakuymd("９９９９年９９月９９日");
        khKoujyosyoumeisyoBean.setIrHaitoukinuketorihoukbn("ＷＷＷＷＷＷＷＷＷ");
        khKoujyosyoumeisyoBean.setIrHknkkn("９９年");
        khKoujyosyoumeisyoBean.setIrNkshrstartymd("９９９９年９９月９９日");
        khKoujyosyoumeisyoBean.setIrPhrkkkn("99");
        khKoujyosyoumeisyoBean.setIrHrkhou("ＷＷＷＷ");
        khKoujyosyoumeisyoBean.setIrNewippanseimeip("9999999999");
        khKoujyosyoumeisyoBean.setIrNewippanhaitoukin("9999999999");
        khKoujyosyoumeisyoBean.setIrNewippansyoumeigk("9999999999");
        khKoujyosyoumeisyoBean.setIrNewiryouseimeip("9999999999");
        khKoujyosyoumeisyoBean.setIrNewiryouhaitoukin("9999999999");
        khKoujyosyoumeisyoBean.setIrNewiryousyoumeigk("9999999999");
        khKoujyosyoumeisyoBean.setIrNewnkseimeip("9999999999");
        khKoujyosyoumeisyoBean.setIrNewnkhaitoukin("9999999999");
        khKoujyosyoumeisyoBean.setIrNewnksyoumeigk("9999999999");
        khKoujyosyoumeisyoBean.setIrNewhknjytuKikan("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKoujyosyoumeisyoBean.setIrPhrkkknjyoutai("ＷＷＷＷ");
        khKoujyosyoumeisyoBean.setIrSyoumeiymd("９９９９年９９月９９日");
        khKoujyosyoumeisyoBean.setIrNewnenkanippanseimeip("9999999999");
        khKoujyosyoumeisyoBean.setIrNewnenkanippanhaitoukin("9999999999");
        khKoujyosyoumeisyoBean.setIrNewippansinkokugk("9999999999");
        khKoujyosyoumeisyoBean.setIrNewippansyoumeigk("9999999999");
        khKoujyosyoumeisyoBean.setIrNewnenkaniryouseimeip("9999999999");
        khKoujyosyoumeisyoBean.setIrNewnenkaniryouhaitoukin("9999999999");
        khKoujyosyoumeisyoBean.setIrNewiryousinkokugk("9999999999");
        khKoujyosyoumeisyoBean.setIrNewiryousyoumeigk("9999999999");

        khKoujyosyoumeisyoBean.setIrNewnenkannkseimeip("9999999999");
        khKoujyosyoumeisyoBean.setIrNewnenkannkhaitoukin("9999999999");
        khKoujyosyoumeisyoBean.setIrNewnksinkokugk("9999999999");
        khKoujyosyoumeisyoBean.setIrKoujyosyoumeifreearea1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKoujyosyoumeisyoBean.setIrKoujyosyoumeifreearea2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khKoujyosyoumeisyoBean.setIrKoujyosyoumeifreearea3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        reportTestBean.addParamObjects(khKoujyosyoumeisyoBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_koujyosyoumeisyo", C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("0101122");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("送付先氏名");
        bzKokyakuAtesakiBean.setIrToiawaseyno("012-2304");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ADFEビル");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        khKoujyosyoumeisyoBean.setIrMidasisub("見出し副題");
        khKoujyosyoumeisyoBean.setIrKyknmkj("契約者名");
        khKoujyosyoumeisyoBean.setIrSyoumeinnd("２０１９年");
        khKoujyosyoumeisyoBean.setIrUktmidasi("受取人");
        khKoujyosyoumeisyoBean.setIrUktnm("受取人氏名");

        khKoujyosyoumeisyoBean.setIrNenkinuktseiymd("２０１９年　５月　６日");
        khKoujyosyoumeisyoBean.setIrSyono("10810100002");
        khKoujyosyoumeisyoBean.setIrHknsyuruikoujyosyoumei("終身保険");
        khKoujyosyoumeisyoBean.setIrNkshrkknkoujyosyoumei("５年");
        khKoujyosyoumeisyoBean.setIrKeiyakuymd("２０１９年　６月　７日");
        khKoujyosyoumeisyoBean.setIrHaitoukinuketorihoukbn("積立");
        khKoujyosyoumeisyoBean.setIrHknkkn("３年");
        khKoujyosyoumeisyoBean.setIrNkshrstartymd("２０１９年　７月　８日");
        khKoujyosyoumeisyoBean.setIrPhrkkkn("3");
        khKoujyosyoumeisyoBean.setIrHrkhou("月払");
        khKoujyosyoumeisyoBean.setIrNewippanseimeip("10002");
        khKoujyosyoumeisyoBean.setIrNewippanhaitoukin("20003");
        khKoujyosyoumeisyoBean.setIrNewippansyoumeigk("****12300");
        khKoujyosyoumeisyoBean.setIrNewiryouseimeip("30004");
        khKoujyosyoumeisyoBean.setIrNewiryouhaitoukin("40005");
        khKoujyosyoumeisyoBean.setIrNewiryousyoumeigk("****34500");
        khKoujyosyoumeisyoBean.setIrNewnkseimeip("50006");
        khKoujyosyoumeisyoBean.setIrNewnkhaitoukin("60007");
        khKoujyosyoumeisyoBean.setIrNewnksyoumeigk("****56700");
        khKoujyosyoumeisyoBean.setIrNewhknjytuKikan("平成28年2月から10年分");
        khKoujyosyoumeisyoBean.setIrPhrkkknjyoutai("払込中");
        khKoujyosyoumeisyoBean.setIrSyoumeiymd("２０１９年　８月　９日");
        khKoujyosyoumeisyoBean.setIrNewnenkanippanseimeip("70008");
        khKoujyosyoumeisyoBean.setIrNewnenkanippanhaitoukin("80009");
        khKoujyosyoumeisyoBean.setIrNewippansinkokugk("****78900");
        khKoujyosyoumeisyoBean.setIrNewnenkaniryouseimeip("12345");
        khKoujyosyoumeisyoBean.setIrNewnenkaniryouhaitoukin("23456");
        khKoujyosyoumeisyoBean.setIrNewiryousinkokugk("****34567");
        khKoujyosyoumeisyoBean.setIrNewnenkannkseimeip("45678");
        khKoujyosyoumeisyoBean.setIrNewnenkannkhaitoukin("56789");
        khKoujyosyoumeisyoBean.setIrNewnksinkokugk("****67890");
        khKoujyosyoumeisyoBean.setIrKoujyosyoumeifreearea1("本商品は、円貨払込保険料が変動するため、申告予定額は記載しておりません。");
        khKoujyosyoumeisyoBean.setIrKoujyosyoumeifreearea2("未使用１");
        khKoujyosyoumeisyoBean.setIrKoujyosyoumeifreearea3("未使用２");


        reportTestBean.addParamObjects(khKoujyosyoumeisyoBean, bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_koujyosyoumeisyo", C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS);

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
        khKoujyosyoumeisyoBean.setIrMidasisub("");
        khKoujyosyoumeisyoBean.setIrKyknmkj("");
        khKoujyosyoumeisyoBean.setIrSyoumeinnd("");
        khKoujyosyoumeisyoBean.setIrUktmidasi("");
        khKoujyosyoumeisyoBean.setIrUktnm("");

        khKoujyosyoumeisyoBean.setIrNenkinuktseiymd("");
        khKoujyosyoumeisyoBean.setIrSyono("");
        khKoujyosyoumeisyoBean.setIrHknsyuruikoujyosyoumei("");
        khKoujyosyoumeisyoBean.setIrNkshrkknkoujyosyoumei("");
        khKoujyosyoumeisyoBean.setIrKeiyakuymd("");
        khKoujyosyoumeisyoBean.setIrHaitoukinuketorihoukbn("");
        khKoujyosyoumeisyoBean.setIrHknkkn("");
        khKoujyosyoumeisyoBean.setIrNkshrstartymd("");
        khKoujyosyoumeisyoBean.setIrPhrkkkn("");
        khKoujyosyoumeisyoBean.setIrHrkhou("");
        khKoujyosyoumeisyoBean.setIrNewippanseimeip("");
        khKoujyosyoumeisyoBean.setIrNewippanhaitoukin("");
        khKoujyosyoumeisyoBean.setIrNewippansyoumeigk("");
        khKoujyosyoumeisyoBean.setIrNewiryouseimeip("");
        khKoujyosyoumeisyoBean.setIrNewiryouhaitoukin("");
        khKoujyosyoumeisyoBean.setIrNewiryousyoumeigk("");
        khKoujyosyoumeisyoBean.setIrNewnkseimeip("");
        khKoujyosyoumeisyoBean.setIrNewnkhaitoukin("");
        khKoujyosyoumeisyoBean.setIrNewnksyoumeigk("");
        khKoujyosyoumeisyoBean.setIrNewhknjytuKikan("");
        khKoujyosyoumeisyoBean.setIrPhrkkknjyoutai("");
        khKoujyosyoumeisyoBean.setIrSyoumeiymd("");
        khKoujyosyoumeisyoBean.setIrNewnenkanippanseimeip("");
        khKoujyosyoumeisyoBean.setIrNewnenkanippanhaitoukin("");
        khKoujyosyoumeisyoBean.setIrNewippansinkokugk("");
        khKoujyosyoumeisyoBean.setIrNewnenkaniryouseimeip("");
        khKoujyosyoumeisyoBean.setIrNewnenkaniryouhaitoukin("");
        khKoujyosyoumeisyoBean.setIrNewiryousinkokugk("");
        khKoujyosyoumeisyoBean.setIrNewnenkannkseimeip("");
        khKoujyosyoumeisyoBean.setIrNewnenkannkhaitoukin("");
        khKoujyosyoumeisyoBean.setIrNewnksinkokugk("");
        khKoujyosyoumeisyoBean.setIrKoujyosyoumeifreearea1("");
        khKoujyosyoumeisyoBean.setIrKoujyosyoumeifreearea2("");
        khKoujyosyoumeisyoBean.setIrKoujyosyoumeifreearea3("");


        reportTestBean.addParamObjects(khKoujyosyoumeisyoBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_koujyosyoumeisyo", C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS);

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

        khKoujyosyoumeisyoBean.setIrMidasisub(null);
        khKoujyosyoumeisyoBean.setIrKyknmkj(null);
        khKoujyosyoumeisyoBean.setIrSyoumeinnd(null);
        khKoujyosyoumeisyoBean.setIrUktmidasi(null);
        khKoujyosyoumeisyoBean.setIrUktnm(null);

        khKoujyosyoumeisyoBean.setIrNenkinuktseiymd(null);
        khKoujyosyoumeisyoBean.setIrSyono(null);
        khKoujyosyoumeisyoBean.setIrHknsyuruikoujyosyoumei(null);
        khKoujyosyoumeisyoBean.setIrNkshrkknkoujyosyoumei(null);
        khKoujyosyoumeisyoBean.setIrKeiyakuymd(null);
        khKoujyosyoumeisyoBean.setIrHaitoukinuketorihoukbn(null);
        khKoujyosyoumeisyoBean.setIrHknkkn(null);
        khKoujyosyoumeisyoBean.setIrNkshrstartymd(null);
        khKoujyosyoumeisyoBean.setIrPhrkkkn(null);
        khKoujyosyoumeisyoBean.setIrHrkhou(null);
        khKoujyosyoumeisyoBean.setIrNewippanseimeip(null);
        khKoujyosyoumeisyoBean.setIrNewippanhaitoukin(null);
        khKoujyosyoumeisyoBean.setIrNewippansyoumeigk(null);
        khKoujyosyoumeisyoBean.setIrNewiryouseimeip(null);
        khKoujyosyoumeisyoBean.setIrNewiryouhaitoukin(null);
        khKoujyosyoumeisyoBean.setIrNewiryousyoumeigk(null);
        khKoujyosyoumeisyoBean.setIrNewnkseimeip(null);
        khKoujyosyoumeisyoBean.setIrNewnkhaitoukin(null);
        khKoujyosyoumeisyoBean.setIrNewnksyoumeigk(null);
        khKoujyosyoumeisyoBean.setIrNewhknjytuKikan(null);
        khKoujyosyoumeisyoBean.setIrPhrkkknjyoutai(null);
        khKoujyosyoumeisyoBean.setIrSyoumeiymd(null);
        khKoujyosyoumeisyoBean.setIrNewnenkanippanseimeip(null);
        khKoujyosyoumeisyoBean.setIrNewnenkanippanhaitoukin(null);
        khKoujyosyoumeisyoBean.setIrNewippansinkokugk(null);
        khKoujyosyoumeisyoBean.setIrNewnenkaniryouseimeip(null);
        khKoujyosyoumeisyoBean.setIrNewnenkaniryouhaitoukin(null);
        khKoujyosyoumeisyoBean.setIrNewiryousinkokugk(null);
        khKoujyosyoumeisyoBean.setIrNewnenkannkseimeip(null);
        khKoujyosyoumeisyoBean.setIrNewnenkannkhaitoukin(null);
        khKoujyosyoumeisyoBean.setIrNewnksinkokugk(null);
        khKoujyosyoumeisyoBean.setIrKoujyosyoumeifreearea1(null);
        khKoujyosyoumeisyoBean.setIrKoujyosyoumeifreearea2(null);
        khKoujyosyoumeisyoBean.setIrKoujyosyoumeifreearea3(null);


        reportTestBean.addParamObjects(khKoujyosyoumeisyoBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "kh_koujyosyoumeisyo", C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2022年 2月 2日");
        bzKokyakuAtesakiBean.setIrShsyno("0101122");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("送付先氏名");
        bzKokyakuAtesakiBean.setIrToiawaseyno("012-2304");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj("ADFEビル");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("問合せ先組織名（漢字）");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");
        khKoujyosyoumeisyoBean.setIrMidasisub("見出し副題");
        khKoujyosyoumeisyoBean.setIrKyknmkj("契約者名");
        khKoujyosyoumeisyoBean.setIrSyoumeinnd("２０１９年");
        khKoujyosyoumeisyoBean.setIrUktmidasi("受取人");
        khKoujyosyoumeisyoBean.setIrUktnm("受取人氏名");
        khKoujyosyoumeisyoBean.setIrNenkinuktseiymd("＊＊＊＊＊＊＊＊＊＊＊");
        khKoujyosyoumeisyoBean.setIrSyono("10810100002");
        khKoujyosyoumeisyoBean.setIrHknsyuruikoujyosyoumei("変額保険");
        khKoujyosyoumeisyoBean.setIrNkshrkknkoujyosyoumei("＊＊＊");
        khKoujyosyoumeisyoBean.setIrKeiyakuymd("２０１９年　６月　７日");
        khKoujyosyoumeisyoBean.setIrHaitoukinuketorihoukbn("＊＊");
        khKoujyosyoumeisyoBean.setIrHknkkn("＊＊＊");
        khKoujyosyoumeisyoBean.setIrNkshrstartymd("＊＊＊＊＊＊＊＊＊＊＊");
        khKoujyosyoumeisyoBean.setIrPhrkkkn("**");
        khKoujyosyoumeisyoBean.setIrHrkhou("＊＊");
        khKoujyosyoumeisyoBean.setIrNewippanseimeip("");
        khKoujyosyoumeisyoBean.setIrNewippanhaitoukin("");
        khKoujyosyoumeisyoBean.setIrNewippansyoumeigk("*********");
        khKoujyosyoumeisyoBean.setIrNewiryouseimeip("");
        khKoujyosyoumeisyoBean.setIrNewiryouhaitoukin("");
        khKoujyosyoumeisyoBean.setIrNewiryousyoumeigk("*********");
        khKoujyosyoumeisyoBean.setIrNewnkseimeip("");
        khKoujyosyoumeisyoBean.setIrNewnkhaitoukin("");
        khKoujyosyoumeisyoBean.setIrNewnksyoumeigk("*********");
        khKoujyosyoumeisyoBean.setIrNewhknjytuKikan("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
        khKoujyosyoumeisyoBean.setIrPhrkkknjyoutai("＊＊＊＊");
        khKoujyosyoumeisyoBean.setIrSyoumeiymd("２０１９年　８月　９日");
        khKoujyosyoumeisyoBean.setIrNewnenkanippanseimeip("");
        khKoujyosyoumeisyoBean.setIrNewnenkanippanhaitoukin("");
        khKoujyosyoumeisyoBean.setIrNewippansinkokugk("*********");
        khKoujyosyoumeisyoBean.setIrNewnenkaniryouseimeip("");
        khKoujyosyoumeisyoBean.setIrNewnenkaniryouhaitoukin("");
        khKoujyosyoumeisyoBean.setIrNewiryousinkokugk("*********");
        khKoujyosyoumeisyoBean.setIrNewnenkannkseimeip("");
        khKoujyosyoumeisyoBean.setIrNewnenkannkhaitoukin("");
        khKoujyosyoumeisyoBean.setIrNewnksinkokugk("*********");
        reportTestBean.addParamObjects(khKoujyosyoumeisyoBean, bzKokyakuAtesakiBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
