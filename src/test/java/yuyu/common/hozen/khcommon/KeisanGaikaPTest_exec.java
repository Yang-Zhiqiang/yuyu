package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
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

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForHozen;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 単月外貨入金額計算クラスのメソッド {@link KeisanGaikaP#exec(BizCurrency, C_Tuukasyu, BizDateYM, BizDate, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanGaikaPTest_exec {

    @Inject
    private KeisanGaikaP keisanGaikaP;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_単月外貨入金額計算";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanWItijiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKawaseRate());
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanGaikakanzan.class).to(KeisanGaikakanzanMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanGaikakanzanMockForHozen.caller = KeisanGaikaPTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        KeisanGaikakanzanMockForHozen.caller = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        C_ErrorKbn errorKbn = keisanGaikaP.exec(null, C_Tuukasyu.USD, BizDateYM.valueOf(201801),
            BizDate.valueOf(20180205), BizDate.valueOf(20180306));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanGaikaP.getP());
        assertNull(keisanGaikaP.getKawaseRate());
        assertNull(keisanGaikaP.getKwsrateKjYmd());

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_ErrorKbn errorKbn = keisanGaikaP.exec(BizCurrency.valueOf(14), null, BizDateYM.valueOf(201801),
            BizDate.valueOf(20180205), BizDate.valueOf(20180306));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanGaikaP.getP());
        assertNull(keisanGaikaP.getKawaseRate());
        assertNull(keisanGaikaP.getKwsrateKjYmd());

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_ErrorKbn errorKbn = keisanGaikaP.exec(BizCurrency.valueOf(14), C_Tuukasyu.USD, null,
            BizDate.valueOf(20180205), BizDate.valueOf(20180306));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanGaikaP.getP());
        assertNull(keisanGaikaP.getKawaseRate());
        assertNull(keisanGaikaP.getKwsrateKjYmd());

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        C_ErrorKbn errorKbn = keisanGaikaP.exec(BizCurrency.valueOf(14), C_Tuukasyu.USD, BizDateYM.valueOf(201801),
            null, BizDate.valueOf(20180306));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanGaikaP.getP());
        assertNull(keisanGaikaP.getKawaseRate());
        assertNull(keisanGaikaP.getKwsrateKjYmd());

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        C_ErrorKbn errorKbn = keisanGaikaP.exec(BizCurrency.valueOf(14), C_Tuukasyu.USD, BizDateYM.valueOf(201801),
            BizDate.valueOf(20180205), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanGaikaP.getP());
        assertNull(keisanGaikaP.getKawaseRate());
        assertNull(keisanGaikaP.getKwsrateKjYmd());

    }

    @Test
    @TestOrder(60)
    public void testExec_B1() {

        C_ErrorKbn errorKbn = keisanGaikaP.exec(BizCurrency.valueOf(14), C_Tuukasyu.USD, BizDateYM.valueOf(201501),
            BizDate.valueOf(20150205), BizDate.valueOf(20180306));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        assertNull(keisanGaikaP.getP());
        assertNull(keisanGaikaP.getKawaseRate());
        assertNull(keisanGaikaP.getKwsrateKjYmd());

    }

    @Test
    @TestOrder(70)
    public void testExec_B2() {

        MockObjectManager.initialize();
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanGaikaP.exec(BizCurrency.valueOf(14), C_Tuukasyu.USD, BizDateYM.valueOf(201802),
            BizDate.valueOf(20180205), BizDate.valueOf(20171220));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanGaikaP.getP(), BizCurrency.valueOf(16, BizCurrencyTypes.DOLLAR), "保険料（契約通貨）");
        exBizCalcbleEquals(keisanGaikaP.getKawaseRate(), BizNumber.valueOf(122.66), "為替レート");
        exDateEquals(keisanGaikaP.getKwsrateKjYmd(), BizDate.valueOf("20171219"), "為替レート基準日");

    }

    @Test
    @TestOrder(80)
    public void testExec_B3() {

        MockObjectManager.initialize();
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanGaikaP.exec(BizCurrency.valueOf(14), C_Tuukasyu.USD, BizDateYM.valueOf(201803),
            BizDate.valueOf(20180105), BizDate.valueOf(20180306));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanGaikaP.getP(), BizCurrency.valueOf(16, BizCurrencyTypes.DOLLAR), "保険料（契約通貨）");
        exBizCalcbleEquals(keisanGaikaP.getKawaseRate(), BizNumber.valueOf(123.12), "為替レート");
        exDateEquals(keisanGaikaP.getKwsrateKjYmd(), BizDate.valueOf("20180228"), "為替レート基準日");

    }

}