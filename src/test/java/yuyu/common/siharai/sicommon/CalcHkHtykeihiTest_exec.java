package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.hozen.khcommon.KeisanHtyKeihi;
import yuyu.common.hozen.khcommon.KeisanHtyKeihiMockForSiharai;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保険金必要経費計算クラスのメソッド {@link CalcHkHtykeihi#exec(String, C_Tuukasyu, C_SUketoriHouhouKbn,
                                 BizCurrency, BizCurrency, BizCurrency, BizCurrency)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CalcHkHtykeihiTest_exec {

    @Inject
    private CalcHkHtykeihi calcHkHtykeihi;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保険金必要経費計算";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanHtyKeihi.class).to(KeisanHtyKeihiMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanHtyKeihiMockForSiharai.caller = CalcHkHtykeihiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        KeisanHtyKeihiMockForSiharai.caller = null;
        KeisanHtyKeihiMockForSiharai.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CalcHkHtykeihiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getKykKihon("12808111112"));
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        KeisanHtyKeihiMockForSiharai.SYORIPTN = KeisanHtyKeihiMockForSiharai.TESTPATTERN1;
        String syono = "12808111112";
        C_Tuukasyu kykTuukasyu = C_Tuukasyu.JPY;
        C_SUketoriHouhouKbn suketorihouhoukbn = C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN;
        BizCurrency hokenkg = BizCurrency.valueOf(10000, BizCurrencyTypes.YEN);
        BizCurrency yenhokenkngk = BizCurrency.valueOf(20000, BizCurrencyTypes.YEN);

        CalcHkHtykeihiBean calcHkHtykeihiBean = calcHkHtykeihi.exec(syono, kykTuukasyu, suketorihouhoukbn, hokenkg,
            yenhokenkngk, BizCurrency.valueOf(0), BizCurrency.valueOf(0), BizNumber.valueOf(0), BizCurrency.valueOf(0));

        exBizCalcbleEquals(calcHkHtykeihiBean.getHtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenhtykeihi(),
            BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getItjknhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenitjknhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "円換算一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getNkhtykeihi(),
            BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYennkhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "円換算年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getShrkykhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "支払時契約者必要経費");
        MockObjectManager.assertArgumentPassed(KeisanHtyKeihi.class, "exec", 0, "12808111112");
        MockObjectManager.assertArgumentPassed(KeisanHtyKeihi.class, "exec", 1, C_Tuukasyu.JPY);
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        KeisanHtyKeihiMockForSiharai.SYORIPTN = KeisanHtyKeihiMockForSiharai.TESTPATTERN3;
        String syono = "12808111123";
        C_Tuukasyu kykTuukasyu = C_Tuukasyu.USD;
        C_SUketoriHouhouKbn suketorihouhoukbn = C_SUketoriHouhouKbn.BLNK;
        BizCurrency hokenkg = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);
        BizCurrency yenhokenkngk = BizCurrency.valueOf(20000, BizCurrencyTypes.YEN);
        BizNumber misyuuptekikawaserate = BizNumber.valueOf(120.25);
        BizCurrency misyuup = BizCurrency.valueOf(301, BizCurrencyTypes.DOLLAR);

        CalcHkHtykeihiBean calcHkHtykeihiBean = calcHkHtykeihi.exec(syono, kykTuukasyu, suketorihouhoukbn, hokenkg,
            yenhokenkngk, BizCurrency.valueOf(0), BizCurrency.valueOf(0), misyuuptekikawaserate, misyuup);

        exBizCalcbleEquals(calcHkHtykeihiBean.getHtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenhtykeihi(),
            BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getItjknhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenitjknhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "円換算一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getNkhtykeihi(),
            BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYennkhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "円換算年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getShrkykhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "支払時契約者必要経費");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        KeisanHtyKeihiMockForSiharai.SYORIPTN = KeisanHtyKeihiMockForSiharai.TESTPATTERN2;
        String syono = "12808111123";
        C_Tuukasyu kykTuukasyu = C_Tuukasyu.JPY;
        C_SUketoriHouhouKbn suketorihouhoukbn = C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN;
        BizCurrency hokenkg = BizCurrency.valueOf(10000, BizCurrencyTypes.YEN);
        BizCurrency yenhokenkngk = BizCurrency.valueOf(20000, BizCurrencyTypes.YEN);
        BizCurrency misyuup = BizCurrency.valueOf(30000, BizCurrencyTypes.YEN);

        CalcHkHtykeihiBean calcHkHtykeihiBean = calcHkHtykeihi.exec(syono, kykTuukasyu, suketorihouhoukbn, hokenkg,
            yenhokenkngk, BizCurrency.valueOf(0), BizCurrency.valueOf(0), BizNumber.valueOf(0), misyuup);

        exBizCalcbleEquals(calcHkHtykeihiBean.getHtykeihi(), BizCurrency.valueOf(12000, BizCurrencyTypes.YEN),
            "必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenhtykeihi(), BizCurrency.valueOf(52000, BizCurrencyTypes.YEN),
            "円換算必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getItjknhtykeihi(), BizCurrency.valueOf(12000, BizCurrencyTypes.YEN),
            "一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenitjknhtykeihi(), BizCurrency.valueOf(52000, BizCurrencyTypes.YEN),
            "円換算一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getNkhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYennkhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "円換算年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getShrkykhtykeihi(), BizCurrency.valueOf(41000, BizCurrencyTypes.YEN),
            "支払時契約者必要経費");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        KeisanHtyKeihiMockForSiharai.SYORIPTN = KeisanHtyKeihiMockForSiharai.TESTPATTERN3;
        String syono = "12808111123";
        C_Tuukasyu kykTuukasyu = C_Tuukasyu.USD;
        C_SUketoriHouhouKbn suketorihouhoukbn = C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN;
        BizCurrency hokenkg = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);
        BizCurrency yenhokenkngk = BizCurrency.valueOf(20000, BizCurrencyTypes.YEN);
        BizNumber misyuuptekikawaserate = BizNumber.valueOf(120.25);
        BizCurrency misyuup = BizCurrency.valueOf(301, BizCurrencyTypes.DOLLAR);

        CalcHkHtykeihiBean calcHkHtykeihiBean = calcHkHtykeihi.exec(syono, kykTuukasyu, suketorihouhoukbn, hokenkg,
            yenhokenkngk, BizCurrency.valueOf(0), BizCurrency.valueOf(0), misyuuptekikawaserate, misyuup);

        exBizCalcbleEquals(calcHkHtykeihiBean.getHtykeihi(), BizCurrency.valueOf(12000, BizCurrencyTypes.DOLLAR),
            "必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenhtykeihi(), BizCurrency.valueOf(58196, BizCurrencyTypes.YEN),
            "円換算必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getItjknhtykeihi(), BizCurrency.valueOf(12000, BizCurrencyTypes.DOLLAR),
            "一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenitjknhtykeihi(), BizCurrency.valueOf(58196, BizCurrencyTypes.YEN),
            "円換算一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getNkhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR),
            "年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYennkhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "円換算年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getShrkykhtykeihi(), BizCurrency.valueOf(47196, BizCurrencyTypes.YEN),
            "支払時契約者必要経費");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        KeisanHtyKeihiMockForSiharai.SYORIPTN = KeisanHtyKeihiMockForSiharai.TESTPATTERN3;
        String syono = "12808111123";
        C_Tuukasyu kykTuukasyu = C_Tuukasyu.USD;
        C_SUketoriHouhouKbn suketorihouhoukbn = C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN;
        BizCurrency hokenkg = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);
        BizCurrency yenhokenkngk = BizCurrency.valueOf(20000, BizCurrencyTypes.YEN);
        BizNumber misyuuptekikawaserate = BizNumber.valueOf(120.25);
        BizCurrency misyuup = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);

        CalcHkHtykeihiBean calcHkHtykeihiBean = calcHkHtykeihi.exec(syono, kykTuukasyu, suketorihouhoukbn, hokenkg,
            yenhokenkngk, BizCurrency.valueOf(0), BizCurrency.valueOf(0), misyuuptekikawaserate, misyuup);

        exBizCalcbleEquals(calcHkHtykeihiBean.getHtykeihi(), BizCurrency.valueOf(12000, BizCurrencyTypes.DOLLAR),
            "必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenhtykeihi(), BizCurrency.valueOf(22000, BizCurrencyTypes.YEN),
            "円換算必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getItjknhtykeihi(), BizCurrency.valueOf(12000, BizCurrencyTypes.DOLLAR),
            "一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenitjknhtykeihi(), BizCurrency.valueOf(22000, BizCurrencyTypes.YEN),
            "円換算一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getNkhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR),
            "年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYennkhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "円換算年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getShrkykhtykeihi(), BizCurrency.valueOf(11000, BizCurrencyTypes.YEN),
            "支払時契約者必要経費");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        KeisanHtyKeihiMockForSiharai.SYORIPTN = KeisanHtyKeihiMockForSiharai.TESTPATTERN3;
        String syono = "12808111123";
        C_Tuukasyu kykTuukasyu = C_Tuukasyu.USD;
        C_SUketoriHouhouKbn suketorihouhoukbn = C_SUketoriHouhouKbn.ZENGAKU_NENKIN;
        BizCurrency hokenkg = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);
        BizCurrency yenhokenkngk = BizCurrency.valueOf(20000, BizCurrencyTypes.YEN);
        BizNumber misyuuptekikawaserate = BizNumber.valueOf(120.25);
        BizCurrency misyuup = BizCurrency.valueOf(301, BizCurrencyTypes.DOLLAR);

        CalcHkHtykeihiBean calcHkHtykeihiBean = calcHkHtykeihi.exec(syono, kykTuukasyu, suketorihouhoukbn, hokenkg,
            yenhokenkngk, BizCurrency.valueOf(0), BizCurrency.valueOf(0), misyuuptekikawaserate, misyuup);

        exBizCalcbleEquals(calcHkHtykeihiBean.getHtykeihi(), BizCurrency.valueOf(12000, BizCurrencyTypes.DOLLAR),
            "必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenhtykeihi(), BizCurrency.valueOf(22000, BizCurrencyTypes.YEN),
            "円換算必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getItjknhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR),
            "一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenitjknhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "円換算一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getNkhtykeihi(), BizCurrency.valueOf(12000, BizCurrencyTypes.DOLLAR),
            "年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYennkhtykeihi(), BizCurrency.valueOf(22000, BizCurrencyTypes.YEN),
            "円換算年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getShrkykhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "支払時契約者必要経費");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        KeisanHtyKeihiMockForSiharai.SYORIPTN = KeisanHtyKeihiMockForSiharai.TESTPATTERN4;
        String syono = "12808111123";
        C_Tuukasyu kykTuukasyu = C_Tuukasyu.EUR;
        C_SUketoriHouhouKbn suketorihouhoukbn = C_SUketoriHouhouKbn.ITIBU_NENKIN;
        BizCurrency hokenkg = BizCurrency.valueOf(1000000, BizCurrencyTypes.EURO);
        BizCurrency yenhokenkngk = BizCurrency.valueOf(6520000, BizCurrencyTypes.YEN);
        BizCurrency nkkknjyutougk = BizCurrency.valueOf(1000, BizCurrencyTypes.EURO);
        BizCurrency yennkkknjyutougk = BizCurrency.valueOf(6520, BizCurrencyTypes.YEN);
        BizNumber misyuuptekikawaserate = BizNumber.valueOf(120.25);
        BizCurrency misyuup = BizCurrency.valueOf(301, BizCurrencyTypes.EURO);

        CalcHkHtykeihiBean calcHkHtykeihiBean = calcHkHtykeihi.exec(syono, kykTuukasyu, suketorihouhoukbn, hokenkg,
            yenhokenkngk, nkkknjyutougk, yennkkknjyutougk, misyuuptekikawaserate, misyuup);

        exBizCalcbleEquals(calcHkHtykeihiBean.getHtykeihi(), BizCurrency.valueOf(32000, BizCurrencyTypes.EURO),
            "必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenhtykeihi(), BizCurrency.valueOf(42000, BizCurrencyTypes.YEN),
            "円換算必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getItjknhtykeihi(), BizCurrency.valueOf(31968, BizCurrencyTypes.EURO),
            "一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenitjknhtykeihi(), BizCurrency.valueOf(41958, BizCurrencyTypes.YEN),
            "円換算一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getNkhtykeihi(), BizCurrency.valueOf(32, BizCurrencyTypes.EURO),
            "年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYennkhtykeihi(), BizCurrency.valueOf(42, BizCurrencyTypes.YEN),
            "円換算年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getShrkykhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "支払時契約者必要経費");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        KeisanHtyKeihiMockForSiharai.SYORIPTN = KeisanHtyKeihiMockForSiharai.TESTPATTERN5;
        String syono = "12808111123";
        C_Tuukasyu kykTuukasyu = C_Tuukasyu.AUD;
        C_SUketoriHouhouKbn suketorihouhoukbn = C_SUketoriHouhouKbn.ITIBU_NENKIN;
        BizCurrency hokenkg = BizCurrency.valueOf(1000000, BizCurrencyTypes.AU_DOLLAR);
        BizCurrency yenhokenkngk = BizCurrency.valueOf(6520000, BizCurrencyTypes.YEN);
        BizCurrency nkkknjyutougk = BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR);
        BizCurrency yennkkknjyutougk = BizCurrency.valueOf(6520, BizCurrencyTypes.YEN);
        BizNumber misyuuptekikawaserate = BizNumber.valueOf(120.25);
        BizCurrency misyuup = BizCurrency.valueOf(301, BizCurrencyTypes.AU_DOLLAR);

        CalcHkHtykeihiBean calcHkHtykeihiBean = calcHkHtykeihi.exec(syono, kykTuukasyu, suketorihouhoukbn, hokenkg,
            yenhokenkngk, nkkknjyutougk, yennkkknjyutougk, misyuuptekikawaserate, misyuup);

        exBizCalcbleEquals(calcHkHtykeihiBean.getHtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR),
            "必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getItjknhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR),
            "一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenitjknhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "円換算一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getNkhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR),
            "年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYennkhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "円換算年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getShrkykhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "支払時契約者必要経費");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        KeisanHtyKeihiMockForSiharai.SYORIPTN = KeisanHtyKeihiMockForSiharai.TESTPATTERN6;
        String syono = "12808111123";
        C_Tuukasyu kykTuukasyu = C_Tuukasyu.JPY;
        C_SUketoriHouhouKbn suketorihouhoukbn = C_SUketoriHouhouKbn.ITIBU_NENKIN;
        BizCurrency hokenkg = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);
        BizCurrency yenhokenkngk = BizCurrency.valueOf(6520000, BizCurrencyTypes.YEN);
        BizCurrency nkkknjyutougk = BizCurrency.valueOf(1000, BizCurrencyTypes.YEN);
        BizCurrency yennkkknjyutougk = BizCurrency.valueOf(6520, BizCurrencyTypes.YEN);
        BizCurrency misyuup = BizCurrency.valueOf(3000000, BizCurrencyTypes.YEN);

        CalcHkHtykeihiBean calcHkHtykeihiBean = calcHkHtykeihi.exec(syono, kykTuukasyu, suketorihouhoukbn, hokenkg,
            yenhokenkngk, nkkknjyutougk, yennkkknjyutougk, BizNumber.valueOf(0), misyuup);

        exBizCalcbleEquals(calcHkHtykeihiBean.getHtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenhtykeihi(), BizCurrency.valueOf(42000, BizCurrencyTypes.YEN),
            "円換算必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getItjknhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenitjknhtykeihi(), BizCurrency.valueOf(41958, BizCurrencyTypes.YEN),
            "円換算一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getNkhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYennkhtykeihi(), BizCurrency.valueOf(42, BizCurrencyTypes.YEN),
            "円換算年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getShrkykhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "支払時契約者必要経費");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        KeisanHtyKeihiMockForSiharai.SYORIPTN = KeisanHtyKeihiMockForSiharai.TESTPATTERN7;
        String syono = "12808111123";
        C_Tuukasyu kykTuukasyu = C_Tuukasyu.USD;
        C_SUketoriHouhouKbn suketorihouhoukbn = C_SUketoriHouhouKbn.ITIBU_NENKIN;
        BizCurrency hokenkg = BizCurrency.valueOf(1000000, BizCurrencyTypes.DOLLAR);
        BizCurrency yenhokenkngk = BizCurrency.valueOf(6520000, BizCurrencyTypes.YEN);
        BizCurrency nkkknjyutougk = BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);
        BizCurrency yennkkknjyutougk = BizCurrency.valueOf(6520, BizCurrencyTypes.YEN);
        BizNumber misyuuptekikawaserate = BizNumber.valueOf(120.25);
        BizCurrency misyuup = BizCurrency.valueOf(301, BizCurrencyTypes.DOLLAR);

        CalcHkHtykeihiBean calcHkHtykeihiBean = calcHkHtykeihi.exec(syono, kykTuukasyu, suketorihouhoukbn, hokenkg,
            yenhokenkngk, nkkknjyutougk, yennkkknjyutougk, misyuuptekikawaserate, misyuup);

        exBizCalcbleEquals(calcHkHtykeihiBean.getHtykeihi(), BizCurrency.valueOf(32000, BizCurrencyTypes.DOLLAR),
            "必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getItjknhtykeihi(), BizCurrency.valueOf(31968, BizCurrencyTypes.DOLLAR),
            "一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenitjknhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "円換算一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getNkhtykeihi(), BizCurrency.valueOf(32, BizCurrencyTypes.DOLLAR),
            "年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYennkhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "円換算年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getShrkykhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "支払時契約者必要経費");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        KeisanHtyKeihiMockForSiharai.SYORIPTN = KeisanHtyKeihiMockForSiharai.TESTPATTERN2;
        String syono = "12808111123";
        C_Tuukasyu kykTuukasyu = C_Tuukasyu.JPY;
        C_SUketoriHouhouKbn suketorihouhoukbn = C_SUketoriHouhouKbn.ITIBU_NENKIN;
        BizCurrency hokenkg = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);
        BizCurrency yenhokenkngk = BizCurrency.valueOf(6520000, BizCurrencyTypes.YEN);
        BizCurrency nkkknjyutougk = BizCurrency.valueOf(1000, BizCurrencyTypes.YEN);
        BizCurrency yennkkknjyutougk = BizCurrency.valueOf(6520, BizCurrencyTypes.YEN);
        BizCurrency misyuup = BizCurrency.valueOf(30000, BizCurrencyTypes.YEN);

        CalcHkHtykeihiBean calcHkHtykeihiBean = calcHkHtykeihi.exec(syono, kykTuukasyu, suketorihouhoukbn, hokenkg,
            yenhokenkngk, nkkknjyutougk, yennkkknjyutougk, BizNumber.valueOf(0), misyuup);

        exBizCalcbleEquals(calcHkHtykeihiBean.getHtykeihi(), BizCurrency.valueOf(12000, BizCurrencyTypes.YEN),
            "必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenhtykeihi(), BizCurrency.valueOf(22000, BizCurrencyTypes.YEN),
            "円換算必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getItjknhtykeihi(), BizCurrency.valueOf(11988, BizCurrencyTypes.YEN),
            "一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYenitjknhtykeihi(), BizCurrency.valueOf(21978, BizCurrencyTypes.YEN),
            "円換算一時金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getNkhtykeihi(), BizCurrency.valueOf(12, BizCurrencyTypes.YEN),
            "年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getYennkhtykeihi(), BizCurrency.valueOf(22, BizCurrencyTypes.YEN),
            "円換算年金必要経費");
        exBizCalcbleEquals(calcHkHtykeihiBean.getShrkykhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
            "支払時契約者必要経費");
    }

}
