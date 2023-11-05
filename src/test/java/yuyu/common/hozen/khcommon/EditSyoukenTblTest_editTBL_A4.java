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
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.GetKawaseRateMock;
import yuyu.common.biz.bzcommon.HanteiHokenKikanMock;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMock;
import yuyu.common.biz.bzdairiten.BzGetAgInfoMock;
import yuyu.common.siharai.sicommon.CalcHkShrKngkMock;
import yuyu.common.siharai.sicommon.CalcJdkghkKngkMock;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_StdrsktkyhnkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険証券TBL編集クラスのメソッド {@link EditSyoukenTbl#editTBL(KhozenCommonParam,IT_KykKihon,List,IT_KykSonotaTkyk,List,IT_SyouhnTokujou,IT_KykSya,IT_HhknSya,IT_KykUkt,IT_KykUkt,List,IT_KhTtdkTyuui,List,List,EditHokenSyoukenParam,BizDate,C_SinsaihkKbn,C_TetudukisyuKbn,C_HassouKbn)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditSyoukenTblTest_editTBL_A4 {

    private final static String syoNo1 = "20806000019";

    private final static String syoNo2 = "20806000020";

    private final static String syoNo3 = "20806000031";

    private final static String syoNo4 = "20806000042";

    private final static String syoNo5 = "20806000053";

    private final static String syoNo6 = "20806000064";

    private final static String syoNo7 = "20806000075";

    private final static String syoNo8 = "20806000086";

    private final static String syoNo9 = "20806000097";

    private final static String syoNo10 = "20806000101";

    private final static String syoNo11 = "20806000112";

    private final static String syoNo12 = "20806000123";

    private final static String syoNo13 = "20806000134";

    private final static String syoNo14 = "20806000145";

    private final static String syoNo15 = "20806000156";

    private final static String syoNo16 = "20806000167";

    private final static String syoNo17 = "20806000178";

    private final static String syoNo18 = "20806000189";

    private final static String syoNo19 = "20806000190";

    private final static String syoNo20 = "20806000204";

    private final static String syoNo21 = "20806000215";

    private final static String syoNo22 = "20806000226";

    private final static String syoNo23 = "20806000237";

    private final static String kbnKey1 = "01";

    private final static String kbnKey2 = "02";

    private final static String kbnKey3 = "03";

    private final static String kbnKey4 = "04";

    private final static String kbnKey5 = "05";

    private final static String kbnKey6 = "06";

    private final static String kbnKey7 = "07";

    private final static String kbnKey8 = "08";

    private final static String kbnKey9 = "09";

    private final static String kbnKey10 = "00";

    @Inject
    private EditSyoukenTbl editSyoukenTbl;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private EditHokenSyoukenParam editHokenSyoukenParam;

    private final static String fileName = "UT-SP_単体テスト仕様書_保険証券TBL編集";

    private final static String sheetName = "INデータ";

    @BeforeClass
    public static void testInit() {
        HanteiHokenKikanMock.caller = EditSyoukenTblTest_editTBL_A4.class;
        KeisanKijyungkMock.caller = EditSyoukenTblTest_editTBL_A4.class;
        BzGetAgInfoMock.caller = EditSyoukenTblTest_editTBL_A4.class;
        SetOutoubiMock.caller = EditSyoukenTblTest_editTBL_A4.class;
        GetKawaseRateMock.caller = EditSyoukenTblTest_editTBL_A4.class;
        CalcHkShrKngkMock.caller = EditSyoukenTblTest_editTBL_A4.class;
        KeisanGaikakanzanMock.caller = EditSyoukenTblTest_editTBL_A4.class;
        CalcJdkghkKngkMock.caller = EditSyoukenTblTest_editTBL_A4.class;
        EditSuiihyouTblMock.caller = EditSyoukenTblTest_editTBL_A4.class;
    }

    @AfterClass
    public static void testClear() {
        HanteiHokenKikanMock.caller = null;
        KeisanKijyungkMock.caller = null;
        BzGetAgInfoMock.caller = null;
        SetOutoubiMock.caller = null;
        GetKawaseRateMock.caller = null;
        CalcHkShrKngkMock.caller = null;
        KeisanGaikakanzanMock.caller = null;
        CalcJdkghkKngkMock.caller = null;
        EditSuiihyouTblMock.caller = null;

        HanteiHokenKikanMock.SYORIPTN = null;
        KeisanKijyungkMock.SYORIPTN = null;
        BzGetAgInfoMock.SYORIPTN = null;
        SetOutoubiMock.SYORIPTN = null;
        GetKawaseRateMock.SYORIPTN = null;
        CalcHkShrKngkMock.SYORIPTN = null;
        KeisanGaikakanzanMock.SYORIPTN = null;
        CalcJdkghkKngkMock.SYORIPTN = null;
        EditSuiihyouTblMock.SYORIPTN = null;

        MockObjectManager.initialize();
    }
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditSyoukenTblTest_editTBL_A4.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ004", testDataAndTblMap);
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
        bizDomManager.delete(bizDomManager.getAllTantouCd());
        bizDomManager.delete(bizDomManager.getAllSisuuKihon());
    }

    @Test
    @TestOrder(10)
    public void testEditTBL_E1() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN1;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000010");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo1);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = new ArrayList<>();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.ARI);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.ARI);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey1, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo1, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "0", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(0), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(101), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(-1), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(0), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13070", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "13080", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "13082", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "13090", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "05", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "13110", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13122", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "13150", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(10000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "13170", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "13180", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "13200", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.JPY, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(11000), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "13240", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "13250", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");

        exClassificationEquals(editSyoukenTbl.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
    }

    @Test
    @TestOrder(20)
    public void testEditTBL_E2() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN1;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000020");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo2);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = new ArrayList<>();

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey2, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo2, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "0", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(0), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(0), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13070", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "13080", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "13090", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "06", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "13110", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13124", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "13140", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "13150", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(10000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "13170", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "13180", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "13190", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.JPY, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(11000), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "13240", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "13250", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "15042", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }

    @Test
    @TestOrder(30)
    public void testEditTBL_E3() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000030");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo3);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey3, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo3, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "20180331", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "JPY", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(1001), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(1), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13010", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.JPY, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(1001), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(1), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13070", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "13080", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "13090", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "04", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "13110", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13120", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "13150", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.EUR, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(20000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "13170", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "13180", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "13192", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.JPY, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(11000), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "13240", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "13250", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "15043", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }

    @Test
    @TestOrder(40)
    public void testEditTBL_E4() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN2;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000040");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo4);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey4, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo4, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "20180331", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "0", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(0), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13020", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(0), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13070", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "13090", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "02", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "13142", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "13150", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.EUR, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(20000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "13170", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "13180", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "13192", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.JPY, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(11000), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "13240", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "13250", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }

    @Test
    @TestOrder(50)
    public void testEditTBL_E5() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000050");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo5);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey5, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo5, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "20180331", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "0", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(0), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13020", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(0), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13090", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "13144", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "13150", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.EUR, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(20000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "13170", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "13180", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "13192", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.JPY, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(11000), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "13240", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "13250", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "15043", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }

    @Test
    @TestOrder(60)
    public void testEditTBL_E6() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN2;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000060");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo6);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo6, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "20180331", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "0", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(1), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13020", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(1), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13071", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(0), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.BLNK, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(0), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }
    @Test
    @TestOrder(70)
    public void testEditTBL_E7() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN2;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000070");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo7);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey7, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo7, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "20180331", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "JPY", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(0), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13010", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "13012", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "13022", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.JPY, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(0), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13070", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "13090", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "03", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(0), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.BLNK, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(0), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }

    @Test
    @TestOrder(80)
    public void testEditTBL_E8() {

        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000080");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo8);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey8, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo8, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "20180331", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "JPY", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(0), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13010", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "13012", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "13022", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.JPY, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(0), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13070", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "13090", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "01", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(0), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.BLNK, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(0), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }

    @Test
    @TestOrder(90)
    public void testEditTBL_E9() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000090");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo9);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey9, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo9, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "20180331", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "JPY", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(1), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13010", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "13020", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.JPY, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(1), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13070", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "13090", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "01", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(0), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.BLNK, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(0), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }

    @Test
    @TestOrder(100)
    public void testEditTBL_E10() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN2;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000100");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo10);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey10, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo10, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "20180331", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "0", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(1), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(99), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(1), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13020", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(1), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13072", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "13090", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(0), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.BLNK, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(0), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }

    @Test
    @TestOrder(110)
    public void testEditTBL_E11() {

        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN2;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000110");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo11);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey1, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo11, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "20180331", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "0", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(1), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13020", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(1), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13070", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "13090", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "01", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(0), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.BLNK, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(0), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }

    @Test
    @TestOrder(120)
    public void testEditTBL_E12() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN2;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000120");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo12);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey2, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo12, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "0", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(0), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(99), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(1), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(0), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13073", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "13080", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "13090", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "13110", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "13150", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.EUR, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(20000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "13170", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.JPY, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(11000), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "13240", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "13250", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }

    @Test
    @TestOrder(130)
    public void testEditTBL_E13() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN2;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000130");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo13);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey3, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo13, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "0", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(0), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(0), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13075", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "13090", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "09", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "13150", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.EUR, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(20000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "13170", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "13180", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "13220", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.JPY, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(11000), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "13240", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "13250", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "15044", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }

    @Test
    @TestOrder(140)
    public void testEditTBL_E14() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN2;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000140");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo14);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey4, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo14, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "0", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(0), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(101), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(-1), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(0), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13075", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "13090", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "07", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "13150", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.EUR, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(20000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "13170", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "13180", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "13220", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.JPY, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(11000), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "13240", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "13250", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "15044", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }

    @Test
    @TestOrder(150)
    public void testEditTBL_E15() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN2;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000150");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo15);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey5, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo15, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "20180331", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "0", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(0), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(98), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(2), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13022", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(0), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13072", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "13090", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "09", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13130", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(0), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.BLNK, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(0), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }

    @Test
    @TestOrder(160)
    public void testEditTBL_E16() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000160");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo16);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo16, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "20180331", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "0", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(0), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13022", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(0), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13073", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "13090", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "07", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13126", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(0), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.BLNK, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(0), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }

    @Test
    @TestOrder(170)
    public void testEditTBL_E17() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000170");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo17);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey7, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo17, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "0", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(0), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(101), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(-1), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13022", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(0), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13073", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "13090", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "07", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(0), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.BLNK, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(0), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }

    @Test
    @TestOrder(180)
    public void testEditTBL_E18() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000180");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo18);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey8, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo18, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "0", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(0), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(99), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(1), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13022", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(0), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13074", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "13090", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "07", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(0), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.BLNK, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(0), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }

    @Test
    @TestOrder(190)
    public void testEditTBL_E19() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000190");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo19);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey9, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo19, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "0", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(0), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(98), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(2), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13022", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(0), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13075", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "13090", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "07", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(0), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.BLNK, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(0), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }

    @Test
    @TestOrder(200)
    public void testEditTBL_E20() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo20);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey10, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo20, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "0", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(0), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13022", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(0), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13076", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "13077", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "13090", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "07", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(0), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.BLNK, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(0), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }

    @Test
    @TestOrder(210)
    public void testEditTBL_E21() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000210");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo21);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey1, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo21, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "0", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(0), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13022", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(0), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "07", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(0), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.BLNK, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(0), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }

    @Test
    @TestOrder(220)
    public void testEditTBL_E22() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000220");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo22);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey2, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo22, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "0", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(0), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(0), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13075", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "13090", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "13150", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.EUR, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(20000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "13170", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "13180", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "13210", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.JPY, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(11000), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "13240", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "13250", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }

    @Test
    @TestOrder(230)
    public void testEditTBL_E23() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000230");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo23);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey3, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo23, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "20180331", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "0", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(0), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(0), "目標到達時円建終身保険移行特約目標割合");

        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13090", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "13150", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.EUR, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(20000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "13170", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.JPY, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(11000), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "13240", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "13250", "案内汎用メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "15044", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
    }
}