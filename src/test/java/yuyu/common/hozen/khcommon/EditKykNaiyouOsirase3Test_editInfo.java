package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.configuration.ProductMode;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForHozen;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.bzcommon.SetNenreiMockForHozen;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkMockForHozen;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 契約内容のお知らせ編集３のメソッド {@link EditKykNaiyouOsirase3#editInfo(IT_KykKihon ,BizDate ,
        BizDate ,String ,ZT_GaikaKokyakuTuutiTy)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditKykNaiyouOsirase3Test_editInfo {

    @Inject
    HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_契約内容のお知らせ編集３";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(EditKykNaiyouOsirase3Test_editInfo.class, fileName, sheetName);

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
        bizDomManager.delete(bizDomManager.getAllSisuuKihon());

    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SetNenrei.class).to(SetNenreiMockForHozen.class);
                bind(CalcHkShrKngk.class).to(CalcHkShrKngkMockForHozen.class);
                bind(KeisanGaikakanzan.class).to(KeisanGaikakanzanMockForHozen.class);
                bind(KeisanTukiIkkatuNyuukinGk.class).to(KeisanTukiIkkatuNyuukinGkMockForHozen.class);
                bind(KeisanCommonKaiyaku.class).to(KeisanCommonKaiyakuMockForHozen.class);
                bind(KeisanVHeijyun.class).to(KeisanVHeijyunMockForHozen.class);
                bind(KeisanHrrtksnHrkPGkgk.class).to(KeisanHrrtksnHrkPGkgkMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        SetNenreiMockForHozen.caller = EditKykNaiyouOsirase3Test_editInfo.class;

        CalcHkShrKngkMockForHozen.caller = EditKykNaiyouOsirase3Test_editInfo.class;

        KeisanGaikakanzanMockForHozen.caller = EditKykNaiyouOsirase3Test_editInfo.class;

        KeisanTukiIkkatuNyuukinGkMockForHozen.caller = EditKykNaiyouOsirase3Test_editInfo.class;

        KeisanCommonKaiyakuMockForHozen.caller = EditKykNaiyouOsirase3Test_editInfo.class;

        KeisanVHeijyunMockForHozen.caller = EditKykNaiyouOsirase3Test_editInfo.class;

        KeisanHrrtksnHrkPGkgkMockForHozen.caller = EditKykNaiyouOsirase3Test_editInfo.class;
    }

    @AfterClass
    public static void testClear() {

        SetNenreiMockForHozen.caller = null;
        CalcHkShrKngkMockForHozen.caller = null;
        KeisanGaikakanzanMockForHozen.caller = null;
        KeisanTukiIkkatuNyuukinGkMockForHozen.caller = null;
        KeisanCommonKaiyakuMockForHozen.caller = null;
        KeisanVHeijyunMockForHozen.caller = null;
        KeisanHrrtksnHrkPGkgkMockForHozen.caller = null;
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testEditInfo_A1() {

        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000013");
        BizDate pSyoriYmd = BizDate.valueOf(20190501);
        BizDate pKykoutoubi = BizDate.valueOf(20190501);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN1;

        EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
        osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "exec", 0, 0), BizDate.valueOf(20250901), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForHozen.class,
            "exec", 0, 1), BizDate.valueOf(19820101), "生年月日");

        exStringEquals((String)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 0), "17806000013", "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 1), BizDate.valueOf(20190501), "計算基準日");
        exClassificationEquals((C_SiinKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 2), C_SiinKbn.SP, "死因区分");
        exClassificationEquals((C_HokenkinsyuruiKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 3), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 4), C_Sdpd.PD, "Ｓ建Ｐ建区分");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 5), C_Hrkkeiro.KOUHURI, "払込経路");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 1), BizCurrency.valueOf(1111), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 2), BizNumber.valueOf(10.1), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 1), BizCurrency.valueOf(22), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 2), BizNumber.valueOf(10.1), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean =
            (KeisanIkkatuNyuukinGkBean) MockObjectManager.getArgument(KeisanTukiIkkatuNyuukinGkMockForHozen.class, "exec", 0, 0);

        KeisanIkkatuNyuukinGkSyouhnBean KeisanIkkatuNyuukinGkSyouhnBean =
            keisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst().get(0);

        exStringEquals(KeisanIkkatuNyuukinGkSyouhnBean.getSyouhnCd(), "ﾕｱ",                                                 "商品コード");
        exNumericEquals(KeisanIkkatuNyuukinGkSyouhnBean.getSyouhnsdNo(), 1,                                                 "商品世代番号");
        exStringEquals(KeisanIkkatuNyuukinGkSyouhnBean.getRyouritusdNo(), "11",                                             "料率世代番号");
        exBizCalcbleEquals(KeisanIkkatuNyuukinGkSyouhnBean.getHokenryou(), BizCurrency.valueOf(1100, BizCurrencyTypes.YEN), "保険料");
        exNumericEquals(keisanIkkatuNyuukinGkBean.getJyuutoutuKisuu(), 1,                                                   "充当月数");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.NONE,                  "定期一括払種類区分");
        exBooleanEquals((boolean)MockObjectManager.getArgument(KeisanTukiIkkatuNyuukinGkMockForHozen.class, "exec", 0, 1), false,       "一括割引不要フラグ");

        exStringEquals((String)MockObjectManager.getArgument(
            KeisanCommonKaiyakuMockForHozen.class, "keisanKaiyakuseisankin", 0, 0), KeisanCommonKaiyaku.KINOUBUNRUI_DRCTSERVICE, "機能分類");

        IT_KykKihon kykKihon = (IT_KykKihon) MockObjectManager.getArgument(KeisanCommonKaiyakuMockForHozen.class,  "keisanKaiyakuseisankin", 0, 1);

        exStringEquals(kykKihon.getKbnkey(), "01"         , "区分キー");
        exStringEquals(kykKihon.getSyono(),  "17806000013", "証券番号");

        exDateEquals((BizDate)MockObjectManager.getArgument(
            KeisanCommonKaiyakuMockForHozen.class, "keisanKaiyakuseisankin", 0, 2), BizDate.valueOf(20190501),                 "処理年月日");

        KeisanKaiyakuBean keisanKaiyakuBean =
            (KeisanKaiyakuBean) MockObjectManager.getArgument(KeisanCommonKaiyakuMockForHozen.class,  "keisanKaiyakuseisankin", 0, 3);

        exDateEquals(keisanKaiyakuBean.getSyoruiukeymd()       , BizDate.valueOf(20190501), "書類受付日");
        exDateEquals(keisanKaiyakuBean.getKaiykymd()           , BizDate.valueOf(20190501), "解約日");
        exBizCalcbleEquals(keisanKaiyakuBean.getYenshrkwsrate(), BizNumber.valueOf(10.1),   "円支払為替レート");

        KeisanVHeijyunBean keisanVHeijyunBean =
            (KeisanVHeijyunBean) MockObjectManager.getArgument(KeisanVHeijyunMockForHozen.class, "exec", 0, 0);

        exStringEquals(keisanVHeijyunBean.getSyouhncd(), "ﾕｱ",                                                      "商品コード");
        exStringEquals(keisanVHeijyunBean.getRyouritusdno(), "11",                                                  "料率世代番号");
        exDateYMEquals(keisanVHeijyunBean.getCalckijyunYm(), BizDateYM.valueOf(202509),                             "計算基準年月");
        exDateEquals(keisanVHeijyunBean.getKykymd(),  BizDate.valueOf(20180501),                                    "契約日");
        exBizCalcbleEquals(keisanVHeijyunBean.getHokenryou(), BizCurrency.valueOf(1100, BizCurrencyTypes.YEN),      "保険料");
        exClassificationEquals(keisanVHeijyunBean.getKyktuukasyu(), C_Tuukasyu.JPY,                                 "契約通貨種類");
        exClassificationEquals(keisanVHeijyunBean.getHhknsei(), C_Hhknsei.MALE,                                     "被保険者性別");
        exNumericEquals(keisanVHeijyunBean.getHhknnen(), 10,                                                        "被保険者年齢");
        exNumericEquals(keisanVHeijyunBean.getHknkkn(), 1,                                                          "保険期間");
        exClassificationEquals(keisanVHeijyunBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI,                       "保険期間歳満期区分");
        exNumericEquals(keisanVHeijyunBean.getHrkkkn(), 0,                                                          "払込期間");
        exClassificationEquals(keisanVHeijyunBean.getHrkkknsmnkbn(), C_HrkkknsmnKbn.SAIMANKI,                       "払込期間歳満期区分");
        exClassificationEquals(keisanVHeijyunBean.getHrkkaisuu(), C_Hrkkaisuu.TUKI,                                 "払込回数");
        exDateEquals(keisanVHeijyunBean.getFstpryosyu(), BizDate.valueOf(20190201),                                 "初回保険料領収日");
        exBizCalcbleEquals(keisanVHeijyunBean.getSitihsyuriritu(), BizNumber.valueOf(1.1),                          "最低保証利率");
        exDateYMEquals(keisanVHeijyunBean.getTmttkntaisyouym(), BizDateYM.valueOf(201906),                          "積立金対象年月");
        exBizCalcbleEquals(keisanVHeijyunBean.getCalckaisiYmjitenv(), BizCurrency.valueOf(10000, BizCurrencyTypes.YEN),   "計算開始年月時点Ｖ");
        exBizCalcbleEquals(keisanVHeijyunBean.getCalckaisiYmjitensump(), BizCurrency.valueOf(8000, BizCurrencyTypes.YEN), "計算開始年月時点累計Ｐ");
        exClassificationEquals(keisanVHeijyunBean.getSisansyuruikbn(), C_KhSisanSyuruiKbn.JISSEKI_SISAN,            "試算種類区分");
        exDateEquals(keisanVHeijyunBean.getSisansyoriYmd(), BizDate.valueOf(20190501),                              "予測計算開始日");
        exBizCalcbleEquals(keisanVHeijyunBean.getSisanyoteiriritu(), BizNumber.valueOf(0.1),                        "予測計算予定利率");
        exBizCalcbleEquals(keisanVHeijyunBean.getSisankawaserate(), BizNumber.valueOf(10.1),                        "予測計算為替レート");

        exStringEquals((String)MockObjectManager.getArgument(KeisanHrrtksnHrkPGkgkMockForHozen.class,
            "exec", 0, 0), "17806000013", "証券番号");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyaisatumsgcd1(), "03008", "（中継用）挨拶文メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "２０１９年　５月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "（定額年金型）", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkkaisuu(), "01", "（中継用）払込回数");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytikiktbrisyuruikbn(), "01", "（中継用）定期一括払種類区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyzennouumu(), "1", "（中継用）前納有無");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkkeiro(), "1", "（中継用）払込経路");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyphrkkkn(), "0", "（中継用）保険料払込期間");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysueokikkn(), "0", "（中継用）据置期間");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "1100", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1010", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "111100", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "2001", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "22222200", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "33333333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05013", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05014", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05015", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "05016", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "05017", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd8(), "05018", "（中継用）保障内容補足メッセージコード８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd9(), "", "（中継用）保障内容補足メッセージコード９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkiktnkgk(), "123456", "（中継用）円貨払込額（一括入金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyzennoutikiktyenhrkgkkykj(), "120100", "（中継用）前納定期一括払円貨払込額（契約時）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigk(), "8888", "（中継用）解約時支払額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigkznnuzndk(), "4444", "（中継用）解約時支払額（前納残高）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigksntshrgk(), "-33328889", "（中継用）解約時支払額（その他支払金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkgoukei(), "2000", "（中継用）円貨払込額の合計額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrritu(), "444", "（中継用）返戻率");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsyensyourai(), "2001", "（中継用）年金原資（円貨）（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgaikasyourai(), "102200", "（中継用）年金原資（契約通貨）（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkgoukeisyourai(), "2000", "（中継用）円貨払込額の合計額（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrritusyourai(), "100", "（中継用）返戻率（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd1(), "05030", "（中継用）年金原資試算補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd2(), "05031", "（中継用）年金原資試算補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd3(), "05032", "（中継用）年金原資試算補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd4(), "", "（中継用）年金原資試算補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd5(), "", "（中継用）年金原資試算補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");


        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym1(), "2018年8月", "（中継用）予定利率基準年月＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu1(), "12500", "（中継用）予定利率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt1(), "12500", "（中継用）予定利率計算基準利率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym1(), "2018年7月", "（中継用）為替レート基準年月＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate1(), "100", "（中継用）換算為替レート＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika1(), "", "（中継用）保険料（契約通貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen1(), "", "（中継用）保険料（円貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn1(), "", "（中継用）初回保険料表示区分＿１");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym2(), "2018年7月", "（中継用）予定利率基準年月＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu2(), "12500", "（中継用）予定利率＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt2(), "12500", "（中継用）予定利率計算基準利率＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym2(), "2018年6月", "（中継用）為替レート基準年月＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate2(), "100", "（中継用）換算為替レート＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika2(), "", "（中継用）保険料（契約通貨）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen2(), "", "（中継用）保険料（円貨）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn2(), "", "（中継用）初回保険料表示区分＿２");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym3(), "2018年6月", "（中継用）予定利率基準年月＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu3(), "12500", "（中継用）予定利率＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt3(), "12500", "（中継用）予定利率計算基準利率＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym3(), "2018年5月", "（中継用）為替レート基準年月＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate3(), "100", "（中継用）換算為替レート＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika3(), "", "（中継用）保険料（契約通貨）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen3(), "", "（中継用）保険料（円貨）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn3(), "1", "（中継用）初回保険料表示区分＿３");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd1(), "05040", "（中継用）予定利率一覧補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd2(), "05041", "（中継用）予定利率一覧補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd3(), "05042", "（中継用）予定利率一覧補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd4(), "05043", "（中継用）予定利率一覧補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd5(), "05044", "（中継用）予定利率一覧補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd6(), "", "（中継用）予定利率一覧補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd7(), "", "（中継用）予定利率一覧補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd8(), "", "（中継用）予定利率一覧補足メッセージコード８");

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testEditInfo_A2() {

        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000024");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN4;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN3;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN1;

        CoreConfig.instance.setProductMode(ProductMode.BATCH);

        EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
        osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "２０１９年　３月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "１年確定年金（定額年金型）", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkkaisuu(), "01", "（中継用）払込回数");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytikiktbrisyuruikbn(), "06", "（中継用）定期一括払種類区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyzennouumu(), "0", "（中継用）前納有無");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkkeiro(), "1", "（中継用）払込経路");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyphrkkkn(), "0", "（中継用）保険料払込期間");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysueokikkn(), "0", "（中継用）据置期間");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "12", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1010", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "111100", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "2001", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "22222200", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "33333333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05013", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05014", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05015", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "05016", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "05017", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd8(), "05018", "（中継用）保障内容補足メッセージコード８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd9(), "", "（中継用）保障内容補足メッセージコード９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkiktnkgk(), "123456", "（中継用）円貨払込額（一括入金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyzennoutikiktyenhrkgkkykj(), "", "（中継用）前納定期一括払円貨払込額（契約時）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigk(), "8888", "（中継用）解約時支払額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigkznnuzndk(), "0", "（中継用）解約時支払額（前納残高）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigksntshrgk(), "-33324445", "（中継用）解約時支払額（その他支払金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkgoukei(), "2000", "（中継用）円貨払込額の合計額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrritu(), "444", "（中継用）返戻率");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsyensyourai(), "2001", "（中継用）年金原資（円貨）（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgaikasyourai(), "102200", "（中継用）年金原資（契約通貨）（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkgoukeisyourai(), "2000", "（中継用）円貨払込額の合計額（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrritusyourai(), "100", "（中継用）返戻率（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd1(), "05030", "（中継用）年金原資試算補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd2(), "05031", "（中継用）年金原資試算補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd3(), "05032", "（中継用）年金原資試算補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd4(), "", "（中継用）年金原資試算補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd5(), "", "（中継用）年金原資試算補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");


        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym1(), "2019年9月", "（中継用）予定利率基準年月＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu1(), "12500", "（中継用）予定利率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt1(), "12400", "（中継用）予定利率計算基準利率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym1(), "2019年8月", "（中継用）為替レート基準年月＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate1(), "11939", "（中継用）換算為替レート＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika1(), "", "（中継用）保険料（契約通貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen1(), "", "（中継用）保険料（円貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn1(), "", "（中継用）初回保険料表示区分＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym2(), "2018年8月", "（中継用）予定利率基準年月＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu2(), "12500", "（中継用）予定利率＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt2(), "12500", "（中継用）予定利率計算基準利率＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym2(), "", "（中継用）為替レート基準年月＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate2(), "", "（中継用）換算為替レート＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika2(), "", "（中継用）保険料（契約通貨）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen2(), "", "（中継用）保険料（円貨）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn2(), "", "（中継用）初回保険料表示区分＿２");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd1(), "05040", "（中継用）予定利率一覧補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd2(), "05041", "（中継用）予定利率一覧補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd3(), "05042", "（中継用）予定利率一覧補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd4(), "05043", "（中継用）予定利率一覧補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd5(), "", "（中継用）予定利率一覧補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd6(), "", "（中継用）予定利率一覧補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd7(), "", "（中継用）予定利率一覧補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd8(), "", "（中継用）予定利率一覧補足メッセージコード８");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testEditInfo_A3() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000035");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN1;

        CoreConfig.instance.setProductMode(ProductMode.BATCH);

        EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
        osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "execDivide", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "execDivide", 0, 1), BizCurrency.valueOf(0), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "execDivide", 0, 2), BizNumber.valueOf(10.1), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "execDivide", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "２０１９年　３月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "年金総額保証付終身年金（定額年金型）", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkkaisuu(), "01", "（中継用）払込回数");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytikiktbrisyuruikbn(), "12", "（中継用）定期一括払種類区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyzennouumu(), "0", "（中継用）前納有無");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkkeiro(), "2", "（中継用）払込経路");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyphrkkkn(), "5", "（中継用）保険料払込期間");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysueokikkn(), "0", "（中継用）据置期間");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "1300", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1010", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "111100", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "8888", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "22222200", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "33333333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05013", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05014", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05015", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "05016", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "05017", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd8(), "05018", "（中継用）保障内容補足メッセージコード８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd9(), "", "（中継用）保障内容補足メッセージコード９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkiktnkgk(), "123456", "（中継用）円貨払込額（一括入金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyzennoutikiktyenhrkgkkykj(), "", "（中継用）前納定期一括払円貨払込額（契約時）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigk(), "8888", "（中継用）解約時支払額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigkznnuzndk(), "0", "（中継用）解約時支払額（前納残高）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigksntshrgk(), "-33324445", "（中継用）解約時支払額（その他支払金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkgoukei(), "2000", "（中継用）円貨払込額の合計額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrritu(), "444", "（中継用）返戻率");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsyensyourai(), "8888", "（中継用）年金原資（円貨）（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgaikasyourai(), "102300", "（中継用）年金原資（契約通貨）（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkgoukeisyourai(), "2000", "（中継用）円貨払込額の合計額（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrritusyourai(), "444", "（中継用）返戻率（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd1(), "05030", "（中継用）年金原資試算補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd2(), "05031", "（中継用）年金原資試算補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd3(), "05032", "（中継用）年金原資試算補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd4(), "", "（中継用）年金原資試算補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd5(), "", "（中継用）年金原資試算補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");


        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym1(), "2018年7月", "（中継用）予定利率基準年月＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu1(), "", "（中継用）予定利率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt1(), "12500", "（中継用）予定利率計算基準利率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym1(), "", "（中継用）為替レート基準年月＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate1(), "", "（中継用）換算為替レート＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika1(), "", "（中継用）保険料（契約通貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen1(), "", "（中継用）保険料（円貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn1(), "", "（中継用）初回保険料表示区分＿１");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd1(), "05040", "（中継用）予定利率一覧補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd2(), "05041", "（中継用）予定利率一覧補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd3(), "05042", "（中継用）予定利率一覧補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd4(), "05043", "（中継用）予定利率一覧補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd5(), "", "（中継用）予定利率一覧補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd6(), "", "（中継用）予定利率一覧補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd7(), "", "（中継用）予定利率一覧補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd8(), "", "（中継用）予定利率一覧補足メッセージコード８");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testEditInfo_A4() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000046");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN1;

        CoreConfig.instance.setProductMode(ProductMode.BATCH);

        EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
        osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "２０１９年　３月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "１年確定年金（第１回年金倍額型）", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkkaisuu(), "06", "（中継用）払込回数");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytikiktbrisyuruikbn(), "00", "（中継用）定期一括払種類区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyzennouumu(), "0", "（中継用）前納有無");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkkeiro(), "2", "（中継用）払込経路");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyphrkkkn(), "5", "（中継用）保険料払込期間");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysueokikkn(), "0", "（中継用）据置期間");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "1400", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1010", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "111100", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "8888", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "22222200", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "33333333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05013", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05014", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05015", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "05016", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "05017", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd8(), "05018", "（中継用）保障内容補足メッセージコード８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd9(), "", "（中継用）保障内容補足メッセージコード９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkiktnkgk(), "123456", "（中継用）円貨払込額（一括入金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyzennoutikiktyenhrkgkkykj(), "", "（中継用）前納定期一括払円貨払込額（契約時）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigk(), "8888", "（中継用）解約時支払額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigkznnuzndk(), "0", "（中継用）解約時支払額（前納残高）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigksntshrgk(), "-33324445", "（中継用）解約時支払額（その他支払金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkgoukei(), "2000", "（中継用）円貨払込額の合計額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrritu(), "444", "（中継用）返戻率");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsyensyourai(), "8888", "（中継用）年金原資（円貨）（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgaikasyourai(), "102300", "（中継用）年金原資（契約通貨）（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkgoukeisyourai(), "2000", "（中継用）円貨払込額の合計額（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrritusyourai(), "444", "（中継用）返戻率（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd1(), "05030", "（中継用）年金原資試算補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd2(), "05031", "（中継用）年金原資試算補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd3(), "05032", "（中継用）年金原資試算補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd4(), "", "（中継用）年金原資試算補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd5(), "", "（中継用）年金原資試算補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");


        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym1(), "2018年10月", "（中継用）予定利率基準年月＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu1(), "12500", "（中継用）予定利率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt1(), "12500", "（中継用）予定利率計算基準利率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym1(), "2018年9月", "（中継用）為替レート基準年月＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate1(), "100", "（中継用）換算為替レート＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika1(), "100100", "（中継用）保険料（契約通貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen1(), "1400", "（中継用）保険料（円貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn1(), "1", "（中継用）初回保険料表示区分＿１");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym2(), "2018年9月", "（中継用）予定利率基準年月＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu2(), "12500", "（中継用）予定利率＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt2(), "12500", "（中継用）予定利率計算基準利率＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym2(), "", "（中継用）為替レート基準年月＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate2(), "", "（中継用）換算為替レート＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika2(), "", "（中継用）保険料（契約通貨）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen2(), "", "（中継用）保険料（円貨）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn2(), "", "（中継用）初回保険料表示区分＿２");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd1(), "05040", "（中継用）予定利率一覧補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd2(), "05041", "（中継用）予定利率一覧補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd3(), "05042", "（中継用）予定利率一覧補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd4(), "05043", "（中継用）予定利率一覧補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd5(), "05044", "（中継用）予定利率一覧補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd6(), "", "（中継用）予定利率一覧補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd7(), "", "（中継用）予定利率一覧補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd8(), "", "（中継用）予定利率一覧補足メッセージコード８");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testEditInfo_A5() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000057");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN3;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN1;

        CoreConfig.instance.setProductMode(ProductMode.BATCH);

        EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
        osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "２０１９年　３月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "１年確定年金（定額年金型）", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkkaisuu(), "06", "（中継用）払込回数");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytikiktbrisyuruikbn(), "01", "（中継用）定期一括払種類区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyzennouumu(), "1", "（中継用）前納有無");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkkeiro(), "3", "（中継用）払込経路");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyphrkkkn(), "5", "（中継用）保険料払込期間");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysueokikkn(), "0", "（中継用）据置期間");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "1400", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1010", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "111100", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "3333", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "22222200", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "33333333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05013", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05014", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05015", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "05016", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "05017", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd8(), "05018", "（中継用）保障内容補足メッセージコード８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd9(), "", "（中継用）保障内容補足メッセージコード９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkiktnkgk(), "123456", "（中継用）円貨払込額（一括入金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyzennoutikiktyenhrkgkkykj(), "120500", "（中継用）前納定期一括払円貨払込額（契約時）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigk(), "8888", "（中継用）解約時支払額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigkznnuzndk(), "4444", "（中継用）解約時支払額（前納残高）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigksntshrgk(), "-33328889", "（中継用）解約時支払額（その他支払金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkgoukei(), "2000", "（中継用）円貨払込額の合計額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrritu(), "444", "（中継用）返戻率");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsyensyourai(), "3333", "（中継用）年金原資（円貨）（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgaikasyourai(), "202300", "（中継用）年金原資（契約通貨）（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkgoukeisyourai(), "2000", "（中継用）円貨払込額の合計額（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrritusyourai(), "166", "（中継用）返戻率（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd1(), "05030", "（中継用）年金原資試算補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd2(), "05031", "（中継用）年金原資試算補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd3(), "05032", "（中継用）年金原資試算補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd4(), "", "（中継用）年金原資試算補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd5(), "", "（中継用）年金原資試算補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");


        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym1(), "2018年10月", "（中継用）予定利率基準年月＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu1(), "", "（中継用）予定利率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt1(), "12500", "（中継用）予定利率計算基準利率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym1(), "", "（中継用）為替レート基準年月＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate1(), "", "（中継用）換算為替レート＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika1(), "", "（中継用）保険料（契約通貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen1(), "", "（中継用）保険料（円貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn1(), "", "（中継用）初回保険料表示区分＿１");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd1(), "05040", "（中継用）予定利率一覧補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd2(), "05041", "（中継用）予定利率一覧補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd3(), "05042", "（中継用）予定利率一覧補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd4(), "05043", "（中継用）予定利率一覧補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd5(), "", "（中継用）予定利率一覧補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd6(), "", "（中継用）予定利率一覧補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd7(), "", "（中継用）予定利率一覧補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd8(), "", "（中継用）予定利率一覧補足メッセージコード８");

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testEditInfo_A6() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000068");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN3;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN1;

        CoreConfig.instance.setProductMode(ProductMode.BATCH);

        EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
        osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "２０１９年　３月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "１年確定年金（定額年金型）", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkkaisuu(), "06", "（中継用）払込回数");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytikiktbrisyuruikbn(), "01", "（中継用）定期一括払種類区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyzennouumu(), "1", "（中継用）前納有無");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkkeiro(), "3", "（中継用）払込経路");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyphrkkkn(), "5", "（中継用）保険料払込期間");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysueokikkn(), "0", "（中継用）据置期間");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "1400", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1010", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "111100", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "3333", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "22222200", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "33333333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05013", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05014", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05015", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "05016", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "05017", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd8(), "05018", "（中継用）保障内容補足メッセージコード８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd9(), "", "（中継用）保障内容補足メッセージコード９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkiktnkgk(), "123456", "（中継用）円貨払込額（一括入金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyzennoutikiktyenhrkgkkykj(), "120500", "（中継用）前納定期一括払円貨払込額（契約時）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigk(), "8888", "（中継用）解約時支払額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigkznnuzndk(), "4444", "（中継用）解約時支払額（前納残高）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigksntshrgk(), "-33328889", "（中継用）解約時支払額（その他支払金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkgoukei(), "2000", "（中継用）円貨払込額の合計額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrritu(), "444", "（中継用）返戻率");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsyensyourai(), "3333", "（中継用）年金原資（円貨）（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgaikasyourai(), "202300", "（中継用）年金原資（契約通貨）（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkgoukeisyourai(), "2000", "（中継用）円貨払込額の合計額（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrritusyourai(), "166", "（中継用）返戻率（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd1(), "05030", "（中継用）年金原資試算補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd2(), "05031", "（中継用）年金原資試算補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd3(), "05032", "（中継用）年金原資試算補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd4(), "", "（中継用）年金原資試算補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd5(), "", "（中継用）年金原資試算補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");


        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym1(), "2018年10月", "（中継用）予定利率基準年月＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu1(), "", "（中継用）予定利率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt1(), "12500", "（中継用）予定利率計算基準利率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym1(), "", "（中継用）為替レート基準年月＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate1(), "", "（中継用）換算為替レート＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika1(), "", "（中継用）保険料（契約通貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen1(), "", "（中継用）保険料（円貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn1(), "", "（中継用）初回保険料表示区分＿１");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd1(), "05040", "（中継用）予定利率一覧補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd2(), "05041", "（中継用）予定利率一覧補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd3(), "05042", "（中継用）予定利率一覧補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd4(), "05043", "（中継用）予定利率一覧補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd5(), "", "（中継用）予定利率一覧補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd6(), "", "（中継用）予定利率一覧補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd7(), "", "（中継用）予定利率一覧補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd8(), "", "（中継用）予定利率一覧補足メッセージコード８");

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testEditInfo_A7() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000079");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN3;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN1;

        CoreConfig.instance.setProductMode(ProductMode.BATCH);

        EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
        osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "２０１９年　３月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "１年確定年金（定額年金型）", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkkaisuu(), "12", "（中継用）払込回数");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytikiktbrisyuruikbn(), "01", "（中継用）定期一括払種類区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyzennouumu(), "1", "（中継用）前納有無");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkkeiro(), "4", "（中継用）払込経路");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyphrkkkn(), "5", "（中継用）保険料払込期間");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysueokikkn(), "0", "（中継用）据置期間");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "1400", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1010", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "111100", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "3333", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "22222200", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "33333333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05013", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05014", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05015", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "05016", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "05017", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd8(), "05018", "（中継用）保障内容補足メッセージコード８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd9(), "", "（中継用）保障内容補足メッセージコード９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkiktnkgk(), "123456", "（中継用）円貨払込額（一括入金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyzennoutikiktyenhrkgkkykj(), "120500", "（中継用）前納定期一括払円貨払込額（契約時）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigk(), "8888", "（中継用）解約時支払額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigkznnuzndk(), "4444", "（中継用）解約時支払額（前納残高）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigksntshrgk(), "-33328889", "（中継用）解約時支払額（その他支払金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkgoukei(), "2000", "（中継用）円貨払込額の合計額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrritu(), "444", "（中継用）返戻率");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsyensyourai(), "3333", "（中継用）年金原資（円貨）（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgaikasyourai(), "202300", "（中継用）年金原資（契約通貨）（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkgoukeisyourai(), "2000", "（中継用）円貨払込額の合計額（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrritusyourai(), "166", "（中継用）返戻率（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd1(), "05030", "（中継用）年金原資試算補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd2(), "05031", "（中継用）年金原資試算補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd3(), "05032", "（中継用）年金原資試算補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd4(), "", "（中継用）年金原資試算補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd5(), "", "（中継用）年金原資試算補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");


        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym1(), "2018年10月", "（中継用）予定利率基準年月＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu1(), "", "（中継用）予定利率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt1(), "12500", "（中継用）予定利率計算基準利率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym1(), "", "（中継用）為替レート基準年月＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate1(), "", "（中継用）換算為替レート＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika1(), "", "（中継用）保険料（契約通貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen1(), "", "（中継用）保険料（円貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn1(), "", "（中継用）初回保険料表示区分＿１");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd1(), "05040", "（中継用）予定利率一覧補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd2(), "05041", "（中継用）予定利率一覧補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd3(), "05042", "（中継用）予定利率一覧補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd4(), "05043", "（中継用）予定利率一覧補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd5(), "", "（中継用）予定利率一覧補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd6(), "", "（中継用）予定利率一覧補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd7(), "", "（中継用）予定利率一覧補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd8(), "", "（中継用）予定利率一覧補足メッセージコード８");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testEditInfo_A8() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000080");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN3;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN1;

        CoreConfig.instance.setProductMode(ProductMode.BATCH);

        EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
        osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "２０１９年　３月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "１年確定年金（定額年金型）", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkkaisuu(), "12", "（中継用）払込回数");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytikiktbrisyuruikbn(), "01", "（中継用）定期一括払種類区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyzennouumu(), "1", "（中継用）前納有無");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkkeiro(), "4", "（中継用）払込経路");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyphrkkkn(), "5", "（中継用）保険料払込期間");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysueokikkn(), "0", "（中継用）据置期間");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "1400", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1010", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "111100", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "3333", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "22222200", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "33333333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05013", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05014", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05015", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "05016", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "05017", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd8(), "05018", "（中継用）保障内容補足メッセージコード８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd9(), "", "（中継用）保障内容補足メッセージコード９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkiktnkgk(), "123456", "（中継用）円貨払込額（一括入金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyzennoutikiktyenhrkgkkykj(), "120500", "（中継用）前納定期一括払円貨払込額（契約時）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigk(), "8888", "（中継用）解約時支払額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigkznnuzndk(), "4444", "（中継用）解約時支払額（前納残高）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigksntshrgk(), "-33328889", "（中継用）解約時支払額（その他支払金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkgoukei(), "2000", "（中継用）円貨払込額の合計額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrritu(), "444", "（中継用）返戻率");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsyensyourai(), "3333", "（中継用）年金原資（円貨）（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgaikasyourai(), "202300", "（中継用）年金原資（契約通貨）（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkgoukeisyourai(), "2000", "（中継用）円貨払込額の合計額（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrritusyourai(), "166", "（中継用）返戻率（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd1(), "05030", "（中継用）年金原資試算補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd2(), "05031", "（中継用）年金原資試算補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd3(), "05032", "（中継用）年金原資試算補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd4(), "", "（中継用）年金原資試算補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd5(), "", "（中継用）年金原資試算補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");


        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym1(), "2018年10月", "（中継用）予定利率基準年月＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu1(), "", "（中継用）予定利率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt1(), "12500", "（中継用）予定利率計算基準利率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym1(), "", "（中継用）為替レート基準年月＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate1(), "", "（中継用）換算為替レート＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika1(), "", "（中継用）保険料（契約通貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen1(), "", "（中継用）保険料（円貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn1(), "", "（中継用）初回保険料表示区分＿１");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd1(), "05040", "（中継用）予定利率一覧補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd2(), "05041", "（中継用）予定利率一覧補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd3(), "05042", "（中継用）予定利率一覧補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd4(), "05043", "（中継用）予定利率一覧補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd5(), "", "（中継用）予定利率一覧補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd6(), "", "（中継用）予定利率一覧補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd7(), "", "（中継用）予定利率一覧補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd8(), "", "（中継用）予定利率一覧補足メッセージコード８");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testEditInfo_A9() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000091");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN3;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN1;

        CoreConfig.instance.setProductMode(ProductMode.BATCH);

        EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
        osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasetuutisakuseiymwa(), "２０１９年　３月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkshrstartymdstr(), "２０２５年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynksyuruinm(), "１年確定年金（定額年金型）", "（中継用）年金種類名称");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkkaisuu(), "06", "（中継用）払込回数");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtytikiktbrisyuruikbn(), "01", "（中継用）定期一括払種類区分");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyzennouumu(), "1", "（中継用）前納有無");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrkkeiro(), "6", "（中継用）払込経路");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyphrkkkn(), "6", "（中継用）保険料払込期間");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysueokikkn(), "0", "（中継用）据置期間");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgk(), "1400", "（中継用）円貨払込額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdkwsrate(), "1010", "（中継用）作成基準日時点為替レート");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkkyktuuka(), "111100", "（中継用）死亡保険金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtysbhknkngkyen(), "3333", "（中継用）死亡保険金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakkyktuuka(), "22222200", "（中継用）解約返戻金額（契約通貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakuhrkngakyen(), "33333333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd1(), "05013", "（中継用）保障内容補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd2(), "", "（中継用）保障内容補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd3(), "", "（中継用）保障内容補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd4(), "05014", "（中継用）保障内容補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd5(), "05015", "（中継用）保障内容補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd6(), "05016", "（中継用）保障内容補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "05017", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd8(), "05018", "（中継用）保障内容補足メッセージコード８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd9(), "", "（中継用）保障内容補足メッセージコード９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkiktnkgk(), "123456", "（中継用）円貨払込額（一括入金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyzennoutikiktyenhrkgkkykj(), "120500", "（中継用）前納定期一括払円貨払込額（契約時）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigk(), "8888", "（中継用）解約時支払額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigkznnuzndk(), "4444", "（中継用）解約時支払額（前納残高）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaiyakusiharaigksntshrgk(), "-33328889", "（中継用）解約時支払額（その他支払金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkgoukei(), "2000", "（中継用）円貨払込額の合計額");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrritu(), "444", "（中継用）返戻率");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsyensyourai(), "3333", "（中継用）年金原資（円貨）（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnsgaikasyourai(), "202300", "（中継用）年金原資（契約通貨）（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyenhrkgkgoukeisyourai(), "2000", "（中継用）円貨払込額の合計額（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhrritusyourai(), "166", "（中継用）返戻率（将来予想金額）");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd1(), "05030", "（中継用）年金原資試算補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd2(), "05031", "（中継用）年金原資試算補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd3(), "05032", "（中継用）年金原資試算補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd4(), "", "（中継用）年金原資試算補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtynkgnshskmsgcd5(), "", "（中継用）年金原資試算補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");


        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym1(), "2019年3月", "（中継用）予定利率基準年月＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu1(), "", "（中継用）予定利率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt1(), "13200", "（中継用）予定利率計算基準利率＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym1(), "2019年2月", "（中継用）為替レート基準年月＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate1(), "100", "（中継用）換算為替レート＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika1(), "200100", "（中継用）保険料（契約通貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen1(), "1400", "（中継用）保険料（円貨）＿１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn1(), "", "（中継用）初回保険料表示区分＿１");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym2(), "2019年2月", "（中継用）予定利率基準年月＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu2(), "", "（中継用）予定利率＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt2(), "13100", "（中継用）予定利率計算基準利率＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym2(), "2019年1月", "（中継用）為替レート基準年月＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate2(), "100", "（中継用）換算為替レート＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika2(), "200100", "（中継用）保険料（契約通貨）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen2(), "1400", "（中継用）保険料（円貨）＿２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn2(), "", "（中継用）初回保険料表示区分＿２");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym3(), "2019年1月", "（中継用）予定利率基準年月＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu3(), "", "（中継用）予定利率＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt3(), "13000", "（中継用）予定利率計算基準利率＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym3(), "2018年12月", "（中継用）為替レート基準年月＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate3(), "100", "（中継用）換算為替レート＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika3(), "200100", "（中継用）保険料（契約通貨）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen3(), "1400", "（中継用）保険料（円貨）＿３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn3(), "", "（中継用）初回保険料表示区分＿３");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym4(), "2018年12月", "（中継用）予定利率基準年月＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu4(), "", "（中継用）予定利率＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt4(), "12900", "（中継用）予定利率計算基準利率＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym4(), "2018年11月", "（中継用）為替レート基準年月＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate4(), "100", "（中継用）換算為替レート＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika4(), "200100", "（中継用）保険料（契約通貨）＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen4(), "1400", "（中継用）保険料（円貨）＿４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn4(), "", "（中継用）初回保険料表示区分＿４");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym5(), "2018年11月", "（中継用）予定利率基準年月＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu5(), "", "（中継用）予定利率＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt5(), "12800", "（中継用）予定利率計算基準利率＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym5(), "2018年10月", "（中継用）為替レート基準年月＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate5(), "100", "（中継用）換算為替レート＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika5(), "200100", "（中継用）保険料（契約通貨）＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen5(), "1400", "（中継用）保険料（円貨）＿５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn5(), "", "（中継用）初回保険料表示区分＿５");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym6(), "2018年10月", "（中継用）予定利率基準年月＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu6(), "", "（中継用）予定利率＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt6(), "12700", "（中継用）予定利率計算基準利率＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym6(), "2018年9月", "（中継用）為替レート基準年月＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate6(), "100", "（中継用）換算為替レート＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika6(), "200100", "（中継用）保険料（契約通貨）＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen6(), "1400", "（中継用）保険料（円貨）＿６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn6(), "", "（中継用）初回保険料表示区分＿６");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym7(), "2018年9月", "（中継用）予定利率基準年月＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu7(), "", "（中継用）予定利率＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt7(), "12600", "（中継用）予定利率計算基準利率＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym7(), "2018年8月", "（中継用）為替レート基準年月＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate7(), "100", "（中継用）換算為替レート＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika7(), "200100", "（中継用）保険料（契約通貨）＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen7(), "1400", "（中継用）保険料（円貨）＿７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn7(), "", "（中継用）初回保険料表示区分＿７");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym8(), "2018年8月", "（中継用）予定利率基準年月＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu8(), "", "（中継用）予定利率＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt8(), "12500", "（中継用）予定利率計算基準利率＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym8(), "2018年7月", "（中継用）為替レート基準年月＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate8(), "100", "（中継用）換算為替レート＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika8(), "200100", "（中継用）保険料（契約通貨）＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen8(), "1400", "（中継用）保険料（円貨）＿８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn8(), "", "（中継用）初回保険料表示区分＿８");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym9(), "2018年7月", "（中継用）予定利率基準年月＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu9(), "", "（中継用）予定利率＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt9(), "12400", "（中継用）予定利率計算基準利率＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym9(), "2018年6月", "（中継用）為替レート基準年月＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate9(), "100", "（中継用）換算為替レート＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika9(), "200100", "（中継用）保険料（契約通貨）＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen9(), "1400", "（中継用）保険料（円貨）＿９");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn9(), "", "（中継用）初回保険料表示区分＿９");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym10(), "2018年6月", "（中継用）予定利率基準年月＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu10(), "", "（中継用）予定利率＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt10(), "12300", "（中継用）予定利率計算基準利率＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym10(), "2018年5月", "（中継用）為替レート基準年月＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate10(), "100", "（中継用）換算為替レート＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika10(), "200100", "（中継用）保険料（契約通貨）＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen10(), "1400", "（中継用）保険料（円貨）＿１０");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn10(), "", "（中継用）初回保険料表示区分＿１０");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym11(), "2018年5月", "（中継用）予定利率基準年月＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu11(), "", "（中継用）予定利率＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt11(), "12200", "（中継用）予定利率計算基準利率＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym11(), "2018年4月", "（中継用）為替レート基準年月＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate11(), "100", "（中継用）換算為替レート＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika11(), "200100", "（中継用）保険料（契約通貨）＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen11(), "1400", "（中継用）保険料（円貨）＿１１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn11(), "", "（中継用）初回保険料表示区分＿１１");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritukijyunym12(), "2018年4月", "（中継用）予定利率基準年月＿１２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyyoteiriritu12(), "", "（中継用）予定利率＿１２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtcalckijyunrrt12(), "12100", "（中継用）予定利率計算基準利率＿１２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykwsratekijyunym12(), "2018年3月", "（中継用）為替レート基準年月＿１２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtykaknsnkwsrate12(), "100", "（中継用）換算為替レート＿１２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypgaika12(), "200100", "（中継用）保険料（契約通貨）＿１２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtypyen12(), "1400", "（中継用）保険料（円貨）＿１２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyfstphyoujikbn12(), "1", "（中継用）初回保険料表示区分＿１２");

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd1(), "05040", "（中継用）予定利率一覧補足メッセージコード１");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd2(), "05041", "（中継用）予定利率一覧補足メッセージコード２");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd3(), "05042", "（中継用）予定利率一覧補足メッセージコード３");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd4(), "05043", "（中継用）予定利率一覧補足メッセージコード４");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd5(), "05044", "（中継用）予定利率一覧補足メッセージコード５");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd6(), "", "（中継用）予定利率一覧補足メッセージコード６");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd7(), "", "（中継用）予定利率一覧補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyytirrtitrnhskmsgcd8(), "", "（中継用）予定利率一覧補足メッセージコード８");
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testEditInfo_A10() {
        CoreConfig.instance.setProductMode(ProductMode.WEB);
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000105");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;

        String className = "";
        try{
            EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
            osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);
        }catch(CommonBizAppException e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。金額チェックエラーです。システム管理者にお問い合わせください。", "メッセージ内容");
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testEditInfo_A11() {
        CoreConfig.instance.setProductMode(ProductMode.WEB);
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000105");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;

        String className = "";
        try{
            EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
            osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);
        }catch(CommonBizAppException e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。金額チェックエラーです。システム管理者にお問い合わせください。", "メッセージ内容");

    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testEditInfo_A12() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000013");
        BizDate pSyoriYmd = BizDate.valueOf(20190601);
        BizDate pKykoutoubi = BizDate.valueOf(20190601);
        String pSyouhnHanmeiKbn = "07";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN3;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN1;

        EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
        osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);


        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "05017", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd8(), "05018", "（中継用）保障内容補足メッセージコード８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd9(), "", "（中継用）保障内容補足メッセージコード９");

    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testEditInfo_A13() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806000105");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;

        CoreConfig.instance.setProductMode(ProductMode.BATCH);

        EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
        osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);

        C_ErrorKbn errkbn = osirase.getCommonErrorKbn();

        exClassificationEquals(errkbn, C_ErrorKbn.ERROR, "エラー区分（共有）");

    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testEditInfo_A14() {
        CoreConfig.instance.setProductMode(ProductMode.WEB);
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806111144");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN3;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN2;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN1;

        String message = "";
        try{
            EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
            osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);
        }catch(CommonBizAppException e) {
            message = e.getMessage();
        }
        exStringEquals(message, "システム整合性エラーです。金額チェックエラーです。システム管理者にお問い合わせください。", "メッセージ内容");
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testEditInfo_A15() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806111144");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN3;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN2;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN1;

        CoreConfig.instance.setProductMode(ProductMode.BATCH);

        EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
        osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);

        C_ErrorKbn errkbn = osirase.getCommonErrorKbn();

        exClassificationEquals(errkbn, C_ErrorKbn.ERROR, "エラー区分（共有）");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(160)
    @Transactional
    public void testEditInfo_A16() {
        CoreConfig.instance.setProductMode(ProductMode.WEB);
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806111144");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN3;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN3;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN1;

        try{
            EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
            osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);
        }catch(CommonBizAppException e) {
            exStringEquals(e.getMessage(), "前納Ｐが充当されていないため、処理できません。前納Ｐ充当後に処理してください。", "メッセージ内容");
            throw e;
        }
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testEditInfo_A17() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806111144");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN3;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN3;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN1;

        CoreConfig.instance.setProductMode(ProductMode.BATCH);

        EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
        osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);

        C_ErrorKbn errkbn = osirase.getCommonErrorKbn();

        exClassificationEquals(errkbn, C_ErrorKbn.ERROR, "エラー区分（共有）");
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testEditInfo_A18() {
        CoreConfig.instance.setProductMode(ProductMode.WEB);
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806111144");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN3;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN4;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN1;

        String message = "";
        try{
            EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
            osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);
        }catch(CommonBizAppException e) {
            message = e.getMessage();
        }
        exStringEquals(message, "システム整合性エラーです。金額チェックエラーです。システム管理者にお問い合わせください。", "メッセージ内容");
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testEditInfo_A19() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806111144");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN3;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN4;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN1;

        CoreConfig.instance.setProductMode(ProductMode.BATCH);

        EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
        osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);

        C_ErrorKbn errkbn = osirase.getCommonErrorKbn();

        exClassificationEquals(errkbn, C_ErrorKbn.ERROR, "エラー区分（共有）");
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testEditInfo_A20() {
        CoreConfig.instance.setProductMode(ProductMode.WEB);
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806111144");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN3;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN2;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN1;

        String message = "";
        try{
            EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
            osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);
        }catch(CommonBizAppException e) {
            message = e.getMessage();
        }
        exStringEquals(message, "システム整合性エラーです。金額チェックエラーです。システム管理者にお問い合わせください。", "メッセージ内容");
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testEditInfo_A21() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806111144");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN3;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN2;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN1;

        CoreConfig.instance.setProductMode(ProductMode.BATCH);

        EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
        osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);

        C_ErrorKbn errkbn = osirase.getCommonErrorKbn();

        exClassificationEquals(errkbn, C_ErrorKbn.ERROR, "エラー区分（共有）");
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testEditInfo_A22() {
        CoreConfig.instance.setProductMode(ProductMode.WEB);
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806111144");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN3;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN2;

        String message = "";
        try{
            EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
            osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);
        }catch(CommonBizAppException e) {
            message = e.getMessage();
        }
        exStringEquals(message, "システム整合性エラーです。金額チェックエラーです。システム管理者にお問い合わせください。", "メッセージ内容");
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testEditInfo_A23() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806111144");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN3;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN2;

        CoreConfig.instance.setProductMode(ProductMode.BATCH);

        EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
        osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);

        C_ErrorKbn errkbn = osirase.getCommonErrorKbn();

        exClassificationEquals(errkbn, C_ErrorKbn.ERROR, "エラー区分（共有）");
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testEditInfo_A24() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806111111");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN3;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN3;

        CoreConfig.instance.setProductMode(ProductMode.BATCH);

        EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
        osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "05017", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd8(), "05018", "（中継用）保障内容補足メッセージコード８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd9(), "05019", "（中継用）保障内容補足メッセージコード９");

    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testEditInfo_A25() {
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806111122");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN3;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN2;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN3;

        CoreConfig.instance.setProductMode(ProductMode.BATCH);

        EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
        osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 1);

        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd7(), "05018", "（中継用）保障内容補足メッセージコード７");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd8(), "05019", "（中継用）保障内容補足メッセージコード８");
        exStringEquals(pGaikaKokyakuTuutiTyn.getZtyhosyouhskmsgcd9(), "", "（中継用）保障内容補足メッセージコード９");
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testEditInfo_A26() {

        CoreConfig.instance.setProductMode(ProductMode.WEB);
        IT_KykKihon pKykKihon;
        pKykKihon = hozenDomManager.getKykKihon("17806111144");
        BizDate pSyoriYmd = BizDate.valueOf(20190301);
        BizDate pKykoutoubi = BizDate.valueOf(20190301);
        String pSyouhnHanmeiKbn = "1";
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN3;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN3;
        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForHozen.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForHozen.TESTPATTERN1;

        EditKykNaiyouOsirase3 osirase = SWAKInjector.getInstance(EditKykNaiyouOsirase3.class);
        pGaikaKokyakuTuutiTyn = osirase.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn, 2);

        exClassificationEquals(osirase.getBizLogicErrorKbn(), C_ErrorKbn.ERROR, "エラー区分（業務）");
        exStringEquals(osirase.getBizLogicErrorMsg(), MessageUtil.getMessage(MessageId.EIF1125), "エラーメッセージ（業務）");
        exBooleanEquals(pGaikaKokyakuTuutiTyn != null, true, "外貨建顧客通知Ｆテーブル（中）");
    }

}
