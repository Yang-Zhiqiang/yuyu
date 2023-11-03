package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.BzGetVrate2;
import yuyu.common.biz.bzcommon.BzGetVrate2MockForHozen;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VRateGetKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 円建変更後Ｓ計算のメソッド {@link KeisanYendtHnkS#exec(BizDate, BizCurrency, BizCurrency, String, Integer, String,
 * BizNumber, C_Hrkkaisuu, C_Hhknsei, int, C_HknkknsmnKbn, int, int, int, int, BizDate,
 * BizDateYM)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanYendtHnkSTest_exec {

    @Inject
    private KeisanYendtHnkS keisanYendtHnkS;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetVrate2.class).to(BzGetVrate2MockForHozen.class);
                bind(KeisanW.class).to(KeisanWMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        BzGetVrate2MockForHozen.caller = KeisanYendtHnkSTest_exec.class;
        KeisanWMockForHozen.caller = KeisanYendtHnkSTest_exec.class;
        BzGetVrate2MockForHozen.SYORIPTN = null;
        KeisanWMockForHozen.SYORIPTN = null;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

        BzGetVrate2MockForHozen.caller = null;
        KeisanWMockForHozen.caller = null;
        BzGetVrate2MockForHozen.SYORIPTN = null;
        KeisanWMockForHozen.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();

        BzGetVrate2MockForHozen.SYORIPTN = BzGetVrate2MockForHozen.TESTPATTERN1;

        BizDate calcKijyunYmd = BizDate.valueOf("20180220");
        BizCurrency yendthnkW = BizCurrency.valueOf(1234567123);
        BizCurrency yendtHnkSibouS = BizCurrency.valueOf(1234567234);
        String syouhnCd = "1010";
        int yendtHnkSyouhnSdno = 10;
        String yendtHnkRyourituSdno = "001";
        BizNumber yendtHnkYoteiriritu = BizNumber.valueOf(0.1234);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;
        C_Hhknsei hhknSei = C_Hhknsei.MALE;
        int hhknNen = 100;
        C_HknkknsmnKbn hknKknSmnKbn = C_HknkknsmnKbn.SAIMANKI;
        int hknkkn = 11;
        int hrkkkn = 12;
        int keikaNensuu = 13;
        int keikaMon = 14;
        BizDate kykYmd = BizDate.valueOf(20180301);
        BizDateYM kaiyakuHrKeisanKijyunYm = BizDateYM.valueOf(201803);

        C_ErrorKbn resultKbn = keisanYendtHnkS.exec(calcKijyunYmd, yendthnkW, yendtHnkSibouS, syouhnCd,
            yendtHnkSyouhnSdno, yendtHnkRyourituSdno, yendtHnkYoteiriritu, hrkkaisuu, hhknSei, hhknNen, hknKknSmnKbn,
            hknkkn, hrkkkn, keikaNensuu, keikaMon, kykYmd, kaiyakuHrKeisanKijyunYm);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");

        exStringEquals((String) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 0),
            "1010", "商品コード");

        exStringEquals((String) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 1),
            "001", "料率世代番号");

        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(0.1234), "予定利率");

        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 3),
            C_Hrkkaisuu.ITIJI, "払込回数");

        exClassificationEquals((C_Hhknsei) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 4),
            C_Hhknsei.MALE, "被保険者性別");

        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 5), 100, "被保険者年齢");

        exClassificationEquals((C_HknkknsmnKbn) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 6),
            C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");

        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 7), 11, "保険期間");

        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 8), 12, "払込期間");

        exClassificationEquals((C_Kykjyoutai) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 9),
            C_Kykjyoutai.ITIJIBARAI, "契約状態");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 10),
            C_Tuukasyu.JPY, "通貨種類");

        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 11), 0, "第１保険期間");

        exClassificationEquals((C_VRateGetKbn) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 12),
            C_VRateGetKbn.TWOYEARS, "取得区分");

        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 13), 13, "経過年数");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();

        BzGetVrate2MockForHozen.SYORIPTN = BzGetVrate2MockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;

        BizDate calcKijyunYmd = BizDate.valueOf("20180220");
        BizCurrency yendthnkW = BizCurrency.valueOf(1234567122);
        BizCurrency yendtHnkSibouS = BizCurrency.valueOf(1234567201);
        String syouhnCd = "1010";
        int yendtHnkSyouhnSdno = 10;
        String yendtHnkRyourituSdno = "001";
        BizNumber yendtHnkYoteiriritu = BizNumber.valueOf(0.1234);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;
        C_Hhknsei hhknSei = C_Hhknsei.MALE;
        int hhknNen = 100;
        C_HknkknsmnKbn hknKknSmnKbn = C_HknkknsmnKbn.SAIMANKI;
        int hknkkn = 11;
        int hrkkkn = 12;
        int keikaNensuu = 13;
        int keikaMon = 1;
        BizDate kykYmd = BizDate.valueOf(20180301);
        BizDateYM kaiyakuHrKeisanKijyunYm = BizDateYM.valueOf(201803);

        C_ErrorKbn resultKbn = keisanYendtHnkS.exec(calcKijyunYmd, yendthnkW, yendtHnkSibouS, syouhnCd,
            yendtHnkSyouhnSdno, yendtHnkRyourituSdno, yendtHnkYoteiriritu, hrkkaisuu, hhknSei, hhknNen, hknKknSmnKbn,
            hknkkn, hrkkkn, keikaNensuu, keikaMon, kykYmd, kaiyakuHrKeisanKijyunYm);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf("20180220"), "計算基準日");

        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 1),
            BizDateYM.valueOf("201803"), "基準年月");

        KeisanWExtBean keisanWExtBean = (KeisanWExtBean) MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 2);

        exStringEquals(keisanWExtBean.getSyouhncd(), "1010", "商品コード");

        exNumericEquals(keisanWExtBean.getSyouhnsdno(), 10, "商品世代番号");

        exStringEquals(keisanWExtBean.getRyouritusdno(), "001", "料率世代番号");

        exBizCalcbleEquals(keisanWExtBean.getYoteiriritu(), BizNumber.valueOf(0.1234), "予定利率");

        exClassificationEquals(keisanWExtBean.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");

        exClassificationEquals(keisanWExtBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");

        exNumericEquals(keisanWExtBean.getHknkkn(), 11, "保険期間");

        exNumericEquals(keisanWExtBean.getHrkkkn(), 12, "払込期間");

        exNumericEquals(keisanWExtBean.getHhknnen(), 100, "被保険者年齢");

        exClassificationEquals(keisanWExtBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");

        exBizCalcbleEquals(keisanWExtBean.getKihons(), BizCurrency.valueOf(1234567200), "基本Ｓ");

        exBizCalcbleEquals(keisanWExtBean.getHokenryou(), BizCurrency.valueOf(0), "保険料");

        exDateEquals(keisanWExtBean.getKykymd(), BizDate.valueOf("20180301"), "契約日");

        exClassificationEquals(keisanWExtBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");

        exBizCalcbleEquals(keisanWExtBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(0), "契約時市場価格調整用利率");

        exBizCalcbleEquals(keisanWExtBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");

        exDateYMEquals(keisanWExtBean.getTmttkntaisyouym(), null, "積立金対象年月");

        exBizCalcbleEquals(keisanWExtBean.getTeiritutmttkngk(), BizCurrency.valueOf(0), "定率積立金額");

        exBizCalcbleEquals(keisanWExtBean.getSisuurendoutmttkngk(), BizCurrency.valueOf(0), "指数連動積立金額");

        exBizCalcbleEquals(keisanWExtBean.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");

        exNumericEquals(keisanWExtBean.getDai1hknkkn(), 0, "第１保険期間");

        exClassificationEquals(keisanWExtBean.getKykJyoutai(), C_Kykjyoutai.ITIJIBARAI, "契約状態");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();

        BzGetVrate2MockForHozen.SYORIPTN = BzGetVrate2MockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;

        BizDate calcKijyunYmd = BizDate.valueOf("20180220");
        BizCurrency yendthnkW = BizCurrency.valueOf(1234567199.1234);
        BizCurrency yendtHnkSibouS = BizCurrency.valueOf(1234567200);
        String syouhnCd = "1010";
        int yendtHnkSyouhnSdno = 10;
        String yendtHnkRyourituSdno = "001";
        BizNumber yendtHnkYoteiriritu = BizNumber.valueOf(0.1234);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;
        C_Hhknsei hhknSei = C_Hhknsei.MALE;
        int hhknNen = 100;
        C_HknkknsmnKbn hknKknSmnKbn = C_HknkknsmnKbn.SAIMANKI;
        int hknkkn = 11;
        int hrkkkn = 12;
        int keikaNensuu = 13;
        int keikaMon = 1;
        BizDate kykYmd = BizDate.valueOf(20180301);
        BizDateYM kaiyakuHrKeisanKijyunYm = BizDateYM.valueOf(201803);

        C_ErrorKbn resultKbn = keisanYendtHnkS.exec(calcKijyunYmd, yendthnkW, yendtHnkSibouS, syouhnCd,
            yendtHnkSyouhnSdno, yendtHnkRyourituSdno, yendtHnkYoteiriritu, hrkkaisuu, hhknSei, hhknNen, hknKknSmnKbn,
            hknkkn, hrkkkn, keikaNensuu, keikaMon, kykYmd, kaiyakuHrKeisanKijyunYm);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf("20180220"), "計算基準日");

        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 1),
            BizDateYM.valueOf("201803"), "基準年月");

        KeisanWExtBean keisanWExtBean = (KeisanWExtBean) MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 2);

        exStringEquals(keisanWExtBean.getSyouhncd(), "1010", "商品コード");

        exNumericEquals(keisanWExtBean.getSyouhnsdno(), 10, "商品世代番号");

        exStringEquals(keisanWExtBean.getRyouritusdno(), "001", "料率世代番号");

        exBizCalcbleEquals(keisanWExtBean.getYoteiriritu(), BizNumber.valueOf(0.1234), "予定利率");

        exClassificationEquals(keisanWExtBean.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");

        exClassificationEquals(keisanWExtBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");

        exNumericEquals(keisanWExtBean.getHknkkn(), 11, "保険期間");

        exNumericEquals(keisanWExtBean.getHrkkkn(), 12, "払込期間");

        exNumericEquals(keisanWExtBean.getHhknnen(), 100, "被保険者年齢");

        exClassificationEquals(keisanWExtBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");

        exBizCalcbleEquals(keisanWExtBean.getKihons(), BizCurrency.valueOf(1234567200), "基本Ｓ");

        exBizCalcbleEquals(keisanWExtBean.getHokenryou(), BizCurrency.valueOf(0), "保険料");

        exDateEquals(keisanWExtBean.getKykymd(), BizDate.valueOf("20180301"), "契約日");

        exClassificationEquals(keisanWExtBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");

        exBizCalcbleEquals(keisanWExtBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(0), "契約時市場価格調整用利率");

        exBizCalcbleEquals(keisanWExtBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");

        exDateYMEquals(keisanWExtBean.getTmttkntaisyouym(), null, "積立金対象年月");

        exBizCalcbleEquals(keisanWExtBean.getTeiritutmttkngk(), BizCurrency.valueOf(0), "定率積立金額");

        exBizCalcbleEquals(keisanWExtBean.getSisuurendoutmttkngk(), BizCurrency.valueOf(0), "指数連動積立金額");

        exBizCalcbleEquals(keisanWExtBean.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");

        exNumericEquals(keisanWExtBean.getDai1hknkkn(), 0, "第１保険期間");

        exClassificationEquals(keisanWExtBean.getKykJyoutai(), C_Kykjyoutai.ITIJIBARAI, "契約状態");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();

        BzGetVrate2MockForHozen.SYORIPTN = BzGetVrate2MockForHozen.TESTPATTERN3;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN3;

        BizDate calcKijyunYmd = BizDate.valueOf("20180220");
        BizCurrency yendthnkW = BizCurrency.valueOf(123456710);
        BizCurrency yendtHnkSibouS = BizCurrency.valueOf(1234567099);
        String syouhnCd = "1010";
        int yendtHnkSyouhnSdno = 10;
        String yendtHnkRyourituSdno = "001";
        BizNumber yendtHnkYoteiriritu = BizNumber.valueOf(0.1234);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;
        C_Hhknsei hhknSei = C_Hhknsei.MALE;
        int hhknNen = 100;
        C_HknkknsmnKbn hknKknSmnKbn = C_HknkknsmnKbn.SAIMANKI;
        int hknkkn = 11;
        int hrkkkn = 12;
        int keikaNensuu = 13;
        int keikaMon = 2;
        BizDate kykYmd = BizDate.valueOf(20180301);
        BizDateYM kaiyakuHrKeisanKijyunYm = BizDateYM.valueOf(201803);

        C_ErrorKbn resultKbn = keisanYendtHnkS.exec(calcKijyunYmd, yendthnkW, yendtHnkSibouS, syouhnCd,
            yendtHnkSyouhnSdno, yendtHnkRyourituSdno, yendtHnkYoteiriritu, hrkkaisuu, hhknSei, hhknNen, hknKknSmnKbn,
            hknkkn, hrkkkn, keikaNensuu, keikaMon, kykYmd, kaiyakuHrKeisanKijyunYm);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanYendtHnkS.getYendthnkKihonSBefore(), BizCurrency.valueOf(1234567100),
            "円建変更後基本Ｓ（調整前）");

        exBizCalcbleEquals(keisanYendtHnkS.getYendthnkKihonSAfter(), BizCurrency.valueOf(1234567099),
            "円建変更後基本Ｓ（調整後）");

        exBizCalcbleEquals(keisanYendtHnkS.getYendthnkW(), BizCurrency.valueOf(123456711), "円建変更後解約返戻金");

        exClassificationEquals(keisanYendtHnkS.getYendthnkhrUmu(), C_UmuKbn.NONE, "円建変更時返戻金有無");

        exBizCalcbleEquals(keisanYendtHnkS.getYendthnkhr(), BizCurrency.valueOf(0), "円建変更時返戻金");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();

        BzGetVrate2MockForHozen.SYORIPTN = BzGetVrate2MockForHozen.TESTPATTERN4;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN4;

        BizDate calcKijyunYmd = BizDate.valueOf("20180220");
        BizCurrency yendthnkW = BizCurrency.valueOf(123456710);
        BizCurrency yendtHnkSibouS = BizCurrency.valueOf(58788999);
        String syouhnCd = "1010";
        int yendtHnkSyouhnSdno = 10;
        String yendtHnkRyourituSdno = "001";
        BizNumber yendtHnkYoteiriritu = BizNumber.valueOf(0.1234);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;
        C_Hhknsei hhknSei = C_Hhknsei.MALE;
        int hhknNen = 100;
        C_HknkknsmnKbn hknKknSmnKbn = C_HknkknsmnKbn.SAIMANKI;
        int hknkkn = 11;
        int hrkkkn = 12;
        int keikaNensuu = 13;
        int keikaMon = 3;
        BizDate kykYmd = BizDate.valueOf(20180301);
        BizDateYM kaiyakuHrKeisanKijyunYm = BizDateYM.valueOf(201803);

        C_ErrorKbn resultKbn = keisanYendtHnkS.exec(calcKijyunYmd, yendthnkW, yendtHnkSibouS, syouhnCd,
            yendtHnkSyouhnSdno, yendtHnkRyourituSdno, yendtHnkYoteiriritu, hrkkaisuu, hhknSei, hhknNen, hknKknSmnKbn,
            hknkkn, hrkkkn, keikaNensuu, keikaMon, kykYmd, kaiyakuHrKeisanKijyunYm);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanYendtHnkS.getYendthnkKihonSBefore(), BizCurrency.valueOf(58789000),
            "円建変更後基本Ｓ（調整前）");

        exBizCalcbleEquals(keisanYendtHnkS.getYendthnkKihonSAfter(), BizCurrency.valueOf(58788999),
            "円建変更後基本Ｓ（調整後）");

        exBizCalcbleEquals(keisanYendtHnkS.getYendthnkW(), BizCurrency.valueOf(123456710), "円建変更後解約返戻金");

        exClassificationEquals(keisanYendtHnkS.getYendthnkhrUmu(), C_UmuKbn.NONE, "円建変更時返戻金有無");

        exBizCalcbleEquals(keisanYendtHnkS.getYendthnkhr(), BizCurrency.valueOf(0), "円建変更時返戻金");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();

        BzGetVrate2MockForHozen.SYORIPTN = BzGetVrate2MockForHozen.TESTPATTERN5;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN5;

        BizDate calcKijyunYmd = BizDate.valueOf("20180220");
        BizCurrency yendthnkW = BizCurrency.valueOf(1234567122);
        BizCurrency yendtHnkSibouS = BizCurrency.valueOf(617283500);
        String syouhnCd = "1010";
        int yendtHnkSyouhnSdno = 10;
        String yendtHnkRyourituSdno = "001";
        BizNumber yendtHnkYoteiriritu = BizNumber.valueOf(0.1234);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;
        C_Hhknsei hhknSei = C_Hhknsei.MALE;
        int hhknNen = 100;
        C_HknkknsmnKbn hknKknSmnKbn = C_HknkknsmnKbn.SAIMANKI;
        int hknkkn = 11;
        int hrkkkn = 12;
        int keikaNensuu = 13;
        int keikaMon = 3;
        BizDate kykYmd = BizDate.valueOf(20180301);
        BizDateYM kaiyakuHrKeisanKijyunYm = BizDateYM.valueOf(201803);

        C_ErrorKbn resultKbn = keisanYendtHnkS.exec(calcKijyunYmd, yendthnkW, yendtHnkSibouS, syouhnCd,
            yendtHnkSyouhnSdno, yendtHnkRyourituSdno, yendtHnkYoteiriritu, hrkkaisuu, hhknSei, hhknNen, hknKknSmnKbn,
            hknkkn, hrkkkn, keikaNensuu, keikaMon, kykYmd, kaiyakuHrKeisanKijyunYm);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanYendtHnkS.getYendthnkKihonSBefore(), BizCurrency.valueOf(617283561),
            "円建変更後基本Ｓ（調整前）");

        exBizCalcbleEquals(keisanYendtHnkS.getYendthnkKihonSAfter(), BizCurrency.valueOf(617283500),
            "円建変更後基本Ｓ（調整後）");

        exBizCalcbleEquals(keisanYendtHnkS.getYendthnkW(), BizCurrency.valueOf(1234567121), "円建変更後解約返戻金");

        exClassificationEquals(keisanYendtHnkS.getYendthnkhrUmu(), C_UmuKbn.ARI, "円建変更時返戻金有無");

        exBizCalcbleEquals(keisanYendtHnkS.getYendthnkhr(), BizCurrency.valueOf(1), "円建変更時返戻金");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();

        BzGetVrate2MockForHozen.SYORIPTN = BzGetVrate2MockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;

        BizDate calcKijyunYmd = BizDate.valueOf("20180220");
        BizCurrency yendthnkW = BizCurrency.valueOf(1234567111.055);
        BizCurrency yendtHnkSibouS = BizCurrency.valueOf(1234567200);
        String syouhnCd = "1010";
        int yendtHnkSyouhnSdno = 10;
        String yendtHnkRyourituSdno = "001";
        BizNumber yendtHnkYoteiriritu = BizNumber.valueOf(0.1234);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;
        C_Hhknsei hhknSei = C_Hhknsei.MALE;
        int hhknNen = 100;
        C_HknkknsmnKbn hknKknSmnKbn = C_HknkknsmnKbn.SAIMANKI;
        int hknkkn = 11;
        int hrkkkn = 12;
        int keikaNensuu = 13;
        int keikaMon = 1;
        BizDate kykYmd = BizDate.valueOf(20180301);
        BizDateYM kaiyakuHrKeisanKijyunYm = BizDateYM.valueOf(201803);

        C_ErrorKbn resultKbn = keisanYendtHnkS.exec(calcKijyunYmd, yendthnkW, yendtHnkSibouS, syouhnCd,
            yendtHnkSyouhnSdno, yendtHnkRyourituSdno, yendtHnkYoteiriritu, hrkkaisuu, hhknSei, hhknNen, hknKknSmnKbn,
            hknkkn, hrkkkn, keikaNensuu, keikaMon, kykYmd, kaiyakuHrKeisanKijyunYm);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanYendtHnkS.getYendthnkKihonSBefore(), BizCurrency.valueOf(1234567200),
            "円建変更後基本Ｓ（調整前）");

        exBizCalcbleEquals(keisanYendtHnkS.getYendthnkKihonSAfter(), BizCurrency.valueOf(1234567200),
            "円建変更後基本Ｓ（調整後）");

        exBizCalcbleEquals(keisanYendtHnkS.getYendthnkW(), BizCurrency.valueOf(1234567890), "円建変更後解約返戻金");

        exClassificationEquals(keisanYendtHnkS.getYendthnkhrUmu(), C_UmuKbn.NONE, "円建変更時返戻金有無");

        exBizCalcbleEquals(keisanYendtHnkS.getYendthnkhr(), BizCurrency.valueOf(0), "円建変更時返戻金");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();

        BzGetVrate2MockForHozen.SYORIPTN = BzGetVrate2MockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;

        BizDate calcKijyunYmd = BizDate.valueOf("20180220");
        BizCurrency yendthnkW = BizCurrency.valueOf(1234567111.5);
        BizCurrency yendtHnkSibouS = BizCurrency.valueOf(1234567300);
        String syouhnCd = "1010";
        int yendtHnkSyouhnSdno = 10;
        String yendtHnkRyourituSdno = "001";
        BizNumber yendtHnkYoteiriritu = BizNumber.valueOf(0.1234);
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;
        C_Hhknsei hhknSei = C_Hhknsei.MALE;
        int hhknNen = 100;
        C_HknkknsmnKbn hknKknSmnKbn = C_HknkknsmnKbn.SAIMANKI;
        int hknkkn = 11;
        int hrkkkn = 12;
        int keikaNensuu = 13;
        int keikaMon = 1;
        BizDate kykYmd = BizDate.valueOf(20180301);
        BizDateYM kaiyakuHrKeisanKijyunYm = BizDateYM.valueOf(201803);

        C_ErrorKbn resultKbn = keisanYendtHnkS.exec(calcKijyunYmd, yendthnkW, yendtHnkSibouS, syouhnCd,
            yendtHnkSyouhnSdno, yendtHnkRyourituSdno, yendtHnkYoteiriritu, hrkkaisuu, hhknSei, hhknNen, hknKknSmnKbn,
            hknkkn, hrkkkn, keikaNensuu, keikaMon, kykYmd, kaiyakuHrKeisanKijyunYm);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanYendtHnkS.getYendthnkKihonSBefore(), BizCurrency.valueOf(1234567200),
            "円建変更後基本Ｓ（調整前）");

        exBizCalcbleEquals(keisanYendtHnkS.getYendthnkKihonSAfter(), BizCurrency.valueOf(1234567200),
            "円建変更後基本Ｓ（調整後）");

        exBizCalcbleEquals(keisanYendtHnkS.getYendthnkW(), BizCurrency.valueOf(1234567890), "円建変更後解約返戻金");

        exClassificationEquals(keisanYendtHnkS.getYendthnkhrUmu(), C_UmuKbn.NONE, "円建変更時返戻金有無");

        exBizCalcbleEquals(keisanYendtHnkS.getYendthnkhr(), BizCurrency.valueOf(0), "円建変更時返戻金");
    }

}
