package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
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

import yuyu.common.biz.bzcommon.BzGetVrate2;
import yuyu.common.biz.bzcommon.BzGetVrate2MockForHozen;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TyksenhokanhouKbn;
import yuyu.def.classification.C_VRateGetKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 保険料積立金計算クラスのメソッド {@link KeisanV#exec( BizDate pCalckijyunYmd, BizDateYM pCalckijyunYm, BizDate pKykymd,
        String pSyouhnCd, int pSyouhnsdNo, String pRyouritusdNo, BizNumber pYoteiRiritu, C_Hrkkaisuu pHaraikomiKaisuu,
        C_Hhknsei pHhknSei, int pHhknNen, C_HknkknsmnKbn pHknKknSmnKbn, int pHknkkn, C_HrkkknsmnKbn pHrkkknsmnKbn,
        int pHrkkkn, BizCurrency pKihonS, int pKeikaNensuu, int pKkeikaMon, C_Tuukasyu pKeiyakuTuukasyu, BizCurrency pHokenryou,
        C_TyksenhokanhouKbn pTyksenhokanhouKbn, C_Kykjyoutai pKykjyoutai, int pDai1hknkkn)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanVTest_exec {

    @Inject
    private KeisanV KeisanV;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetVrate2.class).to(BzGetVrate2MockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        BzGetVrate2MockForHozen.caller = KeisanVTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        BzGetVrate2MockForHozen.caller = null;
        BzGetVrate2MockForHozen.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();

        BzGetVrate2MockForHozen.SYORIPTN = BzGetVrate2MockForHozen.TESTPATTERN1;

        BizDate calckijyunYmd = BizDate.valueOf("20201101");

        BizDateYM calckijyunYm = calckijyunYmd.getBizDateYM();

        BizDate kykymd = BizDate.valueOf("20191101");

        String syouhnCd = "ﾕｲ";

        int syouhnsdNo = 1;

        String ryouritusdNo = "J";

        BizNumber yoteiRiritu = BizNumber.valueOf(0.0124);

        C_Hrkkaisuu haraikomiKaisuu = C_Hrkkaisuu.ITIJI;

        C_Hhknsei hhknSei = C_Hhknsei.MALE;

        int hhknNen = 100;

        C_HknkknsmnKbn hknKknSmnKbn = C_HknkknsmnKbn.NENMANKI;

        int hknkkn = 99;

        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        int hrkkkn = 0;

        BizCurrency kihonS = BizCurrency.valueOf(10000, BizCurrencyTypes.AU_DOLLAR);

        int keikaNensuu = 98;

        int kkeikaMon = 10;

        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.AUD;

        BizCurrency hokenryou = BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR);

        C_TyksenhokanhouKbn tyksenhokanhouKbn = C_TyksenhokanhouKbn.RATE;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;

        int dai1hknkkn = 5;

        C_ErrorKbn resultKbn = KeisanV.exec(calckijyunYmd, calckijyunYm, kykymd, syouhnCd, syouhnsdNo, ryouritusdNo, yoteiRiritu, haraikomiKaisuu, hhknSei,
            hhknNen, hknKknSmnKbn, hknkkn, hrkkknsmnKbn, hrkkkn, kihonS, keikaNensuu, kkeikaMon, keiyakuTuukasyu, hokenryou, tyksenhokanhouKbn, kykjyoutai, dai1hknkkn);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");

        exBizCalcbleEquals(KeisanV.getV(), null, "保険料積立金");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();

        BzGetVrate2MockForHozen.SYORIPTN = BzGetVrate2MockForHozen.TESTPATTERN2;

        BizDate calckijyunYmd = BizDate.valueOf("20201101");

        BizDateYM calckijyunYm = calckijyunYmd.getBizDateYM();

        BizDate kykymd = BizDate.valueOf("20191101");

        String syouhnCd = "ﾕｲ";

        int syouhnsdNo = 1;

        String ryouritusdNo = "J";

        BizNumber yoteiRiritu = BizNumber.valueOf(0.0125);

        C_Hrkkaisuu haraikomiKaisuu = C_Hrkkaisuu.ITIJI;

        C_Hhknsei hhknSei = C_Hhknsei.MALE;

        int hhknNen = 100;

        C_HknkknsmnKbn hknKknSmnKbn = C_HknkknsmnKbn.NENMANKI;

        int hknkkn = 99;

        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        int hrkkkn = 0;

        BizCurrency kihonS = BizCurrency.valueOf(10000, BizCurrencyTypes.AU_DOLLAR);

        int keikaNensuu = 98;

        int kkeikaMon = 9;

        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.AUD;

        BizCurrency hokenryou = BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR);

        C_TyksenhokanhouKbn tyksenhokanhouKbn = C_TyksenhokanhouKbn.JITUGAKU;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;

        int dai1hknkkn = 5;

        C_ErrorKbn resultKbn = KeisanV.exec(calckijyunYmd, calckijyunYm, kykymd, syouhnCd, syouhnsdNo, ryouritusdNo, yoteiRiritu, haraikomiKaisuu, hhknSei,
            hhknNen, hknKknSmnKbn, hknkkn, hrkkknsmnKbn, hrkkkn, kihonS, keikaNensuu, kkeikaMon, keiyakuTuukasyu, hokenryou, tyksenhokanhouKbn, kykjyoutai, dai1hknkkn);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanV.getV(), BizCurrency.valueOf(1.58, BizCurrencyTypes.AU_DOLLAR), "保険料積立金");
        exBooleanEquals(KeisanV.getV().getType() == BizCurrencyTypes.AU_DOLLAR, true, "保険料積立金の通貨タイプ");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();

        BzGetVrate2MockForHozen.SYORIPTN = BzGetVrate2MockForHozen.TESTPATTERN2;

        BizDate calckijyunYmd = BizDate.valueOf("20201101");

        BizDateYM calckijyunYm = calckijyunYmd.getBizDateYM();

        BizDate kykymd = BizDate.valueOf("20191101");

        String syouhnCd = "ﾕｴ";

        int syouhnsdNo = 2;

        String ryouritusdNo = "J";

        BizNumber yoteiRiritu = BizNumber.valueOf(0.0145);

        C_Hrkkaisuu haraikomiKaisuu = C_Hrkkaisuu.ITIJI;

        C_Hhknsei hhknSei = C_Hhknsei.MALE;

        int hhknNen = 40;

        C_HknkknsmnKbn hknKknSmnKbn = C_HknkknsmnKbn.NENMANKI;

        int hknkkn = 99;

        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        int hrkkkn = 0;

        BizCurrency kihonS = BizCurrency.valueOf(10, BizCurrencyTypes.AU_DOLLAR);

        int keikaNensuu = 98;

        int kkeikaMon = 10;

        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.AUD;

        BizCurrency hokenryou = BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR);

        C_TyksenhokanhouKbn tyksenhokanhouKbn = C_TyksenhokanhouKbn.RATE;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;

        int dai1hknkkn = 5;

        C_ErrorKbn resultKbn = KeisanV.exec(calckijyunYmd, calckijyunYm, kykymd, syouhnCd, syouhnsdNo, ryouritusdNo, yoteiRiritu, haraikomiKaisuu, hhknSei,
            hhknNen, hknKknSmnKbn, hknkkn, hrkkknsmnKbn, hrkkkn, kihonS, keikaNensuu, kkeikaMon, keiyakuTuukasyu, hokenryou, tyksenhokanhouKbn, kykjyoutai, dai1hknkkn);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanV.getV(), BizCurrency.valueOf(9999.99, BizCurrencyTypes.AU_DOLLAR), "保険料積立金");
        exBooleanEquals(KeisanV.getV().getType() == BizCurrencyTypes.AU_DOLLAR, true, "保険料積立金の通貨タイプ");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();

        BzGetVrate2MockForHozen.SYORIPTN = BzGetVrate2MockForHozen.TESTPATTERN2;

        BizDate calckijyunYmd = BizDate.valueOf("20201101");

        BizDateYM calckijyunYm = calckijyunYmd.getBizDateYM();

        BizDate kykymd = BizDate.valueOf("20191101");

        String syouhnCd = "ﾕｱ";

        int syouhnsdNo = 3;

        String ryouritusdNo = "L";

        BizNumber yoteiRiritu = BizNumber.valueOf(0.0300);

        C_Hrkkaisuu haraikomiKaisuu = C_Hrkkaisuu.ITIJI;

        C_Hhknsei hhknSei = C_Hhknsei.MALE;

        int hhknNen = 14;

        C_HknkknsmnKbn hknKknSmnKbn = C_HknkknsmnKbn.NENMANKI;

        int hknkkn = 99;

        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        int hrkkkn = 0;

        BizCurrency kihonS = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        int keikaNensuu = 98;

        int kkeikaMon = 9;

        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.USD;

        BizCurrency hokenryou = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        C_TyksenhokanhouKbn tyksenhokanhouKbn = C_TyksenhokanhouKbn.JITUGAKU;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;

        int dai1hknkkn = 5;

        C_ErrorKbn resultKbn = KeisanV.exec(calckijyunYmd, calckijyunYm, kykymd, syouhnCd, syouhnsdNo, ryouritusdNo, yoteiRiritu, haraikomiKaisuu, hhknSei,
            hhknNen, hknKknSmnKbn, hknkkn, hrkkknsmnKbn, hrkkkn, kihonS, keikaNensuu, kkeikaMon, keiyakuTuukasyu, hokenryou, tyksenhokanhouKbn, kykjyoutai, dai1hknkkn);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanV.getV(), BizCurrency.valueOf(1.58, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBooleanEquals(KeisanV.getV().getType() == BizCurrencyTypes.DOLLAR, true, "保険料積立金の通貨タイプ");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();

        BzGetVrate2MockForHozen.SYORIPTN = BzGetVrate2MockForHozen.TESTPATTERN2;

        BizDate calckijyunYmd = BizDate.valueOf("20201101");

        BizDateYM calckijyunYm = calckijyunYmd.getBizDateYM();

        BizDate kykymd = BizDate.valueOf("20191101");

        String syouhnCd = "ﾕｳ";

        int syouhnsdNo = 1;

        String ryouritusdNo = "L";

        BizNumber yoteiRiritu = BizNumber.valueOf(0.0295);

        C_Hrkkaisuu haraikomiKaisuu = C_Hrkkaisuu.ITIJI;

        C_Hhknsei hhknSei = C_Hhknsei.MALE;

        int hhknNen = 13;

        C_HknkknsmnKbn hknKknSmnKbn = C_HknkknsmnKbn.NENMANKI;

        int hknkkn = 99;

        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        int hrkkkn = 0;

        BizCurrency kihonS = BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR);

        int keikaNensuu = 98;

        int kkeikaMon = 10;

        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.USD;

        BizCurrency hokenryou = BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR);

        C_TyksenhokanhouKbn tyksenhokanhouKbn = C_TyksenhokanhouKbn.RATE;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;

        int dai1hknkkn = 5;

        C_ErrorKbn resultKbn = KeisanV.exec(calckijyunYmd, calckijyunYm, kykymd, syouhnCd, syouhnsdNo, ryouritusdNo, yoteiRiritu, haraikomiKaisuu, hhknSei,
            hhknNen, hknKknSmnKbn, hknkkn, hrkkknsmnKbn, hrkkkn, kihonS, keikaNensuu, kkeikaMon, keiyakuTuukasyu, hokenryou, tyksenhokanhouKbn, kykjyoutai, dai1hknkkn);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanV.getV(), BizCurrency.valueOf(9999.99, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBooleanEquals(KeisanV.getV().getType() == BizCurrencyTypes.DOLLAR, true, "保険料積立金の通貨タイプ");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();

        BzGetVrate2MockForHozen.SYORIPTN = BzGetVrate2MockForHozen.TESTPATTERN2;

        BizDate calckijyunYmd = BizDate.valueOf("20201101");

        BizDateYM calckijyunYm = calckijyunYmd.getBizDateYM();

        BizDate kykymd = BizDate.valueOf("20191101");

        String syouhnCd = "ﾕｶ";

        int syouhnsdNo = 2;

        String ryouritusdNo = "J";

        BizNumber yoteiRiritu = BizNumber.valueOf(0.0395);

        C_Hrkkaisuu haraikomiKaisuu = C_Hrkkaisuu.ITIJI;

        C_Hhknsei hhknSei = C_Hhknsei.MALE;

        int hhknNen = 60;

        C_HknkknsmnKbn hknKknSmnKbn = C_HknkknsmnKbn.NENMANKI;

        int hknkkn = 99;

        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        int hrkkkn = 0;

        BizCurrency kihonS = BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR);

        int keikaNensuu = 0;

        int kkeikaMon = 10;

        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.USD;

        BizCurrency hokenryou = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        C_TyksenhokanhouKbn tyksenhokanhouKbn = C_TyksenhokanhouKbn.JITUGAKU;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;

        int dai1hknkkn = 5;

        C_ErrorKbn resultKbn = KeisanV.exec(calckijyunYmd, calckijyunYm, kykymd, syouhnCd, syouhnsdNo, ryouritusdNo, yoteiRiritu, haraikomiKaisuu, hhknSei,
            hhknNen, hknKknSmnKbn, hknkkn, hrkkknsmnKbn, hrkkkn, kihonS, keikaNensuu, kkeikaMon, keiyakuTuukasyu, hokenryou, tyksenhokanhouKbn, kykjyoutai, dai1hknkkn);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanV.getV(), BizCurrency.valueOf(16.67, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBooleanEquals(KeisanV.getV().getType() == BizCurrencyTypes.DOLLAR, true, "保険料積立金の通貨タイプ");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();

        BzGetVrate2MockForHozen.SYORIPTN = BzGetVrate2MockForHozen.TESTPATTERN2;

        BizDate calckijyunYmd = BizDate.valueOf("20201101");

        BizDateYM calckijyunYm = calckijyunYmd.getBizDateYM();

        BizDate kykymd = BizDate.valueOf("20191101");

        String syouhnCd = "ﾕA";

        int syouhnsdNo = 3;

        String ryouritusdNo = "L";

        BizNumber yoteiRiritu = BizNumber.valueOf(0.0105);

        C_Hrkkaisuu haraikomiKaisuu = C_Hrkkaisuu.ITIJI;

        C_Hhknsei hhknSei = C_Hhknsei.FEMALE;

        int hhknNen = 20;

        C_HknkknsmnKbn hknKknSmnKbn = C_HknkknsmnKbn.NENMANKI;

        int hknkkn = 99;

        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        int hrkkkn = 0;

        BizCurrency kihonS = BizCurrency.valueOf(10000050, BizCurrencyTypes.YEN);

        int keikaNensuu = 98;

        int kkeikaMon = 11;

        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.JPY;

        BizCurrency hokenryou = BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR);

        C_TyksenhokanhouKbn tyksenhokanhouKbn = C_TyksenhokanhouKbn.RATE;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;

        int dai1hknkkn = 5;

        C_ErrorKbn resultKbn = KeisanV.exec(calckijyunYmd, calckijyunYm, kykymd, syouhnCd, syouhnsdNo, ryouritusdNo, yoteiRiritu, haraikomiKaisuu, hhknSei,
            hhknNen, hknKknSmnKbn, hknkkn, hrkkknsmnKbn, hrkkkn, kihonS, keikaNensuu, kkeikaMon, keiyakuTuukasyu, hokenryou, tyksenhokanhouKbn, kykjyoutai, dai1hknkkn);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanV.getV(), BizCurrency.valueOf(9948049, BizCurrencyTypes.YEN), "保険料積立金");
        exBooleanEquals(KeisanV.getV().getType() == BizCurrencyTypes.YEN, true, "保険料積立金の通貨タイプ");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();

        BzGetVrate2MockForHozen.SYORIPTN = BzGetVrate2MockForHozen.TESTPATTERN2;

        BizDate calckijyunYmd = BizDate.valueOf("20201101");

        BizDateYM calckijyunYm = calckijyunYmd.getBizDateYM();

        BizDate kykymd = BizDate.valueOf("20191101");

        String syouhnCd = "ﾕA";

        int syouhnsdNo = 2;

        String ryouritusdNo = "L";

        BizNumber yoteiRiritu = BizNumber.valueOf(0.0105);

        C_Hrkkaisuu haraikomiKaisuu = C_Hrkkaisuu.ITIJI;

        C_Hhknsei hhknSei = C_Hhknsei.FEMALE;

        int hhknNen = 20;

        C_HknkknsmnKbn hknKknSmnKbn = C_HknkknsmnKbn.NENMANKI;

        int hknkkn = 99;

        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        int hrkkkn = 0;

        BizCurrency kihonS = BizCurrency.valueOf(10000050, BizCurrencyTypes.YEN);

        int keikaNensuu = 98;

        int kkeikaMon = 0;

        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.JPY;

        BizCurrency hokenryou = BizCurrency.valueOf(100, BizCurrencyTypes.YEN);

        C_TyksenhokanhouKbn tyksenhokanhouKbn = C_TyksenhokanhouKbn.JITUGAKU;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;

        int dai1hknkkn = 5;

        C_ErrorKbn resultKbn = KeisanV.exec(calckijyunYmd, calckijyunYm, kykymd, syouhnCd, syouhnsdNo, ryouritusdNo, yoteiRiritu, haraikomiKaisuu, hhknSei,
            hhknNen, hknKknSmnKbn, hknkkn, hrkkknsmnKbn, hrkkkn, kihonS, keikaNensuu, kkeikaMon, keiyakuTuukasyu, hokenryou, tyksenhokanhouKbn, kykjyoutai, dai1hknkkn);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanV.getV(), BizCurrency.valueOf(9899049, BizCurrencyTypes.YEN), "保険料積立金");
        exBooleanEquals(KeisanV.getV().getType() == BizCurrencyTypes.YEN, true, "保険料積立金の通貨タイプ");

        exStringEquals((String) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 0), "ﾕA", "商品コード");
        exStringEquals((String) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 1), "L", "料率世代番号");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 2), BizNumber.valueOf(0.0105), "予定利率");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 3), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals((C_Hhknsei) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 4), C_Hhknsei.FEMALE, "被保険者性別");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 5), 20, "被保険者年齢");
        exClassificationEquals((C_HknkknsmnKbn) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 6), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 7), 99, "保険期間");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 8), 0, "払込期間");
        exClassificationEquals((C_Kykjyoutai) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 9), C_Kykjyoutai.ITIJIBARAI, "契約状態");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 10), C_Tuukasyu.JPY, "通貨種類");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 11), 0, "第１保険期間");
        exClassificationEquals((C_VRateGetKbn) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 12), C_VRateGetKbn.TWOYEARS, "Ｖレート取得区分");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 13), 98, "経過年数");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();

        BzGetVrate2MockForHozen.SYORIPTN = BzGetVrate2MockForHozen.TESTPATTERN2;

        BizDate calckijyunYmd = BizDate.valueOf("20241001");

        BizDateYM calckijyunYm = calckijyunYmd.getBizDateYM();

        BizDate kykymd = BizDate.valueOf("20191101");

        String syouhnCd = "ﾕｹ";

        int syouhnsdNo = 3;

        String ryouritusdNo = "L";

        BizNumber yoteiRiritu = BizNumber.valueOf(0.0300);

        C_Hrkkaisuu haraikomiKaisuu = C_Hrkkaisuu.TUKI;

        C_Hhknsei hhknSei = C_Hhknsei.MALE;

        int hhknNen = 14;

        C_HknkknsmnKbn hknKknSmnKbn = C_HknkknsmnKbn.NENMANKI;

        int hknkkn = 0;

        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        int hrkkkn = 5;

        BizCurrency kihonS = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        int keikaNensuu = 98;

        int kkeikaMon = 9;

        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.USD;

        BizCurrency hokenryou = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        C_TyksenhokanhouKbn tyksenhokanhouKbn = C_TyksenhokanhouKbn.JITUGAKU;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.HARAIZUMI;

        int dai1hknkkn = 5;

        C_ErrorKbn resultKbn = KeisanV.exec(calckijyunYmd, calckijyunYm, kykymd, syouhnCd, syouhnsdNo, ryouritusdNo, yoteiRiritu, haraikomiKaisuu, hhknSei,
            hhknNen, hknKknSmnKbn, hknkkn, hrkkknsmnKbn, hrkkkn, kihonS, keikaNensuu, kkeikaMon, keiyakuTuukasyu, hokenryou, tyksenhokanhouKbn, kykjyoutai, dai1hknkkn);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanV.getV(), BizCurrency.valueOf(1.58, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBooleanEquals(KeisanV.getV().getType() == BizCurrencyTypes.DOLLAR, true, "保険料積立金の通貨タイプ");

        exStringEquals((String) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 0), "ﾕｹ", "商品コード");
        exStringEquals((String) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 1), "L", "料率世代番号");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 2), BizNumber.valueOf(0.0300), "予定利率");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 3), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals((C_Hhknsei) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 4), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 5), 14, "被保険者年齢");
        exClassificationEquals((C_HknkknsmnKbn) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 6), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 7), 0, "保険期間");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 8), 5, "払込期間");
        exClassificationEquals((C_Kykjyoutai) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 9), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 10), C_Tuukasyu.USD, "通貨種類");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 11), 5, "第１保険期間");
        exClassificationEquals((C_VRateGetKbn) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 12), C_VRateGetKbn.TWOYEARS, "Ｖレート取得区分");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 13), 98, "経過年数");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        MockObjectManager.initialize();

        BzGetVrate2MockForHozen.SYORIPTN = BzGetVrate2MockForHozen.TESTPATTERN2;

        BizDate calckijyunYmd = BizDate.valueOf("20241101");

        BizDateYM calckijyunYm = calckijyunYmd.getBizDateYM();

        BizDate kykymd = BizDate.valueOf("20191101");

        String syouhnCd = "ﾕｹ";

        int syouhnsdNo = 3;

        String ryouritusdNo = "L";

        BizNumber yoteiRiritu = BizNumber.valueOf(0.0300);

        C_Hrkkaisuu haraikomiKaisuu = C_Hrkkaisuu.TUKI;

        C_Hhknsei hhknSei = C_Hhknsei.MALE;

        int hhknNen = 14;

        C_HknkknsmnKbn hknKknSmnKbn = C_HknkknsmnKbn.SAIMANKI;

        int hknkkn = 0;

        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.SAIMANKI;

        int hrkkkn = 19;

        BizCurrency kihonS = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        int keikaNensuu = 98;

        int kkeikaMon = 9;

        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.USD;

        BizCurrency hokenryou = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        C_TyksenhokanhouKbn tyksenhokanhouKbn = C_TyksenhokanhouKbn.JITUGAKU;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.HARAIZUMI;

        int dai1hknkkn = 5;

        C_ErrorKbn resultKbn = KeisanV.exec(calckijyunYmd, calckijyunYm, kykymd, syouhnCd, syouhnsdNo, ryouritusdNo, yoteiRiritu, haraikomiKaisuu, hhknSei,
            hhknNen, hknKknSmnKbn, hknkkn, hrkkknsmnKbn, hrkkkn, kihonS, keikaNensuu, kkeikaMon, keiyakuTuukasyu, hokenryou, tyksenhokanhouKbn, kykjyoutai, dai1hknkkn);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanV.getV(), BizCurrency.valueOf(1.58, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBooleanEquals(KeisanV.getV().getType() == BizCurrencyTypes.DOLLAR, true, "保険料積立金の通貨タイプ");

        exStringEquals((String) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 0), "ﾕｹ", "商品コード");
        exStringEquals((String) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 1), "L", "料率世代番号");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 2), BizNumber.valueOf(0.0300), "予定利率");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 3), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals((C_Hhknsei) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 4), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 5), 14, "被保険者年齢");
        exClassificationEquals((C_HknkknsmnKbn) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 6), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 7), 0, "保険期間");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 8), 19, "払込期間");
        exClassificationEquals((C_Kykjyoutai) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 9), C_Kykjyoutai.HARAIMAN, "契約状態");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 10), C_Tuukasyu.USD, "通貨種類");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 11), 5, "第１保険期間");
        exClassificationEquals((C_VRateGetKbn) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 12), C_VRateGetKbn.TWOYEARS, "Ｖレート取得区分");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 13), 98, "経過年数");

    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();

        BzGetVrate2MockForHozen.SYORIPTN = BzGetVrate2MockForHozen.TESTPATTERN2;

        BizDate calckijyunYmd = BizDate.valueOf("20291201");

        BizDateYM calckijyunYm = calckijyunYmd.getBizDateYM();

        BizDate kykymd = BizDate.valueOf("20191101");

        String syouhnCd = "ﾕｺ";

        int syouhnsdNo = 3;

        String ryouritusdNo = "L";

        BizNumber yoteiRiritu = BizNumber.valueOf(0.0300);

        C_Hrkkaisuu haraikomiKaisuu = C_Hrkkaisuu.TUKI;

        C_Hhknsei hhknSei = C_Hhknsei.MALE;

        int hhknNen = 14;

        C_HknkknsmnKbn hknKknSmnKbn = C_HknkknsmnKbn.SAIMANKI;

        int hknkkn = 0;

        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.SAIMANKI;

        int hrkkkn = 24;

        BizCurrency kihonS = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        int keikaNensuu = 98;

        int kkeikaMon = 9;

        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.USD;

        BizCurrency hokenryou = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        C_TyksenhokanhouKbn tyksenhokanhouKbn = C_TyksenhokanhouKbn.JITUGAKU;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.HARAIMAN;

        int dai1hknkkn = 10;

        C_ErrorKbn resultKbn = KeisanV.exec(calckijyunYmd, calckijyunYm, kykymd, syouhnCd, syouhnsdNo, ryouritusdNo, yoteiRiritu, haraikomiKaisuu, hhknSei,
            hhknNen, hknKknSmnKbn, hknkkn, hrkkknsmnKbn, hrkkkn, kihonS, keikaNensuu, kkeikaMon, keiyakuTuukasyu, hokenryou, tyksenhokanhouKbn, kykjyoutai, dai1hknkkn);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(KeisanV.getV(), BizCurrency.valueOf(1.58, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBooleanEquals(KeisanV.getV().getType() == BizCurrencyTypes.DOLLAR, true, "保険料積立金の通貨タイプ");

        exStringEquals((String) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 0), "ﾕｺ", "商品コード");
        exStringEquals((String) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 1), "L", "料率世代番号");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 2), BizNumber.valueOf(0.0300), "予定利率");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 3), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals((C_Hhknsei) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 4), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 5), 14, "被保険者年齢");
        exClassificationEquals((C_HknkknsmnKbn) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 6), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 7), 0, "保険期間");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 8), 24, "払込期間");
        exClassificationEquals((C_Kykjyoutai) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 9), C_Kykjyoutai.HARAIMAN, "契約状態");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 10), C_Tuukasyu.USD, "通貨種類");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 11), 10, "第１保険期間");
        exClassificationEquals((C_VRateGetKbn) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 12), C_VRateGetKbn.TWOYEARS, "Ｖレート取得区分");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetVrate2MockForHozen.class, "exec", 0, 13), 98, "経過年数");

    }
}
