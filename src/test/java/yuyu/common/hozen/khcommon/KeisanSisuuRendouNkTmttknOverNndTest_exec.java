package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 契約保全共通 指数連動年金積立金計算(年度越)クラスのメソッド
 *  {@link KeisanSisuuRendouNkTmttknOverNnd#exec(C_Tuukasyu, BizDateYM, BizDateYM, BizNumber, BizCurrency, BizCurrency)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanSisuuRendouNkTmttknOverNndTest_exec {

    @Inject
    private KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate kykYmd = BizDate.valueOf("20180101");

        int hknkkn = 11;

        C_UmuKbn teikishrtkykhukaUmu = C_UmuKbn.NONE;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizDate calcKijyunYmd = BizDate.valueOf("20180401");

        BizDateYM   calcKijyunYm = BizDateYM.valueOf(2018, 04);

        BizDateYM   calcStartYm = BizDateYM.valueOf(2018, 05);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0123);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(98765, BizCurrencyTypes.YEN);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN);

        C_ErrorKbn result = keisanSisuuRendouNkTmttknOverNnd.exec(kykYmd, hknkkn, teikishrtkykhukaUmu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk,sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.ERROR, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getTmttkngkkei(), null, "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk(), null, "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getSisuurendoutmttkngk(), null, "指数連動積立金額");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate kykYmd = BizDate.valueOf("20180101");

        int hknkkn = 11;

        C_UmuKbn teikishrtkykhukaUmu = C_UmuKbn.NONE;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.USD;

        BizDate calcKijyunYmd = BizDate.valueOf("20180401");

        BizDateYM   calcKijyunYm = BizDateYM.valueOf(2018, 04);

        BizDateYM   calcStartYm = BizDateYM.valueOf(2018, 04);

        BizNumber tumitateRiritu = BizNumber.valueOf(12345.1234);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(12345678901.23, BizCurrencyTypes.DOLLAR);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(12345678901.98, BizCurrencyTypes.DOLLAR);

        C_ErrorKbn result = keisanSisuuRendouNkTmttknOverNnd.exec(kykYmd, hknkkn, teikishrtkykhukaUmu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk,sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getTmttkngkkei(), BizCurrency.valueOf(24691357803.21, BizCurrencyTypes.DOLLAR), "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk(), BizCurrency.valueOf(12345678901.23, BizCurrencyTypes.DOLLAR), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getSisuurendoutmttkngk(), BizCurrency.valueOf(12345678901.98, BizCurrencyTypes.DOLLAR), "指数連動積立金額");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDate kykYmd = BizDate.valueOf("20180101");

        int hknkkn = 11;

        C_UmuKbn teikishrtkykhukaUmu = C_UmuKbn.NONE;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizDate calcKijyunYmd = BizDate.valueOf("20180401");

        BizDateYM   calcKijyunYm = BizDateYM.valueOf(2018, 04);

        BizDateYM   calcStartYm = BizDateYM.valueOf(2016, 01);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0123);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(98765, BizCurrencyTypes.YEN);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN);

        C_ErrorKbn result = keisanSisuuRendouNkTmttknOverNnd.exec(kykYmd, hknkkn, teikishrtkykhukaUmu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk,sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getTmttkngkkei(), BizCurrency.valueOf(1234669410), "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk(), BizCurrency.valueOf(101520), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567890), "指数連動積立金額");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BizDate kykYmd = BizDate.valueOf("20180101");

        int hknkkn = 11;

        C_UmuKbn teikishrtkykhukaUmu = C_UmuKbn.NONE;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizDate calcKijyunYmd = BizDate.valueOf("20180401");

        BizDateYM   calcKijyunYm = BizDateYM.valueOf(2018, 04);

        BizDateYM   calcStartYm = BizDateYM.valueOf(2018, 01);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0123);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(98765, BizCurrencyTypes.YEN);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN);

        C_ErrorKbn result = keisanSisuuRendouNkTmttknOverNnd.exec(kykYmd, hknkkn, teikishrtkykhukaUmu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk,sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getTmttkngkkei(), BizCurrency.valueOf(1234666958), "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk(), BizCurrency.valueOf(99068), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567890), "指数連動積立金額");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BizDate kykYmd = BizDate.valueOf("20180101");

        int hknkkn = 11;

        C_UmuKbn teikishrtkykhukaUmu = C_UmuKbn.NONE;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizDate calcKijyunYmd = BizDate.valueOf("20180401");

        BizDateYM   calcKijyunYm = BizDateYM.valueOf(2018, 04);

        BizDateYM   calcStartYm = BizDateYM.valueOf(2017, 04);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0123);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(98765, BizCurrencyTypes.YEN);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.YEN);

        C_ErrorKbn result = keisanSisuuRendouNkTmttknOverNnd.exec(kykYmd, hknkkn, teikishrtkykhukaUmu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk,sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getTmttkngkkei(), BizCurrency.valueOf(1234667870), "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk(), BizCurrency.valueOf(99980), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567890), "指数連動積立金額");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BizDate kykYmd = BizDate.valueOf("20180101");

        int hknkkn = 11;

        C_UmuKbn teikishrtkykhukaUmu = C_UmuKbn.NONE;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.USD;

        BizDate calcKijyunYmd = BizDate.valueOf("20180401");

        BizDateYM   calcKijyunYm = BizDateYM.valueOf(2018, 04);

        BizDateYM   calcStartYm = BizDateYM.valueOf(2016, 01);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0123);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(98765, BizCurrencyTypes.DOLLAR);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.DOLLAR);

        C_ErrorKbn result = keisanSisuuRendouNkTmttknOverNnd.exec(kykYmd, hknkkn, teikishrtkykhukaUmu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk,sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getTmttkngkkei(), BizCurrency.valueOf(1234669409.37, BizCurrencyTypes.DOLLAR), "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk(), BizCurrency.valueOf(101519.37, BizCurrencyTypes.DOLLAR), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567890, BizCurrencyTypes.DOLLAR), "指数連動積立金額");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BizDate kykYmd = BizDate.valueOf("20180101");

        int hknkkn = 11;

        C_UmuKbn teikishrtkykhukaUmu = C_UmuKbn.NONE;

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.AUD;

        BizDate calcKijyunYmd = BizDate.valueOf("20180401");

        BizDateYM   calcKijyunYm = BizDateYM.valueOf(2018, 04);

        BizDateYM   calcStartYm = BizDateYM.valueOf(2016, 01);

        BizNumber tumitateRiritu = BizNumber.valueOf(0.0123);

        BizCurrency teirituTmttKngk = BizCurrency.valueOf(98765, BizCurrencyTypes.AU_DOLLAR);

        BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(1234567890, BizCurrencyTypes.AU_DOLLAR);

        C_ErrorKbn result = keisanSisuuRendouNkTmttknOverNnd.exec(kykYmd, hknkkn, teikishrtkykhukaUmu, kyktuukasyu,
            calcKijyunYmd, calcKijyunYm, calcStartYm, tumitateRiritu, teirituTmttKngk,sisuuRendouTmttKngk);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getTmttkngkkei(), BizCurrency.valueOf(1234669409.37, BizCurrencyTypes.AU_DOLLAR), "積立金額合計");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk(), BizCurrency.valueOf(101519.37, BizCurrencyTypes.AU_DOLLAR), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkTmttknOverNnd.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567890, BizCurrencyTypes.AU_DOLLAR), "指数連動積立金額");

    }
}
