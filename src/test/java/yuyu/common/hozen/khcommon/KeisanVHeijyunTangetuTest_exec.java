package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
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

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 単月平準払用保険料積立金計算クラスのメソッド {@link KeisanVHeijyunTangetu#exec(
 * BizDateYM,BizDate,BizCurrency,BizCurrency,Integer,Integer,C_HrkkknsmnKbn,BizNumber,
 * BizNumber,BizNumber,BizNumber,BizCurrency,BizCurrency)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanVHeijyunTangetuTest_exec {

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(KeisanPJyuutougk.class).to(KeisanPJyuutougkMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanPJyuutougkMockForHozen.caller = KeisanVHeijyunTangetuTest_exec.class;
        KeisanPJyuutougkMockForHozen.SYORIPTN = KeisanPJyuutougkMockForHozen.TESTPATTERN1;
    }

    @AfterClass
    public static void testClear() {
        KeisanPJyuutougkMockForHozen.caller = null;
        KeisanPJyuutougkMockForHozen.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDateYM calckijyunym = BizDateYM.valueOf("202805");

        BizDate kykymd = BizDate.valueOf("20190501");

        BizCurrency pYen = BizCurrency.valueOf(10000, BizCurrencyTypes.YEN);

        BizCurrency pkyktuuka = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        int hhknnen = 63;

        int hrkkkn = 99;

        C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.SAIMANKI;

        BizNumber yoteiriritu = BizNumber.valueOf(0.004);

        BizNumber zeitaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaikaiyakuritu = BizNumber.valueOf(0.00008);

        BizCurrency calcKaisiymjitenPtumitatekin = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        BizCurrency calcKaisiymjitenKihrkPsoutougk = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        KeisanVHeijyunTangetu KeisanVHeijyunTangetu = SWAKInjector.getInstance(KeisanVHeijyunTangetu.class);
        C_ErrorKbn resultKbn = KeisanVHeijyunTangetu.exec(calckijyunym, kykymd, pYen, pkyktuuka,
            hhknnen, hrkkkn, hrkkknsmnkbn, yoteiriritu, zeitaisibouritu, soudaisibouritu,
            soudaikaiyakuritu, calcKaisiymjitenPtumitatekin, calcKaisiymjitenKihrkPsoutougk);

        exDateYMEquals(KeisanVHeijyunTangetu.getTumitateYM(), BizDateYM.valueOf("202806"), "保険料積立金計算年月");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getV(), BizCurrency.valueOf(10080.83, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getVTyouseimae(), BizCurrency.valueOf(10080.83, BizCurrencyTypes.DOLLAR), "保険料積立金（調整前）");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getKiharaikomiPSoutougk(), BizCurrency.valueOf(10100, BizCurrencyTypes.DOLLAR), "既払込保険料相当額");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getYoteiSinkeiyakuhiritu(), BizNumber.valueOf(0.15), "予定新契約費率");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getYoteiIjihirituPhirei(), BizNumber.valueOf(0.035), "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getYoteiIjihirituVhirei(), BizNumber.valueOf(0.003), "予定維持費率（Ｖ比例）");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getYoteiSyuukinhiritu(), BizNumber.valueOf(0.015), "予定集金費率");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getKougakuWaribikiritu(), BizNumber.valueOf(0), "高額割引率");

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        KeisanPJyuutougkMockForHozen.SYORIPTN = KeisanPJyuutougkMockForHozen.TESTPATTERN3;

        BizDateYM calckijyunym = BizDateYM.valueOf("202805");

        BizDate kykymd = BizDate.valueOf("20190501");

        BizCurrency pYen = BizCurrency.valueOf(10000, BizCurrencyTypes.YEN);

        BizCurrency pkyktuuka = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        int hhknnen = 63;

        int hrkkkn = 8;

        C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.NENMANKI;

        BizNumber yoteiriritu = BizNumber.valueOf(0.004);

        BizNumber zeitaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaikaiyakuritu = BizNumber.valueOf(0.00008);

        BizCurrency calcKaisiymjitenPtumitatekin = BizCurrency.valueOf(9000, BizCurrencyTypes.DOLLAR);

        BizCurrency calcKaisiymjitenKihrkPsoutougk = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        KeisanVHeijyunTangetu KeisanVHeijyunTangetu = SWAKInjector.getInstance(KeisanVHeijyunTangetu.class);
        C_ErrorKbn resultKbn = KeisanVHeijyunTangetu.exec(calckijyunym, kykymd, pYen, pkyktuuka,
            hhknnen, hrkkkn, hrkkknsmnkbn, yoteiriritu, zeitaisibouritu, soudaisibouritu,
            soudaikaiyakuritu, calcKaisiymjitenPtumitatekin, calcKaisiymjitenKihrkPsoutougk);

        exDateYMEquals(KeisanVHeijyunTangetu.getTumitateYM(), BizDateYM.valueOf("202806"), "保険料積立金計算年月");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getV(), BizCurrency.valueOf(9002.7, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getVTyouseimae(), BizCurrency.valueOf(9002.7, BizCurrencyTypes.DOLLAR), "保険料積立金（調整前）");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getKiharaikomiPSoutougk(), BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR), "既払込保険料相当額");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getYoteiSinkeiyakuhiritu(), null, "予定新契約費率");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getYoteiIjihirituPhirei(), null, "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getYoteiIjihirituVhirei(), BizNumber.valueOf(0.0003), "予定維持費率（Ｖ比例）");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getYoteiSyuukinhiritu(), null, "予定集金費率");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getKougakuWaribikiritu(), null, "高額割引率");

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        KeisanPJyuutougkMockForHozen.SYORIPTN = KeisanPJyuutougkMockForHozen.TESTPATTERN4;

        BizDateYM calckijyunym = BizDateYM.valueOf("203005");

        BizDate kykymd = BizDate.valueOf("20190501");

        BizCurrency pYen = BizCurrency.valueOf(10000, BizCurrencyTypes.YEN);

        BizCurrency pkyktuuka = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        int hhknnen = 63;

        int hrkkkn = 99;

        C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.SAIMANKI;

        BizNumber yoteiriritu = BizNumber.valueOf(0.004);

        BizNumber zeitaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaikaiyakuritu = BizNumber.valueOf(0.00008);

        BizCurrency calcKaisiymjitenPtumitatekin = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        BizCurrency calcKaisiymjitenKihrkPsoutougk = BizCurrency.valueOf(9000, BizCurrencyTypes.DOLLAR);

        KeisanVHeijyunTangetu KeisanVHeijyunTangetu = SWAKInjector.getInstance(KeisanVHeijyunTangetu.class);
        C_ErrorKbn resultKbn = KeisanVHeijyunTangetu.exec(calckijyunym, kykymd, pYen, pkyktuuka,
            hhknnen, hrkkkn, hrkkknsmnkbn, yoteiriritu, zeitaisibouritu, soudaisibouritu,
            soudaikaiyakuritu, calcKaisiymjitenPtumitatekin, calcKaisiymjitenKihrkPsoutougk);

        exDateYMEquals(KeisanVHeijyunTangetu.getTumitateYM(), BizDateYM.valueOf("203006"), "保険料積立金計算年月");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getV(), BizCurrency.valueOf(10095.56, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getVTyouseimae(), BizCurrency.valueOf(10095.49, BizCurrencyTypes.DOLLAR), "保険料積立金（調整前）");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getKiharaikomiPSoutougk(), BizCurrency.valueOf(9100, BizCurrencyTypes.DOLLAR), "既払込保険料相当額");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getYoteiSinkeiyakuhiritu(), BizNumber.valueOf(0), "予定新契約費率");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getYoteiIjihirituPhirei(), BizNumber.valueOf(0.035), "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getYoteiIjihirituVhirei(), BizNumber.valueOf(0.0035), "予定維持費率（Ｖ比例）");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getYoteiSyuukinhiritu(), BizNumber.valueOf(0.015), "予定集金費率");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getKougakuWaribikiritu(), BizNumber.valueOf(0), "高額割引率");

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        KeisanPJyuutougkMockForHozen.SYORIPTN = KeisanPJyuutougkMockForHozen.TESTPATTERN3;

        BizDateYM calckijyunym = BizDateYM.valueOf("202805");

        BizDate kykymd = BizDate.valueOf("20190501");

        BizCurrency pYen = BizCurrency.valueOf(10000, BizCurrencyTypes.YEN);

        BizCurrency pkyktuuka = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        int hhknnen = 63;

        int hrkkkn = 8;

        C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.NENMANKI;

        BizNumber yoteiriritu = BizNumber.valueOf(0.004);

        BizNumber zeitaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaikaiyakuritu = BizNumber.valueOf(0.00008);

        BizCurrency calcKaisiymjitenPtumitatekin = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        BizCurrency calcKaisiymjitenKihrkPsoutougk = BizCurrency.valueOf(9000, BizCurrencyTypes.DOLLAR);

        KeisanVHeijyunTangetu KeisanVHeijyunTangetu = SWAKInjector.getInstance(KeisanVHeijyunTangetu.class);
        C_ErrorKbn resultKbn = KeisanVHeijyunTangetu.exec(calckijyunym, kykymd, pYen, pkyktuuka,
            hhknnen, hrkkkn, hrkkknsmnkbn, yoteiriritu, zeitaisibouritu, soudaisibouritu,
            soudaikaiyakuritu, calcKaisiymjitenPtumitatekin, calcKaisiymjitenKihrkPsoutougk);

        exDateYMEquals(KeisanVHeijyunTangetu.getTumitateYM(), BizDateYM.valueOf("202806"), "保険料積立金計算年月");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getV(), BizCurrency.valueOf(10003.07, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getVTyouseimae(), BizCurrency.valueOf(10003.14, BizCurrencyTypes.DOLLAR), "保険料積立金（調整前）");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getKiharaikomiPSoutougk(), BizCurrency.valueOf(9000, BizCurrencyTypes.DOLLAR), "既払込保険料相当額");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getYoteiSinkeiyakuhiritu(), null, "予定新契約費率");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getYoteiIjihirituPhirei(), null, "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getYoteiIjihirituVhirei(), BizNumber.valueOf(0.0003), "予定維持費率（Ｖ比例）");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getYoteiSyuukinhiritu(), null, "予定集金費率");
        exBizCalcbleEquals(KeisanVHeijyunTangetu.getKougakuWaribikiritu(), null, "高額割引率");

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_B1() {

        BizDateYM calckijyunym = null;

        BizDate kykymd = BizDate.valueOf("20190501");

        BizCurrency pYen = BizCurrency.valueOf(10000, BizCurrencyTypes.YEN);

        BizCurrency pkyktuuka = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        int hhknnen = 63;

        int hrkkkn = 99;

        C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.SAIMANKI;

        BizNumber yoteiriritu = BizNumber.valueOf(0.004);

        BizNumber zeitaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaikaiyakuritu = BizNumber.valueOf(0.00008);

        BizCurrency calcKaisiymjitenPtumitatekin = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        BizCurrency calcKaisiymjitenKihrkPsoutougk = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        KeisanVHeijyunTangetu KeisanVHeijyunTangetu = SWAKInjector.getInstance(KeisanVHeijyunTangetu.class);
        C_ErrorKbn resultKbn = KeisanVHeijyunTangetu.exec(calckijyunym, kykymd, pYen, pkyktuuka,
            hhknnen, hrkkkn, hrkkknsmnkbn, yoteiriritu, zeitaisibouritu, soudaisibouritu,
            soudaikaiyakuritu, calcKaisiymjitenPtumitatekin, calcKaisiymjitenKihrkPsoutougk);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_B2() {

        BizDateYM calckijyunym = BizDateYM.valueOf("202805");

        BizDate kykymd = null;

        BizCurrency pYen = BizCurrency.valueOf(10000, BizCurrencyTypes.YEN);

        BizCurrency pkyktuuka = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        int hhknnen = 63;

        int hrkkkn = 99;

        C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.SAIMANKI;

        BizNumber yoteiriritu = BizNumber.valueOf(0.004);

        BizNumber zeitaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaikaiyakuritu = BizNumber.valueOf(0.00008);

        BizCurrency calcKaisiymjitenPtumitatekin = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        BizCurrency calcKaisiymjitenKihrkPsoutougk = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        KeisanVHeijyunTangetu KeisanVHeijyunTangetu = SWAKInjector.getInstance(KeisanVHeijyunTangetu.class);
        C_ErrorKbn resultKbn = KeisanVHeijyunTangetu.exec(calckijyunym, kykymd, pYen, pkyktuuka,
            hhknnen, hrkkkn, hrkkknsmnkbn, yoteiriritu, zeitaisibouritu, soudaisibouritu,
            soudaikaiyakuritu, calcKaisiymjitenPtumitatekin, calcKaisiymjitenKihrkPsoutougk);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_B3() {

        BizDateYM calckijyunym = BizDateYM.valueOf("202805");

        BizDate kykymd = BizDate.valueOf("20190501");

        BizCurrency pYen = null;

        BizCurrency pkyktuuka = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        int hhknnen = 63;

        int hrkkkn = 99;

        C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.SAIMANKI;

        BizNumber yoteiriritu = BizNumber.valueOf(0.004);

        BizNumber zeitaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaikaiyakuritu = BizNumber.valueOf(0.00008);

        BizCurrency calcKaisiymjitenPtumitatekin = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        BizCurrency calcKaisiymjitenKihrkPsoutougk = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        KeisanVHeijyunTangetu KeisanVHeijyunTangetu = SWAKInjector.getInstance(KeisanVHeijyunTangetu.class);
        C_ErrorKbn resultKbn = KeisanVHeijyunTangetu.exec(calckijyunym, kykymd, pYen, pkyktuuka,
            hhknnen, hrkkkn, hrkkknsmnkbn, yoteiriritu, zeitaisibouritu, soudaisibouritu,
            soudaikaiyakuritu, calcKaisiymjitenPtumitatekin, calcKaisiymjitenKihrkPsoutougk);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_B4() {

        BizDateYM calckijyunym = BizDateYM.valueOf("202805");

        BizDate kykymd = BizDate.valueOf("20190501");

        BizCurrency pYen = BizCurrency.valueOf(10000, BizCurrencyTypes.YEN);

        BizCurrency pkyktuuka = null;

        int hhknnen = 63;

        int hrkkkn = 99;

        C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.SAIMANKI;

        BizNumber yoteiriritu = BizNumber.valueOf(0.004);

        BizNumber zeitaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaikaiyakuritu = BizNumber.valueOf(0.00008);

        BizCurrency calcKaisiymjitenPtumitatekin = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        BizCurrency calcKaisiymjitenKihrkPsoutougk = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        KeisanVHeijyunTangetu KeisanVHeijyunTangetu = SWAKInjector.getInstance(KeisanVHeijyunTangetu.class);
        C_ErrorKbn resultKbn = KeisanVHeijyunTangetu.exec(calckijyunym, kykymd, pYen, pkyktuuka,
            hhknnen, hrkkkn, hrkkknsmnkbn, yoteiriritu, zeitaisibouritu, soudaisibouritu,
            soudaikaiyakuritu, calcKaisiymjitenPtumitatekin, calcKaisiymjitenKihrkPsoutougk);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_B5() {

        BizDateYM calckijyunym = BizDateYM.valueOf("202805");

        BizDate kykymd = BizDate.valueOf("20190501");

        BizCurrency pYen = BizCurrency.valueOf(10000, BizCurrencyTypes.YEN);

        BizCurrency pkyktuuka = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        int hhknnen = 63;

        int hrkkkn = 99;

        C_HrkkknsmnKbn hrkkknsmnkbn = null;

        BizNumber yoteiriritu = BizNumber.valueOf(0.004);

        BizNumber zeitaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaikaiyakuritu = BizNumber.valueOf(0.00008);

        BizCurrency calcKaisiymjitenPtumitatekin = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        BizCurrency calcKaisiymjitenKihrkPsoutougk = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        KeisanVHeijyunTangetu KeisanVHeijyunTangetu = SWAKInjector.getInstance(KeisanVHeijyunTangetu.class);
        C_ErrorKbn resultKbn = KeisanVHeijyunTangetu.exec(calckijyunym, kykymd, pYen, pkyktuuka,
            hhknnen, hrkkkn, hrkkknsmnkbn, yoteiriritu, zeitaisibouritu, soudaisibouritu,
            soudaikaiyakuritu, calcKaisiymjitenPtumitatekin, calcKaisiymjitenKihrkPsoutougk);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_B6() {

        BizDateYM calckijyunym = BizDateYM.valueOf("202805");

        BizDate kykymd = BizDate.valueOf("20190501");

        BizCurrency pYen = BizCurrency.valueOf(10000, BizCurrencyTypes.YEN);

        BizCurrency pkyktuuka = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        int hhknnen = 63;

        int hrkkkn = 99;

        C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.SAIMANKI;

        BizNumber yoteiriritu = null;

        BizNumber zeitaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaikaiyakuritu = BizNumber.valueOf(0.00008);

        BizCurrency calcKaisiymjitenPtumitatekin = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        BizCurrency calcKaisiymjitenKihrkPsoutougk = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        KeisanVHeijyunTangetu KeisanVHeijyunTangetu = SWAKInjector.getInstance(KeisanVHeijyunTangetu.class);
        C_ErrorKbn resultKbn = KeisanVHeijyunTangetu.exec(calckijyunym, kykymd, pYen, pkyktuuka,
            hhknnen, hrkkkn, hrkkknsmnkbn, yoteiriritu, zeitaisibouritu, soudaisibouritu,
            soudaikaiyakuritu, calcKaisiymjitenPtumitatekin, calcKaisiymjitenKihrkPsoutougk);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_B7() {

        BizDateYM calckijyunym = BizDateYM.valueOf("202805");

        BizDate kykymd = BizDate.valueOf("20190501");

        BizCurrency pYen = BizCurrency.valueOf(10000, BizCurrencyTypes.YEN);

        BizCurrency pkyktuuka = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        int hhknnen = 63;

        int hrkkkn = 99;

        C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.SAIMANKI;

        BizNumber yoteiriritu = BizNumber.valueOf(0.004);

        BizNumber zeitaisibouritu = null;

        BizNumber soudaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaikaiyakuritu = BizNumber.valueOf(0.00008);

        BizCurrency calcKaisiymjitenPtumitatekin = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        BizCurrency calcKaisiymjitenKihrkPsoutougk = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        KeisanVHeijyunTangetu KeisanVHeijyunTangetu = SWAKInjector.getInstance(KeisanVHeijyunTangetu.class);
        C_ErrorKbn resultKbn = KeisanVHeijyunTangetu.exec(calckijyunym, kykymd, pYen, pkyktuuka,
            hhknnen, hrkkkn, hrkkknsmnkbn, yoteiriritu, zeitaisibouritu, soudaisibouritu,
            soudaikaiyakuritu, calcKaisiymjitenPtumitatekin, calcKaisiymjitenKihrkPsoutougk);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_B8() {

        BizDateYM calckijyunym = BizDateYM.valueOf("202805");

        BizDate kykymd = BizDate.valueOf("20190501");

        BizCurrency pYen = BizCurrency.valueOf(10000, BizCurrencyTypes.YEN);

        BizCurrency pkyktuuka = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        int hhknnen = 63;

        int hrkkkn = 99;

        C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.SAIMANKI;

        BizNumber yoteiriritu = BizNumber.valueOf(0.004);

        BizNumber zeitaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaisibouritu = null;

        BizNumber soudaikaiyakuritu = BizNumber.valueOf(0.00008);

        BizCurrency calcKaisiymjitenPtumitatekin = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        BizCurrency calcKaisiymjitenKihrkPsoutougk = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        KeisanVHeijyunTangetu KeisanVHeijyunTangetu = SWAKInjector.getInstance(KeisanVHeijyunTangetu.class);
        C_ErrorKbn resultKbn = KeisanVHeijyunTangetu.exec(calckijyunym, kykymd, pYen, pkyktuuka,
            hhknnen, hrkkkn, hrkkknsmnkbn, yoteiriritu, zeitaisibouritu, soudaisibouritu,
            soudaikaiyakuritu, calcKaisiymjitenPtumitatekin, calcKaisiymjitenKihrkPsoutougk);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(130)
    public void testExec_B9() {

        BizDateYM calckijyunym = BizDateYM.valueOf("202805");

        BizDate kykymd = BizDate.valueOf("20190501");

        BizCurrency pYen = BizCurrency.valueOf(10000, BizCurrencyTypes.YEN);

        BizCurrency pkyktuuka = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        int hhknnen = 63;

        int hrkkkn = 99;

        C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.SAIMANKI;

        BizNumber yoteiriritu = BizNumber.valueOf(0.004);

        BizNumber zeitaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaikaiyakuritu = null;

        BizCurrency calcKaisiymjitenPtumitatekin = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        BizCurrency calcKaisiymjitenKihrkPsoutougk = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        KeisanVHeijyunTangetu KeisanVHeijyunTangetu = SWAKInjector.getInstance(KeisanVHeijyunTangetu.class);
        C_ErrorKbn resultKbn = KeisanVHeijyunTangetu.exec(calckijyunym, kykymd, pYen, pkyktuuka,
            hhknnen, hrkkkn, hrkkknsmnkbn, yoteiriritu, zeitaisibouritu, soudaisibouritu,
            soudaikaiyakuritu, calcKaisiymjitenPtumitatekin, calcKaisiymjitenKihrkPsoutougk);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(140)
    public void testExec_C1() {

        KeisanPJyuutougkMockForHozen.SYORIPTN = KeisanPJyuutougkMockForHozen.TESTPATTERN2;

        BizDateYM calckijyunym = BizDateYM.valueOf("202805");

        BizDate kykymd = BizDate.valueOf("20190501");

        BizCurrency pYen = BizCurrency.valueOf(10000, BizCurrencyTypes.YEN);

        BizCurrency pkyktuuka = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        int hhknnen = 63;

        int hrkkkn = 99;

        C_HrkkknsmnKbn hrkkknsmnkbn = C_HrkkknsmnKbn.SAIMANKI;

        BizNumber yoteiriritu = BizNumber.valueOf(0.004);

        BizNumber zeitaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaisibouritu = BizNumber.valueOf(0.00007);

        BizNumber soudaikaiyakuritu = BizNumber.valueOf(0.00008);

        BizCurrency calcKaisiymjitenPtumitatekin = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        BizCurrency calcKaisiymjitenKihrkPsoutougk = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);

        KeisanVHeijyunTangetu KeisanVHeijyunTangetu = SWAKInjector.getInstance(KeisanVHeijyunTangetu.class);
        C_ErrorKbn resultKbn = KeisanVHeijyunTangetu.exec(calckijyunym, kykymd, pYen, pkyktuuka,
            hhknnen, hrkkkn, hrkkknsmnkbn, yoteiriritu, zeitaisibouritu, soudaisibouritu,
            soudaikaiyakuritu, calcKaisiymjitenPtumitatekin, calcKaisiymjitenKihrkPsoutougk);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }
}
