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
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoMockForHozen;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_GengkhouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HugouKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_SksmongonKbn;
import yuyu.def.classification.C_SoukinsakisiteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YenShrTkHnkKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.AS_Kinou;
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
public class EditTtdkKanryouTblTest_editTBL7 extends AbstractTest{

    @Inject
    private EditTtdkKanryouTbl editTtdkKanryouTbl;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private EditTtdkKanryouParam editTtdkKanryouParam;

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_手続完了TBL編集";

    private final static String sheetName = "INデータ_20201229";

    private static String callcentersosikicd;

    private static String uketimecallcenter1;

    private static String uketimecallcenter2;

    private static String uketimetantousitu1;

    private static String uketimetantousitu2;

    private IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinoInfo;

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
        RayHttpHeaderBeanMockForHozen.caller = EditTtdkKanryouTblTest_editTBL.class;
        GetKhKykdrInfoForHozen.caller = EditTtdkKanryouTblTest_editTBL.class;
        BzGetSosikiMadogutiInfoMockForHozen.caller = EditTtdkKanryouTblTest_editTBL.class;
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
            testDataAndTblMap = testDataMaker.getInData(EditTtdkKanryouTblTest_editTBL.class, fileName, sheetName);
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

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000015");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000015", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "保険料を２００　円に減額しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（　基本給付金額を１００　円に減額しました。）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　減額日（計算基準日）：２０１６年　４月　１日", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "減額部分の解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "保険料", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "その他精算金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "配当金", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "特別配当金", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "その他返戻金※", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(1), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(1), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(1), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(1), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.JPY, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.JPY, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.JPY, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.JPY, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(20)
    public void testEditTBL_A2() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000026");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000026", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "基準金額を１４　円に減額しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（減額後毎回円貨払込額　２００　円）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　減額日（計算基準日）：２０１６年　４月　１日", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "減額部分の解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.USD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "２２２　円", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(30)
    public void testEditTBL_A3() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000037");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000037", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "保険料を２００　円に減額しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（　基本給付金額を１００　円に減額しました。）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　減額日（計算基準日）：２０１６年　４月　１日", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "減額部分の解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "（明細）", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "・解約返戻金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "・保険料", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "その他精算金", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "配当金", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "特別配当金", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(222), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(2), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(2), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(1), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(1), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.JPY, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.JPY, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.JPY, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.JPY, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.JPY, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・減額部分の解約返戻金は明細の合計額（外貨）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を円貨に換算した金額です。　（１）×（２）", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（１）適用為替レート：４５６．００　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）減額部分の解約返戻金額明細の合計額（外貨）", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１３　円", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "適用為替レート：４５６．００　円", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(40)
    public void testEditTBL_A4() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000048");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000048", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "保険料を２００　円に減額しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（　基本給付金額を１００　円に減額しました。）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　減額日（計算基準日）：２０１６年　４月　１日", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "減額部分の解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "保険料", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "その他支払金合計", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "（明細）", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "・その他精算金", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "・配当金", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "・特別配当金", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(2), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(1), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(2), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(1), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(1), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.USD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.USD, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.JPY, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.JPY, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.JPY, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・その他支払金合計はその他支払金明細の合計額（円）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を外貨に換算した金額です。　（１）÷（２)", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（１）その他支払金明細の合計額（円）", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　１３　円", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　（２）適用為替レート：１２．００　円", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(50)
    public void testEditTBL_A5() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000059");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000059", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "保険料を２００　円に減額しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（　基本給付金額を１００　円に減額しました。）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　減額日（計算基準日）：２０１６年　４月　１日", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "減額部分の解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.USD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(60)
    public void testEditTBL_A6() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000060");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(1);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "06", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000060", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "保険料を２００　円に減額しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（　基本給付金額を１００　円に減額しました。）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　減額日（計算基準日）：２０１６年　４月　１日", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "減額部分の解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "その他支払金合計", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "（明細）", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.USD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.USD, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・その他支払金合計はその他支払金明細の合計額（円）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を外貨に換算した金額です。　（１）÷（２)", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（１）その他支払金明細の合計額（円）", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　１３　円", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　（２）適用為替レート：１２．００　円", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
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
        exStringEquals(ttdkKan.getOsirasemongon17(), "　◆既払込保険料等は既に払い込まれた保険料等の合計額です。", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "　◆所轄の税務署あてに、支払調書を提出いたします。", "お知らせ文言１８");
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
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(70)
    public void testEditTBL_A7() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000071");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｹ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(1);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.PD);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "07", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000071", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "保険料を２００　円に減額しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（　基本給付金額を１００　円に減額しました。）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　減額日（計算基準日）：２０１６年　４月　１日", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "減額部分の解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "その他支払金合計", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "（明細）", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "・保険料（円貨払込額）", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(2), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.JPY, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "２２２　円", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(80)
    public void testEditTBL_A8() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000082");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(1);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "08", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000082", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "　基本給付金額を１００　円に減額しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "　減額日（計算基準日）：２０１６年　４月　１日", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "減額部分の解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・減額部分の解約返戻金は解約返戻金（外貨）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を円貨に換算した金額です。　（１）×（２）", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（１）適用為替レート：４５６．００　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）減額部分の解約返戻金（外貨）", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１３　円", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "適用為替レート：４５６．００　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆「お手続き完了のお知らせ」は、確定申告の際の参考資料となりますので、大切に保管してください。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆既払込保険料等は既に払い込まれた円貨払込額の合計額等です。", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　◆所轄の税務署あてに、支払調書を提出いたします。", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
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
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(90)
    public void testEditTBL_A9() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000093");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾆｱ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.ARI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "09", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000093", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "保険料", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "特別配当金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(2), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(1), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.JPY, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆消滅日は保険料払込みの猶予期間満了日の翌日です。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【保険料のご返金について】 ", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　当社から金融機関あてに次回の保険料の振替依頼は完了しています。行き違いに保険料が振り替えられたと", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　きは、当社へ着金しだい振替口座へご返金させていただきます。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　＊口座振替日　２０１９年　６月１４日", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　＊口座振替依頼金額　２３４，５６７　円　２０１９年　４月から９か月分を", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　ご案内しています。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　◆税法上、源泉分離課税の対象となりますが、お支払金額から差し引かれる税額はありません。", "お知らせ文言１２");
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
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(100)
    public void testEditTBL_A10() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000107");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾂ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "00", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000107", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "（明細）", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "・解約返戻金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "・保険料", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "その他精算金", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "特別配当金", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(222), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(1), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(1), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(1), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.JPY, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.JPY, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.JPY, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.JPY, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額＝（１）×（２）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）適用為替レート：４５６．００　円", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（２）解約返戻金", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　１３　円", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　上記解約返戻金には以下の契約変更時返戻金（注）", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　　を含みます。", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　１　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "・その他支払金合計はその他支払金明細の合計額です。", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【解約返戻金に対する税務のご説明】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆税法上、源泉分離課税の対象となりますが、お支払金額から差し引かれる税額はありません。", "お知らせ文言５");
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
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(110)
    public void testEditTBL_A11() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000118");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾆｱ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(1);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000118", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "保険料", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "その他支払金合計", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "（明細）", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "・その他精算金", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "・配当金", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(1), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(1), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(1), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.USD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.USD, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.JPY, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.JPY, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額には以下の契約変更時返戻金（注）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を含みます。", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　１　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "・その他支払金合計はその他支払金明細の合計額（円）", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　を外貨に換算した金額です。　（１）÷（２)", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（１）その他支払金明細の合計額（円）", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　１３　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "　（２）適用為替レート：１２．００　円", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【保険料のご返金について】 ", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　当社から金融機関あてに次回の保険料の振替依頼は完了しています。行き違いに保険料が振り替えられたと", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　きは、当社へ着金しだい振替口座へご返金させていただきます。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　＊口座振替日　２０１９年　６月１４日", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　＊口座振替依頼金額　７０３，７０１　円　２０１９年　６月から２７か月分を", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　ご案内しています。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　◆収入金額は、解約日の為替レートにて円換算した金額です。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　◆既払込保険料等は既に払い込まれた保険料等の合計額です。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "　◆税務取扱および申告手続の詳細については、所轄の税務署にお問い合わせください。", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "　◆所轄の税務署あてに、支払調書を提出いたします。", "お知らせ文言１５");
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
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(120)
    public void testEditTBL_A12() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000129");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾍ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000129", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額は解約返戻金額明細の合計額（外貨）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を円貨に換算した金額です。　（１）×（２）", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（１）適用為替レート：４５６．００　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）解約返戻金額明細の合計額（外貨）", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１３　円", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【解約返戻金に対する税務のご説明】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆税法上、源泉分離課税の対象となりますが、お支払金額から差し引かれる税額はありません。", "お知らせ文言５");
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
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(130)
    public void testEditTBL_A13() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000130");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾆｱ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.ARI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000130", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "保険料", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "その他精算金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "その他返戻金※", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(2), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(1), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(1), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.JPY, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.JPY, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆消滅日は保険料払込みの猶予期間満了日の翌日です。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【解約返戻金に対する税務のご説明】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆税法上、源泉分離課税の対象となりますが、お支払金額から差し引かれる税額はありません。", "お知らせ文言５");
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
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(140)
    public void testEditTBL_A14() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000141");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾆｱ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.ARI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000141", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "保険料", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "配当金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(2), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(1), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.JPY, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆消滅日は保険料払込みの猶予期間満了日の翌日です。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【解約返戻金に対する税務のご説明】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆税法上、源泉分離課税の対象となりますが、お支払金額から差し引かれる税額はありません。", "お知らせ文言５");
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
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(150)
    public void testEditTBL_A15() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000152");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾆｱ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.ARI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000152", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "保険料", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "配当金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(2), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(1), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.JPY, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆消滅日は保険料払込みの猶予期間満了日の翌日です。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【解約返戻金に対する税務のご説明】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆税法上、源泉分離課税の対象となりますが、お支払金額から差し引かれる税額はありません。", "お知らせ文言５");
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
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(160)
    public void testEditTBL_A16() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000163");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBKAIJO);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "06", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000163", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "保険料", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "その他精算金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(2), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(1), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.JPY, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(170)
    public void testEditTBL_A17() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000174");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBKAIJO);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "07", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000174", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "保険料積立金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "（明細）", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "・保険料積立金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(222), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.USD, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "外貨金額：１３　円", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "為替レート：１米ドル　＝　４５６．００　円", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "換算基準日：２０１６年　４月　２日", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(180)
    public void testEditTBL_A18() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000185");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBKAIJO);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "08", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000185", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "保険料積立金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "その他支払金合計", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "（明細）", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "・配当金", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "・特別配当金", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(1), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(1), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.USD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.USD, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.JPY, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.JPY, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(190)
    public void testEditTBL_A19() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000196");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｹ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBKAIJO);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "09", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000196", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "保険料積立金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.USD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(200)
    public void testEditTBL_A20() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000200");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBKAIJO);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "00", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000200", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "保険料積立金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "外貨金額：１３　円", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "為替レート：１米ドル　＝　４５６．００　円", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "換算基準日：２０１６年　４月　２日", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(210)
    public void testEditTBL_A21() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000211");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBKAIJO);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR_SHRARI);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000211", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR_SHRARI, "書類コード");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "　被保険者の生年月日・性を平成２８年　４月　１日　男性に訂正しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "　計算基準日：２０１６年　４月　１日", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getTekiyou1(), "返還金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・返還金＝（１）×（２）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）適用為替レート：４５６．００　円", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（２）返還金", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　２２２　円", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【適用為替レートについて】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆円貨支払いのご請求により、返還金を外貨（指定通貨または選択通貨）にかえて生年月日・性訂正日時点の", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　　当社所定の為替レート（※１）で円貨に換算してお支払いしています。", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）－５０銭」（※３）となります。", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　　　日とします。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　公示値とします。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＢを下回ることはありません。", "お知らせ文言１０");
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
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(220)
    public void testEditTBL_A22() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000222");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBKAIJO);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR_SHRARI);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000222", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR_SHRARI, "書類コード");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "1", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "　被保険者の生年月日・性を平成２８年　４月　１日　男性に訂正しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "　計算基準日：２０１６年　４月　１日", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getTekiyou1(), "返還金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.USD, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
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
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(230)
    public void testEditTBL_A23() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000233");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.SBKAIJO);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR_SHRARI);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000233", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR_SHRARI, "書類コード");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "1", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "　被保険者の生年月日・性を平成２８年　４月　１日　男性に訂正しました。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "　計算基準日：２０１６年　４月　１日", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getTekiyou1(), "返還金", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getOsirasemongon1(), "", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "", "お知らせ文言５");
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
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(240)
    public void testEditTBL_A24() {

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");
        kinoInfo.setCategoryId("khcommon");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("19806000244");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾆｱ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        khShrRireki.setYenhtykeihi(BizCurrency.valueOf(111));
        khShrRireki.setYenshrkykhtykeihi(BizCurrency.valueOf(99999));
        khShrRireki.setKykhnkkaisuu(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam = setCommonValueForTest();
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "19806000244", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getOsiraseinjihuyouhyouji(), "0", "お知らせ印字不要表示");
        exDateEquals(ttdkKan.getCalckijyunymd(), BizDate.valueOf(20160401), "計算基準日");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(234), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額＝（１）×（２）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）適用為替レート：４５６．００　円", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（２）解約返戻金", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　１３　円", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約返戻金は、解約返戻金を消滅日の当社所定の為替レートで円貨に換算した金額です。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆消滅日は保険料払込みの猶予期間満了日の翌日です。", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "【保険料のご返金について】 ", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　当社から金融機関あてに次回の保険料（円貨払込額）の振替依頼は完了しています。行き違いに保険料（円", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　貨払込額）が振り替えられたときは、当社へ着金しだい振替口座へご返金させていただきます。", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　＊口座振替日　２０１９年　６月１４日", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　＊口座振替依頼金額　２３４，５６７　円　２０１９年　６月から９か月分を", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　　ご案内しています。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　◆消滅日の属する年の所得となります。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "　　は、確定申告の際の参考資料となりますので、大切に保管してください。", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "　◆所轄の税務署あてに、支払調書を提出いたします。", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
    }

    private EditTtdkKanryouParam setCommonValueForTest() {

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
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.KAIYAKU);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setDocumentId("");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.BLNK);
        editTtdkKanryouParam.setHozonKikanY(0);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);

        return editTtdkKanryouParam;

    }

}
