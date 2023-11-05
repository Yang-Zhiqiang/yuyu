package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 契約保全共通 指数連動年金契約時積立金計算クラスのメソッド
 *  {@link KeisanSisuuRendouNkKykTmttkn#exec(C_Tuukasyu, BizCurrency, BizNumber)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanSisuuRendouNkKykTmttknTest_exec {

    @Inject
    private KeisanSisuuRendouNkKykTmttkn keisanSisuuRendouNkKykTmttkn;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.JPY;

        BizCurrency hokenryou = BizCurrency.valueOf(1234567, BizCurrencyTypes.YEN);

        BizNumber sisuurendourate = BizNumber.valueOf(31);

        C_ErrorKbn result = keisanSisuuRendouNkKykTmttkn.exec(kyktuukasyu, hokenryou, sisuurendourate);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkKykTmttkn.getTeiritutmttkngk(), BizCurrency.valueOf(851851, BizCurrencyTypes.YEN), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkKykTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(382716, BizCurrencyTypes.YEN), "指数連動積立金額");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.USD;

        BizCurrency hokenryou = BizCurrency.valueOf(1234567.34, BizCurrencyTypes.DOLLAR);

        BizNumber sisuurendourate = BizNumber.valueOf(31);

        C_ErrorKbn result = keisanSisuuRendouNkKykTmttkn.exec(kyktuukasyu, hokenryou, sisuurendourate);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkKykTmttkn.getTeiritutmttkngk(), BizCurrency.valueOf(851851.46, BizCurrencyTypes.DOLLAR), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkKykTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(382715.88, BizCurrencyTypes.DOLLAR), "指数連動積立金額");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.AUD;

        BizCurrency hokenryou = BizCurrency.valueOf(1234567.95, BizCurrencyTypes.AU_DOLLAR);

        BizNumber sisuurendourate = BizNumber.valueOf(31);

        C_ErrorKbn result = keisanSisuuRendouNkKykTmttkn.exec(kyktuukasyu, hokenryou, sisuurendourate);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkKykTmttkn.getTeiritutmttkngk(), BizCurrency.valueOf(851851.89, BizCurrencyTypes.AU_DOLLAR), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkKykTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(382716.06, BizCurrencyTypes.AU_DOLLAR), "指数連動積立金額");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.USD;

        BizCurrency hokenryou = BizCurrency.valueOf(1234567.95, BizCurrencyTypes.DOLLAR);

        BizNumber sisuurendourate = BizNumber.valueOf(0);

        C_ErrorKbn result = keisanSisuuRendouNkKykTmttkn.exec(kyktuukasyu, hokenryou, sisuurendourate);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkKykTmttkn.getTeiritutmttkngk(), BizCurrency.valueOf(1234567.95, BizCurrencyTypes.DOLLAR), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkKykTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "指数連動積立金額");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        C_Tuukasyu kyktuukasyu = C_Tuukasyu.USD;

        BizCurrency hokenryou = BizCurrency.valueOf(1234567.95, BizCurrencyTypes.DOLLAR);

        BizNumber sisuurendourate = BizNumber.valueOf(100);

        C_ErrorKbn result = keisanSisuuRendouNkKykTmttkn.exec(kyktuukasyu, hokenryou, sisuurendourate);

        exClassificationEquals(result, C_ErrorKbn.OK, "処理結果区分");

        exBizCalcbleEquals(keisanSisuuRendouNkKykTmttkn.getTeiritutmttkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "定率積立金額");

        exBizCalcbleEquals(keisanSisuuRendouNkKykTmttkn.getSisuurendoutmttkngk(), BizCurrency.valueOf(1234567.95, BizCurrencyTypes.DOLLAR), "指数連動積立金額");

    }

}
