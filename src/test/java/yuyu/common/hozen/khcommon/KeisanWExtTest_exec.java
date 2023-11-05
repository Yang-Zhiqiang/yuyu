package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 解約返戻金計算拡張情報作成クラスのメソッド {@link KeisanWExt#exec()} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanWExtTest_exec {

    @Inject
    private KeisanWExt keisanWExt;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_解約返戻金計算拡張情報作成";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanWExtTest_exec.class, fileName, sheetName);
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
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        C_ErrorKbn errorKbn = keisanWExt.exec("11807111163",BizDate.valueOf("20080808"));
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_ErrorKbn errorKbn = keisanWExt.exec("11807111141",BizDate.valueOf("20080808"));
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_ErrorKbn errorKbn = keisanWExt.exec("11807111152",BizDate.valueOf("20080808"));
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        C_ErrorKbn errorKbn = keisanWExt.exec("11807111130",BizDate.valueOf("20080808"));
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        C_ErrorKbn errorKbn = keisanWExt.exec("11807111199",BizDate.valueOf("20080808"));
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        C_ErrorKbn errorKbn = keisanWExt.exec("17806000079",BizDate.valueOf("20080808"));
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanWExt.getKeisanWExtBean().getSyouhncd(), "07", "商品コード");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getSyouhnsdno(), 10, "商品世代番号");
        exStringEquals(keisanWExt.getKeisanWExtBean().getRyouritusdno(), "101", "料率世代番号");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getYoteiriritu(), BizNumber.valueOf(0.0001), "予定利率");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exDateEquals(keisanWExt.getKeisanWExtBean().getFstpryosyuymd(), BizDate.valueOf(20150605), "初回保険料領収日");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getHrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getHknkkn(), 10, "保険期間");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getHrkkkn(), 20, "払込期間");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getHhknnen(), 30, "被保険者年齢");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getKihons(), BizCurrency.valueOf(1000000,BizCurrencyTypes.YEN), "基本Ｓ");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getHokenryou(), BizCurrency.valueOf(111111,BizCurrencyTypes.YEN), "保険料");
        exDateEquals(keisanWExt.getKeisanWExtBean().getKykymd(), BizDate.valueOf(20160504), "契約日");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.1234),"契約時市場価格調整用利率");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");
        exDateYMEquals(keisanWExt.getKeisanWExtBean().getTmttkntaisyouym(), null, "積立金対象年月");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getTeiritutmttkngk(), BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "定率積立金額");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getSisuurendoutmttkngk(), BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "指数連動積立金額");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getTmttknhaneisisuu(), null, "積立金反映時指数");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getTumitateriritu(), BizNumber.valueOf(0.0001), "積立利率");
        exDateYMEquals(keisanWExt.getKeisanWExtBean().getJkipjytym(), BizDateYM.valueOf(201405), "次回Ｐ充当年月");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getTeikishrtkykhukaumu(), C_UmuKbn.ARI, "定期支払特約付加有無");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getPtmttkngk(), BizCurrency.valueOf(0), "保険料積立金額");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getKihrkmpstgk(), BizCurrency.valueOf(0), "既払込保険料相当額");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getYoteirrthendohosyurrt(), BizNumber.valueOf(0.222), "予定利率変動時保証利率");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getDai1hknkkn(), 0, "第１保険期間");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getKykJyoutai(), C_Kykjyoutai.BLNK, "契約状態");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        C_ErrorKbn errorKbn = keisanWExt.exec("17806000080",BizDate.valueOf("20080808"));
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        C_ErrorKbn errorKbn = keisanWExt.exec("17806000091",BizDate.valueOf("20190113"));
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanWExt.getKeisanWExtBean().getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getSyouhnsdno(), 10, "商品世代番号");
        exStringEquals(keisanWExt.getKeisanWExtBean().getRyouritusdno(), "303", "料率世代番号");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getYoteiriritu(), BizNumber.valueOf(1.1111), "予定利率");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exDateEquals(keisanWExt.getKeisanWExtBean().getFstpryosyuymd(), BizDate.valueOf(20150605), "初回保険料領収日");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getHrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getHknkkn(), 30, "保険期間");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getHrkkkn(), 40, "払込期間");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getHhknnen(), 30, "被保険者年齢");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getKihons(), BizCurrency.valueOf(1111112), "基本Ｓ");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getHokenryou(), BizCurrency.valueOf(3333333), "保険料");
        exDateEquals(keisanWExt.getKeisanWExtBean().getKykymd(), BizDate.valueOf(20160505), "契約日");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getKyksjkkktyouseiriritu(), BizNumber.valueOf(1),
            "契約時市場価格調整用利率");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(5.1234), "解約時市場価格調整用利率");
        exDateYMEquals(keisanWExt.getKeisanWExtBean().getTmttkntaisyouym(), BizDateYM.valueOf(200808), "積立金対象年月");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getTeiritutmttkngk(), BizCurrency.valueOf(100), "定率積立金額");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getSisuurendoutmttkngk(), BizCurrency.valueOf(1200), "指数連動積立金額");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getTmttknhaneisisuu(), BizNumber.valueOf(12345.1234), "積立金反映時指数");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getTumitateriritu(), BizNumber.valueOf(0.0001), "積立利率");
        exDateYMEquals(keisanWExt.getKeisanWExtBean().getJkipjytym(), BizDateYM.valueOf(201405), "次回Ｐ充当年月");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getTeikishrtkykhukaumu(), C_UmuKbn.ARI, "定期支払特約付加有無");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getPtmttkngk(), BizCurrency.valueOf(0), "保険料積立金額");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getKihrkmpstgk(), BizCurrency.valueOf(0), "既払込保険料相当額");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getYoteirrthendohosyurrt(), BizNumber.valueOf(0.222), "予定利率変動時保証利率");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getDai1hknkkn(), 9, "第１保険期間");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getKykJyoutai(), C_Kykjyoutai.ITIJIBARAI, "契約状態");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        C_ErrorKbn errorKbn = keisanWExt.exec("17806000013",BizDate.valueOf("20080808"));
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanWExt.getKeisanWExtBean().getSyouhncd(), "10", "商品コード");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getSyouhnsdno(), 10, "商品世代番号");
        exStringEquals(keisanWExt.getKeisanWExtBean().getRyouritusdno(), "101", "料率世代番号");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getYoteiriritu(), BizNumber.valueOf(0.0001), "予定利率");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exDateEquals(keisanWExt.getKeisanWExtBean().getFstpryosyuymd(), BizDate.valueOf(20150605), "初回保険料領収日");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getHrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getHknkkn(), 10, "保険期間");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getHrkkkn(), 20, "払込期間");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getHhknnen(), 30, "被保険者年齢");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getKihons(), BizCurrency.valueOf(10000,BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getHokenryou(), BizCurrency.valueOf(1111.11,BizCurrencyTypes.DOLLAR), "保険料");
        exDateEquals(keisanWExt.getKeisanWExtBean().getKykymd(), BizDate.valueOf(20160504), "契約日");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.1234),"契約時市場価格調整用利率");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");
        exDateYMEquals(keisanWExt.getKeisanWExtBean().getTmttkntaisyouym(), null, "積立金対象年月");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getTeiritutmttkngk(), BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR), "定率積立金額");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getSisuurendoutmttkngk(), BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getTmttknhaneisisuu() , null, "積立金反映時指数");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getTumitateriritu(), BizNumber.valueOf(0.0001), "積立利率");
        exDateYMEquals(keisanWExt.getKeisanWExtBean().getJkipjytym(), BizDateYM.valueOf(201405), "次回Ｐ充当年月");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getTeikishrtkykhukaumu(), C_UmuKbn.ARI, "定期支払特約付加有無");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getPtmttkngk(), BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR), "保険料積立金額");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getKihrkmpstgk(), BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR), "既払込保険料相当額");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getYoteirrthendohosyurrt(), BizNumber.valueOf(0.222), "予定利率変動時保証利率");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getDai1hknkkn(), 99, "第１保険期間");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getKykJyoutai(), C_Kykjyoutai.ITIJIBARAI, "契約状態");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        C_ErrorKbn errorKbn = keisanWExt.exec("17806100472",BizDate.valueOf("20080808"));
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        C_ErrorKbn errorKbn = keisanWExt.exec("17806100520",BizDate.valueOf("20080808"));
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanWExt.getKeisanWExtBean().getSyouhncd(), "10", "商品コード");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getSyouhnsdno(), 10, "商品世代番号");
        exStringEquals(keisanWExt.getKeisanWExtBean().getRyouritusdno(), "101", "料率世代番号");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getYoteiriritu(), BizNumber.valueOf(0.0001), "予定利率");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exDateEquals(keisanWExt.getKeisanWExtBean().getFstpryosyuymd(), BizDate.valueOf(20150605), "初回保険料領収日");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getHrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getHknkkn(), 10, "保険期間");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getHrkkkn(), 20, "払込期間");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getHhknnen(), 30, "被保険者年齢");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getKihons(), BizCurrency.valueOf(10000,BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getHokenryou(), BizCurrency.valueOf(1111.11,BizCurrencyTypes.DOLLAR), "保険料");
        exDateEquals(keisanWExt.getKeisanWExtBean().getKykymd(), BizDate.valueOf(20160504), "契約日");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.1234),"契約時市場価格調整用利率");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");
        exDateYMEquals(keisanWExt.getKeisanWExtBean().getTmttkntaisyouym(), BizDateYM.valueOf(200101), "積立金対象年月");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getTeiritutmttkngk(), BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR), "定率積立金額");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getSisuurendoutmttkngk(), BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getTmttknhaneisisuu() , null, "積立金反映時指数");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getTumitateriritu(), BizNumber.valueOf(0.0001), "積立利率");
        exDateYMEquals(keisanWExt.getKeisanWExtBean().getJkipjytym(), BizDateYM.valueOf(201405), "次回Ｐ充当年月");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getTeikishrtkykhukaumu(), C_UmuKbn.ARI, "定期支払特約付加有無");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getPtmttkngk(), BizCurrency.valueOf(0.8,BizCurrencyTypes.DOLLAR), "保険料積立金額");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getKihrkmpstgk(), BizCurrency.valueOf(1,BizCurrencyTypes.DOLLAR), "既払込保険料相当額");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getYoteirrthendohosyurrt(), BizNumber.valueOf(0.222), "予定利率変動時保証利率");
        exDateEquals(keisanWExt.getKeisanWExtBean().getYendthnkymd(), null, "円建変更日");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getDai1hknkkn(), 99, "第１保険期間");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getKykJyoutai(), C_Kykjyoutai.ITIJIBARAI, "契約状態");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        C_ErrorKbn errorKbn = keisanWExt.exec("17806100531",BizDate.valueOf("20090808"));
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanWExt.getKeisanWExtBean().getSyouhncd(), "10", "商品コード");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getSyouhnsdno(), 10, "商品世代番号");
        exStringEquals(keisanWExt.getKeisanWExtBean().getRyouritusdno(), "101", "料率世代番号");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getYoteiriritu(), BizNumber.valueOf(0.0001), "予定利率");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exDateEquals(keisanWExt.getKeisanWExtBean().getFstpryosyuymd(), BizDate.valueOf(20150605), "初回保険料領収日");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getHrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getHknkkn(), 10, "保険期間");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getHrkkkn(), 20, "払込期間");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getHhknnen(), 30, "被保険者年齢");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getKihons(), BizCurrency.valueOf(10000,BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getHokenryou(), BizCurrency.valueOf(1111.11,BizCurrencyTypes.DOLLAR), "保険料");
        exDateEquals(keisanWExt.getKeisanWExtBean().getKykymd(), BizDate.valueOf(20160504), "契約日");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.1234),"契約時市場価格調整用利率");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");
        exDateYMEquals(keisanWExt.getKeisanWExtBean().getTmttkntaisyouym(), BizDateYM.valueOf(200808), "積立金対象年月");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getTeiritutmttkngk(), BizCurrency.valueOf(1,BizCurrencyTypes.DOLLAR), "定率積立金額");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getSisuurendoutmttkngk(), BizCurrency.valueOf(12,BizCurrencyTypes.DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getTmttknhaneisisuu() , BizNumber.valueOf(12345.1234), "積立金反映時指数");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getTumitateriritu(), BizNumber.valueOf(0.0001), "積立利率");
        exDateYMEquals(keisanWExt.getKeisanWExtBean().getJkipjytym(), BizDateYM.valueOf(201405), "次回Ｐ充当年月");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getTeikishrtkykhukaumu(), C_UmuKbn.ARI, "定期支払特約付加有無");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getPtmttkngk(), BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR), "保険料積立金額");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getKihrkmpstgk(), BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR), "既払込保険料相当額");
        exBizCalcbleEquals(keisanWExt.getKeisanWExtBean().getYoteirrthendohosyurrt(), BizNumber.valueOf(0.222), "予定利率変動時保証利率");
        exDateEquals(keisanWExt.getKeisanWExtBean().getYendthnkymd(), BizDate.valueOf(20190515), "円建変更日");
        exNumericEquals(keisanWExt.getKeisanWExtBean().getDai1hknkkn(), 99, "第１保険期間");
        exClassificationEquals(keisanWExt.getKeisanWExtBean().getKykJyoutai(), C_Kykjyoutai.ITIJIBARAI, "契約状態");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        C_ErrorKbn errorKbn = keisanWExt.exec("17806000024",BizDate.valueOf("20080808"));
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }
}
