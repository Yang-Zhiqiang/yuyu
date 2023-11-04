package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 既払込保険料累計額計算クラスのメソッド {@link KeisanKihrkPRuikeigk#exec(BizCurrency, C_Tuukasyu, BizDateYM, BizDateYM, C_Hrkkaisuu, BizDate, BizDate, BizCurrency)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanKihrkPRuikeigkTest_exec {

    @Inject
    private KeisanKihrkPRuikeigk keisanKihrkPRuikeigk;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanGaikaP.class).to(KeisanGaikaPMockForHozen.class);
                bind(JtKaisukeisan.class).to(JtKaisukeisanMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanGaikaPMockForHozen.caller = KeisanKihrkPRuikeigkTest_exec.class;
        JtKaisukeisanMockForHozen.caller = KeisanKihrkPRuikeigkTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        KeisanGaikaPMockForHozen.caller = null;
        KeisanGaikaPMockForHozen.SYORIPTN = null;
        JtKaisukeisanMockForHozen.caller = null;
        JtKaisukeisanMockForHozen.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        C_ErrorKbn errorKbn = keisanKihrkPRuikeigk.exec(null, C_Tuukasyu.USD,
            BizDateYM.valueOf(201801), BizDateYM.valueOf(201802), C_Hrkkaisuu.TUKI, BizDate.valueOf(20180304),
            BizDate.valueOf(20180406), BizCurrency.valueOf(15, BizCurrencyTypes.DOLLAR));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanKihrkPRuikeigk.getKibaraiP());

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_ErrorKbn errorKbn = keisanKihrkPRuikeigk.exec(BizCurrency.valueOf(14), null,
            BizDateYM.valueOf(201801), BizDateYM.valueOf(201802), C_Hrkkaisuu.TUKI, BizDate.valueOf(20180304),
            BizDate.valueOf(20180406), BizCurrency.valueOf(15, BizCurrencyTypes.DOLLAR));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanKihrkPRuikeigk.getKibaraiP());

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_ErrorKbn errorKbn = keisanKihrkPRuikeigk.exec(BizCurrency.valueOf(14), C_Tuukasyu.USD,
            null, BizDateYM.valueOf(201802), C_Hrkkaisuu.TUKI, BizDate.valueOf(20180304),
            BizDate.valueOf(20180406), BizCurrency.valueOf(15, BizCurrencyTypes.DOLLAR));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanKihrkPRuikeigk.getKibaraiP());

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        C_ErrorKbn errorKbn = keisanKihrkPRuikeigk.exec(BizCurrency.valueOf(14), C_Tuukasyu.USD,
            BizDateYM.valueOf(201801), null, C_Hrkkaisuu.TUKI, BizDate.valueOf(20180304),
            BizDate.valueOf(20180406), BizCurrency.valueOf(15, BizCurrencyTypes.DOLLAR));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanKihrkPRuikeigk.getKibaraiP());

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        C_ErrorKbn errorKbn = keisanKihrkPRuikeigk.exec(BizCurrency.valueOf(14), C_Tuukasyu.USD,
            BizDateYM.valueOf(201801), BizDateYM.valueOf(201802), null, BizDate.valueOf(20180304),
            BizDate.valueOf(20180406), BizCurrency.valueOf(15, BizCurrencyTypes.DOLLAR));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanKihrkPRuikeigk.getKibaraiP());

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        C_ErrorKbn errorKbn = keisanKihrkPRuikeigk.exec(BizCurrency.valueOf(14), C_Tuukasyu.USD,
            BizDateYM.valueOf(201801), BizDateYM.valueOf(201802), C_Hrkkaisuu.TUKI, null,
            BizDate.valueOf(20180406), BizCurrency.valueOf(15, BizCurrencyTypes.DOLLAR));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanKihrkPRuikeigk.getKibaraiP());

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        C_ErrorKbn errorKbn = keisanKihrkPRuikeigk.exec(BizCurrency.valueOf(14), C_Tuukasyu.USD,
            BizDateYM.valueOf(201801), BizDateYM.valueOf(201802), C_Hrkkaisuu.TUKI, BizDate.valueOf(20180304),
            null, BizCurrency.valueOf(15, BizCurrencyTypes.DOLLAR));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanKihrkPRuikeigk.getKibaraiP());

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        C_ErrorKbn errorKbn = keisanKihrkPRuikeigk.exec(BizCurrency.valueOf(14), C_Tuukasyu.USD,
            BizDateYM.valueOf(201801), BizDateYM.valueOf(201802), C_Hrkkaisuu.TUKI, BizDate.valueOf(20180304),
            BizDate.valueOf(20180406), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanKihrkPRuikeigk.getKibaraiP());

    }

    @Test
    @TestOrder(90)
    public void testExec_B1() {

        C_ErrorKbn errorKbn = keisanKihrkPRuikeigk.exec(BizCurrency.valueOf(14), C_Tuukasyu.USD,
            BizDateYM.valueOf(201801), BizDateYM.valueOf(201801), C_Hrkkaisuu.TUKI, BizDate.valueOf(20180304),
            BizDate.valueOf(20180406), BizCurrency.valueOf(15, BizCurrencyTypes.DOLLAR));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanKihrkPRuikeigk.getKibaraiP());

    }

    @Test
    @TestOrder(100)
    public void testExec_B2() {

        C_ErrorKbn errorKbn = keisanKihrkPRuikeigk.exec(BizCurrency.valueOf(14), C_Tuukasyu.USD,
            BizDateYM.valueOf(201801), BizDateYM.valueOf(201712), C_Hrkkaisuu.TUKI, BizDate.valueOf(20180304),
            BizDate.valueOf(20180406), BizCurrency.valueOf(15, BizCurrencyTypes.DOLLAR));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanKihrkPRuikeigk.getKibaraiP());

    }

    @Test
    @TestOrder(110)
    public void testExec_B3() {

        MockObjectManager.initialize();
        JtKaisukeisanMockForHozen.SYORIPTN = JtKaisukeisanMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanKihrkPRuikeigk.exec(BizCurrency.valueOf(14), C_Tuukasyu.USD,
            BizDateYM.valueOf(201801), BizDateYM.valueOf(201802), C_Hrkkaisuu.TUKI, BizDate.valueOf(20180304),
            BizDate.valueOf(20180406), BizCurrency.valueOf(15, BizCurrencyTypes.DOLLAR));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanKihrkPRuikeigk.getKibaraiP(), BizCurrency.valueOf(15, BizCurrencyTypes.DOLLAR),
            "既払込保険料累計額（契約通貨）");

    }

    @Test
    @TestOrder(120)
    public void testExec_B4() {

        MockObjectManager.initialize();
        JtKaisukeisanMockForHozen.SYORIPTN = JtKaisukeisanMockForHozen.TESTPATTERN2;
        KeisanGaikaPMockForHozen.SYORIPTN = KeisanGaikaPMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanKihrkPRuikeigk.exec(BizCurrency.valueOf(14), C_Tuukasyu.USD,
            BizDateYM.valueOf(201801), BizDateYM.valueOf(201802), C_Hrkkaisuu.TUKI, BizDate.valueOf(20180304),
            BizDate.valueOf(20180406), BizCurrency.valueOf(15, BizCurrencyTypes.DOLLAR));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanKihrkPRuikeigk.getKibaraiP());

    }

    @Test
    @TestOrder(130)
    public void testExec_B5() {

        MockObjectManager.initialize();
        JtKaisukeisanMockForHozen.SYORIPTN = JtKaisukeisanMockForHozen.TESTPATTERN2;
        KeisanGaikaPMockForHozen.SYORIPTN = KeisanGaikaPMockForHozen.TESTPATTERN2;

        C_ErrorKbn errorKbn = keisanKihrkPRuikeigk.exec(BizCurrency.valueOf(14), C_Tuukasyu.USD,
            BizDateYM.valueOf(201801), BizDateYM.valueOf(201909), C_Hrkkaisuu.HALFY, BizDate.valueOf(20180304),
            BizDate.valueOf(20180406), BizCurrency.valueOf(15, BizCurrencyTypes.DOLLAR));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanKihrkPRuikeigk.getKibaraiP(), BizCurrency.valueOf(30, BizCurrencyTypes.DOLLAR),
            "既払込保険料累計額（契約通貨）");

        exNumericEquals((int) MockObjectManager.getArgument(JtKaisukeisanMockForHozen.class, "exec", 0, 0), 1, "充当年数");
        exNumericEquals((int) MockObjectManager.getArgument(JtKaisukeisanMockForHozen.class, "exec", 0, 1), 8, "充当月数");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(JtKaisukeisanMockForHozen.class, "exec", 0, 2), C_Hrkkaisuu.HALFY, "払込回数");

        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 0, 0), BizCurrency.valueOf(14), "保険料（円貨）");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 0, 1), C_Tuukasyu.USD, "契約通貨種類");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 0, 2), BizDateYM.valueOf(201801), "払込期月");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 0, 3), BizDate.valueOf(20180304), "契約日");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 0, 4), BizDate.valueOf(20180406), "初回保険料領収日");

    }

    @Test
    @TestOrder(140)
    public void testExec_B6() {

        MockObjectManager.initialize();
        JtKaisukeisanMockForHozen.SYORIPTN = JtKaisukeisanMockForHozen.TESTPATTERN3;
        KeisanGaikaPMockForHozen.SYORIPTN = KeisanGaikaPMockForHozen.TESTPATTERN2;

        C_ErrorKbn errorKbn = keisanKihrkPRuikeigk.exec(BizCurrency.valueOf(14), C_Tuukasyu.USD,
            BizDateYM.valueOf(201801), BizDateYM.valueOf(202010), C_Hrkkaisuu.TUKI, BizDate.valueOf(20180304),
            BizDate.valueOf(20180406), BizCurrency.valueOf(15, BizCurrencyTypes.DOLLAR));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanKihrkPRuikeigk.getKibaraiP(), BizCurrency.valueOf(60, BizCurrencyTypes.DOLLAR),
            "既払込保険料累計額（契約通貨）");

        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 0, 2), BizDateYM.valueOf(201801), "払込期月");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 1, 2), BizDateYM.valueOf(201802), "払込期月");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 2, 2), BizDateYM.valueOf(201803), "払込期月");

    }

}