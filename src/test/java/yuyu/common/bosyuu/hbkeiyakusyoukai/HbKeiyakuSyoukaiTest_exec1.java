package yuyu.common.bosyuu.hbkeiyakusyoukai;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWMockForHozen;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkMockForHozen;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_TanmatuSiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 生保Ｗｅｂ契約内容照会 {@link HbKeiyakuSyoukai#exec(String, BizDate, C_TanmatuSiyouKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HbKeiyakuSyoukaiTest_exec1 extends AbstractTest {

    @Inject
    private HbKeiyakuSyoukai hbKeiyakuSyoukai;

    private final static String fileName = "UT_SP_単体テスト仕様書_生保Ｗｅｂ契約内容照会";

    private final static String sheetName = "INデータ_20201228";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CalcHkShrKngk.class).to(CalcHkShrKngkMockForHozen.class);
                bind(KeisanW.class).to(KeisanWMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        CalcHkShrKngkMockForHozen.caller = HbKeiyakuSyoukaiTest_exec1.class;
        KeisanWMockForHozen.caller = HbKeiyakuSyoukaiTest_exec1.class;
    }

    @AfterClass
    public static void testClear() {
        CalcHkShrKngkMockForHozen.caller = null;
        CalcHkShrKngkMockForHozen.SYORIPTN = null;
        KeisanWMockForHozen.caller = null;
        KeisanWMockForHozen.SYORIPTN = null;

        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HbKeiyakuSyoukaiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_B1() {

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;

        changeSystemDate(BizDate.valueOf(20200212));
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000046", BizDate.valueOf("20200706"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, "080780");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 5, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "重度介護前払特約", "特約名称１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "保険料指定外通貨払込特約", "特約名称２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "目標到達時円建終身保険変更特約　１４０％", "特約名称３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "保険契約者代理特約", "特約名称４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "被保険者代理特約", "特約名称５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(),24, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　相続人　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "契約者代理人　　　　顧通契代名１０１　テスト１２３　様　　　　　生年月日　昭和５０年　３月　３日", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "被保険者代理人　　　コツウイチカゾクイチノイチ　テスト　様　　　生年月日　平成１０年　１月　１日", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "登録家族（１人目）　コツウイチカゾクイチノイチ　テスト　様　　　生年月日　平成１０年　１月　１日", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "登録家族（２人目）　コツニカゾクイチノイチ　テストイチ　様　　　生年月日　昭和１１年　１月　１日", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "払込保険料の円換算額　　　　８，８５３，３５５円", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "　保険料領収日時点の円換算為替レート　１米ドル＝１２１．５３円（平成２９年　７月　５日）", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "死亡時", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "　第１保険期間（照会日時点）　　　　　　　　　　　０．００米ドル", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "　　　　　　　　　　　　　　　　　　　　　　　　　（０円）", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "　第２保険期間（契約日から１０年経過時点）※", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "　※第２保険期間中は、基本保険金額と解約返戻金額のうちいずれか大きい金額でお支払いします。", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "　第３保険期間（契約日から１５年経過時点）　　　　０．００米ドル", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "　　　　　　　　　　　　　　　　　　　　　　　　　（０円）", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "解約返戻金額（照会日時点）　７６，８７７．６３米ドル　　（９，５３９，７４６円）", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "積立金額（照会日時点）　７５，６０２．４７米ドル　　（９，３８１，５１１円）", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "保険法対応契約", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "重度介護前払特約あり", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "保険料指定外通貨払込特約あり　　加入時保険料入金額　　１００，０００．００豪ドル", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "　保険料領収日時点の払込特約レート　１米ドル＝１．３７２７豪ドル（平成２９年　７月　５日）", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "保険契約者代理特約あり", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "被保険者代理特約あり", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "目標到達時円建終身保険変更特約あり　　　　　（目標額割合　１４０％）", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");

        exStringEquals((String) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 0), "17806000046", "証券番号");
        exDateEquals((BizDate) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 1), BizDate.valueOf("20200212"), "計算基準日");
        exClassificationEquals((C_SiinKbn) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 2), C_SiinKbn.SP, "死因区分");
        exClassificationEquals((C_HokenkinsyuruiKbn) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 3), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals((C_Sdpd) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 4), C_Sdpd.PD, "Ｓ建Ｐ建区分");
        exClassificationEquals((C_Hrkkeiro) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 5), C_Hrkkeiro.BLNK, "払込経路");

        exStringEquals((String) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 0),"ﾕｵ","商品コード");
        exNumericEquals((Integer) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 1),1,"商品世代番号");
        exStringEquals((String) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 2),"J","料率世代番号");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec",0, 3),BizNumber.valueOf(0.0375),"予定利率");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 4),C_Hrkkaisuu.ITIJI,"払込回数");
        exClassificationEquals((C_HknkknsmnKbn) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 5),C_HknkknsmnKbn.SAIMANKI,"保険期間歳満期区分");
        exNumericEquals((Integer) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 6),99,"保険期間");
        exNumericEquals((Integer) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 7),0,"払込期間");
        exNumericEquals((Integer) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 8),47,"被保険者年齢");
        exClassificationEquals((C_Hhknsei) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 9),C_Hhknsei.MALE,"被保険者性別");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 10),BizCurrency.valueOf(187134.85, BizCurrencyTypes.DOLLAR),"基本S");
        exDateEquals((BizDate) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 11),BizDate.valueOf("20170705"),"契約日");
        exDateEquals((BizDate) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 12),BizDate.valueOf("20320705"),"計算基準日");
        exStringEquals((String) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 13),"17806000046","証券番号");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 14),C_Tuukasyu.USD,"通貨種類");
        exNumericEquals((Integer) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 15),10,"第１保険期間");
        exClassificationEquals((C_SiinKbn) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 16),C_SiinKbn.SP,"死因区分");
        exClassificationEquals((C_HokenkinsyuruiKbn) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 17),C_HokenkinsyuruiKbn.SBHOKENKIN,"保険金種類区分");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 18),BizCurrency.valueOf(72849.13,BizCurrencyTypes.DOLLAR),"保険料");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 19),BizNumber.valueOf(0),"解約時市場価格調整用利率");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 20),BizNumber.valueOf(0.04),"契約時市場価格調整用利率");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 21),null,"積立金対象年月");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 22),BizCurrency.valueOf(0),"定率積立金額");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 23),BizCurrency.valueOf(0),"指数連動積立金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 24),BizNumber.valueOf(0),"積立利率");
        exClassificationEquals((C_HrkkknsmnKbn) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 25),null,"払込期間歳満期区分");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 26),null,"次回Ｐ充当年月");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 27),null,"保険料積立金額");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 28),null,"既払込保険料相当額");
        exDateEquals((BizDate) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 29),null,"初回保険料領収日");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 30),null,"予定利率変動時保証利率");
        exClassificationEquals((C_Kykjyoutai) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 31),C_Kykjyoutai.ITIJIBARAI,"契約状態");
        exDateEquals((BizDate) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 32),null,"円建変更日");
        exClassificationEquals((C_Sdpd) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 33), C_Sdpd.PD,"Ｓ建Ｐ建区分");
        exClassificationEquals((C_Hrkkeiro) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 34), C_Hrkkeiro.BLNK,"払込経路");
    }

    @Test
    @TestOrder(20)
    public void testExec_B2() {
        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;

        changeSystemDate(BizDate.valueOf(20200212));
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000149", BizDate.valueOf("20200706"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, "080780");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 4, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "保険料円貨払込特約（一時払い）", "特約名称１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "目標到達時円建終身保険変更特約　１６０％", "特約名称２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "保険契約者代理特約", "特約名称３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "被保険者代理特約", "特約名称４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(),21, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　複数", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "契約者代理人　　　　顧通家族名１０３　テスト１２３　様　　　　　生年月日　平成１０年　１月　１日", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "被保険者代理人　　　シ指名　三七あ　様　　　　　　　　　　　", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "登録家族（１人目）　顧通家族名１０３　テスト１２３　様　　　　　生年月日　平成１０年　１月　１日", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "登録家族（２人目）　登録されておりません", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "死亡時", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "　第１保険期間（照会日時点）　　　　　　　　　　　０．００米ドル", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "　　　　　　　　　　　　　　　　　　　　　　　　　（０円）", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "　第２保険期間（契約日から１０年経過時点）※", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "　※第２保険期間中は、基本保険金額と解約返戻金額のうちいずれか大きい金額でお支払いします。", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "　第３保険期間（契約日から１５年経過時点）　　　　０．００米ドル", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "　　　　　　　　　　　　　　　　　　　　　　　　　（０円）", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "解約返戻金額（照会日時点）　９６，３８６．２６米ドル　　（１１，９６０，５７２円）", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "積立金額（照会日時点）　９４，７８７．５２米ドル　　（１１，７６２，１８４円）", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "保険法対応契約", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "保険料円貨払込特約（一時払い）あり　　　　　加入時保険料入金額　　　１１，１００，０００円", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "　保険料領収日時点の払込特約レート　１米ドル＝１２１．５３円（平成２９年　７月　５日）", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "保険契約者代理特約あり", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "被保険者代理特約あり", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "目標到達時円建終身保険変更特約あり　　　　　（目標額割合　１６０％）", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
    }

    @Test
    @TestOrder(30)
    public void testExec_B3() {
        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;

        changeSystemDate(BizDate.valueOf(20201022));
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99806040217", BizDate.valueOf("20220912"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, "080780");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 5, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "初期死亡時円換算支払額最低保証特約", "特約名称１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "保険料指定外通貨払込特約", "特約名称２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "目標到達時円建終身保険変更特約　指定なし", "特約名称３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "保険契約者代理特約", "特約名称４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "被保険者代理特約", "特約名称５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(),24, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　相続人　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "契約者代理人　　　　顧通家族名４０２　テスト１２３　様　　　　　生年月日　平成１０年　１月　１日", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "被保険者代理人　　　顧通被代名４０２　テスト１２３　様　　　　　生年月日　昭和５０年　２月　２日", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "登録家族（１人目）　顧通家族名４０２　テスト１２３　様　　　　　生年月日　平成１０年　１月　１日", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "登録家族（２人目）　登録されておりません", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "契約加入時しおり約款検索コード　０１－２００４－２４６３", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "約款受領方法　Ｗｅｂでの受取り（インターネット環境で確認）", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "払込保険料の円換算額　　　　８９，７４１，９０９円", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "　保険料領収日時点の円換算為替レート　１米ドル＝１２３．０９円（令和　２年　９月１０日）", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "予定利率　２．７５％", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "死亡時", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "　第２保険期間（照会日時点）※　　　　　　　　　　０．００米ドル", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "　　　　　　　　　　　　　　　　　　　　　　　　　（８９，７７１，０７２円）", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "　※第２保険期間中は、基本保険金額と解約返戻金額のうちいずれか大きい金額でお支払いします。", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "解約返戻金額（照会日時点）　６４０，７４８．６４米ドル　　（７８，５７５，００６円）", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "積立金額（照会日時点）　７３０，０６９．０８米ドル　　（８９，５２８，３７２円）", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "保険法対応契約", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "保険料指定外通貨払込特約あり　　加入時保険料入金額　　１，０００，０００．００豪ドル", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "　保険料領収日時点の払込特約レート　１米ドル＝１．３７１７豪ドル（令和　２年　９月１０日）", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "初期死亡時円換算支払額最低保証特約あり", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "保険契約者代理特約あり", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "被保険者代理特約あり", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "目標到達時円建終身保険変更特約あり　　　　　（目標額割合　指定なし）", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
    }

    @Test
    @TestOrder(40)
    public void testExec_B4() {

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf(20200217));
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99806040103", BizDate.valueOf("20210901"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, "080780");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "６か月一括払　クレジット払扱　一括入金中", "払込方法");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "１０歳まで", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 3, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "保険料円貨払込特約（円貨払込額指定型）", "特約名称１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "保険契約者代理特約", "特約名称２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "被保険者代理特約", "特約名称３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(),18, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　複数", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "年金受取人　　　　　被保険者　様", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "契約者代理人　　　　顧通契代名３０４　テスト１２３　様　　　　　生年月日　昭和５０年　２月　２日", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "被保険者代理人　　　顧通１家族名３０４　テスト１２　様　　　　　生年月日　平成１５年　１月　１日", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "登録家族（１人目）　顧通１家族名３０４　テスト１２　様　　　　　生年月日　平成１５年　１月　１日", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "登録家族（２人目）　顧通１家族名３０４　テスト１２　様　　　　　生年月日　昭和１５年　２月　２日", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "契約加入時しおり約款検索コード　０１－２００４－２４６８", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "約款受領方法　Ｗｅｂでの受取り（インターネット環境で確認）", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "予定利率　２．９３％", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "死亡時（照会日時点）　　　　０．００豪ドル　　（０円）", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "（保険料の払込回数に応じて計算しております。）", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "解約返戻金額（照会日時点）　１，０００．００豪ドル　　（１，０００円）", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "年金開始日　　　　　　　　令和１２年　９月　１日", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "保険法対応契約", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "保険料円貨払込特約（円貨払込額指定型）あり", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "保険契約者代理特約あり", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "被保険者代理特約あり", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
    }

    @Test
    @TestOrder(50)
    public void testExec_B5() {

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20200210));
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99806040206", BizDate.valueOf("20210910"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, "080780");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 4, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "重度介護前払特約", "特約名称１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "初期死亡時円換算支払額最低保証特約", "特約名称２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "保険契約者代理特約", "特約名称３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "被保険者代理特約", "特約名称４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(),22, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　契約者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "契約者代理人　　　　顧通契代名４０４　テスト１２３　様　　　　　生年月日　昭和５０年　４月　４日", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "被保険者代理人　　　顧通契名４０１　テスト１２３４　様　　　　　生年月日　昭和５０年　１月　１日", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "契約加入時しおり約款検索コード　０１－２００４－２７６１", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "約款受領方法　Ｗｅｂでの受取り（インターネット環境で確認）", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "払込保険料の円換算額　　　　１２３，０９０，０００円", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "　保険料領収日時点の円換算為替レート　１米ドル＝１２３．０９円（令和　２年　９月１０日）", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "予定利率　２．７５％", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "死亡時", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "　第１保険期間（照会日時点）　　　　　　　　　　　０．００米ドル", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "　　　　　　　　　　　　　　　　　　　　　　　　　（１２３，１３０，０００円）", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "　第２保険期間（契約日から２年経過以後）※　　　　２，２４４，１００．００米ドル", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "　　　　　　　　　　　　　　　　　　　　　　　　　（２７８，４２５，４８７円）", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "　※第２保険期間中は、基本保険金額と解約返戻金額のうちいずれか大きい金額でお支払いします。", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "解約返戻金額（照会日時点）　１，０００．００米ドル　　（１，０００円）", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "積立金額（照会日時点）　１，０００．００米ドル　　（１，０００円）", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "保険法対応契約", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "重度介護前払特約あり", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "初期死亡時円換算支払額最低保証特約あり", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "保険契約者代理特約あり", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "被保険者代理特約あり", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
    }

    @Test
    @TestOrder(60)
    public void testExec_B6() {

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20200220));
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99806012841", BizDate.valueOf("20220804"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, "080780");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 2, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "保険料円貨払込特約（一時払い）", "特約名称１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "被保険者代理特約", "特約名称２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "", "特約名称３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(),10, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "令和　３年　８月　４日　目標到達（目標値：１６０％）により円建終身保険に変更済", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "　　　　　　　　　　　　到達金額　　　　　２５，３９０，３３５円", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "　　　　　　　　　　　　円建変更時返戻金　２，５２６，３３９円　（未請求）", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "死亡時支払金受取人　シ受名　三七あ　様", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "被保険者代理人　　　シ指名　三七あ　様　　　　　　　　　　　", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "死亡時　　　　　　　　　　　０円", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "解約返戻金額（照会日時点）　１，０００円", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "積立金額（照会日時点）　１，０００円", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "保険法対応契約", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "被保険者代理特約あり", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
    }

    @Test
    @TestOrder(70)
    public void testExec_B7() {

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20200801));
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99806039796", BizDate.valueOf("20250801"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, "080780");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 2, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "目標到達時円建年金保険変更特約　指定なし", "特約名称１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "被保険者代理特約", "特約名称２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "", "特約名称３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(),16, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　契約者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "年金受取人　　　　　被保険者　様", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "被保険者代理人　　　顧通契名２０１　テスト１２３４　様　　　　　生年月日　昭和５０年　１月　１日", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "契約加入時しおり約款検索コード　０１－２００４－２７５５", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "約款受領方法　Ｗｅｂでの受取り（インターネット環境で確認）", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "定率増加部分繰り入れ割合　　　０％", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "払込保険料の円換算額　　　　１２２，１５０，０００円", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "　保険料領収日時点の円換算為替レート　１米ドル＝１２２．１５円（令和　２年　７月　３日）", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "積立利率　２．７％　　積立金増加率上限　１１．５％　　たのしみ倍率　１．０８倍", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "死亡時（照会日時点）　　　　０．００米ドル　　（０円）", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "解約返戻金額（照会日時点）　１，０００．００米ドル　　（１，０００円）", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "積立金額（照会日時点）　１，０００．００米ドル　　（１，０００円）", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "保険法対応契約", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "被保険者代理特約あり", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "目標到達時円建年金保険変更特約あり　　　　　（目標額割合　指定なし）", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
    }

    @Test
    @TestOrder(80)
    public void testExec_B8() {

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20201201));
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99806038795", BizDate.valueOf("20201116"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, "080780");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 1, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "目標到達時円建年金保険変更特約　１０５％", "特約名称１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "", "特約名称２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "", "特約名称３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(),16, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　死受名　零零八　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "年金受取人　　　　　契約者　様", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "登録家族（１人目）　家名　零零八一　様　　　　　　　　　　　　　生年月日　昭和４５年　１月　１日", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "登録家族（２人目）　家名　零零八二　様　　　　　　　　　　　　　生年月日　平成　２年　１月　１日", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "契約加入時しおり約款検索コード　０１－２００８－２４７２", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "約款受領方法　Ｗｅｂでの受取り（インターネット環境で確認）", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "定率増加部分繰り入れ割合　　　０％", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "払込保険料の円換算額　　　　１，１１０，１５０円", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "　保険料領収日時点の円換算為替レート　１米ドル＝１２３．３５円（令和　２年１０月　１日）", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "積立利率　３．４５％　　連動率　１４６．９５％", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "死亡時（照会日時点）　　　　０．００米ドル　　（０円）", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "解約返戻金額（照会日時点）　１，０００．００米ドル　　（１，０００円）", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "積立金額（照会日時点）　１，０００．００米ドル　　（１，０００円）", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "保険法対応契約", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "目標到達時円建年金保険変更特約あり　　　　　（目標額割合　１０５％）", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
    }

    @Test
    @TestOrder(90)
    public void testExec_B9() {

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20200217));
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99806040125", BizDate.valueOf("20210901"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, "080780");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "前納中", "払込方法");
    }

    @Test
    @TestOrder(100)
    public void testExec_B10() {

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20200220));
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99806039800", BizDate.valueOf("20220804"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, "080780");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 3, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "保険料指定外通貨払込特約", "特約名称１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "保険契約者代理特約", "特約名称２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "被保険者代理特約", "特約名称３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(),17, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "令和　３年　８月　４日　目標到達（目標値：１５０％）により円建年金保険に変更済", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "　　　　　　　　　　　　到達金額　　　　　１９６，４８６，３５７円", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "死亡時支払金受取人　相続人　様", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "年金受取人　　　　　被保険者　様", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "契約者代理人　　　　顧通家族名２０２　テスト１２３　様　　　　　生年月日　平成１０年　１月　１日", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "被保険者代理人　　　顧通被代名２０２　テスト１２３　様　　　　　生年月日　昭和５０年　２月　２日", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "登録家族（１人目）　顧通家族名２０２　テスト１２３　様　　　　　生年月日　平成１０年　１月　１日", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "登録家族（２人目）　登録されておりません", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "契約加入時しおり約款検索コード　０１－２００４－２４５８", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "約款受領方法　Ｗｅｂでの受取り（インターネット環境で確認）", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "積立利率　０．０５％", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "死亡時（照会日時点）　　　　０円", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "解約返戻金額（照会日時点）　１，０００円", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "積立金額（照会日時点）　１，０００円", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "保険法対応契約", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "保険契約者代理特約あり", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "被保険者代理特約あり", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
    }

    @Test
    @TestOrder(110)
    public void testExec_B11() {

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20200210));
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000219", BizDate.valueOf("20210910"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, "080780");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "年２回払　口座振替扱", "払込方法");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 4, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "重度介護前払特約", "特約名称１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "初期死亡時円換算支払額最低保証特約", "特約名称２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "保険契約者代理特約", "特約名称３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "被保険者代理特約", "特約名称４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(),19, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　契約者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "契約者代理人　　　　顧通契代名４０４　テスト１２３　様　　　　　生年月日　昭和５０年　４月　４日", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "被保険者代理人　　　顧通契名４０１　テスト１２３４　様　　　　　生年月日　昭和５０年　１月　１日", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "契約加入時しおり約款検索コード　０１－２００４－２７６１", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "約款受領方法　Ｗｅｂでの受取り（インターネット環境で確認）", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "予定利率　２．７５％", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "死亡時", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "　第１保険期間（契約日以後２年）（照会日時点）　　０．００米ドル", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "　　　　　　　　　　　　　　　　　　　　　　　　　（１２３，１３０，０００円）", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "　　※第１保険期間中の保障額は、照会日時点の既払込保険料相当額です。", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "　第２保険期間（契約日から２年経過以後）　　　　　２，２４４，１００．００米ドル", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "　　　　　　　　　　　　　　　　　　　　　　　　　（２７８，４２５，４８７円）", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "解約返戻金額（照会日時点）　１，０００．００米ドル　　（１，０００円）", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "保険法対応契約", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "重度介護前払特約あり", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "初期死亡時円換算支払額最低保証特約あり", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "保険契約者代理特約あり", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "被保険者代理特約あり", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
    }

    @Test
    @TestOrder(120)
    public void testExec_B12() {

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20200210));
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000220", BizDate.valueOf("20210910"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, "080780");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "", "払込方法");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 5, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "重度介護前払特約", "特約名称１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "初期死亡時円換算支払額最低保証特約", "特約名称２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "保険料円貨払込特約（円貨払込額変動型）", "特約名称３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "保険契約者代理特約", "特約名称４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "被保険者代理特約", "特約名称５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(),17, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　契約者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "契約者代理人　　　　顧通契代名４０４　テスト１２３　様　　　　　生年月日　昭和５０年　４月　４日", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "被保険者代理人　　　顧通契名４０１　テスト１２３４　様　　　　　生年月日　昭和５０年　１月　１日", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "契約加入時しおり約款検索コード　０１－２００４－２７６１", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "約款受領方法　Ｗｅｂでの受取り（インターネット環境で確認）", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "予定利率　２．７５％", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "死亡時", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "　第１保険期間（契約日以後２年）（照会日時点）　　０円", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "　　※第１保険期間中の保障額は、照会日時点の既払込保険料相当額です。", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "　第２保険期間（契約日から２年経過以後）　　　　　２，２４４，１００円", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "解約返戻金額（照会日時点）　１，０００円", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "保険法対応契約", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "重度介護前払特約あり", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "保険料円貨払込特約（円貨払込額変動型）あり", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "初期死亡時円換算支払額最低保証特約あり", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "保険契約者代理特約あり", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "被保険者代理特約あり", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
    }

    @Test
    @TestOrder(130)
    public void testExec_B13() {

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20200210));
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000231", BizDate.valueOf("20210910"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, "080780");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "年１回払　口座振替扱", "払込方法");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 4, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "重度介護前払特約", "特約名称１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "初期死亡時円換算支払額最低保証特約", "特約名称２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "保険契約者代理特約", "特約名称３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "被保険者代理特約", "特約名称４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(),14, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　契約者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "契約者代理人　　　　顧通契代名４０４　テスト１２３　様　　　　　生年月日　昭和５０年　４月　４日", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "被保険者代理人　　　顧通契名４０１　テスト１２３４　様　　　　　生年月日　昭和５０年　１月　１日", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "契約加入時しおり約款検索コード　０１－２００４－２７６１", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "約款受領方法　Ｗｅｂでの受取り（インターネット環境で確認）", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "予定利率　２．７５％", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "死亡時", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "　第２保険期間（契約日から０年経過以後）　　　　　２，２４４，１００円", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "解約返戻金額（照会日時点）　１，０００円", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "保険法対応契約", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "重度介護前払特約あり", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "初期死亡時円換算支払額最低保証特約あり", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "保険契約者代理特約あり", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "被保険者代理特約あり", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
    }

    @Test
    @TestOrder(140)
    public void testExec_B14() {

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20200210));
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000242", BizDate.valueOf("20210910"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, "080780");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "", "払込方法");
    }

    @Test
    @TestOrder(150)
    public void testExec_B15() {

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20200210));
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000253", BizDate.valueOf("20210910"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, "080780");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "", "払込方法");
    }

    @Test
    @TestOrder(160)
    public void testExec_B16() {

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20200210));
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000264", BizDate.valueOf("20210910"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, "080780");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "お払込停止", "払込方法");
    }
}
