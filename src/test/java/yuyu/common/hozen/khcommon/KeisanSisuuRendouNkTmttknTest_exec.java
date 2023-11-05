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
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 契約保全共通 指数連動年金積立金計算クラスのメソッド
 *  {@link KeisanSisuuRendouNkTmttkn#exec(C_Tuukasyu, BizDateYM, BizDateYM, BizNumber, BizCurrency, BizCurrency)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanSisuuRendouNkTmttknTest_exec {

    @Inject
    private KeisanSisuuRendouNkTmttkn keisanSisuuRendouNkTmttkn;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate kykymd = null;

        int hknkkn = 0;

        C_UmuKbn teikishrtkykhukaumu = C_UmuKbn.NONE;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizDate calcKijyunYmd = null;

        BizDateYM calcKijyunYm = BizDateYM.valueOf(2018, 2);

        BizDateYM calcStartYm = BizDateYM.valueOf(2018, 3);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0123);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(98765, BizCurrencyTypes.YEN);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN);

        C_ErrorKbn result = keisanSisuuRendouNkTmttkn.exec(kykymd, hknkkn, teikishrtkykhukaumu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk, sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.ERROR, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTmttkngkkei(), null, "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTeiritutmttkngk(), null, "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getSisuurendoutmttkngk(), null, "指数連動積立金額");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate kykymd = null;

        int hknkkn = 0;

        C_UmuKbn teikishrtkykhukaumu = C_UmuKbn.NONE;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizDate calcKijyunYmd = null;

        BizDateYM calcKijyunYm = BizDateYM.valueOf(2018, 2);

        BizDateYM calcStartYm = BizDateYM.valueOf(2018, 2);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0123);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(98765, BizCurrencyTypes.YEN);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN);

        C_ErrorKbn result = keisanSisuuRendouNkTmttkn.exec(kykymd, hknkkn, teikishrtkykhukaumu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk, sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTmttkngkkei(), BizCurrency.valueOf(1234666655, BizCurrencyTypes.YEN), "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTeiritutmttkngk(), BizCurrency.valueOf(98765, BizCurrencyTypes.YEN), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN), "指数連動積立金額");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDate kykymd = null;

        int hknkkn = 0;

        C_UmuKbn teikishrtkykhukaumu = C_UmuKbn.NONE;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizDate calcKijyunYmd = null;

        BizDateYM calcKijyunYm = BizDateYM.valueOf(2018, 2);

        BizDateYM calcStartYm = BizDateYM.valueOf(2018, 1);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0123);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(98765, BizCurrencyTypes.YEN);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN);

        C_ErrorKbn result = keisanSisuuRendouNkTmttkn.exec(kykymd, hknkkn, teikishrtkykhukaumu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk, sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTmttkngkkei(), BizCurrency.valueOf(1234666756, BizCurrencyTypes.YEN), "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTeiritutmttkngk(), BizCurrency.valueOf(98866, BizCurrencyTypes.YEN), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN), "指数連動積立金額");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BizDate kykymd = null;

        int hknkkn = 0;

        C_UmuKbn teikishrtkykhukaumu = C_UmuKbn.NONE;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizDate calcKijyunYmd = null;

        BizDateYM calcKijyunYm = BizDateYM.valueOf(2018, 2);

        BizDateYM calcStartYm = BizDateYM.valueOf(2017, 11);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0123);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(98765, BizCurrencyTypes.YEN);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN);

        C_ErrorKbn result = keisanSisuuRendouNkTmttkn.exec(kykymd, hknkkn, teikishrtkykhukaumu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk, sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTmttkngkkei(), BizCurrency.valueOf(1234666958, BizCurrencyTypes.YEN), "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTeiritutmttkngk(), BizCurrency.valueOf(99068, BizCurrencyTypes.YEN), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN), "指数連動積立金額");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BizDate kykymd = null;

        int hknkkn = 0;

        C_UmuKbn teikishrtkykhukaumu = C_UmuKbn.NONE;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.USD;

        BizDate calcKijyunYmd = null;

        BizDateYM calcKijyunYm = BizDateYM.valueOf(2018, 2);

        BizDateYM calcStartYm = BizDateYM.valueOf(2017, 11);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0123);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(98765.43, BizCurrencyTypes.DOLLAR);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.DOLLAR);

        C_ErrorKbn result = keisanSisuuRendouNkTmttkn.exec(kykymd, hknkkn, teikishrtkykhukaumu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk, sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTmttkngkkei(), BizCurrency.valueOf(1234666957.75, BizCurrencyTypes.DOLLAR), "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTeiritutmttkngk(), BizCurrency.valueOf(99067.75, BizCurrencyTypes.DOLLAR), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567890, BizCurrencyTypes.DOLLAR), "指数連動積立金額");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BizDate kykymd = null;

        int hknkkn = 0;

        C_UmuKbn teikishrtkykhukaumu = C_UmuKbn.NONE;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizDate calcKijyunYmd = null;

        BizDateYM calcKijyunYm = BizDateYM.valueOf(2018, 2);

        BizDateYM calcStartYm = BizDateYM.valueOf(2018, 1);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0451);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(98765, BizCurrencyTypes.YEN);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN);

        C_ErrorKbn result = keisanSisuuRendouNkTmttkn.exec(kykymd, hknkkn, teikishrtkykhukaumu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk, sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTmttkngkkei(), BizCurrency.valueOf(1234667019, BizCurrencyTypes.YEN), "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTeiritutmttkngk(), BizCurrency.valueOf(99129, BizCurrencyTypes.YEN), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN), "指数連動積立金額");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BizDate kykymd = null;

        int hknkkn = 0;

        C_UmuKbn teikishrtkykhukaumu = C_UmuKbn.ARI;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizDate calcKijyunYmd = null;

        BizDateYM calcKijyunYm = BizDateYM.valueOf(2018, 2);

        BizDateYM calcStartYm = BizDateYM.valueOf(2017, 3);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0123);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(98765, BizCurrencyTypes.YEN);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN);

        C_ErrorKbn result = keisanSisuuRendouNkTmttkn.exec(kykymd, hknkkn, teikishrtkykhukaumu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk, sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTmttkngkkei(), BizCurrency.valueOf(1234667769, BizCurrencyTypes.YEN), "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTeiritutmttkngk(), BizCurrency.valueOf(99879, BizCurrencyTypes.YEN), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN), "指数連動積立金額");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        BizDate kykymd = null;

        int hknkkn = 0;

        C_UmuKbn teikishrtkykhukaumu = C_UmuKbn.NONE;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizDate calcKijyunYmd = null;

        BizDateYM calcKijyunYm = BizDateYM.valueOf(2018, 2);

        BizDateYM calcStartYm = BizDateYM.valueOf(2017, 2);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0123);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(98765, BizCurrencyTypes.YEN);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN);

        C_ErrorKbn result = keisanSisuuRendouNkTmttkn.exec(kykymd, hknkkn, teikishrtkykhukaumu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk, sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTmttkngkkei(), BizCurrency.valueOf(1234667870, BizCurrencyTypes.YEN), "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTeiritutmttkngk(), BizCurrency.valueOf(99980, BizCurrencyTypes.YEN), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN), "指数連動積立金額");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        BizDate kykymd = null;

        int hknkkn = 0;

        C_UmuKbn teikishrtkykhukaumu = C_UmuKbn.NONE;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizDate calcKijyunYmd = null;

        BizDateYM calcKijyunYm = BizDateYM.valueOf(2018, 2);

        BizDateYM calcStartYm = BizDateYM.valueOf(2017, 1);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0123);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(98765, BizCurrencyTypes.YEN);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN);

        C_ErrorKbn result = keisanSisuuRendouNkTmttkn.exec(kykymd, hknkkn, teikishrtkykhukaumu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk, sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.ERROR, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTmttkngkkei(), null, "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTeiritutmttkngk(), null, "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getSisuurendoutmttkngk(), null, "指数連動積立金額");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        BizDate kykymd = null;

        int hknkkn = 0;

        C_UmuKbn teikishrtkykhukaumu = C_UmuKbn.NONE;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizDate calcKijyunYmd = null;

        BizDateYM calcKijyunYm = BizDateYM.valueOf(2018, 2);

        BizDateYM calcStartYm = BizDateYM.valueOf(2017, 11);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0123);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(-1, BizCurrencyTypes.YEN);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN);

        C_ErrorKbn result = keisanSisuuRendouNkTmttkn.exec(kykymd, hknkkn, teikishrtkykhukaumu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk, sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTmttkngkkei(), BizCurrency.valueOf(1234567889, BizCurrencyTypes.YEN), "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTeiritutmttkngk(), BizCurrency.valueOf(-1, BizCurrencyTypes.YEN), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN), "指数連動積立金額");

    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        BizDate kykymd = null;

        int hknkkn = 0;

        C_UmuKbn teikishrtkykhukaumu = C_UmuKbn.NONE;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizDate calcKijyunYmd = null;

        BizDateYM calcKijyunYm = BizDateYM.valueOf(2018, 2);

        BizDateYM calcStartYm = BizDateYM.valueOf(2017, 11);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0123);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN);

        C_ErrorKbn result = keisanSisuuRendouNkTmttkn.exec(kykymd, hknkkn, teikishrtkykhukaumu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk, sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTmttkngkkei(), BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN), "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTeiritutmttkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN), "指数連動積立金額");

    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        BizDate kykymd = null;

        int hknkkn = 0;

        C_UmuKbn teikishrtkykhukaumu = C_UmuKbn.NONE;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizDate calcKijyunYmd = null;

        BizDateYM calcKijyunYm = BizDateYM.valueOf(2018, 2);

        BizDateYM calcStartYm = BizDateYM.valueOf(2018, 2);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0123);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN);

        C_ErrorKbn result = keisanSisuuRendouNkTmttkn.exec(kykymd, hknkkn, teikishrtkykhukaumu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk, sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTmttkngkkei(), BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN), "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTeiritutmttkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN), "指数連動積立金額");

    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        BizDate kykymd = BizDate.valueOf(20150515);

        int hknkkn = 5;

        C_UmuKbn teikishrtkykhukaumu = C_UmuKbn.ARI;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizDate calcKijyunYmd = null;

        BizDateYM calcKijyunYm = BizDateYM.valueOf(2020, 5);

        BizDateYM calcStartYm = BizDateYM.valueOf(2019, 5);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0123);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(98765, BizCurrencyTypes.YEN);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN);

        C_ErrorKbn result = keisanSisuuRendouNkTmttkn.exec(kykymd, hknkkn, teikishrtkykhukaumu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk, sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTmttkngkkei(), BizCurrency.valueOf(1234667870, BizCurrencyTypes.YEN), "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTeiritutmttkngk(), BizCurrency.valueOf(99980, BizCurrencyTypes.YEN), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN), "指数連動積立金額");

    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        BizDate kykymd = BizDate.valueOf(20150615);

        int hknkkn = 5;

        C_UmuKbn teikishrtkykhukaumu = C_UmuKbn.ARI;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizDate calcKijyunYmd = BizDate.valueOf(20200514);

        BizDateYM calcKijyunYm = BizDateYM.valueOf(2020, 5);

        BizDateYM calcStartYm = BizDateYM.valueOf(2019, 5);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0123);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(98765, BizCurrencyTypes.YEN);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN);

        C_ErrorKbn result = keisanSisuuRendouNkTmttkn.exec(kykymd, hknkkn, teikishrtkykhukaumu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk, sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTmttkngkkei(), BizCurrency.valueOf(1234667870, BizCurrencyTypes.YEN), "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTeiritutmttkngk(), BizCurrency.valueOf(99980, BizCurrencyTypes.YEN), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN), "指数連動積立金額");

    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        BizDate kykymd = BizDate.valueOf(20150615);

        int hknkkn = 5;

        C_UmuKbn teikishrtkykhukaumu = C_UmuKbn.ARI;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizDate calcKijyunYmd = BizDate.valueOf(20200516);

        BizDateYM calcKijyunYm = BizDateYM.valueOf(2020, 5);

        BizDateYM calcStartYm = BizDateYM.valueOf(2019, 5);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0123);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(98765, BizCurrencyTypes.YEN);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN);

        C_ErrorKbn result = keisanSisuuRendouNkTmttkn.exec(kykymd, hknkkn, teikishrtkykhukaumu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk, sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTmttkngkkei(), BizCurrency.valueOf(1234666655, BizCurrencyTypes.YEN), "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getTeiritutmttkngk(), BizCurrency.valueOf(98765, BizCurrencyTypes.YEN), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN), "指数連動積立金額");

    }
}
