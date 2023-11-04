package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoMockForHozen;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_GengkhouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_SksmongonKbn;
import yuyu.def.classification.C_SoukinsakisiteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YenShrTkHnkKbn;
import yuyu.def.classification.C_ZeimuNaiyouHnsyuCtrlKbn;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhHasseijiKazeiRireki;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.auth.RayHttpHeaderBean;
import yuyu.infr.auth.RayHttpHeaderBeanMockForHozen;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 手続完了TBL編集のメソッド{@link EditTtdkKanryouTbl#editTBL(KhozenCommonParam, IT_KykKihon, List, IT_KykSya, IT_HhknSya, EditTtdkKanryouParam, IT_KhShrRireki, IT_KykSonotaTkyk, BizDate, C_HassouKbn, C_SyoruiCdKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditTtdkKanryouTblTest_editTBL1 extends AbstractTest {

    @Inject
    private EditTtdkKanryouTbl editTtdkKanryouTbl;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private EditTtdkKanryouParam editTtdkKanryouParam;

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_手続完了TBL編集";

    private final static String sheetName = "INデータ_20190226";

    private static String callcentersosikicd;

    private static String uketimecallcenter1;

    private static String uketimecallcenter2;

    private static String uketimetantousitu1;

    private static String uketimetantousitu2;

    @Before
    public void beforeTest() {
        changeSystemDate(BizDate.valueOf(2015, 12, 20));
    }

    @Before
    public void before() {
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(RayHttpHeaderBean.class).to(RayHttpHeaderBeanMockForHozen.class);
                bind(GetKhKykdrInfo.class).to(GetKhKykdrInfoForHozen.class);
                bind(BzGetSosikiMadogutiInfo.class).to(BzGetSosikiMadogutiInfoMockForHozen.class);
            }
        });
        RayHttpHeaderBeanMockForHozen.caller = EditTtdkKanryouTblTest_editTBL1.class;
        GetKhKykdrInfoForHozen.caller = EditTtdkKanryouTblTest_editTBL1.class;
        BzGetSosikiMadogutiInfoMockForHozen.caller = EditTtdkKanryouTblTest_editTBL1.class;
    }

    @BeforeClass
    @Transactional
    public static void testInit() {

        RayHttpHeaderBeanMockForHozen.SYORIPTN = null;
        GetKhKykdrInfoForHozen.SYORIPTN = null;
        BzGetSosikiMadogutiInfoMockForHozen.SYORIPTN = null;

        callcentersosikicd = YuyuBizConfig.getInstance().getCallcentersosikicd();
        uketimecallcenter1 = YuyuBizConfig.getInstance().getUketimecallcenter1();
        uketimecallcenter2 = YuyuBizConfig.getInstance().getUketimecallcenter2();
        uketimetantousitu1 = YuyuBizConfig.getInstance().getUketimetantousitu1();
        uketimetantousitu2 = YuyuBizConfig.getInstance().getUketimetantousitu2();

        YuyuBizConfig.getInstance().setCallcentersosikicd("0010001");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160401");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160402");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160403");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160404");
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditTtdkKanryouTblTest_editTBL1.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllSosikiMadoguti());
        bizDomManager.delete(bizDomManager.getAllGinkou());

        MockObjectManager.initialize();
        RayHttpHeaderBeanMockForHozen.caller = null;
        RayHttpHeaderBeanMockForHozen.SYORIPTN = null;

        GetKhKykdrInfoForHozen.caller = null;
        GetKhKykdrInfoForHozen.SYORIPTN = null;

        BzGetSosikiMadogutiInfoMockForHozen.caller = null;
        BzGetSosikiMadogutiInfoMockForHozen.SYORIPTN = null;

        YuyuBizConfig.getInstance().setCallcentersosikicd(callcentersosikicd);
        YuyuBizConfig.getInstance().setUketimecallcenter1(uketimecallcenter1);
        YuyuBizConfig.getInstance().setUketimecallcenter2(uketimecallcenter2);
        YuyuBizConfig.getInstance().setUketimetantousitu1(uketimetantousitu1);
        YuyuBizConfig.getInstance().setUketimetantousitu2(uketimetantousitu2);
    }

    @Test
    @TestOrder(10)
    public void testEditTBL_A1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806000011");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setDocumentId("");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setHozonKikanY(0);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "60806000011", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "基準金額を１３　円に減額しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（減額後毎回円貨払込額　２００　円）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　減額日（計算基準日）：２０１６年　４月　１日", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "＜お預り金内容＞", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "　個人年金保険料税制適格特約（’９０）が付加されているため、減額部分の解約返戻金およびその他の支払金は、当社", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "　所定の利率で利息をつけてすえ置いておき、年金支払開始日に年金額の増額に充てられます。", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "　減額部分の解約返戻金　　　　　　　　　　　　　　　　　　　　　　　　０　円", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "　その他支払金（以下の合計）　　　　　　　　　　　　　　　　　　　１　円", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "　　保険料（円貨払込額）　　　　　　　　　　　　　　　　　　　　　１　円", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "　　その他精算金　　　　　　　　　　　　　　　　　　　　　　　　　１　円", "手続内容１０");
    }

    @Test
    @TestOrder(20)
    public void testEditTBL_A2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000155");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setDocumentId("");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setHozonKikanY(0);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.ARI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000155", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "２２２　円", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "必要書類の受付日翌日から５営業日を超えた２３日分", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(100), "必要経費");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【適用為替レートについて】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆円貨支払いのご請求により、解約返戻金を外貨（指定通貨または選択通貨）にかえて減額日時点の当社", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　　所定の為替レート（※１）で円貨に換算してお支払いしています。", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）－５０銭」（※３）となります。", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　　　日とします。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　公示値とします。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＢを下回ることはありません。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　◆税法上、源泉分離課税の対象となりますので、お支払金額から差し引きしています。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "　　お支払金額明細に記載の源泉徴収税額は復興特別所得税を含んだ金額です。", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");
        exStringEquals(ttdkKan.getOsirasemongon32(), "", "お知らせ文言３２");
        exStringEquals(ttdkKan.getOsirasemongon33(), "", "お知らせ文言３３");
        exStringEquals(ttdkKan.getOsirasemongon34(), "", "お知らせ文言３４");
        exStringEquals(ttdkKan.getOsirasemongon35(), "", "お知らせ文言３５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.GSTSZEIGK_ARI, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(Long.valueOf(123450)), "源泉分離課税対象差益");
    }

    @Test
    @TestOrder(30)
    public void testEditTBL_A3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setDocumentId("");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setHozonKikanY(0);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.NONE);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111118", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "必要書類の受付日翌日から５営業日を超えた２３日分", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(50), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(101), "必要経費");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【適用為替レートについて】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を減額日時点の当社所定の為替レート（※１）", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　　で外貨（指定通貨または選択通貨）に換算してお支払いしています。", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）＋５０銭」（※３）となります。", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　　　日とします。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　公示値とします。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、外貨（指定通", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "　　貨または選択通貨）を円貨に換算したうえで、円建の生命保険と同様に取り扱います。", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "　◆「お手続き完了のお知らせ」は、確定申告の際の参考資料となりますので、大切に保管してください。", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　◆収入金額は、減額日の為替レートにて円換算した金額です。", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　◆所轄の税務署あてに、支払調書を提出いたします。", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");
        exStringEquals(ttdkKan.getOsirasemongon32(), "", "お知らせ文言３２");
        exStringEquals(ttdkKan.getOsirasemongon33(), "", "お知らせ文言３３");
        exStringEquals(ttdkKan.getOsirasemongon34(), "", "お知らせ文言３４");
        exStringEquals(ttdkKan.getOsirasemongon35(), "", "お知らせ文言３５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(Long.valueOf(0)), "源泉分離課税対象差益");
    }

    @Test
    @TestOrder(40)
    public void testEditTBL_A4() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111129");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｹ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setDocumentId("");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setHozonKikanY(0);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.NONE);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111129", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "必要書類の受付日翌日から５営業日を超えた２３日分", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(60), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(102), "必要経費");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【適用為替レートについて】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を減額日時点の当社所定の為替レート（※１）", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　　で外貨（指定通貨または選択通貨）に換算してお支払いしています。", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）＋５０銭」（※３）となります。", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　　　日とします。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　公示値とします。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、外貨（指定通", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "　　貨または選択通貨）を円貨に換算したうえで、円建の生命保険と同様に取り扱います。", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "　◆「お手続き完了のお知らせ」は、確定申告の際の参考資料となりますので、大切に保管してください。", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　◆収入金額は、減額日の為替レートにて円換算した金額です。", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　◆所轄の税務署あてに、支払調書を提出いたします。", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");
        exStringEquals(ttdkKan.getOsirasemongon32(), "", "お知らせ文言３２");
        exStringEquals(ttdkKan.getOsirasemongon33(), "", "お知らせ文言３３");
        exStringEquals(ttdkKan.getOsirasemongon34(), "", "お知らせ文言３４");
        exStringEquals(ttdkKan.getOsirasemongon35(), "", "お知らせ文言３５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(Long.valueOf(0)), "源泉分離課税対象差益");
    }

    @Test
    @TestOrder(50)
    public void testEditTBL_A5() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setDocumentId("");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setHozonKikanY(0);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.NONE);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111130", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "必要書類の受付日翌日から５営業日を超えた２３日分", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(70), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(103), "必要経費");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、外貨（指定通", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　　貨または選択通貨）を円貨に換算したうえで、円建の生命保険と同様に取り扱います。", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　　は、確定申告の際の参考資料となりますので、大切に保管してください。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　◆収入金額は、減額日の為替レートにて円換算した金額です。", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　◆所轄の税務署あてに、支払調書を提出いたします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");
        exStringEquals(ttdkKan.getOsirasemongon32(), "", "お知らせ文言３２");
        exStringEquals(ttdkKan.getOsirasemongon33(), "", "お知らせ文言３３");
        exStringEquals(ttdkKan.getOsirasemongon34(), "", "お知らせ文言３４");
        exStringEquals(ttdkKan.getOsirasemongon35(), "", "お知らせ文言３５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(Long.valueOf(0)), "源泉分離課税対象差益");
    }

    @Test
    @TestOrder(60)
    public void testEditTBL_A6() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111141");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setDocumentId("");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setHozonKikanY(0);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.NONE);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111141", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "必要書類の受付日翌日から５営業日を超えた２３日分", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(80), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(104), "必要経費");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、外貨（指定通", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　　貨または選択通貨）を円貨に換算したうえで、円建の生命保険と同様に取り扱います。", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　◆収入金額は、減額日の為替レートにて円換算した金額です。", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆所轄の税務署あてに、支払調書を提出いたします。", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");
        exStringEquals(ttdkKan.getOsirasemongon32(), "", "お知らせ文言３２");
        exStringEquals(ttdkKan.getOsirasemongon33(), "", "お知らせ文言３３");
        exStringEquals(ttdkKan.getOsirasemongon34(), "", "お知らせ文言３４");
        exStringEquals(ttdkKan.getOsirasemongon35(), "", "お知らせ文言３５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(Long.valueOf(0)), "源泉分離課税対象差益");
    }

    @Test
    @TestOrder(70)
    public void testEditTBL_A7() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000199");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｹ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.ARI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "09", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000199", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "その他支払金合計", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "（明細）", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "・保険料（円貨払込額）", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "・その他精算金", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "・配当金", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "・特別配当金", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "源泉徴収税額", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "支払利息", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exStringEquals(ttdkKan.getBikou1(), "解約返戻金額＝（１）×（２）－（３）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）積立金相当額", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　２３，５４３　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）市場価格調整率", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１１０．００００００００％", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（３）解約控除額（※）", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　９，９９９，９９９，９９９，９９９　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "必要書類の受付日翌日から５営業日を超えた２５日分", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(111), "必要経費");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.ARI, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "※２０１６年の所得となります。", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆解約返戻金額は、市場金利の変動に応じた市場価格調整（※）を適用し計算するため、市場金利の", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　　変動により解約日の積立金額から増減します。また、解約時等にかかる費用（解約控除）として、", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　　基準金額の一定割合（契約日からの経過年数に応じた所定の控除率）を差し引きます。", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　（※）市場価格調整について", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　　　　　しくみをいいます。", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　・一般的に市場金利が高くなると資産の価値が減少するため解約返戻金額は減少し、市場金利が", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　　　　　低くなると資産の価値が増加するため解約返戻金額も増加します。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、外貨（指定通", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "　　貨または選択通貨）を円貨に換算したうえで、円建の生命保険と同様に取り扱います。", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "　◆収入金額は、解約日の為替レートにて円換算した金額です。", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　◆税務取扱および申告手続の詳細については、所轄の税務署にお問い合わせください。", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");
        exStringEquals(ttdkKan.getOsirasemongon32(), "", "お知らせ文言３２");
        exStringEquals(ttdkKan.getOsirasemongon33(), "", "お知らせ文言３３");
        exStringEquals(ttdkKan.getOsirasemongon34(), "", "お知らせ文言３４");
        exStringEquals(ttdkKan.getOsirasemongon35(), "", "お知らせ文言３５");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.GSTSZEIGK_ARI, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(Long.valueOf("9999999999")), "源泉分離課税対象差益");

    }

    @Test
    @TestOrder(80)
    public void testEditTBL_A8() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111406");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｱ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.NONE);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "00", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111406", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額には以下の契約変更時返戻金（注）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を含みます。", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　１　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "必要書類の受付日翌日から５営業日を超えた２５日分", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(20), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(111), "必要経費");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.ARI, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "※２０１６年の所得となります。", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　　市場金利の変動に応じた市場価格調整（※）を適用し計算するため、解約日の保険料積立金額から", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　　増減します。", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "【解約返戻金に対する税務のご説明】", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、外貨（指定通", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　貨または選択通貨）を円貨に換算したうえで、円建の生命保険と同様に取り扱います。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　　は、確定申告の際の参考資料となりますので、大切に保管してください。", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　◆収入金額は、解約日の為替レートにて円換算した金額です。", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");
        exStringEquals(ttdkKan.getOsirasemongon32(), "", "お知らせ文言３２");
        exStringEquals(ttdkKan.getOsirasemongon33(), "", "お知らせ文言３３");
        exStringEquals(ttdkKan.getOsirasemongon34(), "", "お知らせ文言３４");
        exStringEquals(ttdkKan.getOsirasemongon35(), "", "お知らせ文言３５");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");

    }

    @Test
    @TestOrder(90)
    public void testEditTBL_A9() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111417");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｱ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.NONE);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111417", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額は解約返戻金額明細の合計額（外貨）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を円貨に換算した金額です。　（１）×（２）", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（１）適用為替レート：４５６．００　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）解約返戻金額明細の合計額（外貨）", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１３　円", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "必要書類の受付日翌日から５営業日を超えた２５日分", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(30), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(111), "必要経費");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.ARI, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "※２０１６年の所得となります。", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "※ご契約期間中に契約者の変更がありました。", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "　確定申告については所轄の税務署にお問い合わせください。", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　　市場金利の変動に応じた市場価格調整（※）を適用し計算するため、解約日の保険料積立金額から", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　　増減します。", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "【適用為替レートについて】", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　◆円貨支払いのご請求により、解約返戻金を外貨（指定通貨または選択通貨）にかえて解約日時点の当社", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　所定の為替レート（※１）で円貨に換算してお支払いしています。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）－５０銭」（※３）となります。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　日とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "　　　　公示値とします。", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＢを下回ることはありません。", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　◆「お手続き完了のお知らせ」は、確定申告の際の参考資料となりますので、大切に保管してください。", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");
        exStringEquals(ttdkKan.getOsirasemongon32(), "", "お知らせ文言３２");
        exStringEquals(ttdkKan.getOsirasemongon33(), "", "お知らせ文言３３");
        exStringEquals(ttdkKan.getOsirasemongon34(), "", "お知らせ文言３４");
        exStringEquals(ttdkKan.getOsirasemongon35(), "", "お知らせ文言３５");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(99999), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");

    }

    @Test
    @TestOrder(100)
    public void testEditTBL_A10() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111428");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｱ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.NONE);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111428", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額には以下の契約変更時返戻金（注）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を含みます。", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　１　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "・その他支払金合計はその他支払金明細の合計額（円）", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　を外貨に換算した金額です。　（１）÷（２)", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（１）その他支払金明細の合計額（円）", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　１３　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "　（２）適用為替レート：１２．００　円", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "必要書類の受付日翌日から５営業日を超えた２５日分", "備考１０");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.ARI, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "※２０１６年の所得となります。", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　　市場金利の変動に応じた市場価格調整（※）を適用し計算するため、解約日の保険料積立金額から", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　　増減します。", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "【適用為替レートについて】", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を解約日時点の当社所定の為替レート（※１）", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　で外貨（指定通貨または選択通貨）に換算してお支払いしています。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）＋５０銭」（※３）となります。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　日とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "　　　　公示値とします。", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、外貨（指定通", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "　　貨または選択通貨）を円貨に換算したうえで、円建の生命保険と同様に取り扱います。", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "　◆収入金額は、解約日の為替レートにて円換算した金額です。", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");
        exStringEquals(ttdkKan.getOsirasemongon32(), "", "お知らせ文言３２");
        exStringEquals(ttdkKan.getOsirasemongon33(), "", "お知らせ文言３３");
        exStringEquals(ttdkKan.getOsirasemongon34(), "", "お知らせ文言３４");
        exStringEquals(ttdkKan.getOsirasemongon35(), "", "お知らせ文言３５");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");

    }

    @Test
    @TestOrder(110)
    public void testEditTBL_A11() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111439");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.NONE);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111439", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額には以下の契約変更時返戻金（注）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を含みます。", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　１　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "・その他支払金合計はその他支払金明細の合計額（円）", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　を外貨に換算した金額です。　（１）÷（２)", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（１）その他支払金明細の合計額（円）", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　１３　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "　（２）適用為替レート：１２．００　円", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "必要書類の受付日翌日から５営業日を超えた２５日分", "備考１０");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(50), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【適用為替レートについて】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を解約日時点の当社所定の為替レート（※１）", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　で外貨（指定通貨または選択通貨）に換算してお支払いしています。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）＋５０銭」（※３）となります。", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　日とします。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　公示値とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、外貨（指定通", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　　貨または選択通貨）を円貨に換算したうえで、円建の生命保険と同様に取り扱います。", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "　◆収入金額は、解約日の為替レートにて円換算した金額です。", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　◆既払込保険料等は既に払い込まれた円貨払込額の合計額等です。", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "　◆税務取扱および申告手続の詳細については、所轄の税務署にお問い合わせください。", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");
        exStringEquals(ttdkKan.getOsirasemongon32(), "", "お知らせ文言３２");
        exStringEquals(ttdkKan.getOsirasemongon33(), "", "お知らせ文言３３");
        exStringEquals(ttdkKan.getOsirasemongon34(), "", "お知らせ文言３４");
        exStringEquals(ttdkKan.getOsirasemongon35(), "", "お知らせ文言３５");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKSYASIBOUKAIYAKU, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");

    }

    @Test
    @TestOrder(120)
    public void testEditTBL_A12() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111440");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.NONE);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111440", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額には以下の契約変更時返戻金（注）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を含みます。", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　１　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "・その他支払金合計はその他支払金明細の合計額（円）", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　を外貨に換算した金額です。　（１）÷（２)", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（１）その他支払金明細の合計額（円）", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　１３　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "　（２）適用為替レート：１２．００　円", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "必要書類の受付日翌日から５営業日を超えた２５日分", "備考１０");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(60), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【適用為替レートについて】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を解約日時点の当社所定の為替レート（※１）", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　で外貨（指定通貨または選択通貨）に換算してお支払いしています。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）＋５０銭」（※３）となります。", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　日とします。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　公示値とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、外貨（指定通", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　　貨または選択通貨）を円貨に換算したうえで、円建の生命保険と同様に取り扱います。", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "　◆収入金額は、解約日の為替レートにて円換算した金額です。", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　◆税務取扱および申告手続の詳細については、所轄の税務署にお問い合わせください。", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");
        exStringEquals(ttdkKan.getOsirasemongon32(), "", "お知らせ文言３２");
        exStringEquals(ttdkKan.getOsirasemongon33(), "", "お知らせ文言３３");
        exStringEquals(ttdkKan.getOsirasemongon34(), "", "お知らせ文言３４");
        exStringEquals(ttdkKan.getOsirasemongon35(), "", "お知らせ文言３５");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKSYASIBOUKAIYAKU, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");

    }

    @Test
    @TestOrder(130)
    public void testEditTBL_A13() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111451");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.NONE);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111451", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額には以下の契約変更時返戻金（注）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を含みます。", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　１　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "・その他支払金合計はその他支払金明細の合計額（円）", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　を外貨に換算した金額です。　（１）÷（２)", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（１）その他支払金明細の合計額（円）", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　１３　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "　（２）適用為替レート：１２．００　円", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "必要書類の受付日翌日から５営業日を超えた２５日分", "備考１０");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(70), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【適用為替レートについて】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を解約日時点の当社所定の為替レート（※１）", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　で外貨（指定通貨または選択通貨）に換算してお支払いしています。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）＋５０銭」（※３）となります。", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　日とします。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　公示値とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、外貨（指定通", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　　貨または選択通貨）を円貨に換算したうえで、円建の生命保険と同様に取り扱います。", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "　◆収入金額は、解約日の為替レートにて円換算した金額です。", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　◆税務取扱および申告手続の詳細については、所轄の税務署にお問い合わせください。", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");
        exStringEquals(ttdkKan.getOsirasemongon32(), "", "お知らせ文言３２");
        exStringEquals(ttdkKan.getOsirasemongon33(), "", "お知らせ文言３３");
        exStringEquals(ttdkKan.getOsirasemongon34(), "", "お知らせ文言３４");
        exStringEquals(ttdkKan.getOsirasemongon35(), "", "お知らせ文言３５");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKSYASIBOUKAIYAKU, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getGsbnrkztsaeki(), BizCurrency.valueOf(0), "源泉分離課税対象差益");

    }

    @Test
    @TestOrder(140)
    public void testEditTBL_A14() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111244");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.KYK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111244", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR, "書類コード");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(222), "収入金額");
    }
}